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
/* loaded from: classes6.dex */
public class jg0 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final HashMap<String, List<oh0>> a;
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
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-690967815, "Lcom/baidu/tieba/jg0$a;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-690967815, "Lcom/baidu/tieba/jg0$a;");
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
        public static final jg0 a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-690967784, "Lcom/baidu/tieba/jg0$b;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-690967784, "Lcom/baidu/tieba/jg0$b;");
                    return;
                }
            }
            a = new jg0(null);
        }
    }

    public jg0() {
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
        this.c = qh0.b();
    }

    public /* synthetic */ jg0(a aVar) {
        this();
    }

    public void a(@NonNull wg0 wg0Var) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048576, this, wg0Var) != null) || wg0Var.f()) {
            return;
        }
        this.c.b(wg0Var);
        wg0Var.c = AdDownloadStatus.NONE;
        eh0 eh0Var = new eh0();
        eh0Var.b = "install_failed";
        h(AdDownloadAction.FAIL, wg0Var, eh0Var);
    }

    public void j(@NonNull wg0 wg0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, wg0Var) == null) {
            this.c.c(wg0Var);
        }
    }

    public void l(@NonNull wg0 wg0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, wg0Var) == null) {
            g(AdDownloadAction.PROGRESS_UPDATE, wg0Var);
            this.c.d(wg0Var, new kg0(wg0Var));
        }
    }

    public void n(@NonNull wg0 wg0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, wg0Var) == null) {
            g(AdDownloadAction.PROGRESS_UPDATE, wg0Var);
            wg0Var.b = this.c.a(wg0Var, new kg0(wg0Var));
            wg0Var.c = AdDownloadStatus.DOWNLOADING;
        }
    }

    public static jg0 c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            return b.a;
        }
        return (jg0) invokeV.objValue;
    }

    public static void d(@NonNull wg0 wg0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65539, null, wg0Var) == null) {
            if (!TextUtils.isEmpty(wg0Var.p.c) && qe0.b(wg0Var.p.c)) {
                if (ij0.b().a().a("nad_als_open_to_click_switch", 0) == 1) {
                    e(AdDownloadAction.OPEN, wg0Var);
                    return;
                }
                return;
            }
            gi0.h(wg0Var.d);
            e(AdDownloadAction.OPEN, wg0Var);
        }
    }

    public static void e(@NonNull AdDownloadAction adDownloadAction, @NonNull wg0 wg0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, null, adDownloadAction, wg0Var) == null) {
            f(adDownloadAction, wg0Var, null);
        }
    }

    public void g(@NonNull AdDownloadAction adDownloadAction, @NonNull wg0 wg0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, adDownloadAction, wg0Var) == null) {
            h(adDownloadAction, wg0Var, null);
        }
    }

    public void m(@NonNull wg0 wg0Var, @NonNull kg0 kg0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, wg0Var, kg0Var) == null) {
            g(AdDownloadAction.PROGRESS_UPDATE, wg0Var);
            this.c.d(wg0Var, kg0Var);
        }
    }

    public void o(@NonNull wg0 wg0Var, @NonNull kg0 kg0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048586, this, wg0Var, kg0Var) == null) {
            g(AdDownloadAction.PROGRESS_UPDATE, wg0Var);
            wg0Var.b = this.c.a(wg0Var, kg0Var);
            wg0Var.c = AdDownloadStatus.DOWNLOADING;
        }
    }

    public static void f(@NonNull AdDownloadAction adDownloadAction, @NonNull wg0 wg0Var, @Nullable eh0 eh0Var) {
        ClogBuilder.LogType logType;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLLL(65541, null, adDownloadAction, wg0Var, eh0Var) != null) || TextUtils.isEmpty(wg0Var.p.a)) {
            return;
        }
        String str = wg0Var.q.j;
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
                if (ij0.b().a().a("nad_als_open_to_click_switch", 0) == 1) {
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
        clogBuilder.y(logType).p(wg0Var.p.a).v(wg0Var.q.a).j(str).k(wg0Var.d).l(wg0Var.q.a).m(wg0Var.q.b).n(wg0Var.g);
        JSONObject jSONObject = new JSONObject();
        my0.d(jSONObject, "is_swallow", 1);
        if (!TextUtils.isEmpty(wg0Var.q.d)) {
            my0.f(jSONObject, "ad_download_content_type", wg0Var.q.d);
        }
        long j = wg0Var.q.e;
        if (j > 0) {
            my0.e(jSONObject, "ad_download_content_length", j);
        }
        int i = wg0Var.n;
        if (i > 0) {
            my0.d(jSONObject, "version_code", i);
        }
        if (!TextUtils.isEmpty(wg0Var.o)) {
            my0.f(jSONObject, NativeUnifiedADAppInfoImpl.Keys.VERSION_NAME, wg0Var.o);
        }
        if (eh0Var != null) {
            Exception exc = eh0Var.a;
            if (exc != null) {
                my0.f(jSONObject, "failed_reason", exc.getClass().toString());
            }
            String str2 = eh0Var.b;
            if (str2 != null) {
                my0.f(jSONObject, "failed_reason", str2);
            }
        }
        if (jSONObject.length() > 0) {
            clogBuilder.o(jSONObject.toString());
        }
        bz0.e(clogBuilder);
    }

    public final void b(@NonNull String str, @NonNull String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, str2) == null) {
            Context b2 = hf0.b();
            Object systemService = b2.getSystemService(GrowthConstant.UBC_VALUE_TYPE_CLIP_BOARD);
            if (!(systemService instanceof ClipboardManager)) {
                return;
            }
            ((ClipboardManager) systemService).setPrimaryClip(ClipData.newPlainText(b2.getResources().getString(R.string.nad_invite_code_label), str));
            w01.a().showToast(b2, str2);
        }
    }

    public void h(@NonNull AdDownloadAction adDownloadAction, @NonNull wg0 wg0Var, @Nullable eh0 eh0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048579, this, adDownloadAction, wg0Var, eh0Var) == null) {
            f(adDownloadAction, wg0Var, eh0Var);
            this.b.readLock().lock();
            try {
                List list = (List) ny0.b(this.a, wg0Var.e());
                if (list == null) {
                    return;
                }
                for (int i = 0; i != ly0.l(list); i++) {
                    oh0 oh0Var = (oh0) ly0.d(list, i);
                    if (oh0Var != null && oh0Var.getData() != null) {
                        oh0Var.getData().i(wg0Var);
                        oh0Var.a(adDownloadAction, oh0Var.getData());
                    }
                }
                this.b.readLock().unlock();
                i(adDownloadAction, wg0Var);
            } finally {
                this.b.readLock().unlock();
            }
        }
    }

    public final void i(@NonNull AdDownloadAction adDownloadAction, @NonNull wg0 wg0Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048580, this, adDownloadAction, wg0Var) == null) && a.a[adDownloadAction.ordinal()] == 1) {
            Context context = null;
            WeakReference<Context> weakReference = wg0Var.p.m;
            if (weakReference != null) {
                context = weakReference.get();
            }
            if (!TextUtils.isEmpty(wg0Var.p.l) && context != null) {
                qe0.c(wg0Var.p.l, context);
            }
            if (wg0Var.q.r) {
                w01.a().a(hf0.b(), R.string.nad_apk_download_start_toast);
            }
            yg0 yg0Var = wg0Var.p.k;
            if (yg0Var != null && !TextUtils.isEmpty(yg0Var.a)) {
                yg0 yg0Var2 = wg0Var.p.k;
                b(yg0Var2.a, yg0Var2.b);
            }
        }
    }

    public void k(String str, oh0 oh0Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048582, this, str, oh0Var) == null) && !TextUtils.isEmpty(str) && oh0Var != null) {
            this.b.writeLock().lock();
            try {
                List list = (List) ny0.b(this.a, str);
                if (list == null) {
                    list = new ArrayList();
                    ny0.e(this.a, str, list);
                }
                ly0.b(list, oh0Var);
            } finally {
                this.b.writeLock().unlock();
            }
        }
    }

    public void p(String str, oh0 oh0Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048587, this, str, oh0Var) == null) && !TextUtils.isEmpty(str) && oh0Var != null) {
            this.b.writeLock().lock();
            try {
                List list = (List) ny0.b(this.a, str);
                if (list == null) {
                    return;
                }
                ly0.j(list, oh0Var);
            } finally {
                this.b.writeLock().unlock();
            }
        }
    }
}
