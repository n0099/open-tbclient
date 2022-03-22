package com.bytedance.pangle.download;

import android.content.pm.PackageInfo;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobstat.Config;
import com.baidu.pass.main.facesdk.utils.PreferencesUtil;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.webkit.sdk.dumper.ZeusCrashHandler;
import com.bytedance.pangle.Zeus;
import com.bytedance.pangle.b.b;
import com.bytedance.pangle.helper.PluginDirHelper;
import com.bytedance.pangle.log.ZeusLogger;
import com.bytedance.pangle.plugin.Plugin;
import com.bytedance.pangle.plugin.PluginManager;
import com.ss.android.socialbase.downloader.depend.AbsDownloadListener;
import com.ss.android.socialbase.downloader.depend.IDownloadInterceptor;
import com.ss.android.socialbase.downloader.exception.BaseException;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import java.io.File;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class e {
    public static /* synthetic */ Interceptable $ic;
    public static volatile e a;
    public transient /* synthetic */ FieldHolder $fh;

    public e() {
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

    public static boolean b(@NonNull String str, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65544, null, str, i)) == null) {
            try {
                for (File file : new File(PluginDirHelper.getDownloadDir()).listFiles()) {
                    if (file.getName().contains(str)) {
                        PackageInfo packageInfo = Zeus.getAppApplication().getPackageManager().getPackageInfo(Zeus.getAppApplication().getPackageName(), 0);
                        if (TextUtils.equals(packageInfo.packageName, str) && packageInfo.versionCode == i) {
                            return true;
                        }
                    }
                }
            } catch (Exception e2) {
                ZeusLogger.e(ZeusLogger.TAG_DOWNLOAD, "isPluginDownloaded failed.", e2);
            }
            return false;
        }
        return invokeLI.booleanValue;
    }

    public static e a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
            if (a == null) {
                synchronized (e.class) {
                    if (a == null) {
                        a = new e();
                    }
                }
            }
            return a;
        }
        return (e) invokeV.objValue;
    }

    public final void a(@NonNull String str, @NonNull String str2, int i, @NonNull String str3, boolean z, @NonNull List<String> list, int i2, @Nullable ZeusPluginListener zeusPluginListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{str, str2, Integer.valueOf(i), str3, Boolean.valueOf(z), list, Integer.valueOf(i2), zeusPluginListener}) == null) {
            com.ss.android.socialbase.downloader.downloader.b.with(Zeus.getAppApplication()).url(str).name(String.format("%s_%s_%s.jar", i2 == 1 ? Config.STAT_SDK_CHANNEL : i2 == 0 ? "auto" : "", str2, str3)).onlyWifi(z).savePath(PluginDirHelper.getDownloadDir()).retryCount(5).mimeType("mime_type_plugin").backUpUrls(list).subThreadListener(new AbsDownloadListener(this, zeusPluginListener, str2, i, i2, str3) { // from class: com.bytedance.pangle.download.e.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ ZeusPluginListener a;

                /* renamed from: b  reason: collision with root package name */
                public final /* synthetic */ String f38079b;

                /* renamed from: c  reason: collision with root package name */
                public final /* synthetic */ int f38080c;

                /* renamed from: d  reason: collision with root package name */
                public final /* synthetic */ int f38081d;

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ String f38082e;

                /* renamed from: f  reason: collision with root package name */
                public final /* synthetic */ boolean f38083f;

                /* renamed from: g  reason: collision with root package name */
                public final /* synthetic */ e f38084g;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, zeusPluginListener, str2, Integer.valueOf(i), Integer.valueOf(i2), str3};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i3 = newInitContext.flag;
                        if ((i3 & 1) != 0) {
                            int i4 = i3 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.f38084g = this;
                    this.a = zeusPluginListener;
                    this.f38079b = str2;
                    this.f38080c = i;
                    this.f38081d = i2;
                    this.f38082e = str3;
                    this.f38083f = true;
                }

                @Override // com.ss.android.socialbase.downloader.depend.AbsDownloadListener, com.ss.android.socialbase.downloader.depend.IDownloadListener
                public final void onFailed(DownloadInfo downloadInfo, BaseException baseException) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeLL(1048576, this, downloadInfo, baseException) == null) {
                        ZeusLogger.e(ZeusLogger.TAG_DOWNLOAD, "download onFailed : " + this.f38079b + ZeusCrashHandler.NAME_SEPERATOR + this.f38080c, baseException);
                        e.a(com.bytedance.pangle.b.b.f38019d, e.a(baseException), this.f38079b, this.f38080c, -1L, baseException);
                        ZeusPluginListener zeusPluginListener2 = this.a;
                        if (zeusPluginListener2 != null) {
                            zeusPluginListener2.onEvent(13, "download failed," + baseException.getErrorMessage());
                        }
                    }
                }

                @Override // com.ss.android.socialbase.downloader.depend.AbsDownloadListener, com.ss.android.socialbase.downloader.depend.IDownloadListener
                public final void onProgress(DownloadInfo downloadInfo) {
                    ZeusPluginListener zeusPluginListener2;
                    Interceptable interceptable2 = $ic;
                    if (!(interceptable2 == null || interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, downloadInfo) == null) || (zeusPluginListener2 = this.a) == null) {
                        return;
                    }
                    zeusPluginListener2.onEvent(11, ((((float) downloadInfo.getCurBytes()) * 1.0f) / ((float) downloadInfo.getTotalBytes())) + "%");
                }

                @Override // com.ss.android.socialbase.downloader.depend.AbsDownloadListener, com.ss.android.socialbase.downloader.depend.IDownloadListener
                public final void onStart(DownloadInfo downloadInfo) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(Constants.METHOD_SEND_USER_MSG, this, downloadInfo) == null) {
                        ZeusLogger.d(ZeusLogger.TAG_DOWNLOAD, "download start : " + this.f38079b + ZeusCrashHandler.NAME_SEPERATOR + this.f38080c);
                        e.a(com.bytedance.pangle.b.b.f38018c, b.a.f38026d, this.f38079b, this.f38080c, -1L, null);
                        ZeusPluginListener zeusPluginListener2 = this.a;
                        if (zeusPluginListener2 != null) {
                            zeusPluginListener2.onEvent(10, "start download " + this.f38079b);
                        }
                    }
                }

                @Override // com.ss.android.socialbase.downloader.depend.AbsDownloadListener, com.ss.android.socialbase.downloader.depend.IDownloadListener
                public final void onSuccessed(DownloadInfo downloadInfo) {
                    Interceptable interceptable2 = $ic;
                    if (!(interceptable2 == null || interceptable2.invokeL(1048579, this, downloadInfo) == null) || downloadInfo == null) {
                        return;
                    }
                    ZeusLogger.d(ZeusLogger.TAG_DOWNLOAD, "download onSuccessed : " + this.f38079b + ZeusCrashHandler.NAME_SEPERATOR + this.f38080c);
                    e.a(this.f38081d, downloadInfo, this.f38082e, this.f38079b, this.f38080c, this.f38083f, this.a);
                }
            }).interceptor(new IDownloadInterceptor(this, str2, i, zeusPluginListener) { // from class: com.bytedance.pangle.download.e.2
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ String a;

                /* renamed from: b  reason: collision with root package name */
                public final /* synthetic */ int f38085b;

                /* renamed from: c  reason: collision with root package name */
                public final /* synthetic */ ZeusPluginListener f38086c;

                /* renamed from: d  reason: collision with root package name */
                public final /* synthetic */ e f38087d;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, str2, Integer.valueOf(i), zeusPluginListener};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i3 = newInitContext.flag;
                        if ((i3 & 1) != 0) {
                            int i4 = i3 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.f38087d = this;
                    this.a = str2;
                    this.f38085b = i;
                    this.f38086c = zeusPluginListener;
                }

                @Override // com.ss.android.socialbase.downloader.depend.IDownloadInterceptor
                public final boolean intercepte() {
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeV = interceptable2.invokeV(1048576, this)) == null) {
                        int a2 = e.a(this.a);
                        int i3 = this.f38085b;
                        if (i3 <= a2 || e.b(this.a, i3)) {
                            ZeusLogger.i(ZeusLogger.TAG_DOWNLOAD, "download intercept : " + this.a + ZeusCrashHandler.NAME_SEPERATOR + this.f38085b);
                            ZeusPluginListener zeusPluginListener2 = this.f38086c;
                            if (zeusPluginListener2 != null) {
                                zeusPluginListener2.onEvent(13, this.f38085b <= a2 ? "EVENT_INTERCEPT_ALREADY_INSTALL" : "EVENT_INTERCEPT_DOWNLOAD_FILE_EXISTS");
                                return true;
                            }
                            return true;
                        }
                        return false;
                    }
                    return invokeV.booleanValue;
                }
            }).download();
        }
    }

    public static void a(String str, int i, String str2, int i2, long j, Throwable th) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65541, null, new Object[]{str, Integer.valueOf(i), str2, Integer.valueOf(i2), Long.valueOf(j), th}) == null) {
            JSONObject jSONObject = new JSONObject();
            JSONObject jSONObject2 = new JSONObject();
            JSONObject jSONObject3 = new JSONObject();
            try {
                jSONObject.putOpt("status_code", com.bytedance.pangle.log.d.a(Integer.valueOf(i)));
                jSONObject.putOpt("plugin_package_name", com.bytedance.pangle.log.d.a(str2));
                jSONObject.putOpt("version_code", com.bytedance.pangle.log.d.a(Integer.valueOf(i2)));
                jSONObject2.putOpt("duration", com.bytedance.pangle.log.d.a(Long.valueOf(j)));
                jSONObject3.putOpt("throwable", com.bytedance.pangle.log.d.a(th));
                jSONObject3.putOpt("timestamp", com.bytedance.pangle.log.d.a(Long.valueOf(System.currentTimeMillis())));
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
            com.bytedance.pangle.b.b.a().a(str, jSONObject, jSONObject2, jSONObject3);
        }
    }

    public static /* synthetic */ void a(int i, DownloadInfo downloadInfo, String str, String str2, int i2, boolean z, ZeusPluginListener zeusPluginListener) {
        String str3;
        int i3;
        File file = new File(downloadInfo.getSavePath(), downloadInfo.getName());
        String a2 = com.bytedance.pangle.util.c.a(file);
        boolean z2 = !TextUtils.isEmpty(a2) && a2.equals(str);
        boolean a3 = com.bytedance.pangle.helper.b.a(file);
        if (z2 && a3) {
            a(com.bytedance.pangle.b.b.f38019d, b.a.f38027e, str2, i2, downloadInfo.getDownloadTime(), null);
            if (i == 0 || i == 1) {
                if (zeusPluginListener != null) {
                    zeusPluginListener.onEvent(12, "download success, ".concat(String.valueOf(str2)));
                }
                if (z) {
                    if (zeusPluginListener != null) {
                        zeusPluginListener.onEvent(20, "start install ".concat(String.valueOf(str2)));
                    }
                    PluginManager.getInstance().asyncInstall(file, zeusPluginListener);
                    return;
                }
                return;
            }
            return;
        }
        if (a3) {
            str3 = "Check md5 failed. " + a2 + " != " + str;
            i3 = b.a.i;
        } else {
            str3 = "PluginAbi not match hostAbi[" + com.bytedance.pangle.helper.b.a() + "] md5[" + str + PreferencesUtil.RIGHT_MOUNT;
            i3 = b.a.j;
        }
        a(com.bytedance.pangle.b.b.f38019d, i3, str2, i2, downloadInfo.getDownloadTime(), new RuntimeException(str3));
        file.delete();
        if (zeusPluginListener != null) {
            zeusPluginListener.onEvent(13, str3);
        }
    }

    public static /* synthetic */ int a(BaseException baseException) {
        int i = b.a.f38030h;
        return baseException != null ? (i - 1000) + 100 + baseException.getErrorCode() : i;
    }

    public static /* synthetic */ int a(String str) {
        Plugin plugin2 = Zeus.getPlugin(str);
        if (plugin2 != null) {
            return plugin2.getVersion();
        }
        return 0;
    }
}
