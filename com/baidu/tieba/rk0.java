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
/* loaded from: classes7.dex */
public class rk0 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final HashMap<String, List<wl0>> a;
    public final ReentrantReadWriteLock b;
    public final IAdDownloader c;

    /* loaded from: classes7.dex */
    public static /* synthetic */ class a {
        public static /* synthetic */ Interceptable $ic;
        public static final /* synthetic */ int[] a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-458240523, "Lcom/baidu/tieba/rk0$a;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-458240523, "Lcom/baidu/tieba/rk0$a;");
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

    /* loaded from: classes7.dex */
    public static class b {
        public static /* synthetic */ Interceptable $ic;
        public static final rk0 a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-458240492, "Lcom/baidu/tieba/rk0$b;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-458240492, "Lcom/baidu/tieba/rk0$b;");
                    return;
                }
            }
            a = new rk0(null);
        }
    }

    public rk0() {
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
        this.c = yl0.b();
    }

    public /* synthetic */ rk0(a aVar) {
        this();
    }

    public void a(@NonNull el0 el0Var) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048576, this, el0Var) != null) || el0Var.f()) {
            return;
        }
        this.c.b(el0Var);
        el0Var.c = AdDownloadStatus.NONE;
        ml0 ml0Var = new ml0();
        ml0Var.b = "install_failed";
        h(AdDownloadAction.FAIL, el0Var, ml0Var);
    }

    public void j(@NonNull el0 el0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, el0Var) == null) {
            this.c.c(el0Var);
        }
    }

    public void l(@NonNull el0 el0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, el0Var) == null) {
            g(AdDownloadAction.PROGRESS_UPDATE, el0Var);
            this.c.d(el0Var, new sk0(el0Var));
        }
    }

    public void m(@NonNull el0 el0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, el0Var) == null) {
            g(AdDownloadAction.PROGRESS_UPDATE, el0Var);
            el0Var.b = this.c.a(el0Var, new sk0(el0Var));
            el0Var.c = AdDownloadStatus.DOWNLOADING;
        }
    }

    public static rk0 c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            return b.a;
        }
        return (rk0) invokeV.objValue;
    }

    public static void d(@NonNull el0 el0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65539, null, el0Var) == null) {
            if (!TextUtils.isEmpty(el0Var.p.c) && yi0.b(el0Var.p.c)) {
                if (qn0.b().a().a("nad_als_open_to_click_switch", 0) == 1) {
                    e(AdDownloadAction.OPEN, el0Var);
                    return;
                }
                return;
            }
            om0.h(el0Var.d);
            e(AdDownloadAction.OPEN, el0Var);
        }
    }

    public static void e(@NonNull AdDownloadAction adDownloadAction, @NonNull el0 el0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, null, adDownloadAction, el0Var) == null) {
            f(adDownloadAction, el0Var, null);
        }
    }

    public void g(@NonNull AdDownloadAction adDownloadAction, @NonNull el0 el0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, adDownloadAction, el0Var) == null) {
            h(adDownloadAction, el0Var, null);
        }
    }

    public static void f(@NonNull AdDownloadAction adDownloadAction, @NonNull el0 el0Var, @Nullable ml0 ml0Var) {
        ClogBuilder.LogType logType;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLLL(65541, null, adDownloadAction, el0Var, ml0Var) != null) || TextUtils.isEmpty(el0Var.p.a)) {
            return;
        }
        String str = el0Var.q.j;
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
                if (qn0.b().a().a("nad_als_open_to_click_switch", 0) == 1) {
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
        clogBuilder.y(logType).p(el0Var.p.a).v(el0Var.q.a).j(str).k(el0Var.d).l(el0Var.q.a).m(el0Var.q.b).n(el0Var.g);
        JSONObject jSONObject = new JSONObject();
        b31.d(jSONObject, "is_swallow", 1);
        if (!TextUtils.isEmpty(el0Var.q.d)) {
            b31.f(jSONObject, "ad_download_content_type", el0Var.q.d);
        }
        long j = el0Var.q.e;
        if (j > 0) {
            b31.e(jSONObject, "ad_download_content_length", j);
        }
        int i = el0Var.n;
        if (i > 0) {
            b31.d(jSONObject, "version_code", i);
        }
        if (!TextUtils.isEmpty(el0Var.o)) {
            b31.f(jSONObject, NativeUnifiedADAppInfoImpl.Keys.VERSION_NAME, el0Var.o);
        }
        if (ml0Var != null) {
            Exception exc = ml0Var.a;
            if (exc != null) {
                b31.f(jSONObject, "failed_reason", exc.getClass().toString());
            }
            String str2 = ml0Var.b;
            if (str2 != null) {
                b31.f(jSONObject, "failed_reason", str2);
            }
        }
        if (jSONObject.length() > 0) {
            clogBuilder.o(jSONObject.toString());
        }
        q31.e(clogBuilder);
    }

    public final void b(@NonNull String str, @NonNull String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, str2) == null) {
            Context b2 = pj0.b();
            Object systemService = b2.getSystemService(GrowthConstant.UBC_VALUE_TYPE_CLIP_BOARD);
            if (!(systemService instanceof ClipboardManager)) {
                return;
            }
            ((ClipboardManager) systemService).setPrimaryClip(ClipData.newPlainText(b2.getResources().getString(R.string.nad_invite_code_label), str));
            j51.a().showToast(b2, str2);
        }
    }

    public void h(@NonNull AdDownloadAction adDownloadAction, @NonNull el0 el0Var, @Nullable ml0 ml0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048579, this, adDownloadAction, el0Var, ml0Var) == null) {
            f(adDownloadAction, el0Var, ml0Var);
            this.b.readLock().lock();
            try {
                List list = (List) c31.b(this.a, el0Var.e());
                if (list == null) {
                    return;
                }
                for (int i = 0; i != a31.l(list); i++) {
                    wl0 wl0Var = (wl0) a31.d(list, i);
                    if (wl0Var != null && wl0Var.getData() != null) {
                        wl0Var.getData().i(el0Var);
                        wl0Var.a(adDownloadAction, wl0Var.getData());
                    }
                }
                this.b.readLock().unlock();
                i(adDownloadAction, el0Var);
            } finally {
                this.b.readLock().unlock();
            }
        }
    }

    public final void i(@NonNull AdDownloadAction adDownloadAction, @NonNull el0 el0Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048580, this, adDownloadAction, el0Var) == null) && a.a[adDownloadAction.ordinal()] == 1) {
            Context context = null;
            WeakReference<Context> weakReference = el0Var.p.m;
            if (weakReference != null) {
                context = weakReference.get();
            }
            if (!TextUtils.isEmpty(el0Var.p.l) && context != null) {
                yi0.c(el0Var.p.l, context);
            }
            if (el0Var.q.r) {
                j51.a().a(pj0.b(), R.string.nad_apk_download_start_toast);
            }
            gl0 gl0Var = el0Var.p.k;
            if (gl0Var != null && !TextUtils.isEmpty(gl0Var.a)) {
                gl0 gl0Var2 = el0Var.p.k;
                b(gl0Var2.a, gl0Var2.b);
            }
        }
    }

    public void k(String str, wl0 wl0Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048582, this, str, wl0Var) == null) && !TextUtils.isEmpty(str) && wl0Var != null) {
            this.b.writeLock().lock();
            try {
                List list = (List) c31.b(this.a, str);
                if (list == null) {
                    list = new ArrayList();
                    c31.e(this.a, str, list);
                }
                a31.b(list, wl0Var);
            } finally {
                this.b.writeLock().unlock();
            }
        }
    }

    public void n(String str, wl0 wl0Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048585, this, str, wl0Var) == null) && !TextUtils.isEmpty(str) && wl0Var != null) {
            this.b.writeLock().lock();
            try {
                List list = (List) c31.b(this.a, str);
                if (list == null) {
                    return;
                }
                a31.j(list, wl0Var);
            } finally {
                this.b.writeLock().unlock();
            }
        }
    }
}
