package com.baidu.tieba;

import android.app.Activity;
import android.content.DialogInterface;
import android.os.Environment;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.nadcore.download.consts.AdDownloadStatus;
import com.baidu.nadcore.stats.request.ClogBuilder;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes9.dex */
public class yh0 {
    public static /* synthetic */ Interceptable $ic;
    public static long b;
    public static int c;
    public static int d;
    public transient /* synthetic */ FieldHolder $fh;
    public final List<wg0> a;

    /* loaded from: classes9.dex */
    public class a implements DialogInterface.OnKeyListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ wg0 a;
        public final /* synthetic */ Activity b;
        public final /* synthetic */ wh0 c;
        public final /* synthetic */ yh0 d;

        public a(yh0 yh0Var, wg0 wg0Var, Activity activity, wh0 wh0Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {yh0Var, wg0Var, activity, wh0Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.d = yh0Var;
            this.a = wg0Var;
            this.b = activity;
            this.c = wh0Var;
        }

        @Override // android.content.DialogInterface.OnKeyListener
        public boolean onKey(DialogInterface dialogInterface, int i, KeyEvent keyEvent) {
            InterceptResult invokeLIL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLIL = interceptable.invokeLIL(1048576, this, dialogInterface, i, keyEvent)) == null) {
                yh0.a();
                this.d.j();
                this.d.g(ClogBuilder.LogType.FREE_CLICK, ClogBuilder.Area.DIALOG_KEYBACK, this.a);
                if (vg0.b().a(this.b)) {
                    vg0.b().e(this.b, System.currentTimeMillis());
                    this.c.a();
                    return true;
                }
                this.c.b();
                return true;
            }
            return invokeLIL.booleanValue;
        }
    }

    /* loaded from: classes9.dex */
    public class b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ wh0 a;
        public final /* synthetic */ wg0 b;
        public final /* synthetic */ yh0 c;

        public b(yh0 yh0Var, wh0 wh0Var, wg0 wg0Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {yh0Var, wh0Var, wg0Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = yh0Var;
            this.a = wh0Var;
            this.b = wg0Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                this.c.j();
                vg0.b().d(false);
                this.a.a();
                this.c.g(ClogBuilder.LogType.FREE_CLICK, ClogBuilder.Area.DIALOG_NEGATIVE, this.b);
            }
        }
    }

    /* loaded from: classes9.dex */
    public class c implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ wg0 a;
        public final /* synthetic */ yh0 b;

        public c(yh0 yh0Var, wg0 wg0Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {yh0Var, wg0Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = yh0Var;
            this.a = wg0Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                this.b.j();
                vg0.b().d(false);
                this.b.g(ClogBuilder.LogType.FREE_CLICK, ClogBuilder.Area.DIALOG_POSITIVE, this.a);
                if (TextUtils.equals(this.a.q.o, "reminded_type_unopen")) {
                    gi0.h(this.a.d);
                    return;
                }
                gi0.e(this.a.h, this.a.a());
            }
        }
    }

    /* loaded from: classes9.dex */
    public static class d {
        public static /* synthetic */ Interceptable $ic;
        public static final yh0 a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-260606936, "Lcom/baidu/tieba/yh0$d;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-260606936, "Lcom/baidu/tieba/yh0$d;");
                    return;
                }
            }
            a = new yh0(null);
        }
    }

    public yh0() {
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
        this.a = new ArrayList();
    }

    public static /* synthetic */ int a() {
        int i = c;
        c = i + 1;
        return i;
    }

    public static long e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65541, null)) == null) {
            return az0.a().b("nad_app_quick_config").getLong("key_last_alert_dialog_show_time", 0L);
        }
        return invokeV.longValue;
    }

    public static yh0 f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65542, null)) == null) {
            return d.a;
        }
        return (yh0) invokeV.objValue;
    }

    public final void j() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            long currentTimeMillis = System.currentTimeMillis();
            b = currentTimeMillis;
            h(currentTimeMillis);
        }
    }

    public void l() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            c++;
        }
    }

    public /* synthetic */ yh0(a aVar) {
        this();
    }

    public static void h(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(65543, null, j) == null) {
            az0.a().b("nad_app_quick_config").g("key_last_alert_dialog_show_time", j);
        }
    }

    public final wg0 d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            wg0 wg0Var = null;
            if (ny0.g(this.a)) {
                return null;
            }
            ArrayList arrayList = new ArrayList();
            int l = ny0.l(this.a) - 1;
            wg0 wg0Var2 = null;
            while (true) {
                if (l < 0) {
                    break;
                }
                wg0 wg0Var3 = (wg0) ny0.d(this.a, l);
                if (wg0Var3 != null) {
                    String str = wg0Var3.d;
                    boolean c2 = gi0.c(str);
                    boolean exists = new File(Environment.getExternalStorageDirectory().getAbsolutePath() + "/Android/data/" + str).exists();
                    if (c2) {
                        if (exists) {
                            ny0.b(arrayList, wg0Var3);
                        } else {
                            wg0Var3.q.o = "reminded_type_unopen";
                            ny0.b(arrayList, wg0Var3);
                            wg0Var = wg0Var3;
                            break;
                        }
                    } else if (gi0.g(wg0Var3.h) && wg0Var3.c != AdDownloadStatus.NONE && TextUtils.equals(wg0Var3.q.o, "reminded_type_none") && wg0Var2 == null) {
                        wg0Var3.q.o = "reminded_type_uninstall";
                        wg0Var2 = wg0Var3;
                    }
                }
                l--;
            }
            ny0.k(this.a, arrayList);
            if (wg0Var != null) {
                return wg0Var;
            }
            return wg0Var2;
        }
        return (wg0) invokeV.objValue;
    }

    public final void g(ClogBuilder.LogType logType, ClogBuilder.Area area, wg0 wg0Var) {
        String str;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, logType, area, wg0Var) != null) || wg0Var == null) {
            return;
        }
        ClogBuilder clogBuilder = new ClogBuilder();
        clogBuilder.u(ClogBuilder.Page.POPUP);
        if (logType != null) {
            clogBuilder.y(logType);
        }
        if (area != null) {
            clogBuilder.i(area);
        }
        if (!TextUtils.isEmpty(wg0Var.p.a)) {
            clogBuilder.p(wg0Var.p.a);
        }
        clogBuilder.k(String.valueOf(c));
        clogBuilder.l(String.valueOf(d));
        if (TextUtils.equals(wg0Var.q.o, "reminded_type_uninstall")) {
            str = "1";
        } else {
            str = "2";
        }
        clogBuilder.m(str);
        dz0.e(clogBuilder);
    }

    public void i(Activity activity, wh0 wh0Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, activity, wh0Var) == null) && vg0.b().isMainActivity(activity) && wh0Var != null) {
            if (b == 0) {
                b = e();
            }
            if (System.currentTimeMillis() - b < 600000) {
                wh0Var.a();
                return;
            }
            wg0 d2 = d();
            if (d2 == null) {
                wh0Var.a();
                return;
            }
            ji0 ji0Var = new ji0(activity);
            ji0Var.d();
            ji0Var.e(false);
            ji0Var.f(false);
            ji0Var.g(d2);
            ji0Var.j(new c(this, d2));
            ji0Var.h(new b(this, wh0Var, d2));
            ji0Var.i(new a(this, d2, activity, wh0Var));
            ji0Var.k();
            d++;
            vg0.b().d(true);
            g(ClogBuilder.LogType.FREE_SHOW, ClogBuilder.Area.DIALOG, d2);
        }
    }

    public void k(wg0 wg0Var) {
        File file;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048580, this, wg0Var) == null) && wg0Var != null && (file = wg0Var.h) != null && file.exists()) {
            String str = wg0Var.p.h;
            String absolutePath = wg0Var.h.getAbsolutePath();
            if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(absolutePath)) {
                wg0Var.q.o = "reminded_type_none";
                ny0.b(this.a, wg0Var);
            }
        }
    }
}
