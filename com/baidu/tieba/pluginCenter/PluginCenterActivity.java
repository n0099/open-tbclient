package com.baidu.tieba.pluginCenter;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import c.a.d.f.p.m;
import c.a.d.f.p.n;
import c.a.o0.r.t.a;
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
/* loaded from: classes5.dex */
public class PluginCenterActivity extends BaseActivity<PluginCenterActivity> implements AdapterView.OnItemClickListener, c.a.o0.k0.c.a {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int ITEM_TYPE_DESC = 1;
    public static final int ITEM_TYPE_FUNCTION = 0;
    public transient /* synthetic */ FieldHolder $fh;
    public c.a.d.j.j.c mDownLoadAndInstallCallback;
    public ViewEventCenter mEventCenter;
    public int mFromType;
    public BdListView mListView;
    public NavigationBar mNavigationBar;
    public NoDataView mNoDataView;
    public c.a.o0.k0.f.b<Object, c.a.o0.k0.d.b, c.a.o0.k0.f.a<Object, c.a.o0.k0.d.b>> mPluginCenterAdapter;
    public View mRootView;
    public List<Object> mShowList;

    /* loaded from: classes5.dex */
    public class a extends c.a.o0.k0.f.b<Object, c.a.o0.k0.d.b, c.a.o0.k0.f.a<Object, c.a.o0.k0.d.b>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PluginCenterActivity p;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(PluginCenterActivity pluginCenterActivity, TbPageContext tbPageContext, Class[] clsArr, int[] iArr, ViewEventCenter viewEventCenter) {
            super(tbPageContext, clsArr, iArr, viewEventCenter);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pluginCenterActivity, tbPageContext, clsArr, iArr, viewEventCenter};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    super((TbPageContext) objArr2[0], (Class[]) objArr2[1], (int[]) objArr2[2], (ViewEventCenter) objArr2[3]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.p = pluginCenterActivity;
        }

        @Override // c.a.o0.k0.f.b
        public int o(int i) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeI = interceptable.invokeI(1048576, this, i)) == null) ? getItem(i) instanceof String ? 1 : 0 : invokeI.intValue;
        }
    }

    /* loaded from: classes5.dex */
    public class b implements a.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PluginConfigWrapper a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ PluginCenterActivity f35596b;

        public b(PluginCenterActivity pluginCenterActivity, PluginConfigWrapper pluginConfigWrapper) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pluginCenterActivity, pluginConfigWrapper};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f35596b = pluginCenterActivity;
            this.a = pluginConfigWrapper;
        }

        @Override // c.a.o0.r.t.a.e
        public void onClick(c.a.o0.r.t.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
                if (n.C()) {
                    PluginPackageManager.u().K(this.a, this.f35596b.mDownLoadAndInstallCallback);
                    this.a.setDownLoadPercent(0);
                    this.a.setDownLoadStatus(3);
                    this.f35596b.mPluginCenterAdapter.n(this.a);
                } else {
                    this.f35596b.showToast(R.string.obfuscated_res_0x7f0f0c15);
                }
                aVar.dismiss();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class c implements a.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PluginCenterActivity a;

        public c(PluginCenterActivity pluginCenterActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pluginCenterActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = pluginCenterActivity;
        }

        @Override // c.a.o0.r.t.a.e
        public void onClick(c.a.o0.r.t.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
                aVar.dismiss();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class d implements c.a.d.j.j.c {
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
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = pluginCenterActivity;
        }

        @Override // c.a.d.j.j.c
        public void a(BdFileDownloadData bdFileDownloadData) {
            PluginConfigWrapper findData;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, bdFileDownloadData) == null) || bdFileDownloadData == null || bdFileDownloadData.getId() == null || (findData = this.a.findData(bdFileDownloadData.getId())) == null) {
                return;
            }
            this.a.showToast(R.string.obfuscated_res_0x7f0f04ee);
            findData.setDownLoadStatus(0);
            this.a.mPluginCenterAdapter.n(findData);
        }
    }

    public PluginCenterActivity() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
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
                    if (pluginConfig != null && !TextUtils.isEmpty(pluginConfig.display_name) && pluginConfig.forbidden != 1 && ((h2 = c.a.d.j.j.f.c.j().h(pluginConfig.package_name)) == null || (newest = pluginConfig.newest) == null || h2.versionCode <= newest.version_code)) {
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
            if (pluginConfig == null || (h2 = c.a.d.j.j.f.c.j().h(pluginConfig.package_name)) == null) {
                return 0;
            }
            String h3 = Util.h(h2);
            if (m.isEmpty(h3)) {
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
            this.mRootView = findViewById(R.id.obfuscated_res_0x7f091647);
            this.mListView = (BdListView) findViewById(R.id.obfuscated_res_0x7f091277);
            NoDataView a2 = NoDataViewFactory.a(getPageContext().getPageActivity(), findViewById(R.id.obfuscated_res_0x7f09127e), NoDataViewFactory.d.b(NoDataViewFactory.ImgType.NODATA, n.f(getActivity(), R.dimen.obfuscated_res_0x7f070271)), NoDataViewFactory.e.a(R.string.obfuscated_res_0x7f0f0e6d), null);
            this.mNoDataView = a2;
            this.mListView.setEmptyView(a2);
            a aVar = new a(this, getPageContext(), new Class[]{c.a.p0.d3.a.a.class, c.a.p0.d3.a.b.class}, new int[]{R.layout.obfuscated_res_0x7f0d06ee, R.layout.obfuscated_res_0x7f0d06ed}, this.mEventCenter);
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
            NavigationBar navigationBar = (NavigationBar) findViewById(R.id.obfuscated_res_0x7f091519);
            this.mNavigationBar = navigationBar;
            navigationBar.setCenterTextTitle(getString(R.string.obfuscated_res_0x7f0f0e56));
            this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void resetPluginList() {
        PluginNetConfigInfos b2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65547, this) == null) || (b2 = c.a.d.j.j.e.d.a().b()) == null || b2.getConfigs() == null || b2.getConfigs().size() <= 0) {
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
            format = String.format(TbadkApplication.getInst().getString(R.string.obfuscated_res_0x7f0f0e79), Float.valueOf(pluginConfigWrapper.newest.size / 1048576.0f));
        } else {
            format = String.format(TbadkApplication.getInst().getString(R.string.obfuscated_res_0x7f0f0e5a), Float.valueOf(pluginConfigWrapper.newest.size / 1048576.0f));
        }
        if (z) {
            string = TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f04f8);
        } else {
            string = TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f04e3);
        }
        c.a.o0.r.t.a aVar = new c.a.o0.r.t.a(getActivity());
        aVar.setMessage(format);
        aVar.setPositiveButton(string, new b(this, pluginConfigWrapper));
        aVar.setNegativeButton(TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f036c), new c(this));
        aVar.create(getPageContext());
        aVar.show();
    }

    @Override // c.a.o0.k0.c.a
    public boolean isEventMustSelf() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i) == null) {
            super.onChangeSkinType(i);
            this.mNavigationBar.onChangeSkinType(getPageContext(), i);
            this.mPluginCenterAdapter.notifyDataSetChanged();
            getLayoutMode().j(findViewById(16908290));
            NoDataView noDataView = this.mNoDataView;
            if (noDataView != null) {
                noDataView.f(getPageContext(), i);
            }
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, bundle) == null) {
            super.onCreate(bundle);
            setContentView(R.layout.obfuscated_res_0x7f0d06ec);
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

    @Override // c.a.o0.k0.c.a
    public boolean onEventDispatch(c.a.o0.k0.c.b bVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, bVar)) == null) {
            int b2 = bVar.b();
            c.a.o0.k0.b.a a2 = bVar.a();
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
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(1048581, this, new Object[]{adapterView, view, Integer.valueOf(i), Long.valueOf(j)}) == null) && (this.mPluginCenterAdapter.getItem(i) instanceof PluginConfigWrapper)) {
            sendMessage(new CustomMessage(2002001, new PluginDetailActivityConfig(getPageContext().getPageActivity(), ((PluginConfigWrapper) this.mPluginCenterAdapter.getItem(i)).package_name)));
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            super.onResume();
            PluginPackageManager.u().I(this.mDownLoadAndInstallCallback);
            PluginNetConfigInfos b2 = c.a.d.j.j.e.d.a().b();
            if (b2 != null && b2.getConfigs() != null && b2.getConfigs().size() > 0) {
                List<Object> dealPluginConfigList = dealPluginConfigList(b2.getConfigs());
                this.mShowList = dealPluginConfigList;
                this.mPluginCenterAdapter.k(dealPluginConfigList);
                PluginPackageManager.u().J();
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
