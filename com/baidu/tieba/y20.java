package com.baidu.tieba;

import android.content.ContentUris;
import android.text.TextUtils;
import android.util.Log;
import androidx.core.view.InputDeviceCompat;
import com.baidu.pyramid.runtime.service.ServiceManager;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.config.AppConfig;
import com.baidu.searchbox.download.constants.DownloadStatisticConstants;
import com.baidu.searchbox.download.model.Downloads;
import com.baidu.searchbox.download.model.ExtraInfoModel;
import com.baidu.searchbox.download.statistics.ApkCloudStatisticsUtils;
import com.baidu.searchbox.download.unified.DownloadInfoData;
import com.baidu.searchbox.download.unified.DownloadInfoDatasCallback;
import com.baidu.searchbox.download.unified.DownloadUnifiedManager;
import com.baidu.searchbox.download.util.ApkUtil;
import com.baidu.searchbox.download.util.DocClassifyHelper;
import com.baidu.searchbox.download.util.DownloadHelper;
import com.baidu.searchbox.download.util.DownloadStatisticUtil;
import com.baidu.searchbox.download.util.FileClassifyHelper;
import com.baidu.searchbox.downloadcenter.service.DownloadCenterFunConstants;
import com.baidu.searchbox.downloads.manage.SearchBoxDownloadManager;
import com.baidu.searchbox.retrieve.upload.UploadConstant;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.ubc.UBC;
import com.baidu.ubc.UBCManager;
import java.util.List;
import java.util.Locale;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes8.dex */
public class y20 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean a;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes8.dex */
    public class a implements DownloadInfoDatasCallback {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public a() {
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

        @Override // com.baidu.searchbox.download.unified.DownloadInfoDatasCallback
        public void callback(List<DownloadInfoData> list) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, list) == null) && list != null && list.size() > 0) {
                y20.g(list.get(0), DownloadStatisticConstants.UBC_TYPE_BEGINNING);
            }
        }
    }

    /* loaded from: classes8.dex */
    public class b implements DownloadInfoDatasCallback {
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

        @Override // com.baidu.searchbox.download.unified.DownloadInfoDatasCallback
        public void callback(List<DownloadInfoData> list) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, list) == null) && list != null && list.size() > 0) {
                DownloadInfoData downloadInfoData = list.get(0);
                if (1 != downloadInfoData.getBusinessType()) {
                    y20.g(downloadInfoData, "success");
                }
            }
        }
    }

    /* loaded from: classes8.dex */
    public class c implements DownloadInfoDatasCallback {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

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

        @Override // com.baidu.searchbox.download.unified.DownloadInfoDatasCallback
        public void callback(List<DownloadInfoData> list) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, list) == null) && list != null && list.size() > 0) {
                y20.g(list.get(0), "continue");
            }
        }
    }

    /* loaded from: classes8.dex */
    public class d implements DownloadInfoDatasCallback {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ int a;
        public final /* synthetic */ String b;

        public d(int i, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {Integer.valueOf(i), str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = i;
            this.b = str;
        }

        @Override // com.baidu.searchbox.download.unified.DownloadInfoDatasCallback
        public void callback(List<DownloadInfoData> list) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, list) == null) && list != null && list.size() > 0) {
                DownloadInfoData downloadInfoData = list.get(0);
                if (downloadInfoData.getStatus() == 4) {
                    y20.h(downloadInfoData, DownloadStatisticConstants.UBC_TYPE_SUSPEND, this.a, this.b);
                } else {
                    y20.h(downloadInfoData, "fail", this.a, this.b);
                }
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948278130, "Lcom/baidu/tieba/y20;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948278130, "Lcom/baidu/tieba/y20;");
                return;
            }
        }
        a = AppConfig.isDebug();
    }

    public static void g(DownloadInfoData downloadInfoData, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65543, null, downloadInfoData, str) == null) {
            h(downloadInfoData, str, 0, "");
        }
    }

    public static void c(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65539, null, str, str2) == null) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("from", "tool");
                jSONObject.put("page", str);
                jSONObject.put("source", str2);
            } catch (JSONException e) {
                if (a) {
                    e.printStackTrace();
                }
            }
            z(DownloadStatisticConstants.UBC_DOWNLOAD_CENTER_CLICK, jSONObject.toString());
            UBC.onEvent(DownloadStatisticConstants.UBC_DOWNLOAD_CENTER_CLICK, jSONObject);
        }
    }

    public static void y(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65561, null, str, str2) == null) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("from", "tool");
                jSONObject.put("type", "set");
                jSONObject.put("source", str);
                jSONObject.put("page", str2);
            } catch (JSONException e) {
                if (a) {
                    e.printStackTrace();
                }
            }
            UBC.onEvent(DownloadStatisticConstants.UBC_DOWNLOAD_CENTER_CLICK, jSONObject);
        }
    }

    public static void z(String str, String str2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(65562, null, str, str2) == null) && a) {
            Log.e("DownloadStatisticsUBC", "ubcId=" + str + ": " + str2);
        }
    }

    public static void d(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(InputDeviceCompat.SOURCE_TRACKBALL, null, j) == null) {
            DownloadUnifiedManager.getInstance().queryDownloadInfoDataAsync(ContentUris.withAppendedId(Downloads.Impl.CONTENT_URI, j), new c());
        }
    }

    public static void f(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(65542, null, j) == null) {
            DownloadUnifiedManager.getInstance().queryDownloadInfoDataAsync(ContentUris.withAppendedId(Downloads.Impl.CONTENT_URI, j), new a());
        }
    }

    public static void j(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(65546, null, j) == null) {
            DownloadUnifiedManager.getInstance().queryDownloadInfoDataAsync(ContentUris.withAppendedId(Downloads.Impl.CONTENT_URI, j), new b());
        }
    }

    public static void e(long j, int i, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65541, null, new Object[]{Long.valueOf(j), Integer.valueOf(i), str}) == null) {
            DownloadUnifiedManager.getInstance().queryDownloadInfoDataAsync(ContentUris.withAppendedId(Downloads.Impl.CONTENT_URI, j), new d(i, str));
        }
    }

    public static void h(DownloadInfoData downloadInfoData, String str, int i, String str2) {
        String str3;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLLIL(65544, null, downloadInfoData, str, i, str2) != null) || downloadInfoData == null) {
            return;
        }
        if (downloadInfoData.isVisibleInDownloadsUI()) {
            str3 = "download";
        } else {
            str3 = "other";
        }
        String filePath = downloadInfoData.getFilePath();
        String w = w(false, filePath, downloadInfoData.getMimeType());
        JSONObject jSONObject = new JSONObject();
        try {
            try {
                String extraInfo = downloadInfoData.getExtraInfo();
                jSONObject.putOpt("name", FileClassifyHelper.getFileNameFromPath(filePath));
                jSONObject.putOpt("url", downloadInfoData.getUrl());
                jSONObject.putOpt("size", Long.valueOf(downloadInfoData.getTotalSize()));
                jSONObject.putOpt("partner", downloadInfoData.getSource());
                jSONObject.putOpt("pkg", ApkUtil.parsePackageInfo(AppRuntime.getAppContext(), filePath)[1]);
                jSONObject.putOpt(DownloadStatisticUtil.EXT_KEY_PARTNER_NAME, DownloadStatisticUtil.getExtraSource(extraInfo));
                String extraPartnerSource = DownloadStatisticUtil.getExtraPartnerSource(extraInfo);
                if (!TextUtils.isEmpty(extraPartnerSource)) {
                    jSONObject.putOpt("swan_partner_name", extraPartnerSource);
                }
                String fileSuffix = FileClassifyHelper.getFileSuffix(filePath);
                String str4 = "";
                if (!TextUtils.isEmpty(fileSuffix)) {
                    str4 = fileSuffix.toLowerCase(Locale.getDefault());
                }
                jSONObject.putOpt(UploadConstant.FILE_TYPE, str4);
                if (i != 0) {
                    jSONObject.putOpt("failed_code", Integer.valueOf(i));
                }
                if (!TextUtils.isEmpty(str2)) {
                    jSONObject.putOpt("failed_msg", str2);
                }
            } catch (Exception e) {
                if (a) {
                    e.printStackTrace();
                }
            }
        } finally {
            i(str, str3, w, jSONObject);
        }
    }

    public static void i(String str, String str2, String str3, JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(65545, null, str, str2, str3, jSONObject) == null) {
            JSONObject jSONObject2 = new JSONObject();
            try {
                jSONObject2.putOpt("from", "download");
                jSONObject2.putOpt("type", str);
                jSONObject2.putOpt("source", str2);
                jSONObject2.putOpt("value", str3);
                jSONObject2.put("ext", jSONObject);
                z(DownloadStatisticConstants.UBC_DOWNLOAD_CENTER_CLICK, jSONObject2.toString());
                uua uuaVar = (uua) ServiceManager.getService(UBCManager.SERVICE_REFERENCE);
                if (uuaVar != null) {
                    uuaVar.onEvent(DownloadStatisticConstants.UBC_DOWNLOAD_CENTER_CLICK, jSONObject2);
                }
            } catch (Exception e) {
                if (a) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void k(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65547, null, str) == null) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("from", "tool");
                jSONObject.put("page", DownloadStatisticConstants.UBC_PAGE_VALUE_TOUCH);
                jSONObject.put("source", str);
                ((uua) ServiceManager.getService(UBCManager.SERVICE_REFERENCE)).onEvent(DownloadStatisticConstants.UBC_DOWNLOAD_CENTER_CLICK, jSONObject);
            } catch (JSONException e) {
                if (a) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void l(int i, String str, String str2, JSONObject jSONObject, String str3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65548, null, new Object[]{Integer.valueOf(i), str, str2, jSONObject, str3}) == null) {
            JSONObject jSONObject2 = new JSONObject();
            try {
                ExtraInfoModel parseApkInfo = ApkUtil.parseApkInfo(str3);
                String str4 = DownloadStatisticConstants.UBC_TYPE_PAUSE;
                if (Downloads.isStatusError(i)) {
                    str4 = DownloadStatisticConstants.UBC_VALUE_DOWNLOAD_FAIL;
                }
                jSONObject2.put("from", "tool");
                jSONObject2.put("type", str4);
                jSONObject2.put("source", parseApkInfo.source);
                jSONObject2.put("value", DownloadHelper.getFileTypeString(str, str2));
                if (jSONObject != null) {
                    jSONObject2.put("ext", jSONObject.toString());
                }
            } catch (JSONException e) {
                if (a) {
                    e.printStackTrace();
                }
            }
            z(DownloadStatisticConstants.UBC_DOWNLOAD_CENTER_CLICK, jSONObject2.toString());
            UBC.onEvent(DownloadStatisticConstants.UBC_DOWNLOAD_CENTER_CLICK, jSONObject2);
        }
    }

    public static void m(String str, String str2, int i, String str3, String str4, int i2, boolean z, String str5) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65549, null, new Object[]{str, str2, Integer.valueOf(i), str3, str4, Integer.valueOf(i2), Boolean.valueOf(z), str5}) == null) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put(DownloadCenterFunConstants.MIME_TYPE, str);
                jSONObject.put(DownloadCenterFunConstants.MIME_TYPE, str2);
                jSONObject.put("status", i);
                jSONObject.put("url", str3);
                jSONObject.put("referer", ApkCloudStatisticsUtils.removeBDussInUrl(str4));
                jSONObject.put("redirectCount", i2);
                jSONObject.put("countRetry", z);
            } catch (JSONException e) {
                if (a) {
                    e.printStackTrace();
                }
            }
            l(i, str, str2, jSONObject, str5);
        }
    }

    public static void n(boolean z, String str) {
        String str2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZL(65550, null, z, str) == null) {
            JSONObject jSONObject = new JSONObject();
            if (z) {
                str2 = "agree";
            } else {
                str2 = "disagree";
            }
            try {
                jSONObject.put("from", "tool");
                jSONObject.put("page", "storage");
                jSONObject.put("value", "download");
                jSONObject.put("type", str2);
                jSONObject.put("source", str);
                ((uua) ServiceManager.getService(UBCManager.SERVICE_REFERENCE)).onEvent("2505", jSONObject);
            } catch (JSONException e) {
                if (a) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void r(String str, boolean z) {
        String str2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(65554, null, str, z) == null) {
            JSONObject jSONObject = new JSONObject();
            if (z) {
                str2 = DownloadStatisticConstants.UBC_PERMISSION_DIALOG_CONFIRM;
            } else {
                str2 = DownloadStatisticConstants.UBC_PERMISSION_DIALOG_CANCELL;
            }
            try {
                jSONObject.put("source", str2);
                jSONObject.put("page", DownloadStatisticConstants.UBC_PAGE_VALUE_START_DOWN);
                jSONObject.put("from", "tool");
                jSONObject.put("type", "click");
                jSONObject.put("value", str);
                ((uua) ServiceManager.getService(UBCManager.SERVICE_REFERENCE)).onEvent(DownloadStatisticConstants.UBC_DOWNLOAD_CENTER_CLICK, jSONObject);
            } catch (JSONException e) {
                if (a) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void t(String str, boolean z) {
        String str2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(65556, null, str, z) == null) {
            JSONObject jSONObject = new JSONObject();
            if (z) {
                str2 = "agree";
            } else {
                str2 = "disagree";
            }
            try {
                jSONObject.put("from", "tool");
                jSONObject.put("page", "storage");
                jSONObject.put("value", "system");
                jSONObject.put("type", str2);
                jSONObject.put("source", str);
                ((uua) ServiceManager.getService(UBCManager.SERVICE_REFERENCE)).onEvent("2505", jSONObject);
            } catch (JSONException e) {
                if (a) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void o(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65551, null, str) == null) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("from", "tool");
                jSONObject.put("source", DownloadStatisticConstants.UBC_VALUE_TOAST_SHOW);
                jSONObject.put("type", "show");
                jSONObject.put("page", "downloadcenter");
                jSONObject.put("value", str);
                ((uua) ServiceManager.getService(UBCManager.SERVICE_REFERENCE)).onEvent(DownloadStatisticConstants.UBC_DOWNLOAD_CENTER_CLICK, jSONObject);
            } catch (JSONException e) {
                if (a) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void q(long[] jArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65553, null, jArr) == null) {
            for (long j : jArr) {
                if (a) {
                    Log.e("DownloadStatisticsUBC", "统计FileDownloader 恢复下载的id=" + j);
                }
                String[] queryStaticsInfoByDownloadID = SearchBoxDownloadManager.getInstance(AppRuntime.getAppContext()).queryStaticsInfoByDownloadID(Long.toString(j));
                if (queryStaticsInfoByDownloadID != null && queryStaticsInfoByDownloadID.length == 6) {
                    p(queryStaticsInfoByDownloadID[3], queryStaticsInfoByDownloadID[4], queryStaticsInfoByDownloadID[5]);
                }
            }
        }
    }

    public static void s(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65555, null, str) == null) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("source", DownloadStatisticConstants.UBC_PERMISSION_DIALOG_SHOW);
                jSONObject.put("page", DownloadStatisticConstants.UBC_PAGE_VALUE_START_DOWN);
                jSONObject.put("from", "tool");
                jSONObject.put("type", "show");
                jSONObject.put("value", str);
                ((uua) ServiceManager.getService(UBCManager.SERVICE_REFERENCE)).onEvent(DownloadStatisticConstants.UBC_DOWNLOAD_CENTER_CLICK, jSONObject);
            } catch (JSONException e) {
                if (a) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void p(String str, String str2, String str3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65552, null, str, str2, str3) == null) {
            JSONObject jSONObject = new JSONObject();
            ExtraInfoModel parseApkInfo = ApkUtil.parseApkInfo(str3);
            try {
                jSONObject.put("from", "tool");
                jSONObject.put("type", DownloadStatisticConstants.UBC_TYPE_RESUME);
                jSONObject.put("value", DownloadHelper.getFileTypeString(str, str2));
                jSONObject.put("source", parseApkInfo.source);
            } catch (JSONException e) {
                if (a) {
                    e.printStackTrace();
                }
            }
            z(DownloadStatisticConstants.UBC_DOWNLOAD_CENTER_CLICK, jSONObject.toString());
            UBC.onEvent(DownloadStatisticConstants.UBC_DOWNLOAD_CENTER_CLICK, jSONObject);
        }
    }

    public static void v(String str, String str2, String str3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65558, null, str, str2, str3) == null) {
            JSONObject jSONObject = new JSONObject();
            ExtraInfoModel parseApkInfo = ApkUtil.parseApkInfo(str3);
            try {
                jSONObject.put("from", "tool");
                jSONObject.put("type", "start");
                jSONObject.put("value", DownloadHelper.getFileTypeString(str, str2));
                jSONObject.put("source", parseApkInfo.source);
            } catch (JSONException e) {
                if (a) {
                    e.printStackTrace();
                }
            }
            z(DownloadStatisticConstants.UBC_DOWNLOAD_CENTER_CLICK, jSONObject.toString());
            UBC.onEvent(DownloadStatisticConstants.UBC_DOWNLOAD_CENTER_CLICK, jSONObject);
        }
    }

    public static void u() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65557, null) == null) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("from", "tool");
                jSONObject.put("type", "show");
                jSONObject.put("page", "space");
            } catch (Exception e) {
                if (a) {
                    e.printStackTrace();
                }
            }
            z(DownloadStatisticConstants.DOWNLOAD_WINDOWN_UBC_ID, jSONObject.toString());
            UBC.onEvent(DownloadStatisticConstants.UBC_DOWNLOAD_CENTER_CLICK, jSONObject);
        }
    }

    public static String w(boolean z, String str, String str2) {
        InterceptResult invokeCommon;
        String str3;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65559, null, new Object[]{Boolean.valueOf(z), str, str2})) == null) {
            if (!TextUtils.isEmpty(str)) {
                str3 = str.toLowerCase(Locale.getDefault());
            } else {
                str3 = "";
            }
            String fileSuffix = FileClassifyHelper.getFileSuffix(str3);
            int category = FileClassifyHelper.getCategory(fileSuffix, str2);
            if (category == 0) {
                if (z) {
                    return "video";
                }
                return DownloadStatisticConstants.UBC_VALUE_SHORT_VIDEO;
            } else if (category == 1) {
                return "music";
            } else {
                if (category == 2) {
                    return "image";
                }
                if (category == 3) {
                    return "app";
                }
                if (category == 8) {
                    return "zip";
                }
                if (category == 11) {
                    return DownloadStatisticConstants.UBC_VALUE_OFFLINE_WEB;
                }
                if (category == 4) {
                    DocClassifyHelper.DocCategroy docDetailType = DocClassifyHelper.getDocDetailType(fileSuffix, str2);
                    if (docDetailType == DocClassifyHelper.DocCategroy.PDF) {
                        return "pdf";
                    }
                    if (docDetailType == DocClassifyHelper.DocCategroy.PPT) {
                        return "ppt";
                    }
                    if (docDetailType == DocClassifyHelper.DocCategroy.WORD) {
                        return "doc";
                    }
                    if (docDetailType == DocClassifyHelper.DocCategroy.EXCEL) {
                        return "xls";
                    }
                    if (docDetailType == DocClassifyHelper.DocCategroy.TEXT) {
                        return "txt";
                    }
                }
                return "other";
            }
        }
        return (String) invokeCommon.objValue;
    }

    public static void x(String str, String str2, String str3, String str4, String str5, JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65560, null, new Object[]{str, str2, str3, str4, str5, jSONObject}) == null) {
            JSONObject jSONObject2 = new JSONObject();
            try {
                if (!TextUtils.isEmpty(str)) {
                    jSONObject2.put("from", str);
                }
                if (!TextUtils.isEmpty(str2)) {
                    jSONObject2.put("type", str2);
                }
                if (!TextUtils.isEmpty(str3)) {
                    jSONObject2.put("page", str3);
                }
                if (!TextUtils.isEmpty(str4)) {
                    jSONObject2.put("source", str4);
                }
                if (!TextUtils.isEmpty(str5)) {
                    jSONObject2.put("value", str5);
                }
                if (jSONObject != null && jSONObject.length() != 0) {
                    jSONObject2.put("ext", jSONObject);
                }
                ((UBCManager) ServiceManager.getService(UBCManager.SERVICE_REFERENCE)).onEvent(DownloadStatisticConstants.UBC_DOWNLOAD_OPEN_FILE, jSONObject2.toString());
            } catch (Exception e) {
                if (AppConfig.isDebug()) {
                    e.printStackTrace();
                }
            }
            z(DownloadStatisticConstants.UBC_DOWNLOAD_OPEN_FILE, jSONObject2.toString());
        }
    }
}
