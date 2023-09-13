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
/* loaded from: classes6.dex */
public class km0 {
    public static /* synthetic */ Interceptable $ic;
    public static long b;
    public static int c;
    public static int d;
    public transient /* synthetic */ FieldHolder $fh;
    public final List<il0> a;

    /* loaded from: classes6.dex */
    public class a implements DialogInterface.OnKeyListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ il0 a;
        public final /* synthetic */ Activity b;
        public final /* synthetic */ im0 c;
        public final /* synthetic */ km0 d;

        public a(km0 km0Var, il0 il0Var, Activity activity, im0 im0Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {km0Var, il0Var, activity, im0Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.d = km0Var;
            this.a = il0Var;
            this.b = activity;
            this.c = im0Var;
        }

        @Override // android.content.DialogInterface.OnKeyListener
        public boolean onKey(DialogInterface dialogInterface, int i, KeyEvent keyEvent) {
            InterceptResult invokeLIL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLIL = interceptable.invokeLIL(1048576, this, dialogInterface, i, keyEvent)) == null) {
                km0.a();
                this.d.j();
                this.d.g(ClogBuilder.LogType.FREE_CLICK, ClogBuilder.Area.DIALOG_KEYBACK, this.a);
                if (hl0.b().a(this.b)) {
                    hl0.b().e(this.b, System.currentTimeMillis());
                    this.c.a();
                    return true;
                }
                this.c.b();
                return true;
            }
            return invokeLIL.booleanValue;
        }
    }

    /* loaded from: classes6.dex */
    public class b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ im0 a;
        public final /* synthetic */ il0 b;
        public final /* synthetic */ km0 c;

        public b(km0 km0Var, im0 im0Var, il0 il0Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {km0Var, im0Var, il0Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = km0Var;
            this.a = im0Var;
            this.b = il0Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                this.c.j();
                hl0.b().d(false);
                this.a.a();
                this.c.g(ClogBuilder.LogType.FREE_CLICK, ClogBuilder.Area.DIALOG_NEGATIVE, this.b);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class c implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ il0 a;
        public final /* synthetic */ km0 b;

        public c(km0 km0Var, il0 il0Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {km0Var, il0Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = km0Var;
            this.a = il0Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                this.b.j();
                hl0.b().d(false);
                this.b.g(ClogBuilder.LogType.FREE_CLICK, ClogBuilder.Area.DIALOG_POSITIVE, this.a);
                if (TextUtils.equals(this.a.q.o, "reminded_type_unopen")) {
                    sm0.h(this.a.d);
                    return;
                }
                sm0.e(this.a.h, this.a.a());
            }
        }
    }

    /* loaded from: classes6.dex */
    public static class d {
        public static /* synthetic */ Interceptable $ic;
        public static final km0 a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-656797445, "Lcom/baidu/tieba/km0$d;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-656797445, "Lcom/baidu/tieba/km0$d;");
                    return;
                }
            }
            a = new km0(null);
        }
    }

    public km0() {
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
            return u31.a().b("nad_app_quick_config").getLong("key_last_alert_dialog_show_time", 0L);
        }
        return invokeV.longValue;
    }

    public static km0 f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65542, null)) == null) {
            return d.a;
        }
        return (km0) invokeV.objValue;
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

    public /* synthetic */ km0(a aVar) {
        this();
    }

    public static void h(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(65543, null, j) == null) {
            u31.a().b("nad_app_quick_config").g("key_last_alert_dialog_show_time", j);
        }
    }

    public final il0 d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            il0 il0Var = null;
            if (h31.g(this.a)) {
                return null;
            }
            ArrayList arrayList = new ArrayList();
            int l = h31.l(this.a) - 1;
            il0 il0Var2 = null;
            while (true) {
                if (l < 0) {
                    break;
                }
                il0 il0Var3 = (il0) h31.d(this.a, l);
                if (il0Var3 != null) {
                    String str = il0Var3.d;
                    boolean c2 = sm0.c(str);
                    boolean exists = new File(Environment.getExternalStorageDirectory().getAbsolutePath() + "/Android/data/" + str).exists();
                    if (c2) {
                        if (exists) {
                            h31.b(arrayList, il0Var3);
                        } else {
                            il0Var3.q.o = "reminded_type_unopen";
                            h31.b(arrayList, il0Var3);
                            il0Var = il0Var3;
                            break;
                        }
                    } else if (sm0.g(il0Var3.h) && il0Var3.c != AdDownloadStatus.NONE && TextUtils.equals(il0Var3.q.o, "reminded_type_none") && il0Var2 == null) {
                        il0Var3.q.o = "reminded_type_uninstall";
                        il0Var2 = il0Var3;
                    }
                }
                l--;
            }
            h31.k(this.a, arrayList);
            if (il0Var != null) {
                return il0Var;
            }
            return il0Var2;
        }
        return (il0) invokeV.objValue;
    }

    public final void g(ClogBuilder.LogType logType, ClogBuilder.Area area, il0 il0Var) {
        String str;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, logType, area, il0Var) != null) || il0Var == null) {
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
        if (!TextUtils.isEmpty(il0Var.p.a)) {
            clogBuilder.p(il0Var.p.a);
        }
        clogBuilder.k(String.valueOf(c));
        clogBuilder.l(String.valueOf(d));
        if (TextUtils.equals(il0Var.q.o, "reminded_type_uninstall")) {
            str = "1";
        } else {
            str = "2";
        }
        clogBuilder.m(str);
        x31.e(clogBuilder);
    }

    public void i(Activity activity, im0 im0Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, activity, im0Var) == null) && hl0.b().isMainActivity(activity) && im0Var != null) {
            if (b == 0) {
                b = e();
            }
            if (System.currentTimeMillis() - b < 600000) {
                im0Var.a();
                return;
            }
            il0 d2 = d();
            if (d2 == null) {
                im0Var.a();
                return;
            }
            vm0 vm0Var = new vm0(activity);
            vm0Var.d();
            vm0Var.e(false);
            vm0Var.f(false);
            vm0Var.g(d2);
            vm0Var.j(new c(this, d2));
            vm0Var.h(new b(this, im0Var, d2));
            vm0Var.i(new a(this, d2, activity, im0Var));
            vm0Var.k();
            d++;
            hl0.b().d(true);
            g(ClogBuilder.LogType.FREE_SHOW, ClogBuilder.Area.DIALOG, d2);
        }
    }

    public void k(il0 il0Var) {
        File file;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048580, this, il0Var) == null) && il0Var != null && (file = il0Var.h) != null && file.exists()) {
            String str = il0Var.p.h;
            String absolutePath = il0Var.h.getAbsolutePath();
            if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(absolutePath)) {
                il0Var.q.o = "reminded_type_none";
                h31.b(this.a, il0Var);
            }
        }
    }
}
