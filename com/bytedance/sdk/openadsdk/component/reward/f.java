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
import com.bytedance.sdk.component.adnet.b.b;
import com.bytedance.sdk.component.adnet.err.VAdError;
import com.bytedance.sdk.openadsdk.AdSlot;
import com.bytedance.sdk.openadsdk.CacheDirConstants;
import com.bytedance.sdk.openadsdk.core.e.m;
import com.bytedance.sdk.openadsdk.core.e.x;
import com.bytedance.sdk.openadsdk.core.o;
import java.io.File;
import java.io.FileFilter;
import java.io.IOException;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class f {
    public static /* synthetic */ Interceptable $ic;
    @SuppressLint({"StaticFieldLeak"})

    /* renamed from: a  reason: collision with root package name */
    public static volatile f f29503a;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: b  reason: collision with root package name */
    public final Context f29504b;

    /* renamed from: c  reason: collision with root package name */
    public final i f29505c;

    /* renamed from: d  reason: collision with root package name */
    public Map<m, Long> f29506d;

    /* loaded from: classes5.dex */
    public interface a<T> {
        void a(boolean z, T t);
    }

    public f(Context context) {
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
        this.f29506d = Collections.synchronizedMap(new HashMap());
        Context a2 = context == null ? o.a() : context.getApplicationContext();
        this.f29504b = a2;
        this.f29505c = new i(a2, "sp_reward_video");
    }

    private File d(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65543, this, str)) == null) ? new File(CacheDirConstants.getRewardFullCacheDir(), str) : (File) invokeL.objValue;
    }

    @Nullable
    public AdSlot b(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str)) == null) ? this.f29505c.e(str) : (AdSlot) invokeL.objValue;
    }

    public m c(String str) {
        InterceptResult invokeL;
        m a2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048586, this, str)) == null) {
            long b2 = this.f29505c.b(str);
            boolean c2 = this.f29505c.c(str);
            if (!(System.currentTimeMillis() - b2 < 10500000) || c2) {
                return null;
            }
            try {
                String a3 = this.f29505c.a(str);
                if (TextUtils.isEmpty(a3) || (a2 = com.bytedance.sdk.openadsdk.core.b.a(new JSONObject(a3))) == null) {
                    return null;
                }
                if (com.bytedance.sdk.openadsdk.core.e.o.j(a2)) {
                    return a2;
                }
                x V = a2.V();
                if (V != null) {
                    if (Build.VERSION.SDK_INT < 23) {
                        if (TextUtils.isEmpty(a(V.i(), V.l(), str))) {
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

    public void b(AdSlot adSlot) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, adSlot) == null) {
            this.f29505c.b(adSlot);
        }
    }

    public void a(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, str) == null) {
            this.f29505c.d(str);
        }
    }

    @Nullable
    public AdSlot b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.f29505c.a() : (AdSlot) invokeV.objValue;
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
                    file = new File(this.f29504b.getDataDir(), "shared_prefs");
                } else {
                    file = new File(this.f29504b.getDatabasePath("1").getParentFile().getParentFile(), "shared_prefs");
                }
                if (file.exists() && file.isDirectory() && (listFiles2 = file.listFiles(new FileFilter(this) { // from class: com.bytedance.sdk.openadsdk.component.reward.f.1
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    /* renamed from: a  reason: collision with root package name */
                    public final /* synthetic */ f f29507a;

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
                        this.f29507a = this;
                    }

                    @Override // java.io.FileFilter
                    public boolean accept(File file2) {
                        InterceptResult invokeL;
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || (invokeL = interceptable2.invokeL(1048576, this, file2)) == null) {
                            if (file2 != null) {
                                return file2.getName().contains("sp_reward_video");
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
                                this.f29504b.deleteSharedPreferences(replace);
                            } else {
                                this.f29504b.getSharedPreferences(replace, 0).edit().clear().apply();
                                com.bytedance.sdk.component.utils.f.c(file2);
                            }
                        } catch (Throwable unused) {
                        }
                    }
                }
            } catch (Throwable unused2) {
            }
            try {
                if (("mounted".equals(Environment.getExternalStorageState()) || !Environment.isExternalStorageRemovable()) && this.f29504b.getExternalCacheDir() != null) {
                    externalCacheDir = this.f29504b.getExternalCacheDir();
                } else {
                    externalCacheDir = this.f29504b.getCacheDir();
                }
                if (externalCacheDir == null || !externalCacheDir.exists() || !externalCacheDir.isDirectory() || (listFiles = externalCacheDir.listFiles(new FileFilter(this) { // from class: com.bytedance.sdk.openadsdk.component.reward.f.2
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    /* renamed from: a  reason: collision with root package name */
                    public final /* synthetic */ f f29508a;

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
                        this.f29508a = this;
                    }

                    @Override // java.io.FileFilter
                    public boolean accept(File file3) {
                        InterceptResult invokeL;
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || (invokeL = interceptable2.invokeL(1048576, this, file3)) == null) {
                            if (file3 != null) {
                                return file3.getName().contains("reward_video_cache");
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

    public void a(AdSlot adSlot, m mVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048580, this, adSlot, mVar) == null) {
            a(adSlot);
            if (mVar != null) {
                try {
                    this.f29505c.a(adSlot.getCodeId(), mVar.aO().toString());
                } catch (Throwable unused) {
                }
            }
        }
    }

    public void a(AdSlot adSlot) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, adSlot) == null) {
            this.f29505c.a(adSlot);
        }
    }

    public static f a(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, context)) == null) {
            if (f29503a == null) {
                synchronized (f.class) {
                    if (f29503a == null) {
                        f29503a = new f(context);
                    }
                }
            }
            return f29503a;
        }
        return (f) invokeL.objValue;
    }

    public String a(m mVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, mVar)) == null) {
            if (mVar == null || mVar.V() == null || TextUtils.isEmpty(mVar.V().i())) {
                return null;
            }
            return a(mVar.V().i(), mVar.V().l(), String.valueOf(com.bytedance.sdk.openadsdk.r.o.d(mVar.ao())));
        }
        return (String) invokeL.objValue;
    }

    public String a(String str, String str2, String str3) {
        InterceptResult invokeLLL;
        File d2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, str2, str3)) == null) {
            if (!TextUtils.isEmpty(str) && (d2 = d(str2)) != null && d2.exists() && d2.isFile() && d2.length() > 0) {
                return d2.getAbsolutePath();
            }
            return null;
        }
        return (String) invokeLLL.objValue;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(boolean z, m mVar, long j, @Nullable com.bytedance.sdk.component.adnet.core.m mVar2) {
        VAdError vAdError;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(AdIconUtil.BAIDU_LOGO_ID, this, new Object[]{Boolean.valueOf(z), mVar, Long.valueOf(j), mVar2}) == null) {
            Long remove = this.f29506d.remove(mVar);
            com.bytedance.sdk.openadsdk.e.d.f(this.f29504b, mVar, "rewarded_video", z ? "load_video_success" : "load_video_error", com.bytedance.sdk.openadsdk.r.o.a(z, mVar, remove == null ? 0L : SystemClock.elapsedRealtime() - remove.longValue(), j, (z || mVar2 == null || (vAdError = mVar2.f28033c) == null) ? null : vAdError.getMessage()));
        }
    }

    public void a(m mVar, a<Object> aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048581, this, mVar, aVar) == null) {
            this.f29506d.put(mVar, Long.valueOf(SystemClock.elapsedRealtime()));
            if (mVar != null && mVar.V() != null && !TextUtils.isEmpty(mVar.V().i())) {
                String i2 = mVar.V().i();
                File d2 = d(mVar.V().l());
                com.bytedance.sdk.component.utils.j.b("splashLoadAd", "RewardVideoCache downloadVideo target.getPath() " + d2.getPath());
                com.bytedance.sdk.openadsdk.l.e.b().a(i2, new b.a(this, d2, aVar, mVar) { // from class: com.bytedance.sdk.openadsdk.component.reward.f.3
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    /* renamed from: a  reason: collision with root package name */
                    public final /* synthetic */ File f29509a;

                    /* renamed from: b  reason: collision with root package name */
                    public final /* synthetic */ a f29510b;

                    /* renamed from: c  reason: collision with root package name */
                    public final /* synthetic */ m f29511c;

                    /* renamed from: d  reason: collision with root package name */
                    public final /* synthetic */ f f29512d;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {this, d2, aVar, mVar};
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i3 = newInitContext.flag;
                            if ((i3 & 1) != 0) {
                                int i4 = i3 & 2;
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.f29512d = this;
                        this.f29509a = d2;
                        this.f29510b = aVar;
                        this.f29511c = mVar;
                    }

                    @Override // com.bytedance.sdk.component.adnet.b.b.a
                    public File a(String str) {
                        InterceptResult invokeL;
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || (invokeL = interceptable2.invokeL(1048576, this, str)) == null) {
                            if (!this.f29509a.exists() || this.f29509a.length() <= 0) {
                                return null;
                            }
                            return this.f29509a;
                        }
                        return (File) invokeL.objValue;
                    }

                    @Override // com.bytedance.sdk.component.adnet.b.c.a
                    public void a(long j, long j2) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Long.valueOf(j), Long.valueOf(j2)}) == null) {
                        }
                    }

                    @Override // com.bytedance.sdk.component.adnet.b.b.a
                    public File b(String str) {
                        InterceptResult invokeL;
                        Interceptable interceptable2 = $ic;
                        return (interceptable2 == null || (invokeL = interceptable2.invokeL(1048580, this, str)) == null) ? this.f29509a : (File) invokeL.objValue;
                    }

                    @Override // com.bytedance.sdk.component.adnet.core.m.a
                    public void b(com.bytedance.sdk.component.adnet.core.m<File> mVar2) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeL(1048581, this, mVar2) == null) {
                            a aVar2 = this.f29510b;
                            if (aVar2 != null) {
                                aVar2.a(false, null);
                            }
                            this.f29512d.a(false, this.f29511c, mVar2 == null ? -2L : mVar2.f28038h, mVar2);
                        }
                    }

                    @Override // com.bytedance.sdk.component.adnet.b.b.a
                    public void a(String str, File file) {
                        Interceptable interceptable2 = $ic;
                        if (!(interceptable2 == null || interceptable2.invokeLL(1048579, this, str, file) == null) || file == null) {
                            return;
                        }
                        this.f29512d.a(file);
                    }

                    @Override // com.bytedance.sdk.component.adnet.core.m.a
                    public void a(com.bytedance.sdk.component.adnet.core.m<File> mVar2) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeL(Constants.METHOD_SEND_USER_MSG, this, mVar2) == null) {
                            if (mVar2 != null && mVar2.f28031a != null && this.f29509a.exists()) {
                                a aVar2 = this.f29510b;
                                if (aVar2 != null) {
                                    aVar2.a(true, null);
                                }
                                this.f29512d.a(true, this.f29511c, 0L, mVar2);
                                return;
                            }
                            a aVar3 = this.f29510b;
                            if (aVar3 != null) {
                                aVar3.a(false, null);
                            }
                            this.f29512d.a(false, this.f29511c, mVar2 == null ? -3L : mVar2.f28038h, mVar2);
                        }
                    }
                });
                return;
            }
            if (aVar != null) {
                aVar.a(false, null);
            }
            a(false, mVar, -1L, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(File file) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(AdIconUtil.AD_TEXT_ID, this, file) == null) {
            try {
                com.bytedance.sdk.openadsdk.core.h.d().r().a(file);
            } catch (IOException e2) {
                com.bytedance.sdk.component.utils.j.f("RewardVideoCache", "trimFileCache IOException:" + e2.toString());
            }
        }
    }

    public static void a(Context context, boolean z, m mVar, long j, long j2, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65538, null, new Object[]{context, Boolean.valueOf(z), mVar, Long.valueOf(j), Long.valueOf(j2), str}) == null) {
            com.bytedance.sdk.openadsdk.e.d.f(context, mVar, "rewarded_video", z ? "load_video_success" : "load_video_error", com.bytedance.sdk.openadsdk.r.o.a(z, mVar, j2, j, str));
        }
    }
}
