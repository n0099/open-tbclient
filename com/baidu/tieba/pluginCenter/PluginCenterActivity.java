package com.baidu.tieba.pluginCenter;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.l;
import com.baidu.adp.plugin.PluginCenter;
import com.baidu.adp.plugin.packageManager.PluginPackageManager;
import com.baidu.adp.plugin.packageManager.d;
import com.baidu.adp.plugin.packageManager.pluginFileDownload.BdFileDownloadData;
import com.baidu.adp.plugin.packageManager.pluginServerConfig.PluginNetConfigInfos;
import com.baidu.adp.plugin.packageManager.pluginSettings.PluginSetting;
import com.baidu.adp.plugin.packageManager.pluginSettings.c;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.PluginCenterActivityConfig;
import com.baidu.tbadk.core.atomData.PluginDetailActivityConfig;
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.aj;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NoDataViewFactory;
import com.baidu.tbadk.core.view.g;
import com.baidu.tbadk.mvc.c.a;
import com.baidu.tbadk.mvc.c.b;
import com.baidu.tbadk.mvc.core.ViewEventCenter;
import com.baidu.tieba.d;
import java.util.ArrayList;
import java.util.List;
@SuppressLint({"ResourceAsColor"})
/* loaded from: classes2.dex */
public class PluginCenterActivity extends BaseActivity<PluginCenterActivity> implements AdapterView.OnItemClickListener, a {
    private d arE = new d() { // from class: com.baidu.tieba.pluginCenter.PluginCenterActivity.4
        @Override // com.baidu.adp.plugin.packageManager.d
        public void a(BdFileDownloadData bdFileDownloadData) {
            PluginConfigWrapper rJ;
            if (bdFileDownloadData != null && bdFileDownloadData.getId() != null && bdFileDownloadData.getStatus() != 2 && (rJ = PluginCenterActivity.this.rJ(bdFileDownloadData.getId())) != null) {
                rJ.setDownLoadPercent((float) (bdFileDownloadData.getLength() / bdFileDownloadData.getSize()));
                rJ.setDownLoadStatus(3);
                PluginCenterActivity.this.gFp.aH(rJ);
            }
        }

        @Override // com.baidu.adp.plugin.packageManager.d
        public void b(BdFileDownloadData bdFileDownloadData) {
        }

        @Override // com.baidu.adp.plugin.packageManager.d
        public void c(BdFileDownloadData bdFileDownloadData) {
            PluginConfigWrapper rJ;
            if (bdFileDownloadData != null && bdFileDownloadData.getId() != null && (rJ = PluginCenterActivity.this.rJ(bdFileDownloadData.getId())) != null) {
                PluginCenterActivity.this.showToast(d.j.download_fail_tip);
                rJ.setDownLoadStatus(0);
                PluginCenterActivity.this.gFp.aH(rJ);
            }
        }

        @Override // com.baidu.adp.plugin.packageManager.d
        public void a(BdFileDownloadData bdFileDownloadData, int i, String str) {
            PluginConfigWrapper rJ;
            if (bdFileDownloadData != null && bdFileDownloadData.getId() != null && (rJ = PluginCenterActivity.this.rJ(bdFileDownloadData.getId())) != null) {
                if (i == 0) {
                    PluginCenterActivity.this.showToast(d.j.plugin_installation_finished);
                    PluginCenterActivity.this.dhh.dispatchMvcEvent(new b(1, rJ, null, null));
                    return;
                }
                PluginCenterActivity.this.showToast(PluginCenterActivity.this.getPageContext().getString(d.j.plugin_installation_failed) + str);
                rJ.setDownLoadStatus(0);
                PluginCenterActivity.this.gFp.aH(rJ);
            }
        }
    };
    private BdListView avk;
    private ViewEventCenter dhh;
    private com.baidu.tbadk.mvc.f.b<Object, com.baidu.tbadk.mvc.d.b, com.baidu.tbadk.mvc.f.a<Object, com.baidu.tbadk.mvc.d.b>> gFp;
    private List<Object> gFq;
    private int mFromType;
    private NavigationBar mNavigationBar;
    private g mNoDataView;
    private View mRootView;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(d.h.plugin_center_activity);
        this.dhh = new ViewEventCenter();
        this.dhh.addEventDelegate(this);
        auI();
        WF();
    }

    private void auI() {
        if (getIntent() != null) {
            this.mFromType = getIntent().getIntExtra(PluginCenterActivityConfig.KEY_FROM_TYPE, 0);
        }
        this.mNavigationBar = (NavigationBar) findViewById(d.g.navigation_bar);
        this.mNavigationBar.setTitleText(d.j.plugin_center);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
    }

    private void WF() {
        this.mRootView = findViewById(d.g.parent);
        this.avk = (BdListView) findViewById(d.g.list);
        this.mNoDataView = NoDataViewFactory.a(getPageContext().getPageActivity(), findViewById(d.g.list_layout), NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, l.s(getActivity(), d.e.ds220)), NoDataViewFactory.d.gp(d.j.plugin_no_plugins), null);
        this.avk.setEmptyView(this.mNoDataView);
        this.gFp = new com.baidu.tbadk.mvc.f.b<Object, com.baidu.tbadk.mvc.d.b, com.baidu.tbadk.mvc.f.a<Object, com.baidu.tbadk.mvc.d.b>>(getPageContext(), new Class[]{com.baidu.tieba.pluginCenter.a.a.class, com.baidu.tieba.pluginCenter.a.b.class}, new int[]{d.h.plugin_center_list_function_item, d.h.plugin_center_list_desc_item}, this.dhh) { // from class: com.baidu.tieba.pluginCenter.PluginCenterActivity.1
            @Override // com.baidu.tbadk.mvc.f.b
            public int ij(int i) {
                return getItem(i) instanceof String ? 1 : 0;
            }
        };
        this.avk.setAdapter((ListAdapter) this.gFp);
        this.avk.setOnItemClickListener(this);
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
        PluginNetConfigInfos ro = com.baidu.adp.plugin.packageManager.pluginServerConfig.d.rn().ro();
        if (ro != null && ro.getConfigs() != null && ro.getConfigs().size() > 0) {
            this.gFq = ds(ro.getConfigs());
            this.gFp.N(this.gFq);
            PluginPackageManager.qR().rf();
        }
        if (this.gFq != null && !this.gFq.isEmpty()) {
            aj.t(this.mRootView, d.C0108d.cp_bg_line_c);
        } else {
            aj.t(this.mRootView, d.C0108d.cp_bg_line_d);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        this.gFp.notifyDataSetChanged();
        getLayoutMode().aM(findViewById(16908290));
        if (this.mNoDataView != null) {
            this.mNoDataView.onChangeSkinType(getPageContext(), i);
        }
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        Object item = this.gFp.getItem(i);
        if ((item instanceof PluginNetConfigInfos.PluginConfig) && !(item instanceof PluginConfigWrapper)) {
            sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PluginDetailActivityConfig(getPageContext().getPageActivity(), ((PluginNetConfigInfos.PluginConfig) this.gFp.getItem(i)).package_name)));
        }
    }

    private void a(final PluginConfigWrapper pluginConfigWrapper) {
        String format;
        if (pluginConfigWrapper != null && pluginConfigWrapper.newest != null) {
            boolean z = pluginConfigWrapper.getDownLoadStatus() == 4;
            if (z) {
                format = String.format(TbadkApplication.getInst().getString(d.j.plugin_update_size_prompt), Float.valueOf(pluginConfigWrapper.newest.size / 1048576.0f));
            } else {
                format = String.format(TbadkApplication.getInst().getString(d.j.plugin_download_size_prompt), Float.valueOf(pluginConfigWrapper.newest.size / 1048576.0f));
            }
            String string = z ? TbadkCoreApplication.getInst().getString(d.j.download_update) : TbadkCoreApplication.getInst().getString(d.j.download);
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getActivity());
            aVar.cZ(format);
            aVar.a(string, new a.b() { // from class: com.baidu.tieba.pluginCenter.PluginCenterActivity.2
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    if (l.oZ()) {
                        PluginPackageManager.qR().a(pluginConfigWrapper, PluginCenterActivity.this.arE);
                        pluginConfigWrapper.setDownLoadPercent(0.0f);
                        pluginConfigWrapper.setDownLoadStatus(3);
                        PluginCenterActivity.this.gFp.aH(pluginConfigWrapper);
                    } else {
                        PluginCenterActivity.this.showToast(d.j.neterror);
                    }
                    aVar2.dismiss();
                }
            });
            aVar.b(TbadkCoreApplication.getInst().getString(d.j.cancel), new a.b() { // from class: com.baidu.tieba.pluginCenter.PluginCenterActivity.3
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    aVar2.dismiss();
                }
            });
            aVar.b(getPageContext());
            aVar.AI();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public PluginConfigWrapper rJ(String str) {
        if (str == null) {
            return null;
        }
        List<Object> dataList = this.gFp.getDataList();
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

    private List<Object> ds(List<PluginNetConfigInfos.PluginConfig> list) {
        PluginSetting findPluginSetting;
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        if (list == null || list.size() == 0) {
            return arrayList;
        }
        for (PluginNetConfigInfos.PluginConfig pluginConfig : list) {
            if (pluginConfig != null && !TextUtils.isEmpty(pluginConfig.display_name) && pluginConfig.forbidden != 1 && ((findPluginSetting = c.rt().findPluginSetting(pluginConfig.package_name)) == null || pluginConfig.newest == null || findPluginSetting.versionCode <= pluginConfig.newest.version_code)) {
                if (TextUtils.isEmpty(pluginConfig.package_name) || !PluginCenter.NAME_MOTUSDK.equals(pluginConfig.package_name) || com.baidu.adp.lib.b.d.mz().an("motu_sdk") != 1) {
                    if (this.mFromType == 0) {
                        arrayList2.add(pluginConfig);
                    }
                }
            }
        }
        if (!arrayList2.isEmpty()) {
            arrayList.add(TbadkApplication.getInst().getString(d.j.plugin_function));
            arrayList.addAll(arrayList2);
        }
        return arrayList;
    }

    @Override // com.baidu.tbadk.mvc.c.a
    public boolean a(b bVar) {
        int MH = bVar.MH();
        com.baidu.tbadk.mvc.b.a MI = bVar.MI();
        switch (MH) {
            case 0:
                if (MI instanceof PluginConfigWrapper) {
                    PluginConfigWrapper pluginConfigWrapper = (PluginConfigWrapper) MI;
                    PluginPackageManager.qR().bt(pluginConfigWrapper.package_name);
                    pluginConfigWrapper.setDownLoadStatus(1);
                    this.gFp.aH(pluginConfigWrapper);
                    return true;
                }
                break;
            case 1:
                if (MI instanceof PluginConfigWrapper) {
                    PluginConfigWrapper pluginConfigWrapper2 = (PluginConfigWrapper) MI;
                    PluginPackageManager.qR().bu(pluginConfigWrapper2.package_name);
                    pluginConfigWrapper2.setDownLoadStatus(2);
                    this.gFp.aH(pluginConfigWrapper2);
                    return true;
                }
                break;
            case 2:
                if (MI instanceof PluginConfigWrapper) {
                    a((PluginConfigWrapper) MI);
                    return true;
                }
                break;
        }
        return false;
    }

    @Override // com.baidu.tbadk.mvc.c.a
    public boolean MG() {
        return false;
    }
}
