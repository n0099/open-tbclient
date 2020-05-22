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
import com.baidu.tbadk.mvc.c.b;
import com.baidu.tbadk.mvc.core.ViewEventCenter;
import com.baidu.tieba.R;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
@SuppressLint({"ResourceAsColor"})
/* loaded from: classes8.dex */
public class PluginCenterActivity extends BaseActivity<PluginCenterActivity> implements AdapterView.OnItemClickListener, a {
    private d RT = new d() { // from class: com.baidu.tieba.pluginCenter.PluginCenterActivity.4
        @Override // com.baidu.adp.plugin.packageManager.d
        public void a(BdFileDownloadData bdFileDownloadData) {
            PluginConfigWrapper KF;
            if (bdFileDownloadData != null && bdFileDownloadData.getId() != null && bdFileDownloadData.getStatus() != 2 && (KF = PluginCenterActivity.this.KF(bdFileDownloadData.getId())) != null) {
                KF.setDownLoadPercent((int) ((bdFileDownloadData.getLength() * 100) / bdFileDownloadData.getSize()));
                KF.setDownLoadStatus(3);
                PluginCenterActivity.this.kCT.am(KF);
            }
        }

        @Override // com.baidu.adp.plugin.packageManager.d
        public void b(BdFileDownloadData bdFileDownloadData) {
        }

        @Override // com.baidu.adp.plugin.packageManager.d
        public void c(BdFileDownloadData bdFileDownloadData) {
            PluginConfigWrapper KF;
            if (bdFileDownloadData != null && bdFileDownloadData.getId() != null && (KF = PluginCenterActivity.this.KF(bdFileDownloadData.getId())) != null) {
                PluginCenterActivity.this.showToast(R.string.download_fail_tip);
                KF.setDownLoadStatus(0);
                PluginCenterActivity.this.kCT.am(KF);
            }
        }

        @Override // com.baidu.adp.plugin.packageManager.d
        public void a(BdFileDownloadData bdFileDownloadData, int i, String str) {
            PluginConfigWrapper KF;
            if (bdFileDownloadData != null && bdFileDownloadData.getId() != null && (KF = PluginCenterActivity.this.KF(bdFileDownloadData.getId())) != null) {
                if (i == 0) {
                    PluginCenterActivity.this.showToast(R.string.plugin_installation_finished);
                    PluginCenterActivity.this.gNE.dispatchMvcEvent(new b(1, KF, null, null));
                    return;
                }
                PluginCenterActivity.this.showToast(PluginCenterActivity.this.getPageContext().getString(R.string.plugin_installation_failed) + str);
                PluginCenterActivity.this.cRU();
            }
        }
    };
    private BdListView Um;
    private int fpq;
    private ViewEventCenter gNE;
    private com.baidu.tbadk.mvc.f.b<Object, com.baidu.tbadk.mvc.d.b, com.baidu.tbadk.mvc.f.a<Object, com.baidu.tbadk.mvc.d.b>> kCT;
    private List<Object> kCU;
    private NavigationBar mNavigationBar;
    private NoDataView mNoDataView;
    private View mRootView;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.plugin_center_activity);
        this.gNE = new ViewEventCenter();
        this.gNE.addEventDelegate(this);
        brb();
        brr();
    }

    private void brb() {
        if (getIntent() != null) {
            this.fpq = getIntent().getIntExtra(PluginCenterActivityConfig.KEY_FROM_TYPE, 0);
        }
        this.mNavigationBar = (NavigationBar) findViewById(R.id.navigation_bar);
        this.mNavigationBar.setCenterTextTitle(getString(R.string.plugin_center));
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
    }

    private void brr() {
        this.mRootView = findViewById(R.id.parent);
        this.Um = (BdListView) findViewById(R.id.list);
        this.mNoDataView = NoDataViewFactory.a(getPageContext().getPageActivity(), findViewById(R.id.list_layout), NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, l.getDimens(getActivity(), R.dimen.ds220)), NoDataViewFactory.d.lT(R.string.plugin_no_plugins), null);
        this.Um.setEmptyView(this.mNoDataView);
        this.kCT = new com.baidu.tbadk.mvc.f.b<Object, com.baidu.tbadk.mvc.d.b, com.baidu.tbadk.mvc.f.a<Object, com.baidu.tbadk.mvc.d.b>>(getPageContext(), new Class[]{com.baidu.tieba.pluginCenter.view.a.class, com.baidu.tieba.pluginCenter.view.b.class}, new int[]{R.layout.plugin_center_list_function_item, R.layout.plugin_center_list_desc_item}, this.gNE) { // from class: com.baidu.tieba.pluginCenter.PluginCenterActivity.1
            @Override // com.baidu.tbadk.mvc.f.b
            public int nw(int i) {
                return getItem(i) instanceof String ? 1 : 0;
            }
        };
        this.Um.setAdapter((ListAdapter) this.kCT);
        this.Um.setOnItemClickListener(this);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        PluginPackageManager.nX().a(this.RT);
        PluginNetConfigInfos ov = com.baidu.adp.plugin.packageManager.pluginServerConfig.d.ou().ov();
        if (ov != null && ov.getConfigs() != null && ov.getConfigs().size() > 0) {
            this.kCU = ep(ov.getConfigs());
            this.kCT.aP(this.kCU);
            PluginPackageManager.nX().om();
        }
        if (this.kCU != null && !this.kCU.isEmpty()) {
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
        this.kCT.notifyDataSetChanged();
        getLayoutMode().onModeChanged(findViewById(16908290));
        if (this.mNoDataView != null) {
            this.mNoDataView.onChangeSkinType(getPageContext(), i);
        }
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        if (this.kCT.getItem(i) instanceof PluginConfigWrapper) {
            sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PluginDetailActivityConfig(getPageContext().getPageActivity(), ((PluginConfigWrapper) this.kCT.getItem(i)).package_name)));
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
            aVar.vO(format);
            aVar.a(string, new a.b() { // from class: com.baidu.tieba.pluginCenter.PluginCenterActivity.2
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    if (l.isNetOk()) {
                        PluginPackageManager.nX().a(pluginConfigWrapper, PluginCenterActivity.this.RT);
                        pluginConfigWrapper.setDownLoadPercent(0);
                        pluginConfigWrapper.setDownLoadStatus(3);
                        PluginCenterActivity.this.kCT.am(pluginConfigWrapper);
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
            aVar.aST();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cRU() {
        PluginNetConfigInfos ov = com.baidu.adp.plugin.packageManager.pluginServerConfig.d.ou().ov();
        if (ov != null && ov.getConfigs() != null && ov.getConfigs().size() > 0) {
            this.kCU = ep(ov.getConfigs());
            this.kCT.aP(this.kCU);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public PluginConfigWrapper KF(String str) {
        if (str == null) {
            return null;
        }
        List<Object> dataList = this.kCT.getDataList();
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

    private List<Object> ep(List<PluginNetConfigInfos.PluginConfig> list) {
        PluginSetting findPluginSetting;
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        ArrayList arrayList3 = new ArrayList();
        if (list == null || list.size() == 0) {
            return arrayList;
        }
        for (PluginNetConfigInfos.PluginConfig pluginConfig : list) {
            if (pluginConfig != null && !TextUtils.isEmpty(pluginConfig.display_name) && pluginConfig.forbidden != 1 && ((findPluginSetting = c.oA().findPluginSetting(pluginConfig.package_name)) == null || pluginConfig.newest == null || findPluginSetting.versionCode <= pluginConfig.newest.version_code)) {
                if (this.fpq == 0) {
                    if (PluginPackageManager.nX().cv(pluginConfig.package_name) && !PluginPackageManager.nX().cz(pluginConfig.package_name)) {
                        arrayList3.add(new PluginConfigWrapper(pluginConfig));
                    } else {
                        PluginConfigWrapper pluginConfigWrapper = new PluginConfigWrapper(pluginConfig);
                        pluginConfigWrapper.setDownLoadStatus(PluginPackageManager.nX().cz(pluginConfigWrapper.package_name) ? 3 : 0);
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
        if (pluginConfig == null || (findPluginSetting = c.oA().findPluginSetting(pluginConfig.package_name)) == null) {
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
    public boolean a(b bVar) {
        int beR = bVar.beR();
        com.baidu.tbadk.mvc.b.a beS = bVar.beS();
        switch (beR) {
            case 1:
                if (beS instanceof PluginConfigWrapper) {
                    PluginPackageManager.nX().cu(((PluginConfigWrapper) beS).package_name);
                    cRU();
                    return true;
                }
                break;
            case 2:
                if (beS instanceof PluginConfigWrapper) {
                    a((PluginConfigWrapper) beS);
                    return true;
                }
                break;
            case 3:
                if (beS instanceof PluginConfigWrapper) {
                    sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PluginDetailActivityConfig(getPageContext().getPageActivity(), ((PluginConfigWrapper) beS).package_name)));
                    break;
                }
                break;
        }
        return false;
    }

    @Override // com.baidu.tbadk.mvc.c.a
    public boolean beQ() {
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        PluginPackageManager.nX().a((d) null);
    }
}
