package com.baidu.tieba.pluginCenter;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.plugin.packageManager.PluginPackageManager;
import com.baidu.adp.plugin.packageManager.pluginFileDownload.BdFileDownloadData;
import com.baidu.adp.plugin.packageManager.pluginServerConfig.PluginNetConfigInfos;
import com.baidu.adp.plugin.packageManager.pluginSettings.PluginSetting;
import com.baidu.adp.plugin.util.Util;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.PluginDetailActivityConfig;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NoDataView;
import com.baidu.tbadk.core.view.NoDataViewFactory;
import com.baidu.tbadk.mvc.core.ViewEventCenter;
import com.baidu.tieba.R;
import d.a.c.e.p.k;
import d.a.c.e.p.l;
import d.a.n0.r.s.a;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
@SuppressLint({"ResourceAsColor"})
/* loaded from: classes5.dex */
public class PluginCenterActivity extends BaseActivity<PluginCenterActivity> implements AdapterView.OnItemClickListener, d.a.n0.g0.c.a {
    public static final int ITEM_TYPE_DESC = 1;
    public static final int ITEM_TYPE_FUNCTION = 0;
    public d.a.c.h.j.d mDownLoadAndInstallCallback = new d();
    public ViewEventCenter mEventCenter;
    public int mFromType;
    public BdListView mListView;
    public NavigationBar mNavigationBar;
    public NoDataView mNoDataView;
    public d.a.n0.g0.f.b<Object, d.a.n0.g0.d.b, d.a.n0.g0.f.a<Object, d.a.n0.g0.d.b>> mPluginCenterAdapter;
    public View mRootView;
    public List<Object> mShowList;

    /* loaded from: classes5.dex */
    public class a extends d.a.n0.g0.f.b<Object, d.a.n0.g0.d.b, d.a.n0.g0.f.a<Object, d.a.n0.g0.d.b>> {
        public a(TbPageContext tbPageContext, Class[] clsArr, int[] iArr, ViewEventCenter viewEventCenter) {
            super(tbPageContext, clsArr, iArr, viewEventCenter);
        }

        @Override // d.a.n0.g0.f.b
        public int o(int i2) {
            return getItem(i2) instanceof String ? 1 : 0;
        }
    }

    /* loaded from: classes5.dex */
    public class b implements a.e {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ PluginConfigWrapper f20139e;

        public b(PluginConfigWrapper pluginConfigWrapper) {
            this.f20139e = pluginConfigWrapper;
        }

        @Override // d.a.n0.r.s.a.e
        public void onClick(d.a.n0.r.s.a aVar) {
            if (l.D()) {
                PluginPackageManager.O().x0(this.f20139e, PluginCenterActivity.this.mDownLoadAndInstallCallback);
                this.f20139e.setDownLoadPercent(0);
                this.f20139e.setDownLoadStatus(3);
                PluginCenterActivity.this.mPluginCenterAdapter.n(this.f20139e);
            } else {
                PluginCenterActivity.this.showToast(R.string.neterror);
            }
            aVar.dismiss();
        }
    }

    /* loaded from: classes5.dex */
    public class c implements a.e {
        public c() {
        }

        @Override // d.a.n0.r.s.a.e
        public void onClick(d.a.n0.r.s.a aVar) {
            aVar.dismiss();
        }
    }

    /* loaded from: classes5.dex */
    public class d implements d.a.c.h.j.d {
        public d() {
        }

        @Override // d.a.c.h.j.d
        public void a(BdFileDownloadData bdFileDownloadData) {
        }

        @Override // d.a.c.h.j.d
        public void b(BdFileDownloadData bdFileDownloadData) {
            PluginConfigWrapper findData;
            if (bdFileDownloadData == null || bdFileDownloadData.getId() == null || (findData = PluginCenterActivity.this.findData(bdFileDownloadData.getId())) == null) {
                return;
            }
            PluginCenterActivity.this.showToast(R.string.download_fail_tip);
            findData.setDownLoadStatus(0);
            PluginCenterActivity.this.mPluginCenterAdapter.n(findData);
        }

        @Override // d.a.c.h.j.d
        public void c(BdFileDownloadData bdFileDownloadData, int i2, String str) {
            PluginConfigWrapper findData;
            if (bdFileDownloadData == null || bdFileDownloadData.getId() == null || (findData = PluginCenterActivity.this.findData(bdFileDownloadData.getId())) == null) {
                return;
            }
            if (i2 == 0) {
                PluginCenterActivity.this.showToast(R.string.plugin_installation_finished);
                PluginCenterActivity.this.mEventCenter.dispatchMvcEvent(new d.a.n0.g0.c.b(1, findData, null, null));
                return;
            }
            PluginCenterActivity pluginCenterActivity = PluginCenterActivity.this;
            pluginCenterActivity.showToast(PluginCenterActivity.this.getPageContext().getString(R.string.plugin_installation_failed) + str);
            PluginCenterActivity.this.resetPluginList();
        }

        @Override // d.a.c.h.j.d
        public void d(BdFileDownloadData bdFileDownloadData) {
            PluginConfigWrapper findData;
            if (bdFileDownloadData == null || bdFileDownloadData.getId() == null || bdFileDownloadData.getStatus() == 2 || (findData = PluginCenterActivity.this.findData(bdFileDownloadData.getId())) == null) {
                return;
            }
            findData.setDownLoadPercent((int) ((bdFileDownloadData.getLength() * 100) / bdFileDownloadData.getSize()));
            findData.setDownLoadStatus(3);
            PluginCenterActivity.this.mPluginCenterAdapter.n(findData);
        }
    }

    private List<Object> dealPluginConfigList(List<PluginNetConfigInfos.PluginConfig> list) {
        PluginSetting h2;
        PluginNetConfigInfos.Newest newest;
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        ArrayList arrayList3 = new ArrayList();
        if (list != null && list.size() != 0) {
            for (PluginNetConfigInfos.PluginConfig pluginConfig : list) {
                if (pluginConfig != null && !TextUtils.isEmpty(pluginConfig.display_name) && pluginConfig.forbidden != 1 && ((h2 = d.a.c.h.j.g.d.k().h(pluginConfig.package_name)) == null || (newest = pluginConfig.newest) == null || h2.versionCode <= newest.version_code)) {
                    if (this.mFromType == 0) {
                        if (PluginPackageManager.O().y(pluginConfig.package_name) && !PluginPackageManager.O().Z(pluginConfig.package_name)) {
                            arrayList3.add(new PluginConfigWrapper(pluginConfig));
                        } else {
                            PluginConfigWrapper pluginConfigWrapper = new PluginConfigWrapper(pluginConfig);
                            pluginConfigWrapper.setDownLoadStatus(PluginPackageManager.O().Z(pluginConfigWrapper.package_name) ? 3 : 0);
                            pluginConfigWrapper.setDownLoadPercent(getDownloadPercent(pluginConfig));
                            arrayList2.add(pluginConfigWrapper);
                        }
                    }
                }
            }
            if (!ListUtils.isEmpty(arrayList3)) {
                arrayList.add("已安装");
                arrayList.addAll(arrayList3);
            }
            if (!ListUtils.isEmpty(arrayList2)) {
                arrayList.add("未安装");
                arrayList.addAll(arrayList2);
            }
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public PluginConfigWrapper findData(String str) {
        List<Object> d2;
        if (str != null && (d2 = this.mPluginCenterAdapter.d()) != null && !d2.isEmpty()) {
            for (Object obj : d2) {
                if (obj instanceof PluginConfigWrapper) {
                    PluginConfigWrapper pluginConfigWrapper = (PluginConfigWrapper) obj;
                    if (str.equals(pluginConfigWrapper.package_name)) {
                        return pluginConfigWrapper;
                    }
                }
            }
        }
        return null;
    }

    private int getDownloadPercent(PluginNetConfigInfos.PluginConfig pluginConfig) {
        PluginSetting h2;
        if (pluginConfig == null || (h2 = d.a.c.h.j.g.d.k().h(pluginConfig.package_name)) == null) {
            return 0;
        }
        String l = Util.l(h2);
        if (k.isEmpty(l)) {
            return 0;
        }
        try {
            File file = new File(l + ".tmp");
            if (file.exists() && h2.size > 0) {
                return (int) (((file.length() * 1.0d) / h2.size) * 100.0d);
            }
        } catch (Exception e2) {
            BdLog.e(e2);
        }
        return 0;
    }

    private void initListView() {
        this.mRootView = findViewById(R.id.parent);
        this.mListView = (BdListView) findViewById(R.id.list);
        NoDataView a2 = NoDataViewFactory.a(getPageContext().getPageActivity(), findViewById(R.id.list_layout), NoDataViewFactory.d.b(NoDataViewFactory.ImgType.NODATA, l.g(getActivity(), R.dimen.ds220)), NoDataViewFactory.e.a(R.string.plugin_no_plugins), null);
        this.mNoDataView = a2;
        this.mListView.setEmptyView(a2);
        a aVar = new a(getPageContext(), new Class[]{d.a.o0.l2.a.a.class, d.a.o0.l2.a.b.class}, new int[]{R.layout.plugin_center_list_function_item, R.layout.plugin_center_list_desc_item}, this.mEventCenter);
        this.mPluginCenterAdapter = aVar;
        this.mListView.setAdapter((ListAdapter) aVar);
        this.mListView.setOnItemClickListener(this);
    }

    private void initNavigationBar() {
        if (getIntent() != null) {
            this.mFromType = getIntent().getIntExtra("key_from_type", 0);
        }
        NavigationBar navigationBar = (NavigationBar) findViewById(R.id.navigation_bar);
        this.mNavigationBar = navigationBar;
        navigationBar.setCenterTextTitle(getString(R.string.plugin_center));
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void resetPluginList() {
        PluginNetConfigInfos d2 = d.a.c.h.j.f.d.c().d();
        if (d2 == null || d2.getConfigs() == null || d2.getConfigs().size() <= 0) {
            return;
        }
        List<Object> dealPluginConfigList = dealPluginConfigList(d2.getConfigs());
        this.mShowList = dealPluginConfigList;
        this.mPluginCenterAdapter.k(dealPluginConfigList);
    }

    private void showDownLoadConfirmDialog(PluginConfigWrapper pluginConfigWrapper) {
        String format;
        String string;
        if (pluginConfigWrapper == null || pluginConfigWrapper.newest == null) {
            return;
        }
        boolean z = pluginConfigWrapper.getDownLoadStatus() == 4;
        if (z) {
            format = String.format(TbadkApplication.getInst().getString(R.string.plugin_update_size_prompt), Float.valueOf(pluginConfigWrapper.newest.size / 1048576.0f));
        } else {
            format = String.format(TbadkApplication.getInst().getString(R.string.plugin_download_size_prompt), Float.valueOf(pluginConfigWrapper.newest.size / 1048576.0f));
        }
        if (z) {
            string = TbadkCoreApplication.getInst().getString(R.string.download_update);
        } else {
            string = TbadkCoreApplication.getInst().getString(R.string.download);
        }
        d.a.n0.r.s.a aVar = new d.a.n0.r.s.a(getActivity());
        aVar.setMessage(format);
        aVar.setPositiveButton(string, new b(pluginConfigWrapper));
        aVar.setNegativeButton(TbadkCoreApplication.getInst().getString(R.string.cancel), new c());
        aVar.create(getPageContext());
        aVar.show();
    }

    @Override // d.a.n0.g0.c.a
    public boolean isEventMustSelf() {
        return false;
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i2) {
        super.onChangeSkinType(i2);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i2);
        this.mPluginCenterAdapter.notifyDataSetChanged();
        getLayoutMode().j(findViewById(16908290));
        NoDataView noDataView = this.mNoDataView;
        if (noDataView != null) {
            noDataView.f(getPageContext(), i2);
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.plugin_center_activity);
        ViewEventCenter viewEventCenter = new ViewEventCenter();
        this.mEventCenter = viewEventCenter;
        viewEventCenter.addEventDelegate(this);
        initNavigationBar();
        initListView();
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        PluginPackageManager.O().u0(null);
    }

    @Override // d.a.n0.g0.c.a
    public boolean onEventDispatch(d.a.n0.g0.c.b bVar) {
        int b2 = bVar.b();
        d.a.n0.g0.b.a a2 = bVar.a();
        if (b2 == 1) {
            if (a2 instanceof PluginConfigWrapper) {
                PluginPackageManager.O().z0(((PluginConfigWrapper) a2).package_name);
                resetPluginList();
                return true;
            }
            return false;
        } else if (b2 != 2) {
            if (b2 == 3 && (a2 instanceof PluginConfigWrapper)) {
                sendMessage(new CustomMessage(2002001, new PluginDetailActivityConfig(getPageContext().getPageActivity(), ((PluginConfigWrapper) a2).package_name)));
                return false;
            }
            return false;
        } else if (a2 instanceof PluginConfigWrapper) {
            showDownLoadConfirmDialog((PluginConfigWrapper) a2);
            return true;
        } else {
            return false;
        }
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i2, long j) {
        if (this.mPluginCenterAdapter.getItem(i2) instanceof PluginConfigWrapper) {
            sendMessage(new CustomMessage(2002001, new PluginDetailActivityConfig(getPageContext().getPageActivity(), ((PluginConfigWrapper) this.mPluginCenterAdapter.getItem(i2)).package_name)));
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        PluginPackageManager.O().u0(this.mDownLoadAndInstallCallback);
        PluginNetConfigInfos d2 = d.a.c.h.j.f.d.c().d();
        if (d2 != null && d2.getConfigs() != null && d2.getConfigs().size() > 0) {
            List<Object> dealPluginConfigList = dealPluginConfigList(d2.getConfigs());
            this.mShowList = dealPluginConfigList;
            this.mPluginCenterAdapter.k(dealPluginConfigList);
            PluginPackageManager.O().w0();
        }
        List<Object> list = this.mShowList;
        if (list != null && !list.isEmpty()) {
            SkinManager.setBackgroundColor(this.mRootView, R.color.CAM_X0204);
        } else {
            SkinManager.setBackgroundColor(this.mRootView, R.color.CAM_X0201);
        }
    }
}
