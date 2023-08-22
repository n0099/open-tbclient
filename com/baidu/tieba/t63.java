package com.baidu.tieba;

import android.text.TextUtils;
import android.util.Log;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.swan.apps.SwanAppActivity;
import com.baidu.tieba.ma2;
import com.baidu.tieba.zt2;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.tencent.open.miniapp.MiniApp;
import java.io.File;
import org.json.JSONObject;
/* loaded from: classes8.dex */
public class t63 extends r63 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @Override // com.baidu.tieba.r63
    public String g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return null;
        }
        return (String) invokeV.objValue;
    }

    @Override // com.baidu.tieba.r63
    public String h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return null;
        }
        return (String) invokeV.objValue;
    }

    @Override // com.baidu.tieba.r63
    public boolean k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return true;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tieba.r63
    public d32 m(n63 n63Var, pc2<o63> pc2Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048582, this, n63Var, pc2Var)) == null) {
            return null;
        }
        return (d32) invokeLL.objValue;
    }

    /* loaded from: classes8.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;
        public final /* synthetic */ n63 b;
        public final /* synthetic */ ma2 c;

        public a(t63 t63Var, String str, n63 n63Var, ma2 ma2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {t63Var, str, n63Var, ma2Var};
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
            this.b = n63Var;
            this.c = ma2Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                d13 d13Var = new d13();
                d13Var.c = this.a;
                d13Var.b = o63.a(this.b);
                ma2.b i = this.c.i("navigateTo");
                i.n(ma2.g, ma2.i);
                i.k("pluginFunPage", d13Var).a();
            }
        }
    }

    public t63() {
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

    @Override // com.baidu.tieba.r63
    public d32 b(JSONObject jSONObject) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, jSONObject)) == null) {
            if (jSONObject == null) {
                return new d32(201, "args params is null");
            }
            if (jSONObject.optLong("fee") < 0) {
                return new d32(201, "fee can't smaller than 0");
            }
            if (jSONObject.optJSONObject("paymentArgs") == null) {
                return new d32(201, "paymentArgs can't be null");
            }
            return null;
        }
        return (d32) invokeL.objValue;
    }

    @Override // com.baidu.tieba.r63
    public m63 f(n63 n63Var) {
        InterceptResult invokeL;
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, n63Var)) == null) {
            File file = null;
            if (n63Var == null) {
                return null;
            }
            String str = n63Var.a;
            String str2 = n63Var.c;
            if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
                return null;
            }
            m63 m63Var = new m63();
            m63Var.a = str;
            m63Var.b = str2;
            if (u82.d()) {
                file = zt2.f.e();
            } else if (c73.H()) {
                file = zt2.b.e();
            } else if (c73.D()) {
                file = k82.d();
            } else {
                if (TextUtils.equals(n63Var.d, MiniApp.MINIAPP_VERSION_DEVELOP)) {
                    String a2 = f32.a(str);
                    File g = zt2.g();
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
                                    v63.b(Log.getStackTraceString(e));
                                }
                            }
                        }
                        if (i2 > -1) {
                            m63Var.a = str3 + i2;
                            m63Var.e = true;
                            File file2 = new File(g, m63Var.a + File.separator + i2);
                            m63Var.c = file2.getAbsolutePath();
                            m63Var.d = i2;
                            file = file2;
                        } else {
                            m63Var.e = false;
                            m63Var.c = null;
                        }
                    } else {
                        return m63Var;
                    }
                } else {
                    File file3 = new File(zt2.g(), str);
                    if (!file3.exists()) {
                        return m63Var;
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
                                    v63.b(Log.getStackTraceString(e2));
                                    i = -1;
                                }
                                if (i > i3) {
                                    str5 = str6;
                                    i3 = i;
                                }
                            }
                        }
                        if (i3 != -1) {
                            m63Var.d = i3;
                            m63Var.e = true;
                            file = new File(file3, str5);
                            m63Var.c = file.getAbsolutePath();
                        }
                    }
                    return m63Var;
                }
            }
            if (file == null) {
                return m63Var;
            }
            File file4 = new File(file, str2);
            if (!n(file4)) {
                return m63Var;
            }
            m63Var.f = true;
            m63Var.c = file4.getAbsolutePath();
            return m63Var;
        }
        return (m63) invokeL.objValue;
    }

    @Override // com.baidu.tieba.r63
    public d32 j(String str, n63 n63Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048580, this, str, n63Var)) == null) {
            if (n63Var == null) {
                return new d32(201, "pay args is null");
            }
            SwanAppActivity w = cb3.K().w();
            if (w == null) {
                return new d32(1001, "runtime exception, try reopen this app");
            }
            ma2 Y = w.Y();
            if (Y == null) {
                return new d32(1001, "runtime exception, page manager breakdown");
            }
            v63.b("jump to fun page");
            cb3.M().post(new a(this, str, n63Var, Y));
            return new d32(0);
        }
        return (d32) invokeLL.objValue;
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
