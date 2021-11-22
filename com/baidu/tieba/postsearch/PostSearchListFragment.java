package com.baidu.tieba.postsearch;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListAdapter;
import androidx.core.view.InputDeviceCompat;
import b.a.e.f.p.l;
import b.a.q0.v0.a;
import b.a.r0.v2.b;
import b.a.r0.v2.e;
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
import java.util.List;
/* loaded from: classes9.dex */
public class PostSearchListFragment extends BaseFragment implements BdListView.p {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public PostSearchActivity f54315e;

    /* renamed from: f  reason: collision with root package name */
    public View f54316f;

    /* renamed from: g  reason: collision with root package name */
    public BdListView f54317g;

    /* renamed from: h  reason: collision with root package name */
    public e f54318h;

    /* renamed from: i  reason: collision with root package name */
    public PbListView f54319i;
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

    public void clearListData() {
        List<b.a> list;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            b bVar = this.k;
            if (bVar != null && (list = bVar.f25925a) != null) {
                list.clear();
                this.f54318h.c(this.k.f25925a);
                this.f54318h.notifyDataSetChanged();
            }
            g();
            h();
        }
    }

    public final void g() {
        BdListView bdListView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || (bdListView = this.f54317g) == null) {
            return;
        }
        bdListView.setNextPage(null);
    }

    public final void h() {
        NoDataView noDataView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) || (noDataView = this.j) == null) {
            return;
        }
        noDataView.setVisibility(8);
    }

    public final void i() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            this.f54317g.setNextPage(this.f54319i);
            this.f54319i.f();
            this.f54319i.C(this.f54315e.getResources().getString(R.string.pb_load_more));
        }
    }

    public final void initView() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            this.f54317g = (BdListView) this.f54316f.findViewById(R.id.result_list);
        }
    }

    public final void j() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            if (this.j == null) {
                NoDataView a2 = NoDataViewFactory.a(this.f54315e.getPageContext().getPageActivity(), this.f54316f, NoDataViewFactory.d.b(NoDataViewFactory.ImgType.NODATA, l.g(this.f54315e.getActivity(), R.dimen.ds320)), NoDataViewFactory.e.a(R.string.text_no_search_result), null);
                this.j = a2;
                a2.onChangeSkinType(this.f54315e.getPageContext(), TbadkCoreApplication.getInst().getSkinType());
            }
            this.j.setVisibility(0);
        }
    }

    public final void k() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            this.f54317g.setNextPage(this.f54319i);
            this.f54319i.f();
            this.f54319i.C(this.f54315e.getResources().getString(R.string.list_no_more));
        }
    }

    public final void l() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            this.f54317g.setNextPage(this.f54319i);
            this.f54319i.Q();
        }
    }

    public final void m() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) || this.f54315e == null) {
            return;
        }
        TiebaStatic.log(new StatisticItem("c12406").param("fid", this.f54315e.mForumId).param("fname", this.f54315e.mForumName).param("uid", TbadkCoreApplication.getCurrentAccount()).param("tab_id", this.l));
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, bundle) == null) {
            super.onActivityCreated(bundle);
            this.f54315e = (PostSearchActivity) getBaseFragmentActivity();
            e eVar = new e(this.f54315e.getPageContext());
            this.f54318h = eVar;
            eVar.f(this.l);
            BdListViewHelper.d(this.f54315e.getActivity(), this.f54317g, BdListViewHelper.HeadType.HASTAB);
            this.f54317g.setAdapter((ListAdapter) this.f54318h);
            PbListView pbListView = new PbListView(this.f54315e.getPageContext().getPageActivity());
            this.f54319i = pbListView;
            pbListView.a();
            this.f54317g.setOnSrollToBottomListener(this);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048586, this, i2) == null) {
            super.onChangeSkinType(i2);
            PostSearchActivity postSearchActivity = this.f54315e;
            if (postSearchActivity != null) {
                a.a(postSearchActivity.getPageContext(), this.f54316f);
            }
            PbListView pbListView = this.f54319i;
            if (pbListView != null) {
                pbListView.d(i2);
            }
            e eVar = this.f54318h;
            if (eVar != null) {
                eVar.notifyDataSetChanged();
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048587, this, layoutInflater, viewGroup, bundle)) == null) {
            this.f54316f = layoutInflater.inflate(R.layout.post_search_list_fragment, (ViewGroup) null);
            initView();
            return this.f54316f;
        }
        return (View) invokeLLL.objValue;
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onPrimary() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            super.onPrimary();
            if (this.l == this.f54315e.getPostSearchView().a()) {
                m();
                requestData(false);
            }
        }
    }

    @Override // com.baidu.adp.widget.ListView.BdListView.p
    public void onScrollToBottom() {
        b bVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048589, this) == null) && !StringUtils.isNull(this.m) && (bVar = this.k) != null && bVar.b() && this.f54315e.getModel().l(this.m, this.l)) {
            l();
        }
    }

    public void refreshResultList(b bVar, boolean z) {
        b bVar2;
        List<b.a> list;
        List<b.a> list2;
        b bVar3;
        List<b.a> list3;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048590, this, bVar, z) == null) {
            h();
            hideLoadingView(this.f54316f);
            if (bVar == null || (list2 = bVar.f25925a) == null || list2.size() == 0) {
                if (z && (bVar2 = this.k) != null && (list = bVar2.f25925a) != null && list.size() != 0) {
                    if (this.k.f25926b.b() == 1) {
                        i();
                        return;
                    } else {
                        k();
                        return;
                    }
                }
                g();
                j();
                this.f54317g.setVisibility(8);
                this.k = bVar;
                return;
            }
            if (z && (bVar3 = this.k) != null && (list3 = bVar3.f25925a) != null && list3.size() != 0) {
                b bVar4 = this.k;
                bVar4.f25926b = bVar.f25926b;
                bVar4.f25925a.addAll(bVar.f25925a);
            } else {
                this.k = bVar;
            }
            if (z) {
                m();
            }
            if (this.k.f25926b.b() == 1) {
                i();
            } else {
                k();
            }
            this.f54318h.c(this.k.f25925a);
            this.f54318h.notifyDataSetChanged();
            this.f54318h.e(this.f54315e.mSearchKey);
            this.f54318h.d(this.f54315e.mForumId);
            if (!z) {
                this.f54317g.setSelection(0);
            }
            this.f54317g.setVisibility(0);
        }
    }

    public void requestData(boolean z) {
        PostSearchActivity postSearchActivity;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048591, this, z) == null) || (postSearchActivity = this.f54315e) == null) {
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
            showLoadingView(this.f54316f, false, this.f54315e.getResources().getDimensionPixelSize(R.dimen.ds320));
            this.f54315e.getModel().l(str, this.l);
            this.m = str;
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
