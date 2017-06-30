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
import com.baidu.tbadk.core.util.as;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NoDataViewFactory;
import com.baidu.tbadk.core.view.y;
import com.baidu.tbadk.mvc.core.ViewEventCenter;
import com.baidu.tieba.w;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes2.dex */
public class PluginCenterActivity extends BaseActivity<PluginCenterActivity> implements AdapterView.OnItemClickListener, com.baidu.tbadk.mvc.c.a {
    private com.baidu.adp.plugin.packageManager.e Er = new a(this);
    private BdListView Ib;
    private ViewEventCenter bSq;
    private com.baidu.tbadk.mvc.f.b<Object, com.baidu.tbadk.mvc.d.b, com.baidu.tbadk.mvc.f.a<Object, com.baidu.tbadk.mvc.d.b>> fmI;
    private List<Object> fmJ;
    private int mFromType;
    private NavigationBar mNavigationBar;
    private y mNoDataView;
    private View mRootView;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(w.j.plugin_center_activity);
        this.bSq = new ViewEventCenter();
        this.bSq.addEventDelegate(this);
        Vk();
        WS();
    }

    private void Vk() {
        if (getIntent() != null) {
            this.mFromType = getIntent().getIntExtra(PluginCenterActivityConfig.KEY_FROM_TYPE, 0);
        }
        this.mNavigationBar = (NavigationBar) findViewById(w.h.navigation_bar);
        this.mNavigationBar.setTitleText(w.l.plugin_center);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
    }

    private void WS() {
        this.mRootView = findViewById(w.h.parent);
        this.Ib = (BdListView) findViewById(w.h.list);
        this.mNoDataView = NoDataViewFactory.a(getPageContext().getPageActivity(), findViewById(w.h.list_layout), NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, com.baidu.adp.lib.util.k.g(getActivity(), w.f.ds220)), NoDataViewFactory.d.dg(w.l.plugin_no_plugins), null);
        this.Ib.setEmptyView(this.mNoDataView);
        this.fmI = new b(this, getPageContext(), new Class[]{com.baidu.tieba.pluginCenter.a.a.class, com.baidu.tieba.pluginCenter.a.b.class}, new int[]{w.j.plugin_center_list_function_item, w.j.plugin_center_list_desc_item}, this.bSq);
        this.Ib.setAdapter((ListAdapter) this.fmI);
        this.Ib.setOnItemClickListener(this);
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
        PluginNetConfigInfos jT = com.baidu.adp.plugin.packageManager.pluginServerConfig.d.jS().jT();
        if (jT != null && jT.getConfigs() != null && jT.getConfigs().size() > 0) {
            this.fmJ = cF(jT.getConfigs());
            this.fmI.z(this.fmJ);
            PluginPackageManager.jw().jK();
        }
        if (this.fmJ != null && !this.fmJ.isEmpty()) {
            as.k(this.mRootView, w.e.cp_bg_line_c);
        } else {
            as.k(this.mRootView, w.e.cp_bg_line_d);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        this.fmI.notifyDataSetChanged();
        getLayoutMode().t(findViewById(16908290));
        if (this.mNoDataView != null) {
            this.mNoDataView.onChangeSkinType(getPageContext(), i);
        }
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        Object item = this.fmI.getItem(i);
        if ((item instanceof PluginNetConfigInfos.PluginConfig) && !(item instanceof PluginConfigWrapper)) {
            sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PluginDetailActivityConfig(getPageContext().getPageActivity(), ((PluginNetConfigInfos.PluginConfig) this.fmI.getItem(i)).package_name)));
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
            aVar.cI(format);
            aVar.a(string, new c(this, pluginConfigWrapper));
            aVar.b(TbadkCoreApplication.m9getInst().getString(w.l.cancel), new d(this));
            aVar.b(getPageContext());
            aVar.ta();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public PluginConfigWrapper qi(String str) {
        if (str == null) {
            return null;
        }
        List<Object> dataList = this.fmI.getDataList();
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

    private List<Object> cF(List<PluginNetConfigInfos.PluginConfig> list) {
        PluginSetting findPluginSetting;
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        if (list == null || list.size() == 0) {
            return arrayList;
        }
        for (PluginNetConfigInfos.PluginConfig pluginConfig : list) {
            if (pluginConfig != null && !TextUtils.isEmpty(pluginConfig.display_name) && pluginConfig.forbidden != 1 && ((findPluginSetting = com.baidu.adp.plugin.packageManager.pluginSettings.c.jY().findPluginSetting(pluginConfig.package_name)) == null || pluginConfig.newest == null || findPluginSetting.versionCode <= pluginConfig.newest.version_code)) {
                if (TextUtils.isEmpty(pluginConfig.package_name) || !PluginCenter.NAME_MOTUSDK.equals(pluginConfig.package_name) || com.baidu.adp.lib.b.e.eY().ad("motu_sdk") != 1) {
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
        int EG = bVar.EG();
        com.baidu.tbadk.mvc.b.a EH = bVar.EH();
        switch (EG) {
            case 0:
                if (EH instanceof PluginConfigWrapper) {
                    PluginConfigWrapper pluginConfigWrapper = (PluginConfigWrapper) EH;
                    PluginPackageManager.jw().bg(pluginConfigWrapper.package_name);
                    pluginConfigWrapper.setDownLoadStatus(1);
                    this.fmI.D(pluginConfigWrapper);
                    return true;
                }
                break;
            case 1:
                if (EH instanceof PluginConfigWrapper) {
                    PluginConfigWrapper pluginConfigWrapper2 = (PluginConfigWrapper) EH;
                    PluginPackageManager.jw().bh(pluginConfigWrapper2.package_name);
                    pluginConfigWrapper2.setDownLoadStatus(2);
                    this.fmI.D(pluginConfigWrapper2);
                    return true;
                }
                break;
            case 2:
                if (EH instanceof PluginConfigWrapper) {
                    a((PluginConfigWrapper) EH);
                    return true;
                }
                break;
        }
        return false;
    }

    @Override // com.baidu.tbadk.mvc.c.a
    public boolean EF() {
        return false;
    }
}
