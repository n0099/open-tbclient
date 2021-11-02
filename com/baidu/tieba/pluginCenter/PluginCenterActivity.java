package com.baidu.tieba.pluginCenter;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import b.a.e.e.p.k;
import b.a.e.e.p.l;
import b.a.q0.s.s.a;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.plugin.packageManager.PluginPackageManager;
import com.baidu.adp.plugin.packageManager.pluginFileDownload.BdFileDownloadData;
import com.baidu.adp.plugin.packageManager.pluginServerConfig.PluginNetConfigInfos;
import com.baidu.adp.plugin.packageManager.pluginSettings.PluginSetting;
import com.baidu.adp.plugin.util.Util;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.util.AdIconUtil;
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
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
@SuppressLint({"ResourceAsColor"})
/* loaded from: classes9.dex */
public class PluginCenterActivity extends BaseActivity<PluginCenterActivity> implements AdapterView.OnItemClickListener, b.a.q0.k0.c.a {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int ITEM_TYPE_DESC = 1;
    public static final int ITEM_TYPE_FUNCTION = 0;
    public transient /* synthetic */ FieldHolder $fh;
    public b.a.e.h.j.d mDownLoadAndInstallCallback;
    public ViewEventCenter mEventCenter;
    public int mFromType;
    public BdListView mListView;
    public NavigationBar mNavigationBar;
    public NoDataView mNoDataView;
    public b.a.q0.k0.f.b<Object, b.a.q0.k0.d.b, b.a.q0.k0.f.a<Object, b.a.q0.k0.d.b>> mPluginCenterAdapter;
    public View mRootView;
    public List<Object> mShowList;

    /* loaded from: classes9.dex */
    public class a extends b.a.q0.k0.f.b<Object, b.a.q0.k0.d.b, b.a.q0.k0.f.a<Object, b.a.q0.k0.d.b>> {
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

        @Override // b.a.q0.k0.f.b
        public int o(int i2) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeI = interceptable.invokeI(1048576, this, i2)) == null) ? getItem(i2) instanceof String ? 1 : 0 : invokeI.intValue;
        }
    }

    /* loaded from: classes9.dex */
    public class b implements a.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ PluginConfigWrapper f53332e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ PluginCenterActivity f53333f;

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
            this.f53333f = pluginCenterActivity;
            this.f53332e = pluginConfigWrapper;
        }

        @Override // b.a.q0.s.s.a.e
        public void onClick(b.a.q0.s.s.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
                if (l.D()) {
                    PluginPackageManager.O().x0(this.f53332e, this.f53333f.mDownLoadAndInstallCallback);
                    this.f53332e.setDownLoadPercent(0);
                    this.f53332e.setDownLoadStatus(3);
                    this.f53333f.mPluginCenterAdapter.n(this.f53332e);
                } else {
                    this.f53333f.showToast(R.string.neterror);
                }
                aVar.dismiss();
            }
        }
    }

    /* loaded from: classes9.dex */
    public class c implements a.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ PluginCenterActivity f53334e;

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
            this.f53334e = pluginCenterActivity;
        }

        @Override // b.a.q0.s.s.a.e
        public void onClick(b.a.q0.s.s.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
                aVar.dismiss();
            }
        }
    }

    /* loaded from: classes9.dex */
    public class d implements b.a.e.h.j.d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ PluginCenterActivity f53335a;

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
            this.f53335a = pluginCenterActivity;
        }

        @Override // b.a.e.h.j.d
        public void a(BdFileDownloadData bdFileDownloadData) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, bdFileDownloadData) == null) {
            }
        }

        @Override // b.a.e.h.j.d
        public void b(BdFileDownloadData bdFileDownloadData) {
            PluginConfigWrapper findData;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bdFileDownloadData) == null) || bdFileDownloadData == null || bdFileDownloadData.getId() == null || (findData = this.f53335a.findData(bdFileDownloadData.getId())) == null) {
                return;
            }
            this.f53335a.showToast(R.string.download_fail_tip);
            findData.setDownLoadStatus(0);
            this.f53335a.mPluginCenterAdapter.n(findData);
        }

        @Override // b.a.e.h.j.d
        public void c(BdFileDownloadData bdFileDownloadData, int i2, String str) {
            PluginConfigWrapper findData;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLIL(Constants.METHOD_SEND_USER_MSG, this, bdFileDownloadData, i2, str) == null) || bdFileDownloadData == null || bdFileDownloadData.getId() == null || (findData = this.f53335a.findData(bdFileDownloadData.getId())) == null) {
                return;
            }
            if (i2 == 0) {
                this.f53335a.showToast(R.string.plugin_installation_finished);
                this.f53335a.mEventCenter.dispatchMvcEvent(new b.a.q0.k0.c.b(1, findData, null, null));
                return;
            }
            PluginCenterActivity pluginCenterActivity = this.f53335a;
            pluginCenterActivity.showToast(this.f53335a.getPageContext().getString(R.string.plugin_installation_failed) + str);
            this.f53335a.resetPluginList();
        }

        @Override // b.a.e.h.j.d
        public void d(BdFileDownloadData bdFileDownloadData) {
            PluginConfigWrapper findData;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048579, this, bdFileDownloadData) == null) || bdFileDownloadData == null || bdFileDownloadData.getId() == null || bdFileDownloadData.getStatus() == 2 || (findData = this.f53335a.findData(bdFileDownloadData.getId())) == null) {
                return;
            }
            findData.setDownLoadPercent((int) ((bdFileDownloadData.getLength() * 100) / bdFileDownloadData.getSize()));
            findData.setDownLoadStatus(3);
            this.f53335a.mPluginCenterAdapter.n(findData);
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
        if (interceptable == null || (invokeL = interceptable.invokeL(AdIconUtil.BAIDU_LOGO_ID, this, list)) == null) {
            ArrayList arrayList = new ArrayList();
            ArrayList arrayList2 = new ArrayList();
            ArrayList arrayList3 = new ArrayList();
            if (list != null && list.size() != 0) {
                for (PluginNetConfigInfos.PluginConfig pluginConfig : list) {
                    if (pluginConfig != null && !TextUtils.isEmpty(pluginConfig.display_name) && pluginConfig.forbidden != 1 && ((h2 = b.a.e.h.j.g.d.k().h(pluginConfig.package_name)) == null || (newest = pluginConfig.newest) == null || h2.versionCode <= newest.version_code)) {
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
            if (pluginConfig == null || (h2 = b.a.e.h.j.g.d.k().h(pluginConfig.package_name)) == null) {
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
        return invokeL.intValue;
    }

    private void initListView() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65545, this) == null) {
            this.mRootView = findViewById(R.id.parent);
            this.mListView = (BdListView) findViewById(R.id.list);
            NoDataView a2 = NoDataViewFactory.a(getPageContext().getPageActivity(), findViewById(R.id.list_layout), NoDataViewFactory.d.b(NoDataViewFactory.ImgType.NODATA, l.g(getActivity(), R.dimen.ds220)), NoDataViewFactory.e.a(R.string.plugin_no_plugins), null);
            this.mNoDataView = a2;
            this.mListView.setEmptyView(a2);
            a aVar = new a(this, getPageContext(), new Class[]{b.a.r0.r2.a.a.class, b.a.r0.r2.a.b.class}, new int[]{R.layout.plugin_center_list_function_item, R.layout.plugin_center_list_desc_item}, this.mEventCenter);
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
            NavigationBar navigationBar = (NavigationBar) findViewById(R.id.navigation_bar);
            this.mNavigationBar = navigationBar;
            navigationBar.setCenterTextTitle(getString(R.string.plugin_center));
            this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void resetPluginList() {
        PluginNetConfigInfos d2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65547, this) == null) || (d2 = b.a.e.h.j.f.d.c().d()) == null || d2.getConfigs() == null || d2.getConfigs().size() <= 0) {
            return;
        }
        List<Object> dealPluginConfigList = dealPluginConfigList(d2.getConfigs());
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
            format = String.format(TbadkApplication.getInst().getString(R.string.plugin_update_size_prompt), Float.valueOf(pluginConfigWrapper.newest.size / 1048576.0f));
        } else {
            format = String.format(TbadkApplication.getInst().getString(R.string.plugin_download_size_prompt), Float.valueOf(pluginConfigWrapper.newest.size / 1048576.0f));
        }
        if (z) {
            string = TbadkCoreApplication.getInst().getString(R.string.download_update);
        } else {
            string = TbadkCoreApplication.getInst().getString(R.string.download);
        }
        b.a.q0.s.s.a aVar = new b.a.q0.s.s.a(getActivity());
        aVar.setMessage(format);
        aVar.setPositiveButton(string, new b(this, pluginConfigWrapper));
        aVar.setNegativeButton(TbadkCoreApplication.getInst().getString(R.string.cancel), new c(this));
        aVar.create(getPageContext());
        aVar.show();
    }

    @Override // b.a.q0.k0.c.a
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
            setContentView(R.layout.plugin_center_activity);
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
            PluginPackageManager.O().u0(null);
        }
    }

    @Override // b.a.q0.k0.c.a
    public boolean onEventDispatch(b.a.q0.k0.c.b bVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, bVar)) == null) {
            int b2 = bVar.b();
            b.a.q0.k0.b.a a2 = bVar.a();
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
        return invokeL.booleanValue;
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i2, long j) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(1048581, this, new Object[]{adapterView, view, Integer.valueOf(i2), Long.valueOf(j)}) == null) && (this.mPluginCenterAdapter.getItem(i2) instanceof PluginConfigWrapper)) {
            sendMessage(new CustomMessage(2002001, new PluginDetailActivityConfig(getPageContext().getPageActivity(), ((PluginConfigWrapper) this.mPluginCenterAdapter.getItem(i2)).package_name)));
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            super.onResume();
            PluginPackageManager.O().u0(this.mDownLoadAndInstallCallback);
            PluginNetConfigInfos d2 = b.a.e.h.j.f.d.c().d();
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
}
