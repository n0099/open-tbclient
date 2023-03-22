package com.baidu.tieba;

import android.text.TextUtils;
import android.util.Log;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.swan.apps.SwanAppActivity;
import com.baidu.tieba.c72;
import com.baidu.tieba.pq2;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.tencent.open.miniapp.MiniApp;
import java.io.File;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class j33 extends h33 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @Override // com.baidu.tieba.h33
    public String g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return null;
        }
        return (String) invokeV.objValue;
    }

    @Override // com.baidu.tieba.h33
    public String h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return null;
        }
        return (String) invokeV.objValue;
    }

    @Override // com.baidu.tieba.h33
    public boolean k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return true;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tieba.h33
    public tz1 m(d33 d33Var, f92<e33> f92Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048582, this, d33Var, f92Var)) == null) {
            return null;
        }
        return (tz1) invokeLL.objValue;
    }

    /* loaded from: classes5.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;
        public final /* synthetic */ d33 b;
        public final /* synthetic */ c72 c;

        public a(j33 j33Var, String str, d33 d33Var, c72 c72Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {j33Var, str, d33Var, c72Var};
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
            this.b = d33Var;
            this.c = c72Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                tx2 tx2Var = new tx2();
                tx2Var.c = this.a;
                tx2Var.b = e33.a(this.b);
                c72.b i = this.c.i("navigateTo");
                i.n(c72.g, c72.i);
                i.k("pluginFunPage", tx2Var).a();
            }
        }
    }

    public j33() {
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

    @Override // com.baidu.tieba.h33
    public tz1 b(JSONObject jSONObject) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, jSONObject)) == null) {
            if (jSONObject == null) {
                return new tz1(201, "args params is null");
            }
            if (jSONObject.optLong("fee") < 0) {
                return new tz1(201, "fee can't smaller than 0");
            }
            if (jSONObject.optJSONObject("paymentArgs") == null) {
                return new tz1(201, "paymentArgs can't be null");
            }
            return null;
        }
        return (tz1) invokeL.objValue;
    }

    @Override // com.baidu.tieba.h33
    public c33 f(d33 d33Var) {
        InterceptResult invokeL;
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, d33Var)) == null) {
            File file = null;
            if (d33Var == null) {
                return null;
            }
            String str = d33Var.a;
            String str2 = d33Var.c;
            if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
                return null;
            }
            c33 c33Var = new c33();
            c33Var.a = str;
            c33Var.b = str2;
            if (k52.d()) {
                file = pq2.f.e();
            } else if (s33.H()) {
                file = pq2.b.e();
            } else if (s33.D()) {
                file = a52.d();
            } else {
                if (TextUtils.equals(d33Var.d, MiniApp.MINIAPP_VERSION_DEVELOP)) {
                    String a2 = vz1.a(str);
                    File g = pq2.g();
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
                                    l33.b(Log.getStackTraceString(e));
                                }
                            }
                        }
                        if (i2 > -1) {
                            c33Var.a = str3 + i2;
                            c33Var.e = true;
                            File file2 = new File(g, c33Var.a + File.separator + i2);
                            c33Var.c = file2.getAbsolutePath();
                            c33Var.d = i2;
                            file = file2;
                        } else {
                            c33Var.e = false;
                            c33Var.c = null;
                        }
                    } else {
                        return c33Var;
                    }
                } else {
                    File file3 = new File(pq2.g(), str);
                    if (!file3.exists()) {
                        return c33Var;
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
                                    l33.b(Log.getStackTraceString(e2));
                                    i = -1;
                                }
                                if (i > i3) {
                                    str5 = str6;
                                    i3 = i;
                                }
                            }
                        }
                        if (i3 != -1) {
                            c33Var.d = i3;
                            c33Var.e = true;
                            file = new File(file3, str5);
                            c33Var.c = file.getAbsolutePath();
                        }
                    }
                    return c33Var;
                }
            }
            if (file == null) {
                return c33Var;
            }
            File file4 = new File(file, str2);
            if (!n(file4)) {
                return c33Var;
            }
            c33Var.f = true;
            c33Var.c = file4.getAbsolutePath();
            return c33Var;
        }
        return (c33) invokeL.objValue;
    }

    @Override // com.baidu.tieba.h33
    public tz1 j(String str, d33 d33Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048580, this, str, d33Var)) == null) {
            if (d33Var == null) {
                return new tz1(201, "pay args is null");
            }
            SwanAppActivity w = s73.K().w();
            if (w == null) {
                return new tz1(1001, "runtime exception, try reopen this app");
            }
            c72 Z = w.Z();
            if (Z == null) {
                return new tz1(1001, "runtime exception, page manager breakdown");
            }
            l33.b("jump to fun page");
            s73.M().post(new a(this, str, d33Var, Z));
            return new tz1(0);
        }
        return (tz1) invokeLL.objValue;
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
