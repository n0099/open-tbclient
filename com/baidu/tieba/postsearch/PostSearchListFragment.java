package com.baidu.tieba.postsearch;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListAdapter;
import androidx.core.view.InputDeviceCompat;
import c.a.e.e.p.l;
import c.a.p0.u0.a;
import c.a.q0.s2.b;
import c.a.q0.s2.e;
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
/* loaded from: classes7.dex */
public class PostSearchListFragment extends BaseFragment implements BdListView.p {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public PostSearchActivity f56066e;

    /* renamed from: f  reason: collision with root package name */
    public View f56067f;

    /* renamed from: g  reason: collision with root package name */
    public BdListView f56068g;

    /* renamed from: h  reason: collision with root package name */
    public e f56069h;

    /* renamed from: i  reason: collision with root package name */
    public PbListView f56070i;

    /* renamed from: j  reason: collision with root package name */
    public NoDataView f56071j;
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
            if (bVar != null && (list = bVar.f24342a) != null) {
                list.clear();
                this.f56069h.c(this.k.f24342a);
                this.f56069h.notifyDataSetChanged();
            }
            g();
            h();
        }
    }

    public final void g() {
        BdListView bdListView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || (bdListView = this.f56068g) == null) {
            return;
        }
        bdListView.setNextPage(null);
    }

    public final void h() {
        NoDataView noDataView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) || (noDataView = this.f56071j) == null) {
            return;
        }
        noDataView.setVisibility(8);
    }

    public final void i() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            this.f56068g.setNextPage(this.f56070i);
            this.f56070i.f();
            this.f56070i.A(this.f56066e.getResources().getString(R.string.pb_load_more));
        }
    }

    public final void initView() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            this.f56068g = (BdListView) this.f56067f.findViewById(R.id.result_list);
        }
    }

    public final void j() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            if (this.f56071j == null) {
                NoDataView a2 = NoDataViewFactory.a(this.f56066e.getPageContext().getPageActivity(), this.f56067f, NoDataViewFactory.d.b(NoDataViewFactory.ImgType.NODATA, l.g(this.f56066e.getActivity(), R.dimen.ds320)), NoDataViewFactory.e.a(R.string.text_no_search_result), null);
                this.f56071j = a2;
                a2.onChangeSkinType(this.f56066e.getPageContext(), TbadkCoreApplication.getInst().getSkinType());
            }
            this.f56071j.setVisibility(0);
        }
    }

    public final void k() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            this.f56068g.setNextPage(this.f56070i);
            this.f56070i.f();
            this.f56070i.A(this.f56066e.getResources().getString(R.string.list_no_more));
        }
    }

    public final void l() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            this.f56068g.setNextPage(this.f56070i);
            this.f56070i.O();
        }
    }

    public final void m() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) || this.f56066e == null) {
            return;
        }
        TiebaStatic.log(new StatisticItem("c12406").param("fid", this.f56066e.mForumId).param("fname", this.f56066e.mForumName).param("uid", TbadkCoreApplication.getCurrentAccount()).param("tab_id", this.l));
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, bundle) == null) {
            super.onActivityCreated(bundle);
            this.f56066e = (PostSearchActivity) getBaseFragmentActivity();
            e eVar = new e(this.f56066e.getPageContext());
            this.f56069h = eVar;
            eVar.f(this.l);
            BdListViewHelper.d(this.f56066e.getActivity(), this.f56068g, BdListViewHelper.HeadType.HASTAB);
            this.f56068g.setAdapter((ListAdapter) this.f56069h);
            PbListView pbListView = new PbListView(this.f56066e.getPageContext().getPageActivity());
            this.f56070i = pbListView;
            pbListView.a();
            this.f56068g.setOnSrollToBottomListener(this);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048586, this, i2) == null) {
            super.onChangeSkinType(i2);
            PostSearchActivity postSearchActivity = this.f56066e;
            if (postSearchActivity != null) {
                a.a(postSearchActivity.getPageContext(), this.f56067f);
            }
            PbListView pbListView = this.f56070i;
            if (pbListView != null) {
                pbListView.d(i2);
            }
            e eVar = this.f56069h;
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
            this.f56067f = layoutInflater.inflate(R.layout.post_search_list_fragment, (ViewGroup) null);
            initView();
            return this.f56067f;
        }
        return (View) invokeLLL.objValue;
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onPrimary() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            super.onPrimary();
            if (this.l == this.f56066e.getPostSearchView().a()) {
                m();
                requestData(false);
            }
        }
    }

    @Override // com.baidu.adp.widget.ListView.BdListView.p
    public void onScrollToBottom() {
        b bVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048589, this) == null) && !StringUtils.isNull(this.m) && (bVar = this.k) != null && bVar.b() && this.f56066e.getModel().l(this.m, this.l)) {
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
            hideLoadingView(this.f56067f);
            if (bVar == null || (list2 = bVar.f24342a) == null || list2.size() == 0) {
                if (z && (bVar2 = this.k) != null && (list = bVar2.f24342a) != null && list.size() != 0) {
                    if (this.k.f24343b.b() == 1) {
                        i();
                        return;
                    } else {
                        k();
                        return;
                    }
                }
                g();
                j();
                this.f56068g.setVisibility(8);
                this.k = bVar;
                return;
            }
            if (z && (bVar3 = this.k) != null && (list3 = bVar3.f24342a) != null && list3.size() != 0) {
                b bVar4 = this.k;
                bVar4.f24343b = bVar.f24343b;
                bVar4.f24342a.addAll(bVar.f24342a);
            } else {
                this.k = bVar;
            }
            if (z) {
                m();
            }
            if (this.k.f24343b.b() == 1) {
                i();
            } else {
                k();
            }
            this.f56069h.c(this.k.f24342a);
            this.f56069h.notifyDataSetChanged();
            this.f56069h.e(this.f56066e.mSearchKey);
            this.f56069h.d(this.f56066e.mForumId);
            if (!z) {
                this.f56068g.setSelection(0);
            }
            this.f56068g.setVisibility(0);
        }
    }

    public void requestData(boolean z) {
        PostSearchActivity postSearchActivity;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048591, this, z) == null) || (postSearchActivity = this.f56066e) == null) {
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
            showLoadingView(this.f56067f, false, this.f56066e.getResources().getDimensionPixelSize(R.dimen.ds320));
            this.f56066e.getModel().l(str, this.l);
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
