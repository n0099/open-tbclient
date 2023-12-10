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
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import androidx.exifinterface.media.ExifInterface;
import androidx.recyclerview.widget.RecyclerView;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.safe.JavaTypesHelper;
import com.baidu.adp.lib.safe.SafeHandler;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.BdUtilHelper;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.card.view.CardForumHeadLayout;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.BDLayoutMode;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.FrsActivityConfig;
import com.baidu.tbadk.core.data.AlaInfoData;
import com.baidu.tbadk.core.data.BaijiahaoData;
import com.baidu.tbadk.core.data.ForumData;
import com.baidu.tbadk.core.data.LoginDialogData;
import com.baidu.tbadk.core.data.MetaData;
import com.baidu.tbadk.core.data.ThreadData;
import com.baidu.tbadk.core.elementsMaven.EMManager;
import com.baidu.tbadk.core.sharedPref.SharedPrefHelper;
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
import com.baidu.tbadk.core.view.BlueCircleProgressDialog;
import com.baidu.tbadk.core.view.FriendBotView;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tbadk.core.view.PbListView;
import com.baidu.tbadk.core.view.breathetip.BreatheTipWidget;
import com.baidu.tbadk.coreExtra.data.EmotionGroupType;
import com.baidu.tbadk.data.AdverSegmentData;
import com.baidu.tbadk.editortools.EditorTools;
import com.baidu.tbadk.util.BdListViewHelper;
import com.baidu.tbadk.util.MaskView;
import com.baidu.tbadk.widget.RightFloatLayerLottieView;
import com.baidu.tbadk.widget.RightFloatLayerView;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tbadk.widget.layout.ObservedChangeRelativeLayout;
import com.baidu.tbadk.widget.richText.TbRichText;
import com.baidu.tbadk.widget.richText.TbRichTextView;
import com.baidu.tbadk.youngster.utils.YoungsterVerifyUtils;
import com.baidu.tieba.c0a;
import com.baidu.tieba.f05;
import com.baidu.tieba.g05;
import com.baidu.tieba.g0a;
import com.baidu.tieba.mu9;
import com.baidu.tieba.n2a;
import com.baidu.tieba.o0a;
import com.baidu.tieba.p05;
import com.baidu.tieba.p55;
import com.baidu.tieba.pb.PbFirstFloorDoubleClickAnimation;
import com.baidu.tieba.pb.ejection.EjectionAnimationView;
import com.baidu.tieba.pb.mixplayer.TbLiveMixPlayerConfig;
import com.baidu.tieba.pb.mixplayer.TbMixPlayerView;
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
import com.baidu.tieba.sx9;
import com.baidu.tieba.tbadkCore.data.AgreeData;
import com.baidu.tieba.tbadkCore.data.AgreeMessageData;
import com.baidu.tieba.tbadkCore.writeModel.PostWriteCallBackData;
import com.baidu.tieba.view.NavigationBarCoverTip;
import com.baidu.tieba.view.SortSwitchButton;
import com.baidu.tieba.view.WaterRippleView;
import com.baidu.tieba.zva;
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
import tbclient.SpriteMemeInfo;
@SuppressLint({"ResourceAsColor"})
/* loaded from: classes7.dex */
public class o1a {
    public static /* synthetic */ Interceptable $ic;
    public static final int g2;
    public static int h2;
    public static int i2;
    public static int j2;
    public static int k2;
    public static int l2;
    public static int m2;
    public static final int n2;
    public static int o2;
    public static zva.f p2;
    public transient /* synthetic */ FieldHolder $fh;
    public n2a A;
    public TextView A0;
    public String A1;
    public PbContentCollectionController B;
    public WaterRippleView B0;
    public PermissionJudgePolicy B1;
    public c0a C;
    public ImageView C0;
    public int C1;
    public g0a D;
    public AgreeView D0;
    public int D1;
    public e0a E;
    public ImageView E0;
    public boolean E1;
    public LinearLayout F;
    public ImageView F0;
    public boolean F1;
    public TextView G;
    public HeadImageView G0;
    public u6a G1;
    public TextView H;
    public View H0;
    public MaskView H1;
    public ObservedChangeRelativeLayout I;
    public v6a I0;
    public final PbFallingView I1;
    public vz9 J;
    public TextView J0;
    public RightFloatLayerView J1;
    public f05 K;
    public TextView K0;
    public final FrameLayout K1;
    public g05 L;
    public boolean L0;
    public LinearLayout L1;
    public View M;
    public int M0;
    public o4a M1;
    public EditText N;
    public BlueCircleProgressDialog N0;
    public final Object N1;
    public w6a O;
    public boolean O0;
    public TbMixPlayerView O1;
    public PbListView P;
    public aw9 P0;
    public CustomMessageListener P1;
    public r6a Q;
    public nwa Q0;
    public View.OnClickListener Q1;
    public View R;
    public int R0;
    public View.OnClickListener R1;
    public View S;
    public int S0;
    public View.OnClickListener S1;

    /* renamed from: T  reason: collision with root package name */
    public View f1130T;
    public boolean T0;
    public final ViewTreeObserver.OnGlobalLayoutListener T1;
    public View.OnClickListener U;
    public ViewStub U0;
    public CustomMessageListener U1;
    public SortSwitchButton.f V;
    public PbInterviewStatusView V0;
    public Handler V1;
    public TbRichTextView.z W;
    public TextView W0;
    public Runnable W1;
    public NoNetworkView.b X;
    public View X0;
    public CustomMessageListener X1;
    public n05 Y;
    public View Y0;
    public PbFragment.k3 Y1;
    public Dialog Z;
    public View Z0;
    public boolean Z1;
    public CardForumHeadLayout a;
    public Dialog a0;
    public PbReplyTitleViewHolder a1;
    public View.OnClickListener a2;
    public int b;
    public View b0;
    public View b1;
    public String b2;
    public boolean c;
    public LinearLayout c0;
    public int c1;
    public p55.g c2;
    public int d;
    public CompoundButton.OnCheckedChangeListener d0;
    public boolean d1;
    public View.OnClickListener d2;
    public PbFragment e;
    public TextView e0;
    public v0 e1;
    public final List<TbImageView> e2;
    public RelativeLayout f;
    public TextView f0;
    public int f1;
    public boolean f2;
    public View g;
    public String g0;
    public int g1;
    public int h;
    public n05 h0;
    public Runnable h1;
    public final Handler i;
    public n05 i0;
    public PbFakeFloorModel i1;
    public final e5a j;
    public i05 j0;
    public l0a j1;
    public d5a k;
    public boolean k0;
    public boolean k1;
    public ViewStub l;
    public boolean l0;
    public int l1;
    public ViewStub m;
    public String m0;
    public boolean m1;
    public PbLandscapeListView n;
    public String n0;
    public boolean n1;
    public NoNetworkView o;
    public ux9 o0;
    public boolean o1;
    public List<CustomBlueCheckRadioButton> p;
    public ScrollView p0;
    public int p1;
    public PbThreadPostView q;
    public EditorTools q0;
    public PbTopTipView q1;
    public k1a r;
    public boolean r0;
    public PopupWindow r1;
    public o0a s;
    public View s0;
    public TextView s1;
    public o0a t;
    public View t0;
    public x2a t1;
    public pz9 u;
    public EjectionAnimationView u0;
    public zy9 u1;
    public o2a v;
    public Button v0;
    public PbLandscapeListView.c v1;
    public q2a w;
    public View w0;
    public boolean w1;
    public s2a x;
    public View x0;
    public boolean x1;
    public p2a y;
    public LinearLayout y0;
    public y0a y1;
    public r2a z;
    public ImageView z0;
    public NavigationBarCoverTip z1;

    public int H0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048611, this)) == null) ? R.id.obfuscated_res_0x7f091b9f : invokeV.intValue;
    }

    public boolean e2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048708, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    public int o1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048757, this)) == null) ? R.id.obfuscated_res_0x7f091ffa : invokeV.intValue;
    }

    public void r3(boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048774, this, z2) == null) {
        }
    }

    public boolean y2(int i3) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048808, this, i3)) == null) {
            return false;
        }
        return invokeI.booleanValue;
    }

    /* loaded from: classes7.dex */
    public class a implements o0a.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ o1a a;

        /* renamed from: com.baidu.tieba.o1a$a$a  reason: collision with other inner class name */
        /* loaded from: classes7.dex */
        public class RunnableC0411a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ a a;

            public RunnableC0411a(a aVar) {
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
                if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && this.a.a.r != null && this.a.a.e.u0() != null) {
                    v05.g(Collections.singletonList(new l1a(this.a.a.e.u0(), this.a.a.r)));
                }
            }
        }

        public a(o1a o1aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {o1aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = o1aVar;
        }

        @Override // com.baidu.tieba.o0a.a
        public void a() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && !this.a.u.u() && !this.a.e.t8() && this.a.n != null) {
                this.a.n.post(new RunnableC0411a(this));
            }
        }
    }

    /* loaded from: classes7.dex */
    public class f implements AgreeView.h {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ o1a a;

        /* loaded from: classes7.dex */
        public class a implements ee5 {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ f a;

            public a(f fVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {fVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = fVar;
            }

            @Override // com.baidu.tieba.ee5
            public void a(List<Bitmap> list) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, list) == null) {
                    this.a.a.u0.setVisibility(0);
                    this.a.a.u0.setBitmaps(list);
                    Rect rect = new Rect();
                    this.a.a.D0.getImgAgree().getGlobalVisibleRect(rect);
                    this.a.a.u0.setAnchorPosition((rect.right + rect.left) / 2, (rect.bottom + rect.top) / 2);
                    this.a.a.u0.k();
                }
            }
        }

        public f(o1a o1aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {o1aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = o1aVar;
        }

        @Override // com.baidu.tbadk.core.view.AgreeView.h
        public void onLongPress() {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeV(1048576, this) != null) {
                return;
            }
            this.a.S3();
            ge5.g().c(new a(this));
        }

        @Override // com.baidu.tbadk.core.view.AgreeView.h
        public void onRelease() {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) != null) {
                return;
            }
            this.a.e3();
            this.a.u0.l();
        }
    }

    /* loaded from: classes7.dex */
    public class i implements g0a.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ o1a a;

        /* loaded from: classes7.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ int a;
            public final /* synthetic */ i b;

            public a(i iVar, int i) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {iVar, Integer.valueOf(i)};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.b = iVar;
                this.a = i;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && this.b.a.E != null && this.b.a.e.u0() != null) {
                    this.b.a.E.q(this.a);
                    v05.g(Collections.singletonList(new h0a(this.b.a.e.u0(), this.b.a.E)));
                }
            }
        }

        public i(o1a o1aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {o1aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = o1aVar;
        }

        @Override // com.baidu.tieba.g0a.b
        public void a(int i) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeI(1048576, this, i) == null) && !this.a.e.t8() && !this.a.c && this.a.n != null) {
                this.a.n.post(new a(this, i));
            }
        }
    }

    /* loaded from: classes7.dex */
    public class k0 implements DialogInterface.OnCancelListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ o1a a;

        /* loaded from: classes7.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ k0 a;

            public a(k0 k0Var) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {k0Var};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = k0Var;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable != null && interceptable.invokeV(1048576, this) != null) {
                    return;
                }
                this.a.a.e.HidenSoftKeyPad((InputMethodManager) this.a.a.e.getBaseFragmentActivity().getSystemService("input_method"), this.a.a.f);
            }
        }

        public k0(o1a o1aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {o1aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = o1aVar;
        }

        @Override // android.content.DialogInterface.OnCancelListener
        public void onCancel(DialogInterface dialogInterface) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, dialogInterface) == null) {
                if (this.a.h1 == null) {
                    this.a.h1 = new a(this);
                }
                SafeHandler.getInst().postDelayed(this.a.h1, 150L);
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
        public final /* synthetic */ o1a g;

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
                if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && this.a.g.b1 != null && this.a.g.b1.getLayoutParams() != null) {
                    ViewGroup.LayoutParams layoutParams = this.a.g.b1.getLayoutParams();
                    layoutParams.height = this.a.g.g1;
                    this.a.g.b1.setLayoutParams(layoutParams);
                }
            }
        }

        public l(o1a o1aVar, int i, PbReplyTitleViewHolder pbReplyTitleViewHolder, boolean z, int i2, int i3, int i4) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {o1aVar, Integer.valueOf(i), pbReplyTitleViewHolder, Boolean.valueOf(z), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i5 = newInitContext.flag;
                if ((i5 & 1) != 0) {
                    int i6 = i5 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.g = o1aVar;
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
                if (i2 >= 0 && i2 <= this.g.f.getMeasuredHeight()) {
                    int n1 = this.g.n1(this.b);
                    int i3 = this.a;
                    int i4 = n1 - i3;
                    if (this.c && i4 != 0 && i3 <= (i = this.d)) {
                        i4 = n1 - i;
                    }
                    if (this.g.b1 == null || (layoutParams = this.g.b1.getLayoutParams()) == null) {
                        return;
                    }
                    if (i4 != 0 && i4 <= this.g.f.getMeasuredHeight() && n1 < this.g.f.getMeasuredHeight()) {
                        if (layoutParams != null) {
                            int i5 = layoutParams.height;
                            if (i5 + i4 > 0 && i5 + i4 <= this.g.f.getMeasuredHeight()) {
                                layoutParams.height += i4;
                                if (this.g.n != null) {
                                    this.g.n.setSelectionFromTop(this.e, this.f);
                                }
                            }
                        }
                        layoutParams.height = this.g.g1;
                    } else {
                        layoutParams.height = this.g.g1;
                    }
                    this.g.b1.setLayoutParams(layoutParams);
                    SafeHandler.getInst().post(new a(this));
                }
                if (this.g.n != null) {
                    this.g.n.setOnLayoutListener(null);
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class a0 implements p05.f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ g05.c a;
        public final /* synthetic */ o1a b;

        public a0(o1a o1aVar, g05.c cVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {o1aVar, cVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = o1aVar;
            this.a = cVar;
        }

        @Override // com.baidu.tieba.p05.f
        public void E0(p05 p05Var, int i, View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIL(1048576, this, p05Var, i, view2) == null) {
                this.b.i0.dismiss();
                this.a.a(null, i, view2);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class b implements PbFallingView.q {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ o1a a;

        public b(o1a o1aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {o1aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = o1aVar;
        }

        @Override // com.baidu.tieba.pb.view.PbFallingView.q
        public void onAnimationEnd() {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeV(1048576, this) != null) {
                return;
            }
            this.a.o4();
        }

        @Override // com.baidu.tieba.pb.view.PbFallingView.q
        public void onAnimationStart() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                this.a.I1.setTag(Boolean.FALSE);
                if (this.a.J1 == null) {
                    return;
                }
                this.a.J1.setAutoCompleteShown(false);
                if (this.a.J1.getVisibility() == 0) {
                    this.a.J1.setTag(this.a.I1);
                    this.a.J1.c();
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class b0 implements p05.f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ g05.c a;
        public final /* synthetic */ o1a b;

        public b0(o1a o1aVar, g05.c cVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {o1aVar, cVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = o1aVar;
            this.a = cVar;
        }

        @Override // com.baidu.tieba.p05.f
        public void E0(p05 p05Var, int i, View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIL(1048576, this, p05Var, i, view2) == null) {
                this.b.i0.dismiss();
                this.a.a(null, i, view2);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class c implements mu9.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ o1a a;

        public c(o1a o1aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {o1aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = o1aVar;
        }

        @Override // com.baidu.tieba.mu9.a
        public void a(@NonNull String str, @NonNull String str2, @NonNull String str3) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLL(1048576, this, str, str2, str3) == null) {
                if (this.a.e != null && this.a.e.l0() != null) {
                    this.a.e.l0().m3();
                }
                this.a.u.q();
                if (TextUtils.isEmpty(str2)) {
                    str2 = TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f080b);
                }
                l4a.d(str, str2, str3, 3);
                this.a.J.v();
            }
        }
    }

    /* loaded from: classes7.dex */
    public class c0 implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ o1a a;

        public c0(o1a o1aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {o1aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = o1aVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            long j;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                if ((view2 instanceof HeadImageView) && this.a.P0 != null && this.a.P0.R() != null && this.a.P0.R().getAuthor() != null && this.a.P0.R().getAuthor().getAlaInfo() != null && this.a.P0.R().getAuthor().getAlaInfo().live_status == 1) {
                    StatisticItem statisticItem = new StatisticItem("c11851");
                    statisticItem.param("uid", TbadkCoreApplication.getCurrentAccount());
                    TiebaStatic.log(statisticItem);
                    StatisticItem statisticItem2 = new StatisticItem("c13715");
                    statisticItem2.param("fid", this.a.P0.o());
                    statisticItem2.param("fname", this.a.P0.p());
                    if (this.a.P0.R().getAuthor().getAlaInfo().user_info != null) {
                        j = this.a.P0.R().getAuthor().getAlaInfo().user_info.user_id;
                    } else {
                        j = 0;
                    }
                    statisticItem2.param("obj_param1", j);
                    statisticItem2.param("uid", TbadkCoreApplication.getCurrentAccount());
                    statisticItem2.param("tid", this.a.P0.T());
                    statisticItem2.param(TiebaStatic.Params.OBJ_PARAM2, 1);
                    statisticItem2.param(TiebaStatic.Params.OBJ_PARAM4, YYLiveUtil.calculateLiveType(this.a.P0.R().getAuthor().getAlaInfo()));
                    if (this.a.P0.R().getAuthor().getAlaInfo().mYyExtData != null) {
                        statisticItem2.param(TiebaStatic.Params.OBJ_PARAM3, TiebaStatic.YYValues.YY_LIVE);
                        TiebaStaticHelper.addYYParam(statisticItem2, this.a.P0.R().getAuthor().getAlaInfo().mYyExtData);
                    }
                    TiebaStatic.log(statisticItem2);
                    if (this.a.P0.R().getAuthor().getAlaInfo().isLegalYYLiveData()) {
                        YYLiveUtil.jumpYYLiveRoom(this.a.e.getPageContext(), this.a.P0.R().getAuthor().getAlaInfo(), YYLiveUtil.SOURCE_PB_LIVE_HEAD);
                        return;
                    }
                    return;
                }
                if (this.a.m1) {
                    TiebaStatic.log(new StatisticItem("c11923").param("obj_id", 2));
                }
                if (!this.a.m1 && this.a.P0 != null && this.a.P0.R() != null && this.a.P0.R().getAuthor() != null && this.a.P0.R().getAuthor().isBigV()) {
                    TiebaStatic.log(new StatisticItem("c12151").param("obj_locate", 1));
                }
                if (this.a.e.u0() != null) {
                    this.a.e.u0().c.b.onClick(view2);
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class d implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ o1a a;

        public d(o1a o1aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {o1aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = o1aVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                this.a.D2();
            }
        }
    }

    /* loaded from: classes7.dex */
    public class d0 implements n2a.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ o1a a;

        public d0(o1a o1aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {o1aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = o1aVar;
        }

        @Override // com.baidu.tieba.n2a.a
        public void a(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
                if (z) {
                    this.a.A.a(this.a.n);
                } else {
                    this.a.A.d(this.a.n);
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class e implements yw9 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ o1a a;

        @Override // com.baidu.tieba.yw9
        public /* synthetic */ void onStart() {
            xw9.a(this);
        }

        public e(o1a o1aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {o1aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = o1aVar;
        }

        @Override // com.baidu.tieba.yw9
        public void onStop() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                this.a.u0.setVisibility(8);
                FirstPraiseToast.getInstance().show();
            }
        }
    }

    /* loaded from: classes7.dex */
    public class e0 implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ o1a a;

        public e0(o1a o1aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {o1aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = o1aVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            o1a o1aVar;
            e5a e5aVar;
            LinearLayout linearLayout;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && this.a.J != null && (e5aVar = (o1aVar = this.a).j) != null && e5aVar.k != null && o1aVar.P0 != null && this.a.P0.R() != null && !this.a.P0.R().isVideoThreadType() && !this.a.k2() && this.a.P0.n() != null && !rd.isEmpty(this.a.P0.n().getName())) {
                if ((this.a.J.r() == null || !this.a.J.r().isShown()) && (linearLayout = this.a.j.k) != null) {
                    linearLayout.setVisibility(0);
                    this.a.j.h();
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class f0 implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;
        public final /* synthetic */ o1a b;

        public f0(o1a o1aVar, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {o1aVar, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = o1aVar;
            this.a = str;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                if (BdUtilHelper.isNetOk()) {
                    UrlManager.getInstance().dealOneLink(this.b.e.getPageContext(), new String[]{this.a});
                    this.b.e.finish();
                    return;
                }
                this.b.e.showToast(R.string.obfuscated_res_0x7f0f0e70);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class g implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ o1a a;

        public g(o1a o1aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {o1aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = o1aVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, view2) == null) && this.a.D0 != null && this.a.D0.getData() != null) {
                o1a o1aVar = this.a;
                o1aVar.X2(o1aVar.D0.getData(), this.a.D0.getData().agreeNum);
                if (!this.a.D0.J()) {
                    o1a o1aVar2 = this.a;
                    o1aVar2.Q2(o1aVar2.D0);
                }
                if (this.a.P0 != null && this.a.P0.R() != null && this.a.P0.R().isExcellentThread() && BreatheTipWidget.f()) {
                    ub5.a("c15279", this.a.P0.T(), this.a.P0.o(), "1");
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class g0 implements zva.f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        @Override // com.baidu.tieba.zva.f
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
    public class h implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ o1a a;

        public h(o1a o1aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {o1aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = o1aVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                if (this.a.H0.getVisibility() == 0) {
                    if (this.a.e != null && this.a.e.G2()) {
                        return;
                    }
                    SharedPrefHelper.getInstance().putBoolean("pb_share_red_dot_shown", true);
                    this.a.H0.setVisibility(8);
                }
                this.a.U.onClick(view2);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class h0 implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ Parcelable a;
        public final /* synthetic */ ArrayList b;
        public final /* synthetic */ aw9 c;
        public final /* synthetic */ o1a d;

        public h0(o1a o1aVar, Parcelable parcelable, ArrayList arrayList, aw9 aw9Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {o1aVar, parcelable, arrayList, aw9Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.d = o1aVar;
            this.a = parcelable;
            this.b = arrayList;
            this.c = aw9Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (this.d.n != null) {
                    this.d.n.onRestoreInstanceState(this.a);
                }
                if (this.d.P != null && ListUtils.getCount(this.b) > 1 && this.c.B().b() > 0) {
                    this.d.P.g();
                    this.d.P.H(TbadkApplication.getInst().getString(R.string.obfuscated_res_0x7f0f1031));
                    this.d.P.B();
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class i0 implements PbLandscapeListView.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ o1a a;

        public i0(o1a o1aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {o1aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = o1aVar;
        }

        @Override // com.baidu.tieba.pb.pb.main.PbLandscapeListView.c
        public void a(int i, int i2, float f, float f2, float f3, float f4) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Integer.valueOf(i), Integer.valueOf(i2), Float.valueOf(f), Float.valueOf(f2), Float.valueOf(f3), Float.valueOf(f4)}) == null) && this.a.e != null && this.a.e.isAdded()) {
                if (i < 0 && f > this.a.p1) {
                    this.a.s0();
                    this.a.z2();
                }
                this.a.A0();
            }
        }
    }

    /* loaded from: classes7.dex */
    public class j implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ o1a a;

        public j(o1a o1aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {o1aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = o1aVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                if (this.a.H0.getVisibility() == 0) {
                    SharedPrefHelper.getInstance().putBoolean("pb_share_red_dot_shown", true);
                    this.a.H0.setVisibility(8);
                }
                this.a.U.onClick(this.a.F0);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class j0 implements f05.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ o1a a;

        public j0(o1a o1aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {o1aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = o1aVar;
        }

        @Override // com.baidu.tieba.f05.e
        public void onClick(f05 f05Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, f05Var) == null) {
                this.a.s0();
                f05Var.dismiss();
            }
        }
    }

    /* loaded from: classes7.dex */
    public class k extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ o1a a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public k(o1a o1aVar, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {o1aVar, Integer.valueOf(i)};
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
            this.a = o1aVar;
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

    /* loaded from: classes7.dex */
    public class l0 implements f05.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public l0(o1a o1aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {o1aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // com.baidu.tieba.f05.e
        public void onClick(f05 f05Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, f05Var) == null) {
                f05Var.dismiss();
            }
        }
    }

    /* loaded from: classes7.dex */
    public class m implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ o1a a;

        public m(o1a o1aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {o1aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = o1aVar;
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
                    this.a.e.s6(sparseArray);
                    return;
                }
                this.a.P2(view2);
            } else if (z2) {
                sparseArray.put(R.id.tag_from, 0);
                sparseArray.put(R.id.tag_check_mute_from, 1);
                this.a.e.s6(sparseArray);
            } else if (z3) {
                this.a.K2(((Integer) sparseArray.get(R.id.tag_del_post_type)).intValue(), (String) sparseArray.get(R.id.tag_del_post_id), ((Integer) sparseArray.get(R.id.tag_manage_user_identity)).intValue(), ((Boolean) sparseArray.get(R.id.tag_del_post_is_self)).booleanValue());
            }
        }
    }

    /* loaded from: classes7.dex */
    public class m0 implements f05.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public m0(o1a o1aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {o1aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // com.baidu.tieba.f05.e
        public void onClick(f05 f05Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, f05Var) == null) {
                f05Var.dismiss();
            }
        }
    }

    /* loaded from: classes7.dex */
    public class n implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ o1a a;

        public n(o1a o1aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {o1aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = o1aVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                eh5 f7 = this.a.e.f7();
                ReplyPrivacyCheckController replyPrivacyCheckController = new ReplyPrivacyCheckController(this.a.e.getPageContext());
                if (this.a.e != null && this.a.e.R6() != null && !replyPrivacyCheckController.checkPrivacyBeforeInvokeEditor(this.a.e.R6().replyPrivateFlag)) {
                    return;
                }
                TiebaStatic.log(new StatisticItem(CommonStatisticKey.KEY_RD_USE).param("obj_param1", 3).param("obj_locate", 1).param("obj_type", 1).param("obj_source", UtilHelper.getCurrentPageName(TbadkCoreApplication.getInst().getCurrentActivity())));
                if (!DialogLoginHelper.checkUpIsLogin(new LoginDialogData(this.a.e.getActivity(), LoginDialogData.PB_BOTTOM_REPLY_RESULT_PAGE))) {
                    TiebaStatic.log(new StatisticItem(CommonStatisticKey.KEY_RD_USE).param("obj_param1", 3).param("obj_locate", 2).param("obj_type", 1).param("obj_source", UtilHelper.getCurrentPageName(TbadkCoreApplication.getInst().getCurrentActivity())));
                    return;
                }
                this.a.D4();
                f7.r0();
                this.a.x0();
            }
        }
    }

    /* loaded from: classes7.dex */
    public class n0 implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ int a;
        public final /* synthetic */ int b;
        public final /* synthetic */ int c;
        public final /* synthetic */ View d;
        public final /* synthetic */ o1a e;

        public n0(o1a o1aVar, int i, int i2, int i3, View view2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {o1aVar, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), view2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i4 = newInitContext.flag;
                if ((i4 & 1) != 0) {
                    int i5 = i4 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.e = o1aVar;
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
                    this.e.r1.showAsDropDown(this.d);
                } else {
                    this.e.r1.showAsDropDown(this.e.x0, this.d.getLeft(), -this.e.x0.getHeight());
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class o implements ViewTreeObserver.OnGlobalLayoutListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ o1a a;

        public o(o1a o1aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {o1aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = o1aVar;
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (!this.a.E1 && this.a.e != null && this.a.e.l0() != null && this.a.e.l0().h2()) {
                    this.a.E1 = true;
                    this.a.e.q6(false);
                }
                if (this.a.F1) {
                    return;
                }
                this.a.F1 = true;
                if (this.a.g2() && this.a.B != null) {
                    this.a.B.h();
                    this.a.B.g(true);
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class o0 implements PbFallingView.o {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ o1a a;

        public o0(o1a o1aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {o1aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = o1aVar;
        }

        @Override // com.baidu.tieba.pb.view.PbFallingView.o
        public void onClick() {
            String m1;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (this.a.e != null && this.a.e.l0() != null && this.a.e.l0().d2()) {
                    m1 = this.a.e.getString(R.string.pb_reply_hint_from_smart_frs);
                } else {
                    m1 = this.a.m1();
                }
                if (!StringUtils.isNull(m1) && this.a.P0 != null) {
                    m1 = TbSingleton.getInstance().getAdVertiComment(this.a.P0.r0(), this.a.P0.s0(), m1);
                }
                if (this.a.e != null && this.a.e.f7() != null) {
                    this.a.e.f7().g0(m1);
                }
                if (this.a.A0 != null) {
                    this.a.A0.setText(m1);
                }
                this.a.X3(false);
                this.a.o4();
            }
        }
    }

    /* loaded from: classes7.dex */
    public class p implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public p(o1a o1aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {o1aVar};
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

    /* loaded from: classes7.dex */
    public class p0 implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ d85 a;
        public final /* synthetic */ o1a b;

        public p0(o1a o1aVar, d85 d85Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {o1aVar, d85Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = o1aVar;
            this.a = d85Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, view2) == null) && this.a != null && this.b.P0 != null && this.b.J1 != null) {
                this.b.J1.g(this.a);
                this.b.J1.setAutoCompleteShown(false);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class q implements PbFirstFloorDoubleClickAnimation.d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ o1a a;

        public q(o1a o1aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {o1aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = o1aVar;
        }

        @Override // com.baidu.tieba.pb.PbFirstFloorDoubleClickAnimation.d
        public void onFinish() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.D0.W();
            }
        }
    }

    /* loaded from: classes7.dex */
    public class q0 implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ d85 a;
        public final /* synthetic */ o1a b;

        public q0(o1a o1aVar, d85 d85Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {o1aVar, d85Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = o1aVar;
            this.a = d85Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921664));
                this.b.J1.setHomePbFloatLastCloseTime();
                this.b.F1();
                this.b.J1.t(this.a);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class r extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ o1a a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public r(o1a o1aVar, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {o1aVar, Integer.valueOf(i)};
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
            this.a = o1aVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && customResponsedMessage.getCmd() == 2005016 && this.a.J != null) {
                this.a.J.v();
            }
        }
    }

    /* loaded from: classes7.dex */
    public class r0 implements sx9.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ o1a a;

        public r0(o1a o1aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {o1aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = o1aVar;
        }

        @Override // com.baidu.tieba.sx9.b
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.e.t7();
            }
        }

        @Override // com.baidu.tieba.sx9.b
        public void b() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) && this.a.n != null) {
                this.a.n.setSelection(0);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class s implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ o1a a;

        public s(o1a o1aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {o1aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = o1aVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (this.a.F == null) {
                    this.a.P1();
                }
                this.a.m.setVisibility(0);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class s0 implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ o1a a;

        public s0(o1a o1aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {o1aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = o1aVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                this.a.h3();
            }
        }
    }

    /* loaded from: classes7.dex */
    public class t extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ o1a a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public t(o1a o1aVar, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {o1aVar, Integer.valueOf(i)};
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
            this.a = o1aVar;
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

    /* loaded from: classes7.dex */
    public class t0 implements PbFakeFloorModel.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ o1a a;

        public t0(o1a o1aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {o1aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = o1aVar;
        }

        @Override // com.baidu.tieba.pb.pb.main.view.PbFakeFloorModel.b
        public void a(nwa nwaVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, nwaVar) == null) {
                this.a.i1.f0(nwaVar);
                this.a.J.v();
                this.a.j1.g();
                this.a.q0.y();
                this.a.X3(false);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class u implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ o1a a;

        public u(o1a o1aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {o1aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = o1aVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                this.a.h3();
            }
        }
    }

    /* loaded from: classes7.dex */
    public class u0 implements c0a.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ o1a a;

        public u0(o1a o1aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {o1aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = o1aVar;
        }

        @Override // com.baidu.tieba.c0a.a
        public void b(@Nullable f05 f05Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, f05Var) == null) {
                this.a.e.E6(f05Var, null);
            }
        }

        @Override // com.baidu.tieba.c0a.a
        public void a(@NonNull f05 f05Var, @Nullable JSONArray jSONArray) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048576, this, f05Var, jSONArray) == null) {
                this.a.e.E6(f05Var, jSONArray);
            }
        }

        @Override // com.baidu.tieba.c0a.a
        public void c(@Nullable SparseArray<Object> sparseArray, @Nullable JSONArray jSONArray) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, sparseArray, jSONArray) == null) {
                this.a.e.D6(sparseArray, jSONArray);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class v implements ie5 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ o1a a;

        public v(o1a o1aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {o1aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = o1aVar;
        }

        @Override // com.baidu.tieba.ie5
        public void U(he5 he5Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, he5Var) == null) {
                Object obj = he5Var.c;
                if ((obj instanceof v85) && EmotionGroupType.isSendAsPic(((v85) obj).g())) {
                    if (this.a.B1 == null) {
                        this.a.B1 = new PermissionJudgePolicy();
                    }
                    this.a.B1.clearRequestPermissionList();
                    this.a.B1.appendRequestPermission(this.a.e.getBaseFragmentActivity(), "android.permission.WRITE_EXTERNAL_STORAGE");
                    if (this.a.B1.startRequestPermission(this.a.e.getBaseFragmentActivity())) {
                        return;
                    }
                    v85 v85Var = (v85) he5Var.c;
                    this.a.e.f7().g(v85Var);
                    if (v85Var.j()) {
                        this.a.e.f7().K(null, null);
                    } else {
                        this.a.e.f7().z(false, null);
                    }
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public static class v0 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public PbReplyTitleViewHolder a;
        public BdUniqueId b;

        public v0() {
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
    public class w implements TextWatcher {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ o1a a;

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIII(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, charSequence, i, i2, i3) == null) {
            }
        }

        public w(o1a o1aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {o1aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = o1aVar;
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(1048576, this, editable) != null) || this.a.e.M0 == null) {
                return;
            }
            n4a.a(this.a.e.M0);
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLIII(Constants.METHOD_SEND_USER_MSG, this, charSequence, i, i2, i3) == null) && this.a.q0 != null && this.a.f != null && !TextUtils.isEmpty(charSequence)) {
                n4a.b(charSequence, i, i3, this.a.q0, this.a.t1, this.a.e.getPageContext(), this.a.f);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class x implements p05.f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ boolean a;
        public final /* synthetic */ o1a b;

        public x(o1a o1aVar, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {o1aVar, Boolean.valueOf(z)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = o1aVar;
            this.a = z;
        }

        @Override // com.baidu.tieba.p05.f
        public void E0(p05 p05Var, int i, View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIL(1048576, this, p05Var, i, view2) == null) {
                this.b.Y.dismiss();
                SparseArray<Object> sparseArray = (SparseArray) view2.getTag();
                if (sparseArray == null) {
                    return;
                }
                switch (i) {
                    case 10:
                        this.b.K2(((Integer) sparseArray.get(R.id.tag_del_post_type)).intValue(), (String) sparseArray.get(R.id.tag_del_post_id), ((Integer) sparseArray.get(R.id.tag_manage_user_identity)).intValue(), ((Boolean) sparseArray.get(R.id.tag_del_post_is_self)).booleanValue());
                        return;
                    case 11:
                        if (this.b.Y1 != null) {
                            this.b.Y1.callback(new Object[]{sparseArray.get(R.id.tag_manage_user_identity), sparseArray.get(R.id.tag_forbid_user_name), sparseArray.get(R.id.tag_forbid_user_post_id), sparseArray.get(R.id.tag_forbid_user_name_show), sparseArray.get(R.id.tag_forbid_user_portrait)});
                            return;
                        }
                        return;
                    case 12:
                        this.b.e.p7(this.a, (String) sparseArray.get(R.id.tag_user_mute_mute_userid), sparseArray);
                        return;
                    case 13:
                        this.b.H4(true);
                        return;
                    default:
                        return;
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class y implements CompoundButton.OnCheckedChangeListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ o1a a;

        public y(o1a o1aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {o1aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = o1aVar;
        }

        @Override // android.widget.CompoundButton.OnCheckedChangeListener
        public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLZ(1048576, this, compoundButton, z) == null) && z) {
                this.a.g0 = (String) compoundButton.getTag();
                if (this.a.p != null) {
                    for (CustomBlueCheckRadioButton customBlueCheckRadioButton : this.a.p) {
                        String str = (String) customBlueCheckRadioButton.getTag();
                        if (str != null && this.a.g0 != null && !str.equals(this.a.g0)) {
                            customBlueCheckRadioButton.setChecked(false);
                        }
                    }
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class z implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ o1a a;

        public z(o1a o1aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {o1aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = o1aVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, view2) == null) && (this.a.a0 instanceof Dialog)) {
                yb.b(this.a.a0, this.a.e.getPageContext());
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947980778, "Lcom/baidu/tieba/o1a;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947980778, "Lcom/baidu/tieba/o1a;");
                return;
            }
        }
        g2 = UtilHelper.getLightStatusBarHeight();
        h2 = 3;
        i2 = 0;
        j2 = 3;
        k2 = 4;
        l2 = 5;
        m2 = 6;
        n2 = BdUtilHelper.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds80);
        o2 = 1;
        p2 = new g0();
    }

    public void B2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            z4();
            this.J.w(1);
            k1a k1aVar = this.r;
            if (k1aVar != null) {
                k1aVar.j();
            }
            e0a e0aVar = this.E;
            if (e0aVar != null) {
                e0aVar.g();
            }
            g0a g0aVar = this.D;
            if (g0aVar != null) {
                g0aVar.j();
            }
            RightFloatLayerView rightFloatLayerView = this.J1;
            if (rightFloatLayerView != null && (rightFloatLayerView instanceof RightFloatLayerLottieView)) {
                ((RightFloatLayerLottieView) rightFloatLayerView).G(600);
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016524));
            if (h2()) {
                this.O1.n();
            }
        }
    }

    public nwa N0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048638, this)) == null) {
            if (this.n == null) {
                return null;
            }
            int M0 = M0() - this.n.getHeaderViewsCount();
            int i3 = 0;
            if (M0 < 0) {
                M0 = 0;
            }
            if (this.J.o(M0) != null && this.J.o(M0) != nwa.X0) {
                i3 = M0 + 1;
            }
            if (!(this.J.n(i3) instanceof nwa)) {
                return null;
            }
            return (nwa) this.J.n(i3);
        }
        return (nwa) invokeV.objValue;
    }

    public final int P0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048646, this)) == null) {
            PbLandscapeListView pbLandscapeListView = this.n;
            if (pbLandscapeListView != null && pbLandscapeListView.getData() != null) {
                for (int i3 = 0; i3 < this.n.getData().size(); i3++) {
                    pi piVar = this.n.getData().get(i3);
                    if (piVar != null && piVar.getType() == cw9.k) {
                        return i3 + this.n.getHeaderViewsCount();
                    }
                }
            }
            return 0;
        }
        return invokeV.intValue;
    }

    public final boolean g2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048718, this)) == null) {
            if (R3()) {
                for (int firstVisiblePosition = this.n.getFirstVisiblePosition(); firstVisiblePosition <= this.n.getLastVisiblePosition(); firstVisiblePosition++) {
                    View childAt = this.n.getListView2().getChildAt(firstVisiblePosition);
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

    public void j3() {
        PbListView pbListView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048734, this) == null) && (pbListView = this.P) != null && pbListView.i() != null) {
            LinearLayout i3 = this.P.i();
            View findViewById = i3.findViewById(R.id.obfuscated_res_0x7f091b92);
            if (i3.getVisibility() == 0 && findViewById != null && findViewById.getVisibility() == 0) {
                this.c = true;
                TiebaStatic.log(new StatisticItem("c15304").param("uid", TbadkCoreApplication.getCurrentAccountId()));
            }
        }
    }

    public void l4() {
        nwa nwaVar;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048745, this) != null) || !TbadkCoreApplication.isLogin() || this.P0 == null || !this.n1 || this.m1 || this.l0 || (nwaVar = this.Q0) == null || nwaVar.u() == null || this.Q0.u().getIsLike() || this.Q0.u().hadConcerned()) {
        }
    }

    public o1a(PbFragment pbFragment, View.OnClickListener onClickListener, ux9 ux9Var, SortSwitchButton.f fVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {pbFragment, onClickListener, ux9Var, fVar};
            interceptable.invokeUnInit(65537, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.b = -1;
        this.c = false;
        this.e = null;
        this.f = null;
        this.g = null;
        this.h = 0;
        this.i = new Handler();
        this.n = null;
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
        this.k0 = false;
        this.l0 = false;
        this.m0 = null;
        this.n0 = null;
        this.p0 = null;
        this.r0 = false;
        this.v0 = null;
        this.x0 = null;
        this.A0 = null;
        this.L0 = true;
        this.N0 = null;
        this.O0 = false;
        this.S0 = 3;
        this.T0 = false;
        this.U0 = null;
        this.c1 = 0;
        this.d1 = true;
        this.e1 = new v0();
        this.f1 = 0;
        this.k1 = false;
        this.l1 = 0;
        this.m1 = false;
        this.n1 = false;
        this.o1 = false;
        this.p1 = 0;
        this.w1 = false;
        this.x1 = false;
        this.D1 = 0;
        this.N1 = new Object();
        this.P1 = new k(this, 2921757);
        this.Q1 = new j(this);
        this.R1 = new m(this);
        this.S1 = new n(this);
        this.T1 = new o(this);
        this.U1 = new r(this, 2005016);
        this.V1 = new Handler();
        this.X1 = new t(this, 2004009);
        this.Z1 = true;
        this.a2 = new c0(this);
        this.b2 = null;
        this.e2 = new ArrayList();
        this.f2 = false;
        this.e = pbFragment;
        this.e1.b = pbFragment.getPageContext().getUniqueId();
        this.U = onClickListener;
        this.V = fVar;
        this.o0 = ux9Var;
        this.p1 = BdUtilHelper.getEquipmentWidth(this.e.getContext()) / 8;
        RelativeLayout relativeLayout = (RelativeLayout) LayoutInflater.from(this.e.getPageContext().getPageActivity()).inflate(R.layout.obfuscated_res_0x7f0d0739, (ViewGroup) null);
        this.f = relativeLayout;
        relativeLayout.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        this.s0 = this.f.findViewById(R.id.obfuscated_res_0x7f0904b4);
        this.z1 = (NavigationBarCoverTip) this.f.findViewById(R.id.obfuscated_res_0x7f091c0e);
        this.g = this.f.findViewById(R.id.obfuscated_res_0x7f0923c8);
        this.K1 = (FrameLayout) this.f.findViewById(R.id.obfuscated_res_0x7f09201e);
        this.I = (ObservedChangeRelativeLayout) this.f.findViewById(R.id.obfuscated_res_0x7f0926bc);
        this.o = (NoNetworkView) this.f.findViewById(R.id.view_no_network);
        PbLandscapeListView pbLandscapeListView = (PbLandscapeListView) this.f.findViewById(R.id.obfuscated_res_0x7f091a27);
        this.n = pbLandscapeListView;
        pbLandscapeListView.setDividerHeight(0);
        this.W0 = new TextView(this.e.getActivity());
        AbsListView.LayoutParams layoutParams = new AbsListView.LayoutParams(-1, n1a.i(this.e));
        this.n.setOverScrollMode(2);
        this.n.w(this.W0, 0);
        this.n.setTextViewAdded(true);
        this.g1 = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds134);
        this.b1 = new View(this.e.getPageContext().getPageActivity());
        if (YoungsterVerifyUtils.isYoungsterOpen()) {
            this.b1.setLayoutParams(new AbsListView.LayoutParams(-1, 0));
        } else {
            this.b1.setLayoutParams(new AbsListView.LayoutParams(-1, this.g1));
        }
        MessageManager.getInstance().registerListener(this.P1);
        this.b1.setVisibility(4);
        this.n.addFooterView(this.b1);
        this.n.setOnTouchListener(this.e.L2);
        this.n.getViewTreeObserver().addOnGlobalLayoutListener(this.T1);
        this.j = new e5a(pbFragment, this.f);
        if (this.e.Y6()) {
            ViewStub viewStub = (ViewStub) this.f.findViewById(R.id.obfuscated_res_0x7f0917a0);
            this.l = viewStub;
            viewStub.setVisibility(0);
            d5a d5aVar = new d5a(pbFragment);
            this.k = d5aVar;
            d5aVar.c();
            this.j.a.setVisibility(8);
            layoutParams.height = BdUtilHelper.getDimens(this.e.getActivity(), R.dimen.obfuscated_res_0x7f070365);
        }
        this.W0.setLayoutParams(layoutParams);
        this.I1 = (PbFallingView) this.f.findViewById(R.id.obfuscated_res_0x7f090b3e);
        PbFragment pbFragment2 = this.e;
        this.G1 = new u6a(pbFragment2, pbFragment2.getUniqueId());
        this.j.j().setOnTouchListener(new sx9(new r0(this)));
        vz9 vz9Var = new vz9(this.e, this.n);
        this.J = vz9Var;
        vz9Var.T(this.U);
        this.J.W(this.o0);
        this.J.Q(this.W);
        this.J.S(this.V);
        this.J.M(this.d2);
        this.J.O(this.R1);
        I1();
        W1();
        N1();
        r2a r2aVar = new r2a(this.e);
        this.z = r2aVar;
        r2aVar.f = 2;
        M1();
        J1();
        this.A.a(this.n);
        this.x.i(this.n);
        this.w.a(this.n);
        this.B.a(this.n);
        this.v.a(this.n);
        PbListView pbListView = new PbListView(this.e.getPageContext().getPageActivity());
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
        this.f1130T = this.f.findViewById(R.id.obfuscated_res_0x7f092a7d);
        this.e.registerListener(this.X1);
        this.i1 = new PbFakeFloorModel(this.e.getPageContext());
        PbModel l02 = this.e.l0();
        this.i1.h0(l02.X(), l02.T(), l02.U(), l02.S(), l02.Y());
        l0a l0aVar = new l0a(this.e.getPageContext(), this.i1, this.f);
        this.j1 = l0aVar;
        l0aVar.p(new s0(this));
        this.j1.s(this.e.q2);
        this.i1.j0(new t0(this));
        if (this.e.l0() != null && !StringUtils.isNull(this.e.l0().v1())) {
            PbFragment pbFragment3 = this.e;
            pbFragment3.showToast(pbFragment3.l0().v1());
        }
        this.X0 = this.f.findViewById(R.id.obfuscated_res_0x7f091bab);
        this.Y0 = this.f.findViewById(R.id.obfuscated_res_0x7f0904b2);
        View findViewById = this.f.findViewById(R.id.obfuscated_res_0x7f0923d4);
        this.Z0 = findViewById;
        LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) findViewById.getLayoutParams();
        if (this.e.l0() != null && this.e.l0().e1()) {
            this.X0.setVisibility(0);
            if (layoutParams2 != null) {
                layoutParams2.height = 0;
                this.Z0.setLayoutParams(layoutParams2);
            }
        } else if (layoutParams2 != null) {
            layoutParams2.height = g2;
            this.Z0.setLayoutParams(layoutParams2);
        }
        PbReplyTitleViewHolder pbReplyTitleViewHolder = new PbReplyTitleViewHolder(this.e.getPageContext(), this.f.findViewById(R.id.obfuscated_res_0x7f091c2e));
        this.a1 = pbReplyTitleViewHolder;
        pbReplyTitleViewHolder.u(pbFragment.d0);
        this.a1.g.setVisibility(8);
        this.a1.t(this.U);
        this.a1.s(this.V);
        this.e.registerListener(this.U1);
        T1();
        K1();
        n0();
        m0(YoungsterVerifyUtils.isYoungsterOpen());
        S1();
        R1();
        d3();
    }

    public void A3(NoNetworkView.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, bVar) == null) {
            this.X = bVar;
            NoNetworkView noNetworkView = this.o;
            if (noNetworkView != null) {
                noNetworkView.addNetworkChangeListener(bVar);
            }
        }
    }

    public void A4(boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048580, this, z2) == null) {
            this.k0 = z2;
        }
    }

    public void B3(BdListView.p pVar) {
        PbLandscapeListView pbLandscapeListView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, pVar) == null) && (pbLandscapeListView = this.n) != null) {
            pbLandscapeListView.setOnSrollToBottomListener(pVar);
        }
    }

    public void C2(si siVar) {
        PbLandscapeListView pbLandscapeListView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048588, this, siVar) == null) && (pbLandscapeListView = this.n) != null) {
            pbLandscapeListView.b0 = siVar;
            pbLandscapeListView.W = true;
        }
    }

    public void C3(AbsListView.OnScrollListener onScrollListener) {
        PbLandscapeListView pbLandscapeListView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048589, this, onScrollListener) == null) && (pbLandscapeListView = this.n) != null) {
            pbLandscapeListView.setOnScrollListener(onScrollListener);
        }
    }

    public void D3(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048594, this, onClickListener) == null) {
            this.J.U(onClickListener);
        }
    }

    public void E3(int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048599, this, i3) == null) {
            this.C1 = i3;
        }
    }

    public void E4(aw9 aw9Var) {
        ImageView imageView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048600, this, aw9Var) == null) && aw9Var != null && (imageView = this.F0) != null) {
            m4a.f(aw9Var, this.I0, this.H0, imageView);
        }
    }

    public void F3(View.OnLongClickListener onLongClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048604, this, onLongClickListener) == null) {
            this.x.w(onLongClickListener);
            this.J.R(onLongClickListener);
            zy9 zy9Var = this.u1;
            if (zy9Var != null) {
                zy9Var.q(onLongClickListener);
            }
        }
    }

    public void I4(aw9 aw9Var) {
        o2a o2aVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048620, this, aw9Var) == null) && (o2aVar = this.v) != null) {
            o2aVar.h(aw9Var, this.O0);
        }
    }

    public void L3(boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048633, this, z2) == null) {
            this.x.y(z2);
        }
    }

    public void N3(int i3) {
        PbLandscapeListView pbLandscapeListView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(1048641, this, i3) == null) && (pbLandscapeListView = this.n) != null) {
            pbLandscapeListView.setSelection(i3);
        }
    }

    public void O3(boolean z2) {
        vz9 vz9Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048645, this, z2) == null) && (vz9Var = this.J) != null) {
            vz9Var.V(z2);
        }
    }

    public void P2(View view2) {
        SparseArray<Object> sparseArray;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048648, this, view2) != null) || (sparseArray = (SparseArray) view2.getTag()) == null) {
            return;
        }
        O2(sparseArray, false);
    }

    public void P3(List<String> list) {
        x2a x2aVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048649, this, list) == null) && (x2aVar = this.t1) != null) {
            x2aVar.q(list);
        }
    }

    public final void Q3(int i3) {
        TextView textView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(1048653, this, i3) == null) && (textView = this.W0) != null && (textView.getLayoutParams() instanceof AbsListView.LayoutParams)) {
            AbsListView.LayoutParams layoutParams = (AbsListView.LayoutParams) this.W0.getLayoutParams();
            layoutParams.height = i3;
            this.W0.setLayoutParams(layoutParams);
        }
    }

    public void V3(fv9 fv9Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048673, this, fv9Var) == null) {
            this.u.C(fv9Var);
        }
    }

    public void W3(boolean z2) {
        int i3;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048677, this, z2) == null) {
            View view2 = this.s0;
            if (z2) {
                i3 = 0;
            } else {
                i3 = 8;
            }
            view2.setVisibility(i3);
        }
    }

    public final boolean b2(aw9 aw9Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048696, this, aw9Var)) == null) {
            return n1a.t(aw9Var);
        }
        return invokeL.booleanValue;
    }

    public final int e1(boolean z2) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048707, this, z2)) == null) {
            PbInterviewStatusView pbInterviewStatusView = this.V0;
            if (pbInterviewStatusView == null || pbInterviewStatusView.getVisibility() != 0 || !z2) {
                return 0;
            }
            return 0 + BdUtilHelper.getDimens(TbadkCoreApplication.getInst(), R.dimen.obfuscated_res_0x7f07026a);
        }
        return invokeZ.intValue;
    }

    public final void f0(View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048711, this, view2) == null) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) view2.getLayoutParams();
            layoutParams.addRule(11);
            view2.setLayoutParams(layoutParams);
        }
    }

    public boolean h0(boolean z2) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048721, this, z2)) == null) {
            EditorTools editorTools = this.q0;
            if (editorTools != null && editorTools.D()) {
                this.q0.y();
                return true;
            }
            return false;
        }
        return invokeZ.booleanValue;
    }

    public void l3(String str) {
        PbListView pbListView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048744, this, str) == null) && (pbListView = this.P) != null) {
            pbListView.H(str);
        }
    }

    public void o3(PbFragment.k3 k3Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048759, this, k3Var) == null) {
            this.Y1 = k3Var;
        }
    }

    public void p3(boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048764, this, z2) == null) {
            this.r0 = z2;
        }
    }

    public void q3(boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048769, this, z2) == null) {
            this.J.E(z2);
        }
    }

    public void s3(boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048779, this, z2) == null) {
            this.w1 = z2;
        }
    }

    public final void s4(nwa nwaVar) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048780, this, nwaVar) == null) && nwaVar != null) {
            this.x1 = !StringUtils.isNull(nwaVar.g0());
            s2a s2aVar = this.x;
            if (s2aVar != null) {
                s2aVar.l(nwaVar);
            }
        }
    }

    public void t3(boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048784, this, z2) == null) {
            this.J.G(z2);
        }
    }

    public void u3(boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048789, this, z2) == null) {
            this.J.L(z2);
        }
    }

    public void v3(p55.g gVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048794, this, gVar) == null) {
            this.c2 = gVar;
            w6a w6aVar = this.O;
            if (w6aVar != null) {
                w6aVar.a(gVar);
            }
        }
    }

    public void v4(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048795, this, str) == null) {
            this.e.showToast(str);
        }
    }

    public void w3(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048799, this, onClickListener) == null) {
            this.d2 = onClickListener;
            vz9 vz9Var = this.J;
            if (vz9Var != null) {
                vz9Var.M(onClickListener);
            }
        }
    }

    public void x3(String str) {
        d5a d5aVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048804, this, str) == null) && (d5aVar = this.k) != null) {
            d5aVar.b(str);
        }
    }

    public void y3(boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048809, this, z2) == null) {
            this.k1 = z2;
            PbLandscapeListView pbLandscapeListView = this.n;
            if (pbLandscapeListView != null) {
                this.l1 = pbLandscapeListView.getHeaderViewsCount();
            }
        }
    }

    public void z3(TbRichTextView.z zVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048814, this, zVar) == null) {
            this.W = zVar;
            this.J.Q(zVar);
            this.u1.p(this.W);
        }
    }

    public final void G3(nwa nwaVar, aw9 aw9Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048609, this, nwaVar, aw9Var) == null) {
            this.x.x(nwaVar, aw9Var);
        }
    }

    public void S2(AdverSegmentData adverSegmentData, int i3) {
        PbFallingView pbFallingView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLI(1048660, this, adverSegmentData, i3) == null) && (pbFallingView = this.I1) != null) {
            pbFallingView.x(adverSegmentData, this.e.getPageContext(), i3, false);
        }
    }

    public final boolean m2(AbsListView absListView, int i3) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048748, this, absListView, i3)) == null) {
            if (g0(absListView, i3) && !this.j.o() && !h2()) {
                return true;
            }
            return false;
        }
        return invokeLI.booleanValue;
    }

    @SuppressLint({"CutPasteId"})
    public void u4(aw9 aw9Var, boolean z2) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLZ(1048790, this, aw9Var, z2) != null) || aw9Var == null) {
            return;
        }
        F4(aw9Var, z2);
        v0();
    }

    public void A0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            PbLandscapeListView pbLandscapeListView = this.n;
            if (pbLandscapeListView != null) {
                pbLandscapeListView.z(0L);
            }
            v0();
        }
    }

    public void A1() {
        EditorTools editorTools;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) && (editorTools = this.q0) != null) {
            editorTools.z();
            x2a x2aVar = this.t1;
            if (x2aVar != null) {
                x2aVar.m();
            }
        }
    }

    public void B1() {
        e5a e5aVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048582, this) == null) && (e5aVar = this.j) != null) {
            e5aVar.k();
        }
    }

    public void C0() {
        PbLandscapeListView pbLandscapeListView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048586, this) == null) && (pbLandscapeListView = this.n) != null) {
            pbLandscapeListView.setForbidDragListener(true);
        }
    }

    public void C1() {
        BlueCircleProgressDialog blueCircleProgressDialog;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048587, this) == null) && (blueCircleProgressDialog = this.N0) != null) {
            blueCircleProgressDialog.setDialogVisiable(false);
        }
    }

    public void D0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048591, this) == null) {
            this.u.q();
        }
    }

    public void D1() {
        Runnable runnable;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048592, this) == null) {
            if (this.F == null) {
                P1();
            }
            this.m.setVisibility(8);
            Handler handler = this.V1;
            if (handler != null && (runnable = this.W1) != null) {
                handler.removeCallbacks(runnable);
            }
        }
    }

    public void D2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048593, this) == null) {
            E2(null);
        }
    }

    public void E1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048597, this) == null) {
            this.f1130T.setVisibility(8);
        }
    }

    public void F1() {
        RightFloatLayerView rightFloatLayerView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048602, this) == null) && (rightFloatLayerView = this.J1) != null) {
            rightFloatLayerView.c();
        }
    }

    public vz9 G0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048606, this)) == null) {
            return this.J;
        }
        return (vz9) invokeV.objValue;
    }

    public void G1() {
        EditorTools editorTools;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048607, this) == null) && (editorTools = this.q0) != null) {
            editorTools.y();
        }
    }

    public final void G2() {
        PbFragment pbFragment;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048608, this) == null) && (pbFragment = this.e) != null && pbFragment.f7() != null) {
            this.e.f7().I();
        }
    }

    public void H1() {
        o4a o4aVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048612, this) == null) && (o4aVar = this.M1) != null) {
            o4aVar.a();
        }
    }

    public FriendBotView I0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048616, this)) == null) {
            return this.u.r();
        }
        return (FriendBotView) invokeV.objValue;
    }

    public LinearLayout J0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048621, this)) == null) {
            return this.y0;
        }
        return (LinearLayout) invokeV.objValue;
    }

    public final void J1() {
        PbFragment pbFragment;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048622, this) == null) && this.B == null && (pbFragment = this.e) != null && pbFragment.getActivity() != null) {
            this.B = new PbContentCollectionController(this.e.getActivity());
        }
    }

    public void J3() {
        PbFragment pbFragment;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048624, this) == null) && (pbFragment = this.e) != null && pbFragment.getBaseFragmentActivity() != null) {
            BdUtilHelper.hideSoftKeyPad(this.e.getPageContext().getPageActivity(), this.e.getBaseFragmentActivity().getCurrentFocus());
        }
    }

    public View K0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048626, this)) == null) {
            View view2 = this.b0;
            if (view2 != null) {
                return view2.findViewById(R.id.dialog_button_ok);
            }
            return null;
        }
        return (View) invokeV.objValue;
    }

    public final void K1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048627, this) == null) {
            c0a c0aVar = new c0a(this.e.getPageContext(), this.e.l0());
            this.C = c0aVar;
            c0aVar.f(new u0(this));
        }
    }

    public void K3() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048629, this) == null) {
            this.P.D();
            this.P.U();
        }
    }

    public String L0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048630, this)) == null) {
            return this.g0;
        }
        return (String) invokeV.objValue;
    }

    public final void M1() {
        PbFragment pbFragment;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048635, this) == null) && this.A == null && (pbFragment = this.e) != null) {
            this.A = new n2a(pbFragment.getContext());
        }
    }

    public final void N1() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048639, this) == null) && this.w == null) {
            this.w = new q2a(this.e, this.o0);
        }
    }

    public PbFallingView O0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048642, this)) == null) {
            return this.I1;
        }
        return (PbFallingView) invokeV.objValue;
    }

    public int Q0() {
        InterceptResult invokeV;
        int i3;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048650, this)) == null) {
            PbLandscapeListView pbLandscapeListView = this.n;
            if (pbLandscapeListView != null) {
                i3 = pbLandscapeListView.getFirstVisiblePosition();
            } else {
                i3 = 0;
            }
            return R0(i3);
        }
        return invokeV.intValue;
    }

    public boolean R2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048656, this)) == null) {
            k1a k1aVar = this.r;
            if (k1aVar != null && k1aVar.l()) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public Button S0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048658, this)) == null) {
            return this.v0;
        }
        return (Button) invokeV.objValue;
    }

    public int T0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048662, this)) == null) {
            PbLandscapeListView pbLandscapeListView = this.n;
            if (pbLandscapeListView != null) {
                return pbLandscapeListView.getHeaderViewsCount();
            }
            return 0;
        }
        return invokeV.intValue;
    }

    public TextView U0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048666, this)) == null) {
            return this.x.o();
        }
        return (TextView) invokeV.objValue;
    }

    public void U3() {
        View view2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048669, this) == null) {
            PbLandscapeListView pbLandscapeListView = this.n;
            int i3 = 0;
            if (pbLandscapeListView != null) {
                pbLandscapeListView.setVisibility(0);
            }
            e5a e5aVar = this.j;
            if (e5aVar != null && (view2 = e5aVar.f) != null) {
                if (!TbadkCoreApplication.isLogin()) {
                    i3 = 8;
                }
                view2.setVisibility(i3);
            }
        }
    }

    public int V0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048670, this)) == null) {
            v6a v6aVar = this.I0;
            if (v6aVar != null) {
                return v6aVar.f();
            }
            return 3;
        }
        return invokeV.intValue;
    }

    public final void V2() {
        aw9 aw9Var;
        nwa nwaVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048672, this) == null) && (aw9Var = this.P0) != null && (nwaVar = this.Q0) != null) {
            this.x.t(aw9Var, nwaVar, this.n1, this.m1);
        }
    }

    public PbInterviewStatusView W0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048674, this)) == null) {
            return this.V0;
        }
        return (PbInterviewStatusView) invokeV.objValue;
    }

    public final void W1() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048675, this) == null) && this.y == null) {
            this.y = new p2a(this.e, this.U);
        }
    }

    public boolean X0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048678, this)) == null) {
            return this.w1;
        }
        return invokeV.booleanValue;
    }

    public int Y0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048682, this)) == null) {
            PbLandscapeListView pbLandscapeListView = this.n;
            if (pbLandscapeListView == null) {
                return 0;
            }
            return R0(pbLandscapeListView.getLastVisiblePosition());
        }
        return invokeV.intValue;
    }

    public BdTypeListView Z0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048686, this)) == null) {
            return this.n;
        }
        return (BdTypeListView) invokeV.objValue;
    }

    public final boolean Z1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048687, this)) == null) {
            aw9 aw9Var = this.P0;
            if (aw9Var != null && aw9Var.R() != null && this.P0.R().isAlaLiveMixThreadType()) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public NoNetworkView a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048690, this)) == null) {
            return this.o;
        }
        return (NoNetworkView) invokeV.objValue;
    }

    public boolean a2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048692, this)) == null) {
            return this.L0;
        }
        return invokeV.booleanValue;
    }

    public TbMixPlayerView b1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048695, this)) == null) {
            return this.O1;
        }
        return (TbMixPlayerView) invokeV.objValue;
    }

    public final void b3() {
        PbInterviewStatusView pbInterviewStatusView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048697, this) == null) && (pbInterviewStatusView = this.V0) != null && pbInterviewStatusView.getVisibility() == 0) {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.V0.getLayoutParams();
            marginLayoutParams.setMargins(0, 0, 0, 0);
            this.V0.setLayoutParams(marginLayoutParams);
        }
    }

    public zy9 c1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048699, this)) == null) {
            return this.u1;
        }
        return (zy9) invokeV.objValue;
    }

    public boolean c2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048700, this)) == null) {
            PbLandscapeListView pbLandscapeListView = this.n;
            if (pbLandscapeListView == null) {
                return false;
            }
            return pbLandscapeListView.J();
        }
        return invokeV.booleanValue;
    }

    public void c3() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048701, this) == null) && this.h != 2) {
            PbLandscapeListView pbLandscapeListView = this.n;
            if (pbLandscapeListView != null) {
                pbLandscapeListView.setNextPage(this.P);
            }
            this.h = 2;
        }
    }

    public void c4() {
        e5a e5aVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048702, this) == null) && (e5aVar = this.j) != null && !this.o1) {
            e5aVar.w();
            this.o1 = true;
        }
    }

    public View d1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048703, this)) == null) {
            return this.S;
        }
        return (View) invokeV.objValue;
    }

    public boolean d2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048704, this)) == null) {
            EditorTools editorTools = this.q0;
            if (editorTools == null || editorTools.getVisibility() != 0) {
                return false;
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    public final void d3() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048705, this) == null) {
            br6.b().b(this.N1, new mu9(new c(this)));
        }
    }

    public void d4() {
        PbLandscapeListView pbLandscapeListView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048706, this) == null) && (pbLandscapeListView = this.n) != null) {
            pbLandscapeListView.setVisibility(0);
        }
    }

    public void e4() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048710, this) == null) {
            if (this.N0 == null) {
                this.N0 = new BlueCircleProgressDialog(this.e.getPageContext());
            }
            this.N0.setDialogVisiable(true);
        }
    }

    public View f1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048712, this)) == null) {
            return this.R;
        }
        return (View) invokeV.objValue;
    }

    public final boolean f2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048713, this)) == null) {
            return TextUtils.equals(TbadkCoreApplication.getCurrentAccount(), this.b2);
        }
        return invokeV.booleanValue;
    }

    public void f4() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048715, this) == null) {
            this.J.D(this.P0, false);
            this.J.v();
        }
    }

    public PbListView g1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048717, this)) == null) {
            return this.P;
        }
        return (PbListView) invokeV.objValue;
    }

    public final void g3() {
        PbFragment pbFragment;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048719, this) == null) && (pbFragment = this.e) != null && pbFragment.f7() != null && this.q0 != null) {
            m4a.a(this.e.f7(), this.q0);
        }
    }

    public int h1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048722, this)) == null) {
            try {
                return Integer.parseInt(this.N.getText().toString(), 10);
            } catch (Exception unused) {
                return -1;
            }
        }
        return invokeV.intValue;
    }

    public final boolean h2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048723, this)) == null) {
            TbMixPlayerView tbMixPlayerView = this.O1;
            if (tbMixPlayerView != null && tbMixPlayerView.getVisibility() == 0) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public void h3() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048724, this) == null) {
            g3();
            z1();
            this.j1.g();
            X3(false);
        }
    }

    public View i1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048727, this)) == null) {
            return this.X0;
        }
        return (View) invokeV.objValue;
    }

    public void i3() {
        Handler handler;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048729, this) != null) || (handler = this.V1) == null) {
            return;
        }
        Runnable runnable = this.W1;
        if (runnable != null) {
            handler.removeCallbacks(runnable);
        }
        s sVar = new s(this);
        this.W1 = sVar;
        this.V1.postDelayed(sVar, 2000L);
    }

    public PbFakeFloorModel j1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048732, this)) == null) {
            return this.i1;
        }
        return (PbFakeFloorModel) invokeV.objValue;
    }

    public l0a k1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048737, this)) == null) {
            return this.j1;
        }
        return (l0a) invokeV.objValue;
    }

    @Nullable
    public final View l1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048742, this)) == null) {
            o2a o2aVar = this.v;
            if (o2aVar != null) {
                return o2aVar.c();
            }
            return null;
        }
        return (View) invokeV.objValue;
    }

    public void m4() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048750, this) == null) {
            this.f1130T.setVisibility(0);
        }
    }

    public boolean n2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048753, this)) == null) {
            v6a v6aVar = this.I0;
            if (v6aVar == null) {
                return false;
            }
            return v6aVar.h();
        }
        return invokeV.booleanValue;
    }

    public final void n3() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048754, this) == null) {
            this.I1.setFallingFeedbackListener(new o0(this));
        }
    }

    public void n4() {
        vz9 vz9Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048755, this) == null) && (vz9Var = this.J) != null) {
            vz9Var.X();
        }
    }

    public boolean o2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048758, this)) == null) {
            EditorTools editorTools = this.q0;
            if (editorTools != null && editorTools.D()) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public int p1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048762, this)) == null) {
            return this.S0;
        }
        return invokeV.intValue;
    }

    public void p4() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048765, this) == null) && this.I0 != null && s1()) {
            this.I0.n(2);
        }
    }

    public View q1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048767, this)) == null) {
            return this.g;
        }
        return (View) invokeV.objValue;
    }

    public void q2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048768, this) == null) {
            Y2(this.P0);
        }
    }

    public PbThreadPostView r1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048772, this)) == null) {
            return this.q;
        }
        return (PbThreadPostView) invokeV.objValue;
    }

    public final boolean s1() {
        InterceptResult invokeV;
        ThreadData R;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048777, this)) == null) {
            aw9 aw9Var = this.P0;
            if (aw9Var == null || (R = aw9Var.R()) == null) {
                return false;
            }
            return !R.isDisableShare();
        }
        return invokeV.booleanValue;
    }

    public void t0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048781, this) == null) {
            this.j.f();
            n05 n05Var = this.h0;
            if (n05Var != null) {
                n05Var.dismiss();
            }
            w0();
            f05 f05Var = this.K;
            if (f05Var != null) {
                f05Var.dismiss();
            }
            g05 g05Var = this.L;
            if (g05Var != null) {
                g05Var.e();
            }
        }
    }

    public RelativeLayout t1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048782, this)) == null) {
            return this.I;
        }
        return (RelativeLayout) invokeV.objValue;
    }

    public void u0() {
        v6a v6aVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048786, this) == null) && (v6aVar = this.I0) != null) {
            v6aVar.k(false);
        }
    }

    public RelativeLayout u1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048787, this)) == null) {
            return this.f;
        }
        return (RelativeLayout) invokeV.objValue;
    }

    public final boolean v0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048791, this)) == null) {
            return this.v.b(this.O0);
        }
        return invokeV.booleanValue;
    }

    public final void v1() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048792, this) == null) && this.O1 != null) {
            Q3(n1a.i(this.e));
            this.O1.s();
            this.O1.setVisibility(8);
        }
    }

    public void w1() {
        View view2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048797, this) == null) {
            PbLandscapeListView pbLandscapeListView = this.n;
            if (pbLandscapeListView != null) {
                pbLandscapeListView.setVisibility(8);
            }
            e5a e5aVar = this.j;
            if (e5aVar != null && (view2 = e5aVar.f) != null) {
                view2.setVisibility(8);
            }
        }
    }

    public void w4() {
        o4a o4aVar;
        LinearLayout linearLayout;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048800, this) == null) && (o4aVar = this.M1) != null && (linearLayout = this.L1) != null) {
            o4aVar.c(linearLayout);
        }
    }

    public void x0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048801, this) == null) {
            StatisticItem statisticItem = new StatisticItem("c14693");
            statisticItem.param("uid", TbadkCoreApplication.getCurrentAccountId());
            statisticItem.param("obj_locate", o2);
            TiebaStatic.log(statisticItem);
        }
    }

    public void x1() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048802, this) != null) || this.x0 == null) {
            return;
        }
        this.w0.setVisibility(8);
        this.x0.setVisibility(8);
        this.L0 = false;
    }

    public void x4() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048805, this) == null) {
            this.e.showProgressBar();
        }
    }

    public void y0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048806, this) == null) {
            StatisticItem statisticItem = new StatisticItem("c14692");
            statisticItem.param("uid", TbadkCoreApplication.getCurrentAccountId());
            statisticItem.param("obj_locate", o2);
            TiebaStatic.log(statisticItem);
        }
    }

    public void y4() {
        PbFallingView pbFallingView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048810, this) == null) && (pbFallingView = this.I1) != null) {
            pbFallingView.z();
        }
    }

    public void z0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048811, this) == null) {
            PbListView pbListView = this.P;
            if (pbListView != null) {
                pbListView.B();
                this.P.g();
            }
            C1();
        }
    }

    public void z1() {
        EditorTools editorTools;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048812, this) == null) && (editorTools = this.q0) != null) {
            editorTools.v();
            x2a x2aVar = this.t1;
            if (x2aVar != null) {
                x2aVar.m();
            }
        }
    }

    public void z4() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048815, this) == null) && this.e2 != null) {
            while (this.e2.size() > 0) {
                TbImageView remove = this.e2.remove(0);
                if (remove != null) {
                    remove.stopLoading();
                }
            }
        }
    }

    public void A2(boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(Constants.METHOD_SEND_USER_MSG, this, z2) == null) {
            if (z2) {
                c4();
            } else {
                B1();
            }
            this.e1.a = null;
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004013, this.e1));
            U2(this.e1.a, false);
        }
    }

    public void B4(boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048585, this, z2) == null) {
            this.j.B(z2);
            if (z2 && this.T0) {
                this.P.H(TbadkCoreApplication.getInst().getResources().getString(R.string.click_load_more));
                PbLandscapeListView pbLandscapeListView = this.n;
                if (pbLandscapeListView != null) {
                    pbLandscapeListView.setNextPage(this.P);
                }
                this.h = 2;
            }
        }
    }

    public void V1(aw9 aw9Var) {
        d85 e02;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048671, this, aw9Var) != null) || aw9Var == null) {
            return;
        }
        if (aw9Var.r0()) {
            e02 = aw9Var.e0();
        } else {
            e02 = aw9Var.e0();
            if (e02 == null || e02.a()) {
                e02 = TbSingleton.getInstance().getPbAdFloatViewItemData();
            }
        }
        if (e02 != null && !e02.a()) {
            U1(aw9Var, e02);
        } else {
            F1();
        }
    }

    public void X3(boolean z2) {
        boolean z3;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeZ(1048681, this, z2) != null) || this.x0 == null) {
            return;
        }
        if (this.e.f7() != null && this.e.f7().C()) {
            z3 = true;
        } else {
            z3 = false;
        }
        p3(z3);
        if (this.r0) {
            a4(z2);
        } else {
            y1(z2);
        }
    }

    public void a4(boolean z2) {
        TextView textView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048694, this, z2) == null) && this.x0 != null && (textView = this.A0) != null) {
            textView.setText(R.string.obfuscated_res_0x7f0f061a);
            if (z2) {
                AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
                alphaAnimation.setDuration(400L);
                this.x0.startAnimation(alphaAnimation);
            }
            this.w0.setVisibility(0);
            this.x0.setVisibility(0);
            this.L0 = true;
        }
    }

    public final boolean i2(ThreadData threadData) {
        InterceptResult invokeL;
        String str;
        nwa a02;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048728, this, threadData)) == null) {
            if (threadData != null && threadData.getAuthor() != null) {
                aw9 aw9Var = this.P0;
                if (aw9Var != null && (a02 = aw9Var.a0()) != null && a02.u() != null) {
                    str = a02.u().getUserId();
                } else {
                    str = "";
                }
                return TextUtils.equals(TbadkCoreApplication.getCurrentAccount(), str);
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public final boolean l2(aw9 aw9Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048743, this, aw9Var)) == null) {
            if (aw9Var == null) {
                return true;
            }
            ArrayList<nwa> I = aw9Var.I();
            if (ListUtils.getCount(I) == 0) {
                return true;
            }
            if (ListUtils.getCount(I) == 1 && ListUtils.getItem(I, 0) != null && ((nwa) ListUtils.getItem(I, 0)).L() == 1) {
                return true;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public final int n1(PbReplyTitleViewHolder pbReplyTitleViewHolder) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048752, this, pbReplyTitleViewHolder)) == null) {
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

    public void v2(Configuration configuration) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048793, this, configuration) != null) || configuration == null) {
            return;
        }
        s0();
        if (configuration.orientation == 2) {
            x1();
            z1();
        } else {
            h3();
        }
        l0a l0aVar = this.j1;
        if (l0aVar != null) {
            l0aVar.g();
        }
        this.e.t7();
        this.I.setVisibility(8);
        this.j.v(false);
        this.e.L8(false);
    }

    public void B0(int i3, boolean z2, String str, boolean z3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048581, this, new Object[]{Integer.valueOf(i3), Boolean.valueOf(z2), str, Boolean.valueOf(z3)}) == null) {
            this.e.hideProgressBar();
            if (z2 && z3) {
                PbFragment pbFragment = this.e;
                pbFragment.showToast(pbFragment.getPageContext().getString(R.string.obfuscated_res_0x7f0f14e6));
            } else if (z3) {
                if (rd.isEmpty(str)) {
                    str = TbadkCoreApplication.getInst().getResources().getString(R.string.obfuscated_res_0x7f0f0e70);
                }
                this.e.showToast(str);
            }
        }
    }

    public void C4(zv9 zv9Var) {
        String string;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048590, this, zv9Var) != null) || zv9Var == null) {
            return;
        }
        this.j.C();
        if (!StringUtils.isNull(zv9Var.b)) {
            this.j.y(zv9Var.b);
        }
        String string2 = TbadkCoreApplication.getInst().getResources().getString(R.string.obfuscated_res_0x7f0f169c);
        int i3 = JavaTypesHelper.toInt(zv9Var.a, 0);
        if (i3 != 100) {
            if (i3 != 300) {
                if (i3 != 400) {
                    string = "";
                } else {
                    string = TbadkCoreApplication.getInst().getResources().getString(R.string.obfuscated_res_0x7f0f1609);
                }
            } else {
                string = TbadkCoreApplication.getInst().getResources().getString(R.string.obfuscated_res_0x7f0f0340);
            }
        } else {
            string = TbadkCoreApplication.getInst().getResources().getString(R.string.obfuscated_res_0x7f0f13ab);
        }
        this.e.showNetRefreshView(this.f, String.format(string2, string), null, TbadkCoreApplication.getInst().getResources().getString(R.string.appeal_restore), true, new f0(this, zv9Var.c));
    }

    public void Q2(@NonNull View view2) {
        PbFragment pbFragment;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048652, this, view2) == null) && this.D0.getData() != null && this.D0.getData().hasAgree && this.e.getActivity() != null) {
            PbFirstFloorDoubleClickAnimation pbFirstFloorDoubleClickAnimation = new PbFirstFloorDoubleClickAnimation(this.e.getContext());
            int dimens = BdUtilHelper.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds774);
            int dimens2 = BdUtilHelper.getDimens(TbadkCoreApplication.getInst(), R.dimen.obfuscated_res_0x7f070913);
            int[] iArr = new int[2];
            view2.getLocationInWindow(iArr);
            int i3 = iArr[0];
            int i4 = iArr[1];
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(dimens2, dimens);
            layoutParams.leftMargin = ((view2.getWidth() / 2) + i3) - ((int) ((dimens2 * 1) / 1.45d));
            layoutParams.topMargin = BdUtilHelper.getDimens(TbadkCoreApplication.getInst(), R.dimen.M_H_X006);
            pbFirstFloorDoubleClickAnimation.setLottieHeight(dimens);
            pbFirstFloorDoubleClickAnimation.setLayoutParmas(layoutParams);
            pbFirstFloorDoubleClickAnimation.setClippingEnable(false);
            if (this.P0 != null && (pbFragment = this.e) != null) {
                pbFirstFloorDoubleClickAnimation.showFireworks(true, pbFragment.getActivity().findViewById(16908290), 0, i4, this.P0.T(), this.P0.o());
            }
            pbFirstFloorDoubleClickAnimation.setOnPraiseAnimatorListener(new q(this));
        }
    }

    public final boolean Z3(aw9 aw9Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048689, this, aw9Var)) == null) {
            if (aw9Var == null || aw9Var.R() == null) {
                return false;
            }
            if (aw9Var.R().getIsLive() != 1 && aw9Var.R().getThreadType() != 33 && ((aw9Var.R().getTopicData() == null || aw9Var.R().getTopicData().a() == 0) && aw9Var.R().getIs_top() != 1 && aw9Var.R().getIs_good() != 1 && !aw9Var.R().isActInfo() && !aw9Var.R().isInterviewLive() && !aw9Var.R().isVoteThreadType() && aw9Var.R().getYulePostActivityData() == null && rd.isEmpty(aw9Var.R().getCategory()) && !aw9Var.R().isGodThread() && !aw9Var.R().isRealGod())) {
                return false;
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public void q0(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048766, this, str) == null) {
            if (str.contains("_")) {
                str = str.replace("_", "\n");
            }
            f05 f05Var = new f05(this.e.getPageContext().getPageActivity());
            View inflate = LayoutInflater.from(this.e.getPageContext().getPageActivity()).inflate(R.layout.upgrade_success_dialog_content, (ViewGroup) null);
            TextView textView = (TextView) inflate.findViewById(R.id.title_view);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
            layoutParams.setMargins(0, 0, 0, 0);
            textView.setLayoutParams(layoutParams);
            textView.setGravity(3);
            textView.setText(str);
            ((TextView) inflate.findViewById(R.id.function_description_view)).setVisibility(8);
            f05Var.setContentView(inflate);
            SparseArray sparseArray = new SparseArray();
            sparseArray.put(i2, Integer.valueOf(l2));
            f05Var.setYesButtonTag(sparseArray);
            f05Var.setPositiveButton(R.string.obfuscated_res_0x7f0f1857, this.e);
            f05Var.setNegativeButton(R.string.obfuscated_res_0x7f0f03db, new m0(this));
            f05Var.create(this.e.getPageContext()).show();
        }
    }

    public final void D4() {
        PbFragment pbFragment;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048595, this) == null) && (pbFragment = this.e) != null && pbFragment.f7() != null) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921706, Boolean.valueOf(!this.e.f7().C())));
        }
    }

    public void F2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048603, this) == null) {
            this.J.w(2);
            G2();
            p2();
            J4();
            this.u.F();
            k0();
            g0a g0aVar = this.D;
            if (g0aVar != null) {
                g0aVar.k();
            }
            if (h2()) {
                this.O1.o();
            }
        }
    }

    public final void G4() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048610, this) != null) || !this.e.Y6()) {
            return;
        }
        if (this.e.d7() == -1) {
            SkinManager.setViewTextColor(this.G, R.color.CAM_X0110, 1);
        }
        if (this.e.c7() == -1) {
            SkinManager.setViewTextColor(this.H, R.color.CAM_X0110, 1);
        }
    }

    public final void R1() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048655, this) != null) || this.e.u1 == 3 || !TbadkCoreApplication.isLogin()) {
            return;
        }
        i iVar = new i(this);
        this.E = new e0a(this.e.u0());
        this.D = new g0a(this.n, iVar);
    }

    public final void T1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048663, this) == null) {
            if (this.I1.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) {
                ((ViewGroup.MarginLayoutParams) this.I1.getLayoutParams()).setMargins(0, n1a.i(this.e), 0, 0);
            }
            n3();
            this.I1.setAnimationListener(new b(this));
        }
    }

    public final void e3() {
        PbFragment pbFragment;
        WaterRippleView waterRippleView;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048709, this) != null) || (pbFragment = this.e) == null || pbFragment.getActivity() == null || (waterRippleView = this.B0) == null) {
            return;
        }
        ViewParent parent = waterRippleView.getParent();
        if (parent instanceof ViewGroup) {
            ((ViewGroup) parent).removeView(this.B0);
        }
        TextView textView = this.J0;
        if (textView != null) {
            textView.setVisibility(0);
        }
    }

    public void f3() {
        PbLandscapeListView pbLandscapeListView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048714, this) == null) && (pbLandscapeListView = this.n) != null) {
            this.A.d(pbLandscapeListView);
            this.w.h(this.n);
            this.x.u(this.n);
            this.y.d(this.n);
            this.v.f(this.n);
        }
    }

    public boolean i0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048726, this)) == null) {
            PbListView pbListView = this.P;
            if (pbListView != null && !TextUtils.isEmpty(pbListView.j())) {
                return this.P.j().equals(TbadkCoreApplication.getInst().getResources().getString(R.string.list_has_all_comments));
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public boolean j2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048733, this)) == null) {
            View view2 = this.b1;
            if (view2 == null || view2.getParent() == null || this.P.p()) {
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

    public boolean k2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048738, this)) == null) {
            aw9 aw9Var = this.P0;
            if (aw9Var == null || aw9Var.n() == null || "0".equals(this.P0.n().getId())) {
                return true;
            }
            return "me0407".equals(this.P0.n().getName());
        }
        return invokeV.booleanValue;
    }

    public String m1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048747, this)) == null) {
            if (!rd.isEmpty(this.A1)) {
                return this.A1;
            }
            if (this.e != null) {
                this.A1 = TbadkCoreApplication.getInst().getResources().getString(n1a.d());
            }
            return this.A1;
        }
        return (String) invokeV.objValue;
    }

    public final void n0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048751, this) == null) {
            zy9 zy9Var = new zy9(this.e, this, (ViewStub) this.f.findViewById(R.id.obfuscated_res_0x7f09186b));
            this.u1 = zy9Var;
            zy9Var.n(this.U);
            this.u1.o(this.R1);
            this.u1.p(this.W);
            this.u1.n(this.U);
            this.u1.r(this.o0);
        }
    }

    public final void o4() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048760, this) == null) {
            PbFallingView pbFallingView = this.I1;
            if (pbFallingView != null) {
                pbFallingView.setTag(Boolean.TRUE);
            }
            RightFloatLayerView rightFloatLayerView = this.J1;
            if (rightFloatLayerView != null && rightFloatLayerView.getTag() == this.I1) {
                this.J1.setTag(null);
                this.J1.setAutoCompleteShown(true);
                this.J1.d();
            }
        }
    }

    public void s0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048776, this) == null) {
            this.j.f();
            PbFragment pbFragment = this.e;
            if (pbFragment != null) {
                BdUtilHelper.hideSoftKeyPad(pbFragment.getContext(), this.N);
            }
            z1();
            n05 n05Var = this.h0;
            if (n05Var != null) {
                n05Var.dismiss();
            }
            w0();
            f05 f05Var = this.K;
            if (f05Var != null) {
                f05Var.dismiss();
            }
            g05 g05Var = this.L;
            if (g05Var != null) {
                g05Var.e();
            }
        }
    }

    public void w0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048796, this) == null) {
            c0a c0aVar = this.C;
            if (c0aVar != null) {
                c0aVar.a();
            }
            Dialog dialog = this.Z;
            if (dialog != null) {
                yb.b(dialog, this.e.getPageContext());
            }
            Dialog dialog2 = this.a0;
            if (dialog2 != null) {
                yb.b(dialog2, this.e.getPageContext());
            }
            n05 n05Var = this.Y;
            if (n05Var != null) {
                n05Var.dismiss();
            }
        }
    }

    public final String E0(long j3) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJ = interceptable.invokeJ(1048596, this, j3)) == null) {
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
        if (interceptable == null || (invokeI = interceptable.invokeI(1048601, this, i3)) == null) {
            if (i3 == 0) {
                return this.e.getString(R.string.obfuscated_res_0x7f0f1019);
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

    public void H4(boolean z2) {
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048615, this, z2) == null) {
            vz9 vz9Var = this.J;
            if (vz9Var != null) {
                vz9Var.P(z2);
                this.J.v();
            }
            PbReplyTitleViewHolder pbReplyTitleViewHolder = this.a1;
            if (pbReplyTitleViewHolder != null) {
                pbReplyTitleViewHolder.r(z2);
            }
            PbReplyTitleViewHolder pbReplyTitleViewHolder2 = this.e1.a;
            if (pbReplyTitleViewHolder2 != null) {
                pbReplyTitleViewHolder2.r(z2);
            }
            PbFragment pbFragment = this.e;
            if (pbFragment != null) {
                pbFragment.K8(z2);
            }
            if (z2) {
                q4a.d(this.e.getPageContext(), this.e.l0(), this.e.i7());
            }
            StatisticItem statisticItem = new StatisticItem(CommonStatisticKey.KEY_BATCH_MULTI_DEL_CLICK);
            aw9 aw9Var = this.P0;
            if (aw9Var != null) {
                str = aw9Var.o();
            } else {
                str = "0";
            }
            TiebaStatic.log(statisticItem.param("fid", str).param("uid", TbadkCoreApplication.getCurrentAccountId()).param("obj_type", "1"));
        }
    }

    public void Q1(@Nullable SpriteMemeInfo spriteMemeInfo) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048651, this, spriteMemeInfo) == null) {
            if (this.e != null && this.q0 != null) {
                TiebaStatic.log(new StatisticItem(CommonStatisticKey.KEY_RD_USE).param("obj_param1", 3).param("obj_locate", 9).param("obj_type", 1).param("obj_source", UtilHelper.getCurrentPageName(TbadkCoreApplication.getInst().getCurrentActivity())));
                this.q0.n(spriteMemeInfo);
                x1();
                return;
            }
            TiebaStatic.log(new StatisticItem(CommonStatisticKey.KEY_RD_USE).param("obj_param1", 3).param("obj_locate", 20).param("obj_type", 1).param("obj_source", UtilHelper.getCurrentPageName(TbadkCoreApplication.getInst().getCurrentActivity())));
        }
    }

    public final void X1(aw9 aw9Var) {
        PbListView pbListView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048679, this, aw9Var) == null) && (pbListView = this.P) != null && pbListView.i() != null) {
            LinearLayout i3 = this.P.i();
            if (aw9Var.B().b() == 0 && !this.e.l0().X0() && !l2(aw9Var)) {
                if (this.a == null) {
                    L1();
                }
                ViewParent parent = this.a.getParent();
                if (parent instanceof ViewGroup) {
                    ((ViewGroup) parent).removeView(this.a);
                }
                i3.addView(this.a);
                ForumData n3 = aw9Var.n();
                px4 forumShowInfo = n3.getForumShowInfo();
                if (forumShowInfo != null) {
                    forumShowInfo.g(TbadkCoreApplication.getInst().getString(R.string.enter_forum));
                }
                this.a.setData(n3.getName(), n3.getImage_url(), n3.getPost_num(), n3.getMember_num(), n3.getPendants(), forumShowInfo);
                return;
            }
            i3.removeView(this.a);
            i3.setVisibility(8);
        }
    }

    public void k3(EditorTools editorTools) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048739, this, editorTools) != null) || this.e == null) {
            return;
        }
        this.q0 = editorTools;
        editorTools.setOnCancelClickListener(new u(this));
        this.q0.setId(R.id.obfuscated_res_0x7f091b9e);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams.addRule(12);
        if (this.q0.getParent() == null) {
            this.f.addView(this.q0, layoutParams);
        }
        this.q0.F(TbadkCoreApplication.getInst().getSkinType());
        this.q0.setActionListener(24, new v(this));
        A1();
        this.e.f7().i(new w(this));
    }

    public void r4(boolean z2) {
        TextView textView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048775, this, z2) == null) && this.n != null && (textView = this.W0) != null && this.g != null) {
            if (z2) {
                if (UtilHelper.canUseStyleImmersiveSticky()) {
                    this.g.setVisibility(0);
                } else {
                    this.g.setVisibility(8);
                    this.n.removeHeaderView(this.W0);
                    this.n.setTextViewAdded(false);
                }
                if (this.W0.getLayoutParams() instanceof AbsListView.LayoutParams) {
                    AbsListView.LayoutParams layoutParams = (AbsListView.LayoutParams) this.W0.getLayoutParams();
                    layoutParams.height = g2;
                    this.W0.setLayoutParams(layoutParams);
                    return;
                }
                return;
            }
            if (textView.getLayoutParams() instanceof AbsListView.LayoutParams) {
                AbsListView.LayoutParams layoutParams2 = (AbsListView.LayoutParams) this.W0.getLayoutParams();
                layoutParams2.height = BdListViewHelper.a(BdListViewHelper.HeadType.DEFAULT) + e1(true);
                this.W0.setLayoutParams(layoutParams2);
            }
            b3();
        }
    }

    public void t2(AgreeMessageData agreeMessageData) {
        aw9 aw9Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048783, this, agreeMessageData) == null) && agreeMessageData != null && agreeMessageData.agreeData != null && (aw9Var = this.P0) != null && aw9Var.R() != null && this.P0.R().getAgreeData() != null) {
            AgreeData agreeData = this.P0.R().getAgreeData();
            String str = agreeMessageData.agreeData.nid;
            if (!TextUtils.isEmpty(str) && !"0".equals(str)) {
                BaijiahaoData baijiahaoData = agreeData.baijiahaoData;
                if (baijiahaoData == null || !TextUtils.equals(str, baijiahaoData.oriUgcNid)) {
                    return;
                }
            } else {
                String str2 = agreeMessageData.agreeData.threadId;
                String str3 = agreeData.threadId;
                if ("0".equals(str2) || TextUtils.isEmpty(str2) || !TextUtils.equals(str2, str3)) {
                    return;
                }
            }
            AgreeData agreeData2 = agreeMessageData.agreeData;
            X2(agreeData2, agreeData2.agreeNum);
        }
    }

    public final void t4(aw9 aw9Var) {
        boolean z2;
        q2a q2aVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048785, this, aw9Var) == null) && !this.x1 && aw9Var != null && aw9Var.R() != null && !aw9Var.R().isVideoThreadType()) {
            ThreadData R = aw9Var.R();
            boolean z3 = false;
            if (R.getIs_good() == 1) {
                z2 = true;
            } else {
                z2 = false;
            }
            if (R.getIs_top() == 1) {
                z3 = true;
            }
            s2a s2aVar = this.x;
            if (s2aVar != null) {
                s2aVar.m(aw9Var, z2, z3);
            }
            if (R.isShowTitle() && (q2aVar = this.w) != null && q2aVar.d() != null) {
                d4a.a(this.w.d(), R.isHeadLinePost, R.isGoodThread(), R.isTopThread());
            }
            if (G0() != null) {
                G0().Y(aw9Var);
            }
        }
    }

    public void x2(TbRichText tbRichText) {
        aw9 aw9Var;
        nwa nwaVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048803, this, tbRichText) == null) && (aw9Var = this.P0) != null && aw9Var.I() != null && !this.P0.I().isEmpty() && tbRichText != null && !StringUtils.isNull(tbRichText.getAuthorId())) {
            for (int i3 = 0; i3 < this.P0.I().size() && (nwaVar = this.P0.I().get(i3)) != null && nwaVar.u() != null && !StringUtils.isNull(nwaVar.u().getUserId()); i3++) {
                if (this.P0.I().get(i3).u().getUserId().equals(tbRichText.getAuthorId())) {
                    zy9 zy9Var = this.u1;
                    if (zy9Var != null && zy9Var.k()) {
                        X3(false);
                        return;
                    }
                    return;
                }
            }
        }
    }

    public void y1(boolean z2) {
        boolean z3;
        boolean z4;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048807, this, z2) == null) && this.x0 != null && this.A0 != null) {
            TbSingleton tbSingleton = TbSingleton.getInstance();
            aw9 aw9Var = this.P0;
            if (aw9Var != null && aw9Var.r0()) {
                z3 = true;
            } else {
                z3 = false;
            }
            aw9 aw9Var2 = this.P0;
            if (aw9Var2 != null && aw9Var2.s0()) {
                z4 = true;
            } else {
                z4 = false;
            }
            this.A0.setText(tbSingleton.getAdVertiComment(z3, z4, m1()));
            if (z2) {
                AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
                alphaAnimation.setDuration(400L);
                this.x0.startAnimation(alphaAnimation);
            }
            this.w0.setVisibility(0);
            this.x0.setVisibility(0);
            this.L0 = true;
        }
    }

    public void E2(@Nullable SpriteMemeInfo spriteMemeInfo) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048598, this, spriteMemeInfo) == null) {
            TiebaStatic.log(new StatisticItem(CommonStatisticKey.KEY_RD_USE).param("obj_param1", 3).param("obj_locate", 1).param("obj_type", 1).param("obj_source", UtilHelper.getCurrentPageName(TbadkCoreApplication.getInst().getCurrentActivity())));
            if (!DialogLoginHelper.checkUpIsLogin(new LoginDialogData(this.e.getActivity(), LoginDialogData.PB_BOTTOM_REPLY_RESULT_PAGE))) {
                TiebaStatic.log(new StatisticItem(CommonStatisticKey.KEY_RD_USE).param("obj_param1", 3).param("obj_locate", 2).param("obj_type", 1).param("obj_source", UtilHelper.getCurrentPageName(TbadkCoreApplication.getInst().getCurrentActivity())));
                return;
            }
            D4();
            this.e.r8(spriteMemeInfo);
            PbFragment pbFragment = this.e;
            if (pbFragment != null && pbFragment.l0() != null && this.e.l0().s1() != null && this.e.l0().s1().R() != null && this.e.l0().s1().R().getAuthor() != null) {
                TiebaStatic.log(new StatisticItem("c13701").param("tid", this.e.l0().N1()).param("fid", this.e.l0().s1().o()).param("uid", TbadkCoreApplication.getCurrentAccountId()));
                TiebaStatic.log(new StatisticItem("c13402").param("tid", this.e.l0().b).param("fid", this.e.l0().s1().o()).param("obj_locate", 1).param("uid", TbadkCoreApplication.getCurrentAccount()));
            }
        }
    }

    public void Y1(aw9 aw9Var) {
        PbReplyTitleViewHolder pbReplyTitleViewHolder;
        int bottom;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048683, this, aw9Var) == null) {
            int i3 = 0;
            this.J.D(aw9Var, false);
            this.J.v();
            v0();
            zy9 zy9Var = this.u1;
            if (zy9Var != null) {
                zy9Var.m();
            }
            ArrayList<nwa> I = aw9Var.I();
            if (aw9Var.B().b() == 0 || I == null || I.size() < aw9Var.B().e()) {
                if (l2(aw9Var)) {
                    v0 v0Var = this.e1;
                    if (v0Var != null && (pbReplyTitleViewHolder = v0Var.a) != null && pbReplyTitleViewHolder.getView() != null) {
                        if (this.e1.a.getView().getTop() < 0) {
                            bottom = this.e1.a.getView().getHeight();
                        } else {
                            bottom = this.e1.a.getView().getBottom();
                        }
                        i3 = bottom;
                    }
                    if (this.e.F7()) {
                        this.P.K(TbadkCoreApplication.getInst().getResources().getString(R.string.obfuscated_res_0x7f0f1037), i3);
                    } else {
                        this.P.K(TbadkCoreApplication.getInst().getResources().getString(R.string.obfuscated_res_0x7f0f1038), i3);
                    }
                } else {
                    if (aw9Var.B().b() == 0) {
                        this.P.H(TbadkCoreApplication.getInst().getResources().getString(R.string.list_has_all_comments));
                    } else {
                        this.P.H(TbadkCoreApplication.getInst().getResources().getString(R.string.load_more));
                    }
                    this.P.n();
                }
            }
            Y2(aw9Var);
        }
    }

    public final void Y2(aw9 aw9Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048684, this, aw9Var) == null) && aw9Var != null && aw9Var.R() != null) {
            E4(aw9Var);
            ImageView imageView = this.E0;
            if (imageView != null && imageView.getContext() != null) {
                if (aw9Var.t()) {
                    WebPManager.setPureDrawable(this.E0, R.drawable.icon_pure_pb_bottom_collected26_selection, R.color.CAM_X0305, WebPManager.ResourceStateType.NORMAL_PRESS);
                } else {
                    WebPManager.setPureDrawable(this.E0, R.drawable.icon_pure_pb_bottom_collect26, R.color.CAM_X0107, WebPManager.ResourceStateType.NORMAL_PRESS);
                }
            }
            String F0 = F0(aw9Var.R().getReply_num());
            TextView textView = this.K0;
            if (textView != null) {
                textView.setText(F0);
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921416, aw9Var.R()));
            X2(aw9Var.R().getAgreeData(), aw9Var.R().getAgreeNum());
            if (this.D0 != null && aw9Var.R() != null) {
                this.D0.setThreadData(aw9Var.R());
                int i3 = 1;
                if (aw9Var.R().getAgreeData() != null) {
                    aw9Var.R().getAgreeData().isInThread = true;
                }
                this.D0.setData(aw9Var.R().getAgreeData());
                lw4 lw4Var = new lw4();
                lw4Var.b = 26;
                if (aw9Var.R().isVideoThreadType() && aw9Var.R().getThreadVideoInfo() != null) {
                    i3 = 2;
                }
                lw4Var.c = i3;
                PbFragment pbFragment = this.e;
                if (pbFragment != null && pbFragment.l0() != null) {
                    lw4Var.j = this.e.l0().getFromForumId();
                    lw4Var.f = this.e.l0().r1();
                }
                this.D0.setStatisticData(lw4Var);
            }
        }
    }

    public void Y3(aw9 aw9Var) {
        nwa nwaVar;
        e5a e5aVar;
        boolean z2;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048685, this, aw9Var) == null) && aw9Var != null && (nwaVar = this.Q0) != null && nwaVar.u() != null && (e5aVar = this.j) != null) {
            boolean z3 = !this.m1;
            this.n1 = z3;
            e5aVar.A(z3);
            if (this.e.g7() != null) {
                this.e.g7().s(this.n1);
            }
            V2();
            PbFragment pbFragment = this.e;
            if (pbFragment != null && !pbFragment.e1() && !ListUtils.isEmpty(aw9Var.r())) {
                iz4 iz4Var = aw9Var.r().get(0);
                if (iz4Var != null) {
                    this.j.D(aw9Var, iz4Var.d(), iz4Var.b(), iz4Var.a(), iz4Var.f());
                }
            } else if (aw9Var.n() != null) {
                e5a e5aVar2 = this.j;
                String name = aw9Var.n().getName();
                String id = aw9Var.n().getId();
                String image_url = aw9Var.n().getImage_url();
                if (aw9Var.n().isLike() == 1) {
                    z2 = true;
                } else {
                    z2 = false;
                }
                e5aVar2.D(aw9Var, name, id, image_url, z2);
            }
            if (this.n1) {
                nwa nwaVar2 = this.Q0;
                if (nwaVar2 != null) {
                    this.x.D(aw9Var, nwaVar2, this.l0);
                }
                View view2 = this.Z0;
                if (view2 != null) {
                    view2.setVisibility(8);
                }
                if (this.v1 == null) {
                    this.v1 = new i0(this);
                }
                PbLandscapeListView pbLandscapeListView = this.n;
                if (pbLandscapeListView != null) {
                    pbLandscapeListView.setListViewDragListener(this.v1);
                    return;
                }
                return;
            }
            View view3 = this.Z0;
            if (view3 != null) {
                view3.setVisibility(0);
            }
            this.x.D(aw9Var, this.Q0, this.l0);
            this.v1 = null;
            PbLandscapeListView pbLandscapeListView2 = this.n;
            if (pbLandscapeListView2 != null) {
                pbLandscapeListView2.setListViewDragListener(null);
            }
        }
    }

    public void b4(View view2) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048698, this, view2) != null) || SharedPrefHelper.getInstance().getBoolean("show_long_press_collection_tips", false)) {
            return;
        }
        Rect rect = new Rect();
        this.x0.getGlobalVisibleRect(rect);
        int i3 = rect.bottom;
        int i4 = rect.top;
        view2.getGlobalVisibleRect(rect);
        int i5 = rect.bottom;
        FrameLayout frameLayout = new FrameLayout(this.e.getContext());
        frameLayout.setBackgroundResource(R.drawable.pic_sign_tip);
        TextView textView = new TextView(this.e.getContext());
        this.s1 = textView;
        textView.setText(R.string.obfuscated_res_0x7f0f04e1);
        this.s1.setGravity(17);
        this.s1.setPadding(BdUtilHelper.getDimens(this.e.getContext(), R.dimen.obfuscated_res_0x7f0701e8), 0, BdUtilHelper.getDimens(this.e.getContext(), R.dimen.obfuscated_res_0x7f0701e8), 0);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        layoutParams.gravity = 17;
        layoutParams.height = BdUtilHelper.getDimens(this.e.getContext(), R.dimen.obfuscated_res_0x7f070253);
        if (this.s1.getParent() == null) {
            frameLayout.addView(this.s1, layoutParams);
        }
        PopupWindow popupWindow = new PopupWindow(this.e.getContext());
        this.r1 = popupWindow;
        popupWindow.setContentView(frameLayout);
        this.r1.setHeight(-2);
        this.r1.setWidth(-2);
        this.r1.setFocusable(true);
        this.r1.setOutsideTouchable(false);
        this.r1.setBackgroundDrawable(new ColorDrawable(TbadkCoreApplication.getInst().getResources().getColor(R.color.transparent)));
        GreyUtil.grey(this.r1);
        PbLandscapeListView pbLandscapeListView = this.n;
        if (pbLandscapeListView != null) {
            pbLandscapeListView.postDelayed(new n0(this, i5, i3, i4, view2), 100L);
        }
        SharedPrefHelper.getInstance().putBoolean("show_long_press_collection_tips", true);
    }

    public void j0(@Nullable SpriteMemeInfo spriteMemeInfo) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048731, this, spriteMemeInfo) == null) {
            if (!this.e.checkUpIsLogin()) {
                TiebaStatic.log(new StatisticItem(CommonStatisticKey.KEY_RD_USE).param("obj_param1", 3).param("obj_locate", 2).param("obj_type", 1).param("obj_source", UtilHelper.getCurrentPageName(TbadkCoreApplication.getInst().getCurrentActivity())));
                c6a.u("c10517", this.n0, 2);
            } else if (!this.e.u6()) {
                TiebaStatic.log(new StatisticItem(CommonStatisticKey.KEY_RD_USE).param("obj_param1", 3).param("obj_locate", 8).param("obj_type", 1).param("obj_source", UtilHelper.getCurrentPageName(TbadkCoreApplication.getInst().getCurrentActivity())));
            } else {
                eh5 f7 = this.e.f7();
                if (f7 != null) {
                    f7.s0(spriteMemeInfo);
                }
                if (f7 != null && (f7.B() || f7.D())) {
                    TiebaStatic.log(new StatisticItem(CommonStatisticKey.KEY_RD_USE).param("obj_param1", 3).param("obj_locate", 10).param("obj_type", 1).param("obj_source", UtilHelper.getCurrentPageName(TbadkCoreApplication.getInst().getCurrentActivity())));
                    this.e.f7().z(false, null);
                    return;
                }
                if (this.q0 != null) {
                    Q1(spriteMemeInfo);
                }
                EditorTools editorTools = this.q0;
                if (editorTools != null) {
                    this.L0 = false;
                    if (editorTools.u(2) != null) {
                        zva.c(this.e.getPageContext(), (View) this.q0.u(2).m, false, p2);
                    }
                }
                x1();
            }
        }
    }

    public void k4(AdapterView.OnItemClickListener onItemClickListener) {
        boolean z2;
        boolean z3;
        boolean z4;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048740, this, onItemClickListener) == null) {
            i05 i05Var = this.j0;
            if (i05Var != null) {
                i05Var.d();
                this.j0 = null;
            }
            if (this.P0 == null) {
                return;
            }
            ArrayList<r05> arrayList = new ArrayList<>();
            String string = this.e.getContext().getString(R.string.all_person);
            boolean z5 = false;
            if (this.P0.M() == 1) {
                z2 = true;
            } else {
                z2 = false;
            }
            arrayList.add(new r05(string, "", z2, Integer.toString(1)));
            String string2 = this.e.getContext().getString(R.string.my_fans);
            if (this.P0.M() == 2) {
                z3 = true;
            } else {
                z3 = false;
            }
            arrayList.add(new r05(string2, "", z3, Integer.toString(5)));
            String string3 = this.e.getContext().getString(R.string.my_attentions);
            if (this.P0.M() == 3) {
                z4 = true;
            } else {
                z4 = false;
            }
            arrayList.add(new r05(string3, "", z4, Integer.toString(6)));
            String string4 = this.e.getContext().getString(R.string.myself_only);
            if (this.P0.M() == 4) {
                z5 = true;
            }
            arrayList.add(new r05(string4, "", z5, Integer.toString(7)));
            i05 i05Var2 = new i05(this.e.getPageContext());
            i05Var2.l(R.string.pb_privacy_setting_thread_reply_decs);
            this.j0 = i05Var2;
            i05Var2.k(arrayList, onItemClickListener);
            i05Var2.c();
            this.j0.n();
        }
    }

    public boolean F4(aw9 aw9Var, boolean z2) {
        InterceptResult invokeLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(1048605, this, aw9Var, z2)) == null) {
            if (aw9Var == null) {
                return false;
            }
            if (this.w != null) {
                if (aw9Var.R() != null && aw9Var.R().getIsNoTitle() == 0 && !aw9Var.R().isVideoThreadType()) {
                    if (aw9Var.R() != null) {
                        ThreadData R = aw9Var.R();
                        R.parserSpecTitleForFrsAndPb(true, Z3(aw9Var));
                        R.setResource(3);
                        R.setPbTitle("2");
                    }
                    if (aw9Var.R().isBJHArticleThreadType()) {
                        this.x.u(this.n);
                        this.w.h(this.n);
                        this.w.a(this.n);
                        this.x.i(this.n);
                        this.x.z(this.P0);
                        if (b2(aw9Var)) {
                            this.w.h(this.n);
                        } else {
                            this.w.i(aw9Var);
                        }
                    } else {
                        this.x.z(this.P0);
                        if (b2(aw9Var)) {
                            this.w.h(this.n);
                        } else {
                            this.w.k(aw9Var);
                        }
                    }
                } else if (aw9Var.R().getIsNoTitle() == 1) {
                    if (aw9Var.R() != null) {
                        this.w.h(this.n);
                        this.x.z(this.P0);
                    }
                } else {
                    this.w.h(this.n);
                    this.x.z(this.P0);
                }
            }
            s4(aw9Var.a0());
            t4(aw9Var);
            this.O0 = z2;
            return false;
        }
        return invokeLZ.booleanValue;
    }

    public void q4(jy4 jy4Var, f05.e eVar) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLL(1048770, this, jy4Var, eVar) != null) || jy4Var == null) {
            return;
        }
        int a2 = jy4Var.a();
        int h3 = jy4Var.h();
        f05 f05Var = this.K;
        if (f05Var != null) {
            f05Var.show();
        } else {
            this.K = new f05(this.e.getPageContext().getPageActivity());
            View inflate = LayoutInflater.from(this.e.getPageContext().getPageActivity()).inflate(R.layout.obfuscated_res_0x7f0d0274, (ViewGroup) null);
            this.M = inflate;
            this.K.setContentView(inflate);
            this.K.setPositiveButton(R.string.obfuscated_res_0x7f0f05ab, eVar);
            this.K.setNegativeButton(R.string.obfuscated_res_0x7f0f05a0, new j0(this));
            this.K.setOnCalcelListener(new k0(this));
            this.K.create(this.e.getPageContext()).show();
        }
        EditText editText = (EditText) this.M.findViewById(R.id.obfuscated_res_0x7f0911b0);
        this.N = editText;
        editText.setText("");
        TextView textView = (TextView) this.M.findViewById(R.id.obfuscated_res_0x7f090879);
        if (a2 <= 0) {
            a2 = 1;
        }
        if (h3 <= 0) {
            h3 = 1;
        }
        textView.setText(MessageFormat.format(TbadkCoreApplication.getInst().getResources().getString(R.string.current_page), Integer.valueOf(a2), Integer.valueOf(h3)));
        this.e.getBaseFragmentActivity().ShowSoftKeyPadDelay(this.N, 150);
    }

    public void H2(AbsListView absListView, int i3, int i4, int i5) {
        PbListView pbListView;
        int i6;
        PbReplyTitleViewHolder pbReplyTitleViewHolder;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLIII(1048613, this, absListView, i3, i4, i5) == null) {
            o0a o0aVar = this.t;
            if (o0aVar != null) {
                o0aVar.c(i3, i4);
            }
            o0a o0aVar2 = this.s;
            if (o0aVar2 != null) {
                o0aVar2.c(i3, i4);
            }
            g0a g0aVar = this.D;
            if (g0aVar != null) {
                g0aVar.l(i3, i4);
            }
            e5a e5aVar = this.j;
            if (e5aVar != null && this.x != null) {
                e5aVar.q(absListView, i3, i4, i5);
            }
            T2();
            this.e1.a = null;
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004013, this.e1));
            W3(m2(absListView, i3));
            U2(this.e1.a, false);
            r0();
            if (this.P.q() && !this.P.D) {
                v0 v0Var = this.e1;
                if (v0Var != null && (pbReplyTitleViewHolder = v0Var.a) != null && pbReplyTitleViewHolder.getView() != null) {
                    if (this.e1.a.getView().getTop() < 0) {
                        i6 = this.e1.a.getView().getHeight();
                    } else {
                        i6 = this.e1.a.getView().getBottom();
                    }
                } else {
                    i6 = 0;
                }
                this.P.f(i6);
                this.P.D = true;
            }
            if (i3 > this.b && (pbListView = this.P) != null && pbListView.i() != null) {
                rk6.f(this.P.i(), 0);
            }
        }
    }

    public void H3(boolean z2, PostWriteCallBackData postWriteCallBackData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZL(1048614, this, z2, postWriteCallBackData) == null) {
            this.e.hideProgressBar();
            if (z2) {
                s0();
            } else if (postWriteCallBackData != null && (postWriteCallBackData.isSensitiveError() || postWriteCallBackData.isErrorLinkCountExceedLimit() || postWriteCallBackData.isErrorShowApplyMemberDialog())) {
                t0();
            } else {
                s0();
            }
        }
    }

    public final boolean g0(AbsListView absListView, int i3) {
        InterceptResult invokeLI;
        boolean z2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048716, this, absListView, i3)) == null) {
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

    public final CustomBlueCheckRadioButton o0(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048756, this, str, str2)) == null) {
            Activity pageActivity = this.e.getPageContext().getPageActivity();
            CustomBlueCheckRadioButton customBlueCheckRadioButton = new CustomBlueCheckRadioButton(pageActivity);
            RadioGroup.LayoutParams layoutParams = new RadioGroup.LayoutParams(-1, BdUtilHelper.getDimens(pageActivity, R.dimen.obfuscated_res_0x7f07019a));
            customBlueCheckRadioButton.setOnCheckedChangeListener(this.d0);
            customBlueCheckRadioButton.setTag(str);
            customBlueCheckRadioButton.setText(str2);
            customBlueCheckRadioButton.setLayoutParams(layoutParams);
            return customBlueCheckRadioButton;
        }
        return (CustomBlueCheckRadioButton) invokeLL.objValue;
    }

    public void s2(boolean z2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048778, this, new Object[]{Boolean.valueOf(z2), Integer.valueOf(i3)}) == null) {
            o0a o0aVar = this.s;
            if (o0aVar != null) {
                o0aVar.b(z2, i3);
            }
            o0a o0aVar2 = this.t;
            if (o0aVar2 != null) {
                o0aVar2.b(z2, i3);
            }
            g0a g0aVar = this.D;
            if (g0aVar != null) {
                g0aVar.m(this.P0.n());
                this.D.i(z2, i3);
            }
        }
    }

    public final void I1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048617, this) == null) {
            ImageView imageView = (ImageView) this.f.findViewById(R.id.obfuscated_res_0x7f0909e4);
            this.z0 = imageView;
            imageView.setOnClickListener(this.S1);
            y0();
            this.A0 = (TextView) this.f.findViewById(R.id.obfuscated_res_0x7f091ba6);
            LinearLayout linearLayout = (LinearLayout) this.f.findViewById(R.id.obfuscated_res_0x7f091b9d);
            this.y0 = linearLayout;
            linearLayout.setOnClickListener(new d(this));
            EjectionAnimationView ejectionAnimationView = (EjectionAnimationView) this.f.findViewById(R.id.obfuscated_res_0x7f0909e8);
            this.u0 = ejectionAnimationView;
            ejectionAnimationView.setEjectionAnimationViewCallback(new e(this));
            this.w0 = this.f.findViewById(R.id.obfuscated_res_0x7f092a43);
            this.x0 = this.f.findViewById(R.id.obfuscated_res_0x7f091ba3);
            this.M0 = BdUtilHelper.getDimens(TbadkCoreApplication.getInst(), R.dimen.obfuscated_res_0x7f0703a3);
            this.C0 = (ImageView) this.f.findViewById(R.id.obfuscated_res_0x7f091ba4);
            this.H1 = (MaskView) this.f.findViewById(R.id.mask_view);
            this.C0.setOnClickListener(this.U);
            AgreeView agreeView = (AgreeView) this.f.findViewById(R.id.obfuscated_res_0x7f091b9f);
            this.D0 = agreeView;
            agreeView.setAgreeAlone(true);
            this.D0.x();
            this.D0.setAgreeLongClickListener(new f(this));
            this.D0.setAfterClickListener(new g(this));
            this.D0.setUseDynamicLikeRes("/pb");
            if (this.D0.getAgreeNumView() != null) {
                this.D0.getAgreeNumView().setVisibility(8);
            }
            if (this.D0.getMsgData() != null) {
                this.D0.getMsgData().uniqueId = BdUniqueId.gen();
            }
            boolean booleanExtra = this.e.getBaseFragmentActivity().getIntent().getBooleanExtra("key_is_from_dynamic", false);
            ImageView imageView2 = (ImageView) this.f.findViewById(R.id.obfuscated_res_0x7f091ba2);
            this.E0 = imageView2;
            imageView2.setOnClickListener(this.U);
            if (booleanExtra) {
                this.E0.setVisibility(8);
            } else {
                this.E0.setVisibility(0);
            }
            View findViewById = this.f.findViewById(R.id.obfuscated_res_0x7f091ba9);
            this.H0 = findViewById;
            findViewById.setVisibility(8);
            this.F0 = (ImageView) this.f.findViewById(R.id.obfuscated_res_0x7f091ba7);
            HeadImageView headImageView = (HeadImageView) this.f.findViewById(R.id.obfuscated_res_0x7f091ba8);
            this.G0 = headImageView;
            headImageView.setIsRound(true);
            this.G0.setOnClickListener(this.Q1);
            this.F0.setOnClickListener(new h(this));
            r2();
            v6a v6aVar = new v6a(this.F0);
            this.I0 = v6aVar;
            v6aVar.m(this.G0);
            TextView textView = (TextView) this.f.findViewById(R.id.obfuscated_res_0x7f091ba5);
            this.K0 = textView;
            textView.setVisibility(0);
            this.J0 = (TextView) this.f.findViewById(R.id.obfuscated_res_0x7f091ba0);
            this.U0 = (ViewStub) this.f.findViewById(R.id.obfuscated_res_0x7f0911fe);
            this.D0.setVisibility(0);
            this.J0.setVisibility(0);
            this.v = new o2a(this.e, this.o0);
            this.x = new s2a(this.e, this.o0, this.U);
            pz9 pz9Var = new pz9(this.e, this.f);
            this.u = pz9Var;
            pz9Var.z(this.E0);
            this.u.a();
        }
    }

    public void I2(AbsListView absListView, int i3) {
        RightFloatLayerView rightFloatLayerView;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048618, this, absListView, i3) == null) {
            if (i3 == 0) {
                this.e1.a = null;
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004013, this.e1));
                U2(this.e1.a, true);
                r0();
                this.J.C(true);
            }
            this.J.B();
            if (i3 == 0) {
                RightFloatLayerView rightFloatLayerView2 = this.J1;
                if (rightFloatLayerView2 != null) {
                    rightFloatLayerView2.p();
                }
                l0();
            } else if (i3 == 1) {
                RightFloatLayerView rightFloatLayerView3 = this.J1;
                if (rightFloatLayerView3 != null) {
                    rightFloatLayerView3.o();
                }
            } else if (i3 == 2 && (rightFloatLayerView = this.J1) != null) {
                rightFloatLayerView.q();
            }
        }
    }

    public final void X2(AgreeData agreeData, long j3) {
        TextView textView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLJ(1048680, this, agreeData, j3) == null) && agreeData != null && (textView = this.J0) != null) {
            if (j3 > 0) {
                if (agreeData.agreeType == 2 && agreeData.hasAgree) {
                    textView.setTextColor(SkinManager.getColor(R.color.CAM_X0301));
                } else {
                    this.J0.setTextColor(SkinManager.getColor(R.color.CAM_X0107));
                }
                this.J0.setText(E0(j3));
                this.J0.setVisibility(0);
                return;
            }
            textView.setVisibility(8);
        }
    }

    public void I3() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048619, this) == null) {
            this.e.hideProgressBar();
            aw9 aw9Var = this.P0;
            if (aw9Var != null && this.P != null && aw9Var.B() != null && this.P0.B().b() == 0) {
                this.P.y(this.P0.v());
                if (this.P0.v()) {
                    StatisticItem statisticItem = new StatisticItem(CommonStatisticKey.KEY_PB_FOLD_ICON_SHOW);
                    statisticItem.param("uid", TbadkCoreApplication.getCurrentAccount());
                    statisticItem.param("fid", this.P0.o());
                    statisticItem.param("fname", this.P0.p());
                    statisticItem.param("tid", this.P0.T());
                    TiebaStatic.log(statisticItem);
                }
            }
            z0();
            PbLandscapeListView pbLandscapeListView = this.n;
            if (pbLandscapeListView != null) {
                pbLandscapeListView.z(0L);
            }
            v0();
        }
    }

    public int M0() {
        InterceptResult invokeV;
        View childAt;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048634, this)) == null) {
            PbLandscapeListView pbLandscapeListView = this.n;
            if (pbLandscapeListView == null) {
                return 0;
            }
            int firstVisiblePosition = pbLandscapeListView.getFirstVisiblePosition();
            int lastVisiblePosition = this.n.getLastVisiblePosition();
            if (lastVisiblePosition > firstVisiblePosition) {
                int i3 = (lastVisiblePosition - firstVisiblePosition) + 1;
                int[] iArr = new int[i3];
                Rect rect = new Rect();
                int childCount = this.n.getChildCount();
                int i4 = 0;
                for (int i5 = firstVisiblePosition; i5 <= lastVisiblePosition; i5++) {
                    int i6 = i5 - firstVisiblePosition;
                    if (i6 < childCount && (childAt = this.n.getChildAt(i6)) != null) {
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

    public final void P1() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048647, this) != null) || !this.e.Y6()) {
            return;
        }
        ViewStub viewStub = (ViewStub) this.f.findViewById(R.id.obfuscated_res_0x7f09179b);
        this.m = viewStub;
        viewStub.setVisibility(0);
        if (this.F == null) {
            this.F = (LinearLayout) this.f.findViewById(R.id.obfuscated_res_0x7f09179a);
            jq5.a(this.e.getPageContext(), this.F);
        }
        if (this.G == null) {
            this.G = (TextView) this.F.findViewById(R.id.obfuscated_res_0x7f09179f);
        }
        if (this.H == null) {
            this.H = (TextView) this.F.findViewById(R.id.obfuscated_res_0x7f09179e);
        }
        this.G.setOnClickListener(this.U);
        this.H.setOnClickListener(this.U);
    }

    public final boolean R3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048657, this)) == null) {
            aw9 aw9Var = this.P0;
            if (aw9Var != null && aw9Var.R() != null && !ListUtils.isEmpty(this.P0.R().getThreadRecommendInfoDataList()) && this.e != null && this.w.b() != null && this.w.b().getVisibility() == 0 && this.P0.R().getThreadRecommendInfoDataList().get(0) != null && this.P0.R().getThreadRecommendInfoDataList().get(0).businessType == 1) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public final void S1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048659, this) == null) {
            this.t0 = this.f.findViewById(R.id.obfuscated_res_0x7f091b93);
            this.r = new k1a(this.e.u0(), (ViewGroup) u1().findViewById(R.id.obfuscated_res_0x7f091c41));
            o0a o0aVar = new o0a(this.n, -2);
            this.t = o0aVar;
            o0aVar.d(this.u.s());
            o0a o0aVar2 = new o0a(this.n, 5);
            this.s = o0aVar2;
            o0aVar2.d(new a(this));
            this.L1 = (LinearLayout) this.f.findViewById(R.id.obfuscated_res_0x7f092904);
            this.M1 = new o4a(this.e.getActivity());
        }
    }

    public final void T2() {
        e5a e5aVar;
        aw9 aw9Var;
        boolean z2;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048664, this) == null) && this.w != null && (e5aVar = this.j) != null && e5aVar.j() != null && (aw9Var = this.P0) != null && aw9Var.R() != null && this.P0.R().isQuestionThread() && this.w.b() != null && this.w.b().getVisibility() == 0) {
            int[] iArr = new int[2];
            this.w.b().getLocationInWindow(iArr);
            boolean z3 = true;
            int height = iArr[1] + this.w.b().getHeight();
            if (this.w.b().getParent() != null) {
                z2 = true;
            } else {
                z2 = false;
            }
            e5a e5aVar2 = this.j;
            if (height > e5aVar2.j().getBottom() && z2) {
                z3 = false;
            }
            e5aVar2.z(z3, this.P0.R().getSpan_str());
        }
    }

    public final void k0() {
        PbContentCollectionController pbContentCollectionController;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048736, this) == null) {
            if (R3() && this.P0 != null) {
                StatisticItem addParam = new StatisticItem(CommonStatisticKey.KEY_PB_PAGE_CONTENT_COLLECTION_SHOW).addParam("tid", this.P0.R().getTid()).addParam("obj_param1", this.P0.R().getThreadRecommendInfoDataList().get(0).businessId);
                int i3 = this.P0.R().getThreadRecommendInfoDataList().get(0).albumType;
                if (i3 != -1) {
                    addParam.addParam("obj_type", i3);
                }
                addParam.eventStat();
            }
            if (g2() && (pbContentCollectionController = this.B) != null) {
                pbContentCollectionController.h();
                this.B.g(true);
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:24:0x0051, code lost:
        if (r5.D1 == 1) goto L19;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void r0() {
        u6a u6aVar;
        int i3;
        boolean z2;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048771, this) != null) || (u6aVar = this.G1) == null) {
            return;
        }
        if (this.n != null && u6aVar.a() != null && this.G1.a().getParent() != null) {
            i3 = this.n.getPositionForView(this.G1.a());
        } else {
            i3 = -1;
        }
        boolean z3 = false;
        if (i3 != -1) {
            if (this.G1.a().getTop() + n2 <= this.X0.getBottom()) {
                this.D1 = 1;
                z2 = true;
            } else {
                this.D1 = 0;
                z2 = false;
            }
        }
        PbReplyTitleViewHolder pbReplyTitleViewHolder = this.a1;
        if (this.D1 == 1) {
            z3 = true;
        }
        pbReplyTitleViewHolder.y(z3);
        this.G1.e(z2);
    }

    public final void r2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048773, this) == null) {
            f0(this.E0);
            if (this.F0.getParent() != null) {
                ((ViewGroup) this.F0.getParent()).removeView(this.F0);
                ((ViewGroup) this.G0.getParent()).removeView(this.G0);
            }
            if (this.H0.getParent() != null) {
                ((ViewGroup) this.H0.getParent()).removeView(this.H0);
            }
            RelativeLayout relativeLayout = new RelativeLayout(TbadkCoreApplication.getInst().getContext());
            relativeLayout.setLayoutParams(new LinearLayout.LayoutParams(UtilHelper.getDimenPixelSize(R.dimen.tbds138), -2));
            relativeLayout.addView(this.F0);
            relativeLayout.addView(this.G0);
            relativeLayout.addView(this.H0);
            this.j.a.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, relativeLayout, (View.OnClickListener) null);
            this.j.a.getViewGroup(NavigationBar.ControlAlign.HORIZONTAL_RIGHT).setClipChildren(false);
        }
    }

    public void z2() {
        aw9 aw9Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048813, this) == null) && this.e != null && this.C1 != 3 && (aw9Var = this.P0) != null && aw9Var.n() != null && !rd.isEmpty(this.P0.n().getName())) {
            MessageManager.getInstance().sendMessage(new CustomMessage(2003000, new FrsActivityConfig(this.e.getContext()).createNormalCfg(this.P0.n().getName(), null)));
            TiebaStatic.log(new StatisticItem("c13853").param("post_id", this.P0.T()).param("uid", TbadkCoreApplication.getCurrentAccountId()).param("fid", this.P0.n().getId()));
        }
    }

    public void J2(ArrayList<wx4> arrayList) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048623, this, arrayList) == null) {
            if (this.b0 == null) {
                this.b0 = LayoutInflater.from(this.e.getPageContext().getPageActivity()).inflate(R.layout.commit_good, (ViewGroup) null);
            }
            this.e.getBaseFragmentActivity().getLayoutMode().onModeChanged(this.b0);
            if (this.a0 == null) {
                Dialog dialog = new Dialog(this.e.getPageContext().getPageActivity(), R.style.obfuscated_res_0x7f1003c6);
                this.a0 = dialog;
                dialog.setCanceledOnTouchOutside(true);
                this.a0.setCancelable(true);
                this.p0 = (ScrollView) this.b0.findViewById(R.id.good_scroll);
                this.a0.setContentView(this.b0);
                WindowManager.LayoutParams attributes = this.a0.getWindow().getAttributes();
                attributes.width = BdUtilHelper.getDimens(TbadkCoreApplication.getInst(), R.dimen.obfuscated_res_0x7f0703f6);
                this.a0.getWindow().setAttributes(attributes);
                this.d0 = new y(this);
                this.c0 = (LinearLayout) this.b0.findViewById(R.id.good_class_group);
                TextView textView = (TextView) this.b0.findViewById(R.id.dialog_button_cancel);
                this.f0 = textView;
                textView.setOnClickListener(new z(this));
                TextView textView2 = (TextView) this.b0.findViewById(R.id.dialog_button_ok);
                this.e0 = textView2;
                textView2.setOnClickListener(this.U);
            }
            this.c0.removeAllViews();
            this.p = new ArrayList();
            CustomBlueCheckRadioButton o02 = o0("0", this.e.getPageContext().getString(R.string.thread_good_class));
            this.p.add(o02);
            o02.setChecked(true);
            this.c0.addView(o02);
            if (arrayList != null) {
                for (int i3 = 0; i3 < arrayList.size(); i3++) {
                    wx4 wx4Var = arrayList.get(i3);
                    if (wx4Var != null && !TextUtils.isEmpty(wx4Var.b()) && wx4Var.a() > 0) {
                        CustomBlueCheckRadioButton o03 = o0(String.valueOf(wx4Var.a()), wx4Var.b());
                        this.p.add(o03);
                        View view2 = new View(this.e.getPageContext().getPageActivity());
                        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, BdUtilHelper.getDimens(TbadkCoreApplication.getInst(), R.dimen.obfuscated_res_0x7f070198));
                        SkinManager.setBackgroundColor(view2, R.color.CAM_X0204);
                        view2.setLayoutParams(layoutParams);
                        this.c0.addView(view2);
                        this.c0.addView(o03);
                    }
                }
                ViewGroup.LayoutParams layoutParams2 = this.p0.getLayoutParams();
                int size = arrayList.size();
                if (size != 0 && size != 1) {
                    if (size != 2) {
                        layoutParams2.height = BdUtilHelper.dip2px(this.e.getPageContext().getPageActivity(), 220.0f);
                    } else {
                        layoutParams2.height = BdUtilHelper.dip2px(this.e.getPageContext().getPageActivity(), 186.0f);
                    }
                } else {
                    layoutParams2.height = BdUtilHelper.dip2px(this.e.getPageContext().getPageActivity(), 120.0f);
                }
                this.p0.setLayoutParams(layoutParams2);
                this.p0.removeAllViews();
                LinearLayout linearLayout = this.c0;
                if (linearLayout != null && linearLayout.getParent() == null) {
                    this.p0.addView(this.c0);
                }
            }
            yb.j(this.a0, this.e.getPageContext());
        }
    }

    public final void J4() {
        PbFragment pbFragment;
        int i3;
        String str;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048625, this) == null) && (pbFragment = this.e) != null && pbFragment.l0() != null && this.e.l0().G != null && this.e.l0().G.R() != null && this.e.l0().G.R().isXiuXiuThread()) {
            ThreadData R = this.e.l0().G.R();
            int i4 = 0;
            if (this.e.l0().X0()) {
                i3 = 1;
            } else if (this.e.l0().a1()) {
                i3 = 2;
            } else {
                i3 = 0;
            }
            ItemInfo itemInfo = TbSingleton.getInstance().getFrsItemInfoCache().get(R.getForum_name());
            if (itemInfo != null) {
                i4 = itemInfo.id.intValue();
                str = itemInfo.name;
            } else {
                str = "";
            }
            new StatisticItem("c15062").addParam("obj_locate", i3).addParam("fid", R.getFid()).addParam("fname", R.getForum_name()).addParam("post_id", R.getTid()).addParam("obj_id", i4).addParam("obj_name", str).eventStat();
        }
    }

    public final void L1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048631, this) == null) {
            CardForumHeadLayout cardForumHeadLayout = new CardForumHeadLayout(this.e.getContext());
            this.a = cardForumHeadLayout;
            cardForumHeadLayout.setId(R.id.obfuscated_res_0x7f091b92);
            this.a.setNeedShowForumlable(false);
            this.a.setJumpCallFrom(2);
            this.a.setBarNameIncludePadding(false);
            this.a.setBarThreadLineSpace(BdUtilHelper.getDimens(this.e.getContext(), R.dimen.tbds26));
            this.a.setAttentionLineSpace(BdUtilHelper.getDimens(this.e.getContext(), R.dimen.tbds26));
            int dimens = BdUtilHelper.getDimens(this.e.getContext(), R.dimen.M_W_X006);
            int dimens2 = BdUtilHelper.getDimens(this.e.getContext(), R.dimen.tbds16);
            int dimens3 = BdUtilHelper.getDimens(this.e.getContext(), R.dimen.tbds15);
            int dimens4 = BdUtilHelper.getDimens(this.e.getContext(), R.dimen.M_W_X007);
            int dimens5 = BdUtilHelper.getDimens(this.e.getContext(), R.dimen.M_H_X005);
            this.a.setPadding(dimens, dimens2, dimens, dimens3);
            ViewGroup.MarginLayoutParams marginLayoutParams = new ViewGroup.MarginLayoutParams(-1, -2);
            marginLayoutParams.leftMargin = dimens4;
            marginLayoutParams.rightMargin = dimens4;
            marginLayoutParams.bottomMargin = dimens5;
            this.a.setLayoutParams(marginLayoutParams);
            EMManager.from(this.a).setCorner(R.string.J_X05).setBackGroundRealColor(uua.a(SkinManager.getColor(R.color.CAM_X0341), 0.08f));
            this.a.setAfterClickListener(new p(this));
        }
    }

    public void W2() {
        PbLandscapeListView pbLandscapeListView;
        int i3;
        int i4;
        boolean z2;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048676, this) != null) || (pbLandscapeListView = this.n) == null) {
            return;
        }
        int headerViewsCount = pbLandscapeListView.getHeaderViewsCount() - this.l1;
        int i5 = 0;
        if (this.n.getFirstVisiblePosition() != 0 && this.n.getFirstVisiblePosition() + headerViewsCount >= 0) {
            i3 = this.n.getFirstVisiblePosition() + headerViewsCount;
        } else {
            i3 = 0;
        }
        View childAt = this.n.getChildAt(0);
        if (childAt != null) {
            i4 = childAt.getTop();
        } else {
            i4 = -1;
        }
        this.e1.a = null;
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004013, this.e1));
        PbReplyTitleViewHolder pbReplyTitleViewHolder = this.e1.a;
        int n1 = n1(pbReplyTitleViewHolder);
        int measuredHeight = this.I.getMeasuredHeight() + ((int) this.I.getY());
        boolean z3 = true;
        if (this.X0.getVisibility() == 0) {
            z2 = true;
        } else {
            z2 = false;
        }
        if (this.I.getY() >= 0.0f) {
            z3 = false;
        }
        if ((z2 && pbReplyTitleViewHolder != null) || i3 >= this.J.q() + this.n.getHeaderViewsCount()) {
            if (pbReplyTitleViewHolder != null) {
                i5 = pbReplyTitleViewHolder.g.getMeasuredHeight();
            }
            if (z3) {
                this.n.setSelectionFromTop(this.J.q() + this.n.getHeaderViewsCount(), g2 - i5);
            } else {
                this.n.setSelectionFromTop(this.J.q() + this.n.getHeaderViewsCount(), this.j.j().getMeasuredHeight() - i5);
            }
        } else {
            this.n.setSelectionFromTop(i3, i4);
        }
        if (this.R0 != 9) {
            return;
        }
        this.n.setOnLayoutListener(new l(this, n1, pbReplyTitleViewHolder, z2, measuredHeight, i3, i4));
    }

    public void w2() {
        NoNetworkView.b bVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048798, this) == null) {
            RelativeLayout relativeLayout = this.f;
            if (relativeLayout != null && relativeLayout.getHandler() != null) {
                this.f.getHandler().removeCallbacksAndMessages(null);
            }
            v6a v6aVar = this.I0;
            if (v6aVar != null) {
                v6aVar.j();
            }
            y0a y0aVar = this.y1;
            if (y0aVar != null) {
                y0aVar.c();
            }
            PbTopTipView pbTopTipView = this.q1;
            if (pbTopTipView != null) {
                pbTopTipView.g();
            }
            this.e.hideProgressBar();
            NoNetworkView noNetworkView = this.o;
            if (noNetworkView != null && (bVar = this.X) != null) {
                noNetworkView.removeNetworkChangeListener(bVar);
            }
            zva.d();
            s0();
            z0();
            if (this.h1 != null) {
                SafeHandler.getInst().removeCallbacks(this.h1);
            }
            PbInterviewStatusView pbInterviewStatusView = this.V0;
            if (pbInterviewStatusView != null) {
                pbInterviewStatusView.m();
            }
            MessageManager.getInstance().unRegisterListener(this.P1);
            br6.b().a(this.N1);
            this.V1 = null;
            this.i.removeCallbacksAndMessages(null);
            this.J.w(3);
            View view2 = this.g;
            if (view2 != null) {
                view2.setBackgroundDrawable(null);
            }
            vz9 vz9Var = this.J;
            if (vz9Var != null) {
                vz9Var.y();
            }
            x2a x2aVar = this.t1;
            if (x2aVar != null) {
                x2aVar.l();
            }
            s2a s2aVar = this.x;
            if (s2aVar != null) {
                s2aVar.r();
            }
            PbReplyTitleViewHolder pbReplyTitleViewHolder = this.a1;
            if (pbReplyTitleViewHolder != null) {
                pbReplyTitleViewHolder.s(null);
            }
            this.v1 = null;
            PbLandscapeListView pbLandscapeListView = this.n;
            if (pbLandscapeListView != null) {
                pbLandscapeListView.setOnLayoutListener(null);
                this.n.getViewTreeObserver().removeGlobalOnLayoutListener(this.T1);
                this.n.setListViewDragListener(null);
                this.n.K();
                this.n = null;
            }
            AgreeView agreeView = this.D0;
            if (agreeView != null) {
                agreeView.setAgreeLongClickListener(null);
                this.D0.setAfterClickListener(null);
            }
            v0 v0Var = this.e1;
            if (v0Var != null) {
                v0Var.a = null;
            }
            l0a l0aVar = this.j1;
            if (l0aVar != null) {
                l0aVar.m();
            }
            pz9 pz9Var = this.u;
            if (pz9Var != null) {
                pz9Var.y();
            }
            iv9.d();
            TbMixPlayerView tbMixPlayerView = this.O1;
            if (tbMixPlayerView != null) {
                tbMixPlayerView.s();
                this.O1.p();
            }
        }
    }

    public void K2(int i3, String str, int i4, boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048628, this, new Object[]{Integer.valueOf(i3), str, Integer.valueOf(i4), Boolean.valueOf(z2)}) == null) {
            L2(i3, str, i4, z2, null);
        }
    }

    public void N2(int i3, String str, int i4, boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048640, this, new Object[]{Integer.valueOf(i3), str, Integer.valueOf(i4), Boolean.valueOf(z2)}) == null) {
            this.C.e(l1(), i3, str, i4, z2);
        }
    }

    public void a3(aw9 aw9Var, boolean z2, int i3, int i4) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048693, this, new Object[]{aw9Var, Boolean.valueOf(z2), Integer.valueOf(i3), Integer.valueOf(i4)}) == null) {
            h4(aw9Var, z2, i3, i4);
            this.x.q(i4);
        }
    }

    public void L2(int i3, String str, int i4, boolean z2, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048632, this, new Object[]{Integer.valueOf(i3), str, Integer.valueOf(i4), Boolean.valueOf(z2), str2}) == null) {
            M2(i3, str, i4, z2, str2, false);
        }
    }

    public void M2(int i3, String str, int i4, boolean z2, String str2, boolean z3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048636, this, new Object[]{Integer.valueOf(i3), str, Integer.valueOf(i4), Boolean.valueOf(z2), str2, Boolean.valueOf(z3)}) == null) {
            this.C.b(l1(), i3, str, i4, z2, str2, z3);
        }
    }

    public void M3(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048637, this, str) == null) {
            this.A0.performClick();
            if (!StringUtils.isNull(str) && this.e.f7() != null && this.e.f7().v() != null && this.e.f7().v().k() != null) {
                EditText k3 = this.e.f7().v().k();
                k3.setText(str);
                k3.setSelection(str.length());
            }
        }
    }

    public final void O1(aw9 aw9Var) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048643, this, aw9Var) != null) || aw9Var == null || aw9Var.R() == null || !aw9Var.R().isInterviewLive() || this.V0 != null) {
            return;
        }
        PbInterviewStatusView pbInterviewStatusView = (PbInterviewStatusView) this.U0.inflate();
        this.V0 = pbInterviewStatusView;
        pbInterviewStatusView.setOnClickListener(this.U);
        this.V0.setCallback(this.e.X6());
        this.V0.setData(this.e, aw9Var);
    }

    public final int R0(int i3) {
        InterceptResult invokeI;
        int i4;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048654, this, i3)) == null) {
            PbLandscapeListView pbLandscapeListView = this.n;
            if (pbLandscapeListView == null) {
                return 0;
            }
            gi adapter2 = pbLandscapeListView.getAdapter2();
            if (adapter2 == null) {
                return i3;
            }
            if (i3 < adapter2.getCount() && i3 >= 0 && (adapter2.getItem(i3) instanceof mwa)) {
                i3++;
            }
            int o3 = (adapter2.o() + adapter2.m()) - 1;
            if (i3 > o3) {
                i3 = o3;
            }
            if (this.n.getAdapter2() != null && (this.n.getAdapter2() instanceof gi)) {
                i4 = this.n.getAdapter2().n();
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

    public void m0(boolean z2) {
        int i3;
        int i4;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048746, this, z2) == null) {
            PbLandscapeListView pbLandscapeListView = this.n;
            int i5 = 0;
            if (pbLandscapeListView != null) {
                if (z2) {
                    SkinManager.setBackgroundColor(pbLandscapeListView, R.color.CAM_X0202);
                } else {
                    pbLandscapeListView.setBackgroundResource(0);
                }
            }
            View view2 = this.t0;
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

    public void m3(String str) {
        PbReplyTitleViewHolder pbReplyTitleViewHolder;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048749, this, str) == null) && this.P != null) {
            int i3 = 0;
            v0 v0Var = this.e1;
            if (v0Var != null && (pbReplyTitleViewHolder = v0Var.a) != null && pbReplyTitleViewHolder.getView() != null) {
                i3 = this.e1.a.getView().getTop() < 0 ? this.e1.a.getView().getHeight() : this.e1.a.getView().getBottom();
            }
            this.P.K(str, i3);
        }
    }

    public void O2(SparseArray<Object> sparseArray, boolean z2) {
        int i3;
        l05 l05Var;
        l05 l05Var2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048644, this, sparseArray, z2) == null) {
            p05 p05Var = new p05(this.e.getContext());
            p05Var.u(this.e.getString(R.string.obfuscated_res_0x7f0f032e));
            p05Var.r(new x(this, z2));
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
                    l05Var2 = new l05(10, this.e.getString(R.string.obfuscated_res_0x7f0f056a), p05Var);
                } else {
                    l05Var2 = new l05(10, this.e.getString(R.string.obfuscated_res_0x7f0f055b), p05Var);
                }
                SparseArray sparseArray2 = new SparseArray();
                sparseArray2.put(R.id.tag_del_post_id, sparseArray.get(R.id.tag_del_post_id));
                sparseArray2.put(R.id.tag_del_post_type, sparseArray.get(R.id.tag_del_post_type));
                sparseArray2.put(R.id.tag_del_post_is_self, sparseArray.get(R.id.tag_del_post_is_self));
                sparseArray2.put(R.id.tag_manage_user_identity, sparseArray.get(R.id.tag_manage_user_identity));
                l05Var2.d.setTag(sparseArray2);
                arrayList.add(l05Var2);
            }
            if ((sparseArray.get(R.id.tag_mul_del_post_type) instanceof Boolean) && ((Boolean) sparseArray.get(R.id.tag_mul_del_post_type)).booleanValue()) {
                l05 l05Var3 = new l05(13, this.e.getString(R.string.multi_delete), p05Var);
                SparseArray sparseArray3 = new SparseArray();
                sparseArray3.put(R.id.tag_del_post_id, sparseArray.get(R.id.tag_del_post_id));
                sparseArray3.put(R.id.tag_del_post_type, sparseArray.get(R.id.tag_del_post_type));
                sparseArray3.put(R.id.tag_del_post_is_self, sparseArray.get(R.id.tag_del_post_is_self));
                sparseArray3.put(R.id.tag_manage_user_identity, sparseArray.get(R.id.tag_manage_user_identity));
                l05Var3.d.setTag(sparseArray3);
                arrayList.add(l05Var3);
            }
            if (!"".equals(sparseArray.get(R.id.tag_forbid_user_name)) || !"".equals(sparseArray.get(R.id.tag_forbid_user_name_show))) {
                SparseArray sparseArray4 = new SparseArray();
                sparseArray4.put(R.id.tag_forbid_user_name, sparseArray.get(R.id.tag_forbid_user_name));
                sparseArray4.put(R.id.tag_forbid_user_name_show, sparseArray.get(R.id.tag_forbid_user_name_show));
                sparseArray4.put(R.id.tag_forbid_user_portrait, sparseArray.get(R.id.tag_forbid_user_portrait));
                sparseArray4.put(R.id.tag_manage_user_identity, sparseArray.get(R.id.tag_manage_user_identity));
                sparseArray4.put(R.id.tag_forbid_user_post_id, sparseArray.get(R.id.tag_forbid_user_post_id));
                l05 l05Var4 = new l05(11, this.e.getString(R.string.forbidden_person), p05Var);
                l05Var4.d.setTag(sparseArray4);
                arrayList.add(l05Var4);
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
                    l05Var = new l05(12, this.e.getString(R.string.un_mute), p05Var);
                } else {
                    l05Var = new l05(12, this.e.getString(R.string.obfuscated_res_0x7f0f0d47), p05Var);
                }
                l05Var.d.setTag(sparseArray5);
                arrayList.add(l05Var);
            }
            j4a.d(arrayList);
            p05Var.n(arrayList, true);
            n05 n05Var = new n05(this.e.getPageContext(), p05Var);
            this.Y = n05Var;
            n05Var.l();
        }
    }

    public final void U2(PbReplyTitleViewHolder pbReplyTitleViewHolder, boolean z2) {
        boolean z3;
        int measuredHeight;
        TbMixPlayerView tbMixPlayerView;
        int i3;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLZ(1048668, this, pbReplyTitleViewHolder, z2) == null) && !this.m1 && this.X0 != null && this.j.j() != null) {
            View k3 = G0().k();
            if (k3 != null) {
                int[] iArr = new int[2];
                k3.getLocationInWindow(iArr);
                int i4 = iArr[1];
                if (i4 != 0) {
                    if (this.X0.getVisibility() == 0 && i4 - this.j.j().getBottom() <= this.X0.getHeight()) {
                        this.Y0.setVisibility(0);
                        if (i4 > this.j.j().getBottom()) {
                            i3 = -(((this.X0.getHeight() + this.Y0.getHeight()) + this.j.j().getBottom()) - k3.getBottom());
                        } else {
                            i3 = -this.X0.getHeight();
                        }
                        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.X0.getLayoutParams();
                        if (layoutParams.topMargin != i3) {
                            layoutParams.topMargin = i3;
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
            int q2 = this.J.q();
            if (q2 > 0 && (pbReplyTitleViewHolder == null || pbReplyTitleViewHolder.getView().getParent() == null)) {
                PbLandscapeListView pbLandscapeListView = this.n;
                if (pbLandscapeListView != null && q2 > pbLandscapeListView.getFirstVisiblePosition() - this.n.getHeaderViewsCount()) {
                    this.X0.setVisibility(4);
                    return;
                }
                this.X0.setVisibility(0);
                W3(false);
                this.j.a.hideBottomLine();
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
                    int i5 = this.c1;
                    if (top < i5) {
                        i5 = top;
                    }
                    this.c1 = i5;
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
                    measuredHeight = g2 - pbReplyTitleViewHolder.g.getMeasuredHeight();
                } else {
                    measuredHeight = this.j.j().getMeasuredHeight() - pbReplyTitleViewHolder.g.getMeasuredHeight();
                    if (Z1() && (tbMixPlayerView = this.O1) != null) {
                        measuredHeight += tbMixPlayerView.getPlayerHeight();
                    }
                    this.j.a.hideBottomLine();
                }
                if (pbReplyTitleViewHolder.getView().getParent() == null && top <= this.c1) {
                    this.X0.setVisibility(0);
                    W3(false);
                } else if (top < measuredHeight) {
                    this.X0.setVisibility(0);
                    W3(false);
                } else {
                    this.X0.setVisibility(4);
                    this.j.a.hideBottomLine();
                }
                if (z2) {
                    this.d1 = true;
                }
            } else {
                PbLandscapeListView pbLandscapeListView2 = this.n;
                if (pbLandscapeListView2 != null && pbLandscapeListView2.getFirstVisiblePosition() == 0) {
                    this.X0.setVisibility(4);
                    this.j.a.hideBottomLine();
                }
            }
        }
    }

    public final void S3() {
        PbFragment pbFragment;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048661, this) == null) && (pbFragment = this.e) != null && pbFragment.getActivity() != null) {
            if (this.D0.getWidth() != 0 && this.D0.getHeight() != 0) {
                WaterRippleView waterRippleView = this.B0;
                if (waterRippleView == null) {
                    this.B0 = new WaterRippleView(this.e.getActivity());
                } else {
                    ViewParent parent = waterRippleView.getParent();
                    if (parent instanceof ViewGroup) {
                        ((ViewGroup) parent).removeView(this.B0);
                    }
                }
                Rect rect = new Rect();
                this.f.getGlobalVisibleRect(rect);
                Rect rect2 = new Rect();
                this.D0.getImgAgree().getGlobalVisibleRect(rect2);
                int dimens = BdUtilHelper.getDimens(this.e.getActivity(), R.dimen.tbds166);
                int i3 = ((rect2.right + rect2.left) / 2) - dimens;
                int i4 = (rect.bottom - ((rect2.bottom + rect2.top) / 2)) - dimens;
                int i5 = dimens * 2;
                RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(i5, i5);
                layoutParams.addRule(12, -1);
                layoutParams.setMargins(i3, 0, 0, i4);
                this.f.addView(this.B0, layoutParams);
                TextView textView = this.J0;
                if (textView != null) {
                    textView.setVisibility(4);
                    return;
                }
                return;
            }
            BdLog.e("AgreeView not measured");
        }
    }

    public final void T3() {
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048665, this) == null) {
            if (!Z1()) {
                v1();
                return;
            }
            AlaInfoData c2 = i4a.c(this.P0);
            if (c2 != null && !StringUtils.isNull(c2.mFlv) && c2.live_status == 1) {
                if (this.O1 == null) {
                    this.O1 = (TbMixPlayerView) this.f.findViewById(R.id.obfuscated_res_0x7f09184c);
                    i4a.d(this, this.P0);
                }
                String str2 = null;
                if (this.O1.getTbMixPlayerConfig() instanceof TbLiveMixPlayerConfig) {
                    str2 = ((TbLiveMixPlayerConfig) this.O1.getTbMixPlayerConfig()).a().mFlv;
                }
                if (this.O1.getVisibility() != 0 || ((str = c2.mFlv) != null && !str.equals(str2))) {
                    this.O1.setVisibility(0);
                    this.O1.setMixPlayerConfig(new TbLiveMixPlayerConfig(c2));
                    this.O1.o();
                    Q3(n1a.i(this.e) + this.O1.getPlayerHeight());
                    nua.u("c15498", this.P0.R(), c2, 0L);
                    return;
                }
                return;
            }
            v1();
        }
    }

    public final void l0() {
        aw9 aw9Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048741, this) == null) && this.B != null && (aw9Var = this.P0) != null && aw9Var.R() != null && !ListUtils.isEmpty(this.P0.R().getThreadRecommendInfoDataList()) && this.P0.R().getThreadRecommendInfoDataList().get(0) != null && this.w.b().getVisibility() == 0) {
            if (this.w.b().getParent() == null) {
                this.B.g(false);
                return;
            }
            int[] iArr = new int[2];
            this.B.b().getLocationInWindow(iArr);
            if (iArr[1] + this.B.b().getHeight() > this.j.j().getBottom()) {
                this.B.i();
                this.B.g(true);
                return;
            }
            this.B.g(false);
        }
    }

    public void p0() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048761, this) == null) && !this.f2) {
            TiebaStatic.log("c10490");
            this.f2 = true;
            f05 f05Var = new f05(this.e.getPageContext().getPageActivity());
            SparseArray sparseArray = new SparseArray();
            sparseArray.put(i2, Integer.valueOf(k2));
            f05Var.setTitle(R.string.grade_thread_tips);
            View inflate = LayoutInflater.from(this.e.getPageContext().getPageActivity()).inflate(R.layout.upgrade_success_dialog_content, (ViewGroup) null);
            ((TextView) inflate.findViewById(R.id.function_description_view)).setText(R.string.function_upgrade_to_photo_live_tips);
            ((TextView) inflate.findViewById(R.id.title_view)).setText(R.string.grade_thread_tips);
            f05Var.setContentView(inflate);
            f05Var.setYesButtonTag(sparseArray);
            f05Var.setPositiveButton(R.string.grade_button_tips, this.e);
            f05Var.setNegativeButton(R.string.look_again, new l0(this));
            f05Var.create(this.e.getPageContext()).show();
        }
    }

    public final void p2() {
        PbFragment pbFragment;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048763, this) == null) && (pbFragment = this.e) != null && pbFragment.l0() != null && this.e.l0().G != null && this.e.l0().G.R() != null && this.e.l0().G.R().isQuestionThread()) {
            ThreadData R = this.e.l0().G.R();
            String F1 = this.e.l0().F1();
            String G1 = this.e.l0().G1();
            int i3 = 5;
            if ("question_answer_invite".equals(F1)) {
                i3 = 1;
            } else if ("3".equals(G1)) {
                i3 = 2;
            } else if ("answer_top".equals(F1)) {
                i3 = 3;
            } else if (this.e.l0().X0()) {
                i3 = 4;
            }
            TiebaStatic.log(new StatisticItem("c14924").param("uid", TbadkCoreApplication.getCurrentAccountId()).param("tid", R.getId()).param("fid", R.getFid()).param("obj_source", i3));
        }
    }

    public final void U1(aw9 aw9Var, d85 d85Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048667, this, aw9Var, d85Var) == null) && this.K1 != null && aw9Var != null && d85Var != null && this.e.getContext() != null) {
            if (!RightFloatLayerView.k()) {
                F1();
                return;
            }
            if (this.J1 == null) {
                RightFloatLayerView E = RightFloatLayerLottieView.E(d85Var, this.e.getContext());
                this.J1 = E;
                E.setPageContext(this.e.getPageContext());
                this.K1.removeAllViews();
                this.K1.addView(this.J1);
            }
            if ((this.I1.getTag() instanceof Boolean) && !((Boolean) this.I1.getTag()).booleanValue()) {
                this.J1.setAutoCompleteShown(false);
                this.J1.setTag(this.I1);
                this.J1.c();
            }
            if (d85Var.a()) {
                return;
            }
            this.J1.setData(d85Var);
            this.J1.setLogoListener(new p0(this, d85Var));
            this.J1.setFeedBackListener(new q0(this, d85Var));
        }
    }

    public void Z2(int i3, aw9 aw9Var, boolean z2, int i4) {
        nwa a02;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(1048688, this, new Object[]{Integer.valueOf(i3), aw9Var, Boolean.valueOf(z2), Integer.valueOf(i4)}) == null) && i3 > 0 && aw9Var != null && (a02 = aw9Var.a0()) != null && a02.u() != null) {
            MetaData u2 = a02.u();
            u2.setGiftNum(u2.getGiftNum() + i3);
        }
    }

    public SparseArray<Object> a1(aw9 aw9Var, boolean z2, int i3) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048691, this, new Object[]{aw9Var, Boolean.valueOf(z2), Integer.valueOf(i3)})) == null) {
            if (aw9Var == null) {
                return null;
            }
            return m4a.b(aw9Var, i3);
        }
        return (SparseArray) invokeCommon.objValue;
    }

    public void g4(aw9 aw9Var, int i3, int i4, boolean z2, int i5, boolean z3) {
        PbLandscapeListView pbLandscapeListView;
        boolean z4;
        boolean z5;
        boolean z6;
        boolean z7;
        int i6;
        PbReplyTitleViewHolder pbReplyTitleViewHolder;
        PbFragment pbFragment;
        int size;
        int i7;
        Parcelable e2;
        Parcelable e3;
        int size2;
        int i8;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(1048720, this, new Object[]{aw9Var, Integer.valueOf(i3), Integer.valueOf(i4), Boolean.valueOf(z2), Integer.valueOf(i5), Boolean.valueOf(z3)}) == null) && aw9Var != null && this.n != null) {
            this.P0 = aw9Var;
            this.R0 = i3;
            if (aw9Var.R() != null) {
                this.f1 = aw9Var.R().getCopyThreadRemindType();
                this.l0 = i2(aw9Var.R());
            }
            if (aw9Var.Y() != null) {
                this.b2 = aw9Var.Y().getUserId();
            }
            this.u.A(this.P0);
            O1(aw9Var);
            this.T0 = false;
            this.O0 = z2;
            I3();
            lw9 lw9Var = aw9Var.h;
            if (lw9Var != null && lw9Var.b()) {
                if (this.q == null) {
                    PbThreadPostView pbThreadPostView = new PbThreadPostView(this.e.getContext());
                    this.q = pbThreadPostView;
                    this.n.w(pbThreadPostView, 1);
                    this.q.setData(aw9Var);
                    this.q.setChildOnClickLinstener(this.U);
                }
            } else {
                PbThreadPostView pbThreadPostView2 = this.q;
                if (pbThreadPostView2 != null && (pbLandscapeListView = this.n) != null) {
                    pbLandscapeListView.removeHeaderView(pbThreadPostView2);
                }
            }
            h4(aw9Var, z2, i3, TbadkCoreApplication.getInst().getSkinType());
            Y3(aw9Var);
            this.x.E(aw9Var, this.Q0);
            if (this.y1 == null) {
                this.y1 = new y0a(this.e.getPageContext(), this.z1);
            }
            this.y1.a(aw9Var.z());
            if (this.e.Y6()) {
                if (this.O == null) {
                    w6a w6aVar = new w6a(this.e.getPageContext());
                    this.O = w6aVar;
                    w6aVar.g();
                    this.O.a(this.c2);
                }
                this.n.setPullRefresh(this.O);
                w6a w6aVar2 = this.O;
                if (w6aVar2 != null) {
                    w6aVar2.D(TbadkCoreApplication.getInst().getSkinType());
                }
            } else if (aw9Var.B().c() == 0 && z2) {
                this.n.setPullRefresh(null);
            } else {
                if (this.O == null) {
                    w6a w6aVar3 = new w6a(this.e.getPageContext());
                    this.O = w6aVar3;
                    w6aVar3.g();
                    this.O.a(this.c2);
                }
                this.n.setPullRefresh(this.O);
                w6a w6aVar4 = this.O;
                if (w6aVar4 != null) {
                    w6aVar4.D(TbadkCoreApplication.getInst().getSkinType());
                }
                C1();
            }
            v0();
            this.J.K(this.O0);
            this.J.H(false);
            vz9 vz9Var = this.J;
            if (i3 == 5) {
                z4 = true;
            } else {
                z4 = false;
            }
            vz9Var.I(z4);
            vz9 vz9Var2 = this.J;
            if (i3 == 6) {
                z5 = true;
            } else {
                z5 = false;
            }
            vz9Var2.J(z5);
            vz9 vz9Var3 = this.J;
            if (z3 && this.Z1 && i3 != 2) {
                z6 = true;
            } else {
                z6 = false;
            }
            vz9Var3.F(z6);
            this.J.D(aw9Var, false);
            this.J.v();
            vz9 vz9Var4 = this.J;
            if (aw9Var.B().b() != 0) {
                z7 = true;
            } else {
                z7 = false;
            }
            vz9Var4.x(z7, aw9Var.i());
            this.x.C(aw9Var.a0(), aw9Var.a());
            if (aw9Var.R() != null && aw9Var.R().getPraise() != null && this.d != -1) {
                aw9Var.R().getPraise().setIsLike(this.d);
            }
            this.n.removeFooterView(this.b1);
            this.n.addFooterView(this.b1);
            if (TbadkCoreApplication.isLogin()) {
                this.n.setNextPage(this.P);
                this.h = 2;
                C1();
            } else {
                this.T0 = true;
                if (aw9Var.B().b() == 1) {
                    if (this.Q == null) {
                        PbFragment pbFragment2 = this.e;
                        this.Q = new r6a(pbFragment2, pbFragment2);
                    }
                    this.n.setNextPage(this.Q);
                } else {
                    this.n.setNextPage(this.P);
                }
                this.h = 3;
            }
            ArrayList<nwa> I = aw9Var.I();
            if (aw9Var.B().b() != 0 && I != null && I.size() >= aw9Var.B().e()) {
                if (z3) {
                    if (this.Z1) {
                        z0();
                        if (aw9Var.B().b() != 0) {
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
                if (l2(aw9Var)) {
                    v0 v0Var = this.e1;
                    if (v0Var != null && (pbReplyTitleViewHolder = v0Var.a) != null && pbReplyTitleViewHolder.getView() != null) {
                        if (this.e1.a.getView().getTop() < 0) {
                            i6 = this.e1.a.getView().getHeight();
                        } else {
                            i6 = this.e1.a.getView().getBottom();
                        }
                    } else {
                        i6 = 0;
                    }
                    if (this.e.F7()) {
                        this.P.y(false);
                        if (ListUtils.isEmpty(aw9Var.U())) {
                            this.P.K(TbadkCoreApplication.getInst().getResources().getString(R.string.obfuscated_res_0x7f0f1037), i6);
                        }
                    } else if (ListUtils.isEmpty(aw9Var.U())) {
                        this.P.K(TbadkCoreApplication.getInst().getResources().getString(R.string.obfuscated_res_0x7f0f1038), i6);
                    }
                    if (this.e.g7() != null && !this.e.g7().p()) {
                        this.e.g7().x();
                    }
                } else {
                    if (aw9Var.B().b() == 0) {
                        nwa nwaVar = (nwa) ListUtils.getItem(I, ListUtils.getCount(I) - 1);
                        if (nwaVar != null) {
                            nwaVar.P = false;
                        }
                        this.P.E(-UtilHelper.getDimenPixelSize(R.dimen.tbds32));
                        this.n.setClipChildren(false);
                        this.P.H(TbadkCoreApplication.getInst().getResources().getString(R.string.list_has_all_comments));
                    } else {
                        this.P.E(0);
                        this.P.H(TbadkCoreApplication.getInst().getResources().getString(R.string.load_more));
                    }
                    this.P.n();
                }
                if (aw9Var.B().b() == 0 || I == null) {
                    c3();
                }
            }
            switch (i3) {
                case 2:
                    if (this.n.getData() == null && aw9Var.I() == null) {
                        size = 0;
                    } else {
                        size = (this.n.getData().size() - aw9Var.I().size()) + this.n.getHeaderViewsCount();
                    }
                    PbLandscapeListView pbLandscapeListView2 = this.n;
                    if (i4 > 1) {
                        i7 = (i4 + size) - 2;
                    } else {
                        i7 = 0;
                    }
                    pbLandscapeListView2.setSelection(i7);
                    break;
                case 3:
                    if (i5 == 1 && (e2 = f1a.b().e()) != null && !(e2 instanceof RecyclerView.SavedState)) {
                        this.n.post(new h0(this, e2, I, aw9Var));
                        break;
                    }
                    break;
                case 4:
                    this.Z1 = false;
                    break;
                case 5:
                    this.n.setSelection(0);
                    break;
                case 6:
                case 9:
                    if (i5 == 1 && (e3 = f1a.b().e()) != null && !(e3 instanceof RecyclerView.SavedState)) {
                        this.n.onRestoreInstanceState(e3);
                        break;
                    } else {
                        this.n.setSelection(0);
                        break;
                    }
                    break;
                case 8:
                    if (i4 == 0) {
                        PbLandscapeListView pbLandscapeListView3 = this.n;
                        pbLandscapeListView3.setSelection(c4a.g(pbLandscapeListView3) + this.n.getHeaderViewsCount());
                    } else if (ListUtils.isEmpty(aw9Var.U())) {
                        if (this.n.getData() == null && aw9Var.I() == null) {
                            size2 = 0;
                        } else {
                            size2 = (this.n.getData().size() - aw9Var.I().size()) + this.n.getHeaderViewsCount();
                        }
                        PbLandscapeListView pbLandscapeListView4 = this.n;
                        if (i4 > 0) {
                            i8 = i4 + size2;
                        } else {
                            i8 = 0;
                        }
                        pbLandscapeListView4.setSelection(i8);
                    } else {
                        this.n.setSelection(aw9Var.I().size() + this.n.getHeaderViewsCount());
                    }
                    this.P.g();
                    this.P.H(this.e.getString(R.string.obfuscated_res_0x7f0f1031));
                    this.P.E(0);
                    this.P.B();
                    break;
            }
            if (this.f1 == h2 && f2()) {
                p0();
            }
            if (this.k1) {
                W2();
                this.k1 = false;
                if (i5 == 0) {
                    y3(true);
                }
            }
            if (aw9Var.d == 1 || aw9Var.e == 1) {
                if (this.q1 == null) {
                    this.q1 = new PbTopTipView(this.e.getContext());
                }
                if (aw9Var.e == 1 && "game_guide".equals(this.e.k7())) {
                    this.q1.setText(this.e.getString(R.string.obfuscated_res_0x7f0f1043));
                    this.q1.l(this.f, this.S0);
                } else if (aw9Var.d == 1 && "game_news".equals(this.e.k7())) {
                    this.q1.setText(this.e.getString(R.string.obfuscated_res_0x7f0f1042));
                    this.q1.l(this.f, this.S0);
                }
            }
            X1(aw9Var);
            int i9 = this.b;
            if (i9 == -1) {
                i9 = P0();
            }
            this.b = i9;
            this.n.removeFooterView(this.G1.a());
            if (!ListUtils.isEmpty(aw9Var.K()) && aw9Var.B().b() == 0) {
                this.n.removeFooterView(this.b1);
                this.G1.d(Math.max(this.x0.getMeasuredHeight(), this.M0 / 2));
                this.n.addFooterView(this.G1.a());
                this.G1.f(aw9Var);
            }
            Y2(aw9Var);
            if (aw9Var.k0() && this.e.l0().l2() && this.e.h7() != null) {
                this.e.h7().d();
            }
            if (aw9Var.i() != 3) {
                V1(aw9Var);
            }
            this.A0.setText(TbSingleton.getInstance().getAdVertiComment(aw9Var.r0(), aw9Var.s0(), m1()));
            if (this.r != null) {
                aw9 aw9Var2 = this.P0;
                if (aw9Var2 != null && aw9Var2.n() != null && (pbFragment = this.e) != null && pbFragment.l0() != null) {
                    this.r.r(this.e.l0().b);
                }
                aw9 aw9Var3 = this.P0;
                if (aw9Var3 != null && aw9Var3.R() != null && !ListUtils.isEmpty(this.P0.R().getThreadRecommendInfoDataList()) && this.P0.R().getThreadRecommendInfoDataList().get(0) != null && this.P0.R().getThreadRecommendInfoDataList().get(0).businessType != 1) {
                    this.r.q(this.P0.R().getThreadRecommendInfoDataList().get(0));
                } else {
                    this.r.q(null);
                }
            }
            if (this.E != null && this.P0.n() != null) {
                this.E.o(this.P0.n().getSpritePBGuide(), this.P0.n().getImage_url(), this.P0.n().getId());
            }
            if (R3()) {
                this.B.e(this.P0.R());
            } else {
                this.B.d(this.n);
            }
            this.u.D(this.P0);
            T3();
        }
    }

    @SuppressLint({"ResourceAsColor"})
    public final void h4(aw9 aw9Var, boolean z2, int i3, int i4) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(1048725, this, new Object[]{aw9Var, Boolean.valueOf(z2), Integer.valueOf(i3), Integer.valueOf(i4)}) == null) && aw9Var != null && aw9Var.R() != null) {
            PbFragment pbFragment = this.e;
            if (pbFragment != null && n1a.z(pbFragment)) {
                this.x.u(this.n);
                this.w.h(this.n);
            }
            if (this.e.e1()) {
                if (aw9Var.j() != null) {
                    this.m0 = aw9Var.j().d();
                    this.n0 = aw9Var.j().b();
                }
                if (this.m0 == null && this.e.l0() != null && this.e.l0().R0() != null) {
                    this.m0 = this.e.l0().R0();
                }
            }
            nwa a02 = aw9Var.a0();
            G3(a02, aw9Var);
            int i5 = 8;
            this.x.A(8);
            int i6 = 1;
            if (aw9Var.y0()) {
                this.m1 = true;
                this.j.u(true);
                this.j.a.hideBottomLine();
            } else {
                this.m1 = false;
                this.j.u(false);
            }
            if (this.e.g7() != null) {
                this.e.g7().w(this.m1);
            }
            if (a02 == null) {
                return;
            }
            this.Q0 = a02;
            this.x.A(0);
            this.y.e(aw9Var, this.n);
            this.A.e(aw9Var, this.C1, new d0(this));
            this.w.j(aw9Var);
            this.v.h(aw9Var, this.O0);
            this.v.g(aw9Var);
            this.x.B(this.P0, a02, this.a2);
            if (this.a1 != null) {
                if (aw9Var.a()) {
                    this.a1.getView().setVisibility(8);
                } else {
                    this.a1.getView().setVisibility(0);
                    ow9 ow9Var = new ow9(ow9.g);
                    ow9Var.b = aw9Var.g;
                    ow9Var.c = this.e.F7();
                    ow9Var.e = aw9Var.f;
                    ow9Var.f = aw9Var.R().isQuestionThread();
                    this.a1.i(ow9Var);
                }
            }
            s4(a02);
            t4(aw9Var);
            SafeHandler.getInst().post(new e0(this));
            this.z.f(this.n);
            if (a02.f1129T) {
                this.z.g(a02.U());
                PbLandscapeListView pbLandscapeListView = this.n;
                this.z.c(this.n, (pbLandscapeListView == null || pbLandscapeListView.getHeaderViewsCount() <= 1) ? 0 : 0);
            }
            vz9 vz9Var = this.J;
            if (vz9Var != null && vz9Var.p() != null) {
                this.J.p().W(a02.f1129T);
            }
            vz9 vz9Var2 = this.J;
            if (vz9Var2 != null) {
                vz9Var2.N(a02.f1129T);
            }
            MaskView maskView = this.H1;
            if (a02.f1129T) {
                i5 = 0;
            }
            maskView.setVisibility(i5);
        }
    }

    public void i4(g05.c cVar, boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048730, this, cVar, z2) == null) {
            n05 n05Var = this.i0;
            if (n05Var != null) {
                n05Var.dismiss();
                this.i0 = null;
            }
            p05 p05Var = new p05(this.e.getContext());
            ArrayList arrayList = new ArrayList();
            aw9 aw9Var = this.P0;
            if (aw9Var != null && aw9Var.R() != null && !this.P0.R().isBjh()) {
                arrayList.add(new l05(0, this.e.getPageContext().getString(R.string.save_to_emotion), p05Var));
            }
            if (!z2) {
                arrayList.add(new l05(1, this.e.getPageContext().getString(R.string.save_to_local), p05Var));
            }
            p05Var.m(arrayList);
            p05Var.r(new b0(this, cVar));
            n05 n05Var2 = new n05(this.e.getPageContext(), p05Var);
            this.i0 = n05Var2;
            n05Var2.l();
        }
    }

    public void j4(g05.c cVar, boolean z2, boolean z3, boolean z4, boolean z5) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048735, this, new Object[]{cVar, Boolean.valueOf(z2), Boolean.valueOf(z3), Boolean.valueOf(z4), Boolean.valueOf(z5)}) == null) {
            n05 n05Var = this.h0;
            if (n05Var != null) {
                n05Var.dismiss();
                this.h0 = null;
            }
            p05 p05Var = new p05(this.e.getContext());
            ArrayList arrayList = new ArrayList();
            if (!z4 && !z5) {
                arrayList.add(new l05(0, this.e.getPageContext().getString(R.string.obfuscated_res_0x7f0f04f5), p05Var));
            }
            if (z3) {
                arrayList.add(new l05(1, this.e.getPageContext().getString(R.string.report_text), p05Var));
            } else if (!z2) {
                arrayList.add(new l05(1, this.e.getPageContext().getString(R.string.obfuscated_res_0x7f0f0c89), p05Var));
            } else {
                arrayList.add(new l05(1, this.e.getPageContext().getString(R.string.remove_mark), p05Var));
            }
            p05Var.m(arrayList);
            p05Var.r(new a0(this, cVar));
            n05 n05Var2 = new n05(this.e.getPageContext(), p05Var);
            this.i0 = n05Var2;
            n05Var2.l();
        }
    }

    public void u2(int i3) {
        boolean z2;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeI(1048788, this, i3) != null) || this.S0 == i3) {
            return;
        }
        this.S0 = i3;
        u4(this.P0, this.O0);
        a3(this.P0, this.O0, this.R0, i3);
        BDLayoutMode layoutMode = this.e.getBaseFragmentActivity().getLayoutMode();
        if (i3 == 4) {
            z2 = true;
        } else {
            z2 = false;
        }
        layoutMode.setNightMode(z2);
        this.e.getBaseFragmentActivity().getLayoutMode().onModeChanged(this.f);
        SkinManager.setBackgroundColor(this.f, R.color.CAM_X0201);
        SkinManager.setBackgroundColor(this.s0, R.color.CAM_X0203);
        p2a p2aVar = this.y;
        if (p2aVar != null) {
            p2aVar.c(i3);
        }
        o2a o2aVar = this.v;
        if (o2aVar != null) {
            o2aVar.e(i3);
        }
        q2a q2aVar = this.w;
        if (q2aVar != null) {
            q2aVar.g(i3);
        }
        s2a s2aVar = this.x;
        if (s2aVar != null) {
            s2aVar.q(i3);
        }
        r2a r2aVar = this.z;
        if (r2aVar != null) {
            r2aVar.e();
        }
        n2a n2aVar = this.A;
        if (n2aVar != null) {
            n2aVar.c();
        }
        MaskView maskView = this.H1;
        if (maskView != null) {
            maskView.g();
        }
        k1a k1aVar = this.r;
        if (k1aVar != null) {
            k1aVar.o();
        }
        e0a e0aVar = this.E;
        if (e0aVar != null) {
            e0aVar.n();
        }
        PbContentCollectionController pbContentCollectionController = this.B;
        if (pbContentCollectionController != null) {
            pbContentCollectionController.c();
        }
        PbListView pbListView = this.P;
        if (pbListView != null) {
            pbListView.e(i3);
        }
        if (this.R != null) {
            this.e.getBaseFragmentActivity().getLayoutMode().onModeChanged(this.R);
            SkinManager.setBackgroundResource(this.R, R.drawable.pb_foot_more_trans_selector);
        }
        if (this.S != null) {
            this.e.getBaseFragmentActivity().getLayoutMode().onModeChanged(this.S);
            SkinManager.setBackgroundResource(this.S, R.drawable.pb_foot_more_trans_selector);
        }
        f05 f05Var = this.K;
        if (f05Var != null) {
            f05Var.autoChangeSkinType(this.e.getPageContext());
        }
        A4(this.k0);
        this.J.v();
        w6a w6aVar = this.O;
        if (w6aVar != null) {
            w6aVar.D(i3);
        }
        EditorTools editorTools = this.q0;
        if (editorTools != null) {
            editorTools.F(i3);
        }
        r6a r6aVar = this.Q;
        if (r6aVar != null) {
            r6aVar.g(i3);
        }
        if (!ListUtils.isEmpty(this.p)) {
            for (CustomBlueCheckRadioButton customBlueCheckRadioButton : this.p) {
                customBlueCheckRadioButton.c();
            }
        }
        G4();
        UtilHelper.setStatusBarBackground(this.g, i3);
        UtilHelper.setStatusBarBackground(this.Z0, i3);
        if (this.F != null) {
            jq5.a(this.e.getPageContext(), this.F);
        }
        l0a l0aVar = this.j1;
        if (l0aVar != null) {
            l0aVar.l(i3);
        }
        e5a e5aVar = this.j;
        if (e5aVar != null) {
            e5aVar.p(i3);
        }
        LinearLayout linearLayout = this.y0;
        if (linearLayout != null) {
            linearLayout.setBackgroundDrawable(SkinManager.createShapeDrawableFromColor(BdUtilHelper.getDimens(this.e.getContext(), R.dimen.tbds47), SkinManager.getColor(R.color.CAM_X0209)));
        }
        aw9 aw9Var = this.P0;
        if (aw9Var != null && aw9Var.t()) {
            WebPManager.setPureDrawable(this.E0, R.drawable.icon_pure_pb_bottom_collected26_selection, R.color.CAM_X0305, WebPManager.ResourceStateType.NORMAL_PRESS);
        } else {
            WebPManager.setPureDrawable(this.E0, R.drawable.icon_pure_pb_bottom_collect26, R.color.CAM_X0107, WebPManager.ResourceStateType.NORMAL_PRESS);
        }
        WebPManager.setPureDrawable(this.C0, R.drawable.icon_pure_pb_bottom_comment26, R.color.CAM_X0107, WebPManager.ResourceStateType.NORMAL_PRESS);
        WebPManager.setPureDrawable(this.z0, R.drawable.icon_pure_post_expression24, R.color.CAM_X0107, WebPManager.ResourceStateType.NORMAL);
        E4(this.P0);
        if (this.H0.getVisibility() == 0) {
            this.H0.setBackgroundDrawable(SkinManager.createShapeDrawable(BdUtilHelper.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds15), R.color.CAM_X0301, 0, 0, i3));
        }
        SkinManager.setBackgroundColor(this.x0, R.color.CAM_X0207);
        SkinManager.setBackgroundColor(this.w0, R.color.CAM_X0203);
        SkinManager.setViewTextColor(this.s1, (int) R.color.cp_cont_n);
        SkinManager.setViewTextColor(this.A0, (int) R.color.CAM_X0109);
        SkinManager.setViewTextColor(this.K0, (int) R.color.CAM_X0107);
        SkinManager.setBackgroundShapeDrawable(this.K0, BdUtilHelper.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds18), R.color.CAM_X0207, R.color.CAM_X0207);
        SkinManager.setViewTextColor(this.J0, (int) R.color.CAM_X0107);
        SkinManager.setBackgroundShapeDrawable(this.J0, BdUtilHelper.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds18), R.color.CAM_X0207, R.color.CAM_X0207);
        AgreeView agreeView = this.D0;
        if (agreeView != null) {
            agreeView.x();
            this.D0.P(i3);
            AgreeData data = this.D0.getData();
            if (data != null) {
                X2(data, data.agreeNum);
            }
        }
        zy9 zy9Var = this.u1;
        if (zy9Var != null) {
            zy9Var.l(i3);
        }
        PbThreadPostView pbThreadPostView = this.q;
        if (pbThreadPostView != null) {
            pbThreadPostView.c(i3);
        }
        CardForumHeadLayout cardForumHeadLayout = this.a;
        if (cardForumHeadLayout != null) {
            cardForumHeadLayout.g();
            EMManager.from(this.a).setCorner(R.string.J_X05).setBackGroundRealColor(uua.a(SkinManager.getColor(R.color.CAM_X0341), 0.08f));
        }
        v6a v6aVar = this.I0;
        if (v6aVar != null) {
            v6aVar.i();
        }
        u6a u6aVar = this.G1;
        if (u6aVar != null) {
            u6aVar.c();
        }
        RightFloatLayerView rightFloatLayerView = this.J1;
        if (rightFloatLayerView != null) {
            rightFloatLayerView.n();
        }
        SkinManager.setBackgroundColor(this.Y0, R.color.CAM_X0207);
        SkinManager.setViewTextColor(this.Y0.findViewById(R.id.tv_title), (int) R.color.CAM_X0105);
        LinearLayout linearLayout2 = this.L1;
        if (linearLayout2 != null) {
            EMManager.from(linearLayout2).setBackGroundColor(R.color.CAM_X0201);
        }
        o4a o4aVar = this.M1;
        if (o4aVar != null) {
            o4aVar.b(i3);
        }
    }
}
