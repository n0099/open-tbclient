package com.baidu.tieba.imMessageCenter.mention.officialNotification;

import android.os.Bundle;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import androidx.fragment.app.FragmentManager;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.BaseFragment;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tieba.R;
import com.baidu.tieba.imMessageCenter.mention.OfficialNotificationFragment;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes3.dex */
public class OfficialNotificationActivity extends BaseFragmentActivity {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public BaseFragment mFragment;
    public RelativeLayout mFragmentContainer;
    public NavigationBar mNavigationBar;
    public ViewGroup mRootView;

    public OfficialNotificationActivity() {
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

    private void initFragment() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65537, this) == null) {
            FragmentManager supportFragmentManager = getSupportFragmentManager();
            BaseFragment baseFragment = (BaseFragment) supportFragmentManager.findFragmentByTag(makeFragmentName(OfficialNotificationFragment.class, 0L));
            if (baseFragment == null) {
                baseFragment = new OfficialNotificationFragment();
                supportFragmentManager.beginTransaction().add(this.mFragmentContainer.getId(), baseFragment).commit();
                baseFragment.setPrimary(true);
            }
            this.mFragment = baseFragment;
        }
    }

    private void initViewById() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65538, this) == null) {
            this.mRootView = (ViewGroup) findViewById(R.id.obfuscated_res_0x7f091ad6);
            this.mFragmentContainer = (RelativeLayout) findViewById(R.id.obfuscated_res_0x7f0906da);
            NavigationBar navigationBar = (NavigationBar) findViewById(R.id.obfuscated_res_0x7f091515);
            this.mNavigationBar = navigationBar;
            navigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
            this.mNavigationBar.setCenterTextTitle(getString(R.string.obfuscated_res_0x7f0f1318));
        }
    }

    public static String makeFragmentName(Class cls, long j) {
        InterceptResult invokeLJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLJ = interceptable.invokeLJ(65539, null, cls, j)) == null) {
            return "android:switcher:" + cls.getSimpleName() + ":" + j;
        }
        return (String) invokeLJ.objValue;
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity
    public void onChangeSkinType(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048576, this, i) == null) {
            NavigationBar navigationBar = this.mNavigationBar;
            if (navigationBar != null) {
                navigationBar.onChangeSkinType(getPageContext(), i);
            }
            BaseFragment baseFragment = this.mFragment;
            if (baseFragment != null) {
                baseFragment.onChangeSkinType(i);
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bundle) == null) {
            super.onCreate(bundle);
            setContentView(R.layout.obfuscated_res_0x7f0d0144);
            initViewById();
            initFragment();
        }
    }
}
