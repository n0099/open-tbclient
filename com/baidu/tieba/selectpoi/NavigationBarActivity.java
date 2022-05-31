package com.baidu.tieba.selectpoi;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.RelativeLayout;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NoDataView;
import com.baidu.tbadk.core.view.NoDataViewFactory;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes3.dex */
public class NavigationBarActivity extends BaseActivity<NavigationBarActivity> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public RelativeLayout contentRootView;
    public NavigationBar navigationBar;
    public NoDataView noDataView;
    public NoNetworkView noNetWorkView;
    public RelativeLayout rootView;

    /* loaded from: classes3.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ NavigationBarActivity a;

        public a(NavigationBarActivity navigationBarActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {navigationBarActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = navigationBarActivity;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                this.a.finish();
            }
        }
    }

    public NavigationBarActivity() {
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

    public View getContentRootView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.contentRootView : (View) invokeV.objValue;
    }

    public View getRootView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.rootView : (View) invokeV.objValue;
    }

    public void hideNoDataView() {
        NoDataView noDataView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) || (noDataView = this.noDataView) == null) {
            return;
        }
        noDataView.setVisibility(8);
    }

    public boolean needNoNetWorkView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return true;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048580, this, i) == null) {
            super.onChangeSkinType(i);
            this.navigationBar.onChangeSkinType(getPageContext(), i);
            NoNetworkView noNetworkView = this.noNetWorkView;
            if (noNetworkView != null) {
                noNetworkView.c(getPageContext(), i);
            }
            NoDataView noDataView = this.noDataView;
            if (noDataView != null) {
                noDataView.f(getPageContext(), i);
            }
            getLayoutMode().k(i == 1);
            getLayoutMode().j(this.rootView);
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, bundle) == null) {
            super.onCreate(bundle);
            super.setContentView(R.layout.obfuscated_res_0x7f0d05db);
            this.navigationBar = (NavigationBar) findViewById(R.id.obfuscated_res_0x7f0914f2);
            this.rootView = (RelativeLayout) findViewById(R.id.obfuscated_res_0x7f0914f6);
            this.navigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new a(this));
            if (needNoNetWorkView()) {
                this.noNetWorkView = (NoNetworkView) ((ViewStub) findViewById(R.id.obfuscated_res_0x7f09156d)).inflate();
            }
        }
    }

    @Override // android.app.Activity
    public void setContentView(View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, view2) == null) {
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
            needNoNetWorkView();
            RelativeLayout relativeLayout = new RelativeLayout(getPageContext().getContext());
            this.contentRootView = relativeLayout;
            relativeLayout.addView(view2, new ViewGroup.LayoutParams(-1, -1));
            this.rootView.addView(this.contentRootView, 0, layoutParams);
        }
    }

    public void showNoDataView(NoDataViewFactory.d dVar, NoDataViewFactory.e eVar, NoDataViewFactory.c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, dVar, eVar, cVar) == null) {
            if (this.noDataView == null) {
                this.noDataView = NoDataViewFactory.a(getPageContext().getContext(), this.rootView, dVar, eVar, cVar);
            }
            this.noDataView.f(getPageContext(), TbadkCoreApplication.getInst().getSkinType());
            this.noDataView.setVisibility(0);
        }
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void setContentView(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048582, this, i) == null) {
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
            if (needNoNetWorkView()) {
                layoutParams.addRule(3, R.id.obfuscated_res_0x7f09156c);
            } else {
                layoutParams.addRule(3, R.id.obfuscated_res_0x7f09156d);
            }
            RelativeLayout relativeLayout = new RelativeLayout(getPageContext().getContext());
            this.contentRootView = relativeLayout;
            relativeLayout.addView(LayoutInflater.from(getPageContext().getContext()).inflate(i, (ViewGroup) null), new ViewGroup.LayoutParams(-1, -1));
            this.rootView.addView(this.contentRootView, layoutParams);
        }
    }
}
