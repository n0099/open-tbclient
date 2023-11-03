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
/* loaded from: classes7.dex */
public class p48 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public FrsFragment a;
    public AdvancedAdSlideLoadingLayout b;
    public AppBarLayout c;
    public BdTypeRecyclerView d;
    public zq7 e;
    public String f;
    public List<String> g;
    public int h;
    public boolean i;
    public i65 j;
    public h65 k;
    public g65 l;
    public Runnable m;

    /* loaded from: classes7.dex */
    public class a implements i65 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        @Override // com.baidu.tieba.i65
        public void a(int i, float f) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Integer.valueOf(i), Float.valueOf(f)}) == null) {
            }
        }

        public a(p48 p48Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {p48Var};
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
    public class b implements h65 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ p48 a;

        @Override // com.baidu.tieba.h65
        public void onLoadingEnd() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            }
        }

        public b(p48 p48Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {p48Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = p48Var;
        }

        @Override // com.baidu.tieba.h65
        public void onLoadingStart() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                this.a.i();
                this.a.i = true;
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921680, 1));
            }
        }
    }

    /* loaded from: classes7.dex */
    public class c implements g65 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ p48 a;

        @Override // com.baidu.tieba.g65
        public void a(int i, float f) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Integer.valueOf(i), Float.valueOf(f)}) == null) {
            }
        }

        @Override // com.baidu.tieba.g65
        public void b(int i, float f) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Integer.valueOf(i), Float.valueOf(f)}) == null) {
            }
        }

        @Override // com.baidu.tieba.g65
        public void c(int i, float f) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{Integer.valueOf(i), Float.valueOf(f)}) == null) {
            }
        }

        public c(p48 p48Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {p48Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = p48Var;
        }

        @Override // com.baidu.tieba.g65
        public void d(int i, float f) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048579, this, new Object[]{Integer.valueOf(i), Float.valueOf(f)}) == null) {
                if (this.a.e != null) {
                    this.a.e.J0();
                }
                if (this.a.i) {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921680, 2));
                }
                this.a.i = false;
            }
        }
    }

    /* loaded from: classes7.dex */
    public class d implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ p48 a;

        public d(p48 p48Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {p48Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = p48Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.b.o();
            }
        }
    }

    /* loaded from: classes7.dex */
    public class e extends TypeToken<List<String>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public e(p48 p48Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {p48Var};
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

    public p48(@NonNull FrsFragment frsFragment) {
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
        View H4 = frsFragment.H4();
        AdvancedAdSlideLoadingLayout advancedAdSlideLoadingLayout = (AdvancedAdSlideLoadingLayout) H4.findViewById(R.id.obfuscated_res_0x7f090cc8);
        this.b = advancedAdSlideLoadingLayout;
        advancedAdSlideLoadingLayout.k(this.j);
        this.b.j(this.k);
        this.b.i(this.l);
        this.b.n();
        this.c = (AppBarLayout) H4.findViewById(R.id.obfuscated_res_0x7f090ca1);
        this.d = (BdTypeRecyclerView) H4.findViewById(R.id.obfuscated_res_0x7f090d67);
    }

    public void f(ew4 ew4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, ew4Var) == null) {
            if (ew4Var != null && !qd.isEmpty(ew4Var.b) && !qd.isEmpty(ew4Var.a) && ew4Var.c >= 0) {
                if (this.b.v()) {
                    this.b.o();
                }
                this.b.Y(ew4Var, (ViewGroup) this.a.getActivity().getWindow().getDecorView());
                this.b.setAdvancedAdStyle(true);
                this.b.setNavigationBar((NavigationBar) this.a.getActivity().findViewById(R.id.view_navigation_bar));
                return;
            }
            this.b.setAdvancedAdStyle(false);
        }
    }

    public void s(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048589, this, i) == null) {
            this.h = i;
        }
    }

    public void t(zq7 zq7Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, zq7Var) == null) {
            this.e = zq7Var;
        }
    }

    public void u(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048591, this, z) == null) {
            this.b.setEnableSlideLoading(z);
        }
    }

    public void w(boolean z) {
        AdvancedAdSlideLoadingLayout advancedAdSlideLoadingLayout;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048593, this, z) == null) && (advancedAdSlideLoadingLayout = this.b) != null) {
            advancedAdSlideLoadingLayout.setEnable(z);
        }
    }

    public final boolean g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            boolean z = false;
            if (this.b.getData() != null && this.b.c0()) {
                ew4 data = this.b.getData();
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
            View findViewById = this.a.H4().findViewById(R.id.obfuscated_res_0x7f090f55);
            TbImageView tbImageView = (TbImageView) this.a.getActivity().findViewById(R.id.obfuscated_res_0x7f090f54);
            tbImageView.setPlaceHolder(2);
            TbVideoView tbVideoView = (TbVideoView) this.a.getActivity().findViewById(R.id.obfuscated_res_0x7f092949);
            TbImageView tbImageView2 = (TbImageView) this.a.getActivity().findViewById(R.id.obfuscated_res_0x7f092943);
            View findViewById2 = this.a.getActivity().findViewById(R.id.obfuscated_res_0x7f092948);
            View findViewById3 = this.a.getActivity().findViewById(R.id.obfuscated_res_0x7f090f71);
            if (findViewById == null) {
                return;
            }
            this.b.setBgView(findViewById);
            this.b.l(tbImageView2);
            this.b.l(tbVideoView);
            this.b.l(findViewById2);
            int u4 = this.a.u4();
            if (findViewById3.getVisibility() == 0) {
                u4 -= this.a.getResources().getDimensionPixelSize(R.dimen.tbds32);
            }
            if (u4 <= 0) {
                u4 = findViewById.getLayoutParams().height;
            }
            this.b.setAdvancedAdView(tbImageView, u4, BdUtilHelper.getEquipmentWidth(this.a.getContext()));
        }
    }

    public void h() {
        AdvancedAdSlideLoadingLayout advancedAdSlideLoadingLayout;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) && (advancedAdSlideLoadingLayout = this.b) != null) {
            advancedAdSlideLoadingLayout.a0();
        }
    }

    public zq7 j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return this.e;
        }
        return (zq7) invokeV.objValue;
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
            this.b.m(this.a.H4().findViewById(R.id.obfuscated_res_0x7f090d0f), 0);
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

    public void x() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048594, this) == null) && g()) {
            this.b.g0();
        }
    }

    public void y() {
        AdvancedAdSlideLoadingLayout advancedAdSlideLoadingLayout;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048595, this) == null) && (advancedAdSlideLoadingLayout = this.b) != null && advancedAdSlideLoadingLayout.u()) {
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

    public void z() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048596, this) == null) && this.b.v()) {
            this.b.o();
            SafeHandler.getInst().removeCallbacks(this.m);
        }
    }

    public final void i() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            SafeHandler.getInst().postDelayed(this.m, 5000L);
            zq7 zq7Var = this.e;
            if (zq7Var != null) {
                zq7Var.O1();
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921462, 0));
            }
        }
    }

    public void r() {
        View findViewById;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048588, this) == null) && (findViewById = this.a.H4().findViewById(R.id.obfuscated_res_0x7f090f55)) != null && findViewById.getLayoutParams() != null && this.b != null) {
            this.b.m(findViewById, findViewById.getLayoutParams().height);
        }
    }

    public void v(int i, boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeCommon(1048592, this, new Object[]{Integer.valueOf(i), Boolean.valueOf(z)}) != null) || i != this.h) {
            return;
        }
        if (z) {
            y();
            return;
        }
        this.d.getAdapter().notifyDataSetChanged();
        z();
    }
}
