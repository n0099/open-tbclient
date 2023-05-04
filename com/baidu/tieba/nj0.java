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
public class nj0 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final HashMap<String, List<sk0>> a;
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
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-573680648, "Lcom/baidu/tieba/nj0$a;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-573680648, "Lcom/baidu/tieba/nj0$a;");
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
        public static final nj0 a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-573680617, "Lcom/baidu/tieba/nj0$b;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-573680617, "Lcom/baidu/tieba/nj0$b;");
                    return;
                }
            }
            a = new nj0(null);
        }
    }

    public nj0() {
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
        this.c = uk0.b();
    }

    public /* synthetic */ nj0(a aVar) {
        this();
    }

    public void a(@NonNull ak0 ak0Var) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048576, this, ak0Var) != null) || ak0Var.f()) {
            return;
        }
        this.c.b(ak0Var);
        ak0Var.c = AdDownloadStatus.NONE;
        ik0 ik0Var = new ik0();
        ik0Var.b = "install_failed";
        g(AdDownloadAction.FAIL, ak0Var, ik0Var);
    }

    public void h(@NonNull ak0 ak0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, ak0Var) == null) {
            this.c.c(ak0Var);
        }
    }

    public void j(@NonNull ak0 ak0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, ak0Var) == null) {
            f(AdDownloadAction.PROGRESS_UPDATE, ak0Var);
            this.c.d(ak0Var, new oj0(ak0Var));
        }
    }

    public void k(@NonNull ak0 ak0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, ak0Var) == null) {
            f(AdDownloadAction.PROGRESS_UPDATE, ak0Var);
            ak0Var.b = this.c.a(ak0Var, new oj0(ak0Var));
            ak0Var.c = AdDownloadStatus.DOWNLOADING;
        }
    }

    public static nj0 b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            return b.a;
        }
        return (nj0) invokeV.objValue;
    }

    public static void c(@NonNull ak0 ak0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65539, null, ak0Var) == null) {
            if (!TextUtils.isEmpty(ak0Var.p.c) && uh0.b(ak0Var.p.c)) {
                if (fm0.b().a().a("nad_als_open_to_click_switch", 0) == 1) {
                    d(AdDownloadAction.OPEN, ak0Var);
                    return;
                }
                return;
            }
            el0.g(ak0Var.d);
            d(AdDownloadAction.OPEN, ak0Var);
        }
    }

    public static void d(@NonNull AdDownloadAction adDownloadAction, @NonNull ak0 ak0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, null, adDownloadAction, ak0Var) == null) {
            e(adDownloadAction, ak0Var, null);
        }
    }

    public void f(@NonNull AdDownloadAction adDownloadAction, @NonNull ak0 ak0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, adDownloadAction, ak0Var) == null) {
            g(adDownloadAction, ak0Var, null);
        }
    }

    public static void e(@NonNull AdDownloadAction adDownloadAction, @NonNull ak0 ak0Var, @Nullable ik0 ik0Var) {
        ClogBuilder.LogType logType;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLLL(65541, null, adDownloadAction, ak0Var, ik0Var) != null) || TextUtils.isEmpty(ak0Var.p.a)) {
            return;
        }
        String str = ak0Var.q.j;
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
                if (fm0.b().a().a("nad_als_open_to_click_switch", 0) == 1) {
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
        clogBuilder.y(logType).p(ak0Var.p.a).v(ak0Var.q.a).j(str).k(ak0Var.d).l(ak0Var.q.a).m(ak0Var.q.b).n(ak0Var.g);
        JSONObject jSONObject = new JSONObject();
        z01.d(jSONObject, "is_swallow", 1);
        if (!TextUtils.isEmpty(ak0Var.q.d)) {
            z01.f(jSONObject, "ad_download_content_type", ak0Var.q.d);
        }
        long j = ak0Var.q.e;
        if (j > 0) {
            z01.e(jSONObject, "ad_download_content_length", j);
        }
        int i = ak0Var.n;
        if (i > 0) {
            z01.d(jSONObject, "version_code", i);
        }
        if (!TextUtils.isEmpty(ak0Var.o)) {
            z01.f(jSONObject, "version_name", ak0Var.o);
        }
        if (ik0Var != null) {
            Exception exc = ik0Var.a;
            if (exc != null) {
                z01.f(jSONObject, "failed_reason", exc.getClass().toString());
            }
            String str2 = ik0Var.b;
            if (str2 != null) {
                z01.f(jSONObject, "failed_reason", str2);
            }
        }
        if (jSONObject.length() > 0) {
            clogBuilder.o(jSONObject.toString());
        }
        o11.b(clogBuilder);
    }

    public void g(@NonNull AdDownloadAction adDownloadAction, @NonNull ak0 ak0Var, @Nullable ik0 ik0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(Constants.METHOD_SEND_USER_MSG, this, adDownloadAction, ak0Var, ik0Var) == null) {
            e(adDownloadAction, ak0Var, ik0Var);
            this.b.readLock().lock();
            try {
                List list = (List) a11.b(this.a, ak0Var.e());
                if (list == null) {
                    return;
                }
                for (int i = 0; i != y01.l(list); i++) {
                    sk0 sk0Var = (sk0) y01.d(list, i);
                    if (sk0Var != null && sk0Var.getData() != null) {
                        sk0Var.getData().i(ak0Var);
                        sk0Var.a(adDownloadAction, sk0Var.getData());
                    }
                }
            } finally {
                this.b.readLock().unlock();
            }
        }
    }

    public void i(String str, sk0 sk0Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048580, this, str, sk0Var) == null) && !TextUtils.isEmpty(str) && sk0Var != null) {
            this.b.writeLock().lock();
            try {
                List list = (List) a11.b(this.a, str);
                if (list == null) {
                    list = new ArrayList();
                    a11.e(this.a, str, list);
                }
                y01.b(list, sk0Var);
            } finally {
                this.b.writeLock().unlock();
            }
        }
    }

    public void l(String str, sk0 sk0Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048583, this, str, sk0Var) == null) && !TextUtils.isEmpty(str) && sk0Var != null) {
            this.b.writeLock().lock();
            try {
                List list = (List) a11.b(this.a, str);
                if (list == null) {
                    return;
                }
                y01.j(list, sk0Var);
            } finally {
                this.b.writeLock().unlock();
            }
        }
    }
}
