package com.baidu.tieba;

import android.text.TextUtils;
import com.baidu.adp.log.DefaultLog;
import com.baidu.adp.titan.TitanDownloadService;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.pms.bean.CheckData;
import com.baidu.searchbox.pms.bean.ErrorInfo;
import com.baidu.searchbox.pms.bean.PackageInfo;
import com.baidu.searchbox.pms.callback.DefaultDownloadCallback;
import com.baidu.searchbox.pms.callback.IDataInterceptor;
import com.baidu.searchbox.pms.callback.PackageCallback;
import com.baidu.searchbox.pms.download.DownloadOptions;
import com.baidu.searchbox.pms.init.PmsManager;
import com.baidu.searchbox.pms.init.RequestParams;
import com.baidu.searchbox.pms.init.response.ParseUtils;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class jm extends RequestParams.Channel {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes5.dex */
    public static /* synthetic */ class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* loaded from: classes5.dex */
    public static class c extends DefaultDownloadCallback {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* loaded from: classes5.dex */
        public class a implements im {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            public a(c cVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {cVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                    }
                }
            }

            @Override // com.baidu.tieba.im
            public void onResult(String str, int i, String str2) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeLIL(1048576, this, str, i, str2) == null) {
                    ng8 defaultLog = DefaultLog.getInstance();
                    defaultLog.c(TitanDownloadService.TAG, "install " + str + " result: " + i);
                }
            }
        }

        public c() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        public /* synthetic */ c(a aVar) {
            this();
        }

        @Override // com.baidu.searchbox.pms.callback.DefaultDownloadCallback, com.baidu.searchbox.pms.callback.DownloadCallback
        public void onDownloadError(PackageInfo packageInfo, ErrorInfo errorInfo) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048576, this, packageInfo, errorInfo) == null) {
                ng8 defaultLog = DefaultLog.getInstance();
                defaultLog.b(TitanDownloadService.TAG, "onDownloadError PackageInfo:" + packageInfo + " errorInfo:" + errorInfo);
                super.onDownloadError(packageInfo, errorInfo);
            }
        }

        @Override // com.baidu.searchbox.pms.callback.DefaultDownloadCallback, com.baidu.searchbox.pms.callback.DownloadCallback
        public void onDownloadSuccess(PackageInfo packageInfo, ErrorInfo errorInfo) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, packageInfo, errorInfo) == null) {
                super.onDownloadSuccess(packageInfo, errorInfo);
                ng8 defaultLog = DefaultLog.getInstance();
                defaultLog.c(TitanDownloadService.TAG, "onDownloadSuccess PackageInfo:" + packageInfo + " errorInfo:" + errorInfo);
                mm.b(AppRuntime.getAppContext(), new a(this), packageInfo, false);
            }
        }
    }

    /* loaded from: classes5.dex */
    public static class b implements IDataInterceptor {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public b() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        public /* synthetic */ b(a aVar) {
            this();
        }

        @Override // com.baidu.searchbox.pms.callback.IDataInterceptor
        public JSONObject getUploadData() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                km d = km.d();
                d.g();
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("com.baidu.titan.patch", String.valueOf(d.b()));
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                DefaultLog.getInstance().c(TitanDownloadService.TAG, "get upload data");
                return jSONObject;
            }
            return (JSONObject) invokeV.objValue;
        }

        @Override // com.baidu.searchbox.pms.callback.IDataInterceptor
        public CheckData onReceiveData(JSONObject jSONObject, int i, int i2, String str) {
            InterceptResult invokeCommon;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{jSONObject, Integer.valueOf(i), Integer.valueOf(i2), str})) == null) {
                if (jSONObject == null) {
                    return null;
                }
                try {
                    JSONObject jSONObject2 = jSONObject.getJSONObject("com.baidu.titan.patch");
                    ng8 defaultLog = DefaultLog.getInstance();
                    defaultLog.c(TitanDownloadService.TAG, "onReceiveData:" + jSONObject2);
                    PackageInfo parsePkgItem = ParseUtils.parsePkgItem("132", "com.baidu.titan.patch", jSONObject2);
                    CheckData checkData = new CheckData();
                    JSONObject jSONObject3 = new JSONObject();
                    jSONObject3.put("product", "132/com.baidu.titan.patch");
                    if (parsePkgItem != null && parsePkgItem.updateVersion > 0) {
                        DownloadOptions downloadOptions = new DownloadOptions();
                        downloadOptions.saveToDb = false;
                        PmsManager.getInstance().download(parsePkgItem, downloadOptions, new c(null));
                        if (!TextUtils.isEmpty(parsePkgItem.downloadUrl)) {
                            jSONObject3.put("valid", 1);
                        } else {
                            jSONObject3.put("valid", 0);
                        }
                        jSONObject3.put("version", parsePkgItem.updateVersion);
                    }
                    ArrayList arrayList = new ArrayList();
                    checkData.items = arrayList;
                    arrayList.add(jSONObject2);
                    checkData.totalCount = 1;
                    checkData.successCount = 1;
                    return checkData;
                } catch (JSONException e) {
                    e.printStackTrace();
                    return null;
                }
            }
            return (CheckData) invokeCommon.objValue;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public jm() {
        super("132", "com.baidu.titan.patch", (PackageCallback) null);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr = newInitContext.callArgs;
                super((String) objArr[0], (String) objArr[1], (PackageCallback) objArr[2]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        setDataInterceptor(new b(null));
    }
}
