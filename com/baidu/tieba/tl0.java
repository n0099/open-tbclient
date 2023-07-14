package com.baidu.tieba;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.nadcore.download.consts.AdDownloadAction;
import com.baidu.nadcore.download.consts.AdDownloadStatus;
import com.baidu.nadcore.download.proxy.IAdDownloader;
import com.baidu.nadcore.stats.request.ClogBuilder;
import com.baidu.searchbox.datacollector.growth.utils.GrowthConstant;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.qq.e.ads.nativ.NativeUnifiedADAppInfoImpl;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import org.json.JSONObject;
/* loaded from: classes8.dex */
public class tl0 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final HashMap<String, List<ym0>> a;
    public final ReentrantReadWriteLock b;
    public final IAdDownloader c;

    /* loaded from: classes8.dex */
    public static /* synthetic */ class a {
        public static /* synthetic */ Interceptable $ic;
        public static final /* synthetic */ int[] a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-400058700, "Lcom/baidu/tieba/tl0$a;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-400058700, "Lcom/baidu/tieba/tl0$a;");
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

    /* loaded from: classes8.dex */
    public static class b {
        public static /* synthetic */ Interceptable $ic;
        public static final tl0 a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-400058669, "Lcom/baidu/tieba/tl0$b;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-400058669, "Lcom/baidu/tieba/tl0$b;");
                    return;
                }
            }
            a = new tl0(null);
        }
    }

    public tl0() {
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
        this.c = an0.b();
    }

    public /* synthetic */ tl0(a aVar) {
        this();
    }

    public void a(@NonNull gm0 gm0Var) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048576, this, gm0Var) != null) || gm0Var.f()) {
            return;
        }
        this.c.b(gm0Var);
        gm0Var.c = AdDownloadStatus.NONE;
        om0 om0Var = new om0();
        om0Var.b = "install_failed";
        h(AdDownloadAction.FAIL, gm0Var, om0Var);
    }

    public void j(@NonNull gm0 gm0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, gm0Var) == null) {
            this.c.c(gm0Var);
        }
    }

    public void l(@NonNull gm0 gm0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, gm0Var) == null) {
            g(AdDownloadAction.PROGRESS_UPDATE, gm0Var);
            this.c.d(gm0Var, new ul0(gm0Var));
        }
    }

    public void m(@NonNull gm0 gm0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, gm0Var) == null) {
            g(AdDownloadAction.PROGRESS_UPDATE, gm0Var);
            gm0Var.b = this.c.a(gm0Var, new ul0(gm0Var));
            gm0Var.c = AdDownloadStatus.DOWNLOADING;
        }
    }

    public static tl0 c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            return b.a;
        }
        return (tl0) invokeV.objValue;
    }

    public static void d(@NonNull gm0 gm0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65539, null, gm0Var) == null) {
            if (!TextUtils.isEmpty(gm0Var.p.c) && ak0.b(gm0Var.p.c)) {
                if (so0.b().a().a("nad_als_open_to_click_switch", 0) == 1) {
                    e(AdDownloadAction.OPEN, gm0Var);
                    return;
                }
                return;
            }
            qn0.h(gm0Var.d);
            e(AdDownloadAction.OPEN, gm0Var);
        }
    }

    public static void e(@NonNull AdDownloadAction adDownloadAction, @NonNull gm0 gm0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, null, adDownloadAction, gm0Var) == null) {
            f(adDownloadAction, gm0Var, null);
        }
    }

    public void g(@NonNull AdDownloadAction adDownloadAction, @NonNull gm0 gm0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, adDownloadAction, gm0Var) == null) {
            h(adDownloadAction, gm0Var, null);
        }
    }

    public static void f(@NonNull AdDownloadAction adDownloadAction, @NonNull gm0 gm0Var, @Nullable om0 om0Var) {
        ClogBuilder.LogType logType;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLLL(65541, null, adDownloadAction, gm0Var, om0Var) != null) || TextUtils.isEmpty(gm0Var.p.a)) {
            return;
        }
        String str = gm0Var.q.j;
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
                if (so0.b().a().a("nad_als_open_to_click_switch", 0) == 1) {
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
        clogBuilder.y(logType).p(gm0Var.p.a).v(gm0Var.q.a).j(str).k(gm0Var.d).l(gm0Var.q.a).m(gm0Var.q.b).n(gm0Var.g);
        JSONObject jSONObject = new JSONObject();
        y31.d(jSONObject, "is_swallow", 1);
        if (!TextUtils.isEmpty(gm0Var.q.d)) {
            y31.f(jSONObject, "ad_download_content_type", gm0Var.q.d);
        }
        long j = gm0Var.q.e;
        if (j > 0) {
            y31.e(jSONObject, "ad_download_content_length", j);
        }
        int i = gm0Var.n;
        if (i > 0) {
            y31.d(jSONObject, "version_code", i);
        }
        if (!TextUtils.isEmpty(gm0Var.o)) {
            y31.f(jSONObject, NativeUnifiedADAppInfoImpl.Keys.VERSION_NAME, gm0Var.o);
        }
        if (om0Var != null) {
            Exception exc = om0Var.a;
            if (exc != null) {
                y31.f(jSONObject, "failed_reason", exc.getClass().toString());
            }
            String str2 = om0Var.b;
            if (str2 != null) {
                y31.f(jSONObject, "failed_reason", str2);
            }
        }
        if (jSONObject.length() > 0) {
            clogBuilder.o(jSONObject.toString());
        }
        n41.e(clogBuilder);
    }

    public final void b(@NonNull String str, @NonNull String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, str2) == null) {
            Context b2 = rk0.b();
            Object systemService = b2.getSystemService(GrowthConstant.UBC_VALUE_TYPE_CLIP_BOARD);
            if (!(systemService instanceof ClipboardManager)) {
                return;
            }
            ((ClipboardManager) systemService).setPrimaryClip(ClipData.newPlainText(b2.getResources().getString(R.string.nad_invite_code_label), str));
            g61.a().showToast(b2, str2);
        }
    }

    public void h(@NonNull AdDownloadAction adDownloadAction, @NonNull gm0 gm0Var, @Nullable om0 om0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048579, this, adDownloadAction, gm0Var, om0Var) == null) {
            f(adDownloadAction, gm0Var, om0Var);
            this.b.readLock().lock();
            try {
                List list = (List) z31.b(this.a, gm0Var.e());
                if (list == null) {
                    return;
                }
                for (int i = 0; i != x31.l(list); i++) {
                    ym0 ym0Var = (ym0) x31.d(list, i);
                    if (ym0Var != null && ym0Var.getData() != null) {
                        ym0Var.getData().i(gm0Var);
                        ym0Var.a(adDownloadAction, ym0Var.getData());
                    }
                }
                this.b.readLock().unlock();
                i(adDownloadAction, gm0Var);
            } finally {
                this.b.readLock().unlock();
            }
        }
    }

    public final void i(@NonNull AdDownloadAction adDownloadAction, @NonNull gm0 gm0Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048580, this, adDownloadAction, gm0Var) == null) && a.a[adDownloadAction.ordinal()] == 1) {
            Context context = null;
            WeakReference<Context> weakReference = gm0Var.p.m;
            if (weakReference != null) {
                context = weakReference.get();
            }
            if (!TextUtils.isEmpty(gm0Var.p.l) && context != null) {
                ak0.c(gm0Var.p.l, context);
            }
            if (gm0Var.q.r) {
                g61.a().a(rk0.b(), R.string.nad_apk_download_start_toast);
            }
            im0 im0Var = gm0Var.p.k;
            if (im0Var != null && !TextUtils.isEmpty(im0Var.a)) {
                im0 im0Var2 = gm0Var.p.k;
                b(im0Var2.a, im0Var2.b);
            }
        }
    }

    public void k(String str, ym0 ym0Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048582, this, str, ym0Var) == null) && !TextUtils.isEmpty(str) && ym0Var != null) {
            this.b.writeLock().lock();
            try {
                List list = (List) z31.b(this.a, str);
                if (list == null) {
                    list = new ArrayList();
                    z31.e(this.a, str, list);
                }
                x31.b(list, ym0Var);
            } finally {
                this.b.writeLock().unlock();
            }
        }
    }

    public void n(String str, ym0 ym0Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048585, this, str, ym0Var) == null) && !TextUtils.isEmpty(str) && ym0Var != null) {
            this.b.writeLock().lock();
            try {
                List list = (List) z31.b(this.a, str);
                if (list == null) {
                    return;
                }
                x31.j(list, ym0Var);
            } finally {
                this.b.writeLock().unlock();
            }
        }
    }
}
