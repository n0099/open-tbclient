package com.baidu.tieba.pluginCenter;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import com.baidu.adp.framework.message.CustomMessage;
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
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NoDataViewFactory;
import com.baidu.tbadk.core.view.y;
import com.baidu.tbadk.mvc.core.ViewEventCenter;
import com.baidu.tieba.w;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class PluginCenterActivity extends BaseActivity<PluginCenterActivity> implements AdapterView.OnItemClickListener, com.baidu.tbadk.mvc.c.a {
    private com.baidu.adp.plugin.packageManager.e Eo = new a(this);
    private BdListView Ik;
    private ViewEventCenter bEJ;
    private com.baidu.tbadk.mvc.f.b<Object, com.baidu.tbadk.mvc.d.b, com.baidu.tbadk.mvc.f.a<Object, com.baidu.tbadk.mvc.d.b>> eVg;
    private List<Object> eVh;
    private int mFromType;
    private NavigationBar mNavigationBar;
    private y mNoDataView;
    private View mRootView;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(w.j.plugin_center_activity);
        this.bEJ = new ViewEventCenter();
        this.bEJ.addEventDelegate(this);
        auG();
        Ue();
    }

    private void auG() {
        if (getIntent() != null) {
            this.mFromType = getIntent().getIntExtra(PluginCenterActivityConfig.KEY_FROM_TYPE, 0);
        }
        this.mNavigationBar = (NavigationBar) findViewById(w.h.navigation_bar);
        this.mNavigationBar.setTitleText(w.l.plugin_center);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
    }

    private void Ue() {
        this.mRootView = findViewById(w.h.parent);
        this.Ik = (BdListView) findViewById(w.h.list);
        this.mNoDataView = NoDataViewFactory.a(getPageContext().getPageActivity(), findViewById(w.h.list_layout), NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, com.baidu.adp.lib.util.k.g(getActivity(), w.f.ds220)), NoDataViewFactory.d.dh(w.l.plugin_no_plugins), null);
        this.Ik.setEmptyView(this.mNoDataView);
        this.eVg = new b(this, getPageContext(), new Class[]{com.baidu.tieba.pluginCenter.a.a.class, com.baidu.tieba.pluginCenter.a.b.class}, new int[]{w.j.plugin_center_list_function_item, w.j.plugin_center_list_desc_item}, this.bEJ);
        this.Ik.setAdapter((ListAdapter) this.eVg);
        this.Ik.setOnItemClickListener(this);
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
        PluginNetConfigInfos jV = com.baidu.adp.plugin.packageManager.pluginServerConfig.d.jU().jV();
        if (jV != null && jV.getConfigs() != null && jV.getConfigs().size() > 0) {
            this.eVh = cv(jV.getConfigs());
            this.eVg.w(this.eVh);
            PluginPackageManager.jx().jM();
        }
        if (this.eVh != null && !this.eVh.isEmpty()) {
            aq.k(this.mRootView, w.e.cp_bg_line_c);
        } else {
            aq.k(this.mRootView, w.e.cp_bg_line_d);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        this.eVg.notifyDataSetChanged();
        getLayoutMode().t(findViewById(16908290));
        if (this.mNoDataView != null) {
            this.mNoDataView.onChangeSkinType(getPageContext(), i);
        }
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        Object item = this.eVg.getItem(i);
        if ((item instanceof PluginNetConfigInfos.PluginConfig) && !(item instanceof PluginConfigWrapper)) {
            sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PluginDetailActivityConfig(getPageContext().getPageActivity(), ((PluginNetConfigInfos.PluginConfig) this.eVg.getItem(i)).package_name)));
        }
    }

    private void a(PluginConfigWrapper pluginConfigWrapper) {
        String format;
        if (pluginConfigWrapper != null && pluginConfigWrapper.newest != null) {
            boolean z = pluginConfigWrapper.getDownLoadStatus() == 4;
            if (z) {
                format = String.format(TbadkApplication.getInst().getString(w.l.plugin_update_size_prompt), Float.valueOf(pluginConfigWrapper.newest.size / 1048576.0f));
            } else {
                format = String.format(TbadkApplication.getInst().getString(w.l.plugin_download_size_prompt), Float.valueOf(pluginConfigWrapper.newest.size / 1048576.0f));
            }
            String string = z ? TbadkCoreApplication.m9getInst().getString(w.l.download_update) : TbadkCoreApplication.m9getInst().getString(w.l.download);
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getActivity());
            aVar.cE(format);
            aVar.a(string, new c(this, pluginConfigWrapper));
            aVar.b(TbadkCoreApplication.m9getInst().getString(w.l.cancel), new d(this));
            aVar.b(getPageContext());
            aVar.tQ();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public PluginConfigWrapper oV(String str) {
        if (str == null) {
            return null;
        }
        List<Object> dataList = this.eVg.getDataList();
        if (dataList == null || dataList.isEmpty()) {
            return null;
        }
        for (Object obj : dataList) {
            if (obj instanceof PluginConfigWrapper) {
                PluginConfigWrapper pluginConfigWrapper = (PluginConfigWrapper) obj;
                if (str.equals(pluginConfigWrapper.package_name)) {
                    return pluginConfigWrapper;
                }
            }
        }
        return null;
    }

    private List<Object> cv(List<PluginNetConfigInfos.PluginConfig> list) {
        PluginSetting findPluginSetting;
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        if (list == null || list.size() == 0) {
            return arrayList;
        }
        for (PluginNetConfigInfos.PluginConfig pluginConfig : list) {
            if (pluginConfig != null && !TextUtils.isEmpty(pluginConfig.display_name) && pluginConfig.forbidden != 1 && ((findPluginSetting = com.baidu.adp.plugin.packageManager.pluginSettings.c.ka().findPluginSetting(pluginConfig.package_name)) == null || pluginConfig.newest == null || findPluginSetting.versionCode <= pluginConfig.newest.version_code)) {
                if (TextUtils.isEmpty(pluginConfig.package_name) || !PluginCenter.NAME_MOTUSDK.equals(pluginConfig.package_name) || com.baidu.adp.lib.b.e.eY().Y("motu_sdk") != 1) {
                    if (this.mFromType == 0) {
                        arrayList2.add(pluginConfig);
                    }
                }
            }
        }
        if (!arrayList2.isEmpty()) {
            arrayList.add(TbadkApplication.getInst().getString(w.l.plugin_function));
            arrayList.addAll(arrayList2);
        }
        return arrayList;
    }

    @Override // com.baidu.tbadk.mvc.c.a
    public boolean a(com.baidu.tbadk.mvc.c.b bVar) {
        int Fl = bVar.Fl();
        com.baidu.tbadk.mvc.b.a Fm = bVar.Fm();
        switch (Fl) {
            case 0:
                if (Fm instanceof PluginConfigWrapper) {
                    PluginConfigWrapper pluginConfigWrapper = (PluginConfigWrapper) Fm;
                    PluginPackageManager.jx().bb(pluginConfigWrapper.package_name);
                    pluginConfigWrapper.setDownLoadStatus(1);
                    this.eVg.D(pluginConfigWrapper);
                    return true;
                }
                break;
            case 1:
                if (Fm instanceof PluginConfigWrapper) {
                    PluginConfigWrapper pluginConfigWrapper2 = (PluginConfigWrapper) Fm;
                    PluginPackageManager.jx().bc(pluginConfigWrapper2.package_name);
                    pluginConfigWrapper2.setDownLoadStatus(2);
                    this.eVg.D(pluginConfigWrapper2);
                    return true;
                }
                break;
            case 2:
                if (Fm instanceof PluginConfigWrapper) {
                    a((PluginConfigWrapper) Fm);
                    return true;
                }
                break;
        }
        return false;
    }

    @Override // com.baidu.tbadk.mvc.c.a
    public boolean Fk() {
        return false;
    }
}
