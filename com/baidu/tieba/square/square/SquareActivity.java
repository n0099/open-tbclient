package com.baidu.tieba.square.square;

import android.os.Bundle;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.lib.util.BdNetTypeUtil;
import com.baidu.adp.widget.SwipeBackLayout;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tieba.R;
import com.baidu.tieba.q9a;
import com.baidu.tieba.s9a;
import com.baidu.tieba.sa5;
import com.baidu.tieba.square.square.SquareModel;
import com.baidu.tieba.y95;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
public class SquareActivity extends BaseActivity<Object> implements SwipeBackLayout.c {
    public static /* synthetic */ Interceptable $ic;
    public static boolean m;
    public transient /* synthetic */ FieldHolder $fh;
    public s9a a;
    public SquareModel b;
    public boolean c;
    public boolean d;
    public long e;
    public NavigationBar f;
    public TbPageContext<Object> g;
    public View h;
    public final SquareModel.a i;
    public final NoNetworkView.b j;
    public final View.OnKeyListener k;
    public final sa5.g l;

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

    /* loaded from: classes7.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ SquareActivity a;

        public a(SquareActivity squareActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {squareActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = squareActivity;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                this.a.closeActivity();
            }
        }
    }

    /* loaded from: classes7.dex */
    public class b implements SquareModel.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ SquareActivity a;

        public b(SquareActivity squareActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {squareActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = squareActivity;
        }

        @Override // com.baidu.tieba.square.square.SquareModel.a
        public void a(boolean z, String str, q9a q9aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Boolean.valueOf(z), str, q9aVar}) == null) {
                this.a.a.B(true, "");
                SquareActivity squareActivity = this.a;
                squareActivity.hideLoadingView(squareActivity.a.C());
                if (z && q9aVar != null && !q9aVar.g()) {
                    this.a.a.F(this.a.b.e0());
                    this.a.c = true;
                    this.a.a.D();
                    this.a.L1();
                }
                if (this.a.d) {
                    this.a.d = false;
                    this.a.M1(true);
                    if (!this.a.c) {
                        this.a.a.D();
                        SquareActivity squareActivity2 = this.a;
                        squareActivity2.showLoadingView(squareActivity2.a.C());
                    }
                } else {
                    if (this.a.e > -1) {
                        long currentTimeMillis = System.currentTimeMillis();
                        TiebaStatic.page(TiebaStatic.OpKey.OP_SQUARE_ENTER, currentTimeMillis - this.a.e, this.a.b.g0() - this.a.e, this.a.b.i0(), this.a.b.h0(), currentTimeMillis - this.a.b.f0());
                        this.a.e = -1L;
                    }
                    if (!this.a.c) {
                        if (BdNetTypeUtil.isNetWorkAvailable()) {
                            this.a.a.I(R.string.no_data_text);
                        } else {
                            this.a.a.I(R.string.game_index_no_network_text);
                        }
                    }
                }
                if (!BdNetTypeUtil.isNetWorkAvailable()) {
                    this.a.a.z();
                    if (this.a.c) {
                        return;
                    }
                    this.a.I1();
                    return;
                }
                this.a.g.showToast(str);
                this.a.a.E();
            }
        }
    }

    /* loaded from: classes7.dex */
    public class c implements NoNetworkView.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ SquareActivity a;

        public c(SquareActivity squareActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {squareActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = squareActivity;
        }

        @Override // com.baidu.tbadk.core.view.NoNetworkView.b
        public void j(boolean z) {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeZ(1048576, this, z) != null) || !z) {
                return;
            }
            this.a.M1(true);
        }
    }

    /* loaded from: classes7.dex */
    public class d implements View.OnKeyListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ SquareActivity a;

        public d(SquareActivity squareActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {squareActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = squareActivity;
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

    /* loaded from: classes7.dex */
    public class e implements sa5.g {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ SquareActivity a;

        public e(SquareActivity squareActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {squareActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = squareActivity;
        }

        @Override // com.baidu.tieba.sa5.g
        public void e(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeZ(1048576, this, z) != null) {
                return;
            }
            this.a.M1(true);
        }
    }

    public SquareActivity() {
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
        this.i = new b(this);
        this.j = new c(this);
        this.k = new d(this);
        this.l = new e(this);
    }

    public final void K1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            s9a s9aVar = new s9a(getPageContext(), this.h, this.k);
            this.a = s9aVar;
            s9aVar.H(this.l);
            NavigationBar navigationBar = (NavigationBar) this.g.getPageActivity().findViewById(R.id.view_navigation_bar);
            this.f = navigationBar;
            navigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new a(this));
            this.f.setTitleText(this.g.getString(R.string.obfuscated_res_0x7f0f0307));
        }
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048585, this, i) == null) {
            super.onChangeSkinType(i);
            s9a s9aVar = this.a;
            if (s9aVar != null) {
                s9aVar.onChangeSkinType(i);
                this.f.onChangeSkinType(getPageContext(), i);
            }
        }
    }

    public final void I1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.a.x(this.j);
        }
    }

    public final void J1() {
        SquareModel squareModel;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) && (squareModel = this.b) != null) {
            squareModel.cancelLoadData();
        }
    }

    @Override // com.baidu.adp.widget.SwipeBackLayout.c
    public void K0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            setSwipeBackEnabled(false);
        }
    }

    public final void L1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            this.a.G(this.j);
        }
    }

    public final void initData() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            SquareModel squareModel = new SquareModel(getPageContext());
            this.b = squareModel;
            squareModel.m0(this.i);
            this.d = true;
            M1(true);
        }
    }

    @Override // com.baidu.adp.widget.SwipeBackLayout.c
    public void m0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            setSwipeBackEnabled(true);
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            J1();
            super.onDestroy();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            super.onResume();
            if (m) {
                M1(true);
                m = false;
            }
        }
    }

    public final void M1(boolean z) {
        SquareModel squareModel;
        boolean z2;
        boolean z3;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeZ(1048581, this, z) != null) || (squareModel = this.b) == null) {
            return;
        }
        boolean z4 = false;
        if (squareModel.e0() != null && !this.b.e0().g()) {
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
        J1();
        if (z4) {
            this.b.l0();
        } else {
            this.b.k0();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, bundle) == null) {
            super.onCreate(bundle);
            this.g = getPageContext();
            this.e = System.currentTimeMillis();
            this.h = LayoutInflater.from(getPageContext().getPageActivity()).inflate(R.layout.obfuscated_res_0x7f0d08f0, (ViewGroup) null);
            getPageContext().getPageActivity().setContentView(this.h);
            K1();
            initData();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void closeActivity() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            if (!getIntent().getBooleanExtra("back_special", false)) {
                finish();
                return;
            }
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            if (currentAccount != null && currentAccount.length() > 0) {
                y95.e(getActivity(), 1);
            } else {
                y95.e(getActivity(), 2);
            }
        }
    }
}
