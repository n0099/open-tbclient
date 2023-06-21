package com.baidu.tieba;

import android.text.TextUtils;
import com.baidu.adp.base.BdBaseApplication;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.log.DefaultLog;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.pms.bean.DegradeData;
import com.baidu.searchbox.pms.bean.ErrorInfo;
import com.baidu.searchbox.pms.bean.PackageInfo;
import com.baidu.searchbox.pms.bean.ResultData;
import com.baidu.searchbox.pms.callback.DefaultDownloadCallback;
import com.baidu.searchbox.pms.callback.DefaultPackageCallback;
import com.baidu.searchbox.pms.db.PackageManager;
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
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
/* loaded from: classes7.dex */
public class nm extends DefaultPackageCallback {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public DefaultDownloadCallback a;
    public pm b;

    /* loaded from: classes7.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ List a;
        public final /* synthetic */ nm b;

        public a(nm nmVar, List list) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {nmVar, list};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = nmVar;
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

    public nm(DefaultDownloadCallback defaultDownloadCallback) {
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
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, degradeData) == null) {
            super.onDegradeData(degradeData);
        }
    }

    public nm(DefaultDownloadCallback defaultDownloadCallback, pm pmVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {defaultDownloadCallback, pmVar};
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
        this.b = pmVar;
    }

    public final void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            for (PackageInfo packageInfo : PackageManager.getFinishedPackageInfo("137", null).values()) {
                if (packageInfo != null && !StringUtils.isNull(packageInfo.name) && !om.c(packageInfo.name)) {
                    if (!packageInfo.name.contains(".so")) {
                        ConcurrentHashMap<String, String> resHashMap = BdBaseApplication.getInst().getResHashMap();
                        String str = packageInfo.name;
                        resHashMap.put(str, om.a(str));
                    } else if (!new File(om.b(packageInfo.name)).exists()) {
                        DownloadOptions downloadOptions = new DownloadOptions();
                        downloadOptions.fileDir = om.a(packageInfo.name);
                        gm.b(packageInfo.name, packageInfo.toString(), "re download start");
                        PmsManager.getInstance().download(packageInfo, downloadOptions, new mm(this.a));
                    } else if (qm.a(BdBaseApplication.getInst().getContext(), om.a(packageInfo.name))) {
                        gm.b(packageInfo.name, packageInfo.toString(), "load success1");
                        ConcurrentHashMap<String, String> resHashMap2 = BdBaseApplication.getInst().getResHashMap();
                        String str2 = packageInfo.name;
                        resHashMap2.put(str2, om.a(str2));
                        pm pmVar = this.b;
                        if (pmVar != null) {
                            pmVar.onSoFileLoaded(packageInfo.name);
                        }
                    }
                }
            }
        }
    }

    @Override // com.baidu.searchbox.pms.callback.DefaultPackageCallback, com.baidu.searchbox.pms.callback.PackageCallback
    public void onFetchError(ErrorInfo errorInfo) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, errorInfo) != null) || errorInfo == null) {
            return;
        }
        BdBaseApplication.getInst().getResHashMap().clear();
        b();
        tr8 defaultLog = DefaultLog.getInstance();
        defaultLog.c("PMS", "onFetchError: " + BdBaseApplication.getInst().getResHashMap().toString());
        BdLog.e(errorInfo.errorMsg);
    }

    @Override // com.baidu.searchbox.pms.callback.DefaultPackageCallback, com.baidu.searchbox.pms.callback.PackageCallback
    public void onResultData(ResultData resultData) {
        boolean z;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048579, this, resultData) != null) || resultData == null) {
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
                    downloadOptions.fileDir = om.a(packageInfo.name);
                    gm.b(packageInfo.name, packageInfo.toString(), "download start");
                    PmsManager.getInstance().download(packageInfo, downloadOptions, new mm(this.a));
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
                        resHashMap.put(str, om.a(str));
                    } else if (!om.c(packageInfo2.name)) {
                        if (!new File(om.b(packageInfo2.name)).exists()) {
                            DownloadOptions downloadOptions2 = new DownloadOptions();
                            downloadOptions2.fileDir = om.a(packageInfo2.name);
                            gm.b(packageInfo2.name, packageInfo2.toString(), "re download start");
                            PmsManager.getInstance().download(packageInfo2, downloadOptions2, new mm(this.a));
                        } else if (qm.a(BdBaseApplication.getInst().getContext(), om.a(packageInfo2.name))) {
                            gm.b(packageInfo2.name, packageInfo2.toString(), "load success1");
                            ConcurrentHashMap<String, String> resHashMap2 = BdBaseApplication.getInst().getResHashMap();
                            String str2 = packageInfo2.name;
                            resHashMap2.put(str2, om.a(str2));
                            pm pmVar = this.b;
                            if (pmVar != null) {
                                pmVar.onSoFileLoaded(packageInfo2.name);
                            }
                        }
                    }
                }
            }
            if (!z && this.b == null && this.a != null) {
                xg.a().post(new a(this, arrayList));
            }
        }
        tr8 defaultLog = DefaultLog.getInstance();
        defaultLog.c("PMS", "检索数据库前Map：" + BdBaseApplication.getInst().getResHashMap().toString());
        b();
        tr8 defaultLog2 = DefaultLog.getInstance();
        defaultLog2.c("PMS", "检索数据库后Map：" + BdBaseApplication.getInst().getResHashMap().toString());
        if (!resultData.invalidList.isEmpty()) {
            ArrayList arrayList2 = new ArrayList();
            Map<String, PackageInfo> finishedPackageInfo = PackageManager.getFinishedPackageInfo("137", null);
            for (PackageInfo packageInfo3 : resultData.invalidList) {
                boolean z2 = true;
                for (PackageInfo packageInfo4 : finishedPackageInfo.values()) {
                    if (!TextUtils.isEmpty(packageInfo3.name) && !TextUtils.isEmpty(packageInfo4.name) && packageInfo4.name.equals(packageInfo3.name)) {
                        tr8 defaultLog3 = DefaultLog.getInstance();
                        defaultLog3.c("PMS", "本地数据库中已有资源：" + packageInfo3.name);
                        if (packageInfo4.version == packageInfo3.version) {
                            z2 = false;
                        }
                    }
                }
                if (z2) {
                    arrayList2.add(packageInfo3);
                }
            }
            if (arrayList2.isEmpty()) {
                return;
            }
            tr8 defaultLog4 = DefaultLog.getInstance();
            defaultLog4.c("PMS", "删除已经废弃资源:" + arrayList2.toString());
            BdAsyncTask<?, ?, ?> searchTask = BdAsyncTask.searchTask("key_res_del");
            if (searchTask == null || searchTask.getStatus() != BdAsyncTask.BdAsyncTaskStatus.PENDING) {
                lm lmVar = new lm();
                lmVar.setKey("key_res_del");
                lmVar.execute(arrayList2);
            }
        }
    }
}
