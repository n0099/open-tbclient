package com.baidu.tieba.postsearch;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListAdapter;
import androidx.core.view.InputDeviceCompat;
import c.a.d.f.p.n;
import c.a.s0.x0.a;
import c.a.t0.f3.b;
import c.a.t0.f3.e;
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
/* loaded from: classes12.dex */
public class PostSearchListFragment extends BaseFragment implements BdListView.p {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public PostSearchActivity f47461e;

    /* renamed from: f  reason: collision with root package name */
    public View f47462f;

    /* renamed from: g  reason: collision with root package name */
    public BdListView f47463g;

    /* renamed from: h  reason: collision with root package name */
    public e f47464h;

    /* renamed from: i  reason: collision with root package name */
    public PbListView f47465i;

    /* renamed from: j  reason: collision with root package name */
    public NoDataView f47466j;
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
            if (bVar != null && (list = bVar.a) != null) {
                list.clear();
                this.f47464h.c(this.k.a);
                this.f47464h.notifyDataSetChanged();
            }
            i();
            j();
        }
    }

    public final void i() {
        BdListView bdListView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || (bdListView = this.f47463g) == null) {
            return;
        }
        bdListView.setNextPage(null);
    }

    public final void initView() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.f47463g = (BdListView) this.f47462f.findViewById(R.id.result_list);
        }
    }

    public final void j() {
        NoDataView noDataView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048579, this) == null) || (noDataView = this.f47466j) == null) {
            return;
        }
        noDataView.setVisibility(8);
    }

    public final void k() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            this.f47463g.setNextPage(this.f47465i);
            this.f47465i.f();
            this.f47465i.D(this.f47461e.getResources().getString(R.string.pb_load_more));
        }
    }

    public final void l() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            if (this.f47466j == null) {
                NoDataView a = NoDataViewFactory.a(this.f47461e.getPageContext().getPageActivity(), this.f47462f, NoDataViewFactory.d.b(NoDataViewFactory.ImgType.NODATA, n.f(this.f47461e.getActivity(), R.dimen.ds320)), NoDataViewFactory.e.a(R.string.text_no_search_result), null);
                this.f47466j = a;
                a.onChangeSkinType(this.f47461e.getPageContext(), TbadkCoreApplication.getInst().getSkinType());
            }
            this.f47466j.setVisibility(0);
        }
    }

    public final void n() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            this.f47463g.setNextPage(this.f47465i);
            this.f47465i.f();
            this.f47465i.D(this.f47461e.getResources().getString(R.string.list_no_more));
        }
    }

    public final void o() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            this.f47463g.setNextPage(this.f47465i);
            this.f47465i.R();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, bundle) == null) {
            super.onActivityCreated(bundle);
            this.f47461e = (PostSearchActivity) getBaseFragmentActivity();
            e eVar = new e(this.f47461e.getPageContext());
            this.f47464h = eVar;
            eVar.f(this.l);
            BdListViewHelper.d(this.f47461e.getActivity(), this.f47463g, BdListViewHelper.HeadType.HASTAB);
            this.f47463g.setAdapter((ListAdapter) this.f47464h);
            PbListView pbListView = new PbListView(this.f47461e.getPageContext().getPageActivity());
            this.f47465i = pbListView;
            pbListView.a();
            this.f47463g.setOnSrollToBottomListener(this);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048585, this, i2) == null) {
            super.onChangeSkinType(i2);
            PostSearchActivity postSearchActivity = this.f47461e;
            if (postSearchActivity != null) {
                a.a(postSearchActivity.getPageContext(), this.f47462f);
            }
            PbListView pbListView = this.f47465i;
            if (pbListView != null) {
                pbListView.d(i2);
            }
            e eVar = this.f47464h;
            if (eVar != null) {
                eVar.notifyDataSetChanged();
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048586, this, layoutInflater, viewGroup, bundle)) == null) {
            this.f47462f = layoutInflater.inflate(R.layout.post_search_list_fragment, (ViewGroup) null);
            initView();
            return this.f47462f;
        }
        return (View) invokeLLL.objValue;
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onPrimary() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            super.onPrimary();
            if (this.l == this.f47461e.getPostSearchView().a()) {
                p();
                requestData(false);
            }
        }
    }

    @Override // com.baidu.adp.widget.ListView.BdListView.p
    public void onScrollToBottom() {
        b bVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048588, this) == null) && !StringUtils.isNull(this.m) && (bVar = this.k) != null && bVar.b() && this.f47461e.getModel().l(this.m, this.l)) {
            o();
        }
    }

    public final void p() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048589, this) == null) || this.f47461e == null) {
            return;
        }
        TiebaStatic.log(new StatisticItem("c12406").param("fid", this.f47461e.mForumId).param("fname", this.f47461e.mForumName).param("uid", TbadkCoreApplication.getCurrentAccount()).param("tab_id", this.l));
    }

    public void refreshResultList(b bVar, boolean z) {
        b bVar2;
        List<b.a> list;
        List<b.a> list2;
        b bVar3;
        List<b.a> list3;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048590, this, bVar, z) == null) {
            j();
            hideLoadingView(this.f47462f);
            if (bVar == null || (list2 = bVar.a) == null || list2.size() == 0) {
                if (z && (bVar2 = this.k) != null && (list = bVar2.a) != null && list.size() != 0) {
                    if (this.k.f17532b.b() == 1) {
                        k();
                        return;
                    } else {
                        n();
                        return;
                    }
                }
                i();
                l();
                this.f47463g.setVisibility(8);
                this.k = bVar;
                return;
            }
            if (z && (bVar3 = this.k) != null && (list3 = bVar3.a) != null && list3.size() != 0) {
                b bVar4 = this.k;
                bVar4.f17532b = bVar.f17532b;
                bVar4.a.addAll(bVar.a);
            } else {
                this.k = bVar;
            }
            if (z) {
                p();
            }
            if (this.k.f17532b.b() == 1) {
                k();
            } else {
                n();
            }
            this.f47464h.c(this.k.a);
            this.f47464h.notifyDataSetChanged();
            this.f47464h.e(this.f47461e.mSearchKey);
            this.f47464h.d(this.f47461e.mForumId);
            if (!z) {
                this.f47463g.setSelection(0);
            }
            this.f47463g.setVisibility(0);
        }
    }

    public void requestData(boolean z) {
        PostSearchActivity postSearchActivity;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048591, this, z) == null) || (postSearchActivity = this.f47461e) == null) {
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
            showLoadingView(this.f47462f, false, this.f47461e.getResources().getDimensionPixelSize(R.dimen.ds320));
            this.f47461e.getModel().l(str, this.l);
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
