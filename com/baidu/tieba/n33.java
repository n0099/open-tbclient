package com.baidu.tieba;

import android.text.TextUtils;
import android.util.Log;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.swan.apps.SwanAppActivity;
import com.baidu.tieba.g72;
import com.baidu.tieba.tq2;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.tencent.open.miniapp.MiniApp;
import java.io.File;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class n33 extends l33 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @Override // com.baidu.tieba.l33
    public String g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return null;
        }
        return (String) invokeV.objValue;
    }

    @Override // com.baidu.tieba.l33
    public String h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return null;
        }
        return (String) invokeV.objValue;
    }

    @Override // com.baidu.tieba.l33
    public boolean k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return true;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tieba.l33
    public xz1 m(h33 h33Var, j92<i33> j92Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048582, this, h33Var, j92Var)) == null) {
            return null;
        }
        return (xz1) invokeLL.objValue;
    }

    /* loaded from: classes5.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;
        public final /* synthetic */ h33 b;
        public final /* synthetic */ g72 c;

        public a(n33 n33Var, String str, h33 h33Var, g72 g72Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {n33Var, str, h33Var, g72Var};
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
            this.b = h33Var;
            this.c = g72Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                xx2 xx2Var = new xx2();
                xx2Var.c = this.a;
                xx2Var.b = i33.a(this.b);
                g72.b i = this.c.i("navigateTo");
                i.n(g72.g, g72.i);
                i.k("pluginFunPage", xx2Var).a();
            }
        }
    }

    public n33() {
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

    @Override // com.baidu.tieba.l33
    public xz1 b(JSONObject jSONObject) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, jSONObject)) == null) {
            if (jSONObject == null) {
                return new xz1(201, "args params is null");
            }
            if (jSONObject.optLong("fee") < 0) {
                return new xz1(201, "fee can't smaller than 0");
            }
            if (jSONObject.optJSONObject("paymentArgs") == null) {
                return new xz1(201, "paymentArgs can't be null");
            }
            return null;
        }
        return (xz1) invokeL.objValue;
    }

    @Override // com.baidu.tieba.l33
    public g33 f(h33 h33Var) {
        InterceptResult invokeL;
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, h33Var)) == null) {
            File file = null;
            if (h33Var == null) {
                return null;
            }
            String str = h33Var.a;
            String str2 = h33Var.c;
            if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
                return null;
            }
            g33 g33Var = new g33();
            g33Var.a = str;
            g33Var.b = str2;
            if (o52.d()) {
                file = tq2.f.e();
            } else if (w33.H()) {
                file = tq2.b.e();
            } else if (w33.D()) {
                file = e52.d();
            } else {
                if (TextUtils.equals(h33Var.d, MiniApp.MINIAPP_VERSION_DEVELOP)) {
                    String a2 = zz1.a(str);
                    File g = tq2.g();
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
                                    p33.b(Log.getStackTraceString(e));
                                }
                            }
                        }
                        if (i2 > -1) {
                            g33Var.a = str3 + i2;
                            g33Var.e = true;
                            File file2 = new File(g, g33Var.a + File.separator + i2);
                            g33Var.c = file2.getAbsolutePath();
                            g33Var.d = i2;
                            file = file2;
                        } else {
                            g33Var.e = false;
                            g33Var.c = null;
                        }
                    } else {
                        return g33Var;
                    }
                } else {
                    File file3 = new File(tq2.g(), str);
                    if (!file3.exists()) {
                        return g33Var;
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
                                    p33.b(Log.getStackTraceString(e2));
                                    i = -1;
                                }
                                if (i > i3) {
                                    str5 = str6;
                                    i3 = i;
                                }
                            }
                        }
                        if (i3 != -1) {
                            g33Var.d = i3;
                            g33Var.e = true;
                            file = new File(file3, str5);
                            g33Var.c = file.getAbsolutePath();
                        }
                    }
                    return g33Var;
                }
            }
            if (file == null) {
                return g33Var;
            }
            File file4 = new File(file, str2);
            if (!n(file4)) {
                return g33Var;
            }
            g33Var.f = true;
            g33Var.c = file4.getAbsolutePath();
            return g33Var;
        }
        return (g33) invokeL.objValue;
    }

    @Override // com.baidu.tieba.l33
    public xz1 j(String str, h33 h33Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048580, this, str, h33Var)) == null) {
            if (h33Var == null) {
                return new xz1(201, "pay args is null");
            }
            SwanAppActivity w = w73.K().w();
            if (w == null) {
                return new xz1(1001, "runtime exception, try reopen this app");
            }
            g72 Z = w.Z();
            if (Z == null) {
                return new xz1(1001, "runtime exception, page manager breakdown");
            }
            p33.b("jump to fun page");
            w73.M().post(new a(this, str, h33Var, Z));
            return new xz1(0);
        }
        return (xz1) invokeLL.objValue;
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
