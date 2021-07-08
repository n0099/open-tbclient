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
import d.a.c.e.p.l;
import d.a.o0.s0.a;
import d.a.p0.r2.b;
import d.a.p0.r2.e;
import java.util.List;
/* loaded from: classes4.dex */
public class PostSearchListFragment extends BaseFragment implements BdListView.p {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public PostSearchActivity f20398e;

    /* renamed from: f  reason: collision with root package name */
    public View f20399f;

    /* renamed from: g  reason: collision with root package name */
    public BdListView f20400g;

    /* renamed from: h  reason: collision with root package name */
    public e f20401h;

    /* renamed from: i  reason: collision with root package name */
    public PbListView f20402i;
    public NoDataView j;
    public b k;
    public int l;
    public String m;

    public PostSearchListFragment() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.l = -1;
        this.m = "";
    }

    public void H0() {
        List<b.a> list;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            b bVar = this.k;
            if (bVar != null && (list = bVar.f61862a) != null) {
                list.clear();
                this.f20401h.c(this.k.f61862a);
                this.f20401h.notifyDataSetChanged();
            }
            I0();
            J0();
        }
    }

    public final void I0() {
        BdListView bdListView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || (bdListView = this.f20400g) == null) {
            return;
        }
        bdListView.setNextPage(null);
    }

    public final void J0() {
        NoDataView noDataView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) || (noDataView = this.j) == null) {
            return;
        }
        noDataView.setVisibility(8);
    }

    public final void K0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            this.f20400g = (BdListView) this.f20399f.findViewById(R.id.result_list);
        }
    }

    public void L0(b bVar, boolean z) {
        b bVar2;
        List<b.a> list;
        List<b.a> list2;
        b bVar3;
        List<b.a> list3;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048580, this, bVar, z) == null) {
            J0();
            hideLoadingView(this.f20399f);
            if (bVar == null || (list2 = bVar.f61862a) == null || list2.size() == 0) {
                if (z && (bVar2 = this.k) != null && (list = bVar2.f61862a) != null && list.size() != 0) {
                    if (this.k.f61863b.b() == 1) {
                        N0();
                        return;
                    } else {
                        P0();
                        return;
                    }
                }
                I0();
                O0();
                this.f20400g.setVisibility(8);
                this.k = bVar;
                return;
            }
            if (z && (bVar3 = this.k) != null && (list3 = bVar3.f61862a) != null && list3.size() != 0) {
                b bVar4 = this.k;
                bVar4.f61863b = bVar.f61863b;
                bVar4.f61862a.addAll(bVar.f61862a);
            } else {
                this.k = bVar;
            }
            if (z) {
                R0();
            }
            if (this.k.f61863b.b() == 1) {
                N0();
            } else {
                P0();
            }
            this.f20401h.c(this.k.f61862a);
            this.f20401h.notifyDataSetChanged();
            this.f20401h.e(this.f20398e.mSearchKey);
            this.f20401h.d(this.f20398e.mForumId);
            if (!z) {
                this.f20400g.setSelection(0);
            }
            this.f20400g.setVisibility(0);
        }
    }

    public void M0(boolean z) {
        PostSearchActivity postSearchActivity;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048581, this, z) == null) || (postSearchActivity = this.f20398e) == null) {
            return;
        }
        String str = postSearchActivity.mSearchKey;
        if (StringUtils.isNull(str)) {
            return;
        }
        boolean z2 = true;
        boolean z3 = !str.equals(this.m) || z;
        b bVar = this.k;
        if (bVar != null && (bVar == null || bVar.a())) {
            z2 = z3;
        }
        if (z2) {
            showLoadingView(this.f20399f, false, this.f20398e.getResources().getDimensionPixelSize(R.dimen.ds320));
            this.f20398e.getModel().l(str, this.l);
            this.m = str;
        }
    }

    public final void N0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            this.f20400g.setNextPage(this.f20402i);
            this.f20402i.f();
            this.f20402i.A(this.f20398e.getResources().getString(R.string.pb_load_more));
        }
    }

    public final void O0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            if (this.j == null) {
                NoDataView a2 = NoDataViewFactory.a(this.f20398e.getPageContext().getPageActivity(), this.f20399f, NoDataViewFactory.d.b(NoDataViewFactory.ImgType.NODATA, l.g(this.f20398e.getActivity(), R.dimen.ds320)), NoDataViewFactory.e.a(R.string.text_no_search_result), null);
                this.j = a2;
                a2.f(this.f20398e.getPageContext(), TbadkCoreApplication.getInst().getSkinType());
            }
            this.j.setVisibility(0);
        }
    }

    public final void P0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            this.f20400g.setNextPage(this.f20402i);
            this.f20402i.f();
            this.f20402i.A(this.f20398e.getResources().getString(R.string.list_no_more));
        }
    }

    public final void Q0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            this.f20400g.setNextPage(this.f20402i);
            this.f20402i.O();
        }
    }

    public final void R0() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048586, this) == null) || this.f20398e == null) {
            return;
        }
        TiebaStatic.log(new StatisticItem("c12406").param("fid", this.f20398e.mForumId).param("fname", this.f20398e.mForumName).param("uid", TbadkCoreApplication.getCurrentAccount()).param("tab_id", this.l));
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, bundle) == null) {
            super.onActivityCreated(bundle);
            this.f20398e = (PostSearchActivity) getBaseFragmentActivity();
            e eVar = new e(this.f20398e.getPageContext());
            this.f20401h = eVar;
            eVar.f(this.l);
            BdListViewHelper.d(this.f20398e.getActivity(), this.f20400g, BdListViewHelper.HeadType.HASTAB);
            this.f20400g.setAdapter((ListAdapter) this.f20401h);
            PbListView pbListView = new PbListView(this.f20398e.getPageContext().getPageActivity());
            this.f20402i = pbListView;
            pbListView.a();
            this.f20400g.setOnSrollToBottomListener(this);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048588, this, i2) == null) {
            super.onChangeSkinType(i2);
            PostSearchActivity postSearchActivity = this.f20398e;
            if (postSearchActivity != null) {
                a.a(postSearchActivity.getPageContext(), this.f20399f);
            }
            PbListView pbListView = this.f20402i;
            if (pbListView != null) {
                pbListView.d(i2);
            }
            e eVar = this.f20401h;
            if (eVar != null) {
                eVar.notifyDataSetChanged();
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048589, this, layoutInflater, viewGroup, bundle)) == null) {
            this.f20399f = layoutInflater.inflate(R.layout.post_search_list_fragment, (ViewGroup) null);
            K0();
            return this.f20399f;
        }
        return (View) invokeLLL.objValue;
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onPrimary() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
            super.onPrimary();
            if (this.l == this.f20398e.getPostSearchView().a()) {
                R0();
                M0(false);
            }
        }
    }

    @Override // com.baidu.adp.widget.ListView.BdListView.p
    public void onScrollToBottom() {
        b bVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048591, this) == null) && !StringUtils.isNull(this.m) && (bVar = this.k) != null && bVar.b() && this.f20398e.getModel().l(this.m, this.l)) {
            Q0();
        }
    }

    public PostSearchListFragment(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Integer.valueOf(i2)};
            interceptable.invokeUnInit(65537, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.l = -1;
        this.m = "";
        this.l = i2;
    }
}
