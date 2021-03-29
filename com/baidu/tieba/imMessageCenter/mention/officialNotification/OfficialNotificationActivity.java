package com.baidu.tieba.imMessageCenter.mention.officialNotification;

import android.os.Bundle;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import androidx.fragment.app.FragmentManager;
import com.baidu.tbadk.core.BaseFragment;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tieba.R;
import com.baidu.tieba.imMessageCenter.mention.OfficialNotificationFragment;
/* loaded from: classes3.dex */
public class OfficialNotificationActivity extends BaseFragmentActivity {
    public BaseFragment mFragment;
    public RelativeLayout mFragmentContainer;
    public NavigationBar mNavigationBar;
    public ViewGroup mRootView;

    private void initFragment() {
        FragmentManager supportFragmentManager = getSupportFragmentManager();
        BaseFragment baseFragment = (BaseFragment) supportFragmentManager.findFragmentByTag(makeFragmentName(OfficialNotificationFragment.class, 0L));
        if (baseFragment == null) {
            baseFragment = new OfficialNotificationFragment();
            supportFragmentManager.beginTransaction().add(this.mFragmentContainer.getId(), baseFragment).commit();
            baseFragment.setPrimary(true);
        }
        this.mFragment = baseFragment;
    }

    private void initViewById() {
        this.mRootView = (ViewGroup) findViewById(R.id.root_layout);
        this.mFragmentContainer = (RelativeLayout) findViewById(R.id.container_layout);
        NavigationBar navigationBar = (NavigationBar) findViewById(R.id.navigation_bar);
        this.mNavigationBar = navigationBar;
        navigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.setCenterTextTitle(getString(R.string.system_message));
    }

    public static String makeFragmentName(Class cls, long j) {
        return "android:switcher:" + cls.getSimpleName() + ":" + j;
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity
    public void onChangeSkinType(int i) {
        NavigationBar navigationBar = this.mNavigationBar;
        if (navigationBar != null) {
            navigationBar.onChangeSkinType(getPageContext(), i);
        }
        BaseFragment baseFragment = this.mFragment;
        if (baseFragment != null) {
            baseFragment.onChangeSkinType(i);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, androidx.fragment.app.FragmentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.base_fragment_activity);
        initViewById();
        initFragment();
    }
}
