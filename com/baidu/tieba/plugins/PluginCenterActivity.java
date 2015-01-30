package com.baidu.tieba.plugins;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.plugin.packageManager.PluginPackageManager;
import com.baidu.adp.plugin.packageManager.pluginServerConfig.PluginNetConfigInfos;
import com.baidu.adp.plugin.packageManager.pluginSettings.PluginSetting;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.atomData.PluginDetailActivityConfig;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NoDataViewFactory;
import com.baidu.tbadk.core.view.aa;
import com.baidu.tbadk.core.view.ab;
import com.baidu.tbadk.core.view.x;
import com.baidu.tieba.w;
import com.baidu.tieba.z;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class PluginCenterActivity extends BaseActivity<PluginCenterActivity> {
    private a bLZ;
    private BdListView mListView;
    private NavigationBar mNavigationBar;
    private x mNoDataView;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(com.baidu.tieba.x.plugin_center_activity);
        this.mListView = (BdListView) findViewById(w.list);
        this.mNavigationBar = (NavigationBar) findViewById(w.navigation_bar);
        this.mNavigationBar.setTitleText(z.plugin_center);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNoDataView = NoDataViewFactory.a(getPageContext().getPageActivity(), findViewById(w.list_layout), aa.a(NoDataViewFactory.ImgType.NODATA), ab.cp(z.plugin_no_plugins), null);
        this.mListView.setEmptyView(this.mNoDataView);
    }

    @Override // android.app.Activity
    protected void onStart() {
        PluginSetting findPluginSetting;
        super.onStart();
        this.bLZ = new a(this);
        PluginNetConfigInfos it = com.baidu.adp.plugin.packageManager.pluginServerConfig.d.is().it();
        if (it != null && it.getConfigs() != null && it.getConfigs().size() > 0) {
            ArrayList arrayList = new ArrayList();
            for (PluginNetConfigInfos.PluginConfig pluginConfig : it.getConfigs()) {
                if (pluginConfig != null && !TextUtils.isEmpty(pluginConfig.display_name) && pluginConfig.forbidden != 1 && ((findPluginSetting = com.baidu.adp.plugin.packageManager.pluginSettings.h.iy().findPluginSetting(pluginConfig.package_name)) == null || pluginConfig.newest == null || findPluginSetting.versionCode <= pluginConfig.newest.version_code)) {
                    arrayList.add(pluginConfig);
                }
            }
            this.bLZ.addAll(arrayList);
            PluginPackageManager.ic().in();
        }
        this.mListView.setAdapter((ListAdapter) this.bLZ);
        this.mListView.setOnItemClickListener(this);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        this.bLZ.notifyDataSetChanged();
        getLayoutMode().h(findViewById(16908290));
        if (this.mNoDataView != null) {
            this.mNoDataView.onChangeSkinType(getPageContext(), i);
        }
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        sendMessage(new CustomMessage(2002001, new PluginDetailActivityConfig(getPageContext().getPageActivity(), this.bLZ.getItem(i).package_name)));
    }
}
