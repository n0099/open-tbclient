package com.baidu.tieba;

import android.text.TextUtils;
import android.util.Log;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.swan.apps.SwanAppActivity;
import com.baidu.tieba.eb2;
import com.baidu.tieba.ru2;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.tencent.open.miniapp.MiniApp;
import java.io.File;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class l73 extends j73 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @Override // com.baidu.tieba.j73
    public String g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return null;
        }
        return (String) invokeV.objValue;
    }

    @Override // com.baidu.tieba.j73
    public String h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return null;
        }
        return (String) invokeV.objValue;
    }

    @Override // com.baidu.tieba.j73
    public boolean k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return true;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tieba.j73
    public v32 m(f73 f73Var, hd2<g73> hd2Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048582, this, f73Var, hd2Var)) == null) {
            return null;
        }
        return (v32) invokeLL.objValue;
    }

    /* loaded from: classes6.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;
        public final /* synthetic */ f73 b;
        public final /* synthetic */ eb2 c;

        public a(l73 l73Var, String str, f73 f73Var, eb2 eb2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {l73Var, str, f73Var, eb2Var};
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
            this.b = f73Var;
            this.c = eb2Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                v13 v13Var = new v13();
                v13Var.c = this.a;
                v13Var.b = g73.a(this.b);
                eb2.b i = this.c.i("navigateTo");
                i.n(eb2.g, eb2.i);
                i.k("pluginFunPage", v13Var).a();
            }
        }
    }

    public l73() {
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

    @Override // com.baidu.tieba.j73
    public v32 b(JSONObject jSONObject) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, jSONObject)) == null) {
            if (jSONObject == null) {
                return new v32(201, "args params is null");
            }
            if (jSONObject.optLong("fee") < 0) {
                return new v32(201, "fee can't smaller than 0");
            }
            if (jSONObject.optJSONObject("paymentArgs") == null) {
                return new v32(201, "paymentArgs can't be null");
            }
            return null;
        }
        return (v32) invokeL.objValue;
    }

    @Override // com.baidu.tieba.j73
    public e73 f(f73 f73Var) {
        InterceptResult invokeL;
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, f73Var)) == null) {
            File file = null;
            if (f73Var == null) {
                return null;
            }
            String str = f73Var.a;
            String str2 = f73Var.c;
            if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
                return null;
            }
            e73 e73Var = new e73();
            e73Var.a = str;
            e73Var.b = str2;
            if (m92.d()) {
                file = ru2.f.e();
            } else if (u73.H()) {
                file = ru2.b.e();
            } else if (u73.D()) {
                file = c92.d();
            } else {
                if (TextUtils.equals(f73Var.d, MiniApp.MINIAPP_VERSION_DEVELOP)) {
                    String a2 = x32.a(str);
                    File g = ru2.g();
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
                                    n73.b(Log.getStackTraceString(e));
                                }
                            }
                        }
                        if (i2 > -1) {
                            e73Var.a = str3 + i2;
                            e73Var.e = true;
                            File file2 = new File(g, e73Var.a + File.separator + i2);
                            e73Var.c = file2.getAbsolutePath();
                            e73Var.d = i2;
                            file = file2;
                        } else {
                            e73Var.e = false;
                            e73Var.c = null;
                        }
                    } else {
                        return e73Var;
                    }
                } else {
                    File file3 = new File(ru2.g(), str);
                    if (!file3.exists()) {
                        return e73Var;
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
                                    n73.b(Log.getStackTraceString(e2));
                                    i = -1;
                                }
                                if (i > i3) {
                                    str5 = str6;
                                    i3 = i;
                                }
                            }
                        }
                        if (i3 != -1) {
                            e73Var.d = i3;
                            e73Var.e = true;
                            file = new File(file3, str5);
                            e73Var.c = file.getAbsolutePath();
                        }
                    }
                    return e73Var;
                }
            }
            if (file == null) {
                return e73Var;
            }
            File file4 = new File(file, str2);
            if (!n(file4)) {
                return e73Var;
            }
            e73Var.f = true;
            e73Var.c = file4.getAbsolutePath();
            return e73Var;
        }
        return (e73) invokeL.objValue;
    }

    @Override // com.baidu.tieba.j73
    public v32 j(String str, f73 f73Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048580, this, str, f73Var)) == null) {
            if (f73Var == null) {
                return new v32(201, "pay args is null");
            }
            SwanAppActivity w = ub3.K().w();
            if (w == null) {
                return new v32(1001, "runtime exception, try reopen this app");
            }
            eb2 Y = w.Y();
            if (Y == null) {
                return new v32(1001, "runtime exception, page manager breakdown");
            }
            n73.b("jump to fun page");
            ub3.M().post(new a(this, str, f73Var, Y));
            return new v32(0);
        }
        return (v32) invokeLL.objValue;
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
