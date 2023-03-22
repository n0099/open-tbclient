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
public class jj0 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final HashMap<String, List<ok0>> a;
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
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-688197252, "Lcom/baidu/tieba/jj0$a;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-688197252, "Lcom/baidu/tieba/jj0$a;");
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
        public static final jj0 a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-688197221, "Lcom/baidu/tieba/jj0$b;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-688197221, "Lcom/baidu/tieba/jj0$b;");
                    return;
                }
            }
            a = new jj0(null);
        }
    }

    public jj0() {
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
        this.c = qk0.b();
    }

    public /* synthetic */ jj0(a aVar) {
        this();
    }

    public void a(@NonNull wj0 wj0Var) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048576, this, wj0Var) != null) || wj0Var.f()) {
            return;
        }
        this.c.b(wj0Var);
        wj0Var.c = AdDownloadStatus.NONE;
        ek0 ek0Var = new ek0();
        ek0Var.b = "install_failed";
        g(AdDownloadAction.FAIL, wj0Var, ek0Var);
    }

    public void h(@NonNull wj0 wj0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, wj0Var) == null) {
            this.c.c(wj0Var);
        }
    }

    public void j(@NonNull wj0 wj0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, wj0Var) == null) {
            f(AdDownloadAction.PROGRESS_UPDATE, wj0Var);
            this.c.d(wj0Var, new kj0(wj0Var));
        }
    }

    public void k(@NonNull wj0 wj0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, wj0Var) == null) {
            f(AdDownloadAction.PROGRESS_UPDATE, wj0Var);
            wj0Var.b = this.c.a(wj0Var, new kj0(wj0Var));
            wj0Var.c = AdDownloadStatus.DOWNLOADING;
        }
    }

    public static jj0 b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            return b.a;
        }
        return (jj0) invokeV.objValue;
    }

    public static void c(@NonNull wj0 wj0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65539, null, wj0Var) == null) {
            if (!TextUtils.isEmpty(wj0Var.p.c) && qh0.b(wj0Var.p.c)) {
                if (bm0.b().a().a("nad_als_open_to_click_switch", 0) == 1) {
                    d(AdDownloadAction.OPEN, wj0Var);
                    return;
                }
                return;
            }
            al0.g(wj0Var.d);
            d(AdDownloadAction.OPEN, wj0Var);
        }
    }

    public static void d(@NonNull AdDownloadAction adDownloadAction, @NonNull wj0 wj0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, null, adDownloadAction, wj0Var) == null) {
            e(adDownloadAction, wj0Var, null);
        }
    }

    public void f(@NonNull AdDownloadAction adDownloadAction, @NonNull wj0 wj0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, adDownloadAction, wj0Var) == null) {
            g(adDownloadAction, wj0Var, null);
        }
    }

    public static void e(@NonNull AdDownloadAction adDownloadAction, @NonNull wj0 wj0Var, @Nullable ek0 ek0Var) {
        ClogBuilder.LogType logType;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLLL(65541, null, adDownloadAction, wj0Var, ek0Var) != null) || TextUtils.isEmpty(wj0Var.p.a)) {
            return;
        }
        String str = wj0Var.q.j;
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
                if (bm0.b().a().a("nad_als_open_to_click_switch", 0) == 1) {
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
        clogBuilder.y(logType).p(wj0Var.p.a).v(wj0Var.q.a).j(str).k(wj0Var.d).l(wj0Var.q.a).m(wj0Var.q.b).n(wj0Var.g);
        JSONObject jSONObject = new JSONObject();
        v01.d(jSONObject, "is_swallow", 1);
        if (!TextUtils.isEmpty(wj0Var.q.d)) {
            v01.f(jSONObject, "ad_download_content_type", wj0Var.q.d);
        }
        long j = wj0Var.q.e;
        if (j > 0) {
            v01.e(jSONObject, "ad_download_content_length", j);
        }
        int i = wj0Var.n;
        if (i > 0) {
            v01.d(jSONObject, "version_code", i);
        }
        if (!TextUtils.isEmpty(wj0Var.o)) {
            v01.f(jSONObject, "version_name", wj0Var.o);
        }
        if (ek0Var != null) {
            Exception exc = ek0Var.a;
            if (exc != null) {
                v01.f(jSONObject, "failed_reason", exc.getClass().toString());
            }
            String str2 = ek0Var.b;
            if (str2 != null) {
                v01.f(jSONObject, "failed_reason", str2);
            }
        }
        if (jSONObject.length() > 0) {
            clogBuilder.o(jSONObject.toString());
        }
        k11.b(clogBuilder);
    }

    public void g(@NonNull AdDownloadAction adDownloadAction, @NonNull wj0 wj0Var, @Nullable ek0 ek0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(Constants.METHOD_SEND_USER_MSG, this, adDownloadAction, wj0Var, ek0Var) == null) {
            e(adDownloadAction, wj0Var, ek0Var);
            this.b.readLock().lock();
            try {
                List list = (List) w01.b(this.a, wj0Var.e());
                if (list == null) {
                    return;
                }
                for (int i = 0; i != u01.l(list); i++) {
                    ok0 ok0Var = (ok0) u01.d(list, i);
                    if (ok0Var != null && ok0Var.getData() != null) {
                        ok0Var.getData().i(wj0Var);
                        ok0Var.a(adDownloadAction, ok0Var.getData());
                    }
                }
            } finally {
                this.b.readLock().unlock();
            }
        }
    }

    public void i(String str, ok0 ok0Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048580, this, str, ok0Var) == null) && !TextUtils.isEmpty(str) && ok0Var != null) {
            this.b.writeLock().lock();
            try {
                List list = (List) w01.b(this.a, str);
                if (list == null) {
                    list = new ArrayList();
                    w01.e(this.a, str, list);
                }
                u01.b(list, ok0Var);
            } finally {
                this.b.writeLock().unlock();
            }
        }
    }

    public void l(String str, ok0 ok0Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048583, this, str, ok0Var) == null) && !TextUtils.isEmpty(str) && ok0Var != null) {
            this.b.writeLock().lock();
            try {
                List list = (List) w01.b(this.a, str);
                if (list == null) {
                    return;
                }
                u01.j(list, ok0Var);
            } finally {
                this.b.writeLock().unlock();
            }
        }
    }
}
