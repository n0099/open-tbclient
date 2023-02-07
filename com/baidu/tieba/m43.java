package com.baidu.tieba;

import android.text.TextUtils;
import android.util.Log;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.swan.apps.SwanAppActivity;
import com.baidu.tieba.f82;
import com.baidu.tieba.sr2;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.tencent.open.miniapp.MiniApp;
import java.io.File;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class m43 extends k43 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @Override // com.baidu.tieba.k43
    public String g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return null;
        }
        return (String) invokeV.objValue;
    }

    @Override // com.baidu.tieba.k43
    public String h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return null;
        }
        return (String) invokeV.objValue;
    }

    @Override // com.baidu.tieba.k43
    public boolean k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return true;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tieba.k43
    public w02 m(g43 g43Var, ia2<h43> ia2Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048582, this, g43Var, ia2Var)) == null) {
            return null;
        }
        return (w02) invokeLL.objValue;
    }

    /* loaded from: classes5.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;
        public final /* synthetic */ g43 b;
        public final /* synthetic */ f82 c;

        public a(m43 m43Var, String str, g43 g43Var, f82 f82Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {m43Var, str, g43Var, f82Var};
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
            this.b = g43Var;
            this.c = f82Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                wy2 wy2Var = new wy2();
                wy2Var.c = this.a;
                wy2Var.b = h43.a(this.b);
                f82.b i = this.c.i("navigateTo");
                i.n(f82.g, f82.i);
                i.k("pluginFunPage", wy2Var).a();
            }
        }
    }

    public m43() {
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

    @Override // com.baidu.tieba.k43
    public w02 b(JSONObject jSONObject) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, jSONObject)) == null) {
            if (jSONObject == null) {
                return new w02(201, "args params is null");
            }
            if (jSONObject.optLong("fee") < 0) {
                return new w02(201, "fee can't smaller than 0");
            }
            if (jSONObject.optJSONObject("paymentArgs") == null) {
                return new w02(201, "paymentArgs can't be null");
            }
            return null;
        }
        return (w02) invokeL.objValue;
    }

    @Override // com.baidu.tieba.k43
    public f43 f(g43 g43Var) {
        InterceptResult invokeL;
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, g43Var)) == null) {
            File file = null;
            if (g43Var == null) {
                return null;
            }
            String str = g43Var.a;
            String str2 = g43Var.c;
            if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
                return null;
            }
            f43 f43Var = new f43();
            f43Var.a = str;
            f43Var.b = str2;
            if (n62.d()) {
                file = sr2.f.e();
            } else if (v43.H()) {
                file = sr2.b.e();
            } else if (v43.D()) {
                file = d62.d();
            } else {
                if (TextUtils.equals(g43Var.d, MiniApp.MINIAPP_VERSION_DEVELOP)) {
                    String a2 = y02.a(str);
                    File g = sr2.g();
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
                                    o43.b(Log.getStackTraceString(e));
                                }
                            }
                        }
                        if (i2 > -1) {
                            f43Var.a = str3 + i2;
                            f43Var.e = true;
                            File file2 = new File(g, f43Var.a + File.separator + i2);
                            f43Var.c = file2.getAbsolutePath();
                            f43Var.d = i2;
                            file = file2;
                        } else {
                            f43Var.e = false;
                            f43Var.c = null;
                        }
                    } else {
                        return f43Var;
                    }
                } else {
                    File file3 = new File(sr2.g(), str);
                    if (!file3.exists()) {
                        return f43Var;
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
                                    o43.b(Log.getStackTraceString(e2));
                                    i = -1;
                                }
                                if (i > i3) {
                                    str5 = str6;
                                    i3 = i;
                                }
                            }
                        }
                        if (i3 != -1) {
                            f43Var.d = i3;
                            f43Var.e = true;
                            file = new File(file3, str5);
                            f43Var.c = file.getAbsolutePath();
                        }
                    }
                    return f43Var;
                }
            }
            if (file == null) {
                return f43Var;
            }
            File file4 = new File(file, str2);
            if (!n(file4)) {
                return f43Var;
            }
            f43Var.f = true;
            f43Var.c = file4.getAbsolutePath();
            return f43Var;
        }
        return (f43) invokeL.objValue;
    }

    @Override // com.baidu.tieba.k43
    public w02 j(String str, g43 g43Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048580, this, str, g43Var)) == null) {
            if (g43Var == null) {
                return new w02(201, "pay args is null");
            }
            SwanAppActivity w = v83.K().w();
            if (w == null) {
                return new w02(1001, "runtime exception, try reopen this app");
            }
            f82 X = w.X();
            if (X == null) {
                return new w02(1001, "runtime exception, page manager breakdown");
            }
            o43.b("jump to fun page");
            v83.M().post(new a(this, str, g43Var, X));
            return new w02(0);
        }
        return (w02) invokeLL.objValue;
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
