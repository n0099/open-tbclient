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
import com.baidu.tieba.ai8;
import com.baidu.tieba.b25;
import com.baidu.tieba.gh8;
import com.baidu.tieba.h59;
import com.baidu.tieba.he8;
import com.baidu.tieba.hg8;
import com.baidu.tieba.jc8;
import com.baidu.tieba.k55;
import com.baidu.tieba.kx5;
import com.baidu.tieba.nx5;
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
import com.baidu.tieba.q15;
import com.baidu.tieba.s15;
import com.baidu.tieba.tbadkCore.data.AgreeData;
import com.baidu.tieba.tbadkCore.data.PostData;
import com.baidu.tieba.tbadkCore.util.AntiHelper;
import com.baidu.tieba.tbadkCore.writeModel.PostWriteCallBackData;
import com.baidu.tieba.view.NavigationBarCoverTip;
import com.baidu.tieba.view.WaterRippleView;
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
public class lh8 {
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
    public static h59.f v2;
    public transient /* synthetic */ FieldHolder $fh;
    public PbContentCollectionController A;
    public ImageView A0;
    public boolean A1;
    public LinearLayout B;
    public AgreeView B0;
    public ug8 B1;
    public TextView C;
    public ImageView C0;
    public NavigationBarCoverTip C1;
    public TextView D;
    public ImageView D0;
    public kx5 D1;
    public ObservedChangeRelativeLayout E;
    public HeadImageView E0;
    public nx5 E1;
    public sf8 F;
    public View F0;
    public String F1;
    public q15 G;
    public sl8 G0;
    public PermissionJudgePolicy G1;
    public s15 H;
    public TextView H0;
    public long H1;
    public View I;
    public TextView I0;
    public boolean I1;
    public EditText J;
    public TextView J0;
    public int J1;
    public tl8 K;
    public boolean K0;
    public int K1;
    public PbListView L;
    public int L0;
    public boolean L1;
    public ol8 M;
    public e55 M0;
    public boolean M1;
    public View N;
    public boolean N0;
    public rl8 N1;
    public View O;
    public hd8 O0;
    public MaskView O1;
    public View P;
    public PostData P0;
    public final PbFallingView P1;
    public View.OnClickListener Q;
    public int Q0;
    public RightFloatLayerView Q1;
    public TbRichTextView.a0 R;
    public int R0;
    public final FrameLayout R1;
    public NoNetworkView.b S;
    public boolean S0;
    public CustomMessageListener S1;
    public z15 T;
    public ViewStub T0;
    public boolean T1;
    public View.OnClickListener U;
    public PbInterviewStatusView U0;
    public String U1;
    public q15 V;
    public FrameLayout V0;
    public CustomMessageListener V1;
    public Dialog W;
    public TextView W0;
    public View.OnClickListener W1;
    public Dialog X;
    public View X0;
    public CustomMessageListener X1;
    public View Y;
    public View Y0;
    public Handler Y1;
    public LinearLayout Z;
    public View Z0;
    public Runnable Z1;
    public final ViewTreeObserver.OnGlobalLayoutListener a;
    public CompoundButton.OnCheckedChangeListener a0;
    public PbReplyTitleViewHolder a1;
    public CustomMessageListener a2;
    public int b;
    public TextView b0;
    public View b1;
    public PbFragment.h3 b2;
    public PbFragment c;
    public TextView c0;
    public int c1;
    public boolean c2;
    public RelativeLayout d;
    public String d0;
    public boolean d1;
    public View.OnClickListener d2;
    public View e;
    public z15 e0;
    public a1 e1;
    public boolean e2;
    public int f;
    public z15 f0;
    public PbEmotionBar f1;
    public String f2;
    public final Handler g;
    public u15 g0;
    public int g1;
    public k55.g g2;
    public final oj8 h;
    public boolean h0;
    public int h1;
    public View.OnClickListener h2;
    public nj8 i;
    public boolean i0;
    public Runnable i1;
    public final List<TbImageView> i2;
    public ViewStub j;
    public String j0;
    public PbFakeFloorModel j1;
    public int j2;
    public ViewStub k;
    public String k0;
    public eg8 k1;
    public boolean k2;
    public PbLandscapeListView l;
    public je8 l0;
    public dh8 l1;
    public boolean l2;
    public NoNetworkView m;
    public ScrollView m0;
    public boolean m1;
    public List<CustomBlueCheckRadioButton> n;
    public EditorTools n0;
    public int n1;
    public PbThreadPostView o;
    public boolean o0;
    public boolean o1;
    public ig8 p;
    public View p0;
    public boolean p1;
    public hg8 q;
    public View q0;
    public boolean q1;
    public hh8 r;
    public EjectionAnimationView r0;
    public int r1;
    public gh8 s;
    public Button s0;
    public PbTopTipView s1;
    public gi8 t;
    public View t0;
    public PopupWindow t1;
    public bi8 u;
    public View u0;
    public TextView u1;
    public di8 v;
    public LinearLayout v0;
    public List<String> v1;
    public fi8 w;
    public HeadImageView w0;
    public li8 w1;
    public ci8 x;
    public ImageView x0;
    public hf8 x1;
    public ei8 y;
    public TextView y0;
    public PbLandscapeListView.c y1;
    public ai8 z;
    public WaterRippleView z0;
    public boolean z1;

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
        return (interceptable == null || (invokeV = interceptable.invokeV(1048742, this)) == null) ? R.id.obfuscated_res_0x7f091d80 : invokeV.intValue;
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
        public final /* synthetic */ lh8 a;

        /* loaded from: classes5.dex */
        public class a implements vc5 {
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

            @Override // com.baidu.tieba.vc5
            public void a(List<Bitmap> list) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, list) == null) {
                    this.a.a.r0.setVisibility(0);
                    this.a.a.r0.setBitmaps(list);
                    Rect rect = new Rect();
                    this.a.a.B0.getImgAgree().getGlobalVisibleRect(rect);
                    this.a.a.r0.setAnchorPosition((rect.right + rect.left) / 2, (rect.bottom + rect.top) / 2);
                    this.a.a.r0.k();
                }
            }
        }

        public c(lh8 lh8Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {lh8Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = lh8Var;
        }

        @Override // com.baidu.tbadk.core.view.AgreeView.i
        public void onLongPress() {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeV(1048576, this) != null) {
                return;
            }
            this.a.H3();
            xc5.g().c(new a(this));
        }

        @Override // com.baidu.tbadk.core.view.AgreeView.i
        public void onRelease() {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) != null) {
                return;
            }
            this.a.Q2();
            this.a.r0.l();
        }
    }

    /* loaded from: classes5.dex */
    public class j implements hg8.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ lh8 a;

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

        public j(lh8 lh8Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {lh8Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = lh8Var;
        }

        @Override // com.baidu.tieba.hg8.a
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
        public final /* synthetic */ lh8 g;

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
                if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && this.a.g.b1 != null && this.a.g.b1.getLayoutParams() != null) {
                    ViewGroup.LayoutParams layoutParams = this.a.g.b1.getLayoutParams();
                    layoutParams.height = this.a.g.h1;
                    this.a.g.b1.setLayoutParams(layoutParams);
                }
            }
        }

        public l(lh8 lh8Var, int i, PbReplyTitleViewHolder pbReplyTitleViewHolder, boolean z, int i2, int i3, int i4) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {lh8Var, Integer.valueOf(i), pbReplyTitleViewHolder, Boolean.valueOf(z), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i5 = newInitContext.flag;
                if ((i5 & 1) != 0) {
                    int i6 = i5 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.g = lh8Var;
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
                    if (this.g.b1 == null || (layoutParams = this.g.b1.getLayoutParams()) == null) {
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
                        layoutParams.height = this.g.h1;
                    } else {
                        layoutParams.height = this.g.h1;
                    }
                    this.g.b1.setLayoutParams(layoutParams);
                    gh.a().post(new a(this));
                }
                if (this.g.l != null) {
                    this.g.l.setOnLayoutListener(null);
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class m implements gh8.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ lh8 a;

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

        public m(lh8 lh8Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {lh8Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = lh8Var;
        }

        @Override // com.baidu.tieba.gh8.a
        public void a() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && !this.a.c.B6() && this.a.l != null) {
                this.a.l.post(new a(this));
            }
        }
    }

    /* loaded from: classes5.dex */
    public class p0 implements DialogInterface.OnCancelListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ lh8 a;

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

        public p0(lh8 lh8Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {lh8Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = lh8Var;
        }

        @Override // android.content.DialogInterface.OnCancelListener
        public void onCancel(DialogInterface dialogInterface) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, dialogInterface) == null) {
                if (this.a.i1 == null) {
                    this.a.i1 = new a(this);
                }
                gh.a().postDelayed(this.a.i1, 150L);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ lh8 a;

        public a(lh8 lh8Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {lh8Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = lh8Var;
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

        public a0(lh8 lh8Var, AlertDialog alertDialog) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {lh8Var, alertDialog};
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
    public class b implements ge8 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ lh8 a;

        @Override // com.baidu.tieba.ge8
        public /* synthetic */ void onStart() {
            fe8.a(this);
        }

        public b(lh8 lh8Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {lh8Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = lh8Var;
        }

        @Override // com.baidu.tieba.ge8
        public void onStop() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                this.a.r0.setVisibility(8);
                FirstPraiseToast.getInstance().show();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class b0 implements kx5.h {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ q15 a;
        public final /* synthetic */ lh8 b;

        public b0(lh8 lh8Var, q15 q15Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {lh8Var, q15Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = lh8Var;
            this.a = q15Var;
        }

        @Override // com.baidu.tieba.kx5.h
        public void a(JSONArray jSONArray) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, jSONArray) == null) {
                this.b.c.l5(this.a, jSONArray);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class c0 implements nx5.i {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ SparseArray a;
        public final /* synthetic */ lh8 b;

        public c0(lh8 lh8Var, SparseArray sparseArray) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {lh8Var, sparseArray};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = lh8Var;
            this.a = sparseArray;
        }

        @Override // com.baidu.tieba.nx5.i
        public void a(JSONArray jSONArray) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, jSONArray) == null) {
                this.b.c.k5(this.a, jSONArray);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class d implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ lh8 a;

        public d(lh8 lh8Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {lh8Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = lh8Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, view2) == null) && this.a.B0 != null && this.a.B0.getData() != null) {
                lh8 lh8Var = this.a;
                lh8Var.K2(lh8Var.B0.getData(), this.a.B0.getData().agreeNum);
                if (!this.a.B0.J()) {
                    lh8 lh8Var2 = this.a;
                    lh8Var2.D2(lh8Var2.B0);
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class d0 implements CompoundButton.OnCheckedChangeListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ lh8 a;

        public d0(lh8 lh8Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {lh8Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = lh8Var;
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

    /* loaded from: classes5.dex */
    public class e implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ lh8 a;

        public e(lh8 lh8Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {lh8Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = lh8Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                if (this.a.F0.getVisibility() == 0) {
                    if (this.a.c != null && this.a.c.C1()) {
                        return;
                    }
                    b55.m().w("pb_share_red_dot_shown", true);
                    this.a.F0.setVisibility(8);
                }
                this.a.Q.onClick(view2);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class e0 implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ lh8 a;

        public e0(lh8 lh8Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {lh8Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = lh8Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, view2) == null) && (this.a.X instanceof Dialog)) {
                ih.b(this.a.X, this.a.c.getPageContext());
            }
        }
    }

    /* loaded from: classes5.dex */
    public class f implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ lh8 a;

        public f(lh8 lh8Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {lh8Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = lh8Var;
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
                this.a.C2(view2);
            } else if (z2) {
                sparseArray.put(R.id.tag_from, 0);
                sparseArray.put(R.id.tag_check_mute_from, 1);
                this.a.c.b5(sparseArray);
            } else if (z3) {
                this.a.x2(((Integer) sparseArray.get(R.id.tag_del_post_type)).intValue(), (String) sparseArray.get(R.id.tag_del_post_id), ((Integer) sparseArray.get(R.id.tag_manage_user_identity)).intValue(), ((Boolean) sparseArray.get(R.id.tag_del_post_is_self)).booleanValue());
            }
        }
    }

    /* loaded from: classes5.dex */
    public class f0 implements b25.f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ s15.c a;
        public final /* synthetic */ lh8 b;

        public f0(lh8 lh8Var, s15.c cVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {lh8Var, cVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = lh8Var;
            this.a = cVar;
        }

        @Override // com.baidu.tieba.b25.f
        public void J0(b25 b25Var, int i, View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIL(1048576, this, b25Var, i, view2) == null) {
                this.b.f0.dismiss();
                this.a.a(null, i, view2);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class g implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ lh8 a;

        public g(lh8 lh8Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {lh8Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = lh8Var;
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
    public static class g0 implements h59.f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        @Override // com.baidu.tieba.h59.f
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
        public final /* synthetic */ lh8 a;

        public h(lh8 lh8Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {lh8Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = lh8Var;
        }

        @Override // com.baidu.tieba.pb.pb.main.view.PbFakeFloorModel.b
        public void a(PostData postData) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, postData) == null) {
                this.a.j1.e0(postData);
                this.a.F.Z();
                this.a.k1.g();
                this.a.n0.s();
                this.a.N3(false);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class h0 implements b25.f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ s15.c a;
        public final /* synthetic */ lh8 b;

        public h0(lh8 lh8Var, s15.c cVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {lh8Var, cVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = lh8Var;
            this.a = cVar;
        }

        @Override // com.baidu.tieba.b25.f
        public void J0(b25 b25Var, int i, View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIL(1048576, this, b25Var, i, view2) == null) {
                this.b.f0.dismiss();
                this.a.a(null, i, view2);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class i implements PbFallingView.r {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ lh8 a;

        public i(lh8 lh8Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {lh8Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = lh8Var;
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

    /* loaded from: classes5.dex */
    public class i0 implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ lh8 a;

        public i0(lh8 lh8Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {lh8Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = lh8Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            long j;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                if ((view2 instanceof HeadImageView) && this.a.O0 != null && this.a.O0.Q() != null && this.a.O0.Q().getAuthor() != null && this.a.O0.Q().getAuthor().getAlaInfo() != null && this.a.O0.Q().getAuthor().getAlaInfo().live_status == 1) {
                    StatisticItem statisticItem = new StatisticItem("c11851");
                    statisticItem.param("uid", TbadkCoreApplication.getCurrentAccount());
                    TiebaStatic.log(statisticItem);
                    StatisticItem statisticItem2 = new StatisticItem("c13715");
                    statisticItem2.param("fid", this.a.O0.m());
                    statisticItem2.param("fname", this.a.O0.n());
                    if (this.a.O0.Q().getAuthor().getAlaInfo().user_info != null) {
                        j = this.a.O0.Q().getAuthor().getAlaInfo().user_info.user_id;
                    } else {
                        j = 0;
                    }
                    statisticItem2.param("obj_param1", j);
                    statisticItem2.param("uid", TbadkCoreApplication.getCurrentAccount());
                    statisticItem2.param("tid", this.a.O0.S());
                    statisticItem2.param(TiebaStatic.Params.OBJ_PARAM2, 1);
                    statisticItem2.param(TiebaStatic.Params.OBJ_PARAM4, YYLiveUtil.calculateLiveType(this.a.O0.Q().getAuthor().getAlaInfo()));
                    if (this.a.O0.Q().getAuthor().getAlaInfo().mYyExtData != null) {
                        statisticItem2.param(TiebaStatic.Params.OBJ_PARAM3, TiebaStatic.YYValues.YY_LIVE);
                        TiebaStaticHelper.addYYParam(statisticItem2, this.a.O0.Q().getAuthor().getAlaInfo().mYyExtData);
                    }
                    TiebaStatic.log(statisticItem2);
                    if (this.a.O0.Q().getAuthor().getAlaInfo().isLegalYYLiveData()) {
                        YYLiveUtil.jumpYYLiveRoom(this.a.c.getPageContext(), this.a.O0.Q().getAuthor().getAlaInfo(), YYLiveUtil.SOURCE_PB_LIVE_HEAD);
                        return;
                    }
                    return;
                }
                if (this.a.o1) {
                    TiebaStatic.log(new StatisticItem("c11923").param("obj_id", 2));
                }
                if (!this.a.o1 && this.a.O0 != null && this.a.O0.Q() != null && this.a.O0.Q().getAuthor() != null && this.a.O0.Q().getAuthor().isBigV()) {
                    TiebaStatic.log(new StatisticItem("c12151").param("obj_locate", 1));
                }
                if (this.a.c.N() != null) {
                    this.a.c.N().d.b.onClick(view2);
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class j0 implements ai8.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ lh8 a;

        public j0(lh8 lh8Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {lh8Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = lh8Var;
        }

        @Override // com.baidu.tieba.ai8.a
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
        public final /* synthetic */ lh8 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public k(lh8 lh8Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {lh8Var, Integer.valueOf(i)};
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
            this.a = lh8Var;
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

    /* loaded from: classes5.dex */
    public class k0 implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ lh8 a;

        public k0(lh8 lh8Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {lh8Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = lh8Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            lh8 lh8Var;
            oj8 oj8Var;
            LinearLayout linearLayout;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && this.a.F != null && (oj8Var = (lh8Var = this.a).h) != null && oj8Var.i != null && lh8Var.O0 != null && this.a.O0.Q() != null && !this.a.O0.Q().isVideoThreadType() && !this.a.Y1() && this.a.O0.l() != null && !dj.isEmpty(this.a.O0.l().getName())) {
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
        public final /* synthetic */ lh8 b;

        public l0(lh8 lh8Var, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {lh8Var, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = lh8Var;
            this.a = str;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                if (ej.F()) {
                    UrlManager.getInstance().dealOneLink(this.b.c.getPageContext(), new String[]{this.a});
                    this.b.c.finish();
                    return;
                }
                this.b.c.showToast(R.string.obfuscated_res_0x7f0f0d11);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class m0 implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ Parcelable a;
        public final /* synthetic */ ArrayList b;
        public final /* synthetic */ hd8 c;
        public final /* synthetic */ lh8 d;

        public m0(lh8 lh8Var, Parcelable parcelable, ArrayList arrayList, hd8 hd8Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {lh8Var, parcelable, arrayList, hd8Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.d = lh8Var;
            this.a = parcelable;
            this.b = arrayList;
            this.c = hd8Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.d.l.onRestoreInstanceState(this.a);
                if (ListUtils.getCount(this.b) > 1 && this.c.z().b() > 0) {
                    this.d.L.g();
                    this.d.L.F(TbadkApplication.getInst().getString(R.string.obfuscated_res_0x7f0f0eb3));
                    this.d.L.A();
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class n implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ lh8 a;

        public n(lh8 lh8Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {lh8Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = lh8Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                if (this.a.F0.getVisibility() == 0) {
                    b55.m().w("pb_share_red_dot_shown", true);
                    this.a.F0.setVisibility(8);
                }
                this.a.Q.onClick(this.a.D0);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class n0 implements PbLandscapeListView.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ lh8 a;

        public n0(lh8 lh8Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {lh8Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = lh8Var;
        }

        @Override // com.baidu.tieba.pb.pb.main.PbLandscapeListView.c
        public void a(int i, int i2, float f, float f2, float f3, float f4) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Integer.valueOf(i), Integer.valueOf(i2), Float.valueOf(f), Float.valueOf(f2), Float.valueOf(f3), Float.valueOf(f4)}) == null) && this.a.c != null && this.a.c.isAdded()) {
                if (i < 0 && f > this.a.r1) {
                    this.a.v0();
                    this.a.n2();
                }
                this.a.E0();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class o implements jc8.d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ lh8 a;

        public o(lh8 lh8Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {lh8Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = lh8Var;
        }

        @Override // com.baidu.tieba.jc8.d
        public void onFinish() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.B0.W();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class o0 implements q15.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ lh8 a;

        public o0(lh8 lh8Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {lh8Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = lh8Var;
        }

        @Override // com.baidu.tieba.q15.e
        public void onClick(q15 q15Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, q15Var) == null) {
                this.a.v0();
                q15Var.dismiss();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class p extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ lh8 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public p(lh8 lh8Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {lh8Var, Integer.valueOf(i)};
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
            this.a = lh8Var;
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
        public final /* synthetic */ lh8 a;

        public q(lh8 lh8Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {lh8Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = lh8Var;
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
    public class q0 implements q15.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public q0(lh8 lh8Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {lh8Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // com.baidu.tieba.q15.e
        public void onClick(q15 q15Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, q15Var) == null) {
                q15Var.dismiss();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class r extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ lh8 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public r(lh8 lh8Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {lh8Var, Integer.valueOf(i)};
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
            this.a = lh8Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(1048576, this, customResponsedMessage) != null) || customResponsedMessage == null) {
                return;
            }
            this.a.K0 = false;
        }
    }

    /* loaded from: classes5.dex */
    public class r0 implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ z75 a;
        public final /* synthetic */ lh8 b;

        public r0(lh8 lh8Var, z75 z75Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {lh8Var, z75Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = lh8Var;
            this.a = z75Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, view2) == null) && this.a != null && this.b.O0 != null && this.b.Q1 != null) {
                this.b.Q1.g(this.a);
                this.b.Q1.setAutoCompleteShown(false);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class s implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ lh8 a;

        public s(lh8 lh8Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {lh8Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = lh8Var;
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
    public class s0 implements q15.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public s0(lh8 lh8Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {lh8Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // com.baidu.tieba.q15.e
        public void onClick(q15 q15Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, q15Var) == null) {
                q15Var.dismiss();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class t implements zc5 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ lh8 a;

        public t(lh8 lh8Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {lh8Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = lh8Var;
        }

        @Override // com.baidu.tieba.zc5
        public void A(yc5 yc5Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, yc5Var) == null) {
                Object obj = yc5Var.c;
                if ((obj instanceof q85) && EmotionGroupType.isSendAsPic(((q85) obj).getType())) {
                    if (this.a.G1 == null) {
                        this.a.G1 = new PermissionJudgePolicy();
                    }
                    this.a.G1.clearRequestPermissionList();
                    this.a.G1.appendRequestPermission(this.a.c.getBaseFragmentActivity(), "android.permission.WRITE_EXTERNAL_STORAGE");
                    if (this.a.G1.startRequestPermission(this.a.c.getBaseFragmentActivity())) {
                        return;
                    }
                    q85 q85Var = (q85) yc5Var.c;
                    this.a.c.H5().f(q85Var);
                    if (q85Var.i()) {
                        this.a.c.H5().G(null, null);
                    } else {
                        this.a.c.H5().w(false, null);
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
        public final /* synthetic */ lh8 e;

        public t0(lh8 lh8Var, int i, int i2, int i3, View view2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {lh8Var, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), view2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i4 = newInitContext.flag;
                if ((i4 & 1) != 0) {
                    int i5 = i4 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.e = lh8Var;
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
                    this.e.t1.showAsDropDown(this.d);
                } else {
                    this.e.t1.showAsDropDown(this.e.u0, this.d.getLeft(), -this.e.u0.getHeight());
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class u implements TextWatcher {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ lh8 a;

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIII(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, charSequence, i, i2, i3) == null) {
            }
        }

        public u(lh8 lh8Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {lh8Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = lh8Var;
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
            if ((interceptable == null || interceptable.invokeLIII(Constants.METHOD_SEND_USER_MSG, this, charSequence, i, i2, i3) == null) && this.a.n0 != null && this.a.n0.getVisibility() == 0 && charSequence != null && charSequence.length() >= (i4 = i3 + i)) {
                String substring = charSequence.toString().substring(i, i4);
                if (TextUtils.isEmpty(substring)) {
                    return;
                }
                if (this.a.w1 == null) {
                    RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
                    layoutParams.addRule(11);
                    layoutParams.addRule(2, this.a.n0.getId());
                    lh8 lh8Var = this.a;
                    lh8Var.w1 = new li8(lh8Var.c.getPageContext(), this.a.d, layoutParams);
                    if (!ListUtils.isEmpty(this.a.v1)) {
                        this.a.w1.q(this.a.v1);
                    }
                    this.a.w1.r(this.a.n0);
                }
                this.a.w1.p(substring);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class u0 implements PbFallingView.q {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ lh8 a;

        public u0(lh8 lh8Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {lh8Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = lh8Var;
        }

        @Override // com.baidu.tieba.pb.view.PbFallingView.q
        public void onClick() {
            String l1;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (this.a.c != null && this.a.c.M() != null && this.a.c.M().d2()) {
                    l1 = this.a.c.getString(R.string.pb_reply_hint_from_smart_frs);
                } else {
                    l1 = this.a.l1();
                }
                if (!StringUtils.isNull(l1) && this.a.O0 != null) {
                    l1 = TbSingleton.getInstance().getAdVertiComment(this.a.O0.r0(), this.a.O0.s0(), l1);
                }
                if (this.a.c != null && this.a.c.H5() != null) {
                    this.a.c.H5().c0(l1);
                }
                if (this.a.y0 != null) {
                    this.a.y0.setText(l1);
                }
                this.a.N3(false);
                this.a.h4();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class v implements b25.f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ boolean a;
        public final /* synthetic */ lh8 b;

        public v(lh8 lh8Var, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {lh8Var, Boolean.valueOf(z)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = lh8Var;
            this.a = z;
        }

        @Override // com.baidu.tieba.b25.f
        public void J0(b25 b25Var, int i, View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIL(1048576, this, b25Var, i, view2) == null) {
                this.b.T.dismiss();
                SparseArray<Object> sparseArray = (SparseArray) view2.getTag();
                if (sparseArray == null) {
                    return;
                }
                switch (i) {
                    case 10:
                        this.b.x2(((Integer) sparseArray.get(R.id.tag_del_post_type)).intValue(), (String) sparseArray.get(R.id.tag_del_post_id), ((Integer) sparseArray.get(R.id.tag_manage_user_identity)).intValue(), ((Boolean) sparseArray.get(R.id.tag_del_post_is_self)).booleanValue());
                        return;
                    case 11:
                        if (this.b.b2 != null) {
                            this.b.b2.a(new Object[]{sparseArray.get(R.id.tag_manage_user_identity), sparseArray.get(R.id.tag_forbid_user_name), sparseArray.get(R.id.tag_forbid_user_post_id), sparseArray.get(R.id.tag_forbid_user_name_show), sparseArray.get(R.id.tag_forbid_user_portrait)});
                            return;
                        }
                        return;
                    case 12:
                        this.b.c.T5(this.a, (String) sparseArray.get(R.id.tag_user_mute_mute_userid), sparseArray);
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
        public final /* synthetic */ z75 a;
        public final /* synthetic */ lh8 b;

        public v0(lh8 lh8Var, z75 z75Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {lh8Var, z75Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = lh8Var;
            this.a = z75Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921664));
                this.b.Q1.setHomePbFloatLastCloseTime();
                this.b.C1();
                this.b.Q1.t(this.a);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class w implements q15.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public w(lh8 lh8Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {lh8Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // com.baidu.tieba.q15.e
        public void onClick(q15 q15Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, q15Var) == null) {
                q15Var.dismiss();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class w0 extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ lh8 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public w0(lh8 lh8Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {lh8Var, Integer.valueOf(i)};
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
            this.a = lh8Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(1048576, this, customResponsedMessage) != null) || customResponsedMessage == null || customResponsedMessage.getCmd() != 2921306) {
                return;
            }
            this.a.U1 = null;
        }
    }

    /* loaded from: classes5.dex */
    public class x implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ AlertDialog a;
        public final /* synthetic */ SparseArray b;
        public final /* synthetic */ lh8 c;

        public x(lh8 lh8Var, AlertDialog alertDialog, SparseArray sparseArray) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {lh8Var, alertDialog, sparseArray};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = lh8Var;
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
                    ej.P(this.c.c.N(), R.string.obfuscated_res_0x7f0f0d11);
                } else {
                    this.c.c.k5(this.b, null);
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class x0 implements ViewTreeObserver.OnGlobalLayoutListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PbFragment a;
        public final /* synthetic */ lh8 b;

        public x0(lh8 lh8Var, PbFragment pbFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {lh8Var, pbFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = lh8Var;
            this.a = pbFragment;
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (!this.b.L1 && this.a != null && this.b.c.M() != null && this.b.c.M().g2()) {
                    this.b.L1 = true;
                    this.a.Z4(false);
                }
                if (this.b.M1) {
                    return;
                }
                this.b.M1 = true;
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

        public y(lh8 lh8Var, AlertDialog alertDialog) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {lh8Var, alertDialog};
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
    public class y0 implements he8.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ lh8 a;

        public y0(lh8 lh8Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {lh8Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = lh8Var;
        }

        @Override // com.baidu.tieba.he8.b
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.c.W5();
            }
        }

        @Override // com.baidu.tieba.he8.b
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
        public final /* synthetic */ lh8 c;

        public z(lh8 lh8Var, AlertDialog alertDialog, SparseArray sparseArray) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {lh8Var, alertDialog, sparseArray};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = lh8Var;
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
                    ej.P(this.c.c.N(), R.string.obfuscated_res_0x7f0f0d11);
                } else {
                    this.c.c.k5(this.b, null);
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class z0 implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ReplyPrivacyCheckController a;
        public final /* synthetic */ bf5 b;
        public final /* synthetic */ lh8 c;

        public z0(lh8 lh8Var, ReplyPrivacyCheckController replyPrivacyCheckController, bf5 bf5Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {lh8Var, replyPrivacyCheckController, bf5Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = lh8Var;
            this.a = replyPrivacyCheckController;
            this.b = bf5Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                if (this.a != null && this.c.c != null && this.c.c.s5() != null && !this.a.checkPrivacyBeforeInvokeEditor(this.c.c.s5().replyPrivateFlag)) {
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
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947942989, "Lcom/baidu/tieba/lh8;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947942989, "Lcom/baidu/tieba/lh8;");
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
        t2 = ej.g(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds80);
        u2 = 1;
        v2 = new g0();
    }

    public PostData O0() {
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
            if (this.F.y(N0) != null && this.F.y(N0) != PostData.P0) {
                i2 = N0 + 1;
            }
            if (!(this.F.x(i2) instanceof PostData)) {
                return null;
            }
            return (PostData) this.F.x(i2);
        }
        return (PostData) invokeV.objValue;
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
        PostData postData;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048698, this) == null) && TbadkCoreApplication.isLogin() && this.O0 != null && this.p1 && !this.o1 && !this.i0 && (postData = this.P0) != null && postData.r() != null && !this.P0.r().getIsLike() && !this.P0.r().hadConcerned() && this.l1 == null) {
            this.l1 = new dh8(this.c);
        }
    }

    public final void n0() {
        PbContentCollectionController pbContentCollectionController;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048741, this) == null) {
            if (F3()) {
                new StatisticItem(CommonStatisticKey.KEY_PB_PAGE_CONTENT_COLLECTION_SHOW).addParam("tid", this.O0.Q().getTid()).addParam("obj_param1", this.O0.Q().getThreadRecommendInfoDataList().get(0).businessId).eventStat();
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
            gi8 gi8Var = this.t;
            if (gi8Var != null) {
                gi8Var.l();
            }
            ig8 ig8Var = this.p;
            if (ig8Var != null) {
                ig8Var.k();
            }
            hh8 hh8Var = this.r;
            if (hh8Var != null) {
                hh8Var.j();
            }
            RightFloatLayerView rightFloatLayerView = this.Q1;
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
            gi8 gi8Var = this.t;
            if (gi8Var != null) {
                gi8Var.m();
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

    public lh8(PbFragment pbFragment, View.OnClickListener onClickListener, je8 je8Var) {
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {pbFragment, onClickListener, je8Var};
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
        this.y0 = null;
        this.K0 = true;
        this.M0 = null;
        this.N0 = false;
        this.R0 = 3;
        this.S0 = false;
        this.T0 = null;
        this.c1 = 0;
        this.d1 = true;
        this.e1 = new a1();
        this.g1 = 0;
        this.m1 = false;
        this.n1 = 0;
        this.o1 = false;
        this.p1 = false;
        this.q1 = false;
        this.r1 = 0;
        this.z1 = false;
        this.A1 = false;
        this.H1 = 0L;
        this.K1 = 0;
        this.S1 = new k(this, 2921757);
        this.V1 = new w0(this, 2921306);
        this.W1 = new n(this);
        this.X1 = new p(this, 2005016);
        this.Y1 = new Handler();
        this.a2 = new r(this, 2004009);
        this.c2 = true;
        this.d2 = new i0(this);
        this.e2 = false;
        this.f2 = null;
        this.i2 = new ArrayList();
        this.k2 = false;
        this.H1 = System.currentTimeMillis();
        this.c = pbFragment;
        this.Q = onClickListener;
        this.l0 = je8Var;
        this.r1 = ej.l(pbFragment.getContext()) / 8;
        RelativeLayout relativeLayout = (RelativeLayout) LayoutInflater.from(this.c.getPageContext().getPageActivity()).inflate(R.layout.obfuscated_res_0x7f0d0686, (ViewGroup) null);
        this.d = relativeLayout;
        relativeLayout.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        this.p0 = this.d.findViewById(R.id.obfuscated_res_0x7f090444);
        this.C1 = (NavigationBarCoverTip) this.d.findViewById(R.id.obfuscated_res_0x7f0919a9);
        this.e = this.d.findViewById(R.id.obfuscated_res_0x7f09210e);
        this.R1 = (FrameLayout) this.d.findViewById(R.id.obfuscated_res_0x7f091da2);
        this.E = (ObservedChangeRelativeLayout) this.d.findViewById(R.id.obfuscated_res_0x7f0923d9);
        this.m = (NoNetworkView) this.d.findViewById(R.id.view_no_network);
        PbLandscapeListView pbLandscapeListView = (PbLandscapeListView) this.d.findViewById(R.id.obfuscated_res_0x7f0917dc);
        this.l = pbLandscapeListView;
        pbLandscapeListView.setDividerHeight(0);
        this.V0 = (FrameLayout) this.d.findViewById(R.id.obfuscated_res_0x7f091ded);
        this.W0 = new TextView(this.c.getActivity());
        AbsListView.LayoutParams layoutParams = new AbsListView.LayoutParams(-1, UtilHelper.getLightStatusBarHeight() + ej.g(this.c.getActivity(), R.dimen.obfuscated_res_0x7f070307));
        this.l.setOverScrollMode(2);
        this.l.x(this.W0, 0);
        this.l.setTextViewAdded(true);
        this.h1 = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds134);
        this.b1 = new View(this.c.getPageContext().getPageActivity());
        if (bw5.a()) {
            this.b1.setLayoutParams(new AbsListView.LayoutParams(-1, 0));
        } else {
            this.b1.setLayoutParams(new AbsListView.LayoutParams(-1, this.h1));
        }
        MessageManager.getInstance().registerListener(this.S1);
        this.b1.setVisibility(4);
        this.l.addFooterView(this.b1);
        this.l.setOnTouchListener(this.c.M2);
        this.a = new x0(this, pbFragment);
        this.l.getViewTreeObserver().addOnGlobalLayoutListener(this.a);
        this.h = new oj8(pbFragment, this.d);
        if (this.c.B5()) {
            ViewStub viewStub = (ViewStub) this.d.findViewById(R.id.obfuscated_res_0x7f0915e5);
            this.j = viewStub;
            viewStub.setVisibility(0);
            nj8 nj8Var = new nj8(pbFragment);
            this.i = nj8Var;
            nj8Var.c();
            this.h.a.setVisibility(8);
            layoutParams.height = ej.g(this.c.getActivity(), R.dimen.obfuscated_res_0x7f07023d);
        }
        this.W0.setLayoutParams(layoutParams);
        this.h.q().setOnTouchListener(new he8(new y0(this)));
        this.t0 = this.d.findViewById(R.id.obfuscated_res_0x7f092762);
        this.u0 = this.d.findViewById(R.id.obfuscated_res_0x7f091944);
        ej.g(TbadkCoreApplication.getInst(), R.dimen.tbds120);
        this.L0 = ej.g(TbadkCoreApplication.getInst(), R.dimen.obfuscated_res_0x7f070285);
        this.x0 = (ImageView) this.d.findViewById(R.id.obfuscated_res_0x7f09091c);
        this.x0.setOnClickListener(new z0(this, new ReplyPrivacyCheckController(this.c.getPageContext()), this.c.H5()));
        C0();
        this.y0 = (TextView) this.d.findViewById(R.id.obfuscated_res_0x7f091947);
        LinearLayout linearLayout = (LinearLayout) this.d.findViewById(R.id.obfuscated_res_0x7f09193f);
        this.v0 = linearLayout;
        linearLayout.setOnClickListener(new a(this));
        EjectionAnimationView ejectionAnimationView = (EjectionAnimationView) this.d.findViewById(R.id.obfuscated_res_0x7f090920);
        this.r0 = ejectionAnimationView;
        ejectionAnimationView.setEjectionAnimationViewCallback(new b(this));
        this.A0 = (ImageView) this.d.findViewById(R.id.obfuscated_res_0x7f091945);
        this.O1 = (MaskView) this.d.findViewById(R.id.mask_view);
        this.A0.setOnClickListener(this.Q);
        AgreeView agreeView = (AgreeView) this.d.findViewById(R.id.obfuscated_res_0x7f091941);
        this.B0 = agreeView;
        agreeView.setAgreeAlone(true);
        this.B0.w();
        this.B0.setAgreeLongClickListener(new c(this));
        this.B0.setAfterClickListener(new d(this));
        this.B0.setUseDynamicLikeRes("/pb");
        if (this.B0.getAgreeNumView() != null) {
            this.B0.getAgreeNumView().setVisibility(8);
        }
        if (this.B0.getMsgData() != null) {
            this.B0.getMsgData().a = BdUniqueId.gen();
        }
        boolean booleanExtra = this.c.getBaseFragmentActivity().getIntent().getBooleanExtra("key_is_from_dynamic", false);
        ImageView imageView = (ImageView) this.d.findViewById(R.id.obfuscated_res_0x7f091943);
        this.C0 = imageView;
        imageView.setOnClickListener(this.Q);
        if (booleanExtra) {
            this.C0.setVisibility(8);
        } else {
            this.C0.setVisibility(0);
        }
        View findViewById = this.d.findViewById(R.id.obfuscated_res_0x7f09194a);
        this.F0 = findViewById;
        if (!b55.m().i("pb_share_red_dot_shown", false) && TbadkCoreApplication.isLogin()) {
            i2 = 0;
        } else {
            i2 = 8;
        }
        findViewById.setVisibility(i2);
        this.D0 = (ImageView) this.d.findViewById(R.id.obfuscated_res_0x7f091948);
        HeadImageView headImageView = (HeadImageView) this.d.findViewById(R.id.obfuscated_res_0x7f091949);
        this.E0 = headImageView;
        headImageView.setIsRound(true);
        this.E0.setOnClickListener(this.W1);
        this.D0.setOnClickListener(new e(this));
        f2();
        sl8 sl8Var = new sl8(this.D0);
        this.G0 = sl8Var;
        sl8Var.n(this.E0);
        if (!UbsABTestHelper.isResizeInduceSharingABTest() && !UbsABTestHelper.isResizeInduceSharingABTestA()) {
            this.G0.f();
        }
        TextView textView = (TextView) this.d.findViewById(R.id.obfuscated_res_0x7f091946);
        this.I0 = textView;
        textView.setVisibility(0);
        this.H0 = (TextView) this.d.findViewById(R.id.obfuscated_res_0x7f091942);
        this.T0 = (ViewStub) this.d.findViewById(R.id.obfuscated_res_0x7f0910aa);
        this.B0.setVisibility(0);
        this.H0.setVisibility(0);
        this.u = new bi8(this.c, je8Var);
        this.w = new fi8(this.c, je8Var, this.Q);
        sf8 sf8Var = new sf8(this.c, this.l);
        this.F = sf8Var;
        sf8Var.y0(this.Q);
        this.F.A0(this.l0);
        this.F.v0(this.R);
        this.F.x0(this.c.j2);
        this.F.r0(this.h2);
        f fVar = new f(this);
        this.U = fVar;
        this.F.t0(fVar);
        M1();
        G1();
        ei8 ei8Var = new ei8(this.c);
        this.y = ei8Var;
        ei8Var.f = 2;
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
        this.P = this.d.findViewById(R.id.obfuscated_res_0x7f092797);
        this.c.registerListener(this.a2);
        this.j1 = new PbFakeFloorModel(this.c.getPageContext());
        PbModel M = this.c.M();
        this.j1.g0(M.W(), M.S(), M.T(), M.R(), M.X());
        eg8 eg8Var = new eg8(this.c.getPageContext(), this.j1, this.d);
        this.k1 = eg8Var;
        eg8Var.p(new g(this));
        this.k1.s(this.c.o2);
        this.j1.i0(new h(this));
        if (this.c.M() != null && !StringUtils.isNull(this.c.M().v1())) {
            PbFragment pbFragment2 = this.c;
            pbFragment2.showToast(pbFragment2.M().v1());
        }
        this.X0 = this.d.findViewById(R.id.obfuscated_res_0x7f09194c);
        this.Y0 = this.d.findViewById(R.id.obfuscated_res_0x7f090442);
        View findViewById2 = this.d.findViewById(R.id.obfuscated_res_0x7f09211b);
        this.Z0 = findViewById2;
        LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) findViewById2.getLayoutParams();
        if (this.c.M() != null && this.c.M().e1()) {
            this.X0.setVisibility(0);
            if (layoutParams2 != null) {
                layoutParams2.height = 0;
                this.Z0.setLayoutParams(layoutParams2);
            }
        } else if (layoutParams2 != null) {
            layoutParams2.height = m2;
            this.Z0.setLayoutParams(layoutParams2);
        }
        PbReplyTitleViewHolder pbReplyTitleViewHolder = new PbReplyTitleViewHolder(this.c.getPageContext(), this.d.findViewById(R.id.obfuscated_res_0x7f0919c7));
        this.a1 = pbReplyTitleViewHolder;
        pbReplyTitleViewHolder.r(pbFragment.d0);
        this.a1.g.setVisibility(8);
        this.a1.q(this.Q);
        this.a1.p(this.c.j2);
        this.c.registerListener(this.X1);
        this.c.registerListener(this.V1);
        PbFragment pbFragment3 = this.c;
        this.N1 = new rl8(pbFragment3, pbFragment3.getUniqueId());
        this.P1 = (PbFallingView) this.d.findViewById(R.id.obfuscated_res_0x7f090a5b);
        a3();
        this.P1.setAnimationListener(new i(this));
        q0();
        T2(false);
        this.q0 = this.d.findViewById(R.id.obfuscated_res_0x7f091935);
        p0(bw5.a());
        if (UbsABTestHelper.isPbForumGuideTestA() && M.k2() && kc8.b().e()) {
            if (this.p == null) {
                this.p = new ig8(this.c.getActivity(), (ViewGroup) t1().findViewById(R.id.obfuscated_res_0x7f091971));
            }
            hg8 hg8Var = new hg8(this.l);
            this.q = hg8Var;
            hg8Var.d(new j(this));
        }
        this.r = new hh8(this.c.N(), (ViewGroup) t1().findViewById(R.id.obfuscated_res_0x7f0919db));
        gh8 gh8Var = new gh8(this.l);
        this.s = gh8Var;
        gh8Var.d(new m(this));
    }

    public void A4(hd8 hd8Var) {
        bi8 bi8Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048580, this, hd8Var) == null) && (bi8Var = this.u) != null) {
            bi8Var.h(hd8Var, this.N0);
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
            this.v1 = list;
            li8 li8Var = this.w1;
            if (li8Var != null) {
                li8Var.q(list);
            }
        }
    }

    public void M3(boolean z2) {
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048629, this, z2) == null) {
            View view2 = this.p0;
            if (z2) {
                i2 = 0;
            } else {
                i2 = 8;
            }
            view2.setVisibility(i2);
        }
    }

    public void N3(boolean z2) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeZ(1048633, this, z2) != null) || this.u0 == null) {
            return;
        }
        c3(this.c.H5().y());
        if (this.o0) {
            R3(z2);
        } else {
            w1(z2);
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
            this.b2 = h3Var;
        }
    }

    public void c3(boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048693, this, z2) == null) {
            this.o0 = z2;
        }
    }

    public final int d1(boolean z2) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048695, this, z2)) == null) {
            PbInterviewStatusView pbInterviewStatusView = this.U0;
            if (pbInterviewStatusView == null || pbInterviewStatusView.getVisibility() != 0 || !z2) {
                return 0;
            }
            return 0 + ej.g(TbadkCoreApplication.getInst(), R.dimen.obfuscated_res_0x7f07026a);
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
            this.I1 = z2;
        }
    }

    public void f3(boolean z2) {
        sf8 sf8Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048705, this, z2) == null) && (sf8Var = this.F) != null) {
            sf8Var.j0(z2);
        }
    }

    public void g3(boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048709, this, z2) == null) {
            this.z1 = z2;
        }
    }

    public void h3(boolean z2) {
        gi8 gi8Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048714, this, z2) == null) && (gi8Var = this.t) != null) {
            gi8Var.r(z2);
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
            EditorTools editorTools = this.n0;
            if (editorTools != null && editorTools.w()) {
                this.n0.s();
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

    public void k3(k55.g gVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048729, this, gVar) == null) {
            this.g2 = gVar;
            tl8 tl8Var = this.K;
            if (tl8Var != null) {
                tl8Var.f(gVar);
            }
        }
    }

    public void l3(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048734, this, onClickListener) == null) {
            this.h2 = onClickListener;
            sf8 sf8Var = this.F;
            if (sf8Var != null) {
                sf8Var.r0(onClickListener);
            }
        }
    }

    public final void l4(PostData postData) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048735, this, postData) == null) && postData != null) {
            if (!StringUtils.isNull(postData.a0())) {
                this.A1 = true;
            } else {
                this.A1 = false;
            }
            fi8 fi8Var = this.w;
            if (fi8Var != null) {
                fi8Var.p(postData);
            }
        }
    }

    public boolean m2(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048738, this, i2)) == null) {
            gi8 gi8Var = this.t;
            if (gi8Var != null) {
                return gi8Var.k(i2);
            }
            return false;
        }
        return invokeI.booleanValue;
    }

    public void m3(String str) {
        nj8 nj8Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048739, this, str) == null) && (nj8Var = this.i) != null) {
            nj8Var.b(str);
        }
    }

    public void n3(boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048744, this, z2) == null) {
            this.m1 = z2;
            PbLandscapeListView pbLandscapeListView = this.l;
            if (pbLandscapeListView != null) {
                this.n1 = pbLandscapeListView.getHeaderViewsCount();
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
            this.R = a0Var;
            this.F.v0(a0Var);
            this.x1.q(this.R);
        }
    }

    public void q2(go goVar) {
        PbLandscapeListView pbLandscapeListView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048758, this, goVar) == null) && (pbLandscapeListView = this.l) != null) {
            pbLandscapeListView.b0 = goVar;
            pbLandscapeListView.W = true;
        }
    }

    public void q3(NoNetworkView.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048759, this, bVar) == null) {
            this.S = bVar;
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
            this.h0 = z2;
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
            this.J1 = i2;
        }
    }

    public void v3(View.OnLongClickListener onLongClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048784, this, onLongClickListener) == null) {
            this.w.H(onLongClickListener);
            this.F.w0(onLongClickListener);
            hf8 hf8Var = this.x1;
            if (hf8Var != null) {
                hf8Var.r(onLongClickListener);
            }
        }
    }

    public void F2(qb5 qb5Var, int i2) {
        PbFallingView pbFallingView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLI(1048600, this, qb5Var, i2) == null) && (pbFallingView = this.P1) != null) {
            pbFallingView.A(qb5Var, this.c.getPageContext(), i2, false);
        }
    }

    public void g2(boolean z2, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048708, this, new Object[]{Boolean.valueOf(z2), Integer.valueOf(i2)}) == null) {
            hg8 hg8Var = this.q;
            if (hg8Var != null) {
                hg8Var.b();
            }
            gh8 gh8Var = this.s;
            if (gh8Var != null) {
                gh8Var.b(z2, i2);
            }
        }
    }

    @SuppressLint({"CutPasteId"})
    public void n4(hd8 hd8Var, boolean z2) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLZ(1048745, this, hd8Var, z2) != null) || hd8Var == null) {
            return;
        }
        x4(hd8Var, z2);
        y0();
    }

    public final void w3(PostData postData, hd8 hd8Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048789, this, postData, hd8Var) == null) {
            this.w.I(postData, hd8Var);
        }
    }

    public void A0() {
        gi8 gi8Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && (gi8Var = this.t) != null) {
            gi8Var.b();
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
            Handler handler = this.Y1;
            if (handler != null && (runnable = this.Z1) != null) {
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
            statisticItem.param("obj_locate", u2);
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
            statisticItem.param("obj_locate", u2);
            TiebaStatic.log(statisticItem);
        }
    }

    public void C1() {
        RightFloatLayerView rightFloatLayerView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048587, this) == null) && (rightFloatLayerView = this.Q1) != null) {
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
        if ((interceptable == null || interceptable.invokeV(1048591, this) == null) && (editorTools = this.n0) != null) {
            editorTools.s();
        }
    }

    public void E0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048594, this) == null) {
            PbLandscapeListView pbLandscapeListView = this.l;
            if (pbLandscapeListView != null) {
                pbLandscapeListView.A(0L);
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
            hh8 hh8Var = this.r;
            if (hh8Var != null && hh8Var.l()) {
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
            this.z = new ai8(pbFragment.getContext());
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
            this.v = new di8(this.c, this.l0);
        }
    }

    public final void I2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048612, this) == null) {
            this.w.E(this.O0, this.P0, this.p1, this.o1);
        }
    }

    public sf8 J0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048614, this)) == null) {
            return this.F;
        }
        return (sf8) invokeV.objValue;
    }

    public void J3() {
        gi8 gi8Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048617, this) == null) && (gi8Var = this.t) != null) {
            gi8Var.u(this.l);
        }
    }

    public LinearLayout K0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048618, this)) == null) {
            return this.v0;
        }
        return (LinearLayout) invokeV.objValue;
    }

    public View L0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048622, this)) == null) {
            View view2 = this.Y;
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
            return this.d0;
        }
        return (String) invokeV.objValue;
    }

    public final void M1() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048627, this) == null) && this.x == null) {
            this.x = new ci8(this.c, this.Q);
        }
    }

    public boolean O1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048635, this)) == null) {
            return this.e2;
        }
        return invokeV.booleanValue;
    }

    public final void O2() {
        PbInterviewStatusView pbInterviewStatusView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048636, this) == null) && (pbInterviewStatusView = this.U0) != null && pbInterviewStatusView.getVisibility() == 0) {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.U0.getLayoutParams();
            marginLayoutParams.setMargins(0, 0, 0, 0);
            this.U0.setLayoutParams(marginLayoutParams);
        }
    }

    public PbFallingView P0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048638, this)) == null) {
            return this.P1;
        }
        return (PbFallingView) invokeV.objValue;
    }

    public boolean P1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048639, this)) == null) {
            return this.K0;
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
            return pbLandscapeListView.J();
        }
        return invokeV.booleanValue;
    }

    public Button S0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048650, this)) == null) {
            return this.s0;
        }
        return (Button) invokeV.objValue;
    }

    public boolean S1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048651, this)) == null) {
            EditorTools editorTools = this.n0;
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
        oj8 oj8Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048657, this) == null) && (oj8Var = this.h) != null && !this.q1) {
            oj8Var.E();
            this.q1 = true;
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
            return TextUtils.equals(TbadkCoreApplication.getCurrentAccount(), this.f2);
        }
        return invokeV.booleanValue;
    }

    public void U2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048660, this) == null) {
            S2();
            x1();
            this.k1.g();
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
            sl8 sl8Var = this.G0;
            if (sl8Var != null) {
                return sl8Var.g();
            }
            return 3;
        }
        return invokeV.intValue;
    }

    public final void V2() {
        gi8 gi8Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048664, this) == null) && (gi8Var = this.t) != null) {
            gi8Var.q(this.l, this.W0, this.Q0);
        }
    }

    public void V3() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048665, this) == null) {
            if (this.M0 == null) {
                this.M0 = new e55(this.c.getPageContext());
            }
            this.M0.h(true);
        }
    }

    public PbInterviewStatusView W0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048666, this)) == null) {
            return this.U0;
        }
        return (PbInterviewStatusView) invokeV.objValue;
    }

    public void W2() {
        Handler handler;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048668, this) != null) || (handler = this.Y1) == null) {
            return;
        }
        Runnable runnable = this.Z1;
        if (runnable != null) {
            handler.removeCallbacks(runnable);
        }
        q qVar = new q(this);
        this.Z1 = qVar;
        this.Y1.postDelayed(qVar, 2000L);
    }

    public boolean X0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048670, this)) == null) {
            return this.z1;
        }
        return invokeV.booleanValue;
    }

    public void X3() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048673, this) == null) {
            this.F.h0(this.O0, false);
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
            gi8 gi8Var = this.t;
            if (gi8Var != null && gi8Var.f()) {
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
            return this.T1;
        }
        return invokeV.booleanValue;
    }

    public final void a3() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048685, this) == null) {
            this.P1.setFallingFeedbackListener(new u0(this));
        }
    }

    public hf8 b1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048687, this)) == null) {
            return this.x1;
        }
        return (hf8) invokeV.objValue;
    }

    public boolean b2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048688, this)) == null) {
            sl8 sl8Var = this.G0;
            if (sl8Var == null) {
                return false;
            }
            return sl8Var.i();
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
            EditorTools editorTools = this.n0;
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
            L2(this.O0);
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
        sf8 sf8Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048710, this) == null) && (sf8Var = this.F) != null) {
            sf8Var.B0();
        }
    }

    public View h1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048712, this)) == null) {
            return this.X0;
        }
        return (View) invokeV.objValue;
    }

    public void i0() {
        sl8 sl8Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048716, this) == null) && (sl8Var = this.G0) != null) {
            sl8Var.m(false);
        }
    }

    public PbFakeFloorModel i1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048717, this)) == null) {
            return this.j1;
        }
        return (PbFakeFloorModel) invokeV.objValue;
    }

    public void i4() {
        sl8 sl8Var;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048720, this) != null) || (sl8Var = this.G0) == null) {
            return;
        }
        sl8Var.o(2);
    }

    public eg8 j1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048722, this)) == null) {
            return this.k1;
        }
        return (eg8) invokeV.objValue;
    }

    public gi8 k1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048727, this)) == null) {
            return this.t;
        }
        return (gi8) invokeV.objValue;
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
            return this.R0;
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
        if ((interceptable == null || interceptable.invokeV(1048760, this) == null) && (pbFallingView = this.P1) != null) {
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
        if ((interceptable == null || interceptable.invokeV(1048765, this) == null) && this.i2 != null) {
            while (this.i2.size() > 0) {
                TbImageView remove = this.i2.remove(0);
                if (remove != null) {
                    remove.O();
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
        if ((interceptable == null || interceptable.invokeV(1048773, this) == null) && (pbFragment = this.c) != null && pbFragment.H5() != null) {
            this.c.H5().E();
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
                this.V0.setVisibility(8);
            }
            oj8 oj8Var = this.h;
            if (oj8Var != null && (view2 = oj8Var.d) != null) {
                view2.setVisibility(8);
            }
        }
    }

    public void v1() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048782, this) != null) || this.u0 == null) {
            return;
        }
        this.t0.setVisibility(8);
        this.u0.setVisibility(8);
        this.K0 = false;
        PbEmotionBar pbEmotionBar = this.f1;
        if (pbEmotionBar != null) {
            pbEmotionBar.setVisibility(8);
            T2(false);
        }
    }

    public void x0() {
        sl8 sl8Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048791, this) == null) && (sl8Var = this.G0) != null) {
            sl8Var.l(false);
        }
    }

    public void x1() {
        EditorTools editorTools;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048792, this) == null) && (editorTools = this.n0) != null) {
            editorTools.q();
            li8 li8Var = this.w1;
            if (li8Var != null) {
                li8Var.m();
            }
        }
    }

    public final boolean y0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048796, this)) == null) {
            return this.u.b(this.N0);
        }
        return invokeV.booleanValue;
    }

    public void y1() {
        oj8 oj8Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048797, this) == null) && (oj8Var = this.h) != null) {
            oj8Var.r();
        }
    }

    public void z1() {
        e55 e55Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048802, this) == null) && (e55Var = this.M0) != null) {
            e55Var.h(false);
        }
    }

    public void z3() {
        PbFragment pbFragment;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048804, this) == null) && (pbFragment = this.c) != null && pbFragment.getBaseFragmentActivity() != null) {
            ej.z(this.c.getPageContext().getPageActivity(), this.c.getBaseFragmentActivity().getCurrentFocus());
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
            sparseArray.put(o2, Integer.valueOf(p2));
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
                pbFragment.showToast(pbFragment.getPageContext().getString(R.string.obfuscated_res_0x7f0f1300));
            } else if (z3) {
                if (dj.isEmpty(str)) {
                    str = TbadkCoreApplication.getInst().getResources().getString(R.string.obfuscated_res_0x7f0f0d11);
                }
                this.c.showToast(str);
            }
        }
    }

    public void B2(SparseArray<Object> sparseArray, boolean z2) {
        int i2;
        x15 x15Var;
        x15 x15Var2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048583, this, sparseArray, z2) == null) {
            b25 b25Var = new b25(this.c.getContext());
            b25Var.s(this.c.getString(R.string.obfuscated_res_0x7f0f02f2));
            b25Var.p(new v(this, z2));
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
                    x15Var2 = new x15(10, this.c.getString(R.string.obfuscated_res_0x7f0f04e5), b25Var);
                } else {
                    x15Var2 = new x15(10, this.c.getString(R.string.obfuscated_res_0x7f0f04d8), b25Var);
                }
                SparseArray sparseArray2 = new SparseArray();
                sparseArray2.put(R.id.tag_del_post_id, sparseArray.get(R.id.tag_del_post_id));
                sparseArray2.put(R.id.tag_del_post_type, sparseArray.get(R.id.tag_del_post_type));
                sparseArray2.put(R.id.tag_del_post_is_self, sparseArray.get(R.id.tag_del_post_is_self));
                sparseArray2.put(R.id.tag_manage_user_identity, sparseArray.get(R.id.tag_manage_user_identity));
                x15Var2.d.setTag(sparseArray2);
                arrayList.add(x15Var2);
            }
            if ((sparseArray.get(R.id.tag_mul_del_post_type) instanceof Boolean) && ((Boolean) sparseArray.get(R.id.tag_mul_del_post_type)).booleanValue()) {
                x15 x15Var3 = new x15(13, this.c.getString(R.string.multi_delete), b25Var);
                SparseArray sparseArray3 = new SparseArray();
                sparseArray3.put(R.id.tag_del_post_id, sparseArray.get(R.id.tag_del_post_id));
                sparseArray3.put(R.id.tag_del_post_type, sparseArray.get(R.id.tag_del_post_type));
                sparseArray3.put(R.id.tag_del_post_is_self, sparseArray.get(R.id.tag_del_post_is_self));
                sparseArray3.put(R.id.tag_manage_user_identity, sparseArray.get(R.id.tag_manage_user_identity));
                x15Var3.d.setTag(sparseArray3);
                arrayList.add(x15Var3);
            }
            if ((!"".equals(sparseArray.get(R.id.tag_forbid_user_name)) || !"".equals(sparseArray.get(R.id.tag_forbid_user_name_show))) && !a2()) {
                SparseArray sparseArray4 = new SparseArray();
                sparseArray4.put(R.id.tag_forbid_user_name, sparseArray.get(R.id.tag_forbid_user_name));
                sparseArray4.put(R.id.tag_forbid_user_name_show, sparseArray.get(R.id.tag_forbid_user_name_show));
                sparseArray4.put(R.id.tag_forbid_user_portrait, sparseArray.get(R.id.tag_forbid_user_portrait));
                sparseArray4.put(R.id.tag_manage_user_identity, sparseArray.get(R.id.tag_manage_user_identity));
                sparseArray4.put(R.id.tag_forbid_user_post_id, sparseArray.get(R.id.tag_forbid_user_post_id));
                x15 x15Var4 = new x15(11, this.c.getString(R.string.forbidden_person), b25Var);
                x15Var4.d.setTag(sparseArray4);
                arrayList.add(x15Var4);
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
                    x15Var = new x15(12, this.c.getString(R.string.un_mute), b25Var);
                } else {
                    x15Var = new x15(12, this.c.getString(R.string.obfuscated_res_0x7f0f0bef), b25Var);
                }
                x15Var.d.setTag(sparseArray5);
                arrayList.add(x15Var);
            }
            gj8.f(arrayList);
            if (UbsABTestHelper.isPBPlanA()) {
                b25Var.l(arrayList, false);
            } else {
                b25Var.l(arrayList, true);
            }
            z15 z15Var = new z15(this.c.getPageContext(), b25Var);
            this.T = z15Var;
            z15Var.k();
        }
    }

    public final void H2(PbReplyTitleViewHolder pbReplyTitleViewHolder, boolean z2) {
        boolean z3;
        int measuredHeight;
        int i2;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLZ(1048608, this, pbReplyTitleViewHolder, z2) == null) && !this.o1 && this.X0 != null && this.h.q() != null) {
            View s3 = J0().s();
            if (s3 != null) {
                int[] iArr = new int[2];
                s3.getLocationInWindow(iArr);
                int i3 = iArr[1];
                if (i3 != 0) {
                    if (this.X0.getVisibility() == 0 && i3 - this.h.q().getBottom() <= this.X0.getHeight()) {
                        this.Y0.setVisibility(0);
                        if (i3 > this.h.q().getBottom()) {
                            i2 = -(((this.X0.getHeight() + this.Y0.getHeight()) + this.h.q().getBottom()) - s3.getBottom());
                        } else {
                            i2 = -this.X0.getHeight();
                        }
                        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.X0.getLayoutParams();
                        if (layoutParams.topMargin != i2) {
                            layoutParams.topMargin = i2;
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
            int G = this.F.G();
            if (G > 0 && (pbReplyTitleViewHolder == null || pbReplyTitleViewHolder.getView().getParent() == null)) {
                PbLandscapeListView pbLandscapeListView = this.l;
                if (pbLandscapeListView != null && G > pbLandscapeListView.getFirstVisiblePosition() - this.l.getHeaderViewsCount()) {
                    this.X0.setVisibility(4);
                    return;
                }
                this.X0.setVisibility(0);
                M3(false);
                this.h.a.hideBottomLine();
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
                    int i4 = this.c1;
                    if (top < i4) {
                        i4 = top;
                    }
                    this.c1 = i4;
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
                    measuredHeight = m2 - pbReplyTitleViewHolder.g.getMeasuredHeight();
                } else {
                    measuredHeight = this.h.q().getMeasuredHeight() - pbReplyTitleViewHolder.g.getMeasuredHeight();
                    this.h.a.hideBottomLine();
                }
                if (pbReplyTitleViewHolder.getView().getParent() == null && top <= this.c1) {
                    this.X0.setVisibility(0);
                    M3(false);
                } else if (top < measuredHeight) {
                    this.X0.setVisibility(0);
                    M3(false);
                } else {
                    this.X0.setVisibility(4);
                    this.h.a.hideBottomLine();
                }
                if (z2) {
                    this.d1 = true;
                }
            } else {
                PbLandscapeListView pbLandscapeListView2 = this.l;
                if (pbLandscapeListView2 != null && pbLandscapeListView2.getFirstVisiblePosition() == 0) {
                    this.X0.setVisibility(4);
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
        if ((interceptable == null || interceptable.invokeV(1048585, this) == null) && (pbFragment = this.c) != null && pbFragment.M() != null && this.c.M().G != null && this.c.M().G.Q() != null && this.c.M().G.Q().isXiuXiuThread()) {
            ThreadData Q = this.c.M().G.Q();
            int i3 = 0;
            if (this.c.M().X0()) {
                i2 = 1;
            } else if (this.c.M().a1()) {
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
        int headerViewsCount = pbLandscapeListView.getHeaderViewsCount() - this.n1;
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
        this.e1.c = null;
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004013, this.e1));
        PbReplyTitleViewHolder pbReplyTitleViewHolder = this.e1.c;
        int m1 = m1(pbReplyTitleViewHolder);
        int measuredHeight = this.E.getMeasuredHeight() + ((int) this.E.getY());
        boolean z3 = true;
        if (this.X0.getVisibility() == 0) {
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
                this.l.setSelectionFromTop(this.F.G() + this.l.getHeaderViewsCount(), m2 - i4);
            } else {
                this.l.setSelectionFromTop(this.F.G() + this.l.getHeaderViewsCount(), this.h.q().getMeasuredHeight() - i4);
            }
        } else {
            this.l.setSelectionFromTop(i2, i3);
        }
        if (this.o1 && this.t != null) {
            this.l.setSelectionFromTop(this.F.G() + this.l.getHeaderViewsCount(), this.t.d());
        } else if (this.Q0 != 6) {
        } else {
            this.l.setOnLayoutListener(new l(this, m1, pbReplyTitleViewHolder, z2, measuredHeight, i2, i3));
        }
    }

    public void k2() {
        NoNetworkView.b bVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048728, this) == null) {
            ig8 ig8Var = this.p;
            if (ig8Var != null) {
                ig8Var.l();
            }
            hh8 hh8Var = this.r;
            if (hh8Var != null) {
                hh8Var.o();
            }
            RelativeLayout relativeLayout = this.d;
            if (relativeLayout != null && relativeLayout.getHandler() != null) {
                this.d.getHandler().removeCallbacksAndMessages(null);
            }
            sl8 sl8Var = this.G0;
            if (sl8Var != null) {
                sl8Var.k();
            }
            dh8 dh8Var = this.l1;
            if (dh8Var != null) {
                dh8Var.a();
            }
            ug8 ug8Var = this.B1;
            if (ug8Var != null) {
                ug8Var.c();
            }
            PbTopTipView pbTopTipView = this.s1;
            if (pbTopTipView != null) {
                pbTopTipView.g();
            }
            this.c.hideProgressBar();
            NoNetworkView noNetworkView = this.m;
            if (noNetworkView != null && (bVar = this.S) != null) {
                noNetworkView.e(bVar);
            }
            h59.d();
            v0();
            D0();
            if (this.i1 != null) {
                gh.a().removeCallbacks(this.i1);
            }
            PbInterviewStatusView pbInterviewStatusView = this.U0;
            if (pbInterviewStatusView != null) {
                pbInterviewStatusView.m();
            }
            MessageManager.getInstance().unRegisterListener(this.S1);
            this.Y1 = null;
            this.g.removeCallbacksAndMessages(null);
            this.F.a0(3);
            View view2 = this.e;
            if (view2 != null) {
                view2.setBackgroundDrawable(null);
            }
            gi8 gi8Var = this.t;
            if (gi8Var != null) {
                gi8Var.a();
            }
            sf8 sf8Var = this.F;
            if (sf8Var != null) {
                sf8Var.c0();
            }
            li8 li8Var = this.w1;
            if (li8Var != null) {
                li8Var.l();
            }
            PbEmotionBar pbEmotionBar = this.f1;
            if (pbEmotionBar != null) {
                pbEmotionBar.x();
            }
            fi8 fi8Var = this.w;
            if (fi8Var != null) {
                fi8Var.D();
            }
            PbReplyTitleViewHolder pbReplyTitleViewHolder = this.a1;
            if (pbReplyTitleViewHolder != null) {
                pbReplyTitleViewHolder.p(null);
            }
            this.y1 = null;
            PbLandscapeListView pbLandscapeListView = this.l;
            if (pbLandscapeListView != null) {
                pbLandscapeListView.setOnLayoutListener(null);
                this.l.getViewTreeObserver().removeGlobalOnLayoutListener(this.a);
                this.l.setListViewDragListener(null);
                this.l = null;
            }
            AgreeView agreeView = this.B0;
            if (agreeView != null) {
                agreeView.setAgreeLongClickListener(null);
            }
            a1 a1Var = this.e1;
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
                jk8.r("c10517", this.k0, 2);
            } else if (!this.c.c5()) {
                TiebaStatic.log(new StatisticItem(CommonStatisticKey.KEY_RD_USE).param("obj_param1", 3).param("obj_locate", 8).param("obj_type", 1).param("obj_source", UtilHelper.getCurrentPageName(TbadkCoreApplication.getInst().getCurrentActivity())));
            } else {
                bf5 H5 = this.c.H5();
                if (H5 != null && (H5.x() || H5.z())) {
                    TiebaStatic.log(new StatisticItem(CommonStatisticKey.KEY_RD_USE).param("obj_param1", 3).param("obj_locate", 10).param("obj_type", 1).param("obj_source", UtilHelper.getCurrentPageName(TbadkCoreApplication.getInst().getCurrentActivity())));
                    this.c.H5().w(false, null);
                    return;
                }
                if (this.n0 != null) {
                    J1();
                }
                EditorTools editorTools = this.n0;
                if (editorTools != null) {
                    this.K0 = false;
                    if (editorTools.p(2) != null) {
                        h59.c(this.c.getPageContext(), (View) this.n0.p(2).m, false, v2);
                    }
                }
                v1();
            }
        }
    }

    public void n2() {
        PostData postData;
        int i2;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048743, this) != null) || this.c == null) {
            return;
        }
        if (!this.I1 && this.J1 != 17) {
            if (this.p1 && !this.o1 && (postData = this.P0) != null && postData.r() != null) {
                int i3 = 2;
                if (this.c.v0()) {
                    i2 = 2;
                } else {
                    i2 = 1;
                }
                if (!this.o1) {
                    i3 = 1;
                }
                jk8.q("c12601", i3, i2);
                MessageManager.getInstance().sendMessage(new CustomMessage(2002003, new PersonInfoActivityConfig(this.c.getPageContext().getPageActivity(), this.P0.r().getUserId(), this.P0.r().getUserName(), this.c.M().R0(), AddFriendActivityConfig.TYPE_PB_HEAD)));
                return;
            }
            return;
        }
        hd8 hd8Var = this.O0;
        if (hd8Var != null && hd8Var.l() != null && !dj.isEmpty(this.O0.l().getName())) {
            MessageManager.getInstance().sendMessage(new CustomMessage(2003000, new FrsActivityConfig(this.c.getContext()).createNormalCfg(this.O0.l().getName(), null)));
            TiebaStatic.log(new StatisticItem("c13853").param("post_id", this.O0.S()).param("uid", TbadkCoreApplication.getCurrentAccountId()).param("fid", this.O0.l().getId()));
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
            this.c.z6();
            PbFragment pbFragment = this.c;
            if (pbFragment != null && pbFragment.M() != null && this.c.M().s1() != null && this.c.M().s1().Q() != null && this.c.M().s1().Q().getAuthor() != null) {
                TiebaStatic.log(new StatisticItem("c13701").param("tid", this.c.M().N1()).param("fid", this.c.M().s1().m()).param("uid", TbadkCoreApplication.getCurrentAccountId()));
                TiebaStatic.log(new StatisticItem("c13402").param("tid", this.c.M().b).param("fid", this.c.M().s1().m()).param("obj_locate", 1).param("uid", TbadkCoreApplication.getCurrentAccount()));
            }
        }
    }

    public void C3(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, str) == null) {
            this.y0.performClick();
            if (!StringUtils.isNull(str) && this.c.H5() != null && this.c.H5().s() != null && this.c.H5().s().i() != null) {
                EditText i2 = this.c.H5().s().i();
                i2.setText(str);
                i2.setSelection(str.length());
            }
        }
    }

    public final void H1(hd8 hd8Var) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048607, this, hd8Var) != null) || hd8Var == null || hd8Var.Q() == null || !hd8Var.Q().isInterviewLive() || this.U0 != null) {
            return;
        }
        PbInterviewStatusView pbInterviewStatusView = (PbInterviewStatusView) this.T0.inflate();
        this.U0 = pbInterviewStatusView;
        pbInterviewStatusView.setOnClickListener(this.Q);
        this.U0.setCallback(this.c.A5());
        this.U0.setData(this.c, hd8Var);
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
            un adapter2 = pbLandscapeListView.getAdapter2();
            if (adapter2 == null) {
                return i2;
            }
            if (i2 < adapter2.getCount() && i2 >= 0 && (adapter2.getItem(i2) instanceof ed8)) {
                i2++;
            }
            int o3 = (adapter2.o() + adapter2.m()) - 1;
            if (i2 > o3) {
                i2 = o3;
            }
            if (this.l.getAdapter2() != null && (this.l.getAdapter2() instanceof un)) {
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
        if ((interceptable == null || interceptable.invokeZ(1048649, this, z2) == null) && this.u0 != null && (textView = this.y0) != null) {
            textView.setText(R.string.obfuscated_res_0x7f0f0554);
            if (z2) {
                AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
                alphaAnimation.setDuration(400L);
                this.u0.startAnimation(alphaAnimation);
            }
            this.t0.setVisibility(0);
            this.u0.setVisibility(0);
            this.K0 = true;
            if (this.f1 != null && !this.x1.l()) {
                this.f1.setVisibility(0);
                T2(true);
            }
        }
    }

    public void Z2(String str) {
        PbReplyTitleViewHolder pbReplyTitleViewHolder;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048680, this, str) == null) && this.L != null) {
            int i2 = 0;
            a1 a1Var = this.e1;
            if (a1Var != null && (pbReplyTitleViewHolder = a1Var.c) != null && pbReplyTitleViewHolder.getView() != null) {
                i2 = this.e1.c.getView().getTop() < 0 ? this.e1.c.getView().getHeight() : this.e1.c.getView().getBottom();
            }
            this.L.I(str, i2);
        }
    }

    public final void m4(hd8 hd8Var) {
        boolean z2;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048740, this, hd8Var) == null) && !this.A1 && hd8Var != null && hd8Var.Q() != null && !hd8Var.Q().isVideoThreadType()) {
            boolean z3 = false;
            if (hd8Var.Q().getIs_good() == 1) {
                z2 = true;
            } else {
                z2 = false;
            }
            if (hd8Var.Q().getIs_top() == 1) {
                z3 = true;
            }
            fi8 fi8Var = this.w;
            if (fi8Var != null) {
                fi8Var.q(hd8Var, z2, z3);
            }
            di8 di8Var = this.v;
            if (di8Var != null) {
                di8Var.b(hd8Var, z2, z3);
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
            View view2 = this.q0;
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
        if ((interceptable == null || interceptable.invokeL(1048592, this, view2) == null) && this.B0.getData() != null && this.B0.getData().hasAgree && this.c.getActivity() != null) {
            jc8 jc8Var = new jc8(this.c.getContext());
            int g2 = ej.g(TbadkCoreApplication.getInst(), R.dimen.tbds774);
            int g3 = ej.g(TbadkCoreApplication.getInst(), R.dimen.obfuscated_res_0x7f07077f);
            int[] iArr = new int[2];
            view2.getLocationInWindow(iArr);
            int i2 = iArr[0];
            int i3 = iArr[1];
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(g3, g2);
            layoutParams.leftMargin = ((view2.getWidth() / 2) + i2) - ((int) ((g3 * 1) / 1.45d));
            layoutParams.topMargin = ej.g(TbadkCoreApplication.getInst(), R.dimen.M_H_X006);
            jc8Var.k(g2);
            jc8Var.j(layoutParams);
            jc8Var.i(false);
            jc8Var.n(true, this.c.getActivity().findViewById(16908290), 0, i3, this.O0.S(), this.O0.m());
            jc8Var.l(new o(this));
        }
    }

    public final boolean Q3(hd8 hd8Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048645, this, hd8Var)) == null) {
            if (hd8Var == null || hd8Var.Q() == null) {
                return false;
            }
            if (hd8Var.Q().getIsLive() != 1 && hd8Var.Q().getThreadType() != 33 && ((hd8Var.Q().getTopicData() == null || hd8Var.Q().getTopicData().a() == 0) && hd8Var.Q().getIs_top() != 1 && hd8Var.Q().getIs_good() != 1 && !hd8Var.Q().isActInfo() && !hd8Var.Q().isInterviewLive() && !hd8Var.Q().isVoteThreadType() && hd8Var.Q().getYulePostActivityData() == null && dj.isEmpty(hd8Var.Q().getCategory()) && !hd8Var.Q().isGodThread() && !hd8Var.Q().isRealGod())) {
                return false;
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public void l2(TbRichText tbRichText) {
        hd8 hd8Var;
        PostData postData;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048733, this, tbRichText) == null) && (hd8Var = this.O0) != null && hd8Var.H() != null && !this.O0.H().isEmpty() && tbRichText != null && !StringUtils.isNull(tbRichText.getAuthorId())) {
            for (int i2 = 0; i2 < this.O0.H().size() && (postData = this.O0.H().get(i2)) != null && postData.r() != null && !StringUtils.isNull(postData.r().getUserId()); i2++) {
                if (this.O0.H().get(i2).r().getUserId().equals(tbRichText.getAuthorId())) {
                    hf8 hf8Var = this.x1;
                    if (hf8Var != null && hf8Var.l()) {
                        N3(false);
                    }
                    PbEmotionBar pbEmotionBar = this.f1;
                    if (pbEmotionBar != null) {
                        pbEmotionBar.q(true);
                    }
                    postData.r().getName_show();
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
            q15 q15Var = new q15(this.c.getPageContext().getPageActivity());
            View inflate = LayoutInflater.from(this.c.getPageContext().getPageActivity()).inflate(R.layout.upgrade_success_dialog_content, (ViewGroup) null);
            TextView textView = (TextView) inflate.findViewById(R.id.title_view);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
            layoutParams.setMargins(0, 0, 0, 0);
            textView.setLayoutParams(layoutParams);
            textView.setGravity(3);
            textView.setText(str);
            ((TextView) inflate.findViewById(R.id.function_description_view)).setVisibility(8);
            q15Var.setContentView(inflate);
            SparseArray sparseArray = new SparseArray();
            sparseArray.put(o2, Integer.valueOf(r2));
            q15Var.setYesButtonTag(sparseArray);
            q15Var.setPositiveButton(R.string.obfuscated_res_0x7f0f166d, this.c);
            q15Var.setNegativeButton(R.string.obfuscated_res_0x7f0f038d, new s0(this));
            q15Var.create(this.c.getPageContext()).show();
        }
    }

    public void u4(fd8 fd8Var) {
        String string;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048780, this, fd8Var) != null) || fd8Var == null) {
            return;
        }
        this.h.L();
        if (!StringUtils.isNull(fd8Var.b)) {
            this.h.H(fd8Var.b);
        }
        String string2 = TbadkCoreApplication.getInst().getResources().getString(R.string.obfuscated_res_0x7f0f14ad);
        int e2 = dh.e(fd8Var.a, 0);
        if (e2 != 100) {
            if (e2 != 300) {
                if (e2 != 400) {
                    string = "";
                } else {
                    string = TbadkCoreApplication.getInst().getResources().getString(R.string.obfuscated_res_0x7f0f1423);
                }
            } else {
                string = TbadkCoreApplication.getInst().getResources().getString(R.string.obfuscated_res_0x7f0f0304);
            }
        } else {
            string = TbadkCoreApplication.getInst().getResources().getString(R.string.obfuscated_res_0x7f0f11d5);
        }
        this.c.showNetRefreshView(this.d, String.format(string2, string), null, TbadkCoreApplication.getInst().getResources().getString(R.string.appeal_restore), true, new l0(this, fd8Var.c));
    }

    public final boolean F3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048601, this)) == null) {
            hd8 hd8Var = this.O0;
            if (hd8Var != null && hd8Var.Q() != null && !ListUtils.isEmpty(this.O0.Q().getThreadRecommendInfoDataList()) && this.c != null && this.v.d() != null && this.v.d().getVisibility() == 0 && this.O0.Q().getThreadRecommendInfoDataList().get(0) != null && this.O0.Q().getThreadRecommendInfoDataList().get(0).businessType == 1) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public final void G2() {
        oj8 oj8Var;
        hd8 hd8Var;
        boolean z2;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048604, this) == null) && this.v != null && (oj8Var = this.h) != null && oj8Var.q() != null && (hd8Var = this.O0) != null && hd8Var.Q() != null && this.O0.Q().isQuestionThread() && this.v.d() != null && this.v.d().getVisibility() == 0) {
            int[] iArr = new int[2];
            this.v.d().getLocationInWindow(iArr);
            boolean z3 = true;
            int height = iArr[1] + this.v.d().getHeight();
            if (this.v.d().getParent() == null) {
                z2 = false;
            } else {
                z2 = true;
            }
            oj8 oj8Var2 = this.h;
            if (height > oj8Var2.q().getBottom() && z2) {
                z3 = false;
            }
            oj8Var2.I(z3, this.O0.Q().getSpan_str());
        }
    }

    public final void I1() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048611, this) != null) || !this.c.B5()) {
            return;
        }
        ViewStub viewStub = (ViewStub) this.d.findViewById(R.id.obfuscated_res_0x7f0915e0);
        this.k = viewStub;
        viewStub.setVisibility(0);
        if (this.B == null) {
            this.B = (LinearLayout) this.d.findViewById(R.id.obfuscated_res_0x7f0915df);
            wm5.a(this.c.getPageContext(), this.B);
        }
        if (this.C == null) {
            this.C = (TextView) this.B.findViewById(R.id.obfuscated_res_0x7f0915e4);
        }
        if (this.D == null) {
            this.D = (TextView) this.B.findViewById(R.id.obfuscated_res_0x7f0915e3);
        }
        this.C.setOnClickListener(this.Q);
        this.D.setOnClickListener(this.Q);
    }

    public void J1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048615, this) == null) {
            if (this.c != null && this.n0 != null) {
                TiebaStatic.log(new StatisticItem(CommonStatisticKey.KEY_RD_USE).param("obj_param1", 3).param("obj_locate", 9).param("obj_type", 1).param("obj_source", UtilHelper.getCurrentPageName(TbadkCoreApplication.getInst().getCurrentActivity())));
                this.n0.j();
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
        if ((interceptable == null || interceptable.invokeV(1048652, this) == null) && (pbFragment = this.c) != null && pbFragment.H5() != null && this.n0 != null) {
            we5.a().c(0);
            bf5 H5 = this.c.H5();
            H5.M();
            H5.K();
            if (H5.v() != null) {
                WriteImagesInfo v3 = H5.v();
                if (H5.t) {
                    i2 = 1;
                } else {
                    i2 = 9;
                }
                v3.setMaxImagesAllowed(i2);
            }
            H5.d0(SendView.h);
            H5.h(SendView.h);
            fd5 o3 = this.n0.o(23);
            fd5 o4 = this.n0.o(2);
            fd5 o5 = this.n0.o(5);
            if (o4 != null) {
                o4.display();
            }
            if (o5 != null) {
                o5.display();
            }
            if (o3 != null) {
                o3.hide();
            }
            this.n0.invalidate();
        }
    }

    public final void f2() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048704, this) == null) && UbsABTestHelper.isShareTopRight()) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.C0.getLayoutParams();
            layoutParams.addRule(11);
            this.C0.setLayoutParams(layoutParams);
            if (this.D0.getParent() != null) {
                ((ViewGroup) this.D0.getParent()).removeView(this.D0);
                ((ViewGroup) this.E0.getParent()).removeView(this.E0);
            }
            if (this.F0.getParent() != null) {
                ((ViewGroup) this.F0.getParent()).removeView(this.F0);
            }
            RelativeLayout relativeLayout = new RelativeLayout(TbadkCoreApplication.getInst().getContext());
            relativeLayout.addView(this.D0);
            relativeLayout.addView(this.E0);
            relativeLayout.addView(this.F0);
            this.h.a.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, relativeLayout, (View.OnClickListener) null);
            this.h.a.getViewGroup(NavigationBar.ControlAlign.HORIZONTAL_RIGHT).setClipChildren(false);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:24:0x0051, code lost:
        if (r5.K1 == 1) goto L19;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void u0() {
        rl8 rl8Var;
        int i2;
        boolean z2;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048776, this) != null) || (rl8Var = this.N1) == null) {
            return;
        }
        if (this.l != null && rl8Var.a() != null && this.N1.a().getParent() != null) {
            i2 = this.l.getPositionForView(this.N1.a());
        } else {
            i2 = -1;
        }
        boolean z3 = false;
        if (i2 != -1) {
            if (this.N1.a().getTop() + t2 <= this.X0.getBottom()) {
                this.K1 = 1;
                z2 = true;
            } else {
                this.K1 = 0;
                z2 = false;
            }
        }
        PbReplyTitleViewHolder pbReplyTitleViewHolder = this.a1;
        if (this.K1 == 1) {
            z3 = true;
        }
        pbReplyTitleViewHolder.t(z3);
        this.N1.e(z2);
    }

    public void y3() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048799, this) == null) {
            this.c.hideProgressBar();
            hd8 hd8Var = this.O0;
            if (hd8Var != null && this.L != null && hd8Var.z() != null && this.O0.z().b() == 0) {
                this.L.x(this.O0.t());
                if (this.O0.t()) {
                    StatisticItem statisticItem = new StatisticItem(CommonStatisticKey.KEY_PB_FOLD_ICON_SHOW);
                    statisticItem.param("uid", TbadkCoreApplication.getCurrentAccount());
                    statisticItem.param("fid", this.O0.m());
                    statisticItem.param("fname", this.O0.n());
                    statisticItem.param("tid", this.O0.S());
                    TiebaStatic.log(statisticItem);
                }
            }
            D0();
            PbLandscapeListView pbLandscapeListView = this.l;
            if (pbLandscapeListView != null) {
                pbLandscapeListView.A(0L);
            }
            y0();
        }
    }

    public final boolean G3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048605, this)) == null) {
            PbFragment pbFragment = this.c;
            if (pbFragment == null || pbFragment.M().s1().l().getDeletedReasonInfo() == null || 1 != this.c.M().s1().l().getDeletedReasonInfo().is_grays_cale_forum.intValue()) {
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
            FrameLayout frameLayout = this.V0;
            if (frameLayout != null) {
                frameLayout.setVisibility(0);
            }
            oj8 oj8Var = this.h;
            if (oj8Var != null && (view2 = oj8Var.d) != null) {
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
        if ((interceptable != null && interceptable.invokeV(1048644, this) != null) || (pbFragment = this.c) == null || pbFragment.getActivity() == null || (waterRippleView = this.z0) == null) {
            return;
        }
        ViewParent parent = waterRippleView.getParent();
        if (parent instanceof ViewGroup) {
            ((ViewGroup) parent).removeView(this.z0);
        }
        TextView textView = this.H0;
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
            View view2 = this.b1;
            if (view2 == null || view2.getParent() == null || this.L.o()) {
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
            hd8 hd8Var = this.O0;
            if (hd8Var == null || hd8Var.l() == null || "0".equals(this.O0.l().getId()) || "me0407".equals(this.O0.l().getName())) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public final void h4() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048715, this) == null) {
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
        if ((interceptable == null || interceptable.invokeV(1048731, this) == null) && this.O0 != null && UbsABTestHelper.isResizeInduceSharingABTest() && !ij8.k(this.O0.S())) {
            this.G0.f();
            ij8.b(this.O0.S());
        }
    }

    public String l1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048732, this)) == null) {
            if (!dj.isEmpty(this.F1)) {
                return this.F1;
            }
            if (this.c != null) {
                this.F1 = TbadkCoreApplication.getInst().getResources().getString(jh8.g());
            }
            return this.F1;
        }
        return (String) invokeV.objValue;
    }

    public final void q0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048756, this) == null) {
            hf8 hf8Var = new hf8(this.c, this, (ViewStub) this.d.findViewById(R.id.obfuscated_res_0x7f0916a1));
            this.x1 = hf8Var;
            hf8Var.o(this.Q);
            this.x1.p(this.U);
            this.x1.q(this.R);
            this.x1.o(this.Q);
            this.x1.s(this.l0);
        }
    }

    public void v0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048781, this) == null) {
            this.h.k();
            fi8 fi8Var = this.w;
            if (fi8Var != null) {
                fi8Var.r();
            }
            PbFragment pbFragment = this.c;
            if (pbFragment != null) {
                ej.z(pbFragment.getContext(), this.J);
            }
            x1();
            z15 z15Var = this.e0;
            if (z15Var != null) {
                z15Var.dismiss();
            }
            z0();
            q15 q15Var = this.G;
            if (q15Var != null) {
                q15Var.dismiss();
            }
            s15 s15Var = this.H;
            if (s15Var != null) {
                s15Var.e();
            }
        }
    }

    public final void v4() {
        PbFragment pbFragment;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048785, this) == null) && (pbFragment = this.c) != null && pbFragment.H5() != null) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921706, Boolean.valueOf(!this.c.H5().y())));
        }
    }

    public void w0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048786, this) == null) {
            this.h.k();
            fi8 fi8Var = this.w;
            if (fi8Var != null) {
                fi8Var.r();
            }
            z15 z15Var = this.e0;
            if (z15Var != null) {
                z15Var.dismiss();
            }
            z0();
            q15 q15Var = this.G;
            if (q15Var != null) {
                q15Var.dismiss();
            }
            s15 s15Var = this.H;
            if (s15Var != null) {
                s15Var.e();
            }
        }
    }

    public final void y4() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048800, this) != null) || !this.c.B5()) {
            return;
        }
        if (this.c.G5() == -1) {
            SkinManager.setViewTextColor(this.C, R.color.CAM_X0110, 1);
        }
        if (this.c.F5() == -1) {
            SkinManager.setViewTextColor(this.D, R.color.CAM_X0110, 1);
        }
    }

    public void z0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048801, this) == null) {
            q15 q15Var = this.V;
            if (q15Var != null) {
                q15Var.dismiss();
            }
            Dialog dialog = this.W;
            if (dialog != null) {
                ih.b(dialog, this.c.getPageContext());
            }
            Dialog dialog2 = this.X;
            if (dialog2 != null) {
                ih.b(dialog2, this.c.getPageContext());
            }
            z15 z15Var = this.T;
            if (z15Var != null) {
                z15Var.dismiss();
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
                return this.c.getString(R.string.obfuscated_res_0x7f0f0ea0);
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
        TBAlertConfig.a aVar = new TBAlertConfig.a((int) R.string.obfuscated_res_0x7f0f1250, TBAlertConfig.OperateBtnStyle.MAIN);
        TBAlertConfig.a aVar2 = new TBAlertConfig.a((int) R.string.obfuscated_res_0x7f0f038d, TBAlertConfig.OperateBtnStyle.SECONDARY);
        TBAlertBuilder tBAlertBuilder = new TBAlertBuilder(this.c.N());
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
            this.n0 = editorTools;
            editorTools.setOnCancelClickListener(new s(this));
            this.n0.setId(R.id.obfuscated_res_0x7f091940);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
            layoutParams.addRule(12);
            if (this.n0.getParent() == null) {
                this.d.addView(this.n0, layoutParams);
            }
            this.n0.y(TbadkCoreApplication.getInst().getSkinType());
            this.n0.setActionListener(24, new t(this));
            x1();
            this.c.H5().g(new u(this));
        }
    }

    public void h2(m59 m59Var) {
        hd8 hd8Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048713, this, m59Var) == null) && m59Var != null && m59Var.b != null && (hd8Var = this.O0) != null && hd8Var.Q() != null && this.O0.Q().getAgreeData() != null) {
            AgreeData agreeData = this.O0.Q().getAgreeData();
            String str = m59Var.b.nid;
            if (!TextUtils.isEmpty(str) && !"0".equals(str)) {
                BaijiahaoData baijiahaoData = agreeData.baijiahaoData;
                if (baijiahaoData == null || !TextUtils.equals(str, baijiahaoData.oriUgcNid)) {
                    return;
                }
            } else {
                String str2 = m59Var.b.threadId;
                String str3 = agreeData.threadId;
                if ("0".equals(str2) || TextUtils.isEmpty(str2) || !TextUtils.equals(str2, str3)) {
                    return;
                }
            }
            AgreeData agreeData2 = m59Var.b;
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
        eg8 eg8Var = this.k1;
        if (eg8Var != null) {
            eg8Var.g();
        }
        this.c.W5();
        this.E.setVisibility(8);
        this.h.D(false);
        this.c.P6(false);
        if (this.t != null) {
            if (configuration.orientation == 1) {
                s1().setVisibility(0);
            }
            if (configuration.orientation == 2) {
                this.l2 = true;
                PbLandscapeListView pbLandscapeListView = this.l;
                if (pbLandscapeListView != null) {
                    pbLandscapeListView.setIsLandscape(true);
                    this.l.smoothScrollToPosition(0);
                }
            } else {
                this.l2 = false;
                PbLandscapeListView pbLandscapeListView2 = this.l;
                if (pbLandscapeListView2 != null) {
                    pbLandscapeListView2.setIsLandscape(false);
                    int i2 = this.j2;
                    if (i2 > 0) {
                        this.l.smoothScrollBy(i2, 0);
                    }
                }
            }
            this.t.j(configuration);
            this.V0.setLayoutParams(new RelativeLayout.LayoutParams(-2, -2));
        }
    }

    public void k4(boolean z2) {
        TextView textView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048730, this, z2) == null) && this.l != null && (textView = this.W0) != null && this.e != null) {
            if (z2) {
                if (UtilHelper.canUseStyleImmersiveSticky()) {
                    this.e.setVisibility(0);
                } else {
                    this.e.setVisibility(8);
                    this.l.removeHeaderView(this.W0);
                    this.l.setTextViewAdded(false);
                }
                if (this.W0.getLayoutParams() instanceof AbsListView.LayoutParams) {
                    AbsListView.LayoutParams layoutParams = (AbsListView.LayoutParams) this.W0.getLayoutParams();
                    layoutParams.height = m2;
                    this.W0.setLayoutParams(layoutParams);
                }
                V2();
                return;
            }
            if (textView.getLayoutParams() instanceof AbsListView.LayoutParams) {
                AbsListView.LayoutParams layoutParams2 = (AbsListView.LayoutParams) this.W0.getLayoutParams();
                layoutParams2.height = BdListViewHelper.a(BdListViewHelper.HeadType.DEFAULT) + d1(true);
                this.W0.setLayoutParams(layoutParams2);
            }
            V2();
            O2();
        }
    }

    public void w1(boolean z2) {
        boolean z3;
        boolean z4;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048787, this, z2) == null) && this.u0 != null && this.y0 != null) {
            TbSingleton tbSingleton = TbSingleton.getInstance();
            hd8 hd8Var = this.O0;
            if (hd8Var != null && hd8Var.r0()) {
                z3 = true;
            } else {
                z3 = false;
            }
            hd8 hd8Var2 = this.O0;
            if (hd8Var2 != null && hd8Var2.s0()) {
                z4 = true;
            } else {
                z4 = false;
            }
            this.y0.setText(tbSingleton.getAdVertiComment(z3, z4, l1()));
            if (z2) {
                AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
                alphaAnimation.setDuration(400L);
                this.u0.startAnimation(alphaAnimation);
            }
            this.t0.setVisibility(0);
            this.u0.setVisibility(0);
            this.K0 = true;
            if (this.f1 != null && !this.x1.l()) {
                this.f1.setVisibility(0);
                T2(true);
            }
        }
    }

    public void w4(hd8 hd8Var) {
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048790, this, hd8Var) == null) {
            if (hd8Var != null && AntiHelper.o(hd8Var.Q())) {
                sl8 sl8Var = this.G0;
                if (sl8Var != null) {
                    sl8Var.l(false);
                    this.G0.k();
                }
                ViewGroup.LayoutParams layoutParams = this.D0.getLayoutParams();
                layoutParams.height = -2;
                layoutParams.width = -2;
                this.D0.setLayoutParams(layoutParams);
                WebPManager.setPureDrawable(this.D0, R.drawable.icon_pure_pb_bottom_share26, R.color.CAM_X0110, WebPManager.ResourceStateType.NORMAL_PRESS);
                return;
            }
            sl8 sl8Var2 = this.G0;
            if (sl8Var2 != null && sl8Var2.h()) {
                return;
            }
            ViewGroup.LayoutParams layoutParams2 = this.D0.getLayoutParams();
            layoutParams2.height = -2;
            layoutParams2.width = -2;
            this.D0.setLayoutParams(layoutParams2);
            ImageView imageView = this.D0;
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
            sf8 sf8Var = this.F;
            if (sf8Var != null) {
                sf8Var.u0(z2);
                this.F.Z();
            }
            PbReplyTitleViewHolder pbReplyTitleViewHolder = this.a1;
            if (pbReplyTitleViewHolder != null) {
                pbReplyTitleViewHolder.o(z2);
            }
            PbReplyTitleViewHolder pbReplyTitleViewHolder2 = this.e1.c;
            if (pbReplyTitleViewHolder2 != null) {
                pbReplyTitleViewHolder2.o(z2);
            }
            PbFragment pbFragment = this.c;
            if (pbFragment != null) {
                pbFragment.O6(z2);
            }
            if (z2) {
                hj8.d(this.c.getPageContext(), this.c.M(), this.c.K5());
            }
            StatisticItem statisticItem = new StatisticItem(CommonStatisticKey.KEY_BATCH_MULTI_DEL_CLICK);
            hd8 hd8Var = this.O0;
            if (hd8Var != null) {
                str = hd8Var.m();
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
            if (this.B0.getWidth() != 0 && this.B0.getHeight() != 0) {
                WaterRippleView waterRippleView = this.z0;
                if (waterRippleView == null) {
                    this.z0 = new WaterRippleView(this.c.getActivity());
                } else {
                    ViewParent parent = waterRippleView.getParent();
                    if (parent instanceof ViewGroup) {
                        ((ViewGroup) parent).removeView(this.z0);
                    }
                }
                Rect rect = new Rect();
                this.d.getGlobalVisibleRect(rect);
                Rect rect2 = new Rect();
                this.B0.getImgAgree().getGlobalVisibleRect(rect2);
                int g2 = ej.g(this.c.getActivity(), R.dimen.tbds166);
                int i2 = ((rect2.right + rect2.left) / 2) - g2;
                int i3 = (rect.bottom - ((rect2.bottom + rect2.top) / 2)) - g2;
                int i4 = g2 * 2;
                RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(i4, i4);
                layoutParams.addRule(12, -1);
                layoutParams.setMargins(i2, 0, 0, i3);
                this.d.addView(this.z0, layoutParams);
                TextView textView = this.H0;
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
        if ((interceptable == null || interceptable.invokeV(1048696, this) == null) && (pbFragment = this.c) != null && pbFragment.M() != null && this.c.M().G != null && this.c.M().G.Q() != null && this.c.M().G.Q().isQuestionThread()) {
            ThreadData Q = this.c.M().G.Q();
            String E1 = this.c.M().E1();
            String F1 = this.c.M().F1();
            int i2 = 5;
            if ("question_answer_invite".equals(E1)) {
                i2 = 1;
            } else if ("3".equals(F1)) {
                i2 = 2;
            } else if ("answer_top".equals(E1)) {
                i2 = 3;
            } else if (this.c.M().X0()) {
                i2 = 4;
            }
            TiebaStatic.log(new StatisticItem("c14924").param("uid", TbadkCoreApplication.getCurrentAccountId()).param("tid", Q.getId()).param("fid", Q.getFid()).param("obj_source", i2));
        }
    }

    public final void o0() {
        hd8 hd8Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048746, this) == null) && this.A != null && (hd8Var = this.O0) != null && hd8Var.Q() != null && !ListUtils.isEmpty(this.O0.Q().getThreadRecommendInfoDataList()) && this.O0.Q().getThreadRecommendInfoDataList().get(0) != null && this.v.d().getVisibility() == 0) {
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
        if ((interceptable == null || interceptable.invokeV(1048766, this) == null) && !this.k2) {
            TiebaStatic.log("c10490");
            this.k2 = true;
            q15 q15Var = new q15(this.c.getPageContext().getPageActivity());
            SparseArray sparseArray = new SparseArray();
            sparseArray.put(o2, Integer.valueOf(q2));
            q15Var.setTitle(R.string.grade_thread_tips);
            View inflate = LayoutInflater.from(this.c.getPageContext().getPageActivity()).inflate(R.layout.upgrade_success_dialog_content, (ViewGroup) null);
            ((TextView) inflate.findViewById(R.id.function_description_view)).setText(R.string.function_upgrade_to_photo_live_tips);
            ((TextView) inflate.findViewById(R.id.title_view)).setText(R.string.grade_thread_tips);
            q15Var.setContentView(inflate);
            q15Var.setYesButtonTag(sparseArray);
            q15Var.setPositiveButton(R.string.grade_button_tips, this.c);
            q15Var.setNegativeButton(R.string.look_again, new q0(this));
            q15Var.create(this.c.getPageContext()).show();
        }
    }

    public final void K1(hd8 hd8Var, z75 z75Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048619, this, hd8Var, z75Var) == null) && this.R1 != null && hd8Var != null && z75Var != null && this.c.getContext() != null) {
            if (!RightFloatLayerView.k()) {
                C1();
                return;
            }
            if (this.Q1 == null) {
                RightFloatLayerView E = RightFloatLayerLottieView.E(z75Var, this.c.getContext());
                this.Q1 = E;
                E.setPageContext(this.c.getPageContext());
                this.R1.removeAllViews();
                this.R1.addView(this.Q1);
            }
            if ((this.P1.getTag() instanceof Boolean) && !((Boolean) this.P1.getTag()).booleanValue()) {
                this.Q1.setAutoCompleteShown(false);
                this.Q1.setTag(this.P1);
                this.Q1.c();
            }
            if (z75Var.a()) {
                return;
            }
            this.Q1.setData(z75Var);
            this.Q1.setLogoListener(new r0(this, z75Var));
            this.Q1.setFeedBackListener(new v0(this, z75Var));
        }
    }

    public final void K2(AgreeData agreeData, long j2) {
        TextView textView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLJ(1048620, this, agreeData, j2) == null) && agreeData != null && (textView = this.H0) != null) {
            if (j2 > 0) {
                if (agreeData.agreeType == 2 && agreeData.hasAgree) {
                    textView.setTextColor(SkinManager.getColor(R.color.CAM_X0301));
                } else {
                    this.H0.setTextColor(SkinManager.getColor(R.color.CAM_X0107));
                }
                this.H0.setText(H0(j2));
                this.H0.setVisibility(0);
                return;
            }
            textView.setVisibility(8);
        }
    }

    public void L1(hd8 hd8Var) {
        z75 pbAdFloatViewItemData;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048623, this, hd8Var) != null) || hd8Var == null) {
            return;
        }
        if (hd8Var.r0()) {
            pbAdFloatViewItemData = hd8Var.d0();
        } else {
            pbAdFloatViewItemData = TbSingleton.getInstance().getPbAdFloatViewItemData();
        }
        if (pbAdFloatViewItemData != null && !pbAdFloatViewItemData.a()) {
            K1(hd8Var, pbAdFloatViewItemData);
        } else {
            C1();
        }
    }

    public final boolean Q1(hd8 hd8Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048643, this, hd8Var)) == null) {
            if (hd8Var == null || hd8Var.Q() == null) {
                return false;
            }
            SpannableStringBuilder span_str = hd8Var.Q().getSpan_str();
            if (span_str == null) {
                return true;
            }
            if (!TbadkApplication.getInst().getResources().getString(R.string.obfuscated_res_0x7f0f0ea1).equals(span_str.toString())) {
                return false;
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public final boolean W1(ThreadData threadData) {
        InterceptResult invokeL;
        String str;
        PostData Z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048667, this, threadData)) == null) {
            if (threadData != null && threadData.getAuthor() != null) {
                hd8 hd8Var = this.O0;
                if (hd8Var != null && (Z = hd8Var.Z()) != null && Z.r() != null) {
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
            this.e1.c = null;
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004013, this.e1));
            H2(this.e1.c, false);
        }
    }

    public void t4(boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048775, this, z2) == null) {
            this.h.K(z2);
            if (z2 && this.S0) {
                this.L.F(TbadkCoreApplication.getInst().getResources().getString(R.string.click_load_more));
                PbLandscapeListView pbLandscapeListView = this.l;
                if (pbLandscapeListView != null) {
                    pbLandscapeListView.setNextPage(this.L);
                }
                this.f = 2;
            }
        }
    }

    public final void L2(hd8 hd8Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048624, this, hd8Var) == null) && hd8Var != null && hd8Var.Q() != null) {
            w4(hd8Var);
            ImageView imageView = this.C0;
            if (imageView != null && imageView.getContext() != null) {
                if (hd8Var.r()) {
                    WebPManager.setPureDrawable(this.C0, R.drawable.icon_pure_pb_bottom_collected26_selection, R.color.CAM_X0305, WebPManager.ResourceStateType.NORMAL_PRESS);
                } else {
                    WebPManager.setPureDrawable(this.C0, R.drawable.icon_pure_pb_bottom_collect26, R.color.CAM_X0107, WebPManager.ResourceStateType.NORMAL_PRESS);
                }
            }
            String I0 = I0(hd8Var.Q().getReply_num());
            TextView textView = this.I0;
            if (textView != null) {
                textView.setText(I0);
            }
            TextView textView2 = this.J0;
            if (textView2 != null) {
                textView2.setText(I0);
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921416, hd8Var.Q()));
            K2(hd8Var.Q().getAgreeData(), hd8Var.Q().getAgreeNum());
            if (this.B0 != null && hd8Var.Q() != null) {
                this.B0.setThreadData(hd8Var.Q());
                int i2 = 1;
                if (hd8Var.Q().getAgreeData() != null) {
                    hd8Var.Q().getAgreeData().isInThread = true;
                }
                this.B0.setData(hd8Var.Q().getAgreeData());
                fy4 fy4Var = new fy4();
                fy4Var.b = 26;
                if (hd8Var.Q().isVideoThreadType() && hd8Var.Q().getThreadVideoInfo() != null) {
                    i2 = 2;
                }
                fy4Var.c = i2;
                PbFragment pbFragment = this.c;
                if (pbFragment != null && pbFragment.M() != null) {
                    fy4Var.j = this.c.M().getFromForumId();
                    fy4Var.f = this.c.M().r1();
                }
                this.B0.setStatisticData(fy4Var);
            }
        }
    }

    public void N1(hd8 hd8Var) {
        PbReplyTitleViewHolder pbReplyTitleViewHolder;
        int bottom;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048631, this, hd8Var) == null) {
            int i2 = 0;
            this.F.h0(hd8Var, false);
            this.F.Z();
            y0();
            hf8 hf8Var = this.x1;
            if (hf8Var != null) {
                hf8Var.n();
            }
            ArrayList<PostData> H = hd8Var.H();
            if (hd8Var.z().b() == 0 || H == null || H.size() < hd8Var.z().e()) {
                if (ListUtils.getCount(H) != 0 && (ListUtils.getCount(H) != 1 || H.get(0) == null || H.get(0).F() != 1)) {
                    if (hd8Var.z().b() == 0) {
                        this.L.F(TbadkCoreApplication.getInst().getResources().getString(R.string.list_has_no_more));
                    } else {
                        this.L.F(TbadkCoreApplication.getInst().getResources().getString(R.string.load_more));
                    }
                    this.L.m();
                } else {
                    a1 a1Var = this.e1;
                    if (a1Var != null && (pbReplyTitleViewHolder = a1Var.c) != null && pbReplyTitleViewHolder.getView() != null) {
                        if (this.e1.c.getView().getTop() < 0) {
                            bottom = this.e1.c.getView().getHeight();
                        } else {
                            bottom = this.e1.c.getView().getBottom();
                        }
                        i2 = bottom;
                    }
                    if (this.c.f6()) {
                        this.L.I(TbadkCoreApplication.getInst().getResources().getString(R.string.obfuscated_res_0x7f0f0eb9), i2);
                    } else {
                        this.L.I(TbadkCoreApplication.getInst().getResources().getString(R.string.obfuscated_res_0x7f0f0eba), i2);
                    }
                }
            }
            L2(hd8Var);
        }
    }

    public void O3(hd8 hd8Var) {
        PostData postData;
        oj8 oj8Var;
        boolean z2;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048637, this, hd8Var) == null) && hd8Var != null && (postData = this.P0) != null && postData.r() != null && (oj8Var = this.h) != null) {
            boolean z3 = !this.o1;
            this.p1 = z3;
            oj8Var.J(z3);
            if (this.c.I5() != null) {
                this.c.I5().s(this.p1);
            }
            I2();
            PbFragment pbFragment = this.c;
            if (pbFragment != null && !pbFragment.v0() && !ListUtils.isEmpty(hd8Var.p())) {
                z05 z05Var = hd8Var.p().get(0);
                if (z05Var != null) {
                    this.h.N(hd8Var, z05Var.d(), z05Var.b(), z05Var.a(), z05Var.e());
                }
            } else if (hd8Var.l() != null) {
                oj8 oj8Var2 = this.h;
                String name = hd8Var.l().getName();
                String id = hd8Var.l().getId();
                String image_url = hd8Var.l().getImage_url();
                if (hd8Var.l().isLike() == 1) {
                    z2 = true;
                } else {
                    z2 = false;
                }
                oj8Var2.N(hd8Var, name, id, image_url, z2);
            }
            if (this.p1) {
                this.w.P(hd8Var, this.P0, this.i0);
                View view2 = this.Z0;
                if (view2 != null) {
                    view2.setVisibility(8);
                }
                if (this.y1 == null) {
                    this.y1 = new n0(this);
                }
                PbLandscapeListView pbLandscapeListView = this.l;
                if (pbLandscapeListView != null) {
                    pbLandscapeListView.setListViewDragListener(this.y1);
                    return;
                }
                return;
            }
            View view3 = this.Z0;
            if (view3 != null) {
                view3.setVisibility(0);
            }
            this.w.P(hd8Var, this.P0, this.i0);
            this.y1 = null;
            PbLandscapeListView pbLandscapeListView2 = this.l;
            if (pbLandscapeListView2 != null) {
                pbLandscapeListView2.setListViewDragListener(null);
            }
        }
    }

    public void S3(View view2) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048653, this, view2) != null) || b55.m().i("show_long_press_collection_tips", false)) {
            return;
        }
        Rect rect = new Rect();
        this.u0.getGlobalVisibleRect(rect);
        int i2 = rect.bottom;
        int i3 = rect.top;
        view2.getGlobalVisibleRect(rect);
        int i4 = rect.bottom;
        FrameLayout frameLayout = new FrameLayout(this.c.getContext());
        frameLayout.setBackgroundResource(R.drawable.pic_sign_tip);
        TextView textView = new TextView(this.c.getContext());
        this.u1 = textView;
        textView.setText(R.string.obfuscated_res_0x7f0f0467);
        this.u1.setGravity(17);
        this.u1.setPadding(ej.g(this.c.getContext(), R.dimen.obfuscated_res_0x7f0701e8), 0, ej.g(this.c.getContext(), R.dimen.obfuscated_res_0x7f0701e8), 0);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        layoutParams.gravity = 17;
        layoutParams.height = ej.g(this.c.getContext(), R.dimen.obfuscated_res_0x7f070253);
        if (this.u1.getParent() == null) {
            frameLayout.addView(this.u1, layoutParams);
        }
        PopupWindow popupWindow = new PopupWindow(this.c.getContext());
        this.t1 = popupWindow;
        popupWindow.setContentView(frameLayout);
        this.t1.setHeight(-2);
        this.t1.setWidth(-2);
        this.t1.setFocusable(true);
        this.t1.setOutsideTouchable(false);
        this.t1.setBackgroundDrawable(new ColorDrawable(TbadkCoreApplication.getInst().getResources().getColor(R.color.transparent)));
        GreyUtil.grey(this.t1);
        PbLandscapeListView pbLandscapeListView = this.l;
        if (pbLandscapeListView != null) {
            pbLandscapeListView.postDelayed(new t0(this, i4, i2, i3, view2), 100L);
        }
        b55.m().w("show_long_press_collection_tips", true);
    }

    public void c4(AdapterView.OnItemClickListener onItemClickListener) {
        boolean z2;
        boolean z3;
        boolean z4;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048694, this, onItemClickListener) == null) {
            u15 u15Var = this.g0;
            if (u15Var != null) {
                u15Var.d();
                this.g0 = null;
            }
            if (this.O0 == null) {
                return;
            }
            ArrayList<d25> arrayList = new ArrayList<>();
            String string = this.c.getContext().getString(R.string.all_person);
            boolean z5 = false;
            if (this.O0.N() == 1) {
                z2 = true;
            } else {
                z2 = false;
            }
            arrayList.add(new d25(string, "", z2, Integer.toString(1)));
            String string2 = this.c.getContext().getString(R.string.my_fans);
            if (this.O0.N() == 2) {
                z3 = true;
            } else {
                z3 = false;
            }
            arrayList.add(new d25(string2, "", z3, Integer.toString(5)));
            String string3 = this.c.getContext().getString(R.string.my_attentions);
            if (this.O0.N() == 3) {
                z4 = true;
            } else {
                z4 = false;
            }
            arrayList.add(new d25(string3, "", z4, Integer.toString(6)));
            String string4 = this.c.getContext().getString(R.string.myself_only);
            if (this.O0.N() == 4) {
                z5 = true;
            }
            arrayList.add(new d25(string4, "", z5, Integer.toString(7)));
            u15 u15Var2 = new u15(this.c.getPageContext());
            u15Var2.l(R.string.pb_privacy_setting_thread_reply_decs);
            this.g0 = u15Var2;
            u15Var2.k(arrayList, onItemClickListener);
            u15Var2.c();
            this.g0.n();
        }
    }

    public final void L3(int i2, SparseArray<Object> sparseArray) {
        PbFragment pbFragment;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeIL(1048625, this, i2, sparseArray) == null) && (pbFragment = this.c) != null && pbFragment.M() != null && this.c.M().s1() != null && this.c.M().s1().o() != null && this.c.M().s1().l() != null && this.c.M().s1().l().getDeletedReasonInfo() != null) {
            if (sparseArray != null) {
                sparseArray.put(R.id.tag_is_block_thread, Boolean.TRUE);
            }
            mx5 mx5Var = new mx5(this.c.M().s1().l().getDeletedReasonInfo().is_grays_cale_forum.intValue(), this.c.M().s1().l().getDeletedReasonInfo().is_boomgrow.intValue(), this.c.M().s1().o().has_forum_rule.intValue());
            mx5Var.i(this.c.M().s1().l().getId(), this.c.M().s1().l().getName());
            mx5Var.h(this.c.M().s1().l().getImage_url());
            mx5Var.j(this.c.M().s1().l().getUser_level());
            W3(sparseArray, i2, mx5Var, this.c.M().s1().X(), true);
        }
    }

    public final void e4(q15 q15Var, int i2) {
        PbFragment pbFragment;
        String str;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLI(1048702, this, q15Var, i2) == null) && (pbFragment = this.c) != null && q15Var != null) {
            if (this.D1 == null && this.u != null) {
                this.D1 = new kx5(pbFragment.getPageContext(), this.u.c());
            }
            AntiData s5 = this.c.s5();
            SparseArray<String> sparseArray = new SparseArray<>();
            if (s5 != null && s5.getDelThreadInfoList() != null) {
                List<DeleteThreadInfo> delThreadInfoList = s5.getDelThreadInfoList();
                for (int i3 = 0; i3 < delThreadInfoList.size(); i3++) {
                    if (!TextUtils.isEmpty(delThreadInfoList.get(i3).text_info)) {
                        sparseArray.put(delThreadInfoList.get(i3).text_id, delThreadInfoList.get(i3).text_info);
                    }
                }
            }
            wz4 wz4Var = new wz4();
            wz4Var.j(sparseArray);
            this.D1.B(new String[]{this.c.getString(R.string.delete_thread_reason_1), this.c.getString(R.string.delete_thread_reason_2), this.c.getString(R.string.delete_thread_reason_3), this.c.getString(R.string.delete_thread_reason_4), this.c.getString(R.string.delete_thread_reason_5)});
            this.D1.A(wz4Var);
            if (i2 != 1 && i2 != 2) {
                str = "3";
            } else {
                str = "4";
            }
            this.D1.D(str);
            this.D1.C(new b0(this, q15Var));
        }
    }

    public void j4(a05 a05Var, q15.e eVar) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLL(1048725, this, a05Var, eVar) != null) || a05Var == null) {
            return;
        }
        int a2 = a05Var.a();
        int h2 = a05Var.h();
        q15 q15Var = this.G;
        if (q15Var != null) {
            q15Var.show();
        } else {
            this.G = new q15(this.c.getPageContext().getPageActivity());
            View inflate = LayoutInflater.from(this.c.getPageContext().getPageActivity()).inflate(R.layout.obfuscated_res_0x7f0d023c, (ViewGroup) null);
            this.I = inflate;
            this.G.setContentView(inflate);
            this.G.setPositiveButton(R.string.obfuscated_res_0x7f0f0520, eVar);
            this.G.setNegativeButton(R.string.obfuscated_res_0x7f0f0518, new o0(this));
            this.G.setOnCalcelListener(new p0(this));
            this.G.create(this.c.getPageContext()).show();
        }
        EditText editText = (EditText) this.I.findViewById(R.id.obfuscated_res_0x7f091062);
        this.J = editText;
        editText.setText("");
        TextView textView = (TextView) this.I.findViewById(R.id.obfuscated_res_0x7f0907d3);
        if (a2 <= 0) {
            a2 = 1;
        }
        if (h2 <= 0) {
            h2 = 1;
        }
        textView.setText(MessageFormat.format(TbadkCoreApplication.getInst().getResources().getString(R.string.current_page), Integer.valueOf(a2), Integer.valueOf(h2)));
        this.c.getBaseFragmentActivity().ShowSoftKeyPadDelay(this.J, 150);
    }

    public boolean x4(hd8 hd8Var, boolean z2) {
        InterceptResult invokeLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(1048795, this, hd8Var, z2)) == null) {
            if (hd8Var == null) {
                return false;
            }
            if (this.v != null) {
                if (hd8Var.Q() != null && hd8Var.Q().getIsNoTitle() == 0 && !hd8Var.Q().isVideoThreadType() && !this.T1) {
                    if (hd8Var.Q() != null) {
                        ThreadData Q = hd8Var.Q();
                        Q.parserSpecTitleForFrsAndPb(true, Q3(hd8Var));
                        Q.setResource(3);
                        Q.setPbTitle("2");
                    }
                    if (hd8Var.Q().isBJHArticleThreadType()) {
                        this.w.F(this.l);
                        this.v.h(this.l);
                        this.v.a(this.l);
                        this.w.n(this.l);
                        this.w.K(this.O0);
                        if (Q1(hd8Var)) {
                            this.v.h(this.l);
                        } else {
                            this.v.i(hd8Var);
                        }
                    } else {
                        this.w.K(this.O0);
                        if (Q1(hd8Var)) {
                            this.v.h(this.l);
                        } else {
                            this.v.k(hd8Var);
                        }
                    }
                } else if (hd8Var.Q().getIsNoTitle() == 1) {
                    if (hd8Var.Q() != null) {
                        this.v.h(this.l);
                        this.w.K(this.O0);
                    }
                } else {
                    this.v.h(this.l);
                    this.w.K(this.O0);
                }
            }
            l4(hd8Var.Z());
            m4(hd8Var);
            this.N0 = z2;
            return false;
        }
        return invokeLZ.booleanValue;
    }

    public void M2(int i2, hd8 hd8Var, boolean z2, int i3) {
        PostData Z;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(1048628, this, new Object[]{Integer.valueOf(i2), hd8Var, Boolean.valueOf(z2), Integer.valueOf(i3)}) == null) && i2 > 0 && hd8Var != null && (Z = hd8Var.Z()) != null && Z.r() != null) {
            MetaData r3 = Z.r();
            r3.setGiftNum(r3.getGiftNum() + i2);
        }
    }

    public void N2(hd8 hd8Var, boolean z2, int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048632, this, new Object[]{hd8Var, Boolean.valueOf(z2), Integer.valueOf(i2), Integer.valueOf(i3)}) == null) {
            Z3(hd8Var, z2, i2, i3);
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
        TBAlertConfig.a aVar = new TBAlertConfig.a((int) R.string.obfuscated_res_0x7f0f04d8, TBAlertConfig.OperateBtnStyle.MAIN);
        TBAlertConfig.a aVar2 = new TBAlertConfig.a((int) R.string.obfuscated_res_0x7f0f038d, TBAlertConfig.OperateBtnStyle.SECONDARY);
        TBAlertBuilder tBAlertBuilder = new TBAlertBuilder(this.c.N());
        tBAlertBuilder.w(i2);
        tBAlertBuilder.m(i3);
        tBAlertBuilder.o(true);
        tBAlertBuilder.u(aVar2, aVar);
        tBAlertBuilder.j(false);
        AlertDialog z2 = tBAlertBuilder.z();
        aVar.a(new x(this, z2, sparseArray));
        aVar2.a(new y(this, z2));
    }

    public final void W3(SparseArray<Object> sparseArray, int i2, mx5 mx5Var, UserData userData, boolean z2) {
        PbFragment pbFragment;
        String str;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeCommon(1048669, this, new Object[]{sparseArray, Integer.valueOf(i2), mx5Var, userData, Boolean.valueOf(z2)}) != null) || (pbFragment = this.c) == null) {
            return;
        }
        if (this.E1 == null && this.u != null) {
            this.E1 = new nx5(pbFragment.getPageContext(), this.u.c(), mx5Var, userData);
        }
        this.E1.F(z2);
        AntiData s5 = this.c.s5();
        SparseArray<String> sparseArray2 = new SparseArray<>();
        if (s5 != null && s5.getDelThreadInfoList() != null) {
            List<DeleteThreadInfo> delThreadInfoList = s5.getDelThreadInfoList();
            for (int i3 = 0; i3 < delThreadInfoList.size(); i3++) {
                if (!TextUtils.isEmpty(delThreadInfoList.get(i3).text_info)) {
                    sparseArray2.put(delThreadInfoList.get(i3).text_id, delThreadInfoList.get(i3).text_info);
                }
            }
        }
        wz4 wz4Var = new wz4();
        wz4Var.j(sparseArray2);
        this.E1.H(new String[]{this.c.getString(R.string.delete_thread_reason_1), this.c.getString(R.string.delete_thread_reason_2), this.c.getString(R.string.delete_thread_reason_3), this.c.getString(R.string.delete_thread_reason_4), this.c.getString(R.string.delete_thread_reason_5)});
        this.E1.G(wz4Var);
        if (i2 != 1 && i2 != 2) {
            str = "3";
        } else {
            str = "4";
        }
        this.E1.J(str);
        this.E1.I(new c0(this, sparseArray));
    }

    public void b4(s15.c cVar, boolean z2, boolean z3, boolean z4, boolean z5) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048690, this, new Object[]{cVar, Boolean.valueOf(z2), Boolean.valueOf(z3), Boolean.valueOf(z4), Boolean.valueOf(z5)}) == null) {
            z15 z15Var = this.e0;
            if (z15Var != null) {
                z15Var.dismiss();
                this.e0 = null;
            }
            b25 b25Var = new b25(this.c.getContext());
            ArrayList arrayList = new ArrayList();
            if (!z4 && !z5) {
                arrayList.add(new x15(0, this.c.getPageContext().getString(R.string.obfuscated_res_0x7f0f0478), b25Var));
            }
            if (z3) {
                arrayList.add(new x15(1, this.c.getPageContext().getString(R.string.report_text), b25Var));
            } else if (!z2) {
                arrayList.add(new x15(1, this.c.getPageContext().getString(R.string.obfuscated_res_0x7f0f0b4f), b25Var));
            } else {
                arrayList.add(new x15(1, this.c.getPageContext().getString(R.string.remove_mark), b25Var));
            }
            b25Var.k(arrayList);
            b25Var.p(new f0(this, cVar));
            z15 z15Var2 = new z15(this.c.getPageContext(), b25Var);
            this.f0 = z15Var2;
            z15Var2.k();
        }
    }

    public void Y3(hd8 hd8Var, int i2, int i3, boolean z2, int i4, boolean z3) {
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
        hd8 hd8Var2;
        Parcelable e2;
        Parcelable e3;
        int size2;
        int i7;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(1048677, this, new Object[]{hd8Var, Integer.valueOf(i2), Integer.valueOf(i3), Boolean.valueOf(z2), Integer.valueOf(i4), Boolean.valueOf(z3)}) == null) && hd8Var != null && this.l != null) {
            this.O0 = hd8Var;
            this.Q0 = i2;
            if (hd8Var.Q() != null) {
                this.g1 = hd8Var.Q().getCopyThreadRemindType();
                if (hd8Var.Q().getAnchorLevel() != 0) {
                    this.e2 = true;
                }
                this.i0 = W1(hd8Var.Q());
            }
            if (hd8Var.X() != null) {
                this.f2 = hd8Var.X().getUserId();
            }
            H1(hd8Var);
            l0();
            this.S0 = false;
            this.N0 = z2;
            y3();
            qd8 qd8Var = hd8Var.h;
            if (qd8Var != null && qd8Var.b()) {
                if (this.o == null) {
                    PbThreadPostView pbThreadPostView = new PbThreadPostView(this.c.getContext());
                    this.o = pbThreadPostView;
                    this.l.x(pbThreadPostView, 1);
                    this.o.setData(hd8Var);
                    this.o.setChildOnClickLinstener(this.Q);
                }
            } else {
                PbThreadPostView pbThreadPostView2 = this.o;
                if (pbThreadPostView2 != null && (pbLandscapeListView = this.l) != null) {
                    pbLandscapeListView.removeHeaderView(pbThreadPostView2);
                }
            }
            Z3(hd8Var, z2, i2, TbadkCoreApplication.getInst().getSkinType());
            O3(hd8Var);
            this.w.Q(hd8Var, this.P0);
            if (this.B1 == null) {
                this.B1 = new ug8(this.c.getPageContext(), this.C1);
            }
            this.B1.a(hd8Var.x());
            if (this.c.B5()) {
                if (this.K == null) {
                    tl8 tl8Var = new tl8(this.c.getPageContext());
                    this.K = tl8Var;
                    tl8Var.n();
                    this.K.f(this.g2);
                }
                this.l.setPullRefresh(this.K);
                V2();
                tl8 tl8Var2 = this.K;
                if (tl8Var2 != null) {
                    tl8Var2.H(TbadkCoreApplication.getInst().getSkinType());
                }
            } else if (hd8Var.z().c() == 0 && z2) {
                this.l.setPullRefresh(null);
            } else {
                if (this.K == null) {
                    tl8 tl8Var3 = new tl8(this.c.getPageContext());
                    this.K = tl8Var3;
                    tl8Var3.n();
                    this.K.f(this.g2);
                }
                this.l.setPullRefresh(this.K);
                V2();
                tl8 tl8Var4 = this.K;
                if (tl8Var4 != null) {
                    tl8Var4.H(TbadkCoreApplication.getInst().getSkinType());
                }
                z1();
            }
            y0();
            this.F.p0(this.N0);
            this.F.m0(false);
            sf8 sf8Var = this.F;
            if (i2 == 5) {
                z4 = true;
            } else {
                z4 = false;
            }
            sf8Var.n0(z4);
            sf8 sf8Var2 = this.F;
            if (i2 == 6) {
                z5 = true;
            } else {
                z5 = false;
            }
            sf8Var2.o0(z5);
            sf8 sf8Var3 = this.F;
            if (z3 && this.c2 && i2 != 2) {
                z6 = true;
            } else {
                z6 = false;
            }
            sf8Var3.k0(z6);
            this.F.h0(hd8Var, false);
            this.F.Z();
            sf8 sf8Var4 = this.F;
            if (hd8Var.z().b() != 0) {
                z7 = true;
            } else {
                z7 = false;
            }
            sf8Var4.b0(z7, hd8Var.g());
            this.w.O(hd8Var.Z(), hd8Var.l0());
            if (hd8Var.Q() != null && hd8Var.Q().getPraise() != null && this.b != -1) {
                hd8Var.Q().getPraise().setIsLike(this.b);
            }
            this.l.removeFooterView(this.b1);
            this.l.addFooterView(this.b1);
            if (TbadkCoreApplication.isLogin()) {
                this.l.setNextPage(this.L);
                this.f = 2;
                z1();
            } else {
                this.S0 = true;
                if (hd8Var.z().b() == 1) {
                    if (this.M == null) {
                        PbFragment pbFragment2 = this.c;
                        this.M = new ol8(pbFragment2, pbFragment2);
                    }
                    this.l.setNextPage(this.M);
                } else {
                    this.l.setNextPage(this.L);
                }
                this.f = 3;
            }
            ArrayList<PostData> H = hd8Var.H();
            if (hd8Var.z().b() != 0 && H != null && H.size() >= hd8Var.z().e()) {
                if (z3) {
                    if (this.c2) {
                        D0();
                        if (hd8Var.z().b() != 0) {
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
                if (ListUtils.getCount(H) != 0 && (ListUtils.getCount(H) != 1 || H.get(0) == null || H.get(0).F() != 1)) {
                    if (hd8Var.z().b() == 0) {
                        this.L.F(TbadkCoreApplication.getInst().getResources().getString(R.string.list_has_no_more));
                    } else {
                        this.L.F(TbadkCoreApplication.getInst().getResources().getString(R.string.load_more));
                    }
                    this.L.m();
                } else {
                    a1 a1Var = this.e1;
                    if (a1Var != null && (pbReplyTitleViewHolder = a1Var.c) != null && pbReplyTitleViewHolder.getView() != null) {
                        if (this.e1.c.getView().getTop() < 0) {
                            i5 = this.e1.c.getView().getHeight();
                        } else {
                            i5 = this.e1.c.getView().getBottom();
                        }
                    } else {
                        i5 = 0;
                    }
                    if (this.c.f6()) {
                        this.L.x(false);
                        if (ListUtils.isEmpty(hd8Var.T())) {
                            this.L.I(TbadkCoreApplication.getInst().getResources().getString(R.string.obfuscated_res_0x7f0f0eb9), i5);
                        }
                    } else if (ListUtils.isEmpty(hd8Var.T())) {
                        this.L.I(TbadkCoreApplication.getInst().getResources().getString(R.string.obfuscated_res_0x7f0f0eba), i5);
                    }
                    if (this.c.I5() != null && !this.c.I5().p()) {
                        this.c.I5().x();
                    }
                }
                if (hd8Var.z().b() == 0 || H == null) {
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
                                        gi8 gi8Var = this.t;
                                        if (gi8Var != null && gi8Var.c() != null) {
                                            if (this.c.getBaseFragmentActivity().isUseStyleImmersiveSticky()) {
                                                this.l.setSelectionFromTop((this.F.B() + this.l.getHeaderViewsCount()) - 1, this.t.d() - ej.u(this.c.getPageContext().getPageActivity()));
                                            } else {
                                                this.l.setSelectionFromTop((this.F.B() + this.l.getHeaderViewsCount()) - 1, this.t.d());
                                            }
                                        } else {
                                            this.l.setSelection(this.F.B() + this.l.getHeaderViewsCount());
                                        }
                                    } else if (ListUtils.isEmpty(hd8Var.T())) {
                                        if (this.l.getData() == null && hd8Var.H() == null) {
                                            size2 = 0;
                                        } else {
                                            size2 = (this.l.getData().size() - hd8Var.H().size()) + this.l.getHeaderViewsCount();
                                        }
                                        PbLandscapeListView pbLandscapeListView2 = this.l;
                                        if (i3 > 0) {
                                            i7 = size2 + i3;
                                        } else {
                                            i7 = 0;
                                        }
                                        pbLandscapeListView2.setSelection(i7);
                                    } else {
                                        this.l.setSelection(hd8Var.H().size() + this.l.getHeaderViewsCount());
                                    }
                                    this.L.g();
                                    this.L.F(this.c.getString(R.string.obfuscated_res_0x7f0f0eb3));
                                    this.L.A();
                                }
                            } else if (i4 == 1 && (e3 = ah8.b().e()) != null && !(e3 instanceof RecyclerView.SavedState)) {
                                this.l.onRestoreInstanceState(e3);
                            } else {
                                this.l.setSelection(0);
                            }
                        } else {
                            this.l.setSelection(0);
                        }
                    } else {
                        this.c2 = false;
                    }
                } else if (i4 == 1 && (e2 = ah8.b().e()) != null && !(e2 instanceof RecyclerView.SavedState)) {
                    this.l.post(new m0(this, e2, H, hd8Var));
                }
            } else {
                if (this.l.getData() == null && hd8Var.H() == null) {
                    size = 0;
                } else {
                    size = (this.l.getData().size() - hd8Var.H().size()) + this.l.getHeaderViewsCount();
                }
                PbLandscapeListView pbLandscapeListView3 = this.l;
                if (i3 > 1) {
                    i6 = (size + i3) - 2;
                } else {
                    i6 = 0;
                }
                pbLandscapeListView3.setSelection(i6);
            }
            if (this.g1 == n2 && U1()) {
                s0();
            }
            if (this.m1) {
                J2();
                this.m1 = false;
                if (i4 == 0) {
                    n3(true);
                }
            }
            if (hd8Var.d == 1 || hd8Var.e == 1) {
                if (this.s1 == null) {
                    this.s1 = new PbTopTipView(this.c.getContext());
                }
                if (hd8Var.e == 1 && "game_guide".equals(this.c.N5())) {
                    this.s1.setText(this.c.getString(R.string.obfuscated_res_0x7f0f0ec5));
                    this.s1.l(this.d, this.R0);
                } else if (hd8Var.d == 1 && "game_news".equals(this.c.N5())) {
                    this.s1.setText(this.c.getString(R.string.obfuscated_res_0x7f0f0ec4));
                    this.s1.l(this.d, this.R0);
                }
            }
            this.l.removeFooterView(this.N1.a());
            if (!ListUtils.isEmpty(hd8Var.K()) && hd8Var.z().b() == 0) {
                this.l.removeFooterView(this.b1);
                this.N1.d(Math.max(this.u0.getMeasuredHeight(), this.L0 / 2));
                this.l.addFooterView(this.N1.a());
                this.N1.f(hd8Var);
            }
            L2(hd8Var);
            if (hd8Var.j0() && this.c.M().k2() && this.c.J5() != null) {
                this.c.J5().d();
            }
            if (hd8Var.g() != 3) {
                L1(hd8Var);
            }
            this.y0.setText(TbSingleton.getInstance().getAdVertiComment(hd8Var.r0(), hd8Var.s0(), l1()));
            if (this.p != null && (hd8Var2 = this.O0) != null && hd8Var2.l() != null) {
                this.p.m(this.O0.l().getImage_url());
                this.p.n(this.O0.l().getName());
                PbFragment pbFragment3 = this.c;
                if (pbFragment3 != null && pbFragment3.M() != null) {
                    this.p.o(this.c.M().b);
                }
            }
            if (this.r != null) {
                hd8 hd8Var3 = this.O0;
                if (hd8Var3 != null && hd8Var3.l() != null && (pbFragment = this.c) != null && pbFragment.M() != null) {
                    this.r.q(this.c.M().b);
                }
                hd8 hd8Var4 = this.O0;
                if (hd8Var4 != null && hd8Var4.Q() != null && !ListUtils.isEmpty(this.O0.Q().getThreadRecommendInfoDataList()) && this.O0.Q().getThreadRecommendInfoDataList().get(0) != null && this.O0.Q().getThreadRecommendInfoDataList().get(0).businessType != 1) {
                    this.r.p(this.O0.Q().getThreadRecommendInfoDataList().get(0));
                } else {
                    this.r.p(null);
                }
            }
            if (F3()) {
                this.A.e(this.O0.Q());
            } else {
                this.A.d(this.l);
            }
        }
    }

    @SuppressLint({"ResourceAsColor"})
    public final void Z3(hd8 hd8Var, boolean z2, int i2, int i3) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(1048681, this, new Object[]{hd8Var, Boolean.valueOf(z2), Integer.valueOf(i2), Integer.valueOf(i3)}) == null) && hd8Var != null && hd8Var.Q() != null) {
            if (this.c.v0()) {
                if (hd8Var.h() != null) {
                    this.j0 = hd8Var.h().d();
                    this.k0 = hd8Var.h().b();
                }
                if (this.j0 == null && this.c.M() != null && this.c.M().R0() != null) {
                    this.j0 = this.c.M().R0();
                }
            }
            PostData Z = hd8Var.Z();
            w3(Z, hd8Var);
            int i4 = 8;
            this.w.L(8);
            int i5 = 1;
            if (hd8Var.y0()) {
                this.o1 = true;
                this.h.C(true);
                this.h.a.hideBottomLine();
                if (this.t == null) {
                    this.t = new gi8(this.c);
                }
                this.t.v(hd8Var, Z, this.l, this.w, this.V0, this.h, this.j0, this.H1);
                this.t.s(this.d2);
                V2();
            } else {
                this.o1 = false;
                this.h.C(false);
                gi8 gi8Var = this.t;
                if (gi8Var != null) {
                    gi8Var.p(this.l);
                }
            }
            if (this.c.I5() != null) {
                this.c.I5().w(this.o1);
            }
            if (Z == null) {
                return;
            }
            this.P0 = Z;
            this.w.L(0);
            SparseArray<Object> w2 = this.w.w();
            w2.put(R.id.tag_clip_board, Z);
            w2.put(R.id.tag_is_subpb, Boolean.FALSE);
            this.x.e(hd8Var, this.l);
            this.z.e(hd8Var, this.J1, new j0(this));
            this.v.j(hd8Var);
            this.u.h(hd8Var, this.N0);
            this.u.g(hd8Var);
            this.w.M(this.R0, this.O0, Z, this.d2);
            if (this.a1 != null) {
                if (hd8Var.l0()) {
                    this.a1.getView().setVisibility(8);
                } else {
                    this.a1.getView().setVisibility(0);
                    ud8 ud8Var = new ud8(ud8.i);
                    if (hd8Var.Q() != null) {
                        hd8Var.Q().getReply_num();
                    }
                    ud8Var.c = hd8Var.g;
                    hd8Var.c();
                    ud8Var.d = this.c.f6();
                    ud8Var.g = hd8Var.f;
                    ud8Var.h = hd8Var.Q().isQuestionThread();
                    this.a1.h(ud8Var);
                }
            }
            l4(Z);
            m4(hd8Var);
            gh.a().post(new k0(this));
            this.y.f(this.l);
            if (Z.S) {
                this.y.g(Z.O());
                PbLandscapeListView pbLandscapeListView = this.l;
                this.y.c(this.l, (pbLandscapeListView == null || pbLandscapeListView.getHeaderViewsCount() <= 1) ? 0 : 0);
            }
            sf8 sf8Var = this.F;
            if (sf8Var != null && sf8Var.z() != null) {
                this.F.z().G(Z.S);
            }
            sf8 sf8Var2 = this.F;
            if (sf8Var2 != null) {
                sf8Var2.s0(Z.S);
            }
            MaskView maskView = this.O1;
            if (Z.S) {
                i4 = 0;
            }
            maskView.setVisibility(i4);
        }
    }

    public SparseArray<Object> a1(hd8 hd8Var, boolean z2, int i2) {
        InterceptResult invokeCommon;
        PostData Z;
        boolean z3;
        ez4 ez4Var;
        int i3;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048683, this, new Object[]{hd8Var, Boolean.valueOf(z2), Integer.valueOf(i2)})) == null) {
            StringBuilder sb = null;
            if (hd8Var == null || (Z = hd8Var.Z()) == null) {
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
                sparseArray.put(R.id.tag_manage_user_identity, Integer.valueOf(hd8Var.Y()));
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
                sparseArray.put(R.id.tag_manage_user_identity, Integer.valueOf(hd8Var.Y()));
                sparseArray.put(R.id.tag_should_manage_visible, Boolean.TRUE);
            }
            if (!z3) {
                List<z05> p3 = hd8Var.p();
                if (ListUtils.getCount(p3) > 0) {
                    sb = new StringBuilder();
                    for (z05 z05Var : p3) {
                        if (z05Var != null && !StringUtils.isNull(z05Var.d()) && (ez4Var = z05Var.f) != null && ez4Var.a && !ez4Var.c && ((i3 = ez4Var.b) == 1 || i3 == 2)) {
                            sb.append(dj.cutString(z05Var.d(), 12));
                            sb.append(this.c.getString(R.string.obfuscated_res_0x7f0f06ba));
                            sb.append("、");
                        }
                    }
                }
                if (sb != null && !StringUtils.isNull(sb.toString())) {
                    sparseArray.put(R.id.tag_del_multi_forum, String.format(this.c.getString(R.string.obfuscated_res_0x7f0f04d0), sb.toString().substring(0, sb.length() - 1)));
                }
            }
            return sparseArray;
        }
        return (SparseArray) invokeCommon.objValue;
    }

    public void a4(s15.c cVar, boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048686, this, cVar, z2) == null) {
            z15 z15Var = this.f0;
            if (z15Var != null) {
                z15Var.dismiss();
                this.f0 = null;
            }
            b25 b25Var = new b25(this.c.getContext());
            ArrayList arrayList = new ArrayList();
            hd8 hd8Var = this.O0;
            if (hd8Var != null && hd8Var.Q() != null && !this.O0.Q().isBjh()) {
                arrayList.add(new x15(0, this.c.getPageContext().getString(R.string.save_to_emotion), b25Var));
            }
            if (!z2) {
                arrayList.add(new x15(1, this.c.getPageContext().getString(R.string.save_to_local), b25Var));
            }
            b25Var.k(arrayList);
            b25Var.p(new h0(this, cVar));
            z15 z15Var2 = new z15(this.c.getPageContext(), b25Var);
            this.f0 = z15Var2;
            z15Var2.k();
        }
    }

    public void v2(AbsListView absListView, int i2) {
        RightFloatLayerView rightFloatLayerView;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048783, this, absListView, i2) == null) {
            gi8 gi8Var = this.t;
            if (gi8Var != null) {
                gi8Var.o(absListView, i2);
            }
            if (!this.l2 && i2 == 0) {
                this.j2 = o1();
                this.e1.c = null;
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004013, this.e1));
                H2(this.e1.c, true);
                u0();
                this.F.g0(true);
            }
            this.F.f0();
            if (i2 == 0) {
                RightFloatLayerView rightFloatLayerView2 = this.Q1;
                if (rightFloatLayerView2 != null) {
                    rightFloatLayerView2.p();
                }
                o0();
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
            RadioGroup.LayoutParams layoutParams = new RadioGroup.LayoutParams(-1, ej.g(pageActivity, R.dimen.obfuscated_res_0x7f07019a));
            customBlueCheckRadioButton.setOnCheckedChangeListener(this.a0);
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
        if ((interceptable != null && interceptable.invokeI(1048718, this, i2) != null) || this.R0 == i2) {
            return;
        }
        this.R0 = i2;
        n4(this.O0, this.N0);
        N2(this.O0, this.N0, this.Q0, i2);
        xw4 layoutMode = this.c.getBaseFragmentActivity().getLayoutMode();
        if (i2 == 4) {
            z2 = true;
        } else {
            z2 = false;
        }
        layoutMode.l(z2);
        this.c.getBaseFragmentActivity().getLayoutMode().k(this.d);
        SkinManager.setBackgroundColor(this.d, R.color.CAM_X0201);
        SkinManager.setBackgroundColor(this.p0, R.color.CAM_X0203);
        gi8 gi8Var = this.t;
        if (gi8Var != null) {
            gi8Var.h(i2);
        }
        ci8 ci8Var = this.x;
        if (ci8Var != null) {
            ci8Var.c(i2);
        }
        bi8 bi8Var = this.u;
        if (bi8Var != null) {
            bi8Var.e(i2);
        }
        di8 di8Var = this.v;
        if (di8Var != null) {
            di8Var.g(i2);
        }
        fi8 fi8Var = this.w;
        if (fi8Var != null) {
            fi8Var.C(i2);
        }
        ei8 ei8Var = this.y;
        if (ei8Var != null) {
            ei8Var.e();
        }
        ai8 ai8Var = this.z;
        if (ai8Var != null) {
            ai8Var.c();
        }
        MaskView maskView = this.O1;
        if (maskView != null) {
            maskView.f();
        }
        hh8 hh8Var = this.r;
        if (hh8Var != null) {
            hh8Var.n();
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
        q15 q15Var = this.G;
        if (q15Var != null) {
            q15Var.autoChangeSkinType(this.c.getPageContext());
        }
        s4(this.h0);
        this.F.Z();
        tl8 tl8Var = this.K;
        if (tl8Var != null) {
            tl8Var.H(i2);
        }
        EditorTools editorTools = this.n0;
        if (editorTools != null) {
            editorTools.y(i2);
        }
        ol8 ol8Var = this.M;
        if (ol8Var != null) {
            ol8Var.g(i2);
        }
        if (!ListUtils.isEmpty(this.n)) {
            for (CustomBlueCheckRadioButton customBlueCheckRadioButton : this.n) {
                customBlueCheckRadioButton.c();
            }
        }
        y4();
        UtilHelper.setStatusBarBackground(this.e, i2);
        UtilHelper.setStatusBarBackground(this.Z0, i2);
        if (this.B != null) {
            wm5.a(this.c.getPageContext(), this.B);
        }
        eg8 eg8Var = this.k1;
        if (eg8Var != null) {
            eg8Var.l(i2);
        }
        oj8 oj8Var = this.h;
        if (oj8Var != null) {
            gi8 gi8Var2 = this.t;
            if (gi8Var2 != null) {
                gi8Var2.i(i2);
            } else {
                oj8Var.w(i2);
            }
        }
        HeadImageView headImageView = this.w0;
        if (headImageView != null) {
            headImageView.setBorderColor(SkinManager.getColor(R.color.CAM_X0401));
        }
        LinearLayout linearLayout = this.v0;
        if (linearLayout != null) {
            linearLayout.setBackgroundDrawable(SkinManager.createShapeDrawableFromColor(ej.g(this.c.getContext(), R.dimen.tbds47), SkinManager.getColor(R.color.CAM_X0209)));
        }
        hd8 hd8Var = this.O0;
        if (hd8Var != null && hd8Var.r()) {
            WebPManager.setPureDrawable(this.C0, R.drawable.icon_pure_pb_bottom_collected26_selection, R.color.CAM_X0305, WebPManager.ResourceStateType.NORMAL_PRESS);
        } else {
            WebPManager.setPureDrawable(this.C0, R.drawable.icon_pure_pb_bottom_collect26, R.color.CAM_X0107, WebPManager.ResourceStateType.NORMAL_PRESS);
        }
        WebPManager.setPureDrawable(this.A0, R.drawable.icon_pure_pb_bottom_comment26, R.color.CAM_X0107, WebPManager.ResourceStateType.NORMAL_PRESS);
        WebPManager.setPureDrawable(this.x0, R.drawable.icon_pure_post_expression24, R.color.CAM_X0107, WebPManager.ResourceStateType.NORMAL);
        w4(this.O0);
        if (this.F0.getVisibility() == 0) {
            this.F0.setBackgroundDrawable(SkinManager.createShapeDrawable(ej.g(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds15), R.color.CAM_X0301, 0, 0, i2));
        }
        SkinManager.setBackgroundColor(this.u0, R.color.CAM_X0207);
        SkinManager.setBackgroundColor(this.t0, R.color.CAM_X0203);
        SkinManager.setViewTextColor(this.u1, (int) R.color.cp_cont_n);
        SkinManager.setViewTextColor(this.y0, (int) R.color.CAM_X0109);
        SkinManager.setViewTextColor(this.J0, (int) R.color.CAM_X0105);
        SkinManager.setViewTextColor(this.I0, (int) R.color.CAM_X0107);
        SkinManager.setBackgroundShapeDrawable(this.I0, ej.g(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds18), R.color.CAM_X0207, R.color.CAM_X0207);
        SkinManager.setViewTextColor(this.H0, (int) R.color.CAM_X0107);
        SkinManager.setBackgroundShapeDrawable(this.H0, ej.g(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds18), R.color.CAM_X0207, R.color.CAM_X0207);
        AgreeView agreeView = this.B0;
        if (agreeView != null) {
            agreeView.w();
            this.B0.P(i2);
            AgreeData data = this.B0.getData();
            if (data != null) {
                K2(data, data.agreeNum);
            }
        }
        hf8 hf8Var = this.x1;
        if (hf8Var != null) {
            hf8Var.m(i2);
        }
        PbEmotionBar pbEmotionBar = this.f1;
        if (pbEmotionBar != null) {
            pbEmotionBar.w();
        }
        PbThreadPostView pbThreadPostView = this.o;
        if (pbThreadPostView != null) {
            pbThreadPostView.c(i2);
        }
        sl8 sl8Var = this.G0;
        if (sl8Var != null) {
            sl8Var.j();
        }
        rl8 rl8Var = this.N1;
        if (rl8Var != null) {
            rl8Var.c();
        }
        RightFloatLayerView rightFloatLayerView = this.Q1;
        if (rightFloatLayerView != null) {
            rightFloatLayerView.n();
        }
        SkinManager.setBackgroundColor(this.Y0, R.color.CAM_X0207);
        SkinManager.setViewTextColor(this.Y0.findViewById(R.id.tv_title), (int) R.color.CAM_X0105);
    }

    public void u2(AbsListView absListView, int i2, int i3, int i4) {
        PbReplyTitleViewHolder pbReplyTitleViewHolder;
        int bottom;
        fi8 fi8Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLIII(1048778, this, absListView, i2, i3, i4) == null) {
            hg8 hg8Var = this.q;
            if (hg8Var != null) {
                hg8Var.c(i2, i3);
            }
            gh8 gh8Var = this.s;
            if (gh8Var != null) {
                gh8Var.c(i2, i3);
            }
            gi8 gi8Var = this.t;
            if (gi8Var != null) {
                gi8Var.n(absListView, i2, i3, i4);
            }
            oj8 oj8Var = this.h;
            if (oj8Var != null && (fi8Var = this.w) != null) {
                oj8Var.y(fi8Var.u());
            }
            G2();
            a1 a1Var = this.e1;
            a1Var.a = i2;
            PbLandscapeListView pbLandscapeListView = this.l;
            if (pbLandscapeListView != null) {
                a1Var.b = pbLandscapeListView.getHeaderViewsCount();
            }
            this.e1.c = null;
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004013, this.e1));
            M3(h0(absListView, i2));
            int i5 = 0;
            H2(this.e1.c, false);
            u0();
            if (this.L.p() && !this.L.C) {
                a1 a1Var2 = this.e1;
                if (a1Var2 != null && (pbReplyTitleViewHolder = a1Var2.c) != null && pbReplyTitleViewHolder.getView() != null) {
                    if (this.e1.c.getView().getTop() < 0) {
                        bottom = this.e1.c.getView().getHeight();
                    } else {
                        bottom = this.e1.c.getView().getBottom();
                    }
                    i5 = bottom;
                }
                this.L.f(i5);
                this.L.C = true;
            }
        }
    }

    public void w2(ArrayList<mz4> arrayList) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048788, this, arrayList) == null) {
            if (this.Y == null) {
                this.Y = LayoutInflater.from(this.c.getPageContext().getPageActivity()).inflate(R.layout.commit_good, (ViewGroup) null);
            }
            this.c.getBaseFragmentActivity().getLayoutMode().k(this.Y);
            if (this.X == null) {
                Dialog dialog = new Dialog(this.c.getPageContext().getPageActivity(), R.style.obfuscated_res_0x7f1003ac);
                this.X = dialog;
                dialog.setCanceledOnTouchOutside(true);
                this.X.setCancelable(true);
                this.m0 = (ScrollView) this.Y.findViewById(R.id.good_scroll);
                this.X.setContentView(this.Y);
                WindowManager.LayoutParams attributes = this.X.getWindow().getAttributes();
                attributes.width = ej.g(TbadkCoreApplication.getInst(), R.dimen.obfuscated_res_0x7f0702dc);
                this.X.getWindow().setAttributes(attributes);
                this.a0 = new d0(this);
                this.Z = (LinearLayout) this.Y.findViewById(R.id.good_class_group);
                TextView textView = (TextView) this.Y.findViewById(R.id.dialog_button_cancel);
                this.c0 = textView;
                textView.setOnClickListener(new e0(this));
                TextView textView2 = (TextView) this.Y.findViewById(R.id.dialog_button_ok);
                this.b0 = textView2;
                textView2.setOnClickListener(this.Q);
            }
            this.Z.removeAllViews();
            this.n = new ArrayList();
            CustomBlueCheckRadioButton r02 = r0("0", this.c.getPageContext().getString(R.string.thread_good_class));
            this.n.add(r02);
            r02.setChecked(true);
            this.Z.addView(r02);
            if (arrayList != null) {
                for (int i2 = 0; i2 < arrayList.size(); i2++) {
                    mz4 mz4Var = arrayList.get(i2);
                    if (mz4Var != null && !TextUtils.isEmpty(mz4Var.b()) && mz4Var.a() > 0) {
                        CustomBlueCheckRadioButton r03 = r0(String.valueOf(mz4Var.a()), mz4Var.b());
                        this.n.add(r03);
                        View view2 = new View(this.c.getPageContext().getPageActivity());
                        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, ej.g(TbadkCoreApplication.getInst(), R.dimen.obfuscated_res_0x7f070198));
                        SkinManager.setBackgroundColor(view2, R.color.CAM_X0204);
                        view2.setLayoutParams(layoutParams);
                        this.Z.addView(view2);
                        this.Z.addView(r03);
                    }
                }
                ViewGroup.LayoutParams layoutParams2 = this.m0.getLayoutParams();
                int size = arrayList.size();
                if (size != 0 && size != 1) {
                    if (size != 2) {
                        layoutParams2.height = ej.d(this.c.getPageContext().getPageActivity(), 220.0f);
                    } else {
                        layoutParams2.height = ej.d(this.c.getPageContext().getPageActivity(), 186.0f);
                    }
                } else {
                    layoutParams2.height = ej.d(this.c.getPageContext().getPageActivity(), 120.0f);
                }
                this.m0.setLayoutParams(layoutParams2);
                this.m0.removeAllViews();
                LinearLayout linearLayout = this.Z;
                if (linearLayout != null && linearLayout.getParent() == null) {
                    this.m0.addView(this.Z);
                }
            }
            ih.j(this.X, this.c.getPageContext());
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
            this.V = new q15(this.c.getActivity());
            if (StringUtils.isNull(str2)) {
                this.V.setMessageId(i4);
            } else {
                this.V.setOnlyMessageShowCenter(false);
                this.V.setMessage(str2);
            }
            this.V.setYesButtonTag(sparseArray);
            this.V.setPositiveButton(R.string.obfuscated_res_0x7f0f0520, this.c);
            this.V.setNegativeButton(R.string.obfuscated_res_0x7f0f0518, new w(this));
            this.V.setCancelable(true);
            this.V.create(this.c.getPageContext());
            if (z3) {
                P3(sparseArray, i5, i4);
            } else if (z2) {
                P3(sparseArray, i5, i4);
            } else if (G3()) {
                mx5 mx5Var = new mx5(this.c.M().s1().l().getDeletedReasonInfo().is_grays_cale_forum.intValue(), this.c.M().s1().l().getDeletedReasonInfo().is_boomgrow.intValue(), this.c.M().s1().o().has_forum_rule.intValue());
                mx5Var.i(this.c.M().s1().l().getId(), this.c.M().s1().l().getName());
                mx5Var.h(this.c.M().s1().l().getImage_url());
                mx5Var.j(this.c.M().s1().l().getUser_level());
                W3(sparseArray, i2, mx5Var, this.c.M().s1().X(), false);
            } else {
                e4(this.V, i2);
            }
        }
    }
}
