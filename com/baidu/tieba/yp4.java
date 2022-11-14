package com.baidu.tieba;

import android.content.Context;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.core.content.res.ResourcesCompat;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.BdNetTypeUtil;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.browser.BaseWebViewActivity;
import com.baidu.tbadk.browser.TbWebViewActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.FrsActivityConfig;
import com.baidu.tbadk.core.atomData.InvateAnswerSettingActivityConfig;
import com.baidu.tbadk.core.atomData.ShareDialogConfig;
import com.baidu.tbadk.core.atomData.TbWebViewActivityConfig;
import com.baidu.tbadk.core.util.CommonStatisticKey;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.SvgManager;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.WebPManager;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NoDataView;
import com.baidu.tbadk.core.view.NoDataViewFactory;
import com.baidu.tbadk.coreExtra.share.ShareItem;
import com.baidu.tbadk.util.BdListViewHelper;
import com.baidu.tbadk.widget.ContinuousAnimationView;
import com.baidu.tieba.c19;
import com.baidu.tieba.uv4;
import com.baidu.tieba.view.BdTopToast;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
/* loaded from: classes6.dex */
public class yp4 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean A;
    public View B;
    public boolean C;
    public int D;
    public up4 E;
    public BaseWebViewActivity a;
    public ViewGroup b;
    public NavigationBar c;
    public TextView d;
    public ImageView e;
    public View f;
    public ImageView g;
    public View h;
    public ImageView i;
    public ImageView j;
    public ImageView k;
    public LinearLayout l;
    public TextView m;
    public ContinuousAnimationView n;
    public ProgressBar o;
    public NoDataView p;
    public View.OnClickListener q;
    public View r;
    public FrameLayout s;
    public boolean t;
    public boolean u;
    public boolean v;
    public boolean w;
    public boolean x;
    public k68 y;
    public sv4 z;

    /* loaded from: classes6.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ yp4 a;

        public a(yp4 yp4Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {yp4Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = yp4Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                new StatisticItem(CommonStatisticKey.KEY_QUESTION_DETAIL_HELP).addParam("uid", TbadkCoreApplication.getCurrentAccount()).eventStat();
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new TbWebViewActivityConfig(this.a.a, "", yi.S(TbConfig.QUESTION_THREAD_RULE, "refer=1"), true)));
            }
        }
    }

    /* loaded from: classes6.dex */
    public class b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ yp4 a;

        public b(yp4 yp4Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {yp4Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = yp4Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, view2) == null) && this.a.a != null) {
                if (((this.a.a instanceof TbWebViewActivity) && ((TbWebViewActivity) this.a.a).isDisableGoBack && ((TbWebViewActivity) this.a.a).needDealClickGoBack()) || this.a.a.webViewGoBack()) {
                    return;
                }
                this.a.a.finish();
            }
        }
    }

    /* loaded from: classes6.dex */
    public class c implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ yp4 a;

        public c(yp4 yp4Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {yp4Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = yp4Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, view2) == null) && this.a.a != null) {
                this.a.a.finish();
            }
        }
    }

    /* loaded from: classes6.dex */
    public class d implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ yp4 a;

        public d(yp4 yp4Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {yp4Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = yp4Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                if (this.a.x) {
                    new StatisticItem(CommonStatisticKey.KEY_QUESTION_DETAIL_MORE).addParam("uid", TbadkCoreApplication.getCurrentAccount()).eventStat();
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new InvateAnswerSettingActivityConfig(this.a.a)));
                } else if (this.a.j()) {
                    this.a.N();
                } else if (this.a.k.getVisibility() != 0) {
                    this.a.Q();
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public class e implements uv4.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ yp4 a;

        public e(yp4 yp4Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {yp4Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = yp4Var;
        }

        @Override // com.baidu.tieba.uv4.c
        public void onClick() {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeV(1048576, this) != null) || this.a.z == null) {
                return;
            }
            this.a.z.dismiss();
        }
    }

    /* loaded from: classes6.dex */
    public class f implements uv4.d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ yp4 a;

        public f(yp4 yp4Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {yp4Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = yp4Var;
        }

        @Override // com.baidu.tieba.uv4.d
        public void onClick() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && this.a.z != null && this.a.a != null) {
                this.a.z.dismiss();
                this.a.a.shareFriend();
            }
        }
    }

    /* loaded from: classes6.dex */
    public class g implements uv4.d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ yp4 a;

        public g(yp4 yp4Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {yp4Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = yp4Var;
        }

        @Override // com.baidu.tieba.uv4.d
        public void onClick() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && this.a.z != null && this.a.a != null) {
                this.a.z.dismiss();
                this.a.a.copyLink();
            }
        }
    }

    /* loaded from: classes6.dex */
    public class h implements uv4.d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ yp4 a;

        public h(yp4 yp4Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {yp4Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = yp4Var;
        }

        @Override // com.baidu.tieba.uv4.d
        public void onClick() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && this.a.z != null && this.a.a != null) {
                this.a.z.dismiss();
                this.a.a.openInBrowser();
            }
        }
    }

    /* loaded from: classes6.dex */
    public class i implements c19.d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ yp4 a;

        public i(yp4 yp4Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {yp4Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = yp4Var;
        }

        @Override // com.baidu.tieba.c19.d
        public void onClick() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && this.a.y != null && this.a.a != null) {
                this.a.y.dismiss();
                FrsActivityConfig createNormalCfg = new FrsActivityConfig(this.a.a).createNormalCfg(this.a.a.getResources().getString(R.string.obfuscated_res_0x7f0f153d), null);
                createNormalCfg.setCallFrom(12);
                this.a.a.sendMessage(new CustomMessage(2003000, createNormalCfg));
            }
        }
    }

    /* loaded from: classes6.dex */
    public class j implements c19.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ yp4 a;

        public j(yp4 yp4Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {yp4Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = yp4Var;
        }

        @Override // com.baidu.tieba.c19.c
        public void onClick() {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeV(1048576, this) != null) || this.a.y == null) {
                return;
            }
            this.a.y.dismiss();
        }
    }

    public yp4(BaseWebViewActivity baseWebViewActivity) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {baseWebViewActivity};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.b = null;
        this.n = null;
        this.o = null;
        this.t = true;
        this.u = true;
        this.v = false;
        this.w = false;
        this.x = false;
        this.A = false;
        this.C = true;
        this.D = 0;
        this.a = baseWebViewActivity;
        p();
    }

    public void A(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
            this.w = z;
        }
    }

    public void B(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2) == null) {
            this.D = i2;
        }
    }

    public void C(boolean z) {
        View view2;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(Constants.METHOD_SEND_USER_MSG, this, z) == null) && (view2 = this.r) != null) {
            if (z) {
                view2.setVisibility(0);
            } else {
                view2.setVisibility(8);
            }
        }
    }

    public void D(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048579, this, z) == null) {
            if (z) {
                this.l.getLayoutParams().height = -1;
                this.c.setVisibility(0);
                return;
            }
            this.l.getLayoutParams().height = -1;
            this.c.setVisibility(8);
        }
    }

    public void E(int i2) {
        ImageView imageView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(1048580, this, i2) == null) && this.c != null && (imageView = this.j) != null) {
            imageView.setVisibility(i2);
        }
    }

    public void H(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048583, this, z) == null) {
            this.C = z;
        }
    }

    public void I(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, onClickListener) == null) {
            this.q = onClickListener;
        }
    }

    public void J(boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048585, this, z) == null) && this.t != z) {
            this.t = z;
            this.z = null;
        }
    }

    public void M(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048588, this, z) == null) {
            this.u = z;
        }
    }

    public void o(String str) {
        up4 up4Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048603, this, str) == null) && (up4Var = this.E) != null) {
            up4Var.e(str);
        }
    }

    public void w(boolean z) {
        View view2;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048611, this, z) == null) && (view2 = this.h) != null) {
            if (z) {
                view2.setVisibility(0);
            } else {
                view2.setVisibility(8);
            }
        }
    }

    public void y(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048613, this, z) == null) {
            this.x = z;
        }
    }

    public void z(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048614, this, z) == null) {
            this.v = z;
        }
    }

    public void F() {
        ImageView imageView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048581, this) == null) && this.c != null && (imageView = this.j) != null && this.k != null) {
            imageView.setVisibility(8);
            this.k.setVisibility(0);
            this.k.setOnClickListener(this.a);
        }
    }

    public void K() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            this.A = true;
            L();
        }
    }

    public void O() {
        NavigationBar navigationBar;
        ImageView imageView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048590, this) == null) && (navigationBar = this.c) != null && navigationBar.getVisibility() == 0 && (imageView = this.i) != null) {
            imageView.setVisibility(8);
        }
    }

    public void h() {
        sv4 sv4Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048596, this) == null) && (sv4Var = this.z) != null) {
            sv4Var.cancel();
        }
    }

    public boolean j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048598, this)) == null) {
            return this.v;
        }
        return invokeV.booleanValue;
    }

    public void l() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048600, this) == null) {
            this.m.setVisibility(8);
        }
    }

    public void m() {
        NoDataView noDataView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048601, this) == null) && (noDataView = this.p) != null) {
            noDataView.setVisibility(8);
            this.l.setVisibility(0);
        }
    }

    public boolean r() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048606, this)) == null) {
            NavigationBar navigationBar = this.c;
            if (navigationBar != null && navigationBar.getVisibility() == 0) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public void u() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048609, this) == null) {
            LinearLayout linearLayout = this.l;
            if (linearLayout != null) {
                linearLayout.removeAllViews();
            }
            NavigationBar navigationBar = this.c;
            if (navigationBar != null) {
                navigationBar.release();
            }
            h();
            up4 up4Var = this.E;
            if (up4Var != null) {
                up4Var.j();
            }
        }
    }

    public void G(String str) {
        ImageView imageView;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, str) == null) {
            NavigationBar navigationBar = this.c;
            if (navigationBar != null) {
                this.d = navigationBar.setCenterTextTitle(str);
                ImageView imageView2 = this.g;
                if (imageView2 != null && imageView2.getVisibility() == 0 && (imageView = this.i) != null && imageView.getVisibility() == 0) {
                    this.d.setMaxWidth(yi.g(this.a.getPageContext().getPageActivity(), R.dimen.obfuscated_res_0x7f07024e) * 2);
                }
                if (!this.A) {
                    SkinManager.setNavbarTitleColor(this.d, R.color.CAM_X0105, R.color.s_navbar_title_color);
                } else {
                    this.d.setTextColor(-1);
                }
                if (this.w) {
                    ImageView imageView3 = (ImageView) this.c.getCenterImgBox();
                    this.e = imageView3;
                    imageView3.setOnClickListener(new a(this));
                    LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.d.getLayoutParams();
                    layoutParams.rightMargin = yi.g(this.a.getActivity(), R.dimen.M_W_X002);
                    this.d.setLayoutParams(layoutParams);
                    LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.e.getLayoutParams();
                    layoutParams2.height = yi.g(this.a.getActivity(), R.dimen.tbds42);
                    layoutParams2.width = yi.g(this.a.getActivity(), R.dimen.tbds42);
                    this.e.setLayoutParams(layoutParams2);
                    this.e.setVisibility(0);
                }
            }
            up4 up4Var = this.E;
            if (up4Var != null) {
                up4Var.g();
            }
        }
    }

    public void s(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048607, this, i2) == null) {
            ContinuousAnimationView continuousAnimationView = this.n;
            if (continuousAnimationView != null) {
                SkinManager.setLottieAnimation(continuousAnimationView, R.raw.lottie_full_screen_refresh);
            }
            FrameLayout frameLayout = this.s;
            if (frameLayout != null) {
                if (this.D == 1) {
                    SkinManager.setBackgroundColor(frameLayout, R.color.black_alpha4);
                } else {
                    SkinManager.setBackgroundColor(frameLayout, R.color.CAM_X0202);
                }
                this.s.setVisibility(8);
            }
            NoDataView noDataView = this.p;
            if (noDataView != null) {
                noDataView.f(this.a.getPageContext(), i2);
            }
            if (!this.A) {
                NavigationBar navigationBar = this.c;
                if (navigationBar != null) {
                    navigationBar.onChangeSkinType(this.a.getPageContext(), i2);
                }
                SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.g, R.drawable.obfuscated_res_0x7f08062e, R.color.CAM_X0106, SvgManager.SvgResourceStateType.NORMAL_PRESS);
                SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.i, R.drawable.obfuscated_res_0x7f080a32, R.color.CAM_X0106, SvgManager.SvgResourceStateType.NORMAL_PRESS);
                SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.j, R.drawable.icon_pure_topbar_more44_svg, R.color.CAM_X0106, SvgManager.SvgResourceStateType.NORMAL_PRESS);
                SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.k, R.drawable.obfuscated_res_0x7f080a47, R.color.CAM_X0106, SvgManager.SvgResourceStateType.NORMAL_PRESS);
            } else if (i2 == 1) {
                this.B.setVisibility(0);
            }
            up4 up4Var = this.E;
            if (up4Var != null) {
                up4Var.f(i2);
            }
            ImageView imageView = this.e;
            if (imageView != null) {
                WebPManager.setPureDrawable(imageView, R.drawable.obfuscated_res_0x7f081254, R.color.CAM_X0105, null);
            }
        }
    }

    public void L() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            LinearLayout linearLayout = this.l;
            if (linearLayout != null) {
                linearLayout.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
            }
            NavigationBar navigationBar = this.c;
            if (navigationBar != null && this.j != null && this.k != null) {
                navigationBar.setBackgroundDrawable(null);
                this.c.setBackgroundColor(R.color.transparent);
                this.c.setBackgroundResource(R.drawable.obfuscated_res_0x7f08127e);
                this.j.setVisibility(8);
                this.k.setVisibility(0);
                this.k.setOnClickListener(this.a);
                this.d.setTextColor(-1);
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.k.getLayoutParams();
                layoutParams.width = yi.g(this.a, R.dimen.tbds100);
                layoutParams.height = yi.g(this.a, R.dimen.tbds100);
                SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.i, R.drawable.obfuscated_res_0x7f080a32, R.color.CAM_X0101, SvgManager.SvgResourceStateType.NORMAL_PRESS);
                SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.g, R.drawable.obfuscated_res_0x7f08062e, R.color.CAM_X0101, SvgManager.SvgResourceStateType.NORMAL_PRESS);
                SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.k, R.drawable.obfuscated_res_0x7f080a47, R.color.CAM_X0101, SvgManager.SvgResourceStateType.NORMAL_PRESS);
            }
        }
    }

    public final void N() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            if (this.y == null) {
                c19 c19Var = new c19(this.a);
                ArrayList arrayList = new ArrayList();
                c19.b bVar = new c19.b(this.a.getString(R.string.obfuscated_res_0x7f0f104a), c19Var);
                bVar.h(new i(this));
                arrayList.add(bVar);
                c19Var.g(new j(this));
                c19Var.f(arrayList);
                k68 k68Var = new k68(this.a, c19Var.b());
                this.y = k68Var;
                k68Var.a(0.7f);
            }
            this.y.show();
        }
    }

    public final ProgressBar i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048597, this)) == null) {
            if (this.o == null) {
                ProgressBar progressBar = new ProgressBar(this.a.getActivity(), null, 16842871);
                this.o = progressBar;
                progressBar.setIndeterminateDrawable(ResourcesCompat.getDrawable(this.a.getActivity().getResources(), R.drawable.obfuscated_res_0x7f081008, null));
                FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
                layoutParams.gravity = 17;
                this.o.setLayoutParams(layoutParams);
                this.s.addView(this.o);
            }
            return this.o;
        }
        return (ProgressBar) invokeV.objValue;
    }

    public void v() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048610, this) == null) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.l.getLayoutParams();
            layoutParams.addRule(3, R.id.obfuscated_res_0x7f092613);
            this.l.setLayoutParams(layoutParams);
            ImageView imageView = this.g;
            if (imageView != null) {
                imageView.setBackgroundDrawable(null);
            }
            ImageView imageView2 = this.i;
            if (imageView2 != null) {
                imageView2.setBackgroundDrawable(null);
            }
            ImageView imageView3 = this.j;
            if (imageView3 != null) {
                imageView3.setBackgroundDrawable(null);
            }
            ImageView imageView4 = this.k;
            if (imageView4 != null) {
                imageView4.setBackgroundDrawable(null);
            }
            NavigationBar navigationBar = this.c;
            if (navigationBar != null) {
                navigationBar.showBottomLine(true);
            }
            BaseWebViewActivity baseWebViewActivity = this.a;
            if (baseWebViewActivity != null) {
                baseWebViewActivity.getWindow().clearFlags(1024);
            }
        }
    }

    public void x() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048612, this) == null) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.l.getLayoutParams();
            layoutParams.addRule(3, 0);
            layoutParams.height = -1;
            this.l.setLayoutParams(layoutParams);
            NavigationBar navigationBar = this.c;
            if (navigationBar != null) {
                navigationBar.getBackground().mutate().setAlpha(0);
                this.c.showBottomLine(false);
            }
            SkinManager.setBackgroundResource(this.g, R.drawable.obfuscated_res_0x7f0805a2);
            SkinManager.setBackgroundResource(this.i, R.drawable.obfuscated_res_0x7f0805a2);
            SkinManager.setBackgroundResource(this.j, R.drawable.obfuscated_res_0x7f0805a2);
            SkinManager.setBackgroundResource(this.k, R.drawable.obfuscated_res_0x7f0805a2);
            G("");
            this.a.getWindow().setFlags(1024, 1024);
        }
    }

    public void P() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048591, this) == null) {
            int a2 = BdListViewHelper.a(BdListViewHelper.HeadType.DEFAULT);
            if (this.p == null) {
                this.p = NoDataViewFactory.a(this.a.getPageContext().getPageActivity(), this.b, NoDataViewFactory.d.b(NoDataViewFactory.ImgType.WEBVIEW, a2), NoDataViewFactory.e.d(null, this.a.getPageContext().getString(R.string.obfuscated_res_0x7f0f1537)), NoDataViewFactory.c.a(new NoDataViewFactory.b(this.a.getResources().getString(R.string.obfuscated_res_0x7f0f100a), this.q)));
            }
            if (!BdNetTypeUtil.isNetworkAvailableForImmediately()) {
                this.p.g(NoDataViewFactory.d.b(NoDataViewFactory.ImgType.NETERROR, a2), this.a.getPageContext());
            } else {
                this.p.g(NoDataViewFactory.d.b(NoDataViewFactory.ImgType.WEBVIEW, a2), this.a.getPageContext());
            }
            this.l.setVisibility(8);
            this.p.setVisibility(0);
        }
    }

    public final void Q() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048592, this) == null) {
            if (this.z == null) {
                uv4 uv4Var = new uv4(this.a);
                uv4Var.m(new e(this));
                ArrayList arrayList = new ArrayList();
                if (this.t) {
                    qv4 qv4Var = new qv4(uv4Var);
                    qv4Var.n(this.a.getString(R.string.obfuscated_res_0x7f0f11b9));
                    qv4Var.m(new f(this));
                    arrayList.add(qv4Var);
                }
                qv4 qv4Var2 = new qv4(uv4Var);
                qv4Var2.n(this.a.getString(R.string.obfuscated_res_0x7f0f045e));
                qv4Var2.m(new g(this));
                arrayList.add(qv4Var2);
                qv4 qv4Var3 = new qv4(uv4Var);
                qv4Var3.n(this.a.getString(R.string.obfuscated_res_0x7f0f0d42));
                qv4Var3.m(new h(this));
                arrayList.add(qv4Var3);
                uv4Var.j(arrayList);
                this.z = new sv4(this.a.getPageContext(), uv4Var);
            }
            this.z.show();
        }
    }

    public void R() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048593, this) == null) && TbSingleton.getInstance().isCanWebViewActivityShowProgress() && this.C) {
            this.s.setVisibility(0);
            if (this.D == 1) {
                this.o = i();
                this.n.setVisibility(8);
                this.o.setVisibility(0);
            } else {
                ProgressBar progressBar = this.o;
                if (progressBar != null) {
                    progressBar.setVisibility(8);
                }
                this.n.setVisibility(0);
                this.n.playAnimation();
            }
            NavigationBar navigationBar = this.c;
            if (navigationBar != null) {
                SkinManager.setBackgroundResource(navigationBar.getBarBgView(), R.color.CAM_X0201);
                SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.g, R.drawable.obfuscated_res_0x7f08062e, R.color.CAM_X0106, SvgManager.SvgResourceStateType.NORMAL_PRESS);
                SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.i, R.drawable.obfuscated_res_0x7f080a32, R.color.CAM_X0106, SvgManager.SvgResourceStateType.NORMAL_PRESS);
                SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.j, R.drawable.icon_pure_topbar_more44_svg, R.color.CAM_X0106, SvgManager.SvgResourceStateType.NORMAL_PRESS);
                SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.k, R.drawable.obfuscated_res_0x7f080a47, R.color.CAM_X0106, SvgManager.SvgResourceStateType.NORMAL_PRESS);
            }
        }
    }

    public void S(ShareItem shareItem) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048594, this, shareItem) != null) || shareItem == null) {
            return;
        }
        TiebaStatic.eventStat(this.a.getPageContext().getPageActivity(), "share", "click", 1, new Object[0]);
        StatisticItem statisticItem = new StatisticItem("c10898");
        statisticItem.param(TiebaStatic.Params.OBJ_URL, shareItem.x);
        statisticItem.param("obj_type", 0);
        TiebaStatic.log(statisticItem);
        if (shareItem.q) {
            ShareDialogConfig shareDialogConfig = new ShareDialogConfig((Context) this.a, shareItem, true, (SparseArray<String>) null);
            shareDialogConfig.mShowMoreForumShare = true;
            c66.c().l(shareDialogConfig);
            return;
        }
        MessageManager.getInstance().sendMessage(new CustomMessage(2001276, new ShareDialogConfig((Context) this.a, shareItem, true, k())));
    }

    public void T(boolean z, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZL(1048595, this, z, str) == null) {
            BdTopToast bdTopToast = new BdTopToast(this.a);
            bdTopToast.h(z);
            bdTopToast.g(str);
            bdTopToast.i(this.b);
        }
    }

    public final SparseArray<String> k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048599, this)) == null) {
            SparseArray<String> sparseArray = new SparseArray<>(8);
            sparseArray.put(2, "pb_wx_timeline");
            sparseArray.put(3, "pb_wx_friend");
            sparseArray.put(4, "pb_qq_zone");
            sparseArray.put(5, "pb_tencent_weibo");
            sparseArray.put(6, "pb_sina_weibo");
            sparseArray.put(7, "pb_renren");
            return sparseArray;
        }
        return (SparseArray) invokeV.objValue;
    }

    public void n() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048602, this) == null) && this.C) {
            this.n.setVisibility(8);
            this.n.cancelAnimation();
            ProgressBar progressBar = this.o;
            if (progressBar != null) {
                progressBar.setVisibility(8);
            }
            this.s.setVisibility(8);
            NavigationBar navigationBar = this.c;
            if (navigationBar != null) {
                SkinManager.setBackgroundResource(navigationBar.getBarBgView(), R.color.common_color_10022);
            }
        }
    }

    public boolean q() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048605, this)) == null) {
            try {
                this.l.addView(this.a.createWebView());
                this.m.setVisibility(8);
                if (!this.u) {
                    this.c.setStatusBarVisibility(8);
                    return true;
                }
                return true;
            } catch (Exception e2) {
                this.m.setVisibility(0);
                BdLog.e(e2.getMessage());
                return false;
            }
        }
        return invokeV.booleanValue;
    }

    public final void p() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048604, this) == null) {
            this.a.setContentView(R.layout.obfuscated_res_0x7f0d0145);
            this.b = (ViewGroup) this.a.findViewById(R.id.obfuscated_res_0x7f091cd4);
            this.c = (NavigationBar) this.a.findViewById(R.id.obfuscated_res_0x7f092613);
            this.B = this.a.findViewById(R.id.obfuscated_res_0x7f0916fc);
            this.s = (FrameLayout) this.b.findViewById(R.id.obfuscated_res_0x7f0926b9);
            this.c.showBottomLine();
            G("");
            if (this.a.isTranslucent()) {
                SkinManager.setBackgroundColor(this.b, this.a.getResources().getColor(R.color.black_alpha0));
                this.b.setOnClickListener(this.a);
                this.c.setVisibility(8);
            }
            LinearLayout linearLayout = (LinearLayout) this.a.findViewById(R.id.obfuscated_res_0x7f0926aa);
            this.l = linearLayout;
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) linearLayout.getLayoutParams();
            layoutParams.addRule(3, R.id.obfuscated_res_0x7f092613);
            this.l.setLayoutParams(layoutParams);
            this.m = (TextView) this.a.findViewById(R.id.obfuscated_res_0x7f0926ac);
            this.n = (ContinuousAnimationView) this.a.findViewById(R.id.obfuscated_res_0x7f0926b7);
            this.o = (ProgressBar) this.a.findViewById(R.id.obfuscated_res_0x7f0926b8);
            SkinManager.setLottieAnimation(this.n, R.raw.lottie_full_screen_refresh);
            View addCustomView = this.c.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_LEFT, R.layout.obfuscated_res_0x7f0d0939, new b(this));
            this.f = addCustomView;
            ImageView imageView = (ImageView) addCustomView.findViewById(R.id.obfuscated_res_0x7f0926cf);
            this.g = imageView;
            imageView.setContentDescription(this.a.getResources().getString(R.string.obfuscated_res_0x7f0f02cf));
            View addCustomView2 = this.c.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_LEFT, R.layout.obfuscated_res_0x7f0d093c, new c(this));
            this.h = addCustomView2;
            ImageView imageView2 = (ImageView) addCustomView2.findViewById(R.id.obfuscated_res_0x7f0926cf);
            this.i = imageView2;
            imageView2.setContentDescription(this.a.getResources().getString(R.string.obfuscated_res_0x7f0f0402));
            LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.i.getLayoutParams();
            layoutParams2.leftMargin = yi.g(this.a.getPageContext().getPageActivity(), R.dimen.obfuscated_res_0x7f070224);
            this.i.setLayoutParams(layoutParams2);
            View addCustomView3 = this.c.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.obfuscated_res_0x7f0d093d, new d(this));
            this.r = addCustomView3;
            this.j = (ImageView) addCustomView3.findViewById(R.id.obfuscated_res_0x7f0926d0);
            this.k = (ImageView) this.r.findViewById(R.id.obfuscated_res_0x7f0926d1);
            up4 up4Var = new up4(this.c, this.l);
            this.E = up4Var;
            up4Var.a(new tp4(this.g, R.drawable.obfuscated_res_0x7f08062e), new tp4(this.i, R.drawable.obfuscated_res_0x7f080a32), new tp4(this.j, R.drawable.icon_pure_topbar_more44_svg), new tp4(this.k, R.drawable.obfuscated_res_0x7f080a47), new tp4(this.c.getCenterText(), 0));
        }
    }

    public void t(int i2, int i3, int i4, int i5) {
        up4 up4Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeIIII(1048608, this, i2, i3, i4, i5) == null) && (up4Var = this.E) != null) {
            up4Var.h(i2, i3, i4, i5);
        }
    }
}
