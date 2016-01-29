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
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NoDataViewFactory;
import com.baidu.tbadk.mvc.core.ViewEventCenter;
import com.baidu.tieba.t;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class PluginCenterActivity extends BaseActivity<PluginCenterActivity> implements AdapterView.OnItemClickListener, com.baidu.tbadk.mvc.c.a {
    private com.baidu.adp.plugin.packageManager.e Ev = new a(this);
    private BdListView IY;
    private ViewEventCenter aWA;
    private com.baidu.tbadk.mvc.g.b<Object, com.baidu.tbadk.mvc.d.b, com.baidu.tbadk.mvc.g.a<Object, com.baidu.tbadk.mvc.d.b>> dwU;
    private List<Object> dwV;
    private int mFromType;
    private NavigationBar mNavigationBar;
    private com.baidu.tbadk.core.view.o mNoDataView;
    private View mRootView;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(t.h.plugin_center_activity);
        this.aWA = new ViewEventCenter();
        this.aWA.addEventDelegate(this);
        SG();
        UU();
    }

    private void SG() {
        if (getIntent() != null) {
            this.mFromType = getIntent().getIntExtra(PluginCenterActivityConfig.KEY_FROM_TYPE, 0);
        }
        this.mNavigationBar = (NavigationBar) findViewById(t.g.navigation_bar);
        if (this.mFromType == 1) {
            this.mNavigationBar.setTitleText(t.j.manage);
        } else {
            this.mNavigationBar.setTitleText(t.j.plugin_center);
        }
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
    }

    private void UU() {
        this.mRootView = findViewById(t.g.parent);
        this.IY = (BdListView) findViewById(t.g.list);
        this.mNoDataView = NoDataViewFactory.a(getPageContext().getPageActivity(), findViewById(t.g.list_layout), NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA), NoDataViewFactory.d.dd(t.j.plugin_no_plugins), null);
        this.IY.setEmptyView(this.mNoDataView);
        this.dwU = new b(this, getPageContext(), new Class[]{com.baidu.tieba.pluginCenter.a.d.class, com.baidu.tieba.pluginCenter.a.a.class, com.baidu.tieba.pluginCenter.a.e.class}, new int[]{t.h.plugin_center_list_function_item, t.h.plugin_center_list_discover_item, t.h.plugin_center_list_desc_item}, this.aWA);
        this.IY.setAdapter((ListAdapter) this.dwU);
        this.IY.setOnItemClickListener(this);
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
        PluginNetConfigInfos lX = com.baidu.adp.plugin.packageManager.pluginServerConfig.d.lW().lX();
        if (lX != null && lX.getConfigs() != null && lX.getConfigs().size() > 0) {
            this.dwV = bF(lX.getConfigs());
            this.dwU.w(this.dwV);
            PluginPackageManager.lD().lP();
        }
        if (this.dwV != null && !this.dwV.isEmpty()) {
            ar.l(this.mRootView, t.d.cp_bg_line_c);
        } else {
            ar.l(this.mRootView, t.d.cp_bg_line_d);
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
        this.dwU.notifyDataSetChanged();
        getLayoutMode().x(findViewById(16908290));
        if (this.mNoDataView != null) {
            this.mNoDataView.onChangeSkinType(getPageContext(), i);
        }
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        Object item = this.dwU.getItem(i);
        if ((item instanceof PluginNetConfigInfos.PluginConfig) && !(item instanceof PluginConfigWrapper)) {
            sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PluginDetailActivityConfig(getPageContext().getPageActivity(), ((PluginNetConfigInfos.PluginConfig) this.dwU.getItem(i)).package_name)));
        }
    }

    private void a(PluginConfigWrapper pluginConfigWrapper) {
        String format;
        if (pluginConfigWrapper != null && pluginConfigWrapper.newest != null) {
            boolean z = pluginConfigWrapper.getDownLoadStatus() == 4;
            if (z) {
                format = String.format(TbadkApplication.getInst().getString(t.j.plugin_update_size_prompt), Float.valueOf(pluginConfigWrapper.newest.size / 1048576.0f));
            } else {
                format = String.format(TbadkApplication.getInst().getString(t.j.plugin_download_size_prompt), Float.valueOf(pluginConfigWrapper.newest.size / 1048576.0f));
            }
            String string = z ? TbadkCoreApplication.m411getInst().getString(t.j.download_update) : TbadkCoreApplication.m411getInst().getString(t.j.download);
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getActivity());
            aVar.cE(format);
            aVar.a(string, new c(this, pluginConfigWrapper));
            aVar.b(TbadkCoreApplication.m411getInst().getString(t.j.cancel), new d(this));
            aVar.b(getPageContext());
            aVar.uj();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public PluginConfigWrapper lT(String str) {
        if (str == null) {
            return null;
        }
        List<Object> Fm = this.dwU.Fm();
        if (Fm == null || Fm.isEmpty()) {
            return null;
        }
        for (Object obj : Fm) {
            if (obj instanceof PluginConfigWrapper) {
                PluginConfigWrapper pluginConfigWrapper = (PluginConfigWrapper) obj;
                if (str.equals(pluginConfigWrapper.package_name)) {
                    return pluginConfigWrapper;
                }
            }
        }
        return null;
    }

    private PluginConfigWrapper a(PluginNetConfigInfos.PluginConfig pluginConfig) {
        if (pluginConfig == null) {
            return null;
        }
        PluginConfigWrapper pluginConfigWrapper = new PluginConfigWrapper(pluginConfig);
        if (PluginPackageManager.lD().bw(pluginConfig.package_name)) {
            if (PluginPackageManager.lD().by(pluginConfig.package_name)) {
                pluginConfigWrapper.setDownLoadStatus(4);
                return pluginConfigWrapper;
            } else if (PluginPackageManager.lD().bx(pluginConfig.package_name)) {
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

    private List<Object> bF(List<PluginNetConfigInfos.PluginConfig> list) {
        PluginSetting findPluginSetting;
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        ArrayList arrayList3 = new ArrayList();
        if (list == null || list.size() == 0) {
            return arrayList;
        }
        for (PluginNetConfigInfos.PluginConfig pluginConfig : list) {
            if (pluginConfig != null && !TextUtils.isEmpty(pluginConfig.display_name) && pluginConfig.forbidden != 1 && ((findPluginSetting = com.baidu.adp.plugin.packageManager.pluginSettings.c.mc().findPluginSetting(pluginConfig.package_name)) == null || pluginConfig.newest == null || findPluginSetting.versionCode <= pluginConfig.newest.version_code)) {
                if (TextUtils.isEmpty(pluginConfig.package_name) || !PluginCenter.NAME_MOTUSDK.equals(pluginConfig.package_name) || com.baidu.adp.lib.c.e.gE().ai("motu_sdk") != 1) {
                    if (com.baidu.tbadk.pluign.a.Gm().fX(pluginConfig.ext)) {
                        arrayList3.add(a(pluginConfig));
                    } else if (this.mFromType == 0) {
                        arrayList2.add(pluginConfig);
                    }
                }
            }
        }
        if (!arrayList2.isEmpty()) {
            arrayList.add(TbadkApplication.getInst().getString(t.j.plugin_function));
            arrayList.addAll(arrayList2);
        }
        if (!arrayList3.isEmpty()) {
            arrayList.add(TbadkApplication.getInst().getString(t.j.plugin_for_discover));
            arrayList.addAll(arrayList3);
        }
        return arrayList;
    }

    @Override // com.baidu.tbadk.mvc.c.a
    public boolean a(com.baidu.tbadk.mvc.c.b bVar) {
        int EE = bVar.EE();
        com.baidu.tbadk.mvc.b.a EF = bVar.EF();
        switch (EE) {
            case 0:
                if (EF instanceof PluginConfigWrapper) {
                    PluginConfigWrapper pluginConfigWrapper = (PluginConfigWrapper) EF;
                    PluginPackageManager.lD().bu(pluginConfigWrapper.package_name);
                    pluginConfigWrapper.setDownLoadStatus(1);
                    this.dwU.A(pluginConfigWrapper);
                    com.baidu.tbadk.pluign.a.Gm().fU(pluginConfigWrapper.package_name);
                    return true;
                }
                break;
            case 1:
                if (EF instanceof PluginConfigWrapper) {
                    PluginConfigWrapper pluginConfigWrapper2 = (PluginConfigWrapper) EF;
                    PluginPackageManager.lD().bv(pluginConfigWrapper2.package_name);
                    pluginConfigWrapper2.setDownLoadStatus(2);
                    this.dwU.A(pluginConfigWrapper2);
                    com.baidu.tbadk.pluign.a.Gm().fV(pluginConfigWrapper2.package_name);
                    return true;
                }
                break;
            case 2:
                if (EF instanceof PluginConfigWrapper) {
                    a((PluginConfigWrapper) EF);
                    return true;
                }
                break;
        }
        return false;
    }

    @Override // com.baidu.tbadk.mvc.c.a
    public boolean oI() {
        return false;
    }
}
