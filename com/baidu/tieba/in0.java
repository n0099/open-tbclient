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
public class in0 {
    public static /* synthetic */ Interceptable $ic;
    public static long b;
    public static int c;
    public static int d;
    public transient /* synthetic */ FieldHolder $fh;
    public final List<gm0> a;

    /* loaded from: classes6.dex */
    public class a implements DialogInterface.OnKeyListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ gm0 a;
        public final /* synthetic */ Activity b;
        public final /* synthetic */ gn0 c;
        public final /* synthetic */ in0 d;

        public a(in0 in0Var, gm0 gm0Var, Activity activity, gn0 gn0Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {in0Var, gm0Var, activity, gn0Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.d = in0Var;
            this.a = gm0Var;
            this.b = activity;
            this.c = gn0Var;
        }

        @Override // android.content.DialogInterface.OnKeyListener
        public boolean onKey(DialogInterface dialogInterface, int i, KeyEvent keyEvent) {
            InterceptResult invokeLIL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLIL = interceptable.invokeLIL(1048576, this, dialogInterface, i, keyEvent)) == null) {
                in0.a();
                this.d.j();
                this.d.g(ClogBuilder.LogType.FREE_CLICK, ClogBuilder.Area.DIALOG_KEYBACK, this.a);
                if (fm0.b().a(this.b)) {
                    fm0.b().e(this.b, System.currentTimeMillis());
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
        public final /* synthetic */ gn0 a;
        public final /* synthetic */ gm0 b;
        public final /* synthetic */ in0 c;

        public b(in0 in0Var, gn0 gn0Var, gm0 gm0Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {in0Var, gn0Var, gm0Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = in0Var;
            this.a = gn0Var;
            this.b = gm0Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                this.c.j();
                fm0.b().d(false);
                this.a.a();
                this.c.g(ClogBuilder.LogType.FREE_CLICK, ClogBuilder.Area.DIALOG_NEGATIVE, this.b);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class c implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ gm0 a;
        public final /* synthetic */ in0 b;

        public c(in0 in0Var, gm0 gm0Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {in0Var, gm0Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = in0Var;
            this.a = gm0Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                this.b.j();
                fm0.b().d(false);
                this.b.g(ClogBuilder.LogType.FREE_CLICK, ClogBuilder.Area.DIALOG_POSITIVE, this.a);
                if (TextUtils.equals(this.a.q.o, "reminded_type_unopen")) {
                    qn0.h(this.a.d);
                    return;
                }
                qn0.e(this.a.h, this.a.a());
            }
        }
    }

    /* loaded from: classes6.dex */
    public static class d {
        public static /* synthetic */ Interceptable $ic;
        public static final in0 a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-713132226, "Lcom/baidu/tieba/in0$d;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-713132226, "Lcom/baidu/tieba/in0$d;");
                    return;
                }
            }
            a = new in0(null);
        }
    }

    public in0() {
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
            return k41.a().b("nad_app_quick_config").getLong("key_last_alert_dialog_show_time", 0L);
        }
        return invokeV.longValue;
    }

    public static in0 f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65542, null)) == null) {
            return d.a;
        }
        return (in0) invokeV.objValue;
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

    public /* synthetic */ in0(a aVar) {
        this();
    }

    public static void h(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(65543, null, j) == null) {
            k41.a().b("nad_app_quick_config").g("key_last_alert_dialog_show_time", j);
        }
    }

    public final gm0 d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            gm0 gm0Var = null;
            if (x31.g(this.a)) {
                return null;
            }
            ArrayList arrayList = new ArrayList();
            int l = x31.l(this.a) - 1;
            gm0 gm0Var2 = null;
            while (true) {
                if (l < 0) {
                    break;
                }
                gm0 gm0Var3 = (gm0) x31.d(this.a, l);
                if (gm0Var3 != null) {
                    String str = gm0Var3.d;
                    boolean c2 = qn0.c(str);
                    boolean exists = new File(Environment.getExternalStorageDirectory().getAbsolutePath() + "/Android/data/" + str).exists();
                    if (c2) {
                        if (exists) {
                            x31.b(arrayList, gm0Var3);
                        } else {
                            gm0Var3.q.o = "reminded_type_unopen";
                            x31.b(arrayList, gm0Var3);
                            gm0Var = gm0Var3;
                            break;
                        }
                    } else if (qn0.g(gm0Var3.h) && gm0Var3.c != AdDownloadStatus.NONE && TextUtils.equals(gm0Var3.q.o, "reminded_type_none") && gm0Var2 == null) {
                        gm0Var3.q.o = "reminded_type_uninstall";
                        gm0Var2 = gm0Var3;
                    }
                }
                l--;
            }
            x31.k(this.a, arrayList);
            if (gm0Var != null) {
                return gm0Var;
            }
            return gm0Var2;
        }
        return (gm0) invokeV.objValue;
    }

    public final void g(ClogBuilder.LogType logType, ClogBuilder.Area area, gm0 gm0Var) {
        String str;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, logType, area, gm0Var) != null) || gm0Var == null) {
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
        if (!TextUtils.isEmpty(gm0Var.p.a)) {
            clogBuilder.p(gm0Var.p.a);
        }
        clogBuilder.k(String.valueOf(c));
        clogBuilder.l(String.valueOf(d));
        if (TextUtils.equals(gm0Var.q.o, "reminded_type_uninstall")) {
            str = "1";
        } else {
            str = "2";
        }
        clogBuilder.m(str);
        n41.e(clogBuilder);
    }

    public void i(Activity activity, gn0 gn0Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, activity, gn0Var) == null) && fm0.b().isMainActivity(activity) && gn0Var != null) {
            if (b == 0) {
                b = e();
            }
            if (System.currentTimeMillis() - b < 600000) {
                gn0Var.a();
                return;
            }
            gm0 d2 = d();
            if (d2 == null) {
                gn0Var.a();
                return;
            }
            tn0 tn0Var = new tn0(activity);
            tn0Var.d();
            tn0Var.e(false);
            tn0Var.f(false);
            tn0Var.g(d2);
            tn0Var.j(new c(this, d2));
            tn0Var.h(new b(this, gn0Var, d2));
            tn0Var.i(new a(this, d2, activity, gn0Var));
            tn0Var.k();
            d++;
            fm0.b().d(true);
            g(ClogBuilder.LogType.FREE_SHOW, ClogBuilder.Area.DIALOG, d2);
        }
    }

    public void k(gm0 gm0Var) {
        File file;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048580, this, gm0Var) == null) && gm0Var != null && (file = gm0Var.h) != null && file.exists()) {
            String str = gm0Var.p.h;
            String absolutePath = gm0Var.h.getAbsolutePath();
            if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(absolutePath)) {
                gm0Var.q.o = "reminded_type_none";
                x31.b(this.a, gm0Var);
            }
        }
    }
}
