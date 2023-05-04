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
import com.baidu.tieba.ac9;
import com.baidu.tieba.ii;
import com.baidu.tieba.tn5;
import com.baidu.tieba.xb9;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.List;
/* loaded from: classes5.dex */
public class PostSearchListFragment extends BaseFragment implements BdListView.p {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public PostSearchActivity a;
    public View b;
    public BdListView c;
    public ac9 d;
    public PbListView e;
    public NoDataView f;
    public xb9 g;
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

    public void F1() {
        List<xb9.a> list;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            xb9 xb9Var = this.g;
            if (xb9Var != null && (list = xb9Var.a) != null) {
                list.clear();
                this.d.c(this.g.a);
                this.d.notifyDataSetChanged();
            }
            G1();
            H1();
        }
    }

    public final void G1() {
        BdListView bdListView;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) != null) || (bdListView = this.c) == null) {
            return;
        }
        bdListView.setNextPage(null);
    }

    public final void H1() {
        NoDataView noDataView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) && (noDataView = this.f) != null) {
            noDataView.setVisibility(8);
        }
    }

    public final void I1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            this.c = (BdListView) this.b.findViewById(R.id.obfuscated_res_0x7f091db2);
        }
    }

    public final void L1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            this.c.setNextPage(this.e);
            this.e.g();
            this.e.F(this.a.getResources().getString(R.string.pb_load_more));
        }
    }

    public final void N1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            this.c.setNextPage(this.e);
            this.e.g();
            this.e.F(this.a.getResources().getString(R.string.list_no_more));
        }
    }

    public final void O1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            this.c.setNextPage(this.e);
            this.e.S();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onPrimary() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
            super.onPrimary();
            if (this.h == this.a.v1().a()) {
                P1();
                K1(false);
            }
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

    public void J1(xb9 xb9Var, boolean z) {
        xb9 xb9Var2;
        List<xb9.a> list;
        List<xb9.a> list2;
        xb9 xb9Var3;
        List<xb9.a> list3;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048580, this, xb9Var, z) == null) {
            H1();
            hideLoadingView(this.b);
            boolean z2 = false;
            boolean z3 = true;
            if (xb9Var != null && (list2 = xb9Var.a) != null && list2.size() != 0) {
                if (z && (xb9Var3 = this.g) != null && (list3 = xb9Var3.a) != null && list3.size() != 0) {
                    xb9 xb9Var4 = this.g;
                    xb9Var4.b = xb9Var.b;
                    xb9Var4.a.addAll(xb9Var.a);
                } else {
                    this.g = xb9Var;
                }
                if (z) {
                    P1();
                }
                if (this.g.b.b() != 1) {
                    z3 = false;
                }
                if (z3) {
                    L1();
                } else {
                    N1();
                }
                this.d.c(this.g.a);
                this.d.notifyDataSetChanged();
                this.d.e(this.a.c);
                this.d.d(this.a.e);
                if (!z) {
                    this.c.setSelection(0);
                }
                this.c.setVisibility(0);
            } else if (z && (xb9Var2 = this.g) != null && (list = xb9Var2.a) != null && list.size() != 0) {
                if (this.g.b.b() == 1) {
                    z2 = true;
                }
                if (z2) {
                    L1();
                } else {
                    N1();
                }
            } else {
                G1();
                M1();
                this.c.setVisibility(8);
                this.g = xb9Var;
            }
        }
    }

    public void K1(boolean z) {
        PostSearchActivity postSearchActivity;
        boolean z2;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeZ(1048581, this, z) != null) || (postSearchActivity = this.a) == null) {
            return;
        }
        String str = postSearchActivity.c;
        if (StringUtils.isNull(str)) {
            return;
        }
        boolean z3 = true;
        if (str.equals(this.i) && !z) {
            z2 = false;
        } else {
            z2 = true;
        }
        xb9 xb9Var = this.g;
        if (xb9Var != null && (xb9Var == null || xb9Var.a())) {
            z3 = z2;
        }
        if (z3) {
            showLoadingView(this.b, false, this.a.getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f07029f));
            this.a.u1().l(str, this.h);
            this.i = str;
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, bundle) == null) {
            super.onActivityCreated(bundle);
            this.a = (PostSearchActivity) getBaseFragmentActivity();
            ac9 ac9Var = new ac9(this.a.getPageContext());
            this.d = ac9Var;
            ac9Var.f(this.h);
            BdListViewHelper.d(this.a.getActivity(), this.c, BdListViewHelper.HeadType.HASTAB);
            this.c.setAdapter((ListAdapter) this.d);
            PbListView pbListView = new PbListView(this.a.getPageContext().getPageActivity());
            this.e = pbListView;
            pbListView.a();
            this.c.setOnSrollToBottomListener(this);
        }
    }

    public final void M1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            if (this.f == null) {
                NoDataView a = NoDataViewFactory.a(this.a.getPageContext().getPageActivity(), this.b, NoDataViewFactory.d.b(NoDataViewFactory.ImgType.NODATA, ii.g(this.a.getActivity(), R.dimen.obfuscated_res_0x7f07029f)), NoDataViewFactory.e.a(R.string.text_no_search_result), null);
                this.f = a;
                a.f(this.a.getPageContext(), TbadkCoreApplication.getInst().getSkinType());
            }
            this.f.setVisibility(0);
        }
    }

    public final void P1() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048586, this) != null) || this.a == null) {
            return;
        }
        TiebaStatic.log(new StatisticItem("c12406").param("fid", this.a.e).param("fname", this.a.d).param("uid", TbadkCoreApplication.getCurrentAccount()).param(TiebaStatic.Params.TAB_ID, this.h));
    }

    @Override // com.baidu.adp.widget.ListView.BdListView.p
    public void onScrollToBottom() {
        xb9 xb9Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048591, this) == null) && !StringUtils.isNull(this.i) && (xb9Var = this.g) != null && xb9Var.b() && this.a.u1().l(this.i, this.h)) {
            O1();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048588, this, i) == null) {
            super.onChangeSkinType(i);
            PostSearchActivity postSearchActivity = this.a;
            if (postSearchActivity != null) {
                tn5.a(postSearchActivity.getPageContext(), this.b);
            }
            PbListView pbListView = this.e;
            if (pbListView != null) {
                pbListView.e(i);
            }
            ac9 ac9Var = this.d;
            if (ac9Var != null) {
                ac9Var.notifyDataSetChanged();
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048589, this, layoutInflater, viewGroup, bundle)) == null) {
            this.b = layoutInflater.inflate(R.layout.obfuscated_res_0x7f0d07a6, (ViewGroup) null);
            I1();
            return this.b;
        }
        return (View) invokeLLL.objValue;
    }
}
