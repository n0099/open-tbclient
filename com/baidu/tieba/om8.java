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
import com.baidu.tieba.b05;
import com.baidu.tieba.dn8;
import com.baidu.tieba.jm8;
import com.baidu.tieba.k05;
import com.baidu.tieba.kj8;
import com.baidu.tieba.kl8;
import com.baidu.tieba.mb9;
import com.baidu.tieba.mh8;
import com.baidu.tieba.pb.ejection.EjectionAnimationView;
import com.baidu.tieba.pb.pb.main.PbFragment;
import com.baidu.tieba.pb.pb.main.PbLandscapeListView;
import com.baidu.tieba.pb.pb.main.PbModel;
import com.baidu.tieba.pb.pb.main.PbReplyTitleViewHolder;
import com.baidu.tieba.pb.pb.main.controller.PbContentCollectionController;
import com.baidu.tieba.pb.pb.main.emotion.view.PbEmotionBar;
import com.baidu.tieba.pb.pb.main.view.CustomBlueCheckRadioButton;
import com.baidu.tieba.pb.pb.main.view.PbFakeFloorModel;
import com.baidu.tieba.pb.pb.main.view.PbThreadPostView;
import com.baidu.tieba.pb.pb.main.view.PbTopTipView;
import com.baidu.tieba.pb.view.PbFallingView;
import com.baidu.tieba.pb.view.PbInterviewStatusView;
import com.baidu.tieba.qw5;
import com.baidu.tieba.tbadkCore.data.AgreeData;
import com.baidu.tieba.tbadkCore.util.AntiHelper;
import com.baidu.tieba.tbadkCore.writeModel.PostWriteCallBackData;
import com.baidu.tieba.tw5;
import com.baidu.tieba.v35;
import com.baidu.tieba.view.NavigationBarCoverTip;
import com.baidu.tieba.view.SortSwitchButton;
import com.baidu.tieba.view.WaterRippleView;
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
import java.util.List;
import org.json.JSONArray;
import tbclient.ItemInfo;
@SuppressLint({"ResourceAsColor"})
/* loaded from: classes5.dex */
public class om8 {
    public static /* synthetic */ Interceptable $ic;
    public static final int n2;
    public static int o2;
    public static int p2;
    public static int q2;
    public static int r2;
    public static int s2;
    public static int t2;
    public static final int u2;
    public static int v2;
    public static mb9.f w2;
    public transient /* synthetic */ FieldHolder $fh;
    public PbContentCollectionController A;
    public WaterRippleView A0;
    public boolean A1;
    public LinearLayout B;
    public ImageView B0;
    public boolean B1;
    public TextView C;
    public AgreeView C0;
    public xl8 C1;
    public TextView D;
    public ImageView D0;
    public NavigationBarCoverTip D1;
    public ObservedChangeRelativeLayout E;
    public ImageView E0;
    public qw5 E1;
    public vk8 F;
    public HeadImageView F0;
    public tw5 F1;
    public zz4 G;
    public View G0;
    public String G1;
    public b05 H;
    public vq8 H0;
    public PermissionJudgePolicy H1;
    public View I;
    public TextView I0;
    public long I1;
    public EditText J;
    public TextView J0;
    public boolean J1;
    public wq8 K;
    public TextView K0;
    public int K1;
    public PbListView L;
    public boolean L0;
    public int L1;
    public rq8 M;
    public int M0;
    public boolean M1;
    public View N;
    public p35 N0;
    public boolean N1;
    public View O;
    public boolean O0;
    public uq8 O1;
    public View P;
    public ki8 P0;
    public MaskView P1;
    public View.OnClickListener Q;
    public bc9 Q0;
    public final PbFallingView Q1;
    public SortSwitchButton.f R;
    public int R0;
    public RightFloatLayerView R1;
    public TbRichTextView.a0 S;
    public int S0;
    public final FrameLayout S1;
    public NoNetworkView.b T;
    public boolean T0;
    public CustomMessageListener T1;
    public i05 U;
    public ViewStub U0;
    public boolean U1;
    public View.OnClickListener V;
    public PbInterviewStatusView V0;
    public String V1;
    public zz4 W;
    public FrameLayout W0;
    public CustomMessageListener W1;
    public Dialog X;
    public TextView X0;
    public View.OnClickListener X1;
    public Dialog Y;
    public View Y0;
    public CustomMessageListener Y1;
    public View Z;
    public View Z0;
    public Handler Z1;
    public final ViewTreeObserver.OnGlobalLayoutListener a;
    public LinearLayout a0;
    public View a1;
    public Runnable a2;
    public int b;
    public CompoundButton.OnCheckedChangeListener b0;
    public PbReplyTitleViewHolder b1;
    public CustomMessageListener b2;
    public PbFragment c;
    public TextView c0;
    public View c1;
    public PbFragment.h3 c2;
    public RelativeLayout d;
    public TextView d0;
    public int d1;
    public boolean d2;
    public View e;
    public String e0;
    public boolean e1;
    public View.OnClickListener e2;
    public int f;
    public i05 f0;
    public a1 f1;
    public boolean f2;
    public final Handler g;
    public i05 g0;
    public PbEmotionBar g1;
    public String g2;
    public final ro8 h;
    public d05 h0;
    public int h1;
    public v35.g h2;
    public qo8 i;
    public boolean i0;
    public int i1;
    public View.OnClickListener i2;
    public ViewStub j;
    public boolean j0;
    public Runnable j1;
    public final List<TbImageView> j2;
    public ViewStub k;
    public String k0;
    public PbFakeFloorModel k1;
    public int k2;
    public PbLandscapeListView l;
    public String l0;
    public hl8 l1;
    public boolean l2;
    public NoNetworkView m;
    public mj8 m0;
    public gm8 m1;
    public boolean m2;
    public List<CustomBlueCheckRadioButton> n;
    public ScrollView n0;
    public boolean n1;
    public PbThreadPostView o;
    public EditorTools o0;
    public int o1;
    public ll8 p;
    public boolean p0;
    public boolean p1;
    public kl8 q;
    public View q0;
    public boolean q1;
    public km8 r;
    public View r0;
    public boolean r1;
    public jm8 s;
    public EjectionAnimationView s0;
    public int s1;
    public jn8 t;
    public Button t0;
    public PbTopTipView t1;
    public en8 u;
    public View u0;
    public PopupWindow u1;
    public gn8 v;
    public View v0;
    public TextView v1;
    public in8 w;
    public LinearLayout w0;
    public List<String> w1;
    public fn8 x;
    public HeadImageView x0;
    public on8 x1;
    public hn8 y;
    public ImageView y0;
    public kk8 y1;
    public dn8 z;
    public TextView z0;
    public PbLandscapeListView.c z1;

    public boolean T1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048655, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    public final void T2(boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048656, this, z2) == null) {
        }
    }

    public int n1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048742, this)) == null) ? R.id.obfuscated_res_0x7f091dc7 : invokeV.intValue;
    }

    public void o3(PbFragment.i3 i3Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048749, this, i3Var) == null) {
        }
    }

    /* loaded from: classes5.dex */
    public class c implements AgreeView.i {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ om8 a;

        /* loaded from: classes5.dex */
        public class a implements ib5 {
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

            @Override // com.baidu.tieba.ib5
            public void a(List<Bitmap> list) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, list) == null) {
                    this.a.a.s0.setVisibility(0);
                    this.a.a.s0.setBitmaps(list);
                    Rect rect = new Rect();
                    this.a.a.C0.getImgAgree().getGlobalVisibleRect(rect);
                    this.a.a.s0.setAnchorPosition((rect.right + rect.left) / 2, (rect.bottom + rect.top) / 2);
                    this.a.a.s0.k();
                }
            }
        }

        public c(om8 om8Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {om8Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = om8Var;
        }

        @Override // com.baidu.tbadk.core.view.AgreeView.i
        public void onLongPress() {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeV(1048576, this) != null) {
                return;
            }
            this.a.H3();
            kb5.g().c(new a(this));
        }

        @Override // com.baidu.tbadk.core.view.AgreeView.i
        public void onRelease() {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) != null) {
                return;
            }
            this.a.Q2();
            this.a.s0.l();
        }
    }

    /* loaded from: classes5.dex */
    public class j implements kl8.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ om8 a;

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

        public j(om8 om8Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {om8Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = om8Var;
        }

        @Override // com.baidu.tieba.kl8.a
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
        public final /* synthetic */ om8 g;

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
                if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && this.a.g.c1 != null && this.a.g.c1.getLayoutParams() != null) {
                    ViewGroup.LayoutParams layoutParams = this.a.g.c1.getLayoutParams();
                    layoutParams.height = this.a.g.i1;
                    this.a.g.c1.setLayoutParams(layoutParams);
                }
            }
        }

        public l(om8 om8Var, int i, PbReplyTitleViewHolder pbReplyTitleViewHolder, boolean z, int i2, int i3, int i4) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {om8Var, Integer.valueOf(i), pbReplyTitleViewHolder, Boolean.valueOf(z), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i5 = newInitContext.flag;
                if ((i5 & 1) != 0) {
                    int i6 = i5 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.g = om8Var;
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
                    int m1 = this.g.m1(this.b);
                    int i3 = this.a;
                    int i4 = m1 - i3;
                    if (this.c && i4 != 0 && i3 <= (i = this.d)) {
                        i4 = m1 - i;
                    }
                    if (this.g.c1 == null || (layoutParams = this.g.c1.getLayoutParams()) == null) {
                        return;
                    }
                    if (i4 != 0 && i4 <= this.g.d.getMeasuredHeight() && m1 < this.g.d.getMeasuredHeight()) {
                        if (layoutParams != null) {
                            int i5 = layoutParams.height;
                            if (i5 + i4 > 0 && i5 + i4 <= this.g.d.getMeasuredHeight()) {
                                layoutParams.height += i4;
                                if (this.g.l != null) {
                                    this.g.l.setSelectionFromTop(this.e, this.f);
                                }
                            }
                        }
                        layoutParams.height = this.g.i1;
                    } else {
                        layoutParams.height = this.g.i1;
                    }
                    this.g.c1.setLayoutParams(layoutParams);
                    jg.a().post(new a(this));
                }
                if (this.g.l != null) {
                    this.g.l.setOnLayoutListener(null);
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class m implements jm8.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ om8 a;

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

        public m(om8 om8Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {om8Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = om8Var;
        }

        @Override // com.baidu.tieba.jm8.a
        public void a() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && !this.a.c.D6() && this.a.l != null) {
                this.a.l.post(new a(this));
            }
        }
    }

    /* loaded from: classes5.dex */
    public class p0 implements DialogInterface.OnCancelListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ om8 a;

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

        public p0(om8 om8Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {om8Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = om8Var;
        }

        @Override // android.content.DialogInterface.OnCancelListener
        public void onCancel(DialogInterface dialogInterface) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, dialogInterface) == null) {
                if (this.a.j1 == null) {
                    this.a.j1 = new a(this);
                }
                jg.a().postDelayed(this.a.j1, 150L);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ om8 a;

        public a(om8 om8Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {om8Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = om8Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                this.a.r2();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class a0 implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ AlertDialog a;

        public a0(om8 om8Var, AlertDialog alertDialog) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {om8Var, alertDialog};
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
    public class b implements jj8 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ om8 a;

        @Override // com.baidu.tieba.jj8
        public /* synthetic */ void onStart() {
            ij8.a(this);
        }

        public b(om8 om8Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {om8Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = om8Var;
        }

        @Override // com.baidu.tieba.jj8
        public void onStop() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                this.a.s0.setVisibility(8);
                FirstPraiseToast.getInstance().show();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class b0 implements qw5.h {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ zz4 a;
        public final /* synthetic */ om8 b;

        public b0(om8 om8Var, zz4 zz4Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {om8Var, zz4Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = om8Var;
            this.a = zz4Var;
        }

        @Override // com.baidu.tieba.qw5.h
        public void a(JSONArray jSONArray) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, jSONArray) == null) {
                this.b.c.n5(this.a, jSONArray);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class c0 implements tw5.i {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ SparseArray a;
        public final /* synthetic */ om8 b;

        public c0(om8 om8Var, SparseArray sparseArray) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {om8Var, sparseArray};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = om8Var;
            this.a = sparseArray;
        }

        @Override // com.baidu.tieba.tw5.i
        public void a(JSONArray jSONArray) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, jSONArray) == null) {
                this.b.c.m5(this.a, jSONArray);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class d implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ om8 a;

        public d(om8 om8Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {om8Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = om8Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, view2) == null) && this.a.C0 != null && this.a.C0.getData() != null) {
                om8 om8Var = this.a;
                om8Var.K2(om8Var.C0.getData(), this.a.C0.getData().agreeNum);
                if (!this.a.C0.J()) {
                    om8 om8Var2 = this.a;
                    om8Var2.D2(om8Var2.C0);
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class d0 implements CompoundButton.OnCheckedChangeListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ om8 a;

        public d0(om8 om8Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {om8Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = om8Var;
        }

        @Override // android.widget.CompoundButton.OnCheckedChangeListener
        public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLZ(1048576, this, compoundButton, z) == null) && z) {
                this.a.e0 = (String) compoundButton.getTag();
                if (this.a.n != null) {
                    for (CustomBlueCheckRadioButton customBlueCheckRadioButton : this.a.n) {
                        String str = (String) customBlueCheckRadioButton.getTag();
                        if (str != null && this.a.e0 != null && !str.equals(this.a.e0)) {
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
        public final /* synthetic */ om8 a;

        public e(om8 om8Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {om8Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = om8Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                if (this.a.G0.getVisibility() == 0) {
                    if (this.a.c != null && this.a.c.E1()) {
                        return;
                    }
                    m35.m().w("pb_share_red_dot_shown", true);
                    this.a.G0.setVisibility(8);
                }
                this.a.Q.onClick(view2);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class e0 implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ om8 a;

        public e0(om8 om8Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {om8Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = om8Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, view2) == null) && (this.a.Y instanceof Dialog)) {
                lg.b(this.a.Y, this.a.c.getPageContext());
            }
        }
    }

    /* loaded from: classes5.dex */
    public class f implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ om8 a;

        public f(om8 om8Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {om8Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = om8Var;
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
                    this.a.c.d5(sparseArray);
                    return;
                }
                this.a.C2(view2);
            } else if (z2) {
                sparseArray.put(R.id.tag_from, 0);
                sparseArray.put(R.id.tag_check_mute_from, 1);
                this.a.c.d5(sparseArray);
            } else if (z3) {
                this.a.x2(((Integer) sparseArray.get(R.id.tag_del_post_type)).intValue(), (String) sparseArray.get(R.id.tag_del_post_id), ((Integer) sparseArray.get(R.id.tag_manage_user_identity)).intValue(), ((Boolean) sparseArray.get(R.id.tag_del_post_is_self)).booleanValue());
            }
        }
    }

    /* loaded from: classes5.dex */
    public class f0 implements k05.f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ b05.c a;
        public final /* synthetic */ om8 b;

        public f0(om8 om8Var, b05.c cVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {om8Var, cVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = om8Var;
            this.a = cVar;
        }

        @Override // com.baidu.tieba.k05.f
        public void M0(k05 k05Var, int i, View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIL(1048576, this, k05Var, i, view2) == null) {
                this.b.g0.dismiss();
                this.a.a(null, i, view2);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class g implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ om8 a;

        public g(om8 om8Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {om8Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = om8Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                this.a.U2();
            }
        }
    }

    /* loaded from: classes5.dex */
    public static class g0 implements mb9.f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        @Override // com.baidu.tieba.mb9.f
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
        public final /* synthetic */ om8 a;

        public h(om8 om8Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {om8Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = om8Var;
        }

        @Override // com.baidu.tieba.pb.pb.main.view.PbFakeFloorModel.b
        public void a(bc9 bc9Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, bc9Var) == null) {
                this.a.k1.i0(bc9Var);
                this.a.F.Z();
                this.a.l1.g();
                this.a.o0.s();
                this.a.N3(false);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class h0 implements k05.f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ b05.c a;
        public final /* synthetic */ om8 b;

        public h0(om8 om8Var, b05.c cVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {om8Var, cVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = om8Var;
            this.a = cVar;
        }

        @Override // com.baidu.tieba.k05.f
        public void M0(k05 k05Var, int i, View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIL(1048576, this, k05Var, i, view2) == null) {
                this.b.g0.dismiss();
                this.a.a(null, i, view2);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class i implements PbFallingView.r {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ om8 a;

        public i(om8 om8Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {om8Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = om8Var;
        }

        @Override // com.baidu.tieba.pb.view.PbFallingView.r
        public void onAnimationEnd() {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeV(1048576, this) != null) {
                return;
            }
            this.a.h4();
        }

        @Override // com.baidu.tieba.pb.view.PbFallingView.r
        public void onAnimationStart() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                this.a.Q1.setTag(Boolean.FALSE);
                if (this.a.R1 == null) {
                    return;
                }
                this.a.R1.setAutoCompleteShown(false);
                if (this.a.R1.getVisibility() == 0) {
                    this.a.R1.setTag(this.a.Q1);
                    this.a.R1.c();
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class i0 implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ om8 a;

        public i0(om8 om8Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {om8Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = om8Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            long j;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                if ((view2 instanceof HeadImageView) && this.a.P0 != null && this.a.P0.Q() != null && this.a.P0.Q().getAuthor() != null && this.a.P0.Q().getAuthor().getAlaInfo() != null && this.a.P0.Q().getAuthor().getAlaInfo().live_status == 1) {
                    StatisticItem statisticItem = new StatisticItem("c11851");
                    statisticItem.param("uid", TbadkCoreApplication.getCurrentAccount());
                    TiebaStatic.log(statisticItem);
                    StatisticItem statisticItem2 = new StatisticItem("c13715");
                    statisticItem2.param("fid", this.a.P0.m());
                    statisticItem2.param("fname", this.a.P0.n());
                    if (this.a.P0.Q().getAuthor().getAlaInfo().user_info != null) {
                        j = this.a.P0.Q().getAuthor().getAlaInfo().user_info.user_id;
                    } else {
                        j = 0;
                    }
                    statisticItem2.param("obj_param1", j);
                    statisticItem2.param("uid", TbadkCoreApplication.getCurrentAccount());
                    statisticItem2.param("tid", this.a.P0.S());
                    statisticItem2.param(TiebaStatic.Params.OBJ_PARAM2, 1);
                    statisticItem2.param(TiebaStatic.Params.OBJ_PARAM4, YYLiveUtil.calculateLiveType(this.a.P0.Q().getAuthor().getAlaInfo()));
                    if (this.a.P0.Q().getAuthor().getAlaInfo().mYyExtData != null) {
                        statisticItem2.param(TiebaStatic.Params.OBJ_PARAM3, TiebaStatic.YYValues.YY_LIVE);
                        TiebaStaticHelper.addYYParam(statisticItem2, this.a.P0.Q().getAuthor().getAlaInfo().mYyExtData);
                    }
                    TiebaStatic.log(statisticItem2);
                    if (this.a.P0.Q().getAuthor().getAlaInfo().isLegalYYLiveData()) {
                        YYLiveUtil.jumpYYLiveRoom(this.a.c.getPageContext(), this.a.P0.Q().getAuthor().getAlaInfo(), YYLiveUtil.SOURCE_PB_LIVE_HEAD);
                        return;
                    }
                    return;
                }
                if (this.a.p1) {
                    TiebaStatic.log(new StatisticItem("c11923").param("obj_id", 2));
                }
                if (!this.a.p1 && this.a.P0 != null && this.a.P0.Q() != null && this.a.P0.Q().getAuthor() != null && this.a.P0.Q().getAuthor().isBigV()) {
                    TiebaStatic.log(new StatisticItem("c12151").param("obj_locate", 1));
                }
                if (this.a.c.M() != null) {
                    this.a.c.M().d.b.onClick(view2);
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class j0 implements dn8.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ om8 a;

        public j0(om8 om8Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {om8Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = om8Var;
        }

        @Override // com.baidu.tieba.dn8.a
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
        public final /* synthetic */ om8 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public k(om8 om8Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {om8Var, Integer.valueOf(i)};
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
            this.a = om8Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && customResponsedMessage.getCmd() == 2921757) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004013, this.a.f1));
            }
        }
    }

    /* loaded from: classes5.dex */
    public class k0 implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ om8 a;

        public k0(om8 om8Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {om8Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = om8Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            om8 om8Var;
            ro8 ro8Var;
            LinearLayout linearLayout;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && this.a.F != null && (ro8Var = (om8Var = this.a).h) != null && ro8Var.i != null && om8Var.P0 != null && this.a.P0.Q() != null && !this.a.P0.Q().isVideoThreadType() && !this.a.Y1() && this.a.P0.l() != null && !gi.isEmpty(this.a.P0.l().getName())) {
                if ((this.a.F.I() == null || !this.a.F.I().isShown()) && (linearLayout = this.a.h.i) != null) {
                    linearLayout.setVisibility(0);
                    this.a.h.m();
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class l0 implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;
        public final /* synthetic */ om8 b;

        public l0(om8 om8Var, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {om8Var, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = om8Var;
            this.a = str;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                if (hi.F()) {
                    UrlManager.getInstance().dealOneLink(this.b.c.getPageContext(), new String[]{this.a});
                    this.b.c.finish();
                    return;
                }
                this.b.c.showToast(R.string.obfuscated_res_0x7f0f0d1f);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class m0 implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ Parcelable a;
        public final /* synthetic */ ArrayList b;
        public final /* synthetic */ ki8 c;
        public final /* synthetic */ om8 d;

        public m0(om8 om8Var, Parcelable parcelable, ArrayList arrayList, ki8 ki8Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {om8Var, parcelable, arrayList, ki8Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.d = om8Var;
            this.a = parcelable;
            this.b = arrayList;
            this.c = ki8Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.d.l.onRestoreInstanceState(this.a);
                if (ListUtils.getCount(this.b) > 1 && this.c.z().b() > 0) {
                    this.d.L.g();
                    this.d.L.F(TbadkApplication.getInst().getString(R.string.obfuscated_res_0x7f0f0ec3));
                    this.d.L.A();
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class n implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ om8 a;

        public n(om8 om8Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {om8Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = om8Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                if (this.a.G0.getVisibility() == 0) {
                    m35.m().w("pb_share_red_dot_shown", true);
                    this.a.G0.setVisibility(8);
                }
                this.a.Q.onClick(this.a.E0);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class n0 implements PbLandscapeListView.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ om8 a;

        public n0(om8 om8Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {om8Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = om8Var;
        }

        @Override // com.baidu.tieba.pb.pb.main.PbLandscapeListView.c
        public void a(int i, int i2, float f, float f2, float f3, float f4) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Integer.valueOf(i), Integer.valueOf(i2), Float.valueOf(f), Float.valueOf(f2), Float.valueOf(f3), Float.valueOf(f4)}) == null) && this.a.c != null && this.a.c.isAdded()) {
                if (i < 0 && f > this.a.s1) {
                    this.a.v0();
                    this.a.n2();
                }
                this.a.E0();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class o implements mh8.d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ om8 a;

        public o(om8 om8Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {om8Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = om8Var;
        }

        @Override // com.baidu.tieba.mh8.d
        public void onFinish() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.C0.W();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class o0 implements zz4.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ om8 a;

        public o0(om8 om8Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {om8Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = om8Var;
        }

        @Override // com.baidu.tieba.zz4.e
        public void onClick(zz4 zz4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, zz4Var) == null) {
                this.a.v0();
                zz4Var.dismiss();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class p extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ om8 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public p(om8 om8Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {om8Var, Integer.valueOf(i)};
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
            this.a = om8Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && customResponsedMessage.getCmd() == 2005016 && this.a.F != null) {
                this.a.F.Z();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class q implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ om8 a;

        public q(om8 om8Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {om8Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = om8Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (this.a.B == null) {
                    this.a.I1();
                }
                this.a.k.setVisibility(0);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class q0 implements zz4.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public q0(om8 om8Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {om8Var};
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

    /* loaded from: classes5.dex */
    public class r extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ om8 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public r(om8 om8Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {om8Var, Integer.valueOf(i)};
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
            this.a = om8Var;
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

    /* loaded from: classes5.dex */
    public class r0 implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ k65 a;
        public final /* synthetic */ om8 b;

        public r0(om8 om8Var, k65 k65Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {om8Var, k65Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = om8Var;
            this.a = k65Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, view2) == null) && this.a != null && this.b.P0 != null && this.b.R1 != null) {
                this.b.R1.g(this.a);
                this.b.R1.setAutoCompleteShown(false);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class s implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ om8 a;

        public s(om8 om8Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {om8Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = om8Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                this.a.U2();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class s0 implements zz4.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public s0(om8 om8Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {om8Var};
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

    /* loaded from: classes5.dex */
    public class t implements mb5 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ om8 a;

        public t(om8 om8Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {om8Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = om8Var;
        }

        @Override // com.baidu.tieba.mb5
        public void C(lb5 lb5Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, lb5Var) == null) {
                Object obj = lb5Var.c;
                if ((obj instanceof b75) && EmotionGroupType.isSendAsPic(((b75) obj).getType())) {
                    if (this.a.H1 == null) {
                        this.a.H1 = new PermissionJudgePolicy();
                    }
                    this.a.H1.clearRequestPermissionList();
                    this.a.H1.appendRequestPermission(this.a.c.getBaseFragmentActivity(), "android.permission.WRITE_EXTERNAL_STORAGE");
                    if (this.a.H1.startRequestPermission(this.a.c.getBaseFragmentActivity())) {
                        return;
                    }
                    b75 b75Var = (b75) lb5Var.c;
                    this.a.c.J5().f(b75Var);
                    if (b75Var.i()) {
                        this.a.c.J5().G(null, null);
                    } else {
                        this.a.c.J5().w(false, null);
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
        public final /* synthetic */ om8 e;

        public t0(om8 om8Var, int i, int i2, int i3, View view2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {om8Var, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), view2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i4 = newInitContext.flag;
                if ((i4 & 1) != 0) {
                    int i5 = i4 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.e = om8Var;
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
                    this.e.u1.showAsDropDown(this.e.v0, this.d.getLeft(), -this.e.v0.getHeight());
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class u implements TextWatcher {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ om8 a;

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIII(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, charSequence, i, i2, i3) == null) {
            }
        }

        public u(om8 om8Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {om8Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = om8Var;
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, editable) == null) && this.a.c.K0 != null && this.a.c.K0.e() != null) {
                if (!this.a.c.K0.e().e()) {
                    this.a.c.K0.a(false);
                }
                this.a.c.K0.e().l(false);
            }
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            int i4;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLIII(Constants.METHOD_SEND_USER_MSG, this, charSequence, i, i2, i3) == null) && this.a.o0 != null && this.a.o0.getVisibility() == 0 && charSequence != null && charSequence.length() >= (i4 = i3 + i)) {
                String substring = charSequence.toString().substring(i, i4);
                if (TextUtils.isEmpty(substring)) {
                    return;
                }
                if (this.a.x1 == null) {
                    RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
                    layoutParams.addRule(11);
                    layoutParams.addRule(2, this.a.o0.getId());
                    om8 om8Var = this.a;
                    om8Var.x1 = new on8(om8Var.c.getPageContext(), this.a.d, layoutParams);
                    if (!ListUtils.isEmpty(this.a.w1)) {
                        this.a.x1.q(this.a.w1);
                    }
                    this.a.x1.r(this.a.o0);
                }
                this.a.x1.p(substring);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class u0 implements PbFallingView.q {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ om8 a;

        public u0(om8 om8Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {om8Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = om8Var;
        }

        @Override // com.baidu.tieba.pb.view.PbFallingView.q
        public void onClick() {
            String l1;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (this.a.c != null && this.a.c.L() != null && this.a.c.L().h2()) {
                    l1 = this.a.c.getString(R.string.pb_reply_hint_from_smart_frs);
                } else {
                    l1 = this.a.l1();
                }
                if (!StringUtils.isNull(l1) && this.a.P0 != null) {
                    l1 = TbSingleton.getInstance().getAdVertiComment(this.a.P0.r0(), this.a.P0.s0(), l1);
                }
                if (this.a.c != null && this.a.c.J5() != null) {
                    this.a.c.J5().c0(l1);
                }
                if (this.a.z0 != null) {
                    this.a.z0.setText(l1);
                }
                this.a.N3(false);
                this.a.h4();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class v implements k05.f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ boolean a;
        public final /* synthetic */ om8 b;

        public v(om8 om8Var, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {om8Var, Boolean.valueOf(z)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = om8Var;
            this.a = z;
        }

        @Override // com.baidu.tieba.k05.f
        public void M0(k05 k05Var, int i, View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIL(1048576, this, k05Var, i, view2) == null) {
                this.b.U.dismiss();
                SparseArray<Object> sparseArray = (SparseArray) view2.getTag();
                if (sparseArray == null) {
                    return;
                }
                switch (i) {
                    case 10:
                        this.b.x2(((Integer) sparseArray.get(R.id.tag_del_post_type)).intValue(), (String) sparseArray.get(R.id.tag_del_post_id), ((Integer) sparseArray.get(R.id.tag_manage_user_identity)).intValue(), ((Boolean) sparseArray.get(R.id.tag_del_post_is_self)).booleanValue());
                        return;
                    case 11:
                        if (this.b.c2 != null) {
                            this.b.c2.a(new Object[]{sparseArray.get(R.id.tag_manage_user_identity), sparseArray.get(R.id.tag_forbid_user_name), sparseArray.get(R.id.tag_forbid_user_post_id), sparseArray.get(R.id.tag_forbid_user_name_show), sparseArray.get(R.id.tag_forbid_user_portrait)});
                            return;
                        }
                        return;
                    case 12:
                        this.b.c.V5(this.a, (String) sparseArray.get(R.id.tag_user_mute_mute_userid), sparseArray);
                        return;
                    case 13:
                        this.b.z4(true);
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
        public final /* synthetic */ k65 a;
        public final /* synthetic */ om8 b;

        public v0(om8 om8Var, k65 k65Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {om8Var, k65Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = om8Var;
            this.a = k65Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921664));
                this.b.R1.setHomePbFloatLastCloseTime();
                this.b.C1();
                this.b.R1.t(this.a);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class w implements zz4.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public w(om8 om8Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {om8Var};
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

    /* loaded from: classes5.dex */
    public class w0 extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ om8 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public w0(om8 om8Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {om8Var, Integer.valueOf(i)};
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
            this.a = om8Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(1048576, this, customResponsedMessage) != null) || customResponsedMessage == null || customResponsedMessage.getCmd() != 2921306) {
                return;
            }
            this.a.V1 = null;
        }
    }

    /* loaded from: classes5.dex */
    public class x implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ AlertDialog a;
        public final /* synthetic */ SparseArray b;
        public final /* synthetic */ om8 c;

        public x(om8 om8Var, AlertDialog alertDialog, SparseArray sparseArray) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {om8Var, alertDialog, sparseArray};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = om8Var;
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
                    hi.P(this.c.c.M(), R.string.obfuscated_res_0x7f0f0d1f);
                } else {
                    this.c.c.m5(this.b, null);
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class x0 implements ViewTreeObserver.OnGlobalLayoutListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PbFragment a;
        public final /* synthetic */ om8 b;

        public x0(om8 om8Var, PbFragment pbFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {om8Var, pbFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = om8Var;
            this.a = pbFragment;
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (!this.b.M1 && this.a != null && this.b.c.L() != null && this.b.c.L().l2()) {
                    this.b.M1 = true;
                    this.a.b5(false);
                }
                if (this.b.N1) {
                    return;
                }
                this.b.N1 = true;
                if (this.b.V1() && this.b.A != null) {
                    this.b.A.h();
                    this.b.A.g(true);
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class y implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ AlertDialog a;

        public y(om8 om8Var, AlertDialog alertDialog) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {om8Var, alertDialog};
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
    public class y0 implements kj8.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ om8 a;

        public y0(om8 om8Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {om8Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = om8Var;
        }

        @Override // com.baidu.tieba.kj8.b
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.c.Y5();
            }
        }

        @Override // com.baidu.tieba.kj8.b
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
        public final /* synthetic */ om8 c;

        public z(om8 om8Var, AlertDialog alertDialog, SparseArray sparseArray) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {om8Var, alertDialog, sparseArray};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = om8Var;
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
                    hi.P(this.c.c.M(), R.string.obfuscated_res_0x7f0f0d1f);
                } else {
                    this.c.c.m5(this.b, null);
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class z0 implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ReplyPrivacyCheckController a;
        public final /* synthetic */ od5 b;
        public final /* synthetic */ om8 c;

        public z0(om8 om8Var, ReplyPrivacyCheckController replyPrivacyCheckController, od5 od5Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {om8Var, replyPrivacyCheckController, od5Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = om8Var;
            this.a = replyPrivacyCheckController;
            this.b = od5Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                if (this.a != null && this.c.c != null && this.c.c.u5() != null && !this.a.checkPrivacyBeforeInvokeEditor(this.c.c.u5().replyPrivateFlag)) {
                    return;
                }
                TiebaStatic.log(new StatisticItem(CommonStatisticKey.KEY_RD_USE).param("obj_param1", 3).param("obj_locate", 1).param("obj_type", 1).param("obj_source", UtilHelper.getCurrentPageName(TbadkCoreApplication.getInst().getCurrentActivity())));
                if (!DialogLoginHelper.checkUpIsLogin(new LoginDialogData(this.c.c.getActivity(), LoginDialogData.PB_BOTTOM_REPLY_RESULT_PAGE))) {
                    TiebaStatic.log(new StatisticItem(CommonStatisticKey.KEY_RD_USE).param("obj_param1", 3).param("obj_locate", 2).param("obj_type", 1).param("obj_source", UtilHelper.getCurrentPageName(TbadkCoreApplication.getInst().getCurrentActivity())));
                    return;
                }
                this.c.v4();
                this.b.n0();
                this.c.B0();
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948037167, "Lcom/baidu/tieba/om8;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948037167, "Lcom/baidu/tieba/om8;");
                return;
            }
        }
        n2 = UtilHelper.getLightStatusBarHeight();
        o2 = 3;
        p2 = 0;
        q2 = 3;
        r2 = 4;
        s2 = 5;
        t2 = 6;
        u2 = hi.g(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds80);
        v2 = 1;
        w2 = new g0();
    }

    public bc9 O0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048634, this)) == null) {
            if (this.l == null) {
                return null;
            }
            int N0 = N0() - this.l.getHeaderViewsCount();
            int i2 = 0;
            if (N0 < 0) {
                N0 = 0;
            }
            if (this.F.y(N0) != null && this.F.y(N0) != bc9.P0) {
                i2 = N0 + 1;
            }
            if (!(this.F.x(i2) instanceof bc9)) {
                return null;
            }
            return (bc9) this.F.x(i2);
        }
        return (bc9) invokeV.objValue;
    }

    public final boolean V1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048663, this)) == null) {
            if (F3()) {
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

    public void d4() {
        bc9 bc9Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048698, this) == null) && TbadkCoreApplication.isLogin() && this.P0 != null && this.q1 && !this.p1 && !this.j0 && (bc9Var = this.Q0) != null && bc9Var.r() != null && !this.Q0.r().getIsLike() && !this.Q0.r().hadConcerned() && this.m1 == null) {
            this.m1 = new gm8(this.c);
        }
    }

    public final void n0() {
        PbContentCollectionController pbContentCollectionController;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048741, this) == null) {
            if (F3()) {
                new StatisticItem(CommonStatisticKey.KEY_PB_PAGE_CONTENT_COLLECTION_SHOW).addParam("tid", this.P0.Q().getTid()).addParam("obj_param1", this.P0.Q().getThreadRecommendInfoDataList().get(0).businessId).eventStat();
            }
            if (V1() && (pbContentCollectionController = this.A) != null) {
                pbContentCollectionController.h();
                this.A.g(true);
            }
        }
    }

    public void p2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048753, this) == null) {
            r4();
            this.F.a0(1);
            jn8 jn8Var = this.t;
            if (jn8Var != null) {
                jn8Var.l();
            }
            ll8 ll8Var = this.p;
            if (ll8Var != null) {
                ll8Var.k();
            }
            km8 km8Var = this.r;
            if (km8Var != null) {
                km8Var.j();
            }
            RightFloatLayerView rightFloatLayerView = this.R1;
            if (rightFloatLayerView != null && (rightFloatLayerView instanceof RightFloatLayerLottieView)) {
                ((RightFloatLayerLottieView) rightFloatLayerView).G(600);
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016524));
        }
    }

    public void s2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048768, this) == null) {
            this.F.a0(2);
            jn8 jn8Var = this.t;
            if (jn8Var != null) {
                jn8Var.m();
                if (!TbSingleton.getInstance().isNotchScreen(this.c.getFragmentActivity()) && !TbSingleton.getInstance().isCutoutScreen(this.c.getFragmentActivity())) {
                    t1().setSystemUiVisibility(4);
                }
            }
            t2();
            d2();
            B4();
            n0();
        }
    }

    public om8(PbFragment pbFragment, View.OnClickListener onClickListener, mj8 mj8Var, SortSwitchButton.f fVar) {
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {pbFragment, onClickListener, mj8Var, fVar};
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
        this.F = null;
        this.G = null;
        this.H = null;
        this.I = null;
        this.J = null;
        this.K = null;
        this.L = null;
        this.M = null;
        this.N = null;
        this.O = null;
        this.Q = null;
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
        this.h0 = null;
        this.i0 = false;
        this.j0 = false;
        this.k0 = null;
        this.l0 = null;
        this.n0 = null;
        this.p0 = false;
        this.t0 = null;
        this.v0 = null;
        this.z0 = null;
        this.L0 = true;
        this.N0 = null;
        this.O0 = false;
        this.S0 = 3;
        this.T0 = false;
        this.U0 = null;
        this.d1 = 0;
        this.e1 = true;
        this.f1 = new a1();
        this.h1 = 0;
        this.n1 = false;
        this.o1 = 0;
        this.p1 = false;
        this.q1 = false;
        this.r1 = false;
        this.s1 = 0;
        this.A1 = false;
        this.B1 = false;
        this.I1 = 0L;
        this.L1 = 0;
        this.T1 = new k(this, 2921757);
        this.W1 = new w0(this, 2921306);
        this.X1 = new n(this);
        this.Y1 = new p(this, 2005016);
        this.Z1 = new Handler();
        this.b2 = new r(this, 2004009);
        this.d2 = true;
        this.e2 = new i0(this);
        this.f2 = false;
        this.g2 = null;
        this.j2 = new ArrayList();
        this.l2 = false;
        this.I1 = System.currentTimeMillis();
        this.c = pbFragment;
        this.Q = onClickListener;
        this.R = fVar;
        this.m0 = mj8Var;
        this.s1 = hi.l(pbFragment.getContext()) / 8;
        RelativeLayout relativeLayout = (RelativeLayout) LayoutInflater.from(this.c.getPageContext().getPageActivity()).inflate(R.layout.obfuscated_res_0x7f0d0696, (ViewGroup) null);
        this.d = relativeLayout;
        relativeLayout.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        this.q0 = this.d.findViewById(R.id.obfuscated_res_0x7f090453);
        this.D1 = (NavigationBarCoverTip) this.d.findViewById(R.id.obfuscated_res_0x7f0919ea);
        this.e = this.d.findViewById(R.id.obfuscated_res_0x7f09215f);
        this.S1 = (FrameLayout) this.d.findViewById(R.id.obfuscated_res_0x7f091de9);
        this.E = (ObservedChangeRelativeLayout) this.d.findViewById(R.id.obfuscated_res_0x7f092433);
        this.m = (NoNetworkView) this.d.findViewById(R.id.view_no_network);
        PbLandscapeListView pbLandscapeListView = (PbLandscapeListView) this.d.findViewById(R.id.obfuscated_res_0x7f09181a);
        this.l = pbLandscapeListView;
        pbLandscapeListView.setDividerHeight(0);
        this.W0 = (FrameLayout) this.d.findViewById(R.id.obfuscated_res_0x7f091e38);
        this.X0 = new TextView(this.c.getActivity());
        AbsListView.LayoutParams layoutParams = new AbsListView.LayoutParams(-1, UtilHelper.getLightStatusBarHeight() + hi.g(this.c.getActivity(), R.dimen.obfuscated_res_0x7f070307));
        this.l.setOverScrollMode(2);
        this.l.w(this.X0, 0);
        this.l.setTextViewAdded(true);
        this.i1 = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds134);
        this.c1 = new View(this.c.getPageContext().getPageActivity());
        if (hv5.a()) {
            this.c1.setLayoutParams(new AbsListView.LayoutParams(-1, 0));
        } else {
            this.c1.setLayoutParams(new AbsListView.LayoutParams(-1, this.i1));
        }
        MessageManager.getInstance().registerListener(this.T1);
        this.c1.setVisibility(4);
        this.l.addFooterView(this.c1);
        this.l.setOnTouchListener(this.c.M2);
        this.a = new x0(this, pbFragment);
        this.l.getViewTreeObserver().addOnGlobalLayoutListener(this.a);
        this.h = new ro8(pbFragment, this.d);
        if (this.c.D5()) {
            ViewStub viewStub = (ViewStub) this.d.findViewById(R.id.obfuscated_res_0x7f091617);
            this.j = viewStub;
            viewStub.setVisibility(0);
            qo8 qo8Var = new qo8(pbFragment);
            this.i = qo8Var;
            qo8Var.c();
            this.h.a.setVisibility(8);
            layoutParams.height = hi.g(this.c.getActivity(), R.dimen.obfuscated_res_0x7f07023d);
        }
        this.X0.setLayoutParams(layoutParams);
        this.h.q().setOnTouchListener(new kj8(new y0(this)));
        this.u0 = this.d.findViewById(R.id.obfuscated_res_0x7f0927c0);
        this.v0 = this.d.findViewById(R.id.obfuscated_res_0x7f091985);
        hi.g(TbadkCoreApplication.getInst(), R.dimen.tbds120);
        this.M0 = hi.g(TbadkCoreApplication.getInst(), R.dimen.obfuscated_res_0x7f070285);
        this.y0 = (ImageView) this.d.findViewById(R.id.obfuscated_res_0x7f090944);
        this.y0.setOnClickListener(new z0(this, new ReplyPrivacyCheckController(this.c.getPageContext()), this.c.J5()));
        C0();
        this.z0 = (TextView) this.d.findViewById(R.id.obfuscated_res_0x7f091988);
        LinearLayout linearLayout = (LinearLayout) this.d.findViewById(R.id.obfuscated_res_0x7f091980);
        this.w0 = linearLayout;
        linearLayout.setOnClickListener(new a(this));
        EjectionAnimationView ejectionAnimationView = (EjectionAnimationView) this.d.findViewById(R.id.obfuscated_res_0x7f090948);
        this.s0 = ejectionAnimationView;
        ejectionAnimationView.setEjectionAnimationViewCallback(new b(this));
        this.B0 = (ImageView) this.d.findViewById(R.id.obfuscated_res_0x7f091986);
        this.P1 = (MaskView) this.d.findViewById(R.id.mask_view);
        this.B0.setOnClickListener(this.Q);
        AgreeView agreeView = (AgreeView) this.d.findViewById(R.id.obfuscated_res_0x7f091982);
        this.C0 = agreeView;
        agreeView.setAgreeAlone(true);
        this.C0.w();
        this.C0.setAgreeLongClickListener(new c(this));
        this.C0.setAfterClickListener(new d(this));
        this.C0.setUseDynamicLikeRes("/pb");
        if (this.C0.getAgreeNumView() != null) {
            this.C0.getAgreeNumView().setVisibility(8);
        }
        if (this.C0.getMsgData() != null) {
            this.C0.getMsgData().a = BdUniqueId.gen();
        }
        boolean booleanExtra = this.c.getBaseFragmentActivity().getIntent().getBooleanExtra("key_is_from_dynamic", false);
        ImageView imageView = (ImageView) this.d.findViewById(R.id.obfuscated_res_0x7f091984);
        this.D0 = imageView;
        imageView.setOnClickListener(this.Q);
        if (booleanExtra) {
            this.D0.setVisibility(8);
        } else {
            this.D0.setVisibility(0);
        }
        View findViewById = this.d.findViewById(R.id.obfuscated_res_0x7f09198b);
        this.G0 = findViewById;
        if (!m35.m().i("pb_share_red_dot_shown", false) && TbadkCoreApplication.isLogin()) {
            i2 = 0;
        } else {
            i2 = 8;
        }
        findViewById.setVisibility(i2);
        this.E0 = (ImageView) this.d.findViewById(R.id.obfuscated_res_0x7f091989);
        HeadImageView headImageView = (HeadImageView) this.d.findViewById(R.id.obfuscated_res_0x7f09198a);
        this.F0 = headImageView;
        headImageView.setIsRound(true);
        this.F0.setOnClickListener(this.X1);
        this.E0.setOnClickListener(new e(this));
        f2();
        vq8 vq8Var = new vq8(this.E0);
        this.H0 = vq8Var;
        vq8Var.n(this.F0);
        if (!UbsABTestHelper.isResizeInduceSharingABTest() && !UbsABTestHelper.isResizeInduceSharingABTestA()) {
            this.H0.f();
        }
        TextView textView = (TextView) this.d.findViewById(R.id.obfuscated_res_0x7f091987);
        this.J0 = textView;
        textView.setVisibility(0);
        this.I0 = (TextView) this.d.findViewById(R.id.obfuscated_res_0x7f091983);
        this.U0 = (ViewStub) this.d.findViewById(R.id.obfuscated_res_0x7f0910df);
        this.C0.setVisibility(0);
        this.I0.setVisibility(0);
        this.u = new en8(this.c, mj8Var);
        this.w = new in8(this.c, mj8Var, this.Q);
        vk8 vk8Var = new vk8(this.c, this.l);
        this.F = vk8Var;
        vk8Var.y0(this.Q);
        this.F.A0(this.m0);
        this.F.v0(this.S);
        this.F.x0(this.R);
        this.F.r0(this.i2);
        f fVar2 = new f(this);
        this.V = fVar2;
        this.F.t0(fVar2);
        M1();
        G1();
        hn8 hn8Var = new hn8(this.c);
        this.y = hn8Var;
        hn8Var.f = 2;
        F1();
        E1();
        this.z.a(this.l);
        this.w.n(this.l);
        this.v.a(this.l);
        this.A.a(this.l);
        this.u.a(this.l);
        PbListView pbListView = new PbListView(this.c.getPageContext().getPageActivity());
        this.L = pbListView;
        this.N = pbListView.c().findViewById(R.id.pb_more_view);
        this.O = this.L.c().findViewById(R.id.pb_check_more);
        if (!this.L.j().booleanValue()) {
            this.O.setVisibility(8);
        }
        View view2 = this.N;
        if (view2 != null) {
            view2.setOnClickListener(this.Q);
            SkinManager.setBackgroundResource(this.N, R.drawable.pb_foot_more_trans_selector);
        }
        View view3 = this.O;
        if (view3 != null) {
            view3.setOnClickListener(this.Q);
        }
        this.L.C();
        this.L.q(R.drawable.pb_foot_more_trans_selector);
        this.L.r(R.drawable.pb_foot_more_trans_selector);
        this.P = this.d.findViewById(R.id.obfuscated_res_0x7f0927f7);
        this.c.registerListener(this.b2);
        this.k1 = new PbFakeFloorModel(this.c.getPageContext());
        PbModel L = this.c.L();
        this.k1.k0(L.a0(), L.W(), L.X(), L.V(), L.b0());
        hl8 hl8Var = new hl8(this.c.getPageContext(), this.k1, this.d);
        this.l1 = hl8Var;
        hl8Var.p(new g(this));
        this.l1.s(this.c.o2);
        this.k1.m0(new h(this));
        if (this.c.L() != null && !StringUtils.isNull(this.c.L().z1())) {
            PbFragment pbFragment2 = this.c;
            pbFragment2.showToast(pbFragment2.L().z1());
        }
        this.Y0 = this.d.findViewById(R.id.obfuscated_res_0x7f09198d);
        this.Z0 = this.d.findViewById(R.id.obfuscated_res_0x7f090451);
        View findViewById2 = this.d.findViewById(R.id.obfuscated_res_0x7f09216c);
        this.a1 = findViewById2;
        LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) findViewById2.getLayoutParams();
        if (this.c.L() != null && this.c.L().i1()) {
            this.Y0.setVisibility(0);
            if (layoutParams2 != null) {
                layoutParams2.height = 0;
                this.a1.setLayoutParams(layoutParams2);
            }
        } else if (layoutParams2 != null) {
            layoutParams2.height = n2;
            this.a1.setLayoutParams(layoutParams2);
        }
        PbReplyTitleViewHolder pbReplyTitleViewHolder = new PbReplyTitleViewHolder(this.c.getPageContext(), this.d.findViewById(R.id.obfuscated_res_0x7f091a08));
        this.b1 = pbReplyTitleViewHolder;
        pbReplyTitleViewHolder.r(pbFragment.d0);
        this.b1.g.setVisibility(8);
        this.b1.q(this.Q);
        this.b1.p(this.R);
        this.c.registerListener(this.Y1);
        this.c.registerListener(this.W1);
        PbFragment pbFragment3 = this.c;
        this.O1 = new uq8(pbFragment3, pbFragment3.getUniqueId());
        this.Q1 = (PbFallingView) this.d.findViewById(R.id.obfuscated_res_0x7f090a81);
        a3();
        this.Q1.setAnimationListener(new i(this));
        q0();
        T2(false);
        this.r0 = this.d.findViewById(R.id.obfuscated_res_0x7f091976);
        p0(hv5.a());
        if (UbsABTestHelper.isPbForumGuideTestA() && L.p2() && nh8.b().e()) {
            if (this.p == null) {
                this.p = new ll8(this.c.getActivity(), (ViewGroup) t1().findViewById(R.id.obfuscated_res_0x7f0919b2));
            }
            kl8 kl8Var = new kl8(this.l);
            this.q = kl8Var;
            kl8Var.d(new j(this));
        }
        this.r = new km8(this.c.M(), (ViewGroup) t1().findViewById(R.id.obfuscated_res_0x7f091a1c));
        jm8 jm8Var = new jm8(this.l);
        this.s = jm8Var;
        jm8Var.d(new m(this));
    }

    public void A4(ki8 ki8Var) {
        en8 en8Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048580, this, ki8Var) == null) && (en8Var = this.u) != null) {
            en8Var.h(ki8Var, this.O0);
        }
    }

    public void B3(boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(InputDeviceCompat.SOURCE_TOUCHPAD, this, z2) == null) {
            this.w.J(z2);
        }
    }

    public void C2(View view2) {
        SparseArray<Object> sparseArray;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048588, this, view2) != null) || (sparseArray = (SparseArray) view2.getTag()) == null) {
            return;
        }
        B2(sparseArray, false);
    }

    public void D3(int i2) {
        PbLandscapeListView pbLandscapeListView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(1048593, this, i2) == null) && (pbLandscapeListView = this.l) != null) {
            pbLandscapeListView.setSelection(i2);
        }
    }

    public void E3(List<String> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048597, this, list) == null) {
            this.w1 = list;
            on8 on8Var = this.x1;
            if (on8Var != null) {
                on8Var.q(list);
            }
        }
    }

    public void M3(boolean z2) {
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048629, this, z2) == null) {
            View view2 = this.q0;
            if (z2) {
                i2 = 0;
            } else {
                i2 = 8;
            }
            view2.setVisibility(i2);
        }
    }

    public void Y2(String str) {
        PbListView pbListView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048676, this, str) == null) && (pbListView = this.L) != null) {
            pbListView.F(str);
        }
    }

    public void b3(PbFragment.h3 h3Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048689, this, h3Var) == null) {
            this.c2 = h3Var;
        }
    }

    public void c3(boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048693, this, z2) == null) {
            this.p0 = z2;
        }
    }

    public final int d1(boolean z2) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048695, this, z2)) == null) {
            PbInterviewStatusView pbInterviewStatusView = this.V0;
            if (pbInterviewStatusView == null || pbInterviewStatusView.getVisibility() != 0 || !z2) {
                return 0;
            }
            return 0 + hi.g(TbadkCoreApplication.getInst(), R.dimen.obfuscated_res_0x7f07026a);
        }
        return invokeZ.intValue;
    }

    public void d3(boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048697, this, z2) == null) {
            this.F.i0(z2);
        }
    }

    public void e3(boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048701, this, z2) == null) {
            this.J1 = z2;
        }
    }

    public void f3(boolean z2) {
        vk8 vk8Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048705, this, z2) == null) && (vk8Var = this.F) != null) {
            vk8Var.j0(z2);
        }
    }

    public void g3(boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048709, this, z2) == null) {
            this.A1 = z2;
        }
    }

    public void h3(boolean z2) {
        jn8 jn8Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048714, this, z2) == null) && (jn8Var = this.t) != null) {
            jn8Var.r(z2);
        }
    }

    public void i3(boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048719, this, z2) == null) {
            this.F.l0(z2);
        }
    }

    public boolean j0(boolean z2) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048721, this, z2)) == null) {
            EditorTools editorTools = this.o0;
            if (editorTools != null && editorTools.w()) {
                this.o0.s();
                return true;
            }
            return false;
        }
        return invokeZ.booleanValue;
    }

    public void j3(boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048724, this, z2) == null) {
            this.F.q0(z2);
        }
    }

    public void k3(v35.g gVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048729, this, gVar) == null) {
            this.h2 = gVar;
            wq8 wq8Var = this.K;
            if (wq8Var != null) {
                wq8Var.f(gVar);
            }
        }
    }

    public void l3(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048734, this, onClickListener) == null) {
            this.i2 = onClickListener;
            vk8 vk8Var = this.F;
            if (vk8Var != null) {
                vk8Var.r0(onClickListener);
            }
        }
    }

    public final void l4(bc9 bc9Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048735, this, bc9Var) == null) && bc9Var != null) {
            if (!StringUtils.isNull(bc9Var.a0())) {
                this.B1 = true;
            } else {
                this.B1 = false;
            }
            in8 in8Var = this.w;
            if (in8Var != null) {
                in8Var.p(bc9Var);
            }
        }
    }

    public boolean m2(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048738, this, i2)) == null) {
            jn8 jn8Var = this.t;
            if (jn8Var != null) {
                return jn8Var.k(i2);
            }
            return false;
        }
        return invokeI.booleanValue;
    }

    public void m3(String str) {
        qo8 qo8Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048739, this, str) == null) && (qo8Var = this.i) != null) {
            qo8Var.b(str);
        }
    }

    public void n3(boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048744, this, z2) == null) {
            this.n1 = z2;
            PbLandscapeListView pbLandscapeListView = this.l;
            if (pbLandscapeListView != null) {
                this.o1 = pbLandscapeListView.getHeaderViewsCount();
            }
        }
    }

    public void o4(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048750, this, str) == null) {
            this.c.showToast(str);
        }
    }

    public void p3(TbRichTextView.a0 a0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048754, this, a0Var) == null) {
            this.S = a0Var;
            this.F.v0(a0Var);
            this.y1.q(this.S);
        }
    }

    public void q2(jn jnVar) {
        PbLandscapeListView pbLandscapeListView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048758, this, jnVar) == null) && (pbLandscapeListView = this.l) != null) {
            pbLandscapeListView.b0 = jnVar;
            pbLandscapeListView.W = true;
        }
    }

    public void q3(NoNetworkView.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048759, this, bVar) == null) {
            this.T = bVar;
            NoNetworkView noNetworkView = this.m;
            if (noNetworkView != null) {
                noNetworkView.a(bVar);
            }
        }
    }

    public void r3(BdListView.p pVar) {
        PbLandscapeListView pbLandscapeListView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048764, this, pVar) == null) && (pbLandscapeListView = this.l) != null) {
            pbLandscapeListView.setOnSrollToBottomListener(pVar);
        }
    }

    public void s3(AbsListView.OnScrollListener onScrollListener) {
        PbLandscapeListView pbLandscapeListView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048769, this, onScrollListener) == null) && (pbLandscapeListView = this.l) != null) {
            pbLandscapeListView.setOnScrollListener(onScrollListener);
        }
    }

    public void s4(boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048770, this, z2) == null) {
            this.i0 = z2;
        }
    }

    public void t3(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048774, this, onClickListener) == null) {
            this.F.z0(onClickListener);
        }
    }

    public void u3(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048779, this, i2) == null) {
            this.K1 = i2;
        }
    }

    public void v3(View.OnLongClickListener onLongClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048784, this, onLongClickListener) == null) {
            this.w.H(onLongClickListener);
            this.F.w0(onLongClickListener);
            kk8 kk8Var = this.y1;
            if (kk8Var != null) {
                kk8Var.r(onLongClickListener);
            }
        }
    }

    public void F2(ca5 ca5Var, int i2) {
        PbFallingView pbFallingView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLI(1048600, this, ca5Var, i2) == null) && (pbFallingView = this.Q1) != null) {
            pbFallingView.A(ca5Var, this.c.getPageContext(), i2, false);
        }
    }

    public void g2(boolean z2, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048708, this, new Object[]{Boolean.valueOf(z2), Integer.valueOf(i2)}) == null) {
            kl8 kl8Var = this.q;
            if (kl8Var != null) {
                kl8Var.b();
            }
            jm8 jm8Var = this.s;
            if (jm8Var != null) {
                jm8Var.b(z2, i2);
            }
        }
    }

    @SuppressLint({"CutPasteId"})
    public void n4(ki8 ki8Var, boolean z2) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLZ(1048745, this, ki8Var, z2) != null) || ki8Var == null) {
            return;
        }
        x4(ki8Var, z2);
        y0();
    }

    public final void w3(bc9 bc9Var, ki8 ki8Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048789, this, bc9Var, ki8Var) == null) {
            this.w.I(bc9Var, ki8Var);
        }
    }

    public void A0() {
        jn8 jn8Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && (jn8Var = this.t) != null) {
            jn8Var.b();
        }
    }

    public void A1() {
        Runnable runnable;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            if (this.B == null) {
                I1();
            }
            this.k.setVisibility(8);
            Handler handler = this.Z1;
            if (handler != null && (runnable = this.a2) != null) {
                handler.removeCallbacks(runnable);
            }
        }
    }

    public void A3() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            this.L.C();
            this.L.T();
        }
    }

    public void B0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            StatisticItem statisticItem = new StatisticItem("c14693");
            statisticItem.param("uid", TbadkCoreApplication.getCurrentAccountId());
            statisticItem.param("obj_locate", v2);
            TiebaStatic.log(statisticItem);
        }
    }

    public void B1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            this.P.setVisibility(8);
        }
    }

    public void C0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            StatisticItem statisticItem = new StatisticItem("c14692");
            statisticItem.param("uid", TbadkCoreApplication.getCurrentAccountId());
            statisticItem.param("obj_locate", v2);
            TiebaStatic.log(statisticItem);
        }
    }

    public void C1() {
        RightFloatLayerView rightFloatLayerView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048587, this) == null) && (rightFloatLayerView = this.R1) != null) {
            rightFloatLayerView.c();
        }
    }

    public void D0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
            PbListView pbListView = this.L;
            if (pbListView != null) {
                pbListView.A();
                this.L.g();
            }
            z1();
        }
    }

    public void D1() {
        EditorTools editorTools;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048591, this) == null) && (editorTools = this.o0) != null) {
            editorTools.s();
        }
    }

    public void E0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048594, this) == null) {
            PbLandscapeListView pbLandscapeListView = this.l;
            if (pbLandscapeListView != null) {
                pbLandscapeListView.z(0L);
            }
            y0();
        }
    }

    public final void E1() {
        PbFragment pbFragment;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048595, this) == null) && this.A == null && (pbFragment = this.c) != null && pbFragment.getActivity() != null) {
            this.A = new PbContentCollectionController(this.c.getActivity());
        }
    }

    public boolean E2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) {
            km8 km8Var = this.r;
            if (km8Var != null && km8Var.l()) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public final void F1() {
        PbFragment pbFragment;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048599, this) == null) && this.z == null && (pbFragment = this.c) != null) {
            this.z = new dn8(pbFragment.getContext());
        }
    }

    public void G0() {
        PbLandscapeListView pbLandscapeListView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048602, this) == null) && (pbLandscapeListView = this.l) != null) {
            pbLandscapeListView.setForbidDragListener(true);
        }
    }

    public final void G1() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048603, this) == null) && this.v == null) {
            this.v = new gn8(this.c, this.m0);
        }
    }

    public final void I2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048612, this) == null) {
            this.w.E(this.P0, this.Q0, this.q1, this.p1);
        }
    }

    public vk8 J0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048614, this)) == null) {
            return this.F;
        }
        return (vk8) invokeV.objValue;
    }

    public void J3() {
        jn8 jn8Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048617, this) == null) && (jn8Var = this.t) != null) {
            jn8Var.u(this.l);
        }
    }

    public LinearLayout K0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048618, this)) == null) {
            return this.w0;
        }
        return (LinearLayout) invokeV.objValue;
    }

    public View L0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048622, this)) == null) {
            View view2 = this.Z;
            if (view2 != null) {
                return view2.findViewById(R.id.dialog_button_ok);
            }
            return null;
        }
        return (View) invokeV.objValue;
    }

    public String M0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048626, this)) == null) {
            return this.e0;
        }
        return (String) invokeV.objValue;
    }

    public final void M1() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048627, this) == null) && this.x == null) {
            this.x = new fn8(this.c, this.Q);
        }
    }

    public boolean O1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048635, this)) == null) {
            return this.f2;
        }
        return invokeV.booleanValue;
    }

    public final void O2() {
        PbInterviewStatusView pbInterviewStatusView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048636, this) == null) && (pbInterviewStatusView = this.V0) != null && pbInterviewStatusView.getVisibility() == 0) {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.V0.getLayoutParams();
            marginLayoutParams.setMargins(0, 0, 0, 0);
            this.V0.setLayoutParams(marginLayoutParams);
        }
    }

    public PbFallingView P0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048638, this)) == null) {
            return this.Q1;
        }
        return (PbFallingView) invokeV.objValue;
    }

    public boolean P1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048639, this)) == null) {
            return this.L0;
        }
        return invokeV.booleanValue;
    }

    public void P2() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048640, this) == null) && this.f != 2) {
            PbLandscapeListView pbLandscapeListView = this.l;
            if (pbLandscapeListView != null) {
                pbLandscapeListView.setNextPage(this.L);
            }
            this.f = 2;
        }
    }

    public int Q0() {
        InterceptResult invokeV;
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048642, this)) == null) {
            PbLandscapeListView pbLandscapeListView = this.l;
            if (pbLandscapeListView != null) {
                i2 = pbLandscapeListView.getFirstVisiblePosition();
            } else {
                i2 = 0;
            }
            return R0(i2);
        }
        return invokeV.intValue;
    }

    public boolean R1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048647, this)) == null) {
            PbLandscapeListView pbLandscapeListView = this.l;
            if (pbLandscapeListView == null) {
                return false;
            }
            return pbLandscapeListView.I();
        }
        return invokeV.booleanValue;
    }

    public Button S0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048650, this)) == null) {
            return this.t0;
        }
        return (Button) invokeV.objValue;
    }

    public boolean S1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048651, this)) == null) {
            EditorTools editorTools = this.o0;
            if (editorTools == null || editorTools.getVisibility() != 0) {
                return false;
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    public int T0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048654, this)) == null) {
            PbLandscapeListView pbLandscapeListView = this.l;
            if (pbLandscapeListView != null) {
                return pbLandscapeListView.getHeaderViewsCount();
            }
            return 0;
        }
        return invokeV.intValue;
    }

    public void T3() {
        ro8 ro8Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048657, this) == null) && (ro8Var = this.h) != null && !this.r1) {
            ro8Var.E();
            this.r1 = true;
        }
    }

    public TextView U0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048658, this)) == null) {
            return this.w.s();
        }
        return (TextView) invokeV.objValue;
    }

    public final boolean U1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048659, this)) == null) {
            return TextUtils.equals(TbadkCoreApplication.getCurrentAccount(), this.g2);
        }
        return invokeV.booleanValue;
    }

    public void U2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048660, this) == null) {
            S2();
            x1();
            this.l1.g();
            N3(false);
        }
    }

    public void U3() {
        PbLandscapeListView pbLandscapeListView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048661, this) == null) && (pbLandscapeListView = this.l) != null) {
            pbLandscapeListView.setVisibility(0);
        }
    }

    public int V0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048662, this)) == null) {
            vq8 vq8Var = this.H0;
            if (vq8Var != null) {
                return vq8Var.g();
            }
            return 3;
        }
        return invokeV.intValue;
    }

    public final void V2() {
        jn8 jn8Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048664, this) == null) && (jn8Var = this.t) != null) {
            jn8Var.q(this.l, this.X0, this.R0);
        }
    }

    public void V3() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048665, this) == null) {
            if (this.N0 == null) {
                this.N0 = new p35(this.c.getPageContext());
            }
            this.N0.h(true);
        }
    }

    public PbInterviewStatusView W0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048666, this)) == null) {
            return this.V0;
        }
        return (PbInterviewStatusView) invokeV.objValue;
    }

    public void W2() {
        Handler handler;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048668, this) != null) || (handler = this.Z1) == null) {
            return;
        }
        Runnable runnable = this.a2;
        if (runnable != null) {
            handler.removeCallbacks(runnable);
        }
        q qVar = new q(this);
        this.a2 = qVar;
        this.Z1.postDelayed(qVar, 2000L);
    }

    public boolean X0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048670, this)) == null) {
            return this.A1;
        }
        return invokeV.booleanValue;
    }

    public void X3() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048673, this) == null) {
            this.F.h0(this.P0, false);
            this.F.Z();
        }
    }

    public BdTypeListView Z0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048678, this)) == null) {
            return this.l;
        }
        return (BdTypeListView) invokeV.objValue;
    }

    public boolean Z1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048679, this)) == null) {
            jn8 jn8Var = this.t;
            if (jn8Var != null && jn8Var.f()) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public NoNetworkView a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048682, this)) == null) {
            return this.m;
        }
        return (NoNetworkView) invokeV.objValue;
    }

    public boolean a2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048684, this)) == null) {
            return this.U1;
        }
        return invokeV.booleanValue;
    }

    public final void a3() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048685, this) == null) {
            this.Q1.setFallingFeedbackListener(new u0(this));
        }
    }

    public kk8 b1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048687, this)) == null) {
            return this.y1;
        }
        return (kk8) invokeV.objValue;
    }

    public boolean b2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048688, this)) == null) {
            vq8 vq8Var = this.H0;
            if (vq8Var == null) {
                return false;
            }
            return vq8Var.i();
        }
        return invokeV.booleanValue;
    }

    public View c1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048691, this)) == null) {
            return this.O;
        }
        return (View) invokeV.objValue;
    }

    public boolean c2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048692, this)) == null) {
            EditorTools editorTools = this.o0;
            if (editorTools != null && editorTools.w()) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public View e1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048699, this)) == null) {
            return this.N;
        }
        return (View) invokeV.objValue;
    }

    public void e2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048700, this) == null) {
            L2(this.P0);
        }
    }

    public PbListView f1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048703, this)) == null) {
            return this.L;
        }
        return (PbListView) invokeV.objValue;
    }

    public void f4() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048706, this) == null) {
            this.P.setVisibility(0);
        }
    }

    public int g1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048707, this)) == null) {
            try {
                return Integer.parseInt(this.J.getText().toString(), 10);
            } catch (Exception unused) {
                return -1;
            }
        }
        return invokeV.intValue;
    }

    public void g4() {
        vk8 vk8Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048710, this) == null) && (vk8Var = this.F) != null) {
            vk8Var.B0();
        }
    }

    public View h1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048712, this)) == null) {
            return this.Y0;
        }
        return (View) invokeV.objValue;
    }

    public void i0() {
        vq8 vq8Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048716, this) == null) && (vq8Var = this.H0) != null) {
            vq8Var.m(false);
        }
    }

    public PbFakeFloorModel i1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048717, this)) == null) {
            return this.k1;
        }
        return (PbFakeFloorModel) invokeV.objValue;
    }

    public void i4() {
        vq8 vq8Var;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048720, this) != null) || (vq8Var = this.H0) == null) {
            return;
        }
        vq8Var.o(2);
    }

    public hl8 j1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048722, this)) == null) {
            return this.l1;
        }
        return (hl8) invokeV.objValue;
    }

    public jn8 k1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048727, this)) == null) {
            return this.t;
        }
        return (jn8) invokeV.objValue;
    }

    public final int o1() {
        InterceptResult invokeV;
        View childAt;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048747, this)) == null) {
            PbLandscapeListView pbLandscapeListView = this.l;
            if (pbLandscapeListView == null || (childAt = pbLandscapeListView.getChildAt(0)) == null) {
                return 0;
            }
            return (-childAt.getTop()) + (this.l.getFirstVisiblePosition() * childAt.getHeight());
        }
        return invokeV.intValue;
    }

    public int p1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048752, this)) == null) {
            return this.S0;
        }
        return invokeV.intValue;
    }

    public void p4() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048755, this) == null) {
            this.c.showProgressBar();
        }
    }

    public View q1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048757, this)) == null) {
            return this.e;
        }
        return (View) invokeV.objValue;
    }

    public void q4() {
        PbFallingView pbFallingView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048760, this) == null) && (pbFallingView = this.Q1) != null) {
            pbFallingView.C();
        }
    }

    public PbThreadPostView r1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048762, this)) == null) {
            return this.o;
        }
        return (PbThreadPostView) invokeV.objValue;
    }

    public void r4() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048765, this) == null) && this.j2 != null) {
            while (this.j2.size() > 0) {
                TbImageView remove = this.j2.remove(0);
                if (remove != null) {
                    remove.Q();
                }
            }
        }
    }

    public RelativeLayout s1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048767, this)) == null) {
            return this.E;
        }
        return (RelativeLayout) invokeV.objValue;
    }

    public RelativeLayout t1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048772, this)) == null) {
            return this.d;
        }
        return (RelativeLayout) invokeV.objValue;
    }

    public final void t2() {
        PbFragment pbFragment;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048773, this) == null) && (pbFragment = this.c) != null && pbFragment.J5() != null) {
            this.c.J5().E();
        }
    }

    public void u1() {
        View view2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048777, this) == null) {
            PbLandscapeListView pbLandscapeListView = this.l;
            if (pbLandscapeListView != null) {
                pbLandscapeListView.setVisibility(8);
            }
            if (this.l != null) {
                this.W0.setVisibility(8);
            }
            ro8 ro8Var = this.h;
            if (ro8Var != null && (view2 = ro8Var.d) != null) {
                view2.setVisibility(8);
            }
        }
    }

    public void v1() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048782, this) != null) || this.v0 == null) {
            return;
        }
        this.u0.setVisibility(8);
        this.v0.setVisibility(8);
        this.L0 = false;
        PbEmotionBar pbEmotionBar = this.g1;
        if (pbEmotionBar != null) {
            pbEmotionBar.setVisibility(8);
            T2(false);
        }
    }

    public void x0() {
        vq8 vq8Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048791, this) == null) && (vq8Var = this.H0) != null) {
            vq8Var.l(false);
        }
    }

    public void x1() {
        EditorTools editorTools;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048792, this) == null) && (editorTools = this.o0) != null) {
            editorTools.q();
            on8 on8Var = this.x1;
            if (on8Var != null) {
                on8Var.m();
            }
        }
    }

    public final boolean y0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048796, this)) == null) {
            return this.u.b(this.O0);
        }
        return invokeV.booleanValue;
    }

    public void y1() {
        ro8 ro8Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048797, this) == null) && (ro8Var = this.h) != null) {
            ro8Var.r();
        }
    }

    public void z1() {
        p35 p35Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048802, this) == null) && (p35Var = this.N0) != null) {
            p35Var.h(false);
        }
    }

    public void z3() {
        PbFragment pbFragment;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048804, this) == null) && (pbFragment = this.c) != null && pbFragment.getBaseFragmentActivity() != null) {
            hi.z(this.c.getPageContext().getPageActivity(), this.c.getBaseFragmentActivity().getCurrentFocus());
        }
    }

    public void A2(int i2, String str, int i3, boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{Integer.valueOf(i2), str, Integer.valueOf(i3), Boolean.valueOf(z2)}) == null) {
            SparseArray<Object> sparseArray = new SparseArray<>();
            sparseArray.put(R.id.tag_del_post_id, str);
            sparseArray.put(R.id.tag_del_post_type, Integer.valueOf(i2));
            sparseArray.put(R.id.tag_manage_user_identity, Integer.valueOf(i3));
            sparseArray.put(R.id.tag_del_post_is_self, Boolean.valueOf(z2));
            sparseArray.put(p2, Integer.valueOf(q2));
            if (z2) {
                K3(sparseArray);
            } else {
                L3(i2, sparseArray);
            }
        }
    }

    public void F0(int i2, boolean z2, String str, boolean z3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048598, this, new Object[]{Integer.valueOf(i2), Boolean.valueOf(z2), str, Boolean.valueOf(z3)}) == null) {
            this.c.hideProgressBar();
            if (z2 && z3) {
                PbFragment pbFragment = this.c;
                pbFragment.showToast(pbFragment.getPageContext().getString(R.string.obfuscated_res_0x7f0f1314));
            } else if (z3) {
                if (gi.isEmpty(str)) {
                    str = TbadkCoreApplication.getInst().getResources().getString(R.string.obfuscated_res_0x7f0f0d1f);
                }
                this.c.showToast(str);
            }
        }
    }

    public void B2(SparseArray<Object> sparseArray, boolean z2) {
        int i2;
        g05 g05Var;
        g05 g05Var2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048583, this, sparseArray, z2) == null) {
            k05 k05Var = new k05(this.c.getContext());
            k05Var.s(this.c.getString(R.string.obfuscated_res_0x7f0f02f2));
            k05Var.p(new v(this, z2));
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
                    g05Var2 = new g05(10, this.c.getString(R.string.obfuscated_res_0x7f0f04e8), k05Var);
                } else {
                    g05Var2 = new g05(10, this.c.getString(R.string.obfuscated_res_0x7f0f04db), k05Var);
                }
                SparseArray sparseArray2 = new SparseArray();
                sparseArray2.put(R.id.tag_del_post_id, sparseArray.get(R.id.tag_del_post_id));
                sparseArray2.put(R.id.tag_del_post_type, sparseArray.get(R.id.tag_del_post_type));
                sparseArray2.put(R.id.tag_del_post_is_self, sparseArray.get(R.id.tag_del_post_is_self));
                sparseArray2.put(R.id.tag_manage_user_identity, sparseArray.get(R.id.tag_manage_user_identity));
                g05Var2.d.setTag(sparseArray2);
                arrayList.add(g05Var2);
            }
            if ((sparseArray.get(R.id.tag_mul_del_post_type) instanceof Boolean) && ((Boolean) sparseArray.get(R.id.tag_mul_del_post_type)).booleanValue()) {
                g05 g05Var3 = new g05(13, this.c.getString(R.string.multi_delete), k05Var);
                SparseArray sparseArray3 = new SparseArray();
                sparseArray3.put(R.id.tag_del_post_id, sparseArray.get(R.id.tag_del_post_id));
                sparseArray3.put(R.id.tag_del_post_type, sparseArray.get(R.id.tag_del_post_type));
                sparseArray3.put(R.id.tag_del_post_is_self, sparseArray.get(R.id.tag_del_post_is_self));
                sparseArray3.put(R.id.tag_manage_user_identity, sparseArray.get(R.id.tag_manage_user_identity));
                g05Var3.d.setTag(sparseArray3);
                arrayList.add(g05Var3);
            }
            if ((!"".equals(sparseArray.get(R.id.tag_forbid_user_name)) || !"".equals(sparseArray.get(R.id.tag_forbid_user_name_show))) && !a2()) {
                SparseArray sparseArray4 = new SparseArray();
                sparseArray4.put(R.id.tag_forbid_user_name, sparseArray.get(R.id.tag_forbid_user_name));
                sparseArray4.put(R.id.tag_forbid_user_name_show, sparseArray.get(R.id.tag_forbid_user_name_show));
                sparseArray4.put(R.id.tag_forbid_user_portrait, sparseArray.get(R.id.tag_forbid_user_portrait));
                sparseArray4.put(R.id.tag_manage_user_identity, sparseArray.get(R.id.tag_manage_user_identity));
                sparseArray4.put(R.id.tag_forbid_user_post_id, sparseArray.get(R.id.tag_forbid_user_post_id));
                g05 g05Var4 = new g05(11, this.c.getString(R.string.forbidden_person), k05Var);
                g05Var4.d.setTag(sparseArray4);
                arrayList.add(g05Var4);
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
                    g05Var = new g05(12, this.c.getString(R.string.un_mute), k05Var);
                } else {
                    g05Var = new g05(12, this.c.getString(R.string.obfuscated_res_0x7f0f0bfc), k05Var);
                }
                g05Var.d.setTag(sparseArray5);
                arrayList.add(g05Var);
            }
            jo8.f(arrayList);
            if (UbsABTestHelper.isPBPlanA()) {
                k05Var.l(arrayList, false);
            } else {
                k05Var.l(arrayList, true);
            }
            i05 i05Var = new i05(this.c.getPageContext(), k05Var);
            this.U = i05Var;
            i05Var.k();
        }
    }

    public final void H2(PbReplyTitleViewHolder pbReplyTitleViewHolder, boolean z2) {
        boolean z3;
        int measuredHeight;
        int i2;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLZ(1048608, this, pbReplyTitleViewHolder, z2) == null) && !this.p1 && this.Y0 != null && this.h.q() != null) {
            View s3 = J0().s();
            if (s3 != null) {
                int[] iArr = new int[2];
                s3.getLocationInWindow(iArr);
                int i3 = iArr[1];
                if (i3 != 0) {
                    if (this.Y0.getVisibility() == 0 && i3 - this.h.q().getBottom() <= this.Y0.getHeight()) {
                        this.Z0.setVisibility(0);
                        if (i3 > this.h.q().getBottom()) {
                            i2 = -(((this.Y0.getHeight() + this.Z0.getHeight()) + this.h.q().getBottom()) - s3.getBottom());
                        } else {
                            i2 = -this.Y0.getHeight();
                        }
                        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.Y0.getLayoutParams();
                        if (layoutParams.topMargin != i2) {
                            layoutParams.topMargin = i2;
                            this.Y0.setLayoutParams(layoutParams);
                        }
                    } else {
                        this.Z0.setVisibility(4);
                        RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.Y0.getLayoutParams();
                        if (layoutParams2.topMargin != 0) {
                            layoutParams2.topMargin = 0;
                            this.Y0.setLayoutParams(layoutParams2);
                        }
                    }
                }
            }
            int G = this.F.G();
            if (G > 0 && (pbReplyTitleViewHolder == null || pbReplyTitleViewHolder.getView().getParent() == null)) {
                PbLandscapeListView pbLandscapeListView = this.l;
                if (pbLandscapeListView != null && G > pbLandscapeListView.getFirstVisiblePosition() - this.l.getHeaderViewsCount()) {
                    this.Y0.setVisibility(4);
                    return;
                }
                this.Y0.setVisibility(0);
                M3(false);
                this.h.a.hideBottomLine();
                if (this.Y0.getParent() != null && ((ViewGroup) this.Y0.getParent()).getHeight() <= this.Y0.getTop()) {
                    this.Y0.getParent().requestLayout();
                }
            } else if (pbReplyTitleViewHolder != null && pbReplyTitleViewHolder.getView() != null && pbReplyTitleViewHolder.g != null) {
                int top = pbReplyTitleViewHolder.getView().getTop();
                if (pbReplyTitleViewHolder.getView().getParent() != null) {
                    if (this.e1) {
                        this.d1 = top;
                        this.e1 = false;
                    }
                    int i4 = this.d1;
                    if (top < i4) {
                        i4 = top;
                    }
                    this.d1 = i4;
                }
                if (top == 0 && !pbReplyTitleViewHolder.getView().isShown()) {
                    return;
                }
                if (this.E.getY() < 0.0f) {
                    z3 = true;
                } else {
                    z3 = false;
                }
                if (z3) {
                    measuredHeight = n2 - pbReplyTitleViewHolder.g.getMeasuredHeight();
                } else {
                    measuredHeight = this.h.q().getMeasuredHeight() - pbReplyTitleViewHolder.g.getMeasuredHeight();
                    this.h.a.hideBottomLine();
                }
                if (pbReplyTitleViewHolder.getView().getParent() == null && top <= this.d1) {
                    this.Y0.setVisibility(0);
                    M3(false);
                } else if (top < measuredHeight) {
                    this.Y0.setVisibility(0);
                    M3(false);
                } else {
                    this.Y0.setVisibility(4);
                    this.h.a.hideBottomLine();
                }
                if (z2) {
                    this.e1 = true;
                }
            } else {
                PbLandscapeListView pbLandscapeListView2 = this.l;
                if (pbLandscapeListView2 != null && pbLandscapeListView2.getFirstVisiblePosition() == 0) {
                    this.Y0.setVisibility(4);
                    this.h.a.hideBottomLine();
                }
            }
        }
    }

    public final void B4() {
        PbFragment pbFragment;
        int i2;
        String str;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048585, this) == null) && (pbFragment = this.c) != null && pbFragment.L() != null && this.c.L().G != null && this.c.L().G.Q() != null && this.c.L().G.Q().isXiuXiuThread()) {
            ThreadData Q = this.c.L().G.Q();
            int i3 = 0;
            if (this.c.L().b1()) {
                i2 = 1;
            } else if (this.c.L().e1()) {
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

    public void J2() {
        PbLandscapeListView pbLandscapeListView;
        int i2;
        int i3;
        boolean z2;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048616, this) != null) || (pbLandscapeListView = this.l) == null) {
            return;
        }
        int headerViewsCount = pbLandscapeListView.getHeaderViewsCount() - this.o1;
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
        this.f1.c = null;
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004013, this.f1));
        PbReplyTitleViewHolder pbReplyTitleViewHolder = this.f1.c;
        int m1 = m1(pbReplyTitleViewHolder);
        int measuredHeight = this.E.getMeasuredHeight() + ((int) this.E.getY());
        boolean z3 = true;
        if (this.Y0.getVisibility() == 0) {
            z2 = true;
        } else {
            z2 = false;
        }
        if (this.E.getY() >= 0.0f) {
            z3 = false;
        }
        if ((z2 && pbReplyTitleViewHolder != null) || i2 >= this.F.G() + this.l.getHeaderViewsCount()) {
            if (pbReplyTitleViewHolder != null) {
                i4 = pbReplyTitleViewHolder.g.getMeasuredHeight();
            }
            if (z3) {
                this.l.setSelectionFromTop(this.F.G() + this.l.getHeaderViewsCount(), n2 - i4);
            } else {
                this.l.setSelectionFromTop(this.F.G() + this.l.getHeaderViewsCount(), this.h.q().getMeasuredHeight() - i4);
            }
        } else {
            this.l.setSelectionFromTop(i2, i3);
        }
        if (this.p1 && this.t != null) {
            this.l.setSelectionFromTop(this.F.G() + this.l.getHeaderViewsCount(), this.t.d());
        } else if (this.R0 != 6) {
        } else {
            this.l.setOnLayoutListener(new l(this, m1, pbReplyTitleViewHolder, z2, measuredHeight, i2, i3));
        }
    }

    public void k2() {
        NoNetworkView.b bVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048728, this) == null) {
            ll8 ll8Var = this.p;
            if (ll8Var != null) {
                ll8Var.l();
            }
            km8 km8Var = this.r;
            if (km8Var != null) {
                km8Var.o();
            }
            RelativeLayout relativeLayout = this.d;
            if (relativeLayout != null && relativeLayout.getHandler() != null) {
                this.d.getHandler().removeCallbacksAndMessages(null);
            }
            vq8 vq8Var = this.H0;
            if (vq8Var != null) {
                vq8Var.k();
            }
            gm8 gm8Var = this.m1;
            if (gm8Var != null) {
                gm8Var.a();
            }
            xl8 xl8Var = this.C1;
            if (xl8Var != null) {
                xl8Var.c();
            }
            PbTopTipView pbTopTipView = this.t1;
            if (pbTopTipView != null) {
                pbTopTipView.g();
            }
            this.c.hideProgressBar();
            NoNetworkView noNetworkView = this.m;
            if (noNetworkView != null && (bVar = this.T) != null) {
                noNetworkView.e(bVar);
            }
            mb9.d();
            v0();
            D0();
            if (this.j1 != null) {
                jg.a().removeCallbacks(this.j1);
            }
            PbInterviewStatusView pbInterviewStatusView = this.V0;
            if (pbInterviewStatusView != null) {
                pbInterviewStatusView.m();
            }
            MessageManager.getInstance().unRegisterListener(this.T1);
            this.Z1 = null;
            this.g.removeCallbacksAndMessages(null);
            this.F.a0(3);
            View view2 = this.e;
            if (view2 != null) {
                view2.setBackgroundDrawable(null);
            }
            jn8 jn8Var = this.t;
            if (jn8Var != null) {
                jn8Var.a();
            }
            vk8 vk8Var = this.F;
            if (vk8Var != null) {
                vk8Var.c0();
            }
            on8 on8Var = this.x1;
            if (on8Var != null) {
                on8Var.l();
            }
            PbEmotionBar pbEmotionBar = this.g1;
            if (pbEmotionBar != null) {
                pbEmotionBar.x();
            }
            in8 in8Var = this.w;
            if (in8Var != null) {
                in8Var.D();
            }
            PbReplyTitleViewHolder pbReplyTitleViewHolder = this.b1;
            if (pbReplyTitleViewHolder != null) {
                pbReplyTitleViewHolder.p(null);
            }
            this.z1 = null;
            PbLandscapeListView pbLandscapeListView = this.l;
            if (pbLandscapeListView != null) {
                pbLandscapeListView.setOnLayoutListener(null);
                this.l.getViewTreeObserver().removeGlobalOnLayoutListener(this.a);
                this.l.setListViewDragListener(null);
                this.l.J();
                this.l = null;
            }
            AgreeView agreeView = this.C0;
            if (agreeView != null) {
                agreeView.setAgreeLongClickListener(null);
                this.C0.setAfterClickListener(null);
            }
            a1 a1Var = this.f1;
            if (a1Var != null) {
                a1Var.c = null;
            }
        }
    }

    public void m0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048736, this) == null) {
            if (!this.c.checkUpIsLogin()) {
                TiebaStatic.log(new StatisticItem(CommonStatisticKey.KEY_RD_USE).param("obj_param1", 3).param("obj_locate", 2).param("obj_type", 1).param("obj_source", UtilHelper.getCurrentPageName(TbadkCoreApplication.getInst().getCurrentActivity())));
                mp8.r("c10517", this.l0, 2);
            } else if (!this.c.e5()) {
                TiebaStatic.log(new StatisticItem(CommonStatisticKey.KEY_RD_USE).param("obj_param1", 3).param("obj_locate", 8).param("obj_type", 1).param("obj_source", UtilHelper.getCurrentPageName(TbadkCoreApplication.getInst().getCurrentActivity())));
            } else {
                od5 J5 = this.c.J5();
                if (J5 != null && (J5.x() || J5.z())) {
                    TiebaStatic.log(new StatisticItem(CommonStatisticKey.KEY_RD_USE).param("obj_param1", 3).param("obj_locate", 10).param("obj_type", 1).param("obj_source", UtilHelper.getCurrentPageName(TbadkCoreApplication.getInst().getCurrentActivity())));
                    this.c.J5().w(false, null);
                    return;
                }
                if (this.o0 != null) {
                    J1();
                }
                EditorTools editorTools = this.o0;
                if (editorTools != null) {
                    this.L0 = false;
                    if (editorTools.p(2) != null) {
                        mb9.c(this.c.getPageContext(), (View) this.o0.p(2).m, false, w2);
                    }
                }
                v1();
            }
        }
    }

    public void n2() {
        bc9 bc9Var;
        int i2;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048743, this) != null) || this.c == null) {
            return;
        }
        if (!this.J1 && this.K1 != 17) {
            if (this.q1 && !this.p1 && (bc9Var = this.Q0) != null && bc9Var.r() != null) {
                int i3 = 2;
                if (this.c.x0()) {
                    i2 = 2;
                } else {
                    i2 = 1;
                }
                if (!this.p1) {
                    i3 = 1;
                }
                mp8.q("c12601", i3, i2);
                MessageManager.getInstance().sendMessage(new CustomMessage(2002003, new PersonInfoActivityConfig(this.c.getPageContext().getPageActivity(), this.Q0.r().getUserId(), this.Q0.r().getUserName(), this.c.L().V0(), AddFriendActivityConfig.TYPE_PB_HEAD)));
                return;
            }
            return;
        }
        ki8 ki8Var = this.P0;
        if (ki8Var != null && ki8Var.l() != null && !gi.isEmpty(this.P0.l().getName())) {
            MessageManager.getInstance().sendMessage(new CustomMessage(2003000, new FrsActivityConfig(this.c.getContext()).createNormalCfg(this.P0.l().getName(), null)));
            TiebaStatic.log(new StatisticItem("c13853").param("post_id", this.P0.S()).param("uid", TbadkCoreApplication.getCurrentAccountId()).param("fid", this.P0.l().getId()));
        }
    }

    public void r2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048763, this) == null) {
            TiebaStatic.log(new StatisticItem(CommonStatisticKey.KEY_RD_USE).param("obj_param1", 3).param("obj_locate", 1).param("obj_type", 1).param("obj_source", UtilHelper.getCurrentPageName(TbadkCoreApplication.getInst().getCurrentActivity())));
            if (!DialogLoginHelper.checkUpIsLogin(new LoginDialogData(this.c.getActivity(), LoginDialogData.PB_BOTTOM_REPLY_RESULT_PAGE))) {
                TiebaStatic.log(new StatisticItem(CommonStatisticKey.KEY_RD_USE).param("obj_param1", 3).param("obj_locate", 2).param("obj_type", 1).param("obj_source", UtilHelper.getCurrentPageName(TbadkCoreApplication.getInst().getCurrentActivity())));
                return;
            }
            v4();
            this.c.B6();
            PbFragment pbFragment = this.c;
            if (pbFragment != null && pbFragment.L() != null && this.c.L().w1() != null && this.c.L().w1().Q() != null && this.c.L().w1().Q().getAuthor() != null) {
                TiebaStatic.log(new StatisticItem("c13701").param("tid", this.c.L().R1()).param("fid", this.c.L().w1().m()).param("uid", TbadkCoreApplication.getCurrentAccountId()));
                TiebaStatic.log(new StatisticItem("c13402").param("tid", this.c.L().b).param("fid", this.c.L().w1().m()).param("obj_locate", 1).param("uid", TbadkCoreApplication.getCurrentAccount()));
            }
        }
    }

    public void C3(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, str) == null) {
            this.z0.performClick();
            if (!StringUtils.isNull(str) && this.c.J5() != null && this.c.J5().s() != null && this.c.J5().s().i() != null) {
                EditText i2 = this.c.J5().s().i();
                i2.setText(str);
                i2.setSelection(str.length());
            }
        }
    }

    public final void H1(ki8 ki8Var) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048607, this, ki8Var) != null) || ki8Var == null || ki8Var.Q() == null || !ki8Var.Q().isInterviewLive() || this.V0 != null) {
            return;
        }
        PbInterviewStatusView pbInterviewStatusView = (PbInterviewStatusView) this.U0.inflate();
        this.V0 = pbInterviewStatusView;
        pbInterviewStatusView.setOnClickListener(this.Q);
        this.V0.setCallback(this.c.C5());
        this.V0.setData(this.c, ki8Var);
    }

    public final int R0(int i2) {
        InterceptResult invokeI;
        int i3;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048646, this, i2)) == null) {
            PbLandscapeListView pbLandscapeListView = this.l;
            if (pbLandscapeListView == null) {
                return 0;
            }
            xm adapter2 = pbLandscapeListView.getAdapter2();
            if (adapter2 == null) {
                return i2;
            }
            if (i2 < adapter2.getCount() && i2 >= 0 && (adapter2.getItem(i2) instanceof hi8)) {
                i2++;
            }
            int o3 = (adapter2.o() + adapter2.m()) - 1;
            if (i2 > o3) {
                i2 = o3;
            }
            if (this.l.getAdapter2() != null && (this.l.getAdapter2() instanceof xm)) {
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

    public void R3(boolean z2) {
        TextView textView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048649, this, z2) == null) && this.v0 != null && (textView = this.z0) != null) {
            textView.setText(R.string.obfuscated_res_0x7f0f0557);
            if (z2) {
                AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
                alphaAnimation.setDuration(400L);
                this.v0.startAnimation(alphaAnimation);
            }
            this.u0.setVisibility(0);
            this.v0.setVisibility(0);
            this.L0 = true;
            if (this.g1 != null && !this.y1.l()) {
                this.g1.setVisibility(0);
                T2(true);
            }
        }
    }

    public void Z2(String str) {
        PbReplyTitleViewHolder pbReplyTitleViewHolder;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048680, this, str) == null) && this.L != null) {
            int i2 = 0;
            a1 a1Var = this.f1;
            if (a1Var != null && (pbReplyTitleViewHolder = a1Var.c) != null && pbReplyTitleViewHolder.getView() != null) {
                i2 = this.f1.c.getView().getTop() < 0 ? this.f1.c.getView().getHeight() : this.f1.c.getView().getBottom();
            }
            this.L.I(str, i2);
        }
    }

    public final void m4(ki8 ki8Var) {
        boolean z2;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048740, this, ki8Var) == null) && !this.B1 && ki8Var != null && ki8Var.Q() != null && !ki8Var.Q().isVideoThreadType()) {
            boolean z3 = false;
            if (ki8Var.Q().getIs_good() == 1) {
                z2 = true;
            } else {
                z2 = false;
            }
            if (ki8Var.Q().getIs_top() == 1) {
                z3 = true;
            }
            in8 in8Var = this.w;
            if (in8Var != null) {
                in8Var.q(ki8Var, z2, z3);
            }
            gn8 gn8Var = this.v;
            if (gn8Var != null) {
                gn8Var.b(ki8Var, z2, z3);
            }
        }
    }

    public void p0(boolean z2) {
        int i2;
        int i3;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048751, this, z2) == null) {
            PbLandscapeListView pbLandscapeListView = this.l;
            int i4 = 0;
            if (pbLandscapeListView != null) {
                if (z2) {
                    SkinManager.setBackgroundColor(pbLandscapeListView, R.color.CAM_X0202);
                } else {
                    pbLandscapeListView.setBackgroundResource(0);
                }
            }
            View view2 = this.r0;
            if (view2 != null) {
                if (z2) {
                    i3 = 8;
                } else {
                    i3 = 0;
                }
                view2.setVisibility(i3);
            }
            PbListView pbListView = this.L;
            if (pbListView != null) {
                if (z2) {
                    i2 = 8;
                } else {
                    i2 = 0;
                }
                pbListView.N(i2);
            }
            View view3 = this.N;
            if (view3 != null) {
                if (z2) {
                    i4 = 8;
                }
                view3.setVisibility(i4);
            }
        }
    }

    public void D2(@NonNull View view2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048592, this, view2) == null) && this.C0.getData() != null && this.C0.getData().hasAgree && this.c.getActivity() != null) {
            mh8 mh8Var = new mh8(this.c.getContext());
            int g2 = hi.g(TbadkCoreApplication.getInst(), R.dimen.tbds774);
            int g3 = hi.g(TbadkCoreApplication.getInst(), R.dimen.obfuscated_res_0x7f07077f);
            int[] iArr = new int[2];
            view2.getLocationInWindow(iArr);
            int i2 = iArr[0];
            int i3 = iArr[1];
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(g3, g2);
            layoutParams.leftMargin = ((view2.getWidth() / 2) + i2) - ((int) ((g3 * 1) / 1.45d));
            layoutParams.topMargin = hi.g(TbadkCoreApplication.getInst(), R.dimen.M_H_X006);
            mh8Var.k(g2);
            mh8Var.j(layoutParams);
            mh8Var.i(false);
            mh8Var.n(true, this.c.getActivity().findViewById(16908290), 0, i3, this.P0.S(), this.P0.m());
            mh8Var.l(new o(this));
        }
    }

    public final boolean Q3(ki8 ki8Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048645, this, ki8Var)) == null) {
            if (ki8Var == null || ki8Var.Q() == null) {
                return false;
            }
            if (ki8Var.Q().getIsLive() != 1 && ki8Var.Q().getThreadType() != 33 && ((ki8Var.Q().getTopicData() == null || ki8Var.Q().getTopicData().a() == 0) && ki8Var.Q().getIs_top() != 1 && ki8Var.Q().getIs_good() != 1 && !ki8Var.Q().isActInfo() && !ki8Var.Q().isInterviewLive() && !ki8Var.Q().isVoteThreadType() && ki8Var.Q().getYulePostActivityData() == null && gi.isEmpty(ki8Var.Q().getCategory()) && !ki8Var.Q().isGodThread() && !ki8Var.Q().isRealGod())) {
                return false;
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public void l2(TbRichText tbRichText) {
        ki8 ki8Var;
        bc9 bc9Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048733, this, tbRichText) == null) && (ki8Var = this.P0) != null && ki8Var.H() != null && !this.P0.H().isEmpty() && tbRichText != null && !StringUtils.isNull(tbRichText.getAuthorId())) {
            for (int i2 = 0; i2 < this.P0.H().size() && (bc9Var = this.P0.H().get(i2)) != null && bc9Var.r() != null && !StringUtils.isNull(bc9Var.r().getUserId()); i2++) {
                if (this.P0.H().get(i2).r().getUserId().equals(tbRichText.getAuthorId())) {
                    kk8 kk8Var = this.y1;
                    if (kk8Var != null && kk8Var.l()) {
                        N3(false);
                    }
                    PbEmotionBar pbEmotionBar = this.g1;
                    if (pbEmotionBar != null) {
                        pbEmotionBar.q(true);
                    }
                    bc9Var.r().getName_show();
                    return;
                }
            }
        }
    }

    public void t0(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048771, this, str) == null) {
            if (str.contains("_")) {
                str = str.replace("_", "\n");
            }
            zz4 zz4Var = new zz4(this.c.getPageContext().getPageActivity());
            View inflate = LayoutInflater.from(this.c.getPageContext().getPageActivity()).inflate(R.layout.upgrade_success_dialog_content, (ViewGroup) null);
            TextView textView = (TextView) inflate.findViewById(R.id.title_view);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
            layoutParams.setMargins(0, 0, 0, 0);
            textView.setLayoutParams(layoutParams);
            textView.setGravity(3);
            textView.setText(str);
            ((TextView) inflate.findViewById(R.id.function_description_view)).setVisibility(8);
            zz4Var.setContentView(inflate);
            SparseArray sparseArray = new SparseArray();
            sparseArray.put(p2, Integer.valueOf(s2));
            zz4Var.setYesButtonTag(sparseArray);
            zz4Var.setPositiveButton(R.string.obfuscated_res_0x7f0f1681, this.c);
            zz4Var.setNegativeButton(R.string.obfuscated_res_0x7f0f038e, new s0(this));
            zz4Var.create(this.c.getPageContext()).show();
        }
    }

    public void u4(ii8 ii8Var) {
        String string;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048780, this, ii8Var) != null) || ii8Var == null) {
            return;
        }
        this.h.L();
        if (!StringUtils.isNull(ii8Var.b)) {
            this.h.H(ii8Var.b);
        }
        String string2 = TbadkCoreApplication.getInst().getResources().getString(R.string.obfuscated_res_0x7f0f14c1);
        int e2 = gg.e(ii8Var.a, 0);
        if (e2 != 100) {
            if (e2 != 300) {
                if (e2 != 400) {
                    string = "";
                } else {
                    string = TbadkCoreApplication.getInst().getResources().getString(R.string.obfuscated_res_0x7f0f1437);
                }
            } else {
                string = TbadkCoreApplication.getInst().getResources().getString(R.string.obfuscated_res_0x7f0f0304);
            }
        } else {
            string = TbadkCoreApplication.getInst().getResources().getString(R.string.obfuscated_res_0x7f0f11e5);
        }
        this.c.showNetRefreshView(this.d, String.format(string2, string), null, TbadkCoreApplication.getInst().getResources().getString(R.string.appeal_restore), true, new l0(this, ii8Var.c));
    }

    public final boolean F3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048601, this)) == null) {
            ki8 ki8Var = this.P0;
            if (ki8Var != null && ki8Var.Q() != null && !ListUtils.isEmpty(this.P0.Q().getThreadRecommendInfoDataList()) && this.c != null && this.v.d() != null && this.v.d().getVisibility() == 0 && this.P0.Q().getThreadRecommendInfoDataList().get(0) != null && this.P0.Q().getThreadRecommendInfoDataList().get(0).businessType == 1) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public final void G2() {
        ro8 ro8Var;
        ki8 ki8Var;
        boolean z2;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048604, this) == null) && this.v != null && (ro8Var = this.h) != null && ro8Var.q() != null && (ki8Var = this.P0) != null && ki8Var.Q() != null && this.P0.Q().isQuestionThread() && this.v.d() != null && this.v.d().getVisibility() == 0) {
            int[] iArr = new int[2];
            this.v.d().getLocationInWindow(iArr);
            boolean z3 = true;
            int height = iArr[1] + this.v.d().getHeight();
            if (this.v.d().getParent() == null) {
                z2 = false;
            } else {
                z2 = true;
            }
            ro8 ro8Var2 = this.h;
            if (height > ro8Var2.q().getBottom() && z2) {
                z3 = false;
            }
            ro8Var2.I(z3, this.P0.Q().getSpan_str());
        }
    }

    public final void I1() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048611, this) != null) || !this.c.D5()) {
            return;
        }
        ViewStub viewStub = (ViewStub) this.d.findViewById(R.id.obfuscated_res_0x7f091612);
        this.k = viewStub;
        viewStub.setVisibility(0);
        if (this.B == null) {
            this.B = (LinearLayout) this.d.findViewById(R.id.obfuscated_res_0x7f091611);
            tl5.a(this.c.getPageContext(), this.B);
        }
        if (this.C == null) {
            this.C = (TextView) this.B.findViewById(R.id.obfuscated_res_0x7f091616);
        }
        if (this.D == null) {
            this.D = (TextView) this.B.findViewById(R.id.obfuscated_res_0x7f091615);
        }
        this.C.setOnClickListener(this.Q);
        this.D.setOnClickListener(this.Q);
    }

    public void J1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048615, this) == null) {
            if (this.c != null && this.o0 != null) {
                TiebaStatic.log(new StatisticItem(CommonStatisticKey.KEY_RD_USE).param("obj_param1", 3).param("obj_locate", 9).param("obj_type", 1).param("obj_source", UtilHelper.getCurrentPageName(TbadkCoreApplication.getInst().getCurrentActivity())));
                this.o0.j();
                v1();
                return;
            }
            TiebaStatic.log(new StatisticItem(CommonStatisticKey.KEY_RD_USE).param("obj_param1", 3).param("obj_locate", 20).param("obj_type", 1).param("obj_source", UtilHelper.getCurrentPageName(TbadkCoreApplication.getInst().getCurrentActivity())));
        }
    }

    public int N0() {
        InterceptResult invokeV;
        View childAt;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048630, this)) == null) {
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

    public final void S2() {
        PbFragment pbFragment;
        int i2;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048652, this) == null) && (pbFragment = this.c) != null && pbFragment.J5() != null && this.o0 != null) {
            jd5.a().c(0);
            od5 J5 = this.c.J5();
            J5.M();
            J5.K();
            if (J5.v() != null) {
                WriteImagesInfo v3 = J5.v();
                if (J5.t) {
                    i2 = 1;
                } else {
                    i2 = 9;
                }
                v3.setMaxImagesAllowed(i2);
            }
            J5.d0(SendView.h);
            J5.h(SendView.h);
            sb5 o3 = this.o0.o(23);
            sb5 o4 = this.o0.o(2);
            sb5 o5 = this.o0.o(5);
            if (o4 != null) {
                o4.display();
            }
            if (o5 != null) {
                o5.display();
            }
            if (o3 != null) {
                o3.hide();
            }
            this.o0.invalidate();
        }
    }

    public final void f2() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048704, this) == null) && UbsABTestHelper.isShareTopRight()) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.D0.getLayoutParams();
            layoutParams.addRule(11);
            this.D0.setLayoutParams(layoutParams);
            if (this.E0.getParent() != null) {
                ((ViewGroup) this.E0.getParent()).removeView(this.E0);
                ((ViewGroup) this.F0.getParent()).removeView(this.F0);
            }
            if (this.G0.getParent() != null) {
                ((ViewGroup) this.G0.getParent()).removeView(this.G0);
            }
            RelativeLayout relativeLayout = new RelativeLayout(TbadkCoreApplication.getInst().getContext());
            relativeLayout.addView(this.E0);
            relativeLayout.addView(this.F0);
            relativeLayout.addView(this.G0);
            this.h.a.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, relativeLayout, (View.OnClickListener) null);
            this.h.a.getViewGroup(NavigationBar.ControlAlign.HORIZONTAL_RIGHT).setClipChildren(false);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:24:0x0051, code lost:
        if (r5.L1 == 1) goto L19;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void u0() {
        uq8 uq8Var;
        int i2;
        boolean z2;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048776, this) != null) || (uq8Var = this.O1) == null) {
            return;
        }
        if (this.l != null && uq8Var.a() != null && this.O1.a().getParent() != null) {
            i2 = this.l.getPositionForView(this.O1.a());
        } else {
            i2 = -1;
        }
        boolean z3 = false;
        if (i2 != -1) {
            if (this.O1.a().getTop() + u2 <= this.Y0.getBottom()) {
                this.L1 = 1;
                z2 = true;
            } else {
                this.L1 = 0;
                z2 = false;
            }
        }
        PbReplyTitleViewHolder pbReplyTitleViewHolder = this.b1;
        if (this.L1 == 1) {
            z3 = true;
        }
        pbReplyTitleViewHolder.t(z3);
        this.O1.e(z2);
    }

    public void y3() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048799, this) == null) {
            this.c.hideProgressBar();
            ki8 ki8Var = this.P0;
            if (ki8Var != null && this.L != null && ki8Var.z() != null && this.P0.z().b() == 0) {
                this.L.x(this.P0.t());
                if (this.P0.t()) {
                    StatisticItem statisticItem = new StatisticItem(CommonStatisticKey.KEY_PB_FOLD_ICON_SHOW);
                    statisticItem.param("uid", TbadkCoreApplication.getCurrentAccount());
                    statisticItem.param("fid", this.P0.m());
                    statisticItem.param("fname", this.P0.n());
                    statisticItem.param("tid", this.P0.S());
                    TiebaStatic.log(statisticItem);
                }
            }
            D0();
            PbLandscapeListView pbLandscapeListView = this.l;
            if (pbLandscapeListView != null) {
                pbLandscapeListView.z(0L);
            }
            y0();
        }
    }

    public final boolean G3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048605, this)) == null) {
            PbFragment pbFragment = this.c;
            if (pbFragment == null || pbFragment.L().w1().l().getDeletedReasonInfo() == null || 1 != this.c.L().w1().l().getDeletedReasonInfo().is_grays_cale_forum.intValue()) {
                return false;
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    public void I3() {
        View view2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048613, this) == null) {
            PbLandscapeListView pbLandscapeListView = this.l;
            int i2 = 0;
            if (pbLandscapeListView != null) {
                pbLandscapeListView.setVisibility(0);
            }
            FrameLayout frameLayout = this.W0;
            if (frameLayout != null) {
                frameLayout.setVisibility(0);
            }
            ro8 ro8Var = this.h;
            if (ro8Var != null && (view2 = ro8Var.d) != null) {
                if (!TbadkCoreApplication.isLogin()) {
                    i2 = 8;
                }
                view2.setVisibility(i2);
            }
        }
    }

    public final void Q2() {
        PbFragment pbFragment;
        WaterRippleView waterRippleView;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048644, this) != null) || (pbFragment = this.c) == null || pbFragment.getActivity() == null || (waterRippleView = this.A0) == null) {
            return;
        }
        ViewParent parent = waterRippleView.getParent();
        if (parent instanceof ViewGroup) {
            ((ViewGroup) parent).removeView(this.A0);
        }
        TextView textView = this.I0;
        if (textView != null) {
            textView.setVisibility(0);
        }
    }

    public void R2() {
        PbLandscapeListView pbLandscapeListView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048648, this) == null) && (pbLandscapeListView = this.l) != null) {
            this.z.d(pbLandscapeListView);
            this.v.h(this.l);
            this.w.F(this.l);
            this.x.d(this.l);
            this.u.f(this.l);
        }
    }

    public boolean X1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048671, this)) == null) {
            View view2 = this.c1;
            if (view2 == null || view2.getParent() == null || this.L.o()) {
                return false;
            }
            int bottom = this.c1.getBottom();
            Rect rect = new Rect();
            this.c1.getWindowVisibleDisplayFrame(rect);
            if (bottom <= 0 || bottom > rect.bottom) {
                return false;
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    /* JADX WARN: Code restructure failed: missing block: B:12:0x001e, code lost:
        if (r0 < 0) goto L13;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public int Y0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048674, this)) == null) {
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
            return R0(i2);
        }
        return invokeV.intValue;
    }

    public boolean Y1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048675, this)) == null) {
            ki8 ki8Var = this.P0;
            if (ki8Var == null || ki8Var.l() == null || "0".equals(this.P0.l().getId()) || "me0407".equals(this.P0.l().getName())) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public final void h4() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048715, this) == null) {
            PbFallingView pbFallingView = this.Q1;
            if (pbFallingView != null) {
                pbFallingView.setTag(Boolean.TRUE);
            }
            RightFloatLayerView rightFloatLayerView = this.R1;
            if (rightFloatLayerView != null && rightFloatLayerView.getTag() == this.Q1) {
                this.R1.setTag(null);
                this.R1.setAutoCompleteShown(true);
                this.R1.d();
            }
        }
    }

    public boolean k0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048726, this)) == null) {
            PbListView pbListView = this.L;
            if (pbListView != null && !TextUtils.isEmpty(pbListView.i())) {
                return this.L.i().equals(TbadkCoreApplication.getInst().getResources().getString(R.string.list_has_no_more));
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public final void l0() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048731, this) == null) && this.P0 != null && UbsABTestHelper.isResizeInduceSharingABTest() && !lo8.k(this.P0.S())) {
            this.H0.f();
            lo8.b(this.P0.S());
        }
    }

    public String l1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048732, this)) == null) {
            if (!gi.isEmpty(this.G1)) {
                return this.G1;
            }
            if (this.c != null) {
                this.G1 = TbadkCoreApplication.getInst().getResources().getString(mm8.g());
            }
            return this.G1;
        }
        return (String) invokeV.objValue;
    }

    public final void q0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048756, this) == null) {
            kk8 kk8Var = new kk8(this.c, this, (ViewStub) this.d.findViewById(R.id.obfuscated_res_0x7f0916d7));
            this.y1 = kk8Var;
            kk8Var.o(this.Q);
            this.y1.p(this.V);
            this.y1.q(this.S);
            this.y1.o(this.Q);
            this.y1.s(this.m0);
        }
    }

    public void v0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048781, this) == null) {
            this.h.k();
            in8 in8Var = this.w;
            if (in8Var != null) {
                in8Var.r();
            }
            PbFragment pbFragment = this.c;
            if (pbFragment != null) {
                hi.z(pbFragment.getContext(), this.J);
            }
            x1();
            i05 i05Var = this.f0;
            if (i05Var != null) {
                i05Var.dismiss();
            }
            z0();
            zz4 zz4Var = this.G;
            if (zz4Var != null) {
                zz4Var.dismiss();
            }
            b05 b05Var = this.H;
            if (b05Var != null) {
                b05Var.e();
            }
        }
    }

    public final void v4() {
        PbFragment pbFragment;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048785, this) == null) && (pbFragment = this.c) != null && pbFragment.J5() != null) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921706, Boolean.valueOf(!this.c.J5().y())));
        }
    }

    public void w0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048786, this) == null) {
            this.h.k();
            in8 in8Var = this.w;
            if (in8Var != null) {
                in8Var.r();
            }
            i05 i05Var = this.f0;
            if (i05Var != null) {
                i05Var.dismiss();
            }
            z0();
            zz4 zz4Var = this.G;
            if (zz4Var != null) {
                zz4Var.dismiss();
            }
            b05 b05Var = this.H;
            if (b05Var != null) {
                b05Var.e();
            }
        }
    }

    public final void y4() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048800, this) != null) || !this.c.D5()) {
            return;
        }
        if (this.c.I5() == -1) {
            SkinManager.setViewTextColor(this.C, R.color.CAM_X0110, 1);
        }
        if (this.c.H5() == -1) {
            SkinManager.setViewTextColor(this.D, R.color.CAM_X0110, 1);
        }
    }

    public void z0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048801, this) == null) {
            zz4 zz4Var = this.W;
            if (zz4Var != null) {
                zz4Var.dismiss();
            }
            Dialog dialog = this.X;
            if (dialog != null) {
                lg.b(dialog, this.c.getPageContext());
            }
            Dialog dialog2 = this.Y;
            if (dialog2 != null) {
                lg.b(dialog2, this.c.getPageContext());
            }
            i05 i05Var = this.U;
            if (i05Var != null) {
                i05Var.dismiss();
            }
        }
    }

    public final String H0(long j2) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJ = interceptable.invokeJ(1048606, this, j2)) == null) {
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

    public final String I0(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048610, this, i2)) == null) {
            if (i2 == 0) {
                return this.c.getString(R.string.obfuscated_res_0x7f0f0eb0);
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

    public final void K3(SparseArray<Object> sparseArray) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048621, this, sparseArray) != null) || this.c == null) {
            return;
        }
        if (sparseArray != null) {
            sparseArray.put(R.id.tag_is_block_thread, Boolean.TRUE);
        }
        TBAlertConfig.a aVar = new TBAlertConfig.a((int) R.string.obfuscated_res_0x7f0f1260, TBAlertConfig.OperateBtnStyle.MAIN);
        TBAlertConfig.a aVar2 = new TBAlertConfig.a((int) R.string.obfuscated_res_0x7f0f038e, TBAlertConfig.OperateBtnStyle.SECONDARY);
        TBAlertBuilder tBAlertBuilder = new TBAlertBuilder(this.c.M());
        tBAlertBuilder.w(R.string.musk_my_thread_confirm);
        tBAlertBuilder.m(R.string.musk_my_thread_confirm_subtitle);
        tBAlertBuilder.o(true);
        tBAlertBuilder.u(aVar2, aVar);
        tBAlertBuilder.j(false);
        AlertDialog z2 = tBAlertBuilder.z();
        aVar.a(new z(this, z2, sparseArray));
        aVar2.a(new a0(this, z2));
    }

    public void X2(EditorTools editorTools) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048672, this, editorTools) == null) {
            this.o0 = editorTools;
            editorTools.setOnCancelClickListener(new s(this));
            this.o0.setId(R.id.obfuscated_res_0x7f091981);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
            layoutParams.addRule(12);
            if (this.o0.getParent() == null) {
                this.d.addView(this.o0, layoutParams);
            }
            this.o0.y(TbadkCoreApplication.getInst().getSkinType());
            this.o0.setActionListener(24, new t(this));
            x1();
            this.c.J5().g(new u(this));
        }
    }

    public void h2(rb9 rb9Var) {
        ki8 ki8Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048713, this, rb9Var) == null) && rb9Var != null && rb9Var.b != null && (ki8Var = this.P0) != null && ki8Var.Q() != null && this.P0.Q().getAgreeData() != null) {
            AgreeData agreeData = this.P0.Q().getAgreeData();
            String str = rb9Var.b.nid;
            if (!TextUtils.isEmpty(str) && !"0".equals(str)) {
                BaijiahaoData baijiahaoData = agreeData.baijiahaoData;
                if (baijiahaoData == null || !TextUtils.equals(str, baijiahaoData.oriUgcNid)) {
                    return;
                }
            } else {
                String str2 = rb9Var.b.threadId;
                String str3 = agreeData.threadId;
                if ("0".equals(str2) || TextUtils.isEmpty(str2) || !TextUtils.equals(str2, str3)) {
                    return;
                }
            }
            AgreeData agreeData2 = rb9Var.b;
            K2(agreeData2, agreeData2.agreeNum);
        }
    }

    public void j2(Configuration configuration) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048723, this, configuration) != null) || configuration == null) {
            return;
        }
        v0();
        if (configuration.orientation == 2) {
            v1();
            x1();
        } else {
            U2();
        }
        hl8 hl8Var = this.l1;
        if (hl8Var != null) {
            hl8Var.g();
        }
        this.c.Y5();
        this.E.setVisibility(8);
        this.h.D(false);
        this.c.R6(false);
        if (this.t != null) {
            if (configuration.orientation == 1) {
                s1().setVisibility(0);
            }
            if (configuration.orientation == 2) {
                this.m2 = true;
                PbLandscapeListView pbLandscapeListView = this.l;
                if (pbLandscapeListView != null) {
                    pbLandscapeListView.setIsLandscape(true);
                    this.l.smoothScrollToPosition(0);
                }
            } else {
                this.m2 = false;
                PbLandscapeListView pbLandscapeListView2 = this.l;
                if (pbLandscapeListView2 != null) {
                    pbLandscapeListView2.setIsLandscape(false);
                    int i2 = this.k2;
                    if (i2 > 0) {
                        this.l.smoothScrollBy(i2, 0);
                    }
                }
            }
            this.t.j(configuration);
            this.W0.setLayoutParams(new RelativeLayout.LayoutParams(-2, -2));
        }
    }

    public void k4(boolean z2) {
        TextView textView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048730, this, z2) == null) && this.l != null && (textView = this.X0) != null && this.e != null) {
            if (z2) {
                if (UtilHelper.canUseStyleImmersiveSticky()) {
                    this.e.setVisibility(0);
                } else {
                    this.e.setVisibility(8);
                    this.l.removeHeaderView(this.X0);
                    this.l.setTextViewAdded(false);
                }
                if (this.X0.getLayoutParams() instanceof AbsListView.LayoutParams) {
                    AbsListView.LayoutParams layoutParams = (AbsListView.LayoutParams) this.X0.getLayoutParams();
                    layoutParams.height = n2;
                    this.X0.setLayoutParams(layoutParams);
                }
                V2();
                return;
            }
            if (textView.getLayoutParams() instanceof AbsListView.LayoutParams) {
                AbsListView.LayoutParams layoutParams2 = (AbsListView.LayoutParams) this.X0.getLayoutParams();
                layoutParams2.height = BdListViewHelper.a(BdListViewHelper.HeadType.DEFAULT) + d1(true);
                this.X0.setLayoutParams(layoutParams2);
            }
            V2();
            O2();
        }
    }

    public void w1(boolean z2) {
        boolean z3;
        boolean z4;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048787, this, z2) == null) && this.v0 != null && this.z0 != null) {
            TbSingleton tbSingleton = TbSingleton.getInstance();
            ki8 ki8Var = this.P0;
            if (ki8Var != null && ki8Var.r0()) {
                z3 = true;
            } else {
                z3 = false;
            }
            ki8 ki8Var2 = this.P0;
            if (ki8Var2 != null && ki8Var2.s0()) {
                z4 = true;
            } else {
                z4 = false;
            }
            this.z0.setText(tbSingleton.getAdVertiComment(z3, z4, l1()));
            if (z2) {
                AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
                alphaAnimation.setDuration(400L);
                this.v0.startAnimation(alphaAnimation);
            }
            this.u0.setVisibility(0);
            this.v0.setVisibility(0);
            this.L0 = true;
            if (this.g1 != null && !this.y1.l()) {
                this.g1.setVisibility(0);
                T2(true);
            }
        }
    }

    public void w4(ki8 ki8Var) {
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048790, this, ki8Var) == null) {
            if (ki8Var != null && AntiHelper.o(ki8Var.Q())) {
                vq8 vq8Var = this.H0;
                if (vq8Var != null) {
                    vq8Var.l(false);
                    this.H0.k();
                }
                ViewGroup.LayoutParams layoutParams = this.E0.getLayoutParams();
                layoutParams.height = -2;
                layoutParams.width = -2;
                this.E0.setLayoutParams(layoutParams);
                WebPManager.setPureDrawable(this.E0, R.drawable.icon_pure_pb_bottom_share26, R.color.CAM_X0110, WebPManager.ResourceStateType.NORMAL_PRESS);
                return;
            }
            vq8 vq8Var2 = this.H0;
            if (vq8Var2 != null && vq8Var2.h()) {
                return;
            }
            ViewGroup.LayoutParams layoutParams2 = this.E0.getLayoutParams();
            layoutParams2.height = -2;
            layoutParams2.width = -2;
            this.E0.setLayoutParams(layoutParams2);
            ImageView imageView = this.E0;
            if (UbsABTestHelper.isShareTopRight()) {
                i2 = R.color.CAM_X0105;
            } else {
                i2 = R.color.CAM_X0107;
            }
            WebPManager.setPureDrawable(imageView, R.drawable.icon_pure_pb_bottom_share26, i2, WebPManager.ResourceStateType.NORMAL_PRESS);
        }
    }

    public void z4(boolean z2) {
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048805, this, z2) == null) {
            vk8 vk8Var = this.F;
            if (vk8Var != null) {
                vk8Var.u0(z2);
                this.F.Z();
            }
            PbReplyTitleViewHolder pbReplyTitleViewHolder = this.b1;
            if (pbReplyTitleViewHolder != null) {
                pbReplyTitleViewHolder.o(z2);
            }
            PbReplyTitleViewHolder pbReplyTitleViewHolder2 = this.f1.c;
            if (pbReplyTitleViewHolder2 != null) {
                pbReplyTitleViewHolder2.o(z2);
            }
            PbFragment pbFragment = this.c;
            if (pbFragment != null) {
                pbFragment.Q6(z2);
            }
            if (z2) {
                ko8.d(this.c.getPageContext(), this.c.L(), this.c.M5());
            }
            StatisticItem statisticItem = new StatisticItem(CommonStatisticKey.KEY_BATCH_MULTI_DEL_CLICK);
            ki8 ki8Var = this.P0;
            if (ki8Var != null) {
                str = ki8Var.m();
            } else {
                str = "0";
            }
            TiebaStatic.log(statisticItem.param("fid", str).param("uid", TbadkCoreApplication.getCurrentAccountId()).param("obj_type", "1"));
        }
    }

    public final void H3() {
        PbFragment pbFragment;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048609, this) == null) && (pbFragment = this.c) != null && pbFragment.getActivity() != null) {
            if (this.C0.getWidth() != 0 && this.C0.getHeight() != 0) {
                WaterRippleView waterRippleView = this.A0;
                if (waterRippleView == null) {
                    this.A0 = new WaterRippleView(this.c.getActivity());
                } else {
                    ViewParent parent = waterRippleView.getParent();
                    if (parent instanceof ViewGroup) {
                        ((ViewGroup) parent).removeView(this.A0);
                    }
                }
                Rect rect = new Rect();
                this.d.getGlobalVisibleRect(rect);
                Rect rect2 = new Rect();
                this.C0.getImgAgree().getGlobalVisibleRect(rect2);
                int g2 = hi.g(this.c.getActivity(), R.dimen.tbds166);
                int i2 = ((rect2.right + rect2.left) / 2) - g2;
                int i3 = (rect.bottom - ((rect2.bottom + rect2.top) / 2)) - g2;
                int i4 = g2 * 2;
                RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(i4, i4);
                layoutParams.addRule(12, -1);
                layoutParams.setMargins(i2, 0, 0, i3);
                this.d.addView(this.A0, layoutParams);
                TextView textView = this.I0;
                if (textView != null) {
                    textView.setVisibility(4);
                    return;
                }
                return;
            }
            BdLog.e("AgreeView not measured");
        }
    }

    public final void d2() {
        PbFragment pbFragment;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048696, this) == null) && (pbFragment = this.c) != null && pbFragment.L() != null && this.c.L().G != null && this.c.L().G.Q() != null && this.c.L().G.Q().isQuestionThread()) {
            ThreadData Q = this.c.L().G.Q();
            String I1 = this.c.L().I1();
            String J1 = this.c.L().J1();
            int i2 = 5;
            if ("question_answer_invite".equals(I1)) {
                i2 = 1;
            } else if ("3".equals(J1)) {
                i2 = 2;
            } else if ("answer_top".equals(I1)) {
                i2 = 3;
            } else if (this.c.L().b1()) {
                i2 = 4;
            }
            TiebaStatic.log(new StatisticItem("c14924").param("uid", TbadkCoreApplication.getCurrentAccountId()).param("tid", Q.getId()).param("fid", Q.getFid()).param("obj_source", i2));
        }
    }

    public final void o0() {
        ki8 ki8Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048746, this) == null) && this.A != null && (ki8Var = this.P0) != null && ki8Var.Q() != null && !ListUtils.isEmpty(this.P0.Q().getThreadRecommendInfoDataList()) && this.P0.Q().getThreadRecommendInfoDataList().get(0) != null && this.v.d().getVisibility() == 0) {
            if (this.v.d().getParent() == null) {
                this.A.g(false);
                return;
            }
            int[] iArr = new int[2];
            this.A.b().getLocationInWindow(iArr);
            if (iArr[1] + this.A.b().getHeight() > this.h.q().getBottom()) {
                this.A.i();
                this.A.g(true);
                return;
            }
            this.A.g(false);
        }
    }

    public void s0() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048766, this) == null) && !this.l2) {
            TiebaStatic.log("c10490");
            this.l2 = true;
            zz4 zz4Var = new zz4(this.c.getPageContext().getPageActivity());
            SparseArray sparseArray = new SparseArray();
            sparseArray.put(p2, Integer.valueOf(r2));
            zz4Var.setTitle(R.string.grade_thread_tips);
            View inflate = LayoutInflater.from(this.c.getPageContext().getPageActivity()).inflate(R.layout.upgrade_success_dialog_content, (ViewGroup) null);
            ((TextView) inflate.findViewById(R.id.function_description_view)).setText(R.string.function_upgrade_to_photo_live_tips);
            ((TextView) inflate.findViewById(R.id.title_view)).setText(R.string.grade_thread_tips);
            zz4Var.setContentView(inflate);
            zz4Var.setYesButtonTag(sparseArray);
            zz4Var.setPositiveButton(R.string.grade_button_tips, this.c);
            zz4Var.setNegativeButton(R.string.look_again, new q0(this));
            zz4Var.create(this.c.getPageContext()).show();
        }
    }

    public final void K1(ki8 ki8Var, k65 k65Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048619, this, ki8Var, k65Var) == null) && this.S1 != null && ki8Var != null && k65Var != null && this.c.getContext() != null) {
            if (!RightFloatLayerView.k()) {
                C1();
                return;
            }
            if (this.R1 == null) {
                RightFloatLayerView E = RightFloatLayerLottieView.E(k65Var, this.c.getContext());
                this.R1 = E;
                E.setPageContext(this.c.getPageContext());
                this.S1.removeAllViews();
                this.S1.addView(this.R1);
            }
            if ((this.Q1.getTag() instanceof Boolean) && !((Boolean) this.Q1.getTag()).booleanValue()) {
                this.R1.setAutoCompleteShown(false);
                this.R1.setTag(this.Q1);
                this.R1.c();
            }
            if (k65Var.a()) {
                return;
            }
            this.R1.setData(k65Var);
            this.R1.setLogoListener(new r0(this, k65Var));
            this.R1.setFeedBackListener(new v0(this, k65Var));
        }
    }

    public final void K2(AgreeData agreeData, long j2) {
        TextView textView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLJ(1048620, this, agreeData, j2) == null) && agreeData != null && (textView = this.I0) != null) {
            if (j2 > 0) {
                if (agreeData.agreeType == 2 && agreeData.hasAgree) {
                    textView.setTextColor(SkinManager.getColor(R.color.CAM_X0301));
                } else {
                    this.I0.setTextColor(SkinManager.getColor(R.color.CAM_X0107));
                }
                this.I0.setText(H0(j2));
                this.I0.setVisibility(0);
                return;
            }
            textView.setVisibility(8);
        }
    }

    public void L1(ki8 ki8Var) {
        k65 pbAdFloatViewItemData;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048623, this, ki8Var) != null) || ki8Var == null) {
            return;
        }
        if (ki8Var.r0()) {
            pbAdFloatViewItemData = ki8Var.d0();
        } else {
            pbAdFloatViewItemData = TbSingleton.getInstance().getPbAdFloatViewItemData();
        }
        if (pbAdFloatViewItemData != null && !pbAdFloatViewItemData.a()) {
            K1(ki8Var, pbAdFloatViewItemData);
        } else {
            C1();
        }
    }

    public void N3(boolean z2) {
        boolean z3;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeZ(1048633, this, z2) != null) || this.v0 == null) {
            return;
        }
        if (this.c.J5() != null && this.c.J5().y()) {
            z3 = true;
        } else {
            z3 = false;
        }
        c3(z3);
        if (this.p0) {
            R3(z2);
        } else {
            w1(z2);
        }
    }

    public final boolean Q1(ki8 ki8Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048643, this, ki8Var)) == null) {
            if (ki8Var == null || ki8Var.Q() == null) {
                return false;
            }
            SpannableStringBuilder span_str = ki8Var.Q().getSpan_str();
            if (span_str == null) {
                return true;
            }
            if (!TbadkApplication.getInst().getResources().getString(R.string.obfuscated_res_0x7f0f0eb1).equals(span_str.toString())) {
                return false;
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public final boolean W1(ThreadData threadData) {
        InterceptResult invokeL;
        String str;
        bc9 Z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048667, this, threadData)) == null) {
            if (threadData != null && threadData.getAuthor() != null) {
                ki8 ki8Var = this.P0;
                if (ki8Var != null && (Z = ki8Var.Z()) != null && Z.r() != null) {
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

    public final int m1(PbReplyTitleViewHolder pbReplyTitleViewHolder) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048737, this, pbReplyTitleViewHolder)) == null) {
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

    public void o2(boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048748, this, z2) == null) {
            if (z2) {
                T3();
            } else {
                y1();
            }
            this.f1.c = null;
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004013, this.f1));
            H2(this.f1.c, false);
        }
    }

    public void t4(boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048775, this, z2) == null) {
            this.h.K(z2);
            if (z2 && this.T0) {
                this.L.F(TbadkCoreApplication.getInst().getResources().getString(R.string.click_load_more));
                PbLandscapeListView pbLandscapeListView = this.l;
                if (pbLandscapeListView != null) {
                    pbLandscapeListView.setNextPage(this.L);
                }
                this.f = 2;
            }
        }
    }

    public final void L2(ki8 ki8Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048624, this, ki8Var) == null) && ki8Var != null && ki8Var.Q() != null) {
            w4(ki8Var);
            ImageView imageView = this.D0;
            if (imageView != null && imageView.getContext() != null) {
                if (ki8Var.r()) {
                    WebPManager.setPureDrawable(this.D0, R.drawable.icon_pure_pb_bottom_collected26_selection, R.color.CAM_X0305, WebPManager.ResourceStateType.NORMAL_PRESS);
                } else {
                    WebPManager.setPureDrawable(this.D0, R.drawable.icon_pure_pb_bottom_collect26, R.color.CAM_X0107, WebPManager.ResourceStateType.NORMAL_PRESS);
                }
            }
            String I0 = I0(ki8Var.Q().getReply_num());
            TextView textView = this.J0;
            if (textView != null) {
                textView.setText(I0);
            }
            TextView textView2 = this.K0;
            if (textView2 != null) {
                textView2.setText(I0);
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921416, ki8Var.Q()));
            K2(ki8Var.Q().getAgreeData(), ki8Var.Q().getAgreeNum());
            if (this.C0 != null && ki8Var.Q() != null) {
                this.C0.setThreadData(ki8Var.Q());
                int i2 = 1;
                if (ki8Var.Q().getAgreeData() != null) {
                    ki8Var.Q().getAgreeData().isInThread = true;
                }
                this.C0.setData(ki8Var.Q().getAgreeData());
                nw4 nw4Var = new nw4();
                nw4Var.b = 26;
                if (ki8Var.Q().isVideoThreadType() && ki8Var.Q().getThreadVideoInfo() != null) {
                    i2 = 2;
                }
                nw4Var.c = i2;
                PbFragment pbFragment = this.c;
                if (pbFragment != null && pbFragment.L() != null) {
                    nw4Var.j = this.c.L().getFromForumId();
                    nw4Var.f = this.c.L().v1();
                }
                this.C0.setStatisticData(nw4Var);
            }
        }
    }

    public void N1(ki8 ki8Var) {
        PbReplyTitleViewHolder pbReplyTitleViewHolder;
        int bottom;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048631, this, ki8Var) == null) {
            int i2 = 0;
            this.F.h0(ki8Var, false);
            this.F.Z();
            y0();
            kk8 kk8Var = this.y1;
            if (kk8Var != null) {
                kk8Var.n();
            }
            ArrayList<bc9> H = ki8Var.H();
            if (ki8Var.z().b() == 0 || H == null || H.size() < ki8Var.z().e()) {
                if (ListUtils.getCount(H) != 0 && (ListUtils.getCount(H) != 1 || H.get(0) == null || H.get(0).E() != 1)) {
                    if (ki8Var.z().b() == 0) {
                        this.L.F(TbadkCoreApplication.getInst().getResources().getString(R.string.list_has_no_more));
                    } else {
                        this.L.F(TbadkCoreApplication.getInst().getResources().getString(R.string.load_more));
                    }
                    this.L.m();
                } else {
                    a1 a1Var = this.f1;
                    if (a1Var != null && (pbReplyTitleViewHolder = a1Var.c) != null && pbReplyTitleViewHolder.getView() != null) {
                        if (this.f1.c.getView().getTop() < 0) {
                            bottom = this.f1.c.getView().getHeight();
                        } else {
                            bottom = this.f1.c.getView().getBottom();
                        }
                        i2 = bottom;
                    }
                    if (this.c.h6()) {
                        this.L.I(TbadkCoreApplication.getInst().getResources().getString(R.string.obfuscated_res_0x7f0f0ec9), i2);
                    } else {
                        this.L.I(TbadkCoreApplication.getInst().getResources().getString(R.string.obfuscated_res_0x7f0f0eca), i2);
                    }
                }
            }
            L2(ki8Var);
        }
    }

    public void O3(ki8 ki8Var) {
        bc9 bc9Var;
        ro8 ro8Var;
        boolean z2;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048637, this, ki8Var) == null) && ki8Var != null && (bc9Var = this.Q0) != null && bc9Var.r() != null && (ro8Var = this.h) != null) {
            boolean z3 = !this.p1;
            this.q1 = z3;
            ro8Var.J(z3);
            if (this.c.K5() != null) {
                this.c.K5().s(this.q1);
            }
            I2();
            PbFragment pbFragment = this.c;
            if (pbFragment != null && !pbFragment.x0() && !ListUtils.isEmpty(ki8Var.p())) {
                iz4 iz4Var = ki8Var.p().get(0);
                if (iz4Var != null) {
                    this.h.N(ki8Var, iz4Var.d(), iz4Var.b(), iz4Var.a(), iz4Var.e());
                }
            } else if (ki8Var.l() != null) {
                ro8 ro8Var2 = this.h;
                String name = ki8Var.l().getName();
                String id = ki8Var.l().getId();
                String image_url = ki8Var.l().getImage_url();
                if (ki8Var.l().isLike() == 1) {
                    z2 = true;
                } else {
                    z2 = false;
                }
                ro8Var2.N(ki8Var, name, id, image_url, z2);
            }
            if (this.q1) {
                this.w.P(ki8Var, this.Q0, this.j0);
                View view2 = this.a1;
                if (view2 != null) {
                    view2.setVisibility(8);
                }
                if (this.z1 == null) {
                    this.z1 = new n0(this);
                }
                PbLandscapeListView pbLandscapeListView = this.l;
                if (pbLandscapeListView != null) {
                    pbLandscapeListView.setListViewDragListener(this.z1);
                    return;
                }
                return;
            }
            View view3 = this.a1;
            if (view3 != null) {
                view3.setVisibility(0);
            }
            this.w.P(ki8Var, this.Q0, this.j0);
            this.z1 = null;
            PbLandscapeListView pbLandscapeListView2 = this.l;
            if (pbLandscapeListView2 != null) {
                pbLandscapeListView2.setListViewDragListener(null);
            }
        }
    }

    public void S3(View view2) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048653, this, view2) != null) || m35.m().i("show_long_press_collection_tips", false)) {
            return;
        }
        Rect rect = new Rect();
        this.v0.getGlobalVisibleRect(rect);
        int i2 = rect.bottom;
        int i3 = rect.top;
        view2.getGlobalVisibleRect(rect);
        int i4 = rect.bottom;
        FrameLayout frameLayout = new FrameLayout(this.c.getContext());
        frameLayout.setBackgroundResource(R.drawable.pic_sign_tip);
        TextView textView = new TextView(this.c.getContext());
        this.v1 = textView;
        textView.setText(R.string.obfuscated_res_0x7f0f046a);
        this.v1.setGravity(17);
        this.v1.setPadding(hi.g(this.c.getContext(), R.dimen.obfuscated_res_0x7f0701e8), 0, hi.g(this.c.getContext(), R.dimen.obfuscated_res_0x7f0701e8), 0);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        layoutParams.gravity = 17;
        layoutParams.height = hi.g(this.c.getContext(), R.dimen.obfuscated_res_0x7f070253);
        if (this.v1.getParent() == null) {
            frameLayout.addView(this.v1, layoutParams);
        }
        PopupWindow popupWindow = new PopupWindow(this.c.getContext());
        this.u1 = popupWindow;
        popupWindow.setContentView(frameLayout);
        this.u1.setHeight(-2);
        this.u1.setWidth(-2);
        this.u1.setFocusable(true);
        this.u1.setOutsideTouchable(false);
        this.u1.setBackgroundDrawable(new ColorDrawable(TbadkCoreApplication.getInst().getResources().getColor(R.color.transparent)));
        GreyUtil.grey(this.u1);
        PbLandscapeListView pbLandscapeListView = this.l;
        if (pbLandscapeListView != null) {
            pbLandscapeListView.postDelayed(new t0(this, i4, i2, i3, view2), 100L);
        }
        m35.m().w("show_long_press_collection_tips", true);
    }

    public void c4(AdapterView.OnItemClickListener onItemClickListener) {
        boolean z2;
        boolean z3;
        boolean z4;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048694, this, onItemClickListener) == null) {
            d05 d05Var = this.h0;
            if (d05Var != null) {
                d05Var.d();
                this.h0 = null;
            }
            if (this.P0 == null) {
                return;
            }
            ArrayList<m05> arrayList = new ArrayList<>();
            String string = this.c.getContext().getString(R.string.all_person);
            boolean z5 = false;
            if (this.P0.N() == 1) {
                z2 = true;
            } else {
                z2 = false;
            }
            arrayList.add(new m05(string, "", z2, Integer.toString(1)));
            String string2 = this.c.getContext().getString(R.string.my_fans);
            if (this.P0.N() == 2) {
                z3 = true;
            } else {
                z3 = false;
            }
            arrayList.add(new m05(string2, "", z3, Integer.toString(5)));
            String string3 = this.c.getContext().getString(R.string.my_attentions);
            if (this.P0.N() == 3) {
                z4 = true;
            } else {
                z4 = false;
            }
            arrayList.add(new m05(string3, "", z4, Integer.toString(6)));
            String string4 = this.c.getContext().getString(R.string.myself_only);
            if (this.P0.N() == 4) {
                z5 = true;
            }
            arrayList.add(new m05(string4, "", z5, Integer.toString(7)));
            d05 d05Var2 = new d05(this.c.getPageContext());
            d05Var2.l(R.string.pb_privacy_setting_thread_reply_decs);
            this.h0 = d05Var2;
            d05Var2.k(arrayList, onItemClickListener);
            d05Var2.c();
            this.h0.n();
        }
    }

    public final void L3(int i2, SparseArray<Object> sparseArray) {
        PbFragment pbFragment;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeIL(1048625, this, i2, sparseArray) == null) && (pbFragment = this.c) != null && pbFragment.L() != null && this.c.L().w1() != null && this.c.L().w1().o() != null && this.c.L().w1().l() != null && this.c.L().w1().l().getDeletedReasonInfo() != null) {
            if (sparseArray != null) {
                sparseArray.put(R.id.tag_is_block_thread, Boolean.TRUE);
            }
            sw5 sw5Var = new sw5(this.c.L().w1().l().getDeletedReasonInfo().is_grays_cale_forum.intValue(), this.c.L().w1().l().getDeletedReasonInfo().is_boomgrow.intValue(), this.c.L().w1().o().has_forum_rule.intValue());
            sw5Var.i(this.c.L().w1().l().getId(), this.c.L().w1().l().getName());
            sw5Var.h(this.c.L().w1().l().getImage_url());
            sw5Var.j(this.c.L().w1().l().getUser_level());
            W3(sparseArray, i2, sw5Var, this.c.L().w1().X(), true);
        }
    }

    public final void e4(zz4 zz4Var, int i2) {
        PbFragment pbFragment;
        String str;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLI(1048702, this, zz4Var, i2) == null) && (pbFragment = this.c) != null && zz4Var != null) {
            if (this.E1 == null && this.u != null) {
                this.E1 = new qw5(pbFragment.getPageContext(), this.u.c());
            }
            AntiData u5 = this.c.u5();
            SparseArray<String> sparseArray = new SparseArray<>();
            if (u5 != null && u5.getDelThreadInfoList() != null) {
                List<DeleteThreadInfo> delThreadInfoList = u5.getDelThreadInfoList();
                for (int i3 = 0; i3 < delThreadInfoList.size(); i3++) {
                    if (!TextUtils.isEmpty(delThreadInfoList.get(i3).text_info)) {
                        sparseArray.put(delThreadInfoList.get(i3).text_id, delThreadInfoList.get(i3).text_info);
                    }
                }
            }
            fy4 fy4Var = new fy4();
            fy4Var.j(sparseArray);
            this.E1.B(new String[]{this.c.getString(R.string.delete_thread_reason_1), this.c.getString(R.string.delete_thread_reason_2), this.c.getString(R.string.delete_thread_reason_3), this.c.getString(R.string.delete_thread_reason_4), this.c.getString(R.string.delete_thread_reason_5)});
            this.E1.A(fy4Var);
            if (i2 != 1 && i2 != 2) {
                str = "3";
            } else {
                str = "4";
            }
            this.E1.D(str);
            this.E1.C(new b0(this, zz4Var));
        }
    }

    public void j4(jy4 jy4Var, zz4.e eVar) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLL(1048725, this, jy4Var, eVar) != null) || jy4Var == null) {
            return;
        }
        int a2 = jy4Var.a();
        int h2 = jy4Var.h();
        zz4 zz4Var = this.G;
        if (zz4Var != null) {
            zz4Var.show();
        } else {
            this.G = new zz4(this.c.getPageContext().getPageActivity());
            View inflate = LayoutInflater.from(this.c.getPageContext().getPageActivity()).inflate(R.layout.obfuscated_res_0x7f0d023f, (ViewGroup) null);
            this.I = inflate;
            this.G.setContentView(inflate);
            this.G.setPositiveButton(R.string.obfuscated_res_0x7f0f0523, eVar);
            this.G.setNegativeButton(R.string.obfuscated_res_0x7f0f051b, new o0(this));
            this.G.setOnCalcelListener(new p0(this));
            this.G.create(this.c.getPageContext()).show();
        }
        EditText editText = (EditText) this.I.findViewById(R.id.obfuscated_res_0x7f091094);
        this.J = editText;
        editText.setText("");
        TextView textView = (TextView) this.I.findViewById(R.id.obfuscated_res_0x7f0907ed);
        if (a2 <= 0) {
            a2 = 1;
        }
        if (h2 <= 0) {
            h2 = 1;
        }
        textView.setText(MessageFormat.format(TbadkCoreApplication.getInst().getResources().getString(R.string.current_page), Integer.valueOf(a2), Integer.valueOf(h2)));
        this.c.getBaseFragmentActivity().ShowSoftKeyPadDelay(this.J, 150);
    }

    public boolean x4(ki8 ki8Var, boolean z2) {
        InterceptResult invokeLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(1048795, this, ki8Var, z2)) == null) {
            if (ki8Var == null) {
                return false;
            }
            if (this.v != null) {
                if (ki8Var.Q() != null && ki8Var.Q().getIsNoTitle() == 0 && !ki8Var.Q().isVideoThreadType() && !this.U1) {
                    if (ki8Var.Q() != null) {
                        ThreadData Q = ki8Var.Q();
                        Q.parserSpecTitleForFrsAndPb(true, Q3(ki8Var));
                        Q.setResource(3);
                        Q.setPbTitle("2");
                    }
                    if (ki8Var.Q().isBJHArticleThreadType()) {
                        this.w.F(this.l);
                        this.v.h(this.l);
                        this.v.a(this.l);
                        this.w.n(this.l);
                        this.w.K(this.P0);
                        if (Q1(ki8Var)) {
                            this.v.h(this.l);
                        } else {
                            this.v.i(ki8Var);
                        }
                    } else {
                        this.w.K(this.P0);
                        if (Q1(ki8Var)) {
                            this.v.h(this.l);
                        } else {
                            this.v.k(ki8Var);
                        }
                    }
                } else if (ki8Var.Q().getIsNoTitle() == 1) {
                    if (ki8Var.Q() != null) {
                        this.v.h(this.l);
                        this.w.K(this.P0);
                    }
                } else {
                    this.v.h(this.l);
                    this.w.K(this.P0);
                }
            }
            l4(ki8Var.Z());
            m4(ki8Var);
            this.O0 = z2;
            return false;
        }
        return invokeLZ.booleanValue;
    }

    public void M2(int i2, ki8 ki8Var, boolean z2, int i3) {
        bc9 Z;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(1048628, this, new Object[]{Integer.valueOf(i2), ki8Var, Boolean.valueOf(z2), Integer.valueOf(i3)}) == null) && i2 > 0 && ki8Var != null && (Z = ki8Var.Z()) != null && Z.r() != null) {
            MetaData r3 = Z.r();
            r3.setGiftNum(r3.getGiftNum() + i2);
        }
    }

    public void N2(ki8 ki8Var, boolean z2, int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048632, this, new Object[]{ki8Var, Boolean.valueOf(z2), Integer.valueOf(i2), Integer.valueOf(i3)}) == null) {
            Z3(ki8Var, z2, i2, i3);
            this.w.C(i3);
        }
    }

    public void x2(int i2, String str, int i3, boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048793, this, new Object[]{Integer.valueOf(i2), str, Integer.valueOf(i3), Boolean.valueOf(z2)}) == null) {
            y2(i2, str, i3, z2, null);
        }
    }

    public final void P3(SparseArray<Object> sparseArray, @StringRes int i2, @StringRes int i3) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLII(1048641, this, sparseArray, i2, i3) != null) || this.c == null) {
            return;
        }
        TBAlertConfig.a aVar = new TBAlertConfig.a((int) R.string.obfuscated_res_0x7f0f04db, TBAlertConfig.OperateBtnStyle.MAIN);
        TBAlertConfig.a aVar2 = new TBAlertConfig.a((int) R.string.obfuscated_res_0x7f0f038e, TBAlertConfig.OperateBtnStyle.SECONDARY);
        TBAlertBuilder tBAlertBuilder = new TBAlertBuilder(this.c.M());
        tBAlertBuilder.w(i2);
        tBAlertBuilder.m(i3);
        tBAlertBuilder.o(true);
        tBAlertBuilder.u(aVar2, aVar);
        tBAlertBuilder.j(false);
        AlertDialog z2 = tBAlertBuilder.z();
        aVar.a(new x(this, z2, sparseArray));
        aVar2.a(new y(this, z2));
    }

    public final void W3(SparseArray<Object> sparseArray, int i2, sw5 sw5Var, UserData userData, boolean z2) {
        PbFragment pbFragment;
        String str;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeCommon(1048669, this, new Object[]{sparseArray, Integer.valueOf(i2), sw5Var, userData, Boolean.valueOf(z2)}) != null) || (pbFragment = this.c) == null) {
            return;
        }
        if (this.F1 == null && this.u != null) {
            this.F1 = new tw5(pbFragment.getPageContext(), this.u.c(), sw5Var, userData);
        }
        this.F1.F(z2);
        AntiData u5 = this.c.u5();
        SparseArray<String> sparseArray2 = new SparseArray<>();
        if (u5 != null && u5.getDelThreadInfoList() != null) {
            List<DeleteThreadInfo> delThreadInfoList = u5.getDelThreadInfoList();
            for (int i3 = 0; i3 < delThreadInfoList.size(); i3++) {
                if (!TextUtils.isEmpty(delThreadInfoList.get(i3).text_info)) {
                    sparseArray2.put(delThreadInfoList.get(i3).text_id, delThreadInfoList.get(i3).text_info);
                }
            }
        }
        fy4 fy4Var = new fy4();
        fy4Var.j(sparseArray2);
        this.F1.H(new String[]{this.c.getString(R.string.delete_thread_reason_1), this.c.getString(R.string.delete_thread_reason_2), this.c.getString(R.string.delete_thread_reason_3), this.c.getString(R.string.delete_thread_reason_4), this.c.getString(R.string.delete_thread_reason_5)});
        this.F1.G(fy4Var);
        if (i2 != 1 && i2 != 2) {
            str = "3";
        } else {
            str = "4";
        }
        this.F1.J(str);
        this.F1.I(new c0(this, sparseArray));
    }

    public void b4(b05.c cVar, boolean z2, boolean z3, boolean z4, boolean z5) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048690, this, new Object[]{cVar, Boolean.valueOf(z2), Boolean.valueOf(z3), Boolean.valueOf(z4), Boolean.valueOf(z5)}) == null) {
            i05 i05Var = this.f0;
            if (i05Var != null) {
                i05Var.dismiss();
                this.f0 = null;
            }
            k05 k05Var = new k05(this.c.getContext());
            ArrayList arrayList = new ArrayList();
            if (!z4 && !z5) {
                arrayList.add(new g05(0, this.c.getPageContext().getString(R.string.obfuscated_res_0x7f0f047b), k05Var));
            }
            if (z3) {
                arrayList.add(new g05(1, this.c.getPageContext().getString(R.string.report_text), k05Var));
            } else if (!z2) {
                arrayList.add(new g05(1, this.c.getPageContext().getString(R.string.obfuscated_res_0x7f0f0b5c), k05Var));
            } else {
                arrayList.add(new g05(1, this.c.getPageContext().getString(R.string.remove_mark), k05Var));
            }
            k05Var.k(arrayList);
            k05Var.p(new f0(this, cVar));
            i05 i05Var2 = new i05(this.c.getPageContext(), k05Var);
            this.g0 = i05Var2;
            i05Var2.k();
        }
    }

    public void Y3(ki8 ki8Var, int i2, int i3, boolean z2, int i4, boolean z3) {
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
        ki8 ki8Var2;
        Parcelable e2;
        Parcelable e3;
        int size2;
        int i7;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(1048677, this, new Object[]{ki8Var, Integer.valueOf(i2), Integer.valueOf(i3), Boolean.valueOf(z2), Integer.valueOf(i4), Boolean.valueOf(z3)}) == null) && ki8Var != null && this.l != null) {
            this.P0 = ki8Var;
            this.R0 = i2;
            if (ki8Var.Q() != null) {
                this.h1 = ki8Var.Q().getCopyThreadRemindType();
                if (ki8Var.Q().getAnchorLevel() != 0) {
                    this.f2 = true;
                }
                this.j0 = W1(ki8Var.Q());
            }
            if (ki8Var.X() != null) {
                this.g2 = ki8Var.X().getUserId();
            }
            H1(ki8Var);
            l0();
            this.T0 = false;
            this.O0 = z2;
            y3();
            ti8 ti8Var = ki8Var.h;
            if (ti8Var != null && ti8Var.b()) {
                if (this.o == null) {
                    PbThreadPostView pbThreadPostView = new PbThreadPostView(this.c.getContext());
                    this.o = pbThreadPostView;
                    this.l.w(pbThreadPostView, 1);
                    this.o.setData(ki8Var);
                    this.o.setChildOnClickLinstener(this.Q);
                }
            } else {
                PbThreadPostView pbThreadPostView2 = this.o;
                if (pbThreadPostView2 != null && (pbLandscapeListView = this.l) != null) {
                    pbLandscapeListView.removeHeaderView(pbThreadPostView2);
                }
            }
            Z3(ki8Var, z2, i2, TbadkCoreApplication.getInst().getSkinType());
            O3(ki8Var);
            this.w.Q(ki8Var, this.Q0);
            if (this.C1 == null) {
                this.C1 = new xl8(this.c.getPageContext(), this.D1);
            }
            this.C1.a(ki8Var.x());
            if (this.c.D5()) {
                if (this.K == null) {
                    wq8 wq8Var = new wq8(this.c.getPageContext());
                    this.K = wq8Var;
                    wq8Var.n();
                    this.K.f(this.h2);
                }
                this.l.setPullRefresh(this.K);
                V2();
                wq8 wq8Var2 = this.K;
                if (wq8Var2 != null) {
                    wq8Var2.H(TbadkCoreApplication.getInst().getSkinType());
                }
            } else if (ki8Var.z().c() == 0 && z2) {
                this.l.setPullRefresh(null);
            } else {
                if (this.K == null) {
                    wq8 wq8Var3 = new wq8(this.c.getPageContext());
                    this.K = wq8Var3;
                    wq8Var3.n();
                    this.K.f(this.h2);
                }
                this.l.setPullRefresh(this.K);
                V2();
                wq8 wq8Var4 = this.K;
                if (wq8Var4 != null) {
                    wq8Var4.H(TbadkCoreApplication.getInst().getSkinType());
                }
                z1();
            }
            y0();
            this.F.p0(this.O0);
            this.F.m0(false);
            vk8 vk8Var = this.F;
            if (i2 == 5) {
                z4 = true;
            } else {
                z4 = false;
            }
            vk8Var.n0(z4);
            vk8 vk8Var2 = this.F;
            if (i2 == 6) {
                z5 = true;
            } else {
                z5 = false;
            }
            vk8Var2.o0(z5);
            vk8 vk8Var3 = this.F;
            if (z3 && this.d2 && i2 != 2) {
                z6 = true;
            } else {
                z6 = false;
            }
            vk8Var3.k0(z6);
            this.F.h0(ki8Var, false);
            this.F.Z();
            vk8 vk8Var4 = this.F;
            if (ki8Var.z().b() != 0) {
                z7 = true;
            } else {
                z7 = false;
            }
            vk8Var4.b0(z7, ki8Var.g());
            this.w.O(ki8Var.Z(), ki8Var.l0());
            if (ki8Var.Q() != null && ki8Var.Q().getPraise() != null && this.b != -1) {
                ki8Var.Q().getPraise().setIsLike(this.b);
            }
            this.l.removeFooterView(this.c1);
            this.l.addFooterView(this.c1);
            if (TbadkCoreApplication.isLogin()) {
                this.l.setNextPage(this.L);
                this.f = 2;
                z1();
            } else {
                this.T0 = true;
                if (ki8Var.z().b() == 1) {
                    if (this.M == null) {
                        PbFragment pbFragment2 = this.c;
                        this.M = new rq8(pbFragment2, pbFragment2);
                    }
                    this.l.setNextPage(this.M);
                } else {
                    this.l.setNextPage(this.L);
                }
                this.f = 3;
            }
            ArrayList<bc9> H = ki8Var.H();
            if (ki8Var.z().b() != 0 && H != null && H.size() >= ki8Var.z().e()) {
                if (z3) {
                    if (this.d2) {
                        D0();
                        if (ki8Var.z().b() != 0) {
                            this.L.F(TbadkCoreApplication.getInst().getResources().getString(R.string.pb_load_more));
                        }
                    } else {
                        this.L.C();
                        this.L.Q();
                    }
                } else {
                    this.L.C();
                    this.L.Q();
                }
                this.L.m();
            } else {
                if (ListUtils.getCount(H) != 0 && (ListUtils.getCount(H) != 1 || H.get(0) == null || H.get(0).E() != 1)) {
                    if (ki8Var.z().b() == 0) {
                        this.L.F(TbadkCoreApplication.getInst().getResources().getString(R.string.list_has_no_more));
                    } else {
                        this.L.F(TbadkCoreApplication.getInst().getResources().getString(R.string.load_more));
                    }
                    this.L.m();
                } else {
                    a1 a1Var = this.f1;
                    if (a1Var != null && (pbReplyTitleViewHolder = a1Var.c) != null && pbReplyTitleViewHolder.getView() != null) {
                        if (this.f1.c.getView().getTop() < 0) {
                            i5 = this.f1.c.getView().getHeight();
                        } else {
                            i5 = this.f1.c.getView().getBottom();
                        }
                    } else {
                        i5 = 0;
                    }
                    if (this.c.h6()) {
                        this.L.x(false);
                        if (ListUtils.isEmpty(ki8Var.T())) {
                            this.L.I(TbadkCoreApplication.getInst().getResources().getString(R.string.obfuscated_res_0x7f0f0ec9), i5);
                        }
                    } else if (ListUtils.isEmpty(ki8Var.T())) {
                        this.L.I(TbadkCoreApplication.getInst().getResources().getString(R.string.obfuscated_res_0x7f0f0eca), i5);
                    }
                    if (this.c.K5() != null && !this.c.K5().p()) {
                        this.c.K5().x();
                    }
                }
                if (ki8Var.z().b() == 0 || H == null) {
                    P2();
                }
            }
            if (i2 != 2) {
                if (i2 != 3) {
                    if (i2 != 4) {
                        if (i2 != 5) {
                            if (i2 != 6) {
                                if (i2 == 8) {
                                    if (i3 == 0) {
                                        jn8 jn8Var = this.t;
                                        if (jn8Var != null && jn8Var.c() != null) {
                                            if (this.c.getBaseFragmentActivity().isUseStyleImmersiveSticky()) {
                                                this.l.setSelectionFromTop((this.F.B() + this.l.getHeaderViewsCount()) - 1, this.t.d() - hi.u(this.c.getPageContext().getPageActivity()));
                                            } else {
                                                this.l.setSelectionFromTop((this.F.B() + this.l.getHeaderViewsCount()) - 1, this.t.d());
                                            }
                                        } else {
                                            this.l.setSelection(this.F.B() + this.l.getHeaderViewsCount());
                                        }
                                    } else if (ListUtils.isEmpty(ki8Var.T())) {
                                        if (this.l.getData() == null && ki8Var.H() == null) {
                                            size2 = 0;
                                        } else {
                                            size2 = (this.l.getData().size() - ki8Var.H().size()) + this.l.getHeaderViewsCount();
                                        }
                                        PbLandscapeListView pbLandscapeListView2 = this.l;
                                        if (i3 > 0) {
                                            i7 = size2 + i3;
                                        } else {
                                            i7 = 0;
                                        }
                                        pbLandscapeListView2.setSelection(i7);
                                    } else {
                                        this.l.setSelection(ki8Var.H().size() + this.l.getHeaderViewsCount());
                                    }
                                    this.L.g();
                                    this.L.F(this.c.getString(R.string.obfuscated_res_0x7f0f0ec3));
                                    this.L.A();
                                }
                            } else if (i4 == 1 && (e3 = dm8.b().e()) != null && !(e3 instanceof RecyclerView.SavedState)) {
                                this.l.onRestoreInstanceState(e3);
                            } else {
                                this.l.setSelection(0);
                            }
                        } else {
                            this.l.setSelection(0);
                        }
                    } else {
                        this.d2 = false;
                    }
                } else if (i4 == 1 && (e2 = dm8.b().e()) != null && !(e2 instanceof RecyclerView.SavedState)) {
                    this.l.post(new m0(this, e2, H, ki8Var));
                }
            } else {
                if (this.l.getData() == null && ki8Var.H() == null) {
                    size = 0;
                } else {
                    size = (this.l.getData().size() - ki8Var.H().size()) + this.l.getHeaderViewsCount();
                }
                PbLandscapeListView pbLandscapeListView3 = this.l;
                if (i3 > 1) {
                    i6 = (size + i3) - 2;
                } else {
                    i6 = 0;
                }
                pbLandscapeListView3.setSelection(i6);
            }
            if (this.h1 == o2 && U1()) {
                s0();
            }
            if (this.n1) {
                J2();
                this.n1 = false;
                if (i4 == 0) {
                    n3(true);
                }
            }
            if (ki8Var.d == 1 || ki8Var.e == 1) {
                if (this.t1 == null) {
                    this.t1 = new PbTopTipView(this.c.getContext());
                }
                if (ki8Var.e == 1 && "game_guide".equals(this.c.P5())) {
                    this.t1.setText(this.c.getString(R.string.obfuscated_res_0x7f0f0ed5));
                    this.t1.l(this.d, this.S0);
                } else if (ki8Var.d == 1 && "game_news".equals(this.c.P5())) {
                    this.t1.setText(this.c.getString(R.string.obfuscated_res_0x7f0f0ed4));
                    this.t1.l(this.d, this.S0);
                }
            }
            this.l.removeFooterView(this.O1.a());
            if (!ListUtils.isEmpty(ki8Var.K()) && ki8Var.z().b() == 0) {
                this.l.removeFooterView(this.c1);
                this.O1.d(Math.max(this.v0.getMeasuredHeight(), this.M0 / 2));
                this.l.addFooterView(this.O1.a());
                this.O1.f(ki8Var);
            }
            L2(ki8Var);
            if (ki8Var.j0() && this.c.L().p2() && this.c.L5() != null) {
                this.c.L5().d();
            }
            if (ki8Var.g() != 3) {
                L1(ki8Var);
            }
            this.z0.setText(TbSingleton.getInstance().getAdVertiComment(ki8Var.r0(), ki8Var.s0(), l1()));
            if (this.p != null && (ki8Var2 = this.P0) != null && ki8Var2.l() != null) {
                this.p.m(this.P0.l().getImage_url());
                this.p.n(this.P0.l().getName());
                PbFragment pbFragment3 = this.c;
                if (pbFragment3 != null && pbFragment3.L() != null) {
                    this.p.o(this.c.L().b);
                }
            }
            if (this.r != null) {
                ki8 ki8Var3 = this.P0;
                if (ki8Var3 != null && ki8Var3.l() != null && (pbFragment = this.c) != null && pbFragment.L() != null) {
                    this.r.q(this.c.L().b);
                }
                ki8 ki8Var4 = this.P0;
                if (ki8Var4 != null && ki8Var4.Q() != null && !ListUtils.isEmpty(this.P0.Q().getThreadRecommendInfoDataList()) && this.P0.Q().getThreadRecommendInfoDataList().get(0) != null && this.P0.Q().getThreadRecommendInfoDataList().get(0).businessType != 1) {
                    this.r.p(this.P0.Q().getThreadRecommendInfoDataList().get(0));
                } else {
                    this.r.p(null);
                }
            }
            if (F3()) {
                this.A.e(this.P0.Q());
            } else {
                this.A.d(this.l);
            }
        }
    }

    @SuppressLint({"ResourceAsColor"})
    public final void Z3(ki8 ki8Var, boolean z2, int i2, int i3) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(1048681, this, new Object[]{ki8Var, Boolean.valueOf(z2), Integer.valueOf(i2), Integer.valueOf(i3)}) == null) && ki8Var != null && ki8Var.Q() != null) {
            if (this.c.x0()) {
                if (ki8Var.h() != null) {
                    this.k0 = ki8Var.h().d();
                    this.l0 = ki8Var.h().b();
                }
                if (this.k0 == null && this.c.L() != null && this.c.L().V0() != null) {
                    this.k0 = this.c.L().V0();
                }
            }
            bc9 Z = ki8Var.Z();
            w3(Z, ki8Var);
            int i4 = 8;
            this.w.L(8);
            int i5 = 1;
            if (ki8Var.y0()) {
                this.p1 = true;
                this.h.C(true);
                this.h.a.hideBottomLine();
                if (this.t == null) {
                    this.t = new jn8(this.c);
                }
                this.t.v(ki8Var, Z, this.l, this.w, this.W0, this.h, this.k0, this.I1);
                this.t.s(this.e2);
                V2();
            } else {
                this.p1 = false;
                this.h.C(false);
                jn8 jn8Var = this.t;
                if (jn8Var != null) {
                    jn8Var.p(this.l);
                }
            }
            if (this.c.K5() != null) {
                this.c.K5().w(this.p1);
            }
            if (Z == null) {
                return;
            }
            this.Q0 = Z;
            this.w.L(0);
            SparseArray<Object> w3 = this.w.w();
            w3.put(R.id.tag_clip_board, Z);
            w3.put(R.id.tag_is_subpb, Boolean.FALSE);
            this.x.e(ki8Var, this.l);
            this.z.e(ki8Var, this.K1, new j0(this));
            this.v.j(ki8Var);
            this.u.h(ki8Var, this.O0);
            this.u.g(ki8Var);
            this.w.M(this.S0, this.P0, Z, this.e2);
            if (this.b1 != null) {
                if (ki8Var.l0()) {
                    this.b1.getView().setVisibility(8);
                } else {
                    this.b1.getView().setVisibility(0);
                    xi8 xi8Var = new xi8(xi8.i);
                    if (ki8Var.Q() != null) {
                        ki8Var.Q().getReply_num();
                    }
                    xi8Var.c = ki8Var.g;
                    ki8Var.c();
                    xi8Var.d = this.c.h6();
                    xi8Var.g = ki8Var.f;
                    xi8Var.h = ki8Var.Q().isQuestionThread();
                    this.b1.h(xi8Var);
                }
            }
            l4(Z);
            m4(ki8Var);
            jg.a().post(new k0(this));
            this.y.f(this.l);
            if (Z.S) {
                this.y.g(Z.O());
                PbLandscapeListView pbLandscapeListView = this.l;
                this.y.c(this.l, (pbLandscapeListView == null || pbLandscapeListView.getHeaderViewsCount() <= 1) ? 0 : 0);
            }
            vk8 vk8Var = this.F;
            if (vk8Var != null && vk8Var.z() != null) {
                this.F.z().I(Z.S);
            }
            vk8 vk8Var2 = this.F;
            if (vk8Var2 != null) {
                vk8Var2.s0(Z.S);
            }
            MaskView maskView = this.P1;
            if (Z.S) {
                i4 = 0;
            }
            maskView.setVisibility(i4);
        }
    }

    public SparseArray<Object> a1(ki8 ki8Var, boolean z2, int i2) {
        InterceptResult invokeCommon;
        bc9 Z;
        boolean z3;
        nx4 nx4Var;
        int i3;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048683, this, new Object[]{ki8Var, Boolean.valueOf(z2), Integer.valueOf(i2)})) == null) {
            StringBuilder sb = null;
            if (ki8Var == null || (Z = ki8Var.Z()) == null) {
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
                sparseArray.put(R.id.tag_del_post_id, Z.O());
                sparseArray.put(R.id.tag_del_post_type, 0);
                sparseArray.put(R.id.tag_del_post_is_self, Boolean.valueOf(z3));
                sparseArray.put(R.id.tag_manage_user_identity, Integer.valueOf(ki8Var.Y()));
                sparseArray.put(R.id.tag_should_manage_visible, Boolean.FALSE);
            } else if (i2 == 1) {
                if (Z.r() != null) {
                    sparseArray.put(R.id.tag_forbid_user_name, Z.r().getUserName());
                    sparseArray.put(R.id.tag_forbid_user_name_show, Z.r().getName_show());
                    sparseArray.put(R.id.tag_forbid_user_portrait, Z.r().getPortrait());
                    sparseArray.put(R.id.tag_forbid_user_post_id, Z.O());
                }
                sparseArray.put(R.id.tag_del_post_id, Z.O());
                sparseArray.put(R.id.tag_del_post_type, 0);
                sparseArray.put(R.id.tag_del_post_is_self, Boolean.valueOf(z3));
                sparseArray.put(R.id.tag_manage_user_identity, Integer.valueOf(ki8Var.Y()));
                sparseArray.put(R.id.tag_should_manage_visible, Boolean.TRUE);
            }
            if (!z3) {
                List<iz4> p3 = ki8Var.p();
                if (ListUtils.getCount(p3) > 0) {
                    sb = new StringBuilder();
                    for (iz4 iz4Var : p3) {
                        if (iz4Var != null && !StringUtils.isNull(iz4Var.d()) && (nx4Var = iz4Var.f) != null && nx4Var.a && !nx4Var.c && ((i3 = nx4Var.b) == 1 || i3 == 2)) {
                            sb.append(gi.cutString(iz4Var.d(), 12));
                            sb.append(this.c.getString(R.string.obfuscated_res_0x7f0f06bd));
                            sb.append("、");
                        }
                    }
                }
                if (sb != null && !StringUtils.isNull(sb.toString())) {
                    sparseArray.put(R.id.tag_del_multi_forum, String.format(this.c.getString(R.string.obfuscated_res_0x7f0f04d3), sb.toString().substring(0, sb.length() - 1)));
                }
            }
            return sparseArray;
        }
        return (SparseArray) invokeCommon.objValue;
    }

    public void a4(b05.c cVar, boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048686, this, cVar, z2) == null) {
            i05 i05Var = this.g0;
            if (i05Var != null) {
                i05Var.dismiss();
                this.g0 = null;
            }
            k05 k05Var = new k05(this.c.getContext());
            ArrayList arrayList = new ArrayList();
            ki8 ki8Var = this.P0;
            if (ki8Var != null && ki8Var.Q() != null && !this.P0.Q().isBjh()) {
                arrayList.add(new g05(0, this.c.getPageContext().getString(R.string.save_to_emotion), k05Var));
            }
            if (!z2) {
                arrayList.add(new g05(1, this.c.getPageContext().getString(R.string.save_to_local), k05Var));
            }
            k05Var.k(arrayList);
            k05Var.p(new h0(this, cVar));
            i05 i05Var2 = new i05(this.c.getPageContext(), k05Var);
            this.g0 = i05Var2;
            i05Var2.k();
        }
    }

    public void v2(AbsListView absListView, int i2) {
        RightFloatLayerView rightFloatLayerView;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048783, this, absListView, i2) == null) {
            jn8 jn8Var = this.t;
            if (jn8Var != null) {
                jn8Var.o(absListView, i2);
            }
            if (!this.m2 && i2 == 0) {
                this.k2 = o1();
                this.f1.c = null;
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004013, this.f1));
                H2(this.f1.c, true);
                u0();
                this.F.g0(true);
            }
            this.F.f0();
            if (i2 == 0) {
                RightFloatLayerView rightFloatLayerView2 = this.R1;
                if (rightFloatLayerView2 != null) {
                    rightFloatLayerView2.p();
                }
                o0();
            } else if (i2 == 1) {
                RightFloatLayerView rightFloatLayerView3 = this.R1;
                if (rightFloatLayerView3 != null) {
                    rightFloatLayerView3.o();
                }
            } else if (i2 == 2 && (rightFloatLayerView = this.R1) != null) {
                rightFloatLayerView.q();
            }
        }
    }

    public final boolean h0(AbsListView absListView, int i2) {
        InterceptResult invokeLI;
        boolean z2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048711, this, absListView, i2)) == null) {
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

    public final CustomBlueCheckRadioButton r0(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048761, this, str, str2)) == null) {
            Activity pageActivity = this.c.getPageContext().getPageActivity();
            CustomBlueCheckRadioButton customBlueCheckRadioButton = new CustomBlueCheckRadioButton(pageActivity);
            RadioGroup.LayoutParams layoutParams = new RadioGroup.LayoutParams(-1, hi.g(pageActivity, R.dimen.obfuscated_res_0x7f07019a));
            customBlueCheckRadioButton.setOnCheckedChangeListener(this.b0);
            customBlueCheckRadioButton.setTag(str);
            customBlueCheckRadioButton.setText(str2);
            customBlueCheckRadioButton.setLayoutParams(layoutParams);
            return customBlueCheckRadioButton;
        }
        return (CustomBlueCheckRadioButton) invokeLL.objValue;
    }

    public void x3(boolean z2, PostWriteCallBackData postWriteCallBackData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZL(1048794, this, z2, postWriteCallBackData) == null) {
            this.c.hideProgressBar();
            if (z2) {
                v0();
            } else if (postWriteCallBackData != null && (postWriteCallBackData.isSensitiveError() || postWriteCallBackData.isErrorLinkCountExceedLimit() || postWriteCallBackData.isErrorShowApplyMemberDialog())) {
                w0();
            } else {
                v0();
            }
        }
    }

    public void i2(int i2) {
        boolean z2;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeI(1048718, this, i2) != null) || this.S0 == i2) {
            return;
        }
        this.S0 = i2;
        n4(this.P0, this.O0);
        N2(this.P0, this.O0, this.R0, i2);
        fv4 layoutMode = this.c.getBaseFragmentActivity().getLayoutMode();
        if (i2 == 4) {
            z2 = true;
        } else {
            z2 = false;
        }
        layoutMode.l(z2);
        this.c.getBaseFragmentActivity().getLayoutMode().k(this.d);
        SkinManager.setBackgroundColor(this.d, R.color.CAM_X0201);
        SkinManager.setBackgroundColor(this.q0, R.color.CAM_X0203);
        jn8 jn8Var = this.t;
        if (jn8Var != null) {
            jn8Var.h(i2);
        }
        fn8 fn8Var = this.x;
        if (fn8Var != null) {
            fn8Var.c(i2);
        }
        en8 en8Var = this.u;
        if (en8Var != null) {
            en8Var.e(i2);
        }
        gn8 gn8Var = this.v;
        if (gn8Var != null) {
            gn8Var.g(i2);
        }
        in8 in8Var = this.w;
        if (in8Var != null) {
            in8Var.C(i2);
        }
        hn8 hn8Var = this.y;
        if (hn8Var != null) {
            hn8Var.e();
        }
        dn8 dn8Var = this.z;
        if (dn8Var != null) {
            dn8Var.c();
        }
        MaskView maskView = this.P1;
        if (maskView != null) {
            maskView.f();
        }
        km8 km8Var = this.r;
        if (km8Var != null) {
            km8Var.n();
        }
        PbContentCollectionController pbContentCollectionController = this.A;
        if (pbContentCollectionController != null) {
            pbContentCollectionController.c();
        }
        PbListView pbListView = this.L;
        if (pbListView != null) {
            pbListView.e(i2);
        }
        if (this.N != null) {
            this.c.getBaseFragmentActivity().getLayoutMode().k(this.N);
            SkinManager.setBackgroundResource(this.N, R.drawable.pb_foot_more_trans_selector);
        }
        if (this.O != null) {
            this.c.getBaseFragmentActivity().getLayoutMode().k(this.O);
            SkinManager.setBackgroundResource(this.O, R.drawable.pb_foot_more_trans_selector);
        }
        zz4 zz4Var = this.G;
        if (zz4Var != null) {
            zz4Var.autoChangeSkinType(this.c.getPageContext());
        }
        s4(this.i0);
        this.F.Z();
        wq8 wq8Var = this.K;
        if (wq8Var != null) {
            wq8Var.H(i2);
        }
        EditorTools editorTools = this.o0;
        if (editorTools != null) {
            editorTools.y(i2);
        }
        rq8 rq8Var = this.M;
        if (rq8Var != null) {
            rq8Var.g(i2);
        }
        if (!ListUtils.isEmpty(this.n)) {
            for (CustomBlueCheckRadioButton customBlueCheckRadioButton : this.n) {
                customBlueCheckRadioButton.c();
            }
        }
        y4();
        UtilHelper.setStatusBarBackground(this.e, i2);
        UtilHelper.setStatusBarBackground(this.a1, i2);
        if (this.B != null) {
            tl5.a(this.c.getPageContext(), this.B);
        }
        hl8 hl8Var = this.l1;
        if (hl8Var != null) {
            hl8Var.l(i2);
        }
        ro8 ro8Var = this.h;
        if (ro8Var != null) {
            jn8 jn8Var2 = this.t;
            if (jn8Var2 != null) {
                jn8Var2.i(i2);
            } else {
                ro8Var.w(i2);
            }
        }
        HeadImageView headImageView = this.x0;
        if (headImageView != null) {
            headImageView.setBorderColor(SkinManager.getColor(R.color.CAM_X0401));
        }
        LinearLayout linearLayout = this.w0;
        if (linearLayout != null) {
            linearLayout.setBackgroundDrawable(SkinManager.createShapeDrawableFromColor(hi.g(this.c.getContext(), R.dimen.tbds47), SkinManager.getColor(R.color.CAM_X0209)));
        }
        ki8 ki8Var = this.P0;
        if (ki8Var != null && ki8Var.r()) {
            WebPManager.setPureDrawable(this.D0, R.drawable.icon_pure_pb_bottom_collected26_selection, R.color.CAM_X0305, WebPManager.ResourceStateType.NORMAL_PRESS);
        } else {
            WebPManager.setPureDrawable(this.D0, R.drawable.icon_pure_pb_bottom_collect26, R.color.CAM_X0107, WebPManager.ResourceStateType.NORMAL_PRESS);
        }
        WebPManager.setPureDrawable(this.B0, R.drawable.icon_pure_pb_bottom_comment26, R.color.CAM_X0107, WebPManager.ResourceStateType.NORMAL_PRESS);
        WebPManager.setPureDrawable(this.y0, R.drawable.icon_pure_post_expression24, R.color.CAM_X0107, WebPManager.ResourceStateType.NORMAL);
        w4(this.P0);
        if (this.G0.getVisibility() == 0) {
            this.G0.setBackgroundDrawable(SkinManager.createShapeDrawable(hi.g(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds15), R.color.CAM_X0301, 0, 0, i2));
        }
        SkinManager.setBackgroundColor(this.v0, R.color.CAM_X0207);
        SkinManager.setBackgroundColor(this.u0, R.color.CAM_X0203);
        SkinManager.setViewTextColor(this.v1, (int) R.color.cp_cont_n);
        SkinManager.setViewTextColor(this.z0, (int) R.color.CAM_X0109);
        SkinManager.setViewTextColor(this.K0, (int) R.color.CAM_X0105);
        SkinManager.setViewTextColor(this.J0, (int) R.color.CAM_X0107);
        SkinManager.setBackgroundShapeDrawable(this.J0, hi.g(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds18), R.color.CAM_X0207, R.color.CAM_X0207);
        SkinManager.setViewTextColor(this.I0, (int) R.color.CAM_X0107);
        SkinManager.setBackgroundShapeDrawable(this.I0, hi.g(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds18), R.color.CAM_X0207, R.color.CAM_X0207);
        AgreeView agreeView = this.C0;
        if (agreeView != null) {
            agreeView.w();
            this.C0.P(i2);
            AgreeData data = this.C0.getData();
            if (data != null) {
                K2(data, data.agreeNum);
            }
        }
        kk8 kk8Var = this.y1;
        if (kk8Var != null) {
            kk8Var.m(i2);
        }
        PbEmotionBar pbEmotionBar = this.g1;
        if (pbEmotionBar != null) {
            pbEmotionBar.w();
        }
        PbThreadPostView pbThreadPostView = this.o;
        if (pbThreadPostView != null) {
            pbThreadPostView.c(i2);
        }
        vq8 vq8Var = this.H0;
        if (vq8Var != null) {
            vq8Var.j();
        }
        uq8 uq8Var = this.O1;
        if (uq8Var != null) {
            uq8Var.c();
        }
        RightFloatLayerView rightFloatLayerView = this.R1;
        if (rightFloatLayerView != null) {
            rightFloatLayerView.n();
        }
        SkinManager.setBackgroundColor(this.Z0, R.color.CAM_X0207);
        SkinManager.setViewTextColor(this.Z0.findViewById(R.id.tv_title), (int) R.color.CAM_X0105);
    }

    public void u2(AbsListView absListView, int i2, int i3, int i4) {
        PbReplyTitleViewHolder pbReplyTitleViewHolder;
        int bottom;
        in8 in8Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLIII(1048778, this, absListView, i2, i3, i4) == null) {
            kl8 kl8Var = this.q;
            if (kl8Var != null) {
                kl8Var.c(i2, i3);
            }
            jm8 jm8Var = this.s;
            if (jm8Var != null) {
                jm8Var.c(i2, i3);
            }
            jn8 jn8Var = this.t;
            if (jn8Var != null) {
                jn8Var.n(absListView, i2, i3, i4);
            }
            ro8 ro8Var = this.h;
            if (ro8Var != null && (in8Var = this.w) != null) {
                ro8Var.y(in8Var.u());
            }
            G2();
            a1 a1Var = this.f1;
            a1Var.a = i2;
            PbLandscapeListView pbLandscapeListView = this.l;
            if (pbLandscapeListView != null) {
                a1Var.b = pbLandscapeListView.getHeaderViewsCount();
            }
            this.f1.c = null;
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004013, this.f1));
            M3(h0(absListView, i2));
            int i5 = 0;
            H2(this.f1.c, false);
            u0();
            if (this.L.p() && !this.L.C) {
                a1 a1Var2 = this.f1;
                if (a1Var2 != null && (pbReplyTitleViewHolder = a1Var2.c) != null && pbReplyTitleViewHolder.getView() != null) {
                    if (this.f1.c.getView().getTop() < 0) {
                        bottom = this.f1.c.getView().getHeight();
                    } else {
                        bottom = this.f1.c.getView().getBottom();
                    }
                    i5 = bottom;
                }
                this.L.f(i5);
                this.L.C = true;
            }
        }
    }

    public void w2(ArrayList<vx4> arrayList) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048788, this, arrayList) == null) {
            if (this.Z == null) {
                this.Z = LayoutInflater.from(this.c.getPageContext().getPageActivity()).inflate(R.layout.commit_good, (ViewGroup) null);
            }
            this.c.getBaseFragmentActivity().getLayoutMode().k(this.Z);
            if (this.Y == null) {
                Dialog dialog = new Dialog(this.c.getPageContext().getPageActivity(), R.style.obfuscated_res_0x7f1003b0);
                this.Y = dialog;
                dialog.setCanceledOnTouchOutside(true);
                this.Y.setCancelable(true);
                this.n0 = (ScrollView) this.Z.findViewById(R.id.good_scroll);
                this.Y.setContentView(this.Z);
                WindowManager.LayoutParams attributes = this.Y.getWindow().getAttributes();
                attributes.width = hi.g(TbadkCoreApplication.getInst(), R.dimen.obfuscated_res_0x7f0702dc);
                this.Y.getWindow().setAttributes(attributes);
                this.b0 = new d0(this);
                this.a0 = (LinearLayout) this.Z.findViewById(R.id.good_class_group);
                TextView textView = (TextView) this.Z.findViewById(R.id.dialog_button_cancel);
                this.d0 = textView;
                textView.setOnClickListener(new e0(this));
                TextView textView2 = (TextView) this.Z.findViewById(R.id.dialog_button_ok);
                this.c0 = textView2;
                textView2.setOnClickListener(this.Q);
            }
            this.a0.removeAllViews();
            this.n = new ArrayList();
            CustomBlueCheckRadioButton r02 = r0("0", this.c.getPageContext().getString(R.string.thread_good_class));
            this.n.add(r02);
            r02.setChecked(true);
            this.a0.addView(r02);
            if (arrayList != null) {
                for (int i2 = 0; i2 < arrayList.size(); i2++) {
                    vx4 vx4Var = arrayList.get(i2);
                    if (vx4Var != null && !TextUtils.isEmpty(vx4Var.b()) && vx4Var.a() > 0) {
                        CustomBlueCheckRadioButton r03 = r0(String.valueOf(vx4Var.a()), vx4Var.b());
                        this.n.add(r03);
                        View view2 = new View(this.c.getPageContext().getPageActivity());
                        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, hi.g(TbadkCoreApplication.getInst(), R.dimen.obfuscated_res_0x7f070198));
                        SkinManager.setBackgroundColor(view2, R.color.CAM_X0204);
                        view2.setLayoutParams(layoutParams);
                        this.a0.addView(view2);
                        this.a0.addView(r03);
                    }
                }
                ViewGroup.LayoutParams layoutParams2 = this.n0.getLayoutParams();
                int size = arrayList.size();
                if (size != 0 && size != 1) {
                    if (size != 2) {
                        layoutParams2.height = hi.d(this.c.getPageContext().getPageActivity(), 220.0f);
                    } else {
                        layoutParams2.height = hi.d(this.c.getPageContext().getPageActivity(), 186.0f);
                    }
                } else {
                    layoutParams2.height = hi.d(this.c.getPageContext().getPageActivity(), 120.0f);
                }
                this.n0.setLayoutParams(layoutParams2);
                this.n0.removeAllViews();
                LinearLayout linearLayout = this.a0;
                if (linearLayout != null && linearLayout.getParent() == null) {
                    this.n0.addView(this.a0);
                }
            }
            lg.j(this.Y, this.c.getPageContext());
        }
    }

    public void y2(int i2, String str, int i3, boolean z2, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048798, this, new Object[]{Integer.valueOf(i2), str, Integer.valueOf(i3), Boolean.valueOf(z2), str2}) == null) {
            z2(i2, str, i3, z2, str2, false);
        }
    }

    public void z2(int i2, String str, int i3, boolean z2, String str2, boolean z3) {
        int i4;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048803, this, new Object[]{Integer.valueOf(i2), str, Integer.valueOf(i3), Boolean.valueOf(z2), str2, Boolean.valueOf(z3)}) == null) {
            SparseArray<Object> sparseArray = new SparseArray<>();
            sparseArray.put(R.id.tag_del_post_id, str);
            sparseArray.put(R.id.tag_del_post_type, Integer.valueOf(i2));
            sparseArray.put(R.id.tag_manage_user_identity, Integer.valueOf(i3));
            sparseArray.put(R.id.tag_del_post_is_self, Boolean.valueOf(z2));
            sparseArray.put(p2, Integer.valueOf(q2));
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
            this.W = new zz4(this.c.getActivity());
            if (StringUtils.isNull(str2)) {
                this.W.setMessageId(i4);
            } else {
                this.W.setOnlyMessageShowCenter(false);
                this.W.setMessage(str2);
            }
            this.W.setYesButtonTag(sparseArray);
            this.W.setPositiveButton(R.string.obfuscated_res_0x7f0f0523, this.c);
            this.W.setNegativeButton(R.string.obfuscated_res_0x7f0f051b, new w(this));
            this.W.setCancelable(true);
            this.W.create(this.c.getPageContext());
            if (z3) {
                P3(sparseArray, i5, i4);
            } else if (z2) {
                P3(sparseArray, i5, i4);
            } else if (G3()) {
                sw5 sw5Var = new sw5(this.c.L().w1().l().getDeletedReasonInfo().is_grays_cale_forum.intValue(), this.c.L().w1().l().getDeletedReasonInfo().is_boomgrow.intValue(), this.c.L().w1().o().has_forum_rule.intValue());
                sw5Var.i(this.c.L().w1().l().getId(), this.c.L().w1().l().getName());
                sw5Var.h(this.c.L().w1().l().getImage_url());
                sw5Var.j(this.c.L().w1().l().getUser_level());
                W3(sparseArray, i2, sw5Var, this.c.L().w1().X(), false);
            } else {
                e4(this.W, i2);
            }
        }
    }
}
