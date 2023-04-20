package com.baidu.tieba;

import android.text.TextUtils;
import android.util.Log;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.swan.apps.SwanAppActivity;
import com.baidu.tieba.e72;
import com.baidu.tieba.rq2;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.tencent.open.miniapp.MiniApp;
import java.io.File;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class l33 extends j33 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @Override // com.baidu.tieba.j33
    public String g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return null;
        }
        return (String) invokeV.objValue;
    }

    @Override // com.baidu.tieba.j33
    public String h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return null;
        }
        return (String) invokeV.objValue;
    }

    @Override // com.baidu.tieba.j33
    public boolean k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return true;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tieba.j33
    public vz1 m(f33 f33Var, h92<g33> h92Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048582, this, f33Var, h92Var)) == null) {
            return null;
        }
        return (vz1) invokeLL.objValue;
    }

    /* loaded from: classes5.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;
        public final /* synthetic */ f33 b;
        public final /* synthetic */ e72 c;

        public a(l33 l33Var, String str, f33 f33Var, e72 e72Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {l33Var, str, f33Var, e72Var};
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
            this.b = f33Var;
            this.c = e72Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                vx2 vx2Var = new vx2();
                vx2Var.c = this.a;
                vx2Var.b = g33.a(this.b);
                e72.b i = this.c.i("navigateTo");
                i.n(e72.g, e72.i);
                i.k("pluginFunPage", vx2Var).a();
            }
        }
    }

    public l33() {
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

    @Override // com.baidu.tieba.j33
    public vz1 b(JSONObject jSONObject) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, jSONObject)) == null) {
            if (jSONObject == null) {
                return new vz1(201, "args params is null");
            }
            if (jSONObject.optLong("fee") < 0) {
                return new vz1(201, "fee can't smaller than 0");
            }
            if (jSONObject.optJSONObject("paymentArgs") == null) {
                return new vz1(201, "paymentArgs can't be null");
            }
            return null;
        }
        return (vz1) invokeL.objValue;
    }

    @Override // com.baidu.tieba.j33
    public e33 f(f33 f33Var) {
        InterceptResult invokeL;
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, f33Var)) == null) {
            File file = null;
            if (f33Var == null) {
                return null;
            }
            String str = f33Var.a;
            String str2 = f33Var.c;
            if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
                return null;
            }
            e33 e33Var = new e33();
            e33Var.a = str;
            e33Var.b = str2;
            if (m52.d()) {
                file = rq2.f.e();
            } else if (u33.H()) {
                file = rq2.b.e();
            } else if (u33.D()) {
                file = c52.d();
            } else {
                if (TextUtils.equals(f33Var.d, MiniApp.MINIAPP_VERSION_DEVELOP)) {
                    String a2 = xz1.a(str);
                    File g = rq2.g();
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
                                    n33.b(Log.getStackTraceString(e));
                                }
                            }
                        }
                        if (i2 > -1) {
                            e33Var.a = str3 + i2;
                            e33Var.e = true;
                            File file2 = new File(g, e33Var.a + File.separator + i2);
                            e33Var.c = file2.getAbsolutePath();
                            e33Var.d = i2;
                            file = file2;
                        } else {
                            e33Var.e = false;
                            e33Var.c = null;
                        }
                    } else {
                        return e33Var;
                    }
                } else {
                    File file3 = new File(rq2.g(), str);
                    if (!file3.exists()) {
                        return e33Var;
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
                                    n33.b(Log.getStackTraceString(e2));
                                    i = -1;
                                }
                                if (i > i3) {
                                    str5 = str6;
                                    i3 = i;
                                }
                            }
                        }
                        if (i3 != -1) {
                            e33Var.d = i3;
                            e33Var.e = true;
                            file = new File(file3, str5);
                            e33Var.c = file.getAbsolutePath();
                        }
                    }
                    return e33Var;
                }
            }
            if (file == null) {
                return e33Var;
            }
            File file4 = new File(file, str2);
            if (!n(file4)) {
                return e33Var;
            }
            e33Var.f = true;
            e33Var.c = file4.getAbsolutePath();
            return e33Var;
        }
        return (e33) invokeL.objValue;
    }

    @Override // com.baidu.tieba.j33
    public vz1 j(String str, f33 f33Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048580, this, str, f33Var)) == null) {
            if (f33Var == null) {
                return new vz1(201, "pay args is null");
            }
            SwanAppActivity w = u73.K().w();
            if (w == null) {
                return new vz1(1001, "runtime exception, try reopen this app");
            }
            e72 Z = w.Z();
            if (Z == null) {
                return new vz1(1001, "runtime exception, page manager breakdown");
            }
            n33.b("jump to fun page");
            u73.M().post(new a(this, str, f33Var, Z));
            return new vz1(0);
        }
        return (vz1) invokeLL.objValue;
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
