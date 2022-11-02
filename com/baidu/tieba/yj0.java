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
/* loaded from: classes6.dex */
public class yj0 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final HashMap<String, List<dl0>> a;
    public final ReentrantReadWriteLock b;
    public final IAdDownloader c;

    /* loaded from: classes6.dex */
    public static /* synthetic */ class a {
        public static /* synthetic */ Interceptable $ic;
        public static final /* synthetic */ int[] a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-258759987, "Lcom/baidu/tieba/yj0$a;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-258759987, "Lcom/baidu/tieba/yj0$a;");
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

    /* loaded from: classes6.dex */
    public static class b {
        public static /* synthetic */ Interceptable $ic;
        public static final yj0 a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-258759956, "Lcom/baidu/tieba/yj0$b;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-258759956, "Lcom/baidu/tieba/yj0$b;");
                    return;
                }
            }
            a = new yj0(null);
        }
    }

    public yj0() {
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
        this.c = fl0.b();
    }

    public /* synthetic */ yj0(a aVar) {
        this();
    }

    public static void c(@NonNull lk0 lk0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65539, null, lk0Var) == null) {
            if (!TextUtils.isEmpty(lk0Var.p.c) && ii0.b(lk0Var.p.c)) {
                return;
            }
            pl0.g(lk0Var.d);
            d(AdDownloadAction.OPEN, lk0Var);
        }
    }

    public void a(@NonNull lk0 lk0Var) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048576, this, lk0Var) != null) || lk0Var.f()) {
            return;
        }
        this.c.b(lk0Var);
        lk0Var.c = AdDownloadStatus.NONE;
        tk0 tk0Var = new tk0();
        tk0Var.b = "install_failed";
        g(AdDownloadAction.FAIL, lk0Var, tk0Var);
    }

    public void h(@NonNull lk0 lk0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, lk0Var) == null) {
            this.c.c(lk0Var);
        }
    }

    public void j(@NonNull lk0 lk0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, lk0Var) == null) {
            f(AdDownloadAction.PROGRESS_UPDATE, lk0Var);
            this.c.d(lk0Var, new zj0(lk0Var));
        }
    }

    public void k(@NonNull lk0 lk0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, lk0Var) == null) {
            f(AdDownloadAction.PROGRESS_UPDATE, lk0Var);
            lk0Var.b = this.c.a(lk0Var, new zj0(lk0Var));
            lk0Var.c = AdDownloadStatus.DOWNLOADING;
        }
    }

    public static yj0 b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            return b.a;
        }
        return (yj0) invokeV.objValue;
    }

    public static void d(@NonNull AdDownloadAction adDownloadAction, @NonNull lk0 lk0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, null, adDownloadAction, lk0Var) == null) {
            e(adDownloadAction, lk0Var, null);
        }
    }

    public void f(@NonNull AdDownloadAction adDownloadAction, @NonNull lk0 lk0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, adDownloadAction, lk0Var) == null) {
            g(adDownloadAction, lk0Var, null);
        }
    }

    public static void e(@NonNull AdDownloadAction adDownloadAction, @NonNull lk0 lk0Var, @Nullable tk0 tk0Var) {
        ClogBuilder.LogType logType;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLLL(65541, null, adDownloadAction, lk0Var, tk0Var) != null) || TextUtils.isEmpty(lk0Var.p.a)) {
            return;
        }
        String str = lk0Var.q.j;
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
                logType = ClogBuilder.LogType.DEEP_LINK;
                break;
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
        clogBuilder.y(logType).p(lk0Var.p.a).v(lk0Var.q.a).j(str).k(lk0Var.d).l(lk0Var.q.a).m(lk0Var.q.b).n(lk0Var.g);
        JSONObject jSONObject = new JSONObject();
        if (!TextUtils.isEmpty(lk0Var.q.d)) {
            p01.f(jSONObject, "ad_download_content_type", lk0Var.q.d);
        }
        long j = lk0Var.q.e;
        if (j > 0) {
            p01.e(jSONObject, "ad_download_content_length", j);
        }
        int i = lk0Var.n;
        if (i > 0) {
            p01.d(jSONObject, "version_code", i);
        }
        if (!TextUtils.isEmpty(lk0Var.o)) {
            p01.f(jSONObject, "version_name", lk0Var.o);
        }
        if (tk0Var != null) {
            Exception exc = tk0Var.a;
            if (exc != null) {
                p01.f(jSONObject, "failed_reason", exc.getClass().toString());
            }
            String str2 = tk0Var.b;
            if (str2 != null) {
                p01.f(jSONObject, "failed_reason", str2);
            }
        }
        if (jSONObject.length() > 0) {
            clogBuilder.o(jSONObject.toString());
        }
        z01.b(clogBuilder);
    }

    public void g(@NonNull AdDownloadAction adDownloadAction, @NonNull lk0 lk0Var, @Nullable tk0 tk0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(Constants.METHOD_SEND_USER_MSG, this, adDownloadAction, lk0Var, tk0Var) == null) {
            e(adDownloadAction, lk0Var, tk0Var);
            this.b.readLock().lock();
            try {
                List list = (List) q01.b(this.a, lk0Var.e());
                if (list == null) {
                    return;
                }
                for (int i = 0; i != o01.l(list); i++) {
                    dl0 dl0Var = (dl0) o01.d(list, i);
                    if (dl0Var != null && dl0Var.getData() != null) {
                        dl0Var.getData().i(lk0Var);
                        dl0Var.a(adDownloadAction, dl0Var.getData());
                    }
                }
            } finally {
                this.b.readLock().unlock();
            }
        }
    }

    public void i(String str, dl0 dl0Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048580, this, str, dl0Var) == null) && !TextUtils.isEmpty(str) && dl0Var != null) {
            this.b.writeLock().lock();
            try {
                List list = (List) q01.b(this.a, str);
                if (list == null) {
                    list = new ArrayList();
                    q01.e(this.a, str, list);
                }
                o01.b(list, dl0Var);
            } finally {
                this.b.writeLock().unlock();
            }
        }
    }

    public void l(String str, dl0 dl0Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048583, this, str, dl0Var) == null) && !TextUtils.isEmpty(str) && dl0Var != null) {
            this.b.writeLock().lock();
            try {
                List list = (List) q01.b(this.a, str);
                if (list == null) {
                    return;
                }
                o01.j(list, dl0Var);
            } finally {
                this.b.writeLock().unlock();
            }
        }
    }
}
