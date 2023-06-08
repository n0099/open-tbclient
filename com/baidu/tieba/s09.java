package com.baidu.tieba;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.view.NoDataView;
import com.baidu.tbadk.core.view.NoDataViewFactory;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tbadk.widget.dragsort.SimpleDragSortListView;
import com.baidu.tieba.faceshop.EmotionPackageData;
import com.baidu.tieba.zy5;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.List;
/* loaded from: classes7.dex */
public class s09 implements Object<List<EmotionPackageData>> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TbPageContext a;
    public SimpleDragSortListView b;
    public View c;
    public m09 d;
    public q09 e;
    public vm5 f;
    public FrameLayout g;
    public boolean h;
    public k09 i;
    public NoDataView j;
    public NoNetworkView k;

    /* loaded from: classes7.dex */
    public class a implements zy5.i {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ s09 a;

        public a(s09 s09Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {s09Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = s09Var;
        }

        @Override // com.baidu.tieba.zy5.i
        public void a(int i, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeII(1048576, this, i, i2) == null) {
                this.a.d.a(i, i2);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ List a;
        public final /* synthetic */ s09 b;

        public b(s09 s09Var, List list) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {s09Var, list};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = s09Var;
            this.a = list;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.b.j();
                if (this.b.d != null && this.a != null) {
                    this.b.d.update(this.a);
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class c implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ s09 a;

        public c(s09 s09Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {s09Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = s09Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && this.a.d != null) {
                this.a.d.update();
            }
        }
    }

    public s09(TbPageContext tbPageContext) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.h = false;
        this.a = tbPageContext;
        View inflate = LayoutInflater.from(tbPageContext.getPageActivity()).inflate(R.layout.obfuscated_res_0x7f0d031d, (ViewGroup) null, false);
        this.c = inflate;
        this.g = (FrameLayout) inflate.findViewById(R.id.obfuscated_res_0x7f0917b7);
        this.k = (NoNetworkView) this.c.findViewById(R.id.view_no_network);
        this.e = new q09(this.c.findViewById(R.id.obfuscated_res_0x7f0909bb), tbPageContext.getString(R.string.obfuscated_res_0x7f0f0632));
        SimpleDragSortListView simpleDragSortListView = (SimpleDragSortListView) this.c.findViewById(R.id.obfuscated_res_0x7f0917b6);
        this.b = simpleDragSortListView;
        simpleDragSortListView.setDivider(null);
        this.b.setOverScrollMode(2);
        this.b.setVerticalScrollBarEnabled(false);
        k();
        this.d = new m09(tbPageContext, this.b, this.i);
        l();
        this.k.a(this);
    }

    public void i(boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048582, this, z) == null) && z) {
            l();
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921054));
        }
    }

    public View c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return this.c;
        }
        return (View) invokeV.objValue;
    }

    public void d() {
        FrameLayout frameLayout;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) && this.f != null && (frameLayout = this.g) != null) {
            frameLayout.setVisibility(8);
            this.f.dettachView(this.g);
            this.f = null;
        }
    }

    public final void e() {
        NoDataView noDataView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) && (noDataView = this.j) != null && noDataView.getParent() == this.g) {
            this.j.setVisibility(8);
            this.g.removeView(this.j);
            this.g.setVisibility(8);
        }
    }

    public void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            wg.a().post(new c(this));
        }
    }

    public final void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            d();
            e();
        }
    }

    public final void j() {
        SimpleDragSortListView simpleDragSortListView;
        q09 q09Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048583, this) == null) && (simpleDragSortListView = this.b) != null && !this.h && (q09Var = this.e) != null) {
            this.h = true;
            simpleDragSortListView.setEmptyView(q09Var.a());
        }
    }

    public final void k() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            k09 k09Var = new k09(this.b);
            this.i = k09Var;
            k09Var.c(new a(this));
        }
    }

    public void f(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048579, this, i) == null) {
            q09 q09Var = this.e;
            if (q09Var != null) {
                q09Var.b(i);
            }
            FrameLayout frameLayout = this.g;
            if (frameLayout != null) {
                SkinManager.setBackgroundColor(frameLayout, R.color.CAM_X0201, i);
            }
            q09 q09Var2 = this.e;
            if (q09Var2 != null) {
                SkinManager.setBackgroundColor(q09Var2.a(), R.color.CAM_X0201, i);
            }
            SimpleDragSortListView simpleDragSortListView = this.b;
            if (simpleDragSortListView != null) {
                SkinManager.setBackgroundColor(simpleDragSortListView, R.color.CAM_X0201, i);
            }
            NoNetworkView noNetworkView = this.k;
            if (noNetworkView != null) {
                noNetworkView.d(this.a, i);
            }
        }
    }

    public final void l() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048585, this) == null) && this.a != null && this.g != null) {
            h();
            this.g.setVisibility(0);
            vm5 vm5Var = new vm5(this.a.getPageActivity());
            this.f = vm5Var;
            vm5Var.attachView(this.g, true);
            this.f.onChangeSkinType();
        }
    }

    public void m() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048586, this) == null) && this.a != null && this.g != null) {
            h();
            this.g.setVisibility(0);
            NoDataView b2 = NoDataViewFactory.b(this.a.getPageActivity(), this.g, NoDataViewFactory.d.b(NoDataViewFactory.ImgType.WEBVIEW, vi.g(this.a.getPageActivity(), R.dimen.obfuscated_res_0x7f070358)), NoDataViewFactory.e.d(null, this.a.getString(R.string.obfuscated_res_0x7f0f0635)), null, true);
            this.j = b2;
            b2.setVisibility(0);
            this.j.d(this.a);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    public void update(List<EmotionPackageData> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, list) == null) {
            wg.a().post(new b(this, list));
        }
    }
}
