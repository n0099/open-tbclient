package com.baidu.tieba.pluginCenter;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.l;
import com.baidu.adp.plugin.packageManager.PluginPackageManager;
import com.baidu.adp.plugin.packageManager.d;
import com.baidu.adp.plugin.packageManager.pluginFileDownload.BdFileDownloadData;
import com.baidu.adp.plugin.packageManager.pluginServerConfig.PluginNetConfigInfos;
import com.baidu.adp.plugin.packageManager.pluginSettings.PluginSetting;
import com.baidu.adp.plugin.packageManager.pluginSettings.c;
import com.baidu.adp.plugin.util.Util;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.PluginCenterActivityConfig;
import com.baidu.tbadk.core.atomData.PluginDetailActivityConfig;
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NoDataView;
import com.baidu.tbadk.core.view.NoDataViewFactory;
import com.baidu.tbadk.mvc.c.a;
import com.baidu.tbadk.mvc.core.ViewEventCenter;
import com.baidu.tbadk.mvc.f.b;
import com.baidu.tieba.R;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
@SuppressLint({"ResourceAsColor"})
/* loaded from: classes5.dex */
public class PluginCenterActivity extends BaseActivity<PluginCenterActivity> implements AdapterView.OnItemClickListener, a {
    private BdListView Ak;
    private ViewEventCenter fNE;
    private b<Object, com.baidu.tbadk.mvc.d.b, com.baidu.tbadk.mvc.f.a<Object, com.baidu.tbadk.mvc.d.b>> juF;
    private List<Object> juG;
    private int mFromType;
    private NavigationBar mNavigationBar;
    private NoDataView mNoDataView;
    private View mRootView;
    private d yc = new d() { // from class: com.baidu.tieba.pluginCenter.PluginCenterActivity.4
        @Override // com.baidu.adp.plugin.packageManager.d
        public void a(BdFileDownloadData bdFileDownloadData) {
            PluginConfigWrapper GK;
            if (bdFileDownloadData != null && bdFileDownloadData.getId() != null && bdFileDownloadData.getStatus() != 2 && (GK = PluginCenterActivity.this.GK(bdFileDownloadData.getId())) != null) {
                GK.setDownLoadPercent((int) ((bdFileDownloadData.getLength() * 100) / bdFileDownloadData.getSize()));
                GK.setDownLoadStatus(3);
                PluginCenterActivity.this.juF.af(GK);
            }
        }

        @Override // com.baidu.adp.plugin.packageManager.d
        public void b(BdFileDownloadData bdFileDownloadData) {
        }

        @Override // com.baidu.adp.plugin.packageManager.d
        public void c(BdFileDownloadData bdFileDownloadData) {
            PluginConfigWrapper GK;
            if (bdFileDownloadData != null && bdFileDownloadData.getId() != null && (GK = PluginCenterActivity.this.GK(bdFileDownloadData.getId())) != null) {
                PluginCenterActivity.this.showToast(R.string.download_fail_tip);
                GK.setDownLoadStatus(0);
                PluginCenterActivity.this.juF.af(GK);
            }
        }

        @Override // com.baidu.adp.plugin.packageManager.d
        public void a(BdFileDownloadData bdFileDownloadData, int i, String str) {
            PluginConfigWrapper GK;
            if (bdFileDownloadData != null && bdFileDownloadData.getId() != null && (GK = PluginCenterActivity.this.GK(bdFileDownloadData.getId())) != null) {
                if (i == 0) {
                    PluginCenterActivity.this.showToast(R.string.plugin_installation_finished);
                    PluginCenterActivity.this.fNE.dispatchMvcEvent(new com.baidu.tbadk.mvc.c.b(1, GK, null, null));
                    return;
                }
                PluginCenterActivity.this.showToast(PluginCenterActivity.this.getPageContext().getString(R.string.plugin_installation_failed) + str);
                PluginCenterActivity.this.cxl();
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.plugin_center_activity);
        this.fNE = new ViewEventCenter();
        this.fNE.addEventDelegate(this);
        aZT();
        bam();
    }

    private void aZT() {
        if (getIntent() != null) {
            this.mFromType = getIntent().getIntExtra(PluginCenterActivityConfig.KEY_FROM_TYPE, 0);
        }
        this.mNavigationBar = (NavigationBar) findViewById(R.id.navigation_bar);
        this.mNavigationBar.setCenterTextTitle(getString(R.string.plugin_center));
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
    }

    private void bam() {
        this.mRootView = findViewById(R.id.parent);
        this.Ak = (BdListView) findViewById(R.id.list);
        this.mNoDataView = NoDataViewFactory.a(getPageContext().getPageActivity(), findViewById(R.id.list_layout), NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, l.getDimens(getActivity(), R.dimen.ds220)), NoDataViewFactory.d.kQ(R.string.plugin_no_plugins), null);
        this.Ak.setEmptyView(this.mNoDataView);
        this.juF = new b<Object, com.baidu.tbadk.mvc.d.b, com.baidu.tbadk.mvc.f.a<Object, com.baidu.tbadk.mvc.d.b>>(getPageContext(), new Class[]{com.baidu.tieba.pluginCenter.view.a.class, com.baidu.tieba.pluginCenter.view.b.class}, new int[]{R.layout.plugin_center_list_function_item, R.layout.plugin_center_list_desc_item}, this.fNE) { // from class: com.baidu.tieba.pluginCenter.PluginCenterActivity.1
            @Override // com.baidu.tbadk.mvc.f.b
            public int mq(int i) {
                return getItem(i) instanceof String ? 1 : 0;
            }
        };
        this.Ak.setAdapter((ListAdapter) this.juF);
        this.Ak.setOnItemClickListener(this);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        PluginPackageManager.je().a(this.yc);
        PluginNetConfigInfos jC = com.baidu.adp.plugin.packageManager.pluginServerConfig.d.jB().jC();
        if (jC != null && jC.getConfigs() != null && jC.getConfigs().size() > 0) {
            this.juG = ea(jC.getConfigs());
            this.juF.aL(this.juG);
            PluginPackageManager.je().js();
        }
        if (this.juG != null && !this.juG.isEmpty()) {
            am.setBackgroundColor(this.mRootView, R.color.cp_bg_line_c);
        } else {
            am.setBackgroundColor(this.mRootView, R.color.cp_bg_line_d);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        this.juF.notifyDataSetChanged();
        getLayoutMode().onModeChanged(findViewById(16908290));
        if (this.mNoDataView != null) {
            this.mNoDataView.onChangeSkinType(getPageContext(), i);
        }
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        if (this.juF.getItem(i) instanceof PluginConfigWrapper) {
            sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PluginDetailActivityConfig(getPageContext().getPageActivity(), ((PluginConfigWrapper) this.juF.getItem(i)).package_name)));
        }
    }

    private void a(final PluginConfigWrapper pluginConfigWrapper) {
        String format;
        if (pluginConfigWrapper != null && pluginConfigWrapper.newest != null) {
            boolean z = pluginConfigWrapper.getDownLoadStatus() == 4;
            if (z) {
                format = String.format(TbadkApplication.getInst().getString(R.string.plugin_update_size_prompt), Float.valueOf(pluginConfigWrapper.newest.size / 1048576.0f));
            } else {
                format = String.format(TbadkApplication.getInst().getString(R.string.plugin_download_size_prompt), Float.valueOf(pluginConfigWrapper.newest.size / 1048576.0f));
            }
            String string = z ? TbadkCoreApplication.getInst().getString(R.string.download_update) : TbadkCoreApplication.getInst().getString(R.string.download);
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getActivity());
            aVar.sz(format);
            aVar.a(string, new a.b() { // from class: com.baidu.tieba.pluginCenter.PluginCenterActivity.2
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    if (l.isNetOk()) {
                        PluginPackageManager.je().a(pluginConfigWrapper, PluginCenterActivity.this.yc);
                        pluginConfigWrapper.setDownLoadPercent(0);
                        pluginConfigWrapper.setDownLoadStatus(3);
                        PluginCenterActivity.this.juF.af(pluginConfigWrapper);
                    } else {
                        PluginCenterActivity.this.showToast(R.string.neterror);
                    }
                    aVar2.dismiss();
                }
            });
            aVar.b(TbadkCoreApplication.getInst().getString(R.string.cancel), new a.b() { // from class: com.baidu.tieba.pluginCenter.PluginCenterActivity.3
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    aVar2.dismiss();
                }
            });
            aVar.b(getPageContext());
            aVar.aBW();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cxl() {
        PluginNetConfigInfos jC = com.baidu.adp.plugin.packageManager.pluginServerConfig.d.jB().jC();
        if (jC != null && jC.getConfigs() != null && jC.getConfigs().size() > 0) {
            this.juG = ea(jC.getConfigs());
            this.juF.aL(this.juG);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public PluginConfigWrapper GK(String str) {
        if (str == null) {
            return null;
        }
        List<Object> dataList = this.juF.getDataList();
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

    private List<Object> ea(List<PluginNetConfigInfos.PluginConfig> list) {
        PluginSetting findPluginSetting;
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        ArrayList arrayList3 = new ArrayList();
        if (list == null || list.size() == 0) {
            return arrayList;
        }
        for (PluginNetConfigInfos.PluginConfig pluginConfig : list) {
            if (pluginConfig != null && !TextUtils.isEmpty(pluginConfig.display_name) && pluginConfig.forbidden != 1 && ((findPluginSetting = c.jH().findPluginSetting(pluginConfig.package_name)) == null || pluginConfig.newest == null || findPluginSetting.versionCode <= pluginConfig.newest.version_code)) {
                if (this.mFromType == 0) {
                    if (PluginPackageManager.je().bd(pluginConfig.package_name) && !PluginPackageManager.je().bh(pluginConfig.package_name)) {
                        arrayList3.add(new PluginConfigWrapper(pluginConfig));
                    } else {
                        PluginConfigWrapper pluginConfigWrapper = new PluginConfigWrapper(pluginConfig);
                        pluginConfigWrapper.setDownLoadStatus(PluginPackageManager.je().bh(pluginConfigWrapper.package_name) ? 3 : 0);
                        pluginConfigWrapper.setDownLoadPercent(a(pluginConfig));
                        arrayList2.add(pluginConfigWrapper);
                    }
                }
            }
        }
        if (!v.isEmpty(arrayList3)) {
            arrayList.add("已安装");
            arrayList.addAll(arrayList3);
        }
        if (!v.isEmpty(arrayList2)) {
            arrayList.add("未安装");
            arrayList.addAll(arrayList2);
        }
        return arrayList;
    }

    private int a(PluginNetConfigInfos.PluginConfig pluginConfig) {
        PluginSetting findPluginSetting;
        if (pluginConfig == null || (findPluginSetting = c.jH().findPluginSetting(pluginConfig.package_name)) == null) {
            return 0;
        }
        String f = Util.f(findPluginSetting);
        if (aq.isEmpty(f)) {
            return 0;
        }
        try {
            File file = new File(f + ".tmp");
            if (!file.exists() || findPluginSetting.size <= 0) {
                return 0;
            }
            return (int) (((file.length() * 1.0d) / findPluginSetting.size) * 100.0d);
        } catch (Exception e) {
            BdLog.e(e);
            return 0;
        }
    }

    @Override // com.baidu.tbadk.mvc.c.a
    public boolean a(com.baidu.tbadk.mvc.c.b bVar) {
        int aNy = bVar.aNy();
        com.baidu.tbadk.mvc.b.a aNz = bVar.aNz();
        switch (aNy) {
            case 1:
                if (aNz instanceof PluginConfigWrapper) {
                    PluginPackageManager.je().bc(((PluginConfigWrapper) aNz).package_name);
                    cxl();
                    return true;
                }
                break;
            case 2:
                if (aNz instanceof PluginConfigWrapper) {
                    a((PluginConfigWrapper) aNz);
                    return true;
                }
                break;
            case 3:
                if (aNz instanceof PluginConfigWrapper) {
                    sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PluginDetailActivityConfig(getPageContext().getPageActivity(), ((PluginConfigWrapper) aNz).package_name)));
                    break;
                }
                break;
        }
        return false;
    }

    @Override // com.baidu.tbadk.mvc.c.a
    public boolean aNx() {
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        PluginPackageManager.je().a((d) null);
    }
}
