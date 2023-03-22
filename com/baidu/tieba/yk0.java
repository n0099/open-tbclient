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
/* loaded from: classes7.dex */
public class yk0 {
    public static /* synthetic */ Interceptable $ic;
    public static long b;
    public static int c;
    public static int d;
    public transient /* synthetic */ FieldHolder $fh;
    public final List<wj0> a;

    /* loaded from: classes7.dex */
    public class a implements DialogInterface.OnKeyListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ wj0 a;
        public final /* synthetic */ Activity b;
        public final /* synthetic */ wk0 c;
        public final /* synthetic */ yk0 d;

        public a(yk0 yk0Var, wj0 wj0Var, Activity activity, wk0 wk0Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {yk0Var, wj0Var, activity, wk0Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.d = yk0Var;
            this.a = wj0Var;
            this.b = activity;
            this.c = wk0Var;
        }

        @Override // android.content.DialogInterface.OnKeyListener
        public boolean onKey(DialogInterface dialogInterface, int i, KeyEvent keyEvent) {
            InterceptResult invokeLIL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLIL = interceptable.invokeLIL(1048576, this, dialogInterface, i, keyEvent)) == null) {
                yk0.a();
                this.d.j();
                this.d.g(ClogBuilder.LogType.FREE_CLICK, ClogBuilder.Area.DIALOG_KEYBACK, this.a);
                if (vj0.b().a(this.b)) {
                    vj0.b().e(this.b, System.currentTimeMillis());
                    this.c.a();
                    return true;
                }
                this.c.b();
                return true;
            }
            return invokeLIL.booleanValue;
        }
    }

    /* loaded from: classes7.dex */
    public class b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ wk0 a;
        public final /* synthetic */ wj0 b;
        public final /* synthetic */ yk0 c;

        public b(yk0 yk0Var, wk0 wk0Var, wj0 wj0Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {yk0Var, wk0Var, wj0Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = yk0Var;
            this.a = wk0Var;
            this.b = wj0Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                this.c.j();
                vj0.b().d(false);
                this.a.a();
                this.c.g(ClogBuilder.LogType.FREE_CLICK, ClogBuilder.Area.DIALOG_NEGATIVE, this.b);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class c implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ wj0 a;
        public final /* synthetic */ yk0 b;

        public c(yk0 yk0Var, wj0 wj0Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {yk0Var, wj0Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = yk0Var;
            this.a = wj0Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                this.b.j();
                vj0.b().d(false);
                this.b.g(ClogBuilder.LogType.FREE_CLICK, ClogBuilder.Area.DIALOG_POSITIVE, this.a);
                if (TextUtils.equals(this.a.q.o, "reminded_type_unopen")) {
                    al0.g(this.a.d);
                    return;
                }
                al0.e(this.a.h, this.a.a());
            }
        }
    }

    /* loaded from: classes7.dex */
    public static class d {
        public static /* synthetic */ Interceptable $ic;
        public static final yk0 a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-257836373, "Lcom/baidu/tieba/yk0$d;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-257836373, "Lcom/baidu/tieba/yk0$d;");
                    return;
                }
            }
            a = new yk0(null);
        }
    }

    public yk0() {
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
            return h11.a().b("nad_app_quick_config").getLong("key_last_alert_dialog_show_time", 0L);
        }
        return invokeV.longValue;
    }

    public static yk0 f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65542, null)) == null) {
            return d.a;
        }
        return (yk0) invokeV.objValue;
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

    public /* synthetic */ yk0(a aVar) {
        this();
    }

    public static void h(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(65543, null, j) == null) {
            h11.a().b("nad_app_quick_config").h("key_last_alert_dialog_show_time", j);
        }
    }

    public final wj0 d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            wj0 wj0Var = null;
            if (u01.g(this.a)) {
                return null;
            }
            ArrayList arrayList = new ArrayList();
            int l = u01.l(this.a) - 1;
            wj0 wj0Var2 = null;
            while (true) {
                if (l < 0) {
                    break;
                }
                wj0 wj0Var3 = (wj0) u01.d(this.a, l);
                if (wj0Var3 != null) {
                    String str = wj0Var3.d;
                    boolean c2 = al0.c(str);
                    boolean exists = new File(Environment.getExternalStorageDirectory().getAbsolutePath() + "/Android/data/" + str).exists();
                    if (c2) {
                        if (exists) {
                            u01.b(arrayList, wj0Var3);
                        } else {
                            wj0Var3.q.o = "reminded_type_unopen";
                            u01.b(arrayList, wj0Var3);
                            wj0Var = wj0Var3;
                            break;
                        }
                    } else if (al0.f(wj0Var3.h) && wj0Var3.c != AdDownloadStatus.NONE && TextUtils.equals(wj0Var3.q.o, "reminded_type_none") && wj0Var2 == null) {
                        wj0Var3.q.o = "reminded_type_uninstall";
                        wj0Var2 = wj0Var3;
                    }
                }
                l--;
            }
            u01.k(this.a, arrayList);
            if (wj0Var != null) {
                return wj0Var;
            }
            return wj0Var2;
        }
        return (wj0) invokeV.objValue;
    }

    public final void g(ClogBuilder.LogType logType, ClogBuilder.Area area, wj0 wj0Var) {
        String str;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, logType, area, wj0Var) != null) || wj0Var == null) {
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
        if (!TextUtils.isEmpty(wj0Var.p.a)) {
            clogBuilder.p(wj0Var.p.a);
        }
        clogBuilder.k(String.valueOf(c));
        clogBuilder.l(String.valueOf(d));
        if (TextUtils.equals(wj0Var.q.o, "reminded_type_uninstall")) {
            str = "1";
        } else {
            str = "2";
        }
        clogBuilder.m(str);
        k11.b(clogBuilder);
    }

    public void i(Activity activity, wk0 wk0Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, activity, wk0Var) == null) && vj0.b().isMainActivity(activity) && wk0Var != null) {
            if (b == 0) {
                b = e();
            }
            if (System.currentTimeMillis() - b < 600000) {
                wk0Var.a();
                return;
            }
            wj0 d2 = d();
            if (d2 == null) {
                wk0Var.a();
                return;
            }
            dl0 dl0Var = new dl0(activity);
            dl0Var.d();
            dl0Var.e(false);
            dl0Var.f(false);
            dl0Var.g(d2);
            dl0Var.j(new c(this, d2));
            dl0Var.h(new b(this, wk0Var, d2));
            dl0Var.i(new a(this, d2, activity, wk0Var));
            dl0Var.k();
            d++;
            vj0.b().d(true);
            g(ClogBuilder.LogType.FREE_SHOW, ClogBuilder.Area.DIALOG, d2);
        }
    }

    public void k(wj0 wj0Var) {
        File file;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048580, this, wj0Var) == null) && wj0Var != null && (file = wj0Var.h) != null && file.exists()) {
            String str = wj0Var.p.h;
            String absolutePath = wj0Var.h.getAbsolutePath();
            if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(absolutePath)) {
                wj0Var.q.o = "reminded_type_none";
                u01.b(this.a, wj0Var);
            }
        }
    }
}
