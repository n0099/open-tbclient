package com.baidu.tieba.postsearch;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListAdapter;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.BaseFragment;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.view.NoDataView;
import com.baidu.tbadk.core.view.NoDataViewFactory;
import com.baidu.tbadk.core.view.PbListView;
import com.baidu.tbadk.util.BdListViewHelper;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.ga5;
import com.repackage.pi;
import com.repackage.u78;
import com.repackage.x78;
import java.util.List;
/* loaded from: classes3.dex */
public class PostSearchListFragment extends BaseFragment implements BdListView.p {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public PostSearchActivity a;
    public View b;
    public BdListView c;
    public x78 d;
    public PbListView e;
    public NoDataView f;
    public u78 g;
    public int h;
    public String i;

    public PostSearchListFragment() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.h = -1;
        this.i = "";
    }

    public final void A1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            if (this.f == null) {
                NoDataView a = NoDataViewFactory.a(this.a.getPageContext().getPageActivity(), this.b, NoDataViewFactory.d.b(NoDataViewFactory.ImgType.NODATA, pi.f(this.a.getActivity(), R.dimen.obfuscated_res_0x7f0702a0)), NoDataViewFactory.e.a(R.string.obfuscated_res_0x7f0f13c4), null);
                this.f = a;
                a.f(this.a.getPageContext(), TbadkCoreApplication.getInst().getSkinType());
            }
            this.f.setVisibility(0);
        }
    }

    public final void B1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.c.setNextPage(this.e);
            this.e.f();
            this.e.C(this.a.getResources().getString(R.string.obfuscated_res_0x7f0f09e7));
        }
    }

    public final void C1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.c.setNextPage(this.e);
            this.e.Q();
        }
    }

    public final void D1() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048579, this) == null) || this.a == null) {
            return;
        }
        TiebaStatic.log(new StatisticItem("c12406").param("fid", this.a.e).param("fname", this.a.d).param("uid", TbadkCoreApplication.getCurrentAccount()).param("tab_id", this.h));
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, bundle) == null) {
            super.onActivityCreated(bundle);
            this.a = (PostSearchActivity) getBaseFragmentActivity();
            x78 x78Var = new x78(this.a.getPageContext());
            this.d = x78Var;
            x78Var.f(this.h);
            BdListViewHelper.d(this.a.getActivity(), this.c, BdListViewHelper.HeadType.HASTAB);
            this.c.setAdapter((ListAdapter) this.d);
            PbListView pbListView = new PbListView(this.a.getPageContext().getPageActivity());
            this.e = pbListView;
            pbListView.a();
            this.c.setOnSrollToBottomListener(this);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048581, this, i) == null) {
            super.onChangeSkinType(i);
            PostSearchActivity postSearchActivity = this.a;
            if (postSearchActivity != null) {
                ga5.a(postSearchActivity.getPageContext(), this.b);
            }
            PbListView pbListView = this.e;
            if (pbListView != null) {
                pbListView.d(i);
            }
            x78 x78Var = this.d;
            if (x78Var != null) {
                x78Var.notifyDataSetChanged();
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048582, this, layoutInflater, viewGroup, bundle)) == null) {
            this.b = layoutInflater.inflate(R.layout.obfuscated_res_0x7f0d06fc, (ViewGroup) null);
            v1();
            return this.b;
        }
        return (View) invokeLLL.objValue;
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onPrimary() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            super.onPrimary();
            if (this.h == this.a.p0().a()) {
                D1();
                x1(false);
            }
        }
    }

    @Override // com.baidu.adp.widget.ListView.BdListView.p
    public void onScrollToBottom() {
        u78 u78Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) && !StringUtils.isNull(this.i) && (u78Var = this.g) != null && u78Var.b() && this.a.o0().l(this.i, this.h)) {
            C1();
        }
    }

    public void s1() {
        List<u78.a> list;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            u78 u78Var = this.g;
            if (u78Var != null && (list = u78Var.a) != null) {
                list.clear();
                this.d.c(this.g.a);
                this.d.notifyDataSetChanged();
            }
            t1();
            u1();
        }
    }

    public final void t1() {
        BdListView bdListView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048586, this) == null) || (bdListView = this.c) == null) {
            return;
        }
        bdListView.setNextPage(null);
    }

    public final void u1() {
        NoDataView noDataView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048587, this) == null) || (noDataView = this.f) == null) {
            return;
        }
        noDataView.setVisibility(8);
    }

    public final void v1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            this.c = (BdListView) this.b.findViewById(R.id.obfuscated_res_0x7f091b04);
        }
    }

    public void w1(u78 u78Var, boolean z) {
        u78 u78Var2;
        List<u78.a> list;
        List<u78.a> list2;
        u78 u78Var3;
        List<u78.a> list3;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048589, this, u78Var, z) == null) {
            u1();
            hideLoadingView(this.b);
            if (u78Var == null || (list2 = u78Var.a) == null || list2.size() == 0) {
                if (z && (u78Var2 = this.g) != null && (list = u78Var2.a) != null && list.size() != 0) {
                    if (this.g.b.b() == 1) {
                        y1();
                        return;
                    } else {
                        B1();
                        return;
                    }
                }
                t1();
                A1();
                this.c.setVisibility(8);
                this.g = u78Var;
                return;
            }
            if (z && (u78Var3 = this.g) != null && (list3 = u78Var3.a) != null && list3.size() != 0) {
                u78 u78Var4 = this.g;
                u78Var4.b = u78Var.b;
                u78Var4.a.addAll(u78Var.a);
            } else {
                this.g = u78Var;
            }
            if (z) {
                D1();
            }
            if (this.g.b.b() == 1) {
                y1();
            } else {
                B1();
            }
            this.d.c(this.g.a);
            this.d.notifyDataSetChanged();
            this.d.e(this.a.c);
            this.d.d(this.a.e);
            if (!z) {
                this.c.setSelection(0);
            }
            this.c.setVisibility(0);
        }
    }

    public void x1(boolean z) {
        PostSearchActivity postSearchActivity;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048590, this, z) == null) || (postSearchActivity = this.a) == null) {
            return;
        }
        String str = postSearchActivity.c;
        if (StringUtils.isNull(str)) {
            return;
        }
        boolean z2 = true;
        boolean z3 = !str.equals(this.i) || z;
        u78 u78Var = this.g;
        if (u78Var != null && (u78Var == null || u78Var.a())) {
            z2 = z3;
        }
        if (z2) {
            showLoadingView(this.b, false, this.a.getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f0702a0));
            this.a.o0().l(str, this.h);
            this.i = str;
        }
    }

    public final void y1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048591, this) == null) {
            this.c.setNextPage(this.e);
            this.e.f();
            this.e.C(this.a.getResources().getString(R.string.obfuscated_res_0x7f0f0dc1));
        }
    }

    public PostSearchListFragment(int i) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Integer.valueOf(i)};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.h = -1;
        this.i = "";
        this.h = i;
    }
}
