package com.baidu.tieba;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.s20;
import com.baidu.tieba.u10;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Arrays;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class u20 implements x20 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public u20() {
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

    @Override // com.baidu.tieba.x20
    public String a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? v10.b().a() : (String) invokeV.objValue;
    }

    @Override // com.baidu.tieba.x20
    public String a(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context)) == null) ? u10.f(context.getApplicationContext()).c() : (String) invokeL.objValue;
    }

    @Override // com.baidu.tieba.x20
    public JSONArray b(Context context) {
        InterceptResult invokeL;
        T t;
        u10.f fVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, context)) == null) {
            s20 s20Var = new s20();
            u10.f(context).q(s20Var);
            boolean b = s20Var.b(10000);
            JSONArray jSONArray = new JSONArray();
            if (b) {
                s20.b a = s20Var.a();
                if (a != null && (t = a.a) != 0 && (fVar = (u10.f) t) != null && fVar.b() != null) {
                    for (u10.g gVar : fVar.b()) {
                        JSONObject jSONObject = new JSONObject();
                        try {
                            jSONObject.put("aid", gVar.b);
                            jSONObject.put("pkg", gVar.a);
                            jSONObject.put("priority", gVar.c);
                            jSONArray.put(jSONObject);
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                }
            } else {
                s20Var.c();
            }
            return jSONArray;
        }
        return (JSONArray) invokeL.objValue;
    }

    @Override // com.baidu.tieba.x20
    public String c(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, context)) == null) {
            s20 s20Var = new s20();
            u10.f(context).o(s20Var);
            if (!s20Var.b(10000)) {
                s20Var.c();
                return null;
            }
            s20.b a = s20Var.a();
            if (a == null || TextUtils.isEmpty((CharSequence) a.a)) {
                return null;
            }
            return (String) a.a;
        }
        return (String) invokeL.objValue;
    }

    @Override // com.baidu.tieba.x20
    public String d(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, context)) == null) {
            s20 s20Var = new s20();
            u10.f(context).m(s20Var);
            if (!s20Var.b(10000)) {
                s20Var.c();
                return null;
            }
            s20.b a = s20Var.a();
            if (a == null || TextUtils.isEmpty((CharSequence) a.a)) {
                return null;
            }
            return (String) a.a;
        }
        return (String) invokeL.objValue;
    }

    @Override // com.baidu.tieba.x20
    public String e(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, context)) == null) ? u10.f(context.getApplicationContext()).e() : (String) invokeL.objValue;
    }

    @Override // com.baidu.tieba.x20
    public JSONArray f(Context context) {
        InterceptResult invokeL;
        T t;
        List<o40> list;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, context)) == null) {
            s20 s20Var = new s20();
            v10.b().e(context, s20Var);
            boolean b = s20Var.b(10000);
            JSONArray jSONArray = new JSONArray();
            if (b) {
                s20.b a = s20Var.a();
                if (a != null && (t = a.a) != 0 && (list = (List) t) != null && list.size() > 0) {
                    for (o40 o40Var : list) {
                        JSONObject jSONObject = new JSONObject();
                        try {
                            jSONObject.put("pkg", o40Var.a);
                            jSONObject.put("sigs", Arrays.toString(o40Var.b));
                            jSONObject.put("vc", o40Var.c);
                            jSONObject.put("va", o40Var.d);
                            jSONObject.put("installts", o40Var.e);
                            jSONObject.put("lstupdatets", o40Var.f);
                            jSONArray.put(jSONObject);
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                }
            } else {
                s20Var.c();
            }
            return jSONArray;
        }
        return (JSONArray) invokeL.objValue;
    }

    @Override // com.baidu.tieba.x20
    public JSONObject g(Context context) {
        InterceptResult invokeL;
        T t;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, context)) == null) {
            s20 s20Var = new s20();
            v10.b().c(context, s20Var);
            boolean b = s20Var.b(10000);
            JSONObject jSONObject = new JSONObject();
            if (b) {
                s20.b a = s20Var.a();
                if (a != null && (t = a.a) != 0) {
                    n40 n40Var = (n40) t;
                }
            } else {
                s20Var.c();
            }
            return jSONObject;
        }
        return (JSONObject) invokeL.objValue;
    }
}
