package com.baidu.tieba.personPolymeric.tab.fragments;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.tbadk.core.BaseFragment;
import com.baidu.tbadk.core.data.MetaData;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.s0.m2.j.l;
import tbclient.User;
/* loaded from: classes5.dex */
public abstract class PersonCenterTabBaseFragment extends BaseFragment {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public l f20183e;

    public PersonCenterTabBaseFragment() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    public abstract void G0(boolean z);

    public abstract int H0();

    public abstract boolean I0();

    public void J0(MetaData metaData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, metaData) == null) {
        }
    }

    public abstract void K0(User user);

    @Override // com.baidu.tbadk.core.BaseFragment
    public void hideNetRefreshView(View view) {
        l lVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048581, this, view) == null) || (lVar = this.f20183e) == null) {
            return;
        }
        lVar.dettachView(view);
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048582, this, i2) == null) {
            super.onChangeSkinType(i2);
            l lVar = this.f20183e;
            if (lVar != null) {
                lVar.onChangeSkinType();
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void showNetRefreshView(View view, String str, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLZ(1048583, this, view, str, z) == null) {
            if (this.f20183e == null) {
                l lVar = new l(getPageContext().getPageActivity(), getNetRefreshListener());
                this.f20183e = lVar;
                lVar.e(getPageContext().getResources().getString(R.string.refresh_view_title_text));
                this.f20183e.d(null);
                this.f20183e.c(getPageContext().getResources().getString(R.string.refresh_view_button_text));
                this.f20183e.f();
                this.f20183e.b().setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
            }
            this.f20183e.onChangeSkinType();
            this.f20183e.attachView(view, z);
        }
    }
}
