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
public class nl0 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final HashMap<String, List<sm0>> a;
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
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-571833606, "Lcom/baidu/tieba/nl0$a;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-571833606, "Lcom/baidu/tieba/nl0$a;");
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
        public static final nl0 a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-571833575, "Lcom/baidu/tieba/nl0$b;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-571833575, "Lcom/baidu/tieba/nl0$b;");
                    return;
                }
            }
            a = new nl0(null);
        }
    }

    public nl0() {
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
        this.c = um0.b();
    }

    public /* synthetic */ nl0(a aVar) {
        this();
    }

    public void a(@NonNull am0 am0Var) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048576, this, am0Var) != null) || am0Var.f()) {
            return;
        }
        this.c.b(am0Var);
        am0Var.c = AdDownloadStatus.NONE;
        im0 im0Var = new im0();
        im0Var.b = "install_failed";
        g(AdDownloadAction.FAIL, am0Var, im0Var);
    }

    public void h(@NonNull am0 am0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, am0Var) == null) {
            this.c.c(am0Var);
        }
    }

    public void j(@NonNull am0 am0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, am0Var) == null) {
            f(AdDownloadAction.PROGRESS_UPDATE, am0Var);
            this.c.d(am0Var, new ol0(am0Var));
        }
    }

    public void k(@NonNull am0 am0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, am0Var) == null) {
            f(AdDownloadAction.PROGRESS_UPDATE, am0Var);
            am0Var.b = this.c.a(am0Var, new ol0(am0Var));
            am0Var.c = AdDownloadStatus.DOWNLOADING;
        }
    }

    public static nl0 b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            return b.a;
        }
        return (nl0) invokeV.objValue;
    }

    public static void c(@NonNull am0 am0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65539, null, am0Var) == null) {
            if (!TextUtils.isEmpty(am0Var.p.c) && uj0.b(am0Var.p.c)) {
                if (fo0.b().a().a("nad_als_open_to_click_switch", 0) == 1) {
                    d(AdDownloadAction.OPEN, am0Var);
                    return;
                }
                return;
            }
            en0.g(am0Var.d);
            d(AdDownloadAction.OPEN, am0Var);
        }
    }

    public static void d(@NonNull AdDownloadAction adDownloadAction, @NonNull am0 am0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, null, adDownloadAction, am0Var) == null) {
            e(adDownloadAction, am0Var, null);
        }
    }

    public void f(@NonNull AdDownloadAction adDownloadAction, @NonNull am0 am0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, adDownloadAction, am0Var) == null) {
            g(adDownloadAction, am0Var, null);
        }
    }

    public static void e(@NonNull AdDownloadAction adDownloadAction, @NonNull am0 am0Var, @Nullable im0 im0Var) {
        ClogBuilder.LogType logType;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLLL(65541, null, adDownloadAction, am0Var, im0Var) != null) || TextUtils.isEmpty(am0Var.p.a)) {
            return;
        }
        String str = am0Var.q.j;
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
                if (fo0.b().a().a("nad_als_open_to_click_switch", 0) == 1) {
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
        clogBuilder.y(logType).p(am0Var.p.a).v(am0Var.q.a).j(str).k(am0Var.d).l(am0Var.q.a).m(am0Var.q.b).n(am0Var.g);
        JSONObject jSONObject = new JSONObject();
        z21.d(jSONObject, "is_swallow", 1);
        if (!TextUtils.isEmpty(am0Var.q.d)) {
            z21.f(jSONObject, "ad_download_content_type", am0Var.q.d);
        }
        long j = am0Var.q.e;
        if (j > 0) {
            z21.e(jSONObject, "ad_download_content_length", j);
        }
        int i = am0Var.n;
        if (i > 0) {
            z21.d(jSONObject, "version_code", i);
        }
        if (!TextUtils.isEmpty(am0Var.o)) {
            z21.f(jSONObject, NativeUnifiedADAppInfoImpl.Keys.VERSION_NAME, am0Var.o);
        }
        if (im0Var != null) {
            Exception exc = im0Var.a;
            if (exc != null) {
                z21.f(jSONObject, "failed_reason", exc.getClass().toString());
            }
            String str2 = im0Var.b;
            if (str2 != null) {
                z21.f(jSONObject, "failed_reason", str2);
            }
        }
        if (jSONObject.length() > 0) {
            clogBuilder.o(jSONObject.toString());
        }
        o31.b(clogBuilder);
    }

    public void g(@NonNull AdDownloadAction adDownloadAction, @NonNull am0 am0Var, @Nullable im0 im0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(Constants.METHOD_SEND_USER_MSG, this, adDownloadAction, am0Var, im0Var) == null) {
            e(adDownloadAction, am0Var, im0Var);
            this.b.readLock().lock();
            try {
                List list = (List) a31.b(this.a, am0Var.e());
                if (list == null) {
                    return;
                }
                for (int i = 0; i != y21.l(list); i++) {
                    sm0 sm0Var = (sm0) y21.d(list, i);
                    if (sm0Var != null && sm0Var.getData() != null) {
                        sm0Var.getData().i(am0Var);
                        sm0Var.a(adDownloadAction, sm0Var.getData());
                    }
                }
            } finally {
                this.b.readLock().unlock();
            }
        }
    }

    public void i(String str, sm0 sm0Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048580, this, str, sm0Var) == null) && !TextUtils.isEmpty(str) && sm0Var != null) {
            this.b.writeLock().lock();
            try {
                List list = (List) a31.b(this.a, str);
                if (list == null) {
                    list = new ArrayList();
                    a31.e(this.a, str, list);
                }
                y21.b(list, sm0Var);
            } finally {
                this.b.writeLock().unlock();
            }
        }
    }

    public void l(String str, sm0 sm0Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048583, this, str, sm0Var) == null) && !TextUtils.isEmpty(str) && sm0Var != null) {
            this.b.writeLock().lock();
            try {
                List list = (List) a31.b(this.a, str);
                if (list == null) {
                    return;
                }
                y21.j(list, sm0Var);
            } finally {
                this.b.writeLock().unlock();
            }
        }
    }
}
