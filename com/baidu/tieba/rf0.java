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
public class rf0 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final HashMap<String, List<wg0>> a;
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
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-462858128, "Lcom/baidu/tieba/rf0$a;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-462858128, "Lcom/baidu/tieba/rf0$a;");
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
        public static final rf0 a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-462858097, "Lcom/baidu/tieba/rf0$b;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-462858097, "Lcom/baidu/tieba/rf0$b;");
                    return;
                }
            }
            a = new rf0(null);
        }
    }

    public rf0() {
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
        this.c = yg0.b();
    }

    public /* synthetic */ rf0(a aVar) {
        this();
    }

    public void a(@NonNull eg0 eg0Var) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048576, this, eg0Var) != null) || eg0Var.f()) {
            return;
        }
        this.c.b(eg0Var);
        eg0Var.c = AdDownloadStatus.NONE;
        mg0 mg0Var = new mg0();
        mg0Var.b = "install_failed";
        h(AdDownloadAction.FAIL, eg0Var, mg0Var);
    }

    public void j(@NonNull eg0 eg0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, eg0Var) == null) {
            this.c.c(eg0Var);
        }
    }

    public void l(@NonNull eg0 eg0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, eg0Var) == null) {
            g(AdDownloadAction.PROGRESS_UPDATE, eg0Var);
            this.c.d(eg0Var, new sf0(eg0Var));
        }
    }

    public void n(@NonNull eg0 eg0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, eg0Var) == null) {
            g(AdDownloadAction.PROGRESS_UPDATE, eg0Var);
            eg0Var.b = this.c.a(eg0Var, new sf0(eg0Var));
            eg0Var.c = AdDownloadStatus.DOWNLOADING;
        }
    }

    public static rf0 c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            return b.a;
        }
        return (rf0) invokeV.objValue;
    }

    public static void d(@NonNull eg0 eg0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65539, null, eg0Var) == null) {
            if (!TextUtils.isEmpty(eg0Var.p.c) && yd0.b(eg0Var.p.c)) {
                if (qi0.b().a().a("nad_als_open_to_click_switch", 0) == 1) {
                    e(AdDownloadAction.OPEN, eg0Var);
                    return;
                }
                return;
            }
            oh0.h(eg0Var.d);
            e(AdDownloadAction.OPEN, eg0Var);
        }
    }

    public static void e(@NonNull AdDownloadAction adDownloadAction, @NonNull eg0 eg0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, null, adDownloadAction, eg0Var) == null) {
            f(adDownloadAction, eg0Var, null);
        }
    }

    public void g(@NonNull AdDownloadAction adDownloadAction, @NonNull eg0 eg0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, adDownloadAction, eg0Var) == null) {
            h(adDownloadAction, eg0Var, null);
        }
    }

    public void m(@NonNull eg0 eg0Var, @NonNull sf0 sf0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, eg0Var, sf0Var) == null) {
            g(AdDownloadAction.PROGRESS_UPDATE, eg0Var);
            this.c.d(eg0Var, sf0Var);
        }
    }

    public void o(@NonNull eg0 eg0Var, @NonNull sf0 sf0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048586, this, eg0Var, sf0Var) == null) {
            g(AdDownloadAction.PROGRESS_UPDATE, eg0Var);
            eg0Var.b = this.c.a(eg0Var, sf0Var);
            eg0Var.c = AdDownloadStatus.DOWNLOADING;
        }
    }

    public static void f(@NonNull AdDownloadAction adDownloadAction, @NonNull eg0 eg0Var, @Nullable mg0 mg0Var) {
        ClogBuilder.LogType logType;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLLL(65541, null, adDownloadAction, eg0Var, mg0Var) != null) || TextUtils.isEmpty(eg0Var.p.a)) {
            return;
        }
        String str = eg0Var.q.j;
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
                if (qi0.b().a().a("nad_als_open_to_click_switch", 0) == 1) {
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
        clogBuilder.y(logType).p(eg0Var.p.a).v(eg0Var.q.a).j(str).k(eg0Var.d).l(eg0Var.q.a).m(eg0Var.q.b).n(eg0Var.g);
        JSONObject jSONObject = new JSONObject();
        ux0.d(jSONObject, "is_swallow", 1);
        if (!TextUtils.isEmpty(eg0Var.q.d)) {
            ux0.f(jSONObject, "ad_download_content_type", eg0Var.q.d);
        }
        long j = eg0Var.q.e;
        if (j > 0) {
            ux0.e(jSONObject, "ad_download_content_length", j);
        }
        int i = eg0Var.n;
        if (i > 0) {
            ux0.d(jSONObject, "version_code", i);
        }
        if (!TextUtils.isEmpty(eg0Var.o)) {
            ux0.f(jSONObject, NativeUnifiedADAppInfoImpl.Keys.VERSION_NAME, eg0Var.o);
        }
        if (mg0Var != null) {
            Exception exc = mg0Var.a;
            if (exc != null) {
                ux0.f(jSONObject, "failed_reason", exc.getClass().toString());
            }
            String str2 = mg0Var.b;
            if (str2 != null) {
                ux0.f(jSONObject, "failed_reason", str2);
            }
        }
        if (jSONObject.length() > 0) {
            clogBuilder.o(jSONObject.toString());
        }
        jy0.e(clogBuilder);
    }

    public final void b(@NonNull String str, @NonNull String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, str2) == null) {
            Context b2 = pe0.b();
            Object systemService = b2.getSystemService(GrowthConstant.UBC_VALUE_TYPE_CLIP_BOARD);
            if (!(systemService instanceof ClipboardManager)) {
                return;
            }
            ((ClipboardManager) systemService).setPrimaryClip(ClipData.newPlainText(b2.getResources().getString(R.string.nad_invite_code_label), str));
            e01.a().showToast(b2, str2);
        }
    }

    public void h(@NonNull AdDownloadAction adDownloadAction, @NonNull eg0 eg0Var, @Nullable mg0 mg0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048579, this, adDownloadAction, eg0Var, mg0Var) == null) {
            f(adDownloadAction, eg0Var, mg0Var);
            this.b.readLock().lock();
            try {
                List list = (List) vx0.b(this.a, eg0Var.e());
                if (list == null) {
                    return;
                }
                for (int i = 0; i != tx0.l(list); i++) {
                    wg0 wg0Var = (wg0) tx0.d(list, i);
                    if (wg0Var != null && wg0Var.getData() != null) {
                        wg0Var.getData().i(eg0Var);
                        wg0Var.a(adDownloadAction, wg0Var.getData());
                    }
                }
                this.b.readLock().unlock();
                i(adDownloadAction, eg0Var);
            } finally {
                this.b.readLock().unlock();
            }
        }
    }

    public final void i(@NonNull AdDownloadAction adDownloadAction, @NonNull eg0 eg0Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048580, this, adDownloadAction, eg0Var) == null) && a.a[adDownloadAction.ordinal()] == 1) {
            Context context = null;
            WeakReference<Context> weakReference = eg0Var.p.m;
            if (weakReference != null) {
                context = weakReference.get();
            }
            if (!TextUtils.isEmpty(eg0Var.p.l) && context != null) {
                yd0.c(eg0Var.p.l, context);
            }
            if (eg0Var.q.r) {
                e01.a().a(pe0.b(), R.string.nad_apk_download_start_toast);
            }
            gg0 gg0Var = eg0Var.p.k;
            if (gg0Var != null && !TextUtils.isEmpty(gg0Var.a)) {
                gg0 gg0Var2 = eg0Var.p.k;
                b(gg0Var2.a, gg0Var2.b);
            }
        }
    }

    public void k(String str, wg0 wg0Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048582, this, str, wg0Var) == null) && !TextUtils.isEmpty(str) && wg0Var != null) {
            this.b.writeLock().lock();
            try {
                List list = (List) vx0.b(this.a, str);
                if (list == null) {
                    list = new ArrayList();
                    vx0.e(this.a, str, list);
                }
                tx0.b(list, wg0Var);
            } finally {
                this.b.writeLock().unlock();
            }
        }
    }

    public void p(String str, wg0 wg0Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048587, this, str, wg0Var) == null) && !TextUtils.isEmpty(str) && wg0Var != null) {
            this.b.writeLock().lock();
            try {
                List list = (List) vx0.b(this.a, str);
                if (list == null) {
                    return;
                }
                tx0.j(list, wg0Var);
            } finally {
                this.b.writeLock().unlock();
            }
        }
    }
}
