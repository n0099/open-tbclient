package com.baidu.tieba;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.ColorRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.content.ContextCompat;
import androidx.core.view.InputDeviceCompat;
import androidx.core.view.ViewCompat;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.safe.SafeHandler;
import com.baidu.adp.lib.util.BdNetTypeUtil;
import com.baidu.adp.lib.util.BdUtilHelper;
import com.baidu.adp.widget.ListView.BdTypeRecyclerView;
import com.baidu.adp.widget.design.behavior.AppBarLayoutStickyBehavior;
import com.baidu.adp.widget.design.behavior.ExposeTagViewCoordinatorLayout;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.core.BaseFragment;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.sharedPref.SharedPrefHelper;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.SelectImageHelper;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.SvgManager;
import com.baidu.tbadk.core.util.TbImageHelper;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.WebPManager;
import com.baidu.tbadk.core.view.MessageRedDotView;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tbadk.core.view.NoPressedRelativeLayout;
import com.baidu.tbadk.core.view.PbListView;
import com.baidu.tbadk.core.view.UserPhotoLayout;
import com.baidu.tbadk.gif.GifView;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tbadk.widget.layout.ObservedChangeLinearLayout;
import com.baidu.tieba.ff;
import com.baidu.tieba.frs.FrsAllThreadFragment;
import com.baidu.tieba.frs.FrsFragment;
import com.baidu.tieba.frs.FrsTabViewPager;
import com.baidu.tieba.frs.mc.FrsNewAreaFragment;
import com.baidu.tieba.frs.shrinkhead.LogicField;
import com.baidu.tieba.frs.vc.FrsTabViewController;
import com.baidu.tieba.frs.view.FrsHeaderViewContainer;
import com.baidu.tieba.frs.view.FrsMoveAreaBottomMenuView;
import com.baidu.tieba.frs.view.FrsMultiDelBottomMenuView;
import com.baidu.tieba.frs.view.FrsTopBarGroupEntranceGuideView;
import com.baidu.tieba.tbadkCore.FrsCommonImageLayout;
import com.baidu.tieba.tbadkCore.FrsViewData;
import com.baidu.tieba.tbadkCore.voice.PlayVoiceBnt;
import com.baidu.tieba.tbadkCore.writeModel.PostWriteCallBackData;
import com.baidu.tieba.u46;
import com.baidu.tieba.view.CommonTipView;
import com.baidu.tieba.view.NavigationBarCoverTip;
import com.baidu.tieba.z45;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.appbar.CollapsingToolbarLayout;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import tbclient.FrsPage.TopbarEntrance;
/* loaded from: classes6.dex */
public class li7 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public NoNetworkView A;
    public NavigationBar B;
    @NonNull
    public final it7 C;
    public View D;
    public View E;
    public FrameLayout F;
    public boolean G;
    public boolean H;
    public int I;
    public boolean J;
    public CommonTipView K;
    public bx7 L;
    public hn7 M;
    public kx7 N;
    public GifView O;
    public TbImageView P;
    public HashSet<String> Q;
    public fz9 R;
    public int S;

    /* renamed from: T  reason: collision with root package name */
    public int f1128T;
    public View U;
    public View V;
    public ObservedChangeLinearLayout W;
    public FrsTopBarGroupEntranceGuideView X;
    public boolean Y;
    public fn7 Z;
    public FrsFragment a;
    public boolean a0;
    public NoPressedRelativeLayout b;
    public mra b0;
    public CoordinatorLayout c;
    public AppBarLayout c0;
    public View d;
    public AppBarLayoutStickyBehavior d0;
    public View e;
    public FrsHeaderViewContainer e0;
    public ImageView f;
    public CollapsingToolbarLayout f0;
    public ImageView g;
    public boolean g0;
    public MessageRedDotView h;
    public int h0;
    public xt6 i;
    public int i0;
    public ImageView j;
    public int j0;
    public ImageView k;
    public fx7 k0;
    public TextView l;
    public FrsMultiDelBottomMenuView l0;
    public ImageView m;
    public FrsMoveAreaBottomMenuView m0;
    public ViewStub n;
    public NavigationBarCoverTip n0;
    public FrameLayout o;
    public TextView o0;
    public TbImageView p;
    public TextView p0;
    public TbImageView q;
    public int q0;
    public ExposeTagViewCoordinatorLayout r;
    public int r0;
    public FrsTabViewPager s;
    public boolean s0;
    public PbListView t;
    public an t0;
    public BdTypeRecyclerView u;
    public sya u0;
    public dn7 v;
    public CustomMessageListener v0;
    public ix7 w;
    public AppBarLayout.OnOffsetChangedListener w0;
    public z45 x;
    public Runnable x0;
    public View.OnClickListener y;
    public boolean y0;
    public NoNetworkView.b z;

    /* loaded from: classes6.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ TopbarEntrance a;
        public final /* synthetic */ li7 b;

        public a(li7 li7Var, TopbarEntrance topbarEntrance) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {li7Var, topbarEntrance};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = li7Var;
            this.a = topbarEntrance;
        }

        @Override // java.lang.Runnable
        public void run() {
            String str;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                int[] iArr = new int[2];
                this.b.m.getLocationOnScreen(iArr);
                int width = iArr[0] + (this.b.m.getWidth() / 2);
                if (width > 0) {
                    this.b.X.setTargetViewCenterX(width);
                    FrsTopBarGroupEntranceGuideView frsTopBarGroupEntranceGuideView = this.b.X;
                    if (dw7.d()) {
                        str = this.a.guide_tip_text;
                    } else {
                        str = this.a.guide_tip_first_text;
                    }
                    frsTopBarGroupEntranceGuideView.e(str);
                    dw7.e();
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public class b implements z45.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ li7 a;

        public b(li7 li7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {li7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = li7Var;
        }

        @Override // com.baidu.tieba.z45.c
        public void a(z45 z45Var, int i, View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIL(1048576, this, z45Var, i, view2) == null) {
                z45Var.e();
                if (i == 0) {
                    this.a.a.N5();
                } else if (i == 1 && this.a.a.getPageContext() != null) {
                    SelectImageHelper.getAlbumImage(this.a.a.getPageContext().getPageActivity());
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public class c implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ li7 a;

        public c(li7 li7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {li7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = li7Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeV(1048576, this) != null) || this.a.n == null) {
                return;
            }
            this.a.o.setVisibility(0);
            this.a.q.setVisibility(0);
            this.a.p.setVisibility(8);
        }
    }

    /* loaded from: classes6.dex */
    public class d implements df {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ li7 a;

        @Override // com.baidu.tieba.df
        public int a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                return 4;
            }
            return invokeV.intValue;
        }

        @Override // com.baidu.tieba.df
        public int b() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                return 16;
            }
            return invokeV.intValue;
        }

        public d(li7 li7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {li7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = li7Var;
        }

        @Override // com.baidu.tieba.df
        public View c(LayoutInflater layoutInflater) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, layoutInflater)) == null) {
                View inflate = layoutInflater.inflate(R.layout.tips_blue_left_up, (ViewGroup) null);
                ((TextView) inflate.findViewById(R.id.obfuscated_res_0x7f0925ce)).setText(R.string.obfuscated_res_0x7f0f088f);
                this.a.a.getPageContext().getLayoutMode().onModeChanged(inflate);
                return inflate;
            }
            return (View) invokeL.objValue;
        }

        @Override // com.baidu.tieba.df
        public int getXOffset() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
                return BdUtilHelper.getDimens(this.a.a.getActivity(), R.dimen.obfuscated_res_0x7f07035d);
            }
            return invokeV.intValue;
        }

        @Override // com.baidu.tieba.df
        public int getYOffset() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
                return -BdUtilHelper.getDimens(this.a.a.getActivity(), R.dimen.obfuscated_res_0x7f070404);
            }
            return invokeV.intValue;
        }
    }

    /* loaded from: classes6.dex */
    public class e implements ff.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        @Override // com.baidu.tieba.ff.a
        public void onShown() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            }
        }

        public e(li7 li7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {li7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // com.baidu.tieba.ff.a
        public void onDismiss() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                SharedPrefHelper.getInstance().putLong("frs_video_activity_guide", 1L);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class f implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ef a;

        public f(li7 li7Var, ef efVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {li7Var, efVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = efVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            ef efVar;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && (efVar = this.a) != null) {
                efVar.d();
            }
        }
    }

    /* loaded from: classes6.dex */
    public class g implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ li7 a;

        public g(li7 li7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {li7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = li7Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.a0().notifyDataSetChanged();
                if (!this.a.s0) {
                    this.a.R.n(this.a.S, this.a.f1128T, this.a.J, true);
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public class h extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ li7 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public h(li7 li7Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {li7Var, Integer.valueOf(i)};
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
            this.a = li7Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof Boolean)) {
                if (((Boolean) customResponsedMessage.getData()).booleanValue()) {
                    if (this.a.t0 == null) {
                        this.a.t0 = new an(new ym());
                    }
                    this.a.t0.q(this.a.u, 2);
                } else if (this.a.t0 != null) {
                    this.a.t0.w();
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public class i implements AppBarLayout.OnOffsetChangedListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ li7 a;

        public i(li7 li7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {li7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = li7Var;
        }

        @Override // com.google.android.material.appbar.AppBarLayout.OnOffsetChangedListener, com.google.android.material.appbar.AppBarLayout.BaseOnOffsetChangedListener
        public void onOffsetChanged(AppBarLayout appBarLayout, int i) {
            boolean z;
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeLI(1048576, this, appBarLayout, i) != null) {
                return;
            }
            this.a.Q(appBarLayout, i);
            if (this.a.w != null && this.a.r.hasTargetView()) {
                ix7 ix7Var = this.a.w;
                if (i == 0 && !this.a.r.canDrag()) {
                    z = true;
                } else {
                    z = false;
                }
                ix7Var.t(z);
            }
            if (!this.a.K0() && this.a.u0 != null) {
                this.a.u0.g();
            }
            if (this.a.i0 != i && Math.abs(i) >= 0 && this.a.X() != -1) {
                if (Math.abs(i) >= this.a.X()) {
                    if (this.a.g0) {
                        this.a.g0 = false;
                        li7 li7Var = this.a;
                        li7Var.U0(li7Var.g0);
                    }
                } else if (!this.a.g0) {
                    this.a.g0 = true;
                    li7 li7Var2 = this.a;
                    li7Var2.U0(li7Var2.g0);
                }
                int d0 = this.a.d0() + this.a.l0() + this.a.n0();
                int totalScrollRange = appBarLayout.getTotalScrollRange() - Math.abs(i);
                int totalScrollRange2 = (appBarLayout.getTotalScrollRange() - d0) + this.a.C.g();
                int g = totalScrollRange + this.a.C.g();
                if (totalScrollRange2 <= 0) {
                    return;
                }
                float abs = Math.abs(i * 1.0f) / totalScrollRange2;
                if (Float.compare(abs, 1.0f) > 0) {
                    abs = 1.0f;
                }
                if (Float.compare(abs, 0.05f) <= 0 && this.a.i0 - i < 0) {
                    abs = 0.0f;
                }
                if (Float.compare(abs, 1.0f) != 0) {
                    if (this.a.V != null) {
                        if (this.a.t0() != UtilHelper.getStatusBarHeight()) {
                            this.a.d2(0);
                        }
                        this.a.V.setVisibility(8);
                    }
                } else {
                    this.a.d2(Math.abs(d0 - g));
                    if (this.a.V != null) {
                        this.a.V.setVisibility(0);
                    }
                }
                if (this.a.B != null) {
                    if (this.a.Y) {
                        this.a.B.getBarBgView().setAlpha(abs);
                        this.a.g2(false);
                        this.a.C.c(abs);
                    } else if (this.a.p0 != null) {
                        this.a.p0.setAlpha(abs);
                    }
                }
                this.a.i0 = i;
                CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(2921397, Integer.valueOf(i));
                CustomMessage customMessage = new CustomMessage(2921397);
                if (this.a.a != null && this.a.a.m4() != null && this.a.a.m4().B() != null && (this.a.a.m4().B().b instanceof BaseFragment)) {
                    customMessage.setTag(((BaseFragment) this.a.a.m4().B().b).getUniqueId());
                    customResponsedMessage.setOrginalMessage(customMessage);
                }
                MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
            }
            if (this.a.w != null && this.a.w.k() > 0 && Math.abs(i) >= this.a.w.k()) {
                this.a.w.y();
            }
        }
    }

    /* loaded from: classes6.dex */
    public class j implements y06 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ li7 a;

        public j(li7 li7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {li7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = li7Var;
        }

        @Override // com.baidu.tieba.y06
        public void a(View view2, int i, int i2, int i3, int i4) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{view2, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4)}) == null) && i2 != i4 && i4 > 0) {
                this.a.f0.setMinimumHeight(i2);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class k extends DefaultItemAnimator {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public int a;
        public final /* synthetic */ li7 b;

        public k(li7 li7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {li7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = li7Var;
            this.a = 0;
        }

        @Override // androidx.recyclerview.widget.SimpleItemAnimator
        public void onRemoveFinished(RecyclerView.ViewHolder viewHolder) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, viewHolder) == null) {
                super.onRemoveFinished(viewHolder);
                int i = this.a - 1;
                this.a = i;
                if (i == 0) {
                    this.b.u.getAdapter().notifyDataSetChanged();
                }
            }
        }

        @Override // androidx.recyclerview.widget.SimpleItemAnimator
        public void onRemoveStarting(RecyclerView.ViewHolder viewHolder) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, viewHolder) == null) {
                this.a++;
                super.onRemoveStarting(viewHolder);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class l extends LinearLayoutManager {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public l(li7 li7Var, Context context) {
            super(context);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {li7Var, context};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    super((Context) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
        }

        @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.LayoutManager
        public void onLayoutChildren(RecyclerView.Recycler recycler, RecyclerView.State state) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048576, this, recycler, state) == null) {
                try {
                    super.onLayoutChildren(recycler, state);
                } catch (Throwable unused) {
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public class m implements RecyclerView.RecyclerListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ li7 a;

        public m(li7 li7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {li7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = li7Var;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.RecyclerListener
        public void onViewRecycled(RecyclerView.ViewHolder viewHolder) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, viewHolder) == null) {
                View view2 = viewHolder.itemView;
                if (this.a.R != null) {
                    this.a.R.k(view2);
                }
                PlayVoiceBnt playVoiceBnt = (PlayVoiceBnt) view2.findViewById(R.id.abstract_voice);
                if (playVoiceBnt != null) {
                    playVoiceBnt.h();
                }
                FrsCommonImageLayout frsCommonImageLayout = (FrsCommonImageLayout) view2.findViewById(R.id.abstract_img_layout);
                if (frsCommonImageLayout != null) {
                    frsCommonImageLayout.p();
                }
                if (view2 instanceof UserPhotoLayout) {
                    ((UserPhotoLayout) view2).reset();
                }
                if (this.a.u0 != null) {
                    this.a.u0.e(view2);
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public class n implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ li7 a;

        public n(li7 li7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {li7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = li7Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                this.a.a.r4();
                if (this.a.a != null && this.a.c0 != null) {
                    this.a.a.a5();
                    this.a.c0.setExpanded(true);
                    if (this.a.R != null) {
                        this.a.R.n(this.a.S, this.a.f1128T, false, true);
                    }
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public class o implements ExposeTagViewCoordinatorLayout.NestedScrollAcceptedListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ li7 a;

        public o(li7 li7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {li7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = li7Var;
        }

        @Override // com.baidu.adp.widget.design.behavior.ExposeTagViewCoordinatorLayout.NestedScrollAcceptedListener
        public void onNestedScrollAccepted(boolean z) {
            boolean z2;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeZ(1048576, this, z) == null) && this.a.w != null && this.a.r.hasTargetView()) {
                ix7 ix7Var = this.a.w;
                if (this.a.i0 == 0 && !this.a.r.canDrag()) {
                    z2 = true;
                } else {
                    z2 = false;
                }
                ix7Var.t(z2);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class p implements ViewPager.OnPageChangeListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ li7 a;

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageScrollStateChanged(int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048576, this, i) == null) {
            }
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageScrolled(int i, float f, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Integer.valueOf(i), Float.valueOf(f), Integer.valueOf(i2)}) == null) {
            }
        }

        public p(li7 li7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {li7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = li7Var;
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageSelected(int i) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i) == null) && this.a.w != null && this.a.r.hasTargetView()) {
                this.a.w.t(false);
                this.a.r.clearTargetView();
            }
        }
    }

    public li7(FrsFragment frsFragment, View.OnClickListener onClickListener, fn7 fn7Var, boolean z, fx7 fx7Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {frsFragment, onClickListener, fn7Var, Boolean.valueOf(z), fx7Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = null;
        this.b = null;
        this.c = null;
        this.d = null;
        this.o = null;
        this.p = null;
        this.q = null;
        this.x = null;
        this.y = null;
        this.z = null;
        this.C = ht7.a();
        this.G = true;
        this.H = true;
        this.I = 0;
        this.J = false;
        this.S = 0;
        this.f1128T = 0;
        this.U = null;
        this.V = null;
        this.Y = false;
        this.a0 = true;
        this.g0 = true;
        this.h0 = -1;
        this.i0 = -1;
        this.q0 = 0;
        this.r0 = 0;
        this.s0 = false;
        this.v0 = new h(this, 2156674);
        this.w0 = new i(this);
        this.x0 = new c(this);
        this.a = frsFragment;
        this.y = onClickListener;
        MessageManager.getInstance().registerListener(this.v0);
        I0(fn7Var, z);
        this.Q = new HashSet<>();
        this.I = TbadkCoreApplication.getInst().getMainTabBottomBarHeight();
        this.j0 = TbadkCoreApplication.getInst().getSkinType();
        this.k0 = fx7Var;
    }

    public void C0(boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048580, this, z) == null) && this.M != null) {
            if (z) {
                v1(false, true);
            } else {
                v1(false, false);
            }
        }
    }

    public void C1(int i2) {
        FrsMoveAreaBottomMenuView frsMoveAreaBottomMenuView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(1048581, this, i2) == null) && (frsMoveAreaBottomMenuView = this.m0) != null) {
            frsMoveAreaBottomMenuView.setVisibility(i2);
        }
    }

    public void D1(int i2) {
        FrsMoveAreaBottomMenuView frsMoveAreaBottomMenuView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(1048583, this, i2) == null) && (frsMoveAreaBottomMenuView = this.m0) != null) {
            frsMoveAreaBottomMenuView.setMoveNumber(i2);
        }
    }

    public void E0(e15 e15Var) {
        ix7 ix7Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, e15Var) == null) && (ix7Var = this.w) != null) {
            ix7Var.f(e15Var);
        }
    }

    public void E1(int i2) {
        FrsMultiDelBottomMenuView frsMultiDelBottomMenuView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(1048585, this, i2) == null) && (frsMultiDelBottomMenuView = this.l0) != null) {
            frsMultiDelBottomMenuView.setSelectNumber(i2);
        }
    }

    public void F1(boolean z) {
        FrsMultiDelBottomMenuView frsMultiDelBottomMenuView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048587, this, z) == null) && (frsMultiDelBottomMenuView = this.l0) != null) {
            frsMultiDelBottomMenuView.setIsBlockMode(z);
        }
    }

    public void G1(int i2) {
        FrsMultiDelBottomMenuView frsMultiDelBottomMenuView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(1048589, this, i2) == null) && (frsMultiDelBottomMenuView = this.l0) != null) {
            frsMultiDelBottomMenuView.setVisibility(i2);
        }
    }

    public void H1(u46.c cVar) {
        FrsMultiDelBottomMenuView frsMultiDelBottomMenuView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048591, this, cVar) == null) && (frsMultiDelBottomMenuView = this.l0) != null) {
            frsMultiDelBottomMenuView.setDeleteCallback(cVar);
        }
    }

    public void I1(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048593, this, i2) == null) {
            this.I = i2;
        }
    }

    public void J1(mn mnVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048595, this, mnVar) == null) {
            this.v.d(mnVar);
        }
    }

    public void K1(NoNetworkView.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048597, this, bVar) == null) {
            this.z = bVar;
            NoNetworkView noNetworkView = this.A;
            if (noNetworkView != null) {
                noNetworkView.addNetworkChangeListener(bVar);
            }
        }
    }

    public void L1(boolean z) {
        ix7 ix7Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048599, this, z) == null) && (ix7Var = this.w) != null) {
            ix7Var.v(z);
        }
    }

    public void N(RecyclerView.OnScrollListener onScrollListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048602, this, onScrollListener) == null) {
            this.u.addOnScrollListener(onScrollListener);
        }
    }

    public final void O(int i2) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeI(1048605, this, i2) != null) || this.a == null) {
            return;
        }
        P(i2);
    }

    public void R(String str) {
        kx7 kx7Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048614, this, str) == null) && (kx7Var = this.N) != null) {
            kx7Var.a(str);
        }
    }

    public final void U0(boolean z) {
        FrsFragment frsFragment;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048624, this, z) == null) && z && (frsFragment = this.a) != null && frsFragment.G0() != null) {
            this.a.G0().r0();
        }
    }

    public final void V1(int i2) {
        xt6 xt6Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(1048628, this, i2) == null) && (xt6Var = this.i) != null) {
            xt6Var.h(i2);
        }
    }

    public void a1(boolean z) {
        sya syaVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048642, this, z) == null) && z && (syaVar = this.u0) != null) {
            syaVar.i(2000);
        }
    }

    public void b2(boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048646, this, z) == null) && this.L != null) {
            if (ql5.h().k()) {
                this.L.z(false);
            } else {
                this.L.z(z);
            }
        }
    }

    public final void i2(@ColorRes int i2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(1048667, this, i2) == null) && this.m != null) {
            SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.m, R.drawable.ic_icon_pure_topbar_group40_svg, i2, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        }
    }

    public void o1(int i2) {
        ix7 ix7Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(1048679, this, i2) == null) && (ix7Var = this.w) != null) {
            ix7Var.r(i2);
        }
    }

    public void p1(boolean z) {
        AppBarLayout appBarLayout;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048681, this, z) == null) && (appBarLayout = this.c0) != null) {
            appBarLayout.setExpanded(z);
        }
    }

    public void r1(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048685, this, str) == null) {
            dn7 dn7Var = this.v;
            if (dn7Var instanceof pm7) {
                ((pm7) dn7Var).t(str);
            }
        }
    }

    public void s1(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048687, this, str) == null) {
            this.v.a(str);
        }
    }

    public void t1(int i2) {
        View view2;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(1048689, this, i2) == null) && (view2 = this.d) != null) {
            view2.setVisibility(i2);
        }
    }

    public void u1(boolean z) {
        hn7 hn7Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048691, this, z) == null) && (hn7Var = this.M) != null) {
            hn7Var.a(z);
        }
    }

    public void w1(pj7 pj7Var) {
        ix7 ix7Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048695, this, pj7Var) == null) && (ix7Var = this.w) != null) {
            ix7Var.s(pj7Var);
        }
    }

    public void y1(boolean z) {
        hn7 hn7Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048699, this, z) == null) {
            this.a0 = z;
            if (!z && (hn7Var = this.M) != null) {
                hn7Var.b(false, false);
            }
        }
    }

    public void z1(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048701, this, z) == null) {
            this.J = z;
        }
    }

    public void A1(int i2, boolean z) {
        ix7 ix7Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Integer.valueOf(i2), Boolean.valueOf(z)}) == null) && (ix7Var = this.w) != null) {
            ix7Var.u(i2, z);
        }
    }

    public void i1(int i2, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048666, this, new Object[]{Integer.valueOf(i2), Boolean.valueOf(z)}) == null) {
            xt6 xt6Var = this.i;
            if (xt6Var != null) {
                xt6Var.f(z, i2);
            }
            this.C.d(i2, z);
        }
    }

    public void q1(int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048683, this, i2, i3) == null) {
            this.S = i2;
            this.f1128T = i3;
        }
    }

    public void v1(boolean z, boolean z2) {
        hn7 hn7Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(1048693, this, new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) && this.a0 && (hn7Var = this.M) != null) {
            hn7Var.b(z, z2);
        }
    }

    @NonNull
    public static String f0(@NonNull String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65556, null, str)) == null) {
            String fixedBarText = UtilHelper.getFixedBarText(str, 7, true, false);
            if (fixedBarText.length() < 12) {
                return fixedBarText + "吧";
            }
            return UtilHelper.getFixedBarText(str, 6, true, false) + "吧";
        }
        return (String) invokeL.objValue;
    }

    public void B1(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048579, this, z) == null) {
            this.G = z;
            if (z) {
                this.t.H(this.a.getResources().getString(R.string.load_more));
                BdTypeRecyclerView bdTypeRecyclerView = this.u;
                if (bdTypeRecyclerView.getChildAt(bdTypeRecyclerView.getChildCount() - 1) == this.t.c()) {
                    this.t.U();
                    this.a.b();
                    return;
                }
                this.t.g();
                return;
            }
            this.t.H(this.a.getResources().getString(R.string.obfuscated_res_0x7f0f0bff));
            this.t.g();
        }
    }

    public void R0(boolean z) {
        boolean z2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048615, this, z) == null) {
            this.s0 = z;
            if (this.R == null) {
                return;
            }
            FrsFragment frsFragment = this.a;
            if (frsFragment != null && frsFragment.m4() != null && this.a.m4().B() != null) {
                z2 = this.a.m4().B().b instanceof FrsAllThreadFragment;
            } else {
                z2 = true;
            }
            if (!z && z2) {
                this.R.r(true);
                this.R.n(this.S, this.f1128T, this.J, true);
                return;
            }
            this.R.r(false);
            this.R.z();
        }
    }

    public void Z1(PostWriteCallBackData postWriteCallBackData) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048640, this, postWriteCallBackData) == null) && postWriteCallBackData != null && postWriteCallBackData.mFrom == 2) {
            if (postWriteCallBackData.getIconStampData() != null) {
                FrsFragment frsFragment = this.a;
                if (frsFragment != null && frsFragment.u() != null) {
                    kg5.c(this.a.u(), postWriteCallBackData, 1);
                    return;
                }
                return;
            }
            if (this.b0 == null) {
                this.b0 = new mra(this.a.getActivity(), this.b);
            }
            this.b0.g(postWriteCallBackData);
        }
    }

    public void d1(int i2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(1048651, this, i2) == null) && TbadkCoreApplication.getCurrentAccount() == null) {
            if ((i2 == 3 || i2 == 6) && SharedPrefHelper.getInstance().getBoolean("frs_login_tip", true)) {
                if (this.K == null) {
                    this.K = new CommonTipView(this.a.getActivity());
                }
                this.K.setText(R.string.obfuscated_res_0x7f0f084e);
                FrameLayout v0 = v0();
                if (v0 != null) {
                    this.K.j(v0, TbadkCoreApplication.getInst().getSkinType());
                    SharedPrefHelper.getInstance().putBoolean("frs_login_tip", false);
                }
            }
        }
    }

    public final void d2(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048652, this, i2) == null) {
            View s0 = s0();
            View u0 = u0();
            if (UtilHelper.canUseStyleImmersiveSticky() && s0 != null && u0 != null && s0.getLayoutParams() != null && u0.getLayoutParams() != null) {
                ViewGroup.LayoutParams layoutParams = s0.getLayoutParams();
                int statusBarHeight = UtilHelper.getStatusBarHeight() - i2;
                layoutParams.height = statusBarHeight;
                if (statusBarHeight < 0) {
                    layoutParams.height = 0;
                }
                s0.setLayoutParams(layoutParams);
                ViewGroup.LayoutParams layoutParams2 = u0.getLayoutParams();
                layoutParams2.height = i2;
                if (i2 > UtilHelper.getStatusBarHeight()) {
                    layoutParams2.height = UtilHelper.getStatusBarHeight();
                }
                u0.setLayoutParams(layoutParams2);
            }
        }
    }

    public void h1(l25 l25Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048663, this, l25Var) == null) {
            k46 k46Var = new k46(this.a.getPageContext(), 1);
            k46Var.j(this.u);
            HashMap hashMap = new HashMap();
            hashMap.put("forum_name", this.a.v());
            hashMap.put("forum_id", this.a.w());
            k46Var.k(hashMap);
            k46Var.i(l25Var);
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016516, k46Var));
        }
    }

    public void A0() {
        FrameLayout frameLayout;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && this.n != null && (frameLayout = this.o) != null) {
            frameLayout.setVisibility(8);
        }
    }

    public void B0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.H = false;
            this.u.setNextPage(null);
        }
    }

    public final boolean D0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            fx7 fx7Var = this.k0;
            if (fx7Var != null && fx7Var.Z()) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public void F0() {
        ix7 ix7Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048586, this) == null) && (ix7Var = this.w) != null) {
            ix7Var.n();
        }
    }

    public void G0() {
        ix7 ix7Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048588, this) == null) && (ix7Var = this.w) != null) {
            ix7Var.o();
        }
    }

    public boolean J0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) {
            if (this.n == null || this.q.getVisibility() != 0) {
                return false;
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    public final boolean K0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) {
            return SharedPrefHelper.getInstance().getBoolean("key_reaction_guide_show_number", false);
        }
        return invokeV.booleanValue;
    }

    public boolean L0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048598, this)) == null) {
            if (this.t.c().getParent() != null && this.H) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public boolean M0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048600, this)) == null) {
            FrsMoveAreaBottomMenuView frsMoveAreaBottomMenuView = this.m0;
            if (frsMoveAreaBottomMenuView != null && frsMoveAreaBottomMenuView.b()) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public boolean N0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048603, this)) == null) {
            ix7 ix7Var = this.w;
            if (ix7Var != null) {
                return ix7Var.j() instanceof FrsNewAreaFragment;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public boolean O0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048606, this)) == null) {
            bx7 bx7Var = this.L;
            if (bx7Var == null) {
                return false;
            }
            return bx7Var.n();
        }
        return invokeV.booleanValue;
    }

    public void P0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048609, this) == null) {
            dn7 dn7Var = this.v;
            if (dn7Var instanceof pm7) {
                ((pm7) dn7Var).q();
            }
        }
    }

    public void P1() {
        ix7 ix7Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048610, this) == null) && (ix7Var = this.w) != null) {
            ix7Var.w();
        }
    }

    public void Q0() {
        dn7 dn7Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048612, this) == null) && (dn7Var = this.v) != null) {
            dn7Var.notifyDataSetChanged();
        }
    }

    public void S() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048617, this) == null) {
            this.w.h();
        }
    }

    public void S0() {
        sya syaVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048618, this) == null) && (syaVar = this.u0) != null) {
            syaVar.d();
        }
    }

    public final void T() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048620, this) == null) {
            ImageView imageView = this.k;
            if (imageView != null) {
                imageView.setVisibility(0);
            }
            ImageView imageView2 = this.j;
            if (imageView2 != null) {
                imageView2.setVisibility(0);
            }
        }
    }

    public void T1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048622, this) == null) {
            this.u.setVisibility(0);
        }
    }

    public void U1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048625, this) == null) {
            this.H = true;
            this.u.setNextPage(this.t);
            int i2 = this.I;
            if (i2 > 0) {
                this.t.P(i2);
            }
            this.t.G(null);
            this.t.U();
        }
    }

    public void V() {
        FrsMultiDelBottomMenuView frsMultiDelBottomMenuView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048626, this) == null) && (frsMultiDelBottomMenuView = this.l0) != null) {
            frsMultiDelBottomMenuView.a();
        }
    }

    public void W() {
        FrsMultiDelBottomMenuView frsMultiDelBottomMenuView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048629, this) == null) && (frsMultiDelBottomMenuView = this.l0) != null) {
            frsMultiDelBottomMenuView.b();
        }
    }

    public View Y() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048635, this)) == null) {
            return this.e;
        }
        return (View) invokeV.objValue;
    }

    public void Y0() {
        xt6 xt6Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048636, this) == null) && (xt6Var = this.i) != null) {
            xt6Var.d();
        }
    }

    public void Y1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048637, this) == null) {
            U();
            z45 z45Var = this.x;
            if (z45Var != null) {
                z45Var.m();
            }
        }
    }

    public View Z() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048638, this)) == null) {
            return this.E;
        }
        return (View) invokeV.objValue;
    }

    public void Z0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048639, this) == null) {
            bx7 bx7Var = this.L;
            if (bx7Var != null) {
                bx7Var.q();
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016524));
        }
    }

    public dn7 a0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048641, this)) == null) {
            return this.v;
        }
        return (dn7) invokeV.objValue;
    }

    public ix7 b0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048644, this)) == null) {
            return this.w;
        }
        return (ix7) invokeV.objValue;
    }

    public void b1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048645, this) == null) {
            O(TbadkCoreApplication.getInst().getSkinType());
            bx7 bx7Var = this.L;
            if (bx7Var != null) {
                bx7Var.r();
            }
        }
    }

    public bx7 c0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048647, this)) == null) {
            return this.L;
        }
        return (bx7) invokeV.objValue;
    }

    public void c2() {
        ix7 ix7Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048649, this) == null) && (ix7Var = this.w) != null) {
            ix7Var.x();
        }
    }

    public final int d0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048650, this)) == null) {
            if (!UtilHelper.canUseStyleImmersiveSticky()) {
                return 0;
            }
            return UtilHelper.getStatusBarHeight();
        }
        return invokeV.intValue;
    }

    public boolean e0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048653, this)) == null) {
            ix7 ix7Var = this.w;
            if (ix7Var == null) {
                return false;
            }
            return ix7Var.l();
        }
        return invokeV.booleanValue;
    }

    public void e2() {
        ix7 ix7Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048655, this) == null) && (ix7Var = this.w) != null) {
            ix7Var.y();
        }
    }

    public void f1() {
        ix7 ix7Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048656, this) == null) && (ix7Var = this.w) != null) {
            ix7Var.x();
        }
    }

    public BdTypeRecyclerView g0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048658, this)) == null) {
            return this.u;
        }
        return (BdTypeRecyclerView) invokeV.objValue;
    }

    public void g1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048659, this) == null) {
            I0(this.Z, this.a.A4());
            dn7 dn7Var = this.v;
            if (dn7Var != null) {
                dn7Var.e();
            }
        }
    }

    public Context getContext() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048661, this)) == null) {
            FrsFragment frsFragment = this.a;
            if (frsFragment != null && frsFragment.u() != null) {
                return this.a.u().getPageActivity();
            }
            return null;
        }
        return (Context) invokeV.objValue;
    }

    public View h0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048662, this)) == null) {
            PbListView pbListView = this.t;
            if (pbListView == null) {
                return null;
            }
            return pbListView.c();
        }
        return (View) invokeV.objValue;
    }

    public View i0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048665, this)) == null) {
            xt6 xt6Var = this.i;
            if (xt6Var != null) {
                return xt6Var.c();
            }
            return null;
        }
        return (View) invokeV.objValue;
    }

    @NonNull
    public it7 j0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048668, this)) == null) {
            return this.C;
        }
        return (it7) invokeV.objValue;
    }

    public void j1() {
        NoNetworkView noNetworkView;
        NoNetworkView.b bVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048669, this) == null) && (noNetworkView = this.A) != null && (bVar = this.z) != null) {
            noNetworkView.removeNetworkChangeListener(bVar);
        }
    }

    public NavigationBar k0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048670, this)) == null) {
            return this.B;
        }
        return (NavigationBar) invokeV.objValue;
    }

    public void k1() {
        FrsMoveAreaBottomMenuView frsMoveAreaBottomMenuView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048671, this) == null) && (frsMoveAreaBottomMenuView = this.m0) != null) {
            frsMoveAreaBottomMenuView.d();
        }
    }

    public final int l0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048672, this)) == null) {
            NavigationBar navigationBar = this.B;
            if (navigationBar == null) {
                return 0;
            }
            return navigationBar.getHeight();
        }
        return invokeV.intValue;
    }

    public boolean l1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048673, this)) == null) {
            if (this.G) {
                return false;
            }
            this.t.H(this.a.getResources().getString(R.string.obfuscated_res_0x7f0f0bff));
            this.t.g();
            return true;
        }
        return invokeV.booleanValue;
    }

    public ObservedChangeLinearLayout m0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048674, this)) == null) {
            return this.W;
        }
        return (ObservedChangeLinearLayout) invokeV.objValue;
    }

    public final int n0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048676, this)) == null) {
            if (this.A != null && !BdNetTypeUtil.isNetWorkAvailable()) {
                return this.A.getHeight();
            }
            return 0;
        }
        return invokeV.intValue;
    }

    public void n1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048677, this) == null) {
            this.v.notifyDataSetChanged();
        }
    }

    public fz9 o0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048678, this)) == null) {
            return this.R;
        }
        return (fz9) invokeV.objValue;
    }

    public TextView p0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048680, this)) == null) {
            return this.l;
        }
        return (TextView) invokeV.objValue;
    }

    public hn7 q0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048682, this)) == null) {
            return this.M;
        }
        return (hn7) invokeV.objValue;
    }

    public RelativeLayout r0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048684, this)) == null) {
            return this.b;
        }
        return (RelativeLayout) invokeV.objValue;
    }

    public View s0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048686, this)) == null) {
            return this.U;
        }
        return (View) invokeV.objValue;
    }

    public final int t0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048688, this)) == null) {
            View view2 = this.U;
            if (view2 == null) {
                return 0;
            }
            return view2.getHeight();
        }
        return invokeV.intValue;
    }

    public View u0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048690, this)) == null) {
            return this.V;
        }
        return (View) invokeV.objValue;
    }

    public FrameLayout v0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048692, this)) == null) {
            return this.F;
        }
        return (FrameLayout) invokeV.objValue;
    }

    public FrsTopBarGroupEntranceGuideView w0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048694, this)) == null) {
            return this.X;
        }
        return (FrsTopBarGroupEntranceGuideView) invokeV.objValue;
    }

    public ImageView x0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048696, this)) == null) {
            return this.m;
        }
        return (ImageView) invokeV.objValue;
    }

    public ImageView y0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048698, this)) == null) {
            return this.k;
        }
        return (ImageView) invokeV.objValue;
    }

    public ImageView z0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048700, this)) == null) {
            return this.j;
        }
        return (ImageView) invokeV.objValue;
    }

    public final void H0() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048590, this) != null) || this.O != null) {
            return;
        }
        View k4 = this.a.k4();
        this.O = (GifView) k4.findViewById(R.id.obfuscated_res_0x7f090e2c);
        TbImageView tbImageView = (TbImageView) k4.findViewById(R.id.obfuscated_res_0x7f0924b0);
        this.P = tbImageView;
        tbImageView.setPageId(this.a.getUniqueId());
        this.O.setLayerType(1, null);
        this.P.setLayerType(1, null);
    }

    public void Q1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048613, this) == null) {
            this.H = true;
            this.u.setNextPage(this.t);
            this.t.G(this.y);
            int i2 = this.I;
            if (i2 > 0) {
                this.t.P(i2);
            }
            this.t.g();
            this.t.H(this.a.getResources().getString(R.string.list_click_load_more));
        }
    }

    public void R1() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048616, this) != null) || this.n == null) {
            return;
        }
        this.o.setVisibility(0);
        this.q.setVisibility(8);
        this.p.setVisibility(0);
        TbadkCoreApplication.getInst().handler.postDelayed(this.x0, 5000L);
    }

    public boolean X0() {
        InterceptResult invokeV;
        AppBarLayoutStickyBehavior appBarLayoutStickyBehavior;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048633, this)) == null) {
            if (this.c0 != null && (appBarLayoutStickyBehavior = this.d0) != null && appBarLayoutStickyBehavior.isSticky()) {
                BdTypeRecyclerView bdTypeRecyclerView = this.u;
                if (bdTypeRecyclerView != null) {
                    bdTypeRecyclerView.setSelection(0);
                }
                this.d0.expandedAppBarLayout(this.c0);
                return true;
            }
            bx7 bx7Var = this.L;
            if (bx7Var != null && bx7Var.t()) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public void X1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048634, this) == null) {
            this.H = false;
            this.u.setNextPage(this.t);
            int i2 = this.I;
            if (i2 > 0) {
                this.t.P(i2);
            }
            this.t.G(null);
            this.t.g();
            this.t.H(this.a.getResources().getString(R.string.list_has_no_more));
        }
    }

    public void e1() {
        hn7 hn7Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048654, this) == null) {
            if (this.a0 && (hn7Var = this.M) != null) {
                hn7Var.b(false, false);
            }
            V1(8);
            ImageView imageView = this.k;
            if (imageView != null) {
                imageView.setVisibility(8);
            }
            ImageView imageView2 = this.j;
            if (imageView2 != null) {
                imageView2.setVisibility(8);
            }
            ImageView imageView3 = this.m;
            if (imageView3 != null) {
                imageView3.setVisibility(8);
            }
            b2(false);
            this.u.setVisibility(8);
            this.e0.setVisibility(8);
        }
    }

    public void m1() {
        hn7 hn7Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048675, this) == null) {
            if (this.a0 && (hn7Var = this.M) != null) {
                hn7Var.b(true, false);
            }
            V1(0);
            T();
            b2(this.a.F3());
            this.u.setVisibility(0);
            this.e0.setVisibility(0);
        }
    }

    public final void I0(fn7 fn7Var, boolean z) {
        boolean z2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048592, this, fn7Var, z) == null) {
            this.Z = fn7Var;
            View k4 = this.a.k4();
            if (this.b == null) {
                this.b = (NoPressedRelativeLayout) k4.findViewById(R.id.obfuscated_res_0x7f090c50);
            }
            if (this.d == null) {
                this.d = k4.findViewById(R.id.obfuscated_res_0x7f090c89);
            }
            if (this.c == null) {
                this.c = (CoordinatorLayout) k4.findViewById(R.id.obfuscated_res_0x7f090d40);
            }
            if (this.E == null) {
                this.E = k4.findViewById(R.id.obfuscated_res_0x7f090d1a);
            }
            if (this.F == null) {
                this.F = (FrameLayout) k4.findViewById(R.id.obfuscated_res_0x7f090d87);
            }
            if (this.f0 == null) {
                this.f0 = (CollapsingToolbarLayout) k4.findViewById(R.id.obfuscated_res_0x7f090c87);
            }
            if (this.e0 == null) {
                this.e0 = (FrsHeaderViewContainer) k4.findViewById(R.id.obfuscated_res_0x7f090f32);
            }
            if (this.w == null) {
                this.w = new ix7(this.a);
            }
            if (this.W == null) {
                ObservedChangeLinearLayout observedChangeLinearLayout = (ObservedChangeLinearLayout) k4.findViewById(R.id.obfuscated_res_0x7f091916);
                this.W = observedChangeLinearLayout;
                observedChangeLinearLayout.setOnSizeChangeListener(new j(this));
                if (this.X == null) {
                    this.X = (FrsTopBarGroupEntranceGuideView) this.W.findViewById(R.id.obfuscated_res_0x7f09268f);
                }
            }
            this.C.h(this.a, k4, this.y);
            if (this.B == null) {
                this.B = this.C.e();
                z2 = true;
            } else {
                z2 = false;
            }
            if (this.a.A4()) {
                this.B.setVisibility(8);
            }
            if (this.D == null) {
                this.D = k4.findViewById(R.id.obfuscated_res_0x7f090d3f);
                gn7 c2 = fn7Var.c();
                if (c2 != null) {
                    c2.b(this.D);
                }
            }
            if (this.e == null) {
                this.e = (View) this.C.a(LogicField.BACK_BTN);
                this.f = (ImageView) this.C.a(LogicField.BACK_IV);
            }
            if (this.k == null) {
                this.k = (ImageView) this.C.a(LogicField.SEARCH_BTN);
            }
            if (this.i == null) {
                this.i = (xt6) this.C.a(LogicField.MESSAGE_ICON_CONTROLLER);
                this.g = (ImageView) this.C.a(LogicField.MESSAGE_BTN);
                this.h = (MessageRedDotView) this.C.a(LogicField.MESSAGE_RED_DOT);
                this.i.j(this.C.e());
            }
            if (this.j == null) {
                this.j = (ImageView) this.C.a(LogicField.SHARE_BTN);
            }
            if (this.m == null) {
                ImageView imageView = (ImageView) this.C.a(LogicField.GROUP_BTN);
                this.m = imageView;
                if (imageView != null) {
                    imageView.setVisibility(8);
                }
            }
            if (this.l == null) {
                TextView textView = (TextView) this.B.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_ABSOLUTE_CENTER, R.layout.obfuscated_res_0x7f0d039e, (View.OnClickListener) null);
                this.l = textView;
                textView.setVisibility(8);
                Drawable drawable = SkinManager.getDrawable(R.drawable.icon_arrow12_white);
                int dimens = BdUtilHelper.getDimens(this.a.getActivity(), R.dimen.tbds31);
                drawable.setBounds(0, 0, dimens, dimens);
                this.l.setCompoundDrawables(null, null, drawable, null);
                SkinManager.setBackgroundResourceSelector(this.l, R.drawable.bg_frs_private_status_n, R.drawable.bg_frs_private_status_s);
                SkinManager.setViewTextColor(this.l, (int) R.color.CAM_X0101);
            }
            if (z2) {
                this.B.onChangeSkinType(this.a.getPageContext(), TbadkCoreApplication.getInst().getSkinType());
                SkinManager.setBackgroundColor(this.B.getBottomLine(), R.color.CAM_X0204);
            }
            if (this.u == null) {
                this.u = (BdTypeRecyclerView) k4.findViewById(R.id.obfuscated_res_0x7f090d24);
            }
            k kVar = new k(this);
            kVar.setSupportsChangeAnimations(false);
            this.u.setItemAnimator(kVar);
            BdTypeRecyclerView bdTypeRecyclerView = this.u;
            bdTypeRecyclerView.setLayoutManager(new l(this, bdTypeRecyclerView.getContext()));
            if (TbSingleton.getInstance().isSlideAnimEnable()) {
                an anVar = new an(new ym());
                this.t0 = anVar;
                anVar.q(this.u, 2);
            }
            this.u.setScrollable(this.a);
            this.u.setFadingEdgeLength(0);
            this.u.setOverScrollMode(2);
            this.b.setBottomOrderView(this.u);
            this.u.setOnTouchListener(this.a.V1);
            this.u.setRecyclerListener(new m(this));
            int dimenPixelSize = UtilHelper.getDimenPixelSize(R.dimen.M_W_X004);
            BdTypeRecyclerView bdTypeRecyclerView2 = this.u;
            bdTypeRecyclerView2.setPadding(dimenPixelSize, bdTypeRecyclerView2.getPaddingTop(), dimenPixelSize, this.u.getPaddingBottom());
            if (this.t == null) {
                PbListView pbListView = new PbListView(this.a.getPageContext().getPageActivity());
                this.t = pbListView;
                pbListView.c();
            }
            this.t.s(R.color.transparent);
            this.t.w(BdUtilHelper.getDimens(this.a.getActivity(), R.dimen.tbds182));
            this.t.B();
            this.t.L(R.dimen.tbfontsize33);
            this.t.J(SkinManager.getColor(R.color.CAM_X0109));
            this.t.F(R.color.CAM_X0110);
            this.u.setOnSrollToBottomListener(this.a);
            this.B.setOnClickListener(new n(this));
            boolean isShowBigImage = TbImageHelper.getInstance().isShowBigImage();
            if (this.v == null) {
                this.v = fn7Var.b(this.a, this.u, isShowBigImage);
            }
            ix7 ix7Var = this.w;
            if (ix7Var != null) {
                ix7Var.u(1, false);
            }
            if (!z) {
                if (this.A == null) {
                    this.A = new NoNetworkView(this.a.getActivity());
                    this.A.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
                    this.W.addView(this.A);
                }
                if (BdNetTypeUtil.isNetworkAvailableForImmediately()) {
                    this.A.setVisibility(8);
                } else {
                    this.A.setVisibility(0);
                }
                this.A.onChangeSkinType(this.a.getPageContext(), TbadkCoreApplication.getInst().getSkinType());
            }
            H0();
            if (this.L == null) {
                bx7 a2 = fn7Var.a(this.a, this.b);
                this.L = a2;
                a2.w(this.a.p4());
            }
            if (this.M == null) {
                this.M = fn7Var.d(this.a, this.b);
                u1(true);
            }
            if (this.U == null) {
                this.U = k4.findViewById(R.id.obfuscated_res_0x7f092319);
            }
            if (this.V == null) {
                this.V = k4.findViewById(R.id.obfuscated_res_0x7f09231a);
            }
            if (this.R == null) {
                this.R = new fz9(this.a.getPageContext(), this.u);
            }
            this.R.p(2);
            this.R.u(this.a.getUniqueId());
            if (this.u0 == null) {
                this.u0 = new sya(this.a.getPageContext(), this.u);
            }
            NavigationBarCoverTip navigationBarCoverTip = (NavigationBarCoverTip) k4.findViewById(R.id.obfuscated_res_0x7f091919);
            this.n0 = navigationBarCoverTip;
            if (this.N == null) {
                this.N = new kx7(this.a, navigationBarCoverTip);
            }
            if (this.c0 == null) {
                AppBarLayout appBarLayout = (AppBarLayout) k4.findViewById(R.id.obfuscated_res_0x7f090c63);
                this.c0 = appBarLayout;
                appBarLayout.addOnOffsetChangedListener(this.w0);
                this.g0 = true;
                this.h0 = -1;
                CoordinatorLayout.LayoutParams layoutParams = (CoordinatorLayout.LayoutParams) this.c0.getLayoutParams();
                if (layoutParams.getBehavior() instanceof AppBarLayoutStickyBehavior) {
                    this.d0 = (AppBarLayoutStickyBehavior) layoutParams.getBehavior();
                }
            }
            FrsMultiDelBottomMenuView frsMultiDelBottomMenuView = (FrsMultiDelBottomMenuView) k4.findViewById(R.id.obfuscated_res_0x7f090d38);
            this.l0 = frsMultiDelBottomMenuView;
            frsMultiDelBottomMenuView.setPageContext(this.a.getPageContext());
            FrsMoveAreaBottomMenuView frsMoveAreaBottomMenuView = (FrsMoveAreaBottomMenuView) k4.findViewById(R.id.obfuscated_res_0x7f090d35);
            this.m0 = frsMoveAreaBottomMenuView;
            frsMoveAreaBottomMenuView.setPageContext(this.a.getPageContext());
            if (this.p0 == null) {
                this.p0 = (TextView) this.C.a(LogicField.FOLD_TITLE);
            }
            ExposeTagViewCoordinatorLayout exposeTagViewCoordinatorLayout = (ExposeTagViewCoordinatorLayout) k4.findViewById(R.id.obfuscated_res_0x7f090d40);
            this.r = exposeTagViewCoordinatorLayout;
            exposeTagViewCoordinatorLayout.setListener(new o(this));
            FrsTabViewPager frsTabViewPager = (FrsTabViewPager) k4.findViewById(R.id.obfuscated_res_0x7f090d9c);
            this.s = frsTabViewPager;
            frsTabViewPager.addOnPageChangeListener(new p(this));
        }
    }

    public void M1(ArrayList<cn> arrayList, FrsViewData frsViewData) {
        int i2;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLL(1048601, this, arrayList, frsViewData) != null) || frsViewData == null) {
            return;
        }
        ArrayList<cn> switchThreadDataToThreadCardInfo = frsViewData.switchThreadDataToThreadCardInfo();
        if (ListUtils.isEmpty(switchThreadDataToThreadCardInfo) || !frsViewData.mHasThreadExceptTop) {
            ni7 ni7Var = new ni7();
            ArrayList<cn> arrayList2 = new ArrayList<>();
            arrayList2.add(ni7Var);
            FrsFragment frsFragment = this.a;
            if (frsFragment != null && frsFragment.f1() != null && this.a.f1().m0() == 0) {
                ni7Var.b(this.a.f1().h0());
            }
            switchThreadDataToThreadCardInfo = arrayList2;
        }
        if (ListUtils.getCount(switchThreadDataToThreadCardInfo) > 0) {
            for (int i3 = 0; i3 < switchThreadDataToThreadCardInfo.size(); i3++) {
                cn cnVar = switchThreadDataToThreadCardInfo.get(i3);
                if (cnVar instanceof h45) {
                    ((h45) cnVar).t.setSmartFrsPosition(i3);
                }
            }
        }
        this.v.g(switchThreadDataToThreadCardInfo, frsViewData);
        fz9 fz9Var = this.R;
        if (fz9Var != null && (i2 = this.S) != 0) {
            fz9Var.n(i2, this.f1128T, this.J, true);
        }
        FrsFragment frsFragment2 = this.a;
        if (frsFragment2 != null) {
            frsFragment2.p5();
        }
        FrsMultiDelBottomMenuView frsMultiDelBottomMenuView = this.l0;
        if (frsMultiDelBottomMenuView != null) {
            frsMultiDelBottomMenuView.setFrsViewData(frsViewData);
        }
        sya syaVar = this.u0;
        if (syaVar != null) {
            syaVar.i(2000);
        }
    }

    public final void Q(AppBarLayout appBarLayout, int i2) {
        FrsFragment frsFragment;
        ViewGroup.MarginLayoutParams marginLayoutParams;
        boolean z;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLI(1048611, this, appBarLayout, i2) == null) && (frsFragment = this.a) != null && appBarLayout != null && frsFragment.m4() != null && this.a.getPageContext() != null) {
            int d0 = d0() + l0() + n0();
            int totalScrollRange = (appBarLayout.getTotalScrollRange() - Math.abs(i2)) + this.C.g();
            FrsTabViewController m4 = this.a.m4();
            ViewGroup.LayoutParams layoutParams = this.d.getLayoutParams();
            if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
            } else {
                marginLayoutParams = new ViewGroup.MarginLayoutParams(layoutParams);
            }
            FrsFragment frsFragment2 = this.a;
            if (frsFragment2 != null && frsFragment2.J4()) {
                z = true;
            } else {
                z = false;
            }
            if (totalScrollRange <= 0) {
                if (this.r0 != 2) {
                    m4.f(2);
                }
                this.r0 = 2;
                marginLayoutParams.topMargin = 0;
            } else if (totalScrollRange > 0 && totalScrollRange < d0) {
                if (this.r0 != 1) {
                    m4.f(1);
                }
                this.r0 = 1;
                marginLayoutParams.topMargin = 0;
            } else {
                if (this.r0 != 0) {
                    m4.f(0);
                }
                this.r0 = 0;
                if (z) {
                    marginLayoutParams.topMargin = BdUtilHelper.getDimens(this.a.getActivity(), R.dimen.tbds_30);
                } else {
                    marginLayoutParams.topMargin = 0;
                }
            }
            if (z) {
                this.d.setLayoutParams(marginLayoutParams);
            }
        }
    }

    public void W1(String str, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048631, this, str, i2) == null) {
            if (this.o0 == null) {
                TextView textView = new TextView(this.a.getActivity());
                this.o0 = textView;
                textView.setGravity(19);
                this.o0.setPadding(BdUtilHelper.getDimens(this.a.getActivity(), R.dimen.obfuscated_res_0x7f07020f), 0, BdUtilHelper.getDimens(this.a.getActivity(), R.dimen.obfuscated_res_0x7f07020f), 0);
                this.o0.setLayoutParams(new ViewGroup.LayoutParams(-1, BdUtilHelper.getDimens(this.a.getActivity(), R.dimen.tbds112)));
                this.o0.setTextSize(0, BdUtilHelper.getDimens(this.a.getActivity(), R.dimen.obfuscated_res_0x7f07045e));
                this.o0.setMaxLines(2);
                this.o0.setEllipsize(TextUtils.TruncateAt.valueOf("END"));
                this.o0.setTextColor(ContextCompat.getColor(this.a.getActivity(), R.color.CAM_X0101));
            }
            this.n0.setBackgroundColor(i2);
            this.o0.setText(str);
            this.n0.k(this.a.getActivity(), this.o0, 5000);
        }
    }

    public void N1(String str) {
        TextView textView;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048604, this, str) != null) || (textView = this.p0) == null || !TextUtils.isEmpty(textView.getText())) {
            return;
        }
        if (TextUtils.isEmpty(str)) {
            this.p0.setText("");
            return;
        }
        this.p0.setText(f0(str));
        m05.c().h(str);
    }

    public void O1() {
        NavigationBar navigationBar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048607, this) == null) && (navigationBar = this.B) != null && navigationBar.getBarBgView() != null && this.W != null) {
            x1();
            if (this.Y) {
                this.B.getBarBgView().setAlpha(0.0f);
                this.B.hideBottomLine();
            } else {
                View view2 = this.U;
                if (view2 != null) {
                    view2.setAlpha(1.0f);
                }
                View view3 = this.V;
                if (view3 != null) {
                    view3.setAlpha(1.0f);
                }
                TextView textView = this.p0;
                if (textView != null) {
                    textView.setAlpha(0.0f);
                }
                this.B.getBarBgView().setAlpha(1.0f);
                this.B.showBottomLine();
            }
            V0(this.j0);
        }
    }

    public final int X() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048632, this)) == null) {
            AppBarLayout appBarLayout = this.c0;
            if (appBarLayout == null) {
                return this.h0;
            }
            int i2 = this.h0;
            if (i2 != -1) {
                return i2;
            }
            int i3 = 0;
            for (int childCount = appBarLayout.getChildCount() - 1; childCount >= 0; childCount--) {
                View childAt = this.c0.getChildAt(childCount);
                if (childAt != null) {
                    int scrollFlags = ((AppBarLayout.LayoutParams) childAt.getLayoutParams()).getScrollFlags();
                    if ((scrollFlags & 5) == 5) {
                        if ((scrollFlags & 8) != 0) {
                            i3 += ViewCompat.getMinimumHeight(childAt);
                        }
                    } else if (i3 > 0) {
                        break;
                    }
                }
            }
            int max = Math.max(0, this.c0.getTotalScrollRange() - Math.abs(i3));
            this.h0 = max;
            return max;
        }
        return invokeV.intValue;
    }

    public final void x1() {
        ViewGroup.LayoutParams layoutParams;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048697, this) == null) {
            this.Y = D0();
            FrsHeaderViewContainer frsHeaderViewContainer = this.e0;
            if (frsHeaderViewContainer != null && (layoutParams = frsHeaderViewContainer.getLayoutParams()) != null && (layoutParams instanceof ViewGroup.MarginLayoutParams)) {
                if (this.Y) {
                    ((ViewGroup.MarginLayoutParams) layoutParams).setMargins(0, 0, 0, 0);
                } else {
                    ((ViewGroup.MarginLayoutParams) layoutParams).setMargins(0, BdUtilHelper.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.obfuscated_res_0x7f070424) + d0(), 0, 0);
                }
                this.e0.requestLayout();
            }
        }
    }

    public final void P(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048608, this, i2) == null) {
            NavigationBar navigationBar = this.B;
            if (navigationBar != null) {
                navigationBar.onChangeSkinType(this.a.getPageContext(), i2);
                if (this.B.getBackground() != null && this.B.getBackground().mutate() != null) {
                    this.B.getBackground().mutate().setAlpha(0);
                }
                SkinManager.setBackgroundColor(this.B.getBarBgView(), R.color.CAM_X0207);
                SkinManager.setBackgroundColor(this.B.getBottomLine(), R.color.CAM_X0204);
                SkinManager.setBackgroundColor(this.D, R.color.CAM_X0204, i2);
                xt6 xt6Var = this.i;
                if (xt6Var != null) {
                    xt6Var.e(i2);
                }
                if (this.k != null) {
                    SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.k, R.drawable.ic_icon_pure_topbar_search40_svg, R.color.CAM_X0106, SvgManager.SvgResourceStateType.NORMAL_PRESS);
                }
                if (this.j != null) {
                    SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.j, R.drawable.ic_icon_pure_topbar_share40_svg, R.color.CAM_X0106, SvgManager.SvgResourceStateType.NORMAL_PRESS);
                }
                i2(R.color.CAM_X0106);
            }
            SkinManager.setBackgroundColor(this.U, R.color.CAM_X0207);
            SkinManager.setBackgroundColor(this.V, R.color.CAM_X0207);
            g2(true);
        }
    }

    public void S1(s45 s45Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048619, this, s45Var) == null) {
            if (this.n == null) {
                View k4 = this.a.k4();
                ViewStub viewStub = (ViewStub) k4.findViewById(R.id.obfuscated_res_0x7f092ae9);
                this.n = viewStub;
                viewStub.setVisibility(0);
                this.o = (FrameLayout) k4.findViewById(R.id.obfuscated_res_0x7f090ddb);
                this.p = (TbImageView) k4.findViewById(R.id.obfuscated_res_0x7f090dda);
                this.q = (TbImageView) k4.findViewById(R.id.obfuscated_res_0x7f090ddc);
                this.p.setPageId(this.a.getUniqueId());
                this.q.setPageId(this.a.getUniqueId());
                this.p.setDefaultBgResource(R.color.common_color_10022);
                this.p.setDefaultResource(0);
                this.q.setDefaultBgResource(R.color.common_color_10022);
                this.q.setDefaultResource(0);
                this.o.setOnClickListener(this.y);
            }
            this.o.setVisibility(0);
            String a2 = s45Var.a();
            String b2 = s45Var.b();
            this.p.startLoad(a2, 10, false);
            this.q.startLoad(b2, 10, false);
            TbadkCoreApplication.getInst().handler.postDelayed(this.x0, 5000L);
        }
    }

    public final void g2(boolean z) {
        NavigationBar navigationBar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048660, this, z) == null) && (navigationBar = this.B) != null && navigationBar.getBarBgView() != null && this.Y) {
            if (this.B.getBarBgView().getAlpha() < 0.5f) {
                if (z || this.q0 != 0) {
                    SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.f, R.drawable.ic_icon_pure_topbar_return40_svg, R.color.CAM_X0101, SvgManager.SvgResourceStateType.NORMAL_PRESS);
                    SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.k, R.drawable.ic_icon_pure_topbar_search40_svg, R.color.CAM_X0101, SvgManager.SvgResourceStateType.NORMAL_PRESS);
                    ImageView imageView = this.g;
                    if (imageView != null) {
                        imageView.setImageDrawable(WebPManager.getPureDrawable(R.drawable.icon_pure_topbar_information40, SkinManager.getColor(R.color.CAM_X0101), null));
                    }
                    i2(R.color.CAM_X0101);
                    SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.j, R.drawable.ic_icon_pure_topbar_share40_svg, R.color.CAM_X0101, SvgManager.SvgResourceStateType.NORMAL_PRESS);
                    this.q0 = 0;
                }
            } else if (z || this.q0 != 1) {
                SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.f, R.drawable.ic_icon_pure_topbar_return40_svg, R.color.CAM_X0106, SvgManager.SvgResourceStateType.NORMAL_PRESS);
                SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.k, R.drawable.ic_icon_pure_topbar_search40_svg, R.color.CAM_X0106, SvgManager.SvgResourceStateType.NORMAL_PRESS);
                ImageView imageView2 = this.g;
                if (imageView2 != null) {
                    imageView2.setImageDrawable(WebPManager.getPureDrawable(R.drawable.icon_pure_topbar_information40, SkinManager.getColor(R.color.CAM_X0106), null));
                }
                i2(R.color.CAM_X0106);
                FrsTopBarGroupEntranceGuideView frsTopBarGroupEntranceGuideView = this.X;
                if (frsTopBarGroupEntranceGuideView != null) {
                    frsTopBarGroupEntranceGuideView.a();
                }
                SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.j, R.drawable.ic_icon_pure_topbar_share40_svg, R.color.CAM_X0106, SvgManager.SvgResourceStateType.NORMAL_PRESS);
                this.q0 = 1;
            }
            f2();
        }
    }

    public void T0(int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048621, this, i2, i3) == null) {
            sya syaVar = this.u0;
            if (syaVar != null) {
                syaVar.i(100);
            }
            if (this.u0 != null && !K0()) {
                this.u0.g();
            }
            fz9 fz9Var = this.R;
            if (fz9Var == null) {
                return;
            }
            fz9Var.m(i2, i3, this.J, 1);
            this.R.p(2);
            this.R.q(false);
        }
    }

    public final void U() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048623, this) == null) && this.x == null && this.a.getPageContext() != null) {
            String[] strArr = {this.a.getPageContext().getPageActivity().getString(R.string.take_photo), this.a.getPageContext().getPageActivity().getString(R.string.obfuscated_res_0x7f0f0281)};
            z45 z45Var = new z45(this.a.getPageContext().getPageActivity());
            this.x = z45Var;
            z45Var.l(this.a.getPageContext().getPageActivity().getString(R.string.obfuscated_res_0x7f0f0f1c));
            this.x.j(strArr, new b(this));
            this.x.c(this.a.getPageContext());
        }
    }

    public void W0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048630, this) == null) {
            MessageManager.getInstance().unRegisterListener(this.v0);
            fz9 fz9Var = this.R;
            if (fz9Var != null) {
                fz9Var.h();
            }
            kx7 kx7Var = this.N;
            if (kx7Var != null) {
                kx7Var.c();
            }
            FrsMultiDelBottomMenuView frsMultiDelBottomMenuView = this.l0;
            if (frsMultiDelBottomMenuView != null) {
                frsMultiDelBottomMenuView.setPageContext(null);
            }
            FrsMoveAreaBottomMenuView frsMoveAreaBottomMenuView = this.m0;
            if (frsMoveAreaBottomMenuView != null) {
                frsMoveAreaBottomMenuView.setPageContext(null);
            }
            this.v.onDestory();
            this.u.setOnSrollToBottomListener(null);
            this.u.setScrollable(null);
            this.u.setItemAnimator(null);
            TbadkCoreApplication.getInst().handler.removeCallbacks(this.x0);
            CommonTipView commonTipView = this.K;
            if (commonTipView != null) {
                commonTipView.i();
            }
            this.Q.clear();
            bx7 bx7Var = this.L;
            if (bx7Var != null) {
                bx7Var.p();
            }
            mra mraVar = this.b0;
            if (mraVar != null) {
                mraVar.e();
            }
            NavigationBarCoverTip navigationBarCoverTip = this.n0;
            if (navigationBarCoverTip != null) {
                navigationBarCoverTip.f();
            }
            FrsMultiDelBottomMenuView frsMultiDelBottomMenuView2 = this.l0;
            if (frsMultiDelBottomMenuView2 != null) {
                frsMultiDelBottomMenuView2.e();
            }
            ix7 ix7Var = this.w;
            if (ix7Var != null) {
                ix7Var.q();
            }
            ix7 ix7Var2 = this.w;
            if (ix7Var2 != null) {
                ix7Var2.s(null);
            }
        }
    }

    public void a2() {
        int headerViewsCount;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048643, this) == null) && SharedPrefHelper.getInstance().getLong("frs_video_activity_guide", 0L) == 0 && !this.y0 && this.a.getActivity() != null && this.a.getPageContext() != null) {
            View view2 = null;
            BdTypeRecyclerView bdTypeRecyclerView = this.u;
            if (bdTypeRecyclerView != null && (headerViewsCount = bdTypeRecyclerView.getHeaderViewsCount()) < this.u.getChildCount()) {
                view2 = this.u.getChildAt(headerViewsCount);
            }
            if (view2 != null) {
                ff ffVar = new ff();
                ffVar.k(view2);
                ffVar.c(0);
                ffVar.j(true);
                ffVar.i(false);
                ffVar.d(true);
                ffVar.a(new d(this));
                ffVar.h(new e(this));
                ef b2 = ffVar.b();
                b2.k(false);
                b2.m(this.a.getActivity());
                SafeHandler.getInst().postDelayed(new f(this, b2), 4000L);
                this.y0 = true;
            }
        }
    }

    public void c1() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048648, this) != null) || a0() == null) {
            return;
        }
        List<cn> f2 = a0().f();
        if (ListUtils.isEmpty(f2)) {
            return;
        }
        for (cn cnVar : f2) {
            if (cnVar instanceof h45) {
                h45 h45Var = (h45) cnVar;
                if (h45Var.u != 0 && h45Var.t != null && this.a.f1() != null && this.a.f1().u0() != null) {
                    int[] imageWidthAndHeight = h45Var.t.getImageWidthAndHeight();
                    h45Var.u = imageWidthAndHeight[0];
                    h45Var.v = imageWidthAndHeight[1];
                }
            }
        }
        SafeHandler.getInst().postDelayed(new g(this), 500L);
    }

    public void V0(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048627, this, i2) == null) {
            this.j0 = i2;
            this.C.onChangeSkinType(i2);
            l46 l46Var = new l46(this.a, 4);
            l46Var.F(i2);
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016515, l46Var));
            k46 k46Var = new k46(this.a.getPageContext(), 4);
            k46Var.l(i2);
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016516, k46Var));
            TbImageView tbImageView = this.P;
            if (tbImageView != null) {
                tbImageView.invalidate();
            }
            dn7 dn7Var = this.v;
            if (dn7Var != null) {
                dn7Var.b();
                this.v.notifyDataSetChanged();
            }
            vt5.a(this.a.getPageContext(), this.b);
            NoNetworkView noNetworkView = this.A;
            if (noNetworkView != null) {
                noNetworkView.onChangeSkinType(this.a.getPageContext(), i2);
            }
            PbListView pbListView = this.t;
            if (pbListView != null) {
                pbListView.J(SkinManager.getColor(R.color.CAM_X0109));
                this.t.e(i2);
            }
            TextView textView = this.p0;
            if (textView != null) {
                textView.setTextColor(SkinManager.getColor(R.color.CAM_X0105));
            }
            O(i2);
            if (j0() != null) {
                j0().onChangeSkinType(i2);
            }
            hn7 hn7Var = this.M;
            if (hn7Var != null) {
                hn7Var.onChangeSkinType(i2);
            }
            bx7 bx7Var = this.L;
            if (bx7Var != null) {
                bx7Var.s(i2);
            }
            FrsMultiDelBottomMenuView frsMultiDelBottomMenuView = this.l0;
            if (frsMultiDelBottomMenuView != null) {
                frsMultiDelBottomMenuView.d();
            }
            FrsMoveAreaBottomMenuView frsMoveAreaBottomMenuView = this.m0;
            if (frsMoveAreaBottomMenuView != null) {
                frsMoveAreaBottomMenuView.c();
            }
            SkinManager.setBackgroundColor(this.d, R.color.CAM_X0202);
        }
    }

    public final void f2() {
        NavigationBar navigationBar;
        float f2;
        float f3;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048657, this) != null) || (navigationBar = this.B) == null) {
            return;
        }
        if (navigationBar.getBarBgView() != null) {
            f2 = this.B.getBarBgView().getAlpha();
        } else {
            f2 = 0.0f;
        }
        if (f2 < 0.5f) {
            f3 = 1.0f - (f2 * 2.0f);
        } else {
            f3 = (f2 * 2.0f) - 1.0f;
        }
        if (Float.compare(f3, 0.0f) < 0) {
            f3 = 0.0f;
        }
        if (Float.compare(f3, 1.0f) > 0) {
            f3 = 1.0f;
        }
        TextView textView = this.p0;
        if (textView != null) {
            textView.setAlpha(f2);
        }
        boolean z = true;
        if (f3 >= 0.0f && f3 <= 1.0f) {
            ImageView imageView = this.f;
            if (imageView != null) {
                imageView.setAlpha(f3);
            }
            ImageView imageView2 = this.g;
            if (imageView2 != null) {
                imageView2.setAlpha(f3);
            }
            FrsFragment frsFragment = this.a;
            if (frsFragment != null && frsFragment.m4() != null && this.q0 == 1) {
                this.a.m4().g0(f3);
            }
            MessageRedDotView messageRedDotView = this.h;
            if (messageRedDotView != null) {
                messageRedDotView.setAlpha(f3);
            }
            xt6 xt6Var = this.i;
            if (xt6Var != null) {
                xt6Var.i(f3);
            }
            ImageView imageView3 = this.k;
            if (imageView3 != null) {
                imageView3.setAlpha(f3);
            }
            ImageView imageView4 = this.j;
            if (imageView4 != null) {
                imageView4.setAlpha(f3);
            }
            ImageView imageView5 = this.m;
            if (imageView5 != null) {
                imageView5.setAlpha(f3);
            }
        }
        TextView textView2 = this.l;
        if (textView2 != null) {
            float f4 = 1.0f - (2.0f * f2);
            textView2.setAlpha(f4);
            TextView textView3 = this.l;
            if (f4 <= 0.0f) {
                z = false;
            }
            textView3.setClickable(z);
        }
        View view2 = this.U;
        if (view2 != null) {
            view2.setAlpha(f2);
        }
        View view3 = this.V;
        if (view3 != null) {
            view3.setAlpha(f2);
        }
        View view4 = this.D;
        if (view4 != null) {
            view4.setAlpha(f2);
        }
    }

    public void h2(@Nullable TopbarEntrance topbarEntrance, boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLZ(1048664, this, topbarEntrance, z) == null) && this.m != null) {
            if (topbarEntrance != null && !TextUtils.isEmpty(topbarEntrance.jump_url)) {
                if (this.m.getVisibility() != 0) {
                    fw7.b(this.a.w());
                }
                this.m.setVisibility(0);
                if (z && dw7.b(this.a.w())) {
                    this.m.post(new a(this, topbarEntrance));
                    return;
                }
                return;
            }
            this.m.setVisibility(8);
        }
    }
}
