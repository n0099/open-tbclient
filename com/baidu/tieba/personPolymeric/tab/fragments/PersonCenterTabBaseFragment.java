package com.baidu.tieba.personPolymeric.tab.fragments;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.BaseFragment;
import com.baidu.tbadk.core.data.MetaData;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.z78;
import tbclient.User;
/* loaded from: classes4.dex */
public abstract class PersonCenterTabBaseFragment extends BaseFragment {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public z78 a;

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
        z78 z78Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, view2) == null) || (z78Var = this.a) == null) {
            return;
        }
        z78Var.dettachView(view2);
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i) == null) {
            super.onChangeSkinType(i);
            z78 z78Var = this.a;
            if (z78Var != null) {
                z78Var.onChangeSkinType();
            }
        }
    }

    public abstract void r1(boolean z);

    public abstract int s1();

    @Override // com.baidu.tbadk.core.BaseFragment
    public void showNetRefreshView(View view2, String str, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLZ(1048580, this, view2, str, z) == null) {
            if (this.a == null) {
                z78 z78Var = new z78(getPageContext().getPageActivity(), getNetRefreshListener());
                this.a = z78Var;
                z78Var.e(getPageContext().getResources().getString(R.string.obfuscated_res_0x7f0f0fba));
                this.a.d(null);
                this.a.c(getPageContext().getResources().getString(R.string.obfuscated_res_0x7f0f0fb9));
                this.a.f();
                this.a.b().setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
            }
            this.a.onChangeSkinType();
            this.a.attachView(view2, z);
        }
    }

    public abstract boolean t1();

    public void u1(MetaData metaData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, metaData) == null) {
        }
    }

    public abstract void v1(User user);
}
