package com.baidu.tieba;

import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.safe.SafeHandler;
import com.baidu.adp.lib.util.BdUtilHelper;
import com.baidu.adp.widget.ListView.BdTypeRecyclerView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.sharedPref.SharedPrefHelper;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.slideLoadingLayout.AdvancedAdSlideLoadingLayout;
import com.baidu.tbadk.core.view.slideLoadingLayout.BaseSlideLoadingLayout;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.frs.FrsFragment;
import com.baidu.tieba.play.TbVideoView;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.android.material.appbar.AppBarLayout;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes6.dex */
public class ix7 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public FrsFragment a;
    public AdvancedAdSlideLoadingLayout b;
    public AppBarLayout c;
    public BdTypeRecyclerView d;
    public pj7 e;
    public String f;
    public List<String> g;
    public int h;
    public boolean i;
    public cb5 j;
    public bb5 k;
    public ab5 l;
    public Runnable m;

    /* loaded from: classes6.dex */
    public class a implements cb5 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        @Override // com.baidu.tieba.cb5
        public void a(int i, float f) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Integer.valueOf(i), Float.valueOf(f)}) == null) {
            }
        }

        public a(ix7 ix7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ix7Var};
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

    /* loaded from: classes6.dex */
    public class b implements bb5 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ix7 a;

        @Override // com.baidu.tieba.bb5
        public void onLoadingEnd() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            }
        }

        public b(ix7 ix7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ix7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = ix7Var;
        }

        @Override // com.baidu.tieba.bb5
        public void onLoadingStart() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                this.a.i();
                this.a.i = true;
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921680, 1));
            }
        }
    }

    /* loaded from: classes6.dex */
    public class c implements ab5 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ix7 a;

        @Override // com.baidu.tieba.ab5
        public void a(int i, float f) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Integer.valueOf(i), Float.valueOf(f)}) == null) {
            }
        }

        @Override // com.baidu.tieba.ab5
        public void b(int i, float f) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Integer.valueOf(i), Float.valueOf(f)}) == null) {
            }
        }

        @Override // com.baidu.tieba.ab5
        public void c(int i, float f) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{Integer.valueOf(i), Float.valueOf(f)}) == null) {
            }
        }

        public c(ix7 ix7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ix7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = ix7Var;
        }

        @Override // com.baidu.tieba.ab5
        public void d(int i, float f) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048579, this, new Object[]{Integer.valueOf(i), Float.valueOf(f)}) == null) {
                if (this.a.e != null) {
                    this.a.e.u0();
                }
                if (this.a.i) {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921680, 2));
                }
                this.a.i = false;
            }
        }
    }

    /* loaded from: classes6.dex */
    public class d implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ix7 a;

        public d(ix7 ix7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ix7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = ix7Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.b.o();
            }
        }
    }

    /* loaded from: classes6.dex */
    public class e extends TypeToken<List<String>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public e(ix7 ix7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ix7Var};
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

    public ix7(@NonNull FrsFragment frsFragment) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {frsFragment};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f = "999999";
        this.j = new a(this);
        this.k = new b(this);
        this.l = new c(this);
        this.m = new d(this);
        this.a = frsFragment;
        View k4 = frsFragment.k4();
        AdvancedAdSlideLoadingLayout advancedAdSlideLoadingLayout = (AdvancedAdSlideLoadingLayout) k4.findViewById(R.id.obfuscated_res_0x7f090c8a);
        this.b = advancedAdSlideLoadingLayout;
        advancedAdSlideLoadingLayout.k(this.j);
        this.b.j(this.k);
        this.b.i(this.l);
        this.b.n();
        this.c = (AppBarLayout) k4.findViewById(R.id.obfuscated_res_0x7f090c63);
        this.d = (BdTypeRecyclerView) k4.findViewById(R.id.obfuscated_res_0x7f090d24);
    }

    public void f(e15 e15Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, e15Var) == null) {
            if (e15Var != null && !ei.isEmpty(e15Var.b) && !ei.isEmpty(e15Var.a) && e15Var.c >= 0) {
                if (this.b.v()) {
                    this.b.o();
                }
                this.b.Y(e15Var, (ViewGroup) this.a.getActivity().getWindow().getDecorView());
                this.b.setAdvancedAdStyle(true);
                this.b.setNavigationBar((NavigationBar) this.a.getActivity().findViewById(R.id.view_navigation_bar));
                return;
            }
            this.b.setAdvancedAdStyle(false);
        }
    }

    public void r(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048588, this, i) == null) {
            this.h = i;
        }
    }

    public void s(pj7 pj7Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, pj7Var) == null) {
            this.e = pj7Var;
        }
    }

    public void t(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048590, this, z) == null) {
            this.b.setEnableSlideLoading(z);
        }
    }

    public void v(boolean z) {
        AdvancedAdSlideLoadingLayout advancedAdSlideLoadingLayout;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048592, this, z) == null) && (advancedAdSlideLoadingLayout = this.b) != null) {
            advancedAdSlideLoadingLayout.setEnable(z);
        }
    }

    public final boolean g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            boolean z = false;
            if (this.b.getData() != null && this.b.c0()) {
                e15 data = this.b.getData();
                String currentAccount = TbadkCoreApplication.getCurrentAccount();
                if (currentAccount == null) {
                    currentAccount = this.f;
                }
                String str = currentAccount + data.i;
                List<String> list = (List) new Gson().fromJson(SharedPrefHelper.getInstance().getString("key_uid_adid", ""), new e(this).getType());
                this.g = list;
                if (list == null) {
                    this.g = new ArrayList();
                }
                Iterator<String> it = this.g.iterator();
                while (it.hasNext()) {
                    String next = it.next();
                    if (!StringHelper.isTaday(SharedPrefHelper.getInstance().getLong(next, 0L))) {
                        SharedPrefHelper.getInstance().remove(next);
                        it.remove();
                    }
                }
                if (!StringHelper.isTaday(SharedPrefHelper.getInstance().getLong(str, 0L))) {
                    this.g.add(str);
                    SharedPrefHelper.getInstance().putLong(str, System.currentTimeMillis());
                    z = true;
                }
                SharedPrefHelper.getInstance().putString("key_uid_adid", this.g.toString());
            }
            return z;
        }
        return invokeV.booleanValue;
    }

    public void n() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            View findViewById = this.a.k4().findViewById(R.id.obfuscated_res_0x7f090f0e);
            TbImageView tbImageView = (TbImageView) this.a.getActivity().findViewById(R.id.obfuscated_res_0x7f090f0d);
            tbImageView.setPlaceHolder(2);
            TbVideoView tbVideoView = (TbVideoView) this.a.getActivity().findViewById(R.id.obfuscated_res_0x7f092928);
            TbImageView tbImageView2 = (TbImageView) this.a.getActivity().findViewById(R.id.obfuscated_res_0x7f092922);
            View findViewById2 = this.a.getActivity().findViewById(R.id.obfuscated_res_0x7f092927);
            View findViewById3 = this.a.getActivity().findViewById(R.id.obfuscated_res_0x7f090f2a);
            if (findViewById == null) {
                return;
            }
            this.b.setBgView(findViewById);
            this.b.l(tbImageView2);
            this.b.l(tbVideoView);
            this.b.l(findViewById2);
            int W3 = this.a.W3();
            if (findViewById3.getVisibility() == 0) {
                W3 -= this.a.getResources().getDimensionPixelSize(R.dimen.tbds32);
            }
            if (W3 <= 0) {
                W3 = findViewById.getLayoutParams().height;
            }
            this.b.setAdvancedAdView(tbImageView, W3, BdUtilHelper.getEquipmentWidth(this.a.getContext()));
        }
    }

    public void h() {
        AdvancedAdSlideLoadingLayout advancedAdSlideLoadingLayout;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) && (advancedAdSlideLoadingLayout = this.b) != null) {
            advancedAdSlideLoadingLayout.a0();
        }
    }

    public pj7 j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return this.e;
        }
        return (pj7) invokeV.objValue;
    }

    public int k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return this.b.getLoadingVewMaxHeight();
        }
        return invokeV.intValue;
    }

    public boolean l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            return this.b.v();
        }
        return invokeV.booleanValue;
    }

    public BaseSlideLoadingLayout m() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            return this.b;
        }
        return (BaseSlideLoadingLayout) invokeV.objValue;
    }

    public void o() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            this.b.m(this.a.k4().findViewById(R.id.obfuscated_res_0x7f090ccc), 0);
        }
    }

    public boolean p() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            AdvancedAdSlideLoadingLayout advancedAdSlideLoadingLayout = this.b;
            if (advancedAdSlideLoadingLayout != null) {
                return advancedAdSlideLoadingLayout.d0();
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public void q() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            this.b.o();
            SafeHandler.getInst().removeCallbacks(this.m);
        }
    }

    public void w() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048593, this) == null) && g()) {
            this.b.g0();
        }
    }

    public void x() {
        AdvancedAdSlideLoadingLayout advancedAdSlideLoadingLayout;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048594, this) == null) && (advancedAdSlideLoadingLayout = this.b) != null && advancedAdSlideLoadingLayout.u()) {
            BdTypeRecyclerView bdTypeRecyclerView = this.d;
            if (bdTypeRecyclerView != null) {
                bdTypeRecyclerView.setSelection(0);
            }
            AppBarLayout appBarLayout = this.c;
            if (appBarLayout != null) {
                appBarLayout.setExpanded(true);
            }
            this.b.H();
        }
    }

    public void y() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048595, this) == null) && this.b.v()) {
            this.b.o();
            SafeHandler.getInst().removeCallbacks(this.m);
        }
    }

    public final void i() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            SafeHandler.getInst().postDelayed(this.m, 5000L);
            pj7 pj7Var = this.e;
            if (pj7Var != null) {
                pj7Var.w1();
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921462, 0));
            }
        }
    }

    public void u(int i, boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeCommon(1048591, this, new Object[]{Integer.valueOf(i), Boolean.valueOf(z)}) != null) || i != this.h) {
            return;
        }
        if (z) {
            x();
            return;
        }
        this.d.getAdapter().notifyDataSetChanged();
        y();
    }
}
