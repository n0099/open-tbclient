package com.baidu.tieba;

import android.text.TextUtils;
import android.util.Log;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.swan.apps.SwanAppActivity;
import com.baidu.tieba.lb2;
import com.baidu.tieba.yu2;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.tencent.open.miniapp.MiniApp;
import java.io.File;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class s73 extends q73 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @Override // com.baidu.tieba.q73
    public String g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return null;
        }
        return (String) invokeV.objValue;
    }

    @Override // com.baidu.tieba.q73
    public String h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return null;
        }
        return (String) invokeV.objValue;
    }

    @Override // com.baidu.tieba.q73
    public boolean k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return true;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tieba.q73
    public c42 m(m73 m73Var, od2<n73> od2Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048582, this, m73Var, od2Var)) == null) {
            return null;
        }
        return (c42) invokeLL.objValue;
    }

    /* loaded from: classes7.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;
        public final /* synthetic */ m73 b;
        public final /* synthetic */ lb2 c;

        public a(s73 s73Var, String str, m73 m73Var, lb2 lb2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {s73Var, str, m73Var, lb2Var};
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
            this.b = m73Var;
            this.c = lb2Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                c23 c23Var = new c23();
                c23Var.c = this.a;
                c23Var.b = n73.a(this.b);
                lb2.b i = this.c.i("navigateTo");
                i.n(lb2.g, lb2.i);
                i.k("pluginFunPage", c23Var).a();
            }
        }
    }

    public s73() {
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

    @Override // com.baidu.tieba.q73
    public c42 b(JSONObject jSONObject) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, jSONObject)) == null) {
            if (jSONObject == null) {
                return new c42(201, "args params is null");
            }
            if (jSONObject.optLong("fee") < 0) {
                return new c42(201, "fee can't smaller than 0");
            }
            if (jSONObject.optJSONObject("paymentArgs") == null) {
                return new c42(201, "paymentArgs can't be null");
            }
            return null;
        }
        return (c42) invokeL.objValue;
    }

    @Override // com.baidu.tieba.q73
    public l73 f(m73 m73Var) {
        InterceptResult invokeL;
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, m73Var)) == null) {
            File file = null;
            if (m73Var == null) {
                return null;
            }
            String str = m73Var.a;
            String str2 = m73Var.c;
            if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
                return null;
            }
            l73 l73Var = new l73();
            l73Var.a = str;
            l73Var.b = str2;
            if (t92.d()) {
                file = yu2.f.e();
            } else if (b83.H()) {
                file = yu2.b.e();
            } else if (b83.D()) {
                file = j92.d();
            } else {
                if (TextUtils.equals(m73Var.d, MiniApp.MINIAPP_VERSION_DEVELOP)) {
                    String a2 = e42.a(str);
                    File g = yu2.g();
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
                                    u73.b(Log.getStackTraceString(e));
                                }
                            }
                        }
                        if (i2 > -1) {
                            l73Var.a = str3 + i2;
                            l73Var.e = true;
                            File file2 = new File(g, l73Var.a + File.separator + i2);
                            l73Var.c = file2.getAbsolutePath();
                            l73Var.d = i2;
                            file = file2;
                        } else {
                            l73Var.e = false;
                            l73Var.c = null;
                        }
                    } else {
                        return l73Var;
                    }
                } else {
                    File file3 = new File(yu2.g(), str);
                    if (!file3.exists()) {
                        return l73Var;
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
                                    u73.b(Log.getStackTraceString(e2));
                                    i = -1;
                                }
                                if (i > i3) {
                                    str5 = str6;
                                    i3 = i;
                                }
                            }
                        }
                        if (i3 != -1) {
                            l73Var.d = i3;
                            l73Var.e = true;
                            file = new File(file3, str5);
                            l73Var.c = file.getAbsolutePath();
                        }
                    }
                    return l73Var;
                }
            }
            if (file == null) {
                return l73Var;
            }
            File file4 = new File(file, str2);
            if (!n(file4)) {
                return l73Var;
            }
            l73Var.f = true;
            l73Var.c = file4.getAbsolutePath();
            return l73Var;
        }
        return (l73) invokeL.objValue;
    }

    @Override // com.baidu.tieba.q73
    public c42 j(String str, m73 m73Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048580, this, str, m73Var)) == null) {
            if (m73Var == null) {
                return new c42(201, "pay args is null");
            }
            SwanAppActivity w = bc3.K().w();
            if (w == null) {
                return new c42(1001, "runtime exception, try reopen this app");
            }
            lb2 Y = w.Y();
            if (Y == null) {
                return new c42(1001, "runtime exception, page manager breakdown");
            }
            u73.b("jump to fun page");
            bc3.M().post(new a(this, str, m73Var, Y));
            return new c42(0);
        }
        return (c42) invokeLL.objValue;
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
