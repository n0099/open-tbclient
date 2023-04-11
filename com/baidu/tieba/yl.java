package com.baidu.tieba;

import com.baidu.adp.base.BdBaseApplication;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.pms.bean.DegradeData;
import com.baidu.searchbox.pms.bean.ErrorInfo;
import com.baidu.searchbox.pms.bean.PackageInfo;
import com.baidu.searchbox.pms.bean.ResultData;
import com.baidu.searchbox.pms.callback.DefaultDownloadCallback;
import com.baidu.searchbox.pms.callback.DefaultPackageCallback;
import com.baidu.searchbox.pms.download.DownloadOptions;
import com.baidu.searchbox.pms.init.PmsManager;
import com.baidu.searchbox.pms.utils.DebugUtils;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
/* loaded from: classes7.dex */
public class yl extends DefaultPackageCallback {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public DefaultDownloadCallback a;
    public am b;

    /* loaded from: classes7.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ List a;
        public final /* synthetic */ yl b;

        public a(yl ylVar, List list) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ylVar, list};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = ylVar;
            this.a = list;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                for (PackageInfo packageInfo : this.a) {
                    if (packageInfo != null && !StringUtils.isNull(packageInfo.name)) {
                        this.b.a.onDownloadSuccess(packageInfo, null);
                    }
                }
            }
        }
    }

    public yl(DefaultDownloadCallback defaultDownloadCallback) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {defaultDownloadCallback};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = defaultDownloadCallback;
    }

    @Override // com.baidu.searchbox.pms.callback.DefaultPackageCallback, com.baidu.searchbox.pms.callback.PackageCallback
    public void onDegradeData(DegradeData degradeData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, degradeData) == null) {
            super.onDegradeData(degradeData);
        }
    }

    @Override // com.baidu.searchbox.pms.callback.DefaultPackageCallback, com.baidu.searchbox.pms.callback.PackageCallback
    public void onFetchError(ErrorInfo errorInfo) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, errorInfo) != null) || errorInfo == null) {
            return;
        }
        BdLog.e(errorInfo.errorMsg);
    }

    public yl(DefaultDownloadCallback defaultDownloadCallback, am amVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {defaultDownloadCallback, amVar};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.a = defaultDownloadCallback;
        this.b = amVar;
    }

    @Override // com.baidu.searchbox.pms.callback.DefaultPackageCallback, com.baidu.searchbox.pms.callback.PackageCallback
    public void onResultData(ResultData resultData) {
        boolean z;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, resultData) != null) || resultData == null) {
            return;
        }
        DebugUtils.log(resultData);
        ArrayList<PackageInfo> arrayList = new ArrayList();
        arrayList.addAll(resultData.addList);
        arrayList.addAll(resultData.updateList);
        if (!arrayList.isEmpty()) {
            z = false;
            for (PackageInfo packageInfo : arrayList) {
                if (packageInfo != null && !StringUtils.isNull(packageInfo.name)) {
                    DownloadOptions downloadOptions = new DownloadOptions();
                    downloadOptions.fileDir = zl.a(packageInfo.name);
                    PmsManager.getInstance().download(packageInfo, downloadOptions, new xl(this.a));
                    z = true;
                }
            }
        } else {
            z = false;
        }
        arrayList.clear();
        arrayList.addAll(resultData.configChangeList);
        arrayList.addAll(resultData.filterList);
        if (!arrayList.isEmpty()) {
            for (PackageInfo packageInfo2 : arrayList) {
                if (packageInfo2 != null && !StringUtils.isNull(packageInfo2.name)) {
                    if (!packageInfo2.name.contains(".so")) {
                        ConcurrentHashMap<String, String> resHashMap = BdBaseApplication.getInst().getResHashMap();
                        String str = packageInfo2.name;
                        resHashMap.put(str, zl.a(str));
                    } else if (!new File(zl.b(packageInfo2.name)).exists()) {
                        DownloadOptions downloadOptions2 = new DownloadOptions();
                        downloadOptions2.fileDir = zl.a(packageInfo2.name);
                        PmsManager.getInstance().download(packageInfo2, downloadOptions2, new xl(this.a));
                    } else if (bm.a(BdBaseApplication.getInst().getContext(), zl.a(packageInfo2.name))) {
                        ConcurrentHashMap<String, String> resHashMap2 = BdBaseApplication.getInst().getResHashMap();
                        String str2 = packageInfo2.name;
                        resHashMap2.put(str2, zl.a(str2));
                        am amVar = this.b;
                        if (amVar != null) {
                            amVar.onSoFileLoaded(packageInfo2.name);
                        }
                    }
                }
            }
            if (!z && this.b == null && this.a != null) {
                jg.a().post(new a(this, arrayList));
            }
        }
        if (!resultData.invalidList.isEmpty()) {
            BdAsyncTask<?, ?, ?> searchTask = BdAsyncTask.searchTask("key_res_del");
            if (searchTask == null || searchTask.getStatus() != BdAsyncTask.BdAsyncTaskStatus.PENDING) {
                wl wlVar = new wl();
                wlVar.setKey("key_res_del");
                wlVar.execute(resultData.invalidList);
            }
        }
    }
}
