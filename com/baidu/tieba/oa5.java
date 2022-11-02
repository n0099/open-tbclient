package com.baidu.tieba;

import android.app.Activity;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.AlbumActivityConfig;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class oa5 implements na5 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public long a;
    public long b;
    public Map<String, ma5> c;
    public boolean d;

    /* loaded from: classes5.dex */
    public static class a {
        public static /* synthetic */ Interceptable $ic;
        public static final oa5 a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-553214231, "Lcom/baidu/tieba/oa5$a;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-553214231, "Lcom/baidu/tieba/oa5$a;");
                    return;
                }
            }
            a = new oa5();
        }
    }

    public oa5() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.c = new HashMap();
    }

    public static final oa5 d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            return a.a;
        }
        return (oa5) invokeV.objValue;
    }

    public boolean b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            long currentTimeMillis = System.currentTimeMillis() / 1000;
            if (this.d && currentTimeMillis > f() && currentTimeMillis < e()) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public long e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return this.b;
        }
        return invokeV.longValue;
    }

    public long f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return this.a;
        }
        return invokeV.longValue;
    }

    @Override // com.baidu.tieba.na5
    public void a() {
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            Iterator<Map.Entry<String, ma5>> it = this.c.entrySet().iterator();
            while (true) {
                if (it.hasNext()) {
                    Map.Entry<String, ma5> next = it.next();
                    if (next.getValue() != null && !next.getValue().m()) {
                        z = false;
                        break;
                    }
                } else {
                    z = true;
                    break;
                }
            }
            this.d = z;
            if (z) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921551, Boolean.TRUE));
            }
        }
    }

    public ma5 c(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) {
            return this.c.get(str);
        }
        return (ma5) invokeL.objValue;
    }

    public void g() {
        BdUniqueId bdUniqueId;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            Activity currentActivity = TbadkCoreApplication.getInst().getCurrentActivity();
            if (currentActivity instanceof BaseActivity) {
                bdUniqueId = ((BaseActivity) currentActivity).getUniqueId();
            } else if (currentActivity instanceof BaseFragmentActivity) {
                bdUniqueId = ((BaseFragmentActivity) currentActivity).getUniqueId();
            } else {
                bdUniqueId = null;
            }
            for (Map.Entry<String, ma5> entry : this.c.entrySet()) {
                if (entry.getValue() != null) {
                    entry.getValue().q(bdUniqueId);
                    entry.getValue().p(this);
                    entry.getValue().n();
                }
            }
        }
    }

    public void h(JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, jSONObject) == null) {
            this.a = jSONObject.optLong("start_time");
            this.b = jSONObject.optLong("end_time");
            JSONObject optJSONObject = jSONObject.optJSONObject("feed");
            if (optJSONObject != null) {
                ma5 ma5Var = new ma5();
                ma5Var.o(optJSONObject);
                this.c.put("homePage", ma5Var);
            }
            JSONObject optJSONObject2 = jSONObject.optJSONObject("forum");
            if (optJSONObject2 != null) {
                ma5 ma5Var2 = new ma5();
                ma5Var2.o(optJSONObject2);
                this.c.put("enterForum", ma5Var2);
            }
            JSONObject optJSONObject3 = jSONObject.optJSONObject("channel");
            if (optJSONObject3 != null) {
                ma5 ma5Var3 = new ma5();
                ma5Var3.o(optJSONObject3);
                this.c.put("channel", ma5Var3);
            }
            JSONObject optJSONObject4 = jSONObject.optJSONObject("news");
            if (optJSONObject4 != null) {
                ma5 ma5Var4 = new ma5();
                ma5Var4.o(optJSONObject4);
                this.c.put("message", ma5Var4);
            }
            JSONObject optJSONObject5 = jSONObject.optJSONObject("personal");
            if (optJSONObject5 != null) {
                ma5 ma5Var5 = new ma5();
                ma5Var5.o(optJSONObject5);
                this.c.put("person", ma5Var5);
            }
            JSONObject optJSONObject6 = jSONObject.optJSONObject(AlbumActivityConfig.FROM_WRITE);
            if (optJSONObject6 != null) {
                ma5 ma5Var6 = new ma5();
                ma5Var6.o(optJSONObject6);
                this.c.put(AlbumActivityConfig.FROM_WRITE, ma5Var6);
            }
        }
    }
}
