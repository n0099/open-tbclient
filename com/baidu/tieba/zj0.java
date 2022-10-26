package com.baidu.tieba;

import android.text.TextUtils;
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
public class zj0 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final HashMap a;
    public final ReentrantReadWriteLock b;
    public final IAdDownloader c;

    /* loaded from: classes6.dex */
    public /* synthetic */ class a {
        public static /* synthetic */ Interceptable $ic;
        public static final /* synthetic */ int[] a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-230130836, "Lcom/baidu/tieba/zj0$a;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-230130836, "Lcom/baidu/tieba/zj0$a;");
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
    public class b {
        public static /* synthetic */ Interceptable $ic;
        public static final zj0 a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-230130805, "Lcom/baidu/tieba/zj0$b;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-230130805, "Lcom/baidu/tieba/zj0$b;");
                    return;
                }
            }
            a = new zj0(null);
        }
    }

    public zj0() {
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
        this.a = new HashMap(32);
        this.b = new ReentrantReadWriteLock();
        this.c = gl0.b();
    }

    public /* synthetic */ zj0(a aVar) {
        this();
    }

    public static void c(mk0 mk0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65539, null, mk0Var) == null) {
            if (!TextUtils.isEmpty(mk0Var.p.c) && ji0.b(mk0Var.p.c)) {
                return;
            }
            ql0.f(mk0Var.d);
            d(AdDownloadAction.OPEN, mk0Var);
        }
    }

    public void a(mk0 mk0Var) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048576, this, mk0Var) != null) || mk0Var.f()) {
            return;
        }
        this.c.b(mk0Var);
        mk0Var.c = AdDownloadStatus.NONE;
        f(AdDownloadAction.FAIL, mk0Var);
    }

    public void h(mk0 mk0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, mk0Var) == null) {
            this.c.c(mk0Var);
        }
    }

    public void j(mk0 mk0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, mk0Var) == null) {
            f(AdDownloadAction.PROGRESS_UPDATE, mk0Var);
            this.c.d(mk0Var, new ak0(mk0Var));
        }
    }

    public void k(mk0 mk0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, mk0Var) == null) {
            f(AdDownloadAction.PROGRESS_UPDATE, mk0Var);
            mk0Var.b = this.c.a(mk0Var, new ak0(mk0Var));
            mk0Var.c = AdDownloadStatus.DOWNLOADING;
        }
    }

    public static zj0 b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            return b.a;
        }
        return (zj0) invokeV.objValue;
    }

    public static void d(AdDownloadAction adDownloadAction, mk0 mk0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, null, adDownloadAction, mk0Var) == null) {
            e(adDownloadAction, mk0Var, null);
        }
    }

    public void f(AdDownloadAction adDownloadAction, mk0 mk0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, adDownloadAction, mk0Var) == null) {
            g(adDownloadAction, mk0Var, null);
        }
    }

    public static void e(AdDownloadAction adDownloadAction, mk0 mk0Var, uk0 uk0Var) {
        ClogBuilder.LogType logType;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLLL(65541, null, adDownloadAction, mk0Var, uk0Var) != null) || TextUtils.isEmpty(mk0Var.p.a)) {
            return;
        }
        String str = mk0Var.q.j;
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
        clogBuilder.y(logType).p(mk0Var.p.a).v(mk0Var.q.a).j(str).k(mk0Var.d).l(mk0Var.q.a).m(mk0Var.q.b).n(mk0Var.g);
        JSONObject jSONObject = new JSONObject();
        if (!TextUtils.isEmpty(mk0Var.q.d)) {
            yz0.f(jSONObject, "ad_download_content_type", mk0Var.q.d);
        }
        long j = mk0Var.q.e;
        if (j > 0) {
            yz0.e(jSONObject, "ad_download_content_length", j);
        }
        int i = mk0Var.n;
        if (i > 0) {
            yz0.d(jSONObject, "version_code", i);
        }
        if (!TextUtils.isEmpty(mk0Var.o)) {
            yz0.f(jSONObject, "version_name", mk0Var.o);
        }
        if (uk0Var != null) {
            Exception exc = uk0Var.a;
            if (exc != null) {
                yz0.f(jSONObject, "failed_reason", exc.getClass().toString());
            }
            String str2 = uk0Var.b;
            if (str2 != null) {
                yz0.f(jSONObject, "failed_reason", str2);
            }
        }
        if (jSONObject.length() > 0) {
            clogBuilder.o(jSONObject.toString());
        }
        i01.b(clogBuilder);
    }

    public void g(AdDownloadAction adDownloadAction, mk0 mk0Var, uk0 uk0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(Constants.METHOD_SEND_USER_MSG, this, adDownloadAction, mk0Var, uk0Var) == null) {
            e(adDownloadAction, mk0Var, uk0Var);
            this.b.readLock().lock();
            try {
                List list = (List) zz0.b(this.a, mk0Var.e());
                if (list == null) {
                    return;
                }
                for (int i = 0; i != xz0.l(list); i++) {
                    el0 el0Var = (el0) xz0.d(list, i);
                    if (el0Var != null && el0Var.getData() != null) {
                        el0Var.getData().i(mk0Var);
                        el0Var.a(adDownloadAction, el0Var.getData());
                    }
                }
            } finally {
                this.b.readLock().unlock();
            }
        }
    }

    public void i(String str, el0 el0Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048580, this, str, el0Var) == null) && !TextUtils.isEmpty(str) && el0Var != null) {
            this.b.writeLock().lock();
            try {
                List list = (List) zz0.b(this.a, str);
                if (list == null) {
                    list = new ArrayList();
                    zz0.e(this.a, str, list);
                }
                xz0.b(list, el0Var);
            } finally {
                this.b.writeLock().unlock();
            }
        }
    }

    public void l(String str, el0 el0Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048583, this, str, el0Var) == null) && !TextUtils.isEmpty(str) && el0Var != null) {
            this.b.writeLock().lock();
            try {
                List list = (List) zz0.b(this.a, str);
                if (list == null) {
                    return;
                }
                xz0.j(list, el0Var);
            } finally {
                this.b.writeLock().unlock();
            }
        }
    }
}
