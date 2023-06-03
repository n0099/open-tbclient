package com.baidu.tieba;

import android.content.Context;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobstat.Config;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class k40 implements g40 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public m40 a;
    public r40 b;
    public l40 c;
    public JSONObject d;
    public Context e;

    public k40(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = new j40();
        this.b = new v40();
        this.c = new i40();
        if (this.d == null) {
            c(context);
        }
    }

    @Override // com.baidu.tieba.g40
    public JSONObject a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            if (this.d == null) {
                c(this.e);
            }
            return this.d;
        }
        return (JSONObject) invokeV.objValue;
    }

    public final JSONObject b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("ver", 2);
            } catch (Exception e) {
                e.printStackTrace();
            }
            try {
                jSONObject.put("aid", this.a.a(this.e));
            } catch (Exception e2) {
                e2.printStackTrace();
            }
            try {
                jSONObject.put("uid", this.c.a(this.e));
            } catch (Exception e3) {
                e3.printStackTrace();
            }
            try {
                jSONObject.put("adrid", this.b.c(this.e));
            } catch (Exception e4) {
                e4.printStackTrace();
            }
            try {
                jSONObject.put("network", this.b.d(this.e));
            } catch (Exception e5) {
                e5.printStackTrace();
            }
            try {
                jSONObject.put("pkg", this.b.b(this.e));
            } catch (Exception e6) {
                e6.printStackTrace();
            }
            try {
                jSONObject.put("ctime", this.b.b());
            } catch (Exception e7) {
                e7.printStackTrace();
            }
            try {
                jSONObject.put("ua", this.b.a(this.e));
            } catch (Exception e8) {
                e8.printStackTrace();
            }
            try {
                jSONObject.put("ut", this.b.a());
            } catch (Exception e9) {
                e9.printStackTrace();
            }
            try {
                jSONObject.put("iid", this.a.e(this.e));
            } catch (Exception e10) {
                e10.printStackTrace();
            }
            try {
                jSONObject.put(Config.SID, this.a.b(this.e));
            } catch (Exception e11) {
                e11.printStackTrace();
            }
            try {
                jSONObject.put("oid", this.a.c(this.e));
            } catch (Exception e12) {
                e12.printStackTrace();
            }
            try {
                jSONObject.put(Config.GAID, this.a.d(this.e));
            } catch (Exception e13) {
                e13.printStackTrace();
            }
            try {
                jSONObject.put("cver", this.a.a());
            } catch (Exception e14) {
                e14.printStackTrace();
            }
            try {
                jSONObject.put("sappinfos", this.a.f(this.e).toString());
            } catch (Exception e15) {
                e15.printStackTrace();
            }
            try {
                jSONObject.put("cstoreext", this.a.g(this.e).toString());
            } catch (Exception e16) {
                e16.printStackTrace();
            }
            return jSONObject;
        }
        return (JSONObject) invokeV.objValue;
    }

    public final void c(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, context) == null) {
            if (context == null) {
                throw new NullPointerException("ctx should not be null");
            }
            if (this.e == null) {
                this.e = context.getApplicationContext();
            }
            this.d = b();
        }
    }
}
