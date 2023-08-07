package com.baidu.tieba;

import android.text.TextUtils;
import android.util.Log;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.swan.apps.SwanAppActivity;
import com.baidu.tieba.ha2;
import com.baidu.tieba.ut2;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.tencent.open.miniapp.MiniApp;
import java.io.File;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class o63 extends m63 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @Override // com.baidu.tieba.m63
    public String g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return null;
        }
        return (String) invokeV.objValue;
    }

    @Override // com.baidu.tieba.m63
    public String h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return null;
        }
        return (String) invokeV.objValue;
    }

    @Override // com.baidu.tieba.m63
    public boolean k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return true;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tieba.m63
    public y22 m(i63 i63Var, kc2<j63> kc2Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048582, this, i63Var, kc2Var)) == null) {
            return null;
        }
        return (y22) invokeLL.objValue;
    }

    /* loaded from: classes7.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;
        public final /* synthetic */ i63 b;
        public final /* synthetic */ ha2 c;

        public a(o63 o63Var, String str, i63 i63Var, ha2 ha2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {o63Var, str, i63Var, ha2Var};
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
            this.b = i63Var;
            this.c = ha2Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                y03 y03Var = new y03();
                y03Var.c = this.a;
                y03Var.b = j63.a(this.b);
                ha2.b i = this.c.i("navigateTo");
                i.n(ha2.g, ha2.i);
                i.k("pluginFunPage", y03Var).a();
            }
        }
    }

    public o63() {
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

    @Override // com.baidu.tieba.m63
    public y22 b(JSONObject jSONObject) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, jSONObject)) == null) {
            if (jSONObject == null) {
                return new y22(201, "args params is null");
            }
            if (jSONObject.optLong("fee") < 0) {
                return new y22(201, "fee can't smaller than 0");
            }
            if (jSONObject.optJSONObject("paymentArgs") == null) {
                return new y22(201, "paymentArgs can't be null");
            }
            return null;
        }
        return (y22) invokeL.objValue;
    }

    @Override // com.baidu.tieba.m63
    public h63 f(i63 i63Var) {
        InterceptResult invokeL;
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i63Var)) == null) {
            File file = null;
            if (i63Var == null) {
                return null;
            }
            String str = i63Var.a;
            String str2 = i63Var.c;
            if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
                return null;
            }
            h63 h63Var = new h63();
            h63Var.a = str;
            h63Var.b = str2;
            if (p82.d()) {
                file = ut2.f.e();
            } else if (x63.H()) {
                file = ut2.b.e();
            } else if (x63.D()) {
                file = f82.d();
            } else {
                if (TextUtils.equals(i63Var.d, MiniApp.MINIAPP_VERSION_DEVELOP)) {
                    String a2 = a32.a(str);
                    File g = ut2.g();
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
                                    q63.b(Log.getStackTraceString(e));
                                }
                            }
                        }
                        if (i2 > -1) {
                            h63Var.a = str3 + i2;
                            h63Var.e = true;
                            File file2 = new File(g, h63Var.a + File.separator + i2);
                            h63Var.c = file2.getAbsolutePath();
                            h63Var.d = i2;
                            file = file2;
                        } else {
                            h63Var.e = false;
                            h63Var.c = null;
                        }
                    } else {
                        return h63Var;
                    }
                } else {
                    File file3 = new File(ut2.g(), str);
                    if (!file3.exists()) {
                        return h63Var;
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
                                    q63.b(Log.getStackTraceString(e2));
                                    i = -1;
                                }
                                if (i > i3) {
                                    str5 = str6;
                                    i3 = i;
                                }
                            }
                        }
                        if (i3 != -1) {
                            h63Var.d = i3;
                            h63Var.e = true;
                            file = new File(file3, str5);
                            h63Var.c = file.getAbsolutePath();
                        }
                    }
                    return h63Var;
                }
            }
            if (file == null) {
                return h63Var;
            }
            File file4 = new File(file, str2);
            if (!n(file4)) {
                return h63Var;
            }
            h63Var.f = true;
            h63Var.c = file4.getAbsolutePath();
            return h63Var;
        }
        return (h63) invokeL.objValue;
    }

    @Override // com.baidu.tieba.m63
    public y22 j(String str, i63 i63Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048580, this, str, i63Var)) == null) {
            if (i63Var == null) {
                return new y22(201, "pay args is null");
            }
            SwanAppActivity w = xa3.K().w();
            if (w == null) {
                return new y22(1001, "runtime exception, try reopen this app");
            }
            ha2 Y = w.Y();
            if (Y == null) {
                return new y22(1001, "runtime exception, page manager breakdown");
            }
            q63.b("jump to fun page");
            xa3.M().post(new a(this, str, i63Var, Y));
            return new y22(0);
        }
        return (y22) invokeLL.objValue;
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
