package com.baidu.tieba.postsearch;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListAdapter;
import androidx.core.view.InputDeviceCompat;
import c.a.d.f.p.n;
import c.a.o0.w0.a;
import c.a.p0.g3.b;
import c.a.p0.g3.e;
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
/* loaded from: classes5.dex */
public class PostSearchListFragment extends BaseFragment implements BdListView.p {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public PostSearchActivity a;

    /* renamed from: b  reason: collision with root package name */
    public View f35639b;

    /* renamed from: c  reason: collision with root package name */
    public BdListView f35640c;

    /* renamed from: d  reason: collision with root package name */
    public e f35641d;

    /* renamed from: e  reason: collision with root package name */
    public PbListView f35642e;

    /* renamed from: f  reason: collision with root package name */
    public NoDataView f35643f;

    /* renamed from: g  reason: collision with root package name */
    public b f35644g;

    /* renamed from: h  reason: collision with root package name */
    public int f35645h;
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
        this.f35645h = -1;
        this.i = "";
    }

    public void C0() {
        List<b.a> list;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            b bVar = this.f35644g;
            if (bVar != null && (list = bVar.a) != null) {
                list.clear();
                this.f35641d.c(this.f35644g.a);
                this.f35641d.notifyDataSetChanged();
            }
            D0();
            E0();
        }
    }

    public final void D0() {
        BdListView bdListView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || (bdListView = this.f35640c) == null) {
            return;
        }
        bdListView.setNextPage(null);
    }

    public final void E0() {
        NoDataView noDataView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) || (noDataView = this.f35643f) == null) {
            return;
        }
        noDataView.setVisibility(8);
    }

    public final void F0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            this.f35640c = (BdListView) this.f35639b.findViewById(R.id.obfuscated_res_0x7f091a77);
        }
    }

    public void G0(b bVar, boolean z) {
        b bVar2;
        List<b.a> list;
        List<b.a> list2;
        b bVar3;
        List<b.a> list3;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048580, this, bVar, z) == null) {
            E0();
            hideLoadingView(this.f35639b);
            if (bVar == null || (list2 = bVar.a) == null || list2.size() == 0) {
                if (z && (bVar2 = this.f35644g) != null && (list = bVar2.a) != null && list.size() != 0) {
                    if (this.f35644g.f15230b.b() == 1) {
                        I0();
                        return;
                    } else {
                        K0();
                        return;
                    }
                }
                D0();
                J0();
                this.f35640c.setVisibility(8);
                this.f35644g = bVar;
                return;
            }
            if (z && (bVar3 = this.f35644g) != null && (list3 = bVar3.a) != null && list3.size() != 0) {
                b bVar4 = this.f35644g;
                bVar4.f15230b = bVar.f15230b;
                bVar4.a.addAll(bVar.a);
            } else {
                this.f35644g = bVar;
            }
            if (z) {
                M0();
            }
            if (this.f35644g.f15230b.b() == 1) {
                I0();
            } else {
                K0();
            }
            this.f35641d.c(this.f35644g.a);
            this.f35641d.notifyDataSetChanged();
            this.f35641d.e(this.a.mSearchKey);
            this.f35641d.d(this.a.mForumId);
            if (!z) {
                this.f35640c.setSelection(0);
            }
            this.f35640c.setVisibility(0);
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
        b bVar = this.f35644g;
        if (bVar != null && (bVar == null || bVar.a())) {
            z2 = z3;
        }
        if (z2) {
            showLoadingView(this.f35639b, false, this.a.getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f070297));
            this.a.getModel().l(str, this.f35645h);
            this.i = str;
        }
    }

    public final void I0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            this.f35640c.setNextPage(this.f35642e);
            this.f35642e.f();
            this.f35642e.D(this.a.getResources().getString(R.string.obfuscated_res_0x7f0f0da7));
        }
    }

    public final void J0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            if (this.f35643f == null) {
                NoDataView a = NoDataViewFactory.a(this.a.getPageContext().getPageActivity(), this.f35639b, NoDataViewFactory.d.b(NoDataViewFactory.ImgType.NODATA, n.f(this.a.getActivity(), R.dimen.obfuscated_res_0x7f070297)), NoDataViewFactory.e.a(R.string.obfuscated_res_0x7f0f1383), null);
                this.f35643f = a;
                a.f(this.a.getPageContext(), TbadkCoreApplication.getInst().getSkinType());
            }
            this.f35643f.setVisibility(0);
        }
    }

    public final void K0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            this.f35640c.setNextPage(this.f35642e);
            this.f35642e.f();
            this.f35642e.D(this.a.getResources().getString(R.string.obfuscated_res_0x7f0f09e8));
        }
    }

    public final void L0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            this.f35640c.setNextPage(this.f35642e);
            this.f35642e.R();
        }
    }

    public final void M0() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048586, this) == null) || this.a == null) {
            return;
        }
        TiebaStatic.log(new StatisticItem("c12406").param("fid", this.a.mForumId).param("fname", this.a.mForumName).param("uid", TbadkCoreApplication.getCurrentAccount()).param("tab_id", this.f35645h));
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, bundle) == null) {
            super.onActivityCreated(bundle);
            this.a = (PostSearchActivity) getBaseFragmentActivity();
            e eVar = new e(this.a.getPageContext());
            this.f35641d = eVar;
            eVar.f(this.f35645h);
            BdListViewHelper.d(this.a.getActivity(), this.f35640c, BdListViewHelper.HeadType.HASTAB);
            this.f35640c.setAdapter((ListAdapter) this.f35641d);
            PbListView pbListView = new PbListView(this.a.getPageContext().getPageActivity());
            this.f35642e = pbListView;
            pbListView.a();
            this.f35640c.setOnSrollToBottomListener(this);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048588, this, i) == null) {
            super.onChangeSkinType(i);
            PostSearchActivity postSearchActivity = this.a;
            if (postSearchActivity != null) {
                a.a(postSearchActivity.getPageContext(), this.f35639b);
            }
            PbListView pbListView = this.f35642e;
            if (pbListView != null) {
                pbListView.d(i);
            }
            e eVar = this.f35641d;
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
            this.f35639b = layoutInflater.inflate(R.layout.obfuscated_res_0x7f0d06fe, (ViewGroup) null);
            F0();
            return this.f35639b;
        }
        return (View) invokeLLL.objValue;
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onPrimary() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
            super.onPrimary();
            if (this.f35645h == this.a.getPostSearchView().a()) {
                M0();
                H0(false);
            }
        }
    }

    @Override // com.baidu.adp.widget.ListView.BdListView.p
    public void onScrollToBottom() {
        b bVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048591, this) == null) && !StringUtils.isNull(this.i) && (bVar = this.f35644g) != null && bVar.b() && this.a.getModel().l(this.i, this.f35645h)) {
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
        this.f35645h = -1;
        this.i = "";
        this.f35645h = i;
    }
}
