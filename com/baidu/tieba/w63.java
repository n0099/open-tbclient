package com.baidu.tieba;

import android.text.TextUtils;
import android.util.Log;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.swan.apps.SwanAppActivity;
import com.baidu.tieba.cu2;
import com.baidu.tieba.pa2;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.tencent.open.miniapp.MiniApp;
import java.io.File;
import org.json.JSONObject;
/* loaded from: classes8.dex */
public class w63 extends u63 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @Override // com.baidu.tieba.u63
    public String g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return null;
        }
        return (String) invokeV.objValue;
    }

    @Override // com.baidu.tieba.u63
    public String h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return null;
        }
        return (String) invokeV.objValue;
    }

    @Override // com.baidu.tieba.u63
    public boolean k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return true;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tieba.u63
    public g32 m(q63 q63Var, sc2<r63> sc2Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048582, this, q63Var, sc2Var)) == null) {
            return null;
        }
        return (g32) invokeLL.objValue;
    }

    /* loaded from: classes8.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;
        public final /* synthetic */ q63 b;
        public final /* synthetic */ pa2 c;

        public a(w63 w63Var, String str, q63 q63Var, pa2 pa2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {w63Var, str, q63Var, pa2Var};
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
            this.b = q63Var;
            this.c = pa2Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                g13 g13Var = new g13();
                g13Var.c = this.a;
                g13Var.b = r63.a(this.b);
                pa2.b i = this.c.i("navigateTo");
                i.n(pa2.g, pa2.i);
                i.k("pluginFunPage", g13Var).a();
            }
        }
    }

    public w63() {
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

    @Override // com.baidu.tieba.u63
    public g32 b(JSONObject jSONObject) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, jSONObject)) == null) {
            if (jSONObject == null) {
                return new g32(201, "args params is null");
            }
            if (jSONObject.optLong("fee") < 0) {
                return new g32(201, "fee can't smaller than 0");
            }
            if (jSONObject.optJSONObject("paymentArgs") == null) {
                return new g32(201, "paymentArgs can't be null");
            }
            return null;
        }
        return (g32) invokeL.objValue;
    }

    @Override // com.baidu.tieba.u63
    public p63 f(q63 q63Var) {
        InterceptResult invokeL;
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, q63Var)) == null) {
            File file = null;
            if (q63Var == null) {
                return null;
            }
            String str = q63Var.a;
            String str2 = q63Var.c;
            if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
                return null;
            }
            p63 p63Var = new p63();
            p63Var.a = str;
            p63Var.b = str2;
            if (x82.d()) {
                file = cu2.f.e();
            } else if (f73.H()) {
                file = cu2.b.e();
            } else if (f73.D()) {
                file = n82.d();
            } else {
                if (TextUtils.equals(q63Var.d, MiniApp.MINIAPP_VERSION_DEVELOP)) {
                    String a2 = i32.a(str);
                    File g = cu2.g();
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
                                    y63.b(Log.getStackTraceString(e));
                                }
                            }
                        }
                        if (i2 > -1) {
                            p63Var.a = str3 + i2;
                            p63Var.e = true;
                            File file2 = new File(g, p63Var.a + File.separator + i2);
                            p63Var.c = file2.getAbsolutePath();
                            p63Var.d = i2;
                            file = file2;
                        } else {
                            p63Var.e = false;
                            p63Var.c = null;
                        }
                    } else {
                        return p63Var;
                    }
                } else {
                    File file3 = new File(cu2.g(), str);
                    if (!file3.exists()) {
                        return p63Var;
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
                                    y63.b(Log.getStackTraceString(e2));
                                    i = -1;
                                }
                                if (i > i3) {
                                    str5 = str6;
                                    i3 = i;
                                }
                            }
                        }
                        if (i3 != -1) {
                            p63Var.d = i3;
                            p63Var.e = true;
                            file = new File(file3, str5);
                            p63Var.c = file.getAbsolutePath();
                        }
                    }
                    return p63Var;
                }
            }
            if (file == null) {
                return p63Var;
            }
            File file4 = new File(file, str2);
            if (!n(file4)) {
                return p63Var;
            }
            p63Var.f = true;
            p63Var.c = file4.getAbsolutePath();
            return p63Var;
        }
        return (p63) invokeL.objValue;
    }

    @Override // com.baidu.tieba.u63
    public g32 j(String str, q63 q63Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048580, this, str, q63Var)) == null) {
            if (q63Var == null) {
                return new g32(201, "pay args is null");
            }
            SwanAppActivity w = fb3.K().w();
            if (w == null) {
                return new g32(1001, "runtime exception, try reopen this app");
            }
            pa2 X = w.X();
            if (X == null) {
                return new g32(1001, "runtime exception, page manager breakdown");
            }
            y63.b("jump to fun page");
            fb3.M().post(new a(this, str, q63Var, X));
            return new g32(0);
        }
        return (g32) invokeLL.objValue;
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
