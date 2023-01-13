package com.baidu.tieba;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.s30;
import com.baidu.tieba.u20;
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
public class u30 implements x30 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public u30() {
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

    @Override // com.baidu.tieba.x30
    public String a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? v20.b().a() : (String) invokeV.objValue;
    }

    @Override // com.baidu.tieba.x30
    public String a(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context)) == null) ? u20.f(context.getApplicationContext()).c() : (String) invokeL.objValue;
    }

    @Override // com.baidu.tieba.x30
    public JSONArray b(Context context) {
        InterceptResult invokeL;
        T t;
        u20.f fVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, context)) == null) {
            s30 s30Var = new s30();
            u20.f(context).q(s30Var);
            boolean b = s30Var.b(10000);
            JSONArray jSONArray = new JSONArray();
            if (b) {
                s30.b a = s30Var.a();
                if (a != null && (t = a.a) != 0 && (fVar = (u20.f) t) != null && fVar.b() != null) {
                    for (u20.g gVar : fVar.b()) {
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
                s30Var.c();
            }
            return jSONArray;
        }
        return (JSONArray) invokeL.objValue;
    }

    @Override // com.baidu.tieba.x30
    public String c(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, context)) == null) {
            s30 s30Var = new s30();
            u20.f(context).m(s30Var);
            if (!s30Var.b(10000)) {
                s30Var.c();
                return null;
            }
            s30.b a = s30Var.a();
            if (a == null || TextUtils.isEmpty((CharSequence) a.a)) {
                return null;
            }
            return (String) a.a;
        }
        return (String) invokeL.objValue;
    }

    @Override // com.baidu.tieba.x30
    public String d(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, context)) == null) {
            s30 s30Var = new s30();
            u20.f(context).o(s30Var);
            if (!s30Var.b(10000)) {
                s30Var.c();
                return null;
            }
            s30.b a = s30Var.a();
            if (a == null || TextUtils.isEmpty((CharSequence) a.a)) {
                return null;
            }
            return (String) a.a;
        }
        return (String) invokeL.objValue;
    }

    @Override // com.baidu.tieba.x30
    public JSONArray e(Context context) {
        InterceptResult invokeL;
        T t;
        List<o50> list;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, context)) == null) {
            s30 s30Var = new s30();
            v20.b().e(context, s30Var);
            boolean b = s30Var.b(10000);
            JSONArray jSONArray = new JSONArray();
            if (b) {
                s30.b a = s30Var.a();
                if (a != null && (t = a.a) != 0 && (list = (List) t) != null && list.size() > 0) {
                    for (o50 o50Var : list) {
                        JSONObject jSONObject = new JSONObject();
                        try {
                            jSONObject.put("pkg", o50Var.a);
                            jSONObject.put("sigs", Arrays.toString(o50Var.b));
                            jSONObject.put("vc", o50Var.c);
                            jSONObject.put("va", o50Var.d);
                            jSONObject.put("installts", o50Var.e);
                            jSONObject.put("lstupdatets", o50Var.f);
                            jSONArray.put(jSONObject);
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                }
            } else {
                s30Var.c();
            }
            return jSONArray;
        }
        return (JSONArray) invokeL.objValue;
    }

    @Override // com.baidu.tieba.x30
    public JSONObject f(Context context) {
        InterceptResult invokeL;
        T t;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, context)) == null) {
            s30 s30Var = new s30();
            v20.b().c(context, s30Var);
            boolean b = s30Var.b(10000);
            JSONObject jSONObject = new JSONObject();
            if (b) {
                s30.b a = s30Var.a();
                if (a != null && (t = a.a) != 0) {
                    n50 n50Var = (n50) t;
                }
            } else {
                s30Var.c();
            }
            return jSONObject;
        }
        return (JSONObject) invokeL.objValue;
    }

    @Override // com.baidu.tieba.x30
    public String g(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, context)) == null) ? u20.f(context.getApplicationContext()).e() : (String) invokeL.objValue;
    }
}
