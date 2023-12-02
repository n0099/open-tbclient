package com.baidu.tieba.square.square;

import android.os.Bundle;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.lib.util.BdNetTypeUtil;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.BaseFragment;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tieba.R;
import com.baidu.tieba.fta;
import com.baidu.tieba.hta;
import com.baidu.tieba.p55;
import com.baidu.tieba.square.square.SquareModel;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes8.dex */
public class SquareFragment extends BaseFragment {
    public static /* synthetic */ Interceptable $ic;
    public static boolean l;
    public transient /* synthetic */ FieldHolder $fh;
    public hta a;
    public SquareModel b;
    public boolean c;
    public boolean d;
    public long e;
    public TbPageContext<?> f;
    public View g;
    public final SquareModel.a h;
    public final NoNetworkView.b i;
    public final View.OnKeyListener j;
    public final p55.g k;

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

    /* loaded from: classes8.dex */
    public class a implements SquareModel.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ SquareFragment a;

        public a(SquareFragment squareFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {squareFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = squareFragment;
        }

        @Override // com.baidu.tieba.square.square.SquareModel.a
        public void a(boolean z, String str, fta ftaVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Boolean.valueOf(z), str, ftaVar}) == null) {
                this.a.a.z(true, "");
                SquareFragment squareFragment = this.a;
                squareFragment.hideLoadingView(squareFragment.a.A());
                if (z && ftaVar != null && !ftaVar.g()) {
                    this.a.a.E(this.a.b.X());
                    this.a.c = true;
                    this.a.a.C();
                    this.a.X2();
                }
                if (!this.a.d) {
                    if (this.a.e > -1) {
                        long currentTimeMillis = System.currentTimeMillis();
                        TiebaStatic.page("op_square_enter", currentTimeMillis - this.a.e, this.a.b.Z() - this.a.e, this.a.b.b0(), this.a.b.a0(), currentTimeMillis - this.a.b.Y());
                        this.a.e = -1L;
                    }
                    if (!this.a.c) {
                        if (BdNetTypeUtil.isNetWorkAvailable()) {
                            this.a.a.H(R.string.no_data_text);
                        } else {
                            this.a.a.H(R.string.game_index_no_network_text);
                        }
                    }
                } else {
                    this.a.d = false;
                    this.a.Y2(true);
                    if (!this.a.c) {
                        this.a.a.C();
                        SquareFragment squareFragment2 = this.a;
                        squareFragment2.showLoadingView(squareFragment2.a.A());
                    }
                }
                if (!BdNetTypeUtil.isNetWorkAvailable()) {
                    this.a.a.y();
                    if (!this.a.c) {
                        this.a.U2();
                        return;
                    }
                    return;
                }
                this.a.f.showToast(str);
                this.a.a.D();
            }
        }
    }

    /* loaded from: classes8.dex */
    public class b implements NoNetworkView.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ SquareFragment a;

        public b(SquareFragment squareFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {squareFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = squareFragment;
        }

        @Override // com.baidu.tbadk.core.view.NoNetworkView.b
        public void p(boolean z) {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeZ(1048576, this, z) != null) || !z) {
                return;
            }
            this.a.Y2(true);
        }
    }

    /* loaded from: classes8.dex */
    public class c implements View.OnKeyListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ SquareFragment a;

        public c(SquareFragment squareFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {squareFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = squareFragment;
        }

        @Override // android.view.View.OnKeyListener
        public boolean onKey(View view2, int i, KeyEvent keyEvent) {
            InterceptResult invokeLIL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLIL = interceptable.invokeLIL(1048576, this, view2, i, keyEvent)) == null) {
                if (!(view2 instanceof ListView)) {
                    return false;
                }
                ListView listView = (ListView) view2;
                if (keyEvent.getAction() == 0) {
                    if (i == 21) {
                        if (listView.getSelectedView() == null) {
                            listView.dispatchKeyEvent(new KeyEvent(0, 19));
                            return true;
                        }
                    } else if (i == 22 && listView.getSelectedView() == null) {
                        listView.dispatchKeyEvent(new KeyEvent(0, 20));
                        return true;
                    }
                }
                return false;
            }
            return invokeLIL.booleanValue;
        }
    }

    /* loaded from: classes8.dex */
    public class d implements p55.g {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ SquareFragment a;

        public d(SquareFragment squareFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {squareFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = squareFragment;
        }

        @Override // com.baidu.tieba.p55.g
        public void g(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeZ(1048576, this, z) != null) {
                return;
            }
            this.a.Y2(true);
        }
    }

    public SquareFragment() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.a = null;
        this.b = null;
        this.c = false;
        this.d = false;
        this.e = -1L;
        this.h = new a(this);
        this.i = new b(this);
        this.j = new c(this);
        this.k = new d(this);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, bundle) == null) {
            super.onActivityCreated(bundle);
            this.f = getPageContext();
            this.e = System.currentTimeMillis();
            W2();
            initData();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048583, this, i) == null) {
            super.onChangeSkinType(i);
            hta htaVar = this.a;
            if (htaVar != null) {
                htaVar.onChangeSkinType(i);
            }
        }
    }

    public final void U2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.a.g(this.i);
        }
    }

    public final void V2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.b.cancelLoadData();
        }
    }

    public final void W2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            hta htaVar = new hta(this.f, getUniqueId(), this.g, this.j);
            this.a = htaVar;
            htaVar.G(this.k);
        }
    }

    public final void X2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            this.a.F(this.i);
        }
    }

    public final void initData() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            SquareModel squareModel = new SquareModel(this.f);
            this.b = squareModel;
            squareModel.f0(this.h);
            this.d = true;
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            V2();
            super.onDestroy();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onPrimary() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            super.onPrimary();
            Y2(this.d);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onResume() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            super.onResume();
            if (l) {
                Y2(true);
                l = false;
            }
        }
    }

    public final void Y2(boolean z) {
        SquareModel squareModel;
        boolean z2;
        boolean z3;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeZ(1048580, this, z) != null) || (squareModel = this.b) == null) {
            return;
        }
        boolean z4 = false;
        if (squareModel.X() != null && !this.b.X().g()) {
            z2 = false;
        } else {
            z2 = true;
        }
        if (z) {
            z3 = true;
        } else {
            z3 = false;
        }
        if (!BdNetTypeUtil.isNetWorkAvailable()) {
            this.d = false;
            z3 = false;
            z2 = true;
        }
        if (this.d) {
            z2 = true;
        } else {
            z4 = z3;
        }
        if (!z2 && !z4) {
            return;
        }
        V2();
        if (z4) {
            this.b.e0();
        } else {
            this.b.d0();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, layoutInflater, viewGroup, bundle)) == null) {
            View inflate = layoutInflater.inflate(R.layout.obfuscated_res_0x7f0d0929, (ViewGroup) null);
            this.g = inflate;
            return inflate;
        }
        return (View) invokeLLL.objValue;
    }
}
