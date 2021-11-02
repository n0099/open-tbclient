package com.bytedance.pangle.download;

import android.content.pm.PackageInfo;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.util.AdIconUtil;
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
import kotlinx.coroutines.DebugKt;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes11.dex */
public class f {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static volatile f f61333a;
    public transient /* synthetic */ FieldHolder $fh;

    public f() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    public static boolean b(@NonNull String str, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65544, null, str, i2)) == null) {
            try {
                for (File file : new File(PluginDirHelper.getDownloadDir()).listFiles()) {
                    if (file.getName().contains(str)) {
                        PackageInfo packageInfo = Zeus.getAppApplication().getPackageManager().getPackageInfo(Zeus.getAppApplication().getPackageName(), 0);
                        if (TextUtils.equals(packageInfo.packageName, str) && packageInfo.versionCode == i2) {
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

    public static f a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
            if (f61333a == null) {
                synchronized (f.class) {
                    if (f61333a == null) {
                        f61333a = new f();
                    }
                }
            }
            return f61333a;
        }
        return (f) invokeV.objValue;
    }

    public final void a(@NonNull String str, @NonNull String str2, int i2, @NonNull String str3, boolean z, @NonNull List<String> list, int i3, @Nullable ZeusPluginListener zeusPluginListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{str, str2, Integer.valueOf(i2), str3, Boolean.valueOf(z), list, Integer.valueOf(i3), zeusPluginListener}) == null) {
            com.ss.android.socialbase.downloader.downloader.b.with(Zeus.getAppApplication()).url(str).name(String.format("%s_%s_%s.jar", i3 == 1 ? "sc" : i3 == 0 ? DebugKt.DEBUG_PROPERTY_VALUE_AUTO : "", str2, str3)).onlyWifi(z).savePath(PluginDirHelper.getDownloadDir()).retryCount(5).mimeType("mime_type_plugin").backUpUrls(list).subThreadListener(new AbsDownloadListener(this, zeusPluginListener, str2, i2, i3, str3) { // from class: com.bytedance.pangle.download.f.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ ZeusPluginListener f61334a;

                /* renamed from: b  reason: collision with root package name */
                public final /* synthetic */ String f61335b;

                /* renamed from: c  reason: collision with root package name */
                public final /* synthetic */ int f61336c;

                /* renamed from: d  reason: collision with root package name */
                public final /* synthetic */ int f61337d;

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ String f61338e;

                /* renamed from: f  reason: collision with root package name */
                public final /* synthetic */ boolean f61339f;

                /* renamed from: g  reason: collision with root package name */
                public final /* synthetic */ f f61340g;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, zeusPluginListener, str2, Integer.valueOf(i2), Integer.valueOf(i3), str3};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i4 = newInitContext.flag;
                        if ((i4 & 1) != 0) {
                            int i5 = i4 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.f61340g = this;
                    this.f61334a = zeusPluginListener;
                    this.f61335b = str2;
                    this.f61336c = i2;
                    this.f61337d = i3;
                    this.f61338e = str3;
                    this.f61339f = true;
                }

                @Override // com.ss.android.socialbase.downloader.depend.AbsDownloadListener, com.ss.android.socialbase.downloader.depend.IDownloadListener
                public final void onFailed(DownloadInfo downloadInfo, BaseException baseException) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeLL(1048576, this, downloadInfo, baseException) == null) {
                        ZeusLogger.e(ZeusLogger.TAG_DOWNLOAD, "download onFailed : " + this.f61335b + ZeusCrashHandler.NAME_SEPERATOR + this.f61336c, baseException);
                        f.a(com.bytedance.pangle.b.b.f61246d, f.a(baseException), this.f61335b, this.f61336c, -1L, baseException);
                        ZeusPluginListener zeusPluginListener2 = this.f61334a;
                        if (zeusPluginListener2 != null) {
                            zeusPluginListener2.onEvent(13, "download failed," + baseException.getErrorMessage());
                        }
                    }
                }

                @Override // com.ss.android.socialbase.downloader.depend.AbsDownloadListener, com.ss.android.socialbase.downloader.depend.IDownloadListener
                public final void onProgress(DownloadInfo downloadInfo) {
                    ZeusPluginListener zeusPluginListener2;
                    Interceptable interceptable2 = $ic;
                    if (!(interceptable2 == null || interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, downloadInfo) == null) || (zeusPluginListener2 = this.f61334a) == null) {
                        return;
                    }
                    zeusPluginListener2.onEvent(11, ((((float) downloadInfo.getCurBytes()) * 1.0f) / ((float) downloadInfo.getTotalBytes())) + "%");
                }

                @Override // com.ss.android.socialbase.downloader.depend.AbsDownloadListener, com.ss.android.socialbase.downloader.depend.IDownloadListener
                public final void onStart(DownloadInfo downloadInfo) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(Constants.METHOD_SEND_USER_MSG, this, downloadInfo) == null) {
                        ZeusLogger.d(ZeusLogger.TAG_DOWNLOAD, "download start : " + this.f61335b + ZeusCrashHandler.NAME_SEPERATOR + this.f61336c);
                        f.a(com.bytedance.pangle.b.b.f61245c, b.a.f61256d, this.f61335b, this.f61336c, -1L, null);
                        ZeusPluginListener zeusPluginListener2 = this.f61334a;
                        if (zeusPluginListener2 != null) {
                            zeusPluginListener2.onEvent(10, "start download " + this.f61335b);
                        }
                    }
                }

                @Override // com.ss.android.socialbase.downloader.depend.AbsDownloadListener, com.ss.android.socialbase.downloader.depend.IDownloadListener
                public final void onSuccessed(DownloadInfo downloadInfo) {
                    Interceptable interceptable2 = $ic;
                    if (!(interceptable2 == null || interceptable2.invokeL(1048579, this, downloadInfo) == null) || downloadInfo == null) {
                        return;
                    }
                    ZeusLogger.d(ZeusLogger.TAG_DOWNLOAD, "download onSuccessed : " + this.f61335b + ZeusCrashHandler.NAME_SEPERATOR + this.f61336c);
                    f.a(this.f61337d, downloadInfo, this.f61338e, this.f61335b, this.f61336c, this.f61339f, this.f61334a);
                }
            }).interceptor(new IDownloadInterceptor(this, str2, i2, zeusPluginListener) { // from class: com.bytedance.pangle.download.f.2
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ String f61341a;

                /* renamed from: b  reason: collision with root package name */
                public final /* synthetic */ int f61342b;

                /* renamed from: c  reason: collision with root package name */
                public final /* synthetic */ ZeusPluginListener f61343c;

                /* renamed from: d  reason: collision with root package name */
                public final /* synthetic */ f f61344d;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, str2, Integer.valueOf(i2), zeusPluginListener};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i4 = newInitContext.flag;
                        if ((i4 & 1) != 0) {
                            int i5 = i4 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.f61344d = this;
                    this.f61341a = str2;
                    this.f61342b = i2;
                    this.f61343c = zeusPluginListener;
                }

                @Override // com.ss.android.socialbase.downloader.depend.IDownloadInterceptor
                public final boolean intercepte() {
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeV = interceptable2.invokeV(1048576, this)) == null) {
                        int a2 = f.a(this.f61341a);
                        int i4 = this.f61342b;
                        if (i4 <= a2 || f.b(this.f61341a, i4)) {
                            ZeusLogger.i(ZeusLogger.TAG_DOWNLOAD, "download intercept : " + this.f61341a + ZeusCrashHandler.NAME_SEPERATOR + this.f61342b);
                            ZeusPluginListener zeusPluginListener2 = this.f61343c;
                            if (zeusPluginListener2 != null) {
                                zeusPluginListener2.onEvent(13, this.f61342b <= a2 ? "EVENT_INTERCEPT_ALREADY_INSTALL" : "EVENT_INTERCEPT_DOWNLOAD_FILE_EXISTS");
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

    public static void a(String str, int i2, String str2, int i3, long j, Throwable th) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(AdIconUtil.AD_TEXT_ID, null, new Object[]{str, Integer.valueOf(i2), str2, Integer.valueOf(i3), Long.valueOf(j), th}) == null) {
            JSONObject jSONObject = new JSONObject();
            JSONObject jSONObject2 = new JSONObject();
            JSONObject jSONObject3 = new JSONObject();
            try {
                jSONObject.putOpt("status_code", com.bytedance.pangle.log.d.a(Integer.valueOf(i2)));
                jSONObject.putOpt("plugin_package_name", com.bytedance.pangle.log.d.a(str2));
                jSONObject.putOpt("version_code", com.bytedance.pangle.log.d.a(Integer.valueOf(i3)));
                jSONObject2.putOpt("duration", com.bytedance.pangle.log.d.a(Long.valueOf(j)));
                jSONObject3.putOpt("throwable", com.bytedance.pangle.log.d.a(th));
                jSONObject3.putOpt("timestamp", com.bytedance.pangle.log.d.a(Long.valueOf(System.currentTimeMillis())));
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
            com.bytedance.pangle.b.b.a().a(str, jSONObject, jSONObject2, jSONObject3);
        }
    }

    public static /* synthetic */ void a(int i2, DownloadInfo downloadInfo, String str, String str2, int i3, boolean z, ZeusPluginListener zeusPluginListener) {
        String str3;
        int i4;
        File file = new File(downloadInfo.getSavePath(), downloadInfo.getName());
        String a2 = com.bytedance.pangle.util.d.a(file);
        boolean z2 = !TextUtils.isEmpty(a2) && a2.equals(str);
        boolean a3 = com.bytedance.pangle.helper.b.a(file);
        if (z2 && a3) {
            a(com.bytedance.pangle.b.b.f61246d, b.a.f61257e, str2, i3, downloadInfo.getDownloadTime(), null);
            if (i2 == 0 || i2 == 1) {
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
            i4 = b.a.f61261i;
        } else {
            str3 = "PluginAbi not match hostAbi[" + com.bytedance.pangle.helper.b.a() + "] md5[" + str + PreferencesUtil.RIGHT_MOUNT;
            i4 = b.a.j;
        }
        a(com.bytedance.pangle.b.b.f61246d, i4, str2, i3, downloadInfo.getDownloadTime(), new RuntimeException(str3));
        file.delete();
        if (zeusPluginListener != null) {
            zeusPluginListener.onEvent(13, str3);
        }
    }

    public static /* synthetic */ int a(BaseException baseException) {
        int i2 = b.a.f61260h;
        return baseException != null ? (i2 - 1000) + 100 + baseException.getErrorCode() : i2;
    }

    public static /* synthetic */ int a(String str) {
        Plugin plugin2 = Zeus.getPlugin(str);
        if (plugin2 != null) {
            return plugin2.getVersion();
        }
        return 0;
    }
}
