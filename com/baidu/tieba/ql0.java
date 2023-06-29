package com.baidu.tieba;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.nadcore.download.consts.AdDownloadAction;
import com.baidu.nadcore.download.consts.AdDownloadStatus;
import com.baidu.nadcore.download.proxy.IAdDownloader;
import com.baidu.nadcore.stats.request.ClogBuilder;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.qq.e.ads.nativ.NativeUnifiedADAppInfoImpl;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class ql0 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final HashMap<String, List<vm0>> a;
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
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-485946153, "Lcom/baidu/tieba/ql0$a;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-485946153, "Lcom/baidu/tieba/ql0$a;");
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
        public static final ql0 a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-485946122, "Lcom/baidu/tieba/ql0$b;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-485946122, "Lcom/baidu/tieba/ql0$b;");
                    return;
                }
            }
            a = new ql0(null);
        }
    }

    public ql0() {
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
        this.c = xm0.b();
    }

    public /* synthetic */ ql0(a aVar) {
        this();
    }

    public void a(@NonNull dm0 dm0Var) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048576, this, dm0Var) != null) || dm0Var.f()) {
            return;
        }
        this.c.b(dm0Var);
        dm0Var.c = AdDownloadStatus.NONE;
        lm0 lm0Var = new lm0();
        lm0Var.b = "install_failed";
        g(AdDownloadAction.FAIL, dm0Var, lm0Var);
    }

    public void h(@NonNull dm0 dm0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, dm0Var) == null) {
            this.c.c(dm0Var);
        }
    }

    public void j(@NonNull dm0 dm0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, dm0Var) == null) {
            f(AdDownloadAction.PROGRESS_UPDATE, dm0Var);
            this.c.d(dm0Var, new rl0(dm0Var));
        }
    }

    public void k(@NonNull dm0 dm0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, dm0Var) == null) {
            f(AdDownloadAction.PROGRESS_UPDATE, dm0Var);
            dm0Var.b = this.c.a(dm0Var, new rl0(dm0Var));
            dm0Var.c = AdDownloadStatus.DOWNLOADING;
        }
    }

    public static ql0 b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            return b.a;
        }
        return (ql0) invokeV.objValue;
    }

    public static void c(@NonNull dm0 dm0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65539, null, dm0Var) == null) {
            if (!TextUtils.isEmpty(dm0Var.p.c) && xj0.b(dm0Var.p.c)) {
                if (io0.b().a().a("nad_als_open_to_click_switch", 0) == 1) {
                    d(AdDownloadAction.OPEN, dm0Var);
                    return;
                }
                return;
            }
            hn0.g(dm0Var.d);
            d(AdDownloadAction.OPEN, dm0Var);
        }
    }

    public static void d(@NonNull AdDownloadAction adDownloadAction, @NonNull dm0 dm0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, null, adDownloadAction, dm0Var) == null) {
            e(adDownloadAction, dm0Var, null);
        }
    }

    public void f(@NonNull AdDownloadAction adDownloadAction, @NonNull dm0 dm0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, adDownloadAction, dm0Var) == null) {
            g(adDownloadAction, dm0Var, null);
        }
    }

    public static void e(@NonNull AdDownloadAction adDownloadAction, @NonNull dm0 dm0Var, @Nullable lm0 lm0Var) {
        ClogBuilder.LogType logType;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLLL(65541, null, adDownloadAction, dm0Var, lm0Var) != null) || TextUtils.isEmpty(dm0Var.p.a)) {
            return;
        }
        String str = dm0Var.q.j;
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
                if (io0.b().a().a("nad_als_open_to_click_switch", 0) == 1) {
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
        clogBuilder.y(logType).p(dm0Var.p.a).v(dm0Var.q.a).j(str).k(dm0Var.d).l(dm0Var.q.a).m(dm0Var.q.b).n(dm0Var.g);
        JSONObject jSONObject = new JSONObject();
        c31.d(jSONObject, "is_swallow", 1);
        if (!TextUtils.isEmpty(dm0Var.q.d)) {
            c31.f(jSONObject, "ad_download_content_type", dm0Var.q.d);
        }
        long j = dm0Var.q.e;
        if (j > 0) {
            c31.e(jSONObject, "ad_download_content_length", j);
        }
        int i = dm0Var.n;
        if (i > 0) {
            c31.d(jSONObject, "version_code", i);
        }
        if (!TextUtils.isEmpty(dm0Var.o)) {
            c31.f(jSONObject, NativeUnifiedADAppInfoImpl.Keys.VERSION_NAME, dm0Var.o);
        }
        if (lm0Var != null) {
            Exception exc = lm0Var.a;
            if (exc != null) {
                c31.f(jSONObject, "failed_reason", exc.getClass().toString());
            }
            String str2 = lm0Var.b;
            if (str2 != null) {
                c31.f(jSONObject, "failed_reason", str2);
            }
        }
        if (jSONObject.length() > 0) {
            clogBuilder.o(jSONObject.toString());
        }
        r31.b(clogBuilder);
    }

    public void g(@NonNull AdDownloadAction adDownloadAction, @NonNull dm0 dm0Var, @Nullable lm0 lm0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(Constants.METHOD_SEND_USER_MSG, this, adDownloadAction, dm0Var, lm0Var) == null) {
            e(adDownloadAction, dm0Var, lm0Var);
            this.b.readLock().lock();
            try {
                List list = (List) d31.b(this.a, dm0Var.e());
                if (list == null) {
                    return;
                }
                for (int i = 0; i != b31.l(list); i++) {
                    vm0 vm0Var = (vm0) b31.d(list, i);
                    if (vm0Var != null && vm0Var.getData() != null) {
                        vm0Var.getData().i(dm0Var);
                        vm0Var.a(adDownloadAction, vm0Var.getData());
                    }
                }
            } finally {
                this.b.readLock().unlock();
            }
        }
    }

    public void i(String str, vm0 vm0Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048580, this, str, vm0Var) == null) && !TextUtils.isEmpty(str) && vm0Var != null) {
            this.b.writeLock().lock();
            try {
                List list = (List) d31.b(this.a, str);
                if (list == null) {
                    list = new ArrayList();
                    d31.e(this.a, str, list);
                }
                b31.b(list, vm0Var);
            } finally {
                this.b.writeLock().unlock();
            }
        }
    }

    public void l(String str, vm0 vm0Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048583, this, str, vm0Var) == null) && !TextUtils.isEmpty(str) && vm0Var != null) {
            this.b.writeLock().lock();
            try {
                List list = (List) d31.b(this.a, str);
                if (list == null) {
                    return;
                }
                b31.j(list, vm0Var);
            } finally {
                this.b.writeLock().unlock();
            }
        }
    }
}
