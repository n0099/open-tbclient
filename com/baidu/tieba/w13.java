package com.baidu.tieba;

import android.text.TextUtils;
import android.util.Log;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.swan.apps.SwanAppActivity;
import com.baidu.tieba.cp2;
import com.baidu.tieba.p52;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.tencent.open.miniapp.MiniApp;
import java.io.File;
import org.json.JSONObject;
/* loaded from: classes8.dex */
public class w13 extends u13 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @Override // com.baidu.tieba.u13
    public String g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return null;
        }
        return (String) invokeV.objValue;
    }

    @Override // com.baidu.tieba.u13
    public String h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return null;
        }
        return (String) invokeV.objValue;
    }

    @Override // com.baidu.tieba.u13
    public boolean k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return true;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tieba.u13
    public hy1 m(q13 q13Var, s72<r13> s72Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048582, this, q13Var, s72Var)) == null) {
            return null;
        }
        return (hy1) invokeLL.objValue;
    }

    /* loaded from: classes8.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;
        public final /* synthetic */ q13 b;
        public final /* synthetic */ p52 c;

        public a(w13 w13Var, String str, q13 q13Var, p52 p52Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {w13Var, str, q13Var, p52Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = str;
            this.b = q13Var;
            this.c = p52Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                gw2 gw2Var = new gw2();
                gw2Var.c = this.a;
                gw2Var.b = r13.a(this.b);
                p52.b i = this.c.i("navigateTo");
                i.n(p52.g, p52.i);
                i.k("pluginFunPage", gw2Var).a();
            }
        }
    }

    public w13() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    @Override // com.baidu.tieba.u13
    public hy1 b(JSONObject jSONObject) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, jSONObject)) == null) {
            if (jSONObject == null) {
                return new hy1(201, "args params is null");
            }
            if (jSONObject.optLong("fee") < 0) {
                return new hy1(201, "fee can't smaller than 0");
            }
            if (jSONObject.optJSONObject("paymentArgs") == null) {
                return new hy1(201, "paymentArgs can't be null");
            }
            return null;
        }
        return (hy1) invokeL.objValue;
    }

    @Override // com.baidu.tieba.u13
    public p13 f(q13 q13Var) {
        InterceptResult invokeL;
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, q13Var)) == null) {
            File file = null;
            if (q13Var == null) {
                return null;
            }
            String str = q13Var.a;
            String str2 = q13Var.c;
            if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
                return null;
            }
            p13 p13Var = new p13();
            p13Var.a = str;
            p13Var.b = str2;
            if (x32.d()) {
                file = cp2.f.e();
            } else if (f23.H()) {
                file = cp2.b.e();
            } else if (f23.D()) {
                file = n32.d();
            } else {
                if (TextUtils.equals(q13Var.d, MiniApp.MINIAPP_VERSION_DEVELOP)) {
                    String a2 = jy1.a(str);
                    File g = cp2.g();
                    String[] list = g.list();
                    if (list != null && g.length() != 0) {
                        String str3 = a2 + "_dev";
                        int i2 = -1;
                        for (String str4 : list) {
                            if (!TextUtils.isEmpty(str4) && str4.startsWith(str3)) {
                                try {
                                    int parseInt = Integer.parseInt(str4.substring(str3.length()));
                                    if (parseInt > i2) {
                                        i2 = parseInt;
                                    }
                                } catch (NumberFormatException e) {
                                    y13.b(Log.getStackTraceString(e));
                                }
                            }
                        }
                        if (i2 > -1) {
                            p13Var.a = str3 + i2;
                            p13Var.e = true;
                            File file2 = new File(g, p13Var.a + File.separator + i2);
                            p13Var.c = file2.getAbsolutePath();
                            p13Var.d = i2;
                            file = file2;
                        } else {
                            p13Var.e = false;
                            p13Var.c = null;
                        }
                    } else {
                        return p13Var;
                    }
                } else {
                    File file3 = new File(cp2.g(), str);
                    if (!file3.exists()) {
                        return p13Var;
                    }
                    String[] list2 = file3.list();
                    if (list2 != null && list2.length != 0) {
                        String str5 = null;
                        int i3 = -1;
                        for (String str6 : list2) {
                            if (!TextUtils.isEmpty(str6)) {
                                try {
                                    i = Integer.parseInt(str6);
                                } catch (NumberFormatException e2) {
                                    y13.b(Log.getStackTraceString(e2));
                                    i = -1;
                                }
                                if (i > i3) {
                                    str5 = str6;
                                    i3 = i;
                                }
                            }
                        }
                        if (i3 != -1) {
                            p13Var.d = i3;
                            p13Var.e = true;
                            file = new File(file3, str5);
                            p13Var.c = file.getAbsolutePath();
                        }
                    }
                    return p13Var;
                }
            }
            if (file == null) {
                return p13Var;
            }
            File file4 = new File(file, str2);
            if (!n(file4)) {
                return p13Var;
            }
            p13Var.f = true;
            p13Var.c = file4.getAbsolutePath();
            return p13Var;
        }
        return (p13) invokeL.objValue;
    }

    @Override // com.baidu.tieba.u13
    public hy1 j(String str, q13 q13Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048580, this, str, q13Var)) == null) {
            if (q13Var == null) {
                return new hy1(201, "pay args is null");
            }
            SwanAppActivity w = f63.K().w();
            if (w == null) {
                return new hy1(1001, "runtime exception, try reopen this app");
            }
            p52 Y = w.Y();
            if (Y == null) {
                return new hy1(1001, "runtime exception, page manager breakdown");
            }
            y13.b("jump to fun page");
            f63.M().post(new a(this, str, q13Var, Y));
            return new hy1(0);
        }
        return (hy1) invokeLL.objValue;
    }

    public final boolean n(File file) {
        InterceptResult invokeL;
        String[] list;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, file)) == null) {
            if (file == null || !file.exists() || !file.isDirectory() || (list = file.list()) == null || list.length <= 0) {
                return false;
            }
            return true;
        }
        return invokeL.booleanValue;
    }
}
