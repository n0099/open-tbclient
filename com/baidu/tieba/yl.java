package com.baidu.tieba;

import com.baidu.adp.base.BdBaseApplication;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.pyramid.runtime.service.ServiceManager;
import com.baidu.searchbox.pms.bean.ErrorInfo;
import com.baidu.searchbox.pms.bean.PackageInfo;
import com.baidu.searchbox.pms.callback.DefaultDownloadCallback;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.File;
import java.util.concurrent.ConcurrentHashMap;
/* loaded from: classes7.dex */
public class yl extends DefaultDownloadCallback {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public DefaultDownloadCallback a;

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

    @Override // com.baidu.searchbox.pms.callback.DefaultDownloadCallback, com.baidu.searchbox.pms.callback.DownloadCallback
    public void onDownloadError(PackageInfo packageInfo, ErrorInfo errorInfo) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLL(1048576, this, packageInfo, errorInfo) != null) || errorInfo == null) {
            return;
        }
        BdLog.e(errorInfo.errorMsg);
        DefaultDownloadCallback defaultDownloadCallback = this.a;
        if (defaultDownloadCallback != null) {
            defaultDownloadCallback.onDownloadError(packageInfo, errorInfo);
        }
    }

    @Override // com.baidu.searchbox.pms.callback.DefaultDownloadCallback, com.baidu.searchbox.pms.callback.DownloadCallback
    public void onDownloadSuccess(PackageInfo packageInfo, ErrorInfo errorInfo) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, packageInfo, errorInfo) == null) && packageInfo != null && !StringUtils.isNull(packageInfo.filePath) && !StringUtils.isNull(packageInfo.name)) {
            File file = new File(packageInfo.filePath);
            if (file.exists() && file.isFile()) {
                String b = am.b(packageInfo.name);
                File file2 = new File(b);
                if (file2.exists() && !file2.delete()) {
                    return;
                }
                sl.b(packageInfo.name, packageInfo.toString(), "download success");
                if (file.renameTo(file2)) {
                    if (b.contains(".so")) {
                        if (cm.a(BdBaseApplication.getInst().getContext(), am.a(packageInfo.name))) {
                            sl.b(packageInfo.name, packageInfo.toString(), "load success2");
                            ConcurrentHashMap<String, String> resHashMap = BdBaseApplication.getInst().getResHashMap();
                            String str = packageInfo.name;
                            resHashMap.put(str, am.a(str));
                        }
                        ((rl) ServiceManager.getService(rl.a)).a(packageInfo.name);
                    } else {
                        ConcurrentHashMap<String, String> resHashMap2 = BdBaseApplication.getInst().getResHashMap();
                        String str2 = packageInfo.name;
                        resHashMap2.put(str2, am.a(str2));
                    }
                    DefaultDownloadCallback defaultDownloadCallback = this.a;
                    if (defaultDownloadCallback != null) {
                        defaultDownloadCallback.onDownloadSuccess(packageInfo, errorInfo);
                    }
                }
            }
        }
    }
}
