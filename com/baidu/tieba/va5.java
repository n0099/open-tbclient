package com.baidu.tieba;

import android.app.Activity;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
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
/* loaded from: classes6.dex */
public class va5 implements ua5 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public long a;
    public long b;
    public Map<String, sa5> c;
    public boolean d;

    /* loaded from: classes6.dex */
    public static class a {
        public static /* synthetic */ Interceptable $ic;
        public static final va5 a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-352810174, "Lcom/baidu/tieba/va5$a;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-352810174, "Lcom/baidu/tieba/va5$a;");
                    return;
                }
            }
            a = new va5();
        }
    }

    public va5() {
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

    public static final va5 d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            return a.a;
        }
        return (va5) invokeV.objValue;
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

    @Override // com.baidu.tieba.ua5
    public void a() {
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            Iterator<Map.Entry<String, sa5>> it = this.c.entrySet().iterator();
            while (true) {
                if (it.hasNext()) {
                    Map.Entry<String, sa5> next = it.next();
                    if (next.getValue() != null && !next.getValue().v()) {
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

    public sa5 c(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) {
            return this.c.get(str);
        }
        return (sa5) invokeL.objValue;
    }

    public ta5 g() {
        InterceptResult invokeV;
        ta5 r;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            sa5 c = d().c("style");
            if (c != null && (r = c.r()) != null && StringUtils.isNotNull(r.b()) && StringUtils.isNotNull(r.c()) && StringUtils.isNotNull(r.a())) {
                return r;
            }
            return null;
        }
        return (ta5) invokeV.objValue;
    }

    public void h() {
        BdUniqueId bdUniqueId;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            Activity currentActivity = TbadkCoreApplication.getInst().getCurrentActivity();
            if (currentActivity instanceof BaseActivity) {
                bdUniqueId = ((BaseActivity) currentActivity).getUniqueId();
            } else if (currentActivity instanceof BaseFragmentActivity) {
                bdUniqueId = ((BaseFragmentActivity) currentActivity).getUniqueId();
            } else {
                bdUniqueId = null;
            }
            for (Map.Entry<String, sa5> entry : this.c.entrySet()) {
                if (entry.getValue() != null) {
                    entry.getValue().A(bdUniqueId);
                    entry.getValue().z(this);
                    entry.getValue().x();
                }
            }
        }
    }

    public void i(JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, jSONObject) == null) {
            this.a = jSONObject.optLong("start_time");
            this.b = jSONObject.optLong("end_time");
            JSONObject optJSONObject = jSONObject.optJSONObject("feed");
            if (optJSONObject != null) {
                sa5 sa5Var = new sa5();
                sa5Var.y(optJSONObject);
                this.c.put("homePage", sa5Var);
            }
            JSONObject optJSONObject2 = jSONObject.optJSONObject("forum");
            if (optJSONObject2 != null) {
                sa5 sa5Var2 = new sa5();
                sa5Var2.y(optJSONObject2);
                this.c.put("enterForum", sa5Var2);
            }
            JSONObject optJSONObject3 = jSONObject.optJSONObject("channel");
            if (optJSONObject3 != null) {
                sa5 sa5Var3 = new sa5();
                sa5Var3.y(optJSONObject3);
                this.c.put("channel", sa5Var3);
            }
            JSONObject optJSONObject4 = jSONObject.optJSONObject("news");
            if (optJSONObject4 != null) {
                sa5 sa5Var4 = new sa5();
                sa5Var4.y(optJSONObject4);
                this.c.put("message", sa5Var4);
            }
            JSONObject optJSONObject5 = jSONObject.optJSONObject("personal");
            if (optJSONObject5 != null) {
                sa5 sa5Var5 = new sa5();
                sa5Var5.y(optJSONObject5);
                this.c.put("person", sa5Var5);
            }
            JSONObject optJSONObject6 = jSONObject.optJSONObject(AlbumActivityConfig.FROM_WRITE);
            if (optJSONObject6 != null) {
                sa5 sa5Var6 = new sa5();
                sa5Var6.y(optJSONObject6);
                this.c.put(AlbumActivityConfig.FROM_WRITE, sa5Var6);
            }
            JSONObject optJSONObject7 = jSONObject.optJSONObject("style");
            if (optJSONObject7 != null) {
                sa5 sa5Var7 = new sa5();
                sa5Var7.y(optJSONObject7);
                this.c.put("style", sa5Var7);
            }
        }
    }
}
