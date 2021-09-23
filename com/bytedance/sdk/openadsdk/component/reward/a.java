package com.bytedance.sdk.openadsdk.component.reward;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Build;
import android.os.Environment;
import android.os.SystemClock;
import android.text.TextUtils;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.ActivityChooserModel;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.bytedance.sdk.component.net.NetResponse;
import com.bytedance.sdk.component.net.callback.NetCallback;
import com.bytedance.sdk.component.net.executor.DownloadExecutor;
import com.bytedance.sdk.component.net.executor.NetExecutor;
import com.bytedance.sdk.openadsdk.AdSlot;
import com.bytedance.sdk.openadsdk.CacheDirConstants;
import com.bytedance.sdk.openadsdk.core.e.m;
import com.bytedance.sdk.openadsdk.core.e.x;
import com.bytedance.sdk.openadsdk.core.o;
import com.bytedance.sdk.openadsdk.q.q;
import java.io.File;
import java.io.FileFilter;
import java.io.IOException;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;
/* loaded from: classes9.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    @SuppressLint({"StaticFieldLeak"})

    /* renamed from: a  reason: collision with root package name */
    public static volatile a f66033a;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: b  reason: collision with root package name */
    public final Context f66034b;

    /* renamed from: c  reason: collision with root package name */
    public final i f66035c;

    /* renamed from: d  reason: collision with root package name */
    public Map<m, Long> f66036d;

    /* renamed from: com.bytedance.sdk.openadsdk.component.reward.a$a  reason: collision with other inner class name */
    /* loaded from: classes9.dex */
    public interface InterfaceC1898a<T> {
        void a(boolean z, T t);
    }

    public a(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f66036d = Collections.synchronizedMap(new HashMap());
        Context a2 = context == null ? o.a() : context.getApplicationContext();
        this.f66034b = a2;
        this.f66035c = new i(a2, "sp_full_screen_video");
    }

    private File d(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(AdIconUtil.AD_TEXT_ID, this, str)) == null) ? new File(CacheDirConstants.getRewardFullCacheDir(), str) : (File) invokeL.objValue;
    }

    @Nullable
    public AdSlot b(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str)) == null) ? this.f66035c.e(str) : (AdSlot) invokeL.objValue;
    }

    public m c(String str) {
        InterceptResult invokeL;
        m a2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048586, this, str)) == null) {
            long b2 = this.f66035c.b(str);
            boolean c2 = this.f66035c.c(str);
            if (!(System.currentTimeMillis() - b2 < 10500000) || c2) {
                return null;
            }
            try {
                String a3 = this.f66035c.a(str);
                if (TextUtils.isEmpty(a3) || (a2 = com.bytedance.sdk.openadsdk.core.b.a(new JSONObject(a3))) == null) {
                    return null;
                }
                if (com.bytedance.sdk.openadsdk.core.e.o.j(a2)) {
                    return a2;
                }
                x V = a2.V();
                if (V != null) {
                    if (Build.VERSION.SDK_INT < 23) {
                        if (TextUtils.isEmpty(a(V.i(), V.l()))) {
                            return null;
                        }
                    }
                    return a2;
                }
                return null;
            } catch (Exception unused) {
                return null;
            }
        }
        return (m) invokeL.objValue;
    }

    public void a(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, str) == null) {
            this.f66035c.d(str);
        }
    }

    public void b(AdSlot adSlot) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, adSlot) == null) {
            this.f66035c.b(adSlot);
        }
    }

    public void a() {
        File externalCacheDir;
        File[] listFiles;
        File file;
        File[] listFiles2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            try {
                if (Build.VERSION.SDK_INT >= 24) {
                    file = new File(this.f66034b.getDataDir(), "shared_prefs");
                } else {
                    file = new File(this.f66034b.getDatabasePath("1").getParentFile().getParentFile(), "shared_prefs");
                }
                if (file.exists() && file.isDirectory() && (listFiles2 = file.listFiles(new FileFilter(this) { // from class: com.bytedance.sdk.openadsdk.component.reward.a.1
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    /* renamed from: a  reason: collision with root package name */
                    public final /* synthetic */ a f66037a;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {this};
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i2 = newInitContext.flag;
                            if ((i2 & 1) != 0) {
                                int i3 = i2 & 2;
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.f66037a = this;
                    }

                    @Override // java.io.FileFilter
                    public boolean accept(File file2) {
                        InterceptResult invokeL;
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || (invokeL = interceptable2.invokeL(1048576, this, file2)) == null) {
                            if (file2 != null) {
                                return file2.getName().contains("sp_full_screen_video");
                            }
                            return false;
                        }
                        return invokeL.booleanValue;
                    }
                })) != null) {
                    for (File file2 : listFiles2) {
                        try {
                            String replace = file2.getName().replace(ActivityChooserModel.HISTORY_FILE_EXTENSION, "");
                            if (Build.VERSION.SDK_INT >= 24) {
                                this.f66034b.deleteSharedPreferences(replace);
                            } else {
                                this.f66034b.getSharedPreferences(replace, 0).edit().clear().apply();
                                com.bytedance.sdk.component.utils.f.c(file2);
                            }
                        } catch (Throwable unused) {
                        }
                    }
                }
            } catch (Throwable unused2) {
            }
            try {
                if (("mounted".equals(Environment.getExternalStorageState()) || !Environment.isExternalStorageRemovable()) && this.f66034b.getExternalCacheDir() != null) {
                    externalCacheDir = this.f66034b.getExternalCacheDir();
                } else {
                    externalCacheDir = this.f66034b.getCacheDir();
                }
                if (externalCacheDir == null || !externalCacheDir.exists() || !externalCacheDir.isDirectory() || (listFiles = externalCacheDir.listFiles(new FileFilter(this) { // from class: com.bytedance.sdk.openadsdk.component.reward.a.2
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    /* renamed from: a  reason: collision with root package name */
                    public final /* synthetic */ a f66038a;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {this};
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i2 = newInitContext.flag;
                            if ((i2 & 1) != 0) {
                                int i3 = i2 & 2;
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.f66038a = this;
                    }

                    @Override // java.io.FileFilter
                    public boolean accept(File file3) {
                        InterceptResult invokeL;
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || (invokeL = interceptable2.invokeL(1048576, this, file3)) == null) {
                            if (file3 != null) {
                                return file3.getName().contains("full_screen_video_cache");
                            }
                            return false;
                        }
                        return invokeL.booleanValue;
                    }
                })) == null || listFiles.length <= 0) {
                    return;
                }
                for (File file3 : listFiles) {
                    try {
                        com.bytedance.sdk.component.utils.f.c(file3);
                    } catch (Throwable unused3) {
                    }
                }
            } catch (Throwable unused4) {
            }
        }
    }

    @Nullable
    public AdSlot b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.f66035c.a() : (AdSlot) invokeV.objValue;
    }

    public void a(AdSlot adSlot, m mVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048580, this, adSlot, mVar) == null) {
            a(adSlot);
            if (mVar != null) {
                try {
                    this.f66035c.a(adSlot.getCodeId(), mVar.aP().toString());
                } catch (Throwable unused) {
                }
            }
        }
    }

    public void a(AdSlot adSlot) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, adSlot) == null) {
            this.f66035c.a(adSlot);
        }
    }

    public static a a(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, context)) == null) {
            if (f66033a == null) {
                synchronized (a.class) {
                    if (f66033a == null) {
                        f66033a = new a(context);
                    }
                }
            }
            return f66033a;
        }
        return (a) invokeL.objValue;
    }

    public String a(m mVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, mVar)) == null) {
            if (mVar == null || mVar.V() == null || TextUtils.isEmpty(mVar.V().i())) {
                return null;
            }
            return a(mVar.V().i(), mVar.V().l());
        }
        return (String) invokeL.objValue;
    }

    public String a(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, str2)) == null) {
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            if (TextUtils.isEmpty(str2)) {
                str2 = com.bytedance.sdk.component.utils.e.a(str);
            }
            File d2 = d(str2);
            if (d2 == null || !d2.exists() || !d2.isFile() || d2.length() <= 0) {
                return null;
            }
            return d2.getAbsolutePath();
        }
        return (String) invokeLL.objValue;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(boolean z, m mVar, long j2, @Nullable String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(InputDeviceCompat.SOURCE_TRACKBALL, this, new Object[]{Boolean.valueOf(z), mVar, Long.valueOf(j2), str}) == null) {
            Long remove = this.f66036d.remove(mVar);
            com.bytedance.sdk.openadsdk.e.d.e(this.f66034b, mVar, "fullscreen_interstitial_ad", z ? "load_video_success" : "load_video_error", q.a(z, mVar, remove == null ? 0L : SystemClock.elapsedRealtime() - remove.longValue(), j2, (z || str == null) ? null : str));
        }
    }

    public void a(m mVar, InterfaceC1898a<Object> interfaceC1898a) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048581, this, mVar, interfaceC1898a) == null) {
            this.f66036d.put(mVar, Long.valueOf(SystemClock.elapsedRealtime()));
            if (mVar != null && mVar.V() != null && !TextUtils.isEmpty(mVar.V().i())) {
                String i2 = mVar.V().i();
                File d2 = d(mVar.V().l());
                DownloadExecutor downloadExecutor = com.bytedance.sdk.openadsdk.k.d.b().c().getDownloadExecutor();
                downloadExecutor.setUrl(i2);
                downloadExecutor.setFileInfo(d2.getParent(), d2.getName());
                downloadExecutor.enqueue(new NetCallback(this, interfaceC1898a, mVar) { // from class: com.bytedance.sdk.openadsdk.component.reward.a.3
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    /* renamed from: a  reason: collision with root package name */
                    public final /* synthetic */ InterfaceC1898a f66039a;

                    /* renamed from: b  reason: collision with root package name */
                    public final /* synthetic */ m f66040b;

                    /* renamed from: c  reason: collision with root package name */
                    public final /* synthetic */ a f66041c;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {this, interfaceC1898a, mVar};
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i3 = newInitContext.flag;
                            if ((i3 & 1) != 0) {
                                int i4 = i3 & 2;
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.f66041c = this;
                        this.f66039a = interfaceC1898a;
                        this.f66040b = mVar;
                    }

                    @Override // com.bytedance.sdk.component.net.callback.NetCallback
                    public void onFailure(NetExecutor netExecutor, IOException iOException) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeLL(1048576, this, netExecutor, iOException) == null) {
                            InterfaceC1898a interfaceC1898a2 = this.f66039a;
                            if (interfaceC1898a2 != null) {
                                interfaceC1898a2.a(false, null);
                            }
                            com.bytedance.sdk.component.utils.k.c("FullScreenVideoCache", "onFailure: FullScreenVideo preload fail ");
                            this.f66041c.a(false, this.f66040b, -2L, iOException.getMessage());
                        }
                    }

                    @Override // com.bytedance.sdk.component.net.callback.NetCallback
                    public void onResponse(NetExecutor netExecutor, NetResponse netResponse) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, netExecutor, netResponse) == null) {
                            if (netResponse.isSuccess() && netResponse.getFile() != null && netResponse.getFile().exists()) {
                                InterfaceC1898a interfaceC1898a2 = this.f66039a;
                                if (interfaceC1898a2 != null) {
                                    interfaceC1898a2.a(true, null);
                                }
                                com.bytedance.sdk.component.utils.k.c("FullScreenVideoCache", "onResponse: FullScreenVideo preload success ");
                                this.f66041c.a(true, this.f66040b, netResponse.getCode(), netResponse.getMessage());
                                return;
                            }
                            InterfaceC1898a interfaceC1898a3 = this.f66039a;
                            if (interfaceC1898a3 != null) {
                                interfaceC1898a3.a(false, null);
                            }
                            com.bytedance.sdk.component.utils.k.c("FullScreenVideoCache", "onResponse: FullScreenVideo preload Fail ");
                            this.f66041c.a(false, this.f66040b, netResponse.getCode(), netResponse.getMessage());
                        }
                    }
                });
                return;
            }
            if (interfaceC1898a != null) {
                interfaceC1898a.a(false, null);
            }
            a(false, mVar, -1L, "meta == null or  meta.getVideo() == null ");
        }
    }

    public static void a(Context context, boolean z, m mVar, long j2, long j3, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65538, null, new Object[]{context, Boolean.valueOf(z), mVar, Long.valueOf(j2), Long.valueOf(j3), str}) == null) {
            com.bytedance.sdk.openadsdk.e.d.e(context, mVar, "fullscreen_interstitial_ad", z ? "load_video_success" : "load_video_error", q.a(z, mVar, j3, j2, str));
        }
    }
}
