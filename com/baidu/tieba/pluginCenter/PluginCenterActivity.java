package com.baidu.tieba.pluginCenter;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.plugin.PluginCenter;
import com.baidu.adp.plugin.packageManager.PluginPackageManager;
import com.baidu.adp.plugin.packageManager.pluginServerConfig.PluginNetConfigInfos;
import com.baidu.adp.plugin.packageManager.pluginSettings.PluginSetting;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.PluginCenterActivityConfig;
import com.baidu.tbadk.core.atomData.PluginDetailActivityConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.as;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NoDataViewFactory;
import com.baidu.tbadk.mvc.core.ViewEventCenter;
import com.baidu.tieba.n;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class PluginCenterActivity extends BaseActivity<PluginCenterActivity> implements AdapterView.OnItemClickListener, com.baidu.tbadk.mvc.c.a {
    private com.baidu.adp.plugin.packageManager.e Eh = new a(this);
    private ViewEventCenter aUs;
    private com.baidu.tbadk.mvc.g.b<Object, com.baidu.tbadk.mvc.d.b, com.baidu.tbadk.mvc.g.a<Object, com.baidu.tbadk.mvc.d.b>> dja;
    private List<Object> djb;
    private int mFromType;
    private BdListView mListView;
    private NavigationBar mNavigationBar;
    private com.baidu.tbadk.core.view.o mNoDataView;
    private View mRootView;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(n.h.plugin_center_activity);
        this.aUs = new ViewEventCenter();
        this.aUs.addEventDelegate(this);
        Qz();
        SL();
    }

    private void Qz() {
        if (getIntent() != null) {
            this.mFromType = getIntent().getIntExtra(PluginCenterActivityConfig.KEY_FROM_TYPE, 0);
        }
        this.mNavigationBar = (NavigationBar) findViewById(n.g.navigation_bar);
        if (this.mFromType == 1) {
            this.mNavigationBar.setTitleText(n.j.manage);
        } else {
            this.mNavigationBar.setTitleText(n.j.plugin_center);
        }
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
    }

    private void SL() {
        this.mRootView = findViewById(n.g.parent);
        this.mListView = (BdListView) findViewById(n.g.list);
        this.mNoDataView = NoDataViewFactory.a(getPageContext().getPageActivity(), findViewById(n.g.list_layout), NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA), NoDataViewFactory.d.cM(n.j.plugin_no_plugins), null);
        this.mListView.setEmptyView(this.mNoDataView);
        this.dja = new b(this, getPageContext(), new Class[]{com.baidu.tieba.pluginCenter.a.d.class, com.baidu.tieba.pluginCenter.a.a.class, com.baidu.tieba.pluginCenter.a.e.class}, new int[]{n.h.plugin_center_list_function_item, n.h.plugin_center_list_discover_item, n.h.plugin_center_list_desc_item}, this.aUs);
        this.mListView.setAdapter((ListAdapter) this.dja);
        this.mListView.setOnItemClickListener(this);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onStart() {
        super.onStart();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        PluginNetConfigInfos lK = com.baidu.adp.plugin.packageManager.pluginServerConfig.d.lJ().lK();
        if (lK != null && lK.getConfigs() != null && lK.getConfigs().size() > 0) {
            this.djb = bv(lK.getConfigs());
            this.dja.s(this.djb);
            PluginPackageManager.ls().lC();
        }
        if (this.djb != null && !this.djb.isEmpty()) {
            as.j(this.mRootView, n.d.cp_bg_line_c);
        } else {
            as.j(this.mRootView, n.d.cp_bg_line_d);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.DISCOVER_NEED_REFRESH_NET_PLUGIN));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        this.dja.notifyDataSetChanged();
        getLayoutMode().k(findViewById(16908290));
        if (this.mNoDataView != null) {
            this.mNoDataView.onChangeSkinType(getPageContext(), i);
        }
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        Object item = this.dja.getItem(i);
        if ((item instanceof PluginNetConfigInfos.PluginConfig) && !(item instanceof PluginConfigWrapper)) {
            sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PluginDetailActivityConfig(getPageContext().getPageActivity(), ((PluginNetConfigInfos.PluginConfig) this.dja.getItem(i)).package_name)));
        }
    }

    private void a(PluginConfigWrapper pluginConfigWrapper) {
        String format;
        if (pluginConfigWrapper != null && pluginConfigWrapper.newest != null) {
            boolean z = pluginConfigWrapper.getDownLoadStatus() == 4;
            if (z) {
                format = String.format(TbadkApplication.getInst().getString(n.j.plugin_update_size_prompt), Float.valueOf(pluginConfigWrapper.newest.size / 1048576.0f));
            } else {
                format = String.format(TbadkApplication.getInst().getString(n.j.plugin_download_size_prompt), Float.valueOf(pluginConfigWrapper.newest.size / 1048576.0f));
            }
            String string = z ? TbadkCoreApplication.m411getInst().getString(n.j.download_update) : TbadkCoreApplication.m411getInst().getString(n.j.download);
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getActivity());
            aVar.cF(format);
            aVar.a(string, new c(this, pluginConfigWrapper));
            aVar.b(TbadkCoreApplication.m411getInst().getString(n.j.cancel), new d(this));
            aVar.b(getPageContext());
            aVar.tf();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public PluginConfigWrapper lF(String str) {
        if (str == null) {
            return null;
        }
        List<Object> DS = this.dja.DS();
        if (DS == null || DS.isEmpty()) {
            return null;
        }
        for (Object obj : DS) {
            if (obj instanceof PluginConfigWrapper) {
                PluginConfigWrapper pluginConfigWrapper = (PluginConfigWrapper) obj;
                if (str.equals(pluginConfigWrapper.package_name)) {
                    return pluginConfigWrapper;
                }
            }
        }
        return null;
    }

    private PluginConfigWrapper b(PluginNetConfigInfos.PluginConfig pluginConfig) {
        if (pluginConfig == null) {
            return null;
        }
        PluginConfigWrapper pluginConfigWrapper = new PluginConfigWrapper(pluginConfig);
        if (PluginPackageManager.ls().bw(pluginConfig.package_name)) {
            if (PluginPackageManager.ls().by(pluginConfig.package_name)) {
                pluginConfigWrapper.setDownLoadStatus(4);
                return pluginConfigWrapper;
            } else if (PluginPackageManager.ls().bx(pluginConfig.package_name)) {
                pluginConfigWrapper.setDownLoadStatus(1);
                return pluginConfigWrapper;
            } else {
                pluginConfigWrapper.setDownLoadStatus(2);
                return pluginConfigWrapper;
            }
        }
        pluginConfigWrapper.setDownLoadStatus(0);
        return pluginConfigWrapper;
    }

    private List<Object> bv(List<PluginNetConfigInfos.PluginConfig> list) {
        PluginSetting findPluginSetting;
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        ArrayList arrayList3 = new ArrayList();
        if (list == null || list.size() == 0) {
            return arrayList;
        }
        for (PluginNetConfigInfos.PluginConfig pluginConfig : list) {
            if (pluginConfig != null && !TextUtils.isEmpty(pluginConfig.display_name) && pluginConfig.forbidden != 1 && ((findPluginSetting = com.baidu.adp.plugin.packageManager.pluginSettings.c.lP().findPluginSetting(pluginConfig.package_name)) == null || pluginConfig.newest == null || findPluginSetting.versionCode <= pluginConfig.newest.version_code)) {
                if (TextUtils.isEmpty(pluginConfig.package_name) || !PluginCenter.NAME_MOTUSDK.equals(pluginConfig.package_name) || com.baidu.adp.lib.c.e.gw().aj("motu_sdk") != 1) {
                    if (com.baidu.tbadk.pluign.a.EV().ga(pluginConfig.ext)) {
                        arrayList3.add(b(pluginConfig));
                    } else if (this.mFromType == 0) {
                        arrayList2.add(pluginConfig);
                    }
                }
            }
        }
        if (!arrayList2.isEmpty()) {
            arrayList.add(TbadkApplication.getInst().getString(n.j.plugin_function));
            arrayList.addAll(arrayList2);
        }
        if (!arrayList3.isEmpty()) {
            arrayList.add(TbadkApplication.getInst().getString(n.j.plugin_for_discover));
            arrayList.addAll(arrayList3);
        }
        return arrayList;
    }

    @Override // com.baidu.tbadk.mvc.c.a
    public boolean a(com.baidu.tbadk.mvc.c.b bVar) {
        int Dj = bVar.Dj();
        com.baidu.tbadk.mvc.b.a Dk = bVar.Dk();
        switch (Dj) {
            case 0:
                if (Dk instanceof PluginConfigWrapper) {
                    PluginConfigWrapper pluginConfigWrapper = (PluginConfigWrapper) Dk;
                    PluginPackageManager.ls().bu(pluginConfigWrapper.package_name);
                    pluginConfigWrapper.setDownLoadStatus(1);
                    this.dja.A(pluginConfigWrapper);
                    com.baidu.tbadk.pluign.a.EV().fX(pluginConfigWrapper.package_name);
                    return true;
                }
                break;
            case 1:
                if (Dk instanceof PluginConfigWrapper) {
                    PluginConfigWrapper pluginConfigWrapper2 = (PluginConfigWrapper) Dk;
                    PluginPackageManager.ls().bv(pluginConfigWrapper2.package_name);
                    pluginConfigWrapper2.setDownLoadStatus(2);
                    this.dja.A(pluginConfigWrapper2);
                    com.baidu.tbadk.pluign.a.EV().fY(pluginConfigWrapper2.package_name);
                    return true;
                }
                break;
            case 2:
                if (Dk instanceof PluginConfigWrapper) {
                    a((PluginConfigWrapper) Dk);
                    return true;
                }
                break;
        }
        return false;
    }

    @Override // com.baidu.tbadk.mvc.c.a
    public boolean on() {
        return false;
    }
}
