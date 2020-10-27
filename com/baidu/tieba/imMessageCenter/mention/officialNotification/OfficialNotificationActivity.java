package com.baidu.tieba.imMessageCenter.mention.officialNotification;

import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import com.baidu.tbadk.core.BaseFragment;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tieba.R;
import com.baidu.tieba.imMessageCenter.mention.OfficialNotificationFragment;
/* loaded from: classes22.dex */
public class OfficialNotificationActivity extends BaseFragmentActivity {
    private BaseFragment gyP;
    private RelativeLayout kqP;
    private NavigationBar mNavigationBar;
    private ViewGroup mRootView;

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.support.v4.app.SupportActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.base_fragment_activity);
        cUx();
        Re();
    }

    private void cUx() {
        this.mRootView = (ViewGroup) findViewById(R.id.root_layout);
        this.kqP = (RelativeLayout) findViewById(R.id.container_layout);
        this.mNavigationBar = (NavigationBar) findViewById(R.id.navigation_bar);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.setCenterTextTitle(getString(R.string.system_message));
    }

    private void Re() {
        FragmentManager supportFragmentManager = getSupportFragmentManager();
        BaseFragment baseFragment = (BaseFragment) supportFragmentManager.findFragmentByTag(a(OfficialNotificationFragment.class, 0L));
        if (baseFragment == null) {
            baseFragment = new OfficialNotificationFragment();
            supportFragmentManager.beginTransaction().add(this.kqP.getId(), baseFragment).commit();
            baseFragment.setPrimary(true);
        }
        this.gyP = baseFragment;
    }

    private static String a(Class cls, long j) {
        return "android:switcher:" + cls.getSimpleName() + ":" + j;
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity
    protected void onChangeSkinType(int i) {
        if (this.mNavigationBar != null) {
            this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        }
        if (this.gyP != null) {
            this.gyP.onChangeSkinType(i);
        }
    }
}
