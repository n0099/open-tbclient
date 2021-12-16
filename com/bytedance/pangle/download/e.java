package com.bytedance.pangle.download;

import android.os.Build;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.ar.constants.HttpConstants;
import com.baidu.searchbox.pms.db.PackageTable;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.bytedance.frameworks.core.encrypt.RequestEncryptUtils;
import com.bytedance.pangle.Zeus;
import com.bytedance.pangle.ZeusParam;
import com.bytedance.pangle.plugin.Plugin;
import com.bytedance.pangle.plugin.PluginManager;
import com.meizu.cloud.pushsdk.notification.model.TimeDisplaySetting;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public final class e {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static String a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            ZeusParam zeusParam = com.bytedance.pangle.i.a().f55184b;
            String host = zeusParam.getHost();
            if (TextUtils.isEmpty(host)) {
                host = "https://plugin-patch-api.bytedance.com/api/plugin/config/v2/";
            }
            StringBuilder sb = new StringBuilder(host);
            sb.append("?");
            a(sb, "device_id", zeusParam.getDid().get());
            a(sb, "ac", d.c(Zeus.getAppApplication()));
            a(sb, "channel", zeusParam.getChannel());
            a(sb, "aid", String.valueOf(zeusParam.getAppId()));
            a(sb, "app_name", zeusParam.getAppName());
            a(sb, "version_code", String.valueOf(zeusParam.getHostVersionCode()));
            a(sb, "update_version_code", String.valueOf(zeusParam.getHostVersionCode()));
            a(sb, "version_name", zeusParam.getHostVersionName());
            a(sb, "device_platform", "android");
            String a = i.a(Zeus.getAppApplication());
            if (!TextUtils.isEmpty(a)) {
                a(sb, "resolution", a);
            }
            int b2 = i.b(Zeus.getAppApplication());
            if (b2 > 0) {
                a(sb, "dpi", String.valueOf(b2));
            }
            a(sb, "device_type", Build.MODEL);
            a(sb, RequestEncryptUtils.KEY_DEVICE_BRAND, Build.BRAND);
            a(sb, "language", Locale.getDefault().getLanguage());
            a(sb, "os_api", String.valueOf(Build.VERSION.SDK_INT));
            try {
                String str = Build.VERSION.RELEASE;
                if (str != null && str.length() > 10) {
                    str = str.substring(0, 10);
                }
                a(sb, HttpConstants.OS_VERSION, str);
            } catch (Exception unused) {
            }
            a(sb, "host_abi", com.bytedance.pangle.helper.b.a());
            a(sb, TimeDisplaySetting.TIME_DISPLAY_SETTING, String.valueOf(System.currentTimeMillis()));
            sb.deleteCharAt(sb.length() - 1);
            return sb.toString();
        }
        return (String) invokeV.objValue;
    }

    @Nullable
    public static JSONArray b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) {
            List<Plugin> plugins = PluginManager.getInstance().getPlugins();
            if (plugins == null || plugins.isEmpty()) {
                return null;
            }
            JSONArray jSONArray = new JSONArray();
            for (Plugin plugin2 : plugins) {
                if (plugin2 != null) {
                    try {
                        jSONArray.put(a(plugin2));
                    } catch (JSONException e2) {
                        e2.printStackTrace();
                    }
                }
            }
            return jSONArray;
        }
        return (JSONArray) invokeV.objValue;
    }

    public static void a(StringBuilder sb, String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65539, null, sb, str, str2) == null) {
            sb.append(str);
            sb.append("=");
            sb.append(str2);
            sb.append("&");
        }
    }

    public static PluginDownloadBean a(@NonNull JSONObject jSONObject) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, jSONObject)) == null) {
            PluginDownloadBean pluginDownloadBean = new PluginDownloadBean();
            pluginDownloadBean.mPackageName = jSONObject.optString("packagename");
            pluginDownloadBean.mVersionCode = jSONObject.optInt("versioncode");
            pluginDownloadBean.mUrl = jSONObject.optString("url");
            pluginDownloadBean.mMd5 = jSONObject.optString(PackageTable.MD5);
            pluginDownloadBean.mOrder = jSONObject.optInt("Order");
            pluginDownloadBean.isOffline = jSONObject.optBoolean("offline");
            pluginDownloadBean.isRevert = jSONObject.optBoolean("revert");
            pluginDownloadBean.isWifiOnly = jSONObject.optBoolean("wifionly", true);
            pluginDownloadBean.mClientVersionMin = jSONObject.optInt("clientversion_min", 0);
            pluginDownloadBean.mClientVersionMax = jSONObject.optInt("clientversion_max", Integer.MAX_VALUE);
            int optInt = jSONObject.optInt("download_type", 0);
            pluginDownloadBean.mDownloadType = optInt != 2 ? optInt : 1;
            if (pluginDownloadBean.mClientVersionMax == 0) {
                pluginDownloadBean.mClientVersionMax = Integer.MAX_VALUE;
            }
            pluginDownloadBean.mBackupUrlList = new LinkedList();
            JSONArray optJSONArray = jSONObject.optJSONArray("backup_urls");
            if (optJSONArray != null && optJSONArray.length() > 0) {
                for (int i2 = 0; i2 < optJSONArray.length(); i2++) {
                    pluginDownloadBean.mBackupUrlList.add(optJSONArray.getString(i2));
                }
            }
            return pluginDownloadBean;
        }
        return (PluginDownloadBean) invokeL.objValue;
    }

    @NonNull
    public static JSONObject a(@NonNull Plugin plugin2) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, plugin2)) == null) {
            JSONObject jSONObject = new JSONObject();
            jSONObject.putOpt("packagename", plugin2.mPkgName);
            jSONObject.putOpt("versioncode", Integer.valueOf(plugin2.getVersion()));
            jSONObject.putOpt("maxversion", Integer.valueOf(plugin2.mMaxVersionCode));
            jSONObject.putOpt("minversion", Integer.valueOf(plugin2.mMinVersionCode));
            return jSONObject;
        }
        return (JSONObject) invokeL.objValue;
    }
}
