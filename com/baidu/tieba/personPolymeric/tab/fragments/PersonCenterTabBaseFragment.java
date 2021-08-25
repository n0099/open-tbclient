package com.baidu.tieba.personPolymeric.tab.fragments;

import android.view.View;
import android.view.ViewGroup;
import androidx.core.view.InputDeviceCompat;
import c.a.q0.n2.j.l;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.BaseFragment;
import com.baidu.tbadk.core.data.MetaData;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import tbclient.User;
/* loaded from: classes7.dex */
public abstract class PersonCenterTabBaseFragment extends BaseFragment {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public l f55873e;

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

    public abstract void forceRefresh(boolean z);

    public abstract int getTabType();

    @Override // com.baidu.tbadk.core.BaseFragment
    public void hideNetRefreshView(View view) {
        l lVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, view) == null) || (lVar = this.f55873e) == null) {
            return;
        }
        lVar.dettachView(view);
    }

    public abstract boolean isHost();

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048580, this, i2) == null) {
            super.onChangeSkinType(i2);
            l lVar = this.f55873e;
            if (lVar != null) {
                lVar.onChangeSkinType();
            }
        }
    }

    public abstract void scrollToTop();

    public void setAuthor(MetaData metaData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, metaData) == null) {
        }
    }

    public abstract void setUser(User user);

    @Override // com.baidu.tbadk.core.BaseFragment
    public void showNetRefreshView(View view, String str, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLZ(InputDeviceCompat.SOURCE_TOUCHPAD, this, view, str, z) == null) {
            if (this.f55873e == null) {
                l lVar = new l(getPageContext().getPageActivity(), getNetRefreshListener());
                this.f55873e = lVar;
                lVar.e(getPageContext().getResources().getString(R.string.refresh_view_title_text));
                this.f55873e.d(null);
                this.f55873e.c(getPageContext().getResources().getString(R.string.refresh_view_button_text));
                this.f55873e.f();
                this.f55873e.b().setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
            }
            this.f55873e.onChangeSkinType();
            this.f55873e.attachView(view, z);
        }
    }
}
