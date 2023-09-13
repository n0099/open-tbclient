package com.baidu.tieba;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.BdUtilHelper;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.view.NoDataView;
import com.baidu.tbadk.core.view.NoDataViewFactory;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tbadk.loading.LoadingView;
import com.baidu.tieba.faceshop.EmotionPackageData;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.List;
/* loaded from: classes6.dex */
public class jf9 implements Object<List<EmotionPackageData>> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TbPageContext a;
    public BdListView b;
    public cf9 c;
    public ff9 d;
    public View e;
    public LoadingView f;
    public FrameLayout g;
    public NoDataView h;
    public boolean i;
    public NoNetworkView j;

    public jf9(TbPageContext tbPageContext) {
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
        this.i = false;
        this.a = tbPageContext;
        View inflate = LayoutInflater.from(tbPageContext.getPageActivity()).inflate(R.layout.obfuscated_res_0x7f0d033d, (ViewGroup) null, false);
        this.e = inflate;
        NoNetworkView noNetworkView = (NoNetworkView) inflate.findViewById(R.id.view_no_network);
        this.j = noNetworkView;
        noNetworkView.addNetworkChangeListener(this);
        this.g = (FrameLayout) this.e.findViewById(R.id.obfuscated_res_0x7f092281);
        this.b = (BdListView) this.e.findViewById(R.id.obfuscated_res_0x7f0909e9);
        this.d = new ff9(this.e.findViewById(R.id.obfuscated_res_0x7f0909e8), tbPageContext.getString(R.string.obfuscated_res_0x7f0f064b));
        this.b.setDivider(null);
        this.b.setOverScrollMode(2);
        this.b.setVerticalScrollBarEnabled(false);
        this.c = new cf9(tbPageContext, this.b);
        g();
    }

    public View a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return this.e;
        }
        return (View) invokeV.objValue;
    }

    public void b() {
        FrameLayout frameLayout;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) && this.f != null && (frameLayout = this.g) != null) {
            frameLayout.setVisibility(8);
            this.f.dettachView(this.g);
            this.f = null;
        }
    }

    public final void c() {
        NoDataView noDataView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) && (noDataView = this.h) != null && noDataView.getParent() == this.g) {
            this.h.setVisibility(8);
            this.g.removeView(this.h);
            this.g.setVisibility(8);
        }
    }

    public final void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            b();
            c();
        }
    }

    public final void f() {
        BdListView bdListView;
        ff9 ff9Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048581, this) == null) && (bdListView = this.b) != null && !this.i && (ff9Var = this.d) != null) {
            this.i = true;
            bdListView.setEmptyView(ff9Var.a());
        }
    }

    public void d(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048579, this, i) == null) {
            View view2 = this.e;
            if (view2 != null) {
                SkinManager.setBackgroundColor(view2, R.color.cp_bg_line_d_alpha90, i);
            }
            BdListView bdListView = this.b;
            if (bdListView != null) {
                SkinManager.setBackgroundColor(bdListView, R.color.CAM_X0201, i);
            }
            ff9 ff9Var = this.d;
            if (ff9Var != null) {
                ff9Var.b(i);
            }
            NoNetworkView noNetworkView = this.j;
            if (noNetworkView != null) {
                noNetworkView.onChangeSkinType(this.a, i);
            }
            FrameLayout frameLayout = this.g;
            if (frameLayout != null) {
                SkinManager.setBackgroundColor(frameLayout, R.color.CAM_X0201, i);
            }
        }
    }

    public final void g() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048582, this) == null) && this.a != null && this.g != null) {
            e();
            this.g.setVisibility(0);
            if (this.f == null) {
                this.f = new LoadingView(this.a.getPageActivity());
            }
            this.f.attachView(this.g, true);
            this.f.onChangeSkinType();
        }
    }

    public void h() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048583, this) == null) && this.a != null && this.g != null) {
            e();
            this.g.setVisibility(0);
            NoDataView b = NoDataViewFactory.b(this.a.getPageActivity(), this.g, NoDataViewFactory.d.b(NoDataViewFactory.ImgType.WEBVIEW, BdUtilHelper.getDimens(this.a.getPageActivity(), R.dimen.obfuscated_res_0x7f070362)), NoDataViewFactory.e.d(null, this.a.getString(R.string.obfuscated_res_0x7f0f064d)), null, true);
            this.h = b;
            b.setVisibility(0);
            this.h.d(this.a);
        }
    }

    public void k(boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(InputDeviceCompat.SOURCE_TOUCHPAD, this, z) == null) && z) {
            g();
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921314));
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    public void update(List<EmotionPackageData> list) {
        cf9 cf9Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, list) == null) {
            f();
            if (list != null && (cf9Var = this.c) != null) {
                cf9Var.update(list);
            }
        }
    }
}
