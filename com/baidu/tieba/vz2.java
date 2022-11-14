package com.baidu.tieba;

import android.text.TextUtils;
import android.util.Log;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.swan.apps.SwanAppActivity;
import com.baidu.tieba.bn2;
import com.baidu.tieba.o32;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.tencent.open.miniapp.MiniApp;
import java.io.File;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class vz2 extends tz2 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @Override // com.baidu.tieba.tz2
    public String g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return null;
        }
        return (String) invokeV.objValue;
    }

    @Override // com.baidu.tieba.tz2
    public String h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return null;
        }
        return (String) invokeV.objValue;
    }

    @Override // com.baidu.tieba.tz2
    public boolean k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return true;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tieba.tz2
    public fw1 m(pz2 pz2Var, r52<qz2> r52Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048582, this, pz2Var, r52Var)) == null) {
            return null;
        }
        return (fw1) invokeLL.objValue;
    }

    /* loaded from: classes6.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;
        public final /* synthetic */ pz2 b;
        public final /* synthetic */ o32 c;

        public a(vz2 vz2Var, String str, pz2 pz2Var, o32 o32Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {vz2Var, str, pz2Var, o32Var};
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
            this.b = pz2Var;
            this.c = o32Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                fu2 fu2Var = new fu2();
                fu2Var.c = this.a;
                fu2Var.b = qz2.a(this.b);
                o32.b i = this.c.i("navigateTo");
                i.n(o32.g, o32.i);
                i.k("pluginFunPage", fu2Var).a();
            }
        }
    }

    public vz2() {
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

    @Override // com.baidu.tieba.tz2
    public fw1 b(JSONObject jSONObject) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, jSONObject)) == null) {
            if (jSONObject == null) {
                return new fw1(201, "args params is null");
            }
            if (jSONObject.optLong("fee") < 0) {
                return new fw1(201, "fee can't smaller than 0");
            }
            if (jSONObject.optJSONObject("paymentArgs") == null) {
                return new fw1(201, "paymentArgs can't be null");
            }
            return null;
        }
        return (fw1) invokeL.objValue;
    }

    @Override // com.baidu.tieba.tz2
    public oz2 f(pz2 pz2Var) {
        InterceptResult invokeL;
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, pz2Var)) == null) {
            File file = null;
            if (pz2Var == null) {
                return null;
            }
            String str = pz2Var.a;
            String str2 = pz2Var.c;
            if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
                return null;
            }
            oz2 oz2Var = new oz2();
            oz2Var.a = str;
            oz2Var.b = str2;
            if (w12.d()) {
                file = bn2.f.e();
            } else if (e03.H()) {
                file = bn2.b.e();
            } else if (e03.D()) {
                file = m12.d();
            } else {
                if (TextUtils.equals(pz2Var.d, MiniApp.MINIAPP_VERSION_DEVELOP)) {
                    String a2 = hw1.a(str);
                    File g = bn2.g();
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
                                    xz2.b(Log.getStackTraceString(e));
                                }
                            }
                        }
                        if (i2 > -1) {
                            oz2Var.a = str3 + i2;
                            oz2Var.e = true;
                            File file2 = new File(g, oz2Var.a + File.separator + i2);
                            oz2Var.c = file2.getAbsolutePath();
                            oz2Var.d = i2;
                            file = file2;
                        } else {
                            oz2Var.e = false;
                            oz2Var.c = null;
                        }
                    } else {
                        return oz2Var;
                    }
                } else {
                    File file3 = new File(bn2.g(), str);
                    if (!file3.exists()) {
                        return oz2Var;
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
                                    xz2.b(Log.getStackTraceString(e2));
                                    i = -1;
                                }
                                if (i > i3) {
                                    str5 = str6;
                                    i3 = i;
                                }
                            }
                        }
                        if (i3 != -1) {
                            oz2Var.d = i3;
                            oz2Var.e = true;
                            file = new File(file3, str5);
                            oz2Var.c = file.getAbsolutePath();
                        }
                    }
                    return oz2Var;
                }
            }
            if (file == null) {
                return oz2Var;
            }
            File file4 = new File(file, str2);
            if (!n(file4)) {
                return oz2Var;
            }
            oz2Var.f = true;
            oz2Var.c = file4.getAbsolutePath();
            return oz2Var;
        }
        return (oz2) invokeL.objValue;
    }

    @Override // com.baidu.tieba.tz2
    public fw1 j(String str, pz2 pz2Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048580, this, str, pz2Var)) == null) {
            if (pz2Var == null) {
                return new fw1(201, "pay args is null");
            }
            SwanAppActivity w = e43.K().w();
            if (w == null) {
                return new fw1(1001, "runtime exception, try reopen this app");
            }
            o32 X = w.X();
            if (X == null) {
                return new fw1(1001, "runtime exception, page manager breakdown");
            }
            xz2.b("jump to fun page");
            e43.M().post(new a(this, str, pz2Var, X));
            return new fw1(0);
        }
        return (fw1) invokeLL.objValue;
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
