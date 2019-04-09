package com.baidu.tieba.pluginCenter;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.l;
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
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NoDataView;
import com.baidu.tbadk.core.view.NoDataViewFactory;
import com.baidu.tbadk.mvc.c.a;
import com.baidu.tbadk.mvc.c.b;
import com.baidu.tbadk.mvc.core.ViewEventCenter;
import com.baidu.tieba.d;
import java.util.ArrayList;
import java.util.List;
@SuppressLint({"ResourceAsColor"})
/* loaded from: classes3.dex */
public class PluginCenterActivity extends BaseActivity<PluginCenterActivity> implements AdapterView.OnItemClickListener, a {
    private d Lt = new d() { // from class: com.baidu.tieba.pluginCenter.PluginCenterActivity.4
        @Override // com.baidu.adp.plugin.packageManager.d
        public void a(BdFileDownloadData bdFileDownloadData) {
            PluginConfigWrapper AY;
            if (bdFileDownloadData != null && bdFileDownloadData.getId() != null && bdFileDownloadData.getStatus() != 2 && (AY = PluginCenterActivity.this.AY(bdFileDownloadData.getId())) != null) {
                AY.setDownLoadPercent((int) ((bdFileDownloadData.getLength() * 100) / bdFileDownloadData.getSize()));
                AY.setDownLoadStatus(3);
                PluginCenterActivity.this.iau.ac(AY);
            }
        }

        @Override // com.baidu.adp.plugin.packageManager.d
        public void b(BdFileDownloadData bdFileDownloadData) {
        }

        @Override // com.baidu.adp.plugin.packageManager.d
        public void c(BdFileDownloadData bdFileDownloadData) {
            PluginConfigWrapper AY;
            if (bdFileDownloadData != null && bdFileDownloadData.getId() != null && (AY = PluginCenterActivity.this.AY(bdFileDownloadData.getId())) != null) {
                PluginCenterActivity.this.showToast(d.j.download_fail_tip);
                AY.setDownLoadStatus(0);
                PluginCenterActivity.this.iau.ac(AY);
            }
        }

        @Override // com.baidu.adp.plugin.packageManager.d
        public void a(BdFileDownloadData bdFileDownloadData, int i, String str) {
            PluginConfigWrapper AY;
            if (bdFileDownloadData != null && bdFileDownloadData.getId() != null && (AY = PluginCenterActivity.this.AY(bdFileDownloadData.getId())) != null) {
                if (i == 0) {
                    PluginCenterActivity.this.showToast(d.j.plugin_installation_finished);
                    PluginCenterActivity.this.eAL.dispatchMvcEvent(new b(1, AY, null, null));
                    return;
                }
                PluginCenterActivity.this.showToast(PluginCenterActivity.this.getPageContext().getString(d.j.plugin_installation_failed) + str);
                PluginCenterActivity.this.bUr();
            }
        }
    };
    private BdListView Pj;
    private ViewEventCenter eAL;
    private com.baidu.tbadk.mvc.f.b<Object, com.baidu.tbadk.mvc.d.b, com.baidu.tbadk.mvc.f.a<Object, com.baidu.tbadk.mvc.d.b>> iau;
    private List<Object> iav;
    private int mFromType;
    private NavigationBar mNavigationBar;
    private NoDataView mNoDataView;
    private View mRootView;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(d.h.plugin_center_activity);
        this.eAL = new ViewEventCenter();
        this.eAL.addEventDelegate(this);
        aBy();
        aBW();
    }

    private void aBy() {
        if (getIntent() != null) {
            this.mFromType = getIntent().getIntExtra(PluginCenterActivityConfig.KEY_FROM_TYPE, 0);
        }
        this.mNavigationBar = (NavigationBar) findViewById(d.g.navigation_bar);
        this.mNavigationBar.setCenterTextTitle(getString(d.j.plugin_center));
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
    }

    private void aBW() {
        this.mRootView = findViewById(d.g.parent);
        this.Pj = (BdListView) findViewById(d.g.list);
        this.mNoDataView = NoDataViewFactory.a(getPageContext().getPageActivity(), findViewById(d.g.list_layout), NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, l.h(getActivity(), d.e.ds220)), NoDataViewFactory.d.hT(d.j.plugin_no_plugins), null);
        this.Pj.setEmptyView(this.mNoDataView);
        this.iau = new com.baidu.tbadk.mvc.f.b<Object, com.baidu.tbadk.mvc.d.b, com.baidu.tbadk.mvc.f.a<Object, com.baidu.tbadk.mvc.d.b>>(getPageContext(), new Class[]{com.baidu.tieba.pluginCenter.view.a.class, com.baidu.tieba.pluginCenter.view.b.class}, new int[]{d.h.plugin_center_list_function_item, d.h.plugin_center_list_desc_item}, this.eAL) { // from class: com.baidu.tieba.pluginCenter.PluginCenterActivity.1
            @Override // com.baidu.tbadk.mvc.f.b
            public int jS(int i) {
                return getItem(i) instanceof String ? 1 : 0;
            }
        };
        this.Pj.setAdapter((ListAdapter) this.iau);
        this.Pj.setOnItemClickListener(this);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        PluginPackageManager.ni().a(this.Lt);
        PluginNetConfigInfos nG = com.baidu.adp.plugin.packageManager.pluginServerConfig.d.nF().nG();
        if (nG != null && nG.getConfigs() != null && nG.getConfigs().size() > 0) {
            this.iav = dL(nG.getConfigs());
            this.iau.ae(this.iav);
            PluginPackageManager.ni().nw();
        }
        if (this.iav != null && !this.iav.isEmpty()) {
            al.l(this.mRootView, d.C0277d.cp_bg_line_c);
        } else {
            al.l(this.mRootView, d.C0277d.cp_bg_line_d);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        this.iau.notifyDataSetChanged();
        getLayoutMode().onModeChanged(findViewById(16908290));
        if (this.mNoDataView != null) {
            this.mNoDataView.onChangeSkinType(getPageContext(), i);
        }
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        if (this.iau.getItem(i) instanceof PluginConfigWrapper) {
            sendMessage(new CustomMessage(2002001, new PluginDetailActivityConfig(getPageContext().getPageActivity(), ((PluginConfigWrapper) this.iau.getItem(i)).package_name)));
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
            aVar.lz(format);
            aVar.a(string, new a.b() { // from class: com.baidu.tieba.pluginCenter.PluginCenterActivity.2
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    if (l.lo()) {
                        PluginPackageManager.ni().a(pluginConfigWrapper, PluginCenterActivity.this.Lt);
                        pluginConfigWrapper.setDownLoadPercent(0);
                        pluginConfigWrapper.setDownLoadStatus(3);
                        PluginCenterActivity.this.iau.ac(pluginConfigWrapper);
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
            aVar.aaW();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bUr() {
        PluginNetConfigInfos nG = com.baidu.adp.plugin.packageManager.pluginServerConfig.d.nF().nG();
        if (nG != null && nG.getConfigs() != null && nG.getConfigs().size() > 0) {
            this.iav = dL(nG.getConfigs());
            this.iau.ae(this.iav);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public PluginConfigWrapper AY(String str) {
        if (str == null) {
            return null;
        }
        List<Object> dataList = this.iau.getDataList();
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

    private List<Object> dL(List<PluginNetConfigInfos.PluginConfig> list) {
        PluginSetting findPluginSetting;
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        ArrayList arrayList3 = new ArrayList();
        if (list == null || list.size() == 0) {
            return arrayList;
        }
        for (PluginNetConfigInfos.PluginConfig pluginConfig : list) {
            if (pluginConfig != null && !TextUtils.isEmpty(pluginConfig.display_name) && pluginConfig.forbidden != 1 && ((findPluginSetting = c.nL().findPluginSetting(pluginConfig.package_name)) == null || pluginConfig.newest == null || findPluginSetting.versionCode <= pluginConfig.newest.version_code)) {
                if (this.mFromType == 0) {
                    if (PluginPackageManager.ni().bY(pluginConfig.package_name)) {
                        arrayList3.add(new PluginConfigWrapper(pluginConfig));
                    } else {
                        PluginConfigWrapper pluginConfigWrapper = new PluginConfigWrapper(pluginConfig);
                        pluginConfigWrapper.setDownLoadStatus(PluginPackageManager.ni().cc(pluginConfigWrapper.package_name) ? 3 : 0);
                        arrayList2.add(pluginConfigWrapper);
                    }
                }
            }
        }
        if (!v.T(arrayList3)) {
            arrayList.add("已安装");
            arrayList.addAll(arrayList3);
        }
        if (!v.T(arrayList2)) {
            arrayList.add("未安装");
            arrayList.addAll(arrayList2);
        }
        return arrayList;
    }

    @Override // com.baidu.tbadk.mvc.c.a
    public boolean a(b bVar) {
        int anY = bVar.anY();
        com.baidu.tbadk.mvc.b.a anZ = bVar.anZ();
        switch (anY) {
            case 1:
                if (anZ instanceof PluginConfigWrapper) {
                    PluginPackageManager.ni().bX(((PluginConfigWrapper) anZ).package_name);
                    bUr();
                    return true;
                }
                break;
            case 2:
                if (anZ instanceof PluginConfigWrapper) {
                    a((PluginConfigWrapper) anZ);
                    return true;
                }
                break;
            case 3:
                if (anZ instanceof PluginConfigWrapper) {
                    sendMessage(new CustomMessage(2002001, new PluginDetailActivityConfig(getPageContext().getPageActivity(), ((PluginConfigWrapper) anZ).package_name)));
                    break;
                }
                break;
        }
        return false;
    }

    @Override // com.baidu.tbadk.mvc.c.a
    public boolean anX() {
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        PluginPackageManager.ni().a((com.baidu.adp.plugin.packageManager.d) null);
    }
}
