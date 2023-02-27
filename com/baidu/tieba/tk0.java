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
public class tk0 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final HashMap<String, List<yl0>> a;
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
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-400982221, "Lcom/baidu/tieba/tk0$a;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-400982221, "Lcom/baidu/tieba/tk0$a;");
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
        public static final tk0 a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-400982190, "Lcom/baidu/tieba/tk0$b;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-400982190, "Lcom/baidu/tieba/tk0$b;");
                    return;
                }
            }
            a = new tk0(null);
        }
    }

    public tk0() {
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
        this.c = am0.b();
    }

    public /* synthetic */ tk0(a aVar) {
        this();
    }

    public void a(@NonNull gl0 gl0Var) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048576, this, gl0Var) != null) || gl0Var.f()) {
            return;
        }
        this.c.b(gl0Var);
        gl0Var.c = AdDownloadStatus.NONE;
        ol0 ol0Var = new ol0();
        ol0Var.b = "install_failed";
        g(AdDownloadAction.FAIL, gl0Var, ol0Var);
    }

    public void h(@NonNull gl0 gl0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, gl0Var) == null) {
            this.c.c(gl0Var);
        }
    }

    public void j(@NonNull gl0 gl0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, gl0Var) == null) {
            f(AdDownloadAction.PROGRESS_UPDATE, gl0Var);
            this.c.d(gl0Var, new uk0(gl0Var));
        }
    }

    public void k(@NonNull gl0 gl0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, gl0Var) == null) {
            f(AdDownloadAction.PROGRESS_UPDATE, gl0Var);
            gl0Var.b = this.c.a(gl0Var, new uk0(gl0Var));
            gl0Var.c = AdDownloadStatus.DOWNLOADING;
        }
    }

    public static tk0 b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            return b.a;
        }
        return (tk0) invokeV.objValue;
    }

    public static void c(@NonNull gl0 gl0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65539, null, gl0Var) == null) {
            if (!TextUtils.isEmpty(gl0Var.p.c) && aj0.b(gl0Var.p.c)) {
                if (ln0.b().a().a("nad_als_open_to_click_switch", 0) == 1) {
                    d(AdDownloadAction.OPEN, gl0Var);
                    return;
                }
                return;
            }
            km0.g(gl0Var.d);
            d(AdDownloadAction.OPEN, gl0Var);
        }
    }

    public static void d(@NonNull AdDownloadAction adDownloadAction, @NonNull gl0 gl0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, null, adDownloadAction, gl0Var) == null) {
            e(adDownloadAction, gl0Var, null);
        }
    }

    public void f(@NonNull AdDownloadAction adDownloadAction, @NonNull gl0 gl0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, adDownloadAction, gl0Var) == null) {
            g(adDownloadAction, gl0Var, null);
        }
    }

    public static void e(@NonNull AdDownloadAction adDownloadAction, @NonNull gl0 gl0Var, @Nullable ol0 ol0Var) {
        ClogBuilder.LogType logType;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLLL(65541, null, adDownloadAction, gl0Var, ol0Var) != null) || TextUtils.isEmpty(gl0Var.p.a)) {
            return;
        }
        String str = gl0Var.q.j;
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
                if (ln0.b().a().a("nad_als_open_to_click_switch", 0) == 1) {
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
        clogBuilder.y(logType).p(gl0Var.p.a).v(gl0Var.q.a).j(str).k(gl0Var.d).l(gl0Var.q.a).m(gl0Var.q.b).n(gl0Var.g);
        JSONObject jSONObject = new JSONObject();
        f21.d(jSONObject, "is_swallow", 1);
        if (!TextUtils.isEmpty(gl0Var.q.d)) {
            f21.f(jSONObject, "ad_download_content_type", gl0Var.q.d);
        }
        long j = gl0Var.q.e;
        if (j > 0) {
            f21.e(jSONObject, "ad_download_content_length", j);
        }
        int i = gl0Var.n;
        if (i > 0) {
            f21.d(jSONObject, "version_code", i);
        }
        if (!TextUtils.isEmpty(gl0Var.o)) {
            f21.f(jSONObject, "version_name", gl0Var.o);
        }
        if (ol0Var != null) {
            Exception exc = ol0Var.a;
            if (exc != null) {
                f21.f(jSONObject, "failed_reason", exc.getClass().toString());
            }
            String str2 = ol0Var.b;
            if (str2 != null) {
                f21.f(jSONObject, "failed_reason", str2);
            }
        }
        if (jSONObject.length() > 0) {
            clogBuilder.o(jSONObject.toString());
        }
        u21.b(clogBuilder);
    }

    public void g(@NonNull AdDownloadAction adDownloadAction, @NonNull gl0 gl0Var, @Nullable ol0 ol0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(Constants.METHOD_SEND_USER_MSG, this, adDownloadAction, gl0Var, ol0Var) == null) {
            e(adDownloadAction, gl0Var, ol0Var);
            this.b.readLock().lock();
            try {
                List list = (List) g21.b(this.a, gl0Var.e());
                if (list == null) {
                    return;
                }
                for (int i = 0; i != e21.l(list); i++) {
                    yl0 yl0Var = (yl0) e21.d(list, i);
                    if (yl0Var != null && yl0Var.getData() != null) {
                        yl0Var.getData().i(gl0Var);
                        yl0Var.a(adDownloadAction, yl0Var.getData());
                    }
                }
            } finally {
                this.b.readLock().unlock();
            }
        }
    }

    public void i(String str, yl0 yl0Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048580, this, str, yl0Var) == null) && !TextUtils.isEmpty(str) && yl0Var != null) {
            this.b.writeLock().lock();
            try {
                List list = (List) g21.b(this.a, str);
                if (list == null) {
                    list = new ArrayList();
                    g21.e(this.a, str, list);
                }
                e21.b(list, yl0Var);
            } finally {
                this.b.writeLock().unlock();
            }
        }
    }

    public void l(String str, yl0 yl0Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048583, this, str, yl0Var) == null) && !TextUtils.isEmpty(str) && yl0Var != null) {
            this.b.writeLock().lock();
            try {
                List list = (List) g21.b(this.a, str);
                if (list == null) {
                    return;
                }
                e21.j(list, yl0Var);
            } finally {
                this.b.writeLock().unlock();
            }
        }
    }
}
