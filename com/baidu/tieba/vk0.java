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
public class vk0 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final HashMap<String, List<am0>> a;
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
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-343723919, "Lcom/baidu/tieba/vk0$a;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-343723919, "Lcom/baidu/tieba/vk0$a;");
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
        public static final vk0 a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-343723888, "Lcom/baidu/tieba/vk0$b;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-343723888, "Lcom/baidu/tieba/vk0$b;");
                    return;
                }
            }
            a = new vk0(null);
        }
    }

    public vk0() {
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
        this.c = cm0.b();
    }

    public /* synthetic */ vk0(a aVar) {
        this();
    }

    public void a(@NonNull il0 il0Var) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048576, this, il0Var) != null) || il0Var.f()) {
            return;
        }
        this.c.b(il0Var);
        il0Var.c = AdDownloadStatus.NONE;
        ql0 ql0Var = new ql0();
        ql0Var.b = "install_failed";
        h(AdDownloadAction.FAIL, il0Var, ql0Var);
    }

    public void j(@NonNull il0 il0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, il0Var) == null) {
            this.c.c(il0Var);
        }
    }

    public void l(@NonNull il0 il0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, il0Var) == null) {
            g(AdDownloadAction.PROGRESS_UPDATE, il0Var);
            this.c.d(il0Var, new wk0(il0Var));
        }
    }

    public void n(@NonNull il0 il0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, il0Var) == null) {
            g(AdDownloadAction.PROGRESS_UPDATE, il0Var);
            il0Var.b = this.c.a(il0Var, new wk0(il0Var));
            il0Var.c = AdDownloadStatus.DOWNLOADING;
        }
    }

    public static vk0 c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            return b.a;
        }
        return (vk0) invokeV.objValue;
    }

    public static void d(@NonNull il0 il0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65539, null, il0Var) == null) {
            if (!TextUtils.isEmpty(il0Var.p.c) && cj0.b(il0Var.p.c)) {
                if (un0.b().a().a("nad_als_open_to_click_switch", 0) == 1) {
                    e(AdDownloadAction.OPEN, il0Var);
                    return;
                }
                return;
            }
            sm0.h(il0Var.d);
            e(AdDownloadAction.OPEN, il0Var);
        }
    }

    public static void e(@NonNull AdDownloadAction adDownloadAction, @NonNull il0 il0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, null, adDownloadAction, il0Var) == null) {
            f(adDownloadAction, il0Var, null);
        }
    }

    public void g(@NonNull AdDownloadAction adDownloadAction, @NonNull il0 il0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, adDownloadAction, il0Var) == null) {
            h(adDownloadAction, il0Var, null);
        }
    }

    public void m(@NonNull il0 il0Var, @NonNull wk0 wk0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, il0Var, wk0Var) == null) {
            g(AdDownloadAction.PROGRESS_UPDATE, il0Var);
            this.c.d(il0Var, wk0Var);
        }
    }

    public void o(@NonNull il0 il0Var, @NonNull wk0 wk0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048586, this, il0Var, wk0Var) == null) {
            g(AdDownloadAction.PROGRESS_UPDATE, il0Var);
            il0Var.b = this.c.a(il0Var, wk0Var);
            il0Var.c = AdDownloadStatus.DOWNLOADING;
        }
    }

    public static void f(@NonNull AdDownloadAction adDownloadAction, @NonNull il0 il0Var, @Nullable ql0 ql0Var) {
        ClogBuilder.LogType logType;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLLL(65541, null, adDownloadAction, il0Var, ql0Var) != null) || TextUtils.isEmpty(il0Var.p.a)) {
            return;
        }
        String str = il0Var.q.j;
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
                if (un0.b().a().a("nad_als_open_to_click_switch", 0) == 1) {
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
        clogBuilder.y(logType).p(il0Var.p.a).v(il0Var.q.a).j(str).k(il0Var.d).l(il0Var.q.a).m(il0Var.q.b).n(il0Var.g);
        JSONObject jSONObject = new JSONObject();
        i31.d(jSONObject, "is_swallow", 1);
        if (!TextUtils.isEmpty(il0Var.q.d)) {
            i31.f(jSONObject, "ad_download_content_type", il0Var.q.d);
        }
        long j = il0Var.q.e;
        if (j > 0) {
            i31.e(jSONObject, "ad_download_content_length", j);
        }
        int i = il0Var.n;
        if (i > 0) {
            i31.d(jSONObject, "version_code", i);
        }
        if (!TextUtils.isEmpty(il0Var.o)) {
            i31.f(jSONObject, NativeUnifiedADAppInfoImpl.Keys.VERSION_NAME, il0Var.o);
        }
        if (ql0Var != null) {
            Exception exc = ql0Var.a;
            if (exc != null) {
                i31.f(jSONObject, "failed_reason", exc.getClass().toString());
            }
            String str2 = ql0Var.b;
            if (str2 != null) {
                i31.f(jSONObject, "failed_reason", str2);
            }
        }
        if (jSONObject.length() > 0) {
            clogBuilder.o(jSONObject.toString());
        }
        x31.e(clogBuilder);
    }

    public final void b(@NonNull String str, @NonNull String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, str2) == null) {
            Context b2 = tj0.b();
            Object systemService = b2.getSystemService(GrowthConstant.UBC_VALUE_TYPE_CLIP_BOARD);
            if (!(systemService instanceof ClipboardManager)) {
                return;
            }
            ((ClipboardManager) systemService).setPrimaryClip(ClipData.newPlainText(b2.getResources().getString(R.string.nad_invite_code_label), str));
            s51.a().showToast(b2, str2);
        }
    }

    public void h(@NonNull AdDownloadAction adDownloadAction, @NonNull il0 il0Var, @Nullable ql0 ql0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048579, this, adDownloadAction, il0Var, ql0Var) == null) {
            f(adDownloadAction, il0Var, ql0Var);
            this.b.readLock().lock();
            try {
                List list = (List) j31.b(this.a, il0Var.e());
                if (list == null) {
                    return;
                }
                for (int i = 0; i != h31.l(list); i++) {
                    am0 am0Var = (am0) h31.d(list, i);
                    if (am0Var != null && am0Var.getData() != null) {
                        am0Var.getData().i(il0Var);
                        am0Var.a(adDownloadAction, am0Var.getData());
                    }
                }
                this.b.readLock().unlock();
                i(adDownloadAction, il0Var);
            } finally {
                this.b.readLock().unlock();
            }
        }
    }

    public final void i(@NonNull AdDownloadAction adDownloadAction, @NonNull il0 il0Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048580, this, adDownloadAction, il0Var) == null) && a.a[adDownloadAction.ordinal()] == 1) {
            Context context = null;
            WeakReference<Context> weakReference = il0Var.p.m;
            if (weakReference != null) {
                context = weakReference.get();
            }
            if (!TextUtils.isEmpty(il0Var.p.l) && context != null) {
                cj0.c(il0Var.p.l, context);
            }
            if (il0Var.q.r) {
                s51.a().a(tj0.b(), R.string.nad_apk_download_start_toast);
            }
            kl0 kl0Var = il0Var.p.k;
            if (kl0Var != null && !TextUtils.isEmpty(kl0Var.a)) {
                kl0 kl0Var2 = il0Var.p.k;
                b(kl0Var2.a, kl0Var2.b);
            }
        }
    }

    public void k(String str, am0 am0Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048582, this, str, am0Var) == null) && !TextUtils.isEmpty(str) && am0Var != null) {
            this.b.writeLock().lock();
            try {
                List list = (List) j31.b(this.a, str);
                if (list == null) {
                    list = new ArrayList();
                    j31.e(this.a, str, list);
                }
                h31.b(list, am0Var);
            } finally {
                this.b.writeLock().unlock();
            }
        }
    }

    public void p(String str, am0 am0Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048587, this, str, am0Var) == null) && !TextUtils.isEmpty(str) && am0Var != null) {
            this.b.writeLock().lock();
            try {
                List list = (List) j31.b(this.a, str);
                if (list == null) {
                    return;
                }
                h31.j(list, am0Var);
            } finally {
                this.b.writeLock().unlock();
            }
        }
    }
}
