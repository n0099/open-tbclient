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
/* loaded from: classes6.dex */
public class ml0 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final HashMap<String, List<rm0>> a;
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
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-600462757, "Lcom/baidu/tieba/ml0$a;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-600462757, "Lcom/baidu/tieba/ml0$a;");
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
        public static final ml0 a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-600462726, "Lcom/baidu/tieba/ml0$b;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-600462726, "Lcom/baidu/tieba/ml0$b;");
                    return;
                }
            }
            a = new ml0(null);
        }
    }

    public ml0() {
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
        this.c = tm0.b();
    }

    public /* synthetic */ ml0(a aVar) {
        this();
    }

    public void a(@NonNull zl0 zl0Var) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048576, this, zl0Var) != null) || zl0Var.f()) {
            return;
        }
        this.c.b(zl0Var);
        zl0Var.c = AdDownloadStatus.NONE;
        hm0 hm0Var = new hm0();
        hm0Var.b = "install_failed";
        g(AdDownloadAction.FAIL, zl0Var, hm0Var);
    }

    public void h(@NonNull zl0 zl0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, zl0Var) == null) {
            this.c.c(zl0Var);
        }
    }

    public void j(@NonNull zl0 zl0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, zl0Var) == null) {
            f(AdDownloadAction.PROGRESS_UPDATE, zl0Var);
            this.c.d(zl0Var, new nl0(zl0Var));
        }
    }

    public void k(@NonNull zl0 zl0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, zl0Var) == null) {
            f(AdDownloadAction.PROGRESS_UPDATE, zl0Var);
            zl0Var.b = this.c.a(zl0Var, new nl0(zl0Var));
            zl0Var.c = AdDownloadStatus.DOWNLOADING;
        }
    }

    public static ml0 b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            return b.a;
        }
        return (ml0) invokeV.objValue;
    }

    public static void c(@NonNull zl0 zl0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65539, null, zl0Var) == null) {
            if (!TextUtils.isEmpty(zl0Var.p.c) && tj0.b(zl0Var.p.c)) {
                if (eo0.b().a().a("nad_als_open_to_click_switch", 0) == 1) {
                    d(AdDownloadAction.OPEN, zl0Var);
                    return;
                }
                return;
            }
            dn0.g(zl0Var.d);
            d(AdDownloadAction.OPEN, zl0Var);
        }
    }

    public static void d(@NonNull AdDownloadAction adDownloadAction, @NonNull zl0 zl0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, null, adDownloadAction, zl0Var) == null) {
            e(adDownloadAction, zl0Var, null);
        }
    }

    public void f(@NonNull AdDownloadAction adDownloadAction, @NonNull zl0 zl0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, adDownloadAction, zl0Var) == null) {
            g(adDownloadAction, zl0Var, null);
        }
    }

    public static void e(@NonNull AdDownloadAction adDownloadAction, @NonNull zl0 zl0Var, @Nullable hm0 hm0Var) {
        ClogBuilder.LogType logType;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLLL(65541, null, adDownloadAction, zl0Var, hm0Var) != null) || TextUtils.isEmpty(zl0Var.p.a)) {
            return;
        }
        String str = zl0Var.q.j;
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
                if (eo0.b().a().a("nad_als_open_to_click_switch", 0) == 1) {
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
        clogBuilder.y(logType).p(zl0Var.p.a).v(zl0Var.q.a).j(str).k(zl0Var.d).l(zl0Var.q.a).m(zl0Var.q.b).n(zl0Var.g);
        JSONObject jSONObject = new JSONObject();
        y21.d(jSONObject, "is_swallow", 1);
        if (!TextUtils.isEmpty(zl0Var.q.d)) {
            y21.f(jSONObject, "ad_download_content_type", zl0Var.q.d);
        }
        long j = zl0Var.q.e;
        if (j > 0) {
            y21.e(jSONObject, "ad_download_content_length", j);
        }
        int i = zl0Var.n;
        if (i > 0) {
            y21.d(jSONObject, "version_code", i);
        }
        if (!TextUtils.isEmpty(zl0Var.o)) {
            y21.f(jSONObject, NativeUnifiedADAppInfoImpl.Keys.VERSION_NAME, zl0Var.o);
        }
        if (hm0Var != null) {
            Exception exc = hm0Var.a;
            if (exc != null) {
                y21.f(jSONObject, "failed_reason", exc.getClass().toString());
            }
            String str2 = hm0Var.b;
            if (str2 != null) {
                y21.f(jSONObject, "failed_reason", str2);
            }
        }
        if (jSONObject.length() > 0) {
            clogBuilder.o(jSONObject.toString());
        }
        n31.b(clogBuilder);
    }

    public void g(@NonNull AdDownloadAction adDownloadAction, @NonNull zl0 zl0Var, @Nullable hm0 hm0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(Constants.METHOD_SEND_USER_MSG, this, adDownloadAction, zl0Var, hm0Var) == null) {
            e(adDownloadAction, zl0Var, hm0Var);
            this.b.readLock().lock();
            try {
                List list = (List) z21.b(this.a, zl0Var.e());
                if (list == null) {
                    return;
                }
                for (int i = 0; i != x21.l(list); i++) {
                    rm0 rm0Var = (rm0) x21.d(list, i);
                    if (rm0Var != null && rm0Var.getData() != null) {
                        rm0Var.getData().i(zl0Var);
                        rm0Var.a(adDownloadAction, rm0Var.getData());
                    }
                }
            } finally {
                this.b.readLock().unlock();
            }
        }
    }

    public void i(String str, rm0 rm0Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048580, this, str, rm0Var) == null) && !TextUtils.isEmpty(str) && rm0Var != null) {
            this.b.writeLock().lock();
            try {
                List list = (List) z21.b(this.a, str);
                if (list == null) {
                    list = new ArrayList();
                    z21.e(this.a, str, list);
                }
                x21.b(list, rm0Var);
            } finally {
                this.b.writeLock().unlock();
            }
        }
    }

    public void l(String str, rm0 rm0Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048583, this, str, rm0Var) == null) && !TextUtils.isEmpty(str) && rm0Var != null) {
            this.b.writeLock().lock();
            try {
                List list = (List) z21.b(this.a, str);
                if (list == null) {
                    return;
                }
                x21.j(list, rm0Var);
            } finally {
                this.b.writeLock().unlock();
            }
        }
    }
}
