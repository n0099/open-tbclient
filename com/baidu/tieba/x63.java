package com.baidu.tieba;

import android.text.TextUtils;
import android.util.Log;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.swan.apps.SwanAppActivity;
import com.baidu.tieba.du2;
import com.baidu.tieba.qa2;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.tencent.open.miniapp.MiniApp;
import java.io.File;
import org.json.JSONObject;
/* loaded from: classes8.dex */
public class x63 extends v63 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @Override // com.baidu.tieba.v63
    public String g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return null;
        }
        return (String) invokeV.objValue;
    }

    @Override // com.baidu.tieba.v63
    public String h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return null;
        }
        return (String) invokeV.objValue;
    }

    @Override // com.baidu.tieba.v63
    public boolean k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return true;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tieba.v63
    public h32 m(r63 r63Var, tc2<s63> tc2Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048582, this, r63Var, tc2Var)) == null) {
            return null;
        }
        return (h32) invokeLL.objValue;
    }

    /* loaded from: classes8.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;
        public final /* synthetic */ r63 b;
        public final /* synthetic */ qa2 c;

        public a(x63 x63Var, String str, r63 r63Var, qa2 qa2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {x63Var, str, r63Var, qa2Var};
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
            this.b = r63Var;
            this.c = qa2Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                h13 h13Var = new h13();
                h13Var.c = this.a;
                h13Var.b = s63.a(this.b);
                qa2.b i = this.c.i("navigateTo");
                i.n(qa2.g, qa2.i);
                i.k("pluginFunPage", h13Var).a();
            }
        }
    }

    public x63() {
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

    @Override // com.baidu.tieba.v63
    public h32 b(JSONObject jSONObject) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, jSONObject)) == null) {
            if (jSONObject == null) {
                return new h32(201, "args params is null");
            }
            if (jSONObject.optLong("fee") < 0) {
                return new h32(201, "fee can't smaller than 0");
            }
            if (jSONObject.optJSONObject("paymentArgs") == null) {
                return new h32(201, "paymentArgs can't be null");
            }
            return null;
        }
        return (h32) invokeL.objValue;
    }

    @Override // com.baidu.tieba.v63
    public q63 f(r63 r63Var) {
        InterceptResult invokeL;
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, r63Var)) == null) {
            File file = null;
            if (r63Var == null) {
                return null;
            }
            String str = r63Var.a;
            String str2 = r63Var.c;
            if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
                return null;
            }
            q63 q63Var = new q63();
            q63Var.a = str;
            q63Var.b = str2;
            if (y82.d()) {
                file = du2.f.e();
            } else if (g73.H()) {
                file = du2.b.e();
            } else if (g73.D()) {
                file = o82.d();
            } else {
                if (TextUtils.equals(r63Var.d, MiniApp.MINIAPP_VERSION_DEVELOP)) {
                    String a2 = j32.a(str);
                    File g = du2.g();
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
                                    z63.b(Log.getStackTraceString(e));
                                }
                            }
                        }
                        if (i2 > -1) {
                            q63Var.a = str3 + i2;
                            q63Var.e = true;
                            File file2 = new File(g, q63Var.a + File.separator + i2);
                            q63Var.c = file2.getAbsolutePath();
                            q63Var.d = i2;
                            file = file2;
                        } else {
                            q63Var.e = false;
                            q63Var.c = null;
                        }
                    } else {
                        return q63Var;
                    }
                } else {
                    File file3 = new File(du2.g(), str);
                    if (!file3.exists()) {
                        return q63Var;
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
                                    z63.b(Log.getStackTraceString(e2));
                                    i = -1;
                                }
                                if (i > i3) {
                                    str5 = str6;
                                    i3 = i;
                                }
                            }
                        }
                        if (i3 != -1) {
                            q63Var.d = i3;
                            q63Var.e = true;
                            file = new File(file3, str5);
                            q63Var.c = file.getAbsolutePath();
                        }
                    }
                    return q63Var;
                }
            }
            if (file == null) {
                return q63Var;
            }
            File file4 = new File(file, str2);
            if (!n(file4)) {
                return q63Var;
            }
            q63Var.f = true;
            q63Var.c = file4.getAbsolutePath();
            return q63Var;
        }
        return (q63) invokeL.objValue;
    }

    @Override // com.baidu.tieba.v63
    public h32 j(String str, r63 r63Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048580, this, str, r63Var)) == null) {
            if (r63Var == null) {
                return new h32(201, "pay args is null");
            }
            SwanAppActivity w = gb3.K().w();
            if (w == null) {
                return new h32(1001, "runtime exception, try reopen this app");
            }
            qa2 Y = w.Y();
            if (Y == null) {
                return new h32(1001, "runtime exception, page manager breakdown");
            }
            z63.b("jump to fun page");
            gb3.M().post(new a(this, str, r63Var, Y));
            return new h32(0);
        }
        return (h32) invokeLL.objValue;
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
