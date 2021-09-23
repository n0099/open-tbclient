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
/* loaded from: classes7.dex */
public class NavigationBarActivity extends BaseActivity<NavigationBarActivity> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public RelativeLayout contentRootView;
    public NavigationBar navigationBar;
    public NoDataView noDataView;
    public NoNetworkView noNetWorkView;
    public RelativeLayout rootView;

    /* loaded from: classes7.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ NavigationBarActivity f56718e;

        public a(NavigationBarActivity navigationBarActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {navigationBarActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f56718e = navigationBarActivity;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.f56718e.finish();
            }
        }
    }

    public NavigationBarActivity() {
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
    public void onChangeSkinType(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048580, this, i2) == null) {
            super.onChangeSkinType(i2);
            this.navigationBar.onChangeSkinType(getPageContext(), i2);
            NoNetworkView noNetworkView = this.noNetWorkView;
            if (noNetworkView != null) {
                noNetworkView.onChangeSkinType(getPageContext(), i2);
            }
            NoDataView noDataView = this.noDataView;
            if (noDataView != null) {
                noDataView.onChangeSkinType(getPageContext(), i2);
            }
            getLayoutMode().k(i2 == 1);
            getLayoutMode().j(this.rootView);
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, bundle) == null) {
            super.onCreate(bundle);
            super.setContentView(R.layout.nevigationbar_layout);
            this.navigationBar = (NavigationBar) findViewById(R.id.navigation_bar);
            this.rootView = (RelativeLayout) findViewById(R.id.navigation_bar_root);
            this.navigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new a(this));
            if (needNoNetWorkView()) {
                this.noNetWorkView = (NoNetworkView) ((ViewStub) findViewById(R.id.no_network_viewstub)).inflate();
            }
        }
    }

    @Override // android.app.Activity
    public void setContentView(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, view) == null) {
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
            needNoNetWorkView();
            RelativeLayout relativeLayout = new RelativeLayout(getPageContext().getContext());
            this.contentRootView = relativeLayout;
            relativeLayout.addView(view, new ViewGroup.LayoutParams(-1, -1));
            this.rootView.addView(this.contentRootView, 0, layoutParams);
        }
    }

    public void showNoDataView(NoDataViewFactory.d dVar, NoDataViewFactory.e eVar, NoDataViewFactory.c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, dVar, eVar, cVar) == null) {
            if (this.noDataView == null) {
                this.noDataView = NoDataViewFactory.a(getPageContext().getContext(), this.rootView, dVar, eVar, cVar);
            }
            this.noDataView.onChangeSkinType(getPageContext(), TbadkCoreApplication.getInst().getSkinType());
            this.noDataView.setVisibility(0);
        }
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void setContentView(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048582, this, i2) == null) {
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
            if (needNoNetWorkView()) {
                layoutParams.addRule(3, R.id.no_network_view);
            } else {
                layoutParams.addRule(3, R.id.no_network_viewstub);
            }
            RelativeLayout relativeLayout = new RelativeLayout(getPageContext().getContext());
            this.contentRootView = relativeLayout;
            relativeLayout.addView(LayoutInflater.from(getPageContext().getContext()).inflate(i2, (ViewGroup) null), new ViewGroup.LayoutParams(-1, -1));
            this.rootView.addView(this.contentRootView, layoutParams);
        }
    }
}
