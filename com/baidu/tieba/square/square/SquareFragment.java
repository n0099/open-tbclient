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
import c.a.r0.h3.j.h;
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
import java.net.URLEncoder;
/* loaded from: classes7.dex */
public class SquareFragment extends BaseFragment {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String PAGE_NAME = "square_page";
    public static boolean needRefresh;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public h f57039e;

    /* renamed from: f  reason: collision with root package name */
    public SquareModel f57040f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f57041g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f57042h;

    /* renamed from: i  reason: collision with root package name */
    public long f57043i;

    /* renamed from: j  reason: collision with root package name */
    public TbPageContext<?> f57044j;
    public View k;
    public final SquareModel.a l;
    public final NoNetworkView.b m;
    public final View.OnKeyListener n;
    public final f.g o;

    /* loaded from: classes7.dex */
    public class a implements SquareModel.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ SquareFragment f57045a;

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
            this.f57045a = squareFragment;
        }

        @Override // com.baidu.tieba.square.square.SquareModel.a
        public void a(boolean z, String str, c.a.r0.h3.j.f fVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Boolean.valueOf(z), str, fVar}) == null) {
                this.f57045a.f57039e.f(true, "");
                SquareFragment squareFragment = this.f57045a;
                squareFragment.hideLoadingView(squareFragment.f57039e.g());
                if (z && fVar != null && !fVar.g()) {
                    this.f57045a.f57039e.j(this.f57045a.f57040f.F());
                    this.f57045a.f57041g = true;
                    this.f57045a.f57039e.h();
                    this.f57045a.q();
                }
                if (this.f57045a.f57042h) {
                    this.f57045a.f57042h = false;
                    this.f57045a.r(true);
                    if (!this.f57045a.f57041g) {
                        this.f57045a.f57039e.h();
                        SquareFragment squareFragment2 = this.f57045a;
                        squareFragment2.showLoadingView(squareFragment2.f57039e.g());
                    }
                } else {
                    if (this.f57045a.f57043i > -1) {
                        long currentTimeMillis = System.currentTimeMillis();
                        TiebaStatic.page(TiebaStatic.OpKey.OP_SQUARE_ENTER, currentTimeMillis - this.f57045a.f57043i, this.f57045a.f57040f.H() - this.f57045a.f57043i, this.f57045a.f57040f.J(), this.f57045a.f57040f.I(), currentTimeMillis - this.f57045a.f57040f.G());
                        this.f57045a.f57043i = -1L;
                    }
                    if (!this.f57045a.f57041g) {
                        if (j.z()) {
                            this.f57045a.f57039e.m(R.string.no_data_text);
                        } else {
                            this.f57045a.f57039e.m(R.string.game_index_no_network_text);
                        }
                    }
                }
                if (!j.z()) {
                    this.f57045a.f57039e.e();
                    if (this.f57045a.f57041g) {
                        return;
                    }
                    this.f57045a.o();
                    return;
                }
                this.f57045a.f57044j.showToast(str);
                this.f57045a.f57039e.i();
            }
        }
    }

    /* loaded from: classes7.dex */
    public class b implements NoNetworkView.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ SquareFragment f57046e;

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
            this.f57046e = squareFragment;
        }

        @Override // com.baidu.tbadk.core.view.NoNetworkView.b
        public void onNetworkChange(boolean z) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeZ(1048576, this, z) == null) && z) {
                this.f57046e.r(true);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class c implements View.OnKeyListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ SquareFragment f57047e;

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
            this.f57047e = squareFragment;
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
    public class d implements f.g {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ SquareFragment f57048e;

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
            this.f57048e = squareFragment;
        }

        @Override // c.a.q0.s.f0.f.g
        public void onListPullRefresh(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
                this.f57048e.r(true);
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
        this.f57039e = null;
        this.f57040f = null;
        this.f57041g = false;
        this.f57042h = false;
        this.f57043i = -1L;
        this.l = new a(this);
        this.m = new b(this);
        this.n = new c(this);
        this.o = new d(this);
    }

    public static String makeStatisticsParam(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65551, null, str, str2)) == null) {
            StringBuilder sb = new StringBuilder();
            sb.append("square_page");
            try {
                sb.append(URLEncoder.encode("|", "utf-8"));
            } catch (Exception e2) {
                e2.printStackTrace();
                sb.append("|");
            }
            sb.append(str + "_" + str2);
            return sb.toString();
        }
        return (String) invokeLL.objValue;
    }

    public final void initData() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            SquareModel squareModel = new SquareModel(this.f57044j);
            this.f57040f = squareModel;
            squareModel.N(this.l);
            this.f57042h = true;
        }
    }

    public final void initUI() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            h hVar = new h(this.f57044j, getUniqueId(), this.k, this.n);
            this.f57039e = hVar;
            hVar.l(this.o);
        }
    }

    public final void o() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.f57039e.c(this.m);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, bundle) == null) {
            super.onActivityCreated(bundle);
            this.f57044j = getPageContext();
            this.f57043i = System.currentTimeMillis();
            initUI();
            initData();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048580, this, i2) == null) {
            super.onChangeSkinType(i2);
            h hVar = this.f57039e;
            if (hVar != null) {
                hVar.onChangeSkinType(i2);
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048581, this, layoutInflater, viewGroup, bundle)) == null) {
            View inflate = layoutInflater.inflate(R.layout.square_fragment_view, (ViewGroup) null);
            this.k = inflate;
            return inflate;
        }
        return (View) invokeLLL.objValue;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            p();
            super.onDestroy();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onPrimary() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            super.onPrimary();
            r(this.f57042h);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onResume() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            super.onResume();
            if (needRefresh) {
                r(true);
                needRefresh = false;
            }
        }
    }

    public final void p() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            this.f57040f.cancelLoadData();
        }
    }

    public final void q() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            this.f57039e.k(this.m);
        }
    }

    public final void r(boolean z) {
        SquareModel squareModel;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048587, this, z) == null) || (squareModel = this.f57040f) == null) {
            return;
        }
        boolean z2 = false;
        boolean z3 = squareModel.F() == null || this.f57040f.F().g();
        boolean z4 = z;
        if (!j.z()) {
            this.f57042h = false;
            z4 = false;
            z3 = true;
        }
        if (this.f57042h) {
            z3 = true;
        } else {
            z2 = z4;
        }
        if (z3 || z2) {
            p();
            if (z2) {
                this.f57040f.M();
            } else {
                this.f57040f.L();
            }
        }
    }
}
