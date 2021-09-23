package com.baidu.tieba.square.square;

import android.os.Bundle;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import androidx.core.view.InputDeviceCompat;
import c.a.e.e.p.j;
import c.a.q0.s.f0.f;
import c.a.r0.g3.j.h;
import com.baidu.adp.widget.SwipeBackLayout;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.ProxyAdkBaseActivity;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tieba.R;
import com.baidu.tieba.square.square.SquareModel;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
public class SquareActivity extends ProxyAdkBaseActivity<Object> implements SwipeBackLayout.c {
    public static /* synthetic */ Interceptable $ic;
    public static boolean q;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public h f57094e;

    /* renamed from: f  reason: collision with root package name */
    public SquareModel f57095f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f57096g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f57097h;

    /* renamed from: i  reason: collision with root package name */
    public long f57098i;

    /* renamed from: j  reason: collision with root package name */
    public NavigationBar f57099j;
    public TbPageContext<Object> k;
    public View l;
    public final SquareModel.a m;
    public final NoNetworkView.b n;
    public final View.OnKeyListener o;
    public final f.g p;

    /* loaded from: classes7.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ SquareActivity f57100e;

        public a(SquareActivity squareActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {squareActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f57100e = squareActivity;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.f57100e.closeActivity();
            }
        }
    }

    /* loaded from: classes7.dex */
    public class b implements SquareModel.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ SquareActivity f57101a;

        public b(SquareActivity squareActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {squareActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f57101a = squareActivity;
        }

        @Override // com.baidu.tieba.square.square.SquareModel.a
        public void a(boolean z, String str, c.a.r0.g3.j.f fVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Boolean.valueOf(z), str, fVar}) == null) {
                this.f57101a.f57094e.f(true, "");
                SquareActivity squareActivity = this.f57101a;
                squareActivity.hideLoadingView(squareActivity.f57094e.g());
                if (z && fVar != null && !fVar.g()) {
                    this.f57101a.f57094e.j(this.f57101a.f57095f.F());
                    this.f57101a.f57096g = true;
                    this.f57101a.f57094e.h();
                    this.f57101a.v();
                }
                if (this.f57101a.f57097h) {
                    this.f57101a.f57097h = false;
                    this.f57101a.w(true);
                    if (!this.f57101a.f57096g) {
                        this.f57101a.f57094e.h();
                        SquareActivity squareActivity2 = this.f57101a;
                        squareActivity2.showLoadingView(squareActivity2.f57094e.g());
                    }
                } else {
                    if (this.f57101a.f57098i > -1) {
                        long currentTimeMillis = System.currentTimeMillis();
                        TiebaStatic.page(TiebaStatic.OpKey.OP_SQUARE_ENTER, currentTimeMillis - this.f57101a.f57098i, this.f57101a.f57095f.H() - this.f57101a.f57098i, this.f57101a.f57095f.J(), this.f57101a.f57095f.I(), currentTimeMillis - this.f57101a.f57095f.G());
                        this.f57101a.f57098i = -1L;
                    }
                    if (!this.f57101a.f57096g) {
                        if (j.z()) {
                            this.f57101a.f57094e.m(R.string.no_data_text);
                        } else {
                            this.f57101a.f57094e.m(R.string.game_index_no_network_text);
                        }
                    }
                }
                if (!j.z()) {
                    this.f57101a.f57094e.e();
                    if (this.f57101a.f57096g) {
                        return;
                    }
                    this.f57101a.r();
                    return;
                }
                this.f57101a.k.showToast(str);
                this.f57101a.f57094e.i();
            }
        }
    }

    /* loaded from: classes7.dex */
    public class c implements NoNetworkView.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ SquareActivity f57102e;

        public c(SquareActivity squareActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {squareActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f57102e = squareActivity;
        }

        @Override // com.baidu.tbadk.core.view.NoNetworkView.b
        public void onNetworkChange(boolean z) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeZ(1048576, this, z) == null) && z) {
                this.f57102e.w(true);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class d implements View.OnKeyListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ SquareActivity f57103e;

        public d(SquareActivity squareActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {squareActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f57103e = squareActivity;
        }

        @Override // android.view.View.OnKeyListener
        public boolean onKey(View view, int i2, KeyEvent keyEvent) {
            InterceptResult invokeLIL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLIL = interceptable.invokeLIL(1048576, this, view, i2, keyEvent)) == null) {
                if (view instanceof ListView) {
                    ListView listView = (ListView) view;
                    if (keyEvent.getAction() == 0) {
                        if (i2 == 21) {
                            if (listView.getSelectedView() == null) {
                                listView.dispatchKeyEvent(new KeyEvent(0, 19));
                                return true;
                            }
                        } else if (i2 == 22 && listView.getSelectedView() == null) {
                            listView.dispatchKeyEvent(new KeyEvent(0, 20));
                            return true;
                        }
                    }
                    return false;
                }
                return false;
            }
            return invokeLIL.booleanValue;
        }
    }

    /* loaded from: classes7.dex */
    public class e implements f.g {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ SquareActivity f57104e;

        public e(SquareActivity squareActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {squareActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f57104e = squareActivity;
        }

        @Override // c.a.q0.s.f0.f.g
        public void onListPullRefresh(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
                this.f57104e.w(true);
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-1521321087, "Lcom/baidu/tieba/square/square/SquareActivity;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(-1521321087, "Lcom/baidu/tieba/square/square/SquareActivity;");
        }
    }

    public SquareActivity() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f57094e = null;
        this.f57095f = null;
        this.f57096g = false;
        this.f57097h = false;
        this.f57098i = -1L;
        this.m = new b(this);
        this.n = new c(this);
        this.o = new d(this);
        this.p = new e(this);
    }

    @Override // com.baidu.tbadk.ProxyAdkBaseActivity
    public void closeActivity() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            if (!getIntent().getBooleanExtra("back_special", false)) {
                finish();
                return;
            }
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            if (currentAccount != null && currentAccount.length() > 0) {
                c.a.q0.s.a0.b.e(getActivity(), 1);
            } else {
                c.a.q0.s.a0.b.e(getActivity(), 2);
            }
        }
    }

    @Override // com.baidu.adp.widget.SwipeBackLayout.c
    public void disableSwipeBack() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            setSwipeBackEnabled(false);
        }
    }

    @Override // com.baidu.adp.widget.SwipeBackLayout.c
    public void enableSwipeBack() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            setSwipeBackEnabled(true);
        }
    }

    @Override // com.baidu.tbadk.ProxyAdkBaseActivity
    public void onChangeSkinType(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048579, this, i2) == null) {
            super.onChangeSkinType(i2);
            h hVar = this.f57094e;
            if (hVar != null) {
                hVar.onChangeSkinType(i2);
                this.f57099j.onChangeSkinType(getPageContext(), i2);
            }
        }
    }

    @Override // com.baidu.tbadk.ProxyAdkBaseActivity, com.baidu.adp.plugin.pluginBase.PluginAdpBaseActivity, com.baidu.adp.plugin.pluginBase.PluginBaseActivity
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, bundle) == null) {
            super.onCreate(bundle);
            this.k = getPageContext();
            this.f57098i = System.currentTimeMillis();
            this.l = LayoutInflater.from(getPageContext().getPageActivity()).inflate(R.layout.square_view, (ViewGroup) null);
            getPageContext().getPageActivity().setContentView(this.l);
            u();
            t();
        }
    }

    @Override // com.baidu.tbadk.ProxyAdkBaseActivity, com.baidu.adp.plugin.pluginBase.PluginAdpBaseActivity, com.baidu.adp.plugin.pluginBase.PluginBaseActivity
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            s();
            super.onDestroy();
        }
    }

    @Override // com.baidu.tbadk.ProxyAdkBaseActivity, com.baidu.adp.plugin.pluginBase.PluginAdpBaseActivity, com.baidu.adp.plugin.pluginBase.PluginBaseActivity
    public void onResume() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            super.onResume();
            if (q) {
                w(true);
                q = false;
            }
        }
    }

    public final void r() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            this.f57094e.c(this.n);
        }
    }

    public final void s() {
        SquareModel squareModel;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) || (squareModel = this.f57095f) == null) {
            return;
        }
        squareModel.cancelLoadData();
    }

    public final void t() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            SquareModel squareModel = new SquareModel(getPageContext());
            this.f57095f = squareModel;
            squareModel.N(this.m);
            this.f57097h = true;
            w(true);
        }
    }

    public final void u() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            h hVar = new h(getPageContext(), this.l, this.o);
            this.f57094e = hVar;
            hVar.l(this.p);
            NavigationBar navigationBar = (NavigationBar) this.k.getPageActivity().findViewById(R.id.view_navigation_bar);
            this.f57099j = navigationBar;
            navigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new a(this));
            this.f57099j.setTitleText(this.k.getString(R.string.ba_square));
        }
    }

    public final void v() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            this.f57094e.k(this.n);
        }
    }

    public final void w(boolean z) {
        SquareModel squareModel;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048588, this, z) == null) || (squareModel = this.f57095f) == null) {
            return;
        }
        boolean z2 = false;
        boolean z3 = squareModel.F() == null || this.f57095f.F().g();
        boolean z4 = z;
        if (!j.z()) {
            this.f57097h = false;
            z4 = false;
            z3 = true;
        }
        if (this.f57097h) {
            z3 = true;
        } else {
            z2 = z4;
        }
        if (z3 || z2) {
            s();
            if (z2) {
                this.f57095f.M();
            } else {
                this.f57095f.L();
            }
        }
    }
}
