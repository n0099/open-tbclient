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
import com.baidu.card.view.CardForumHeadLayout;
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
import com.baidu.tbadk.core.data.ForumData;
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
import com.baidu.tieba.c55;
import com.baidu.tieba.e55;
import com.baidu.tieba.m46;
import com.baidu.tieba.m69;
import com.baidu.tieba.n55;
import com.baidu.tieba.p46;
import com.baidu.tieba.p89;
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
import com.baidu.tieba.q29;
import com.baidu.tieba.q49;
import com.baidu.tieba.q79;
import com.baidu.tieba.tbadkCore.data.AgreeData;
import com.baidu.tieba.tbadkCore.util.AntiHelper;
import com.baidu.tieba.tbadkCore.writeModel.PostWriteCallBackData;
import com.baidu.tieba.u69;
import com.baidu.tieba.ux9;
import com.baidu.tieba.view.NavigationBarCoverTip;
import com.baidu.tieba.view.SortSwitchButton;
import com.baidu.tieba.view.WaterRippleView;
import com.baidu.tieba.w95;
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
/* loaded from: classes8.dex */
public class v79 {
    public static /* synthetic */ Interceptable $ic;
    public static final int h2;
    public static int i2;
    public static int j2;
    public static int k2;
    public static int l2;
    public static int m2;
    public static int n2;
    public static final int o2;
    public static int p2;
    public static ux9.f q2;
    public transient /* synthetic */ FieldHolder $fh;
    public t89 A;
    public LinearLayout A0;
    public boolean A1;
    public p89 B;
    public ImageView B0;
    public f79 B1;
    public PbContentCollectionController C;
    public TextView C0;
    public NavigationBarCoverTip C1;
    public m69 D;
    public WaterRippleView D0;
    public m46 D1;
    public l69 E;
    public ImageView E0;
    public p46 E1;
    public LinearLayout F;
    public AgreeView F0;
    public String F1;
    public TextView G;
    public ImageView G0;
    public PermissionJudgePolicy G1;
    public TextView H;
    public ImageView H0;
    public boolean H1;
    public ObservedChangeRelativeLayout I;
    public HeadImageView I0;
    public int I1;
    public d69 J;
    public View J0;
    public int J1;
    public c55 K;
    public sb9 K0;
    public boolean K1;
    public e55 L;
    public TextView L0;
    public boolean L1;
    public View M;
    public TextView M0;
    public rb9 M1;
    public EditText N;
    public boolean N0;
    public MaskView N1;
    public tb9 O;
    public int O0;
    public final PbFallingView O1;
    public PbListView P;
    public q95 P0;
    public RightFloatLayerView P1;
    public ob9 Q;
    public boolean Q0;
    public final FrameLayout Q1;
    public View R;
    public m39 R0;
    public LinearLayout R1;
    public View S;
    public jy9 S0;
    public t99 S1;

    /* renamed from: T  reason: collision with root package name */
    public View f1173T;
    public int T0;
    public CustomMessageListener T1;
    public View.OnClickListener U;
    public int U0;
    public View.OnClickListener U1;
    public SortSwitchButton.f V;
    public boolean V0;
    public CustomMessageListener V1;
    public TbRichTextView.a0 W;
    public ViewStub W0;
    public Handler W1;
    public NoNetworkView.b X;
    public PbInterviewStatusView X0;
    public Runnable X1;
    public l55 Y;
    public TextView Y0;
    public CustomMessageListener Y1;
    public View.OnClickListener Z;
    public View Z0;
    public PbFragment.g3 Z1;
    public final ViewTreeObserver.OnGlobalLayoutListener a;
    public c55 a0;
    public View a1;
    public boolean a2;
    public CardForumHeadLayout b;
    public Dialog b0;
    public View b1;
    public View.OnClickListener b2;
    public int c;
    public Dialog c0;
    public PbReplyTitleViewHolder c1;
    public String c2;
    public boolean d;
    public View d0;
    public View d1;
    public w95.g d2;
    public int e;
    public LinearLayout e0;
    public int e1;
    public View.OnClickListener e2;
    public PbFragment f;
    public CompoundButton.OnCheckedChangeListener f0;
    public boolean f1;
    public final List<TbImageView> f2;
    public RelativeLayout g;
    public TextView g0;
    public b1 g1;
    public boolean g2;
    public View h;
    public TextView h0;
    public int h1;
    public int i;
    public String i0;
    public int i1;
    public final Handler j;
    public l55 j0;
    public Runnable j1;
    public final ga9 k;
    public l55 k0;
    public PbFakeFloorModel k1;
    public fa9 l;
    public g55 l0;
    public r69 l1;
    public ViewStub m;
    public boolean m0;
    public boolean m1;
    public ViewStub n;
    public boolean n0;
    public int n1;
    public PbLandscapeListView o;
    public String o0;
    public boolean o1;
    public NoNetworkView p;
    public String p0;
    public boolean p1;
    public List<CustomBlueCheckRadioButton> q;
    public s49 q0;
    public boolean q1;
    public PbThreadPostView r;
    public ScrollView r0;
    public int r1;
    public v69 s;
    public EditorTools s0;
    public PbTopTipView s1;
    public u69 t;
    public boolean t0;
    public PopupWindow t1;
    public r79 u;
    public View u0;
    public TextView u1;
    public q79 v;
    public View v0;
    public List<String> v1;
    public q89 w;
    public EjectionAnimationView w0;
    public y89 w1;
    public s89 x;
    public Button x0;
    public q59 x1;
    public u89 y;
    public View y0;
    public PbLandscapeListView.c y1;
    public r89 z;
    public View z0;
    public boolean z1;

    public int J0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048612, this)) == null) ? R.id.obfuscated_res_0x7f091a01 : invokeV.intValue;
    }

    public boolean V1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048661, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    public int n1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048740, this)) == null) ? R.id.obfuscated_res_0x7f091e4e : invokeV.intValue;
    }

    public boolean n2(int i3) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048741, this, i3)) == null) {
            return false;
        }
        return invokeI.booleanValue;
    }

    /* loaded from: classes8.dex */
    public class b implements AgreeView.i {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ v79 a;

        /* loaded from: classes8.dex */
        public class a implements rh5 {
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

            @Override // com.baidu.tieba.rh5
            public void a(List<Bitmap> list) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, list) == null) {
                    this.a.a.w0.setVisibility(0);
                    this.a.a.w0.setBitmaps(list);
                    Rect rect = new Rect();
                    this.a.a.F0.getImgAgree().getGlobalVisibleRect(rect);
                    this.a.a.w0.setAnchorPosition((rect.right + rect.left) / 2, (rect.bottom + rect.top) / 2);
                    this.a.a.w0.k();
                }
            }
        }

        public b(v79 v79Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {v79Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = v79Var;
        }

        @Override // com.baidu.tbadk.core.view.AgreeView.i
        public void onLongPress() {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeV(1048576, this) != null) {
                return;
            }
            this.a.F3();
            th5.g().c(new a(this));
        }

        @Override // com.baidu.tbadk.core.view.AgreeView.i
        public void onRelease() {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) != null) {
                return;
            }
            this.a.R2();
            this.a.w0.l();
        }
    }

    /* loaded from: classes8.dex */
    public class i implements u69.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ v79 a;

        /* loaded from: classes8.dex */
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
                if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && this.a.a.s != null) {
                    this.a.a.s.p();
                }
            }
        }

        public i(v79 v79Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {v79Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = v79Var;
        }

        @Override // com.baidu.tieba.u69.a
        public void a() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && this.a.o != null) {
                this.a.o.post(new a(this));
            }
        }
    }

    /* loaded from: classes8.dex */
    public class j implements q79.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ v79 a;

        /* loaded from: classes8.dex */
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
                if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && this.a.a.u != null && this.a.a.f.V() != null) {
                    t55.g(Collections.singletonList(new s79(this.a.a.f.V(), this.a.a.u)));
                }
            }
        }

        public j(v79 v79Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {v79Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = v79Var;
        }

        @Override // com.baidu.tieba.q79.a
        public void a() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && !this.a.f.y6() && this.a.o != null) {
                this.a.o.post(new a(this));
            }
        }
    }

    /* loaded from: classes8.dex */
    public class l implements PbLandscapeListView.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ int a;
        public final /* synthetic */ PbReplyTitleViewHolder b;
        public final /* synthetic */ boolean c;
        public final /* synthetic */ int d;
        public final /* synthetic */ int e;
        public final /* synthetic */ int f;
        public final /* synthetic */ v79 g;

        /* loaded from: classes8.dex */
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
                if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && this.a.g.d1 != null && this.a.g.d1.getLayoutParams() != null) {
                    ViewGroup.LayoutParams layoutParams = this.a.g.d1.getLayoutParams();
                    layoutParams.height = this.a.g.i1;
                    this.a.g.d1.setLayoutParams(layoutParams);
                }
            }
        }

        public l(v79 v79Var, int i, PbReplyTitleViewHolder pbReplyTitleViewHolder, boolean z, int i2, int i3, int i4) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {v79Var, Integer.valueOf(i), pbReplyTitleViewHolder, Boolean.valueOf(z), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i5 = newInitContext.flag;
                if ((i5 & 1) != 0) {
                    int i6 = i5 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.g = v79Var;
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
                if (i2 >= 0 && i2 <= this.g.g.getMeasuredHeight()) {
                    int m1 = this.g.m1(this.b);
                    int i3 = this.a;
                    int i4 = m1 - i3;
                    if (this.c && i4 != 0 && i3 <= (i = this.d)) {
                        i4 = m1 - i;
                    }
                    if (this.g.d1 == null || (layoutParams = this.g.d1.getLayoutParams()) == null) {
                        return;
                    }
                    if (i4 != 0 && i4 <= this.g.g.getMeasuredHeight() && m1 < this.g.g.getMeasuredHeight()) {
                        if (layoutParams != null) {
                            int i5 = layoutParams.height;
                            if (i5 + i4 > 0 && i5 + i4 <= this.g.g.getMeasuredHeight()) {
                                layoutParams.height += i4;
                                if (this.g.o != null) {
                                    this.g.o.setSelectionFromTop(this.e, this.f);
                                }
                            }
                        }
                        layoutParams.height = this.g.i1;
                    } else {
                        layoutParams.height = this.g.i1;
                    }
                    this.g.d1.setLayoutParams(layoutParams);
                    wg.a().post(new a(this));
                }
                if (this.g.o != null) {
                    this.g.o.setOnLayoutListener(null);
                }
            }
        }
    }

    /* loaded from: classes8.dex */
    public class m implements m69.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ v79 a;

        /* loaded from: classes8.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ int a;
            public final /* synthetic */ m b;

            public a(m mVar, int i) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {mVar, Integer.valueOf(i)};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.b = mVar;
                this.a = i;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && this.b.a.E != null && this.b.a.f.V() != null) {
                    this.b.a.E.q(this.a);
                    t55.g(Collections.singletonList(new n69(this.b.a.f.V(), this.b.a.E)));
                }
            }
        }

        public m(v79 v79Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {v79Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = v79Var;
        }

        @Override // com.baidu.tieba.m69.b
        public void a(int i) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeI(1048576, this, i) == null) && !this.a.f.y6() && !this.a.d && this.a.o != null) {
                this.a.o.post(new a(this, i));
            }
        }
    }

    /* loaded from: classes8.dex */
    public class q0 implements DialogInterface.OnCancelListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ v79 a;

        /* loaded from: classes8.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ q0 a;

            public a(q0 q0Var) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {q0Var};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = q0Var;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable != null && interceptable.invokeV(1048576, this) != null) {
                    return;
                }
                this.a.a.f.HidenSoftKeyPad((InputMethodManager) this.a.a.f.getBaseFragmentActivity().getSystemService("input_method"), this.a.a.g);
            }
        }

        public q0(v79 v79Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {v79Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = v79Var;
        }

        @Override // android.content.DialogInterface.OnCancelListener
        public void onCancel(DialogInterface dialogInterface) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, dialogInterface) == null) {
                if (this.a.j1 == null) {
                    this.a.j1 = new a(this);
                }
                wg.a().postDelayed(this.a.j1, 150L);
            }
        }
    }

    /* loaded from: classes8.dex */
    public class a implements m49 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ v79 a;

        @Override // com.baidu.tieba.m49
        public /* synthetic */ void onStart() {
            l49.a(this);
        }

        public a(v79 v79Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {v79Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = v79Var;
        }

        @Override // com.baidu.tieba.m49
        public void onStop() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                this.a.w0.setVisibility(8);
                FirstPraiseToast.getInstance().show();
            }
        }
    }

    /* loaded from: classes8.dex */
    public class a0 implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ AlertDialog a;
        public final /* synthetic */ SparseArray b;
        public final /* synthetic */ v79 c;

        public a0(v79 v79Var, AlertDialog alertDialog, SparseArray sparseArray) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {v79Var, alertDialog, sparseArray};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = v79Var;
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
                    vi.P(this.c.f.V(), R.string.obfuscated_res_0x7f0f0def);
                } else {
                    this.c.f.l5(this.b, null);
                }
            }
        }
    }

    /* loaded from: classes8.dex */
    public class a1 implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ v79 a;

        public a1(v79 v79Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {v79Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = v79Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                this.a.s2();
            }
        }
    }

    /* loaded from: classes8.dex */
    public class b0 implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ AlertDialog a;

        public b0(v79 v79Var, AlertDialog alertDialog) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {v79Var, alertDialog};
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

    /* loaded from: classes8.dex */
    public static class b1 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public PbReplyTitleViewHolder a;
        public BdUniqueId b;

        public b1() {
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

    /* loaded from: classes8.dex */
    public class c implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ v79 a;

        public c(v79 v79Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {v79Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = v79Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, view2) == null) && this.a.F0 != null && this.a.F0.getData() != null) {
                v79 v79Var = this.a;
                v79Var.L2(v79Var.F0.getData(), this.a.F0.getData().agreeNum);
                if (!this.a.F0.J()) {
                    v79 v79Var2 = this.a;
                    v79Var2.E2(v79Var2.F0);
                }
                if (this.a.R0 != null && this.a.R0.N() != null && this.a.R0.N().isExcellentThread() && BreatheTipWidget.f()) {
                    sf5.a("c15279", this.a.R0.P(), this.a.R0.l(), "1");
                }
            }
        }
    }

    /* loaded from: classes8.dex */
    public class c0 implements m46.h {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ c55 a;
        public final /* synthetic */ v79 b;

        public c0(v79 v79Var, c55 c55Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {v79Var, c55Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = v79Var;
            this.a = c55Var;
        }

        @Override // com.baidu.tieba.m46.h
        public void a(JSONArray jSONArray) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, jSONArray) == null) {
                this.b.f.m5(this.a, jSONArray);
            }
        }
    }

    /* loaded from: classes8.dex */
    public class d implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ v79 a;

        public d(v79 v79Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {v79Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = v79Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                if (this.a.J0.getVisibility() == 0) {
                    if (this.a.f != null && this.a.f.H1()) {
                        return;
                    }
                    n95.m().w("pb_share_red_dot_shown", true);
                    this.a.J0.setVisibility(8);
                }
                this.a.U.onClick(view2);
            }
        }
    }

    /* loaded from: classes8.dex */
    public class d0 implements p46.i {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ SparseArray a;
        public final /* synthetic */ v79 b;

        public d0(v79 v79Var, SparseArray sparseArray) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {v79Var, sparseArray};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = v79Var;
            this.a = sparseArray;
        }

        @Override // com.baidu.tieba.p46.i
        public void a(JSONArray jSONArray) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, jSONArray) == null) {
                this.b.f.l5(this.a, jSONArray);
            }
        }
    }

    /* loaded from: classes8.dex */
    public class e implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ v79 a;

        public e(v79 v79Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {v79Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = v79Var;
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
                    this.a.f.c5(sparseArray);
                    return;
                }
                this.a.D2(view2);
            } else if (z2) {
                sparseArray.put(R.id.tag_from, 0);
                sparseArray.put(R.id.tag_check_mute_from, 1);
                this.a.f.c5(sparseArray);
            } else if (z3) {
                this.a.y2(((Integer) sparseArray.get(R.id.tag_del_post_type)).intValue(), (String) sparseArray.get(R.id.tag_del_post_id), ((Integer) sparseArray.get(R.id.tag_manage_user_identity)).intValue(), ((Boolean) sparseArray.get(R.id.tag_del_post_is_self)).booleanValue());
            }
        }
    }

    /* loaded from: classes8.dex */
    public class e0 implements CompoundButton.OnCheckedChangeListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ v79 a;

        public e0(v79 v79Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {v79Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = v79Var;
        }

        @Override // android.widget.CompoundButton.OnCheckedChangeListener
        public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLZ(1048576, this, compoundButton, z) == null) && z) {
                this.a.i0 = (String) compoundButton.getTag();
                if (this.a.q != null) {
                    for (CustomBlueCheckRadioButton customBlueCheckRadioButton : this.a.q) {
                        String str = (String) customBlueCheckRadioButton.getTag();
                        if (str != null && this.a.i0 != null && !str.equals(this.a.i0)) {
                            customBlueCheckRadioButton.setChecked(false);
                        }
                    }
                }
            }
        }
    }

    /* loaded from: classes8.dex */
    public class f implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ v79 a;

        public f(v79 v79Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {v79Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = v79Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                this.a.U2();
            }
        }
    }

    /* loaded from: classes8.dex */
    public class f0 implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ v79 a;

        public f0(v79 v79Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {v79Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = v79Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, view2) == null) && (this.a.c0 instanceof Dialog)) {
                yg.b(this.a.c0, this.a.f.getPageContext());
            }
        }
    }

    /* loaded from: classes8.dex */
    public class g implements PbFakeFloorModel.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ v79 a;

        public g(v79 v79Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {v79Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = v79Var;
        }

        @Override // com.baidu.tieba.pb.pb.main.view.PbFakeFloorModel.b
        public void a(jy9 jy9Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, jy9Var) == null) {
                this.a.k1.l0(jy9Var);
                this.a.J.f0();
                this.a.l1.g();
                this.a.s0.s();
                this.a.K3(false);
            }
        }
    }

    /* loaded from: classes8.dex */
    public static class g0 implements ux9.f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        @Override // com.baidu.tieba.ux9.f
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

    /* loaded from: classes8.dex */
    public class h implements PbFallingView.r {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ v79 a;

        public h(v79 v79Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {v79Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = v79Var;
        }

        @Override // com.baidu.tieba.pb.view.PbFallingView.r
        public void onAnimationEnd() {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeV(1048576, this) != null) {
                return;
            }
            this.a.e4();
        }

        @Override // com.baidu.tieba.pb.view.PbFallingView.r
        public void onAnimationStart() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                this.a.O1.setTag(Boolean.FALSE);
                if (this.a.P1 == null) {
                    return;
                }
                this.a.P1.setAutoCompleteShown(false);
                if (this.a.P1.getVisibility() == 0) {
                    this.a.P1.setTag(this.a.O1);
                    this.a.P1.c();
                }
            }
        }
    }

    /* loaded from: classes8.dex */
    public class h0 implements n55.f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ e55.c a;
        public final /* synthetic */ v79 b;

        public h0(v79 v79Var, e55.c cVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {v79Var, cVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = v79Var;
            this.a = cVar;
        }

        @Override // com.baidu.tieba.n55.f
        public void M0(n55 n55Var, int i, View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIL(1048576, this, n55Var, i, view2) == null) {
                this.b.k0.dismiss();
                this.a.a(null, i, view2);
            }
        }
    }

    /* loaded from: classes8.dex */
    public class i0 implements n55.f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ e55.c a;
        public final /* synthetic */ v79 b;

        public i0(v79 v79Var, e55.c cVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {v79Var, cVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = v79Var;
            this.a = cVar;
        }

        @Override // com.baidu.tieba.n55.f
        public void M0(n55 n55Var, int i, View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIL(1048576, this, n55Var, i, view2) == null) {
                this.b.k0.dismiss();
                this.a.a(null, i, view2);
            }
        }
    }

    /* loaded from: classes8.dex */
    public class j0 implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ v79 a;

        public j0(v79 v79Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {v79Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = v79Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            long j;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                if ((view2 instanceof HeadImageView) && this.a.R0 != null && this.a.R0.N() != null && this.a.R0.N().getAuthor() != null && this.a.R0.N().getAuthor().getAlaInfo() != null && this.a.R0.N().getAuthor().getAlaInfo().live_status == 1) {
                    StatisticItem statisticItem = new StatisticItem("c11851");
                    statisticItem.param("uid", TbadkCoreApplication.getCurrentAccount());
                    TiebaStatic.log(statisticItem);
                    StatisticItem statisticItem2 = new StatisticItem("c13715");
                    statisticItem2.param("fid", this.a.R0.l());
                    statisticItem2.param("fname", this.a.R0.m());
                    if (this.a.R0.N().getAuthor().getAlaInfo().user_info != null) {
                        j = this.a.R0.N().getAuthor().getAlaInfo().user_info.user_id;
                    } else {
                        j = 0;
                    }
                    statisticItem2.param("obj_param1", j);
                    statisticItem2.param("uid", TbadkCoreApplication.getCurrentAccount());
                    statisticItem2.param("tid", this.a.R0.P());
                    statisticItem2.param(TiebaStatic.Params.OBJ_PARAM2, 1);
                    statisticItem2.param(TiebaStatic.Params.OBJ_PARAM4, YYLiveUtil.calculateLiveType(this.a.R0.N().getAuthor().getAlaInfo()));
                    if (this.a.R0.N().getAuthor().getAlaInfo().mYyExtData != null) {
                        statisticItem2.param(TiebaStatic.Params.OBJ_PARAM3, TiebaStatic.YYValues.YY_LIVE);
                        TiebaStaticHelper.addYYParam(statisticItem2, this.a.R0.N().getAuthor().getAlaInfo().mYyExtData);
                    }
                    TiebaStatic.log(statisticItem2);
                    if (this.a.R0.N().getAuthor().getAlaInfo().isLegalYYLiveData()) {
                        YYLiveUtil.jumpYYLiveRoom(this.a.f.getPageContext(), this.a.R0.N().getAuthor().getAlaInfo(), YYLiveUtil.SOURCE_PB_LIVE_HEAD);
                        return;
                    }
                    return;
                }
                if (this.a.o1) {
                    TiebaStatic.log(new StatisticItem("c11923").param("obj_id", 2));
                }
                if (!this.a.o1 && this.a.R0 != null && this.a.R0.N() != null && this.a.R0.N().getAuthor() != null && this.a.R0.N().getAuthor().isBigV()) {
                    TiebaStatic.log(new StatisticItem("c12151").param("obj_locate", 1));
                }
                if (this.a.f.V() != null) {
                    this.a.f.V().c.b.onClick(view2);
                }
            }
        }
    }

    /* loaded from: classes8.dex */
    public class k extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ v79 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public k(v79 v79Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {v79Var, Integer.valueOf(i)};
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
            this.a = v79Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && customResponsedMessage.getCmd() == 2921757) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004013, this.a.g1));
            }
        }
    }

    /* loaded from: classes8.dex */
    public class k0 implements p89.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ v79 a;

        public k0(v79 v79Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {v79Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = v79Var;
        }

        @Override // com.baidu.tieba.p89.a
        public void a(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
                if (z) {
                    this.a.B.a(this.a.o);
                } else {
                    this.a.B.d(this.a.o);
                }
            }
        }
    }

    /* loaded from: classes8.dex */
    public class l0 implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ v79 a;

        public l0(v79 v79Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {v79Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = v79Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            v79 v79Var;
            ga9 ga9Var;
            LinearLayout linearLayout;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && this.a.J != null && (ga9Var = (v79Var = this.a).k) != null && ga9Var.k != null && v79Var.R0 != null && this.a.R0.N() != null && !this.a.R0.N().isVideoThreadType() && !this.a.a2() && this.a.R0.k() != null && !ui.isEmpty(this.a.R0.k().getName())) {
                if ((this.a.J.L() == null || !this.a.J.L().isShown()) && (linearLayout = this.a.k.k) != null) {
                    linearLayout.setVisibility(0);
                    this.a.k.h();
                }
            }
        }
    }

    /* loaded from: classes8.dex */
    public class m0 implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;
        public final /* synthetic */ v79 b;

        public m0(v79 v79Var, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {v79Var, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = v79Var;
            this.a = str;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                if (vi.F()) {
                    UrlManager.getInstance().dealOneLink(this.b.f.getPageContext(), new String[]{this.a});
                    this.b.f.finish();
                    return;
                }
                this.b.f.showToast(R.string.obfuscated_res_0x7f0f0def);
            }
        }
    }

    /* loaded from: classes8.dex */
    public class n implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ v79 a;

        public n(v79 v79Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {v79Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = v79Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                if (this.a.J0.getVisibility() == 0) {
                    n95.m().w("pb_share_red_dot_shown", true);
                    this.a.J0.setVisibility(8);
                }
                this.a.U.onClick(this.a.H0);
            }
        }
    }

    /* loaded from: classes8.dex */
    public class n0 implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ Parcelable a;
        public final /* synthetic */ ArrayList b;
        public final /* synthetic */ m39 c;
        public final /* synthetic */ v79 d;

        public n0(v79 v79Var, Parcelable parcelable, ArrayList arrayList, m39 m39Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {v79Var, parcelable, arrayList, m39Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.d = v79Var;
            this.a = parcelable;
            this.b = arrayList;
            this.c = m39Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (this.d.o != null) {
                    this.d.o.onRestoreInstanceState(this.a);
                }
                if (this.d.P != null && ListUtils.getCount(this.b) > 1 && this.c.y().b() > 0) {
                    this.d.P.g();
                    this.d.P.H(TbadkApplication.getInst().getString(R.string.obfuscated_res_0x7f0f0fa9));
                    this.d.P.B();
                }
            }
        }
    }

    /* loaded from: classes8.dex */
    public class o implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public o(v79 v79Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {v79Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                TiebaStatic.log(new StatisticItem("c15305").param("uid", TbadkCoreApplication.getCurrentAccountId()));
            }
        }
    }

    /* loaded from: classes8.dex */
    public class o0 implements PbLandscapeListView.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ v79 a;

        public o0(v79 v79Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {v79Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = v79Var;
        }

        @Override // com.baidu.tieba.pb.pb.main.PbLandscapeListView.c
        public void a(int i, int i2, float f, float f2, float f3, float f4) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Integer.valueOf(i), Integer.valueOf(i2), Float.valueOf(f), Float.valueOf(f2), Float.valueOf(f3), Float.valueOf(f4)}) == null) && this.a.f != null && this.a.f.isAdded()) {
                if (i < 0 && f > this.a.r1) {
                    this.a.v0();
                    this.a.o2();
                }
                this.a.D0();
            }
        }
    }

    /* loaded from: classes8.dex */
    public class p implements q29.d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ v79 a;

        public p(v79 v79Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {v79Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = v79Var;
        }

        @Override // com.baidu.tieba.q29.d
        public void onFinish() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.F0.W();
            }
        }
    }

    /* loaded from: classes8.dex */
    public class p0 implements c55.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ v79 a;

        public p0(v79 v79Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {v79Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = v79Var;
        }

        @Override // com.baidu.tieba.c55.e
        public void onClick(c55 c55Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, c55Var) == null) {
                this.a.v0();
                c55Var.dismiss();
            }
        }
    }

    /* loaded from: classes8.dex */
    public class q extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ v79 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public q(v79 v79Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {v79Var, Integer.valueOf(i)};
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
            this.a = v79Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && customResponsedMessage.getCmd() == 2005016 && this.a.J != null) {
                this.a.J.f0();
            }
        }
    }

    /* loaded from: classes8.dex */
    public class r implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ v79 a;

        public r(v79 v79Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {v79Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = v79Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (this.a.F == null) {
                    this.a.J1();
                }
                this.a.n.setVisibility(0);
            }
        }
    }

    /* loaded from: classes8.dex */
    public class r0 implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ lc5 a;
        public final /* synthetic */ v79 b;

        public r0(v79 v79Var, lc5 lc5Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {v79Var, lc5Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = v79Var;
            this.a = lc5Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, view2) == null) && this.a != null && this.b.R0 != null && this.b.P1 != null) {
                this.b.P1.g(this.a);
                this.b.P1.setAutoCompleteShown(false);
            }
        }
    }

    /* loaded from: classes8.dex */
    public class s extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ v79 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public s(v79 v79Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {v79Var, Integer.valueOf(i)};
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
            this.a = v79Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(1048576, this, customResponsedMessage) != null) || customResponsedMessage == null) {
                return;
            }
            this.a.N0 = false;
        }
    }

    /* loaded from: classes8.dex */
    public class s0 implements c55.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public s0(v79 v79Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {v79Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // com.baidu.tieba.c55.e
        public void onClick(c55 c55Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, c55Var) == null) {
                c55Var.dismiss();
            }
        }
    }

    /* loaded from: classes8.dex */
    public class t implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ v79 a;

        public t(v79 v79Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {v79Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = v79Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                this.a.U2();
            }
        }
    }

    /* loaded from: classes8.dex */
    public class t0 implements c55.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public t0(v79 v79Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {v79Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // com.baidu.tieba.c55.e
        public void onClick(c55 c55Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, c55Var) == null) {
                c55Var.dismiss();
            }
        }
    }

    /* loaded from: classes8.dex */
    public class u implements vh5 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ v79 a;

        public u(v79 v79Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {v79Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = v79Var;
        }

        @Override // com.baidu.tieba.vh5
        public void C(uh5 uh5Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, uh5Var) == null) {
                Object obj = uh5Var.c;
                if ((obj instanceof cd5) && EmotionGroupType.isSendAsPic(((cd5) obj).getType())) {
                    if (this.a.G1 == null) {
                        this.a.G1 = new PermissionJudgePolicy();
                    }
                    this.a.G1.clearRequestPermissionList();
                    this.a.G1.appendRequestPermission(this.a.f.getBaseFragmentActivity(), "android.permission.WRITE_EXTERNAL_STORAGE");
                    if (this.a.G1.startRequestPermission(this.a.f.getBaseFragmentActivity())) {
                        return;
                    }
                    cd5 cd5Var = (cd5) uh5Var.c;
                    this.a.f.I5().f(cd5Var);
                    if (cd5Var.i()) {
                        this.a.f.I5().H(null, null);
                    } else {
                        this.a.f.I5().w(false, null);
                    }
                }
            }
        }
    }

    /* loaded from: classes8.dex */
    public class u0 implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ int a;
        public final /* synthetic */ int b;
        public final /* synthetic */ int c;
        public final /* synthetic */ View d;
        public final /* synthetic */ v79 e;

        public u0(v79 v79Var, int i, int i2, int i3, View view2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {v79Var, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), view2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i4 = newInitContext.flag;
                if ((i4 & 1) != 0) {
                    int i5 = i4 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.e = v79Var;
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
                    this.e.t1.showAsDropDown(this.e.z0, this.d.getLeft(), -this.e.z0.getHeight());
                }
            }
        }
    }

    /* loaded from: classes8.dex */
    public class v implements TextWatcher {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ v79 a;

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIII(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, charSequence, i, i2, i3) == null) {
            }
        }

        public v(v79 v79Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {v79Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = v79Var;
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, editable) == null) && this.a.f.L0 != null && this.a.f.L0.e() != null) {
                if (!this.a.f.L0.e().e()) {
                    this.a.f.L0.a(false);
                }
                this.a.f.L0.e().l(false);
            }
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            int i4;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLIII(Constants.METHOD_SEND_USER_MSG, this, charSequence, i, i2, i3) == null) && this.a.s0 != null && this.a.s0.getVisibility() == 0 && charSequence != null && charSequence.length() >= (i4 = i3 + i)) {
                String substring = charSequence.toString().substring(i, i4);
                if (TextUtils.isEmpty(substring)) {
                    return;
                }
                if (this.a.w1 == null) {
                    RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
                    layoutParams.addRule(11);
                    layoutParams.addRule(2, this.a.s0.getId());
                    v79 v79Var = this.a;
                    v79Var.w1 = new y89(v79Var.f.getPageContext(), this.a.g, layoutParams);
                    if (!ListUtils.isEmpty(this.a.v1)) {
                        this.a.w1.q(this.a.v1);
                    }
                    this.a.w1.r(this.a.s0);
                }
                this.a.w1.p(substring);
            }
        }
    }

    /* loaded from: classes8.dex */
    public class v0 implements PbFallingView.q {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ v79 a;

        public v0(v79 v79Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {v79Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = v79Var;
        }

        @Override // com.baidu.tieba.pb.view.PbFallingView.q
        public void onClick() {
            String l1;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (this.a.f != null && this.a.f.Q() != null && this.a.f.Q().h2()) {
                    l1 = this.a.f.getString(R.string.pb_reply_hint_from_smart_frs);
                } else {
                    l1 = this.a.l1();
                }
                if (!StringUtils.isNull(l1) && this.a.R0 != null) {
                    l1 = TbSingleton.getInstance().getAdVertiComment(this.a.R0.p0(), this.a.R0.q0(), l1);
                }
                if (this.a.f != null && this.a.f.I5() != null) {
                    this.a.f.I5().d0(l1);
                }
                if (this.a.C0 != null) {
                    this.a.C0.setText(l1);
                }
                this.a.K3(false);
                this.a.e4();
            }
        }
    }

    /* loaded from: classes8.dex */
    public class w implements n55.f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ boolean a;
        public final /* synthetic */ v79 b;

        public w(v79 v79Var, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {v79Var, Boolean.valueOf(z)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = v79Var;
            this.a = z;
        }

        @Override // com.baidu.tieba.n55.f
        public void M0(n55 n55Var, int i, View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIL(1048576, this, n55Var, i, view2) == null) {
                this.b.Y.dismiss();
                SparseArray<Object> sparseArray = (SparseArray) view2.getTag();
                if (sparseArray == null) {
                    return;
                }
                switch (i) {
                    case 10:
                        this.b.y2(((Integer) sparseArray.get(R.id.tag_del_post_type)).intValue(), (String) sparseArray.get(R.id.tag_del_post_id), ((Integer) sparseArray.get(R.id.tag_manage_user_identity)).intValue(), ((Boolean) sparseArray.get(R.id.tag_del_post_is_self)).booleanValue());
                        return;
                    case 11:
                        if (this.b.Z1 != null) {
                            this.b.Z1.callback(new Object[]{sparseArray.get(R.id.tag_manage_user_identity), sparseArray.get(R.id.tag_forbid_user_name), sparseArray.get(R.id.tag_forbid_user_post_id), sparseArray.get(R.id.tag_forbid_user_name_show), sparseArray.get(R.id.tag_forbid_user_portrait)});
                            return;
                        }
                        return;
                    case 12:
                        this.b.f.R5(this.a, (String) sparseArray.get(R.id.tag_user_mute_mute_userid), sparseArray);
                        return;
                    case 13:
                        this.b.x4(true);
                        return;
                    default:
                        return;
                }
            }
        }
    }

    /* loaded from: classes8.dex */
    public class w0 implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ lc5 a;
        public final /* synthetic */ v79 b;

        public w0(v79 v79Var, lc5 lc5Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {v79Var, lc5Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = v79Var;
            this.a = lc5Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921664));
                this.b.P1.setHomePbFloatLastCloseTime();
                this.b.B1();
                this.b.P1.t(this.a);
            }
        }
    }

    /* loaded from: classes8.dex */
    public class x implements c55.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public x(v79 v79Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {v79Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // com.baidu.tieba.c55.e
        public void onClick(c55 c55Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, c55Var) == null) {
                c55Var.dismiss();
            }
        }
    }

    /* loaded from: classes8.dex */
    public class x0 implements ViewTreeObserver.OnGlobalLayoutListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PbFragment a;
        public final /* synthetic */ v79 b;

        public x0(v79 v79Var, PbFragment pbFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {v79Var, pbFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = v79Var;
            this.a = pbFragment;
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (!this.b.K1 && this.a != null && this.b.f.Q() != null && this.b.f.Q().l2()) {
                    this.b.K1 = true;
                    this.a.a5(false);
                }
                if (this.b.L1) {
                    return;
                }
                this.b.L1 = true;
                if (this.b.X1() && this.b.C != null) {
                    this.b.C.h();
                    this.b.C.g(true);
                }
            }
        }
    }

    /* loaded from: classes8.dex */
    public class y implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ AlertDialog a;
        public final /* synthetic */ SparseArray b;
        public final /* synthetic */ v79 c;

        public y(v79 v79Var, AlertDialog alertDialog, SparseArray sparseArray) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {v79Var, alertDialog, sparseArray};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = v79Var;
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
                    vi.P(this.c.f.V(), R.string.obfuscated_res_0x7f0f0def);
                } else {
                    this.c.f.l5(this.b, null);
                }
            }
        }
    }

    /* loaded from: classes8.dex */
    public class y0 implements q49.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ v79 a;

        public y0(v79 v79Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {v79Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = v79Var;
        }

        @Override // com.baidu.tieba.q49.b
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.f.U5();
            }
        }

        @Override // com.baidu.tieba.q49.b
        public void b() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) && this.a.o != null) {
                this.a.o.setSelection(0);
            }
        }
    }

    /* loaded from: classes8.dex */
    public class z implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ AlertDialog a;

        public z(v79 v79Var, AlertDialog alertDialog) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {v79Var, alertDialog};
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

    /* loaded from: classes8.dex */
    public class z0 implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ReplyPrivacyCheckController a;
        public final /* synthetic */ yj5 b;
        public final /* synthetic */ v79 c;

        public z0(v79 v79Var, ReplyPrivacyCheckController replyPrivacyCheckController, yj5 yj5Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {v79Var, replyPrivacyCheckController, yj5Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = v79Var;
            this.a = replyPrivacyCheckController;
            this.b = yj5Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                if (this.a != null && this.c.f != null && this.c.f.s5() != null && !this.a.checkPrivacyBeforeInvokeEditor(this.c.f.s5().replyPrivateFlag)) {
                    return;
                }
                TiebaStatic.log(new StatisticItem(CommonStatisticKey.KEY_RD_USE).param("obj_param1", 3).param("obj_locate", 1).param("obj_type", 1).param("obj_source", UtilHelper.getCurrentPageName(TbadkCoreApplication.getInst().getCurrentActivity())));
                if (!DialogLoginHelper.checkUpIsLogin(new LoginDialogData(this.c.f.getActivity(), LoginDialogData.PB_BOTTOM_REPLY_RESULT_PAGE))) {
                    TiebaStatic.log(new StatisticItem(CommonStatisticKey.KEY_RD_USE).param("obj_param1", 3).param("obj_locate", 2).param("obj_type", 1).param("obj_source", UtilHelper.getCurrentPageName(TbadkCoreApplication.getInst().getCurrentActivity())));
                    return;
                }
                this.c.t4();
                this.b.o0();
                this.c.A0();
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948193841, "Lcom/baidu/tieba/v79;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948193841, "Lcom/baidu/tieba/v79;");
                return;
            }
        }
        h2 = UtilHelper.getLightStatusBarHeight();
        i2 = 3;
        j2 = 0;
        k2 = 3;
        l2 = 4;
        m2 = 5;
        n2 = 6;
        o2 = vi.g(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds80);
        p2 = 1;
        q2 = new g0();
    }

    public jy9 O0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048632, this)) == null) {
            if (this.o == null) {
                return null;
            }
            int N0 = N0() - this.o.getHeaderViewsCount();
            int i3 = 0;
            if (N0 < 0) {
                N0 = 0;
            }
            if (this.J.A(N0) != null && this.J.A(N0) != jy9.R0) {
                i3 = N0 + 1;
            }
            if (!(this.J.z(i3) instanceof jy9)) {
                return null;
            }
            return (jy9) this.J.z(i3);
        }
        return (jy9) invokeV.objValue;
    }

    public final int Q0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048640, this)) == null) {
            PbLandscapeListView pbLandscapeListView = this.o;
            if (pbLandscapeListView != null && pbLandscapeListView.getData() != null) {
                for (int i3 = 0; i3 < this.o.getData().size(); i3++) {
                    vn vnVar = this.o.getData().get(i3);
                    if (vnVar != null && vnVar.getType() == o39.k) {
                        return i3 + this.o.getHeaderViewsCount();
                    }
                }
            }
            return 0;
        }
        return invokeV.intValue;
    }

    public void W2() {
        PbListView pbListView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048666, this) == null) && (pbListView = this.P) != null && pbListView.i() != null) {
            LinearLayout i3 = this.P.i();
            View findViewById = i3.findViewById(R.id.obfuscated_res_0x7f0919f4);
            if (i3.getVisibility() == 0 && findViewById != null && findViewById.getVisibility() == 0) {
                this.d = true;
                TiebaStatic.log(new StatisticItem("c15304").param("uid", TbadkCoreApplication.getCurrentAccountId()));
            }
        }
    }

    public final boolean X1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048669, this)) == null) {
            if (D3()) {
                for (int firstVisiblePosition = this.o.getFirstVisiblePosition(); firstVisiblePosition <= this.o.getLastVisiblePosition(); firstVisiblePosition++) {
                    View childAt = this.o.getListView2().getChildAt(firstVisiblePosition);
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

    public void a4() {
        jy9 jy9Var;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048684, this) != null) || !TbadkCoreApplication.isLogin() || this.R0 == null || !this.p1 || this.o1 || this.n0 || (jy9Var = this.S0) == null || jy9Var.p() == null || this.S0.p().getIsLike() || this.S0.p().hadConcerned()) {
        }
    }

    public final void n0() {
        PbContentCollectionController pbContentCollectionController;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048739, this) == null) {
            if (D3() && this.R0 != null) {
                new StatisticItem(CommonStatisticKey.KEY_PB_PAGE_CONTENT_COLLECTION_SHOW).addParam("tid", this.R0.N().getTid()).addParam("obj_param1", this.R0.N().getThreadRecommendInfoDataList().get(0).businessId).eventStat();
            }
            if (X1() && (pbContentCollectionController = this.C) != null) {
                pbContentCollectionController.h();
                this.C.g(true);
            }
        }
    }

    public void q2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048756, this) == null) {
            p4();
            this.J.g0(1);
            v69 v69Var = this.s;
            if (v69Var != null) {
                v69Var.k();
            }
            r79 r79Var = this.u;
            if (r79Var != null) {
                r79Var.j();
            }
            l69 l69Var = this.E;
            if (l69Var != null) {
                l69Var.g();
            }
            m69 m69Var = this.D;
            if (m69Var != null) {
                m69Var.i();
            }
            RightFloatLayerView rightFloatLayerView = this.P1;
            if (rightFloatLayerView != null && (rightFloatLayerView instanceof RightFloatLayerLottieView)) {
                ((RightFloatLayerLottieView) rightFloatLayerView).G(600);
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016524));
        }
    }

    public v79(PbFragment pbFragment, View.OnClickListener onClickListener, s49 s49Var, SortSwitchButton.f fVar) {
        int i3;
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {pbFragment, onClickListener, s49Var, fVar};
            interceptable.invokeUnInit(65537, newInitContext);
            int i4 = newInitContext.flag;
            if ((i4 & 1) != 0) {
                int i5 = i4 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.c = -1;
        this.d = false;
        this.f = null;
        this.g = null;
        this.h = null;
        this.i = 0;
        this.j = new Handler();
        this.o = null;
        this.J = null;
        this.K = null;
        this.L = null;
        this.M = null;
        this.N = null;
        this.O = null;
        this.P = null;
        this.Q = null;
        this.R = null;
        this.S = null;
        this.U = null;
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
        this.i0 = null;
        this.j0 = null;
        this.k0 = null;
        this.l0 = null;
        this.m0 = false;
        this.n0 = false;
        this.o0 = null;
        this.p0 = null;
        this.r0 = null;
        this.t0 = false;
        this.x0 = null;
        this.z0 = null;
        this.C0 = null;
        this.N0 = true;
        this.P0 = null;
        this.Q0 = false;
        this.U0 = 3;
        this.V0 = false;
        this.W0 = null;
        this.e1 = 0;
        this.f1 = true;
        this.g1 = new b1();
        this.h1 = 0;
        this.m1 = false;
        this.n1 = 0;
        this.o1 = false;
        this.p1 = false;
        this.q1 = false;
        this.r1 = 0;
        this.z1 = false;
        this.A1 = false;
        this.J1 = 0;
        this.T1 = new k(this, 2921757);
        this.U1 = new n(this);
        this.V1 = new q(this, 2005016);
        this.W1 = new Handler();
        this.Y1 = new s(this, 2004009);
        this.a2 = true;
        this.b2 = new j0(this);
        this.c2 = null;
        this.f2 = new ArrayList();
        this.g2 = false;
        this.f = pbFragment;
        this.g1.b = pbFragment.getPageContext().getUniqueId();
        this.U = onClickListener;
        this.V = fVar;
        this.q0 = s49Var;
        this.r1 = vi.l(this.f.getContext()) / 8;
        RelativeLayout relativeLayout = (RelativeLayout) LayoutInflater.from(this.f.getPageContext().getPageActivity()).inflate(R.layout.obfuscated_res_0x7f0d06d0, (ViewGroup) null);
        this.g = relativeLayout;
        relativeLayout.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        this.u0 = this.g.findViewById(R.id.obfuscated_res_0x7f09046d);
        this.C1 = (NavigationBarCoverTip) this.g.findViewById(R.id.obfuscated_res_0x7f091a6c);
        this.h = this.g.findViewById(R.id.obfuscated_res_0x7f0921f6);
        this.Q1 = (FrameLayout) this.g.findViewById(R.id.obfuscated_res_0x7f091e72);
        this.I = (ObservedChangeRelativeLayout) this.g.findViewById(R.id.obfuscated_res_0x7f0924d9);
        this.p = (NoNetworkView) this.g.findViewById(R.id.view_no_network);
        PbLandscapeListView pbLandscapeListView = (PbLandscapeListView) this.g.findViewById(R.id.obfuscated_res_0x7f09189d);
        this.o = pbLandscapeListView;
        pbLandscapeListView.setDividerHeight(0);
        this.Y0 = new TextView(this.f.getActivity());
        AbsListView.LayoutParams layoutParams = new AbsListView.LayoutParams(-1, UtilHelper.getLightStatusBarHeight() + vi.g(this.f.getActivity(), R.dimen.obfuscated_res_0x7f07041a));
        this.o.setOverScrollMode(2);
        this.o.w(this.Y0, 0);
        this.o.setTextViewAdded(true);
        this.i1 = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds134);
        this.d1 = new View(this.f.getPageContext().getPageActivity());
        if (d36.a()) {
            this.d1.setLayoutParams(new AbsListView.LayoutParams(-1, 0));
        } else {
            this.d1.setLayoutParams(new AbsListView.LayoutParams(-1, this.i1));
        }
        MessageManager.getInstance().registerListener(this.T1);
        this.d1.setVisibility(4);
        this.o.addFooterView(this.d1);
        this.o.setOnTouchListener(this.f.J2);
        this.a = new x0(this, pbFragment);
        this.o.getViewTreeObserver().addOnGlobalLayoutListener(this.a);
        this.k = new ga9(pbFragment, this.g);
        if (this.f.B5()) {
            ViewStub viewStub = (ViewStub) this.g.findViewById(R.id.obfuscated_res_0x7f09168c);
            this.m = viewStub;
            viewStub.setVisibility(0);
            fa9 fa9Var = new fa9(pbFragment);
            this.l = fa9Var;
            fa9Var.c();
            this.k.a.setVisibility(8);
            layoutParams.height = vi.g(this.f.getActivity(), R.dimen.obfuscated_res_0x7f07035e);
        }
        this.Y0.setLayoutParams(layoutParams);
        this.k.j().setOnTouchListener(new q49(new y0(this)));
        this.y0 = this.g.findViewById(R.id.obfuscated_res_0x7f092872);
        this.z0 = this.g.findViewById(R.id.obfuscated_res_0x7f091a04);
        this.O0 = vi.g(TbadkCoreApplication.getInst(), R.dimen.obfuscated_res_0x7f07039c);
        this.B0 = (ImageView) this.g.findViewById(R.id.obfuscated_res_0x7f09097b);
        this.B0.setOnClickListener(new z0(this, new ReplyPrivacyCheckController(this.f.getPageContext()), this.f.I5()));
        B0();
        this.C0 = (TextView) this.g.findViewById(R.id.obfuscated_res_0x7f091a07);
        LinearLayout linearLayout = (LinearLayout) this.g.findViewById(R.id.obfuscated_res_0x7f0919ff);
        this.A0 = linearLayout;
        linearLayout.setOnClickListener(new a1(this));
        EjectionAnimationView ejectionAnimationView = (EjectionAnimationView) this.g.findViewById(R.id.obfuscated_res_0x7f09097f);
        this.w0 = ejectionAnimationView;
        ejectionAnimationView.setEjectionAnimationViewCallback(new a(this));
        this.E0 = (ImageView) this.g.findViewById(R.id.obfuscated_res_0x7f091a05);
        this.N1 = (MaskView) this.g.findViewById(R.id.mask_view);
        this.E0.setOnClickListener(this.U);
        AgreeView agreeView = (AgreeView) this.g.findViewById(R.id.obfuscated_res_0x7f091a01);
        this.F0 = agreeView;
        agreeView.setAgreeAlone(true);
        this.F0.w();
        this.F0.setAgreeLongClickListener(new b(this));
        this.F0.setAfterClickListener(new c(this));
        this.F0.setUseDynamicLikeRes("/pb");
        if (this.F0.getAgreeNumView() != null) {
            this.F0.getAgreeNumView().setVisibility(8);
        }
        if (this.F0.getMsgData() != null) {
            this.F0.getMsgData().a = BdUniqueId.gen();
        }
        boolean booleanExtra = this.f.getBaseFragmentActivity().getIntent().getBooleanExtra("key_is_from_dynamic", false);
        ImageView imageView = (ImageView) this.g.findViewById(R.id.obfuscated_res_0x7f091a03);
        this.G0 = imageView;
        imageView.setOnClickListener(this.U);
        if (booleanExtra) {
            this.G0.setVisibility(8);
        } else {
            this.G0.setVisibility(0);
        }
        View findViewById = this.g.findViewById(R.id.obfuscated_res_0x7f091a0a);
        this.J0 = findViewById;
        if (!n95.m().i("pb_share_red_dot_shown", false) && TbadkCoreApplication.isLogin()) {
            i3 = 0;
        } else {
            i3 = 8;
        }
        findViewById.setVisibility(i3);
        this.H0 = (ImageView) this.g.findViewById(R.id.obfuscated_res_0x7f091a08);
        HeadImageView headImageView = (HeadImageView) this.g.findViewById(R.id.obfuscated_res_0x7f091a09);
        this.I0 = headImageView;
        headImageView.setIsRound(true);
        this.I0.setOnClickListener(this.U1);
        this.H0.setOnClickListener(new d(this));
        g2();
        sb9 sb9Var = new sb9(this.H0);
        this.K0 = sb9Var;
        sb9Var.n(this.I0);
        if (!UbsABTestHelper.isResizeInduceSharingABTest() && !UbsABTestHelper.isResizeInduceSharingABTestA()) {
            this.K0.f();
        }
        TextView textView = (TextView) this.g.findViewById(R.id.obfuscated_res_0x7f091a06);
        this.M0 = textView;
        textView.setVisibility(0);
        this.L0 = (TextView) this.g.findViewById(R.id.obfuscated_res_0x7f091a02);
        this.W0 = (ViewStub) this.g.findViewById(R.id.obfuscated_res_0x7f09113e);
        this.F0.setVisibility(0);
        this.L0.setVisibility(0);
        this.w = new q89(this.f, s49Var);
        this.y = new u89(this.f, s49Var, this.U);
        d69 d69Var = new d69(this.f, this.o);
        this.J = d69Var;
        d69Var.E0(this.U);
        this.J.G0(this.q0);
        this.J.B0(this.W);
        this.J.D0(this.V);
        this.J.x0(this.e2);
        e eVar = new e(this);
        this.Z = eVar;
        this.J.z0(eVar);
        O1();
        H1();
        t89 t89Var = new t89(this.f);
        this.A = t89Var;
        t89Var.f = 2;
        G1();
        E1();
        this.B.a(this.o);
        this.y.q(this.o);
        this.x.a(this.o);
        this.C.a(this.o);
        this.w.a(this.o);
        PbListView pbListView = new PbListView(this.f.getPageContext().getPageActivity());
        this.P = pbListView;
        this.R = pbListView.c().findViewById(R.id.pb_more_view);
        this.S = this.P.c().findViewById(R.id.pb_check_more);
        if (!this.P.k().booleanValue()) {
            this.S.setVisibility(8);
        }
        View view2 = this.R;
        if (view2 != null) {
            view2.setOnClickListener(this.U);
            SkinManager.setBackgroundResource(this.R, R.drawable.pb_foot_more_trans_selector);
        }
        View view3 = this.S;
        if (view3 != null) {
            view3.setOnClickListener(this.U);
        }
        this.P.D();
        this.P.r(R.drawable.pb_foot_more_trans_selector);
        this.P.F(R.color.CAM_X0109);
        this.P.s(R.drawable.pb_foot_more_trans_selector);
        this.f1173T = this.g.findViewById(R.id.obfuscated_res_0x7f0928aa);
        this.f.registerListener(this.Y1);
        this.k1 = new PbFakeFloorModel(this.f.getPageContext());
        PbModel Q = this.f.Q();
        this.k1.n0(Q.d0(), Q.Z(), Q.a0(), Q.Y(), Q.e0());
        r69 r69Var = new r69(this.f.getPageContext(), this.k1, this.g);
        this.l1 = r69Var;
        r69Var.p(new f(this));
        this.l1.s(this.f.m2);
        this.k1.p0(new g(this));
        if (this.f.Q() != null && !StringUtils.isNull(this.f.Q().B1())) {
            PbFragment pbFragment2 = this.f;
            pbFragment2.showToast(pbFragment2.Q().B1());
        }
        this.Z0 = this.g.findViewById(R.id.obfuscated_res_0x7f091a0c);
        this.a1 = this.g.findViewById(R.id.obfuscated_res_0x7f09046b);
        View findViewById2 = this.g.findViewById(R.id.obfuscated_res_0x7f092202);
        this.b1 = findViewById2;
        LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) findViewById2.getLayoutParams();
        if (this.f.Q() != null && this.f.Q().k1()) {
            this.Z0.setVisibility(0);
            if (layoutParams2 != null) {
                layoutParams2.height = 0;
                this.b1.setLayoutParams(layoutParams2);
            }
        } else if (layoutParams2 != null) {
            layoutParams2.height = h2;
            this.b1.setLayoutParams(layoutParams2);
        }
        PbReplyTitleViewHolder pbReplyTitleViewHolder = new PbReplyTitleViewHolder(this.f.getPageContext(), this.g.findViewById(R.id.obfuscated_res_0x7f091a8b));
        this.c1 = pbReplyTitleViewHolder;
        pbReplyTitleViewHolder.s(pbFragment.d0);
        this.c1.g.setVisibility(8);
        this.c1.r(this.U);
        this.c1.q(this.V);
        this.f.registerListener(this.V1);
        PbFragment pbFragment3 = this.f;
        this.M1 = new rb9(pbFragment3, pbFragment3.getUniqueId());
        this.O1 = (PbFallingView) this.g.findViewById(R.id.obfuscated_res_0x7f090ac5);
        a3();
        this.O1.setAnimationListener(new h(this));
        q0();
        this.v0 = this.g.findViewById(R.id.obfuscated_res_0x7f0919f5);
        p0(d36.a());
        if (UbsABTestHelper.isPbForumGuideTestA() && Q.p2() && r29.b().e()) {
            if (this.s == null) {
                this.s = new v69(this.f.getActivity(), (ViewGroup) s1().findViewById(R.id.obfuscated_res_0x7f091a31));
            }
            u69 u69Var = new u69(this.o);
            this.t = u69Var;
            u69Var.d(new i(this));
        }
        this.u = new r79(this.f.V(), (ViewGroup) s1().findViewById(R.id.obfuscated_res_0x7f091a9e));
        q79 q79Var = new q79(this.o);
        this.v = q79Var;
        q79Var.d(new j(this));
        this.R1 = (LinearLayout) this.g.findViewById(R.id.obfuscated_res_0x7f092737);
        this.S1 = new t99(this.f.getActivity());
        L1();
    }

    public void B3(int i3) {
        PbLandscapeListView pbLandscapeListView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(1048583, this, i3) == null) && (pbLandscapeListView = this.o) != null) {
            pbLandscapeListView.setSelection(i3);
        }
    }

    public void C3(List<String> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, list) == null) {
            this.v1 = list;
            y89 y89Var = this.w1;
            if (y89Var != null) {
                y89Var.q(list);
            }
        }
    }

    public void D2(View view2) {
        SparseArray<Object> sparseArray;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048590, this, view2) != null) || (sparseArray = (SparseArray) view2.getTag()) == null) {
            return;
        }
        C2(sparseArray, false);
    }

    public void J3(boolean z2) {
        int i3;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048615, this, z2) == null) {
            View view2 = this.u0;
            if (z2) {
                i3 = 0;
            } else {
                i3 = 8;
            }
            view2.setVisibility(i3);
        }
    }

    public final boolean S1(m39 m39Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048649, this, m39Var)) == null) {
            return u79.x(m39Var);
        }
        return invokeL.booleanValue;
    }

    public void Y2(String str) {
        PbListView pbListView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048674, this, str) == null) && (pbListView = this.P) != null) {
            pbListView.H(str);
        }
    }

    public void b3(PbFragment.g3 g3Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048687, this, g3Var) == null) {
            this.Z1 = g3Var;
        }
    }

    public void c3(boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048691, this, z2) == null) {
            this.t0 = z2;
        }
    }

    public void d3(boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048695, this, z2) == null) {
            this.J.o0(z2);
        }
    }

    public final int e1(boolean z2) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048697, this, z2)) == null) {
            PbInterviewStatusView pbInterviewStatusView = this.X0;
            if (pbInterviewStatusView == null || pbInterviewStatusView.getVisibility() != 0 || !z2) {
                return 0;
            }
            return 0 + vi.g(TbadkCoreApplication.getInst(), R.dimen.obfuscated_res_0x7f07026a);
        }
        return invokeZ.intValue;
    }

    public void e3(boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048699, this, z2) == null) {
            this.H1 = z2;
        }
    }

    public void f3(boolean z2) {
        d69 d69Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048703, this, z2) == null) && (d69Var = this.J) != null) {
            d69Var.p0(z2);
        }
    }

    public void g3(boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048707, this, z2) == null) {
            this.z1 = z2;
        }
    }

    public void h3(boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048712, this, z2) == null) {
            this.J.r0(z2);
        }
    }

    public void i3(boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048717, this, z2) == null) {
            this.J.w0(z2);
        }
    }

    public final void i4(jy9 jy9Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048718, this, jy9Var) == null) && jy9Var != null) {
            this.A1 = !StringUtils.isNull(jy9Var.b0());
            u89 u89Var = this.y;
            if (u89Var != null) {
                u89Var.t(jy9Var);
            }
        }
    }

    public boolean j0(boolean z2) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048719, this, z2)) == null) {
            EditorTools editorTools = this.s0;
            if (editorTools != null && editorTools.w()) {
                this.s0.s();
                return true;
            }
            return false;
        }
        return invokeZ.booleanValue;
    }

    public void j3(w95.g gVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048722, this, gVar) == null) {
            this.d2 = gVar;
            tb9 tb9Var = this.O;
            if (tb9Var != null) {
                tb9Var.f(gVar);
            }
        }
    }

    public void k3(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048727, this, onClickListener) == null) {
            this.e2 = onClickListener;
            d69 d69Var = this.J;
            if (d69Var != null) {
                d69Var.x0(onClickListener);
            }
        }
    }

    public void l3(String str) {
        fa9 fa9Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048732, this, str) == null) && (fa9Var = this.l) != null) {
            fa9Var.b(str);
        }
    }

    public void l4(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048733, this, str) == null) {
            this.f.showToast(str);
        }
    }

    public void m3(boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048737, this, z2) == null) {
            this.m1 = z2;
            PbLandscapeListView pbLandscapeListView = this.o;
            if (pbLandscapeListView != null) {
                this.n1 = pbLandscapeListView.getHeaderViewsCount();
            }
        }
    }

    public void n3(TbRichTextView.a0 a0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048742, this, a0Var) == null) {
            this.W = a0Var;
            this.J.B0(a0Var);
            this.x1.q(this.W);
        }
    }

    public void o3(NoNetworkView.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048747, this, bVar) == null) {
            this.X = bVar;
            NoNetworkView noNetworkView = this.p;
            if (noNetworkView != null) {
                noNetworkView.a(bVar);
            }
        }
    }

    public void p3(BdListView.p pVar) {
        PbLandscapeListView pbLandscapeListView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048752, this, pVar) == null) && (pbLandscapeListView = this.o) != null) {
            pbLandscapeListView.setOnSrollToBottomListener(pVar);
        }
    }

    public void q3(AbsListView.OnScrollListener onScrollListener) {
        PbLandscapeListView pbLandscapeListView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048757, this, onScrollListener) == null) && (pbLandscapeListView = this.o) != null) {
            pbLandscapeListView.setOnScrollListener(onScrollListener);
        }
    }

    public void q4(boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048758, this, z2) == null) {
            this.m0 = z2;
        }
    }

    public void r2(yn ynVar) {
        PbLandscapeListView pbLandscapeListView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048761, this, ynVar) == null) && (pbLandscapeListView = this.o) != null) {
            pbLandscapeListView.b0 = ynVar;
            pbLandscapeListView.W = true;
        }
    }

    public void r3(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048762, this, onClickListener) == null) {
            this.J.F0(onClickListener);
        }
    }

    public void s3(int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048767, this, i3) == null) {
            this.I1 = i3;
        }
    }

    public void t3(View.OnLongClickListener onLongClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048772, this, onLongClickListener) == null) {
            this.y.I(onLongClickListener);
            this.J.C0(onLongClickListener);
            q59 q59Var = this.x1;
            if (q59Var != null) {
                q59Var.r(onLongClickListener);
            }
        }
    }

    public void y4(m39 m39Var) {
        q89 q89Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048798, this, m39Var) == null) && (q89Var = this.w) != null) {
            q89Var.h(m39Var, this.Q0);
        }
    }

    public void z3(boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048802, this, z2) == null) {
            this.y.K(z2);
        }
    }

    public void G2(lg5 lg5Var, int i3) {
        PbFallingView pbFallingView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLI(1048602, this, lg5Var, i3) == null) && (pbFallingView = this.O1) != null) {
            pbFallingView.A(lg5Var, this.f.getPageContext(), i3, false);
        }
    }

    @SuppressLint({"CutPasteId"})
    public void k4(m39 m39Var, boolean z2) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLZ(1048728, this, m39Var, z2) != null) || m39Var == null) {
            return;
        }
        v4(m39Var, z2);
        y0();
    }

    public final void u3(jy9 jy9Var, m39 m39Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048777, this, jy9Var, m39Var) == null) {
            this.y.J(jy9Var, m39Var);
        }
    }

    public void A0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            StatisticItem statisticItem = new StatisticItem("c14693");
            statisticItem.param("uid", TbadkCoreApplication.getCurrentAccountId());
            statisticItem.param("obj_locate", p2);
            TiebaStatic.log(statisticItem);
        }
    }

    public void A1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.f1173T.setVisibility(8);
        }
    }

    public void B0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            StatisticItem statisticItem = new StatisticItem("c14692");
            statisticItem.param("uid", TbadkCoreApplication.getCurrentAccountId());
            statisticItem.param("obj_locate", p2);
            TiebaStatic.log(statisticItem);
        }
    }

    public void B1() {
        RightFloatLayerView rightFloatLayerView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048581, this) == null) && (rightFloatLayerView = this.P1) != null) {
            rightFloatLayerView.c();
        }
    }

    public void C0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            PbListView pbListView = this.P;
            if (pbListView != null) {
                pbListView.B();
                this.P.g();
            }
            y1();
        }
    }

    public void C1() {
        EditorTools editorTools;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048585, this) == null) && (editorTools = this.s0) != null) {
            editorTools.s();
        }
    }

    public void D0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            PbLandscapeListView pbLandscapeListView = this.o;
            if (pbLandscapeListView != null) {
                pbLandscapeListView.z(0L);
            }
            y0();
        }
    }

    public void D1() {
        t99 t99Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048589, this) == null) && (t99Var = this.S1) != null) {
            t99Var.a();
        }
    }

    public final void E1() {
        PbFragment pbFragment;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048593, this) == null) && this.C == null && (pbFragment = this.f) != null && pbFragment.getActivity() != null) {
            this.C = new PbContentCollectionController(this.f.getActivity());
        }
    }

    public void F0() {
        PbLandscapeListView pbLandscapeListView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048596, this) == null) && (pbLandscapeListView = this.o) != null) {
            pbLandscapeListView.setForbidDragListener(true);
        }
    }

    public boolean F2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048598, this)) == null) {
            r79 r79Var = this.u;
            if (r79Var != null && r79Var.l()) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public final void G1() {
        PbFragment pbFragment;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048601, this) == null) && this.B == null && (pbFragment = this.f) != null) {
            this.B = new p89(pbFragment.getContext());
        }
    }

    public void G3() {
        View view2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048603, this) == null) {
            PbLandscapeListView pbLandscapeListView = this.o;
            int i3 = 0;
            if (pbLandscapeListView != null) {
                pbLandscapeListView.setVisibility(0);
            }
            ga9 ga9Var = this.k;
            if (ga9Var != null && (view2 = ga9Var.f) != null) {
                if (!TbadkCoreApplication.isLogin()) {
                    i3 = 8;
                }
                view2.setVisibility(i3);
            }
        }
    }

    public final void H1() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048605, this) == null) && this.x == null) {
            this.x = new s89(this.f, this.q0);
        }
    }

    public d69 I0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048608, this)) == null) {
            return this.J;
        }
        return (d69) invokeV.objValue;
    }

    public final void J2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048614, this) == null) {
            this.y.F(this.R0, this.S0, this.p1, this.o1);
        }
    }

    public LinearLayout K0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048616, this)) == null) {
            return this.A0;
        }
        return (LinearLayout) invokeV.objValue;
    }

    public View L0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048620, this)) == null) {
            View view2 = this.d0;
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
        if (interceptable == null || (invokeV = interceptable.invokeV(1048624, this)) == null) {
            return this.i0;
        }
        return (String) invokeV.objValue;
    }

    public final void O1() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048633, this) == null) && this.z == null) {
            this.z = new r89(this.f, this.U);
        }
    }

    public PbFallingView P0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048636, this)) == null) {
            return this.O1;
        }
        return (PbFallingView) invokeV.objValue;
    }

    public final void P2() {
        PbInterviewStatusView pbInterviewStatusView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048638, this) == null) && (pbInterviewStatusView = this.X0) != null && pbInterviewStatusView.getVisibility() == 0) {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.X0.getLayoutParams();
            marginLayoutParams.setMargins(0, 0, 0, 0);
            this.X0.setLayoutParams(marginLayoutParams);
        }
    }

    public void Q2() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048642, this) == null) && this.i != 2) {
            PbLandscapeListView pbLandscapeListView = this.o;
            if (pbLandscapeListView != null) {
                pbLandscapeListView.setNextPage(this.P);
            }
            this.i = 2;
        }
    }

    public void Q3() {
        ga9 ga9Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048643, this) == null) && (ga9Var = this.k) != null && !this.q1) {
            ga9Var.w();
            this.q1 = true;
        }
    }

    public int R0() {
        InterceptResult invokeV;
        int i3;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048644, this)) == null) {
            PbLandscapeListView pbLandscapeListView = this.o;
            if (pbLandscapeListView != null) {
                i3 = pbLandscapeListView.getFirstVisiblePosition();
            } else {
                i3 = 0;
            }
            return S0(i3);
        }
        return invokeV.intValue;
    }

    public boolean R1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048645, this)) == null) {
            return this.N0;
        }
        return invokeV.booleanValue;
    }

    public void R3() {
        PbLandscapeListView pbLandscapeListView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048647, this) == null) && (pbLandscapeListView = this.o) != null) {
            pbLandscapeListView.setVisibility(0);
        }
    }

    public void S3() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048651, this) == null) {
            if (this.P0 == null) {
                this.P0 = new q95(this.f.getPageContext());
            }
            this.P0.h(true);
        }
    }

    public Button T0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048652, this)) == null) {
            return this.x0;
        }
        return (Button) invokeV.objValue;
    }

    public boolean T1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048653, this)) == null) {
            PbLandscapeListView pbLandscapeListView = this.o;
            if (pbLandscapeListView == null) {
                return false;
            }
            return pbLandscapeListView.J();
        }
        return invokeV.booleanValue;
    }

    public int U0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048656, this)) == null) {
            PbLandscapeListView pbLandscapeListView = this.o;
            if (pbLandscapeListView != null) {
                return pbLandscapeListView.getHeaderViewsCount();
            }
            return 0;
        }
        return invokeV.intValue;
    }

    public boolean U1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048657, this)) == null) {
            EditorTools editorTools = this.s0;
            if (editorTools == null || editorTools.getVisibility() != 0) {
                return false;
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    public void U2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048658, this) == null) {
            T2();
            w1();
            this.l1.g();
            K3(false);
        }
    }

    public void U3() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048659, this) == null) {
            this.J.n0(this.R0, false);
            this.J.f0();
        }
    }

    public TextView V0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048660, this)) == null) {
            return this.y.v();
        }
        return (TextView) invokeV.objValue;
    }

    public void V2() {
        Handler handler;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048662, this) != null) || (handler = this.W1) == null) {
            return;
        }
        Runnable runnable = this.X1;
        if (runnable != null) {
            handler.removeCallbacks(runnable);
        }
        r rVar = new r(this);
        this.X1 = rVar;
        this.W1.postDelayed(rVar, 2000L);
    }

    public int W0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048664, this)) == null) {
            sb9 sb9Var = this.K0;
            if (sb9Var != null) {
                return sb9Var.g();
            }
            return 3;
        }
        return invokeV.intValue;
    }

    public final boolean W1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048665, this)) == null) {
            return TextUtils.equals(TbadkCoreApplication.getCurrentAccount(), this.c2);
        }
        return invokeV.booleanValue;
    }

    public PbInterviewStatusView X0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048668, this)) == null) {
            return this.X0;
        }
        return (PbInterviewStatusView) invokeV.objValue;
    }

    public boolean Y0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048672, this)) == null) {
            return this.z1;
        }
        return invokeV.booleanValue;
    }

    public int Z0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048676, this)) == null) {
            PbLandscapeListView pbLandscapeListView = this.o;
            if (pbLandscapeListView == null) {
                return 0;
            }
            return S0(pbLandscapeListView.getLastVisiblePosition());
        }
        return invokeV.intValue;
    }

    public NoNetworkView a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048680, this)) == null) {
            return this.p;
        }
        return (NoNetworkView) invokeV.objValue;
    }

    public BdTypeListView a1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048681, this)) == null) {
            return this.o;
        }
        return (BdTypeListView) invokeV.objValue;
    }

    public final void a3() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048683, this) == null) {
            this.O1.setFallingFeedbackListener(new v0(this));
        }
    }

    public q59 c1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048689, this)) == null) {
            return this.x1;
        }
        return (q59) invokeV.objValue;
    }

    public boolean c2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048690, this)) == null) {
            sb9 sb9Var = this.K0;
            if (sb9Var == null) {
                return false;
            }
            return sb9Var.i();
        }
        return invokeV.booleanValue;
    }

    public void c4() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048692, this) == null) {
            this.f1173T.setVisibility(0);
        }
    }

    public View d1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048693, this)) == null) {
            return this.S;
        }
        return (View) invokeV.objValue;
    }

    public boolean d2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048694, this)) == null) {
            EditorTools editorTools = this.s0;
            if (editorTools != null && editorTools.w()) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public void d4() {
        d69 d69Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048696, this) == null) && (d69Var = this.J) != null) {
            d69Var.H0();
        }
    }

    public View f1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048701, this)) == null) {
            return this.R;
        }
        return (View) invokeV.objValue;
    }

    public void f2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048702, this) == null) {
            M2(this.R0);
        }
    }

    public void f4() {
        sb9 sb9Var;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048704, this) != null) || (sb9Var = this.K0) == null) {
            return;
        }
        sb9Var.o(2);
    }

    public PbListView g1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048705, this)) == null) {
            return this.P;
        }
        return (PbListView) invokeV.objValue;
    }

    public int h1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048710, this)) == null) {
            try {
                return Integer.parseInt(this.N.getText().toString(), 10);
            } catch (Exception unused) {
                return -1;
            }
        }
        return invokeV.intValue;
    }

    public void i0() {
        sb9 sb9Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048714, this) == null) && (sb9Var = this.K0) != null) {
            sb9Var.m(false);
        }
    }

    public View i1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048715, this)) == null) {
            return this.Z0;
        }
        return (View) invokeV.objValue;
    }

    public PbFakeFloorModel j1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048720, this)) == null) {
            return this.k1;
        }
        return (PbFakeFloorModel) invokeV.objValue;
    }

    public r69 k1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048725, this)) == null) {
            return this.l1;
        }
        return (r69) invokeV.objValue;
    }

    public void m4() {
        t99 t99Var;
        LinearLayout linearLayout;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048738, this) == null) && (t99Var = this.S1) != null && (linearLayout = this.R1) != null) {
            t99Var.c(linearLayout);
        }
    }

    public void n4() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048743, this) == null) {
            this.f.showProgressBar();
        }
    }

    public int o1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048745, this)) == null) {
            return this.U0;
        }
        return invokeV.intValue;
    }

    public void o4() {
        PbFallingView pbFallingView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048748, this) == null) && (pbFallingView = this.O1) != null) {
            pbFallingView.C();
        }
    }

    public View p1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048750, this)) == null) {
            return this.h;
        }
        return (View) invokeV.objValue;
    }

    public void p4() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048753, this) == null) && this.f2 != null) {
            while (this.f2.size() > 0) {
                TbImageView remove = this.f2.remove(0);
                if (remove != null) {
                    remove.R();
                }
            }
        }
    }

    public PbThreadPostView q1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048755, this)) == null) {
            return this.r;
        }
        return (PbThreadPostView) invokeV.objValue;
    }

    public RelativeLayout r1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048760, this)) == null) {
            return this.I;
        }
        return (RelativeLayout) invokeV.objValue;
    }

    public RelativeLayout s1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048765, this)) == null) {
            return this.g;
        }
        return (RelativeLayout) invokeV.objValue;
    }

    public void t1() {
        View view2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048770, this) == null) {
            PbLandscapeListView pbLandscapeListView = this.o;
            if (pbLandscapeListView != null) {
                pbLandscapeListView.setVisibility(8);
            }
            ga9 ga9Var = this.k;
            if (ga9Var != null && (view2 = ga9Var.f) != null) {
                view2.setVisibility(8);
            }
        }
    }

    public void t2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048771, this) == null) {
            this.J.g0(2);
            u2();
            e2();
            z4();
            n0();
            m69 m69Var = this.D;
            if (m69Var != null) {
                m69Var.j();
            }
        }
    }

    public void u1() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048775, this) != null) || this.z0 == null) {
            return;
        }
        this.y0.setVisibility(8);
        this.z0.setVisibility(8);
        this.N0 = false;
    }

    public final void u2() {
        PbFragment pbFragment;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048776, this) == null) && (pbFragment = this.f) != null && pbFragment.I5() != null) {
            this.f.I5().F();
        }
    }

    public void w0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048784, this) == null) {
            this.k.f();
            l55 l55Var = this.j0;
            if (l55Var != null) {
                l55Var.dismiss();
            }
            z0();
            c55 c55Var = this.K;
            if (c55Var != null) {
                c55Var.dismiss();
            }
            e55 e55Var = this.L;
            if (e55Var != null) {
                e55Var.e();
            }
        }
    }

    public void w1() {
        EditorTools editorTools;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048785, this) == null) && (editorTools = this.s0) != null) {
            editorTools.q();
            y89 y89Var = this.w1;
            if (y89Var != null) {
                y89Var.m();
            }
        }
    }

    public void x0() {
        sb9 sb9Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048789, this) == null) && (sb9Var = this.K0) != null) {
            sb9Var.l(false);
        }
    }

    public void x1() {
        ga9 ga9Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048790, this) == null) && (ga9Var = this.k) != null) {
            ga9Var.k();
        }
    }

    public void x3() {
        PbFragment pbFragment;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048792, this) == null) && (pbFragment = this.f) != null && pbFragment.getBaseFragmentActivity() != null) {
            vi.z(this.f.getPageContext().getPageActivity(), this.f.getBaseFragmentActivity().getCurrentFocus());
        }
    }

    public final boolean y0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048794, this)) == null) {
            return this.w.b(this.Q0);
        }
        return invokeV.booleanValue;
    }

    public void y1() {
        q95 q95Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048795, this) == null) && (q95Var = this.P0) != null) {
            q95Var.h(false);
        }
    }

    public void y3() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048797, this) == null) {
            this.P.D();
            this.P.U();
        }
    }

    public void z1() {
        Runnable runnable;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048800, this) == null) {
            if (this.F == null) {
                J1();
            }
            this.n.setVisibility(8);
            Handler handler = this.W1;
            if (handler != null && (runnable = this.X1) != null) {
                handler.removeCallbacks(runnable);
            }
        }
    }

    public void A2(int i3, String str, int i4, boolean z2, String str2, boolean z3) {
        int i5;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{Integer.valueOf(i3), str, Integer.valueOf(i4), Boolean.valueOf(z2), str2, Boolean.valueOf(z3)}) == null) {
            SparseArray<Object> sparseArray = new SparseArray<>();
            sparseArray.put(R.id.tag_del_post_id, str);
            sparseArray.put(R.id.tag_del_post_type, Integer.valueOf(i3));
            sparseArray.put(R.id.tag_manage_user_identity, Integer.valueOf(i4));
            sparseArray.put(R.id.tag_del_post_is_self, Boolean.valueOf(z2));
            sparseArray.put(j2, Integer.valueOf(k2));
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
            this.a0 = new c55(this.f.getActivity());
            if (StringUtils.isNull(str2)) {
                this.a0.setMessageId(i5);
            } else {
                this.a0.setOnlyMessageShowCenter(false);
                this.a0.setMessage(str2);
            }
            this.a0.setYesButtonTag(sparseArray);
            this.a0.setPositiveButton(R.string.obfuscated_res_0x7f0f058f, this.f);
            this.a0.setNegativeButton(R.string.obfuscated_res_0x7f0f0584, new x(this));
            this.a0.setCancelable(true);
            this.a0.create(this.f.getPageContext());
            if (z3) {
                M3(sparseArray, i6, i5);
            } else if (z2) {
                M3(sparseArray, i6, i5);
            } else if (E3()) {
                o46 o46Var = new o46(this.f.Q().y1().k().getDeletedReasonInfo().is_grays_cale_forum.intValue(), this.f.Q().y1().k().getDeletedReasonInfo().is_boomgrow.intValue(), this.f.Q().y1().n().has_forum_rule.intValue());
                o46Var.i(this.f.Q().y1().k().getId(), this.f.Q().y1().k().getName());
                o46Var.h(this.f.Q().y1().k().getImage_url());
                o46Var.j(this.f.Q().y1().k().getUser_level());
                T3(sparseArray, i3, o46Var, this.f.Q().y1().U(), false);
            } else {
                b4(this.a0, i3);
            }
        }
    }

    public void A3(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, str) == null) {
            this.C0.performClick();
            if (!StringUtils.isNull(str) && this.f.I5() != null && this.f.I5().s() != null && this.f.I5().s().i() != null) {
                EditText i3 = this.f.I5().s().i();
                i3.setText(str);
                i3.setSelection(str.length());
            }
        }
    }

    public final void I1(m39 m39Var) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048609, this, m39Var) != null) || m39Var == null || m39Var.N() == null || !m39Var.N().isInterviewLive() || this.X0 != null) {
            return;
        }
        PbInterviewStatusView pbInterviewStatusView = (PbInterviewStatusView) this.W0.inflate();
        this.X0 = pbInterviewStatusView;
        pbInterviewStatusView.setOnClickListener(this.U);
        this.X0.setCallback(this.f.A5());
        this.X0.setData(this.f, m39Var);
    }

    public final int S0(int i3) {
        InterceptResult invokeI;
        int i4;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048648, this, i3)) == null) {
            PbLandscapeListView pbLandscapeListView = this.o;
            if (pbLandscapeListView == null) {
                return 0;
            }
            mn adapter2 = pbLandscapeListView.getAdapter2();
            if (adapter2 == null) {
                return i3;
            }
            if (i3 < adapter2.getCount() && i3 >= 0 && (adapter2.getItem(i3) instanceof iy9)) {
                i3++;
            }
            int o3 = (adapter2.o() + adapter2.m()) - 1;
            if (i3 > o3) {
                i3 = o3;
            }
            if (this.o.getAdapter2() != null && (this.o.getAdapter2() instanceof mn)) {
                i4 = this.o.getAdapter2().n();
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

    public void Z2(String str) {
        PbReplyTitleViewHolder pbReplyTitleViewHolder;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048678, this, str) == null) && this.P != null) {
            int i3 = 0;
            b1 b1Var = this.g1;
            if (b1Var != null && (pbReplyTitleViewHolder = b1Var.a) != null && pbReplyTitleViewHolder.getView() != null) {
                i3 = this.g1.a.getView().getTop() < 0 ? this.g1.a.getView().getHeight() : this.g1.a.getView().getBottom();
            }
            this.P.K(str, i3);
        }
    }

    public void p0(boolean z2) {
        int i3;
        int i4;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048749, this, z2) == null) {
            PbLandscapeListView pbLandscapeListView = this.o;
            int i5 = 0;
            if (pbLandscapeListView != null) {
                if (z2) {
                    SkinManager.setBackgroundColor(pbLandscapeListView, R.color.CAM_X0202);
                } else {
                    pbLandscapeListView.setBackgroundResource(0);
                }
            }
            View view2 = this.v0;
            if (view2 != null) {
                if (z2) {
                    i4 = 8;
                } else {
                    i4 = 0;
                }
                view2.setVisibility(i4);
            }
            PbListView pbListView = this.P;
            if (pbListView != null) {
                if (z2) {
                    i3 = 8;
                } else {
                    i3 = 0;
                }
                pbListView.O(i3);
            }
            View view3 = this.R;
            if (view3 != null) {
                if (z2) {
                    i5 = 8;
                }
                view3.setVisibility(i5);
            }
        }
    }

    public void B2(int i3, String str, int i4, boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048582, this, new Object[]{Integer.valueOf(i3), str, Integer.valueOf(i4), Boolean.valueOf(z2)}) == null) {
            SparseArray<Object> sparseArray = new SparseArray<>();
            sparseArray.put(R.id.tag_del_post_id, str);
            sparseArray.put(R.id.tag_del_post_type, Integer.valueOf(i3));
            sparseArray.put(R.id.tag_manage_user_identity, Integer.valueOf(i4));
            sparseArray.put(R.id.tag_del_post_is_self, Boolean.valueOf(z2));
            sparseArray.put(j2, Integer.valueOf(k2));
            if (z2) {
                H3(sparseArray);
            } else {
                I3(i3, sparseArray);
            }
        }
    }

    public void E0(int i3, boolean z2, String str, boolean z3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048592, this, new Object[]{Integer.valueOf(i3), Boolean.valueOf(z2), str, Boolean.valueOf(z3)}) == null) {
            this.f.hideProgressBar();
            if (z2 && z3) {
                PbFragment pbFragment = this.f;
                pbFragment.showToast(pbFragment.getPageContext().getString(R.string.obfuscated_res_0x7f0f1448));
            } else if (z3) {
                if (ui.isEmpty(str)) {
                    str = TbadkCoreApplication.getInst().getResources().getString(R.string.obfuscated_res_0x7f0f0def);
                }
                this.f.showToast(str);
            }
        }
    }

    public void C2(SparseArray<Object> sparseArray, boolean z2) {
        int i3;
        j55 j55Var;
        j55 j55Var2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048586, this, sparseArray, z2) == null) {
            n55 n55Var = new n55(this.f.getContext());
            n55Var.t(this.f.getString(R.string.obfuscated_res_0x7f0f031f));
            n55Var.q(new w(this, z2));
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
                    j55Var2 = new j55(10, this.f.getString(R.string.obfuscated_res_0x7f0f054e), n55Var);
                } else {
                    j55Var2 = new j55(10, this.f.getString(R.string.obfuscated_res_0x7f0f053f), n55Var);
                }
                SparseArray sparseArray2 = new SparseArray();
                sparseArray2.put(R.id.tag_del_post_id, sparseArray.get(R.id.tag_del_post_id));
                sparseArray2.put(R.id.tag_del_post_type, sparseArray.get(R.id.tag_del_post_type));
                sparseArray2.put(R.id.tag_del_post_is_self, sparseArray.get(R.id.tag_del_post_is_self));
                sparseArray2.put(R.id.tag_manage_user_identity, sparseArray.get(R.id.tag_manage_user_identity));
                j55Var2.d.setTag(sparseArray2);
                arrayList.add(j55Var2);
            }
            if ((sparseArray.get(R.id.tag_mul_del_post_type) instanceof Boolean) && ((Boolean) sparseArray.get(R.id.tag_mul_del_post_type)).booleanValue()) {
                j55 j55Var3 = new j55(13, this.f.getString(R.string.multi_delete), n55Var);
                SparseArray sparseArray3 = new SparseArray();
                sparseArray3.put(R.id.tag_del_post_id, sparseArray.get(R.id.tag_del_post_id));
                sparseArray3.put(R.id.tag_del_post_type, sparseArray.get(R.id.tag_del_post_type));
                sparseArray3.put(R.id.tag_del_post_is_self, sparseArray.get(R.id.tag_del_post_is_self));
                sparseArray3.put(R.id.tag_manage_user_identity, sparseArray.get(R.id.tag_manage_user_identity));
                j55Var3.d.setTag(sparseArray3);
                arrayList.add(j55Var3);
            }
            if (!"".equals(sparseArray.get(R.id.tag_forbid_user_name)) || !"".equals(sparseArray.get(R.id.tag_forbid_user_name_show))) {
                SparseArray sparseArray4 = new SparseArray();
                sparseArray4.put(R.id.tag_forbid_user_name, sparseArray.get(R.id.tag_forbid_user_name));
                sparseArray4.put(R.id.tag_forbid_user_name_show, sparseArray.get(R.id.tag_forbid_user_name_show));
                sparseArray4.put(R.id.tag_forbid_user_portrait, sparseArray.get(R.id.tag_forbid_user_portrait));
                sparseArray4.put(R.id.tag_manage_user_identity, sparseArray.get(R.id.tag_manage_user_identity));
                sparseArray4.put(R.id.tag_forbid_user_post_id, sparseArray.get(R.id.tag_forbid_user_post_id));
                j55 j55Var4 = new j55(11, this.f.getString(R.string.forbidden_person), n55Var);
                j55Var4.d.setTag(sparseArray4);
                arrayList.add(j55Var4);
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
                    j55Var = new j55(12, this.f.getString(R.string.un_mute), n55Var);
                } else {
                    j55Var = new j55(12, this.f.getString(R.string.obfuscated_res_0x7f0f0ccc), n55Var);
                }
                j55Var.d.setTag(sparseArray5);
                arrayList.add(j55Var);
            }
            r99.f(arrayList);
            n55Var.m(arrayList, !UbsABTestHelper.isPBPlanA());
            l55 l55Var = new l55(this.f.getPageContext(), n55Var);
            this.Y = l55Var;
            l55Var.l();
        }
    }

    public final void I2(PbReplyTitleViewHolder pbReplyTitleViewHolder, boolean z2) {
        boolean z3;
        int measuredHeight;
        int i3;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLZ(1048610, this, pbReplyTitleViewHolder, z2) == null) && !this.o1 && this.Z0 != null && this.k.j() != null) {
            View u2 = I0().u();
            if (u2 != null) {
                int[] iArr = new int[2];
                u2.getLocationInWindow(iArr);
                int i4 = iArr[1];
                if (i4 != 0) {
                    if (this.Z0.getVisibility() == 0 && i4 - this.k.j().getBottom() <= this.Z0.getHeight()) {
                        this.a1.setVisibility(0);
                        if (i4 > this.k.j().getBottom()) {
                            i3 = -(((this.Z0.getHeight() + this.a1.getHeight()) + this.k.j().getBottom()) - u2.getBottom());
                        } else {
                            i3 = -this.Z0.getHeight();
                        }
                        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.Z0.getLayoutParams();
                        if (layoutParams.topMargin != i3) {
                            layoutParams.topMargin = i3;
                            this.Z0.setLayoutParams(layoutParams);
                        }
                    } else {
                        this.a1.setVisibility(4);
                        RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.Z0.getLayoutParams();
                        if (layoutParams2.topMargin != 0) {
                            layoutParams2.topMargin = 0;
                            this.Z0.setLayoutParams(layoutParams2);
                        }
                    }
                }
            }
            int J = this.J.J();
            if (J > 0 && (pbReplyTitleViewHolder == null || pbReplyTitleViewHolder.getView().getParent() == null)) {
                PbLandscapeListView pbLandscapeListView = this.o;
                if (pbLandscapeListView != null && J > pbLandscapeListView.getFirstVisiblePosition() - this.o.getHeaderViewsCount()) {
                    this.Z0.setVisibility(4);
                    return;
                }
                this.Z0.setVisibility(0);
                J3(false);
                this.k.a.hideBottomLine();
                if (this.Z0.getParent() != null && ((ViewGroup) this.Z0.getParent()).getHeight() <= this.Z0.getTop()) {
                    this.Z0.getParent().requestLayout();
                }
            } else if (pbReplyTitleViewHolder != null && pbReplyTitleViewHolder.getView() != null && pbReplyTitleViewHolder.g != null) {
                int top = pbReplyTitleViewHolder.getView().getTop();
                if (pbReplyTitleViewHolder.getView().getParent() != null) {
                    if (this.f1) {
                        this.e1 = top;
                        this.f1 = false;
                    }
                    int i5 = this.e1;
                    if (top < i5) {
                        i5 = top;
                    }
                    this.e1 = i5;
                }
                if (top == 0 && !pbReplyTitleViewHolder.getView().isShown()) {
                    return;
                }
                if (this.I.getY() < 0.0f) {
                    z3 = true;
                } else {
                    z3 = false;
                }
                if (z3) {
                    measuredHeight = h2 - pbReplyTitleViewHolder.g.getMeasuredHeight();
                } else {
                    measuredHeight = this.k.j().getMeasuredHeight() - pbReplyTitleViewHolder.g.getMeasuredHeight();
                    this.k.a.hideBottomLine();
                }
                if (pbReplyTitleViewHolder.getView().getParent() == null && top <= this.e1) {
                    this.Z0.setVisibility(0);
                    J3(false);
                } else if (top < measuredHeight) {
                    this.Z0.setVisibility(0);
                    J3(false);
                } else {
                    this.Z0.setVisibility(4);
                    this.k.a.hideBottomLine();
                }
                if (z2) {
                    this.f1 = true;
                }
            } else {
                PbLandscapeListView pbLandscapeListView2 = this.o;
                if (pbLandscapeListView2 != null && pbLandscapeListView2.getFirstVisiblePosition() == 0) {
                    this.Z0.setVisibility(4);
                    this.k.a.hideBottomLine();
                }
            }
        }
    }

    public final boolean D3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) {
            m39 m39Var = this.R0;
            if (m39Var != null && m39Var.N() != null && !ListUtils.isEmpty(this.R0.N().getThreadRecommendInfoDataList()) && this.f != null && this.x.b() != null && this.x.b().getVisibility() == 0 && this.R0.N().getThreadRecommendInfoDataList().get(0) != null && this.R0.N().getThreadRecommendInfoDataList().get(0).businessType == 1) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public final void H2() {
        ga9 ga9Var;
        m39 m39Var;
        boolean z2;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048606, this) == null) && this.x != null && (ga9Var = this.k) != null && ga9Var.j() != null && (m39Var = this.R0) != null && m39Var.N() != null && this.R0.N().isQuestionThread() && this.x.b() != null && this.x.b().getVisibility() == 0) {
            int[] iArr = new int[2];
            this.x.b().getLocationInWindow(iArr);
            boolean z3 = true;
            int height = iArr[1] + this.x.b().getHeight();
            if (this.x.b().getParent() != null) {
                z2 = true;
            } else {
                z2 = false;
            }
            ga9 ga9Var2 = this.k;
            if (height > ga9Var2.j().getBottom() && z2) {
                z3 = false;
            }
            ga9Var2.z(z3, this.R0.N().getSpan_str());
        }
    }

    public final void J1() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048613, this) != null) || !this.f.B5()) {
            return;
        }
        ViewStub viewStub = (ViewStub) this.g.findViewById(R.id.obfuscated_res_0x7f091687);
        this.n = viewStub;
        viewStub.setVisibility(0);
        if (this.F == null) {
            this.F = (LinearLayout) this.g.findViewById(R.id.obfuscated_res_0x7f091686);
            gt5.a(this.f.getPageContext(), this.F);
        }
        if (this.G == null) {
            this.G = (TextView) this.F.findViewById(R.id.obfuscated_res_0x7f09168b);
        }
        if (this.H == null) {
            this.H = (TextView) this.F.findViewById(R.id.obfuscated_res_0x7f09168a);
        }
        this.G.setOnClickListener(this.U);
        this.H.setOnClickListener(this.U);
    }

    public void K1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048617, this) == null) {
            if (this.f != null && this.s0 != null) {
                TiebaStatic.log(new StatisticItem(CommonStatisticKey.KEY_RD_USE).param("obj_param1", 3).param("obj_locate", 9).param("obj_type", 1).param("obj_source", UtilHelper.getCurrentPageName(TbadkCoreApplication.getInst().getCurrentActivity())));
                this.s0.j();
                u1();
                return;
            }
            TiebaStatic.log(new StatisticItem(CommonStatisticKey.KEY_RD_USE).param("obj_param1", 3).param("obj_locate", 20).param("obj_type", 1).param("obj_source", UtilHelper.getCurrentPageName(TbadkCoreApplication.getInst().getCurrentActivity())));
        }
    }

    public int N0() {
        InterceptResult invokeV;
        View childAt;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048628, this)) == null) {
            PbLandscapeListView pbLandscapeListView = this.o;
            if (pbLandscapeListView == null) {
                return 0;
            }
            int firstVisiblePosition = pbLandscapeListView.getFirstVisiblePosition();
            int lastVisiblePosition = this.o.getLastVisiblePosition();
            if (lastVisiblePosition > firstVisiblePosition) {
                int i3 = (lastVisiblePosition - firstVisiblePosition) + 1;
                int[] iArr = new int[i3];
                Rect rect = new Rect();
                int childCount = this.o.getChildCount();
                int i4 = 0;
                for (int i5 = firstVisiblePosition; i5 <= lastVisiblePosition; i5++) {
                    int i6 = i5 - firstVisiblePosition;
                    if (i6 < childCount && (childAt = this.o.getChildAt(i6)) != null) {
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

    public final void T2() {
        PbFragment pbFragment;
        int i3;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048654, this) == null) && (pbFragment = this.f) != null && pbFragment.I5() != null && this.s0 != null) {
            tj5.a().c(0);
            yj5 I5 = this.f.I5();
            I5.N();
            I5.L();
            if (I5.v() != null) {
                WriteImagesInfo v2 = I5.v();
                if (I5.t) {
                    i3 = 1;
                } else {
                    i3 = 9;
                }
                v2.setMaxImagesAllowed(i3);
            }
            I5.e0(SendView.h);
            I5.h(SendView.h);
            ci5 o3 = this.s0.o(23);
            ci5 o4 = this.s0.o(2);
            ci5 o5 = this.s0.o(5);
            if (o4 != null) {
                o4.display();
            }
            if (o5 != null) {
                o5.display();
            }
            if (o3 != null) {
                o3.hide();
            }
            this.s0.invalidate();
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:24:0x0051, code lost:
        if (r5.J1 == 1) goto L19;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void u0() {
        rb9 rb9Var;
        int i3;
        boolean z2;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048774, this) != null) || (rb9Var = this.M1) == null) {
            return;
        }
        if (this.o != null && rb9Var.a() != null && this.M1.a().getParent() != null) {
            i3 = this.o.getPositionForView(this.M1.a());
        } else {
            i3 = -1;
        }
        boolean z3 = false;
        if (i3 != -1) {
            if (this.M1.a().getTop() + o2 <= this.Z0.getBottom()) {
                this.J1 = 1;
                z2 = true;
            } else {
                this.J1 = 0;
                z2 = false;
            }
        }
        PbReplyTitleViewHolder pbReplyTitleViewHolder = this.c1;
        if (this.J1 == 1) {
            z3 = true;
        }
        pbReplyTitleViewHolder.u(z3);
        this.M1.e(z2);
    }

    public void w3() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048787, this) == null) {
            this.f.hideProgressBar();
            m39 m39Var = this.R0;
            if (m39Var != null && this.P != null && m39Var.y() != null && this.R0.y().b() == 0) {
                this.P.y(this.R0.s());
                if (this.R0.s()) {
                    StatisticItem statisticItem = new StatisticItem(CommonStatisticKey.KEY_PB_FOLD_ICON_SHOW);
                    statisticItem.param("uid", TbadkCoreApplication.getCurrentAccount());
                    statisticItem.param("fid", this.R0.l());
                    statisticItem.param("fname", this.R0.m());
                    statisticItem.param("tid", this.R0.P());
                    TiebaStatic.log(statisticItem);
                }
            }
            C0();
            PbLandscapeListView pbLandscapeListView = this.o;
            if (pbLandscapeListView != null) {
                pbLandscapeListView.z(0L);
            }
            y0();
        }
    }

    public void E2(@NonNull View view2) {
        PbFragment pbFragment;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048594, this, view2) == null) && this.F0.getData() != null && this.F0.getData().hasAgree && this.f.getActivity() != null) {
            q29 q29Var = new q29(this.f.getContext());
            int g2 = vi.g(TbadkCoreApplication.getInst(), R.dimen.tbds774);
            int g3 = vi.g(TbadkCoreApplication.getInst(), R.dimen.obfuscated_res_0x7f0708e4);
            int[] iArr = new int[2];
            view2.getLocationInWindow(iArr);
            int i3 = iArr[0];
            int i4 = iArr[1];
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(g3, g2);
            layoutParams.leftMargin = ((view2.getWidth() / 2) + i3) - ((int) ((g3 * 1) / 1.45d));
            layoutParams.topMargin = vi.g(TbadkCoreApplication.getInst(), R.dimen.M_H_X006);
            q29Var.k(g2);
            q29Var.j(layoutParams);
            q29Var.i(false);
            if (this.R0 != null && (pbFragment = this.f) != null) {
                q29Var.n(true, pbFragment.getActivity().findViewById(16908290), 0, i4, this.R0.P(), this.R0.l());
            }
            q29Var.l(new p(this));
        }
    }

    public final boolean N3(m39 m39Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048631, this, m39Var)) == null) {
            if (m39Var == null || m39Var.N() == null) {
                return false;
            }
            if (m39Var.N().getIsLive() != 1 && m39Var.N().getThreadType() != 33 && ((m39Var.N().getTopicData() == null || m39Var.N().getTopicData().a() == 0) && m39Var.N().getIs_top() != 1 && m39Var.N().getIs_good() != 1 && !m39Var.N().isActInfo() && !m39Var.N().isInterviewLive() && !m39Var.N().isVoteThreadType() && m39Var.N().getYulePostActivityData() == null && ui.isEmpty(m39Var.N().getCategory()) && !m39Var.N().isGodThread() && !m39Var.N().isRealGod())) {
                return false;
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public final void P1(m39 m39Var) {
        PbListView pbListView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048637, this, m39Var) == null) && (pbListView = this.P) != null && pbListView.i() != null) {
            LinearLayout i3 = this.P.i();
            if (UbsABTestHelper.isPbEnterForum() && m39Var.y().b() == 0 && !this.f.Q().d1() && !b2(m39Var)) {
                if (this.b == null) {
                    F1();
                }
                ViewParent parent = this.b.getParent();
                if (parent instanceof ViewGroup) {
                    ((ViewGroup) parent).removeView(this.b);
                }
                i3.addView(this.b);
                ForumData k3 = m39Var.k();
                p25 forumShowInfo = k3.getForumShowInfo();
                if (forumShowInfo != null) {
                    forumShowInfo.g(TbadkCoreApplication.getInst().getString(R.string.enter_forum));
                }
                this.b.setData(k3.getName(), k3.getImage_url(), k3.getPost_num(), k3.getMember_num(), k3.getPendants(), forumShowInfo);
                return;
            }
            i3.removeView(this.b);
            i3.setVisibility(8);
        }
    }

    public void s4(l39 l39Var) {
        String string;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048768, this, l39Var) != null) || l39Var == null) {
            return;
        }
        this.k.C();
        if (!StringUtils.isNull(l39Var.b)) {
            this.k.y(l39Var.b);
        }
        String string2 = TbadkCoreApplication.getInst().getResources().getString(R.string.obfuscated_res_0x7f0f15fe);
        int e2 = tg.e(l39Var.a, 0);
        if (e2 != 100) {
            if (e2 != 300) {
                if (e2 != 400) {
                    string = "";
                } else {
                    string = TbadkCoreApplication.getInst().getResources().getString(R.string.obfuscated_res_0x7f0f156b);
                }
            } else {
                string = TbadkCoreApplication.getInst().getResources().getString(R.string.obfuscated_res_0x7f0f0331);
            }
        } else {
            string = TbadkCoreApplication.getInst().getResources().getString(R.string.obfuscated_res_0x7f0f1313);
        }
        this.f.showNetRefreshView(this.g, String.format(string2, string), null, TbadkCoreApplication.getInst().getResources().getString(R.string.appeal_restore), true, new m0(this, l39Var.c));
    }

    public void t0(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048769, this, str) == null) {
            if (str.contains("_")) {
                str = str.replace("_", "\n");
            }
            c55 c55Var = new c55(this.f.getPageContext().getPageActivity());
            View inflate = LayoutInflater.from(this.f.getPageContext().getPageActivity()).inflate(R.layout.upgrade_success_dialog_content, (ViewGroup) null);
            TextView textView = (TextView) inflate.findViewById(R.id.title_view);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
            layoutParams.setMargins(0, 0, 0, 0);
            textView.setLayoutParams(layoutParams);
            textView.setGravity(3);
            textView.setText(str);
            ((TextView) inflate.findViewById(R.id.function_description_view)).setVisibility(8);
            c55Var.setContentView(inflate);
            SparseArray sparseArray = new SparseArray();
            sparseArray.put(j2, Integer.valueOf(m2));
            c55Var.setYesButtonTag(sparseArray);
            c55Var.setPositiveButton(R.string.obfuscated_res_0x7f0f17e4, this.f);
            c55Var.setNegativeButton(R.string.obfuscated_res_0x7f0f03c9, new t0(this));
            c55Var.create(this.f.getPageContext()).show();
        }
    }

    public final boolean E3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) {
            PbFragment pbFragment = this.f;
            if (pbFragment == null || pbFragment.Q().y1().k().getDeletedReasonInfo() == null || 1 != this.f.Q().y1().k().getDeletedReasonInfo().is_grays_cale_forum.intValue()) {
                return false;
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    public final void L1() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048621, this) != null) || this.f.r1 == 3 || !TbadkCoreApplication.isLogin()) {
            return;
        }
        m mVar = new m(this);
        this.E = new l69(this.f.V());
        this.D = new m69(this.o, mVar);
    }

    public final void R2() {
        PbFragment pbFragment;
        WaterRippleView waterRippleView;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048646, this) != null) || (pbFragment = this.f) == null || pbFragment.getActivity() == null || (waterRippleView = this.D0) == null) {
            return;
        }
        ViewParent parent = waterRippleView.getParent();
        if (parent instanceof ViewGroup) {
            ((ViewGroup) parent).removeView(this.D0);
        }
        TextView textView = this.L0;
        if (textView != null) {
            textView.setVisibility(0);
        }
    }

    public void S2() {
        PbLandscapeListView pbLandscapeListView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048650, this) == null) && (pbLandscapeListView = this.o) != null) {
            this.B.d(pbLandscapeListView);
            this.x.h(this.o);
            this.y.G(this.o);
            this.z.d(this.o);
            this.w.f(this.o);
        }
    }

    public boolean Z1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048677, this)) == null) {
            View view2 = this.d1;
            if (view2 == null || view2.getParent() == null || this.P.p()) {
                return false;
            }
            int bottom = this.d1.getBottom();
            Rect rect = new Rect();
            this.d1.getWindowVisibleDisplayFrame(rect);
            if (bottom <= 0 || bottom > rect.bottom) {
                return false;
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    public boolean a2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048682, this)) == null) {
            m39 m39Var = this.R0;
            if (m39Var == null || m39Var.k() == null || "0".equals(this.R0.k().getId())) {
                return true;
            }
            return "me0407".equals(this.R0.k().getName());
        }
        return invokeV.booleanValue;
    }

    public final void e4() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048700, this) == null) {
            PbFallingView pbFallingView = this.O1;
            if (pbFallingView != null) {
                pbFallingView.setTag(Boolean.TRUE);
            }
            RightFloatLayerView rightFloatLayerView = this.P1;
            if (rightFloatLayerView != null && rightFloatLayerView.getTag() == this.O1) {
                this.P1.setTag(null);
                this.P1.setAutoCompleteShown(true);
                this.P1.d();
            }
        }
    }

    public boolean k0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048724, this)) == null) {
            PbListView pbListView = this.P;
            if (pbListView != null && !TextUtils.isEmpty(pbListView.j())) {
                return this.P.j().equals(TbadkCoreApplication.getInst().getResources().getString(R.string.list_has_all_comments));
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public final void l0() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048729, this) == null) && this.R0 != null && UbsABTestHelper.isResizeInduceSharingABTest() && !v99.h(this.R0.P())) {
            this.K0.f();
            v99.b(this.R0.P());
        }
    }

    public String l1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048730, this)) == null) {
            if (!ui.isEmpty(this.F1)) {
                return this.F1;
            }
            if (this.f != null) {
                this.F1 = TbadkCoreApplication.getInst().getResources().getString(u79.g());
            }
            return this.F1;
        }
        return (String) invokeV.objValue;
    }

    public final void q0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048754, this) == null) {
            q59 q59Var = new q59(this.f, this, (ViewStub) this.g.findViewById(R.id.obfuscated_res_0x7f091751));
            this.x1 = q59Var;
            q59Var.o(this.U);
            this.x1.p(this.Z);
            this.x1.q(this.W);
            this.x1.o(this.U);
            this.x1.s(this.q0);
        }
    }

    public final void t4() {
        PbFragment pbFragment;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048773, this) == null) && (pbFragment = this.f) != null && pbFragment.I5() != null) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921706, Boolean.valueOf(!this.f.I5().z())));
        }
    }

    public void v0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048779, this) == null) {
            this.k.f();
            PbFragment pbFragment = this.f;
            if (pbFragment != null) {
                vi.z(pbFragment.getContext(), this.N);
            }
            w1();
            l55 l55Var = this.j0;
            if (l55Var != null) {
                l55Var.dismiss();
            }
            z0();
            c55 c55Var = this.K;
            if (c55Var != null) {
                c55Var.dismiss();
            }
            e55 e55Var = this.L;
            if (e55Var != null) {
                e55Var.e();
            }
        }
    }

    public final void w4() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048788, this) != null) || !this.f.B5()) {
            return;
        }
        if (this.f.G5() == -1) {
            SkinManager.setViewTextColor(this.G, R.color.CAM_X0110, 1);
        }
        if (this.f.F5() == -1) {
            SkinManager.setViewTextColor(this.H, R.color.CAM_X0110, 1);
        }
    }

    public void z0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048799, this) == null) {
            c55 c55Var = this.a0;
            if (c55Var != null) {
                c55Var.dismiss();
            }
            Dialog dialog = this.b0;
            if (dialog != null) {
                yg.b(dialog, this.f.getPageContext());
            }
            Dialog dialog2 = this.c0;
            if (dialog2 != null) {
                yg.b(dialog2, this.f.getPageContext());
            }
            l55 l55Var = this.Y;
            if (l55Var != null) {
                l55Var.dismiss();
            }
        }
    }

    public final void F1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048597, this) == null) {
            CardForumHeadLayout cardForumHeadLayout = new CardForumHeadLayout(this.f.getContext());
            this.b = cardForumHeadLayout;
            cardForumHeadLayout.setId(R.id.obfuscated_res_0x7f0919f4);
            this.b.setNeedShowForumlable(false);
            this.b.setJumpCallFrom(2);
            this.b.setBarNameIncludePadding(false);
            this.b.setBarThreadLineSpace(vi.g(this.f.getContext(), R.dimen.tbds26));
            this.b.setAttentionLineSpace(vi.g(this.f.getContext(), R.dimen.tbds26));
            int g2 = vi.g(this.f.getContext(), R.dimen.M_W_X006);
            int g3 = vi.g(this.f.getContext(), R.dimen.tbds16);
            int g4 = vi.g(this.f.getContext(), R.dimen.tbds15);
            int g5 = vi.g(this.f.getContext(), R.dimen.M_W_X007);
            int g6 = vi.g(this.f.getContext(), R.dimen.M_H_X005);
            this.b.setPadding(g2, g3, g2, g4);
            ViewGroup.MarginLayoutParams marginLayoutParams = new ViewGroup.MarginLayoutParams(-1, -2);
            marginLayoutParams.leftMargin = g5;
            marginLayoutParams.rightMargin = g5;
            marginLayoutParams.bottomMargin = g6;
            this.b.setLayoutParams(marginLayoutParams);
            o75 d2 = o75.d(this.b);
            d2.o(R.string.J_X05);
            d2.h(ow9.a(SkinManager.getColor(R.color.CAM_X0341), 0.08f));
            this.b.setAfterClickListener(new o(this));
        }
    }

    public void K2() {
        PbLandscapeListView pbLandscapeListView;
        int i3;
        int i4;
        boolean z2;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048618, this) != null) || (pbLandscapeListView = this.o) == null) {
            return;
        }
        int headerViewsCount = pbLandscapeListView.getHeaderViewsCount() - this.n1;
        int i5 = 0;
        if (this.o.getFirstVisiblePosition() != 0 && this.o.getFirstVisiblePosition() + headerViewsCount >= 0) {
            i3 = this.o.getFirstVisiblePosition() + headerViewsCount;
        } else {
            i3 = 0;
        }
        View childAt = this.o.getChildAt(0);
        if (childAt != null) {
            i4 = childAt.getTop();
        } else {
            i4 = -1;
        }
        this.g1.a = null;
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004013, this.g1));
        PbReplyTitleViewHolder pbReplyTitleViewHolder = this.g1.a;
        int m1 = m1(pbReplyTitleViewHolder);
        int measuredHeight = this.I.getMeasuredHeight() + ((int) this.I.getY());
        boolean z3 = true;
        if (this.Z0.getVisibility() == 0) {
            z2 = true;
        } else {
            z2 = false;
        }
        if (this.I.getY() >= 0.0f) {
            z3 = false;
        }
        if ((z2 && pbReplyTitleViewHolder != null) || i3 >= this.J.J() + this.o.getHeaderViewsCount()) {
            if (pbReplyTitleViewHolder != null) {
                i5 = pbReplyTitleViewHolder.g.getMeasuredHeight();
            }
            if (z3) {
                this.o.setSelectionFromTop(this.J.J() + this.o.getHeaderViewsCount(), h2 - i5);
            } else {
                this.o.setSelectionFromTop(this.J.J() + this.o.getHeaderViewsCount(), this.k.j().getMeasuredHeight() - i5);
            }
        } else {
            this.o.setSelectionFromTop(i3, i4);
        }
        if (this.T0 != 6) {
            return;
        }
        this.o.setOnLayoutListener(new l(this, m1, pbReplyTitleViewHolder, z2, measuredHeight, i3, i4));
    }

    public void l2() {
        NoNetworkView.b bVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048731, this) == null) {
            v69 v69Var = this.s;
            if (v69Var != null) {
                v69Var.l();
            }
            RelativeLayout relativeLayout = this.g;
            if (relativeLayout != null && relativeLayout.getHandler() != null) {
                this.g.getHandler().removeCallbacksAndMessages(null);
            }
            sb9 sb9Var = this.K0;
            if (sb9Var != null) {
                sb9Var.k();
            }
            f79 f79Var = this.B1;
            if (f79Var != null) {
                f79Var.c();
            }
            PbTopTipView pbTopTipView = this.s1;
            if (pbTopTipView != null) {
                pbTopTipView.g();
            }
            this.f.hideProgressBar();
            NoNetworkView noNetworkView = this.p;
            if (noNetworkView != null && (bVar = this.X) != null) {
                noNetworkView.e(bVar);
            }
            ux9.d();
            v0();
            C0();
            if (this.j1 != null) {
                wg.a().removeCallbacks(this.j1);
            }
            PbInterviewStatusView pbInterviewStatusView = this.X0;
            if (pbInterviewStatusView != null) {
                pbInterviewStatusView.m();
            }
            MessageManager.getInstance().unRegisterListener(this.T1);
            this.W1 = null;
            this.j.removeCallbacksAndMessages(null);
            this.J.g0(3);
            View view2 = this.h;
            if (view2 != null) {
                view2.setBackgroundDrawable(null);
            }
            d69 d69Var = this.J;
            if (d69Var != null) {
                d69Var.i0();
            }
            y89 y89Var = this.w1;
            if (y89Var != null) {
                y89Var.l();
            }
            u89 u89Var = this.y;
            if (u89Var != null) {
                u89Var.D();
            }
            PbReplyTitleViewHolder pbReplyTitleViewHolder = this.c1;
            if (pbReplyTitleViewHolder != null) {
                pbReplyTitleViewHolder.q(null);
            }
            this.y1 = null;
            PbLandscapeListView pbLandscapeListView = this.o;
            if (pbLandscapeListView != null) {
                pbLandscapeListView.setOnLayoutListener(null);
                this.o.getViewTreeObserver().removeGlobalOnLayoutListener(this.a);
                this.o.setListViewDragListener(null);
                this.o.K();
                this.o = null;
            }
            AgreeView agreeView = this.F0;
            if (agreeView != null) {
                agreeView.setAgreeLongClickListener(null);
                this.F0.setAfterClickListener(null);
            }
            b1 b1Var = this.g1;
            if (b1Var != null) {
                b1Var.a = null;
            }
        }
    }

    public void m0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048734, this) == null) {
            if (!this.f.checkUpIsLogin()) {
                TiebaStatic.log(new StatisticItem(CommonStatisticKey.KEY_RD_USE).param("obj_param1", 3).param("obj_locate", 2).param("obj_type", 1).param("obj_source", UtilHelper.getCurrentPageName(TbadkCoreApplication.getInst().getCurrentActivity())));
                bb9.r("c10517", this.p0, 2);
            } else if (!this.f.d5()) {
                TiebaStatic.log(new StatisticItem(CommonStatisticKey.KEY_RD_USE).param("obj_param1", 3).param("obj_locate", 8).param("obj_type", 1).param("obj_source", UtilHelper.getCurrentPageName(TbadkCoreApplication.getInst().getCurrentActivity())));
            } else {
                yj5 I5 = this.f.I5();
                if (I5 != null && (I5.y() || I5.A())) {
                    TiebaStatic.log(new StatisticItem(CommonStatisticKey.KEY_RD_USE).param("obj_param1", 3).param("obj_locate", 10).param("obj_type", 1).param("obj_source", UtilHelper.getCurrentPageName(TbadkCoreApplication.getInst().getCurrentActivity())));
                    this.f.I5().w(false, null);
                    return;
                }
                if (this.s0 != null) {
                    K1();
                }
                EditorTools editorTools = this.s0;
                if (editorTools != null) {
                    this.N0 = false;
                    if (editorTools.p(2) != null) {
                        ux9.c(this.f.getPageContext(), (View) this.s0.p(2).m, false, q2);
                    }
                }
                u1();
            }
        }
    }

    public void o2() {
        jy9 jy9Var;
        int i3;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048746, this) != null) || this.f == null) {
            return;
        }
        if (!this.H1 && this.I1 != 17) {
            if (this.p1 && !this.o1 && (jy9Var = this.S0) != null && jy9Var.p() != null) {
                int i4 = 2;
                if (this.f.z0()) {
                    i3 = 2;
                } else {
                    i3 = 1;
                }
                if (!this.o1) {
                    i4 = 1;
                }
                bb9.q("c12601", i4, i3);
                MessageManager.getInstance().sendMessage(new CustomMessage(2002003, new PersonInfoActivityConfig(this.f.getPageContext().getPageActivity(), this.S0.p().getUserId(), this.S0.p().getUserName(), this.f.Q().X0(), AddFriendActivityConfig.TYPE_PB_HEAD)));
                return;
            }
            return;
        }
        m39 m39Var = this.R0;
        if (m39Var != null && m39Var.k() != null && !ui.isEmpty(this.R0.k().getName())) {
            MessageManager.getInstance().sendMessage(new CustomMessage(2003000, new FrsActivityConfig(this.f.getContext()).createNormalCfg(this.R0.k().getName(), null)));
            TiebaStatic.log(new StatisticItem("c13853").param("post_id", this.R0.P()).param("uid", TbadkCoreApplication.getCurrentAccountId()).param("fid", this.R0.k().getId()));
        }
    }

    public void s2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048766, this) == null) {
            TiebaStatic.log(new StatisticItem(CommonStatisticKey.KEY_RD_USE).param("obj_param1", 3).param("obj_locate", 1).param("obj_type", 1).param("obj_source", UtilHelper.getCurrentPageName(TbadkCoreApplication.getInst().getCurrentActivity())));
            if (!DialogLoginHelper.checkUpIsLogin(new LoginDialogData(this.f.getActivity(), LoginDialogData.PB_BOTTOM_REPLY_RESULT_PAGE))) {
                TiebaStatic.log(new StatisticItem(CommonStatisticKey.KEY_RD_USE).param("obj_param1", 3).param("obj_locate", 2).param("obj_type", 1).param("obj_source", UtilHelper.getCurrentPageName(TbadkCoreApplication.getInst().getCurrentActivity())));
                return;
            }
            t4();
            this.f.w6();
            PbFragment pbFragment = this.f;
            if (pbFragment != null && pbFragment.Q() != null && this.f.Q().y1() != null && this.f.Q().y1().N() != null && this.f.Q().y1().N().getAuthor() != null) {
                TiebaStatic.log(new StatisticItem("c13701").param("tid", this.f.Q().S1()).param("fid", this.f.Q().y1().l()).param("uid", TbadkCoreApplication.getCurrentAccountId()));
                TiebaStatic.log(new StatisticItem("c13402").param("tid", this.f.Q().b).param("fid", this.f.Q().y1().l()).param("obj_locate", 1).param("uid", TbadkCoreApplication.getCurrentAccount()));
            }
        }
    }

    public final void z4() {
        PbFragment pbFragment;
        int i3;
        String str;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048803, this) == null) && (pbFragment = this.f) != null && pbFragment.Q() != null && this.f.Q().G != null && this.f.Q().G.N() != null && this.f.Q().G.N().isXiuXiuThread()) {
            ThreadData N = this.f.Q().G.N();
            int i4 = 0;
            if (this.f.Q().d1()) {
                i3 = 1;
            } else if (this.f.Q().g1()) {
                i3 = 2;
            } else {
                i3 = 0;
            }
            ItemInfo itemInfo = TbSingleton.getInstance().getFrsItemInfoCache().get(N.getForum_name());
            if (itemInfo != null) {
                i4 = itemInfo.id.intValue();
                str = itemInfo.name;
            } else {
                str = "";
            }
            new StatisticItem("c15062").addParam("obj_locate", i3).addParam("fid", N.getFid()).addParam("fname", N.getForum_name()).addParam("post_id", N.getTid()).addParam("obj_id", i4).addParam("obj_name", str).eventStat();
        }
    }

    public final void F3() {
        PbFragment pbFragment;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048599, this) == null) && (pbFragment = this.f) != null && pbFragment.getActivity() != null) {
            if (this.F0.getWidth() != 0 && this.F0.getHeight() != 0) {
                WaterRippleView waterRippleView = this.D0;
                if (waterRippleView == null) {
                    this.D0 = new WaterRippleView(this.f.getActivity());
                } else {
                    ViewParent parent = waterRippleView.getParent();
                    if (parent instanceof ViewGroup) {
                        ((ViewGroup) parent).removeView(this.D0);
                    }
                }
                Rect rect = new Rect();
                this.g.getGlobalVisibleRect(rect);
                Rect rect2 = new Rect();
                this.F0.getImgAgree().getGlobalVisibleRect(rect2);
                int g2 = vi.g(this.f.getActivity(), R.dimen.tbds166);
                int i3 = ((rect2.right + rect2.left) / 2) - g2;
                int i4 = (rect.bottom - ((rect2.bottom + rect2.top) / 2)) - g2;
                int i5 = g2 * 2;
                RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(i5, i5);
                layoutParams.addRule(12, -1);
                layoutParams.setMargins(i3, 0, 0, i4);
                this.g.addView(this.D0, layoutParams);
                TextView textView = this.L0;
                if (textView != null) {
                    textView.setVisibility(4);
                    return;
                }
                return;
            }
            BdLog.e("AgreeView not measured");
        }
    }

    public final void e2() {
        PbFragment pbFragment;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048698, this) == null) && (pbFragment = this.f) != null && pbFragment.Q() != null && this.f.Q().G != null && this.f.Q().G.N() != null && this.f.Q().G.N().isQuestionThread()) {
            ThreadData N = this.f.Q().G.N();
            String K1 = this.f.Q().K1();
            String L1 = this.f.Q().L1();
            int i3 = 5;
            if ("question_answer_invite".equals(K1)) {
                i3 = 1;
            } else if ("3".equals(L1)) {
                i3 = 2;
            } else if ("answer_top".equals(K1)) {
                i3 = 3;
            } else if (this.f.Q().d1()) {
                i3 = 4;
            }
            TiebaStatic.log(new StatisticItem("c14924").param("uid", TbadkCoreApplication.getCurrentAccountId()).param("tid", N.getId()).param("fid", N.getFid()).param("obj_source", i3));
        }
    }

    public final void g2() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048706, this) == null) && UbsABTestHelper.isShareTopRight()) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.G0.getLayoutParams();
            layoutParams.addRule(11);
            this.G0.setLayoutParams(layoutParams);
            if (this.H0.getParent() != null) {
                ((ViewGroup) this.H0.getParent()).removeView(this.H0);
                ((ViewGroup) this.I0.getParent()).removeView(this.I0);
            }
            if (this.J0.getParent() != null) {
                ((ViewGroup) this.J0.getParent()).removeView(this.J0);
            }
            RelativeLayout relativeLayout = new RelativeLayout(TbadkCoreApplication.getInst().getContext());
            relativeLayout.setLayoutParams(new LinearLayout.LayoutParams(UtilHelper.getDimenPixelSize(R.dimen.tbds138), -2));
            relativeLayout.addView(this.H0);
            relativeLayout.addView(this.I0);
            relativeLayout.addView(this.J0);
            this.k.a.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, relativeLayout, (View.OnClickListener) null);
            this.k.a.getViewGroup(NavigationBar.ControlAlign.HORIZONTAL_RIGHT).setClipChildren(false);
        }
    }

    public final void o0() {
        m39 m39Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048744, this) == null) && this.C != null && (m39Var = this.R0) != null && m39Var.N() != null && !ListUtils.isEmpty(this.R0.N().getThreadRecommendInfoDataList()) && this.R0.N().getThreadRecommendInfoDataList().get(0) != null && this.x.b().getVisibility() == 0) {
            if (this.x.b().getParent() == null) {
                this.C.g(false);
                return;
            }
            int[] iArr = new int[2];
            this.C.b().getLocationInWindow(iArr);
            if (iArr[1] + this.C.b().getHeight() > this.k.j().getBottom()) {
                this.C.i();
                this.C.g(true);
                return;
            }
            this.C.g(false);
        }
    }

    public void s0() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048764, this) == null) && !this.g2) {
            TiebaStatic.log("c10490");
            this.g2 = true;
            c55 c55Var = new c55(this.f.getPageContext().getPageActivity());
            SparseArray sparseArray = new SparseArray();
            sparseArray.put(j2, Integer.valueOf(l2));
            c55Var.setTitle(R.string.grade_thread_tips);
            View inflate = LayoutInflater.from(this.f.getPageContext().getPageActivity()).inflate(R.layout.upgrade_success_dialog_content, (ViewGroup) null);
            ((TextView) inflate.findViewById(R.id.function_description_view)).setText(R.string.function_upgrade_to_photo_live_tips);
            ((TextView) inflate.findViewById(R.id.title_view)).setText(R.string.grade_thread_tips);
            c55Var.setContentView(inflate);
            c55Var.setYesButtonTag(sparseArray);
            c55Var.setPositiveButton(R.string.grade_button_tips, this.f);
            c55Var.setNegativeButton(R.string.look_again, new s0(this));
            c55Var.create(this.f.getPageContext()).show();
        }
    }

    public final String G0(long j3) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJ = interceptable.invokeJ(1048600, this, j3)) == null) {
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

    public final String H0(int i3) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048604, this, i3)) == null) {
            if (i3 == 0) {
                return this.f.getString(R.string.obfuscated_res_0x7f0f0f91);
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

    public final void H3(SparseArray<Object> sparseArray) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048607, this, sparseArray) != null) || this.f == null) {
            return;
        }
        if (sparseArray != null) {
            sparseArray.put(R.id.tag_is_block_thread, Boolean.TRUE);
        }
        TBAlertConfig.a aVar = new TBAlertConfig.a((int) R.string.obfuscated_res_0x7f0f1390, TBAlertConfig.OperateBtnStyle.MAIN);
        TBAlertConfig.a aVar2 = new TBAlertConfig.a((int) R.string.obfuscated_res_0x7f0f03c9, TBAlertConfig.OperateBtnStyle.SECONDARY);
        TBAlertBuilder tBAlertBuilder = new TBAlertBuilder(this.f.V());
        tBAlertBuilder.w(R.string.musk_my_thread_confirm);
        tBAlertBuilder.m(R.string.musk_my_thread_confirm_subtitle);
        tBAlertBuilder.o(true);
        tBAlertBuilder.u(aVar2, aVar);
        tBAlertBuilder.j(false);
        AlertDialog z2 = tBAlertBuilder.z();
        aVar.a(new a0(this, z2, sparseArray));
        aVar2.a(new b0(this, z2));
    }

    public void X2(EditorTools editorTools) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048670, this, editorTools) == null) {
            this.s0 = editorTools;
            editorTools.setOnCancelClickListener(new t(this));
            this.s0.setId(R.id.obfuscated_res_0x7f091a00);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
            layoutParams.addRule(12);
            if (this.s0.getParent() == null) {
                this.g.addView(this.s0, layoutParams);
            }
            this.s0.y(TbadkCoreApplication.getInst().getSkinType());
            this.s0.setActionListener(24, new u(this));
            w1();
            this.f.I5().g(new v(this));
        }
    }

    public void h4(boolean z2) {
        TextView textView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048713, this, z2) == null) && this.o != null && (textView = this.Y0) != null && this.h != null) {
            if (z2) {
                if (UtilHelper.canUseStyleImmersiveSticky()) {
                    this.h.setVisibility(0);
                } else {
                    this.h.setVisibility(8);
                    this.o.removeHeaderView(this.Y0);
                    this.o.setTextViewAdded(false);
                }
                if (this.Y0.getLayoutParams() instanceof AbsListView.LayoutParams) {
                    AbsListView.LayoutParams layoutParams = (AbsListView.LayoutParams) this.Y0.getLayoutParams();
                    layoutParams.height = h2;
                    this.Y0.setLayoutParams(layoutParams);
                    return;
                }
                return;
            }
            if (textView.getLayoutParams() instanceof AbsListView.LayoutParams) {
                AbsListView.LayoutParams layoutParams2 = (AbsListView.LayoutParams) this.Y0.getLayoutParams();
                layoutParams2.height = BdListViewHelper.a(BdListViewHelper.HeadType.DEFAULT) + e1(true);
                this.Y0.setLayoutParams(layoutParams2);
            }
            P2();
        }
    }

    public void i2(zx9 zx9Var) {
        m39 m39Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048716, this, zx9Var) == null) && zx9Var != null && zx9Var.b != null && (m39Var = this.R0) != null && m39Var.N() != null && this.R0.N().getAgreeData() != null) {
            AgreeData agreeData = this.R0.N().getAgreeData();
            String str = zx9Var.b.nid;
            if (!TextUtils.isEmpty(str) && !"0".equals(str)) {
                BaijiahaoData baijiahaoData = agreeData.baijiahaoData;
                if (baijiahaoData == null || !TextUtils.equals(str, baijiahaoData.oriUgcNid)) {
                    return;
                }
            } else {
                String str2 = zx9Var.b.threadId;
                String str3 = agreeData.threadId;
                if ("0".equals(str2) || TextUtils.isEmpty(str2) || !TextUtils.equals(str2, str3)) {
                    return;
                }
            }
            AgreeData agreeData2 = zx9Var.b;
            L2(agreeData2, agreeData2.agreeNum);
        }
    }

    public final void j4(m39 m39Var) {
        boolean z2;
        s89 s89Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048723, this, m39Var) == null) && !this.A1 && m39Var != null && m39Var.N() != null && !m39Var.N().isVideoThreadType()) {
            ThreadData N = m39Var.N();
            boolean z3 = false;
            if (N.getIs_good() == 1) {
                z2 = true;
            } else {
                z2 = false;
            }
            if (N.getIs_top() == 1) {
                z3 = true;
            }
            u89 u89Var = this.y;
            if (u89Var != null) {
                u89Var.u(m39Var, z2, z3);
            }
            if (N.isShowTitle() && (s89Var = this.x) != null && s89Var.d() != null) {
                u79.b(this.x.d(), N.isHeadLinePost, N.isGoodThread(), N.isTopThread());
            }
            if (I0() != null) {
                I0().I0(m39Var);
            }
        }
    }

    public void m2(TbRichText tbRichText) {
        m39 m39Var;
        jy9 jy9Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048736, this, tbRichText) == null) && (m39Var = this.R0) != null && m39Var.F() != null && !this.R0.F().isEmpty() && tbRichText != null && !StringUtils.isNull(tbRichText.getAuthorId())) {
            for (int i3 = 0; i3 < this.R0.F().size() && (jy9Var = this.R0.F().get(i3)) != null && jy9Var.p() != null && !StringUtils.isNull(jy9Var.p().getUserId()); i3++) {
                if (this.R0.F().get(i3).p().getUserId().equals(tbRichText.getAuthorId())) {
                    q59 q59Var = this.x1;
                    if (q59Var != null && q59Var.l()) {
                        K3(false);
                        return;
                    }
                    return;
                }
            }
        }
    }

    public void u4(m39 m39Var) {
        int i3;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048778, this, m39Var) == null) {
            if (m39Var != null && AntiHelper.o(m39Var.N())) {
                sb9 sb9Var = this.K0;
                if (sb9Var != null) {
                    sb9Var.l(false);
                    this.K0.k();
                }
                ViewGroup.LayoutParams layoutParams = this.H0.getLayoutParams();
                layoutParams.height = -2;
                layoutParams.width = -2;
                this.H0.setLayoutParams(layoutParams);
                WebPManager.setPureDrawable(this.H0, R.drawable.icon_pure_pb_bottom_share26, R.color.CAM_X0110, WebPManager.ResourceStateType.NORMAL_PRESS);
                return;
            }
            sb9 sb9Var2 = this.K0;
            if (sb9Var2 != null && sb9Var2.h()) {
                return;
            }
            ViewGroup.LayoutParams layoutParams2 = this.H0.getLayoutParams();
            layoutParams2.height = -2;
            layoutParams2.width = -2;
            this.H0.setLayoutParams(layoutParams2);
            ImageView imageView = this.H0;
            if (UbsABTestHelper.isShareTopRight()) {
                i3 = R.color.CAM_X0105;
            } else {
                i3 = R.color.CAM_X0107;
            }
            WebPManager.setPureDrawable(imageView, R.drawable.icon_pure_pb_bottom_share26, i3, WebPManager.ResourceStateType.NORMAL_PRESS);
        }
    }

    public void v1(boolean z2) {
        boolean z3;
        boolean z4;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048780, this, z2) == null) && this.z0 != null && this.C0 != null) {
            TbSingleton tbSingleton = TbSingleton.getInstance();
            m39 m39Var = this.R0;
            if (m39Var != null && m39Var.p0()) {
                z3 = true;
            } else {
                z3 = false;
            }
            m39 m39Var2 = this.R0;
            if (m39Var2 != null && m39Var2.q0()) {
                z4 = true;
            } else {
                z4 = false;
            }
            this.C0.setText(tbSingleton.getAdVertiComment(z3, z4, l1()));
            if (z2) {
                AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
                alphaAnimation.setDuration(400L);
                this.z0.startAnimation(alphaAnimation);
            }
            this.y0.setVisibility(0);
            this.z0.setVisibility(0);
            this.N0 = true;
        }
    }

    public void x4(boolean z2) {
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048793, this, z2) == null) {
            d69 d69Var = this.J;
            if (d69Var != null) {
                d69Var.A0(z2);
                this.J.f0();
            }
            PbReplyTitleViewHolder pbReplyTitleViewHolder = this.c1;
            if (pbReplyTitleViewHolder != null) {
                pbReplyTitleViewHolder.p(z2);
            }
            PbReplyTitleViewHolder pbReplyTitleViewHolder2 = this.g1.a;
            if (pbReplyTitleViewHolder2 != null) {
                pbReplyTitleViewHolder2.p(z2);
            }
            PbFragment pbFragment = this.f;
            if (pbFragment != null) {
                pbFragment.M6(z2);
            }
            if (z2) {
                u99.d(this.f.getPageContext(), this.f.Q(), this.f.L5());
            }
            StatisticItem statisticItem = new StatisticItem(CommonStatisticKey.KEY_BATCH_MULTI_DEL_CLICK);
            m39 m39Var = this.R0;
            if (m39Var != null) {
                str = m39Var.l();
            } else {
                str = "0";
            }
            TiebaStatic.log(statisticItem.param("fid", str).param("uid", TbadkCoreApplication.getCurrentAccountId()).param("obj_type", "1"));
        }
    }

    public final void I3(int i3, SparseArray<Object> sparseArray) {
        PbFragment pbFragment;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeIL(1048611, this, i3, sparseArray) == null) && (pbFragment = this.f) != null && pbFragment.Q() != null && this.f.Q().y1() != null && this.f.Q().y1().n() != null && this.f.Q().y1().k() != null && this.f.Q().y1().k().getDeletedReasonInfo() != null) {
            if (sparseArray != null) {
                sparseArray.put(R.id.tag_is_block_thread, Boolean.TRUE);
            }
            o46 o46Var = new o46(this.f.Q().y1().k().getDeletedReasonInfo().is_grays_cale_forum.intValue(), this.f.Q().y1().k().getDeletedReasonInfo().is_boomgrow.intValue(), this.f.Q().y1().n().has_forum_rule.intValue());
            o46Var.i(this.f.Q().y1().k().getId(), this.f.Q().y1().k().getName());
            o46Var.h(this.f.Q().y1().k().getImage_url());
            o46Var.j(this.f.Q().y1().k().getUser_level());
            T3(sparseArray, i3, o46Var, this.f.Q().y1().U(), true);
        }
    }

    public final void b4(c55 c55Var, int i3) {
        PbFragment pbFragment;
        String str;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLI(1048688, this, c55Var, i3) == null) && (pbFragment = this.f) != null && c55Var != null) {
            if (this.D1 == null && this.w != null) {
                this.D1 = new m46(pbFragment.getPageContext(), this.w.c());
            }
            AntiData s5 = this.f.s5();
            SparseArray<String> sparseArray = new SparseArray<>();
            if (s5 != null && s5.getDelThreadInfoList() != null) {
                List<DeleteThreadInfo> delThreadInfoList = s5.getDelThreadInfoList();
                for (int i4 = 0; i4 < delThreadInfoList.size(); i4++) {
                    if (!TextUtils.isEmpty(delThreadInfoList.get(i4).text_info)) {
                        sparseArray.put(delThreadInfoList.get(i4).text_id, delThreadInfoList.get(i4).text_info);
                    }
                }
            }
            g35 g35Var = new g35();
            g35Var.j(sparseArray);
            this.D1.B(new String[]{this.f.getString(R.string.delete_thread_reason_1), this.f.getString(R.string.delete_thread_reason_2), this.f.getString(R.string.delete_thread_reason_3), this.f.getString(R.string.delete_thread_reason_4), this.f.getString(R.string.delete_thread_reason_5)});
            this.D1.A(g35Var);
            if (i3 != 1 && i3 != 2) {
                str = "3";
            } else {
                str = "4";
            }
            this.D1.D(str);
            this.D1.C(new c0(this, c55Var));
        }
    }

    public void g4(k35 k35Var, c55.e eVar) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLL(1048708, this, k35Var, eVar) != null) || k35Var == null) {
            return;
        }
        int a2 = k35Var.a();
        int h3 = k35Var.h();
        c55 c55Var = this.K;
        if (c55Var != null) {
            c55Var.show();
        } else {
            this.K = new c55(this.f.getPageContext().getPageActivity());
            View inflate = LayoutInflater.from(this.f.getPageContext().getPageActivity()).inflate(R.layout.obfuscated_res_0x7f0d025e, (ViewGroup) null);
            this.M = inflate;
            this.K.setContentView(inflate);
            this.K.setPositiveButton(R.string.obfuscated_res_0x7f0f058f, eVar);
            this.K.setNegativeButton(R.string.obfuscated_res_0x7f0f0584, new p0(this));
            this.K.setOnCalcelListener(new q0(this));
            this.K.create(this.f.getPageContext()).show();
        }
        EditText editText = (EditText) this.M.findViewById(R.id.obfuscated_res_0x7f0910f6);
        this.N = editText;
        editText.setText("");
        TextView textView = (TextView) this.M.findViewById(R.id.obfuscated_res_0x7f09081c);
        if (a2 <= 0) {
            a2 = 1;
        }
        if (h3 <= 0) {
            h3 = 1;
        }
        textView.setText(MessageFormat.format(TbadkCoreApplication.getInst().getResources().getString(R.string.current_page), Integer.valueOf(a2), Integer.valueOf(h3)));
        this.f.getBaseFragmentActivity().ShowSoftKeyPadDelay(this.N, 150);
    }

    public boolean v4(m39 m39Var, boolean z2) {
        InterceptResult invokeLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(1048783, this, m39Var, z2)) == null) {
            if (m39Var == null) {
                return false;
            }
            if (this.x != null) {
                if (m39Var.N() != null && m39Var.N().getIsNoTitle() == 0 && !m39Var.N().isVideoThreadType()) {
                    if (m39Var.N() != null) {
                        ThreadData N = m39Var.N();
                        N.parserSpecTitleForFrsAndPb(true, N3(m39Var));
                        N.setResource(3);
                        N.setPbTitle("2");
                    }
                    if (m39Var.N().isBJHArticleThreadType()) {
                        this.y.G(this.o);
                        this.x.h(this.o);
                        this.x.a(this.o);
                        this.y.q(this.o);
                        this.y.L(this.R0);
                        if (S1(m39Var)) {
                            this.x.h(this.o);
                        } else {
                            this.x.i(m39Var);
                        }
                    } else {
                        this.y.L(this.R0);
                        if (S1(m39Var)) {
                            this.x.h(this.o);
                        } else {
                            this.x.k(m39Var);
                        }
                    }
                } else if (m39Var.N().getIsNoTitle() == 1) {
                    if (m39Var.N() != null) {
                        this.x.h(this.o);
                        this.y.L(this.R0);
                    }
                } else {
                    this.x.h(this.o);
                    this.y.L(this.R0);
                }
            }
            i4(m39Var.W());
            j4(m39Var);
            this.Q0 = z2;
            return false;
        }
        return invokeLZ.booleanValue;
    }

    public void K3(boolean z2) {
        boolean z3;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeZ(1048619, this, z2) != null) || this.z0 == null) {
            return;
        }
        if (this.f.I5() != null && this.f.I5().z()) {
            z3 = true;
        } else {
            z3 = false;
        }
        c3(z3);
        if (this.t0) {
            O3(z2);
        } else {
            v1(z2);
        }
    }

    public void N1(m39 m39Var) {
        lc5 pbAdFloatViewItemData;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048629, this, m39Var) != null) || m39Var == null) {
            return;
        }
        if (m39Var.p0()) {
            pbAdFloatViewItemData = m39Var.a0();
        } else {
            pbAdFloatViewItemData = TbSingleton.getInstance().getPbAdFloatViewItemData();
        }
        if (pbAdFloatViewItemData != null && !pbAdFloatViewItemData.a()) {
            M1(m39Var, pbAdFloatViewItemData);
        } else {
            B1();
        }
    }

    public void O3(boolean z2) {
        TextView textView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048635, this, z2) == null) && this.z0 != null && (textView = this.C0) != null) {
            textView.setText(R.string.obfuscated_res_0x7f0f05f9);
            if (z2) {
                AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
                alphaAnimation.setDuration(400L);
                this.z0.startAnimation(alphaAnimation);
            }
            this.y0.setVisibility(0);
            this.z0.setVisibility(0);
            this.N0 = true;
        }
    }

    public final boolean Y1(ThreadData threadData) {
        InterceptResult invokeL;
        String str;
        jy9 W;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048673, this, threadData)) == null) {
            if (threadData != null && threadData.getAuthor() != null) {
                m39 m39Var = this.R0;
                if (m39Var != null && (W = m39Var.W()) != null && W.p() != null) {
                    str = W.p().getUserId();
                } else {
                    str = "";
                }
                return TextUtils.equals(TbadkCoreApplication.getCurrentAccount(), str);
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public final boolean b2(m39 m39Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048686, this, m39Var)) == null) {
            if (m39Var == null) {
                return true;
            }
            ArrayList<jy9> F = m39Var.F();
            if (ListUtils.getCount(F) == 0) {
                return true;
            }
            if (ListUtils.getCount(F) == 1 && ListUtils.getItem(F, 0) != null && ((jy9) ListUtils.getItem(F, 0)).D() == 1) {
                return true;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public void k2(Configuration configuration) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048726, this, configuration) != null) || configuration == null) {
            return;
        }
        v0();
        if (configuration.orientation == 2) {
            u1();
            w1();
        } else {
            U2();
        }
        r69 r69Var = this.l1;
        if (r69Var != null) {
            r69Var.g();
        }
        this.f.U5();
        this.I.setVisibility(8);
        this.k.v(false);
        this.f.N6(false);
    }

    public final int m1(PbReplyTitleViewHolder pbReplyTitleViewHolder) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048735, this, pbReplyTitleViewHolder)) == null) {
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

    public void p2(boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048751, this, z2) == null) {
            if (z2) {
                Q3();
            } else {
                x1();
            }
            this.g1.a = null;
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004013, this.g1));
            I2(this.g1.a, false);
        }
    }

    public void r4(boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048763, this, z2) == null) {
            this.k.B(z2);
            if (z2 && this.V0) {
                this.P.H(TbadkCoreApplication.getInst().getResources().getString(R.string.click_load_more));
                PbLandscapeListView pbLandscapeListView = this.o;
                if (pbLandscapeListView != null) {
                    pbLandscapeListView.setNextPage(this.P);
                }
                this.i = 2;
            }
        }
    }

    public final void L2(AgreeData agreeData, long j3) {
        TextView textView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLJ(1048622, this, agreeData, j3) == null) && agreeData != null && (textView = this.L0) != null) {
            if (j3 > 0) {
                if (agreeData.agreeType == 2 && agreeData.hasAgree) {
                    textView.setTextColor(SkinManager.getColor(R.color.CAM_X0301));
                } else {
                    this.L0.setTextColor(SkinManager.getColor(R.color.CAM_X0107));
                }
                this.L0.setText(G0(j3));
                this.L0.setVisibility(0);
                return;
            }
            textView.setVisibility(8);
        }
    }

    public void w2(AbsListView absListView, int i3) {
        RightFloatLayerView rightFloatLayerView;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048786, this, absListView, i3) == null) {
            if (i3 == 0) {
                this.g1.a = null;
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004013, this.g1));
                I2(this.g1.a, true);
                u0();
                this.J.m0(true);
            }
            this.J.l0();
            if (i3 == 0) {
                RightFloatLayerView rightFloatLayerView2 = this.P1;
                if (rightFloatLayerView2 != null) {
                    rightFloatLayerView2.p();
                }
                o0();
            } else if (i3 == 1) {
                RightFloatLayerView rightFloatLayerView3 = this.P1;
                if (rightFloatLayerView3 != null) {
                    rightFloatLayerView3.o();
                }
            } else if (i3 == 2 && (rightFloatLayerView = this.P1) != null) {
                rightFloatLayerView.q();
            }
        }
    }

    public void L3(m39 m39Var) {
        jy9 jy9Var;
        ga9 ga9Var;
        boolean z2;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048623, this, m39Var) == null) && m39Var != null && (jy9Var = this.S0) != null && jy9Var.p() != null && (ga9Var = this.k) != null) {
            boolean z3 = !this.o1;
            this.p1 = z3;
            ga9Var.A(z3);
            if (this.f.J5() != null) {
                this.f.J5().s(this.p1);
            }
            J2();
            PbFragment pbFragment = this.f;
            if (pbFragment != null && !pbFragment.z0() && !ListUtils.isEmpty(m39Var.o())) {
                j45 j45Var = m39Var.o().get(0);
                if (j45Var != null) {
                    this.k.D(m39Var, j45Var.d(), j45Var.b(), j45Var.a(), j45Var.f());
                }
            } else if (m39Var.k() != null) {
                ga9 ga9Var2 = this.k;
                String name = m39Var.k().getName();
                String id = m39Var.k().getId();
                String image_url = m39Var.k().getImage_url();
                if (m39Var.k().isLike() == 1) {
                    z2 = true;
                } else {
                    z2 = false;
                }
                ga9Var2.D(m39Var, name, id, image_url, z2);
            }
            if (this.p1) {
                this.y.Q(m39Var, this.S0, this.n0);
                View view2 = this.b1;
                if (view2 != null) {
                    view2.setVisibility(8);
                }
                if (this.y1 == null) {
                    this.y1 = new o0(this);
                }
                PbLandscapeListView pbLandscapeListView = this.o;
                if (pbLandscapeListView != null) {
                    pbLandscapeListView.setListViewDragListener(this.y1);
                    return;
                }
                return;
            }
            View view3 = this.b1;
            if (view3 != null) {
                view3.setVisibility(0);
            }
            this.y.Q(m39Var, this.S0, this.n0);
            this.y1 = null;
            PbLandscapeListView pbLandscapeListView2 = this.o;
            if (pbLandscapeListView2 != null) {
                pbLandscapeListView2.setListViewDragListener(null);
            }
        }
    }

    public final void M2(m39 m39Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048626, this, m39Var) == null) && m39Var != null && m39Var.N() != null) {
            u4(m39Var);
            ImageView imageView = this.G0;
            if (imageView != null && imageView.getContext() != null) {
                if (m39Var.q()) {
                    WebPManager.setPureDrawable(this.G0, R.drawable.icon_pure_pb_bottom_collected26_selection, R.color.CAM_X0305, WebPManager.ResourceStateType.NORMAL_PRESS);
                } else {
                    WebPManager.setPureDrawable(this.G0, R.drawable.icon_pure_pb_bottom_collect26, R.color.CAM_X0107, WebPManager.ResourceStateType.NORMAL_PRESS);
                }
            }
            String H0 = H0(m39Var.N().getReply_num());
            TextView textView = this.M0;
            if (textView != null) {
                textView.setText(H0);
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921416, m39Var.N()));
            L2(m39Var.N().getAgreeData(), m39Var.N().getAgreeNum());
            if (this.F0 != null && m39Var.N() != null) {
                this.F0.setThreadData(m39Var.N());
                int i3 = 1;
                if (m39Var.N().getAgreeData() != null) {
                    m39Var.N().getAgreeData().isInThread = true;
                }
                this.F0.setData(m39Var.N().getAgreeData());
                n15 n15Var = new n15();
                n15Var.b = 26;
                if (m39Var.N().isVideoThreadType() && m39Var.N().getThreadVideoInfo() != null) {
                    i3 = 2;
                }
                n15Var.c = i3;
                PbFragment pbFragment = this.f;
                if (pbFragment != null && pbFragment.Q() != null) {
                    n15Var.j = this.f.Q().getFromForumId();
                    n15Var.f = this.f.Q().x1();
                }
                this.F0.setStatisticData(n15Var);
            }
        }
    }

    public void P3(View view2) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048639, this, view2) != null) || n95.m().i("show_long_press_collection_tips", false)) {
            return;
        }
        Rect rect = new Rect();
        this.z0.getGlobalVisibleRect(rect);
        int i3 = rect.bottom;
        int i4 = rect.top;
        view2.getGlobalVisibleRect(rect);
        int i5 = rect.bottom;
        FrameLayout frameLayout = new FrameLayout(this.f.getContext());
        frameLayout.setBackgroundResource(R.drawable.pic_sign_tip);
        TextView textView = new TextView(this.f.getContext());
        this.u1 = textView;
        textView.setText(R.string.obfuscated_res_0x7f0f04c7);
        this.u1.setGravity(17);
        this.u1.setPadding(vi.g(this.f.getContext(), R.dimen.obfuscated_res_0x7f0701e8), 0, vi.g(this.f.getContext(), R.dimen.obfuscated_res_0x7f0701e8), 0);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        layoutParams.gravity = 17;
        layoutParams.height = vi.g(this.f.getContext(), R.dimen.obfuscated_res_0x7f070253);
        if (this.u1.getParent() == null) {
            frameLayout.addView(this.u1, layoutParams);
        }
        PopupWindow popupWindow = new PopupWindow(this.f.getContext());
        this.t1 = popupWindow;
        popupWindow.setContentView(frameLayout);
        this.t1.setHeight(-2);
        this.t1.setWidth(-2);
        this.t1.setFocusable(true);
        this.t1.setOutsideTouchable(false);
        this.t1.setBackgroundDrawable(new ColorDrawable(TbadkCoreApplication.getInst().getResources().getColor(R.color.transparent)));
        GreyUtil.grey(this.t1);
        PbLandscapeListView pbLandscapeListView = this.o;
        if (pbLandscapeListView != null) {
            pbLandscapeListView.postDelayed(new u0(this, i5, i3, i4, view2), 100L);
        }
        n95.m().w("show_long_press_collection_tips", true);
    }

    public void Q1(m39 m39Var) {
        PbReplyTitleViewHolder pbReplyTitleViewHolder;
        int bottom;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048641, this, m39Var) == null) {
            int i3 = 0;
            this.J.n0(m39Var, false);
            this.J.f0();
            y0();
            q59 q59Var = this.x1;
            if (q59Var != null) {
                q59Var.n();
            }
            ArrayList<jy9> F = m39Var.F();
            if (m39Var.y().b() == 0 || F == null || F.size() < m39Var.y().e()) {
                if (b2(m39Var)) {
                    b1 b1Var = this.g1;
                    if (b1Var != null && (pbReplyTitleViewHolder = b1Var.a) != null && pbReplyTitleViewHolder.getView() != null) {
                        if (this.g1.a.getView().getTop() < 0) {
                            bottom = this.g1.a.getView().getHeight();
                        } else {
                            bottom = this.g1.a.getView().getBottom();
                        }
                        i3 = bottom;
                    }
                    if (this.f.d6()) {
                        this.P.K(TbadkCoreApplication.getInst().getResources().getString(R.string.obfuscated_res_0x7f0f0faf), i3);
                    } else {
                        this.P.K(TbadkCoreApplication.getInst().getResources().getString(R.string.obfuscated_res_0x7f0f0fb0), i3);
                    }
                } else {
                    if (m39Var.y().b() == 0) {
                        this.P.H(TbadkCoreApplication.getInst().getResources().getString(R.string.list_has_all_comments));
                    } else {
                        this.P.H(TbadkCoreApplication.getInst().getResources().getString(R.string.load_more));
                    }
                    this.P.n();
                }
            }
            M2(m39Var);
        }
    }

    public void Z3(AdapterView.OnItemClickListener onItemClickListener) {
        boolean z2;
        boolean z3;
        boolean z4;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048679, this, onItemClickListener) == null) {
            g55 g55Var = this.l0;
            if (g55Var != null) {
                g55Var.d();
                this.l0 = null;
            }
            if (this.R0 == null) {
                return;
            }
            ArrayList<p55> arrayList = new ArrayList<>();
            String string = this.f.getContext().getString(R.string.all_person);
            boolean z5 = false;
            if (this.R0.J() == 1) {
                z2 = true;
            } else {
                z2 = false;
            }
            arrayList.add(new p55(string, "", z2, Integer.toString(1)));
            String string2 = this.f.getContext().getString(R.string.my_fans);
            if (this.R0.J() == 2) {
                z3 = true;
            } else {
                z3 = false;
            }
            arrayList.add(new p55(string2, "", z3, Integer.toString(5)));
            String string3 = this.f.getContext().getString(R.string.my_attentions);
            if (this.R0.J() == 3) {
                z4 = true;
            } else {
                z4 = false;
            }
            arrayList.add(new p55(string3, "", z4, Integer.toString(6)));
            String string4 = this.f.getContext().getString(R.string.myself_only);
            if (this.R0.J() == 4) {
                z5 = true;
            }
            arrayList.add(new p55(string4, "", z5, Integer.toString(7)));
            g55 g55Var2 = new g55(this.f.getPageContext());
            g55Var2.l(R.string.pb_privacy_setting_thread_reply_decs);
            this.l0 = g55Var2;
            g55Var2.k(arrayList, onItemClickListener);
            g55Var2.c();
            this.l0.n();
        }
    }

    public final void M1(m39 m39Var, lc5 lc5Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048625, this, m39Var, lc5Var) == null) && this.Q1 != null && m39Var != null && lc5Var != null && this.f.getContext() != null) {
            if (!RightFloatLayerView.k()) {
                B1();
                return;
            }
            if (this.P1 == null) {
                RightFloatLayerView E = RightFloatLayerLottieView.E(lc5Var, this.f.getContext());
                this.P1 = E;
                E.setPageContext(this.f.getPageContext());
                this.Q1.removeAllViews();
                this.Q1.addView(this.P1);
            }
            if ((this.O1.getTag() instanceof Boolean) && !((Boolean) this.O1.getTag()).booleanValue()) {
                this.P1.setAutoCompleteShown(false);
                this.P1.setTag(this.O1);
                this.P1.c();
            }
            if (lc5Var.a()) {
                return;
            }
            this.P1.setData(lc5Var);
            this.P1.setLogoListener(new r0(this, lc5Var));
            this.P1.setFeedBackListener(new w0(this, lc5Var));
        }
    }

    public final void M3(SparseArray<Object> sparseArray, @StringRes int i3, @StringRes int i4) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLII(1048627, this, sparseArray, i3, i4) != null) || this.f == null) {
            return;
        }
        TBAlertConfig.a aVar = new TBAlertConfig.a((int) R.string.obfuscated_res_0x7f0f053f, TBAlertConfig.OperateBtnStyle.MAIN);
        TBAlertConfig.a aVar2 = new TBAlertConfig.a((int) R.string.obfuscated_res_0x7f0f03c9, TBAlertConfig.OperateBtnStyle.SECONDARY);
        TBAlertBuilder tBAlertBuilder = new TBAlertBuilder(this.f.V());
        tBAlertBuilder.w(i3);
        tBAlertBuilder.m(i4);
        tBAlertBuilder.o(true);
        tBAlertBuilder.u(aVar2, aVar);
        tBAlertBuilder.j(false);
        AlertDialog z2 = tBAlertBuilder.z();
        aVar.a(new y(this, z2, sparseArray));
        aVar2.a(new z(this, z2));
    }

    public void N2(int i3, m39 m39Var, boolean z2, int i4) {
        jy9 W;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(1048630, this, new Object[]{Integer.valueOf(i3), m39Var, Boolean.valueOf(z2), Integer.valueOf(i4)}) == null) && i3 > 0 && m39Var != null && (W = m39Var.W()) != null && W.p() != null) {
            MetaData p3 = W.p();
            p3.setGiftNum(p3.getGiftNum() + i3);
        }
    }

    public void O2(m39 m39Var, boolean z2, int i3, int i4) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048634, this, new Object[]{m39Var, Boolean.valueOf(z2), Integer.valueOf(i3), Integer.valueOf(i4)}) == null) {
            W3(m39Var, z2, i3, i4);
            this.y.C(i4);
        }
    }

    public void y2(int i3, String str, int i4, boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048796, this, new Object[]{Integer.valueOf(i3), str, Integer.valueOf(i4), Boolean.valueOf(z2)}) == null) {
            z2(i3, str, i4, z2, null);
        }
    }

    public final void T3(SparseArray<Object> sparseArray, int i3, o46 o46Var, UserData userData, boolean z2) {
        PbFragment pbFragment;
        String str;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeCommon(1048655, this, new Object[]{sparseArray, Integer.valueOf(i3), o46Var, userData, Boolean.valueOf(z2)}) != null) || (pbFragment = this.f) == null) {
            return;
        }
        if (this.E1 == null && this.w != null) {
            this.E1 = new p46(pbFragment.getPageContext(), this.w.c(), o46Var, userData);
        }
        this.E1.F(z2);
        AntiData s5 = this.f.s5();
        SparseArray<String> sparseArray2 = new SparseArray<>();
        if (s5 != null && s5.getDelThreadInfoList() != null) {
            List<DeleteThreadInfo> delThreadInfoList = s5.getDelThreadInfoList();
            for (int i4 = 0; i4 < delThreadInfoList.size(); i4++) {
                if (!TextUtils.isEmpty(delThreadInfoList.get(i4).text_info)) {
                    sparseArray2.put(delThreadInfoList.get(i4).text_id, delThreadInfoList.get(i4).text_info);
                }
            }
        }
        g35 g35Var = new g35();
        g35Var.j(sparseArray2);
        this.E1.H(new String[]{this.f.getString(R.string.delete_thread_reason_1), this.f.getString(R.string.delete_thread_reason_2), this.f.getString(R.string.delete_thread_reason_3), this.f.getString(R.string.delete_thread_reason_4), this.f.getString(R.string.delete_thread_reason_5)});
        this.E1.G(g35Var);
        if (i3 != 1 && i3 != 2) {
            str = "3";
        } else {
            str = "4";
        }
        this.E1.J(str);
        this.E1.I(new d0(this, sparseArray));
    }

    public void Y3(e55.c cVar, boolean z2, boolean z3, boolean z4, boolean z5) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048675, this, new Object[]{cVar, Boolean.valueOf(z2), Boolean.valueOf(z3), Boolean.valueOf(z4), Boolean.valueOf(z5)}) == null) {
            l55 l55Var = this.j0;
            if (l55Var != null) {
                l55Var.dismiss();
                this.j0 = null;
            }
            n55 n55Var = new n55(this.f.getContext());
            ArrayList arrayList = new ArrayList();
            if (!z4 && !z5) {
                arrayList.add(new j55(0, this.f.getPageContext().getString(R.string.obfuscated_res_0x7f0f04db), n55Var));
            }
            if (z3) {
                arrayList.add(new j55(1, this.f.getPageContext().getString(R.string.report_text), n55Var));
            } else if (!z2) {
                arrayList.add(new j55(1, this.f.getPageContext().getString(R.string.obfuscated_res_0x7f0f0c27), n55Var));
            } else {
                arrayList.add(new j55(1, this.f.getPageContext().getString(R.string.remove_mark), n55Var));
            }
            n55Var.l(arrayList);
            n55Var.q(new h0(this, cVar));
            l55 l55Var2 = new l55(this.f.getPageContext(), n55Var);
            this.k0 = l55Var2;
            l55Var2.l();
        }
    }

    public void V3(m39 m39Var, int i3, int i4, boolean z2, int i5, boolean z3) {
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
        m39 m39Var2;
        Parcelable e2;
        Parcelable e3;
        int size2;
        int i8;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(1048663, this, new Object[]{m39Var, Integer.valueOf(i3), Integer.valueOf(i4), Boolean.valueOf(z2), Integer.valueOf(i5), Boolean.valueOf(z3)}) == null) && m39Var != null && this.o != null) {
            this.R0 = m39Var;
            this.T0 = i3;
            if (m39Var.N() != null) {
                this.h1 = m39Var.N().getCopyThreadRemindType();
                this.n0 = Y1(m39Var.N());
            }
            if (m39Var.U() != null) {
                this.c2 = m39Var.U().getUserId();
            }
            I1(m39Var);
            l0();
            this.V0 = false;
            this.Q0 = z2;
            w3();
            y39 y39Var = m39Var.h;
            if (y39Var != null && y39Var.b()) {
                if (this.r == null) {
                    PbThreadPostView pbThreadPostView = new PbThreadPostView(this.f.getContext());
                    this.r = pbThreadPostView;
                    this.o.w(pbThreadPostView, 1);
                    this.r.setData(m39Var);
                    this.r.setChildOnClickLinstener(this.U);
                }
            } else {
                PbThreadPostView pbThreadPostView2 = this.r;
                if (pbThreadPostView2 != null && (pbLandscapeListView = this.o) != null) {
                    pbLandscapeListView.removeHeaderView(pbThreadPostView2);
                }
            }
            W3(m39Var, z2, i3, TbadkCoreApplication.getInst().getSkinType());
            L3(m39Var);
            this.y.R(m39Var, this.S0);
            if (this.B1 == null) {
                this.B1 = new f79(this.f.getPageContext(), this.C1);
            }
            this.B1.a(m39Var.w());
            if (this.f.B5()) {
                if (this.O == null) {
                    tb9 tb9Var = new tb9(this.f.getPageContext());
                    this.O = tb9Var;
                    tb9Var.n();
                    this.O.f(this.d2);
                }
                this.o.setPullRefresh(this.O);
                tb9 tb9Var2 = this.O;
                if (tb9Var2 != null) {
                    tb9Var2.H(TbadkCoreApplication.getInst().getSkinType());
                }
            } else if (m39Var.y().c() == 0 && z2) {
                this.o.setPullRefresh(null);
            } else {
                if (this.O == null) {
                    tb9 tb9Var3 = new tb9(this.f.getPageContext());
                    this.O = tb9Var3;
                    tb9Var3.n();
                    this.O.f(this.d2);
                }
                this.o.setPullRefresh(this.O);
                tb9 tb9Var4 = this.O;
                if (tb9Var4 != null) {
                    tb9Var4.H(TbadkCoreApplication.getInst().getSkinType());
                }
                y1();
            }
            y0();
            this.J.v0(this.Q0);
            this.J.s0(false);
            d69 d69Var = this.J;
            if (i3 == 5) {
                z4 = true;
            } else {
                z4 = false;
            }
            d69Var.t0(z4);
            d69 d69Var2 = this.J;
            if (i3 == 6) {
                z5 = true;
            } else {
                z5 = false;
            }
            d69Var2.u0(z5);
            d69 d69Var3 = this.J;
            if (z3 && this.a2 && i3 != 2) {
                z6 = true;
            } else {
                z6 = false;
            }
            d69Var3.q0(z6);
            this.J.n0(m39Var, false);
            this.J.f0();
            d69 d69Var4 = this.J;
            if (m39Var.y().b() != 0) {
                z7 = true;
            } else {
                z7 = false;
            }
            d69Var4.h0(z7, m39Var.f());
            this.y.P(m39Var.W(), m39Var.i0());
            if (m39Var.N() != null && m39Var.N().getPraise() != null && this.e != -1) {
                m39Var.N().getPraise().setIsLike(this.e);
            }
            this.o.removeFooterView(this.d1);
            this.o.addFooterView(this.d1);
            if (TbadkCoreApplication.isLogin()) {
                this.o.setNextPage(this.P);
                this.i = 2;
                y1();
            } else {
                this.V0 = true;
                if (m39Var.y().b() == 1) {
                    if (this.Q == null) {
                        PbFragment pbFragment2 = this.f;
                        this.Q = new ob9(pbFragment2, pbFragment2);
                    }
                    this.o.setNextPage(this.Q);
                } else {
                    this.o.setNextPage(this.P);
                }
                this.i = 3;
            }
            ArrayList<jy9> F = m39Var.F();
            if (m39Var.y().b() != 0 && F != null && F.size() >= m39Var.y().e()) {
                if (z3) {
                    if (this.a2) {
                        C0();
                        if (m39Var.y().b() != 0) {
                            this.P.H(TbadkCoreApplication.getInst().getResources().getString(R.string.pb_load_more));
                        }
                    } else {
                        this.P.D();
                        this.P.R();
                    }
                } else {
                    this.P.D();
                    this.P.R();
                }
                this.P.n();
            } else {
                if (b2(m39Var)) {
                    b1 b1Var = this.g1;
                    if (b1Var != null && (pbReplyTitleViewHolder = b1Var.a) != null && pbReplyTitleViewHolder.getView() != null) {
                        if (this.g1.a.getView().getTop() < 0) {
                            i6 = this.g1.a.getView().getHeight();
                        } else {
                            i6 = this.g1.a.getView().getBottom();
                        }
                    } else {
                        i6 = 0;
                    }
                    if (this.f.d6()) {
                        this.P.y(false);
                        if (ListUtils.isEmpty(m39Var.Q())) {
                            this.P.K(TbadkCoreApplication.getInst().getResources().getString(R.string.obfuscated_res_0x7f0f0faf), i6);
                        }
                    } else if (ListUtils.isEmpty(m39Var.Q())) {
                        this.P.K(TbadkCoreApplication.getInst().getResources().getString(R.string.obfuscated_res_0x7f0f0fb0), i6);
                    }
                    if (this.f.J5() != null && !this.f.J5().p()) {
                        this.f.J5().x();
                    }
                } else {
                    if (m39Var.y().b() == 0) {
                        jy9 jy9Var = (jy9) ListUtils.getItem(F, ListUtils.getCount(F) - 1);
                        if (jy9Var != null) {
                            jy9Var.P = false;
                        }
                        this.P.E(-UtilHelper.getDimenPixelSize(R.dimen.tbds36));
                        this.o.setClipChildren(false);
                        this.P.H(TbadkCoreApplication.getInst().getResources().getString(R.string.list_has_all_comments));
                    } else {
                        this.P.H(TbadkCoreApplication.getInst().getResources().getString(R.string.load_more));
                    }
                    this.P.n();
                }
                if (m39Var.y().b() == 0 || F == null) {
                    Q2();
                }
            }
            if (i3 != 2) {
                if (i3 != 3) {
                    if (i3 != 4) {
                        if (i3 != 5) {
                            if (i3 != 6) {
                                if (i3 == 8) {
                                    if (i4 == 0) {
                                        this.o.setSelection(this.J.D() + this.o.getHeaderViewsCount());
                                    } else if (ListUtils.isEmpty(m39Var.Q())) {
                                        if (this.o.getData() == null && m39Var.F() == null) {
                                            size2 = 0;
                                        } else {
                                            size2 = (this.o.getData().size() - m39Var.F().size()) + this.o.getHeaderViewsCount();
                                        }
                                        PbLandscapeListView pbLandscapeListView2 = this.o;
                                        if (i4 > 0) {
                                            i8 = size2 + i4;
                                        } else {
                                            i8 = 0;
                                        }
                                        pbLandscapeListView2.setSelection(i8);
                                    } else {
                                        this.o.setSelection(m39Var.F().size() + this.o.getHeaderViewsCount());
                                    }
                                    this.P.g();
                                    this.P.H(this.f.getString(R.string.obfuscated_res_0x7f0f0fa9));
                                    this.P.B();
                                }
                            } else if (i5 == 1 && (e3 = l79.b().e()) != null && !(e3 instanceof RecyclerView.SavedState)) {
                                this.o.onRestoreInstanceState(e3);
                            } else {
                                this.o.setSelection(0);
                            }
                        } else {
                            this.o.setSelection(0);
                        }
                    } else {
                        this.a2 = false;
                    }
                } else if (i5 == 1 && (e2 = l79.b().e()) != null && !(e2 instanceof RecyclerView.SavedState)) {
                    this.o.post(new n0(this, e2, F, m39Var));
                }
            } else {
                if (this.o.getData() == null && m39Var.F() == null) {
                    size = 0;
                } else {
                    size = (this.o.getData().size() - m39Var.F().size()) + this.o.getHeaderViewsCount();
                }
                PbLandscapeListView pbLandscapeListView3 = this.o;
                if (i4 > 1) {
                    i7 = (size + i4) - 2;
                } else {
                    i7 = 0;
                }
                pbLandscapeListView3.setSelection(i7);
            }
            if (this.h1 == i2 && W1()) {
                s0();
            }
            if (this.m1) {
                K2();
                this.m1 = false;
                if (i5 == 0) {
                    m3(true);
                }
            }
            if (m39Var.d == 1 || m39Var.e == 1) {
                if (this.s1 == null) {
                    this.s1 = new PbTopTipView(this.f.getContext());
                }
                if (m39Var.e == 1 && "game_guide".equals(this.f.N5())) {
                    this.s1.setText(this.f.getString(R.string.obfuscated_res_0x7f0f0fbb));
                    this.s1.l(this.g, this.U0);
                } else if (m39Var.d == 1 && "game_news".equals(this.f.N5())) {
                    this.s1.setText(this.f.getString(R.string.obfuscated_res_0x7f0f0fba));
                    this.s1.l(this.g, this.U0);
                }
            }
            P1(m39Var);
            int i9 = this.c;
            if (i9 == -1) {
                i9 = Q0();
            }
            this.c = i9;
            this.o.removeFooterView(this.M1.a());
            if (!ListUtils.isEmpty(m39Var.H()) && m39Var.y().b() == 0) {
                this.o.removeFooterView(this.d1);
                this.M1.d(Math.max(this.z0.getMeasuredHeight(), this.O0 / 2));
                this.o.addFooterView(this.M1.a());
                this.M1.f(m39Var);
            }
            M2(m39Var);
            if (m39Var.g0() && this.f.Q().p2() && this.f.K5() != null) {
                this.f.K5().d();
            }
            if (m39Var.f() != 3) {
                N1(m39Var);
            }
            this.C0.setText(TbSingleton.getInstance().getAdVertiComment(m39Var.p0(), m39Var.q0(), l1()));
            if (this.s != null && (m39Var2 = this.R0) != null && m39Var2.k() != null) {
                this.s.m(this.R0.k().getImage_url());
                this.s.n(this.R0.k().getName());
                PbFragment pbFragment3 = this.f;
                if (pbFragment3 != null && pbFragment3.Q() != null) {
                    this.s.o(this.f.Q().b);
                }
            }
            if (this.u != null) {
                m39 m39Var3 = this.R0;
                if (m39Var3 != null && m39Var3.k() != null && (pbFragment = this.f) != null && pbFragment.Q() != null) {
                    this.u.r(this.f.Q().b);
                }
                m39 m39Var4 = this.R0;
                if (m39Var4 != null && m39Var4.N() != null && !ListUtils.isEmpty(this.R0.N().getThreadRecommendInfoDataList()) && this.R0.N().getThreadRecommendInfoDataList().get(0) != null && this.R0.N().getThreadRecommendInfoDataList().get(0).businessType != 1) {
                    this.u.q(this.R0.N().getThreadRecommendInfoDataList().get(0));
                } else {
                    this.u.q(null);
                }
            }
            if (this.E != null && this.R0.k() != null) {
                this.E.o(this.R0.k().getSpritePBGuide(), this.R0.k().getImage_url(), this.R0.k().getId());
            }
            if (D3()) {
                this.C.e(this.R0.N());
            } else {
                this.C.d(this.o);
            }
        }
    }

    @SuppressLint({"ResourceAsColor"})
    public final void W3(m39 m39Var, boolean z2, int i3, int i4) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(1048667, this, new Object[]{m39Var, Boolean.valueOf(z2), Integer.valueOf(i3), Integer.valueOf(i4)}) == null) && m39Var != null && m39Var.N() != null) {
            PbFragment pbFragment = this.f;
            if (pbFragment != null && u79.D(pbFragment)) {
                this.y.G(this.o);
                this.x.h(this.o);
            }
            if (this.f.z0()) {
                if (m39Var.g() != null) {
                    this.o0 = m39Var.g().d();
                    this.p0 = m39Var.g().b();
                }
                if (this.o0 == null && this.f.Q() != null && this.f.Q().X0() != null) {
                    this.o0 = this.f.Q().X0();
                }
            }
            jy9 W = m39Var.W();
            u3(W, m39Var);
            int i5 = 8;
            this.y.M(8);
            int i6 = 1;
            if (m39Var.w0()) {
                this.o1 = true;
                this.k.u(true);
                this.k.a.hideBottomLine();
            } else {
                this.o1 = false;
                this.k.u(false);
            }
            if (this.f.J5() != null) {
                this.f.J5().w(this.o1);
            }
            if (W == null) {
                return;
            }
            this.S0 = W;
            this.y.M(0);
            this.z.e(m39Var, this.o);
            this.B.e(m39Var, this.I1, new k0(this));
            this.x.j(m39Var);
            this.w.h(m39Var, this.Q0);
            this.w.g(m39Var);
            this.y.N(this.U0, this.R0, W, this.b2);
            if (this.c1 != null) {
                if (m39Var.i0()) {
                    this.c1.getView().setVisibility(8);
                } else {
                    this.c1.getView().setVisibility(0);
                    c49 c49Var = new c49(c49.g);
                    c49Var.b = m39Var.g;
                    c49Var.c = this.f.d6();
                    c49Var.e = m39Var.f;
                    c49Var.f = m39Var.N().isQuestionThread();
                    this.c1.i(c49Var);
                }
            }
            i4(W);
            j4(m39Var);
            wg.a().post(new l0(this));
            this.A.f(this.o);
            if (W.S) {
                this.A.g(W.O());
                PbLandscapeListView pbLandscapeListView = this.o;
                this.A.c(this.o, (pbLandscapeListView == null || pbLandscapeListView.getHeaderViewsCount() <= 1) ? 0 : 0);
            }
            d69 d69Var = this.J;
            if (d69Var != null && d69Var.B() != null) {
                this.J.B().I(W.S);
            }
            d69 d69Var2 = this.J;
            if (d69Var2 != null) {
                d69Var2.y0(W.S);
            }
            MaskView maskView = this.N1;
            if (W.S) {
                i5 = 0;
            }
            maskView.setVisibility(i5);
        }
    }

    public void X3(e55.c cVar, boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048671, this, cVar, z2) == null) {
            l55 l55Var = this.k0;
            if (l55Var != null) {
                l55Var.dismiss();
                this.k0 = null;
            }
            n55 n55Var = new n55(this.f.getContext());
            ArrayList arrayList = new ArrayList();
            m39 m39Var = this.R0;
            if (m39Var != null && m39Var.N() != null && !this.R0.N().isBjh()) {
                arrayList.add(new j55(0, this.f.getPageContext().getString(R.string.save_to_emotion), n55Var));
            }
            if (!z2) {
                arrayList.add(new j55(1, this.f.getPageContext().getString(R.string.save_to_local), n55Var));
            }
            n55Var.l(arrayList);
            n55Var.q(new i0(this, cVar));
            l55 l55Var2 = new l55(this.f.getPageContext(), n55Var);
            this.k0 = l55Var2;
            l55Var2.l();
        }
    }

    public SparseArray<Object> b1(m39 m39Var, boolean z2, int i3) {
        InterceptResult invokeCommon;
        jy9 W;
        boolean z3;
        n25 n25Var;
        int i4;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048685, this, new Object[]{m39Var, Boolean.valueOf(z2), Integer.valueOf(i3)})) == null) {
            StringBuilder sb = null;
            if (m39Var == null || (W = m39Var.W()) == null) {
                return null;
            }
            String userId = W.p().getUserId();
            if (userId != null && userId.equals(TbadkCoreApplication.getCurrentAccount())) {
                z3 = true;
            } else {
                z3 = false;
            }
            SparseArray<Object> sparseArray = new SparseArray<>();
            if (i3 == 0) {
                sparseArray.put(R.id.tag_del_post_id, W.O());
                sparseArray.put(R.id.tag_del_post_type, 0);
                sparseArray.put(R.id.tag_del_post_is_self, Boolean.valueOf(z3));
                sparseArray.put(R.id.tag_manage_user_identity, Integer.valueOf(m39Var.V()));
                sparseArray.put(R.id.tag_should_manage_visible, Boolean.FALSE);
            } else if (i3 == 1) {
                if (W.p() != null) {
                    sparseArray.put(R.id.tag_forbid_user_name, W.p().getUserName());
                    sparseArray.put(R.id.tag_forbid_user_name_show, W.p().getName_show());
                    sparseArray.put(R.id.tag_forbid_user_portrait, W.p().getPortrait());
                    sparseArray.put(R.id.tag_forbid_user_post_id, W.O());
                }
                sparseArray.put(R.id.tag_del_post_id, W.O());
                sparseArray.put(R.id.tag_del_post_type, 0);
                sparseArray.put(R.id.tag_del_post_is_self, Boolean.valueOf(z3));
                sparseArray.put(R.id.tag_manage_user_identity, Integer.valueOf(m39Var.V()));
                sparseArray.put(R.id.tag_should_manage_visible, Boolean.TRUE);
            }
            if (!z3) {
                List<j45> o3 = m39Var.o();
                if (ListUtils.getCount(o3) > 0) {
                    sb = new StringBuilder();
                    for (j45 j45Var : o3) {
                        if (j45Var != null && !StringUtils.isNull(j45Var.d()) && (n25Var = j45Var.h) != null && n25Var.a && !n25Var.c && ((i4 = n25Var.b) == 1 || i4 == 2)) {
                            sb.append(ui.cutString(j45Var.d(), 12));
                            sb.append(this.f.getString(R.string.obfuscated_res_0x7f0f0766));
                            sb.append("、");
                        }
                    }
                }
                if (sb != null && !StringUtils.isNull(sb.toString())) {
                    sparseArray.put(R.id.tag_del_multi_forum, String.format(this.f.getString(R.string.obfuscated_res_0x7f0f0537), sb.toString().substring(0, sb.length() - 1)));
                }
            }
            return sparseArray;
        }
        return (SparseArray) invokeCommon.objValue;
    }

    public final boolean h0(AbsListView absListView, int i3) {
        InterceptResult invokeLI;
        boolean z2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048709, this, absListView, i3)) == null) {
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

    public void h2(boolean z2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048711, this, new Object[]{Boolean.valueOf(z2), Integer.valueOf(i3)}) == null) {
            u69 u69Var = this.t;
            if (u69Var != null) {
                u69Var.b();
            }
            q79 q79Var = this.v;
            if (q79Var != null) {
                q79Var.b(z2, i3);
            }
            m69 m69Var = this.D;
            if (m69Var != null) {
                m69Var.l(this.R0.k());
                this.D.h(z2, i3);
            }
        }
    }

    public final CustomBlueCheckRadioButton r0(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048759, this, str, str2)) == null) {
            Activity pageActivity = this.f.getPageContext().getPageActivity();
            CustomBlueCheckRadioButton customBlueCheckRadioButton = new CustomBlueCheckRadioButton(pageActivity);
            RadioGroup.LayoutParams layoutParams = new RadioGroup.LayoutParams(-1, vi.g(pageActivity, R.dimen.obfuscated_res_0x7f07019a));
            customBlueCheckRadioButton.setOnCheckedChangeListener(this.f0);
            customBlueCheckRadioButton.setTag(str);
            customBlueCheckRadioButton.setText(str2);
            customBlueCheckRadioButton.setLayoutParams(layoutParams);
            return customBlueCheckRadioButton;
        }
        return (CustomBlueCheckRadioButton) invokeLL.objValue;
    }

    public void v3(boolean z2, PostWriteCallBackData postWriteCallBackData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZL(1048782, this, z2, postWriteCallBackData) == null) {
            this.f.hideProgressBar();
            if (z2) {
                v0();
            } else if (postWriteCallBackData != null && (postWriteCallBackData.isSensitiveError() || postWriteCallBackData.isErrorLinkCountExceedLimit() || postWriteCallBackData.isErrorShowApplyMemberDialog())) {
                w0();
            } else {
                v0();
            }
        }
    }

    public void j2(int i3) {
        boolean z2;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeI(1048721, this, i3) != null) || this.U0 == i3) {
            return;
        }
        this.U0 = i3;
        k4(this.R0, this.Q0);
        O2(this.R0, this.Q0, this.T0, i3);
        d05 layoutMode = this.f.getBaseFragmentActivity().getLayoutMode();
        if (i3 == 4) {
            z2 = true;
        } else {
            z2 = false;
        }
        layoutMode.l(z2);
        this.f.getBaseFragmentActivity().getLayoutMode().k(this.g);
        SkinManager.setBackgroundColor(this.g, R.color.CAM_X0201);
        SkinManager.setBackgroundColor(this.u0, R.color.CAM_X0203);
        r89 r89Var = this.z;
        if (r89Var != null) {
            r89Var.c(i3);
        }
        q89 q89Var = this.w;
        if (q89Var != null) {
            q89Var.e(i3);
        }
        s89 s89Var = this.x;
        if (s89Var != null) {
            s89Var.g(i3);
        }
        u89 u89Var = this.y;
        if (u89Var != null) {
            u89Var.C(i3);
        }
        t89 t89Var = this.A;
        if (t89Var != null) {
            t89Var.e();
        }
        p89 p89Var = this.B;
        if (p89Var != null) {
            p89Var.c();
        }
        MaskView maskView = this.N1;
        if (maskView != null) {
            maskView.f();
        }
        r79 r79Var = this.u;
        if (r79Var != null) {
            r79Var.o();
        }
        l69 l69Var = this.E;
        if (l69Var != null) {
            l69Var.n();
        }
        PbContentCollectionController pbContentCollectionController = this.C;
        if (pbContentCollectionController != null) {
            pbContentCollectionController.c();
        }
        PbListView pbListView = this.P;
        if (pbListView != null) {
            pbListView.e(i3);
        }
        if (this.R != null) {
            this.f.getBaseFragmentActivity().getLayoutMode().k(this.R);
            SkinManager.setBackgroundResource(this.R, R.drawable.pb_foot_more_trans_selector);
        }
        if (this.S != null) {
            this.f.getBaseFragmentActivity().getLayoutMode().k(this.S);
            SkinManager.setBackgroundResource(this.S, R.drawable.pb_foot_more_trans_selector);
        }
        c55 c55Var = this.K;
        if (c55Var != null) {
            c55Var.autoChangeSkinType(this.f.getPageContext());
        }
        q4(this.m0);
        this.J.f0();
        tb9 tb9Var = this.O;
        if (tb9Var != null) {
            tb9Var.H(i3);
        }
        EditorTools editorTools = this.s0;
        if (editorTools != null) {
            editorTools.y(i3);
        }
        ob9 ob9Var = this.Q;
        if (ob9Var != null) {
            ob9Var.g(i3);
        }
        if (!ListUtils.isEmpty(this.q)) {
            for (CustomBlueCheckRadioButton customBlueCheckRadioButton : this.q) {
                customBlueCheckRadioButton.c();
            }
        }
        w4();
        UtilHelper.setStatusBarBackground(this.h, i3);
        UtilHelper.setStatusBarBackground(this.b1, i3);
        if (this.F != null) {
            gt5.a(this.f.getPageContext(), this.F);
        }
        r69 r69Var = this.l1;
        if (r69Var != null) {
            r69Var.l(i3);
        }
        ga9 ga9Var = this.k;
        if (ga9Var != null) {
            ga9Var.p(i3);
        }
        LinearLayout linearLayout = this.A0;
        if (linearLayout != null) {
            linearLayout.setBackgroundDrawable(SkinManager.createShapeDrawableFromColor(vi.g(this.f.getContext(), R.dimen.tbds47), SkinManager.getColor(R.color.CAM_X0209)));
        }
        m39 m39Var = this.R0;
        if (m39Var != null && m39Var.q()) {
            WebPManager.setPureDrawable(this.G0, R.drawable.icon_pure_pb_bottom_collected26_selection, R.color.CAM_X0305, WebPManager.ResourceStateType.NORMAL_PRESS);
        } else {
            WebPManager.setPureDrawable(this.G0, R.drawable.icon_pure_pb_bottom_collect26, R.color.CAM_X0107, WebPManager.ResourceStateType.NORMAL_PRESS);
        }
        WebPManager.setPureDrawable(this.E0, R.drawable.icon_pure_pb_bottom_comment26, R.color.CAM_X0107, WebPManager.ResourceStateType.NORMAL_PRESS);
        WebPManager.setPureDrawable(this.B0, R.drawable.icon_pure_post_expression24, R.color.CAM_X0107, WebPManager.ResourceStateType.NORMAL);
        u4(this.R0);
        if (this.J0.getVisibility() == 0) {
            this.J0.setBackgroundDrawable(SkinManager.createShapeDrawable(vi.g(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds15), R.color.CAM_X0301, 0, 0, i3));
        }
        SkinManager.setBackgroundColor(this.z0, R.color.CAM_X0207);
        SkinManager.setBackgroundColor(this.y0, R.color.CAM_X0203);
        SkinManager.setViewTextColor(this.u1, (int) R.color.cp_cont_n);
        SkinManager.setViewTextColor(this.C0, (int) R.color.CAM_X0109);
        SkinManager.setViewTextColor(this.M0, (int) R.color.CAM_X0107);
        SkinManager.setBackgroundShapeDrawable(this.M0, vi.g(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds18), R.color.CAM_X0207, R.color.CAM_X0207);
        SkinManager.setViewTextColor(this.L0, (int) R.color.CAM_X0107);
        SkinManager.setBackgroundShapeDrawable(this.L0, vi.g(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds18), R.color.CAM_X0207, R.color.CAM_X0207);
        AgreeView agreeView = this.F0;
        if (agreeView != null) {
            agreeView.w();
            this.F0.P(i3);
            AgreeData data = this.F0.getData();
            if (data != null) {
                L2(data, data.agreeNum);
            }
        }
        q59 q59Var = this.x1;
        if (q59Var != null) {
            q59Var.m(i3);
        }
        PbThreadPostView pbThreadPostView = this.r;
        if (pbThreadPostView != null) {
            pbThreadPostView.c(i3);
        }
        CardForumHeadLayout cardForumHeadLayout = this.b;
        if (cardForumHeadLayout != null) {
            cardForumHeadLayout.g();
            o75 d2 = o75.d(this.b);
            d2.o(R.string.J_X05);
            d2.h(ow9.a(SkinManager.getColor(R.color.CAM_X0341), 0.08f));
        }
        sb9 sb9Var = this.K0;
        if (sb9Var != null) {
            sb9Var.j();
        }
        rb9 rb9Var = this.M1;
        if (rb9Var != null) {
            rb9Var.c();
        }
        RightFloatLayerView rightFloatLayerView = this.P1;
        if (rightFloatLayerView != null) {
            rightFloatLayerView.n();
        }
        SkinManager.setBackgroundColor(this.a1, R.color.CAM_X0207);
        SkinManager.setViewTextColor(this.a1.findViewById(R.id.tv_title), (int) R.color.CAM_X0105);
        LinearLayout linearLayout2 = this.R1;
        if (linearLayout2 != null) {
            o75.d(linearLayout2).f(R.color.CAM_X0201);
        }
        t99 t99Var = this.S1;
        if (t99Var != null) {
            t99Var.b(i3);
        }
    }

    public void v2(AbsListView absListView, int i3, int i4, int i5) {
        boolean z2;
        PbListView pbListView;
        int i6;
        PbReplyTitleViewHolder pbReplyTitleViewHolder;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLIII(1048781, this, absListView, i3, i4, i5) == null) {
            u69 u69Var = this.t;
            if (u69Var != null) {
                u69Var.c(i3, i4);
            }
            q79 q79Var = this.v;
            if (q79Var != null) {
                q79Var.c(i3, i4);
            }
            m69 m69Var = this.D;
            if (m69Var != null) {
                m69Var.k(i3, i4);
            }
            ga9 ga9Var = this.k;
            if (ga9Var != null && this.y != null) {
                ga9Var.q(absListView, i3, i4, i5);
            }
            H2();
            this.g1.a = null;
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004013, this.g1));
            if (h0(absListView, i3) && !this.k.o()) {
                z2 = true;
            } else {
                z2 = false;
            }
            J3(z2);
            I2(this.g1.a, false);
            u0();
            if (this.P.q() && !this.P.D) {
                b1 b1Var = this.g1;
                if (b1Var != null && (pbReplyTitleViewHolder = b1Var.a) != null && pbReplyTitleViewHolder.getView() != null) {
                    if (this.g1.a.getView().getTop() < 0) {
                        i6 = this.g1.a.getView().getHeight();
                    } else {
                        i6 = this.g1.a.getView().getBottom();
                    }
                } else {
                    i6 = 0;
                }
                this.P.f(i6);
                this.P.D = true;
            }
            if (i3 > this.c && (pbListView = this.P) != null && pbListView.i() != null) {
                rm6.f(this.P.i(), 0);
            }
        }
    }

    public void x2(ArrayList<w25> arrayList) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048791, this, arrayList) == null) {
            if (this.d0 == null) {
                this.d0 = LayoutInflater.from(this.f.getPageContext().getPageActivity()).inflate(R.layout.commit_good, (ViewGroup) null);
            }
            this.f.getBaseFragmentActivity().getLayoutMode().k(this.d0);
            if (this.c0 == null) {
                Dialog dialog = new Dialog(this.f.getPageContext().getPageActivity(), R.style.obfuscated_res_0x7f1003bf);
                this.c0 = dialog;
                dialog.setCanceledOnTouchOutside(true);
                this.c0.setCancelable(true);
                this.r0 = (ScrollView) this.d0.findViewById(R.id.good_scroll);
                this.c0.setContentView(this.d0);
                WindowManager.LayoutParams attributes = this.c0.getWindow().getAttributes();
                attributes.width = vi.g(TbadkCoreApplication.getInst(), R.dimen.obfuscated_res_0x7f0703ef);
                this.c0.getWindow().setAttributes(attributes);
                this.f0 = new e0(this);
                this.e0 = (LinearLayout) this.d0.findViewById(R.id.good_class_group);
                TextView textView = (TextView) this.d0.findViewById(R.id.dialog_button_cancel);
                this.h0 = textView;
                textView.setOnClickListener(new f0(this));
                TextView textView2 = (TextView) this.d0.findViewById(R.id.dialog_button_ok);
                this.g0 = textView2;
                textView2.setOnClickListener(this.U);
            }
            this.e0.removeAllViews();
            this.q = new ArrayList();
            CustomBlueCheckRadioButton r02 = r0("0", this.f.getPageContext().getString(R.string.thread_good_class));
            this.q.add(r02);
            r02.setChecked(true);
            this.e0.addView(r02);
            if (arrayList != null) {
                for (int i3 = 0; i3 < arrayList.size(); i3++) {
                    w25 w25Var = arrayList.get(i3);
                    if (w25Var != null && !TextUtils.isEmpty(w25Var.b()) && w25Var.a() > 0) {
                        CustomBlueCheckRadioButton r03 = r0(String.valueOf(w25Var.a()), w25Var.b());
                        this.q.add(r03);
                        View view2 = new View(this.f.getPageContext().getPageActivity());
                        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, vi.g(TbadkCoreApplication.getInst(), R.dimen.obfuscated_res_0x7f070198));
                        SkinManager.setBackgroundColor(view2, R.color.CAM_X0204);
                        view2.setLayoutParams(layoutParams);
                        this.e0.addView(view2);
                        this.e0.addView(r03);
                    }
                }
                ViewGroup.LayoutParams layoutParams2 = this.r0.getLayoutParams();
                int size = arrayList.size();
                if (size != 0 && size != 1) {
                    if (size != 2) {
                        layoutParams2.height = vi.d(this.f.getPageContext().getPageActivity(), 220.0f);
                    } else {
                        layoutParams2.height = vi.d(this.f.getPageContext().getPageActivity(), 186.0f);
                    }
                } else {
                    layoutParams2.height = vi.d(this.f.getPageContext().getPageActivity(), 120.0f);
                }
                this.r0.setLayoutParams(layoutParams2);
                this.r0.removeAllViews();
                LinearLayout linearLayout = this.e0;
                if (linearLayout != null && linearLayout.getParent() == null) {
                    this.r0.addView(this.e0);
                }
            }
            yg.j(this.c0, this.f.getPageContext());
        }
    }

    public void z2(int i3, String str, int i4, boolean z2, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048801, this, new Object[]{Integer.valueOf(i3), str, Integer.valueOf(i4), Boolean.valueOf(z2), str2}) == null) {
            A2(i3, str, i4, z2, str2, false);
        }
    }
}
