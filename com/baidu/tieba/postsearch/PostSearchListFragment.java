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
import com.baidu.tieba.cc8;
import com.baidu.tieba.ej;
import com.baidu.tieba.fc8;
import com.baidu.tieba.ge5;
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
    public fc8 d;
    public PbListView e;
    public NoDataView f;
    public cc8 g;
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
            this.c.setNextPage(this.e);
            this.e.R();
        }
    }

    public final void B1() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || this.a == null) {
            return;
        }
        TiebaStatic.log(new StatisticItem("c12406").param("fid", this.a.e).param("fname", this.a.d).param("uid", TbadkCoreApplication.getCurrentAccount()).param("tab_id", this.h));
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, bundle) == null) {
            super.onActivityCreated(bundle);
            this.a = (PostSearchActivity) getBaseFragmentActivity();
            fc8 fc8Var = new fc8(this.a.getPageContext());
            this.d = fc8Var;
            fc8Var.f(this.h);
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
        if (interceptable == null || interceptable.invokeI(1048579, this, i) == null) {
            super.onChangeSkinType(i);
            PostSearchActivity postSearchActivity = this.a;
            if (postSearchActivity != null) {
                ge5.a(postSearchActivity.getPageContext(), this.b);
            }
            PbListView pbListView = this.e;
            if (pbListView != null) {
                pbListView.d(i);
            }
            fc8 fc8Var = this.d;
            if (fc8Var != null) {
                fc8Var.notifyDataSetChanged();
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048580, this, layoutInflater, viewGroup, bundle)) == null) {
            this.b = layoutInflater.inflate(R.layout.obfuscated_res_0x7f0d0749, (ViewGroup) null);
            t1();
            return this.b;
        }
        return (View) invokeLLL.objValue;
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onPrimary() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            super.onPrimary();
            if (this.h == this.a.O0().a()) {
                B1();
                v1(false);
            }
        }
    }

    @Override // com.baidu.adp.widget.ListView.BdListView.p
    public void onScrollToBottom() {
        cc8 cc8Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048582, this) == null) && !StringUtils.isNull(this.i) && (cc8Var = this.g) != null && cc8Var.b() && this.a.N0().l(this.i, this.h)) {
            A1();
        }
    }

    public void q1() {
        List<cc8.a> list;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            cc8 cc8Var = this.g;
            if (cc8Var != null && (list = cc8Var.a) != null) {
                list.clear();
                this.d.c(this.g.a);
                this.d.notifyDataSetChanged();
            }
            r1();
            s1();
        }
    }

    public final void r1() {
        BdListView bdListView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) || (bdListView = this.c) == null) {
            return;
        }
        bdListView.setNextPage(null);
    }

    public final void s1() {
        NoDataView noDataView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048585, this) == null) || (noDataView = this.f) == null) {
            return;
        }
        noDataView.setVisibility(8);
    }

    public final void t1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            this.c = (BdListView) this.b.findViewById(R.id.obfuscated_res_0x7f091c0a);
        }
    }

    public void u1(cc8 cc8Var, boolean z) {
        cc8 cc8Var2;
        List<cc8.a> list;
        List<cc8.a> list2;
        cc8 cc8Var3;
        List<cc8.a> list3;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048587, this, cc8Var, z) == null) {
            s1();
            hideLoadingView(this.b);
            if (cc8Var == null || (list2 = cc8Var.a) == null || list2.size() == 0) {
                if (z && (cc8Var2 = this.g) != null && (list = cc8Var2.a) != null && list.size() != 0) {
                    if (this.g.b.b() == 1) {
                        w1();
                        return;
                    } else {
                        z1();
                        return;
                    }
                }
                r1();
                x1();
                this.c.setVisibility(8);
                this.g = cc8Var;
                return;
            }
            if (z && (cc8Var3 = this.g) != null && (list3 = cc8Var3.a) != null && list3.size() != 0) {
                cc8 cc8Var4 = this.g;
                cc8Var4.b = cc8Var.b;
                cc8Var4.a.addAll(cc8Var.a);
            } else {
                this.g = cc8Var;
            }
            if (z) {
                B1();
            }
            if (this.g.b.b() == 1) {
                w1();
            } else {
                z1();
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

    public void v1(boolean z) {
        PostSearchActivity postSearchActivity;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048588, this, z) == null) || (postSearchActivity = this.a) == null) {
            return;
        }
        String str = postSearchActivity.c;
        if (StringUtils.isNull(str)) {
            return;
        }
        boolean z2 = true;
        boolean z3 = !str.equals(this.i) || z;
        cc8 cc8Var = this.g;
        if (cc8Var != null && (cc8Var == null || cc8Var.a())) {
            z2 = z3;
        }
        if (z2) {
            showLoadingView(this.b, false, this.a.getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f07029e));
            this.a.N0().l(str, this.h);
            this.i = str;
        }
    }

    public final void w1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            this.c.setNextPage(this.e);
            this.e.f();
            this.e.D(this.a.getResources().getString(R.string.obfuscated_res_0x7f0f0df4));
        }
    }

    public final void x1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
            if (this.f == null) {
                NoDataView a = NoDataViewFactory.a(this.a.getPageContext().getPageActivity(), this.b, NoDataViewFactory.d.b(NoDataViewFactory.ImgType.NODATA, ej.f(this.a.getActivity(), R.dimen.obfuscated_res_0x7f07029e)), NoDataViewFactory.e.a(R.string.obfuscated_res_0x7f0f13d4), null);
                this.f = a;
                a.f(this.a.getPageContext(), TbadkCoreApplication.getInst().getSkinType());
            }
            this.f.setVisibility(0);
        }
    }

    public final void z1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048591, this) == null) {
            this.c.setNextPage(this.e);
            this.e.f();
            this.e.D(this.a.getResources().getString(R.string.obfuscated_res_0x7f0f0a01));
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
