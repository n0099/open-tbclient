package com.baidu.tieba;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.nadcore.download.consts.AdDownloadAction;
import com.baidu.nadcore.download.consts.AdDownloadStatus;
import com.baidu.nadcore.download.proxy.IAdDownloader;
import com.baidu.nadcore.stats.request.ClogBuilder;
import com.baidu.searchbox.datacollector.growth.utils.GrowthConstant;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.qq.e.ads.nativ.NativeUnifiedADAppInfoImpl;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import org.json.JSONObject;
/* loaded from: classes8.dex */
public class uk0 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final HashMap<String, List<zl0>> a;
    public final ReentrantReadWriteLock b;
    public final IAdDownloader c;

    /* loaded from: classes8.dex */
    public static /* synthetic */ class a {
        public static /* synthetic */ Interceptable $ic;
        public static final /* synthetic */ int[] a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-372353070, "Lcom/baidu/tieba/uk0$a;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-372353070, "Lcom/baidu/tieba/uk0$a;");
                    return;
                }
            }
            int[] iArr = new int[AdDownloadAction.values().length];
            a = iArr;
            try {
                iArr[AdDownloadAction.START.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                a[AdDownloadAction.PAUSE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                a[AdDownloadAction.RESUME.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                a[AdDownloadAction.COMPLETE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                a[AdDownloadAction.INSTALL_START.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                a[AdDownloadAction.INSTALL_FINISH.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                a[AdDownloadAction.OPEN.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                a[AdDownloadAction.FAIL.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                a[AdDownloadAction.FAIL_RETRY.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                a[AdDownloadAction.FAIL_PERMISSION_DENY.ordinal()] = 10;
            } catch (NoSuchFieldError unused10) {
            }
        }
    }

    /* loaded from: classes8.dex */
    public static class b {
        public static /* synthetic */ Interceptable $ic;
        public static final uk0 a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-372353039, "Lcom/baidu/tieba/uk0$b;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-372353039, "Lcom/baidu/tieba/uk0$b;");
                    return;
                }
            }
            a = new uk0(null);
        }
    }

    public uk0() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = new HashMap<>(32);
        this.b = new ReentrantReadWriteLock();
        this.c = bm0.b();
    }

    public /* synthetic */ uk0(a aVar) {
        this();
    }

    public void a(@NonNull hl0 hl0Var) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048576, this, hl0Var) != null) || hl0Var.f()) {
            return;
        }
        this.c.b(hl0Var);
        hl0Var.c = AdDownloadStatus.NONE;
        pl0 pl0Var = new pl0();
        pl0Var.b = "install_failed";
        h(AdDownloadAction.FAIL, hl0Var, pl0Var);
    }

    public void j(@NonNull hl0 hl0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, hl0Var) == null) {
            this.c.c(hl0Var);
        }
    }

    public void l(@NonNull hl0 hl0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, hl0Var) == null) {
            g(AdDownloadAction.PROGRESS_UPDATE, hl0Var);
            this.c.d(hl0Var, new vk0(hl0Var));
        }
    }

    public void m(@NonNull hl0 hl0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, hl0Var) == null) {
            g(AdDownloadAction.PROGRESS_UPDATE, hl0Var);
            hl0Var.b = this.c.a(hl0Var, new vk0(hl0Var));
            hl0Var.c = AdDownloadStatus.DOWNLOADING;
        }
    }

    public static uk0 c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            return b.a;
        }
        return (uk0) invokeV.objValue;
    }

    public static void d(@NonNull hl0 hl0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65539, null, hl0Var) == null) {
            if (!TextUtils.isEmpty(hl0Var.p.c) && bj0.b(hl0Var.p.c)) {
                if (tn0.b().a().a("nad_als_open_to_click_switch", 0) == 1) {
                    e(AdDownloadAction.OPEN, hl0Var);
                    return;
                }
                return;
            }
            rm0.h(hl0Var.d);
            e(AdDownloadAction.OPEN, hl0Var);
        }
    }

    public static void e(@NonNull AdDownloadAction adDownloadAction, @NonNull hl0 hl0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, null, adDownloadAction, hl0Var) == null) {
            f(adDownloadAction, hl0Var, null);
        }
    }

    public void g(@NonNull AdDownloadAction adDownloadAction, @NonNull hl0 hl0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, adDownloadAction, hl0Var) == null) {
            h(adDownloadAction, hl0Var, null);
        }
    }

    public static void f(@NonNull AdDownloadAction adDownloadAction, @NonNull hl0 hl0Var, @Nullable pl0 pl0Var) {
        ClogBuilder.LogType logType;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLLL(65541, null, adDownloadAction, hl0Var, pl0Var) != null) || TextUtils.isEmpty(hl0Var.p.a)) {
            return;
        }
        String str = hl0Var.q.j;
        switch (a.a[adDownloadAction.ordinal()]) {
            case 1:
                logType = ClogBuilder.LogType.DOWNLOAD_START;
                break;
            case 2:
                logType = ClogBuilder.LogType.DOWNLOAD_PAUSE;
                break;
            case 3:
                logType = ClogBuilder.LogType.DOWNLOAD_CONTINUE;
                break;
            case 4:
                logType = ClogBuilder.LogType.DOWNLOAD_COMPLETE;
                break;
            case 5:
                logType = ClogBuilder.LogType.DOWNLOAD_INSTALL;
                break;
            case 6:
                logType = ClogBuilder.LogType.INSTALL_COMPLETE;
                break;
            case 7:
                if (tn0.b().a().a("nad_als_open_to_click_switch", 0) == 1) {
                    logType = ClogBuilder.LogType.CLICK;
                    str = ClogBuilder.Area.OPEN_BUTTON.type;
                    break;
                } else {
                    logType = ClogBuilder.LogType.DEEP_LINK;
                    break;
                }
            case 8:
                logType = ClogBuilder.LogType.DOWNLOAD_FAILED;
                break;
            case 9:
                logType = ClogBuilder.LogType.DOWNLOAD_RETRY;
                break;
            default:
                return;
        }
        if (TextUtils.isEmpty(str)) {
            str = ClogBuilder.Area.DOWNLOAD_BUTTON.type;
        }
        ClogBuilder clogBuilder = new ClogBuilder();
        clogBuilder.y(logType).p(hl0Var.p.a).v(hl0Var.q.a).j(str).k(hl0Var.d).l(hl0Var.q.a).m(hl0Var.q.b).n(hl0Var.g);
        JSONObject jSONObject = new JSONObject();
        e31.d(jSONObject, "is_swallow", 1);
        if (!TextUtils.isEmpty(hl0Var.q.d)) {
            e31.f(jSONObject, "ad_download_content_type", hl0Var.q.d);
        }
        long j = hl0Var.q.e;
        if (j > 0) {
            e31.e(jSONObject, "ad_download_content_length", j);
        }
        int i = hl0Var.n;
        if (i > 0) {
            e31.d(jSONObject, "version_code", i);
        }
        if (!TextUtils.isEmpty(hl0Var.o)) {
            e31.f(jSONObject, NativeUnifiedADAppInfoImpl.Keys.VERSION_NAME, hl0Var.o);
        }
        if (pl0Var != null) {
            Exception exc = pl0Var.a;
            if (exc != null) {
                e31.f(jSONObject, "failed_reason", exc.getClass().toString());
            }
            String str2 = pl0Var.b;
            if (str2 != null) {
                e31.f(jSONObject, "failed_reason", str2);
            }
        }
        if (jSONObject.length() > 0) {
            clogBuilder.o(jSONObject.toString());
        }
        t31.e(clogBuilder);
    }

    public final void b(@NonNull String str, @NonNull String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, str2) == null) {
            Context b2 = sj0.b();
            Object systemService = b2.getSystemService(GrowthConstant.UBC_VALUE_TYPE_CLIP_BOARD);
            if (!(systemService instanceof ClipboardManager)) {
                return;
            }
            ((ClipboardManager) systemService).setPrimaryClip(ClipData.newPlainText(b2.getResources().getString(R.string.nad_invite_code_label), str));
            o51.a().showToast(b2, str2);
        }
    }

    public void h(@NonNull AdDownloadAction adDownloadAction, @NonNull hl0 hl0Var, @Nullable pl0 pl0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048579, this, adDownloadAction, hl0Var, pl0Var) == null) {
            f(adDownloadAction, hl0Var, pl0Var);
            this.b.readLock().lock();
            try {
                List list = (List) f31.b(this.a, hl0Var.e());
                if (list == null) {
                    return;
                }
                for (int i = 0; i != d31.l(list); i++) {
                    zl0 zl0Var = (zl0) d31.d(list, i);
                    if (zl0Var != null && zl0Var.getData() != null) {
                        zl0Var.getData().i(hl0Var);
                        zl0Var.a(adDownloadAction, zl0Var.getData());
                    }
                }
                this.b.readLock().unlock();
                i(adDownloadAction, hl0Var);
            } finally {
                this.b.readLock().unlock();
            }
        }
    }

    public final void i(@NonNull AdDownloadAction adDownloadAction, @NonNull hl0 hl0Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048580, this, adDownloadAction, hl0Var) == null) && a.a[adDownloadAction.ordinal()] == 1) {
            Context context = null;
            WeakReference<Context> weakReference = hl0Var.p.m;
            if (weakReference != null) {
                context = weakReference.get();
            }
            if (!TextUtils.isEmpty(hl0Var.p.l) && context != null) {
                bj0.c(hl0Var.p.l, context);
            }
            if (hl0Var.q.r) {
                o51.a().a(sj0.b(), R.string.nad_apk_download_start_toast);
            }
            jl0 jl0Var = hl0Var.p.k;
            if (jl0Var != null && !TextUtils.isEmpty(jl0Var.a)) {
                jl0 jl0Var2 = hl0Var.p.k;
                b(jl0Var2.a, jl0Var2.b);
            }
        }
    }

    public void k(String str, zl0 zl0Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048582, this, str, zl0Var) == null) && !TextUtils.isEmpty(str) && zl0Var != null) {
            this.b.writeLock().lock();
            try {
                List list = (List) f31.b(this.a, str);
                if (list == null) {
                    list = new ArrayList();
                    f31.e(this.a, str, list);
                }
                d31.b(list, zl0Var);
            } finally {
                this.b.writeLock().unlock();
            }
        }
    }

    public void n(String str, zl0 zl0Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048585, this, str, zl0Var) == null) && !TextUtils.isEmpty(str) && zl0Var != null) {
            this.b.writeLock().lock();
            try {
                List list = (List) f31.b(this.a, str);
                if (list == null) {
                    return;
                }
                d31.j(list, zl0Var);
            } finally {
                this.b.writeLock().unlock();
            }
        }
    }
}
