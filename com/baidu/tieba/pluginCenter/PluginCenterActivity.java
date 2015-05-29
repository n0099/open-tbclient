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
import com.baidu.tbadk.core.util.ay;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NoDataViewFactory;
import com.baidu.tbadk.core.view.aa;
import com.baidu.tbadk.core.view.ab;
import com.baidu.tbadk.core.view.x;
import com.baidu.tbadk.mvc.core.ViewEventCenter;
import com.baidu.tieba.q;
import com.baidu.tieba.r;
import com.baidu.tieba.t;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class PluginCenterActivity extends BaseActivity<PluginCenterActivity> implements AdapterView.OnItemClickListener, com.baidu.tbadk.mvc.c.a {
    private com.baidu.adp.plugin.packageManager.i DE = new a(this);
    private ViewEventCenter aET;
    private com.baidu.tbadk.mvc.j.b<Object, com.baidu.tbadk.mvc.e.c, com.baidu.tbadk.mvc.j.a<Object, com.baidu.tbadk.mvc.e.c>> bXf;
    private List<Object> bXg;
    private int mFromType;
    private BdListView mListView;
    private NavigationBar mNavigationBar;
    private x mNoDataView;
    private View mRootView;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(r.plugin_center_activity);
        this.aET = new ViewEventCenter();
        this.aET.addEventDelegate(this);
        MM();
        initListView();
    }

    private void MM() {
        if (getIntent() != null) {
            this.mFromType = getIntent().getIntExtra(PluginCenterActivityConfig.KEY_FROM_TYPE, 0);
        }
        this.mNavigationBar = (NavigationBar) findViewById(q.navigation_bar);
        if (this.mFromType == 1) {
            this.mNavigationBar.setTitleText(t.manage);
        } else {
            this.mNavigationBar.setTitleText(t.plugin_center);
        }
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
    }

    private void initListView() {
        this.mRootView = findViewById(q.parent);
        this.mListView = (BdListView) findViewById(q.list);
        this.mNoDataView = NoDataViewFactory.a(getPageContext().getPageActivity(), findViewById(q.list_layout), aa.a(NoDataViewFactory.ImgType.NODATA), ab.cv(t.plugin_no_plugins), null);
        this.mListView.setEmptyView(this.mNoDataView);
        this.bXf = new b(this, getPageContext(), new Class[]{com.baidu.tieba.pluginCenter.a.d.class, com.baidu.tieba.pluginCenter.a.a.class, com.baidu.tieba.pluginCenter.a.e.class}, new int[]{r.plugin_center_list_function_item, r.plugin_center_list_discover_item, r.plugin_center_list_desc_item}, this.aET);
        this.mListView.setAdapter((ListAdapter) this.bXf);
        this.mListView.setOnItemClickListener(this);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onStart() {
        super.onStart();
        PluginNetConfigInfos md = com.baidu.adp.plugin.packageManager.pluginServerConfig.d.mc().md();
        if (md != null && md.getConfigs() != null && md.getConfigs().size() > 0) {
            this.bXg = aU(md.getConfigs());
            this.bXf.s(this.bXg);
            PluginPackageManager.lM().lV();
        }
        if (this.bXg != null && !this.bXg.isEmpty()) {
            ay.j(this.mRootView, com.baidu.tieba.n.cp_bg_line_c);
        } else {
            ay.j(this.mRootView, com.baidu.tieba.n.cp_bg_line_d);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2009504));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        this.bXf.notifyDataSetChanged();
        getLayoutMode().j(findViewById(16908290));
        if (this.mNoDataView != null) {
            this.mNoDataView.onChangeSkinType(getPageContext(), i);
        }
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        Object item = this.bXf.getItem(i);
        if ((item instanceof PluginNetConfigInfos.PluginConfig) && !(item instanceof PluginConfigWrapper)) {
            sendMessage(new CustomMessage(2002001, new PluginDetailActivityConfig(getPageContext().getPageActivity(), ((PluginNetConfigInfos.PluginConfig) this.bXf.getItem(i)).package_name)));
        }
    }

    private void a(PluginConfigWrapper pluginConfigWrapper) {
        String format;
        if (pluginConfigWrapper != null && pluginConfigWrapper.newest != null) {
            boolean z = pluginConfigWrapper.getDownLoadStatus() == 4;
            if (z) {
                format = String.format(TbadkApplication.getInst().getString(t.plugin_update_size_prompt), Float.valueOf(pluginConfigWrapper.newest.size / 1048576.0f));
            } else {
                format = String.format(TbadkApplication.getInst().getString(t.plugin_download_size_prompt), Float.valueOf(pluginConfigWrapper.newest.size / 1048576.0f));
            }
            String string = z ? TbadkCoreApplication.m411getInst().getString(t.download_update) : TbadkCoreApplication.m411getInst().getString(t.download);
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getActivity());
            aVar.cn(format);
            aVar.a(string, new c(this, pluginConfigWrapper));
            aVar.b(TbadkCoreApplication.m411getInst().getString(t.cancel), new d(this));
            aVar.b(getPageContext());
            aVar.rL();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public PluginConfigWrapper iI(String str) {
        if (str == null) {
            return null;
        }
        List<Object> CM = this.bXf.CM();
        if (CM == null || CM.isEmpty()) {
            return null;
        }
        for (Object obj : CM) {
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
        if (PluginPackageManager.lM().bw(pluginConfig.package_name)) {
            if (PluginPackageManager.lM().by(pluginConfig.package_name)) {
                pluginConfigWrapper.setDownLoadStatus(4);
                return pluginConfigWrapper;
            } else if (PluginPackageManager.lM().bx(pluginConfig.package_name)) {
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

    private List<Object> aU(List<PluginNetConfigInfos.PluginConfig> list) {
        PluginSetting findPluginSetting;
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        ArrayList arrayList3 = new ArrayList();
        if (list == null || list.size() == 0) {
            return arrayList;
        }
        for (PluginNetConfigInfos.PluginConfig pluginConfig : list) {
            if (pluginConfig != null && !TextUtils.isEmpty(pluginConfig.display_name) && pluginConfig.forbidden != 1 && ((findPluginSetting = com.baidu.adp.plugin.packageManager.pluginSettings.h.mi().findPluginSetting(pluginConfig.package_name)) == null || pluginConfig.newest == null || findPluginSetting.versionCode <= pluginConfig.newest.version_code)) {
                if (TextUtils.isEmpty(pluginConfig.package_name) || !PluginCenter.NAME_MOTUSDK.equals(pluginConfig.package_name) || com.baidu.adp.lib.b.f.gD().ai("motu_sdk") != 1) {
                    if (com.baidu.tbadk.pluign.a.DM().fb(pluginConfig.ext)) {
                        arrayList3.add(b(pluginConfig));
                    } else if (this.mFromType == 0) {
                        arrayList2.add(pluginConfig);
                    }
                }
            }
        }
        if (!arrayList2.isEmpty()) {
            arrayList.add(TbadkApplication.getInst().getString(t.plugin_function));
            arrayList.addAll(arrayList2);
        }
        if (!arrayList3.isEmpty()) {
            arrayList.add(TbadkApplication.getInst().getString(t.plugin_for_discover));
            arrayList.addAll(arrayList3);
        }
        return arrayList;
    }

    @Override // com.baidu.tbadk.mvc.c.a
    public boolean a(com.baidu.tbadk.mvc.c.b bVar) {
        int Br = bVar.Br();
        com.baidu.tbadk.mvc.b.a Bs = bVar.Bs();
        switch (Br) {
            case 0:
                if (Bs instanceof PluginConfigWrapper) {
                    PluginConfigWrapper pluginConfigWrapper = (PluginConfigWrapper) Bs;
                    PluginPackageManager.lM().bu(pluginConfigWrapper.package_name);
                    pluginConfigWrapper.setDownLoadStatus(1);
                    this.bXf.y(pluginConfigWrapper);
                    com.baidu.tbadk.pluign.a.DM().eY(pluginConfigWrapper.package_name);
                    return true;
                }
                break;
            case 1:
                if (Bs instanceof PluginConfigWrapper) {
                    PluginConfigWrapper pluginConfigWrapper2 = (PluginConfigWrapper) Bs;
                    PluginPackageManager.lM().bv(pluginConfigWrapper2.package_name);
                    pluginConfigWrapper2.setDownLoadStatus(2);
                    this.bXf.y(pluginConfigWrapper2);
                    com.baidu.tbadk.pluign.a.DM().eZ(pluginConfigWrapper2.package_name);
                    return true;
                }
                break;
            case 2:
                if (Bs instanceof PluginConfigWrapper) {
                    a((PluginConfigWrapper) Bs);
                    return true;
                }
                break;
        }
        return false;
    }

    @Override // com.baidu.tbadk.mvc.c.a
    public boolean AM() {
        return false;
    }
}
