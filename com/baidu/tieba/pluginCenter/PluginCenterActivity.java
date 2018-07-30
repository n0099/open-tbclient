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
import com.baidu.tieba.d;
import java.util.ArrayList;
import java.util.List;
@SuppressLint({"ResourceAsColor"})
/* loaded from: classes2.dex */
public class PluginCenterActivity extends BaseActivity<PluginCenterActivity> implements AdapterView.OnItemClickListener, a {
    private d Ij = new d() { // from class: com.baidu.tieba.pluginCenter.PluginCenterActivity.4
        @Override // com.baidu.adp.plugin.packageManager.d
        public void a(BdFileDownloadData bdFileDownloadData) {
            PluginConfigWrapper sk;
            if (bdFileDownloadData != null && bdFileDownloadData.getId() != null && bdFileDownloadData.getStatus() != 2 && (sk = PluginCenterActivity.this.sk(bdFileDownloadData.getId())) != null) {
                sk.setDownLoadPercent((float) (bdFileDownloadData.getLength() / bdFileDownloadData.getSize()));
                sk.setDownLoadStatus(3);
                PluginCenterActivity.this.gig.F(sk);
            }
        }

        @Override // com.baidu.adp.plugin.packageManager.d
        public void b(BdFileDownloadData bdFileDownloadData) {
        }

        @Override // com.baidu.adp.plugin.packageManager.d
        public void c(BdFileDownloadData bdFileDownloadData) {
            PluginConfigWrapper sk;
            if (bdFileDownloadData != null && bdFileDownloadData.getId() != null && (sk = PluginCenterActivity.this.sk(bdFileDownloadData.getId())) != null) {
                PluginCenterActivity.this.showToast(d.j.download_fail_tip);
                sk.setDownLoadStatus(0);
                PluginCenterActivity.this.gig.F(sk);
            }
        }

        @Override // com.baidu.adp.plugin.packageManager.d
        public void a(BdFileDownloadData bdFileDownloadData, int i, String str) {
            PluginConfigWrapper sk;
            if (bdFileDownloadData != null && bdFileDownloadData.getId() != null && (sk = PluginCenterActivity.this.sk(bdFileDownloadData.getId())) != null) {
                if (i == 0) {
                    PluginCenterActivity.this.showToast(d.j.plugin_installation_finished);
                    PluginCenterActivity.this.cRI.dispatchMvcEvent(new b(1, sk, null, null));
                    return;
                }
                PluginCenterActivity.this.showToast(PluginCenterActivity.this.getPageContext().getString(d.j.plugin_installation_failed) + str);
                sk.setDownLoadStatus(0);
                PluginCenterActivity.this.gig.F(sk);
            }
        }
    };
    private BdListView LO;
    private int bCT;
    private ViewEventCenter cRI;
    private com.baidu.tbadk.mvc.f.b<Object, com.baidu.tbadk.mvc.d.b, com.baidu.tbadk.mvc.f.a<Object, com.baidu.tbadk.mvc.d.b>> gig;
    private List<Object> gih;
    private NavigationBar mNavigationBar;
    private NoDataView mNoDataView;
    private View mRootView;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(d.h.plugin_center_activity);
        this.cRI = new ViewEventCenter();
        this.cRI.addEventDelegate(this);
        asl();
        TJ();
    }

    private void asl() {
        if (getIntent() != null) {
            this.bCT = getIntent().getIntExtra(PluginCenterActivityConfig.KEY_FROM_TYPE, 0);
        }
        this.mNavigationBar = (NavigationBar) findViewById(d.g.navigation_bar);
        this.mNavigationBar.setTitleText(d.j.plugin_center);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
    }

    private void TJ() {
        this.mRootView = findViewById(d.g.parent);
        this.LO = (BdListView) findViewById(d.g.list);
        this.mNoDataView = NoDataViewFactory.a(getPageContext().getPageActivity(), findViewById(d.g.list_layout), NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, l.f(getActivity(), d.e.ds220)), NoDataViewFactory.d.du(d.j.plugin_no_plugins), null);
        this.LO.setEmptyView(this.mNoDataView);
        this.gig = new com.baidu.tbadk.mvc.f.b<Object, com.baidu.tbadk.mvc.d.b, com.baidu.tbadk.mvc.f.a<Object, com.baidu.tbadk.mvc.d.b>>(getPageContext(), new Class[]{com.baidu.tieba.pluginCenter.a.a.class, com.baidu.tieba.pluginCenter.a.b.class}, new int[]{d.h.plugin_center_list_function_item, d.h.plugin_center_list_desc_item}, this.cRI) { // from class: com.baidu.tieba.pluginCenter.PluginCenterActivity.1
            @Override // com.baidu.tbadk.mvc.f.b
            public int fi(int i) {
                return getItem(i) instanceof String ? 1 : 0;
            }
        };
        this.LO.setAdapter((ListAdapter) this.gig);
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
            this.gih = dh(mk.getConfigs());
            this.gig.I(this.gih);
            PluginPackageManager.lN().mb();
        }
        if (this.gih != null && !this.gih.isEmpty()) {
            am.j(this.mRootView, d.C0140d.cp_bg_line_c);
        } else {
            am.j(this.mRootView, d.C0140d.cp_bg_line_d);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        this.gig.notifyDataSetChanged();
        getLayoutMode().onModeChanged(findViewById(16908290));
        if (this.mNoDataView != null) {
            this.mNoDataView.onChangeSkinType(getPageContext(), i);
        }
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        Object item = this.gig.getItem(i);
        if ((item instanceof PluginNetConfigInfos.PluginConfig) && !(item instanceof PluginConfigWrapper)) {
            sendMessage(new CustomMessage(2002001, new PluginDetailActivityConfig(getPageContext().getPageActivity(), ((PluginNetConfigInfos.PluginConfig) this.gig.getItem(i)).package_name)));
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
            aVar.dB(format);
            aVar.a(string, new a.b() { // from class: com.baidu.tieba.pluginCenter.PluginCenterActivity.2
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    if (l.jV()) {
                        PluginPackageManager.lN().a(pluginConfigWrapper, PluginCenterActivity.this.Ij);
                        pluginConfigWrapper.setDownLoadPercent(0.0f);
                        pluginConfigWrapper.setDownLoadStatus(3);
                        PluginCenterActivity.this.gig.F(pluginConfigWrapper);
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
            aVar.xf();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public PluginConfigWrapper sk(String str) {
        if (str == null) {
            return null;
        }
        List<Object> dataList = this.gig.getDataList();
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
                    if (this.bCT == 0) {
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
        int Jy = bVar.Jy();
        com.baidu.tbadk.mvc.b.a Jz = bVar.Jz();
        switch (Jy) {
            case 0:
                if (Jz instanceof PluginConfigWrapper) {
                    PluginConfigWrapper pluginConfigWrapper = (PluginConfigWrapper) Jz;
                    PluginPackageManager.lN().bF(pluginConfigWrapper.package_name);
                    pluginConfigWrapper.setDownLoadStatus(1);
                    this.gig.F(pluginConfigWrapper);
                    return true;
                }
                break;
            case 1:
                if (Jz instanceof PluginConfigWrapper) {
                    PluginConfigWrapper pluginConfigWrapper2 = (PluginConfigWrapper) Jz;
                    PluginPackageManager.lN().bG(pluginConfigWrapper2.package_name);
                    pluginConfigWrapper2.setDownLoadStatus(2);
                    this.gig.F(pluginConfigWrapper2);
                    return true;
                }
                break;
            case 2:
                if (Jz instanceof PluginConfigWrapper) {
                    a((PluginConfigWrapper) Jz);
                    return true;
                }
                break;
        }
        return false;
    }

    @Override // com.baidu.tbadk.mvc.c.a
    public boolean Jx() {
        return false;
    }
}
