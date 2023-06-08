package com.baidu.tieba;

import android.app.Activity;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.toolbar.CommonToolbarStatisticConstants;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class jn5 implements in5 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public long a;
    public long b;
    public ConcurrentHashMap<String, gn5> c;
    public int d;
    public boolean e;

    /* loaded from: classes6.dex */
    public static class a {
        public static /* synthetic */ Interceptable $ic;
        public static final jn5 a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-684354213, "Lcom/baidu/tieba/jn5$a;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-684354213, "Lcom/baidu/tieba/jn5$a;");
                    return;
                }
            }
            a = new jn5();
        }
    }

    public jn5() {
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
        this.c = new ConcurrentHashMap<>();
    }

    public static final jn5 f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            return a.a;
        }
        return (jn5) invokeV.objValue;
    }

    public boolean b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            long currentTimeMillis = System.currentTimeMillis() / 1000;
            if (this.e && currentTimeMillis > h() && currentTimeMillis < g()) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public boolean c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            if (z21.c(this.c) || this.d != this.c.hashCode()) {
                return false;
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    public Map<String, gn5> e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return this.c;
        }
        return (Map) invokeV.objValue;
    }

    public long g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return this.b;
        }
        return invokeV.longValue;
    }

    public long h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            return this.a;
        }
        return invokeV.longValue;
    }

    public void l() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            this.c.clear();
            this.d = 0;
            this.a = 0L;
            this.b = 0L;
            this.e = false;
        }
    }

    @Override // com.baidu.tieba.in5
    public void a() {
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            Iterator<Map.Entry<String, gn5>> it = this.c.entrySet().iterator();
            while (true) {
                if (it.hasNext()) {
                    Map.Entry<String, gn5> next = it.next();
                    if (next.getValue() != null && !next.getValue().v()) {
                        z = false;
                        break;
                    }
                } else {
                    z = true;
                    break;
                }
            }
            this.e = z;
            if (z) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921551, Boolean.TRUE));
            }
        }
    }

    public gn5 d(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, str)) == null) {
            return this.c.get(str);
        }
        return (gn5) invokeL.objValue;
    }

    public void m(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048587, this, i) == null) {
            this.d = i;
        }
    }

    public hn5 i() {
        InterceptResult invokeV;
        hn5 r;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            gn5 d = f().d("style");
            if (d != null && (r = d.r()) != null && StringUtils.isNotNull(r.b()) && StringUtils.isNotNull(r.c()) && StringUtils.isNotNull(r.a())) {
                return r;
            }
            return null;
        }
        return (hn5) invokeV.objValue;
    }

    public void j() {
        BdUniqueId bdUniqueId;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            Activity currentActivity = TbadkCoreApplication.getInst().getCurrentActivity();
            if (currentActivity instanceof BaseActivity) {
                bdUniqueId = ((BaseActivity) currentActivity).getUniqueId();
            } else if (currentActivity instanceof BaseFragmentActivity) {
                bdUniqueId = ((BaseFragmentActivity) currentActivity).getUniqueId();
            } else {
                bdUniqueId = null;
            }
            for (Map.Entry<String, gn5> entry : this.c.entrySet()) {
                if (entry.getValue() != null) {
                    entry.getValue().A(bdUniqueId);
                    entry.getValue().z(this);
                    entry.getValue().x();
                }
            }
        }
    }

    public void k(JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, jSONObject) == null) {
            this.c.clear();
            this.a = jSONObject.optLong("start_time");
            this.b = jSONObject.optLong("end_time");
            JSONObject optJSONObject = jSONObject.optJSONObject("feed");
            if (optJSONObject != null) {
                gn5 gn5Var = new gn5();
                gn5Var.y(optJSONObject);
                this.c.put("homePage", gn5Var);
            }
            JSONObject optJSONObject2 = jSONObject.optJSONObject("forum");
            if (optJSONObject2 != null) {
                gn5 gn5Var2 = new gn5();
                gn5Var2.y(optJSONObject2);
                this.c.put("enterForum", gn5Var2);
            }
            JSONObject optJSONObject3 = jSONObject.optJSONObject("channel");
            if (optJSONObject3 != null) {
                gn5 gn5Var3 = new gn5();
                gn5Var3.y(optJSONObject3);
                this.c.put("channel", gn5Var3);
            }
            JSONObject optJSONObject4 = jSONObject.optJSONObject(CommonToolbarStatisticConstants.TOOLBAR_MENU_NEW_DETAIL_BROWSER);
            if (optJSONObject4 != null) {
                gn5 gn5Var4 = new gn5();
                gn5Var4.y(optJSONObject4);
                this.c.put("message", gn5Var4);
            }
            JSONObject optJSONObject5 = jSONObject.optJSONObject("personal");
            if (optJSONObject5 != null) {
                gn5 gn5Var5 = new gn5();
                gn5Var5.y(optJSONObject5);
                this.c.put("person", gn5Var5);
            }
            JSONObject optJSONObject6 = jSONObject.optJSONObject("write");
            if (optJSONObject6 != null) {
                gn5 gn5Var6 = new gn5();
                gn5Var6.y(optJSONObject6);
                this.c.put("write", gn5Var6);
            }
            JSONObject optJSONObject7 = jSONObject.optJSONObject("style");
            if (optJSONObject7 != null) {
                gn5 gn5Var7 = new gn5();
                gn5Var7.y(optJSONObject7);
                this.c.put("style", gn5Var7);
            }
        }
    }
}
