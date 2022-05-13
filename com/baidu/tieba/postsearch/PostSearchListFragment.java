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
import com.repackage.mi;
import com.repackage.o88;
import com.repackage.r88;
import com.repackage.w95;
import java.util.List;
/* loaded from: classes3.dex */
public class PostSearchListFragment extends BaseFragment implements BdListView.p {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public PostSearchActivity a;
    public View b;
    public BdListView c;
    public r88 d;
    public PbListView e;
    public NoDataView f;
    public o88 g;
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

    public void C0() {
        List<o88.a> list;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            o88 o88Var = this.g;
            if (o88Var != null && (list = o88Var.a) != null) {
                list.clear();
                this.d.c(this.g.a);
                this.d.notifyDataSetChanged();
            }
            D0();
            E0();
        }
    }

    public final void D0() {
        BdListView bdListView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || (bdListView = this.c) == null) {
            return;
        }
        bdListView.setNextPage(null);
    }

    public final void E0() {
        NoDataView noDataView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) || (noDataView = this.f) == null) {
            return;
        }
        noDataView.setVisibility(8);
    }

    public final void F0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            this.c = (BdListView) this.b.findViewById(R.id.obfuscated_res_0x7f091ab5);
        }
    }

    public void G0(o88 o88Var, boolean z) {
        o88 o88Var2;
        List<o88.a> list;
        List<o88.a> list2;
        o88 o88Var3;
        List<o88.a> list3;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048580, this, o88Var, z) == null) {
            E0();
            hideLoadingView(this.b);
            if (o88Var == null || (list2 = o88Var.a) == null || list2.size() == 0) {
                if (z && (o88Var2 = this.g) != null && (list = o88Var2.a) != null && list.size() != 0) {
                    if (this.g.b.b() == 1) {
                        I0();
                        return;
                    } else {
                        K0();
                        return;
                    }
                }
                D0();
                J0();
                this.c.setVisibility(8);
                this.g = o88Var;
                return;
            }
            if (z && (o88Var3 = this.g) != null && (list3 = o88Var3.a) != null && list3.size() != 0) {
                o88 o88Var4 = this.g;
                o88Var4.b = o88Var.b;
                o88Var4.a.addAll(o88Var.a);
            } else {
                this.g = o88Var;
            }
            if (z) {
                M0();
            }
            if (this.g.b.b() == 1) {
                I0();
            } else {
                K0();
            }
            this.d.c(this.g.a);
            this.d.notifyDataSetChanged();
            this.d.e(this.a.mSearchKey);
            this.d.d(this.a.mForumId);
            if (!z) {
                this.c.setSelection(0);
            }
            this.c.setVisibility(0);
        }
    }

    public void H0(boolean z) {
        PostSearchActivity postSearchActivity;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048581, this, z) == null) || (postSearchActivity = this.a) == null) {
            return;
        }
        String str = postSearchActivity.mSearchKey;
        if (StringUtils.isNull(str)) {
            return;
        }
        boolean z2 = true;
        boolean z3 = !str.equals(this.i) || z;
        o88 o88Var = this.g;
        if (o88Var != null && (o88Var == null || o88Var.a())) {
            z2 = z3;
        }
        if (z2) {
            showLoadingView(this.b, false, this.a.getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f0702a1));
            this.a.getModel().l(str, this.h);
            this.i = str;
        }
    }

    public final void I0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            this.c.setNextPage(this.e);
            this.e.f();
            this.e.C(this.a.getResources().getString(R.string.obfuscated_res_0x7f0f0dc3));
        }
    }

    public final void J0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            if (this.f == null) {
                NoDataView a = NoDataViewFactory.a(this.a.getPageContext().getPageActivity(), this.b, NoDataViewFactory.d.b(NoDataViewFactory.ImgType.NODATA, mi.f(this.a.getActivity(), R.dimen.obfuscated_res_0x7f0702a1)), NoDataViewFactory.e.a(R.string.obfuscated_res_0x7f0f13ac), null);
                this.f = a;
                a.f(this.a.getPageContext(), TbadkCoreApplication.getInst().getSkinType());
            }
            this.f.setVisibility(0);
        }
    }

    public final void K0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            this.c.setNextPage(this.e);
            this.e.f();
            this.e.C(this.a.getResources().getString(R.string.obfuscated_res_0x7f0f09ee));
        }
    }

    public final void L0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            this.c.setNextPage(this.e);
            this.e.Q();
        }
    }

    public final void M0() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048586, this) == null) || this.a == null) {
            return;
        }
        TiebaStatic.log(new StatisticItem("c12406").param("fid", this.a.mForumId).param("fname", this.a.mForumName).param("uid", TbadkCoreApplication.getCurrentAccount()).param("tab_id", this.h));
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, bundle) == null) {
            super.onActivityCreated(bundle);
            this.a = (PostSearchActivity) getBaseFragmentActivity();
            r88 r88Var = new r88(this.a.getPageContext());
            this.d = r88Var;
            r88Var.f(this.h);
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
        if (interceptable == null || interceptable.invokeI(1048588, this, i) == null) {
            super.onChangeSkinType(i);
            PostSearchActivity postSearchActivity = this.a;
            if (postSearchActivity != null) {
                w95.a(postSearchActivity.getPageContext(), this.b);
            }
            PbListView pbListView = this.e;
            if (pbListView != null) {
                pbListView.d(i);
            }
            r88 r88Var = this.d;
            if (r88Var != null) {
                r88Var.notifyDataSetChanged();
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048589, this, layoutInflater, viewGroup, bundle)) == null) {
            this.b = layoutInflater.inflate(R.layout.obfuscated_res_0x7f0d06ed, (ViewGroup) null);
            F0();
            return this.b;
        }
        return (View) invokeLLL.objValue;
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onPrimary() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
            super.onPrimary();
            if (this.h == this.a.getPostSearchView().a()) {
                M0();
                H0(false);
            }
        }
    }

    @Override // com.baidu.adp.widget.ListView.BdListView.p
    public void onScrollToBottom() {
        o88 o88Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048591, this) == null) && !StringUtils.isNull(this.i) && (o88Var = this.g) != null && o88Var.b() && this.a.getModel().l(this.i, this.h)) {
            L0();
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
