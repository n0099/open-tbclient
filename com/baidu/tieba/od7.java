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
import com.baidu.adp.lib.util.BdNetTypeUtil;
import com.baidu.adp.widget.ListView.BdTypeRecyclerView;
import com.baidu.adp.widget.design.behavior.AppBarLayoutStickyBehavior;
import com.baidu.adp.widget.design.behavior.ExposeTagViewCoordinatorLayout;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.core.BaseFragment;
import com.baidu.tbadk.core.TbadkCoreApplication;
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
import com.baidu.tieba.e55;
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
import com.baidu.tieba.l46;
import com.baidu.tieba.mf;
import com.baidu.tieba.tbadkCore.FrsCommonImageLayout;
import com.baidu.tieba.tbadkCore.FrsViewData;
import com.baidu.tieba.tbadkCore.voice.PlayVoiceBnt;
import com.baidu.tieba.tbadkCore.writeModel.PostWriteCallBackData;
import com.baidu.tieba.view.CommonTipView;
import com.baidu.tieba.view.NavigationBarCoverTip;
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
/* loaded from: classes7.dex */
public class od7 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public NoNetworkView A;
    public NavigationBar B;
    @NonNull
    public final zn7 C;
    public View D;
    public View E;
    public FrameLayout F;
    public boolean G;
    public boolean H;
    public int I;
    public boolean J;
    public CommonTipView K;
    public lr7 L;
    public di7 M;
    public ur7 N;
    public GifView O;
    public TbImageView P;
    public HashSet<String> Q;
    public si9 R;
    public int S;

    /* renamed from: T  reason: collision with root package name */
    public int f1144T;
    public View U;
    public View V;
    public ObservedChangeLinearLayout W;
    public FrsTopBarGroupEntranceGuideView X;
    public boolean Y;
    public bi7 Z;
    public FrsFragment a;
    public boolean a0;
    public NoPressedRelativeLayout b;
    public g7a b0;
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
    public nr6 i;
    public int i0;
    public ImageView j;
    public int j0;
    public ImageView k;
    public pr7 k0;
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
    public tn t0;
    public BdTypeRecyclerView u;
    public bea u0;
    public zh7 v;
    public CustomMessageListener v0;
    public sr7 w;
    public AppBarLayout.OnOffsetChangedListener w0;
    public e55 x;
    public Runnable x0;
    public View.OnClickListener y;
    public boolean y0;
    public NoNetworkView.b z;

    /* loaded from: classes7.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ TopbarEntrance a;
        public final /* synthetic */ od7 b;

        public a(od7 od7Var, TopbarEntrance topbarEntrance) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {od7Var, topbarEntrance};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = od7Var;
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
                    if (oq7.d()) {
                        str = this.a.guide_tip_text;
                    } else {
                        str = this.a.guide_tip_first_text;
                    }
                    frsTopBarGroupEntranceGuideView.e(str);
                    oq7.e();
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class b implements e55.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ od7 a;

        public b(od7 od7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {od7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = od7Var;
        }

        @Override // com.baidu.tieba.e55.c
        public void a(e55 e55Var, int i, View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIL(1048576, this, e55Var, i, view2) == null) {
                e55Var.e();
                if (i == 0) {
                    this.a.a.r5();
                } else if (i == 1 && this.a.a.getPageContext() != null) {
                    SelectImageHelper.getAlbumImage(this.a.a.getPageContext().getPageActivity());
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class c implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ od7 a;

        public c(od7 od7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {od7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = od7Var;
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

    /* loaded from: classes7.dex */
    public class d implements kf {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ od7 a;

        @Override // com.baidu.tieba.kf
        public int a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                return 4;
            }
            return invokeV.intValue;
        }

        @Override // com.baidu.tieba.kf
        public int b() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                return 16;
            }
            return invokeV.intValue;
        }

        public d(od7 od7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {od7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = od7Var;
        }

        @Override // com.baidu.tieba.kf
        public View c(LayoutInflater layoutInflater) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, layoutInflater)) == null) {
                View inflate = layoutInflater.inflate(R.layout.tips_blue_left_up, (ViewGroup) null);
                ((TextView) inflate.findViewById(R.id.obfuscated_res_0x7f0924a0)).setText(R.string.obfuscated_res_0x7f0f0872);
                this.a.a.getPageContext().getLayoutMode().k(inflate);
                return inflate;
            }
            return (View) invokeL.objValue;
        }

        @Override // com.baidu.tieba.kf
        public int getXOffset() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
                return vi.g(this.a.a.getActivity(), R.dimen.obfuscated_res_0x7f070353);
            }
            return invokeV.intValue;
        }

        @Override // com.baidu.tieba.kf
        public int getYOffset() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
                return -vi.g(this.a.a.getActivity(), R.dimen.obfuscated_res_0x7f0703fa);
            }
            return invokeV.intValue;
        }
    }

    /* loaded from: classes7.dex */
    public class e implements mf.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        @Override // com.baidu.tieba.mf.a
        public void onShown() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            }
        }

        public e(od7 od7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {od7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // com.baidu.tieba.mf.a
        public void onDismiss() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                n95.m().A("frs_video_activity_guide", 1L);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class f implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ lf a;

        public f(od7 od7Var, lf lfVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {od7Var, lfVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = lfVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            lf lfVar;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && (lfVar = this.a) != null) {
                lfVar.d();
            }
        }
    }

    /* loaded from: classes7.dex */
    public class g implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ od7 a;

        public g(od7 od7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {od7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = od7Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.a0().notifyDataSetChanged();
                if (!this.a.s0) {
                    this.a.R.n(this.a.S, this.a.f1144T, this.a.J, true);
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class h extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ od7 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public h(od7 od7Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {od7Var, Integer.valueOf(i)};
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
            this.a = od7Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof Boolean)) {
                if (((Boolean) customResponsedMessage.getData()).booleanValue()) {
                    if (this.a.t0 == null) {
                        this.a.t0 = new tn(new rn());
                    }
                    this.a.t0.q(this.a.u, 2);
                } else if (this.a.t0 != null) {
                    this.a.t0.w();
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class i implements AppBarLayout.OnOffsetChangedListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ od7 a;

        public i(od7 od7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {od7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = od7Var;
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
                sr7 sr7Var = this.a.w;
                if (i == 0 && !this.a.r.canDrag()) {
                    z = true;
                } else {
                    z = false;
                }
                sr7Var.s(z);
            }
            if (!this.a.K0() && this.a.u0 != null) {
                this.a.u0.g();
            }
            if (this.a.i0 != i && Math.abs(i) >= 0 && this.a.X() != -1) {
                if (Math.abs(i) >= this.a.X()) {
                    if (this.a.g0) {
                        this.a.g0 = false;
                        od7 od7Var = this.a;
                        od7Var.U0(od7Var.g0);
                    }
                } else if (!this.a.g0) {
                    this.a.g0 = true;
                    od7 od7Var2 = this.a;
                    od7Var2.U0(od7Var2.g0);
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
                            this.a.c2(0);
                        }
                        this.a.V.setVisibility(8);
                    }
                } else {
                    this.a.c2(Math.abs(d0 - g));
                    if (this.a.V != null) {
                        this.a.V.setVisibility(0);
                    }
                }
                if (this.a.B != null) {
                    if (this.a.Y) {
                        this.a.B.getBarBgView().setAlpha(abs);
                        this.a.f2(false);
                        this.a.C.c(abs);
                    } else if (this.a.p0 != null) {
                        this.a.p0.setAlpha(abs);
                    }
                }
                this.a.i0 = i;
                CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(2921397, Integer.valueOf(i));
                CustomMessage customMessage = new CustomMessage(2921397);
                if (this.a.a != null && this.a.a.T3() != null && this.a.a.T3().B() != null && (this.a.a.T3().B().b instanceof BaseFragment)) {
                    customMessage.setTag(((BaseFragment) this.a.a.T3().B().b).getUniqueId());
                    customResponsedMessage.setOrginalMessage(customMessage);
                }
                MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
            }
            if (this.a.w != null && this.a.w.k() > 0 && Math.abs(i) >= this.a.w.k()) {
                this.a.w.x();
            }
        }
    }

    /* loaded from: classes7.dex */
    public class j implements m06 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ od7 a;

        public j(od7 od7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {od7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = od7Var;
        }

        @Override // com.baidu.tieba.m06
        public void a(View view2, int i, int i2, int i3, int i4) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{view2, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4)}) == null) && i2 != i4 && i4 > 0) {
                this.a.f0.setMinimumHeight(i2);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class k extends DefaultItemAnimator {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public int a;
        public final /* synthetic */ od7 b;

        public k(od7 od7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {od7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = od7Var;
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

    /* loaded from: classes7.dex */
    public class l extends LinearLayoutManager {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public l(od7 od7Var, Context context) {
            super(context);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {od7Var, context};
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

    /* loaded from: classes7.dex */
    public class m implements RecyclerView.RecyclerListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ od7 a;

        public m(od7 od7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {od7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = od7Var;
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
                    playVoiceBnt.k();
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

    /* loaded from: classes7.dex */
    public class n implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ od7 a;

        public n(od7 od7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {od7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = od7Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                this.a.a.Y3();
                if (this.a.a != null && this.a.c0 != null) {
                    this.a.a.E4();
                    this.a.c0.setExpanded(true);
                    if (this.a.R != null) {
                        this.a.R.n(this.a.S, this.a.f1144T, false, true);
                    }
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class o implements ExposeTagViewCoordinatorLayout.NestedScrollAcceptedListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ od7 a;

        public o(od7 od7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {od7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = od7Var;
        }

        @Override // com.baidu.adp.widget.design.behavior.ExposeTagViewCoordinatorLayout.NestedScrollAcceptedListener
        public void onNestedScrollAccepted(boolean z) {
            boolean z2;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeZ(1048576, this, z) == null) && this.a.w != null && this.a.r.hasTargetView()) {
                sr7 sr7Var = this.a.w;
                if (this.a.i0 == 0 && !this.a.r.canDrag()) {
                    z2 = true;
                } else {
                    z2 = false;
                }
                sr7Var.s(z2);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class p implements ViewPager.OnPageChangeListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ od7 a;

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

        public p(od7 od7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {od7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = od7Var;
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageSelected(int i) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i) == null) && this.a.w != null && this.a.r.hasTargetView()) {
                this.a.w.s(false);
                this.a.r.clearTargetView();
            }
        }
    }

    public od7(FrsFragment frsFragment, View.OnClickListener onClickListener, bi7 bi7Var, boolean z, pr7 pr7Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {frsFragment, onClickListener, bi7Var, Boolean.valueOf(z), pr7Var};
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
        this.C = yn7.a();
        this.G = true;
        this.H = true;
        this.I = 0;
        this.J = false;
        this.S = 0;
        this.f1144T = 0;
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
        I0(bi7Var, z);
        this.Q = new HashSet<>();
        this.I = TbadkCoreApplication.getInst().getMainTabBottomBarHeight();
        this.j0 = TbadkCoreApplication.getInst().getSkinType();
        this.k0 = pr7Var;
    }

    public void B1(int i2) {
        FrsMoveAreaBottomMenuView frsMoveAreaBottomMenuView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(1048579, this, i2) == null) && (frsMoveAreaBottomMenuView = this.m0) != null) {
            frsMoveAreaBottomMenuView.setVisibility(i2);
        }
    }

    public void C0(boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048580, this, z) == null) && this.M != null) {
            if (z) {
                u1(false, true);
            } else {
                u1(false, false);
            }
        }
    }

    public void C1(int i2) {
        FrsMoveAreaBottomMenuView frsMoveAreaBottomMenuView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(1048581, this, i2) == null) && (frsMoveAreaBottomMenuView = this.m0) != null) {
            frsMoveAreaBottomMenuView.setMoveNumber(i2);
        }
    }

    public void D1(int i2) {
        FrsMultiDelBottomMenuView frsMultiDelBottomMenuView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(1048583, this, i2) == null) && (frsMultiDelBottomMenuView = this.l0) != null) {
            frsMultiDelBottomMenuView.setSelectNumber(i2);
        }
    }

    public void E0(k15 k15Var) {
        sr7 sr7Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, k15Var) == null) && (sr7Var = this.w) != null) {
            sr7Var.f(k15Var);
        }
    }

    public void E1(boolean z) {
        FrsMultiDelBottomMenuView frsMultiDelBottomMenuView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048585, this, z) == null) && (frsMultiDelBottomMenuView = this.l0) != null) {
            frsMultiDelBottomMenuView.setIsBlockMode(z);
        }
    }

    public void F1(int i2) {
        FrsMultiDelBottomMenuView frsMultiDelBottomMenuView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(1048587, this, i2) == null) && (frsMultiDelBottomMenuView = this.l0) != null) {
            frsMultiDelBottomMenuView.setVisibility(i2);
        }
    }

    public void G1(l46.c cVar) {
        FrsMultiDelBottomMenuView frsMultiDelBottomMenuView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048589, this, cVar) == null) && (frsMultiDelBottomMenuView = this.l0) != null) {
            frsMultiDelBottomMenuView.setDeleteCallback(cVar);
        }
    }

    public void H1(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048591, this, i2) == null) {
            this.I = i2;
        }
    }

    public void I1(fo foVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048593, this, foVar) == null) {
            this.v.d(foVar);
        }
    }

    public void J1(NoNetworkView.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048595, this, bVar) == null) {
            this.z = bVar;
            NoNetworkView noNetworkView = this.A;
            if (noNetworkView != null) {
                noNetworkView.a(bVar);
            }
        }
    }

    public void K1(boolean z) {
        sr7 sr7Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048597, this, z) == null) && (sr7Var = this.w) != null) {
            sr7Var.u(z);
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
        ur7 ur7Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048614, this, str) == null) && (ur7Var = this.N) != null) {
            ur7Var.a(str);
        }
    }

    public final void U0(boolean z) {
        FrsFragment frsFragment;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048624, this, z) == null) && z && (frsFragment = this.a) != null && frsFragment.x0() != null) {
            this.a.x0().q0();
        }
    }

    public final void U1(int i2) {
        nr6 nr6Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(1048625, this, i2) == null) && (nr6Var = this.i) != null) {
            nr6Var.g(i2);
        }
    }

    public void Z0(boolean z) {
        bea beaVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048639, this, z) == null) && z && (beaVar = this.u0) != null) {
            beaVar.i(2000);
        }
    }

    public void a2(boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048643, this, z) == null) && this.L != null) {
            if (qk5.h().k()) {
                this.L.x(false);
            } else {
                this.L.x(z);
            }
        }
    }

    public final void h2(@ColorRes int i2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(1048664, this, i2) == null) && this.m != null) {
            SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.m, R.drawable.ic_icon_pure_topbar_group40_svg, i2, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        }
    }

    public void n1(int i2) {
        sr7 sr7Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(1048676, this, i2) == null) && (sr7Var = this.w) != null) {
            sr7Var.q(i2);
        }
    }

    public void o1(boolean z) {
        AppBarLayout appBarLayout;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048678, this, z) == null) && (appBarLayout = this.c0) != null) {
            appBarLayout.setExpanded(z);
        }
    }

    public void q1(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048682, this, str) == null) {
            zh7 zh7Var = this.v;
            if (zh7Var instanceof lh7) {
                ((lh7) zh7Var).t(str);
            }
        }
    }

    public void r1(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048684, this, str) == null) {
            this.v.a(str);
        }
    }

    public void s1(int i2) {
        View view2;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(1048686, this, i2) == null) && (view2 = this.d) != null) {
            view2.setVisibility(i2);
        }
    }

    public void t1(boolean z) {
        di7 di7Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048688, this, z) == null) && (di7Var = this.M) != null) {
            di7Var.a(z);
        }
    }

    public void v1(se7 se7Var) {
        sr7 sr7Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048692, this, se7Var) == null) && (sr7Var = this.w) != null) {
            sr7Var.r(se7Var);
        }
    }

    public void x1(boolean z) {
        di7 di7Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048696, this, z) == null) {
            this.a0 = z;
            if (!z && (di7Var = this.M) != null) {
                di7Var.b(false, false);
            }
        }
    }

    public void y1(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048698, this, z) == null) {
            this.J = z;
        }
    }

    public void h1(int i2, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048663, this, new Object[]{Integer.valueOf(i2), Boolean.valueOf(z)}) == null) {
            nr6 nr6Var = this.i;
            if (nr6Var != null) {
                nr6Var.e(z, i2);
            }
            this.C.d(i2, z);
        }
    }

    public void p1(int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048680, this, i2, i3) == null) {
            this.S = i2;
            this.f1144T = i3;
        }
    }

    public void u1(boolean z, boolean z2) {
        di7 di7Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(1048690, this, new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) && this.a0 && (di7Var = this.M) != null) {
            di7Var.b(z, z2);
        }
    }

    public void z1(int i2, boolean z) {
        sr7 sr7Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(1048700, this, new Object[]{Integer.valueOf(i2), Boolean.valueOf(z)}) == null) && (sr7Var = this.w) != null) {
            sr7Var.t(i2, z);
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

    public void A1(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z) == null) {
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
            this.t.H(this.a.getResources().getString(R.string.obfuscated_res_0x7f0f0bcc));
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
            if (frsFragment != null && frsFragment.T3() != null && this.a.T3().B() != null) {
                z2 = this.a.T3().B().b instanceof FrsAllThreadFragment;
            } else {
                z2 = true;
            }
            if (!z && z2) {
                this.R.r(true);
                this.R.n(this.S, this.f1144T, this.J, true);
                return;
            }
            this.R.r(false);
            this.R.z();
        }
    }

    public void c1(int i2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(1048648, this, i2) == null) && TbadkCoreApplication.getCurrentAccount() == null) {
            if ((i2 == 3 || i2 == 6) && n95.m().i("frs_login_tip", true)) {
                if (this.K == null) {
                    this.K = new CommonTipView(this.a.getActivity());
                }
                this.K.setText(R.string.obfuscated_res_0x7f0f0832);
                FrameLayout v0 = v0();
                if (v0 != null) {
                    this.K.j(v0, TbadkCoreApplication.getInst().getSkinType());
                    n95.m().w("frs_login_tip", false);
                }
            }
        }
    }

    public final void c2(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048649, this, i2) == null) {
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

    public void g1(q25 q25Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048659, this, q25Var) == null) {
            b46 b46Var = new b46(this.a.getPageContext(), 1);
            b46Var.j(this.u);
            HashMap hashMap = new HashMap();
            hashMap.put("forum_name", this.a.v());
            hashMap.put("forum_id", this.a.w());
            b46Var.k(hashMap);
            b46Var.i(q25Var);
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016516, b46Var));
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
            pr7 pr7Var = this.k0;
            if (pr7Var != null && pr7Var.X()) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public void F0() {
        sr7 sr7Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048586, this) == null) && (sr7Var = this.w) != null) {
            sr7Var.n();
        }
    }

    public void G0() {
        sr7 sr7Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048588, this) == null) && (sr7Var = this.w) != null) {
            sr7Var.o();
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
            return n95.m().i("key_reaction_guide_show_number", false);
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
            sr7 sr7Var = this.w;
            if (sr7Var != null) {
                return sr7Var.j() instanceof FrsNewAreaFragment;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public boolean O0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048606, this)) == null) {
            lr7 lr7Var = this.L;
            if (lr7Var == null) {
                return false;
            }
            return lr7Var.m();
        }
        return invokeV.booleanValue;
    }

    public void O1() {
        sr7 sr7Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048607, this) == null) && (sr7Var = this.w) != null) {
            sr7Var.v();
        }
    }

    public void P0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048609, this) == null) {
            zh7 zh7Var = this.v;
            if (zh7Var instanceof lh7) {
                ((lh7) zh7Var).q();
            }
        }
    }

    public void Q0() {
        zh7 zh7Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048612, this) == null) && (zh7Var = this.v) != null) {
            zh7Var.notifyDataSetChanged();
        }
    }

    public void S() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048617, this) == null) {
            this.w.h();
        }
    }

    public void S0() {
        bea beaVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048618, this) == null) && (beaVar = this.u0) != null) {
            beaVar.d();
        }
    }

    public void S1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048619, this) == null) {
            this.u.setVisibility(0);
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

    public void X1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048634, this) == null) {
            U();
            e55 e55Var = this.x;
            if (e55Var != null) {
                e55Var.m();
            }
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
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048636, this) == null) {
            lr7 lr7Var = this.L;
            if (lr7Var != null) {
                lr7Var.p();
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016524));
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

    public zh7 a0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048641, this)) == null) {
            return this.v;
        }
        return (zh7) invokeV.objValue;
    }

    public void a1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048642, this) == null) {
            O(TbadkCoreApplication.getInst().getSkinType());
            lr7 lr7Var = this.L;
            if (lr7Var != null) {
                lr7Var.q();
            }
        }
    }

    public sr7 b0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048644, this)) == null) {
            return this.w;
        }
        return (sr7) invokeV.objValue;
    }

    public void b2() {
        sr7 sr7Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048646, this) == null) && (sr7Var = this.w) != null) {
            sr7Var.w();
        }
    }

    public lr7 c0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048647, this)) == null) {
            return this.L;
        }
        return (lr7) invokeV.objValue;
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

    public void d2() {
        sr7 sr7Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048652, this) == null) && (sr7Var = this.w) != null) {
            sr7Var.x();
        }
    }

    public boolean e0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048653, this)) == null) {
            sr7 sr7Var = this.w;
            if (sr7Var == null) {
                return false;
            }
            return sr7Var.l();
        }
        return invokeV.booleanValue;
    }

    public void e1() {
        sr7 sr7Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048654, this) == null) && (sr7Var = this.w) != null) {
            sr7Var.w();
        }
    }

    public void f1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048656, this) == null) {
            I0(this.Z, this.a.h4());
            zh7 zh7Var = this.v;
            if (zh7Var != null) {
                zh7Var.e();
            }
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

    public Context getContext() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048661, this)) == null) {
            FrsFragment frsFragment = this.a;
            if (frsFragment == null) {
                return null;
            }
            return frsFragment.t().getPageActivity();
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
            nr6 nr6Var = this.i;
            if (nr6Var != null) {
                return nr6Var.c();
            }
            return null;
        }
        return (View) invokeV.objValue;
    }

    public void i1() {
        NoNetworkView noNetworkView;
        NoNetworkView.b bVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048666, this) == null) && (noNetworkView = this.A) != null && (bVar = this.z) != null) {
            noNetworkView.e(bVar);
        }
    }

    @NonNull
    public zn7 j0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048667, this)) == null) {
            return this.C;
        }
        return (zn7) invokeV.objValue;
    }

    public void j1() {
        FrsMoveAreaBottomMenuView frsMoveAreaBottomMenuView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048668, this) == null) && (frsMoveAreaBottomMenuView = this.m0) != null) {
            frsMoveAreaBottomMenuView.d();
        }
    }

    public NavigationBar k0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048669, this)) == null) {
            return this.B;
        }
        return (NavigationBar) invokeV.objValue;
    }

    public boolean k1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048670, this)) == null) {
            if (this.G) {
                return false;
            }
            this.t.H(this.a.getResources().getString(R.string.obfuscated_res_0x7f0f0bcc));
            this.t.g();
            return true;
        }
        return invokeV.booleanValue;
    }

    public final int l0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048671, this)) == null) {
            NavigationBar navigationBar = this.B;
            if (navigationBar == null) {
                return 0;
            }
            return navigationBar.getHeight();
        }
        return invokeV.intValue;
    }

    public ObservedChangeLinearLayout m0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048673, this)) == null) {
            return this.W;
        }
        return (ObservedChangeLinearLayout) invokeV.objValue;
    }

    public void m1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048674, this) == null) {
            this.v.notifyDataSetChanged();
        }
    }

    public final int n0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048675, this)) == null) {
            if (this.A != null && !BdNetTypeUtil.isNetWorkAvailable()) {
                return this.A.getHeight();
            }
            return 0;
        }
        return invokeV.intValue;
    }

    public si9 o0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048677, this)) == null) {
            return this.R;
        }
        return (si9) invokeV.objValue;
    }

    public TextView p0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048679, this)) == null) {
            return this.l;
        }
        return (TextView) invokeV.objValue;
    }

    public di7 q0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048681, this)) == null) {
            return this.M;
        }
        return (di7) invokeV.objValue;
    }

    public RelativeLayout r0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048683, this)) == null) {
            return this.b;
        }
        return (RelativeLayout) invokeV.objValue;
    }

    public View s0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048685, this)) == null) {
            return this.U;
        }
        return (View) invokeV.objValue;
    }

    public final int t0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048687, this)) == null) {
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
        if (interceptable == null || (invokeV = interceptable.invokeV(1048689, this)) == null) {
            return this.V;
        }
        return (View) invokeV.objValue;
    }

    public FrameLayout v0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048691, this)) == null) {
            return this.F;
        }
        return (FrameLayout) invokeV.objValue;
    }

    public FrsTopBarGroupEntranceGuideView w0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048693, this)) == null) {
            return this.X;
        }
        return (FrsTopBarGroupEntranceGuideView) invokeV.objValue;
    }

    public ImageView x0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048695, this)) == null) {
            return this.m;
        }
        return (ImageView) invokeV.objValue;
    }

    public ImageView y0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048697, this)) == null) {
            return this.k;
        }
        return (ImageView) invokeV.objValue;
    }

    public ImageView z0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048699, this)) == null) {
            return this.j;
        }
        return (ImageView) invokeV.objValue;
    }

    public final void H0() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048590, this) != null) || this.O != null) {
            return;
        }
        View R3 = this.a.R3();
        this.O = (GifView) R3.findViewById(R.id.obfuscated_res_0x7f090dfc);
        TbImageView tbImageView = (TbImageView) R3.findViewById(R.id.obfuscated_res_0x7f092386);
        this.P = tbImageView;
        tbImageView.setPageId(this.a.getUniqueId());
        this.O.setLayerType(1, null);
        this.P.setLayerType(1, null);
    }

    public void P1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048610, this) == null) {
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

    public void Q1() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048613, this) != null) || this.n == null) {
            return;
        }
        this.o.setVisibility(0);
        this.q.setVisibility(8);
        this.p.setVisibility(0);
        TbadkCoreApplication.getInst().handler.postDelayed(this.x0, 5000L);
    }

    public void W1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048631, this) == null) {
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
            lr7 lr7Var = this.L;
            if (lr7Var != null && lr7Var.s()) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public void d1() {
        di7 di7Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048651, this) == null) {
            if (this.a0 && (di7Var = this.M) != null) {
                di7Var.b(false, false);
            }
            U1(8);
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
            a2(false);
            this.u.setVisibility(8);
            this.e0.setVisibility(8);
        }
    }

    public void l1() {
        di7 di7Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048672, this) == null) {
            if (this.a0 && (di7Var = this.M) != null) {
                di7Var.b(true, false);
            }
            U1(0);
            T();
            a2(this.a.o3());
            this.u.setVisibility(0);
            this.e0.setVisibility(0);
        }
    }

    public final void I0(bi7 bi7Var, boolean z) {
        boolean z2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048592, this, bi7Var, z) == null) {
            this.Z = bi7Var;
            View R3 = this.a.R3();
            if (this.b == null) {
                this.b = (NoPressedRelativeLayout) R3.findViewById(R.id.obfuscated_res_0x7f090c21);
            }
            if (this.d == null) {
                this.d = R3.findViewById(R.id.obfuscated_res_0x7f090c5a);
            }
            if (this.c == null) {
                this.c = (CoordinatorLayout) R3.findViewById(R.id.obfuscated_res_0x7f090d11);
            }
            if (this.E == null) {
                this.E = R3.findViewById(R.id.obfuscated_res_0x7f090ceb);
            }
            if (this.F == null) {
                this.F = (FrameLayout) R3.findViewById(R.id.obfuscated_res_0x7f090d58);
            }
            if (this.f0 == null) {
                this.f0 = (CollapsingToolbarLayout) R3.findViewById(R.id.obfuscated_res_0x7f090c58);
            }
            if (this.e0 == null) {
                this.e0 = (FrsHeaderViewContainer) R3.findViewById(R.id.obfuscated_res_0x7f090efa);
            }
            if (this.w == null) {
                this.w = new sr7(this.a);
            }
            if (this.W == null) {
                ObservedChangeLinearLayout observedChangeLinearLayout = (ObservedChangeLinearLayout) R3.findViewById(R.id.obfuscated_res_0x7f091860);
                this.W = observedChangeLinearLayout;
                observedChangeLinearLayout.setOnSizeChangeListener(new j(this));
                if (this.X == null) {
                    this.X = (FrsTopBarGroupEntranceGuideView) this.W.findViewById(R.id.obfuscated_res_0x7f09255a);
                }
            }
            this.C.h(this.a, R3, this.y);
            if (this.B == null) {
                this.B = this.C.e();
                z2 = true;
            } else {
                z2 = false;
            }
            if (this.a.h4()) {
                this.B.setVisibility(8);
            }
            if (this.D == null) {
                this.D = R3.findViewById(R.id.obfuscated_res_0x7f090d10);
                ci7 c2 = bi7Var.c();
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
                this.i = (nr6) this.C.a(LogicField.MESSAGE_ICON_CONTROLLER);
                this.g = (ImageView) this.C.a(LogicField.MESSAGE_BTN);
                this.h = (MessageRedDotView) this.C.a(LogicField.MESSAGE_RED_DOT);
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
                TextView textView = (TextView) this.B.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_ABSOLUTE_CENTER, R.layout.obfuscated_res_0x7f0d0386, (View.OnClickListener) null);
                this.l = textView;
                textView.setVisibility(8);
                Drawable drawable = SkinManager.getDrawable(R.drawable.icon_arrow12_white);
                int g2 = vi.g(this.a.getActivity(), R.dimen.tbds31);
                drawable.setBounds(0, 0, g2, g2);
                this.l.setCompoundDrawables(null, null, drawable, null);
                SkinManager.setBackgroundResourceSelector(this.l, R.drawable.bg_frs_private_status_n, R.drawable.bg_frs_private_status_s);
                SkinManager.setViewTextColor(this.l, (int) R.color.CAM_X0101);
            }
            if (z2) {
                this.B.onChangeSkinType(this.a.getPageContext(), TbadkCoreApplication.getInst().getSkinType());
                SkinManager.setBackgroundColor(this.B.getBottomLine(), R.color.CAM_X0204);
            }
            if (this.u == null) {
                this.u = (BdTypeRecyclerView) R3.findViewById(R.id.obfuscated_res_0x7f090cf5);
            }
            k kVar = new k(this);
            kVar.setSupportsChangeAnimations(false);
            this.u.setItemAnimator(kVar);
            BdTypeRecyclerView bdTypeRecyclerView = this.u;
            bdTypeRecyclerView.setLayoutManager(new l(this, bdTypeRecyclerView.getContext()));
            if (TbSingleton.getInstance().isSlideAnimEnable()) {
                tn tnVar = new tn(new rn());
                this.t0 = tnVar;
                tnVar.q(this.u, 2);
            }
            this.u.setScrollable(this.a);
            this.u.setFadingEdgeLength(0);
            this.u.setOverScrollMode(2);
            this.b.setBottomOrderView(this.u);
            this.u.setOnTouchListener(this.a.U1);
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
            this.t.w(vi.g(this.a.getActivity(), R.dimen.tbds182));
            this.t.B();
            this.t.L(R.dimen.tbfontsize33);
            this.t.J(SkinManager.getColor(R.color.CAM_X0109));
            this.t.F(R.color.CAM_X0110);
            this.u.setOnSrollToBottomListener(this.a);
            this.B.setOnClickListener(new n(this));
            boolean isShowBigImage = TbImageHelper.getInstance().isShowBigImage();
            if (this.v == null) {
                this.v = bi7Var.b(this.a, this.u, isShowBigImage);
            }
            sr7 sr7Var = this.w;
            if (sr7Var != null) {
                sr7Var.t(1, false);
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
                this.A.d(this.a.getPageContext(), TbadkCoreApplication.getInst().getSkinType());
            }
            H0();
            if (this.L == null) {
                lr7 a2 = bi7Var.a(this.a, this.b);
                this.L = a2;
                a2.u(this.a.W3());
            }
            if (this.M == null) {
                this.M = bi7Var.d(this.a, this.b);
                t1(true);
            }
            if (this.U == null) {
                this.U = R3.findViewById(R.id.obfuscated_res_0x7f0921f6);
            }
            if (this.V == null) {
                this.V = R3.findViewById(R.id.obfuscated_res_0x7f0921f7);
            }
            if (this.R == null) {
                this.R = new si9(this.a.getPageContext(), this.u);
            }
            this.R.p(2);
            this.R.u(this.a.getUniqueId());
            if (this.u0 == null) {
                this.u0 = new bea(this.a.getPageContext(), this.u);
            }
            NavigationBarCoverTip navigationBarCoverTip = (NavigationBarCoverTip) R3.findViewById(R.id.obfuscated_res_0x7f091863);
            this.n0 = navigationBarCoverTip;
            if (this.N == null) {
                this.N = new ur7(this.a, navigationBarCoverTip);
            }
            if (this.c0 == null) {
                AppBarLayout appBarLayout = (AppBarLayout) R3.findViewById(R.id.obfuscated_res_0x7f090c34);
                this.c0 = appBarLayout;
                appBarLayout.addOnOffsetChangedListener(this.w0);
                this.g0 = true;
                this.h0 = -1;
                CoordinatorLayout.LayoutParams layoutParams = (CoordinatorLayout.LayoutParams) this.c0.getLayoutParams();
                if (layoutParams.getBehavior() instanceof AppBarLayoutStickyBehavior) {
                    this.d0 = (AppBarLayoutStickyBehavior) layoutParams.getBehavior();
                }
            }
            FrsMultiDelBottomMenuView frsMultiDelBottomMenuView = (FrsMultiDelBottomMenuView) R3.findViewById(R.id.obfuscated_res_0x7f090d09);
            this.l0 = frsMultiDelBottomMenuView;
            frsMultiDelBottomMenuView.setPageContext(this.a.getPageContext());
            FrsMoveAreaBottomMenuView frsMoveAreaBottomMenuView = (FrsMoveAreaBottomMenuView) R3.findViewById(R.id.obfuscated_res_0x7f090d06);
            this.m0 = frsMoveAreaBottomMenuView;
            frsMoveAreaBottomMenuView.setPageContext(this.a.getPageContext());
            if (this.p0 == null) {
                this.p0 = (TextView) this.C.a(LogicField.FOLD_TITLE);
            }
            ExposeTagViewCoordinatorLayout exposeTagViewCoordinatorLayout = (ExposeTagViewCoordinatorLayout) R3.findViewById(R.id.obfuscated_res_0x7f090d11);
            this.r = exposeTagViewCoordinatorLayout;
            exposeTagViewCoordinatorLayout.setListener(new o(this));
            FrsTabViewPager frsTabViewPager = (FrsTabViewPager) R3.findViewById(R.id.obfuscated_res_0x7f090d6d);
            this.s = frsTabViewPager;
            frsTabViewPager.addOnPageChangeListener(new p(this));
        }
    }

    public void L1(ArrayList<vn> arrayList, FrsViewData frsViewData) {
        int i2;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLL(1048599, this, arrayList, frsViewData) != null) || frsViewData == null) {
            return;
        }
        ArrayList<vn> switchThreadDataToThreadCardInfo = frsViewData.switchThreadDataToThreadCardInfo();
        if (ListUtils.isEmpty(switchThreadDataToThreadCardInfo) || !frsViewData.mHasThreadExceptTop) {
            qd7 qd7Var = new qd7();
            ArrayList<vn> arrayList2 = new ArrayList<>();
            arrayList2.add(qd7Var);
            FrsFragment frsFragment = this.a;
            if (frsFragment != null && frsFragment.V0() != null && this.a.V0().u0() == 0) {
                qd7Var.b(this.a.V0().p0());
            }
            switchThreadDataToThreadCardInfo = arrayList2;
        }
        if (ListUtils.getCount(switchThreadDataToThreadCardInfo) > 0) {
            for (int i3 = 0; i3 < switchThreadDataToThreadCardInfo.size(); i3++) {
                vn vnVar = switchThreadDataToThreadCardInfo.get(i3);
                if (vnVar instanceof n45) {
                    ((n45) vnVar).t.setSmartFrsPosition(i3);
                }
            }
        }
        this.v.g(switchThreadDataToThreadCardInfo, frsViewData);
        si9 si9Var = this.R;
        if (si9Var != null && (i2 = this.S) != 0) {
            si9Var.n(i2, this.f1144T, this.J, true);
        }
        FrsFragment frsFragment2 = this.a;
        if (frsFragment2 != null) {
            frsFragment2.T4();
        }
        FrsMultiDelBottomMenuView frsMultiDelBottomMenuView = this.l0;
        if (frsMultiDelBottomMenuView != null) {
            frsMultiDelBottomMenuView.setFrsViewData(frsViewData);
        }
        bea beaVar = this.u0;
        if (beaVar != null) {
            beaVar.i(2000);
        }
    }

    public final void Q(AppBarLayout appBarLayout, int i2) {
        FrsFragment frsFragment;
        ViewGroup.MarginLayoutParams marginLayoutParams;
        boolean z;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLI(1048611, this, appBarLayout, i2) == null) && (frsFragment = this.a) != null && appBarLayout != null && frsFragment.T3() != null && this.a.getPageContext() != null) {
            int d0 = d0() + l0() + n0();
            int totalScrollRange = (appBarLayout.getTotalScrollRange() - Math.abs(i2)) + this.C.g();
            FrsTabViewController T3 = this.a.T3();
            ViewGroup.LayoutParams layoutParams = this.d.getLayoutParams();
            if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
            } else {
                marginLayoutParams = new ViewGroup.MarginLayoutParams(layoutParams);
            }
            FrsFragment frsFragment2 = this.a;
            if (frsFragment2 != null && frsFragment2.q4()) {
                z = true;
            } else {
                z = false;
            }
            if (totalScrollRange <= 0) {
                if (this.r0 != 2) {
                    T3.f(2);
                }
                this.r0 = 2;
                marginLayoutParams.topMargin = 0;
            } else if (totalScrollRange > 0 && totalScrollRange < d0) {
                if (this.r0 != 1) {
                    T3.f(1);
                }
                this.r0 = 1;
                marginLayoutParams.topMargin = 0;
            } else {
                if (this.r0 != 0) {
                    T3.f(0);
                }
                this.r0 = 0;
                if (z) {
                    marginLayoutParams.topMargin = vi.g(this.a.getActivity(), R.dimen.tbds_30);
                } else {
                    marginLayoutParams.topMargin = 0;
                }
            }
            if (z) {
                this.d.setLayoutParams(marginLayoutParams);
            }
        }
    }

    public void V1(String str, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048628, this, str, i2) == null) {
            if (this.o0 == null) {
                TextView textView = new TextView(this.a.getActivity());
                this.o0 = textView;
                textView.setGravity(19);
                this.o0.setPadding(vi.g(this.a.getActivity(), R.dimen.obfuscated_res_0x7f07020f), 0, vi.g(this.a.getActivity(), R.dimen.obfuscated_res_0x7f07020f), 0);
                this.o0.setLayoutParams(new ViewGroup.LayoutParams(-1, vi.g(this.a.getActivity(), R.dimen.tbds112)));
                this.o0.setTextSize(0, vi.g(this.a.getActivity(), R.dimen.obfuscated_res_0x7f070453));
                this.o0.setMaxLines(2);
                this.o0.setEllipsize(TextUtils.TruncateAt.valueOf("END"));
                this.o0.setTextColor(ContextCompat.getColor(this.a.getActivity(), R.color.CAM_X0101));
            }
            this.n0.setBackgroundColor(i2);
            this.o0.setText(str);
            this.n0.n(this.a.getActivity(), this.o0, 5000);
        }
    }

    public void M1(String str) {
        TextView textView;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048601, this, str) != null) || (textView = this.p0) == null || !TextUtils.isEmpty(textView.getText())) {
            return;
        }
        if (TextUtils.isEmpty(str)) {
            this.p0.setText("");
            return;
        }
        this.p0.setText(f0(str));
        n05.c().h(str);
    }

    public void Y1(PostWriteCallBackData postWriteCallBackData) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048637, this, postWriteCallBackData) == null) && postWriteCallBackData != null && postWriteCallBackData.mFrom == 2) {
            if (postWriteCallBackData.getIconStampData() != null) {
                xf5.c(this.a.t(), postWriteCallBackData, 1);
                return;
            }
            if (this.b0 == null) {
                this.b0 = new g7a(this.a.getActivity(), this.b);
            }
            this.b0.g(postWriteCallBackData);
        }
    }

    public void N1() {
        NavigationBar navigationBar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048604, this) == null) && (navigationBar = this.B) != null && navigationBar.getBarBgView() != null && this.W != null) {
            w1();
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

    public final void w1() {
        ViewGroup.LayoutParams layoutParams;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048694, this) == null) {
            this.Y = D0();
            FrsHeaderViewContainer frsHeaderViewContainer = this.e0;
            if (frsHeaderViewContainer != null && (layoutParams = frsHeaderViewContainer.getLayoutParams()) != null && (layoutParams instanceof ViewGroup.MarginLayoutParams)) {
                if (this.Y) {
                    ((ViewGroup.MarginLayoutParams) layoutParams).setMargins(0, 0, 0, 0);
                } else {
                    ((ViewGroup.MarginLayoutParams) layoutParams).setMargins(0, vi.g(TbadkCoreApplication.getInst().getContext(), R.dimen.obfuscated_res_0x7f07041a) + d0(), 0, 0);
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
                nr6 nr6Var = this.i;
                if (nr6Var != null) {
                    nr6Var.d(i2);
                }
                if (this.k != null) {
                    SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.k, R.drawable.ic_icon_pure_topbar_search40_svg, R.color.CAM_X0106, SvgManager.SvgResourceStateType.NORMAL_PRESS);
                }
                if (this.j != null) {
                    SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.j, R.drawable.ic_icon_pure_topbar_share40_svg, R.color.CAM_X0106, SvgManager.SvgResourceStateType.NORMAL_PRESS);
                }
                h2(R.color.CAM_X0106);
            }
            SkinManager.setBackgroundColor(this.U, R.color.CAM_X0207);
            SkinManager.setBackgroundColor(this.V, R.color.CAM_X0207);
            f2(true);
        }
    }

    public void R1(y45 y45Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048616, this, y45Var) == null) {
            if (this.n == null) {
                View R3 = this.a.R3();
                ViewStub viewStub = (ViewStub) R3.findViewById(R.id.obfuscated_res_0x7f0929bc);
                this.n = viewStub;
                viewStub.setVisibility(0);
                this.o = (FrameLayout) R3.findViewById(R.id.obfuscated_res_0x7f090dab);
                this.p = (TbImageView) R3.findViewById(R.id.obfuscated_res_0x7f090daa);
                this.q = (TbImageView) R3.findViewById(R.id.obfuscated_res_0x7f090dac);
                this.p.setPageId(this.a.getUniqueId());
                this.q.setPageId(this.a.getUniqueId());
                this.p.setDefaultBgResource(R.color.common_color_10022);
                this.p.setDefaultResource(0);
                this.q.setDefaultBgResource(R.color.common_color_10022);
                this.q.setDefaultResource(0);
                this.o.setOnClickListener(this.y);
            }
            this.o.setVisibility(0);
            String a2 = y45Var.a();
            String b2 = y45Var.b();
            this.p.N(a2, 10, false);
            this.q.N(b2, 10, false);
            TbadkCoreApplication.getInst().handler.postDelayed(this.x0, 5000L);
        }
    }

    public void V0(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048627, this, i2) == null) {
            this.j0 = i2;
            this.C.onChangeSkinType(i2);
            c46 c46Var = new c46(this.a, 4);
            c46Var.F(i2);
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016515, c46Var));
            b46 b46Var = new b46(this.a.getPageContext(), 4);
            b46Var.l(i2);
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016516, b46Var));
            TbImageView tbImageView = this.P;
            if (tbImageView != null) {
                tbImageView.invalidate();
            }
            zh7 zh7Var = this.v;
            if (zh7Var != null) {
                zh7Var.b();
                this.v.notifyDataSetChanged();
            }
            gt5.a(this.a.getPageContext(), this.b);
            NoNetworkView noNetworkView = this.A;
            if (noNetworkView != null) {
                noNetworkView.d(this.a.getPageContext(), i2);
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
            di7 di7Var = this.M;
            if (di7Var != null) {
                di7Var.onChangeSkinType(i2);
            }
            lr7 lr7Var = this.L;
            if (lr7Var != null) {
                lr7Var.r(i2);
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

    public final void f2(boolean z) {
        NavigationBar navigationBar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048657, this, z) == null) && (navigationBar = this.B) != null && navigationBar.getBarBgView() != null && this.Y) {
            if (this.B.getBarBgView().getAlpha() < 0.5f) {
                if (z || this.q0 != 0) {
                    SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.f, R.drawable.ic_icon_pure_topbar_return40_svg, R.color.CAM_X0101, SvgManager.SvgResourceStateType.NORMAL_PRESS);
                    SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.k, R.drawable.ic_icon_pure_topbar_search40_svg, R.color.CAM_X0101, SvgManager.SvgResourceStateType.NORMAL_PRESS);
                    ImageView imageView = this.g;
                    if (imageView != null) {
                        imageView.setImageDrawable(WebPManager.getPureDrawable(R.drawable.icon_pure_topbar_information40, SkinManager.getColor(R.color.CAM_X0101), null));
                    }
                    h2(R.color.CAM_X0101);
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
                h2(R.color.CAM_X0106);
                FrsTopBarGroupEntranceGuideView frsTopBarGroupEntranceGuideView = this.X;
                if (frsTopBarGroupEntranceGuideView != null) {
                    frsTopBarGroupEntranceGuideView.a();
                }
                SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.j, R.drawable.ic_icon_pure_topbar_share40_svg, R.color.CAM_X0106, SvgManager.SvgResourceStateType.NORMAL_PRESS);
                this.q0 = 1;
            }
            e2();
        }
    }

    public void T0(int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048621, this, i2, i3) == null) {
            bea beaVar = this.u0;
            if (beaVar != null) {
                beaVar.i(100);
            }
            if (this.u0 != null && !K0()) {
                this.u0.g();
            }
            si9 si9Var = this.R;
            if (si9Var == null) {
                return;
            }
            si9Var.m(i2, i3, this.J, 1);
            this.R.p(2);
            this.R.q(false);
        }
    }

    public final void U() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048623, this) == null) && this.x == null && this.a.getPageContext() != null) {
            String[] strArr = {this.a.getPageContext().getPageActivity().getString(R.string.take_photo), this.a.getPageContext().getPageActivity().getString(R.string.obfuscated_res_0x7f0f027e)};
            e55 e55Var = new e55(this.a.getPageContext().getPageActivity());
            this.x = e55Var;
            e55Var.l(this.a.getPageContext().getPageActivity().getString(R.string.obfuscated_res_0x7f0f0ec6));
            this.x.j(strArr, new b(this));
            this.x.c(this.a.getPageContext());
        }
    }

    public void W0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048630, this) == null) {
            MessageManager.getInstance().unRegisterListener(this.v0);
            si9 si9Var = this.R;
            if (si9Var != null) {
                si9Var.h();
            }
            ur7 ur7Var = this.N;
            if (ur7Var != null) {
                ur7Var.c();
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
            TbadkCoreApplication.getInst().handler.removeCallbacks(this.x0);
            CommonTipView commonTipView = this.K;
            if (commonTipView != null) {
                commonTipView.i();
            }
            this.Q.clear();
            lr7 lr7Var = this.L;
            if (lr7Var != null) {
                lr7Var.o();
            }
            g7a g7aVar = this.b0;
            if (g7aVar != null) {
                g7aVar.e();
            }
            NavigationBarCoverTip navigationBarCoverTip = this.n0;
            if (navigationBarCoverTip != null) {
                navigationBarCoverTip.i();
            }
            FrsMultiDelBottomMenuView frsMultiDelBottomMenuView2 = this.l0;
            if (frsMultiDelBottomMenuView2 != null) {
                frsMultiDelBottomMenuView2.e();
            }
            sr7 sr7Var = this.w;
            if (sr7Var != null) {
                sr7Var.p();
            }
            sr7 sr7Var2 = this.w;
            if (sr7Var2 != null) {
                sr7Var2.r(null);
            }
        }
    }

    public void Z1() {
        int headerViewsCount;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048640, this) == null) && n95.m().o("frs_video_activity_guide", 0L) == 0 && !this.y0 && this.a.getActivity() != null && this.a.getPageContext() != null) {
            View view2 = null;
            BdTypeRecyclerView bdTypeRecyclerView = this.u;
            if (bdTypeRecyclerView != null && (headerViewsCount = bdTypeRecyclerView.getHeaderViewsCount()) < this.u.getChildCount()) {
                view2 = this.u.getChildAt(headerViewsCount);
            }
            if (view2 != null) {
                mf mfVar = new mf();
                mfVar.k(view2);
                mfVar.c(0);
                mfVar.j(true);
                mfVar.i(false);
                mfVar.d(true);
                mfVar.a(new d(this));
                mfVar.h(new e(this));
                lf b2 = mfVar.b();
                b2.k(false);
                b2.m(this.a.getActivity());
                wg.a().postDelayed(new f(this, b2), 4000L);
                this.y0 = true;
            }
        }
    }

    public void b1() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048645, this) != null) || a0() == null) {
            return;
        }
        List<vn> f2 = a0().f();
        if (ListUtils.isEmpty(f2)) {
            return;
        }
        for (vn vnVar : f2) {
            if (vnVar instanceof n45) {
                n45 n45Var = (n45) vnVar;
                if (n45Var.u != 0 && n45Var.t != null && this.a.V0() != null && this.a.V0().C0() != null) {
                    int[] imageWidthAndHeight = n45Var.t.getImageWidthAndHeight();
                    n45Var.u = imageWidthAndHeight[0];
                    n45Var.v = imageWidthAndHeight[1];
                }
            }
        }
        wg.a().postDelayed(new g(this), 500L);
    }

    public final void e2() {
        NavigationBar navigationBar;
        float f2;
        float f3;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048655, this) != null) || (navigationBar = this.B) == null) {
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
            if (frsFragment != null && frsFragment.T3() != null && this.q0 == 1) {
                this.a.T3().g0(f3);
            }
            MessageRedDotView messageRedDotView = this.h;
            if (messageRedDotView != null) {
                messageRedDotView.setAlpha(f3);
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

    public void g2(@Nullable TopbarEntrance topbarEntrance, boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLZ(1048660, this, topbarEntrance, z) == null) && this.m != null) {
            if (topbarEntrance != null && !TextUtils.isEmpty(topbarEntrance.jump_url)) {
                if (this.m.getVisibility() != 0) {
                    qq7.b(this.a.w());
                }
                this.m.setVisibility(0);
                if (z && oq7.b(this.a.w())) {
                    this.m.post(new a(this, topbarEntrance));
                    return;
                }
                return;
            }
            this.m.setVisibility(8);
        }
    }
}
