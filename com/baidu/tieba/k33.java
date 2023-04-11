package com.baidu.tieba;

import android.text.TextUtils;
import android.util.Log;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.swan.apps.SwanAppActivity;
import com.baidu.tieba.d72;
import com.baidu.tieba.qq2;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.tencent.open.miniapp.MiniApp;
import java.io.File;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class k33 extends i33 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @Override // com.baidu.tieba.i33
    public String g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return null;
        }
        return (String) invokeV.objValue;
    }

    @Override // com.baidu.tieba.i33
    public String h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return null;
        }
        return (String) invokeV.objValue;
    }

    @Override // com.baidu.tieba.i33
    public boolean k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return true;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tieba.i33
    public uz1 m(e33 e33Var, g92<f33> g92Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048582, this, e33Var, g92Var)) == null) {
            return null;
        }
        return (uz1) invokeLL.objValue;
    }

    /* loaded from: classes5.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;
        public final /* synthetic */ e33 b;
        public final /* synthetic */ d72 c;

        public a(k33 k33Var, String str, e33 e33Var, d72 d72Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {k33Var, str, e33Var, d72Var};
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
            this.b = e33Var;
            this.c = d72Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                ux2 ux2Var = new ux2();
                ux2Var.c = this.a;
                ux2Var.b = f33.a(this.b);
                d72.b i = this.c.i("navigateTo");
                i.n(d72.g, d72.i);
                i.k("pluginFunPage", ux2Var).a();
            }
        }
    }

    public k33() {
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

    @Override // com.baidu.tieba.i33
    public uz1 b(JSONObject jSONObject) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, jSONObject)) == null) {
            if (jSONObject == null) {
                return new uz1(201, "args params is null");
            }
            if (jSONObject.optLong("fee") < 0) {
                return new uz1(201, "fee can't smaller than 0");
            }
            if (jSONObject.optJSONObject("paymentArgs") == null) {
                return new uz1(201, "paymentArgs can't be null");
            }
            return null;
        }
        return (uz1) invokeL.objValue;
    }

    @Override // com.baidu.tieba.i33
    public d33 f(e33 e33Var) {
        InterceptResult invokeL;
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, e33Var)) == null) {
            File file = null;
            if (e33Var == null) {
                return null;
            }
            String str = e33Var.a;
            String str2 = e33Var.c;
            if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
                return null;
            }
            d33 d33Var = new d33();
            d33Var.a = str;
            d33Var.b = str2;
            if (l52.d()) {
                file = qq2.f.e();
            } else if (t33.H()) {
                file = qq2.b.e();
            } else if (t33.D()) {
                file = b52.d();
            } else {
                if (TextUtils.equals(e33Var.d, MiniApp.MINIAPP_VERSION_DEVELOP)) {
                    String a2 = wz1.a(str);
                    File g = qq2.g();
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
                                    m33.b(Log.getStackTraceString(e));
                                }
                            }
                        }
                        if (i2 > -1) {
                            d33Var.a = str3 + i2;
                            d33Var.e = true;
                            File file2 = new File(g, d33Var.a + File.separator + i2);
                            d33Var.c = file2.getAbsolutePath();
                            d33Var.d = i2;
                            file = file2;
                        } else {
                            d33Var.e = false;
                            d33Var.c = null;
                        }
                    } else {
                        return d33Var;
                    }
                } else {
                    File file3 = new File(qq2.g(), str);
                    if (!file3.exists()) {
                        return d33Var;
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
                                    m33.b(Log.getStackTraceString(e2));
                                    i = -1;
                                }
                                if (i > i3) {
                                    str5 = str6;
                                    i3 = i;
                                }
                            }
                        }
                        if (i3 != -1) {
                            d33Var.d = i3;
                            d33Var.e = true;
                            file = new File(file3, str5);
                            d33Var.c = file.getAbsolutePath();
                        }
                    }
                    return d33Var;
                }
            }
            if (file == null) {
                return d33Var;
            }
            File file4 = new File(file, str2);
            if (!n(file4)) {
                return d33Var;
            }
            d33Var.f = true;
            d33Var.c = file4.getAbsolutePath();
            return d33Var;
        }
        return (d33) invokeL.objValue;
    }

    @Override // com.baidu.tieba.i33
    public uz1 j(String str, e33 e33Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048580, this, str, e33Var)) == null) {
            if (e33Var == null) {
                return new uz1(201, "pay args is null");
            }
            SwanAppActivity w = t73.K().w();
            if (w == null) {
                return new uz1(1001, "runtime exception, try reopen this app");
            }
            d72 Z = w.Z();
            if (Z == null) {
                return new uz1(1001, "runtime exception, page manager breakdown");
            }
            m33.b("jump to fun page");
            t73.M().post(new a(this, str, e33Var, Z));
            return new uz1(0);
        }
        return (uz1) invokeLL.objValue;
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
