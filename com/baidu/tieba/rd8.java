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
import com.baidu.tieba.ge8;
import com.baidu.tieba.j05;
import com.baidu.tieba.l05;
import com.baidu.tieba.nd8;
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
import com.baidu.tieba.pb.view.FallingView;
import com.baidu.tieba.pb.view.PbInterviewStatusView;
import com.baidu.tieba.qc8;
import com.baidu.tieba.r09;
import com.baidu.tieba.sa8;
import com.baidu.tieba.tbadkCore.data.AgreeData;
import com.baidu.tieba.tbadkCore.data.PostData;
import com.baidu.tieba.tbadkCore.util.AntiHelper;
import com.baidu.tieba.tbadkCore.writeModel.PostWriteCallBackData;
import com.baidu.tieba.tv5;
import com.baidu.tieba.u05;
import com.baidu.tieba.view.NavigationBarCoverTip;
import com.baidu.tieba.view.WaterRippleView;
import com.baidu.tieba.wv5;
import com.baidu.tieba.x88;
import com.baidu.tieba.y35;
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
public class rd8 {
    public static /* synthetic */ Interceptable $ic;
    public static final int a2;
    public static final int b2;
    public static int c2;
    public static r09.f d2;
    public transient /* synthetic */ FieldHolder $fh;
    public LinearLayout A;
    public ImageView A0;
    public String A1;
    public TextView B;
    public ImageView B0;
    public PermissionJudgePolicy B1;
    public TextView C;
    public HeadImageView C0;
    public boolean C1;
    public ObservedChangeRelativeLayout D;
    public View D0;
    public int D1;
    public dc8 E;
    public ch8 E0;
    public int E1;
    public j05 F;
    public TextView F0;
    public boolean F1;
    public l05 G;
    public TextView G0;
    public boolean G1;
    public View H;
    public boolean H0;
    public bh8 H1;
    public EditText I;
    public int I0;
    public MaskView I1;
    public dh8 J;
    public s35 J0;
    public final FallingView J1;
    public PbListView K;
    public boolean K0;
    public RightFloatLayerView K1;
    public zg8 L;
    public u98 L0;
    public final FrameLayout L1;
    public View M;
    public PostData M0;
    public CustomMessageListener M1;
    public View N;
    public int N0;
    public View.OnClickListener N1;
    public View O;
    public int O0;
    public CustomMessageListener O1;
    public View.OnClickListener P;
    public boolean P0;
    public Handler P1;
    public TbRichTextView.a0 Q;
    public ViewStub Q0;
    public Runnable Q1;
    public NoNetworkView.b R;
    public PbInterviewStatusView R0;
    public CustomMessageListener R1;
    public s05 S;
    public FrameLayout S0;
    public PbFragment.h3 S1;
    public View.OnClickListener T;
    public TextView T0;
    public boolean T1;
    public j05 U;
    public View U0;
    public View.OnClickListener U1;
    public Dialog V;
    public View V0;
    public String V1;
    public Dialog W;
    public View W0;
    public y35.g W1;
    public View X;
    public PbReplyTitleViewHolder X0;
    public View.OnClickListener X1;
    public LinearLayout Y;
    public View Y0;
    public final List<TbImageView> Y1;
    public CompoundButton.OnCheckedChangeListener Z;
    public int Z0;
    public boolean Z1;
    public final ViewTreeObserver.OnGlobalLayoutListener a;
    public TextView a0;
    public boolean a1;
    public int b;
    public TextView b0;
    public z0 b1;
    public PbFragment c;
    public String c0;
    public int c1;
    public RelativeLayout d;
    public s05 d0;
    public int d1;
    public View e;
    public s05 e0;
    public Runnable e1;
    public int f;
    public n05 f0;
    public PbFakeFloorModel f1;
    public final Handler g;
    public boolean g0;
    public nc8 g1;
    public final qf8 h;
    public boolean h0;
    public boolean h1;
    public pf8 i;
    public String i0;
    public int i1;
    public ViewStub j;
    public String j0;
    public boolean j1;
    public ViewStub k;
    public ua8 k0;
    public boolean k1;
    public PbLandscapeListView l;
    public ScrollView l0;
    public boolean l1;
    public NoNetworkView m;
    public EditorTools m0;
    public int m1;
    public List<CustomBlueCheckRadioButton> n;
    public boolean n0;
    public PbTopTipView n1;
    public PbThreadPostView o;
    public View o0;
    public PopupWindow o1;
    public rc8 p;
    public View p0;
    public TextView p1;
    public qc8 q;
    public EjectionAnimationView q0;
    public List<String> q1;
    public od8 r;
    public Button r0;
    public pe8 r1;
    public nd8 s;
    public View s0;
    public tb8 s1;
    public he8 t;
    public View t0;
    public PbLandscapeListView.c t1;
    public je8 u;
    public LinearLayout u0;
    public boolean u1;
    public le8 v;
    public ImageView v0;
    public boolean v1;
    public ie8 w;
    public TextView w0;
    public cd8 w1;
    public ke8 x;
    public WaterRippleView x0;
    public NavigationBarCoverTip x1;
    public ge8 y;
    public ImageView y0;
    public tv5 y1;
    public PbContentCollectionController z;
    public AgreeView z0;
    public wv5 z1;

    public boolean N1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048629, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    public int j1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048722, this)) == null) ? R.id.obfuscated_res_0x7f091cfb : invokeV.intValue;
    }

    /* loaded from: classes6.dex */
    public class b implements AgreeView.i {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ rd8 a;

        /* loaded from: classes6.dex */
        public class a implements ib5 {
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

            @Override // com.baidu.tieba.ib5
            public void a(List<Bitmap> list) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, list) == null) {
                    this.a.a.q0.setVisibility(0);
                    this.a.a.q0.setBitmaps(list);
                    Rect rect = new Rect();
                    this.a.a.z0.getImgAgree().getGlobalVisibleRect(rect);
                    this.a.a.q0.setAnchorPosition((rect.right + rect.left) / 2, (rect.bottom + rect.top) / 2);
                    this.a.a.q0.k();
                }
            }
        }

        public b(rd8 rd8Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {rd8Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = rd8Var;
        }

        @Override // com.baidu.tbadk.core.view.AgreeView.i
        public void onLongPress() {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeV(1048576, this) != null) {
                return;
            }
            this.a.u3();
            kb5.g().c(new a(this));
        }

        @Override // com.baidu.tbadk.core.view.AgreeView.i
        public void onRelease() {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) != null) {
                return;
            }
            this.a.H2();
            this.a.q0.l();
        }
    }

    /* loaded from: classes6.dex */
    public class i implements qc8.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ rd8 a;

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

        public i(rd8 rd8Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {rd8Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = rd8Var;
        }

        @Override // com.baidu.tieba.qc8.a
        public void a() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && this.a.l != null) {
                this.a.l.post(new a(this));
            }
        }
    }

    /* loaded from: classes6.dex */
    public class j implements nd8.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ rd8 a;

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
                if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && this.a.a.r != null) {
                    this.a.a.r.r();
                }
            }
        }

        public j(rd8 rd8Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {rd8Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = rd8Var;
        }

        @Override // com.baidu.tieba.nd8.a
        public void a() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && !this.a.c.r6() && this.a.l != null) {
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
        public final /* synthetic */ rd8 g;

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

        public l(rd8 rd8Var, int i, PbReplyTitleViewHolder pbReplyTitleViewHolder, boolean z, int i2, int i3, int i4) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {rd8Var, Integer.valueOf(i), pbReplyTitleViewHolder, Boolean.valueOf(z), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i5 = newInitContext.flag;
                if ((i5 & 1) != 0) {
                    int i6 = i5 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.g = rd8Var;
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
                    gh.a().post(new a(this));
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
        public final /* synthetic */ rd8 a;

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

        public o0(rd8 rd8Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {rd8Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = rd8Var;
        }

        @Override // android.content.DialogInterface.OnCancelListener
        public void onCancel(DialogInterface dialogInterface) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, dialogInterface) == null) {
                if (this.a.e1 == null) {
                    this.a.e1 = new a(this);
                }
                gh.a().postDelayed(this.a.e1, 150L);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class a implements ra8 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ rd8 a;

        @Override // com.baidu.tieba.ra8
        public /* synthetic */ void onStart() {
            qa8.a(this);
        }

        public a(rd8 rd8Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {rd8Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = rd8Var;
        }

        @Override // com.baidu.tieba.ra8
        public void onStop() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                this.a.q0.setVisibility(8);
                FirstPraiseToast.getInstance().show();
            }
        }
    }

    /* loaded from: classes6.dex */
    public class a0 implements tv5.h {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ j05 a;
        public final /* synthetic */ rd8 b;

        public a0(rd8 rd8Var, j05 j05Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {rd8Var, j05Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = rd8Var;
            this.a = j05Var;
        }

        @Override // com.baidu.tieba.tv5.h
        public void a(JSONArray jSONArray) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, jSONArray) == null) {
                this.b.c.h5(this.a, jSONArray);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class b0 implements wv5.i {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ SparseArray a;
        public final /* synthetic */ rd8 b;

        public b0(rd8 rd8Var, SparseArray sparseArray) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {rd8Var, sparseArray};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = rd8Var;
            this.a = sparseArray;
        }

        @Override // com.baidu.tieba.wv5.i
        public void a(JSONArray jSONArray) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, jSONArray) == null) {
                this.b.c.g5(this.a, jSONArray);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class c implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ rd8 a;

        public c(rd8 rd8Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {rd8Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = rd8Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, view2) == null) && this.a.z0 != null && this.a.z0.getData() != null) {
                rd8 rd8Var = this.a;
                rd8Var.B2(rd8Var.z0.getData(), this.a.z0.getData().agreeNum);
                if (!this.a.z0.J()) {
                    rd8 rd8Var2 = this.a;
                    rd8Var2.u2(rd8Var2.z0);
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public class c0 implements CompoundButton.OnCheckedChangeListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ rd8 a;

        public c0(rd8 rd8Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {rd8Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = rd8Var;
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
        public final /* synthetic */ rd8 a;

        public d(rd8 rd8Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {rd8Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = rd8Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                if (this.a.D0.getVisibility() == 0) {
                    if (this.a.c != null && this.a.c.C1()) {
                        return;
                    }
                    p35.m().w("pb_share_red_dot_shown", true);
                    this.a.D0.setVisibility(8);
                }
                this.a.P.onClick(view2);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class d0 implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ rd8 a;

        public d0(rd8 rd8Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {rd8Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = rd8Var;
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
        public final /* synthetic */ rd8 a;

        public e(rd8 rd8Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {rd8Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = rd8Var;
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
                    this.a.c.X4(sparseArray);
                    return;
                }
                this.a.t2(view2);
            } else if (z2) {
                sparseArray.put(R.id.tag_from, 0);
                sparseArray.put(R.id.tag_check_mute_from, 1);
                this.a.c.X4(sparseArray);
            } else if (z3) {
                this.a.o2(((Integer) sparseArray.get(R.id.tag_del_post_type)).intValue(), (String) sparseArray.get(R.id.tag_del_post_id), ((Integer) sparseArray.get(R.id.tag_manage_user_identity)).intValue(), ((Boolean) sparseArray.get(R.id.tag_del_post_is_self)).booleanValue());
            }
        }
    }

    /* loaded from: classes6.dex */
    public class e0 implements u05.f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ l05.c a;
        public final /* synthetic */ rd8 b;

        public e0(rd8 rd8Var, l05.c cVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {rd8Var, cVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = rd8Var;
            this.a = cVar;
        }

        @Override // com.baidu.tieba.u05.f
        public void J0(u05 u05Var, int i, View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIL(1048576, this, u05Var, i, view2) == null) {
                this.b.e0.dismiss();
                this.a.a(null, i, view2);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class f implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ rd8 a;

        public f(rd8 rd8Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {rd8Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = rd8Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                this.a.K2();
            }
        }
    }

    /* loaded from: classes6.dex */
    public class f0 implements u05.f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ l05.c a;
        public final /* synthetic */ rd8 b;

        public f0(rd8 rd8Var, l05.c cVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {rd8Var, cVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = rd8Var;
            this.a = cVar;
        }

        @Override // com.baidu.tieba.u05.f
        public void J0(u05 u05Var, int i, View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIL(1048576, this, u05Var, i, view2) == null) {
                this.b.e0.dismiss();
                this.a.a(null, i, view2);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class g implements PbFakeFloorModel.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ rd8 a;

        public g(rd8 rd8Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {rd8Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = rd8Var;
        }

        @Override // com.baidu.tieba.pb.pb.main.view.PbFakeFloorModel.b
        public void a(PostData postData) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, postData) == null) {
                this.a.f1.X(postData);
                this.a.E.Z();
                this.a.g1.g();
                this.a.m0.s();
                this.a.z3(false);
            }
        }
    }

    /* loaded from: classes6.dex */
    public static class g0 implements r09.f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        @Override // com.baidu.tieba.r09.f
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
    public class h implements FallingView.s {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ rd8 a;

        public h(rd8 rd8Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {rd8Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = rd8Var;
        }

        @Override // com.baidu.tieba.pb.view.FallingView.s
        public void onAnimationEnd() {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeV(1048576, this) != null) {
                return;
            }
            this.a.T3();
        }

        @Override // com.baidu.tieba.pb.view.FallingView.s
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
        public final /* synthetic */ rd8 a;

        public h0(rd8 rd8Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {rd8Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = rd8Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            long j;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                if ((view2 instanceof HeadImageView) && this.a.L0 != null && this.a.L0.N() != null && this.a.L0.N().getAuthor() != null && this.a.L0.N().getAuthor().getAlaInfo() != null && this.a.L0.N().getAuthor().getAlaInfo().live_status == 1) {
                    StatisticItem statisticItem = new StatisticItem("c11851");
                    statisticItem.param("uid", TbadkCoreApplication.getCurrentAccount());
                    TiebaStatic.log(statisticItem);
                    StatisticItem statisticItem2 = new StatisticItem("c13715");
                    statisticItem2.param("fid", this.a.L0.l());
                    statisticItem2.param("fname", this.a.L0.m());
                    if (this.a.L0.N().getAuthor().getAlaInfo().user_info != null) {
                        j = this.a.L0.N().getAuthor().getAlaInfo().user_info.user_id;
                    } else {
                        j = 0;
                    }
                    statisticItem2.param("obj_param1", j);
                    statisticItem2.param("uid", TbadkCoreApplication.getCurrentAccount());
                    statisticItem2.param("tid", this.a.L0.P());
                    statisticItem2.param(TiebaStatic.Params.OBJ_PARAM2, 1);
                    statisticItem2.param(TiebaStatic.Params.OBJ_PARAM4, YYLiveUtil.calculateLiveType(this.a.L0.N().getAuthor().getAlaInfo()));
                    if (this.a.L0.N().getAuthor().getAlaInfo().mYyExtData != null) {
                        statisticItem2.param(TiebaStatic.Params.OBJ_PARAM3, TiebaStatic.YYValues.YY_LIVE);
                        TiebaStaticHelper.addYYParam(statisticItem2, this.a.L0.N().getAuthor().getAlaInfo().mYyExtData);
                    }
                    TiebaStatic.log(statisticItem2);
                    if (this.a.L0.N().getAuthor().getAlaInfo().isLegalYYLiveData()) {
                        YYLiveUtil.jumpYYLiveRoom(this.a.c.getPageContext(), this.a.L0.N().getAuthor().getAlaInfo(), YYLiveUtil.SOURCE_PB_LIVE_HEAD);
                        return;
                    }
                    return;
                }
                if (this.a.j1) {
                    TiebaStatic.log(new StatisticItem("c11923").param("obj_id", 2));
                }
                if (!this.a.j1 && this.a.L0 != null && this.a.L0.N() != null && this.a.L0.N().getAuthor() != null && this.a.L0.N().getAuthor().isBigV()) {
                    TiebaStatic.log(new StatisticItem("c12151").param("obj_locate", 1));
                }
                if (this.a.c.N() != null) {
                    this.a.c.N().d.b.onClick(view2);
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public class i0 implements ge8.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ rd8 a;

        public i0(rd8 rd8Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {rd8Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = rd8Var;
        }

        @Override // com.baidu.tieba.ge8.a
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
        public final /* synthetic */ rd8 a;

        public j0(rd8 rd8Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {rd8Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = rd8Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            rd8 rd8Var;
            qf8 qf8Var;
            LinearLayout linearLayout;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && this.a.E != null && (qf8Var = (rd8Var = this.a).h) != null && qf8Var.i != null && rd8Var.L0 != null && this.a.L0.N() != null && !this.a.L0.N().isVideoThreadType() && !this.a.S1() && this.a.L0.k() != null && !dj.isEmpty(this.a.L0.k().getName())) {
                if ((this.a.E.I() == null || !this.a.E.I().isShown()) && (linearLayout = this.a.h.i) != null) {
                    linearLayout.setVisibility(0);
                    this.a.h.g();
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public class k extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ rd8 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public k(rd8 rd8Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {rd8Var, Integer.valueOf(i)};
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
            this.a = rd8Var;
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
        public final /* synthetic */ rd8 b;

        public k0(rd8 rd8Var, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {rd8Var, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = rd8Var;
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
                this.b.c.showToast(R.string.obfuscated_res_0x7f0f0cfe);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class l0 implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ Parcelable a;
        public final /* synthetic */ ArrayList b;
        public final /* synthetic */ u98 c;
        public final /* synthetic */ rd8 d;

        public l0(rd8 rd8Var, Parcelable parcelable, ArrayList arrayList, u98 u98Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {rd8Var, parcelable, arrayList, u98Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.d = rd8Var;
            this.a = parcelable;
            this.b = arrayList;
            this.c = u98Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.d.l.onRestoreInstanceState(this.a);
                if (ListUtils.getCount(this.b) > 1 && this.c.y().b() > 0) {
                    this.d.K.g();
                    this.d.K.F(TbadkApplication.getInst().getString(R.string.obfuscated_res_0x7f0f0e9b));
                    this.d.K.A();
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public class m implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ rd8 a;

        public m(rd8 rd8Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {rd8Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = rd8Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                if (this.a.D0.getVisibility() == 0) {
                    p35.m().w("pb_share_red_dot_shown", true);
                    this.a.D0.setVisibility(8);
                }
                this.a.P.onClick(this.a.B0);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class m0 implements PbLandscapeListView.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ rd8 a;

        public m0(rd8 rd8Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {rd8Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = rd8Var;
        }

        @Override // com.baidu.tieba.pb.pb.main.PbLandscapeListView.c
        public void a(int i, float f) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Integer.valueOf(i), Float.valueOf(f)}) == null) && this.a.c != null && this.a.c.isAdded()) {
                if (i < 0 && f > this.a.m1) {
                    this.a.t0();
                    this.a.e2();
                }
                this.a.B0();
            }
        }
    }

    /* loaded from: classes6.dex */
    public class n implements x88.d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ rd8 a;

        public n(rd8 rd8Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {rd8Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = rd8Var;
        }

        @Override // com.baidu.tieba.x88.d
        public void onFinish() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.z0.W();
            }
        }
    }

    /* loaded from: classes6.dex */
    public class n0 implements j05.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ rd8 a;

        public n0(rd8 rd8Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {rd8Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = rd8Var;
        }

        @Override // com.baidu.tieba.j05.e
        public void onClick(j05 j05Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, j05Var) == null) {
                this.a.t0();
                j05Var.dismiss();
            }
        }
    }

    /* loaded from: classes6.dex */
    public class o extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ rd8 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public o(rd8 rd8Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {rd8Var, Integer.valueOf(i)};
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
            this.a = rd8Var;
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
    public class p implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ rd8 a;

        public p(rd8 rd8Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {rd8Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = rd8Var;
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
    public class p0 implements j05.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public p0(rd8 rd8Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {rd8Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // com.baidu.tieba.j05.e
        public void onClick(j05 j05Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, j05Var) == null) {
                j05Var.dismiss();
            }
        }
    }

    /* loaded from: classes6.dex */
    public class q extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ rd8 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public q(rd8 rd8Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {rd8Var, Integer.valueOf(i)};
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
            this.a = rd8Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(1048576, this, customResponsedMessage) != null) || customResponsedMessage == null) {
                return;
            }
            this.a.H0 = false;
        }
    }

    /* loaded from: classes6.dex */
    public class q0 implements j05.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public q0(rd8 rd8Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {rd8Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // com.baidu.tieba.j05.e
        public void onClick(j05 j05Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, j05Var) == null) {
                j05Var.dismiss();
            }
        }
    }

    /* loaded from: classes6.dex */
    public class r implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ rd8 a;

        public r(rd8 rd8Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {rd8Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = rd8Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                this.a.K2();
            }
        }
    }

    /* loaded from: classes6.dex */
    public class r0 implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ n65 a;
        public final /* synthetic */ rd8 b;

        public r0(rd8 rd8Var, n65 n65Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {rd8Var, n65Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = rd8Var;
            this.a = n65Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, view2) == null) && this.a != null && this.b.L0 != null && this.b.K1 != null) {
                this.b.K1.g(this.a);
                this.b.K1.setAutoCompleteShown(false);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class s implements mb5 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ rd8 a;

        public s(rd8 rd8Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {rd8Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = rd8Var;
        }

        @Override // com.baidu.tieba.mb5
        public void A(lb5 lb5Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, lb5Var) == null) {
                Object obj = lb5Var.c;
                if ((obj instanceof e75) && EmotionGroupType.isSendAsPic(((e75) obj).getType())) {
                    if (this.a.B1 == null) {
                        this.a.B1 = new PermissionJudgePolicy();
                    }
                    this.a.B1.clearRequestPermissionList();
                    this.a.B1.appendRequestPermission(this.a.c.getBaseFragmentActivity(), "android.permission.WRITE_EXTERNAL_STORAGE");
                    if (this.a.B1.startRequestPermission(this.a.c.getBaseFragmentActivity())) {
                        return;
                    }
                    e75 e75Var = (e75) lb5Var.c;
                    this.a.c.B5().f(e75Var);
                    if (e75Var.i()) {
                        this.a.c.B5().G(null, null);
                    } else {
                        this.a.c.B5().w(false, null);
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
        public final /* synthetic */ rd8 e;

        public s0(rd8 rd8Var, int i, int i2, int i3, View view2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {rd8Var, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), view2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i4 = newInitContext.flag;
                if ((i4 & 1) != 0) {
                    int i5 = i4 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.e = rd8Var;
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
                    this.e.o1.showAsDropDown(this.e.t0, this.d.getLeft(), -this.e.t0.getHeight());
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public class t implements TextWatcher {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ rd8 a;

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIII(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, charSequence, i, i2, i3) == null) {
            }
        }

        public t(rd8 rd8Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {rd8Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = rd8Var;
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
            if ((interceptable == null || interceptable.invokeLIII(Constants.METHOD_SEND_USER_MSG, this, charSequence, i, i2, i3) == null) && this.a.m0 != null && this.a.m0.getVisibility() == 0 && charSequence != null && charSequence.length() >= (i4 = i3 + i)) {
                String substring = charSequence.toString().substring(i, i4);
                if (TextUtils.isEmpty(substring)) {
                    return;
                }
                if (this.a.r1 == null) {
                    RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
                    layoutParams.addRule(11);
                    layoutParams.addRule(2, this.a.m0.getId());
                    rd8 rd8Var = this.a;
                    rd8Var.r1 = new pe8(rd8Var.c.getPageContext(), this.a.d, layoutParams);
                    if (!ListUtils.isEmpty(this.a.q1)) {
                        this.a.r1.q(this.a.q1);
                    }
                    this.a.r1.r(this.a.m0);
                }
                this.a.r1.p(substring);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class t0 implements FallingView.q {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ rd8 a;

        public t0(rd8 rd8Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {rd8Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = rd8Var;
        }

        @Override // com.baidu.tieba.pb.view.FallingView.q
        public void onClick() {
            String h1;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (this.a.c != null && this.a.c.M() != null && this.a.c.M().T1()) {
                    h1 = this.a.c.getString(R.string.pb_reply_hint_from_smart_frs);
                } else {
                    h1 = this.a.h1();
                }
                if (!StringUtils.isNull(h1) && this.a.L0 != null) {
                    h1 = TbSingleton.getInstance().getAdVertiComment(this.a.L0.o0(), this.a.L0.p0(), h1);
                }
                if (this.a.c != null && this.a.c.B5() != null) {
                    this.a.c.B5().c0(h1);
                }
                if (this.a.w0 != null) {
                    this.a.w0.setText(h1);
                }
                this.a.z3(false);
                this.a.T3();
            }
        }
    }

    /* loaded from: classes6.dex */
    public class u implements u05.f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ boolean a;
        public final /* synthetic */ rd8 b;

        public u(rd8 rd8Var, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {rd8Var, Boolean.valueOf(z)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = rd8Var;
            this.a = z;
        }

        @Override // com.baidu.tieba.u05.f
        public void J0(u05 u05Var, int i, View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIL(1048576, this, u05Var, i, view2) == null) {
                this.b.S.dismiss();
                SparseArray<Object> sparseArray = (SparseArray) view2.getTag();
                if (sparseArray == null) {
                    return;
                }
                switch (i) {
                    case 10:
                        this.b.o2(((Integer) sparseArray.get(R.id.tag_del_post_type)).intValue(), (String) sparseArray.get(R.id.tag_del_post_id), ((Integer) sparseArray.get(R.id.tag_manage_user_identity)).intValue(), ((Boolean) sparseArray.get(R.id.tag_del_post_is_self)).booleanValue());
                        return;
                    case 11:
                        if (this.b.S1 != null) {
                            this.b.S1.a(new Object[]{sparseArray.get(R.id.tag_manage_user_identity), sparseArray.get(R.id.tag_forbid_user_name), sparseArray.get(R.id.tag_forbid_user_post_id), sparseArray.get(R.id.tag_forbid_user_name_show), sparseArray.get(R.id.tag_forbid_user_portrait)});
                            return;
                        }
                        return;
                    case 12:
                        this.b.c.K5(this.a, (String) sparseArray.get(R.id.tag_user_mute_mute_userid), sparseArray);
                        return;
                    case 13:
                        this.b.l4(true);
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
        public final /* synthetic */ n65 a;
        public final /* synthetic */ rd8 b;

        public u0(rd8 rd8Var, n65 n65Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {rd8Var, n65Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = rd8Var;
            this.a = n65Var;
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

    /* loaded from: classes6.dex */
    public class v implements j05.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public v(rd8 rd8Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {rd8Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // com.baidu.tieba.j05.e
        public void onClick(j05 j05Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, j05Var) == null) {
                j05Var.dismiss();
            }
        }
    }

    /* loaded from: classes6.dex */
    public class v0 implements ViewTreeObserver.OnGlobalLayoutListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PbFragment a;
        public final /* synthetic */ rd8 b;

        public v0(rd8 rd8Var, PbFragment pbFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {rd8Var, pbFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = rd8Var;
            this.a = pbFragment;
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (!this.b.F1 && this.a != null && this.b.c.M() != null && this.b.c.M().W1()) {
                    this.b.F1 = true;
                    this.a.V4(false);
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

    /* loaded from: classes6.dex */
    public class w implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ AlertDialog a;
        public final /* synthetic */ SparseArray b;
        public final /* synthetic */ rd8 c;

        public w(rd8 rd8Var, AlertDialog alertDialog, SparseArray sparseArray) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {rd8Var, alertDialog, sparseArray};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = rd8Var;
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
                    ej.P(this.c.c.N(), R.string.obfuscated_res_0x7f0f0cfe);
                } else {
                    this.c.c.g5(this.b, null);
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public class w0 implements sa8.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ rd8 a;

        public w0(rd8 rd8Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {rd8Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = rd8Var;
        }

        @Override // com.baidu.tieba.sa8.b
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.c.N5();
            }
        }

        @Override // com.baidu.tieba.sa8.b
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

        public x(rd8 rd8Var, AlertDialog alertDialog) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {rd8Var, alertDialog};
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
        public final /* synthetic */ od5 b;
        public final /* synthetic */ rd8 c;

        public x0(rd8 rd8Var, ReplyPrivacyCheckController replyPrivacyCheckController, od5 od5Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {rd8Var, replyPrivacyCheckController, od5Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = rd8Var;
            this.a = replyPrivacyCheckController;
            this.b = od5Var;
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
                this.c.h4();
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
        public final /* synthetic */ rd8 c;

        public y(rd8 rd8Var, AlertDialog alertDialog, SparseArray sparseArray) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {rd8Var, alertDialog, sparseArray};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = rd8Var;
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
                    ej.P(this.c.c.N(), R.string.obfuscated_res_0x7f0f0cfe);
                } else {
                    this.c.c.g5(this.b, null);
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public class y0 implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ rd8 a;

        public y0(rd8 rd8Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {rd8Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = rd8Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                this.a.i2();
            }
        }
    }

    /* loaded from: classes6.dex */
    public class z implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ AlertDialog a;

        public z(rd8 rd8Var, AlertDialog alertDialog) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {rd8Var, alertDialog};
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
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948117891, "Lcom/baidu/tieba/rd8;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948117891, "Lcom/baidu/tieba/rd8;");
                return;
            }
        }
        a2 = UtilHelper.getLightStatusBarHeight();
        b2 = ej.g(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds80);
        c2 = 1;
        d2 = new g0();
    }

    public final void H2() {
        PbFragment pbFragment;
        WaterRippleView waterRippleView;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048606, this) != null) || (pbFragment = this.c) == null || pbFragment.getActivity() == null || (waterRippleView = this.x0) == null) {
            return;
        }
        ViewParent parent = waterRippleView.getParent();
        if (parent instanceof ViewGroup) {
            ((ViewGroup) parent).removeView(this.x0);
        }
        TextView textView = this.F0;
        if (textView != null) {
            textView.setVisibility(0);
        }
    }

    public void I2() {
        PbLandscapeListView pbLandscapeListView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048610, this) == null) && (pbLandscapeListView = this.l) != null) {
            this.y.d(pbLandscapeListView);
            this.u.h(this.l);
            this.v.C(this.l);
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
            u98 u98Var = this.L0;
            if (u98Var == null || u98Var.k() == null || "0".equals(this.L0.k().getId()) || "me0407".equals(this.L0.k().getName())) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public final void T3() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048655, this) == null) {
            FallingView fallingView = this.J1;
            if (fallingView != null) {
                fallingView.setTag(Boolean.TRUE);
            }
            RightFloatLayerView rightFloatLayerView = this.K1;
            if (rightFloatLayerView != null && rightFloatLayerView.getTag() == this.J1) {
                this.K1.setTag(null);
                this.K1.setAutoCompleteShown(true);
                this.K1.d();
            }
        }
    }

    public void g2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048708, this) == null) {
            d4();
            this.E.a0(1);
            rc8 rc8Var = this.p;
            if (rc8Var != null) {
                rc8Var.k();
            }
            od8 od8Var = this.r;
            if (od8Var != null) {
                od8Var.j();
            }
            RightFloatLayerView rightFloatLayerView = this.K1;
            if (rightFloatLayerView != null && (rightFloatLayerView instanceof RightFloatLayerLottieView)) {
                ((RightFloatLayerLottieView) rightFloatLayerView).G(600);
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016524));
        }
    }

    public String h1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048712, this)) == null) {
            if (!dj.isEmpty(this.A1)) {
                return this.A1;
            }
            if (this.c != null) {
                this.A1 = TbadkCoreApplication.getInst().getResources().getString(qd8.g());
            }
            return this.A1;
        }
        return (String) invokeV.objValue;
    }

    public final void h4() {
        PbFragment pbFragment;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048715, this) == null) && (pbFragment = this.c) != null && pbFragment.B5() != null) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921706, Boolean.valueOf(!this.c.B5().y())));
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

    public final void j0() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048721, this) == null) && this.L0 != null && UbsABTestHelper.isResizeInduceSharingABTest() && !lf8.h(this.L0.P())) {
            this.E0.f();
            lf8.b(this.L0.P());
        }
    }

    public final void k4() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048730, this) != null) || !this.c.v5()) {
            return;
        }
        if (this.c.A5() == -1) {
            SkinManager.setViewTextColor(this.B, R.color.CAM_X0110, 1);
        }
        if (this.c.z5() == -1) {
            SkinManager.setViewTextColor(this.C, R.color.CAM_X0110, 1);
        }
    }

    public final void o0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048746, this) == null) {
            tb8 tb8Var = new tb8(this.c, this, (ViewStub) this.d.findViewById(R.id.obfuscated_res_0x7f09164a));
            this.s1 = tb8Var;
            tb8Var.o(this.P);
            this.s1.p(this.T);
            this.s1.q(this.Q);
            this.s1.o(this.P);
            this.s1.s(this.k0);
        }
    }

    public void t0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048766, this) == null) {
            this.h.e();
            PbFragment pbFragment = this.c;
            if (pbFragment != null) {
                ej.z(pbFragment.getContext(), this.I);
            }
            s1();
            s05 s05Var = this.d0;
            if (s05Var != null) {
                s05Var.dismiss();
            }
            x0();
            j05 j05Var = this.F;
            if (j05Var != null) {
                j05Var.dismiss();
            }
            l05 l05Var = this.G;
            if (l05Var != null) {
                l05Var.e();
            }
        }
    }

    public final boolean t3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048769, this)) == null) {
            PbFragment pbFragment = this.c;
            if (pbFragment == null || pbFragment.M().k1().k().getDeletedReasonInfo() == null || 1 != this.c.M().k1().k().getDeletedReasonInfo().is_grays_cale_forum.intValue()) {
                return false;
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    public void v3() {
        View view2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048777, this) == null) {
            PbLandscapeListView pbLandscapeListView = this.l;
            int i2 = 0;
            if (pbLandscapeListView != null) {
                pbLandscapeListView.setVisibility(0);
            }
            FrameLayout frameLayout = this.S0;
            if (frameLayout != null) {
                frameLayout.setVisibility(0);
            }
            qf8 qf8Var = this.h;
            if (qf8Var != null && (view2 = qf8Var.d) != null) {
                if (!TbadkCoreApplication.isLogin()) {
                    i2 = 8;
                }
                view2.setVisibility(i2);
            }
        }
    }

    public void x0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048782, this) == null) {
            j05 j05Var = this.U;
            if (j05Var != null) {
                j05Var.dismiss();
            }
            Dialog dialog = this.V;
            if (dialog != null) {
                ih.b(dialog, this.c.getPageContext());
            }
            Dialog dialog2 = this.W;
            if (dialog2 != null) {
                ih.b(dialog2, this.c.getPageContext());
            }
            s05 s05Var = this.S;
            if (s05Var != null) {
                s05Var.dismiss();
            }
        }
    }

    public rd8(PbFragment pbFragment, View.OnClickListener onClickListener, ua8 ua8Var) {
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {pbFragment, onClickListener, ua8Var};
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
        this.w0 = null;
        this.H0 = true;
        this.J0 = null;
        this.K0 = false;
        this.O0 = 3;
        this.P0 = false;
        this.Q0 = null;
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
        this.k0 = ua8Var;
        this.m1 = ej.l(pbFragment.getContext()) / 8;
        RelativeLayout relativeLayout = (RelativeLayout) LayoutInflater.from(this.c.getPageContext().getPageActivity()).inflate(R.layout.obfuscated_res_0x7f0d066b, (ViewGroup) null);
        this.d = relativeLayout;
        relativeLayout.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        this.o0 = this.d.findViewById(R.id.obfuscated_res_0x7f0903ff);
        this.x1 = (NavigationBarCoverTip) this.d.findViewById(R.id.obfuscated_res_0x7f091945);
        this.e = this.d.findViewById(R.id.obfuscated_res_0x7f092085);
        this.L1 = (FrameLayout) this.d.findViewById(R.id.obfuscated_res_0x7f091d1d);
        this.D = (ObservedChangeRelativeLayout) this.d.findViewById(R.id.obfuscated_res_0x7f092345);
        this.m = (NoNetworkView) this.d.findViewById(R.id.view_no_network);
        PbLandscapeListView pbLandscapeListView = (PbLandscapeListView) this.d.findViewById(R.id.obfuscated_res_0x7f091782);
        this.l = pbLandscapeListView;
        pbLandscapeListView.setDividerHeight(0);
        this.S0 = (FrameLayout) this.d.findViewById(R.id.obfuscated_res_0x7f091d68);
        this.T0 = new TextView(this.c.getActivity());
        AbsListView.LayoutParams layoutParams = new AbsListView.LayoutParams(-1, UtilHelper.getLightStatusBarHeight() + ej.g(this.c.getActivity(), R.dimen.obfuscated_res_0x7f070307));
        this.l.setOverScrollMode(2);
        this.l.x(this.T0, 0);
        this.l.setTextViewAdded(true);
        this.d1 = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds134);
        this.Y0 = new View(this.c.getPageContext().getPageActivity());
        if (ku5.a()) {
            this.Y0.setLayoutParams(new AbsListView.LayoutParams(-1, 0));
        } else {
            this.Y0.setLayoutParams(new AbsListView.LayoutParams(-1, this.d1));
        }
        MessageManager.getInstance().registerListener(this.M1);
        this.Y0.setVisibility(4);
        this.l.addFooterView(this.Y0);
        this.l.setOnTouchListener(this.c.J2);
        this.a = new v0(this, pbFragment);
        this.l.getViewTreeObserver().addOnGlobalLayoutListener(this.a);
        this.h = new qf8(pbFragment, this.d);
        if (this.c.v5()) {
            ViewStub viewStub = (ViewStub) this.d.findViewById(R.id.obfuscated_res_0x7f09158e);
            this.j = viewStub;
            viewStub.setVisibility(0);
            pf8 pf8Var = new pf8(pbFragment);
            this.i = pf8Var;
            pf8Var.c();
            this.h.a.setVisibility(8);
            layoutParams.height = ej.g(this.c.getActivity(), R.dimen.obfuscated_res_0x7f07023d);
        }
        this.T0.setLayoutParams(layoutParams);
        this.h.i().setOnTouchListener(new sa8(new w0(this)));
        this.s0 = this.d.findViewById(R.id.obfuscated_res_0x7f0926a7);
        this.t0 = this.d.findViewById(R.id.obfuscated_res_0x7f0918e0);
        this.I0 = ej.g(TbadkCoreApplication.getInst(), R.dimen.obfuscated_res_0x7f070285);
        this.v0 = (ImageView) this.d.findViewById(R.id.obfuscated_res_0x7f0908d3);
        this.v0.setOnClickListener(new x0(this, new ReplyPrivacyCheckController(this.c.getPageContext()), this.c.B5()));
        z0();
        this.w0 = (TextView) this.d.findViewById(R.id.obfuscated_res_0x7f0918e3);
        LinearLayout linearLayout = (LinearLayout) this.d.findViewById(R.id.obfuscated_res_0x7f0918db);
        this.u0 = linearLayout;
        linearLayout.setOnClickListener(new y0(this));
        EjectionAnimationView ejectionAnimationView = (EjectionAnimationView) this.d.findViewById(R.id.obfuscated_res_0x7f0908d7);
        this.q0 = ejectionAnimationView;
        ejectionAnimationView.setEjectionAnimationViewCallback(new a(this));
        this.y0 = (ImageView) this.d.findViewById(R.id.obfuscated_res_0x7f0918e1);
        this.I1 = (MaskView) this.d.findViewById(R.id.mask_view);
        this.y0.setOnClickListener(this.P);
        AgreeView agreeView = (AgreeView) this.d.findViewById(R.id.obfuscated_res_0x7f0918dd);
        this.z0 = agreeView;
        agreeView.setAgreeAlone(true);
        this.z0.w();
        this.z0.setAgreeLongClickListener(new b(this));
        this.z0.setAfterClickListener(new c(this));
        this.z0.setUseDynamicLikeRes("/pb");
        if (this.z0.getAgreeNumView() != null) {
            this.z0.getAgreeNumView().setVisibility(8);
        }
        if (this.z0.getMsgData() != null) {
            this.z0.getMsgData().a = BdUniqueId.gen();
        }
        boolean booleanExtra = this.c.getBaseFragmentActivity().getIntent().getBooleanExtra("key_is_from_dynamic", false);
        ImageView imageView = (ImageView) this.d.findViewById(R.id.obfuscated_res_0x7f0918df);
        this.A0 = imageView;
        imageView.setOnClickListener(this.P);
        if (booleanExtra) {
            this.A0.setVisibility(8);
        } else {
            this.A0.setVisibility(0);
        }
        View findViewById = this.d.findViewById(R.id.obfuscated_res_0x7f0918e6);
        this.D0 = findViewById;
        if (!p35.m().i("pb_share_red_dot_shown", false) && TbadkCoreApplication.isLogin()) {
            i2 = 0;
        } else {
            i2 = 8;
        }
        findViewById.setVisibility(i2);
        this.B0 = (ImageView) this.d.findViewById(R.id.obfuscated_res_0x7f0918e4);
        HeadImageView headImageView = (HeadImageView) this.d.findViewById(R.id.obfuscated_res_0x7f0918e5);
        this.C0 = headImageView;
        headImageView.setIsRound(true);
        this.C0.setOnClickListener(this.N1);
        this.B0.setOnClickListener(new d(this));
        X1();
        ch8 ch8Var = new ch8(this.B0);
        this.E0 = ch8Var;
        ch8Var.n(this.C0);
        if (!UbsABTestHelper.isResizeInduceSharingABTest() && !UbsABTestHelper.isResizeInduceSharingABTestA()) {
            this.E0.f();
        }
        TextView textView = (TextView) this.d.findViewById(R.id.obfuscated_res_0x7f0918e2);
        this.G0 = textView;
        textView.setVisibility(0);
        this.F0 = (TextView) this.d.findViewById(R.id.obfuscated_res_0x7f0918de);
        this.Q0 = (ViewStub) this.d.findViewById(R.id.obfuscated_res_0x7f091057);
        this.z0.setVisibility(0);
        this.F0.setVisibility(0);
        this.t = new he8(this.c, ua8Var);
        this.v = new le8(this.c, ua8Var, this.P);
        dc8 dc8Var = new dc8(this.c, this.l);
        this.E = dc8Var;
        dc8Var.x0(this.P);
        this.E.z0(this.k0);
        this.E.u0(this.Q);
        this.E.w0(this.c.h2);
        this.E.r0(this.X1);
        e eVar = new e(this);
        this.T = eVar;
        this.E.s0(eVar);
        H1();
        B1();
        ke8 ke8Var = new ke8(this.c);
        this.x = ke8Var;
        ke8Var.f = 2;
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
        this.O = this.d.findViewById(R.id.obfuscated_res_0x7f0926da);
        this.c.registerListener(this.R1);
        this.f1 = new PbFakeFloorModel(this.c.getPageContext());
        PbModel M = this.c.M();
        this.f1.Z(M.P(), M.L(), M.M(), M.K(), M.Q());
        nc8 nc8Var = new nc8(this.c.getPageContext(), this.f1, this.d);
        this.g1 = nc8Var;
        nc8Var.p(new f(this));
        this.g1.s(this.c.m2);
        this.f1.b0(new g(this));
        if (this.c.M() != null && !StringUtils.isNull(this.c.M().n1())) {
            PbFragment pbFragment2 = this.c;
            pbFragment2.showToast(pbFragment2.M().n1());
        }
        this.U0 = this.d.findViewById(R.id.obfuscated_res_0x7f0918e8);
        this.V0 = this.d.findViewById(R.id.obfuscated_res_0x7f0903fd);
        View findViewById2 = this.d.findViewById(R.id.obfuscated_res_0x7f092091);
        this.W0 = findViewById2;
        LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) findViewById2.getLayoutParams();
        if (this.c.M() != null && this.c.M().W0()) {
            this.U0.setVisibility(0);
            if (layoutParams2 != null) {
                layoutParams2.height = 0;
                this.W0.setLayoutParams(layoutParams2);
            }
        } else if (layoutParams2 != null) {
            layoutParams2.height = a2;
            this.W0.setLayoutParams(layoutParams2);
        }
        PbReplyTitleViewHolder pbReplyTitleViewHolder = new PbReplyTitleViewHolder(this.c.getPageContext(), this.d.findViewById(R.id.obfuscated_res_0x7f09195e));
        this.X0 = pbReplyTitleViewHolder;
        pbReplyTitleViewHolder.q(pbFragment.c0);
        this.X0.f.setVisibility(8);
        this.X0.p(this.P);
        this.X0.o(this.c.h2);
        this.c.registerListener(this.O1);
        PbFragment pbFragment3 = this.c;
        this.H1 = new bh8(pbFragment3, pbFragment3.getUniqueId());
        this.J1 = (FallingView) this.d.findViewById(R.id.obfuscated_res_0x7f090a10);
        P2();
        this.J1.setAnimationListener(new h(this));
        o0();
        this.p0 = this.d.findViewById(R.id.obfuscated_res_0x7f0918d2);
        n0(ku5.a());
        if (UbsABTestHelper.isPbForumGuideTestA() && M.a2() && y88.b().e()) {
            if (this.p == null) {
                this.p = new rc8(this.c.getActivity(), (ViewGroup) o1().findViewById(R.id.obfuscated_res_0x7f09190d));
            }
            qc8 qc8Var = new qc8(this.l);
            this.q = qc8Var;
            qc8Var.d(new i(this));
        }
        this.r = new od8(this.c.N(), (ViewGroup) o1().findViewById(R.id.obfuscated_res_0x7f091971));
        nd8 nd8Var = new nd8(this.l);
        this.s = nd8Var;
        nd8Var.d(new j(this));
    }

    public void N2(String str) {
        PbListView pbListView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048630, this, str) == null) && (pbListView = this.K) != null) {
            pbListView.F(str);
        }
    }

    public void Q2(PbFragment.h3 h3Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048642, this, h3Var) == null) {
            this.S1 = h3Var;
        }
    }

    public void R2(boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048646, this, z2) == null) {
            this.n0 = z2;
        }
    }

    public void S2(boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048650, this, z2) == null) {
            this.E.i0(z2);
        }
    }

    public void T2(boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048654, this, z2) == null) {
            this.C1 = z2;
        }
    }

    public void U2(boolean z2) {
        dc8 dc8Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048658, this, z2) == null) && (dc8Var = this.E) != null) {
            dc8Var.j0(z2);
        }
    }

    public void V2(boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048662, this, z2) == null) {
            this.u1 = z2;
        }
    }

    public void W2(boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048666, this, z2) == null) {
            this.E.l0(z2);
        }
    }

    public void X2(boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048670, this, z2) == null) {
            this.E.q0(z2);
        }
    }

    public final void X3(PostData postData) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048671, this, postData) == null) && postData != null) {
            if (!StringUtils.isNull(postData.a0())) {
                this.v1 = true;
            } else {
                this.v1 = false;
            }
            le8 le8Var = this.v;
            if (le8Var != null) {
                le8Var.o(postData);
            }
        }
    }

    public void Y2(y35.g gVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048674, this, gVar) == null) {
            this.W1 = gVar;
            dh8 dh8Var = this.J;
            if (dh8Var != null) {
                dh8Var.f(gVar);
            }
        }
    }

    public void Z2(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048678, this, onClickListener) == null) {
            this.X1 = onClickListener;
            dc8 dc8Var = this.E;
            if (dc8Var != null) {
                dc8Var.r0(onClickListener);
            }
        }
    }

    public final int a1(boolean z2) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048681, this, z2)) == null) {
            PbInterviewStatusView pbInterviewStatusView = this.R0;
            if (pbInterviewStatusView == null || pbInterviewStatusView.getVisibility() != 0 || !z2) {
                return 0;
            }
            return 0 + ej.g(TbadkCoreApplication.getInst(), R.dimen.obfuscated_res_0x7f07026a);
        }
        return invokeZ.intValue;
    }

    public void a3(String str) {
        pf8 pf8Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048683, this, str) == null) && (pf8Var = this.i) != null) {
            pf8Var.b(str);
        }
    }

    public void a4(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048684, this, str) == null) {
            this.c.showToast(str);
        }
    }

    public void b3(boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048687, this, z2) == null) {
            this.h1 = z2;
            PbLandscapeListView pbLandscapeListView = this.l;
            if (pbLandscapeListView != null) {
                this.i1 = pbLandscapeListView.getHeaderViewsCount();
            }
        }
    }

    public void c3(TbRichTextView.a0 a0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048691, this, a0Var) == null) {
            this.Q = a0Var;
            this.E.u0(a0Var);
            this.s1.q(this.Q);
        }
    }

    public void d3(NoNetworkView.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048695, this, bVar) == null) {
            this.R = bVar;
            NoNetworkView noNetworkView = this.m;
            if (noNetworkView != null) {
                noNetworkView.a(bVar);
            }
        }
    }

    public void e3(BdListView.p pVar) {
        PbLandscapeListView pbLandscapeListView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048699, this, pVar) == null) && (pbLandscapeListView = this.l) != null) {
            pbLandscapeListView.setOnSrollToBottomListener(pVar);
        }
    }

    public void e4(boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048700, this, z2) == null) {
            this.g0 = z2;
        }
    }

    public void f3(AbsListView.OnScrollListener onScrollListener) {
        PbLandscapeListView pbLandscapeListView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048704, this, onScrollListener) == null) && (pbLandscapeListView = this.l) != null) {
            pbLandscapeListView.setOnScrollListener(onScrollListener);
        }
    }

    public void g3(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048709, this, onClickListener) == null) {
            this.E.y0(onClickListener);
        }
    }

    public void h2(go goVar) {
        PbLandscapeListView pbLandscapeListView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048713, this, goVar) == null) && (pbLandscapeListView = this.l) != null) {
            pbLandscapeListView.b0 = goVar;
            pbLandscapeListView.W = true;
        }
    }

    public void h3(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048714, this, i2) == null) {
            this.D1 = i2;
        }
    }

    public void i3(View.OnLongClickListener onLongClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048719, this, onLongClickListener) == null) {
            this.v.E(onLongClickListener);
            this.E.v0(onLongClickListener);
            tb8 tb8Var = this.s1;
            if (tb8Var != null) {
                tb8Var.r(onLongClickListener);
            }
        }
    }

    public void m4(u98 u98Var) {
        he8 he8Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048740, this, u98Var) == null) && (he8Var = this.t) != null) {
            he8Var.h(u98Var, this.K0);
        }
    }

    public void o3(boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048749, this, z2) == null) {
            this.v.G(z2);
        }
    }

    public void q3(int i2) {
        PbLandscapeListView pbLandscapeListView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(1048757, this, i2) == null) && (pbLandscapeListView = this.l) != null) {
            pbLandscapeListView.setSelection(i2);
        }
    }

    public void r3(List<String> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048761, this, list) == null) {
            this.q1 = list;
            pe8 pe8Var = this.r1;
            if (pe8Var != null) {
                pe8Var.q(list);
            }
        }
    }

    public void t2(View view2) {
        SparseArray<Object> sparseArray;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048768, this, view2) != null) || (sparseArray = (SparseArray) view2.getTag()) == null) {
            return;
        }
        s2(sparseArray, false);
    }

    public void y3(boolean z2) {
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048789, this, z2) == null) {
            View view2 = this.o0;
            if (z2) {
                i2 = 0;
            } else {
                i2 = 8;
            }
            view2.setVisibility(i2);
        }
    }

    public void z3(boolean z2) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeZ(1048793, this, z2) != null) || this.t0 == null) {
            return;
        }
        R2(this.c.B5().y());
        if (this.n0) {
            D3(z2);
        } else {
            r1(z2);
        }
    }

    public void D2(int i2, u98 u98Var) {
        PostData W;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeIL(1048590, this, i2, u98Var) == null) && i2 > 0 && u98Var != null && (W = u98Var.W()) != null && W.r() != null) {
            MetaData r2 = W.r();
            r2.setGiftNum(r2.getGiftNum() + i2);
        }
    }

    public void E2(u98 u98Var, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048594, this, u98Var, i2) == null) {
            L3(u98Var);
            this.v.z(i2);
        }
    }

    public void Y1(boolean z2, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048673, this, new Object[]{Boolean.valueOf(z2), Integer.valueOf(i2)}) == null) {
            qc8 qc8Var = this.q;
            if (qc8Var != null) {
                qc8Var.b();
            }
            nd8 nd8Var = this.s;
            if (nd8Var != null) {
                nd8Var.b(z2, i2);
            }
        }
    }

    @SuppressLint({"CutPasteId"})
    public void Z3(u98 u98Var, boolean z2) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLZ(1048679, this, u98Var, z2) != null) || u98Var == null) {
            return;
        }
        j4(u98Var, z2);
        w0();
    }

    public final void j3(PostData postData, u98 u98Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048724, this, postData, u98Var) == null) {
            this.v.F(postData, u98Var);
        }
    }

    public void w2(ea5 ea5Var, int i2) {
        FallingView fallingView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLI(1048780, this, ea5Var, i2) == null) && (fallingView = this.J1) != null) {
            fallingView.A(ea5Var, this.c.getPageContext(), i2, false);
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
            this.y = new ge8(pbFragment.getContext());
        }
    }

    public void B0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            PbLandscapeListView pbLandscapeListView = this.l;
            if (pbLandscapeListView != null) {
                pbLandscapeListView.A(0L);
            }
            w0();
        }
    }

    public final void B1() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048581, this) == null) && this.u == null) {
            this.u = new je8(this.c, this.k0);
        }
    }

    public void D0() {
        PbLandscapeListView pbLandscapeListView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048588, this) == null) && (pbLandscapeListView = this.l) != null) {
            pbLandscapeListView.setForbidDragListener(true);
        }
    }

    public final void F2() {
        PbInterviewStatusView pbInterviewStatusView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048598, this) == null) && (pbInterviewStatusView = this.R0) != null && pbInterviewStatusView.getVisibility() == 0) {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.R0.getLayoutParams();
            marginLayoutParams.setMargins(0, 0, 0, 0);
            this.R0.setLayoutParams(marginLayoutParams);
        }
    }

    public void F3() {
        qf8 qf8Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048599, this) == null) && (qf8Var = this.h) != null && !this.l1) {
            qf8Var.u();
            this.l1 = true;
        }
    }

    public dc8 G0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048600, this)) == null) {
            return this.E;
        }
        return (dc8) invokeV.objValue;
    }

    public void G2() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048602, this) == null) && this.f != 2) {
            PbLandscapeListView pbLandscapeListView = this.l;
            if (pbLandscapeListView != null) {
                pbLandscapeListView.setNextPage(this.K);
            }
            this.f = 2;
        }
    }

    public void G3() {
        PbLandscapeListView pbLandscapeListView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048603, this) == null) && (pbLandscapeListView = this.l) != null) {
            pbLandscapeListView.setVisibility(0);
        }
    }

    public LinearLayout H0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048604, this)) == null) {
            return this.u0;
        }
        return (LinearLayout) invokeV.objValue;
    }

    public final void H1() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048605, this) == null) && this.w == null) {
            this.w = new ie8(this.c, this.P);
        }
    }

    public void H3() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048607, this) == null) {
            if (this.J0 == null) {
                this.J0 = new s35(this.c.getPageContext());
            }
            this.J0.h(true);
        }
    }

    public View I0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048608, this)) == null) {
            View view2 = this.X;
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
            return this.c0;
        }
        return (String) invokeV.objValue;
    }

    public boolean J1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048613, this)) == null) {
            return this.H0;
        }
        return invokeV.booleanValue;
    }

    public void J3() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048615, this) == null) {
            this.E.h0(this.L0, false);
            this.E.Z();
        }
    }

    public void K2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048618, this) == null) {
            J2();
            s1();
            this.g1.g();
            z3(false);
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
            return pbLandscapeListView.J();
        }
        return invokeV.booleanValue;
    }

    public void L2() {
        Handler handler;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048622, this) != null) || (handler = this.P1) == null) {
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

    public FallingView M0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048624, this)) == null) {
            return this.J1;
        }
        return (FallingView) invokeV.objValue;
    }

    public boolean M1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048625, this)) == null) {
            EditorTools editorTools = this.m0;
            if (editorTools == null || editorTools.getVisibility() != 0) {
                return false;
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    public int N0() {
        InterceptResult invokeV;
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048628, this)) == null) {
            PbLandscapeListView pbLandscapeListView = this.l;
            if (pbLandscapeListView != null) {
                i2 = pbLandscapeListView.getFirstVisiblePosition();
            } else {
                i2 = 0;
            }
            return O0(i2);
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
            return this.r0;
        }
        return (Button) invokeV.objValue;
    }

    public final void P2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048638, this) == null) {
            this.J1.setFallingFeedbackListener(new t0(this));
        }
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

    public TextView R0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048644, this)) == null) {
            return this.v.q();
        }
        return (TextView) invokeV.objValue;
    }

    public void R3() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048647, this) == null) {
            this.O.setVisibility(0);
        }
    }

    public int S0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048648, this)) == null) {
            ch8 ch8Var = this.E0;
            if (ch8Var != null) {
                return ch8Var.g();
            }
            return 3;
        }
        return invokeV.intValue;
    }

    public void S3() {
        dc8 dc8Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048651, this) == null) && (dc8Var = this.E) != null) {
            dc8Var.A0();
        }
    }

    public PbInterviewStatusView T0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048652, this)) == null) {
            return this.R0;
        }
        return (PbInterviewStatusView) invokeV.objValue;
    }

    public boolean T1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048653, this)) == null) {
            ch8 ch8Var = this.E0;
            if (ch8Var == null) {
                return false;
            }
            return ch8Var.i();
        }
        return invokeV.booleanValue;
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
            EditorTools editorTools = this.m0;
            if (editorTools != null && editorTools.w()) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public void U3() {
        ch8 ch8Var;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048659, this) != null) || (ch8Var = this.E0) == null) {
            return;
        }
        ch8Var.o(2);
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
            C2(this.L0);
        }
    }

    public tb8 Y0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048672, this)) == null) {
            return this.s1;
        }
        return (tb8) invokeV.objValue;
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

    public void b4() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048688, this) == null) {
            this.c.showProgressBar();
        }
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
        FallingView fallingView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048692, this) == null) && (fallingView = this.J1) != null) {
            fallingView.C();
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
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048696, this) == null) && this.Y1 != null) {
            while (this.Y1.size() > 0) {
                TbImageView remove = this.Y1.remove(0);
                if (remove != null) {
                    remove.O();
                }
            }
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

    public PbFakeFloorModel f1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048702, this)) == null) {
            return this.f1;
        }
        return (PbFakeFloorModel) invokeV.objValue;
    }

    public void g0() {
        ch8 ch8Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048706, this) == null) && (ch8Var = this.E0) != null) {
            ch8Var.m(false);
        }
    }

    public nc8 g1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048707, this)) == null) {
            return this.g1;
        }
        return (nc8) invokeV.objValue;
    }

    public boolean h0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048711, this)) == null) {
            EditorTools editorTools = this.m0;
            if (editorTools != null && editorTools.w()) {
                this.m0.s();
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public void j2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048723, this) == null) {
            this.E.a0(2);
            k2();
            V1();
            n4();
            l0();
        }
    }

    public int k1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048727, this)) == null) {
            return this.O0;
        }
        return invokeV.intValue;
    }

    public final void k2() {
        PbFragment pbFragment;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048728, this) == null) && (pbFragment = this.c) != null && pbFragment.B5() != null) {
            this.c.B5().E();
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

    public PbThreadPostView m1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048737, this)) == null) {
            return this.o;
        }
        return (PbThreadPostView) invokeV.objValue;
    }

    public void m3() {
        PbFragment pbFragment;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048739, this) == null) && (pbFragment = this.c) != null && pbFragment.getBaseFragmentActivity() != null) {
            ej.z(this.c.getPageContext().getPageActivity(), this.c.getBaseFragmentActivity().getCurrentFocus());
        }
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
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048744, this) == null) {
            this.K.C();
            this.K.S();
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

    public void p1() {
        View view2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048751, this) == null) {
            PbLandscapeListView pbLandscapeListView = this.l;
            if (pbLandscapeListView != null) {
                pbLandscapeListView.setVisibility(8);
            }
            if (this.l != null) {
                this.S0.setVisibility(8);
            }
            qf8 qf8Var = this.h;
            if (qf8Var != null && (view2 = qf8Var.d) != null) {
                view2.setVisibility(8);
            }
        }
    }

    public void q1() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048755, this) != null) || this.t0 == null) {
            return;
        }
        this.s0.setVisibility(8);
        this.t0.setVisibility(8);
        this.H0 = false;
    }

    public void s1() {
        EditorTools editorTools;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048763, this) == null) && (editorTools = this.m0) != null) {
            editorTools.q();
            pe8 pe8Var = this.r1;
            if (pe8Var != null) {
                pe8Var.m();
            }
        }
    }

    public void t1() {
        qf8 qf8Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048767, this) == null) && (qf8Var = this.h) != null) {
            qf8Var.j();
        }
    }

    public void u0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048770, this) == null) {
            this.h.e();
            s05 s05Var = this.d0;
            if (s05Var != null) {
                s05Var.dismiss();
            }
            x0();
            j05 j05Var = this.F;
            if (j05Var != null) {
                j05Var.dismiss();
            }
            l05 l05Var = this.G;
            if (l05Var != null) {
                l05Var.e();
            }
        }
    }

    public void u1() {
        s35 s35Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048771, this) == null) && (s35Var = this.J0) != null) {
            s35Var.h(false);
        }
    }

    public void v0() {
        ch8 ch8Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048774, this) == null) && (ch8Var = this.E0) != null) {
            ch8Var.l(false);
        }
    }

    public void v1() {
        Runnable runnable;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048775, this) == null) {
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

    public boolean v2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048776, this)) == null) {
            od8 od8Var = this.r;
            if (od8Var != null && od8Var.l()) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public final boolean w0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048778, this)) == null) {
            return this.t.b(this.K0);
        }
        return invokeV.booleanValue;
    }

    public void w1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048779, this) == null) {
            this.O.setVisibility(8);
        }
    }

    public void x1() {
        RightFloatLayerView rightFloatLayerView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048783, this) == null) && (rightFloatLayerView = this.K1) != null) {
            rightFloatLayerView.c();
        }
    }

    public void y0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048786, this) == null) {
            StatisticItem statisticItem = new StatisticItem("c14693");
            statisticItem.param("uid", TbadkCoreApplication.getCurrentAccountId());
            statisticItem.param("obj_locate", c2);
            TiebaStatic.log(statisticItem);
        }
    }

    public void y1() {
        EditorTools editorTools;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048787, this) == null) && (editorTools = this.m0) != null) {
            editorTools.s();
        }
    }

    public void z0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048790, this) == null) {
            StatisticItem statisticItem = new StatisticItem("c14692");
            statisticItem.param("uid", TbadkCoreApplication.getCurrentAccountId());
            statisticItem.param("obj_locate", c2);
            TiebaStatic.log(statisticItem);
        }
    }

    public final void z1() {
        PbFragment pbFragment;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048791, this) == null) && this.z == null && (pbFragment = this.c) != null && pbFragment.getActivity() != null) {
            this.z = new PbContentCollectionController(this.c.getActivity());
        }
    }

    public final void z2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048792, this) == null) {
            this.v.B(this.L0, this.M0, this.k1, this.j1);
        }
    }

    public void A2() {
        PbLandscapeListView pbLandscapeListView;
        int i2;
        int i3;
        boolean z2;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) != null) || (pbLandscapeListView = this.l) == null) {
            return;
        }
        int headerViewsCount = pbLandscapeListView.getHeaderViewsCount() - this.i1;
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
        if ((z2 && pbReplyTitleViewHolder != null) || i2 >= this.E.G() + this.l.getHeaderViewsCount()) {
            if (pbReplyTitleViewHolder != null) {
                i4 = pbReplyTitleViewHolder.f.getMeasuredHeight();
            }
            if (z3) {
                this.l.setSelectionFromTop(this.E.G() + this.l.getHeaderViewsCount(), a2 - i4);
            } else {
                this.l.setSelectionFromTop(this.E.G() + this.l.getHeaderViewsCount(), this.h.i().getMeasuredHeight() - i4);
            }
        } else {
            this.l.setSelectionFromTop(i2, i3);
        }
        if (this.N0 != 6) {
            return;
        }
        this.l.setOnLayoutListener(new l(this, i1, pbReplyTitleViewHolder, z2, measuredHeight, i2, i3));
    }

    public void c2() {
        NoNetworkView.b bVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048690, this) == null) {
            rc8 rc8Var = this.p;
            if (rc8Var != null) {
                rc8Var.l();
            }
            od8 od8Var = this.r;
            if (od8Var != null) {
                od8Var.o();
            }
            RelativeLayout relativeLayout = this.d;
            if (relativeLayout != null && relativeLayout.getHandler() != null) {
                this.d.getHandler().removeCallbacksAndMessages(null);
            }
            ch8 ch8Var = this.E0;
            if (ch8Var != null) {
                ch8Var.k();
            }
            cd8 cd8Var = this.w1;
            if (cd8Var != null) {
                cd8Var.c();
            }
            PbTopTipView pbTopTipView = this.n1;
            if (pbTopTipView != null) {
                pbTopTipView.g();
            }
            this.c.hideProgressBar();
            NoNetworkView noNetworkView = this.m;
            if (noNetworkView != null && (bVar = this.R) != null) {
                noNetworkView.e(bVar);
            }
            r09.d();
            t0();
            A0();
            if (this.e1 != null) {
                gh.a().removeCallbacks(this.e1);
            }
            PbInterviewStatusView pbInterviewStatusView = this.R0;
            if (pbInterviewStatusView != null) {
                pbInterviewStatusView.m();
            }
            MessageManager.getInstance().unRegisterListener(this.M1);
            this.P1 = null;
            this.g.removeCallbacksAndMessages(null);
            this.E.a0(3);
            View view2 = this.e;
            if (view2 != null) {
                view2.setBackgroundDrawable(null);
            }
            dc8 dc8Var = this.E;
            if (dc8Var != null) {
                dc8Var.c0();
            }
            pe8 pe8Var = this.r1;
            if (pe8Var != null) {
                pe8Var.l();
            }
            le8 le8Var = this.v;
            if (le8Var != null) {
                le8Var.A();
            }
            PbReplyTitleViewHolder pbReplyTitleViewHolder = this.X0;
            if (pbReplyTitleViewHolder != null) {
                pbReplyTitleViewHolder.o(null);
            }
            this.t1 = null;
            PbLandscapeListView pbLandscapeListView = this.l;
            if (pbLandscapeListView != null) {
                pbLandscapeListView.setOnLayoutListener(null);
                this.l.getViewTreeObserver().removeGlobalOnLayoutListener(this.a);
                this.l.setListViewDragListener(null);
                this.l = null;
            }
            AgreeView agreeView = this.z0;
            if (agreeView != null) {
                agreeView.setAgreeLongClickListener(null);
            }
            z0 z0Var = this.b1;
            if (z0Var != null) {
                z0Var.a = null;
            }
        }
    }

    public void e2() {
        PostData postData;
        int i2;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048698, this) != null) || this.c == null) {
            return;
        }
        if (!this.C1 && this.D1 != 17) {
            if (this.k1 && !this.j1 && (postData = this.M0) != null && postData.r() != null) {
                int i3 = 2;
                if (this.c.v0()) {
                    i2 = 2;
                } else {
                    i2 = 1;
                }
                if (!this.j1) {
                    i3 = 1;
                }
                lg8.q("c12601", i3, i2);
                MessageManager.getInstance().sendMessage(new CustomMessage(2002003, new PersonInfoActivityConfig(this.c.getPageContext().getPageActivity(), this.M0.r().getUserId(), this.M0.r().getUserName(), this.c.M().J0(), AddFriendActivityConfig.TYPE_PB_HEAD)));
                return;
            }
            return;
        }
        u98 u98Var = this.L0;
        if (u98Var != null && u98Var.k() != null && !dj.isEmpty(this.L0.k().getName())) {
            MessageManager.getInstance().sendMessage(new CustomMessage(2003000, new FrsActivityConfig(this.c.getContext()).createNormalCfg(this.L0.k().getName(), null)));
            TiebaStatic.log(new StatisticItem("c13853").param("post_id", this.L0.P()).param("uid", TbadkCoreApplication.getCurrentAccountId()).param("fid", this.L0.k().getId()));
        }
    }

    public void i2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048718, this) == null) {
            TiebaStatic.log(new StatisticItem(CommonStatisticKey.KEY_RD_USE).param("obj_param1", 3).param("obj_locate", 1).param("obj_type", 1).param("obj_source", UtilHelper.getCurrentPageName(TbadkCoreApplication.getInst().getCurrentActivity())));
            if (!DialogLoginHelper.checkUpIsLogin(new LoginDialogData(this.c.getActivity(), LoginDialogData.PB_BOTTOM_REPLY_RESULT_PAGE))) {
                TiebaStatic.log(new StatisticItem(CommonStatisticKey.KEY_RD_USE).param("obj_param1", 3).param("obj_locate", 2).param("obj_type", 1).param("obj_source", UtilHelper.getCurrentPageName(TbadkCoreApplication.getInst().getCurrentActivity())));
                return;
            }
            h4();
            this.c.p6();
            PbFragment pbFragment = this.c;
            if (pbFragment != null && pbFragment.M() != null && this.c.M().k1() != null && this.c.M().k1().N() != null && this.c.M().k1().N().getAuthor() != null) {
                TiebaStatic.log(new StatisticItem("c13701").param("tid", this.c.M().E1()).param("fid", this.c.M().k1().l()).param("uid", TbadkCoreApplication.getCurrentAccountId()));
                TiebaStatic.log(new StatisticItem("c13402").param("tid", this.c.M().b).param("fid", this.c.M().k1().l()).param("obj_locate", 1).param("uid", TbadkCoreApplication.getCurrentAccount()));
            }
        }
    }

    public void k0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048726, this) == null) {
            if (!this.c.checkUpIsLogin()) {
                TiebaStatic.log(new StatisticItem(CommonStatisticKey.KEY_RD_USE).param("obj_param1", 3).param("obj_locate", 2).param("obj_type", 1).param("obj_source", UtilHelper.getCurrentPageName(TbadkCoreApplication.getInst().getCurrentActivity())));
                lg8.r("c10517", this.j0, 2);
            } else if (!this.c.Y4()) {
                TiebaStatic.log(new StatisticItem(CommonStatisticKey.KEY_RD_USE).param("obj_param1", 3).param("obj_locate", 8).param("obj_type", 1).param("obj_source", UtilHelper.getCurrentPageName(TbadkCoreApplication.getInst().getCurrentActivity())));
            } else {
                od5 B5 = this.c.B5();
                if (B5 != null && (B5.x() || B5.z())) {
                    TiebaStatic.log(new StatisticItem(CommonStatisticKey.KEY_RD_USE).param("obj_param1", 3).param("obj_locate", 10).param("obj_type", 1).param("obj_source", UtilHelper.getCurrentPageName(TbadkCoreApplication.getInst().getCurrentActivity())));
                    this.c.B5().w(false, null);
                    return;
                }
                if (this.m0 != null) {
                    E1();
                }
                EditorTools editorTools = this.m0;
                if (editorTools != null) {
                    this.H0 = false;
                    if (editorTools.p(2) != null) {
                        r09.c(this.c.getPageContext(), (View) this.m0.p(2).m, false, d2);
                    }
                }
                q1();
            }
        }
    }

    public final void n4() {
        PbFragment pbFragment;
        int i2;
        String str;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048745, this) == null) && (pbFragment = this.c) != null && pbFragment.M() != null && this.c.M().G != null && this.c.M().G.N() != null && this.c.M().G.N().isXiuXiuThread()) {
            ThreadData N = this.c.M().G.N();
            int i3 = 0;
            if (this.c.M().P0()) {
                i2 = 1;
            } else if (this.c.M().S0()) {
                i2 = 2;
            } else {
                i2 = 0;
            }
            ItemInfo itemInfo = TbSingleton.getInstance().getFrsItemInfoCache().get(N.getForum_name());
            if (itemInfo != null) {
                i3 = itemInfo.id.intValue();
                str = itemInfo.name;
            } else {
                str = "";
            }
            new StatisticItem("c15062").addParam("obj_locate", i2).addParam("fid", N.getFid()).addParam("fname", N.getForum_name()).addParam("post_id", N.getTid()).addParam("obj_id", i3).addParam("obj_name", str).eventStat();
        }
    }

    public void A3(u98 u98Var) {
        PostData postData;
        qf8 qf8Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048579, this, u98Var) == null) && u98Var != null && (postData = this.M0) != null && postData.r() != null && (qf8Var = this.h) != null) {
            boolean z2 = !this.j1;
            this.k1 = z2;
            qf8Var.y(z2);
            if (this.c.C5() != null) {
                this.c.C5().s(this.k1);
            }
            z2();
            PbFragment pbFragment = this.c;
            if (pbFragment != null && !pbFragment.v0() && !ListUtils.isEmpty(u98Var.o())) {
                sz4 sz4Var = u98Var.o().get(0);
                if (sz4Var != null) {
                    this.h.B(sz4Var.d(), sz4Var.a());
                }
            } else if (u98Var.k() != null) {
                this.h.B(u98Var.k().getName(), u98Var.k().getImage_url());
            }
            if (this.k1) {
                this.v.M(u98Var, this.M0, this.h0);
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
            this.v.M(u98Var, this.M0, this.h0);
            this.t1 = null;
            PbLandscapeListView pbLandscapeListView2 = this.l;
            if (pbLandscapeListView2 != null) {
                pbLandscapeListView2.setListViewDragListener(null);
            }
        }
    }

    public final void C2(u98 u98Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048586, this, u98Var) == null) && u98Var != null && u98Var.N() != null) {
            i4(u98Var);
            ImageView imageView = this.A0;
            if (imageView != null && imageView.getContext() != null) {
                if (u98Var.q()) {
                    WebPManager.setPureDrawable(this.A0, R.drawable.icon_pure_pb_bottom_collected26_selection, R.color.CAM_X0305, WebPManager.ResourceStateType.NORMAL_PRESS);
                } else {
                    WebPManager.setPureDrawable(this.A0, R.drawable.icon_pure_pb_bottom_collect26, R.color.CAM_X0107, WebPManager.ResourceStateType.NORMAL_PRESS);
                }
            }
            String F0 = F0(u98Var.N().getReply_num());
            TextView textView = this.G0;
            if (textView != null) {
                textView.setText(F0);
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921416, u98Var.N()));
            B2(u98Var.N().getAgreeData(), u98Var.N().getAgreeNum());
            if (this.z0 != null && u98Var.N() != null) {
                this.z0.setThreadData(u98Var.N());
                int i2 = 1;
                if (u98Var.N().getAgreeData() != null) {
                    u98Var.N().getAgreeData().isInThread = true;
                }
                this.z0.setData(u98Var.N().getAgreeData());
                yw4 yw4Var = new yw4();
                yw4Var.b = 26;
                if (u98Var.N().isVideoThreadType() && u98Var.N().getThreadVideoInfo() != null) {
                    i2 = 2;
                }
                yw4Var.c = i2;
                PbFragment pbFragment = this.c;
                if (pbFragment != null && pbFragment.M() != null) {
                    yw4Var.j = this.c.M().getFromForumId();
                    yw4Var.f = this.c.M().j1();
                }
                this.z0.setStatisticData(yw4Var);
            }
        }
    }

    public void E3(View view2) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048595, this, view2) != null) || p35.m().i("show_long_press_collection_tips", false)) {
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
        this.p1 = textView;
        textView.setText(R.string.obfuscated_res_0x7f0f0464);
        this.p1.setGravity(17);
        this.p1.setPadding(ej.g(this.c.getContext(), R.dimen.obfuscated_res_0x7f0701e8), 0, ej.g(this.c.getContext(), R.dimen.obfuscated_res_0x7f0701e8), 0);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        layoutParams.gravity = 17;
        layoutParams.height = ej.g(this.c.getContext(), R.dimen.obfuscated_res_0x7f070253);
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
            pbLandscapeListView.postDelayed(new s0(this, i4, i2, i3, view2), 100L);
        }
        p35.m().w("show_long_press_collection_tips", true);
    }

    public void I1(u98 u98Var) {
        PbReplyTitleViewHolder pbReplyTitleViewHolder;
        int bottom;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048609, this, u98Var) == null) {
            int i2 = 0;
            this.E.h0(u98Var, false);
            this.E.Z();
            w0();
            tb8 tb8Var = this.s1;
            if (tb8Var != null) {
                tb8Var.n();
            }
            ArrayList<PostData> G = u98Var.G();
            if (u98Var.y().b() == 0 || G == null || G.size() < u98Var.y().e()) {
                if (ListUtils.getCount(G) != 0 && (ListUtils.getCount(G) != 1 || G.get(0) == null || G.get(0).F() != 1)) {
                    if (u98Var.y().b() == 0) {
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
                        i2 = bottom;
                    }
                    if (this.c.V5()) {
                        this.K.I(TbadkCoreApplication.getInst().getResources().getString(R.string.obfuscated_res_0x7f0f0ea1), i2);
                    } else {
                        this.K.I(TbadkCoreApplication.getInst().getResources().getString(R.string.obfuscated_res_0x7f0f0ea2), i2);
                    }
                }
            }
            C2(u98Var);
        }
    }

    public void O3(AdapterView.OnItemClickListener onItemClickListener) {
        boolean z2;
        boolean z3;
        boolean z4;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048635, this, onItemClickListener) == null) {
            n05 n05Var = this.f0;
            if (n05Var != null) {
                n05Var.d();
                this.f0 = null;
            }
            if (this.L0 == null) {
                return;
            }
            ArrayList<w05> arrayList = new ArrayList<>();
            String string = this.c.getContext().getString(R.string.all_person);
            boolean z5 = false;
            if (this.L0.K() == 1) {
                z2 = true;
            } else {
                z2 = false;
            }
            arrayList.add(new w05(string, "", z2, Integer.toString(1)));
            String string2 = this.c.getContext().getString(R.string.my_fans);
            if (this.L0.K() == 2) {
                z3 = true;
            } else {
                z3 = false;
            }
            arrayList.add(new w05(string2, "", z3, Integer.toString(5)));
            String string3 = this.c.getContext().getString(R.string.my_attentions);
            if (this.L0.K() == 3) {
                z4 = true;
            } else {
                z4 = false;
            }
            arrayList.add(new w05(string3, "", z4, Integer.toString(6)));
            String string4 = this.c.getContext().getString(R.string.myself_only);
            if (this.L0.K() == 4) {
                z5 = true;
            }
            arrayList.add(new w05(string4, "", z5, Integer.toString(7)));
            n05 n05Var2 = new n05(this.c.getPageContext());
            n05Var2.l(R.string.pb_privacy_setting_thread_reply_decs);
            this.f0 = n05Var2;
            n05Var2.k(arrayList, onItemClickListener);
            n05Var2.c();
            this.f0.n();
        }
    }

    public final void B2(AgreeData agreeData, long j2) {
        TextView textView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLJ(1048582, this, agreeData, j2) == null) && agreeData != null && (textView = this.F0) != null) {
            if (j2 > 0) {
                if (agreeData.agreeType == 2 && agreeData.hasAgree) {
                    textView.setTextColor(SkinManager.getColor(R.color.CAM_X0301));
                } else {
                    this.F0.setTextColor(SkinManager.getColor(R.color.CAM_X0107));
                }
                this.F0.setText(E0(j2));
                this.F0.setVisibility(0);
                return;
            }
            textView.setVisibility(8);
        }
    }

    public final void B3(SparseArray<Object> sparseArray, @StringRes int i2, @StringRes int i3) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLII(1048583, this, sparseArray, i2, i3) != null) || this.c == null) {
            return;
        }
        TBAlertConfig.a aVar = new TBAlertConfig.a((int) R.string.obfuscated_res_0x7f0f04d5, TBAlertConfig.OperateBtnStyle.MAIN);
        TBAlertConfig.a aVar2 = new TBAlertConfig.a((int) R.string.obfuscated_res_0x7f0f038b, TBAlertConfig.OperateBtnStyle.SECONDARY);
        TBAlertBuilder tBAlertBuilder = new TBAlertBuilder(this.c.N());
        tBAlertBuilder.w(i2);
        tBAlertBuilder.m(i3);
        tBAlertBuilder.o(true);
        tBAlertBuilder.u(aVar2, aVar);
        tBAlertBuilder.j(false);
        AlertDialog z2 = tBAlertBuilder.z();
        aVar.a(new w(this, z2, sparseArray));
        aVar2.a(new x(this, z2));
    }

    public void C0(boolean z2, String str, boolean z3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(InputDeviceCompat.SOURCE_TOUCHPAD, this, new Object[]{Boolean.valueOf(z2), str, Boolean.valueOf(z3)}) == null) {
            this.c.hideProgressBar();
            if (z2 && z3) {
                PbFragment pbFragment = this.c;
                pbFragment.showToast(pbFragment.getPageContext().getString(R.string.obfuscated_res_0x7f0f12e7));
            } else if (z3) {
                if (dj.isEmpty(str)) {
                    str = TbadkCoreApplication.getInst().getResources().getString(R.string.obfuscated_res_0x7f0f0cfe);
                }
                this.c.showToast(str);
            }
        }
    }

    public final void C1(u98 u98Var) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048585, this, u98Var) != null) || u98Var == null || u98Var.N() == null || !u98Var.N().isInterviewLive() || this.R0 != null) {
            return;
        }
        PbInterviewStatusView pbInterviewStatusView = (PbInterviewStatusView) this.Q0.inflate();
        this.R0 = pbInterviewStatusView;
        pbInterviewStatusView.setOnClickListener(this.P);
        this.R0.setCallback(this.c.u5());
        this.R0.setData(this.c, u98Var);
    }

    public final int O0(int i2) {
        InterceptResult invokeI;
        int i3;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048632, this, i2)) == null) {
            PbLandscapeListView pbLandscapeListView = this.l;
            if (pbLandscapeListView == null) {
                return 0;
            }
            un adapter2 = pbLandscapeListView.getAdapter2();
            if (adapter2 == null) {
                return i2;
            }
            int o2 = (adapter2.o() + adapter2.m()) - 1;
            if (i2 > o2) {
                i2 = o2;
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

    public void O2(String str) {
        PbReplyTitleViewHolder pbReplyTitleViewHolder;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048634, this, str) == null) && this.K != null) {
            int i2 = 0;
            z0 z0Var = this.b1;
            if (z0Var != null && (pbReplyTitleViewHolder = z0Var.a) != null && pbReplyTitleViewHolder.getView() != null) {
                i2 = this.b1.a.getView().getTop() < 0 ? this.b1.a.getView().getHeight() : this.b1.a.getView().getBottom();
            }
            this.K.I(str, i2);
        }
    }

    public final void Y3(u98 u98Var) {
        boolean z2;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048675, this, u98Var) == null) && !this.v1 && u98Var != null && u98Var.N() != null && !u98Var.N().isVideoThreadType()) {
            boolean z3 = false;
            if (u98Var.N().getIs_good() == 1) {
                z2 = true;
            } else {
                z2 = false;
            }
            if (u98Var.N().getIs_top() == 1) {
                z3 = true;
            }
            le8 le8Var = this.v;
            if (le8Var != null) {
                le8Var.p(u98Var, z2, z3);
            }
            je8 je8Var = this.u;
            if (je8Var != null) {
                je8Var.b(u98Var, z2, z3);
            }
        }
    }

    public void m2(int i2) {
        RightFloatLayerView rightFloatLayerView;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048738, this, i2) == null) {
            if (i2 == 0) {
                this.b1.a = null;
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004013, this.b1));
                y2(this.b1.a, true);
                s0();
                this.E.g0(true);
            }
            this.E.f0();
            if (i2 == 0) {
                RightFloatLayerView rightFloatLayerView2 = this.K1;
                if (rightFloatLayerView2 != null) {
                    rightFloatLayerView2.p();
                }
                m0();
            } else if (i2 == 1) {
                RightFloatLayerView rightFloatLayerView3 = this.K1;
                if (rightFloatLayerView3 != null) {
                    rightFloatLayerView3.o();
                }
            } else if (i2 == 2 && (rightFloatLayerView = this.K1) != null) {
                rightFloatLayerView.q();
            }
        }
    }

    public void n0(boolean z2) {
        int i2;
        int i3;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048741, this, z2) == null) {
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

    public void p3(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048753, this, str) == null) {
            this.w0.performClick();
            if (!StringUtils.isNull(str) && this.c.B5() != null && this.c.B5().s() != null && this.c.B5().s().i() != null) {
                EditText i2 = this.c.B5().s().i();
                i2.setText(str);
                i2.setSelection(str.length());
            }
        }
    }

    public final boolean C3(u98 u98Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048587, this, u98Var)) == null) {
            if (u98Var == null || u98Var.N() == null) {
                return false;
            }
            if (u98Var.N().getIsLive() != 1 && u98Var.N().getThreadType() != 33 && ((u98Var.N().getTopicData() == null || u98Var.N().getTopicData().a() == 0) && u98Var.N().getIs_top() != 1 && u98Var.N().getIs_good() != 1 && !u98Var.N().isActInfo() && !u98Var.N().isInterviewLive() && !u98Var.N().isVoteThreadType() && u98Var.N().getYulePostActivityData() == null && dj.isEmpty(u98Var.N().getCategory()) && !u98Var.N().isGodThread() && !u98Var.N().isRealGod())) {
                return false;
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public void g4(s98 s98Var) {
        String string;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048710, this, s98Var) != null) || s98Var == null) {
            return;
        }
        this.h.A();
        if (!StringUtils.isNull(s98Var.b)) {
            this.h.w(s98Var.b);
        }
        String string2 = TbadkCoreApplication.getInst().getResources().getString(R.string.obfuscated_res_0x7f0f1492);
        int e2 = dh.e(s98Var.a, 0);
        if (e2 != 100) {
            if (e2 != 300) {
                if (e2 != 400) {
                    string = "";
                } else {
                    string = TbadkCoreApplication.getInst().getResources().getString(R.string.obfuscated_res_0x7f0f140a);
                }
            } else {
                string = TbadkCoreApplication.getInst().getResources().getString(R.string.obfuscated_res_0x7f0f0303);
            }
        } else {
            string = TbadkCoreApplication.getInst().getResources().getString(R.string.obfuscated_res_0x7f0f11bd);
        }
        this.c.showNetRefreshView(this.d, String.format(string2, string), null, TbadkCoreApplication.getInst().getResources().getString(R.string.appeal_restore), true, new k0(this, s98Var.c));
    }

    public void r0(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048758, this, str) == null) {
            if (str.contains("_")) {
                str = str.replace("_", "\n");
            }
            j05 j05Var = new j05(this.c.getPageContext().getPageActivity());
            View inflate = LayoutInflater.from(this.c.getPageContext().getPageActivity()).inflate(R.layout.upgrade_success_dialog_content, (ViewGroup) null);
            TextView textView = (TextView) inflate.findViewById(R.id.title_view);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
            layoutParams.setMargins(0, 0, 0, 0);
            textView.setLayoutParams(layoutParams);
            textView.setGravity(3);
            textView.setText(str);
            ((TextView) inflate.findViewById(R.id.function_description_view)).setVisibility(8);
            j05Var.setContentView(inflate);
            SparseArray sparseArray = new SparseArray();
            sparseArray.put(0, 5);
            j05Var.setYesButtonTag(sparseArray);
            j05Var.setPositiveButton(R.string.obfuscated_res_0x7f0f1650, this.c);
            j05Var.setNegativeButton(R.string.obfuscated_res_0x7f0f038b, new q0(this));
            j05Var.create(this.c.getPageContext()).show();
        }
    }

    public void u2(@NonNull View view2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048772, this, view2) == null) && this.z0.getData() != null && this.z0.getData().hasAgree && this.c.getActivity() != null) {
            x88 x88Var = new x88(this.c.getContext());
            int g2 = ej.g(TbadkCoreApplication.getInst(), R.dimen.tbds774);
            int g3 = ej.g(TbadkCoreApplication.getInst(), R.dimen.obfuscated_res_0x7f07077f);
            int[] iArr = new int[2];
            view2.getLocationInWindow(iArr);
            int i2 = iArr[0];
            int i3 = iArr[1];
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(g3, g2);
            layoutParams.leftMargin = ((view2.getWidth() / 2) + i2) - ((int) ((g3 * 1) / 1.45d));
            layoutParams.topMargin = ej.g(TbadkCoreApplication.getInst(), R.dimen.M_H_X006);
            x88Var.k(g2);
            x88Var.j(layoutParams);
            x88Var.i(false);
            x88Var.n(true, this.c.getActivity().findViewById(16908290), 0, i3, this.L0.P(), this.L0.l());
            x88Var.l(new n(this));
        }
    }

    public final void D1() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048589, this) != null) || !this.c.v5()) {
            return;
        }
        ViewStub viewStub = (ViewStub) this.d.findViewById(R.id.obfuscated_res_0x7f091589);
        this.k = viewStub;
        viewStub.setVisibility(0);
        if (this.A == null) {
            this.A = (LinearLayout) this.d.findViewById(R.id.obfuscated_res_0x7f091588);
            il5.a(this.c.getPageContext(), this.A);
        }
        if (this.B == null) {
            this.B = (TextView) this.A.findViewById(R.id.obfuscated_res_0x7f09158d);
        }
        if (this.C == null) {
            this.C = (TextView) this.A.findViewById(R.id.obfuscated_res_0x7f09158c);
        }
        this.B.setOnClickListener(this.P);
        this.C.setOnClickListener(this.P);
    }

    public void E1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048593, this) == null) {
            if (this.c != null && this.m0 != null) {
                TiebaStatic.log(new StatisticItem(CommonStatisticKey.KEY_RD_USE).param("obj_param1", 3).param("obj_locate", 9).param("obj_type", 1).param("obj_source", UtilHelper.getCurrentPageName(TbadkCoreApplication.getInst().getCurrentActivity())));
                this.m0.j();
                q1();
                return;
            }
            TiebaStatic.log(new StatisticItem(CommonStatisticKey.KEY_RD_USE).param("obj_param1", 3).param("obj_locate", 20).param("obj_type", 1).param("obj_source", UtilHelper.getCurrentPageName(TbadkCoreApplication.getInst().getCurrentActivity())));
        }
    }

    public final void J2() {
        PbFragment pbFragment;
        int i2;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048614, this) == null) && (pbFragment = this.c) != null && pbFragment.B5() != null && this.m0 != null) {
            jd5.a().c(0);
            od5 B5 = this.c.B5();
            B5.M();
            B5.K();
            if (B5.v() != null) {
                WriteImagesInfo v2 = B5.v();
                if (B5.t) {
                    i2 = 1;
                } else {
                    i2 = 9;
                }
                v2.setMaxImagesAllowed(i2);
            }
            B5.d0(SendView.h);
            B5.h(SendView.h);
            sb5 o2 = this.m0.o(23);
            sb5 o3 = this.m0.o(2);
            sb5 o4 = this.m0.o(5);
            if (o3 != null) {
                o3.display();
            }
            if (o4 != null) {
                o4.display();
            }
            if (o2 != null) {
                o2.hide();
            }
            this.m0.invalidate();
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

    public final void X1() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048669, this) == null) && UbsABTestHelper.isShareTopRight()) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.A0.getLayoutParams();
            layoutParams.addRule(11);
            this.A0.setLayoutParams(layoutParams);
            if (this.B0.getParent() != null) {
                ((ViewGroup) this.B0.getParent()).removeView(this.B0);
                ((ViewGroup) this.C0.getParent()).removeView(this.C0);
            }
            if (this.D0.getParent() != null) {
                ((ViewGroup) this.D0.getParent()).removeView(this.D0);
            }
            RelativeLayout relativeLayout = new RelativeLayout(TbadkCoreApplication.getInst().getContext());
            relativeLayout.addView(this.B0);
            relativeLayout.addView(this.C0);
            relativeLayout.addView(this.D0);
            this.h.a.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, relativeLayout, (View.OnClickListener) null);
            this.h.a.getViewGroup(NavigationBar.ControlAlign.HORIZONTAL_RIGHT).setClipChildren(false);
        }
    }

    public void l3() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048734, this) == null) {
            this.c.hideProgressBar();
            u98 u98Var = this.L0;
            if (u98Var != null && this.K != null && u98Var.y() != null && this.L0.y().b() == 0) {
                this.K.x(this.L0.s());
                if (this.L0.s()) {
                    StatisticItem statisticItem = new StatisticItem(CommonStatisticKey.KEY_PB_FOLD_ICON_SHOW);
                    statisticItem.param("uid", TbadkCoreApplication.getCurrentAccount());
                    statisticItem.param("fid", this.L0.l());
                    statisticItem.param("fname", this.L0.m());
                    statisticItem.param("tid", this.L0.P());
                    TiebaStatic.log(statisticItem);
                }
            }
            A0();
            PbLandscapeListView pbLandscapeListView = this.l;
            if (pbLandscapeListView != null) {
                pbLandscapeListView.A(0L);
            }
            w0();
        }
    }

    public void q0() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048754, this) == null) && !this.Z1) {
            TiebaStatic.log("c10490");
            this.Z1 = true;
            j05 j05Var = new j05(this.c.getPageContext().getPageActivity());
            SparseArray sparseArray = new SparseArray();
            sparseArray.put(0, 4);
            j05Var.setTitle(R.string.grade_thread_tips);
            View inflate = LayoutInflater.from(this.c.getPageContext().getPageActivity()).inflate(R.layout.upgrade_success_dialog_content, (ViewGroup) null);
            ((TextView) inflate.findViewById(R.id.function_description_view)).setText(R.string.function_upgrade_to_photo_live_tips);
            ((TextView) inflate.findViewById(R.id.title_view)).setText(R.string.grade_thread_tips);
            j05Var.setContentView(inflate);
            j05Var.setYesButtonTag(sparseArray);
            j05Var.setPositiveButton(R.string.grade_button_tips, this.c);
            j05Var.setNegativeButton(R.string.look_again, new p0(this));
            j05Var.create(this.c.getPageContext()).show();
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:24:0x0051, code lost:
        if (r5.E1 == 1) goto L19;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void s0() {
        bh8 bh8Var;
        int i2;
        boolean z2;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048762, this) != null) || (bh8Var = this.H1) == null) {
            return;
        }
        if (this.l != null && bh8Var.a() != null && this.H1.a().getParent() != null) {
            i2 = this.l.getPositionForView(this.H1.a());
        } else {
            i2 = -1;
        }
        boolean z3 = false;
        if (i2 != -1) {
            if (this.H1.a().getTop() + b2 <= this.U0.getBottom()) {
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
        pbReplyTitleViewHolder.r(z3);
        this.H1.e(z2);
    }

    public final boolean s3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048765, this)) == null) {
            u98 u98Var = this.L0;
            if (u98Var != null && u98Var.N() != null && !ListUtils.isEmpty(this.L0.N().getThreadRecommendInfoDataList()) && this.c != null && this.u.d() != null && this.u.d().getVisibility() == 0 && this.L0.N().getThreadRecommendInfoDataList().get(0) != null && this.L0.N().getThreadRecommendInfoDataList().get(0).businessType == 1) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public final void x2() {
        qf8 qf8Var;
        u98 u98Var;
        boolean z2;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048784, this) == null) && this.u != null && (qf8Var = this.h) != null && qf8Var.i() != null && (u98Var = this.L0) != null && u98Var.N() != null && this.L0.N().isQuestionThread() && this.u.d() != null && this.u.d().getVisibility() == 0) {
            int[] iArr = new int[2];
            this.u.d().getLocationInWindow(iArr);
            boolean z3 = true;
            int height = iArr[1] + this.u.d().getHeight();
            if (this.u.d().getParent() == null) {
                z2 = false;
            } else {
                z2 = true;
            }
            qf8 qf8Var2 = this.h;
            if (height > qf8Var2.i().getBottom() && z2) {
                z3 = false;
            }
            qf8Var2.x(z3, this.L0.N().getSpan_str());
        }
    }

    public void D3(boolean z2) {
        TextView textView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048591, this, z2) == null) && this.t0 != null && (textView = this.w0) != null) {
            textView.setText(R.string.obfuscated_res_0x7f0f054d);
            if (z2) {
                AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
                alphaAnimation.setDuration(400L);
                this.t0.startAnimation(alphaAnimation);
            }
            this.s0.setVisibility(0);
            this.t0.setVisibility(0);
            this.H0 = true;
        }
    }

    public void G1(u98 u98Var) {
        n65 pbAdFloatViewItemData;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048601, this, u98Var) != null) || u98Var == null) {
            return;
        }
        if (u98Var.o0()) {
            pbAdFloatViewItemData = u98Var.a0();
        } else {
            pbAdFloatViewItemData = TbSingleton.getInstance().getPbAdFloatViewItemData();
        }
        if (pbAdFloatViewItemData != null && !pbAdFloatViewItemData.a()) {
            F1(u98Var, pbAdFloatViewItemData);
        } else {
            x1();
        }
    }

    public final boolean K1(u98 u98Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048617, this, u98Var)) == null) {
            if (u98Var == null || u98Var.N() == null) {
                return false;
            }
            SpannableStringBuilder span_str = u98Var.N().getSpan_str();
            if (span_str == null) {
                return true;
            }
            if (!TbadkApplication.getInst().getResources().getString(R.string.obfuscated_res_0x7f0f0e89).equals(span_str.toString())) {
                return false;
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public final boolean Q1(ThreadData threadData) {
        InterceptResult invokeL;
        String str;
        PostData W;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048641, this, threadData)) == null) {
            if (threadData != null && threadData.getAuthor() != null) {
                u98 u98Var = this.L0;
                if (u98Var != null && (W = u98Var.W()) != null && W.r() != null) {
                    str = W.r().getUserId();
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
            K2();
        }
        nc8 nc8Var = this.g1;
        if (nc8Var != null) {
            nc8Var.g();
        }
        this.c.N5();
        this.D.setVisibility(8);
        this.h.t(false);
        this.c.F6(false);
    }

    public void f2(boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048703, this, z2) == null) {
            if (z2) {
                F3();
            } else {
                t1();
            }
            this.b1.a = null;
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004013, this.b1));
            y2(this.b1.a, false);
        }
    }

    public void f4(boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048705, this, z2) == null) {
            this.h.z(z2);
            if (z2 && this.P0) {
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

    public final String E0(long j2) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJ = interceptable.invokeJ(1048592, this, j2)) == null) {
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

    public final String F0(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048596, this, i2)) == null) {
            if (i2 == 0) {
                return this.c.getString(R.string.obfuscated_res_0x7f0f0e88);
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

    public void M2(EditorTools editorTools) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048626, this, editorTools) == null) {
            this.m0 = editorTools;
            editorTools.setOnCancelClickListener(new r(this));
            this.m0.setId(R.id.obfuscated_res_0x7f0918dc);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
            layoutParams.addRule(12);
            if (this.m0.getParent() == null) {
                this.d.addView(this.m0, layoutParams);
            }
            this.m0.y(TbadkCoreApplication.getInst().getSkinType());
            this.m0.setActionListener(24, new s(this));
            s1();
            this.c.B5().g(new t(this));
        }
    }

    public void W3(boolean z2) {
        TextView textView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048667, this, z2) == null) && this.l != null && (textView = this.T0) != null && this.e != null) {
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
            F2();
        }
    }

    public void Z1(w09 w09Var) {
        u98 u98Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048677, this, w09Var) == null) && w09Var != null && w09Var.b != null && (u98Var = this.L0) != null && u98Var.N() != null && this.L0.N().getAgreeData() != null) {
            AgreeData agreeData = this.L0.N().getAgreeData();
            String str = w09Var.b.nid;
            if (!TextUtils.isEmpty(str) && !"0".equals(str)) {
                BaijiahaoData baijiahaoData = agreeData.baijiahaoData;
                if (baijiahaoData == null || !TextUtils.equals(str, baijiahaoData.oriUgcNid)) {
                    return;
                }
            } else {
                String str2 = w09Var.b.threadId;
                String str3 = agreeData.threadId;
                if ("0".equals(str2) || TextUtils.isEmpty(str2) || !TextUtils.equals(str2, str3)) {
                    return;
                }
            }
            AgreeData agreeData2 = w09Var.b;
            B2(agreeData2, agreeData2.agreeNum);
        }
    }

    public void d2(TbRichText tbRichText) {
        u98 u98Var;
        PostData postData;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048694, this, tbRichText) == null) && (u98Var = this.L0) != null && u98Var.G() != null && !this.L0.G().isEmpty() && tbRichText != null && !StringUtils.isNull(tbRichText.getAuthorId())) {
            for (int i2 = 0; i2 < this.L0.G().size() && (postData = this.L0.G().get(i2)) != null && postData.r() != null && !StringUtils.isNull(postData.r().getUserId()); i2++) {
                if (this.L0.G().get(i2).r().getUserId().equals(tbRichText.getAuthorId())) {
                    tb8 tb8Var = this.s1;
                    if (tb8Var != null && tb8Var.l()) {
                        z3(false);
                        return;
                    }
                    return;
                }
            }
        }
    }

    public void i4(u98 u98Var) {
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048720, this, u98Var) == null) {
            if (u98Var != null && AntiHelper.o(u98Var.N())) {
                ch8 ch8Var = this.E0;
                if (ch8Var != null) {
                    ch8Var.l(false);
                    this.E0.k();
                }
                ViewGroup.LayoutParams layoutParams = this.B0.getLayoutParams();
                layoutParams.height = -2;
                layoutParams.width = -2;
                this.B0.setLayoutParams(layoutParams);
                WebPManager.setPureDrawable(this.B0, R.drawable.icon_pure_pb_bottom_share26, R.color.CAM_X0110, WebPManager.ResourceStateType.NORMAL_PRESS);
                return;
            }
            ch8 ch8Var2 = this.E0;
            if (ch8Var2 != null && ch8Var2.h()) {
                return;
            }
            ViewGroup.LayoutParams layoutParams2 = this.B0.getLayoutParams();
            layoutParams2.height = -2;
            layoutParams2.width = -2;
            this.B0.setLayoutParams(layoutParams2);
            ImageView imageView = this.B0;
            if (UbsABTestHelper.isShareTopRight()) {
                i2 = R.color.CAM_X0105;
            } else {
                i2 = R.color.CAM_X0107;
            }
            WebPManager.setPureDrawable(imageView, R.drawable.icon_pure_pb_bottom_share26, i2, WebPManager.ResourceStateType.NORMAL_PRESS);
        }
    }

    public void l4(boolean z2) {
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048735, this, z2) == null) {
            dc8 dc8Var = this.E;
            if (dc8Var != null) {
                dc8Var.t0(z2);
                this.E.Z();
            }
            PbReplyTitleViewHolder pbReplyTitleViewHolder = this.X0;
            if (pbReplyTitleViewHolder != null) {
                pbReplyTitleViewHolder.n(z2);
            }
            PbReplyTitleViewHolder pbReplyTitleViewHolder2 = this.b1.a;
            if (pbReplyTitleViewHolder2 != null) {
                pbReplyTitleViewHolder2.n(z2);
            }
            PbFragment pbFragment = this.c;
            if (pbFragment != null) {
                pbFragment.E6(z2);
            }
            if (z2) {
                kf8.d(this.c.getPageContext(), this.c.M(), this.c.E5());
            }
            StatisticItem statisticItem = new StatisticItem(CommonStatisticKey.KEY_BATCH_MULTI_DEL_CLICK);
            u98 u98Var = this.L0;
            if (u98Var != null) {
                str = u98Var.l();
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
        if ((interceptable == null || interceptable.invokeZ(1048759, this, z2) == null) && this.t0 != null && this.w0 != null) {
            TbSingleton tbSingleton = TbSingleton.getInstance();
            u98 u98Var = this.L0;
            if (u98Var != null && u98Var.o0()) {
                z3 = true;
            } else {
                z3 = false;
            }
            u98 u98Var2 = this.L0;
            if (u98Var2 != null && u98Var2.p0()) {
                z4 = true;
            } else {
                z4 = false;
            }
            this.w0.setText(tbSingleton.getAdVertiComment(z3, z4, h1()));
            if (z2) {
                AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
                alphaAnimation.setDuration(400L);
                this.t0.startAnimation(alphaAnimation);
            }
            this.s0.setVisibility(0);
            this.t0.setVisibility(0);
            this.H0 = true;
        }
    }

    public final void w3(SparseArray<Object> sparseArray) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048781, this, sparseArray) != null) || this.c == null) {
            return;
        }
        if (sparseArray != null) {
            sparseArray.put(R.id.tag_is_block_thread, Boolean.TRUE);
        }
        TBAlertConfig.a aVar = new TBAlertConfig.a((int) R.string.obfuscated_res_0x7f0f1238, TBAlertConfig.OperateBtnStyle.MAIN);
        TBAlertConfig.a aVar2 = new TBAlertConfig.a((int) R.string.obfuscated_res_0x7f0f038b, TBAlertConfig.OperateBtnStyle.SECONDARY);
        TBAlertBuilder tBAlertBuilder = new TBAlertBuilder(this.c.N());
        tBAlertBuilder.w(R.string.musk_my_thread_confirm);
        tBAlertBuilder.m(R.string.musk_my_thread_confirm_subtitle);
        tBAlertBuilder.o(true);
        tBAlertBuilder.u(aVar2, aVar);
        tBAlertBuilder.j(false);
        AlertDialog z2 = tBAlertBuilder.z();
        aVar.a(new y(this, z2, sparseArray));
        aVar2.a(new z(this, z2));
    }

    public final void F1(u98 u98Var, n65 n65Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048597, this, u98Var, n65Var) == null) && this.L1 != null && u98Var != null && n65Var != null && this.c.getContext() != null) {
            if (!RightFloatLayerView.k()) {
                x1();
                return;
            }
            if (this.K1 == null) {
                RightFloatLayerView E = RightFloatLayerLottieView.E(n65Var, this.c.getContext());
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
            if (n65Var.a()) {
                return;
            }
            this.K1.setData(n65Var);
            this.K1.setLogoListener(new r0(this, n65Var));
            this.K1.setFeedBackListener(new u0(this, n65Var));
        }
    }

    public final void I3(SparseArray<Object> sparseArray, int i2, vv5 vv5Var, UserData userData, boolean z2) {
        PbFragment pbFragment;
        String str;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeCommon(1048611, this, new Object[]{sparseArray, Integer.valueOf(i2), vv5Var, userData, Boolean.valueOf(z2)}) != null) || (pbFragment = this.c) == null) {
            return;
        }
        if (this.z1 == null && this.t != null) {
            this.z1 = new wv5(pbFragment.getPageContext(), this.t.c(), vv5Var, userData);
        }
        this.z1.F(z2);
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
        py4 py4Var = new py4();
        py4Var.j(sparseArray2);
        this.z1.H(new String[]{this.c.getString(R.string.delete_thread_reason_1), this.c.getString(R.string.delete_thread_reason_2), this.c.getString(R.string.delete_thread_reason_3), this.c.getString(R.string.delete_thread_reason_4), this.c.getString(R.string.delete_thread_reason_5)});
        this.z1.G(py4Var);
        if (i2 != 1 && i2 != 2) {
            str = "3";
        } else {
            str = "4";
        }
        this.z1.J(str);
        this.z1.I(new b0(this, sparseArray));
    }

    public void N3(l05.c cVar, boolean z2, boolean z3, boolean z4, boolean z5) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048631, this, new Object[]{cVar, Boolean.valueOf(z2), Boolean.valueOf(z3), Boolean.valueOf(z4), Boolean.valueOf(z5)}) == null) {
            s05 s05Var = this.d0;
            if (s05Var != null) {
                s05Var.dismiss();
                this.d0 = null;
            }
            u05 u05Var = new u05(this.c.getContext());
            ArrayList arrayList = new ArrayList();
            if (!z4 && !z5) {
                arrayList.add(new q05(0, this.c.getPageContext().getString(R.string.obfuscated_res_0x7f0f0475), u05Var));
            }
            if (z3) {
                arrayList.add(new q05(1, this.c.getPageContext().getString(R.string.report_text), u05Var));
            } else if (!z2) {
                arrayList.add(new q05(1, this.c.getPageContext().getString(R.string.obfuscated_res_0x7f0f0b3c), u05Var));
            } else {
                arrayList.add(new q05(1, this.c.getPageContext().getString(R.string.remove_mark), u05Var));
            }
            u05Var.k(arrayList);
            u05Var.p(new e0(this, cVar));
            s05 s05Var2 = new s05(this.c.getPageContext(), u05Var);
            this.e0 = s05Var2;
            s05Var2.k();
        }
    }

    public void K3(u98 u98Var, int i2, int i3, boolean z2, int i4, boolean z3) {
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
        u98 u98Var2;
        Parcelable e2;
        Parcelable e3;
        int size2;
        int i7;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(1048619, this, new Object[]{u98Var, Integer.valueOf(i2), Integer.valueOf(i3), Boolean.valueOf(z2), Integer.valueOf(i4), Boolean.valueOf(z3)}) == null) && u98Var != null && this.l != null) {
            this.L0 = u98Var;
            this.N0 = i2;
            if (u98Var.N() != null) {
                this.c1 = u98Var.N().getCopyThreadRemindType();
                this.h0 = Q1(u98Var.N());
            }
            if (u98Var.U() != null) {
                this.V1 = u98Var.U().getUserId();
            }
            C1(u98Var);
            j0();
            this.P0 = false;
            this.K0 = z2;
            l3();
            da8 da8Var = u98Var.h;
            if (da8Var != null && da8Var.b()) {
                if (this.o == null) {
                    PbThreadPostView pbThreadPostView = new PbThreadPostView(this.c.getContext());
                    this.o = pbThreadPostView;
                    this.l.x(pbThreadPostView, 1);
                    this.o.setData();
                    this.o.setChildOnClickLinstener(this.P);
                }
            } else {
                PbThreadPostView pbThreadPostView2 = this.o;
                if (pbThreadPostView2 != null && (pbLandscapeListView = this.l) != null) {
                    pbLandscapeListView.removeHeaderView(pbThreadPostView2);
                }
            }
            L3(u98Var);
            A3(u98Var);
            this.v.N(u98Var, this.M0);
            if (this.w1 == null) {
                this.w1 = new cd8(this.c.getPageContext(), this.x1);
            }
            this.w1.a(u98Var.w());
            if (this.c.v5()) {
                if (this.J == null) {
                    dh8 dh8Var = new dh8(this.c.getPageContext());
                    this.J = dh8Var;
                    dh8Var.n();
                    this.J.f(this.W1);
                }
                this.l.setPullRefresh(this.J);
                dh8 dh8Var2 = this.J;
                if (dh8Var2 != null) {
                    dh8Var2.H(TbadkCoreApplication.getInst().getSkinType());
                }
            } else if (u98Var.y().c() == 0 && z2) {
                this.l.setPullRefresh(null);
            } else {
                if (this.J == null) {
                    dh8 dh8Var3 = new dh8(this.c.getPageContext());
                    this.J = dh8Var3;
                    dh8Var3.n();
                    this.J.f(this.W1);
                }
                this.l.setPullRefresh(this.J);
                dh8 dh8Var4 = this.J;
                if (dh8Var4 != null) {
                    dh8Var4.H(TbadkCoreApplication.getInst().getSkinType());
                }
                u1();
            }
            w0();
            this.E.p0(this.K0);
            this.E.m0(false);
            dc8 dc8Var = this.E;
            if (i2 == 5) {
                z4 = true;
            } else {
                z4 = false;
            }
            dc8Var.n0(z4);
            dc8 dc8Var2 = this.E;
            if (i2 == 6) {
                z5 = true;
            } else {
                z5 = false;
            }
            dc8Var2.o0(z5);
            dc8 dc8Var3 = this.E;
            if (z3 && this.T1 && i2 != 2) {
                z6 = true;
            } else {
                z6 = false;
            }
            dc8Var3.k0(z6);
            this.E.h0(u98Var, false);
            this.E.Z();
            dc8 dc8Var4 = this.E;
            if (u98Var.y().b() != 0) {
                z7 = true;
            } else {
                z7 = false;
            }
            dc8Var4.b0(z7, u98Var.f());
            this.v.L(u98Var.W(), u98Var.i0());
            if (u98Var.N() != null && u98Var.N().getPraise() != null && this.b != -1) {
                u98Var.N().getPraise().setIsLike(this.b);
            }
            this.l.removeFooterView(this.Y0);
            this.l.addFooterView(this.Y0);
            if (TbadkCoreApplication.isLogin()) {
                this.l.setNextPage(this.K);
                this.f = 2;
                u1();
            } else {
                this.P0 = true;
                if (u98Var.y().b() == 1) {
                    if (this.L == null) {
                        PbFragment pbFragment2 = this.c;
                        this.L = new zg8(pbFragment2, pbFragment2);
                    }
                    this.l.setNextPage(this.L);
                } else {
                    this.l.setNextPage(this.K);
                }
                this.f = 3;
            }
            ArrayList<PostData> G = u98Var.G();
            if (u98Var.y().b() != 0 && G != null && G.size() >= u98Var.y().e()) {
                if (z3) {
                    if (this.T1) {
                        A0();
                        if (u98Var.y().b() != 0) {
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
                if (ListUtils.getCount(G) != 0 && (ListUtils.getCount(G) != 1 || G.get(0) == null || G.get(0).F() != 1)) {
                    if (u98Var.y().b() == 0) {
                        this.K.F(TbadkCoreApplication.getInst().getResources().getString(R.string.list_has_no_more));
                    } else {
                        this.K.F(TbadkCoreApplication.getInst().getResources().getString(R.string.load_more));
                    }
                    this.K.m();
                } else {
                    z0 z0Var = this.b1;
                    if (z0Var != null && (pbReplyTitleViewHolder = z0Var.a) != null && pbReplyTitleViewHolder.getView() != null) {
                        if (this.b1.a.getView().getTop() < 0) {
                            i5 = this.b1.a.getView().getHeight();
                        } else {
                            i5 = this.b1.a.getView().getBottom();
                        }
                    } else {
                        i5 = 0;
                    }
                    if (this.c.V5()) {
                        this.K.x(false);
                        if (ListUtils.isEmpty(u98Var.Q())) {
                            this.K.I(TbadkCoreApplication.getInst().getResources().getString(R.string.obfuscated_res_0x7f0f0ea1), i5);
                        }
                    } else if (ListUtils.isEmpty(u98Var.Q())) {
                        this.K.I(TbadkCoreApplication.getInst().getResources().getString(R.string.obfuscated_res_0x7f0f0ea2), i5);
                    }
                    if (this.c.C5() != null && !this.c.C5().p()) {
                        this.c.C5().x();
                    }
                }
                if (u98Var.y().b() == 0 || G == null) {
                    G2();
                }
            }
            if (i2 != 2) {
                if (i2 != 3) {
                    if (i2 != 4) {
                        if (i2 != 5) {
                            if (i2 != 6) {
                                if (i2 == 8) {
                                    if (i3 == 0) {
                                        this.l.setSelection(this.E.B() + this.l.getHeaderViewsCount());
                                    } else if (ListUtils.isEmpty(u98Var.Q())) {
                                        if (this.l.getData() == null && u98Var.G() == null) {
                                            size2 = 0;
                                        } else {
                                            size2 = (this.l.getData().size() - u98Var.G().size()) + this.l.getHeaderViewsCount();
                                        }
                                        PbLandscapeListView pbLandscapeListView2 = this.l;
                                        if (i3 > 0) {
                                            i7 = size2 + i3;
                                        } else {
                                            i7 = 0;
                                        }
                                        pbLandscapeListView2.setSelection(i7);
                                    } else {
                                        this.l.setSelection(u98Var.G().size() + this.l.getHeaderViewsCount());
                                    }
                                    this.K.g();
                                    this.K.F(this.c.getString(R.string.obfuscated_res_0x7f0f0e9b));
                                    this.K.A();
                                }
                            } else if (i4 == 1 && (e3 = id8.b().e()) != null && !(e3 instanceof RecyclerView.SavedState)) {
                                this.l.onRestoreInstanceState(e3);
                            } else {
                                this.l.setSelection(0);
                            }
                        } else {
                            this.l.setSelection(0);
                        }
                    } else {
                        this.T1 = false;
                    }
                } else if (i4 == 1 && (e2 = id8.b().e()) != null && !(e2 instanceof RecyclerView.SavedState)) {
                    this.l.post(new l0(this, e2, G, u98Var));
                }
            } else {
                if (this.l.getData() == null && u98Var.G() == null) {
                    size = 0;
                } else {
                    size = (this.l.getData().size() - u98Var.G().size()) + this.l.getHeaderViewsCount();
                }
                PbLandscapeListView pbLandscapeListView3 = this.l;
                if (i3 > 1) {
                    i6 = (size + i3) - 2;
                } else {
                    i6 = 0;
                }
                pbLandscapeListView3.setSelection(i6);
            }
            if (this.c1 == 3 && O1()) {
                q0();
            }
            if (this.h1) {
                A2();
                this.h1 = false;
                if (i4 == 0) {
                    b3(true);
                }
            }
            if (u98Var.d == 1 || u98Var.e == 1) {
                if (this.n1 == null) {
                    this.n1 = new PbTopTipView(this.c.getContext());
                }
                if (u98Var.e == 1 && "game_guide".equals(this.c.G5())) {
                    this.n1.setText(this.c.getString(R.string.obfuscated_res_0x7f0f0ead));
                    this.n1.l(this.d, this.O0);
                } else if (u98Var.d == 1 && "game_news".equals(this.c.G5())) {
                    this.n1.setText(this.c.getString(R.string.obfuscated_res_0x7f0f0eac));
                    this.n1.l(this.d, this.O0);
                }
            }
            this.l.removeFooterView(this.H1.a());
            if (!ListUtils.isEmpty(u98Var.I()) && u98Var.y().b() == 0) {
                this.l.removeFooterView(this.Y0);
                this.H1.d(Math.max(this.t0.getMeasuredHeight(), this.I0 / 2));
                this.l.addFooterView(this.H1.a());
                this.H1.f(u98Var);
            }
            C2(u98Var);
            if (u98Var.g0() && this.c.M().a2() && this.c.D5() != null) {
                this.c.D5().d();
            }
            if (u98Var.f() != 3) {
                G1(u98Var);
            }
            this.w0.setText(TbSingleton.getInstance().getAdVertiComment(u98Var.o0(), u98Var.p0(), h1()));
            if (this.p != null && (u98Var2 = this.L0) != null && u98Var2.k() != null) {
                this.p.m(this.L0.k().getImage_url());
                this.p.n(this.L0.k().getName());
                PbFragment pbFragment3 = this.c;
                if (pbFragment3 != null && pbFragment3.M() != null) {
                    this.p.o(this.c.M().b);
                }
            }
            if (this.r != null) {
                u98 u98Var3 = this.L0;
                if (u98Var3 != null && u98Var3.k() != null && (pbFragment = this.c) != null && pbFragment.M() != null) {
                    this.r.q(this.c.M().b);
                }
                u98 u98Var4 = this.L0;
                if (u98Var4 != null && u98Var4.N() != null && !ListUtils.isEmpty(this.L0.N().getThreadRecommendInfoDataList()) && this.L0.N().getThreadRecommendInfoDataList().get(0) != null && this.L0.N().getThreadRecommendInfoDataList().get(0).businessType != 1) {
                    this.r.p(this.L0.N().getThreadRecommendInfoDataList().get(0));
                } else {
                    this.r.p(null);
                }
            }
            if (s3()) {
                this.z.e(this.L0.N());
            } else {
                this.z.d(this.l);
            }
        }
    }

    public PostData L0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048620, this)) == null) {
            if (this.l == null) {
                return null;
            }
            int K0 = K0() - this.l.getHeaderViewsCount();
            int i2 = 0;
            if (K0 < 0) {
                K0 = 0;
            }
            if (this.E.y(K0) != null && this.E.y(K0) != PostData.P0) {
                i2 = K0 + 1;
            }
            if (!(this.E.x(i2) instanceof PostData)) {
                return null;
            }
            return (PostData) this.E.x(i2);
        }
        return (PostData) invokeV.objValue;
    }

    public final boolean P1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048637, this)) == null) {
            if (s3()) {
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

    public void P3() {
        PostData postData;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048639, this) != null) || !TbadkCoreApplication.isLogin() || this.L0 == null || !this.k1 || this.j1 || this.h0 || (postData = this.M0) == null || postData.r() == null || this.M0.r().getIsLike() || this.M0.r().hadConcerned()) {
        }
    }

    public final void l0() {
        PbContentCollectionController pbContentCollectionController;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048731, this) == null) {
            if (s3()) {
                new StatisticItem(CommonStatisticKey.KEY_PB_PAGE_CONTENT_COLLECTION_SHOW).addParam("tid", this.L0.N().getTid()).addParam("obj_param1", this.L0.N().getThreadRecommendInfoDataList().get(0).businessId).eventStat();
            }
            if (P1() && (pbContentCollectionController = this.z) != null) {
                pbContentCollectionController.h();
                this.z.g(true);
            }
        }
    }

    @SuppressLint({"ResourceAsColor"})
    public final void L3(u98 u98Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048623, this, u98Var) == null) && u98Var != null && u98Var.N() != null) {
            if (this.c.v0()) {
                if (u98Var.g() != null) {
                    this.i0 = u98Var.g().d();
                    this.j0 = u98Var.g().b();
                }
                if (this.i0 == null && this.c.M() != null && this.c.M().J0() != null) {
                    this.i0 = this.c.M().J0();
                }
            }
            PostData W = u98Var.W();
            j3(W, u98Var);
            int i2 = 8;
            this.v.I(8);
            int i3 = 1;
            if (u98Var.v0()) {
                this.j1 = true;
                this.h.s(true);
                this.h.a.hideBottomLine();
            } else {
                this.j1 = false;
                this.h.s(false);
            }
            if (this.c.C5() != null) {
                this.c.C5().w(this.j1);
            }
            if (W == null) {
                return;
            }
            this.M0 = W;
            this.v.I(0);
            SparseArray<Object> t2 = this.v.t();
            t2.put(R.id.tag_clip_board, W);
            t2.put(R.id.tag_is_subpb, Boolean.FALSE);
            this.w.e(u98Var, this.l);
            this.y.e(u98Var, this.D1, new i0(this));
            this.u.j(u98Var);
            this.t.h(u98Var, this.K0);
            this.t.g(u98Var);
            this.v.J(this.L0, W, this.U1);
            if (this.X0 != null) {
                if (u98Var.i0()) {
                    this.X0.getView().setVisibility(8);
                } else {
                    this.X0.getView().setVisibility(0);
                    ha8 ha8Var = new ha8(ha8.g);
                    ha8Var.b = u98Var.g;
                    ha8Var.c = this.c.V5();
                    ha8Var.e = u98Var.f;
                    ha8Var.f = u98Var.N().isQuestionThread();
                    this.X0.h(ha8Var);
                }
            }
            X3(W);
            Y3(u98Var);
            gh.a().post(new j0(this));
            this.x.f(this.l);
            if (W.S) {
                this.x.g(W.O());
                PbLandscapeListView pbLandscapeListView = this.l;
                this.x.c(this.l, (pbLandscapeListView == null || pbLandscapeListView.getHeaderViewsCount() <= 1) ? 0 : 0);
            }
            dc8 dc8Var = this.E;
            if (dc8Var != null && dc8Var.z() != null) {
                this.E.z().G(W.S);
            }
            MaskView maskView = this.I1;
            if (W.S) {
                i2 = 0;
            }
            maskView.setVisibility(i2);
        }
    }

    public void M3(l05.c cVar, boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048627, this, cVar, z2) == null) {
            s05 s05Var = this.e0;
            if (s05Var != null) {
                s05Var.dismiss();
                this.e0 = null;
            }
            u05 u05Var = new u05(this.c.getContext());
            ArrayList arrayList = new ArrayList();
            u98 u98Var = this.L0;
            if (u98Var != null && u98Var.N() != null && !this.L0.N().isBjh()) {
                arrayList.add(new q05(0, this.c.getPageContext().getString(R.string.save_to_emotion), u05Var));
            }
            if (!z2) {
                arrayList.add(new q05(1, this.c.getPageContext().getString(R.string.save_to_local), u05Var));
            }
            u05Var.k(arrayList);
            u05Var.p(new f0(this, cVar));
            s05 s05Var2 = new s05(this.c.getPageContext(), u05Var);
            this.e0 = s05Var2;
            s05Var2.k();
        }
    }

    public final void Q3(j05 j05Var, int i2) {
        PbFragment pbFragment;
        String str;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLI(1048643, this, j05Var, i2) == null) && (pbFragment = this.c) != null && j05Var != null) {
            if (this.y1 == null && this.t != null) {
                this.y1 = new tv5(pbFragment.getPageContext(), this.t.c());
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
            py4 py4Var = new py4();
            py4Var.j(sparseArray);
            this.y1.B(new String[]{this.c.getString(R.string.delete_thread_reason_1), this.c.getString(R.string.delete_thread_reason_2), this.c.getString(R.string.delete_thread_reason_3), this.c.getString(R.string.delete_thread_reason_4), this.c.getString(R.string.delete_thread_reason_5)});
            this.y1.A(py4Var);
            if (i2 != 1 && i2 != 2) {
                str = "3";
            } else {
                str = "4";
            }
            this.y1.D(str);
            this.y1.C(new a0(this, j05Var));
        }
    }

    public void V3(ty4 ty4Var, j05.e eVar) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLL(1048663, this, ty4Var, eVar) != null) || ty4Var == null) {
            return;
        }
        int a3 = ty4Var.a();
        int h2 = ty4Var.h();
        j05 j05Var = this.F;
        if (j05Var != null) {
            j05Var.show();
        } else {
            this.F = new j05(this.c.getPageContext().getPageActivity());
            View inflate = LayoutInflater.from(this.c.getPageContext().getPageActivity()).inflate(R.layout.obfuscated_res_0x7f0d022e, (ViewGroup) null);
            this.H = inflate;
            this.F.setContentView(inflate);
            this.F.setPositiveButton(R.string.obfuscated_res_0x7f0f051d, eVar);
            this.F.setNegativeButton(R.string.obfuscated_res_0x7f0f0515, new n0(this));
            this.F.setOnCalcelListener(new o0(this));
            this.F.create(this.c.getPageContext()).show();
        }
        EditText editText = (EditText) this.H.findViewById(R.id.obfuscated_res_0x7f09100f);
        this.I = editText;
        editText.setText("");
        TextView textView = (TextView) this.H.findViewById(R.id.obfuscated_res_0x7f09078b);
        if (a3 <= 0) {
            a3 = 1;
        }
        if (h2 <= 0) {
            h2 = 1;
        }
        textView.setText(MessageFormat.format(TbadkCoreApplication.getInst().getResources().getString(R.string.current_page), Integer.valueOf(a3), Integer.valueOf(h2)));
        this.c.getBaseFragmentActivity().ShowSoftKeyPadDelay(this.I, 150);
    }

    public boolean j4(u98 u98Var, boolean z2) {
        InterceptResult invokeLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(1048725, this, u98Var, z2)) == null) {
            if (u98Var == null) {
                return false;
            }
            if (this.u != null) {
                if (u98Var.N() != null && u98Var.N().getIsNoTitle() == 0 && !u98Var.N().isVideoThreadType()) {
                    if (u98Var.N() != null) {
                        ThreadData N = u98Var.N();
                        N.parserSpecTitleForFrsAndPb(true, C3(u98Var));
                        N.setResource(3);
                        N.setPbTitle("2");
                    }
                    if (u98Var.N().isBJHArticleThreadType()) {
                        this.v.C(this.l);
                        this.u.h(this.l);
                        this.u.a(this.l);
                        this.v.n(this.l);
                        this.v.H(this.L0);
                        if (K1(u98Var)) {
                            this.u.h(this.l);
                        } else {
                            this.u.i(u98Var);
                        }
                    } else {
                        this.v.H(this.L0);
                        if (K1(u98Var)) {
                            this.u.h(this.l);
                        } else {
                            this.u.k(u98Var);
                        }
                    }
                } else if (u98Var.N().getIsNoTitle() == 1) {
                    if (u98Var.N() != null) {
                        this.u.h(this.l);
                        this.v.H(this.L0);
                    }
                } else {
                    this.u.h(this.l);
                    this.v.H(this.L0);
                }
            }
            X3(u98Var.W());
            Y3(u98Var);
            this.K0 = z2;
            return false;
        }
        return invokeLZ.booleanValue;
    }

    public final void x3(int i2, SparseArray<Object> sparseArray) {
        PbFragment pbFragment;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeIL(1048785, this, i2, sparseArray) == null) && (pbFragment = this.c) != null && pbFragment.M() != null && this.c.M().k1() != null && this.c.M().k1().n() != null && this.c.M().k1().k() != null && this.c.M().k1().k().getDeletedReasonInfo() != null) {
            if (sparseArray != null) {
                sparseArray.put(R.id.tag_is_block_thread, Boolean.TRUE);
            }
            vv5 vv5Var = new vv5(this.c.M().k1().k().getDeletedReasonInfo().is_grays_cale_forum.intValue(), this.c.M().k1().k().getDeletedReasonInfo().is_boomgrow.intValue(), this.c.M().k1().n().has_forum_rule.intValue());
            vv5Var.i(this.c.M().k1().k().getId(), this.c.M().k1().k().getName());
            vv5Var.h(this.c.M().k1().k().getImage_url());
            vv5Var.j(this.c.M().k1().k().getUser_level());
            I3(sparseArray, i2, vv5Var, this.c.M().k1().U(), true);
        }
    }

    public final void V1() {
        PbFragment pbFragment;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048661, this) == null) && (pbFragment = this.c) != null && pbFragment.M() != null && this.c.M().G != null && this.c.M().G.N() != null && this.c.M().G.N().isQuestionThread()) {
            ThreadData N = this.c.M().G.N();
            String w1 = this.c.M().w1();
            String x1 = this.c.M().x1();
            int i2 = 5;
            if ("question_answer_invite".equals(w1)) {
                i2 = 1;
            } else if ("3".equals(x1)) {
                i2 = 2;
            } else if ("answer_top".equals(w1)) {
                i2 = 3;
            } else if (this.c.M().P0()) {
                i2 = 4;
            }
            TiebaStatic.log(new StatisticItem("c14924").param("uid", TbadkCoreApplication.getCurrentAccountId()).param("tid", N.getId()).param("fid", N.getFid()).param("obj_source", i2));
        }
    }

    public final void m0() {
        u98 u98Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048736, this) == null) && this.z != null && (u98Var = this.L0) != null && u98Var.N() != null && !ListUtils.isEmpty(this.L0.N().getThreadRecommendInfoDataList()) && this.L0.N().getThreadRecommendInfoDataList().get(0) != null && this.u.d().getVisibility() == 0) {
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

    public final void u3() {
        PbFragment pbFragment;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048773, this) == null) && (pbFragment = this.c) != null && pbFragment.getActivity() != null) {
            if (this.z0.getWidth() != 0 && this.z0.getHeight() != 0) {
                WaterRippleView waterRippleView = this.x0;
                if (waterRippleView == null) {
                    this.x0 = new WaterRippleView(this.c.getActivity());
                } else {
                    ViewParent parent = waterRippleView.getParent();
                    if (parent instanceof ViewGroup) {
                        ((ViewGroup) parent).removeView(this.x0);
                    }
                }
                Rect rect = new Rect();
                this.d.getGlobalVisibleRect(rect);
                Rect rect2 = new Rect();
                this.z0.getImgAgree().getGlobalVisibleRect(rect2);
                int g2 = ej.g(this.c.getActivity(), R.dimen.tbds166);
                int i2 = ((rect2.right + rect2.left) / 2) - g2;
                int i3 = (rect.bottom - ((rect2.bottom + rect2.top) / 2)) - g2;
                int i4 = g2 * 2;
                RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(i4, i4);
                layoutParams.addRule(12, -1);
                layoutParams.setMargins(i2, 0, 0, i3);
                this.d.addView(this.x0, layoutParams);
                TextView textView = this.F0;
                if (textView != null) {
                    textView.setVisibility(4);
                    return;
                }
                return;
            }
            BdLog.e("AgreeView not measured");
        }
    }

    public SparseArray<Object> X0(u98 u98Var, int i2) {
        InterceptResult invokeLI;
        PostData W;
        boolean z2;
        xx4 xx4Var;
        int i3;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048668, this, u98Var, i2)) == null) {
            StringBuilder sb = null;
            if (u98Var == null || (W = u98Var.W()) == null) {
                return null;
            }
            String userId = W.r().getUserId();
            if (userId != null && userId.equals(TbadkCoreApplication.getCurrentAccount())) {
                z2 = true;
            } else {
                z2 = false;
            }
            SparseArray<Object> sparseArray = new SparseArray<>();
            if (i2 == 0) {
                sparseArray.put(R.id.tag_del_post_id, W.O());
                sparseArray.put(R.id.tag_del_post_type, 0);
                sparseArray.put(R.id.tag_del_post_is_self, Boolean.valueOf(z2));
                sparseArray.put(R.id.tag_manage_user_identity, Integer.valueOf(u98Var.V()));
                sparseArray.put(R.id.tag_should_manage_visible, Boolean.FALSE);
            } else if (i2 == 1) {
                if (W.r() != null) {
                    sparseArray.put(R.id.tag_forbid_user_name, W.r().getUserName());
                    sparseArray.put(R.id.tag_forbid_user_name_show, W.r().getName_show());
                    sparseArray.put(R.id.tag_forbid_user_portrait, W.r().getPortrait());
                    sparseArray.put(R.id.tag_forbid_user_post_id, W.O());
                }
                sparseArray.put(R.id.tag_del_post_id, W.O());
                sparseArray.put(R.id.tag_del_post_type, 0);
                sparseArray.put(R.id.tag_del_post_is_self, Boolean.valueOf(z2));
                sparseArray.put(R.id.tag_manage_user_identity, Integer.valueOf(u98Var.V()));
                sparseArray.put(R.id.tag_should_manage_visible, Boolean.TRUE);
            }
            if (!z2) {
                List<sz4> o2 = u98Var.o();
                if (ListUtils.getCount(o2) > 0) {
                    sb = new StringBuilder();
                    for (sz4 sz4Var : o2) {
                        if (sz4Var != null && !StringUtils.isNull(sz4Var.d()) && (xx4Var = sz4Var.f) != null && xx4Var.a && !xx4Var.c && ((i3 = xx4Var.b) == 1 || i3 == 2)) {
                            sb.append(dj.cutString(sz4Var.d(), 12));
                            sb.append(this.c.getString(R.string.obfuscated_res_0x7f0f06ad));
                            sb.append("、");
                        }
                    }
                }
                if (sb != null && !StringUtils.isNull(sb.toString())) {
                    sparseArray.put(R.id.tag_del_multi_forum, String.format(this.c.getString(R.string.obfuscated_res_0x7f0f04cd), sb.toString().substring(0, sb.length() - 1)));
                }
            }
            return sparseArray;
        }
        return (SparseArray) invokeLI.objValue;
    }

    public void a2(int i2) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeI(1048682, this, i2) != null) || this.O0 == i2) {
            return;
        }
        this.O0 = i2;
        Z3(this.L0, this.K0);
        E2(this.L0, i2);
        qv4 layoutMode = this.c.getBaseFragmentActivity().getLayoutMode();
        boolean z2 = true;
        if (i2 != 1) {
            z2 = false;
        }
        layoutMode.l(z2);
        this.c.getBaseFragmentActivity().getLayoutMode().k(this.d);
        SkinManager.setBackgroundColor(this.d, R.color.CAM_X0201);
        SkinManager.setBackgroundColor(this.o0, R.color.CAM_X0203);
        ie8 ie8Var = this.w;
        if (ie8Var != null) {
            ie8Var.c(i2);
        }
        he8 he8Var = this.t;
        if (he8Var != null) {
            he8Var.e();
        }
        je8 je8Var = this.u;
        if (je8Var != null) {
            je8Var.g();
        }
        le8 le8Var = this.v;
        if (le8Var != null) {
            le8Var.z(i2);
        }
        ke8 ke8Var = this.x;
        if (ke8Var != null) {
            ke8Var.e();
        }
        ge8 ge8Var = this.y;
        if (ge8Var != null) {
            ge8Var.c();
        }
        MaskView maskView = this.I1;
        if (maskView != null) {
            maskView.f();
        }
        od8 od8Var = this.r;
        if (od8Var != null) {
            od8Var.n();
        }
        PbContentCollectionController pbContentCollectionController = this.z;
        if (pbContentCollectionController != null) {
            pbContentCollectionController.c();
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
        j05 j05Var = this.F;
        if (j05Var != null) {
            j05Var.autoChangeSkinType(this.c.getPageContext());
        }
        e4(this.g0);
        this.E.Z();
        dh8 dh8Var = this.J;
        if (dh8Var != null) {
            dh8Var.H(i2);
        }
        EditorTools editorTools = this.m0;
        if (editorTools != null) {
            editorTools.y(i2);
        }
        zg8 zg8Var = this.L;
        if (zg8Var != null) {
            zg8Var.g();
        }
        if (!ListUtils.isEmpty(this.n)) {
            for (CustomBlueCheckRadioButton customBlueCheckRadioButton : this.n) {
                customBlueCheckRadioButton.c();
            }
        }
        k4();
        UtilHelper.setStatusBarBackground(this.e, i2);
        UtilHelper.setStatusBarBackground(this.W0, i2);
        if (this.A != null) {
            il5.a(this.c.getPageContext(), this.A);
        }
        nc8 nc8Var = this.g1;
        if (nc8Var != null) {
            nc8Var.l(i2);
        }
        qf8 qf8Var = this.h;
        if (qf8Var != null) {
            qf8Var.n(i2);
        }
        LinearLayout linearLayout = this.u0;
        if (linearLayout != null) {
            linearLayout.setBackgroundDrawable(SkinManager.createShapeDrawableFromColor(ej.g(this.c.getContext(), R.dimen.tbds47), SkinManager.getColor(R.color.CAM_X0209)));
        }
        u98 u98Var = this.L0;
        if (u98Var != null && u98Var.q()) {
            WebPManager.setPureDrawable(this.A0, R.drawable.icon_pure_pb_bottom_collected26_selection, R.color.CAM_X0305, WebPManager.ResourceStateType.NORMAL_PRESS);
        } else {
            WebPManager.setPureDrawable(this.A0, R.drawable.icon_pure_pb_bottom_collect26, R.color.CAM_X0107, WebPManager.ResourceStateType.NORMAL_PRESS);
        }
        WebPManager.setPureDrawable(this.y0, R.drawable.icon_pure_pb_bottom_comment26, R.color.CAM_X0107, WebPManager.ResourceStateType.NORMAL_PRESS);
        WebPManager.setPureDrawable(this.v0, R.drawable.icon_pure_post_expression24, R.color.CAM_X0107, WebPManager.ResourceStateType.NORMAL);
        i4(this.L0);
        if (this.D0.getVisibility() == 0) {
            this.D0.setBackgroundDrawable(SkinManager.createShapeDrawable(ej.g(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds15), R.color.CAM_X0301, 0, 0, i2));
        }
        SkinManager.setBackgroundColor(this.t0, R.color.CAM_X0207);
        SkinManager.setBackgroundColor(this.s0, R.color.CAM_X0203);
        SkinManager.setViewTextColor(this.p1, (int) R.color.cp_cont_n);
        SkinManager.setViewTextColor(this.w0, (int) R.color.CAM_X0109);
        SkinManager.setViewTextColor(this.G0, (int) R.color.CAM_X0107);
        SkinManager.setBackgroundShapeDrawable(this.G0, ej.g(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds18), R.color.CAM_X0207, R.color.CAM_X0207);
        SkinManager.setViewTextColor(this.F0, (int) R.color.CAM_X0107);
        SkinManager.setBackgroundShapeDrawable(this.F0, ej.g(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds18), R.color.CAM_X0207, R.color.CAM_X0207);
        AgreeView agreeView = this.z0;
        if (agreeView != null) {
            agreeView.w();
            this.z0.P(i2);
            AgreeData data = this.z0.getData();
            if (data != null) {
                B2(data, data.agreeNum);
            }
        }
        tb8 tb8Var = this.s1;
        if (tb8Var != null) {
            tb8Var.m(i2);
        }
        PbThreadPostView pbThreadPostView = this.o;
        if (pbThreadPostView != null) {
            pbThreadPostView.c(i2);
        }
        ch8 ch8Var = this.E0;
        if (ch8Var != null) {
            ch8Var.j();
        }
        bh8 bh8Var = this.H1;
        if (bh8Var != null) {
            bh8Var.c();
        }
        RightFloatLayerView rightFloatLayerView = this.K1;
        if (rightFloatLayerView != null) {
            rightFloatLayerView.n();
        }
        SkinManager.setBackgroundColor(this.V0, R.color.CAM_X0207);
        SkinManager.setViewTextColor(this.V0.findViewById(R.id.tv_title), (int) R.color.CAM_X0105);
    }

    public final boolean f0(AbsListView absListView, int i2) {
        InterceptResult invokeLI;
        boolean z2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048701, this, absListView, i2)) == null) {
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

    public void k3(boolean z2, PostWriteCallBackData postWriteCallBackData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZL(1048729, this, z2, postWriteCallBackData) == null) {
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
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048750, this, str, str2)) == null) {
            Activity pageActivity = this.c.getPageContext().getPageActivity();
            CustomBlueCheckRadioButton customBlueCheckRadioButton = new CustomBlueCheckRadioButton(pageActivity);
            RadioGroup.LayoutParams layoutParams = new RadioGroup.LayoutParams(-1, ej.g(pageActivity, R.dimen.obfuscated_res_0x7f07019a));
            customBlueCheckRadioButton.setOnCheckedChangeListener(this.Z);
            customBlueCheckRadioButton.setTag(str);
            customBlueCheckRadioButton.setText(str2);
            customBlueCheckRadioButton.setLayoutParams(layoutParams);
            return customBlueCheckRadioButton;
        }
        return (CustomBlueCheckRadioButton) invokeLL.objValue;
    }

    public void l2(AbsListView absListView, int i2, int i3) {
        PbReplyTitleViewHolder pbReplyTitleViewHolder;
        int bottom;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLII(1048733, this, absListView, i2, i3) == null) {
            qc8 qc8Var = this.q;
            if (qc8Var != null) {
                qc8Var.c(i2, i3);
            }
            nd8 nd8Var = this.s;
            if (nd8Var != null) {
                nd8Var.c(i2, i3);
            }
            qf8 qf8Var = this.h;
            if (qf8Var != null && this.v != null) {
                qf8Var.o();
            }
            x2();
            this.b1.a = null;
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004013, this.b1));
            y3(f0(absListView, i2));
            int i4 = 0;
            y2(this.b1.a, false);
            s0();
            if (this.K.p() && !this.K.A) {
                z0 z0Var = this.b1;
                if (z0Var != null && (pbReplyTitleViewHolder = z0Var.a) != null && pbReplyTitleViewHolder.getView() != null) {
                    if (this.b1.a.getView().getTop() < 0) {
                        bottom = this.b1.a.getView().getHeight();
                    } else {
                        bottom = this.b1.a.getView().getBottom();
                    }
                    i4 = bottom;
                }
                this.K.f(i4);
                this.K.A = true;
            }
        }
    }

    public void n2(ArrayList<fy4> arrayList) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048743, this, arrayList) == null) {
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
                attributes.width = ej.g(TbadkCoreApplication.getInst(), R.dimen.obfuscated_res_0x7f0702dc);
                this.W.getWindow().setAttributes(attributes);
                this.Z = new c0(this);
                this.Y = (LinearLayout) this.X.findViewById(R.id.good_class_group);
                TextView textView = (TextView) this.X.findViewById(R.id.dialog_button_cancel);
                this.b0 = textView;
                textView.setOnClickListener(new d0(this));
                TextView textView2 = (TextView) this.X.findViewById(R.id.dialog_button_ok);
                this.a0 = textView2;
                textView2.setOnClickListener(this.P);
            }
            this.Y.removeAllViews();
            this.n = new ArrayList();
            CustomBlueCheckRadioButton p02 = p0("0", this.c.getPageContext().getString(R.string.thread_good_class));
            this.n.add(p02);
            p02.setChecked(true);
            this.Y.addView(p02);
            if (arrayList != null) {
                for (int i2 = 0; i2 < arrayList.size(); i2++) {
                    fy4 fy4Var = arrayList.get(i2);
                    if (fy4Var != null && !TextUtils.isEmpty(fy4Var.b()) && fy4Var.a() > 0) {
                        CustomBlueCheckRadioButton p03 = p0(String.valueOf(fy4Var.a()), fy4Var.b());
                        this.n.add(p03);
                        View view2 = new View(this.c.getPageContext().getPageActivity());
                        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, ej.g(TbadkCoreApplication.getInst(), R.dimen.obfuscated_res_0x7f070198));
                        SkinManager.setBackgroundColor(view2, R.color.CAM_X0204);
                        view2.setLayoutParams(layoutParams);
                        this.Y.addView(view2);
                        this.Y.addView(p03);
                    }
                }
                ViewGroup.LayoutParams layoutParams2 = this.l0.getLayoutParams();
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

    public void o2(int i2, String str, int i3, boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048748, this, new Object[]{Integer.valueOf(i2), str, Integer.valueOf(i3), Boolean.valueOf(z2)}) == null) {
            p2(i2, str, i3, z2, null);
        }
    }

    public void p2(int i2, String str, int i3, boolean z2, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048752, this, new Object[]{Integer.valueOf(i2), str, Integer.valueOf(i3), Boolean.valueOf(z2), str2}) == null) {
            q2(i2, str, i3, z2, str2, false);
        }
    }

    public void q2(int i2, String str, int i3, boolean z2, String str2, boolean z3) {
        int i4;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048756, this, new Object[]{Integer.valueOf(i2), str, Integer.valueOf(i3), Boolean.valueOf(z2), str2, Boolean.valueOf(z3)}) == null) {
            SparseArray<Object> sparseArray = new SparseArray<>();
            sparseArray.put(R.id.tag_del_post_id, str);
            sparseArray.put(R.id.tag_del_post_type, Integer.valueOf(i2));
            sparseArray.put(R.id.tag_manage_user_identity, Integer.valueOf(i3));
            sparseArray.put(R.id.tag_del_post_is_self, Boolean.valueOf(z2));
            sparseArray.put(0, 3);
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
            this.U = new j05(this.c.getActivity());
            if (StringUtils.isNull(str2)) {
                this.U.setMessageId(i4);
            } else {
                this.U.setOnlyMessageShowCenter(false);
                this.U.setMessage(str2);
            }
            this.U.setYesButtonTag(sparseArray);
            this.U.setPositiveButton(R.string.obfuscated_res_0x7f0f051d, this.c);
            this.U.setNegativeButton(R.string.obfuscated_res_0x7f0f0515, new v(this));
            this.U.setCancelable(true);
            this.U.create(this.c.getPageContext());
            if (z3) {
                B3(sparseArray, i5, i4);
            } else if (z2) {
                B3(sparseArray, i5, i4);
            } else if (t3()) {
                vv5 vv5Var = new vv5(this.c.M().k1().k().getDeletedReasonInfo().is_grays_cale_forum.intValue(), this.c.M().k1().k().getDeletedReasonInfo().is_boomgrow.intValue(), this.c.M().k1().n().has_forum_rule.intValue());
                vv5Var.i(this.c.M().k1().k().getId(), this.c.M().k1().k().getName());
                vv5Var.h(this.c.M().k1().k().getImage_url());
                vv5Var.j(this.c.M().k1().k().getUser_level());
                I3(sparseArray, i2, vv5Var, this.c.M().k1().U(), false);
            } else {
                Q3(this.U, i2);
            }
        }
    }

    public void r2(int i2, String str, int i3, boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048760, this, new Object[]{Integer.valueOf(i2), str, Integer.valueOf(i3), Boolean.valueOf(z2)}) == null) {
            SparseArray<Object> sparseArray = new SparseArray<>();
            sparseArray.put(R.id.tag_del_post_id, str);
            sparseArray.put(R.id.tag_del_post_type, Integer.valueOf(i2));
            sparseArray.put(R.id.tag_manage_user_identity, Integer.valueOf(i3));
            sparseArray.put(R.id.tag_del_post_is_self, Boolean.valueOf(z2));
            sparseArray.put(0, 3);
            if (z2) {
                w3(sparseArray);
            } else {
                x3(i2, sparseArray);
            }
        }
    }

    public void s2(SparseArray<Object> sparseArray, boolean z2) {
        int i2;
        q05 q05Var;
        q05 q05Var2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048764, this, sparseArray, z2) == null) {
            u05 u05Var = new u05(this.c.getContext());
            u05Var.s(this.c.getString(R.string.obfuscated_res_0x7f0f02f1));
            u05Var.p(new u(this, z2));
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
                    q05Var2 = new q05(10, this.c.getString(R.string.obfuscated_res_0x7f0f04e2), u05Var);
                } else {
                    q05Var2 = new q05(10, this.c.getString(R.string.obfuscated_res_0x7f0f04d5), u05Var);
                }
                SparseArray sparseArray2 = new SparseArray();
                sparseArray2.put(R.id.tag_del_post_id, sparseArray.get(R.id.tag_del_post_id));
                sparseArray2.put(R.id.tag_del_post_type, sparseArray.get(R.id.tag_del_post_type));
                sparseArray2.put(R.id.tag_del_post_is_self, sparseArray.get(R.id.tag_del_post_is_self));
                sparseArray2.put(R.id.tag_manage_user_identity, sparseArray.get(R.id.tag_manage_user_identity));
                q05Var2.d.setTag(sparseArray2);
                arrayList.add(q05Var2);
            }
            if ((sparseArray.get(R.id.tag_mul_del_post_type) instanceof Boolean) && ((Boolean) sparseArray.get(R.id.tag_mul_del_post_type)).booleanValue()) {
                q05 q05Var3 = new q05(13, this.c.getString(R.string.multi_delete), u05Var);
                SparseArray sparseArray3 = new SparseArray();
                sparseArray3.put(R.id.tag_del_post_id, sparseArray.get(R.id.tag_del_post_id));
                sparseArray3.put(R.id.tag_del_post_type, sparseArray.get(R.id.tag_del_post_type));
                sparseArray3.put(R.id.tag_del_post_is_self, sparseArray.get(R.id.tag_del_post_is_self));
                sparseArray3.put(R.id.tag_manage_user_identity, sparseArray.get(R.id.tag_manage_user_identity));
                q05Var3.d.setTag(sparseArray3);
                arrayList.add(q05Var3);
            }
            if (!"".equals(sparseArray.get(R.id.tag_forbid_user_name)) || !"".equals(sparseArray.get(R.id.tag_forbid_user_name_show))) {
                SparseArray sparseArray4 = new SparseArray();
                sparseArray4.put(R.id.tag_forbid_user_name, sparseArray.get(R.id.tag_forbid_user_name));
                sparseArray4.put(R.id.tag_forbid_user_name_show, sparseArray.get(R.id.tag_forbid_user_name_show));
                sparseArray4.put(R.id.tag_forbid_user_portrait, sparseArray.get(R.id.tag_forbid_user_portrait));
                sparseArray4.put(R.id.tag_manage_user_identity, sparseArray.get(R.id.tag_manage_user_identity));
                sparseArray4.put(R.id.tag_forbid_user_post_id, sparseArray.get(R.id.tag_forbid_user_post_id));
                q05 q05Var4 = new q05(11, this.c.getString(R.string.forbidden_person), u05Var);
                q05Var4.d.setTag(sparseArray4);
                arrayList.add(q05Var4);
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
                    q05Var = new q05(12, this.c.getString(R.string.un_mute), u05Var);
                } else {
                    q05Var = new q05(12, this.c.getString(R.string.obfuscated_res_0x7f0f0bdc), u05Var);
                }
                q05Var.d.setTag(sparseArray5);
                arrayList.add(q05Var);
            }
            jf8.f(arrayList);
            if (UbsABTestHelper.isPBPlanA()) {
                u05Var.l(arrayList, false);
            } else {
                u05Var.l(arrayList, true);
            }
            s05 s05Var = new s05(this.c.getPageContext(), u05Var);
            this.S = s05Var;
            s05Var.k();
        }
    }

    public final void y2(PbReplyTitleViewHolder pbReplyTitleViewHolder, boolean z2) {
        boolean z3;
        int measuredHeight;
        int i2;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLZ(1048788, this, pbReplyTitleViewHolder, z2) == null) && !this.j1 && this.U0 != null && this.h.i() != null) {
            View s2 = G0().s();
            if (s2 != null) {
                int[] iArr = new int[2];
                s2.getLocationInWindow(iArr);
                int i3 = iArr[1];
                if (i3 != 0) {
                    if (this.U0.getVisibility() == 0 && i3 - this.h.i().getBottom() <= this.U0.getHeight()) {
                        this.V0.setVisibility(0);
                        if (i3 > this.h.i().getBottom()) {
                            i2 = -(((this.U0.getHeight() + this.V0.getHeight()) + this.h.i().getBottom()) - s2.getBottom());
                        } else {
                            i2 = -this.U0.getHeight();
                        }
                        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.U0.getLayoutParams();
                        if (layoutParams.topMargin != i2) {
                            layoutParams.topMargin = i2;
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
                y3(false);
                this.h.a.hideBottomLine();
                if (this.U0.getParent() != null && ((ViewGroup) this.U0.getParent()).getHeight() <= this.U0.getTop()) {
                    this.U0.getParent().requestLayout();
                }
            } else if (pbReplyTitleViewHolder != null && pbReplyTitleViewHolder.getView() != null && pbReplyTitleViewHolder.f != null) {
                int top = pbReplyTitleViewHolder.getView().getTop();
                if (pbReplyTitleViewHolder.getView().getParent() != null) {
                    if (this.a1) {
                        this.Z0 = top;
                        this.a1 = false;
                    }
                    int i4 = this.Z0;
                    if (top < i4) {
                        i4 = top;
                    }
                    this.Z0 = i4;
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
                    measuredHeight = a2 - pbReplyTitleViewHolder.f.getMeasuredHeight();
                } else {
                    measuredHeight = this.h.i().getMeasuredHeight() - pbReplyTitleViewHolder.f.getMeasuredHeight();
                    this.h.a.hideBottomLine();
                }
                if (pbReplyTitleViewHolder.getView().getParent() == null && top <= this.Z0) {
                    this.U0.setVisibility(0);
                    y3(false);
                } else if (top < measuredHeight) {
                    this.U0.setVisibility(0);
                    y3(false);
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
