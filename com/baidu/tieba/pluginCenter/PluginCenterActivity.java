package com.baidu.tieba.pluginCenter;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import c.a.d.f.p.l;
import c.a.d.f.p.m;
import c.a.r0.s.t.a;
import c.a.s0.b3.e;
import c.a.s0.b3.f;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.plugin.packageManager.PluginPackageManager;
import com.baidu.adp.plugin.packageManager.pluginFileDownload.BdFileDownloadData;
import com.baidu.adp.plugin.packageManager.pluginServerConfig.PluginNetConfigInfos;
import com.baidu.adp.plugin.packageManager.pluginSettings.PluginSetting;
import com.baidu.adp.plugin.util.Util;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.android.imsdk.internal.Constants;
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
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
@SuppressLint({"ResourceAsColor"})
/* loaded from: classes12.dex */
public class PluginCenterActivity extends BaseActivity<PluginCenterActivity> implements AdapterView.OnItemClickListener, c.a.r0.l0.c.a {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int ITEM_TYPE_DESC = 1;
    public static final int ITEM_TYPE_FUNCTION = 0;
    public transient /* synthetic */ FieldHolder $fh;
    public c.a.d.i.j.c mDownLoadAndInstallCallback;
    public ViewEventCenter mEventCenter;
    public int mFromType;
    public BdListView mListView;
    public NavigationBar mNavigationBar;
    public NoDataView mNoDataView;
    public c.a.r0.l0.f.b<Object, c.a.r0.l0.d.b, c.a.r0.l0.f.a<Object, c.a.r0.l0.d.b>> mPluginCenterAdapter;
    public View mRootView;
    public List<Object> mShowList;

    /* loaded from: classes12.dex */
    public class a extends c.a.r0.l0.f.b<Object, c.a.r0.l0.d.b, c.a.r0.l0.f.a<Object, c.a.r0.l0.d.b>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PluginCenterActivity t;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(PluginCenterActivity pluginCenterActivity, TbPageContext tbPageContext, Class[] clsArr, int[] iArr, ViewEventCenter viewEventCenter) {
            super(tbPageContext, clsArr, iArr, viewEventCenter);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pluginCenterActivity, tbPageContext, clsArr, iArr, viewEventCenter};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    super((TbPageContext) objArr2[0], (Class[]) objArr2[1], (int[]) objArr2[2], (ViewEventCenter) objArr2[3]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.t = pluginCenterActivity;
        }

        @Override // c.a.r0.l0.f.b
        public int o(int i2) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeI = interceptable.invokeI(1048576, this, i2)) == null) ? getItem(i2) instanceof String ? 1 : 0 : invokeI.intValue;
        }
    }

    /* loaded from: classes12.dex */
    public class b implements a.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ PluginConfigWrapper f48990e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ PluginCenterActivity f48991f;

        public b(PluginCenterActivity pluginCenterActivity, PluginConfigWrapper pluginConfigWrapper) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pluginCenterActivity, pluginConfigWrapper};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f48991f = pluginCenterActivity;
            this.f48990e = pluginConfigWrapper;
        }

        @Override // c.a.r0.s.t.a.e
        public void onClick(c.a.r0.s.t.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
                if (m.C()) {
                    PluginPackageManager.u().K(this.f48990e, this.f48991f.mDownLoadAndInstallCallback);
                    this.f48990e.setDownLoadPercent(0);
                    this.f48990e.setDownLoadStatus(3);
                    this.f48991f.mPluginCenterAdapter.n(this.f48990e);
                } else {
                    this.f48991f.showToast(f.neterror);
                }
                aVar.dismiss();
            }
        }
    }

    /* loaded from: classes12.dex */
    public class c implements a.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ PluginCenterActivity f48992e;

        public c(PluginCenterActivity pluginCenterActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pluginCenterActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f48992e = pluginCenterActivity;
        }

        @Override // c.a.r0.s.t.a.e
        public void onClick(c.a.r0.s.t.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
                aVar.dismiss();
            }
        }
    }

    /* loaded from: classes12.dex */
    public class d implements c.a.d.i.j.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PluginCenterActivity a;

        public d(PluginCenterActivity pluginCenterActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pluginCenterActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = pluginCenterActivity;
        }

        @Override // c.a.d.i.j.c
        public void a(BdFileDownloadData bdFileDownloadData) {
            PluginConfigWrapper findData;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, bdFileDownloadData) == null) || bdFileDownloadData == null || bdFileDownloadData.getId() == null || (findData = this.a.findData(bdFileDownloadData.getId())) == null) {
                return;
            }
            this.a.showToast(f.download_fail_tip);
            findData.setDownLoadStatus(0);
            this.a.mPluginCenterAdapter.n(findData);
        }
    }

    public PluginCenterActivity() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.mDownLoadAndInstallCallback = new d(this);
    }

    private List<Object> dealPluginConfigList(List<PluginNetConfigInfos.PluginConfig> list) {
        InterceptResult invokeL;
        PluginSetting h2;
        PluginNetConfigInfos.Newest newest;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65542, this, list)) == null) {
            ArrayList arrayList = new ArrayList();
            ArrayList arrayList2 = new ArrayList();
            ArrayList arrayList3 = new ArrayList();
            if (list != null && list.size() != 0) {
                for (PluginNetConfigInfos.PluginConfig pluginConfig : list) {
                    if (pluginConfig != null && !TextUtils.isEmpty(pluginConfig.display_name) && pluginConfig.forbidden != 1 && ((h2 = c.a.d.i.j.f.c.j().h(pluginConfig.package_name)) == null || (newest = pluginConfig.newest) == null || h2.versionCode <= newest.version_code)) {
                        if (this.mFromType == 0) {
                            if (PluginPackageManager.u().l(pluginConfig.package_name) && !PluginPackageManager.u().y(pluginConfig.package_name)) {
                                arrayList3.add(new PluginConfigWrapper(pluginConfig));
                            } else {
                                PluginConfigWrapper pluginConfigWrapper = new PluginConfigWrapper(pluginConfig);
                                pluginConfigWrapper.setDownLoadStatus(PluginPackageManager.u().y(pluginConfigWrapper.package_name) ? 3 : 0);
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
        return (List) invokeL.objValue;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public PluginConfigWrapper findData(String str) {
        InterceptResult invokeL;
        List<Object> d2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65543, this, str)) == null) {
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
        return (PluginConfigWrapper) invokeL.objValue;
    }

    private int getDownloadPercent(PluginNetConfigInfos.PluginConfig pluginConfig) {
        InterceptResult invokeL;
        PluginSetting h2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65544, this, pluginConfig)) == null) {
            if (pluginConfig == null || (h2 = c.a.d.i.j.f.c.j().h(pluginConfig.package_name)) == null) {
                return 0;
            }
            String h3 = Util.h(h2);
            if (l.isEmpty(h3)) {
                return 0;
            }
            try {
                File file = new File(h3 + ".tmp");
                if (file.exists() && h2.size > 0) {
                    return (int) (((file.length() * 1.0d) / h2.size) * 100.0d);
                }
            } catch (Exception e2) {
                BdLog.e(e2);
            }
            return 0;
        }
        return invokeL.intValue;
    }

    private void initListView() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65545, this) == null) {
            this.mRootView = findViewById(c.a.s0.b3.d.parent);
            this.mListView = (BdListView) findViewById(c.a.s0.b3.d.list);
            NoDataView a2 = NoDataViewFactory.a(getPageContext().getPageActivity(), findViewById(c.a.s0.b3.d.list_layout), NoDataViewFactory.d.b(NoDataViewFactory.ImgType.NODATA, m.f(getActivity(), c.a.s0.b3.b.ds220)), NoDataViewFactory.e.a(f.plugin_no_plugins), null);
            this.mNoDataView = a2;
            this.mListView.setEmptyView(a2);
            a aVar = new a(this, getPageContext(), new Class[]{c.a.s0.a3.a.a.class, c.a.s0.a3.a.b.class}, new int[]{e.plugin_center_list_function_item, e.plugin_center_list_desc_item}, this.mEventCenter);
            this.mPluginCenterAdapter = aVar;
            this.mListView.setAdapter((ListAdapter) aVar);
            this.mListView.setOnItemClickListener(this);
        }
    }

    private void initNavigationBar() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65546, this) == null) {
            if (getIntent() != null) {
                this.mFromType = getIntent().getIntExtra("key_from_type", 0);
            }
            NavigationBar navigationBar = (NavigationBar) findViewById(c.a.s0.b3.d.navigation_bar);
            this.mNavigationBar = navigationBar;
            navigationBar.setCenterTextTitle(getString(f.plugin_center));
            this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void resetPluginList() {
        PluginNetConfigInfos b2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65547, this) == null) || (b2 = c.a.d.i.j.e.d.a().b()) == null || b2.getConfigs() == null || b2.getConfigs().size() <= 0) {
            return;
        }
        List<Object> dealPluginConfigList = dealPluginConfigList(b2.getConfigs());
        this.mShowList = dealPluginConfigList;
        this.mPluginCenterAdapter.k(dealPluginConfigList);
    }

    private void showDownLoadConfirmDialog(PluginConfigWrapper pluginConfigWrapper) {
        String format;
        String string;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65548, this, pluginConfigWrapper) == null) || pluginConfigWrapper == null || pluginConfigWrapper.newest == null) {
            return;
        }
        boolean z = pluginConfigWrapper.getDownLoadStatus() == 4;
        if (z) {
            format = String.format(TbadkApplication.getInst().getString(f.plugin_update_size_prompt), Float.valueOf(pluginConfigWrapper.newest.size / 1048576.0f));
        } else {
            format = String.format(TbadkApplication.getInst().getString(f.plugin_download_size_prompt), Float.valueOf(pluginConfigWrapper.newest.size / 1048576.0f));
        }
        if (z) {
            string = TbadkCoreApplication.getInst().getString(f.download_update);
        } else {
            string = TbadkCoreApplication.getInst().getString(f.download);
        }
        c.a.r0.s.t.a aVar = new c.a.r0.s.t.a(getActivity());
        aVar.setMessage(format);
        aVar.setPositiveButton(string, new b(this, pluginConfigWrapper));
        aVar.setNegativeButton(TbadkCoreApplication.getInst().getString(f.cancel), new c(this));
        aVar.create(getPageContext());
        aVar.show();
    }

    @Override // c.a.r0.l0.c.a
    public boolean isEventMustSelf() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2) == null) {
            super.onChangeSkinType(i2);
            this.mNavigationBar.onChangeSkinType(getPageContext(), i2);
            this.mPluginCenterAdapter.notifyDataSetChanged();
            getLayoutMode().j(findViewById(16908290));
            NoDataView noDataView = this.mNoDataView;
            if (noDataView != null) {
                noDataView.onChangeSkinType(getPageContext(), i2);
            }
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, bundle) == null) {
            super.onCreate(bundle);
            setContentView(e.plugin_center_activity);
            ViewEventCenter viewEventCenter = new ViewEventCenter();
            this.mEventCenter = viewEventCenter;
            viewEventCenter.addEventDelegate(this);
            initNavigationBar();
            initListView();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            super.onDestroy();
            PluginPackageManager.u().I(null);
        }
    }

    @Override // c.a.r0.l0.c.a
    public boolean onEventDispatch(c.a.r0.l0.c.b bVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, bVar)) == null) {
            int b2 = bVar.b();
            c.a.r0.l0.b.a a2 = bVar.a();
            if (b2 == 1) {
                if (a2 instanceof PluginConfigWrapper) {
                    PluginPackageManager.u().M(((PluginConfigWrapper) a2).package_name);
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
        return invokeL.booleanValue;
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i2, long j2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(1048581, this, new Object[]{adapterView, view, Integer.valueOf(i2), Long.valueOf(j2)}) == null) && (this.mPluginCenterAdapter.getItem(i2) instanceof PluginConfigWrapper)) {
            sendMessage(new CustomMessage(2002001, new PluginDetailActivityConfig(getPageContext().getPageActivity(), ((PluginConfigWrapper) this.mPluginCenterAdapter.getItem(i2)).package_name)));
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            super.onResume();
            PluginPackageManager.u().I(this.mDownLoadAndInstallCallback);
            PluginNetConfigInfos b2 = c.a.d.i.j.e.d.a().b();
            if (b2 != null && b2.getConfigs() != null && b2.getConfigs().size() > 0) {
                List<Object> dealPluginConfigList = dealPluginConfigList(b2.getConfigs());
                this.mShowList = dealPluginConfigList;
                this.mPluginCenterAdapter.k(dealPluginConfigList);
                PluginPackageManager.u().J();
            }
            List<Object> list = this.mShowList;
            if (list != null && !list.isEmpty()) {
                SkinManager.setBackgroundColor(this.mRootView, c.a.s0.b3.a.CAM_X0204);
            } else {
                SkinManager.setBackgroundColor(this.mRootView, c.a.s0.b3.a.CAM_X0201);
            }
        }
    }
}
