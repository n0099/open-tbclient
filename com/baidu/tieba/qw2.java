package com.baidu.tieba;

import android.text.TextUtils;
import android.util.Log;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.swan.apps.SwanAppActivity;
import com.baidu.tieba.j02;
import com.baidu.tieba.wj2;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.tencent.open.miniapp.MiniApp;
import java.io.File;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class qw2 extends ow2 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes5.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;
        public final /* synthetic */ kw2 b;
        public final /* synthetic */ j02 c;

        public a(qw2 qw2Var, String str, kw2 kw2Var, j02 j02Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {qw2Var, str, kw2Var, j02Var};
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
            this.b = kw2Var;
            this.c = j02Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                ar2 ar2Var = new ar2();
                ar2Var.c = this.a;
                ar2Var.b = lw2.a(this.b);
                j02.b i = this.c.i("navigateTo");
                i.n(j02.g, j02.i);
                i.k("pluginFunPage", ar2Var).a();
            }
        }
    }

    public qw2() {
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

    @Override // com.baidu.tieba.ow2
    public at1 b(JSONObject jSONObject) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, jSONObject)) == null) {
            if (jSONObject == null) {
                return new at1(201, "args params is null");
            }
            if (jSONObject.optLong("fee") < 0) {
                return new at1(201, "fee can't smaller than 0");
            }
            if (jSONObject.optJSONObject("paymentArgs") == null) {
                return new at1(201, "paymentArgs can't be null");
            }
            return null;
        }
        return (at1) invokeL.objValue;
    }

    @Override // com.baidu.tieba.ow2
    public jw2 f(kw2 kw2Var) {
        InterceptResult invokeL;
        String[] list;
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, kw2Var)) == null) {
            File file = null;
            if (kw2Var == null) {
                return null;
            }
            String str = kw2Var.a;
            String str2 = kw2Var.c;
            if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
                return null;
            }
            jw2 jw2Var = new jw2();
            jw2Var.a = str;
            jw2Var.b = str2;
            if (ry1.d()) {
                file = wj2.f.e();
            } else if (zw2.H()) {
                file = wj2.b.e();
            } else if (zw2.D()) {
                file = hy1.d();
            } else {
                if (TextUtils.equals(kw2Var.d, MiniApp.MINIAPP_VERSION_DEVELOP)) {
                    String a2 = ct1.a(str);
                    File g = wj2.g();
                    String[] list2 = g.list();
                    if (list2 == null || g.length() == 0) {
                        return jw2Var;
                    }
                    String str3 = a2 + "_dev";
                    int i2 = -1;
                    for (String str4 : list2) {
                        if (!TextUtils.isEmpty(str4) && str4.startsWith(str3)) {
                            try {
                                int parseInt = Integer.parseInt(str4.substring(str3.length()));
                                if (parseInt > i2) {
                                    i2 = parseInt;
                                }
                            } catch (NumberFormatException e) {
                                sw2.b(Log.getStackTraceString(e));
                            }
                        }
                    }
                    if (i2 > -1) {
                        jw2Var.a = str3 + i2;
                        jw2Var.e = true;
                        File file2 = new File(g, jw2Var.a + File.separator + i2);
                        jw2Var.c = file2.getAbsolutePath();
                        jw2Var.d = i2;
                        file = file2;
                    } else {
                        jw2Var.e = false;
                        jw2Var.c = null;
                    }
                } else {
                    File file3 = new File(wj2.g(), str);
                    if (file3.exists() && (list = file3.list()) != null && list.length != 0) {
                        String str5 = null;
                        int i3 = -1;
                        for (String str6 : list) {
                            if (!TextUtils.isEmpty(str6)) {
                                try {
                                    i = Integer.parseInt(str6);
                                } catch (NumberFormatException e2) {
                                    sw2.b(Log.getStackTraceString(e2));
                                    i = -1;
                                }
                                if (i > i3) {
                                    str5 = str6;
                                    i3 = i;
                                }
                            }
                        }
                        if (i3 != -1) {
                            jw2Var.d = i3;
                            jw2Var.e = true;
                            file = new File(file3, str5);
                            jw2Var.c = file.getAbsolutePath();
                        }
                    }
                    return jw2Var;
                }
            }
            if (file == null) {
                return jw2Var;
            }
            File file4 = new File(file, str2);
            if (n(file4)) {
                jw2Var.f = true;
                jw2Var.c = file4.getAbsolutePath();
                return jw2Var;
            }
            return jw2Var;
        }
        return (jw2) invokeL.objValue;
    }

    @Override // com.baidu.tieba.ow2
    public String g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return null;
        }
        return (String) invokeV.objValue;
    }

    @Override // com.baidu.tieba.ow2
    public String h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return null;
        }
        return (String) invokeV.objValue;
    }

    @Override // com.baidu.tieba.ow2
    public at1 j(String str, kw2 kw2Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048580, this, str, kw2Var)) == null) {
            if (kw2Var == null) {
                return new at1(201, "pay args is null");
            }
            SwanAppActivity w = z03.K().w();
            if (w == null) {
                return new at1(1001, "runtime exception, try reopen this app");
            }
            j02 X = w.X();
            if (X == null) {
                return new at1(1001, "runtime exception, page manager breakdown");
            }
            sw2.b("jump to fun page");
            z03.M().post(new a(this, str, kw2Var, X));
            return new at1(0);
        }
        return (at1) invokeLL.objValue;
    }

    @Override // com.baidu.tieba.ow2
    public boolean k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return true;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tieba.ow2
    public at1 m(kw2 kw2Var, m22<lw2> m22Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048582, this, kw2Var, m22Var)) == null) {
            return null;
        }
        return (at1) invokeLL.objValue;
    }

    public final boolean n(File file) {
        InterceptResult invokeL;
        String[] list;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, file)) == null) ? file != null && file.exists() && file.isDirectory() && (list = file.list()) != null && list.length > 0 : invokeL.booleanValue;
    }
}
