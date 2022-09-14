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
/* loaded from: classes4.dex */
public class lj0 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final HashMap<String, List<qk0>> a;
    public final ReentrantReadWriteLock b;
    public final IAdDownloader c;

    /* loaded from: classes4.dex */
    public static /* synthetic */ class a {
        public static /* synthetic */ Interceptable $ic;
        public static final /* synthetic */ int[] a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-630938950, "Lcom/baidu/tieba/lj0$a;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-630938950, "Lcom/baidu/tieba/lj0$a;");
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

    /* loaded from: classes4.dex */
    public static class b {
        public static /* synthetic */ Interceptable $ic;
        public static final lj0 a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-630938919, "Lcom/baidu/tieba/lj0$b;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-630938919, "Lcom/baidu/tieba/lj0$b;");
                    return;
                }
            }
            a = new lj0(null);
        }
    }

    public /* synthetic */ lj0(a aVar) {
        this();
    }

    public static lj0 b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) ? b.a : (lj0) invokeV.objValue;
    }

    public static void c(@NonNull yj0 yj0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65539, null, yj0Var) == null) {
            if (TextUtils.isEmpty(yj0Var.p.c) || !vh0.b(yj0Var.p.c)) {
                cl0.f(yj0Var.d);
                d(AdDownloadAction.OPEN, yj0Var);
            }
        }
    }

    public static void d(@NonNull AdDownloadAction adDownloadAction, @NonNull yj0 yj0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, null, adDownloadAction, yj0Var) == null) {
            e(adDownloadAction, yj0Var, null);
        }
    }

    public static void e(@NonNull AdDownloadAction adDownloadAction, @NonNull yj0 yj0Var, @Nullable gk0 gk0Var) {
        ClogBuilder.LogType logType;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLL(65541, null, adDownloadAction, yj0Var, gk0Var) == null) || TextUtils.isEmpty(yj0Var.p.a)) {
            return;
        }
        String str = yj0Var.q.j;
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
        clogBuilder.y(logType).p(yj0Var.p.a).v(yj0Var.q.a).j(str).k(yj0Var.d).l(yj0Var.q.a).m(yj0Var.q.b).n(yj0Var.g);
        JSONObject jSONObject = new JSONObject();
        if (!TextUtils.isEmpty(yj0Var.q.d)) {
            kz0.f(jSONObject, "ad_download_content_type", yj0Var.q.d);
        }
        long j = yj0Var.q.e;
        if (j > 0) {
            kz0.e(jSONObject, "ad_download_content_length", j);
        }
        int i = yj0Var.n;
        if (i > 0) {
            kz0.d(jSONObject, "version_code", i);
        }
        if (!TextUtils.isEmpty(yj0Var.o)) {
            kz0.f(jSONObject, "version_name", yj0Var.o);
        }
        if (gk0Var != null) {
            Exception exc = gk0Var.a;
            if (exc != null) {
                kz0.f(jSONObject, "failed_reason", exc.getClass().toString());
            }
            String str2 = gk0Var.b;
            if (str2 != null) {
                kz0.f(jSONObject, "failed_reason", str2);
            }
        }
        if (jSONObject.length() > 0) {
            clogBuilder.o(jSONObject.toString());
        }
        uz0.b(clogBuilder);
    }

    public void a(@NonNull yj0 yj0Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, yj0Var) == null) || yj0Var.f()) {
            return;
        }
        this.c.b(yj0Var);
        yj0Var.c = AdDownloadStatus.NONE;
        f(AdDownloadAction.FAIL, yj0Var);
    }

    public void f(@NonNull AdDownloadAction adDownloadAction, @NonNull yj0 yj0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, adDownloadAction, yj0Var) == null) {
            g(adDownloadAction, yj0Var, null);
        }
    }

    public void g(@NonNull AdDownloadAction adDownloadAction, @NonNull yj0 yj0Var, @Nullable gk0 gk0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(Constants.METHOD_SEND_USER_MSG, this, adDownloadAction, yj0Var, gk0Var) == null) {
            e(adDownloadAction, yj0Var, gk0Var);
            this.b.readLock().lock();
            try {
                List list = (List) lz0.b(this.a, yj0Var.e());
                if (list == null) {
                    return;
                }
                for (int i = 0; i != jz0.l(list); i++) {
                    qk0 qk0Var = (qk0) jz0.d(list, i);
                    if (qk0Var != null && qk0Var.getData() != null) {
                        qk0Var.getData().i(yj0Var);
                        qk0Var.a(adDownloadAction, qk0Var.getData());
                    }
                }
            } finally {
                this.b.readLock().unlock();
            }
        }
    }

    public void h(@NonNull yj0 yj0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, yj0Var) == null) {
            this.c.c(yj0Var);
        }
    }

    public void i(String str, qk0 qk0Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048580, this, str, qk0Var) == null) || TextUtils.isEmpty(str) || qk0Var == null) {
            return;
        }
        this.b.writeLock().lock();
        try {
            List list = (List) lz0.b(this.a, str);
            if (list == null) {
                list = new ArrayList();
                lz0.e(this.a, str, list);
            }
            jz0.b(list, qk0Var);
        } finally {
            this.b.writeLock().unlock();
        }
    }

    public void j(@NonNull yj0 yj0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, yj0Var) == null) {
            f(AdDownloadAction.PROGRESS_UPDATE, yj0Var);
            this.c.d(yj0Var, new mj0(yj0Var));
        }
    }

    public void k(@NonNull yj0 yj0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, yj0Var) == null) {
            f(AdDownloadAction.PROGRESS_UPDATE, yj0Var);
            yj0Var.b = this.c.a(yj0Var, new mj0(yj0Var));
            yj0Var.c = AdDownloadStatus.DOWNLOADING;
        }
    }

    public void l(String str, qk0 qk0Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048583, this, str, qk0Var) == null) || TextUtils.isEmpty(str) || qk0Var == null) {
            return;
        }
        this.b.writeLock().lock();
        try {
            List list = (List) lz0.b(this.a, str);
            if (list == null) {
                return;
            }
            jz0.j(list, qk0Var);
        } finally {
            this.b.writeLock().unlock();
        }
    }

    public lj0() {
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
        this.c = sk0.b();
    }
}
