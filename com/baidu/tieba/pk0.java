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
public class pk0 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final HashMap<String, List<ul0>> a;
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
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-515498825, "Lcom/baidu/tieba/pk0$a;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-515498825, "Lcom/baidu/tieba/pk0$a;");
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
        public static final pk0 a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-515498794, "Lcom/baidu/tieba/pk0$b;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-515498794, "Lcom/baidu/tieba/pk0$b;");
                    return;
                }
            }
            a = new pk0(null);
        }
    }

    public pk0() {
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
        this.c = wl0.b();
    }

    public /* synthetic */ pk0(a aVar) {
        this();
    }

    public static void c(@NonNull cl0 cl0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65539, null, cl0Var) == null) {
            if (!TextUtils.isEmpty(cl0Var.p.c) && wi0.b(cl0Var.p.c)) {
                return;
            }
            gm0.g(cl0Var.d);
            d(AdDownloadAction.OPEN, cl0Var);
        }
    }

    public void a(@NonNull cl0 cl0Var) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048576, this, cl0Var) != null) || cl0Var.f()) {
            return;
        }
        this.c.b(cl0Var);
        cl0Var.c = AdDownloadStatus.NONE;
        kl0 kl0Var = new kl0();
        kl0Var.b = "install_failed";
        g(AdDownloadAction.FAIL, cl0Var, kl0Var);
    }

    public void h(@NonNull cl0 cl0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, cl0Var) == null) {
            this.c.c(cl0Var);
        }
    }

    public void j(@NonNull cl0 cl0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, cl0Var) == null) {
            f(AdDownloadAction.PROGRESS_UPDATE, cl0Var);
            this.c.d(cl0Var, new qk0(cl0Var));
        }
    }

    public void k(@NonNull cl0 cl0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, cl0Var) == null) {
            f(AdDownloadAction.PROGRESS_UPDATE, cl0Var);
            cl0Var.b = this.c.a(cl0Var, new qk0(cl0Var));
            cl0Var.c = AdDownloadStatus.DOWNLOADING;
        }
    }

    public static pk0 b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            return b.a;
        }
        return (pk0) invokeV.objValue;
    }

    public static void d(@NonNull AdDownloadAction adDownloadAction, @NonNull cl0 cl0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, null, adDownloadAction, cl0Var) == null) {
            e(adDownloadAction, cl0Var, null);
        }
    }

    public void f(@NonNull AdDownloadAction adDownloadAction, @NonNull cl0 cl0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, adDownloadAction, cl0Var) == null) {
            g(adDownloadAction, cl0Var, null);
        }
    }

    public static void e(@NonNull AdDownloadAction adDownloadAction, @NonNull cl0 cl0Var, @Nullable kl0 kl0Var) {
        ClogBuilder.LogType logType;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLLL(65541, null, adDownloadAction, cl0Var, kl0Var) != null) || TextUtils.isEmpty(cl0Var.p.a)) {
            return;
        }
        String str = cl0Var.q.j;
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
        clogBuilder.y(logType).p(cl0Var.p.a).v(cl0Var.q.a).j(str).k(cl0Var.d).l(cl0Var.q.a).m(cl0Var.q.b).n(cl0Var.g);
        JSONObject jSONObject = new JSONObject();
        y11.d(jSONObject, "is_swallow", 1);
        if (!TextUtils.isEmpty(cl0Var.q.d)) {
            y11.f(jSONObject, "ad_download_content_type", cl0Var.q.d);
        }
        long j = cl0Var.q.e;
        if (j > 0) {
            y11.e(jSONObject, "ad_download_content_length", j);
        }
        int i = cl0Var.n;
        if (i > 0) {
            y11.d(jSONObject, "version_code", i);
        }
        if (!TextUtils.isEmpty(cl0Var.o)) {
            y11.f(jSONObject, "version_name", cl0Var.o);
        }
        if (kl0Var != null) {
            Exception exc = kl0Var.a;
            if (exc != null) {
                y11.f(jSONObject, "failed_reason", exc.getClass().toString());
            }
            String str2 = kl0Var.b;
            if (str2 != null) {
                y11.f(jSONObject, "failed_reason", str2);
            }
        }
        if (jSONObject.length() > 0) {
            clogBuilder.o(jSONObject.toString());
        }
        n21.b(clogBuilder);
    }

    public void g(@NonNull AdDownloadAction adDownloadAction, @NonNull cl0 cl0Var, @Nullable kl0 kl0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(Constants.METHOD_SEND_USER_MSG, this, adDownloadAction, cl0Var, kl0Var) == null) {
            e(adDownloadAction, cl0Var, kl0Var);
            this.b.readLock().lock();
            try {
                List list = (List) z11.b(this.a, cl0Var.e());
                if (list == null) {
                    return;
                }
                for (int i = 0; i != x11.l(list); i++) {
                    ul0 ul0Var = (ul0) x11.d(list, i);
                    if (ul0Var != null && ul0Var.getData() != null) {
                        ul0Var.getData().i(cl0Var);
                        ul0Var.a(adDownloadAction, ul0Var.getData());
                    }
                }
            } finally {
                this.b.readLock().unlock();
            }
        }
    }

    public void i(String str, ul0 ul0Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048580, this, str, ul0Var) == null) && !TextUtils.isEmpty(str) && ul0Var != null) {
            this.b.writeLock().lock();
            try {
                List list = (List) z11.b(this.a, str);
                if (list == null) {
                    list = new ArrayList();
                    z11.e(this.a, str, list);
                }
                x11.b(list, ul0Var);
            } finally {
                this.b.writeLock().unlock();
            }
        }
    }

    public void l(String str, ul0 ul0Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048583, this, str, ul0Var) == null) && !TextUtils.isEmpty(str) && ul0Var != null) {
            this.b.writeLock().lock();
            try {
                List list = (List) z11.b(this.a, str);
                if (list == null) {
                    return;
                }
                x11.j(list, ul0Var);
            } finally {
                this.b.writeLock().unlock();
            }
        }
    }
}
