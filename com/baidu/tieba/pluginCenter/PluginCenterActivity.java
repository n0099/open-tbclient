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
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NoDataView;
import com.baidu.tbadk.core.view.NoDataViewFactory;
import com.baidu.tbadk.mvc.c.a;
import com.baidu.tbadk.mvc.c.b;
import com.baidu.tbadk.mvc.core.ViewEventCenter;
import com.baidu.tieba.e;
import java.util.ArrayList;
import java.util.List;
@SuppressLint({"ResourceAsColor"})
/* loaded from: classes4.dex */
public class PluginCenterActivity extends BaseActivity<PluginCenterActivity> implements AdapterView.OnItemClickListener, a {
    private d Lg = new d() { // from class: com.baidu.tieba.pluginCenter.PluginCenterActivity.4
        @Override // com.baidu.adp.plugin.packageManager.d
        public void a(BdFileDownloadData bdFileDownloadData) {
            PluginConfigWrapper uf;
            if (bdFileDownloadData != null && bdFileDownloadData.getId() != null && bdFileDownloadData.getStatus() != 2 && (uf = PluginCenterActivity.this.uf(bdFileDownloadData.getId())) != null) {
                uf.setDownLoadPercent((float) (bdFileDownloadData.getLength() / bdFileDownloadData.getSize()));
                uf.setDownLoadStatus(3);
                PluginCenterActivity.this.gIh.K(uf);
            }
        }

        @Override // com.baidu.adp.plugin.packageManager.d
        public void b(BdFileDownloadData bdFileDownloadData) {
        }

        @Override // com.baidu.adp.plugin.packageManager.d
        public void c(BdFileDownloadData bdFileDownloadData) {
            PluginConfigWrapper uf;
            if (bdFileDownloadData != null && bdFileDownloadData.getId() != null && (uf = PluginCenterActivity.this.uf(bdFileDownloadData.getId())) != null) {
                PluginCenterActivity.this.showToast(e.j.download_fail_tip);
                uf.setDownLoadStatus(0);
                PluginCenterActivity.this.gIh.K(uf);
            }
        }

        @Override // com.baidu.adp.plugin.packageManager.d
        public void a(BdFileDownloadData bdFileDownloadData, int i, String str) {
            PluginConfigWrapper uf;
            if (bdFileDownloadData != null && bdFileDownloadData.getId() != null && (uf = PluginCenterActivity.this.uf(bdFileDownloadData.getId())) != null) {
                if (i == 0) {
                    PluginCenterActivity.this.showToast(e.j.plugin_installation_finished);
                    PluginCenterActivity.this.dqs.dispatchMvcEvent(new b(1, uf, null, null));
                    return;
                }
                PluginCenterActivity.this.showToast(PluginCenterActivity.this.getPageContext().getString(e.j.plugin_installation_failed) + str);
                uf.setDownLoadStatus(0);
                PluginCenterActivity.this.gIh.K(uf);
            }
        }
    };
    private BdListView OF;
    private ViewEventCenter dqs;
    private com.baidu.tbadk.mvc.f.b<Object, com.baidu.tbadk.mvc.d.b, com.baidu.tbadk.mvc.f.a<Object, com.baidu.tbadk.mvc.d.b>> gIh;
    private List<Object> gIi;
    private int mFromType;
    private NavigationBar mNavigationBar;
    private NoDataView mNoDataView;
    private View mRootView;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(e.h.plugin_center_activity);
        this.dqs = new ViewEventCenter();
        this.dqs.addEventDelegate(this);
        azu();
        aaz();
    }

    private void azu() {
        if (getIntent() != null) {
            this.mFromType = getIntent().getIntExtra(PluginCenterActivityConfig.KEY_FROM_TYPE, 0);
        }
        this.mNavigationBar = (NavigationBar) findViewById(e.g.navigation_bar);
        this.mNavigationBar.setTitleText(e.j.plugin_center);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
    }

    private void aaz() {
        this.mRootView = findViewById(e.g.parent);
        this.OF = (BdListView) findViewById(e.g.list);
        this.mNoDataView = NoDataViewFactory.a(getPageContext().getPageActivity(), findViewById(e.g.list_layout), NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, l.h(getActivity(), e.C0210e.ds220)), NoDataViewFactory.d.eq(e.j.plugin_no_plugins), null);
        this.OF.setEmptyView(this.mNoDataView);
        this.gIh = new com.baidu.tbadk.mvc.f.b<Object, com.baidu.tbadk.mvc.d.b, com.baidu.tbadk.mvc.f.a<Object, com.baidu.tbadk.mvc.d.b>>(getPageContext(), new Class[]{com.baidu.tieba.pluginCenter.a.a.class, com.baidu.tieba.pluginCenter.a.b.class}, new int[]{e.h.plugin_center_list_function_item, e.h.plugin_center_list_desc_item}, this.dqs) { // from class: com.baidu.tieba.pluginCenter.PluginCenterActivity.1
            @Override // com.baidu.tbadk.mvc.f.b
            public int gf(int i) {
                return getItem(i) instanceof String ? 1 : 0;
            }
        };
        this.OF.setAdapter((ListAdapter) this.gIh);
        this.OF.setOnItemClickListener(this);
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
        PluginNetConfigInfos nx = com.baidu.adp.plugin.packageManager.pluginServerConfig.d.nw().nx();
        if (nx != null && nx.getConfigs() != null && nx.getConfigs().size() > 0) {
            this.gIi = dz(nx.getConfigs());
            this.gIh.R(this.gIi);
            PluginPackageManager.na().no();
        }
        if (this.gIi != null && !this.gIi.isEmpty()) {
            al.j(this.mRootView, e.d.cp_bg_line_c);
        } else {
            al.j(this.mRootView, e.d.cp_bg_line_d);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        this.gIh.notifyDataSetChanged();
        getLayoutMode().onModeChanged(findViewById(16908290));
        if (this.mNoDataView != null) {
            this.mNoDataView.onChangeSkinType(getPageContext(), i);
        }
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        Object item = this.gIh.getItem(i);
        if ((item instanceof PluginNetConfigInfos.PluginConfig) && !(item instanceof PluginConfigWrapper)) {
            sendMessage(new CustomMessage(2002001, new PluginDetailActivityConfig(getPageContext().getPageActivity(), ((PluginNetConfigInfos.PluginConfig) this.gIh.getItem(i)).package_name)));
        }
    }

    private void a(final PluginConfigWrapper pluginConfigWrapper) {
        String format;
        if (pluginConfigWrapper != null && pluginConfigWrapper.newest != null) {
            boolean z = pluginConfigWrapper.getDownLoadStatus() == 4;
            if (z) {
                format = String.format(TbadkApplication.getInst().getString(e.j.plugin_update_size_prompt), Float.valueOf(pluginConfigWrapper.newest.size / 1048576.0f));
            } else {
                format = String.format(TbadkApplication.getInst().getString(e.j.plugin_download_size_prompt), Float.valueOf(pluginConfigWrapper.newest.size / 1048576.0f));
            }
            String string = z ? TbadkCoreApplication.getInst().getString(e.j.download_update) : TbadkCoreApplication.getInst().getString(e.j.download);
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getActivity());
            aVar.eB(format);
            aVar.a(string, new a.b() { // from class: com.baidu.tieba.pluginCenter.PluginCenterActivity.2
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    if (l.ll()) {
                        PluginPackageManager.na().a(pluginConfigWrapper, PluginCenterActivity.this.Lg);
                        pluginConfigWrapper.setDownLoadPercent(0.0f);
                        pluginConfigWrapper.setDownLoadStatus(3);
                        PluginCenterActivity.this.gIh.K(pluginConfigWrapper);
                    } else {
                        PluginCenterActivity.this.showToast(e.j.neterror);
                    }
                    aVar2.dismiss();
                }
            });
            aVar.b(TbadkCoreApplication.getInst().getString(e.j.cancel), new a.b() { // from class: com.baidu.tieba.pluginCenter.PluginCenterActivity.3
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    aVar2.dismiss();
                }
            });
            aVar.b(getPageContext());
            aVar.BF();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public PluginConfigWrapper uf(String str) {
        if (str == null) {
            return null;
        }
        List<Object> dataList = this.gIh.getDataList();
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

    private List<Object> dz(List<PluginNetConfigInfos.PluginConfig> list) {
        PluginSetting findPluginSetting;
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        if (list == null || list.size() == 0) {
            return arrayList;
        }
        for (PluginNetConfigInfos.PluginConfig pluginConfig : list) {
            if (pluginConfig != null && !TextUtils.isEmpty(pluginConfig.display_name) && pluginConfig.forbidden != 1 && ((findPluginSetting = c.nC().findPluginSetting(pluginConfig.package_name)) == null || pluginConfig.newest == null || findPluginSetting.versionCode <= pluginConfig.newest.version_code)) {
                if (TextUtils.isEmpty(pluginConfig.package_name) || !PluginCenter.NAME_MOTUSDK.equals(pluginConfig.package_name) || com.baidu.adp.lib.b.d.iQ().aO("motu_sdk") != 1) {
                    if (this.mFromType == 0) {
                        arrayList2.add(pluginConfig);
                    }
                }
            }
        }
        if (!arrayList2.isEmpty()) {
            arrayList.add(TbadkApplication.getInst().getString(e.j.plugin_function));
            arrayList.addAll(arrayList2);
        }
        return arrayList;
    }

    @Override // com.baidu.tbadk.mvc.c.a
    public boolean a(b bVar) {
        int Oe = bVar.Oe();
        com.baidu.tbadk.mvc.b.a Of = bVar.Of();
        switch (Oe) {
            case 0:
                if (Of instanceof PluginConfigWrapper) {
                    PluginConfigWrapper pluginConfigWrapper = (PluginConfigWrapper) Of;
                    PluginPackageManager.na().bV(pluginConfigWrapper.package_name);
                    pluginConfigWrapper.setDownLoadStatus(1);
                    this.gIh.K(pluginConfigWrapper);
                    return true;
                }
                break;
            case 1:
                if (Of instanceof PluginConfigWrapper) {
                    PluginConfigWrapper pluginConfigWrapper2 = (PluginConfigWrapper) Of;
                    PluginPackageManager.na().bW(pluginConfigWrapper2.package_name);
                    pluginConfigWrapper2.setDownLoadStatus(2);
                    this.gIh.K(pluginConfigWrapper2);
                    return true;
                }
                break;
            case 2:
                if (Of instanceof PluginConfigWrapper) {
                    a((PluginConfigWrapper) Of);
                    return true;
                }
                break;
        }
        return false;
    }

    @Override // com.baidu.tbadk.mvc.c.a
    public boolean Od() {
        return false;
    }
}
