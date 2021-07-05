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
import d.a.r0.s0.a;
import d.a.s0.r2.b;
import d.a.s0.r2.e;
import java.util.List;
/* loaded from: classes5.dex */
public class PostSearchListFragment extends BaseFragment implements BdListView.p {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public PostSearchActivity f20352e;

    /* renamed from: f  reason: collision with root package name */
    public View f20353f;

    /* renamed from: g  reason: collision with root package name */
    public BdListView f20354g;

    /* renamed from: h  reason: collision with root package name */
    public e f20355h;

    /* renamed from: i  reason: collision with root package name */
    public PbListView f20356i;
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

    public void G0() {
        List<b.a> list;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            b bVar = this.k;
            if (bVar != null && (list = bVar.f65084a) != null) {
                list.clear();
                this.f20355h.c(this.k.f65084a);
                this.f20355h.notifyDataSetChanged();
            }
            H0();
            I0();
        }
    }

    public final void H0() {
        BdListView bdListView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || (bdListView = this.f20354g) == null) {
            return;
        }
        bdListView.setNextPage(null);
    }

    public final void I0() {
        NoDataView noDataView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) || (noDataView = this.j) == null) {
            return;
        }
        noDataView.setVisibility(8);
    }

    public final void J0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            this.f20354g = (BdListView) this.f20353f.findViewById(R.id.result_list);
        }
    }

    public void K0(b bVar, boolean z) {
        b bVar2;
        List<b.a> list;
        List<b.a> list2;
        b bVar3;
        List<b.a> list3;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048580, this, bVar, z) == null) {
            I0();
            hideLoadingView(this.f20353f);
            if (bVar == null || (list2 = bVar.f65084a) == null || list2.size() == 0) {
                if (z && (bVar2 = this.k) != null && (list = bVar2.f65084a) != null && list.size() != 0) {
                    if (this.k.f65085b.b() == 1) {
                        M0();
                        return;
                    } else {
                        O0();
                        return;
                    }
                }
                H0();
                N0();
                this.f20354g.setVisibility(8);
                this.k = bVar;
                return;
            }
            if (z && (bVar3 = this.k) != null && (list3 = bVar3.f65084a) != null && list3.size() != 0) {
                b bVar4 = this.k;
                bVar4.f65085b = bVar.f65085b;
                bVar4.f65084a.addAll(bVar.f65084a);
            } else {
                this.k = bVar;
            }
            if (z) {
                Q0();
            }
            if (this.k.f65085b.b() == 1) {
                M0();
            } else {
                O0();
            }
            this.f20355h.c(this.k.f65084a);
            this.f20355h.notifyDataSetChanged();
            this.f20355h.e(this.f20352e.mSearchKey);
            this.f20355h.d(this.f20352e.mForumId);
            if (!z) {
                this.f20354g.setSelection(0);
            }
            this.f20354g.setVisibility(0);
        }
    }

    public void L0(boolean z) {
        PostSearchActivity postSearchActivity;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048581, this, z) == null) || (postSearchActivity = this.f20352e) == null) {
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
            showLoadingView(this.f20353f, false, this.f20352e.getResources().getDimensionPixelSize(R.dimen.ds320));
            this.f20352e.getModel().l(str, this.l);
            this.m = str;
        }
    }

    public final void M0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            this.f20354g.setNextPage(this.f20356i);
            this.f20356i.f();
            this.f20356i.A(this.f20352e.getResources().getString(R.string.pb_load_more));
        }
    }

    public final void N0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            if (this.j == null) {
                NoDataView a2 = NoDataViewFactory.a(this.f20352e.getPageContext().getPageActivity(), this.f20353f, NoDataViewFactory.d.b(NoDataViewFactory.ImgType.NODATA, l.g(this.f20352e.getActivity(), R.dimen.ds320)), NoDataViewFactory.e.a(R.string.text_no_search_result), null);
                this.j = a2;
                a2.f(this.f20352e.getPageContext(), TbadkCoreApplication.getInst().getSkinType());
            }
            this.j.setVisibility(0);
        }
    }

    public final void O0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            this.f20354g.setNextPage(this.f20356i);
            this.f20356i.f();
            this.f20356i.A(this.f20352e.getResources().getString(R.string.list_no_more));
        }
    }

    public final void P0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            this.f20354g.setNextPage(this.f20356i);
            this.f20356i.O();
        }
    }

    public final void Q0() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048586, this) == null) || this.f20352e == null) {
            return;
        }
        TiebaStatic.log(new StatisticItem("c12406").param("fid", this.f20352e.mForumId).param("fname", this.f20352e.mForumName).param("uid", TbadkCoreApplication.getCurrentAccount()).param("tab_id", this.l));
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, bundle) == null) {
            super.onActivityCreated(bundle);
            this.f20352e = (PostSearchActivity) getBaseFragmentActivity();
            e eVar = new e(this.f20352e.getPageContext());
            this.f20355h = eVar;
            eVar.f(this.l);
            BdListViewHelper.d(this.f20352e.getActivity(), this.f20354g, BdListViewHelper.HeadType.HASTAB);
            this.f20354g.setAdapter((ListAdapter) this.f20355h);
            PbListView pbListView = new PbListView(this.f20352e.getPageContext().getPageActivity());
            this.f20356i = pbListView;
            pbListView.a();
            this.f20354g.setOnSrollToBottomListener(this);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048588, this, i2) == null) {
            super.onChangeSkinType(i2);
            PostSearchActivity postSearchActivity = this.f20352e;
            if (postSearchActivity != null) {
                a.a(postSearchActivity.getPageContext(), this.f20353f);
            }
            PbListView pbListView = this.f20356i;
            if (pbListView != null) {
                pbListView.d(i2);
            }
            e eVar = this.f20355h;
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
            this.f20353f = layoutInflater.inflate(R.layout.post_search_list_fragment, (ViewGroup) null);
            J0();
            return this.f20353f;
        }
        return (View) invokeLLL.objValue;
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onPrimary() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
            super.onPrimary();
            if (this.l == this.f20352e.getPostSearchView().a()) {
                Q0();
                L0(false);
            }
        }
    }

    @Override // com.baidu.adp.widget.ListView.BdListView.p
    public void onScrollToBottom() {
        b bVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048591, this) == null) && !StringUtils.isNull(this.m) && (bVar = this.k) != null && bVar.b() && this.f20352e.getModel().l(this.m, this.l)) {
            P0();
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
