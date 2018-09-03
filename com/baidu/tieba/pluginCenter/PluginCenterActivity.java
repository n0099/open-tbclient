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
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NoDataView;
import com.baidu.tbadk.core.view.NoDataViewFactory;
import com.baidu.tbadk.mvc.c.a;
import com.baidu.tbadk.mvc.c.b;
import com.baidu.tbadk.mvc.core.ViewEventCenter;
import com.baidu.tieba.f;
import java.util.ArrayList;
import java.util.List;
@SuppressLint({"ResourceAsColor"})
/* loaded from: classes2.dex */
public class PluginCenterActivity extends BaseActivity<PluginCenterActivity> implements AdapterView.OnItemClickListener, a {
    private d Ij = new d() { // from class: com.baidu.tieba.pluginCenter.PluginCenterActivity.4
        @Override // com.baidu.adp.plugin.packageManager.d
        public void a(BdFileDownloadData bdFileDownloadData) {
            PluginConfigWrapper sn;
            if (bdFileDownloadData != null && bdFileDownloadData.getId() != null && bdFileDownloadData.getStatus() != 2 && (sn = PluginCenterActivity.this.sn(bdFileDownloadData.getId())) != null) {
                sn.setDownLoadPercent((float) (bdFileDownloadData.getLength() / bdFileDownloadData.getSize()));
                sn.setDownLoadStatus(3);
                PluginCenterActivity.this.gif.F(sn);
            }
        }

        @Override // com.baidu.adp.plugin.packageManager.d
        public void b(BdFileDownloadData bdFileDownloadData) {
        }

        @Override // com.baidu.adp.plugin.packageManager.d
        public void c(BdFileDownloadData bdFileDownloadData) {
            PluginConfigWrapper sn;
            if (bdFileDownloadData != null && bdFileDownloadData.getId() != null && (sn = PluginCenterActivity.this.sn(bdFileDownloadData.getId())) != null) {
                PluginCenterActivity.this.showToast(f.j.download_fail_tip);
                sn.setDownLoadStatus(0);
                PluginCenterActivity.this.gif.F(sn);
            }
        }

        @Override // com.baidu.adp.plugin.packageManager.d
        public void a(BdFileDownloadData bdFileDownloadData, int i, String str) {
            PluginConfigWrapper sn;
            if (bdFileDownloadData != null && bdFileDownloadData.getId() != null && (sn = PluginCenterActivity.this.sn(bdFileDownloadData.getId())) != null) {
                if (i == 0) {
                    PluginCenterActivity.this.showToast(f.j.plugin_installation_finished);
                    PluginCenterActivity.this.cRF.dispatchMvcEvent(new b(1, sn, null, null));
                    return;
                }
                PluginCenterActivity.this.showToast(PluginCenterActivity.this.getPageContext().getString(f.j.plugin_installation_failed) + str);
                sn.setDownLoadStatus(0);
                PluginCenterActivity.this.gif.F(sn);
            }
        }
    };
    private BdListView LO;
    private ViewEventCenter cRF;
    private com.baidu.tbadk.mvc.f.b<Object, com.baidu.tbadk.mvc.d.b, com.baidu.tbadk.mvc.f.a<Object, com.baidu.tbadk.mvc.d.b>> gif;
    private List<Object> gig;
    private int mFromType;
    private NavigationBar mNavigationBar;
    private NoDataView mNoDataView;
    private View mRootView;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(f.h.plugin_center_activity);
        this.cRF = new ViewEventCenter();
        this.cRF.addEventDelegate(this);
        asl();
        TM();
    }

    private void asl() {
        if (getIntent() != null) {
            this.mFromType = getIntent().getIntExtra(PluginCenterActivityConfig.KEY_FROM_TYPE, 0);
        }
        this.mNavigationBar = (NavigationBar) findViewById(f.g.navigation_bar);
        this.mNavigationBar.setTitleText(f.j.plugin_center);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
    }

    private void TM() {
        this.mRootView = findViewById(f.g.parent);
        this.LO = (BdListView) findViewById(f.g.list);
        this.mNoDataView = NoDataViewFactory.a(getPageContext().getPageActivity(), findViewById(f.g.list_layout), NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, l.f(getActivity(), f.e.ds220)), NoDataViewFactory.d.dt(f.j.plugin_no_plugins), null);
        this.LO.setEmptyView(this.mNoDataView);
        this.gif = new com.baidu.tbadk.mvc.f.b<Object, com.baidu.tbadk.mvc.d.b, com.baidu.tbadk.mvc.f.a<Object, com.baidu.tbadk.mvc.d.b>>(getPageContext(), new Class[]{com.baidu.tieba.pluginCenter.a.a.class, com.baidu.tieba.pluginCenter.a.b.class}, new int[]{f.h.plugin_center_list_function_item, f.h.plugin_center_list_desc_item}, this.cRF) { // from class: com.baidu.tieba.pluginCenter.PluginCenterActivity.1
            @Override // com.baidu.tbadk.mvc.f.b
            public int fh(int i) {
                return getItem(i) instanceof String ? 1 : 0;
            }
        };
        this.LO.setAdapter((ListAdapter) this.gif);
        this.LO.setOnItemClickListener(this);
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
        PluginNetConfigInfos mk = com.baidu.adp.plugin.packageManager.pluginServerConfig.d.mj().mk();
        if (mk != null && mk.getConfigs() != null && mk.getConfigs().size() > 0) {
            this.gig = dh(mk.getConfigs());
            this.gif.I(this.gig);
            PluginPackageManager.lN().mb();
        }
        if (this.gig != null && !this.gig.isEmpty()) {
            am.j(this.mRootView, f.d.cp_bg_line_c);
        } else {
            am.j(this.mRootView, f.d.cp_bg_line_d);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        this.gif.notifyDataSetChanged();
        getLayoutMode().onModeChanged(findViewById(16908290));
        if (this.mNoDataView != null) {
            this.mNoDataView.onChangeSkinType(getPageContext(), i);
        }
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        Object item = this.gif.getItem(i);
        if ((item instanceof PluginNetConfigInfos.PluginConfig) && !(item instanceof PluginConfigWrapper)) {
            sendMessage(new CustomMessage(2002001, new PluginDetailActivityConfig(getPageContext().getPageActivity(), ((PluginNetConfigInfos.PluginConfig) this.gif.getItem(i)).package_name)));
        }
    }

    private void a(final PluginConfigWrapper pluginConfigWrapper) {
        String format;
        if (pluginConfigWrapper != null && pluginConfigWrapper.newest != null) {
            boolean z = pluginConfigWrapper.getDownLoadStatus() == 4;
            if (z) {
                format = String.format(TbadkApplication.getInst().getString(f.j.plugin_update_size_prompt), Float.valueOf(pluginConfigWrapper.newest.size / 1048576.0f));
            } else {
                format = String.format(TbadkApplication.getInst().getString(f.j.plugin_download_size_prompt), Float.valueOf(pluginConfigWrapper.newest.size / 1048576.0f));
            }
            String string = z ? TbadkCoreApplication.getInst().getString(f.j.download_update) : TbadkCoreApplication.getInst().getString(f.j.download);
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getActivity());
            aVar.dB(format);
            aVar.a(string, new a.b() { // from class: com.baidu.tieba.pluginCenter.PluginCenterActivity.2
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    if (l.jV()) {
                        PluginPackageManager.lN().a(pluginConfigWrapper, PluginCenterActivity.this.Ij);
                        pluginConfigWrapper.setDownLoadPercent(0.0f);
                        pluginConfigWrapper.setDownLoadStatus(3);
                        PluginCenterActivity.this.gif.F(pluginConfigWrapper);
                    } else {
                        PluginCenterActivity.this.showToast(f.j.neterror);
                    }
                    aVar2.dismiss();
                }
            });
            aVar.b(TbadkCoreApplication.getInst().getString(f.j.cancel), new a.b() { // from class: com.baidu.tieba.pluginCenter.PluginCenterActivity.3
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    aVar2.dismiss();
                }
            });
            aVar.b(getPageContext());
            aVar.xe();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public PluginConfigWrapper sn(String str) {
        if (str == null) {
            return null;
        }
        List<Object> dataList = this.gif.getDataList();
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

    private List<Object> dh(List<PluginNetConfigInfos.PluginConfig> list) {
        PluginSetting findPluginSetting;
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        if (list == null || list.size() == 0) {
            return arrayList;
        }
        for (PluginNetConfigInfos.PluginConfig pluginConfig : list) {
            if (pluginConfig != null && !TextUtils.isEmpty(pluginConfig.display_name) && pluginConfig.forbidden != 1 && ((findPluginSetting = c.mp().findPluginSetting(pluginConfig.package_name)) == null || pluginConfig.newest == null || findPluginSetting.versionCode <= pluginConfig.newest.version_code)) {
                if (TextUtils.isEmpty(pluginConfig.package_name) || !PluginCenter.NAME_MOTUSDK.equals(pluginConfig.package_name) || com.baidu.adp.lib.b.d.hv().ax("motu_sdk") != 1) {
                    if (this.mFromType == 0) {
                        arrayList2.add(pluginConfig);
                    }
                }
            }
        }
        if (!arrayList2.isEmpty()) {
            arrayList.add(TbadkApplication.getInst().getString(f.j.plugin_function));
            arrayList.addAll(arrayList2);
        }
        return arrayList;
    }

    @Override // com.baidu.tbadk.mvc.c.a
    public boolean a(b bVar) {
        int JC = bVar.JC();
        com.baidu.tbadk.mvc.b.a JD = bVar.JD();
        switch (JC) {
            case 0:
                if (JD instanceof PluginConfigWrapper) {
                    PluginConfigWrapper pluginConfigWrapper = (PluginConfigWrapper) JD;
                    PluginPackageManager.lN().bF(pluginConfigWrapper.package_name);
                    pluginConfigWrapper.setDownLoadStatus(1);
                    this.gif.F(pluginConfigWrapper);
                    return true;
                }
                break;
            case 1:
                if (JD instanceof PluginConfigWrapper) {
                    PluginConfigWrapper pluginConfigWrapper2 = (PluginConfigWrapper) JD;
                    PluginPackageManager.lN().bG(pluginConfigWrapper2.package_name);
                    pluginConfigWrapper2.setDownLoadStatus(2);
                    this.gif.F(pluginConfigWrapper2);
                    return true;
                }
                break;
            case 2:
                if (JD instanceof PluginConfigWrapper) {
                    a((PluginConfigWrapper) JD);
                    return true;
                }
                break;
        }
        return false;
    }

    @Override // com.baidu.tbadk.mvc.c.a
    public boolean JB() {
        return false;
    }
}
