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
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class kj0 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final HashMap<String, List<pk0>> a;
    public final ReentrantReadWriteLock b;
    public final IAdDownloader c;

    /* loaded from: classes5.dex */
    public static /* synthetic */ class a {
        public static /* synthetic */ Interceptable $ic;
        public static final /* synthetic */ int[] a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-659568101, "Lcom/baidu/tieba/kj0$a;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-659568101, "Lcom/baidu/tieba/kj0$a;");
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

    /* loaded from: classes5.dex */
    public static class b {
        public static /* synthetic */ Interceptable $ic;
        public static final kj0 a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-659568070, "Lcom/baidu/tieba/kj0$b;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-659568070, "Lcom/baidu/tieba/kj0$b;");
                    return;
                }
            }
            a = new kj0(null);
        }
    }

    public kj0() {
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
        this.c = rk0.b();
    }

    public /* synthetic */ kj0(a aVar) {
        this();
    }

    public void a(@NonNull xj0 xj0Var) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048576, this, xj0Var) != null) || xj0Var.f()) {
            return;
        }
        this.c.b(xj0Var);
        xj0Var.c = AdDownloadStatus.NONE;
        fk0 fk0Var = new fk0();
        fk0Var.b = "install_failed";
        g(AdDownloadAction.FAIL, xj0Var, fk0Var);
    }

    public void h(@NonNull xj0 xj0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, xj0Var) == null) {
            this.c.c(xj0Var);
        }
    }

    public void j(@NonNull xj0 xj0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, xj0Var) == null) {
            f(AdDownloadAction.PROGRESS_UPDATE, xj0Var);
            this.c.d(xj0Var, new lj0(xj0Var));
        }
    }

    public void k(@NonNull xj0 xj0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, xj0Var) == null) {
            f(AdDownloadAction.PROGRESS_UPDATE, xj0Var);
            xj0Var.b = this.c.a(xj0Var, new lj0(xj0Var));
            xj0Var.c = AdDownloadStatus.DOWNLOADING;
        }
    }

    public static kj0 b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            return b.a;
        }
        return (kj0) invokeV.objValue;
    }

    public static void c(@NonNull xj0 xj0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65539, null, xj0Var) == null) {
            if (!TextUtils.isEmpty(xj0Var.p.c) && rh0.b(xj0Var.p.c)) {
                if (cm0.b().a().a("nad_als_open_to_click_switch", 0) == 1) {
                    d(AdDownloadAction.OPEN, xj0Var);
                    return;
                }
                return;
            }
            bl0.g(xj0Var.d);
            d(AdDownloadAction.OPEN, xj0Var);
        }
    }

    public static void d(@NonNull AdDownloadAction adDownloadAction, @NonNull xj0 xj0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, null, adDownloadAction, xj0Var) == null) {
            e(adDownloadAction, xj0Var, null);
        }
    }

    public void f(@NonNull AdDownloadAction adDownloadAction, @NonNull xj0 xj0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, adDownloadAction, xj0Var) == null) {
            g(adDownloadAction, xj0Var, null);
        }
    }

    public static void e(@NonNull AdDownloadAction adDownloadAction, @NonNull xj0 xj0Var, @Nullable fk0 fk0Var) {
        ClogBuilder.LogType logType;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLLL(65541, null, adDownloadAction, xj0Var, fk0Var) != null) || TextUtils.isEmpty(xj0Var.p.a)) {
            return;
        }
        String str = xj0Var.q.j;
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
                if (cm0.b().a().a("nad_als_open_to_click_switch", 0) == 1) {
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
        clogBuilder.y(logType).p(xj0Var.p.a).v(xj0Var.q.a).j(str).k(xj0Var.d).l(xj0Var.q.a).m(xj0Var.q.b).n(xj0Var.g);
        JSONObject jSONObject = new JSONObject();
        w01.d(jSONObject, "is_swallow", 1);
        if (!TextUtils.isEmpty(xj0Var.q.d)) {
            w01.f(jSONObject, "ad_download_content_type", xj0Var.q.d);
        }
        long j = xj0Var.q.e;
        if (j > 0) {
            w01.e(jSONObject, "ad_download_content_length", j);
        }
        int i = xj0Var.n;
        if (i > 0) {
            w01.d(jSONObject, "version_code", i);
        }
        if (!TextUtils.isEmpty(xj0Var.o)) {
            w01.f(jSONObject, "version_name", xj0Var.o);
        }
        if (fk0Var != null) {
            Exception exc = fk0Var.a;
            if (exc != null) {
                w01.f(jSONObject, "failed_reason", exc.getClass().toString());
            }
            String str2 = fk0Var.b;
            if (str2 != null) {
                w01.f(jSONObject, "failed_reason", str2);
            }
        }
        if (jSONObject.length() > 0) {
            clogBuilder.o(jSONObject.toString());
        }
        l11.b(clogBuilder);
    }

    public void g(@NonNull AdDownloadAction adDownloadAction, @NonNull xj0 xj0Var, @Nullable fk0 fk0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(Constants.METHOD_SEND_USER_MSG, this, adDownloadAction, xj0Var, fk0Var) == null) {
            e(adDownloadAction, xj0Var, fk0Var);
            this.b.readLock().lock();
            try {
                List list = (List) x01.b(this.a, xj0Var.e());
                if (list == null) {
                    return;
                }
                for (int i = 0; i != v01.l(list); i++) {
                    pk0 pk0Var = (pk0) v01.d(list, i);
                    if (pk0Var != null && pk0Var.getData() != null) {
                        pk0Var.getData().i(xj0Var);
                        pk0Var.a(adDownloadAction, pk0Var.getData());
                    }
                }
            } finally {
                this.b.readLock().unlock();
            }
        }
    }

    public void i(String str, pk0 pk0Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048580, this, str, pk0Var) == null) && !TextUtils.isEmpty(str) && pk0Var != null) {
            this.b.writeLock().lock();
            try {
                List list = (List) x01.b(this.a, str);
                if (list == null) {
                    list = new ArrayList();
                    x01.e(this.a, str, list);
                }
                v01.b(list, pk0Var);
            } finally {
                this.b.writeLock().unlock();
            }
        }
    }

    public void l(String str, pk0 pk0Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048583, this, str, pk0Var) == null) && !TextUtils.isEmpty(str) && pk0Var != null) {
            this.b.writeLock().lock();
            try {
                List list = (List) x01.b(this.a, str);
                if (list == null) {
                    return;
                }
                v01.j(list, pk0Var);
            } finally {
                this.b.writeLock().unlock();
            }
        }
    }
}
