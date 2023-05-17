package com.baidu.tieba;

import android.text.TextUtils;
import android.util.Log;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.swan.apps.SwanAppActivity;
import com.baidu.tieba.cs2;
import com.baidu.tieba.p82;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.tencent.open.miniapp.MiniApp;
import java.io.File;
import org.json.JSONObject;
/* loaded from: classes8.dex */
public class w43 extends u43 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @Override // com.baidu.tieba.u43
    public String g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return null;
        }
        return (String) invokeV.objValue;
    }

    @Override // com.baidu.tieba.u43
    public String h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return null;
        }
        return (String) invokeV.objValue;
    }

    @Override // com.baidu.tieba.u43
    public boolean k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return true;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tieba.u43
    public g12 m(q43 q43Var, sa2<r43> sa2Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048582, this, q43Var, sa2Var)) == null) {
            return null;
        }
        return (g12) invokeLL.objValue;
    }

    /* loaded from: classes8.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;
        public final /* synthetic */ q43 b;
        public final /* synthetic */ p82 c;

        public a(w43 w43Var, String str, q43 q43Var, p82 p82Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {w43Var, str, q43Var, p82Var};
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
            this.b = q43Var;
            this.c = p82Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                gz2 gz2Var = new gz2();
                gz2Var.c = this.a;
                gz2Var.b = r43.a(this.b);
                p82.b i = this.c.i("navigateTo");
                i.n(p82.g, p82.i);
                i.k("pluginFunPage", gz2Var).a();
            }
        }
    }

    public w43() {
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

    @Override // com.baidu.tieba.u43
    public g12 b(JSONObject jSONObject) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, jSONObject)) == null) {
            if (jSONObject == null) {
                return new g12(201, "args params is null");
            }
            if (jSONObject.optLong("fee") < 0) {
                return new g12(201, "fee can't smaller than 0");
            }
            if (jSONObject.optJSONObject("paymentArgs") == null) {
                return new g12(201, "paymentArgs can't be null");
            }
            return null;
        }
        return (g12) invokeL.objValue;
    }

    @Override // com.baidu.tieba.u43
    public p43 f(q43 q43Var) {
        InterceptResult invokeL;
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, q43Var)) == null) {
            File file = null;
            if (q43Var == null) {
                return null;
            }
            String str = q43Var.a;
            String str2 = q43Var.c;
            if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
                return null;
            }
            p43 p43Var = new p43();
            p43Var.a = str;
            p43Var.b = str2;
            if (x62.d()) {
                file = cs2.f.e();
            } else if (f53.H()) {
                file = cs2.b.e();
            } else if (f53.D()) {
                file = n62.d();
            } else {
                if (TextUtils.equals(q43Var.d, MiniApp.MINIAPP_VERSION_DEVELOP)) {
                    String a2 = i12.a(str);
                    File g = cs2.g();
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
                                    y43.b(Log.getStackTraceString(e));
                                }
                            }
                        }
                        if (i2 > -1) {
                            p43Var.a = str3 + i2;
                            p43Var.e = true;
                            File file2 = new File(g, p43Var.a + File.separator + i2);
                            p43Var.c = file2.getAbsolutePath();
                            p43Var.d = i2;
                            file = file2;
                        } else {
                            p43Var.e = false;
                            p43Var.c = null;
                        }
                    } else {
                        return p43Var;
                    }
                } else {
                    File file3 = new File(cs2.g(), str);
                    if (!file3.exists()) {
                        return p43Var;
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
                                    y43.b(Log.getStackTraceString(e2));
                                    i = -1;
                                }
                                if (i > i3) {
                                    str5 = str6;
                                    i3 = i;
                                }
                            }
                        }
                        if (i3 != -1) {
                            p43Var.d = i3;
                            p43Var.e = true;
                            file = new File(file3, str5);
                            p43Var.c = file.getAbsolutePath();
                        }
                    }
                    return p43Var;
                }
            }
            if (file == null) {
                return p43Var;
            }
            File file4 = new File(file, str2);
            if (!n(file4)) {
                return p43Var;
            }
            p43Var.f = true;
            p43Var.c = file4.getAbsolutePath();
            return p43Var;
        }
        return (p43) invokeL.objValue;
    }

    @Override // com.baidu.tieba.u43
    public g12 j(String str, q43 q43Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048580, this, str, q43Var)) == null) {
            if (q43Var == null) {
                return new g12(201, "pay args is null");
            }
            SwanAppActivity w = f93.K().w();
            if (w == null) {
                return new g12(1001, "runtime exception, try reopen this app");
            }
            p82 Z = w.Z();
            if (Z == null) {
                return new g12(1001, "runtime exception, page manager breakdown");
            }
            y43.b("jump to fun page");
            f93.M().post(new a(this, str, q43Var, Z));
            return new g12(0);
        }
        return (g12) invokeLL.objValue;
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
