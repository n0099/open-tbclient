package com.baidu.tieba.postsearch;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListAdapter;
import androidx.core.view.InputDeviceCompat;
import c.a.d.f.p.n;
import c.a.s0.x0.a;
import c.a.t0.e3.b;
import c.a.t0.e3.e;
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
    public PostSearchActivity f49282e;

    /* renamed from: f  reason: collision with root package name */
    public View f49283f;

    /* renamed from: g  reason: collision with root package name */
    public BdListView f49284g;

    /* renamed from: h  reason: collision with root package name */
    public e f49285h;

    /* renamed from: i  reason: collision with root package name */
    public PbListView f49286i;

    /* renamed from: j  reason: collision with root package name */
    public NoDataView f49287j;

    /* renamed from: k  reason: collision with root package name */
    public b f49288k;
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
            b bVar = this.f49288k;
            if (bVar != null && (list = bVar.a) != null) {
                list.clear();
                this.f49285h.c(this.f49288k.a);
                this.f49285h.notifyDataSetChanged();
            }
            i();
            j();
        }
    }

    public final void i() {
        BdListView bdListView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || (bdListView = this.f49284g) == null) {
            return;
        }
        bdListView.setNextPage(null);
    }

    public final void initView() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.f49284g = (BdListView) this.f49283f.findViewById(R.id.result_list);
        }
    }

    public final void j() {
        NoDataView noDataView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048579, this) == null) || (noDataView = this.f49287j) == null) {
            return;
        }
        noDataView.setVisibility(8);
    }

    public final void k() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            this.f49284g.setNextPage(this.f49286i);
            this.f49286i.f();
            this.f49286i.D(this.f49282e.getResources().getString(R.string.pb_load_more));
        }
    }

    public final void l() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            if (this.f49287j == null) {
                NoDataView a = NoDataViewFactory.a(this.f49282e.getPageContext().getPageActivity(), this.f49283f, NoDataViewFactory.d.b(NoDataViewFactory.ImgType.NODATA, n.f(this.f49282e.getActivity(), R.dimen.ds320)), NoDataViewFactory.e.a(R.string.text_no_search_result), null);
                this.f49287j = a;
                a.onChangeSkinType(this.f49282e.getPageContext(), TbadkCoreApplication.getInst().getSkinType());
            }
            this.f49287j.setVisibility(0);
        }
    }

    public final void n() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            this.f49284g.setNextPage(this.f49286i);
            this.f49286i.f();
            this.f49286i.D(this.f49282e.getResources().getString(R.string.list_no_more));
        }
    }

    public final void o() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            this.f49284g.setNextPage(this.f49286i);
            this.f49286i.R();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, bundle) == null) {
            super.onActivityCreated(bundle);
            this.f49282e = (PostSearchActivity) getBaseFragmentActivity();
            e eVar = new e(this.f49282e.getPageContext());
            this.f49285h = eVar;
            eVar.f(this.l);
            BdListViewHelper.d(this.f49282e.getActivity(), this.f49284g, BdListViewHelper.HeadType.HASTAB);
            this.f49284g.setAdapter((ListAdapter) this.f49285h);
            PbListView pbListView = new PbListView(this.f49282e.getPageContext().getPageActivity());
            this.f49286i = pbListView;
            pbListView.a();
            this.f49284g.setOnSrollToBottomListener(this);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048585, this, i2) == null) {
            super.onChangeSkinType(i2);
            PostSearchActivity postSearchActivity = this.f49282e;
            if (postSearchActivity != null) {
                a.a(postSearchActivity.getPageContext(), this.f49283f);
            }
            PbListView pbListView = this.f49286i;
            if (pbListView != null) {
                pbListView.d(i2);
            }
            e eVar = this.f49285h;
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
            this.f49283f = layoutInflater.inflate(R.layout.post_search_list_fragment, (ViewGroup) null);
            initView();
            return this.f49283f;
        }
        return (View) invokeLLL.objValue;
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onPrimary() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            super.onPrimary();
            if (this.l == this.f49282e.getPostSearchView().a()) {
                p();
                requestData(false);
            }
        }
    }

    @Override // com.baidu.adp.widget.ListView.BdListView.p
    public void onScrollToBottom() {
        b bVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048588, this) == null) && !StringUtils.isNull(this.m) && (bVar = this.f49288k) != null && bVar.b() && this.f49282e.getModel().l(this.m, this.l)) {
            o();
        }
    }

    public final void p() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048589, this) == null) || this.f49282e == null) {
            return;
        }
        TiebaStatic.log(new StatisticItem("c12406").param("fid", this.f49282e.mForumId).param("fname", this.f49282e.mForumName).param("uid", TbadkCoreApplication.getCurrentAccount()).param("tab_id", this.l));
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
            hideLoadingView(this.f49283f);
            if (bVar == null || (list2 = bVar.a) == null || list2.size() == 0) {
                if (z && (bVar2 = this.f49288k) != null && (list = bVar2.a) != null && list.size() != 0) {
                    if (this.f49288k.f17632b.b() == 1) {
                        k();
                        return;
                    } else {
                        n();
                        return;
                    }
                }
                i();
                l();
                this.f49284g.setVisibility(8);
                this.f49288k = bVar;
                return;
            }
            if (z && (bVar3 = this.f49288k) != null && (list3 = bVar3.a) != null && list3.size() != 0) {
                b bVar4 = this.f49288k;
                bVar4.f17632b = bVar.f17632b;
                bVar4.a.addAll(bVar.a);
            } else {
                this.f49288k = bVar;
            }
            if (z) {
                p();
            }
            if (this.f49288k.f17632b.b() == 1) {
                k();
            } else {
                n();
            }
            this.f49285h.c(this.f49288k.a);
            this.f49285h.notifyDataSetChanged();
            this.f49285h.e(this.f49282e.mSearchKey);
            this.f49285h.d(this.f49282e.mForumId);
            if (!z) {
                this.f49284g.setSelection(0);
            }
            this.f49284g.setVisibility(0);
        }
    }

    public void requestData(boolean z) {
        PostSearchActivity postSearchActivity;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048591, this, z) == null) || (postSearchActivity = this.f49282e) == null) {
            return;
        }
        String str = postSearchActivity.mSearchKey;
        if (StringUtils.isNull(str)) {
            return;
        }
        boolean z2 = true;
        boolean z3 = !str.equals(this.m) || z;
        b bVar = this.f49288k;
        if (bVar != null && (bVar == null || bVar.a())) {
            z2 = z3;
        }
        if (z2) {
            showLoadingView(this.f49283f, false, this.f49282e.getResources().getDimensionPixelSize(R.dimen.ds320));
            this.f49282e.getModel().l(str, this.l);
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
