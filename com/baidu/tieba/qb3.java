package com.baidu.tieba;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.http.request.HttpRequest;
import com.baidu.swan.apps.statistic.interfacestability.SwanInterfaceType;
import com.baidu.swan.game.guide.GameGuideConfigInfo;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class qb3 extends rb3<JSONObject> {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean r;
    public transient /* synthetic */ FieldHolder $fh;
    public final Activity m;
    public final String n;
    public final String o;
    public boolean p;
    public int q;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948086023, "Lcom/baidu/tieba/qb3;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948086023, "Lcom/baidu/tieba/qb3;");
                return;
            }
        }
        r = rm1.a;
    }

    @Override // com.baidu.tieba.rb3
    public SwanInterfaceType A() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return SwanInterfaceType.OPEN_DATA;
        }
        return (SwanInterfaceType) invokeV.objValue;
    }

    @Override // com.baidu.tieba.rb3
    public boolean F() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            if (cb3.b() && !R()) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tieba.rb3
    public void L() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.q++;
        }
    }

    public boolean R() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            if (this.q >= B()) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tieba.db3
    public boolean k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            w("data", Q().toString());
            return true;
        }
        return invokeV.booleanValue;
    }

    public qb3(Activity activity, String str, String str2, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {activity, str, str2, Boolean.valueOf(z)};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.m = activity;
        this.n = str;
        this.o = str2;
        this.p = z;
    }

    public JSONObject Q() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            JSONObject jSONObject = new JSONObject();
            try {
                g63 N = N();
                jSONObject.put("ma_id", N.P());
                jSONObject.put("scope", this.n);
                jSONObject.put("host_pkgname", AppRuntime.getApplication().getPackageName());
                jSONObject.put("host_key_hash", eb3.g());
                jSONObject.put(GameGuideConfigInfo.KEY_APP_KEY, N.P());
                if (N.Z() != null && N.Z().U() != null) {
                    jSONObject.put("scene", N.Z().U());
                }
                if (this.p) {
                    jSONObject.put("action_type", "1");
                }
                String l = np2.o().l();
                if (!TextUtils.isEmpty(l)) {
                    jSONObject.put("host_api_key", l);
                }
                if (!TextUtils.isEmpty(this.o)) {
                    jSONObject.put("provider_appkey", this.o);
                }
            } catch (JSONException e) {
                if (r) {
                    e.printStackTrace();
                }
            }
            return jSONObject;
        }
        return (JSONObject) invokeV.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.db3
    @SuppressLint({"BDThrowableCheck"})
    /* renamed from: S */
    public JSONObject n(JSONObject jSONObject) throws JSONException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, jSONObject)) == null) {
            JSONObject c = eb3.c(jSONObject);
            int optInt = c.optInt("errno", 10001);
            if (optInt != 0) {
                if (11001 == optInt) {
                    eb3.m(c);
                    eb3.t("MaOpenDataRequest", c.toString());
                }
                if (r) {
                    throw new JSONException("Illegal errno=" + optInt + " errms=" + c.optString("errms"));
                }
            }
            return c;
        }
        return (JSONObject) invokeL.objValue;
    }

    @Override // com.baidu.tieba.rb3
    public HttpRequest x(rb3 rb3Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, rb3Var)) == null) {
            return np2.o().u(this.m, rb3Var.C());
        }
        return (HttpRequest) invokeL.objValue;
    }
}
