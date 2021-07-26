package com.baidu.tieba.square.square;

import android.os.Bundle;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.BaseFragment;
import com.baidu.tbadk.core.util.TiebaStatic;
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
import d.a.d.e.p.j;
import d.a.p0.s.f0.f;
import d.a.q0.e3.j.h;
/* loaded from: classes4.dex */
public class SquareFragment extends BaseFragment {
    public static /* synthetic */ Interceptable $ic;
    public static boolean p;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public h f21171e;

    /* renamed from: f  reason: collision with root package name */
    public SquareModel f21172f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f21173g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f21174h;

    /* renamed from: i  reason: collision with root package name */
    public long f21175i;
    public TbPageContext<?> j;
    public View k;
    public final SquareModel.a l;
    public final NoNetworkView.b m;
    public final View.OnKeyListener n;
    public final f.g o;

    /* loaded from: classes4.dex */
    public class a implements SquareModel.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ SquareFragment f21176a;

        public a(SquareFragment squareFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {squareFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f21176a = squareFragment;
        }

        @Override // com.baidu.tieba.square.square.SquareModel.a
        public void a(boolean z, String str, d.a.q0.e3.j.f fVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Boolean.valueOf(z), str, fVar}) == null) {
                this.f21176a.f21171e.g(true, "");
                SquareFragment squareFragment = this.f21176a;
                squareFragment.hideLoadingView(squareFragment.f21171e.h());
                if (z && fVar != null && !fVar.g()) {
                    this.f21176a.f21171e.l(this.f21176a.f21172f.F());
                    this.f21176a.f21173g = true;
                    this.f21176a.f21171e.j();
                    this.f21176a.d1();
                }
                if (this.f21176a.f21174h) {
                    this.f21176a.f21174h = false;
                    this.f21176a.e1(true);
                    if (!this.f21176a.f21173g) {
                        this.f21176a.f21171e.j();
                        SquareFragment squareFragment2 = this.f21176a;
                        squareFragment2.showLoadingView(squareFragment2.f21171e.h());
                    }
                } else {
                    if (this.f21176a.f21175i > -1) {
                        long currentTimeMillis = System.currentTimeMillis();
                        TiebaStatic.page(TiebaStatic.OpKey.OP_SQUARE_ENTER, currentTimeMillis - this.f21176a.f21175i, this.f21176a.f21172f.H() - this.f21176a.f21175i, this.f21176a.f21172f.J(), this.f21176a.f21172f.I(), currentTimeMillis - this.f21176a.f21172f.G());
                        this.f21176a.f21175i = -1L;
                    }
                    if (!this.f21176a.f21173g) {
                        if (j.z()) {
                            this.f21176a.f21171e.o(R.string.no_data_text);
                        } else {
                            this.f21176a.f21171e.o(R.string.game_index_no_network_text);
                        }
                    }
                }
                if (!j.z()) {
                    this.f21176a.f21171e.f();
                    if (this.f21176a.f21173g) {
                        return;
                    }
                    this.f21176a.a1();
                    return;
                }
                this.f21176a.j.showToast(str);
                this.f21176a.f21171e.k();
            }
        }
    }

    /* loaded from: classes4.dex */
    public class b implements NoNetworkView.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ SquareFragment f21177e;

        public b(SquareFragment squareFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {squareFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f21177e = squareFragment;
        }

        @Override // com.baidu.tbadk.core.view.NoNetworkView.b
        public void b(boolean z) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeZ(1048576, this, z) == null) && z) {
                this.f21177e.e1(true);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class c implements View.OnKeyListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ SquareFragment f21178e;

        public c(SquareFragment squareFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {squareFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f21178e = squareFragment;
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

    /* loaded from: classes4.dex */
    public class d implements f.g {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ SquareFragment f21179e;

        public d(SquareFragment squareFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {squareFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f21179e = squareFragment;
        }

        @Override // d.a.p0.s.f0.f.g
        public void onListPullRefresh(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
                this.f21179e.e1(true);
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-1344703392, "Lcom/baidu/tieba/square/square/SquareFragment;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(-1344703392, "Lcom/baidu/tieba/square/square/SquareFragment;");
        }
    }

    public SquareFragment() {
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
        this.f21171e = null;
        this.f21172f = null;
        this.f21173g = false;
        this.f21174h = false;
        this.f21175i = -1L;
        this.l = new a(this);
        this.m = new b(this);
        this.n = new c(this);
        this.o = new d(this);
    }

    public final void a1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.f21171e.d(this.m);
        }
    }

    public final void b1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.f21172f.cancelLoadData();
        }
    }

    public final void c1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            h hVar = new h(this.j, getUniqueId(), this.k, this.n);
            this.f21171e = hVar;
            hVar.n(this.o);
        }
    }

    public final void d1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            this.f21171e.m(this.m);
        }
    }

    public final void e1(boolean z) {
        SquareModel squareModel;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048580, this, z) == null) || (squareModel = this.f21172f) == null) {
            return;
        }
        boolean z2 = false;
        boolean z3 = squareModel.F() == null || this.f21172f.F().g();
        boolean z4 = z;
        if (!j.z()) {
            this.f21174h = false;
            z4 = false;
            z3 = true;
        }
        if (this.f21174h) {
            z3 = true;
        } else {
            z2 = z4;
        }
        if (z3 || z2) {
            b1();
            if (z2) {
                this.f21172f.M();
            } else {
                this.f21172f.L();
            }
        }
    }

    public final void initData() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            SquareModel squareModel = new SquareModel(this.j);
            this.f21172f = squareModel;
            squareModel.N(this.l);
            this.f21174h = true;
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, bundle) == null) {
            super.onActivityCreated(bundle);
            this.j = getPageContext();
            this.f21175i = System.currentTimeMillis();
            c1();
            initData();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048583, this, i2) == null) {
            super.onChangeSkinType(i2);
            h hVar = this.f21171e;
            if (hVar != null) {
                hVar.onChangeSkinType(i2);
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, layoutInflater, viewGroup, bundle)) == null) {
            View inflate = layoutInflater.inflate(R.layout.square_fragment_view, (ViewGroup) null);
            this.k = inflate;
            return inflate;
        }
        return (View) invokeLLL.objValue;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            b1();
            super.onDestroy();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onPrimary() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            super.onPrimary();
            e1(this.f21174h);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onResume() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            super.onResume();
            if (p) {
                e1(true);
                p = false;
            }
        }
    }
}
