package com.baidu.tieba;

import android.text.TextUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.swan.game.guide.GameGuideConfigInfo;
import com.baidu.swan.games.view.recommend.model.RecommendItemModel;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
/* loaded from: classes5.dex */
public class n74 {
    public static /* synthetic */ Interceptable $ic;
    public static final String b = null;
    public transient /* synthetic */ FieldHolder $fh;
    public List<String> a;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(1947955358, "Lcom/baidu/tieba/n74;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(1947955358, "Lcom/baidu/tieba/n74;");
        }
    }

    public final String g(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048582, this, i)) == null) {
            if (i != 1) {
                if (i != 2) {
                    if (i != 3) {
                        return null;
                    }
                    return "popview";
                }
                return "list";
            }
            return "carousel";
        }
        return (String) invokeI.objValue;
    }

    public n74() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.a = new ArrayList();
    }

    public final String a(String str, String str2, String str3) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048576, this, str, str2, str3)) == null) {
            return String.format("%s_%s:%s", str, str2, str3);
        }
        return (String) invokeLLL.objValue;
    }

    public void b(int i, String str, String str2, String str3) {
        String O;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Integer.valueOf(i), str, str2, str3}) == null) {
            String g = g(i);
            if (e43.M() == null) {
                O = null;
            } else {
                O = e43.M().O();
            }
            gb3 gb3Var = new gb3();
            gb3Var.b = "click";
            gb3Var.g = g;
            gb3Var.e = str;
            if (str2 != null) {
                gb3Var.a("target_appkey", str2);
            }
            gb3Var.a("current_appkey", O);
            if (!TextUtils.isEmpty(str3)) {
                gb3Var.a("location", str3);
            }
            xa3.g(gb3Var);
        }
    }

    public void c(int i, t74 t74Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(Constants.METHOD_SEND_USER_MSG, this, i, t74Var) == null) {
            String g = g(i);
            JSONArray f = f(t74Var);
            gb3 gb3Var = new gb3();
            gb3Var.b = "show";
            gb3Var.g = g;
            if (f != null) {
                gb3Var.a(GameGuideConfigInfo.KEY_GAME_LIST, f);
            }
            xa3.g(gb3Var);
        }
    }

    public void e(int i, t74 t74Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048580, this, i, t74Var) == null) {
            String g = g(i);
            JSONArray f = f(t74Var);
            gb3 gb3Var = new gb3();
            gb3Var.b = "show";
            gb3Var.g = g;
            if (f != null) {
                gb3Var.a(GameGuideConfigInfo.KEY_GAME_LIST, f);
            }
            xa3.g(gb3Var);
            this.a.clear();
        }
    }

    public void d(int i, String str, String str2) {
        String O;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeILL(1048579, this, i, str, str2) == null) {
            String g = g(i);
            String a = a(g, str, str2);
            if (this.a.contains(a)) {
                return;
            }
            if (e43.M() == null) {
                O = null;
            } else {
                O = e43.M().O();
            }
            gb3 gb3Var = new gb3();
            gb3Var.b = "click";
            gb3Var.g = g;
            gb3Var.e = str;
            if (str2 != null) {
                gb3Var.a("target_appkey", str2);
            }
            gb3Var.a("current_appkey", O);
            xa3.g(gb3Var);
            this.a.add(a);
        }
    }

    public final JSONArray f(t74 t74Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, t74Var)) == null) {
            if (t74Var != null && t74Var.b != null) {
                JSONArray jSONArray = new JSONArray();
                for (RecommendItemModel recommendItemModel : t74Var.b) {
                    jSONArray.put(recommendItemModel.appKey);
                }
                return jSONArray;
            }
            return null;
        }
        return (JSONArray) invokeL.objValue;
    }
}
