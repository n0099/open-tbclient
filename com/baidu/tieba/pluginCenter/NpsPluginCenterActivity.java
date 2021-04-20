package com.baidu.tieba.pluginCenter;

import android.os.Bundle;
import android.view.View;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NoDataView;
import com.baidu.tbadk.coreExtra.view.TbSettingTextTipView;
import com.baidu.tieba.R;
import d.b.c.g.c;
import d.b.h0.g0.f.a;
import d.b.h0.g0.f.b;
import java.util.List;
/* loaded from: classes3.dex */
public class NpsPluginCenterActivity extends BaseActivity {
    public TbSettingTextTipView livePlugin;
    public int mFromType;
    public NavigationBar mNavigationBar;
    public NoDataView mNoDataView;
    public b<Object, d.b.h0.g0.d.b, a<Object, d.b.h0.g0.d.b>> mPluginCenterAdapter;
    public View mRootView;
    public List<Object> mShowList;

    private void initNavigationBar() {
        if (getIntent() != null) {
            this.mFromType = getIntent().getIntExtra("key_from_type", 0);
        }
        NavigationBar navigationBar = (NavigationBar) findViewById(R.id.view_navigation_bar);
        this.mNavigationBar = navigationBar;
        navigationBar.setCenterTextTitle(getString(R.string.plugin_center));
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        getLayoutMode().j(findViewById(16908290));
        NoDataView noDataView = this.mNoDataView;
        if (noDataView != null) {
            noDataView.f(getPageContext(), i);
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.nps_plugin_center_activity);
        initNavigationBar();
        TbSettingTextTipView tbSettingTextTipView = (TbSettingTextTipView) findViewById(R.id.tieba_live_text);
        this.livePlugin = tbSettingTextTipView;
        tbSettingTextTipView.c();
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        this.livePlugin.setTip(c.d().e());
        SkinManager.setBackgroundColor(this.mRootView, R.color.CAM_X0204);
    }
}
