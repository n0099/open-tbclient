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
import com.baidu.tieba.au8;
import com.baidu.tieba.c05;
import com.baidu.tieba.dl9;
import com.baidu.tieba.ds8;
import com.baidu.tieba.e05;
import com.baidu.tieba.n05;
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
import com.baidu.tieba.px8;
import com.baidu.tieba.tbadkCore.data.AgreeData;
import com.baidu.tieba.tbadkCore.util.AntiHelper;
import com.baidu.tieba.tbadkCore.writeModel.PostWriteCallBackData;
import com.baidu.tieba.tw8;
import com.baidu.tieba.view.NavigationBarCoverTip;
import com.baidu.tieba.view.SortSwitchButton;
import com.baidu.tieba.view.WaterRippleView;
import com.baidu.tieba.wx5;
import com.baidu.tieba.xv8;
import com.baidu.tieba.y45;
import com.baidu.tieba.zx5;
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
/* loaded from: classes7.dex */
public class xw8 {
    public static /* synthetic */ Interceptable $ic;
    public static final int a2;
    public static int b2;
    public static int c2;
    public static int d2;
    public static int e2;
    public static int f2;
    public static int g2;
    public static final int h2;
    public static int i2;
    public static dl9.f j2;
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
    public kv8 E;
    public View E0;
    public int E1;
    public c05 F;
    public l09 F0;
    public boolean F1;
    public e05 G;
    public TextView G0;
    public boolean G1;
    public View H;
    public TextView H0;
    public k09 H1;
    public EditText I;
    public boolean I0;
    public MaskView I1;
    public m09 J;
    public int J0;
    public final PbFallingView J1;
    public PbListView K;
    public s45 K0;
    public RightFloatLayerView K1;
    public h09 L;
    public boolean L0;
    public final FrameLayout L1;
    public View M;
    public zs8 M0;
    public CustomMessageListener M1;
    public View N;
    public sl9 N0;
    public View.OnClickListener N1;
    public View O;
    public int O0;
    public CustomMessageListener O1;
    public View.OnClickListener P;
    public int P0;
    public Handler P1;
    public SortSwitchButton.f Q;
    public boolean Q0;
    public Runnable Q1;
    public TbRichTextView.a0 R;
    public ViewStub R0;
    public CustomMessageListener R1;
    public NoNetworkView.b S;
    public PbInterviewStatusView S0;
    public PbFragment.g3 S1;
    public l05 T;
    public TextView T0;
    public boolean T1;
    public View.OnClickListener U;
    public View U0;
    public View.OnClickListener U1;
    public c05 V;
    public View V0;
    public String V1;
    public Dialog W;
    public View W0;
    public y45.g W1;
    public Dialog X;
    public PbReplyTitleViewHolder X0;
    public View.OnClickListener X1;
    public View Y;
    public View Y0;
    public final List<TbImageView> Y1;
    public LinearLayout Z;
    public int Z0;
    public boolean Z1;
    public final ViewTreeObserver.OnGlobalLayoutListener a;
    public CompoundButton.OnCheckedChangeListener a0;
    public boolean a1;
    public int b;
    public TextView b0;
    public z0 b1;
    public PbFragment c;
    public TextView c0;
    public int c1;
    public RelativeLayout d;
    public String d0;
    public int d1;
    public View e;
    public l05 e0;
    public Runnable e1;
    public int f;
    public l05 f0;
    public PbFakeFloorModel f1;
    public final Handler g;
    public g05 g0;
    public uv8 g1;
    public final zy8 h;
    public boolean h0;
    public boolean h1;
    public yy8 i;
    public boolean i0;
    public int i1;
    public ViewStub j;
    public String j0;
    public boolean j1;
    public ViewStub k;
    public String k0;
    public boolean k1;
    public PbLandscapeListView l;
    public cu8 l0;
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
    public yv8 p;
    public View p0;
    public TextView p1;
    public xv8 q;
    public View q0;
    public List<String> q1;
    public uw8 r;
    public EjectionAnimationView r0;
    public yx8 r1;
    public tw8 s;
    public Button s0;
    public av8 s1;
    public qx8 t;
    public View t0;
    public PbLandscapeListView.c t1;
    public sx8 u;
    public View u0;
    public boolean u1;
    public ux8 v;
    public LinearLayout v0;
    public boolean v1;
    public rx8 w;
    public ImageView w0;
    public iw8 w1;
    public tx8 x;
    public TextView x0;
    public NavigationBarCoverTip x1;
    public px8 y;
    public WaterRippleView y0;
    public wx5 y1;
    public PbContentCollectionController z;
    public ImageView z0;
    public zx5 z1;

    public boolean N1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048629, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    public boolean e2(int i3) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048698, this, i3)) == null) {
            return false;
        }
        return invokeI.booleanValue;
    }

    public int j1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048722, this)) == null) ? R.id.obfuscated_res_0x7f091db6 : invokeV.intValue;
    }

    /* loaded from: classes7.dex */
    public class b implements AgreeView.i {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ xw8 a;

        /* loaded from: classes7.dex */
        public class a implements mc5 {
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

            @Override // com.baidu.tieba.mc5
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

        public b(xw8 xw8Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {xw8Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = xw8Var;
        }

        @Override // com.baidu.tbadk.core.view.AgreeView.i
        public void onLongPress() {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeV(1048576, this) != null) {
                return;
            }
            this.a.v3();
            oc5.g().c(new a(this));
        }

        @Override // com.baidu.tbadk.core.view.AgreeView.i
        public void onRelease() {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) != null) {
                return;
            }
            this.a.I2();
            this.a.r0.l();
        }
    }

    /* loaded from: classes7.dex */
    public class i implements xv8.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ xw8 a;

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
                if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && this.a.a.p != null) {
                    this.a.a.p.p();
                }
            }
        }

        public i(xw8 xw8Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {xw8Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = xw8Var;
        }

        @Override // com.baidu.tieba.xv8.a
        public void a() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && this.a.l != null) {
                this.a.l.post(new a(this));
            }
        }
    }

    /* loaded from: classes7.dex */
    public class j implements tw8.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ xw8 a;

        /* loaded from: classes7.dex */
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
                if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && this.a.a.r != null) {
                    this.a.a.r.r();
                }
            }
        }

        public j(xw8 xw8Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {xw8Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = xw8Var;
        }

        @Override // com.baidu.tieba.tw8.a
        public void a() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && !this.a.c.t6() && this.a.l != null) {
                this.a.l.post(new a(this));
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
        public final /* synthetic */ xw8 g;

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
                if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && this.a.g.Y0 != null && this.a.g.Y0.getLayoutParams() != null) {
                    ViewGroup.LayoutParams layoutParams = this.a.g.Y0.getLayoutParams();
                    layoutParams.height = this.a.g.d1;
                    this.a.g.Y0.setLayoutParams(layoutParams);
                }
            }
        }

        public l(xw8 xw8Var, int i, PbReplyTitleViewHolder pbReplyTitleViewHolder, boolean z, int i2, int i3, int i4) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {xw8Var, Integer.valueOf(i), pbReplyTitleViewHolder, Boolean.valueOf(z), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i5 = newInitContext.flag;
                if ((i5 & 1) != 0) {
                    int i6 = i5 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.g = xw8Var;
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
                    if (this.g.Y0 == null || (layoutParams = this.g.Y0.getLayoutParams()) == null) {
                        return;
                    }
                    if (i4 != 0 && i4 <= this.g.d.getMeasuredHeight() && i1 < this.g.d.getMeasuredHeight()) {
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
                    jg.a().post(new a(this));
                }
                if (this.g.l != null) {
                    this.g.l.setOnLayoutListener(null);
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class o0 implements DialogInterface.OnCancelListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ xw8 a;

        /* loaded from: classes7.dex */
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

        public o0(xw8 xw8Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {xw8Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = xw8Var;
        }

        @Override // android.content.DialogInterface.OnCancelListener
        public void onCancel(DialogInterface dialogInterface) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, dialogInterface) == null) {
                if (this.a.e1 == null) {
                    this.a.e1 = new a(this);
                }
                jg.a().postDelayed(this.a.e1, 150L);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class a implements wt8 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ xw8 a;

        @Override // com.baidu.tieba.wt8
        public /* synthetic */ void onStart() {
            vt8.a(this);
        }

        public a(xw8 xw8Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {xw8Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = xw8Var;
        }

        @Override // com.baidu.tieba.wt8
        public void onStop() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                this.a.r0.setVisibility(8);
                FirstPraiseToast.getInstance().show();
            }
        }
    }

    /* loaded from: classes7.dex */
    public class a0 implements wx5.h {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ c05 a;
        public final /* synthetic */ xw8 b;

        public a0(xw8 xw8Var, c05 c05Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {xw8Var, c05Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = xw8Var;
            this.a = c05Var;
        }

        @Override // com.baidu.tieba.wx5.h
        public void a(JSONArray jSONArray) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, jSONArray) == null) {
                this.b.c.j5(this.a, jSONArray);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class b0 implements zx5.i {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ SparseArray a;
        public final /* synthetic */ xw8 b;

        public b0(xw8 xw8Var, SparseArray sparseArray) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {xw8Var, sparseArray};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = xw8Var;
            this.a = sparseArray;
        }

        @Override // com.baidu.tieba.zx5.i
        public void a(JSONArray jSONArray) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, jSONArray) == null) {
                this.b.c.i5(this.a, jSONArray);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class c implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ xw8 a;

        public c(xw8 xw8Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {xw8Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = xw8Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, view2) == null) && this.a.A0 != null && this.a.A0.getData() != null) {
                xw8 xw8Var = this.a;
                xw8Var.C2(xw8Var.A0.getData(), this.a.A0.getData().agreeNum);
                if (!this.a.A0.J()) {
                    xw8 xw8Var2 = this.a;
                    xw8Var2.v2(xw8Var2.A0);
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class c0 implements CompoundButton.OnCheckedChangeListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ xw8 a;

        public c0(xw8 xw8Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {xw8Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = xw8Var;
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

    /* loaded from: classes7.dex */
    public class d implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ xw8 a;

        public d(xw8 xw8Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {xw8Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = xw8Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                if (this.a.E0.getVisibility() == 0) {
                    if (this.a.c != null && this.a.c.E1()) {
                        return;
                    }
                    p45.m().w("pb_share_red_dot_shown", true);
                    this.a.E0.setVisibility(8);
                }
                this.a.P.onClick(view2);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class d0 implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ xw8 a;

        public d0(xw8 xw8Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {xw8Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = xw8Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, view2) == null) && (this.a.X instanceof Dialog)) {
                lg.b(this.a.X, this.a.c.getPageContext());
            }
        }
    }

    /* loaded from: classes7.dex */
    public class e implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ xw8 a;

        public e(xw8 xw8Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {xw8Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = xw8Var;
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
                    this.a.c.Z4(sparseArray);
                    return;
                }
                this.a.u2(view2);
            } else if (z2) {
                sparseArray.put(R.id.tag_from, 0);
                sparseArray.put(R.id.tag_check_mute_from, 1);
                this.a.c.Z4(sparseArray);
            } else if (z3) {
                this.a.p2(((Integer) sparseArray.get(R.id.tag_del_post_type)).intValue(), (String) sparseArray.get(R.id.tag_del_post_id), ((Integer) sparseArray.get(R.id.tag_manage_user_identity)).intValue(), ((Boolean) sparseArray.get(R.id.tag_del_post_is_self)).booleanValue());
            }
        }
    }

    /* loaded from: classes7.dex */
    public class e0 implements n05.f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ e05.c a;
        public final /* synthetic */ xw8 b;

        public e0(xw8 xw8Var, e05.c cVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {xw8Var, cVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = xw8Var;
            this.a = cVar;
        }

        @Override // com.baidu.tieba.n05.f
        public void M0(n05 n05Var, int i, View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIL(1048576, this, n05Var, i, view2) == null) {
                this.b.f0.dismiss();
                this.a.a(null, i, view2);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class f implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ xw8 a;

        public f(xw8 xw8Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {xw8Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = xw8Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                this.a.L2();
            }
        }
    }

    /* loaded from: classes7.dex */
    public class f0 implements n05.f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ e05.c a;
        public final /* synthetic */ xw8 b;

        public f0(xw8 xw8Var, e05.c cVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {xw8Var, cVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = xw8Var;
            this.a = cVar;
        }

        @Override // com.baidu.tieba.n05.f
        public void M0(n05 n05Var, int i, View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIL(1048576, this, n05Var, i, view2) == null) {
                this.b.f0.dismiss();
                this.a.a(null, i, view2);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class g implements PbFakeFloorModel.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ xw8 a;

        public g(xw8 xw8Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {xw8Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = xw8Var;
        }

        @Override // com.baidu.tieba.pb.pb.main.view.PbFakeFloorModel.b
        public void a(sl9 sl9Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, sl9Var) == null) {
                this.a.f1.h0(sl9Var);
                this.a.E.a0();
                this.a.g1.g();
                this.a.n0.s();
                this.a.A3(false);
            }
        }
    }

    /* loaded from: classes7.dex */
    public static class g0 implements dl9.f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        @Override // com.baidu.tieba.dl9.f
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
        public final /* synthetic */ xw8 a;

        public h(xw8 xw8Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {xw8Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = xw8Var;
        }

        @Override // com.baidu.tieba.pb.view.PbFallingView.r
        public void onAnimationEnd() {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeV(1048576, this) != null) {
                return;
            }
            this.a.U3();
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

    /* loaded from: classes7.dex */
    public class h0 implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ xw8 a;

        public h0(xw8 xw8Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {xw8Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = xw8Var;
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
                if (this.a.c.Q() != null) {
                    this.a.c.Q().c.b.onClick(view2);
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class i0 implements px8.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ xw8 a;

        public i0(xw8 xw8Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {xw8Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = xw8Var;
        }

        @Override // com.baidu.tieba.px8.a
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

    /* loaded from: classes7.dex */
    public class j0 implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ xw8 a;

        public j0(xw8 xw8Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {xw8Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = xw8Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            xw8 xw8Var;
            zy8 zy8Var;
            LinearLayout linearLayout;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && this.a.E != null && (zy8Var = (xw8Var = this.a).h) != null && zy8Var.i != null && xw8Var.M0 != null && this.a.M0.M() != null && !this.a.M0.M().isVideoThreadType() && !this.a.S1() && this.a.M0.k() != null && !hi.isEmpty(this.a.M0.k().getName())) {
                if ((this.a.E.I() == null || !this.a.E.I().isShown()) && (linearLayout = this.a.h.i) != null) {
                    linearLayout.setVisibility(0);
                    this.a.h.g();
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class k extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ xw8 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public k(xw8 xw8Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {xw8Var, Integer.valueOf(i)};
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
            this.a = xw8Var;
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

    /* loaded from: classes7.dex */
    public class k0 implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;
        public final /* synthetic */ xw8 b;

        public k0(xw8 xw8Var, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {xw8Var, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = xw8Var;
            this.a = str;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                if (ii.F()) {
                    UrlManager.getInstance().dealOneLink(this.b.c.getPageContext(), new String[]{this.a});
                    this.b.c.finish();
                    return;
                }
                this.b.c.showToast(R.string.obfuscated_res_0x7f0f0d1b);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class l0 implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ Parcelable a;
        public final /* synthetic */ ArrayList b;
        public final /* synthetic */ zs8 c;
        public final /* synthetic */ xw8 d;

        public l0(xw8 xw8Var, Parcelable parcelable, ArrayList arrayList, zs8 zs8Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {xw8Var, parcelable, arrayList, zs8Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.d = xw8Var;
            this.a = parcelable;
            this.b = arrayList;
            this.c = zs8Var;
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
                    this.d.K.F(TbadkApplication.getInst().getString(R.string.obfuscated_res_0x7f0f0ebc));
                    this.d.K.A();
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class m implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ xw8 a;

        public m(xw8 xw8Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {xw8Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = xw8Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                if (this.a.E0.getVisibility() == 0) {
                    p45.m().w("pb_share_red_dot_shown", true);
                    this.a.E0.setVisibility(8);
                }
                this.a.P.onClick(this.a.C0);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class m0 implements PbLandscapeListView.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ xw8 a;

        public m0(xw8 xw8Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {xw8Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = xw8Var;
        }

        @Override // com.baidu.tieba.pb.pb.main.PbLandscapeListView.c
        public void a(int i, int i2, float f, float f2, float f3, float f4) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Integer.valueOf(i), Integer.valueOf(i2), Float.valueOf(f), Float.valueOf(f2), Float.valueOf(f3), Float.valueOf(f4)}) == null) && this.a.c != null && this.a.c.isAdded()) {
                if (i < 0 && f > this.a.m1) {
                    this.a.t0();
                    this.a.f2();
                }
                this.a.B0();
            }
        }
    }

    /* loaded from: classes7.dex */
    public class n implements ds8.d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ xw8 a;

        public n(xw8 xw8Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {xw8Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = xw8Var;
        }

        @Override // com.baidu.tieba.ds8.d
        public void onFinish() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.A0.W();
            }
        }
    }

    /* loaded from: classes7.dex */
    public class n0 implements c05.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ xw8 a;

        public n0(xw8 xw8Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {xw8Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = xw8Var;
        }

        @Override // com.baidu.tieba.c05.e
        public void onClick(c05 c05Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, c05Var) == null) {
                this.a.t0();
                c05Var.dismiss();
            }
        }
    }

    /* loaded from: classes7.dex */
    public class o extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ xw8 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public o(xw8 xw8Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {xw8Var, Integer.valueOf(i)};
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
            this.a = xw8Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && customResponsedMessage.getCmd() == 2005016 && this.a.E != null) {
                this.a.E.a0();
            }
        }
    }

    /* loaded from: classes7.dex */
    public class p implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ xw8 a;

        public p(xw8 xw8Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {xw8Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = xw8Var;
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

    /* loaded from: classes7.dex */
    public class p0 implements c05.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public p0(xw8 xw8Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {xw8Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // com.baidu.tieba.c05.e
        public void onClick(c05 c05Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, c05Var) == null) {
                c05Var.dismiss();
            }
        }
    }

    /* loaded from: classes7.dex */
    public class q extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ xw8 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public q(xw8 xw8Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {xw8Var, Integer.valueOf(i)};
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
            this.a = xw8Var;
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

    /* loaded from: classes7.dex */
    public class q0 implements c05.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public q0(xw8 xw8Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {xw8Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // com.baidu.tieba.c05.e
        public void onClick(c05 c05Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, c05Var) == null) {
                c05Var.dismiss();
            }
        }
    }

    /* loaded from: classes7.dex */
    public class r implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ xw8 a;

        public r(xw8 xw8Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {xw8Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = xw8Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                this.a.L2();
            }
        }
    }

    /* loaded from: classes7.dex */
    public class r0 implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ n75 a;
        public final /* synthetic */ xw8 b;

        public r0(xw8 xw8Var, n75 n75Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {xw8Var, n75Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = xw8Var;
            this.a = n75Var;
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

    /* loaded from: classes7.dex */
    public class s implements qc5 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ xw8 a;

        public s(xw8 xw8Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {xw8Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = xw8Var;
        }

        @Override // com.baidu.tieba.qc5
        public void C(pc5 pc5Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, pc5Var) == null) {
                Object obj = pc5Var.c;
                if ((obj instanceof e85) && EmotionGroupType.isSendAsPic(((e85) obj).getType())) {
                    if (this.a.B1 == null) {
                        this.a.B1 = new PermissionJudgePolicy();
                    }
                    this.a.B1.clearRequestPermissionList();
                    this.a.B1.appendRequestPermission(this.a.c.getBaseFragmentActivity(), "android.permission.WRITE_EXTERNAL_STORAGE");
                    if (this.a.B1.startRequestPermission(this.a.c.getBaseFragmentActivity())) {
                        return;
                    }
                    e85 e85Var = (e85) pc5Var.c;
                    this.a.c.D5().f(e85Var);
                    if (e85Var.i()) {
                        this.a.c.D5().G(null, null);
                    } else {
                        this.a.c.D5().w(false, null);
                    }
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class s0 implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ int a;
        public final /* synthetic */ int b;
        public final /* synthetic */ int c;
        public final /* synthetic */ View d;
        public final /* synthetic */ xw8 e;

        public s0(xw8 xw8Var, int i, int i2, int i3, View view2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {xw8Var, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), view2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i4 = newInitContext.flag;
                if ((i4 & 1) != 0) {
                    int i5 = i4 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.e = xw8Var;
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

    /* loaded from: classes7.dex */
    public class t implements TextWatcher {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ xw8 a;

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIII(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, charSequence, i, i2, i3) == null) {
            }
        }

        public t(xw8 xw8Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {xw8Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = xw8Var;
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, editable) == null) && this.a.c.J0 != null && this.a.c.J0.e() != null) {
                if (!this.a.c.J0.e().e()) {
                    this.a.c.J0.a(false);
                }
                this.a.c.J0.e().l(false);
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
                    xw8 xw8Var = this.a;
                    xw8Var.r1 = new yx8(xw8Var.c.getPageContext(), this.a.d, layoutParams);
                    if (!ListUtils.isEmpty(this.a.q1)) {
                        this.a.r1.q(this.a.q1);
                    }
                    this.a.r1.r(this.a.n0);
                }
                this.a.r1.p(substring);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class t0 implements PbFallingView.q {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ xw8 a;

        public t0(xw8 xw8Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {xw8Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = xw8Var;
        }

        @Override // com.baidu.tieba.pb.view.PbFallingView.q
        public void onClick() {
            String h1;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (this.a.c != null && this.a.c.P() != null && this.a.c.P().d2()) {
                    h1 = this.a.c.getString(R.string.pb_reply_hint_from_smart_frs);
                } else {
                    h1 = this.a.h1();
                }
                if (!StringUtils.isNull(h1) && this.a.M0 != null) {
                    h1 = TbSingleton.getInstance().getAdVertiComment(this.a.M0.o0(), this.a.M0.p0(), h1);
                }
                if (this.a.c != null && this.a.c.D5() != null) {
                    this.a.c.D5().c0(h1);
                }
                if (this.a.x0 != null) {
                    this.a.x0.setText(h1);
                }
                this.a.A3(false);
                this.a.U3();
            }
        }
    }

    /* loaded from: classes7.dex */
    public class u implements n05.f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ boolean a;
        public final /* synthetic */ xw8 b;

        public u(xw8 xw8Var, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {xw8Var, Boolean.valueOf(z)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = xw8Var;
            this.a = z;
        }

        @Override // com.baidu.tieba.n05.f
        public void M0(n05 n05Var, int i, View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIL(1048576, this, n05Var, i, view2) == null) {
                this.b.T.dismiss();
                SparseArray<Object> sparseArray = (SparseArray) view2.getTag();
                if (sparseArray == null) {
                    return;
                }
                switch (i) {
                    case 10:
                        this.b.p2(((Integer) sparseArray.get(R.id.tag_del_post_type)).intValue(), (String) sparseArray.get(R.id.tag_del_post_id), ((Integer) sparseArray.get(R.id.tag_manage_user_identity)).intValue(), ((Boolean) sparseArray.get(R.id.tag_del_post_is_self)).booleanValue());
                        return;
                    case 11:
                        if (this.b.S1 != null) {
                            this.b.S1.a(new Object[]{sparseArray.get(R.id.tag_manage_user_identity), sparseArray.get(R.id.tag_forbid_user_name), sparseArray.get(R.id.tag_forbid_user_post_id), sparseArray.get(R.id.tag_forbid_user_name_show), sparseArray.get(R.id.tag_forbid_user_portrait)});
                            return;
                        }
                        return;
                    case 12:
                        this.b.c.M5(this.a, (String) sparseArray.get(R.id.tag_user_mute_mute_userid), sparseArray);
                        return;
                    case 13:
                        this.b.m4(true);
                        return;
                    default:
                        return;
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class u0 implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ n75 a;
        public final /* synthetic */ xw8 b;

        public u0(xw8 xw8Var, n75 n75Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {xw8Var, n75Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = xw8Var;
            this.a = n75Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921664));
                this.b.K1.setHomePbFloatLastCloseTime();
                this.b.x1();
                this.b.K1.t(this.a);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class v implements c05.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public v(xw8 xw8Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {xw8Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // com.baidu.tieba.c05.e
        public void onClick(c05 c05Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, c05Var) == null) {
                c05Var.dismiss();
            }
        }
    }

    /* loaded from: classes7.dex */
    public class v0 implements ViewTreeObserver.OnGlobalLayoutListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PbFragment a;
        public final /* synthetic */ xw8 b;

        public v0(xw8 xw8Var, PbFragment pbFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {xw8Var, pbFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = xw8Var;
            this.a = pbFragment;
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (!this.b.F1 && this.a != null && this.b.c.P() != null && this.b.c.P().h2()) {
                    this.b.F1 = true;
                    this.a.X4(false);
                }
                if (this.b.G1) {
                    return;
                }
                this.b.G1 = true;
                if (this.b.P1() && this.b.z != null) {
                    this.b.z.h();
                    this.b.z.g(true);
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class w implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ AlertDialog a;
        public final /* synthetic */ SparseArray b;
        public final /* synthetic */ xw8 c;

        public w(xw8 xw8Var, AlertDialog alertDialog, SparseArray sparseArray) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {xw8Var, alertDialog, sparseArray};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = xw8Var;
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
                    ii.P(this.c.c.Q(), R.string.obfuscated_res_0x7f0f0d1b);
                } else {
                    this.c.c.i5(this.b, null);
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class w0 implements au8.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ xw8 a;

        public w0(xw8 xw8Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {xw8Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = xw8Var;
        }

        @Override // com.baidu.tieba.au8.b
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.c.P5();
            }
        }

        @Override // com.baidu.tieba.au8.b
        public void b() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) && this.a.l != null) {
                this.a.l.setSelection(0);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class x implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ AlertDialog a;

        public x(xw8 xw8Var, AlertDialog alertDialog) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {xw8Var, alertDialog};
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
    public class x0 implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ReplyPrivacyCheckController a;
        public final /* synthetic */ se5 b;
        public final /* synthetic */ xw8 c;

        public x0(xw8 xw8Var, ReplyPrivacyCheckController replyPrivacyCheckController, se5 se5Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {xw8Var, replyPrivacyCheckController, se5Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = xw8Var;
            this.a = replyPrivacyCheckController;
            this.b = se5Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                if (this.a != null && this.c.c != null && this.c.c.p5() != null && !this.a.checkPrivacyBeforeInvokeEditor(this.c.c.p5().replyPrivateFlag)) {
                    return;
                }
                TiebaStatic.log(new StatisticItem(CommonStatisticKey.KEY_RD_USE).param("obj_param1", 3).param("obj_locate", 1).param("obj_type", 1).param("obj_source", UtilHelper.getCurrentPageName(TbadkCoreApplication.getInst().getCurrentActivity())));
                if (!DialogLoginHelper.checkUpIsLogin(new LoginDialogData(this.c.c.getActivity(), LoginDialogData.PB_BOTTOM_REPLY_RESULT_PAGE))) {
                    TiebaStatic.log(new StatisticItem(CommonStatisticKey.KEY_RD_USE).param("obj_param1", 3).param("obj_locate", 2).param("obj_type", 1).param("obj_source", UtilHelper.getCurrentPageName(TbadkCoreApplication.getInst().getCurrentActivity())));
                    return;
                }
                this.c.i4();
                this.b.n0();
                this.c.y0();
            }
        }
    }

    /* loaded from: classes7.dex */
    public class y implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ AlertDialog a;
        public final /* synthetic */ SparseArray b;
        public final /* synthetic */ xw8 c;

        public y(xw8 xw8Var, AlertDialog alertDialog, SparseArray sparseArray) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {xw8Var, alertDialog, sparseArray};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = xw8Var;
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
                    ii.P(this.c.c.Q(), R.string.obfuscated_res_0x7f0f0d1b);
                } else {
                    this.c.c.i5(this.b, null);
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class y0 implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ xw8 a;

        public y0(xw8 xw8Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {xw8Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = xw8Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                this.a.j2();
            }
        }
    }

    /* loaded from: classes7.dex */
    public class z implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ AlertDialog a;

        public z(xw8 xw8Var, AlertDialog alertDialog) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {xw8Var, alertDialog};
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
    public static class z0 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public PbReplyTitleViewHolder a;

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
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948314896, "Lcom/baidu/tieba/xw8;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948314896, "Lcom/baidu/tieba/xw8;");
                return;
            }
        }
        a2 = UtilHelper.getLightStatusBarHeight();
        b2 = 3;
        c2 = 0;
        d2 = 3;
        e2 = 4;
        f2 = 5;
        g2 = 6;
        h2 = ii.g(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds80);
        i2 = 1;
        j2 = new g0();
    }

    public sl9 L0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048620, this)) == null) {
            if (this.l == null) {
                return null;
            }
            int K0 = K0() - this.l.getHeaderViewsCount();
            int i3 = 0;
            if (K0 < 0) {
                K0 = 0;
            }
            if (this.E.y(K0) != null && this.E.y(K0) != sl9.Q0) {
                i3 = K0 + 1;
            }
            if (!(this.E.x(i3) instanceof sl9)) {
                return null;
            }
            return (sl9) this.E.x(i3);
        }
        return (sl9) invokeV.objValue;
    }

    public final boolean P1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048637, this)) == null) {
            if (t3()) {
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

    public void Q3() {
        sl9 sl9Var;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048643, this) != null) || !TbadkCoreApplication.isLogin() || this.M0 == null || !this.k1 || this.j1 || this.i0 || (sl9Var = this.N0) == null || sl9Var.q() == null || this.N0.q().getIsLike() || this.N0.q().hadConcerned()) {
        }
    }

    public final void l0() {
        PbContentCollectionController pbContentCollectionController;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048731, this) == null) {
            if (t3()) {
                new StatisticItem(CommonStatisticKey.KEY_PB_PAGE_CONTENT_COLLECTION_SHOW).addParam("tid", this.M0.M().getTid()).addParam("obj_param1", this.M0.M().getThreadRecommendInfoDataList().get(0).businessId).eventStat();
            }
            if (P1() && (pbContentCollectionController = this.z) != null) {
                pbContentCollectionController.h();
                this.z.g(true);
            }
        }
    }

    public xw8(PbFragment pbFragment, View.OnClickListener onClickListener, cu8 cu8Var, SortSwitchButton.f fVar) {
        int i3;
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {pbFragment, onClickListener, cu8Var, fVar};
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
        this.M1 = new k(this, 2921757);
        this.N1 = new m(this);
        this.O1 = new o(this, 2005016);
        this.P1 = new Handler();
        this.R1 = new q(this, 2004009);
        this.T1 = true;
        this.U1 = new h0(this);
        this.V1 = null;
        this.Y1 = new ArrayList();
        this.Z1 = false;
        this.c = pbFragment;
        this.P = onClickListener;
        this.Q = fVar;
        this.l0 = cu8Var;
        this.m1 = ii.l(pbFragment.getContext()) / 8;
        RelativeLayout relativeLayout = (RelativeLayout) LayoutInflater.from(this.c.getPageContext().getPageActivity()).inflate(R.layout.obfuscated_res_0x7f0d0694, (ViewGroup) null);
        this.d = relativeLayout;
        relativeLayout.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        this.p0 = this.d.findViewById(R.id.obfuscated_res_0x7f090454);
        this.x1 = (NavigationBarCoverTip) this.d.findViewById(R.id.obfuscated_res_0x7f0919e5);
        this.e = this.d.findViewById(R.id.obfuscated_res_0x7f09214d);
        this.L1 = (FrameLayout) this.d.findViewById(R.id.obfuscated_res_0x7f091dd8);
        this.D = (ObservedChangeRelativeLayout) this.d.findViewById(R.id.obfuscated_res_0x7f092428);
        this.m = (NoNetworkView) this.d.findViewById(R.id.view_no_network);
        PbLandscapeListView pbLandscapeListView = (PbLandscapeListView) this.d.findViewById(R.id.obfuscated_res_0x7f09181d);
        this.l = pbLandscapeListView;
        pbLandscapeListView.setDividerHeight(0);
        this.T0 = new TextView(this.c.getActivity());
        AbsListView.LayoutParams layoutParams = new AbsListView.LayoutParams(-1, UtilHelper.getLightStatusBarHeight() + ii.g(this.c.getActivity(), R.dimen.obfuscated_res_0x7f070307));
        this.l.setOverScrollMode(2);
        this.l.w(this.T0, 0);
        this.l.setTextViewAdded(true);
        this.d1 = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds134);
        this.Y0 = new View(this.c.getPageContext().getPageActivity());
        if (nw5.a()) {
            this.Y0.setLayoutParams(new AbsListView.LayoutParams(-1, 0));
        } else {
            this.Y0.setLayoutParams(new AbsListView.LayoutParams(-1, this.d1));
        }
        MessageManager.getInstance().registerListener(this.M1);
        this.Y0.setVisibility(4);
        this.l.addFooterView(this.Y0);
        this.l.setOnTouchListener(this.c.H2);
        this.a = new v0(this, pbFragment);
        this.l.getViewTreeObserver().addOnGlobalLayoutListener(this.a);
        this.h = new zy8(pbFragment, this.d);
        if (this.c.x5()) {
            ViewStub viewStub = (ViewStub) this.d.findViewById(R.id.obfuscated_res_0x7f09161a);
            this.j = viewStub;
            viewStub.setVisibility(0);
            yy8 yy8Var = new yy8(pbFragment);
            this.i = yy8Var;
            yy8Var.c();
            this.h.a.setVisibility(8);
            layoutParams.height = ii.g(this.c.getActivity(), R.dimen.obfuscated_res_0x7f07023d);
        }
        this.T0.setLayoutParams(layoutParams);
        this.h.i().setOnTouchListener(new au8(new w0(this)));
        this.t0 = this.d.findViewById(R.id.obfuscated_res_0x7f0927ae);
        this.u0 = this.d.findViewById(R.id.obfuscated_res_0x7f091980);
        this.J0 = ii.g(TbadkCoreApplication.getInst(), R.dimen.obfuscated_res_0x7f070285);
        this.w0 = (ImageView) this.d.findViewById(R.id.obfuscated_res_0x7f090946);
        this.w0.setOnClickListener(new x0(this, new ReplyPrivacyCheckController(this.c.getPageContext()), this.c.D5()));
        z0();
        this.x0 = (TextView) this.d.findViewById(R.id.obfuscated_res_0x7f091983);
        LinearLayout linearLayout = (LinearLayout) this.d.findViewById(R.id.obfuscated_res_0x7f09197b);
        this.v0 = linearLayout;
        linearLayout.setOnClickListener(new y0(this));
        EjectionAnimationView ejectionAnimationView = (EjectionAnimationView) this.d.findViewById(R.id.obfuscated_res_0x7f09094a);
        this.r0 = ejectionAnimationView;
        ejectionAnimationView.setEjectionAnimationViewCallback(new a(this));
        this.z0 = (ImageView) this.d.findViewById(R.id.obfuscated_res_0x7f091981);
        this.I1 = (MaskView) this.d.findViewById(R.id.mask_view);
        this.z0.setOnClickListener(this.P);
        AgreeView agreeView = (AgreeView) this.d.findViewById(R.id.obfuscated_res_0x7f09197d);
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
        ImageView imageView = (ImageView) this.d.findViewById(R.id.obfuscated_res_0x7f09197f);
        this.B0 = imageView;
        imageView.setOnClickListener(this.P);
        if (booleanExtra) {
            this.B0.setVisibility(8);
        } else {
            this.B0.setVisibility(0);
        }
        View findViewById = this.d.findViewById(R.id.obfuscated_res_0x7f091986);
        this.E0 = findViewById;
        if (!p45.m().i("pb_share_red_dot_shown", false) && TbadkCoreApplication.isLogin()) {
            i3 = 0;
        } else {
            i3 = 8;
        }
        findViewById.setVisibility(i3);
        this.C0 = (ImageView) this.d.findViewById(R.id.obfuscated_res_0x7f091984);
        HeadImageView headImageView = (HeadImageView) this.d.findViewById(R.id.obfuscated_res_0x7f091985);
        this.D0 = headImageView;
        headImageView.setIsRound(true);
        this.D0.setOnClickListener(this.N1);
        this.C0.setOnClickListener(new d(this));
        X1();
        l09 l09Var = new l09(this.C0);
        this.F0 = l09Var;
        l09Var.n(this.D0);
        if (!UbsABTestHelper.isResizeInduceSharingABTest() && !UbsABTestHelper.isResizeInduceSharingABTestA()) {
            this.F0.f();
        }
        TextView textView = (TextView) this.d.findViewById(R.id.obfuscated_res_0x7f091982);
        this.H0 = textView;
        textView.setVisibility(0);
        this.G0 = (TextView) this.d.findViewById(R.id.obfuscated_res_0x7f09197e);
        this.R0 = (ViewStub) this.d.findViewById(R.id.obfuscated_res_0x7f0910e4);
        this.A0.setVisibility(0);
        this.G0.setVisibility(0);
        this.t = new qx8(this.c, cu8Var);
        this.v = new ux8(this.c, cu8Var, this.P);
        kv8 kv8Var = new kv8(this.c, this.l);
        this.E = kv8Var;
        kv8Var.z0(this.P);
        this.E.B0(this.l0);
        this.E.w0(this.R);
        this.E.y0(this.Q);
        this.E.s0(this.X1);
        e eVar = new e(this);
        this.U = eVar;
        this.E.u0(eVar);
        H1();
        B1();
        tx8 tx8Var = new tx8(this.c);
        this.x = tx8Var;
        tx8Var.f = 2;
        A1();
        z1();
        this.y.a(this.l);
        this.v.n(this.l);
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
        this.O = this.d.findViewById(R.id.obfuscated_res_0x7f0927e5);
        this.c.registerListener(this.R1);
        this.f1 = new PbFakeFloorModel(this.c.getPageContext());
        PbModel P = this.c.P();
        this.f1.j0(P.Z(), P.V(), P.W(), P.U(), P.a0());
        uv8 uv8Var = new uv8(this.c.getPageContext(), this.f1, this.d);
        this.g1 = uv8Var;
        uv8Var.p(new f(this));
        this.g1.s(this.c.k2);
        this.f1.l0(new g(this));
        if (this.c.P() != null && !StringUtils.isNull(this.c.P().x1())) {
            PbFragment pbFragment2 = this.c;
            pbFragment2.showToast(pbFragment2.P().x1());
        }
        this.U0 = this.d.findViewById(R.id.obfuscated_res_0x7f091988);
        this.V0 = this.d.findViewById(R.id.obfuscated_res_0x7f090452);
        View findViewById2 = this.d.findViewById(R.id.obfuscated_res_0x7f092159);
        this.W0 = findViewById2;
        LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) findViewById2.getLayoutParams();
        if (this.c.P() != null && this.c.P().g1()) {
            this.U0.setVisibility(0);
            if (layoutParams2 != null) {
                layoutParams2.height = 0;
                this.W0.setLayoutParams(layoutParams2);
            }
        } else if (layoutParams2 != null) {
            layoutParams2.height = a2;
            this.W0.setLayoutParams(layoutParams2);
        }
        PbReplyTitleViewHolder pbReplyTitleViewHolder = new PbReplyTitleViewHolder(this.c.getPageContext(), this.d.findViewById(R.id.obfuscated_res_0x7f091a03));
        this.X0 = pbReplyTitleViewHolder;
        pbReplyTitleViewHolder.r(pbFragment.c0);
        this.X0.g.setVisibility(8);
        this.X0.q(this.P);
        this.X0.p(this.Q);
        this.c.registerListener(this.O1);
        PbFragment pbFragment3 = this.c;
        this.H1 = new k09(pbFragment3, pbFragment3.getUniqueId());
        this.J1 = (PbFallingView) this.d.findViewById(R.id.obfuscated_res_0x7f090a83);
        Q2();
        this.J1.setAnimationListener(new h(this));
        o0();
        this.q0 = this.d.findViewById(R.id.obfuscated_res_0x7f091971);
        n0(nw5.a());
        if (UbsABTestHelper.isPbForumGuideTestA() && P.l2() && es8.b().e()) {
            if (this.p == null) {
                this.p = new yv8(this.c.getActivity(), (ViewGroup) o1().findViewById(R.id.obfuscated_res_0x7f0919ad));
            }
            xv8 xv8Var = new xv8(this.l);
            this.q = xv8Var;
            xv8Var.d(new i(this));
        }
        this.r = new uw8(this.c.Q(), (ViewGroup) o1().findViewById(R.id.obfuscated_res_0x7f091a16));
        tw8 tw8Var = new tw8(this.l);
        this.s = tw8Var;
        tw8Var.d(new j(this));
    }

    public void O2(String str) {
        PbListView pbListView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048634, this, str) == null) && (pbListView = this.K) != null) {
            pbListView.F(str);
        }
    }

    public void R2(PbFragment.g3 g3Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048646, this, g3Var) == null) {
            this.S1 = g3Var;
        }
    }

    public void S2(boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048650, this, z2) == null) {
            this.o0 = z2;
        }
    }

    public void T2(boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048654, this, z2) == null) {
            this.E.j0(z2);
        }
    }

    public void U2(boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048658, this, z2) == null) {
            this.C1 = z2;
        }
    }

    public void V2(boolean z2) {
        kv8 kv8Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048662, this, z2) == null) && (kv8Var = this.E) != null) {
            kv8Var.k0(z2);
        }
    }

    public void W2(boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048666, this, z2) == null) {
            this.u1 = z2;
        }
    }

    public void X2(boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048670, this, z2) == null) {
            this.E.m0(z2);
        }
    }

    public void Y2(boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048674, this, z2) == null) {
            this.E.r0(z2);
        }
    }

    public final void Y3(sl9 sl9Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048675, this, sl9Var) == null) && sl9Var != null) {
            this.v1 = !StringUtils.isNull(sl9Var.b0());
            ux8 ux8Var = this.v;
            if (ux8Var != null) {
                ux8Var.o(sl9Var);
            }
        }
    }

    public void Z2(y45.g gVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048678, this, gVar) == null) {
            this.W1 = gVar;
            m09 m09Var = this.J;
            if (m09Var != null) {
                m09Var.f(gVar);
            }
        }
    }

    public final int a1(boolean z2) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048681, this, z2)) == null) {
            PbInterviewStatusView pbInterviewStatusView = this.S0;
            if (pbInterviewStatusView == null || pbInterviewStatusView.getVisibility() != 0 || !z2) {
                return 0;
            }
            return 0 + ii.g(TbadkCoreApplication.getInst(), R.dimen.obfuscated_res_0x7f07026a);
        }
        return invokeZ.intValue;
    }

    public void a3(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048683, this, onClickListener) == null) {
            this.X1 = onClickListener;
            kv8 kv8Var = this.E;
            if (kv8Var != null) {
                kv8Var.s0(onClickListener);
            }
        }
    }

    public void b3(String str) {
        yy8 yy8Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048687, this, str) == null) && (yy8Var = this.i) != null) {
            yy8Var.b(str);
        }
    }

    public void b4(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048688, this, str) == null) {
            this.c.showToast(str);
        }
    }

    public void c3(boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048691, this, z2) == null) {
            this.h1 = z2;
            PbLandscapeListView pbLandscapeListView = this.l;
            if (pbLandscapeListView != null) {
                this.i1 = pbLandscapeListView.getHeaderViewsCount();
            }
        }
    }

    public void d3(TbRichTextView.a0 a0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048695, this, a0Var) == null) {
            this.R = a0Var;
            this.E.w0(a0Var);
            this.s1.q(this.R);
        }
    }

    public void e3(NoNetworkView.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048699, this, bVar) == null) {
            this.S = bVar;
            NoNetworkView noNetworkView = this.m;
            if (noNetworkView != null) {
                noNetworkView.a(bVar);
            }
        }
    }

    public void f3(BdListView.p pVar) {
        PbLandscapeListView pbLandscapeListView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048704, this, pVar) == null) && (pbLandscapeListView = this.l) != null) {
            pbLandscapeListView.setOnSrollToBottomListener(pVar);
        }
    }

    public void f4(boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048705, this, z2) == null) {
            this.h0 = z2;
        }
    }

    public void g3(AbsListView.OnScrollListener onScrollListener) {
        PbLandscapeListView pbLandscapeListView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048709, this, onScrollListener) == null) && (pbLandscapeListView = this.l) != null) {
            pbLandscapeListView.setOnScrollListener(onScrollListener);
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

    public void h3(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048714, this, onClickListener) == null) {
            this.E.A0(onClickListener);
        }
    }

    public void i2(kn knVar) {
        PbLandscapeListView pbLandscapeListView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048718, this, knVar) == null) && (pbLandscapeListView = this.l) != null) {
            pbLandscapeListView.b0 = knVar;
            pbLandscapeListView.W = true;
        }
    }

    public void i3(int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048719, this, i3) == null) {
            this.D1 = i3;
        }
    }

    public void j3(View.OnLongClickListener onLongClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048724, this, onLongClickListener) == null) {
            this.v.D(onLongClickListener);
            this.E.x0(onLongClickListener);
            av8 av8Var = this.s1;
            if (av8Var != null) {
                av8Var.r(onLongClickListener);
            }
        }
    }

    public void n4(zs8 zs8Var) {
        qx8 qx8Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048745, this, zs8Var) == null) && (qx8Var = this.t) != null) {
            qx8Var.h(zs8Var, this.L0);
        }
    }

    public void p3(boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048754, this, z2) == null) {
            this.v.F(z2);
        }
    }

    public void r3(int i3) {
        PbLandscapeListView pbLandscapeListView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(1048762, this, i3) == null) && (pbLandscapeListView = this.l) != null) {
            pbLandscapeListView.setSelection(i3);
        }
    }

    public void s3(List<String> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048766, this, list) == null) {
            this.q1 = list;
            yx8 yx8Var = this.r1;
            if (yx8Var != null) {
                yx8Var.q(list);
            }
        }
    }

    public void u2(View view2) {
        SparseArray<Object> sparseArray;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048773, this, view2) != null) || (sparseArray = (SparseArray) view2.getTag()) == null) {
            return;
        }
        t2(sparseArray, false);
    }

    public void z3(boolean z2) {
        int i3;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048794, this, z2) == null) {
            View view2 = this.p0;
            if (z2) {
                i3 = 0;
            } else {
                i3 = 8;
            }
            view2.setVisibility(i3);
        }
    }

    public void Y1(boolean z2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048673, this, new Object[]{Boolean.valueOf(z2), Integer.valueOf(i3)}) == null) {
            xv8 xv8Var = this.q;
            if (xv8Var != null) {
                xv8Var.b();
            }
            tw8 tw8Var = this.s;
            if (tw8Var != null) {
                tw8Var.b(z2, i3);
            }
        }
    }

    @SuppressLint({"CutPasteId"})
    public void a4(zs8 zs8Var, boolean z2) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLZ(1048684, this, zs8Var, z2) != null) || zs8Var == null) {
            return;
        }
        k4(zs8Var, z2);
        w0();
    }

    public final void k3(sl9 sl9Var, zs8 zs8Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048729, this, sl9Var, zs8Var) == null) {
            this.v.E(sl9Var, zs8Var);
        }
    }

    public void x2(gb5 gb5Var, int i3) {
        PbFallingView pbFallingView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLI(1048785, this, gb5Var, i3) == null) && (pbFallingView = this.J1) != null) {
            pbFallingView.A(gb5Var, this.c.getPageContext(), i3, false);
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
            u1();
        }
    }

    public final void A1() {
        PbFragment pbFragment;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) && this.y == null && (pbFragment = this.c) != null) {
            this.y = new px8(pbFragment.getContext());
        }
    }

    public final void A2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.v.A(this.M0, this.N0, this.k1, this.j1);
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
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048581, this) == null) && this.u == null) {
            this.u = new sx8(this.c, this.l0);
        }
    }

    public void D0() {
        PbLandscapeListView pbLandscapeListView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048588, this) == null) && (pbLandscapeListView = this.l) != null) {
            pbLandscapeListView.setForbidDragListener(true);
        }
    }

    public kv8 G0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048600, this)) == null) {
            return this.E;
        }
        return (kv8) invokeV.objValue;
    }

    public final void G2() {
        PbInterviewStatusView pbInterviewStatusView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048602, this) == null) && (pbInterviewStatusView = this.S0) != null && pbInterviewStatusView.getVisibility() == 0) {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.S0.getLayoutParams();
            marginLayoutParams.setMargins(0, 0, 0, 0);
            this.S0.setLayoutParams(marginLayoutParams);
        }
    }

    public void G3() {
        zy8 zy8Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048603, this) == null) && (zy8Var = this.h) != null && !this.l1) {
            zy8Var.t();
            this.l1 = true;
        }
    }

    public LinearLayout H0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048604, this)) == null) {
            return this.v0;
        }
        return (LinearLayout) invokeV.objValue;
    }

    public final void H1() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048605, this) == null) && this.w == null) {
            this.w = new rx8(this.c, this.P);
        }
    }

    public void H2() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048606, this) == null) && this.f != 2) {
            PbLandscapeListView pbLandscapeListView = this.l;
            if (pbLandscapeListView != null) {
                pbLandscapeListView.setNextPage(this.K);
            }
            this.f = 2;
        }
    }

    public void H3() {
        PbLandscapeListView pbLandscapeListView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048607, this) == null) && (pbLandscapeListView = this.l) != null) {
            pbLandscapeListView.setVisibility(0);
        }
    }

    public View I0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048608, this)) == null) {
            View view2 = this.Y;
            if (view2 != null) {
                return view2.findViewById(R.id.dialog_button_ok);
            }
            return null;
        }
        return (View) invokeV.objValue;
    }

    public void I3() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048611, this) == null) {
            if (this.K0 == null) {
                this.K0 = new s45(this.c.getPageContext());
            }
            this.K0.h(true);
        }
    }

    public String J0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048612, this)) == null) {
            return this.d0;
        }
        return (String) invokeV.objValue;
    }

    public boolean J1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048613, this)) == null) {
            return this.I0;
        }
        return invokeV.booleanValue;
    }

    public void K3() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048619, this) == null) {
            this.E.i0(this.M0, false);
            this.E.a0();
        }
    }

    public boolean L1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048621, this)) == null) {
            PbLandscapeListView pbLandscapeListView = this.l;
            if (pbLandscapeListView == null) {
                return false;
            }
            return pbLandscapeListView.I();
        }
        return invokeV.booleanValue;
    }

    public void L2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048622, this) == null) {
            K2();
            s1();
            this.g1.g();
            A3(false);
        }
    }

    public PbFallingView M0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048624, this)) == null) {
            return this.J1;
        }
        return (PbFallingView) invokeV.objValue;
    }

    public boolean M1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048625, this)) == null) {
            EditorTools editorTools = this.n0;
            if (editorTools == null || editorTools.getVisibility() != 0) {
                return false;
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    public void M2() {
        Handler handler;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048626, this) != null) || (handler = this.P1) == null) {
            return;
        }
        Runnable runnable = this.Q1;
        if (runnable != null) {
            handler.removeCallbacks(runnable);
        }
        p pVar = new p(this);
        this.Q1 = pVar;
        this.P1.postDelayed(pVar, 2000L);
    }

    public int N0() {
        InterceptResult invokeV;
        int i3;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048628, this)) == null) {
            PbLandscapeListView pbLandscapeListView = this.l;
            if (pbLandscapeListView != null) {
                i3 = pbLandscapeListView.getFirstVisiblePosition();
            } else {
                i3 = 0;
            }
            return O0(i3);
        }
        return invokeV.intValue;
    }

    public final boolean O1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048633, this)) == null) {
            return TextUtils.equals(TbadkCoreApplication.getCurrentAccount(), this.V1);
        }
        return invokeV.booleanValue;
    }

    public Button P0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048636, this)) == null) {
            return this.s0;
        }
        return (Button) invokeV.objValue;
    }

    public int Q0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048640, this)) == null) {
            PbLandscapeListView pbLandscapeListView = this.l;
            if (pbLandscapeListView != null) {
                return pbLandscapeListView.getHeaderViewsCount();
            }
            return 0;
        }
        return invokeV.intValue;
    }

    public final void Q2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048642, this) == null) {
            this.J1.setFallingFeedbackListener(new t0(this));
        }
    }

    public TextView R0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048644, this)) == null) {
            return this.v.q();
        }
        return (TextView) invokeV.objValue;
    }

    public int S0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048648, this)) == null) {
            l09 l09Var = this.F0;
            if (l09Var != null) {
                return l09Var.g();
            }
            return 3;
        }
        return invokeV.intValue;
    }

    public void S3() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048651, this) == null) {
            this.O.setVisibility(0);
        }
    }

    public PbInterviewStatusView T0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048652, this)) == null) {
            return this.S0;
        }
        return (PbInterviewStatusView) invokeV.objValue;
    }

    public boolean T1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048653, this)) == null) {
            l09 l09Var = this.F0;
            if (l09Var == null) {
                return false;
            }
            return l09Var.i();
        }
        return invokeV.booleanValue;
    }

    public void T3() {
        kv8 kv8Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048655, this) == null) && (kv8Var = this.E) != null) {
            kv8Var.C0();
        }
    }

    public boolean U0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048656, this)) == null) {
            return this.u1;
        }
        return invokeV.booleanValue;
    }

    public boolean U1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048657, this)) == null) {
            EditorTools editorTools = this.n0;
            if (editorTools != null && editorTools.w()) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public int V0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048660, this)) == null) {
            PbLandscapeListView pbLandscapeListView = this.l;
            if (pbLandscapeListView == null) {
                return 0;
            }
            return O0(pbLandscapeListView.getLastVisiblePosition());
        }
        return invokeV.intValue;
    }

    public void V3() {
        l09 l09Var;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048663, this) != null) || (l09Var = this.F0) == null) {
            return;
        }
        l09Var.o(2);
    }

    public BdTypeListView W0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048664, this)) == null) {
            return this.l;
        }
        return (BdTypeListView) invokeV.objValue;
    }

    public void W1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048665, this) == null) {
            D2(this.M0);
        }
    }

    public av8 Y0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048672, this)) == null) {
            return this.s1;
        }
        return (av8) invokeV.objValue;
    }

    public View Z0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048676, this)) == null) {
            return this.N;
        }
        return (View) invokeV.objValue;
    }

    public NoNetworkView a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048680, this)) == null) {
            return this.m;
        }
        return (NoNetworkView) invokeV.objValue;
    }

    public View b1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048685, this)) == null) {
            return this.M;
        }
        return (View) invokeV.objValue;
    }

    public PbListView c1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048689, this)) == null) {
            return this.K;
        }
        return (PbListView) invokeV.objValue;
    }

    public void c4() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048692, this) == null) {
            this.c.showProgressBar();
        }
    }

    public int d1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048693, this)) == null) {
            try {
                return Integer.parseInt(this.I.getText().toString(), 10);
            } catch (Exception unused) {
                return -1;
            }
        }
        return invokeV.intValue;
    }

    public void d4() {
        PbFallingView pbFallingView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048696, this) == null) && (pbFallingView = this.J1) != null) {
            pbFallingView.C();
        }
    }

    public View e1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048697, this)) == null) {
            return this.U0;
        }
        return (View) invokeV.objValue;
    }

    public void e4() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048700, this) == null) && this.Y1 != null) {
            while (this.Y1.size() > 0) {
                TbImageView remove = this.Y1.remove(0);
                if (remove != null) {
                    remove.R();
                }
            }
        }
    }

    public PbFakeFloorModel f1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048702, this)) == null) {
            return this.f1;
        }
        return (PbFakeFloorModel) invokeV.objValue;
    }

    public void g0() {
        l09 l09Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048706, this) == null) && (l09Var = this.F0) != null) {
            l09Var.m(false);
        }
    }

    public uv8 g1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048707, this)) == null) {
            return this.g1;
        }
        return (uv8) invokeV.objValue;
    }

    public int k1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048727, this)) == null) {
            return this.P0;
        }
        return invokeV.intValue;
    }

    public void k2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048728, this) == null) {
            this.E.b0(2);
            l2();
            V1();
            o4();
            l0();
        }
    }

    public View l1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048732, this)) == null) {
            return this.e;
        }
        return (View) invokeV.objValue;
    }

    public final void l2() {
        PbFragment pbFragment;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048733, this) == null) && (pbFragment = this.c) != null && pbFragment.D5() != null) {
            this.c.D5().E();
        }
    }

    public PbThreadPostView m1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048737, this)) == null) {
            return this.o;
        }
        return (PbThreadPostView) invokeV.objValue;
    }

    public RelativeLayout n1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048742, this)) == null) {
            return this.D;
        }
        return (RelativeLayout) invokeV.objValue;
    }

    public void n3() {
        PbFragment pbFragment;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048744, this) == null) && (pbFragment = this.c) != null && pbFragment.getBaseFragmentActivity() != null) {
            ii.z(this.c.getPageContext().getPageActivity(), this.c.getBaseFragmentActivity().getCurrentFocus());
        }
    }

    public RelativeLayout o1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048747, this)) == null) {
            return this.d;
        }
        return (RelativeLayout) invokeV.objValue;
    }

    public void o3() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048749, this) == null) {
            this.K.C();
            this.K.S();
        }
    }

    public void p1() {
        View view2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048752, this) == null) {
            PbLandscapeListView pbLandscapeListView = this.l;
            if (pbLandscapeListView != null) {
                pbLandscapeListView.setVisibility(8);
            }
            zy8 zy8Var = this.h;
            if (zy8Var != null && (view2 = zy8Var.d) != null) {
                view2.setVisibility(8);
            }
        }
    }

    public void q1() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048756, this) != null) || this.u0 == null) {
            return;
        }
        this.t0.setVisibility(8);
        this.u0.setVisibility(8);
        this.I0 = false;
    }

    public void s1() {
        EditorTools editorTools;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048764, this) == null) && (editorTools = this.n0) != null) {
            editorTools.q();
            yx8 yx8Var = this.r1;
            if (yx8Var != null) {
                yx8Var.m();
            }
        }
    }

    public void t1() {
        zy8 zy8Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048768, this) == null) && (zy8Var = this.h) != null) {
            zy8Var.j();
        }
    }

    public void u0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048771, this) == null) {
            this.h.e();
            l05 l05Var = this.e0;
            if (l05Var != null) {
                l05Var.dismiss();
            }
            x0();
            c05 c05Var = this.F;
            if (c05Var != null) {
                c05Var.dismiss();
            }
            e05 e05Var = this.G;
            if (e05Var != null) {
                e05Var.e();
            }
        }
    }

    public void u1() {
        s45 s45Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048772, this) == null) && (s45Var = this.K0) != null) {
            s45Var.h(false);
        }
    }

    public void v0() {
        l09 l09Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048775, this) == null) && (l09Var = this.F0) != null) {
            l09Var.l(false);
        }
    }

    public void v1() {
        Runnable runnable;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048776, this) == null) {
            if (this.A == null) {
                D1();
            }
            this.k.setVisibility(8);
            Handler handler = this.P1;
            if (handler != null && (runnable = this.Q1) != null) {
                handler.removeCallbacks(runnable);
            }
        }
    }

    public final boolean w0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048779, this)) == null) {
            return this.t.b(this.L0);
        }
        return invokeV.booleanValue;
    }

    public void w1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048780, this) == null) {
            this.O.setVisibility(8);
        }
    }

    public boolean w2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048781, this)) == null) {
            uw8 uw8Var = this.r;
            if (uw8Var != null && uw8Var.l()) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public void w3() {
        View view2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048782, this) == null) {
            PbLandscapeListView pbLandscapeListView = this.l;
            int i3 = 0;
            if (pbLandscapeListView != null) {
                pbLandscapeListView.setVisibility(0);
            }
            zy8 zy8Var = this.h;
            if (zy8Var != null && (view2 = zy8Var.d) != null) {
                if (!TbadkCoreApplication.isLogin()) {
                    i3 = 8;
                }
                view2.setVisibility(i3);
            }
        }
    }

    public void x1() {
        RightFloatLayerView rightFloatLayerView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048784, this) == null) && (rightFloatLayerView = this.K1) != null) {
            rightFloatLayerView.c();
        }
    }

    public void y0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048787, this) == null) {
            StatisticItem statisticItem = new StatisticItem("c14693");
            statisticItem.param("uid", TbadkCoreApplication.getCurrentAccountId());
            statisticItem.param("obj_locate", i2);
            TiebaStatic.log(statisticItem);
        }
    }

    public void y1() {
        EditorTools editorTools;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048788, this) == null) && (editorTools = this.n0) != null) {
            editorTools.s();
        }
    }

    public void z0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048791, this) == null) {
            StatisticItem statisticItem = new StatisticItem("c14692");
            statisticItem.param("uid", TbadkCoreApplication.getCurrentAccountId());
            statisticItem.param("obj_locate", i2);
            TiebaStatic.log(statisticItem);
        }
    }

    public final void z1() {
        PbFragment pbFragment;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048792, this) == null) && this.z == null && (pbFragment = this.c) != null && pbFragment.getActivity() != null) {
            this.z = new PbContentCollectionController(this.c.getActivity());
        }
    }

    public void A3(boolean z2) {
        boolean z3;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeZ(1048579, this, z2) != null) || this.u0 == null) {
            return;
        }
        if (this.c.D5() != null && this.c.D5().y()) {
            z3 = true;
        } else {
            z3 = false;
        }
        S2(z3);
        if (this.o0) {
            E3(z2);
        } else {
            r1(z2);
        }
    }

    public void E3(boolean z2) {
        TextView textView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048595, this, z2) == null) && this.u0 != null && (textView = this.x0) != null) {
            textView.setText(R.string.obfuscated_res_0x7f0f0555);
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

    public void G1(zs8 zs8Var) {
        n75 pbAdFloatViewItemData;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048601, this, zs8Var) != null) || zs8Var == null) {
            return;
        }
        if (zs8Var.o0()) {
            pbAdFloatViewItemData = zs8Var.Z();
        } else {
            pbAdFloatViewItemData = TbSingleton.getInstance().getPbAdFloatViewItemData();
        }
        if (pbAdFloatViewItemData != null && !pbAdFloatViewItemData.a()) {
            F1(zs8Var, pbAdFloatViewItemData);
        } else {
            x1();
        }
    }

    public final boolean K1(zs8 zs8Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048617, this, zs8Var)) == null) {
            if (zs8Var != null && zs8Var.M() != null) {
                SpannableStringBuilder span_str = zs8Var.M().getSpan_str();
                if (span_str != null) {
                    return TbadkApplication.getInst().getResources().getString(R.string.obfuscated_res_0x7f0f0eaa).equals(span_str.toString());
                }
                return true;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public final boolean Q1(ThreadData threadData) {
        InterceptResult invokeL;
        String str;
        sl9 V;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048641, this, threadData)) == null) {
            if (threadData != null && threadData.getAuthor() != null) {
                zs8 zs8Var = this.M0;
                if (zs8Var != null && (V = zs8Var.V()) != null && V.q() != null) {
                    str = V.q().getUserId();
                } else {
                    str = "";
                }
                return TextUtils.equals(TbadkCoreApplication.getCurrentAccount(), str);
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public void b2(Configuration configuration) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048686, this, configuration) != null) || configuration == null) {
            return;
        }
        t0();
        if (configuration.orientation == 2) {
            q1();
            s1();
        } else {
            L2();
        }
        uv8 uv8Var = this.g1;
        if (uv8Var != null) {
            uv8Var.g();
        }
        this.c.P5();
        this.D.setVisibility(8);
        this.h.s(false);
        this.c.H6(false);
    }

    public void g2(boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048708, this, z2) == null) {
            if (z2) {
                G3();
            } else {
                t1();
            }
            this.b1.a = null;
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004013, this.b1));
            z2(this.b1.a, false);
        }
    }

    public void g4(boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048710, this, z2) == null) {
            this.h.y(z2);
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

    public final int i1(PbReplyTitleViewHolder pbReplyTitleViewHolder) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048717, this, pbReplyTitleViewHolder)) == null) {
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

    public void B2() {
        PbLandscapeListView pbLandscapeListView;
        int i3;
        int i4;
        boolean z2;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048582, this) != null) || (pbLandscapeListView = this.l) == null) {
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
        int i1 = i1(pbReplyTitleViewHolder);
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
        if ((z2 && pbReplyTitleViewHolder != null) || i3 >= this.E.G() + this.l.getHeaderViewsCount()) {
            if (pbReplyTitleViewHolder != null) {
                i5 = pbReplyTitleViewHolder.g.getMeasuredHeight();
            }
            if (z3) {
                this.l.setSelectionFromTop(this.E.G() + this.l.getHeaderViewsCount(), a2 - i5);
            } else {
                this.l.setSelectionFromTop(this.E.G() + this.l.getHeaderViewsCount(), this.h.i().getMeasuredHeight() - i5);
            }
        } else {
            this.l.setSelectionFromTop(i3, i4);
        }
        if (this.O0 != 6) {
            return;
        }
        this.l.setOnLayoutListener(new l(this, i1, pbReplyTitleViewHolder, z2, measuredHeight, i3, i4));
    }

    public void c2() {
        NoNetworkView.b bVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048690, this) == null) {
            yv8 yv8Var = this.p;
            if (yv8Var != null) {
                yv8Var.l();
            }
            uw8 uw8Var = this.r;
            if (uw8Var != null) {
                uw8Var.o();
            }
            RelativeLayout relativeLayout = this.d;
            if (relativeLayout != null && relativeLayout.getHandler() != null) {
                this.d.getHandler().removeCallbacksAndMessages(null);
            }
            l09 l09Var = this.F0;
            if (l09Var != null) {
                l09Var.k();
            }
            iw8 iw8Var = this.w1;
            if (iw8Var != null) {
                iw8Var.c();
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
            dl9.d();
            t0();
            A0();
            if (this.e1 != null) {
                jg.a().removeCallbacks(this.e1);
            }
            PbInterviewStatusView pbInterviewStatusView = this.S0;
            if (pbInterviewStatusView != null) {
                pbInterviewStatusView.m();
            }
            MessageManager.getInstance().unRegisterListener(this.M1);
            this.P1 = null;
            this.g.removeCallbacksAndMessages(null);
            this.E.b0(3);
            View view2 = this.e;
            if (view2 != null) {
                view2.setBackgroundDrawable(null);
            }
            kv8 kv8Var = this.E;
            if (kv8Var != null) {
                kv8Var.d0();
            }
            yx8 yx8Var = this.r1;
            if (yx8Var != null) {
                yx8Var.l();
            }
            ux8 ux8Var = this.v;
            if (ux8Var != null) {
                ux8Var.z();
            }
            PbReplyTitleViewHolder pbReplyTitleViewHolder = this.X0;
            if (pbReplyTitleViewHolder != null) {
                pbReplyTitleViewHolder.p(null);
            }
            this.t1 = null;
            PbLandscapeListView pbLandscapeListView = this.l;
            if (pbLandscapeListView != null) {
                pbLandscapeListView.setOnLayoutListener(null);
                this.l.getViewTreeObserver().removeGlobalOnLayoutListener(this.a);
                this.l.setListViewDragListener(null);
                this.l.J();
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

    public void f2() {
        sl9 sl9Var;
        int i3;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048703, this) != null) || this.c == null) {
            return;
        }
        if (!this.C1 && this.D1 != 17) {
            if (this.k1 && !this.j1 && (sl9Var = this.N0) != null && sl9Var.q() != null) {
                int i4 = 2;
                if (this.c.y0()) {
                    i3 = 2;
                } else {
                    i3 = 1;
                }
                if (!this.j1) {
                    i4 = 1;
                }
                uz8.q("c12601", i4, i3);
                MessageManager.getInstance().sendMessage(new CustomMessage(2002003, new PersonInfoActivityConfig(this.c.getPageContext().getPageActivity(), this.N0.q().getUserId(), this.N0.q().getUserName(), this.c.P().T0(), AddFriendActivityConfig.TYPE_PB_HEAD)));
                return;
            }
            return;
        }
        zs8 zs8Var = this.M0;
        if (zs8Var != null && zs8Var.k() != null && !hi.isEmpty(this.M0.k().getName())) {
            MessageManager.getInstance().sendMessage(new CustomMessage(2003000, new FrsActivityConfig(this.c.getContext()).createNormalCfg(this.M0.k().getName(), null)));
            TiebaStatic.log(new StatisticItem("c13853").param("post_id", this.M0.O()).param("uid", TbadkCoreApplication.getCurrentAccountId()).param("fid", this.M0.k().getId()));
        }
    }

    public void j2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048723, this) == null) {
            TiebaStatic.log(new StatisticItem(CommonStatisticKey.KEY_RD_USE).param("obj_param1", 3).param("obj_locate", 1).param("obj_type", 1).param("obj_source", UtilHelper.getCurrentPageName(TbadkCoreApplication.getInst().getCurrentActivity())));
            if (!DialogLoginHelper.checkUpIsLogin(new LoginDialogData(this.c.getActivity(), LoginDialogData.PB_BOTTOM_REPLY_RESULT_PAGE))) {
                TiebaStatic.log(new StatisticItem(CommonStatisticKey.KEY_RD_USE).param("obj_param1", 3).param("obj_locate", 2).param("obj_type", 1).param("obj_source", UtilHelper.getCurrentPageName(TbadkCoreApplication.getInst().getCurrentActivity())));
                return;
            }
            i4();
            this.c.r6();
            PbFragment pbFragment = this.c;
            if (pbFragment != null && pbFragment.P() != null && this.c.P().u1() != null && this.c.P().u1().M() != null && this.c.P().u1().M().getAuthor() != null) {
                TiebaStatic.log(new StatisticItem("c13701").param("tid", this.c.P().O1()).param("fid", this.c.P().u1().l()).param("uid", TbadkCoreApplication.getCurrentAccountId()));
                TiebaStatic.log(new StatisticItem("c13402").param("tid", this.c.P().b).param("fid", this.c.P().u1().l()).param("obj_locate", 1).param("uid", TbadkCoreApplication.getCurrentAccount()));
            }
        }
    }

    public void k0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048726, this) == null) {
            if (!this.c.checkUpIsLogin()) {
                TiebaStatic.log(new StatisticItem(CommonStatisticKey.KEY_RD_USE).param("obj_param1", 3).param("obj_locate", 2).param("obj_type", 1).param("obj_source", UtilHelper.getCurrentPageName(TbadkCoreApplication.getInst().getCurrentActivity())));
                uz8.r("c10517", this.k0, 2);
            } else if (!this.c.a5()) {
                TiebaStatic.log(new StatisticItem(CommonStatisticKey.KEY_RD_USE).param("obj_param1", 3).param("obj_locate", 8).param("obj_type", 1).param("obj_source", UtilHelper.getCurrentPageName(TbadkCoreApplication.getInst().getCurrentActivity())));
            } else {
                se5 D5 = this.c.D5();
                if (D5 != null && (D5.x() || D5.z())) {
                    TiebaStatic.log(new StatisticItem(CommonStatisticKey.KEY_RD_USE).param("obj_param1", 3).param("obj_locate", 10).param("obj_type", 1).param("obj_source", UtilHelper.getCurrentPageName(TbadkCoreApplication.getInst().getCurrentActivity())));
                    this.c.D5().w(false, null);
                    return;
                }
                if (this.n0 != null) {
                    E1();
                }
                EditorTools editorTools = this.n0;
                if (editorTools != null) {
                    this.I0 = false;
                    if (editorTools.p(2) != null) {
                        dl9.c(this.c.getPageContext(), (View) this.n0.p(2).m, false, j2);
                    }
                }
                q1();
            }
        }
    }

    public final void o4() {
        PbFragment pbFragment;
        int i3;
        String str;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048750, this) == null) && (pbFragment = this.c) != null && pbFragment.P() != null && this.c.P().G != null && this.c.P().G.M() != null && this.c.P().G.M().isXiuXiuThread()) {
            ThreadData M = this.c.P().G.M();
            int i4 = 0;
            if (this.c.P().Z0()) {
                i3 = 1;
            } else if (this.c.P().c1()) {
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

    public void B3(zs8 zs8Var) {
        sl9 sl9Var;
        zy8 zy8Var;
        boolean z2;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048583, this, zs8Var) == null) && zs8Var != null && (sl9Var = this.N0) != null && sl9Var.q() != null && (zy8Var = this.h) != null) {
            boolean z3 = !this.j1;
            this.k1 = z3;
            zy8Var.x(z3);
            if (this.c.E5() != null) {
                this.c.E5().s(this.k1);
            }
            A2();
            PbFragment pbFragment = this.c;
            if (pbFragment != null && !pbFragment.y0() && !ListUtils.isEmpty(zs8Var.o())) {
                kz4 kz4Var = zs8Var.o().get(0);
                if (kz4Var != null) {
                    this.h.A(zs8Var, kz4Var.d(), kz4Var.b(), kz4Var.a(), kz4Var.e());
                }
            } else if (zs8Var.k() != null) {
                zy8 zy8Var2 = this.h;
                String name = zs8Var.k().getName();
                String id = zs8Var.k().getId();
                String image_url = zs8Var.k().getImage_url();
                if (zs8Var.k().isLike() == 1) {
                    z2 = true;
                } else {
                    z2 = false;
                }
                zy8Var2.A(zs8Var, name, id, image_url, z2);
            }
            if (this.k1) {
                this.v.L(zs8Var, this.N0, this.i0);
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
            this.v.L(zs8Var, this.N0, this.i0);
            this.t1 = null;
            PbLandscapeListView pbLandscapeListView2 = this.l;
            if (pbLandscapeListView2 != null) {
                pbLandscapeListView2.setListViewDragListener(null);
            }
        }
    }

    public final void D2(zs8 zs8Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048590, this, zs8Var) == null) && zs8Var != null && zs8Var.M() != null) {
            j4(zs8Var);
            ImageView imageView = this.B0;
            if (imageView != null && imageView.getContext() != null) {
                if (zs8Var.q()) {
                    WebPManager.setPureDrawable(this.B0, R.drawable.icon_pure_pb_bottom_collected26_selection, R.color.CAM_X0305, WebPManager.ResourceStateType.NORMAL_PRESS);
                } else {
                    WebPManager.setPureDrawable(this.B0, R.drawable.icon_pure_pb_bottom_collect26, R.color.CAM_X0107, WebPManager.ResourceStateType.NORMAL_PRESS);
                }
            }
            String F0 = F0(zs8Var.M().getReply_num());
            TextView textView = this.H0;
            if (textView != null) {
                textView.setText(F0);
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921416, zs8Var.M()));
            C2(zs8Var.M().getAgreeData(), zs8Var.M().getAgreeNum());
            if (this.A0 != null && zs8Var.M() != null) {
                this.A0.setThreadData(zs8Var.M());
                int i3 = 1;
                if (zs8Var.M().getAgreeData() != null) {
                    zs8Var.M().getAgreeData().isInThread = true;
                }
                this.A0.setData(zs8Var.M().getAgreeData());
                pw4 pw4Var = new pw4();
                pw4Var.b = 26;
                if (zs8Var.M().isVideoThreadType() && zs8Var.M().getThreadVideoInfo() != null) {
                    i3 = 2;
                }
                pw4Var.c = i3;
                PbFragment pbFragment = this.c;
                if (pbFragment != null && pbFragment.P() != null) {
                    pw4Var.j = this.c.P().getFromForumId();
                    pw4Var.f = this.c.P().t1();
                }
                this.A0.setStatisticData(pw4Var);
            }
        }
    }

    public void F3(View view2) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048599, this, view2) != null) || p45.m().i("show_long_press_collection_tips", false)) {
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
        textView.setText(R.string.obfuscated_res_0x7f0f0468);
        this.p1.setGravity(17);
        this.p1.setPadding(ii.g(this.c.getContext(), R.dimen.obfuscated_res_0x7f0701e8), 0, ii.g(this.c.getContext(), R.dimen.obfuscated_res_0x7f0701e8), 0);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        layoutParams.gravity = 17;
        layoutParams.height = ii.g(this.c.getContext(), R.dimen.obfuscated_res_0x7f070253);
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
        p45.m().w("show_long_press_collection_tips", true);
    }

    public void I1(zs8 zs8Var) {
        PbReplyTitleViewHolder pbReplyTitleViewHolder;
        int bottom;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048609, this, zs8Var) == null) {
            int i3 = 0;
            this.E.i0(zs8Var, false);
            this.E.a0();
            w0();
            av8 av8Var = this.s1;
            if (av8Var != null) {
                av8Var.n();
            }
            ArrayList<sl9> F = zs8Var.F();
            if (zs8Var.y().b() == 0 || F == null || F.size() < zs8Var.y().e()) {
                if (ListUtils.getCount(F) != 0 && (ListUtils.getCount(F) != 1 || F.get(0) == null || F.get(0).E() != 1)) {
                    if (zs8Var.y().b() == 0) {
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
                    if (this.c.Y5()) {
                        this.K.I(TbadkCoreApplication.getInst().getResources().getString(R.string.obfuscated_res_0x7f0f0ec2), i3);
                    } else {
                        this.K.I(TbadkCoreApplication.getInst().getResources().getString(R.string.obfuscated_res_0x7f0f0ec3), i3);
                    }
                }
            }
            D2(zs8Var);
        }
    }

    public void P3(AdapterView.OnItemClickListener onItemClickListener) {
        boolean z2;
        boolean z3;
        boolean z4;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048639, this, onItemClickListener) == null) {
            g05 g05Var = this.g0;
            if (g05Var != null) {
                g05Var.d();
                this.g0 = null;
            }
            if (this.M0 == null) {
                return;
            }
            ArrayList<p05> arrayList = new ArrayList<>();
            String string = this.c.getContext().getString(R.string.all_person);
            boolean z5 = false;
            if (this.M0.J() == 1) {
                z2 = true;
            } else {
                z2 = false;
            }
            arrayList.add(new p05(string, "", z2, Integer.toString(1)));
            String string2 = this.c.getContext().getString(R.string.my_fans);
            if (this.M0.J() == 2) {
                z3 = true;
            } else {
                z3 = false;
            }
            arrayList.add(new p05(string2, "", z3, Integer.toString(5)));
            String string3 = this.c.getContext().getString(R.string.my_attentions);
            if (this.M0.J() == 3) {
                z4 = true;
            } else {
                z4 = false;
            }
            arrayList.add(new p05(string3, "", z4, Integer.toString(6)));
            String string4 = this.c.getContext().getString(R.string.myself_only);
            if (this.M0.J() == 4) {
                z5 = true;
            }
            arrayList.add(new p05(string4, "", z5, Integer.toString(7)));
            g05 g05Var2 = new g05(this.c.getPageContext());
            g05Var2.l(R.string.pb_privacy_setting_thread_reply_decs);
            this.g0 = g05Var2;
            g05Var2.k(arrayList, onItemClickListener);
            g05Var2.c();
            this.g0.n();
        }
    }

    public void C0(int i3, boolean z2, String str, boolean z3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(InputDeviceCompat.SOURCE_TOUCHPAD, this, new Object[]{Integer.valueOf(i3), Boolean.valueOf(z2), str, Boolean.valueOf(z3)}) == null) {
            this.c.hideProgressBar();
            if (z2 && z3) {
                PbFragment pbFragment = this.c;
                pbFragment.showToast(pbFragment.getPageContext().getString(R.string.obfuscated_res_0x7f0f130b));
            } else if (z3) {
                if (hi.isEmpty(str)) {
                    str = TbadkCoreApplication.getInst().getResources().getString(R.string.obfuscated_res_0x7f0f0d1b);
                }
                this.c.showToast(str);
            }
        }
    }

    public void s2(int i3, String str, int i4, boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048765, this, new Object[]{Integer.valueOf(i3), str, Integer.valueOf(i4), Boolean.valueOf(z2)}) == null) {
            SparseArray<Object> sparseArray = new SparseArray<>();
            sparseArray.put(R.id.tag_del_post_id, str);
            sparseArray.put(R.id.tag_del_post_type, Integer.valueOf(i3));
            sparseArray.put(R.id.tag_manage_user_identity, Integer.valueOf(i4));
            sparseArray.put(R.id.tag_del_post_is_self, Boolean.valueOf(z2));
            sparseArray.put(c2, Integer.valueOf(d2));
            if (z2) {
                x3(sparseArray);
            } else {
                y3(i3, sparseArray);
            }
        }
    }

    public final void C1(zs8 zs8Var) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048585, this, zs8Var) != null) || zs8Var == null || zs8Var.M() == null || !zs8Var.M().isInterviewLive() || this.S0 != null) {
            return;
        }
        PbInterviewStatusView pbInterviewStatusView = (PbInterviewStatusView) this.R0.inflate();
        this.S0 = pbInterviewStatusView;
        pbInterviewStatusView.setOnClickListener(this.P);
        this.S0.setCallback(this.c.w5());
        this.S0.setData(this.c, zs8Var);
    }

    public final int O0(int i3) {
        InterceptResult invokeI;
        int i4;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048632, this, i3)) == null) {
            PbLandscapeListView pbLandscapeListView = this.l;
            if (pbLandscapeListView == null) {
                return 0;
            }
            ym adapter2 = pbLandscapeListView.getAdapter2();
            if (adapter2 == null) {
                return i3;
            }
            if (i3 < adapter2.getCount() && i3 >= 0 && (adapter2.getItem(i3) instanceof rl9)) {
                i3++;
            }
            int o2 = (adapter2.o() + adapter2.m()) - 1;
            if (i3 > o2) {
                i3 = o2;
            }
            if (this.l.getAdapter2() != null && (this.l.getAdapter2() instanceof ym)) {
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

    public void P2(String str) {
        PbReplyTitleViewHolder pbReplyTitleViewHolder;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048638, this, str) == null) && this.K != null) {
            int i3 = 0;
            z0 z0Var = this.b1;
            if (z0Var != null && (pbReplyTitleViewHolder = z0Var.a) != null && pbReplyTitleViewHolder.getView() != null) {
                i3 = this.b1.a.getView().getTop() < 0 ? this.b1.a.getView().getHeight() : this.b1.a.getView().getBottom();
            }
            this.K.I(str, i3);
        }
    }

    public final void Z3(zs8 zs8Var) {
        boolean z2;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048679, this, zs8Var) == null) && !this.v1 && zs8Var != null && zs8Var.M() != null && !zs8Var.M().isVideoThreadType()) {
            boolean z3 = false;
            if (zs8Var.M().getIs_good() == 1) {
                z2 = true;
            } else {
                z2 = false;
            }
            if (zs8Var.M().getIs_top() == 1) {
                z3 = true;
            }
            ux8 ux8Var = this.v;
            if (ux8Var != null) {
                ux8Var.p(zs8Var, z2, z3);
            }
            sx8 sx8Var = this.u;
            if (sx8Var != null) {
                sx8Var.b(zs8Var, z2, z3);
            }
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

    public void q3(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048758, this, str) == null) {
            this.x0.performClick();
            if (!StringUtils.isNull(str) && this.c.D5() != null && this.c.D5().s() != null && this.c.D5().s().i() != null) {
                EditText i3 = this.c.D5().s().i();
                i3.setText(str);
                i3.setSelection(str.length());
            }
        }
    }

    public final void C2(AgreeData agreeData, long j3) {
        TextView textView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLJ(1048586, this, agreeData, j3) == null) && agreeData != null && (textView = this.G0) != null) {
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

    public void n2(AbsListView absListView, int i3) {
        RightFloatLayerView rightFloatLayerView;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048743, this, absListView, i3) == null) {
            if (i3 == 0) {
                this.b1.a = null;
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004013, this.b1));
                z2(this.b1.a, true);
                s0();
                this.E.h0(true);
            }
            this.E.g0();
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

    public final void C3(SparseArray<Object> sparseArray, @StringRes int i3, @StringRes int i4) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLII(1048587, this, sparseArray, i3, i4) != null) || this.c == null) {
            return;
        }
        TBAlertConfig.a aVar = new TBAlertConfig.a((int) R.string.obfuscated_res_0x7f0f04d9, TBAlertConfig.OperateBtnStyle.MAIN);
        TBAlertConfig.a aVar2 = new TBAlertConfig.a((int) R.string.obfuscated_res_0x7f0f038d, TBAlertConfig.OperateBtnStyle.SECONDARY);
        TBAlertBuilder tBAlertBuilder = new TBAlertBuilder(this.c.Q());
        tBAlertBuilder.w(i3);
        tBAlertBuilder.m(i4);
        tBAlertBuilder.o(true);
        tBAlertBuilder.u(aVar2, aVar);
        tBAlertBuilder.j(false);
        AlertDialog z2 = tBAlertBuilder.z();
        aVar.a(new w(this, z2, sparseArray));
        aVar2.a(new x(this, z2));
    }

    public final void D1() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048589, this) != null) || !this.c.x5()) {
            return;
        }
        ViewStub viewStub = (ViewStub) this.d.findViewById(R.id.obfuscated_res_0x7f091615);
        this.k = viewStub;
        viewStub.setVisibility(0);
        if (this.A == null) {
            this.A = (LinearLayout) this.d.findViewById(R.id.obfuscated_res_0x7f091614);
            zm5.a(this.c.getPageContext(), this.A);
        }
        if (this.B == null) {
            this.B = (TextView) this.A.findViewById(R.id.obfuscated_res_0x7f091619);
        }
        if (this.C == null) {
            this.C = (TextView) this.A.findViewById(R.id.obfuscated_res_0x7f091618);
        }
        this.B.setOnClickListener(this.P);
        this.C.setOnClickListener(this.P);
    }

    public void E1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048593, this) == null) {
            if (this.c != null && this.n0 != null) {
                TiebaStatic.log(new StatisticItem(CommonStatisticKey.KEY_RD_USE).param("obj_param1", 3).param("obj_locate", 9).param("obj_type", 1).param("obj_source", UtilHelper.getCurrentPageName(TbadkCoreApplication.getInst().getCurrentActivity())));
                this.n0.j();
                q1();
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

    public final void K2() {
        PbFragment pbFragment;
        int i3;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048618, this) == null) && (pbFragment = this.c) != null && pbFragment.D5() != null && this.n0 != null) {
            ne5.a().c(0);
            se5 D5 = this.c.D5();
            D5.M();
            D5.K();
            if (D5.v() != null) {
                WriteImagesInfo v2 = D5.v();
                if (D5.t) {
                    i3 = 1;
                } else {
                    i3 = 9;
                }
                v2.setMaxImagesAllowed(i3);
            }
            D5.d0(SendView.h);
            D5.h(SendView.h);
            wc5 o2 = this.n0.o(23);
            wc5 o3 = this.n0.o(2);
            wc5 o4 = this.n0.o(5);
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

    public final void X1() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048669, this) == null) && UbsABTestHelper.isShareTopRight()) {
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

    public void m3() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048739, this) == null) {
            this.c.hideProgressBar();
            zs8 zs8Var = this.M0;
            if (zs8Var != null && this.K != null && zs8Var.y() != null && this.M0.y().b() == 0) {
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
        k09 k09Var;
        int i3;
        boolean z2;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048763, this) != null) || (k09Var = this.H1) == null) {
            return;
        }
        if (this.l != null && k09Var.a() != null && this.H1.a().getParent() != null) {
            i3 = this.l.getPositionForView(this.H1.a());
        } else {
            i3 = -1;
        }
        boolean z3 = false;
        if (i3 != -1) {
            if (this.H1.a().getTop() + h2 <= this.U0.getBottom()) {
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
        pbReplyTitleViewHolder.t(z3);
        this.H1.e(z2);
    }

    public final boolean t3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048770, this)) == null) {
            zs8 zs8Var = this.M0;
            if (zs8Var != null && zs8Var.M() != null && !ListUtils.isEmpty(this.M0.M().getThreadRecommendInfoDataList()) && this.c != null && this.u.d() != null && this.u.d().getVisibility() == 0 && this.M0.M().getThreadRecommendInfoDataList().get(0) != null && this.M0.M().getThreadRecommendInfoDataList().get(0).businessType == 1) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public final void y2() {
        zy8 zy8Var;
        zs8 zs8Var;
        boolean z2;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048789, this) == null) && this.u != null && (zy8Var = this.h) != null && zy8Var.i() != null && (zs8Var = this.M0) != null && zs8Var.M() != null && this.M0.M().isQuestionThread() && this.u.d() != null && this.u.d().getVisibility() == 0) {
            int[] iArr = new int[2];
            this.u.d().getLocationInWindow(iArr);
            boolean z3 = true;
            int height = iArr[1] + this.u.d().getHeight();
            if (this.u.d().getParent() != null) {
                z2 = true;
            } else {
                z2 = false;
            }
            zy8 zy8Var2 = this.h;
            if (height > zy8Var2.i().getBottom() && z2) {
                z3 = false;
            }
            zy8Var2.w(z3, this.M0.M().getSpan_str());
        }
    }

    public final boolean D3(zs8 zs8Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048591, this, zs8Var)) == null) {
            if (zs8Var == null || zs8Var.M() == null) {
                return false;
            }
            if (zs8Var.M().getIsLive() != 1 && zs8Var.M().getThreadType() != 33 && ((zs8Var.M().getTopicData() == null || zs8Var.M().getTopicData().a() == 0) && zs8Var.M().getIs_top() != 1 && zs8Var.M().getIs_good() != 1 && !zs8Var.M().isActInfo() && !zs8Var.M().isInterviewLive() && !zs8Var.M().isVoteThreadType() && zs8Var.M().getYulePostActivityData() == null && hi.isEmpty(zs8Var.M().getCategory()) && !zs8Var.M().isGodThread() && !zs8Var.M().isRealGod())) {
                return false;
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public void h4(ys8 ys8Var) {
        String string;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048715, this, ys8Var) != null) || ys8Var == null) {
            return;
        }
        this.h.z();
        if (!StringUtils.isNull(ys8Var.b)) {
            this.h.v(ys8Var.b);
        }
        String string2 = TbadkCoreApplication.getInst().getResources().getString(R.string.obfuscated_res_0x7f0f14b8);
        int e3 = gg.e(ys8Var.a, 0);
        if (e3 != 100) {
            if (e3 != 300) {
                if (e3 != 400) {
                    string = "";
                } else {
                    string = TbadkCoreApplication.getInst().getResources().getString(R.string.obfuscated_res_0x7f0f142e);
                }
            } else {
                string = TbadkCoreApplication.getInst().getResources().getString(R.string.obfuscated_res_0x7f0f0303);
            }
        } else {
            string = TbadkCoreApplication.getInst().getResources().getString(R.string.obfuscated_res_0x7f0f11dc);
        }
        this.c.showNetRefreshView(this.d, String.format(string2, string), null, TbadkCoreApplication.getInst().getResources().getString(R.string.appeal_restore), true, new k0(this, ys8Var.c));
    }

    public void r0(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048759, this, str) == null) {
            if (str.contains("_")) {
                str = str.replace("_", "\n");
            }
            c05 c05Var = new c05(this.c.getPageContext().getPageActivity());
            View inflate = LayoutInflater.from(this.c.getPageContext().getPageActivity()).inflate(R.layout.upgrade_success_dialog_content, (ViewGroup) null);
            TextView textView = (TextView) inflate.findViewById(R.id.title_view);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
            layoutParams.setMargins(0, 0, 0, 0);
            textView.setLayoutParams(layoutParams);
            textView.setGravity(3);
            textView.setText(str);
            ((TextView) inflate.findViewById(R.id.function_description_view)).setVisibility(8);
            c05Var.setContentView(inflate);
            SparseArray sparseArray = new SparseArray();
            sparseArray.put(c2, Integer.valueOf(f2));
            c05Var.setYesButtonTag(sparseArray);
            c05Var.setPositiveButton(R.string.obfuscated_res_0x7f0f1678, this.c);
            c05Var.setNegativeButton(R.string.obfuscated_res_0x7f0f038d, new q0(this));
            c05Var.create(this.c.getPageContext()).show();
        }
    }

    public void v2(@NonNull View view2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048777, this, view2) == null) && this.A0.getData() != null && this.A0.getData().hasAgree && this.c.getActivity() != null) {
            ds8 ds8Var = new ds8(this.c.getContext());
            int g3 = ii.g(TbadkCoreApplication.getInst(), R.dimen.tbds774);
            int g4 = ii.g(TbadkCoreApplication.getInst(), R.dimen.obfuscated_res_0x7f07077f);
            int[] iArr = new int[2];
            view2.getLocationInWindow(iArr);
            int i3 = iArr[0];
            int i4 = iArr[1];
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(g4, g3);
            layoutParams.leftMargin = ((view2.getWidth() / 2) + i3) - ((int) ((g4 * 1) / 1.45d));
            layoutParams.topMargin = ii.g(TbadkCoreApplication.getInst(), R.dimen.M_H_X006);
            ds8Var.k(g3);
            ds8Var.j(layoutParams);
            ds8Var.i(false);
            ds8Var.n(true, this.c.getActivity().findViewById(16908290), 0, i4, this.M0.O(), this.M0.l());
            ds8Var.l(new n(this));
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
                return this.c.getString(R.string.obfuscated_res_0x7f0f0ea9);
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

    public void N2(EditorTools editorTools) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048630, this, editorTools) == null) {
            this.n0 = editorTools;
            editorTools.setOnCancelClickListener(new r(this));
            this.n0.setId(R.id.obfuscated_res_0x7f09197c);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
            layoutParams.addRule(12);
            if (this.n0.getParent() == null) {
                this.d.addView(this.n0, layoutParams);
            }
            this.n0.y(TbadkCoreApplication.getInst().getSkinType());
            this.n0.setActionListener(24, new s(this));
            s1();
            this.c.D5().g(new t(this));
        }
    }

    public void X3(boolean z2) {
        TextView textView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048671, this, z2) == null) && this.l != null && (textView = this.T0) != null && this.e != null) {
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
                    layoutParams.height = a2;
                    this.T0.setLayoutParams(layoutParams);
                    return;
                }
                return;
            }
            if (textView.getLayoutParams() instanceof AbsListView.LayoutParams) {
                AbsListView.LayoutParams layoutParams2 = (AbsListView.LayoutParams) this.T0.getLayoutParams();
                layoutParams2.height = BdListViewHelper.a(BdListViewHelper.HeadType.DEFAULT) + a1(true);
                this.T0.setLayoutParams(layoutParams2);
            }
            G2();
        }
    }

    public void Z1(il9 il9Var) {
        zs8 zs8Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048677, this, il9Var) == null) && il9Var != null && il9Var.b != null && (zs8Var = this.M0) != null && zs8Var.M() != null && this.M0.M().getAgreeData() != null) {
            AgreeData agreeData = this.M0.M().getAgreeData();
            String str = il9Var.b.nid;
            if (!TextUtils.isEmpty(str) && !"0".equals(str)) {
                BaijiahaoData baijiahaoData = agreeData.baijiahaoData;
                if (baijiahaoData == null || !TextUtils.equals(str, baijiahaoData.oriUgcNid)) {
                    return;
                }
            } else {
                String str2 = il9Var.b.threadId;
                String str3 = agreeData.threadId;
                if ("0".equals(str2) || TextUtils.isEmpty(str2) || !TextUtils.equals(str2, str3)) {
                    return;
                }
            }
            AgreeData agreeData2 = il9Var.b;
            C2(agreeData2, agreeData2.agreeNum);
        }
    }

    public void d2(TbRichText tbRichText) {
        zs8 zs8Var;
        sl9 sl9Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048694, this, tbRichText) == null) && (zs8Var = this.M0) != null && zs8Var.F() != null && !this.M0.F().isEmpty() && tbRichText != null && !StringUtils.isNull(tbRichText.getAuthorId())) {
            for (int i3 = 0; i3 < this.M0.F().size() && (sl9Var = this.M0.F().get(i3)) != null && sl9Var.q() != null && !StringUtils.isNull(sl9Var.q().getUserId()); i3++) {
                if (this.M0.F().get(i3).q().getUserId().equals(tbRichText.getAuthorId())) {
                    av8 av8Var = this.s1;
                    if (av8Var != null && av8Var.l()) {
                        A3(false);
                        return;
                    }
                    return;
                }
            }
        }
    }

    public void j4(zs8 zs8Var) {
        int i3;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048725, this, zs8Var) == null) {
            if (zs8Var != null && AntiHelper.o(zs8Var.M())) {
                l09 l09Var = this.F0;
                if (l09Var != null) {
                    l09Var.l(false);
                    this.F0.k();
                }
                ViewGroup.LayoutParams layoutParams = this.C0.getLayoutParams();
                layoutParams.height = -2;
                layoutParams.width = -2;
                this.C0.setLayoutParams(layoutParams);
                WebPManager.setPureDrawable(this.C0, R.drawable.icon_pure_pb_bottom_share26, R.color.CAM_X0110, WebPManager.ResourceStateType.NORMAL_PRESS);
                return;
            }
            l09 l09Var2 = this.F0;
            if (l09Var2 != null && l09Var2.h()) {
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

    public void m4(boolean z2) {
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048740, this, z2) == null) {
            kv8 kv8Var = this.E;
            if (kv8Var != null) {
                kv8Var.v0(z2);
                this.E.a0();
            }
            PbReplyTitleViewHolder pbReplyTitleViewHolder = this.X0;
            if (pbReplyTitleViewHolder != null) {
                pbReplyTitleViewHolder.o(z2);
            }
            PbReplyTitleViewHolder pbReplyTitleViewHolder2 = this.b1.a;
            if (pbReplyTitleViewHolder2 != null) {
                pbReplyTitleViewHolder2.o(z2);
            }
            PbFragment pbFragment = this.c;
            if (pbFragment != null) {
                pbFragment.G6(z2);
            }
            if (z2) {
                sy8.d(this.c.getPageContext(), this.c.P(), this.c.G5());
            }
            StatisticItem statisticItem = new StatisticItem(CommonStatisticKey.KEY_BATCH_MULTI_DEL_CLICK);
            zs8 zs8Var = this.M0;
            if (zs8Var != null) {
                str = zs8Var.l();
            } else {
                str = "0";
            }
            TiebaStatic.log(statisticItem.param("fid", str).param("uid", TbadkCoreApplication.getCurrentAccountId()).param("obj_type", "1"));
        }
    }

    public void r1(boolean z2) {
        boolean z3;
        boolean z4;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048760, this, z2) == null) && this.u0 != null && this.x0 != null) {
            TbSingleton tbSingleton = TbSingleton.getInstance();
            zs8 zs8Var = this.M0;
            if (zs8Var != null && zs8Var.o0()) {
                z3 = true;
            } else {
                z3 = false;
            }
            zs8 zs8Var2 = this.M0;
            if (zs8Var2 != null && zs8Var2.p0()) {
                z4 = true;
            } else {
                z4 = false;
            }
            this.x0.setText(tbSingleton.getAdVertiComment(z3, z4, h1()));
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

    public final void x3(SparseArray<Object> sparseArray) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048786, this, sparseArray) != null) || this.c == null) {
            return;
        }
        if (sparseArray != null) {
            sparseArray.put(R.id.tag_is_block_thread, Boolean.TRUE);
        }
        TBAlertConfig.a aVar = new TBAlertConfig.a((int) R.string.obfuscated_res_0x7f0f1256, TBAlertConfig.OperateBtnStyle.MAIN);
        TBAlertConfig.a aVar2 = new TBAlertConfig.a((int) R.string.obfuscated_res_0x7f0f038d, TBAlertConfig.OperateBtnStyle.SECONDARY);
        TBAlertBuilder tBAlertBuilder = new TBAlertBuilder(this.c.Q());
        tBAlertBuilder.w(R.string.musk_my_thread_confirm);
        tBAlertBuilder.m(R.string.musk_my_thread_confirm_subtitle);
        tBAlertBuilder.o(true);
        tBAlertBuilder.u(aVar2, aVar);
        tBAlertBuilder.j(false);
        AlertDialog z2 = tBAlertBuilder.z();
        aVar.a(new y(this, z2, sparseArray));
        aVar2.a(new z(this, z2));
    }

    public void E2(int i3, zs8 zs8Var, boolean z2, int i4) {
        sl9 V;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(1048594, this, new Object[]{Integer.valueOf(i3), zs8Var, Boolean.valueOf(z2), Integer.valueOf(i4)}) == null) && i3 > 0 && zs8Var != null && (V = zs8Var.V()) != null && V.q() != null) {
            MetaData q2 = V.q();
            q2.setGiftNum(q2.getGiftNum() + i3);
        }
    }

    public final void F1(zs8 zs8Var, n75 n75Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048597, this, zs8Var, n75Var) == null) && this.L1 != null && zs8Var != null && n75Var != null && this.c.getContext() != null) {
            if (!RightFloatLayerView.k()) {
                x1();
                return;
            }
            if (this.K1 == null) {
                RightFloatLayerView E = RightFloatLayerLottieView.E(n75Var, this.c.getContext());
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
            if (n75Var.a()) {
                return;
            }
            this.K1.setData(n75Var);
            this.K1.setLogoListener(new r0(this, n75Var));
            this.K1.setFeedBackListener(new u0(this, n75Var));
        }
    }

    public void F2(zs8 zs8Var, boolean z2, int i3, int i4) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048598, this, new Object[]{zs8Var, Boolean.valueOf(z2), Integer.valueOf(i3), Integer.valueOf(i4)}) == null) {
            M3(zs8Var, z2, i3, i4);
            this.v.y(i4);
        }
    }

    public void p2(int i3, String str, int i4, boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048753, this, new Object[]{Integer.valueOf(i3), str, Integer.valueOf(i4), Boolean.valueOf(z2)}) == null) {
            q2(i3, str, i4, z2, null);
        }
    }

    public final void I2() {
        PbFragment pbFragment;
        WaterRippleView waterRippleView;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048610, this) != null) || (pbFragment = this.c) == null || pbFragment.getActivity() == null || (waterRippleView = this.y0) == null) {
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

    public void J2() {
        PbLandscapeListView pbLandscapeListView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048614, this) == null) && (pbLandscapeListView = this.l) != null) {
            this.y.d(pbLandscapeListView);
            this.u.h(this.l);
            this.v.B(this.l);
            this.w.d(this.l);
            this.t.f(this.l);
        }
    }

    public boolean R1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048645, this)) == null) {
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

    public boolean S1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048649, this)) == null) {
            zs8 zs8Var = this.M0;
            if (zs8Var == null || zs8Var.k() == null || "0".equals(this.M0.k().getId())) {
                return true;
            }
            return "me0407".equals(this.M0.k().getName());
        }
        return invokeV.booleanValue;
    }

    public final void U3() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048659, this) == null) {
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

    public String h1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048712, this)) == null) {
            if (!hi.isEmpty(this.A1)) {
                return this.A1;
            }
            if (this.c != null) {
                this.A1 = TbadkCoreApplication.getInst().getResources().getString(ww8.g());
            }
            return this.A1;
        }
        return (String) invokeV.objValue;
    }

    public void h2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048713, this) == null) {
            e4();
            this.E.b0(1);
            yv8 yv8Var = this.p;
            if (yv8Var != null) {
                yv8Var.k();
            }
            uw8 uw8Var = this.r;
            if (uw8Var != null) {
                uw8Var.j();
            }
            RightFloatLayerView rightFloatLayerView = this.K1;
            if (rightFloatLayerView != null && (rightFloatLayerView instanceof RightFloatLayerLottieView)) {
                ((RightFloatLayerLottieView) rightFloatLayerView).G(600);
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016524));
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

    public final void i4() {
        PbFragment pbFragment;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048720, this) == null) && (pbFragment = this.c) != null && pbFragment.D5() != null) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921706, Boolean.valueOf(!this.c.D5().y())));
        }
    }

    public final void j0() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048721, this) == null) && this.M0 != null && UbsABTestHelper.isResizeInduceSharingABTest() && !ty8.h(this.M0.O())) {
            this.F0.f();
            ty8.b(this.M0.O());
        }
    }

    public final void l4() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048735, this) != null) || !this.c.x5()) {
            return;
        }
        if (this.c.C5() == -1) {
            SkinManager.setViewTextColor(this.B, R.color.CAM_X0110, 1);
        }
        if (this.c.B5() == -1) {
            SkinManager.setViewTextColor(this.C, R.color.CAM_X0110, 1);
        }
    }

    public final void o0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048746, this) == null) {
            av8 av8Var = new av8(this.c, this, (ViewStub) this.d.findViewById(R.id.obfuscated_res_0x7f0916db));
            this.s1 = av8Var;
            av8Var.o(this.P);
            this.s1.p(this.U);
            this.s1.q(this.R);
            this.s1.o(this.P);
            this.s1.s(this.l0);
        }
    }

    public void t0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048767, this) == null) {
            this.h.e();
            PbFragment pbFragment = this.c;
            if (pbFragment != null) {
                ii.z(pbFragment.getContext(), this.I);
            }
            s1();
            l05 l05Var = this.e0;
            if (l05Var != null) {
                l05Var.dismiss();
            }
            x0();
            c05 c05Var = this.F;
            if (c05Var != null) {
                c05Var.dismiss();
            }
            e05 e05Var = this.G;
            if (e05Var != null) {
                e05Var.e();
            }
        }
    }

    public final boolean u3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048774, this)) == null) {
            PbFragment pbFragment = this.c;
            if (pbFragment == null || pbFragment.P().u1().k().getDeletedReasonInfo() == null || 1 != this.c.P().u1().k().getDeletedReasonInfo().is_grays_cale_forum.intValue()) {
                return false;
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    public void x0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048783, this) == null) {
            c05 c05Var = this.V;
            if (c05Var != null) {
                c05Var.dismiss();
            }
            Dialog dialog = this.W;
            if (dialog != null) {
                lg.b(dialog, this.c.getPageContext());
            }
            Dialog dialog2 = this.X;
            if (dialog2 != null) {
                lg.b(dialog2, this.c.getPageContext());
            }
            l05 l05Var = this.T;
            if (l05Var != null) {
                l05Var.dismiss();
            }
        }
    }

    public final void J3(SparseArray<Object> sparseArray, int i3, yx5 yx5Var, UserData userData, boolean z2) {
        PbFragment pbFragment;
        String str;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeCommon(1048615, this, new Object[]{sparseArray, Integer.valueOf(i3), yx5Var, userData, Boolean.valueOf(z2)}) != null) || (pbFragment = this.c) == null) {
            return;
        }
        if (this.z1 == null && this.t != null) {
            this.z1 = new zx5(pbFragment.getPageContext(), this.t.c(), yx5Var, userData);
        }
        this.z1.F(z2);
        AntiData p5 = this.c.p5();
        SparseArray<String> sparseArray2 = new SparseArray<>();
        if (p5 != null && p5.getDelThreadInfoList() != null) {
            List<DeleteThreadInfo> delThreadInfoList = p5.getDelThreadInfoList();
            for (int i4 = 0; i4 < delThreadInfoList.size(); i4++) {
                if (!TextUtils.isEmpty(delThreadInfoList.get(i4).text_info)) {
                    sparseArray2.put(delThreadInfoList.get(i4).text_id, delThreadInfoList.get(i4).text_info);
                }
            }
        }
        hy4 hy4Var = new hy4();
        hy4Var.j(sparseArray2);
        this.z1.H(new String[]{this.c.getString(R.string.delete_thread_reason_1), this.c.getString(R.string.delete_thread_reason_2), this.c.getString(R.string.delete_thread_reason_3), this.c.getString(R.string.delete_thread_reason_4), this.c.getString(R.string.delete_thread_reason_5)});
        this.z1.G(hy4Var);
        if (i3 != 1 && i3 != 2) {
            str = "3";
        } else {
            str = "4";
        }
        this.z1.J(str);
        this.z1.I(new b0(this, sparseArray));
    }

    public void O3(e05.c cVar, boolean z2, boolean z3, boolean z4, boolean z5) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048635, this, new Object[]{cVar, Boolean.valueOf(z2), Boolean.valueOf(z3), Boolean.valueOf(z4), Boolean.valueOf(z5)}) == null) {
            l05 l05Var = this.e0;
            if (l05Var != null) {
                l05Var.dismiss();
                this.e0 = null;
            }
            n05 n05Var = new n05(this.c.getContext());
            ArrayList arrayList = new ArrayList();
            if (!z4 && !z5) {
                arrayList.add(new j05(0, this.c.getPageContext().getString(R.string.obfuscated_res_0x7f0f0479), n05Var));
            }
            if (z3) {
                arrayList.add(new j05(1, this.c.getPageContext().getString(R.string.report_text), n05Var));
            } else if (!z2) {
                arrayList.add(new j05(1, this.c.getPageContext().getString(R.string.obfuscated_res_0x7f0f0b58), n05Var));
            } else {
                arrayList.add(new j05(1, this.c.getPageContext().getString(R.string.remove_mark), n05Var));
            }
            n05Var.k(arrayList);
            n05Var.p(new e0(this, cVar));
            l05 l05Var2 = new l05(this.c.getPageContext(), n05Var);
            this.f0 = l05Var2;
            l05Var2.k();
        }
    }

    public void L3(zs8 zs8Var, int i3, int i4, boolean z2, int i5, boolean z3) {
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
        zs8 zs8Var2;
        Parcelable e3;
        Parcelable e4;
        int size2;
        int i8;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(1048623, this, new Object[]{zs8Var, Integer.valueOf(i3), Integer.valueOf(i4), Boolean.valueOf(z2), Integer.valueOf(i5), Boolean.valueOf(z3)}) == null) && zs8Var != null && this.l != null) {
            this.M0 = zs8Var;
            this.O0 = i3;
            if (zs8Var.M() != null) {
                this.c1 = zs8Var.M().getCopyThreadRemindType();
                this.i0 = Q1(zs8Var.M());
            }
            if (zs8Var.T() != null) {
                this.V1 = zs8Var.T().getUserId();
            }
            C1(zs8Var);
            j0();
            this.Q0 = false;
            this.L0 = z2;
            m3();
            it8 it8Var = zs8Var.h;
            if (it8Var != null && it8Var.b()) {
                if (this.o == null) {
                    PbThreadPostView pbThreadPostView = new PbThreadPostView(this.c.getContext());
                    this.o = pbThreadPostView;
                    this.l.w(pbThreadPostView, 1);
                    this.o.setData(zs8Var);
                    this.o.setChildOnClickLinstener(this.P);
                }
            } else {
                PbThreadPostView pbThreadPostView2 = this.o;
                if (pbThreadPostView2 != null && (pbLandscapeListView = this.l) != null) {
                    pbLandscapeListView.removeHeaderView(pbThreadPostView2);
                }
            }
            M3(zs8Var, z2, i3, TbadkCoreApplication.getInst().getSkinType());
            B3(zs8Var);
            this.v.M(zs8Var, this.N0);
            if (this.w1 == null) {
                this.w1 = new iw8(this.c.getPageContext(), this.x1);
            }
            this.w1.a(zs8Var.w());
            if (this.c.x5()) {
                if (this.J == null) {
                    m09 m09Var = new m09(this.c.getPageContext());
                    this.J = m09Var;
                    m09Var.n();
                    this.J.f(this.W1);
                }
                this.l.setPullRefresh(this.J);
                m09 m09Var2 = this.J;
                if (m09Var2 != null) {
                    m09Var2.H(TbadkCoreApplication.getInst().getSkinType());
                }
            } else if (zs8Var.y().c() == 0 && z2) {
                this.l.setPullRefresh(null);
            } else {
                if (this.J == null) {
                    m09 m09Var3 = new m09(this.c.getPageContext());
                    this.J = m09Var3;
                    m09Var3.n();
                    this.J.f(this.W1);
                }
                this.l.setPullRefresh(this.J);
                m09 m09Var4 = this.J;
                if (m09Var4 != null) {
                    m09Var4.H(TbadkCoreApplication.getInst().getSkinType());
                }
                u1();
            }
            w0();
            this.E.q0(this.L0);
            this.E.n0(false);
            kv8 kv8Var = this.E;
            if (i3 == 5) {
                z4 = true;
            } else {
                z4 = false;
            }
            kv8Var.o0(z4);
            kv8 kv8Var2 = this.E;
            if (i3 == 6) {
                z5 = true;
            } else {
                z5 = false;
            }
            kv8Var2.p0(z5);
            kv8 kv8Var3 = this.E;
            if (z3 && this.T1 && i3 != 2) {
                z6 = true;
            } else {
                z6 = false;
            }
            kv8Var3.l0(z6);
            this.E.i0(zs8Var, false);
            this.E.a0();
            kv8 kv8Var4 = this.E;
            if (zs8Var.y().b() != 0) {
                z7 = true;
            } else {
                z7 = false;
            }
            kv8Var4.c0(z7, zs8Var.f());
            this.v.K(zs8Var.V(), zs8Var.h0());
            if (zs8Var.M() != null && zs8Var.M().getPraise() != null && this.b != -1) {
                zs8Var.M().getPraise().setIsLike(this.b);
            }
            this.l.removeFooterView(this.Y0);
            this.l.addFooterView(this.Y0);
            if (TbadkCoreApplication.isLogin()) {
                this.l.setNextPage(this.K);
                this.f = 2;
                u1();
            } else {
                this.Q0 = true;
                if (zs8Var.y().b() == 1) {
                    if (this.L == null) {
                        PbFragment pbFragment2 = this.c;
                        this.L = new h09(pbFragment2, pbFragment2);
                    }
                    this.l.setNextPage(this.L);
                } else {
                    this.l.setNextPage(this.K);
                }
                this.f = 3;
            }
            ArrayList<sl9> F = zs8Var.F();
            if (zs8Var.y().b() != 0 && F != null && F.size() >= zs8Var.y().e()) {
                if (z3) {
                    if (this.T1) {
                        A0();
                        if (zs8Var.y().b() != 0) {
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
                if (ListUtils.getCount(F) != 0 && (ListUtils.getCount(F) != 1 || F.get(0) == null || F.get(0).E() != 1)) {
                    if (zs8Var.y().b() == 0) {
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
                    if (this.c.Y5()) {
                        this.K.x(false);
                        if (ListUtils.isEmpty(zs8Var.P())) {
                            this.K.I(TbadkCoreApplication.getInst().getResources().getString(R.string.obfuscated_res_0x7f0f0ec2), i6);
                        }
                    } else if (ListUtils.isEmpty(zs8Var.P())) {
                        this.K.I(TbadkCoreApplication.getInst().getResources().getString(R.string.obfuscated_res_0x7f0f0ec3), i6);
                    }
                    if (this.c.E5() != null && !this.c.E5().p()) {
                        this.c.E5().x();
                    }
                }
                if (zs8Var.y().b() == 0 || F == null) {
                    H2();
                }
            }
            if (i3 != 2) {
                if (i3 != 3) {
                    if (i3 != 4) {
                        if (i3 != 5) {
                            if (i3 != 6) {
                                if (i3 == 8) {
                                    if (i4 == 0) {
                                        this.l.setSelection(this.E.B() + this.l.getHeaderViewsCount());
                                    } else if (ListUtils.isEmpty(zs8Var.P())) {
                                        if (this.l.getData() == null && zs8Var.F() == null) {
                                            size2 = 0;
                                        } else {
                                            size2 = (this.l.getData().size() - zs8Var.F().size()) + this.l.getHeaderViewsCount();
                                        }
                                        PbLandscapeListView pbLandscapeListView2 = this.l;
                                        if (i4 > 0) {
                                            i8 = size2 + i4;
                                        } else {
                                            i8 = 0;
                                        }
                                        pbLandscapeListView2.setSelection(i8);
                                    } else {
                                        this.l.setSelection(zs8Var.F().size() + this.l.getHeaderViewsCount());
                                    }
                                    this.K.g();
                                    this.K.F(this.c.getString(R.string.obfuscated_res_0x7f0f0ebc));
                                    this.K.A();
                                }
                            } else if (i5 == 1 && (e4 = ow8.b().e()) != null && !(e4 instanceof RecyclerView.SavedState)) {
                                this.l.onRestoreInstanceState(e4);
                            } else {
                                this.l.setSelection(0);
                            }
                        } else {
                            this.l.setSelection(0);
                        }
                    } else {
                        this.T1 = false;
                    }
                } else if (i5 == 1 && (e3 = ow8.b().e()) != null && !(e3 instanceof RecyclerView.SavedState)) {
                    this.l.post(new l0(this, e3, F, zs8Var));
                }
            } else {
                if (this.l.getData() == null && zs8Var.F() == null) {
                    size = 0;
                } else {
                    size = (this.l.getData().size() - zs8Var.F().size()) + this.l.getHeaderViewsCount();
                }
                PbLandscapeListView pbLandscapeListView3 = this.l;
                if (i4 > 1) {
                    i7 = (size + i4) - 2;
                } else {
                    i7 = 0;
                }
                pbLandscapeListView3.setSelection(i7);
            }
            if (this.c1 == b2 && O1()) {
                q0();
            }
            if (this.h1) {
                B2();
                this.h1 = false;
                if (i5 == 0) {
                    c3(true);
                }
            }
            if (zs8Var.d == 1 || zs8Var.e == 1) {
                if (this.n1 == null) {
                    this.n1 = new PbTopTipView(this.c.getContext());
                }
                if (zs8Var.e == 1 && "game_guide".equals(this.c.I5())) {
                    this.n1.setText(this.c.getString(R.string.obfuscated_res_0x7f0f0ece));
                    this.n1.l(this.d, this.P0);
                } else if (zs8Var.d == 1 && "game_news".equals(this.c.I5())) {
                    this.n1.setText(this.c.getString(R.string.obfuscated_res_0x7f0f0ecd));
                    this.n1.l(this.d, this.P0);
                }
            }
            this.l.removeFooterView(this.H1.a());
            if (!ListUtils.isEmpty(zs8Var.H()) && zs8Var.y().b() == 0) {
                this.l.removeFooterView(this.Y0);
                this.H1.d(Math.max(this.u0.getMeasuredHeight(), this.J0 / 2));
                this.l.addFooterView(this.H1.a());
                this.H1.f(zs8Var);
            }
            D2(zs8Var);
            if (zs8Var.f0() && this.c.P().l2() && this.c.F5() != null) {
                this.c.F5().d();
            }
            if (zs8Var.f() != 3) {
                G1(zs8Var);
            }
            this.x0.setText(TbSingleton.getInstance().getAdVertiComment(zs8Var.o0(), zs8Var.p0(), h1()));
            if (this.p != null && (zs8Var2 = this.M0) != null && zs8Var2.k() != null) {
                this.p.m(this.M0.k().getImage_url());
                this.p.n(this.M0.k().getName());
                PbFragment pbFragment3 = this.c;
                if (pbFragment3 != null && pbFragment3.P() != null) {
                    this.p.o(this.c.P().b);
                }
            }
            if (this.r != null) {
                zs8 zs8Var3 = this.M0;
                if (zs8Var3 != null && zs8Var3.k() != null && (pbFragment = this.c) != null && pbFragment.P() != null) {
                    this.r.q(this.c.P().b);
                }
                zs8 zs8Var4 = this.M0;
                if (zs8Var4 != null && zs8Var4.M() != null && !ListUtils.isEmpty(this.M0.M().getThreadRecommendInfoDataList()) && this.M0.M().getThreadRecommendInfoDataList().get(0) != null && this.M0.M().getThreadRecommendInfoDataList().get(0).businessType != 1) {
                    this.r.p(this.M0.M().getThreadRecommendInfoDataList().get(0));
                } else {
                    this.r.p(null);
                }
            }
            if (t3()) {
                this.z.e(this.M0.M());
            } else {
                this.z.d(this.l);
            }
        }
    }

    @SuppressLint({"ResourceAsColor"})
    public final void M3(zs8 zs8Var, boolean z2, int i3, int i4) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(1048627, this, new Object[]{zs8Var, Boolean.valueOf(z2), Integer.valueOf(i3), Integer.valueOf(i4)}) == null) && zs8Var != null && zs8Var.M() != null) {
            if (this.c.y0()) {
                if (zs8Var.g() != null) {
                    this.j0 = zs8Var.g().d();
                    this.k0 = zs8Var.g().b();
                }
                if (this.j0 == null && this.c.P() != null && this.c.P().T0() != null) {
                    this.j0 = this.c.P().T0();
                }
            }
            sl9 V = zs8Var.V();
            k3(V, zs8Var);
            int i5 = 8;
            this.v.H(8);
            int i6 = 1;
            if (zs8Var.v0()) {
                this.j1 = true;
                this.h.r(true);
                this.h.a.hideBottomLine();
            } else {
                this.j1 = false;
                this.h.r(false);
            }
            if (this.c.E5() != null) {
                this.c.E5().w(this.j1);
            }
            if (V == null) {
                return;
            }
            this.N0 = V;
            this.v.H(0);
            this.w.e(zs8Var, this.l);
            this.y.e(zs8Var, this.D1, new i0(this));
            this.u.j(zs8Var);
            this.t.h(zs8Var, this.L0);
            this.t.g(zs8Var);
            this.v.I(this.P0, this.M0, V, this.U1);
            if (this.X0 != null) {
                if (zs8Var.h0()) {
                    this.X0.getView().setVisibility(8);
                } else {
                    this.X0.getView().setVisibility(0);
                    mt8 mt8Var = new mt8(mt8.g);
                    mt8Var.b = zs8Var.g;
                    mt8Var.c = this.c.Y5();
                    mt8Var.e = zs8Var.f;
                    mt8Var.f = zs8Var.M().isQuestionThread();
                    this.X0.h(mt8Var);
                }
            }
            Y3(V);
            Z3(zs8Var);
            jg.a().post(new j0(this));
            this.x.f(this.l);
            if (V.S) {
                this.x.g(V.O());
                PbLandscapeListView pbLandscapeListView = this.l;
                this.x.c(this.l, (pbLandscapeListView == null || pbLandscapeListView.getHeaderViewsCount() <= 1) ? 0 : 0);
            }
            kv8 kv8Var = this.E;
            if (kv8Var != null && kv8Var.z() != null) {
                this.E.z().I(V.S);
            }
            kv8 kv8Var2 = this.E;
            if (kv8Var2 != null) {
                kv8Var2.t0(V.S);
            }
            MaskView maskView = this.I1;
            if (V.S) {
                i5 = 0;
            }
            maskView.setVisibility(i5);
        }
    }

    public void N3(e05.c cVar, boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048631, this, cVar, z2) == null) {
            l05 l05Var = this.f0;
            if (l05Var != null) {
                l05Var.dismiss();
                this.f0 = null;
            }
            n05 n05Var = new n05(this.c.getContext());
            ArrayList arrayList = new ArrayList();
            zs8 zs8Var = this.M0;
            if (zs8Var != null && zs8Var.M() != null && !this.M0.M().isBjh()) {
                arrayList.add(new j05(0, this.c.getPageContext().getString(R.string.save_to_emotion), n05Var));
            }
            if (!z2) {
                arrayList.add(new j05(1, this.c.getPageContext().getString(R.string.save_to_local), n05Var));
            }
            n05Var.k(arrayList);
            n05Var.p(new f0(this, cVar));
            l05 l05Var2 = new l05(this.c.getPageContext(), n05Var);
            this.f0 = l05Var2;
            l05Var2.k();
        }
    }

    public final void R3(c05 c05Var, int i3) {
        PbFragment pbFragment;
        String str;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLI(1048647, this, c05Var, i3) == null) && (pbFragment = this.c) != null && c05Var != null) {
            if (this.y1 == null && this.t != null) {
                this.y1 = new wx5(pbFragment.getPageContext(), this.t.c());
            }
            AntiData p5 = this.c.p5();
            SparseArray<String> sparseArray = new SparseArray<>();
            if (p5 != null && p5.getDelThreadInfoList() != null) {
                List<DeleteThreadInfo> delThreadInfoList = p5.getDelThreadInfoList();
                for (int i4 = 0; i4 < delThreadInfoList.size(); i4++) {
                    if (!TextUtils.isEmpty(delThreadInfoList.get(i4).text_info)) {
                        sparseArray.put(delThreadInfoList.get(i4).text_id, delThreadInfoList.get(i4).text_info);
                    }
                }
            }
            hy4 hy4Var = new hy4();
            hy4Var.j(sparseArray);
            this.y1.B(new String[]{this.c.getString(R.string.delete_thread_reason_1), this.c.getString(R.string.delete_thread_reason_2), this.c.getString(R.string.delete_thread_reason_3), this.c.getString(R.string.delete_thread_reason_4), this.c.getString(R.string.delete_thread_reason_5)});
            this.y1.A(hy4Var);
            if (i3 != 1 && i3 != 2) {
                str = "3";
            } else {
                str = "4";
            }
            this.y1.D(str);
            this.y1.C(new a0(this, c05Var));
        }
    }

    public void W3(ly4 ly4Var, c05.e eVar) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLL(1048667, this, ly4Var, eVar) != null) || ly4Var == null) {
            return;
        }
        int a3 = ly4Var.a();
        int h3 = ly4Var.h();
        c05 c05Var = this.F;
        if (c05Var != null) {
            c05Var.show();
        } else {
            this.F = new c05(this.c.getPageContext().getPageActivity());
            View inflate = LayoutInflater.from(this.c.getPageContext().getPageActivity()).inflate(R.layout.obfuscated_res_0x7f0d0241, (ViewGroup) null);
            this.H = inflate;
            this.F.setContentView(inflate);
            this.F.setPositiveButton(R.string.obfuscated_res_0x7f0f0521, eVar);
            this.F.setNegativeButton(R.string.obfuscated_res_0x7f0f0519, new n0(this));
            this.F.setOnCalcelListener(new o0(this));
            this.F.create(this.c.getPageContext()).show();
        }
        EditText editText = (EditText) this.H.findViewById(R.id.obfuscated_res_0x7f091099);
        this.I = editText;
        editText.setText("");
        TextView textView = (TextView) this.H.findViewById(R.id.obfuscated_res_0x7f0907f1);
        if (a3 <= 0) {
            a3 = 1;
        }
        if (h3 <= 0) {
            h3 = 1;
        }
        textView.setText(MessageFormat.format(TbadkCoreApplication.getInst().getResources().getString(R.string.current_page), Integer.valueOf(a3), Integer.valueOf(h3)));
        this.c.getBaseFragmentActivity().ShowSoftKeyPadDelay(this.I, 150);
    }

    public boolean k4(zs8 zs8Var, boolean z2) {
        InterceptResult invokeLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(1048730, this, zs8Var, z2)) == null) {
            if (zs8Var == null) {
                return false;
            }
            if (this.u != null) {
                if (zs8Var.M() != null && zs8Var.M().getIsNoTitle() == 0 && !zs8Var.M().isVideoThreadType()) {
                    if (zs8Var.M() != null) {
                        ThreadData M = zs8Var.M();
                        M.parserSpecTitleForFrsAndPb(true, D3(zs8Var));
                        M.setResource(3);
                        M.setPbTitle("2");
                    }
                    if (zs8Var.M().isBJHArticleThreadType()) {
                        this.v.B(this.l);
                        this.u.h(this.l);
                        this.u.a(this.l);
                        this.v.n(this.l);
                        this.v.G(this.M0);
                        if (K1(zs8Var)) {
                            this.u.h(this.l);
                        } else {
                            this.u.i(zs8Var);
                        }
                    } else {
                        this.v.G(this.M0);
                        if (K1(zs8Var)) {
                            this.u.h(this.l);
                        } else {
                            this.u.k(zs8Var);
                        }
                    }
                } else if (zs8Var.M().getIsNoTitle() == 1) {
                    if (zs8Var.M() != null) {
                        this.u.h(this.l);
                        this.v.G(this.M0);
                    }
                } else {
                    this.u.h(this.l);
                    this.v.G(this.M0);
                }
            }
            Y3(zs8Var.V());
            Z3(zs8Var);
            this.L0 = z2;
            return false;
        }
        return invokeLZ.booleanValue;
    }

    public final void y3(int i3, SparseArray<Object> sparseArray) {
        PbFragment pbFragment;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeIL(1048790, this, i3, sparseArray) == null) && (pbFragment = this.c) != null && pbFragment.P() != null && this.c.P().u1() != null && this.c.P().u1().n() != null && this.c.P().u1().k() != null && this.c.P().u1().k().getDeletedReasonInfo() != null) {
            if (sparseArray != null) {
                sparseArray.put(R.id.tag_is_block_thread, Boolean.TRUE);
            }
            yx5 yx5Var = new yx5(this.c.P().u1().k().getDeletedReasonInfo().is_grays_cale_forum.intValue(), this.c.P().u1().k().getDeletedReasonInfo().is_boomgrow.intValue(), this.c.P().u1().n().has_forum_rule.intValue());
            yx5Var.i(this.c.P().u1().k().getId(), this.c.P().u1().k().getName());
            yx5Var.h(this.c.P().u1().k().getImage_url());
            yx5Var.j(this.c.P().u1().k().getUser_level());
            J3(sparseArray, i3, yx5Var, this.c.P().u1().T(), true);
        }
    }

    public final void V1() {
        PbFragment pbFragment;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048661, this) == null) && (pbFragment = this.c) != null && pbFragment.P() != null && this.c.P().G != null && this.c.P().G.M() != null && this.c.P().G.M().isQuestionThread()) {
            ThreadData M = this.c.P().G.M();
            String G1 = this.c.P().G1();
            String H1 = this.c.P().H1();
            int i3 = 5;
            if ("question_answer_invite".equals(G1)) {
                i3 = 1;
            } else if ("3".equals(H1)) {
                i3 = 2;
            } else if ("answer_top".equals(G1)) {
                i3 = 3;
            } else if (this.c.P().Z0()) {
                i3 = 4;
            }
            TiebaStatic.log(new StatisticItem("c14924").param("uid", TbadkCoreApplication.getCurrentAccountId()).param("tid", M.getId()).param("fid", M.getFid()).param("obj_source", i3));
        }
    }

    public final void m0() {
        zs8 zs8Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048736, this) == null) && this.z != null && (zs8Var = this.M0) != null && zs8Var.M() != null && !ListUtils.isEmpty(this.M0.M().getThreadRecommendInfoDataList()) && this.M0.M().getThreadRecommendInfoDataList().get(0) != null && this.u.d().getVisibility() == 0) {
            if (this.u.d().getParent() == null) {
                this.z.g(false);
                return;
            }
            int[] iArr = new int[2];
            this.z.b().getLocationInWindow(iArr);
            if (iArr[1] + this.z.b().getHeight() > this.h.i().getBottom()) {
                this.z.i();
                this.z.g(true);
                return;
            }
            this.z.g(false);
        }
    }

    public void q0() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048755, this) == null) && !this.Z1) {
            TiebaStatic.log("c10490");
            this.Z1 = true;
            c05 c05Var = new c05(this.c.getPageContext().getPageActivity());
            SparseArray sparseArray = new SparseArray();
            sparseArray.put(c2, Integer.valueOf(e2));
            c05Var.setTitle(R.string.grade_thread_tips);
            View inflate = LayoutInflater.from(this.c.getPageContext().getPageActivity()).inflate(R.layout.upgrade_success_dialog_content, (ViewGroup) null);
            ((TextView) inflate.findViewById(R.id.function_description_view)).setText(R.string.function_upgrade_to_photo_live_tips);
            ((TextView) inflate.findViewById(R.id.title_view)).setText(R.string.grade_thread_tips);
            c05Var.setContentView(inflate);
            c05Var.setYesButtonTag(sparseArray);
            c05Var.setPositiveButton(R.string.grade_button_tips, this.c);
            c05Var.setNegativeButton(R.string.look_again, new p0(this));
            c05Var.create(this.c.getPageContext()).show();
        }
    }

    public final void v3() {
        PbFragment pbFragment;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048778, this) == null) && (pbFragment = this.c) != null && pbFragment.getActivity() != null) {
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
                int g3 = ii.g(this.c.getActivity(), R.dimen.tbds166);
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

    public SparseArray<Object> X0(zs8 zs8Var, boolean z2, int i3) {
        InterceptResult invokeCommon;
        sl9 V;
        boolean z3;
        px4 px4Var;
        int i4;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048668, this, new Object[]{zs8Var, Boolean.valueOf(z2), Integer.valueOf(i3)})) == null) {
            StringBuilder sb = null;
            if (zs8Var == null || (V = zs8Var.V()) == null) {
                return null;
            }
            String userId = V.q().getUserId();
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
                sparseArray.put(R.id.tag_manage_user_identity, Integer.valueOf(zs8Var.U()));
                sparseArray.put(R.id.tag_should_manage_visible, Boolean.FALSE);
            } else if (i3 == 1) {
                if (V.q() != null) {
                    sparseArray.put(R.id.tag_forbid_user_name, V.q().getUserName());
                    sparseArray.put(R.id.tag_forbid_user_name_show, V.q().getName_show());
                    sparseArray.put(R.id.tag_forbid_user_portrait, V.q().getPortrait());
                    sparseArray.put(R.id.tag_forbid_user_post_id, V.O());
                }
                sparseArray.put(R.id.tag_del_post_id, V.O());
                sparseArray.put(R.id.tag_del_post_type, 0);
                sparseArray.put(R.id.tag_del_post_is_self, Boolean.valueOf(z3));
                sparseArray.put(R.id.tag_manage_user_identity, Integer.valueOf(zs8Var.U()));
                sparseArray.put(R.id.tag_should_manage_visible, Boolean.TRUE);
            }
            if (!z3) {
                List<kz4> o2 = zs8Var.o();
                if (ListUtils.getCount(o2) > 0) {
                    sb = new StringBuilder();
                    for (kz4 kz4Var : o2) {
                        if (kz4Var != null && !StringUtils.isNull(kz4Var.d()) && (px4Var = kz4Var.f) != null && px4Var.a && !px4Var.c && ((i4 = px4Var.b) == 1 || i4 == 2)) {
                            sb.append(hi.cutString(kz4Var.d(), 12));
                            sb.append(this.c.getString(R.string.obfuscated_res_0x7f0f06b5));
                            sb.append("、");
                        }
                    }
                }
                if (sb != null && !StringUtils.isNull(sb.toString())) {
                    sparseArray.put(R.id.tag_del_multi_forum, String.format(this.c.getString(R.string.obfuscated_res_0x7f0f04d1), sb.toString().substring(0, sb.length() - 1)));
                }
            }
            return sparseArray;
        }
        return (SparseArray) invokeCommon.objValue;
    }

    public void a2(int i3) {
        boolean z2;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeI(1048682, this, i3) != null) || this.P0 == i3) {
            return;
        }
        this.P0 = i3;
        a4(this.M0, this.L0);
        F2(this.M0, this.L0, this.O0, i3);
        hv4 layoutMode = this.c.getBaseFragmentActivity().getLayoutMode();
        if (i3 == 4) {
            z2 = true;
        } else {
            z2 = false;
        }
        layoutMode.l(z2);
        this.c.getBaseFragmentActivity().getLayoutMode().k(this.d);
        SkinManager.setBackgroundColor(this.d, R.color.CAM_X0201);
        SkinManager.setBackgroundColor(this.p0, R.color.CAM_X0203);
        rx8 rx8Var = this.w;
        if (rx8Var != null) {
            rx8Var.c(i3);
        }
        qx8 qx8Var = this.t;
        if (qx8Var != null) {
            qx8Var.e(i3);
        }
        sx8 sx8Var = this.u;
        if (sx8Var != null) {
            sx8Var.g(i3);
        }
        ux8 ux8Var = this.v;
        if (ux8Var != null) {
            ux8Var.y(i3);
        }
        tx8 tx8Var = this.x;
        if (tx8Var != null) {
            tx8Var.e();
        }
        px8 px8Var = this.y;
        if (px8Var != null) {
            px8Var.c();
        }
        MaskView maskView = this.I1;
        if (maskView != null) {
            maskView.f();
        }
        uw8 uw8Var = this.r;
        if (uw8Var != null) {
            uw8Var.n();
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
        c05 c05Var = this.F;
        if (c05Var != null) {
            c05Var.autoChangeSkinType(this.c.getPageContext());
        }
        f4(this.h0);
        this.E.a0();
        m09 m09Var = this.J;
        if (m09Var != null) {
            m09Var.H(i3);
        }
        EditorTools editorTools = this.n0;
        if (editorTools != null) {
            editorTools.y(i3);
        }
        h09 h09Var = this.L;
        if (h09Var != null) {
            h09Var.g(i3);
        }
        if (!ListUtils.isEmpty(this.n)) {
            for (CustomBlueCheckRadioButton customBlueCheckRadioButton : this.n) {
                customBlueCheckRadioButton.c();
            }
        }
        l4();
        UtilHelper.setStatusBarBackground(this.e, i3);
        UtilHelper.setStatusBarBackground(this.W0, i3);
        if (this.A != null) {
            zm5.a(this.c.getPageContext(), this.A);
        }
        uv8 uv8Var = this.g1;
        if (uv8Var != null) {
            uv8Var.l(i3);
        }
        zy8 zy8Var = this.h;
        if (zy8Var != null) {
            zy8Var.n(i3);
        }
        LinearLayout linearLayout = this.v0;
        if (linearLayout != null) {
            linearLayout.setBackgroundDrawable(SkinManager.createShapeDrawableFromColor(ii.g(this.c.getContext(), R.dimen.tbds47), SkinManager.getColor(R.color.CAM_X0209)));
        }
        zs8 zs8Var = this.M0;
        if (zs8Var != null && zs8Var.q()) {
            WebPManager.setPureDrawable(this.B0, R.drawable.icon_pure_pb_bottom_collected26_selection, R.color.CAM_X0305, WebPManager.ResourceStateType.NORMAL_PRESS);
        } else {
            WebPManager.setPureDrawable(this.B0, R.drawable.icon_pure_pb_bottom_collect26, R.color.CAM_X0107, WebPManager.ResourceStateType.NORMAL_PRESS);
        }
        WebPManager.setPureDrawable(this.z0, R.drawable.icon_pure_pb_bottom_comment26, R.color.CAM_X0107, WebPManager.ResourceStateType.NORMAL_PRESS);
        WebPManager.setPureDrawable(this.w0, R.drawable.icon_pure_post_expression24, R.color.CAM_X0107, WebPManager.ResourceStateType.NORMAL);
        j4(this.M0);
        if (this.E0.getVisibility() == 0) {
            this.E0.setBackgroundDrawable(SkinManager.createShapeDrawable(ii.g(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds15), R.color.CAM_X0301, 0, 0, i3));
        }
        SkinManager.setBackgroundColor(this.u0, R.color.CAM_X0207);
        SkinManager.setBackgroundColor(this.t0, R.color.CAM_X0203);
        SkinManager.setViewTextColor(this.p1, (int) R.color.cp_cont_n);
        SkinManager.setViewTextColor(this.x0, (int) R.color.CAM_X0109);
        SkinManager.setViewTextColor(this.H0, (int) R.color.CAM_X0107);
        SkinManager.setBackgroundShapeDrawable(this.H0, ii.g(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds18), R.color.CAM_X0207, R.color.CAM_X0207);
        SkinManager.setViewTextColor(this.G0, (int) R.color.CAM_X0107);
        SkinManager.setBackgroundShapeDrawable(this.G0, ii.g(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds18), R.color.CAM_X0207, R.color.CAM_X0207);
        AgreeView agreeView = this.A0;
        if (agreeView != null) {
            agreeView.w();
            this.A0.P(i3);
            AgreeData data = this.A0.getData();
            if (data != null) {
                C2(data, data.agreeNum);
            }
        }
        av8 av8Var = this.s1;
        if (av8Var != null) {
            av8Var.m(i3);
        }
        PbThreadPostView pbThreadPostView = this.o;
        if (pbThreadPostView != null) {
            pbThreadPostView.c(i3);
        }
        l09 l09Var = this.F0;
        if (l09Var != null) {
            l09Var.j();
        }
        k09 k09Var = this.H1;
        if (k09Var != null) {
            k09Var.c();
        }
        RightFloatLayerView rightFloatLayerView = this.K1;
        if (rightFloatLayerView != null) {
            rightFloatLayerView.n();
        }
        SkinManager.setBackgroundColor(this.V0, R.color.CAM_X0207);
        SkinManager.setViewTextColor(this.V0.findViewById(R.id.tv_title), (int) R.color.CAM_X0105);
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

    public void l3(boolean z2, PostWriteCallBackData postWriteCallBackData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZL(1048734, this, z2, postWriteCallBackData) == null) {
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
            RadioGroup.LayoutParams layoutParams = new RadioGroup.LayoutParams(-1, ii.g(pageActivity, R.dimen.obfuscated_res_0x7f07019a));
            customBlueCheckRadioButton.setOnCheckedChangeListener(this.a0);
            customBlueCheckRadioButton.setTag(str);
            customBlueCheckRadioButton.setText(str2);
            customBlueCheckRadioButton.setLayoutParams(layoutParams);
            return customBlueCheckRadioButton;
        }
        return (CustomBlueCheckRadioButton) invokeLL.objValue;
    }

    public void m2(AbsListView absListView, int i3, int i4, int i5) {
        PbReplyTitleViewHolder pbReplyTitleViewHolder;
        int bottom;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLIII(1048738, this, absListView, i3, i4, i5) == null) {
            xv8 xv8Var = this.q;
            if (xv8Var != null) {
                xv8Var.c(i3, i4);
            }
            tw8 tw8Var = this.s;
            if (tw8Var != null) {
                tw8Var.c(i3, i4);
            }
            y2();
            this.b1.a = null;
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004013, this.b1));
            z3(f0(absListView, i3));
            int i6 = 0;
            z2(this.b1.a, false);
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

    public void o2(ArrayList<xx4> arrayList) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048748, this, arrayList) == null) {
            if (this.Y == null) {
                this.Y = LayoutInflater.from(this.c.getPageContext().getPageActivity()).inflate(R.layout.commit_good, (ViewGroup) null);
            }
            this.c.getBaseFragmentActivity().getLayoutMode().k(this.Y);
            if (this.X == null) {
                Dialog dialog = new Dialog(this.c.getPageContext().getPageActivity(), R.style.obfuscated_res_0x7f1003b0);
                this.X = dialog;
                dialog.setCanceledOnTouchOutside(true);
                this.X.setCancelable(true);
                this.m0 = (ScrollView) this.Y.findViewById(R.id.good_scroll);
                this.X.setContentView(this.Y);
                WindowManager.LayoutParams attributes = this.X.getWindow().getAttributes();
                attributes.width = ii.g(TbadkCoreApplication.getInst(), R.dimen.obfuscated_res_0x7f0702dc);
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
                    xx4 xx4Var = arrayList.get(i3);
                    if (xx4Var != null && !TextUtils.isEmpty(xx4Var.b()) && xx4Var.a() > 0) {
                        CustomBlueCheckRadioButton p03 = p0(String.valueOf(xx4Var.a()), xx4Var.b());
                        this.n.add(p03);
                        View view2 = new View(this.c.getPageContext().getPageActivity());
                        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, ii.g(TbadkCoreApplication.getInst(), R.dimen.obfuscated_res_0x7f070198));
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
                        layoutParams2.height = ii.d(this.c.getPageContext().getPageActivity(), 220.0f);
                    } else {
                        layoutParams2.height = ii.d(this.c.getPageContext().getPageActivity(), 186.0f);
                    }
                } else {
                    layoutParams2.height = ii.d(this.c.getPageContext().getPageActivity(), 120.0f);
                }
                this.m0.setLayoutParams(layoutParams2);
                this.m0.removeAllViews();
                LinearLayout linearLayout = this.Z;
                if (linearLayout != null && linearLayout.getParent() == null) {
                    this.m0.addView(this.Z);
                }
            }
            lg.j(this.X, this.c.getPageContext());
        }
    }

    public void q2(int i3, String str, int i4, boolean z2, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048757, this, new Object[]{Integer.valueOf(i3), str, Integer.valueOf(i4), Boolean.valueOf(z2), str2}) == null) {
            r2(i3, str, i4, z2, str2, false);
        }
    }

    public void r2(int i3, String str, int i4, boolean z2, String str2, boolean z3) {
        int i5;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048761, this, new Object[]{Integer.valueOf(i3), str, Integer.valueOf(i4), Boolean.valueOf(z2), str2, Boolean.valueOf(z3)}) == null) {
            SparseArray<Object> sparseArray = new SparseArray<>();
            sparseArray.put(R.id.tag_del_post_id, str);
            sparseArray.put(R.id.tag_del_post_type, Integer.valueOf(i3));
            sparseArray.put(R.id.tag_manage_user_identity, Integer.valueOf(i4));
            sparseArray.put(R.id.tag_del_post_is_self, Boolean.valueOf(z2));
            sparseArray.put(c2, Integer.valueOf(d2));
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
            this.V = new c05(this.c.getActivity());
            if (StringUtils.isNull(str2)) {
                this.V.setMessageId(i5);
            } else {
                this.V.setOnlyMessageShowCenter(false);
                this.V.setMessage(str2);
            }
            this.V.setYesButtonTag(sparseArray);
            this.V.setPositiveButton(R.string.obfuscated_res_0x7f0f0521, this.c);
            this.V.setNegativeButton(R.string.obfuscated_res_0x7f0f0519, new v(this));
            this.V.setCancelable(true);
            this.V.create(this.c.getPageContext());
            if (z3) {
                C3(sparseArray, i6, i5);
            } else if (z2) {
                C3(sparseArray, i6, i5);
            } else if (u3()) {
                yx5 yx5Var = new yx5(this.c.P().u1().k().getDeletedReasonInfo().is_grays_cale_forum.intValue(), this.c.P().u1().k().getDeletedReasonInfo().is_boomgrow.intValue(), this.c.P().u1().n().has_forum_rule.intValue());
                yx5Var.i(this.c.P().u1().k().getId(), this.c.P().u1().k().getName());
                yx5Var.h(this.c.P().u1().k().getImage_url());
                yx5Var.j(this.c.P().u1().k().getUser_level());
                J3(sparseArray, i3, yx5Var, this.c.P().u1().T(), false);
            } else {
                R3(this.V, i3);
            }
        }
    }

    public void t2(SparseArray<Object> sparseArray, boolean z2) {
        int i3;
        j05 j05Var;
        j05 j05Var2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048769, this, sparseArray, z2) == null) {
            n05 n05Var = new n05(this.c.getContext());
            n05Var.s(this.c.getString(R.string.obfuscated_res_0x7f0f02f1));
            n05Var.p(new u(this, z2));
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
                    j05Var2 = new j05(10, this.c.getString(R.string.obfuscated_res_0x7f0f04e6), n05Var);
                } else {
                    j05Var2 = new j05(10, this.c.getString(R.string.obfuscated_res_0x7f0f04d9), n05Var);
                }
                SparseArray sparseArray2 = new SparseArray();
                sparseArray2.put(R.id.tag_del_post_id, sparseArray.get(R.id.tag_del_post_id));
                sparseArray2.put(R.id.tag_del_post_type, sparseArray.get(R.id.tag_del_post_type));
                sparseArray2.put(R.id.tag_del_post_is_self, sparseArray.get(R.id.tag_del_post_is_self));
                sparseArray2.put(R.id.tag_manage_user_identity, sparseArray.get(R.id.tag_manage_user_identity));
                j05Var2.d.setTag(sparseArray2);
                arrayList.add(j05Var2);
            }
            if ((sparseArray.get(R.id.tag_mul_del_post_type) instanceof Boolean) && ((Boolean) sparseArray.get(R.id.tag_mul_del_post_type)).booleanValue()) {
                j05 j05Var3 = new j05(13, this.c.getString(R.string.multi_delete), n05Var);
                SparseArray sparseArray3 = new SparseArray();
                sparseArray3.put(R.id.tag_del_post_id, sparseArray.get(R.id.tag_del_post_id));
                sparseArray3.put(R.id.tag_del_post_type, sparseArray.get(R.id.tag_del_post_type));
                sparseArray3.put(R.id.tag_del_post_is_self, sparseArray.get(R.id.tag_del_post_is_self));
                sparseArray3.put(R.id.tag_manage_user_identity, sparseArray.get(R.id.tag_manage_user_identity));
                j05Var3.d.setTag(sparseArray3);
                arrayList.add(j05Var3);
            }
            if (!"".equals(sparseArray.get(R.id.tag_forbid_user_name)) || !"".equals(sparseArray.get(R.id.tag_forbid_user_name_show))) {
                SparseArray sparseArray4 = new SparseArray();
                sparseArray4.put(R.id.tag_forbid_user_name, sparseArray.get(R.id.tag_forbid_user_name));
                sparseArray4.put(R.id.tag_forbid_user_name_show, sparseArray.get(R.id.tag_forbid_user_name_show));
                sparseArray4.put(R.id.tag_forbid_user_portrait, sparseArray.get(R.id.tag_forbid_user_portrait));
                sparseArray4.put(R.id.tag_manage_user_identity, sparseArray.get(R.id.tag_manage_user_identity));
                sparseArray4.put(R.id.tag_forbid_user_post_id, sparseArray.get(R.id.tag_forbid_user_post_id));
                j05 j05Var4 = new j05(11, this.c.getString(R.string.forbidden_person), n05Var);
                j05Var4.d.setTag(sparseArray4);
                arrayList.add(j05Var4);
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
                    j05Var = new j05(12, this.c.getString(R.string.un_mute), n05Var);
                } else {
                    j05Var = new j05(12, this.c.getString(R.string.obfuscated_res_0x7f0f0bf8), n05Var);
                }
                j05Var.d.setTag(sparseArray5);
                arrayList.add(j05Var);
            }
            ry8.f(arrayList);
            n05Var.l(arrayList, !UbsABTestHelper.isPBPlanA());
            l05 l05Var = new l05(this.c.getPageContext(), n05Var);
            this.T = l05Var;
            l05Var.k();
        }
    }

    public final void z2(PbReplyTitleViewHolder pbReplyTitleViewHolder, boolean z2) {
        boolean z3;
        int measuredHeight;
        int i3;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLZ(1048793, this, pbReplyTitleViewHolder, z2) == null) && !this.j1 && this.U0 != null && this.h.i() != null) {
            View s2 = G0().s();
            if (s2 != null) {
                int[] iArr = new int[2];
                s2.getLocationInWindow(iArr);
                int i4 = iArr[1];
                if (i4 != 0) {
                    if (this.U0.getVisibility() == 0 && i4 - this.h.i().getBottom() <= this.U0.getHeight()) {
                        this.V0.setVisibility(0);
                        if (i4 > this.h.i().getBottom()) {
                            i3 = -(((this.U0.getHeight() + this.V0.getHeight()) + this.h.i().getBottom()) - s2.getBottom());
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
            int G = this.E.G();
            if (G > 0 && (pbReplyTitleViewHolder == null || pbReplyTitleViewHolder.getView().getParent() == null)) {
                PbLandscapeListView pbLandscapeListView = this.l;
                if (pbLandscapeListView != null && G > pbLandscapeListView.getFirstVisiblePosition() - this.l.getHeaderViewsCount()) {
                    this.U0.setVisibility(4);
                    return;
                }
                this.U0.setVisibility(0);
                z3(false);
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
                    measuredHeight = a2 - pbReplyTitleViewHolder.g.getMeasuredHeight();
                } else {
                    measuredHeight = this.h.i().getMeasuredHeight() - pbReplyTitleViewHolder.g.getMeasuredHeight();
                    this.h.a.hideBottomLine();
                }
                if (pbReplyTitleViewHolder.getView().getParent() == null && top <= this.Z0) {
                    this.U0.setVisibility(0);
                    z3(false);
                } else if (top < measuredHeight) {
                    this.U0.setVisibility(0);
                    z3(false);
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
}
