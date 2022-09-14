package com.baidu.tieba;

import android.text.TextUtils;
import android.util.Log;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.swan.apps.SwanAppActivity;
import com.baidu.tieba.h22;
import com.baidu.tieba.ul2;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.tencent.open.miniapp.MiniApp;
import java.io.File;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class oy2 extends my2 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes5.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;
        public final /* synthetic */ iy2 b;
        public final /* synthetic */ h22 c;

        public a(oy2 oy2Var, String str, iy2 iy2Var, h22 h22Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {oy2Var, str, iy2Var, h22Var};
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
            this.b = iy2Var;
            this.c = h22Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                ys2 ys2Var = new ys2();
                ys2Var.c = this.a;
                ys2Var.b = jy2.a(this.b);
                h22.b i = this.c.i("navigateTo");
                i.n(h22.g, h22.i);
                i.k("pluginFunPage", ys2Var).a();
            }
        }
    }

    public oy2() {
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

    @Override // com.baidu.tieba.my2
    public yu1 b(JSONObject jSONObject) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, jSONObject)) == null) {
            if (jSONObject == null) {
                return new yu1(201, "args params is null");
            }
            if (jSONObject.optLong("fee") < 0) {
                return new yu1(201, "fee can't smaller than 0");
            }
            if (jSONObject.optJSONObject("paymentArgs") == null) {
                return new yu1(201, "paymentArgs can't be null");
            }
            return null;
        }
        return (yu1) invokeL.objValue;
    }

    @Override // com.baidu.tieba.my2
    public hy2 f(iy2 iy2Var) {
        InterceptResult invokeL;
        String[] list;
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, iy2Var)) == null) {
            File file = null;
            if (iy2Var == null) {
                return null;
            }
            String str = iy2Var.a;
            String str2 = iy2Var.c;
            if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
                return null;
            }
            hy2 hy2Var = new hy2();
            hy2Var.a = str;
            hy2Var.b = str2;
            if (p02.d()) {
                file = ul2.f.e();
            } else if (xy2.H()) {
                file = ul2.b.e();
            } else if (xy2.D()) {
                file = f02.d();
            } else {
                if (TextUtils.equals(iy2Var.d, MiniApp.MINIAPP_VERSION_DEVELOP)) {
                    String a2 = av1.a(str);
                    File g = ul2.g();
                    String[] list2 = g.list();
                    if (list2 == null || g.length() == 0) {
                        return hy2Var;
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
                                qy2.b(Log.getStackTraceString(e));
                            }
                        }
                    }
                    if (i2 > -1) {
                        hy2Var.a = str3 + i2;
                        hy2Var.e = true;
                        File file2 = new File(g, hy2Var.a + File.separator + i2);
                        hy2Var.c = file2.getAbsolutePath();
                        hy2Var.d = i2;
                        file = file2;
                    } else {
                        hy2Var.e = false;
                        hy2Var.c = null;
                    }
                } else {
                    File file3 = new File(ul2.g(), str);
                    if (file3.exists() && (list = file3.list()) != null && list.length != 0) {
                        String str5 = null;
                        int i3 = -1;
                        for (String str6 : list) {
                            if (!TextUtils.isEmpty(str6)) {
                                try {
                                    i = Integer.parseInt(str6);
                                } catch (NumberFormatException e2) {
                                    qy2.b(Log.getStackTraceString(e2));
                                    i = -1;
                                }
                                if (i > i3) {
                                    str5 = str6;
                                    i3 = i;
                                }
                            }
                        }
                        if (i3 != -1) {
                            hy2Var.d = i3;
                            hy2Var.e = true;
                            file = new File(file3, str5);
                            hy2Var.c = file.getAbsolutePath();
                        }
                    }
                    return hy2Var;
                }
            }
            if (file == null) {
                return hy2Var;
            }
            File file4 = new File(file, str2);
            if (n(file4)) {
                hy2Var.f = true;
                hy2Var.c = file4.getAbsolutePath();
                return hy2Var;
            }
            return hy2Var;
        }
        return (hy2) invokeL.objValue;
    }

    @Override // com.baidu.tieba.my2
    public String g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return null;
        }
        return (String) invokeV.objValue;
    }

    @Override // com.baidu.tieba.my2
    public String h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return null;
        }
        return (String) invokeV.objValue;
    }

    @Override // com.baidu.tieba.my2
    public yu1 j(String str, iy2 iy2Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048580, this, str, iy2Var)) == null) {
            if (iy2Var == null) {
                return new yu1(201, "pay args is null");
            }
            SwanAppActivity w = x23.K().w();
            if (w == null) {
                return new yu1(1001, "runtime exception, try reopen this app");
            }
            h22 X = w.X();
            if (X == null) {
                return new yu1(1001, "runtime exception, page manager breakdown");
            }
            qy2.b("jump to fun page");
            x23.M().post(new a(this, str, iy2Var, X));
            return new yu1(0);
        }
        return (yu1) invokeLL.objValue;
    }

    @Override // com.baidu.tieba.my2
    public boolean k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return true;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tieba.my2
    public yu1 m(iy2 iy2Var, k42<jy2> k42Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048582, this, iy2Var, k42Var)) == null) {
            return null;
        }
        return (yu1) invokeLL.objValue;
    }

    public final boolean n(File file) {
        InterceptResult invokeL;
        String[] list;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, file)) == null) ? file != null && file.exists() && file.isDirectory() && (list = file.list()) != null && list.length > 0 : invokeL.booleanValue;
    }
}
