package com.baidu.tieba.personPolymeric.tab.fragments;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.tbadk.core.BaseFragment;
import com.baidu.tbadk.core.data.MetaData;
import com.baidu.tieba.R;
import com.baidu.tieba.ss9;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import tbclient.User;
/* loaded from: classes7.dex */
public abstract class PersonCenterTabBaseFragment extends BaseFragment {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public ss9 a;

    public abstract void I1(boolean z);

    public abstract int J1();

    public abstract boolean K1();

    public void L1(MetaData metaData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, metaData) == null) {
        }
    }

    public abstract void M1(User user);

    public PersonCenterTabBaseFragment() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void hideNetRefreshView(View view2) {
        ss9 ss9Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048581, this, view2) == null) && (ss9Var = this.a) != null) {
            ss9Var.dettachView(view2);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048582, this, i) == null) {
            super.onChangeSkinType(i);
            ss9 ss9Var = this.a;
            if (ss9Var != null) {
                ss9Var.onChangeSkinType();
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void showNetRefreshView(View view2, String str, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLZ(1048583, this, view2, str, z) == null) {
            if (this.a == null) {
                ss9 ss9Var = new ss9(getPageContext().getPageActivity(), getNetRefreshListener());
                this.a = ss9Var;
                ss9Var.d(getPageContext().getResources().getString(R.string.refresh_view_title_text));
                this.a.c(null);
                this.a.b(getPageContext().getResources().getString(R.string.refresh_view_button_text));
                this.a.e();
                this.a.getAttachedView().setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
            }
            this.a.onChangeSkinType();
            this.a.attachView(view2, z);
        }
    }
}
