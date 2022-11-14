package com.baidu.tieba;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.n30;
import com.baidu.tieba.p20;
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
/* loaded from: classes5.dex */
public class p30 implements s30 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public p30() {
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

    @Override // com.baidu.tieba.s30
    public String a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? q20.b().a() : (String) invokeV.objValue;
    }

    @Override // com.baidu.tieba.s30
    public String a(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context)) == null) ? p20.f(context.getApplicationContext()).c() : (String) invokeL.objValue;
    }

    @Override // com.baidu.tieba.s30
    public JSONArray b(Context context) {
        InterceptResult invokeL;
        T t;
        p20.f fVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, context)) == null) {
            n30 n30Var = new n30();
            p20.f(context).q(n30Var);
            boolean b = n30Var.b(10000);
            JSONArray jSONArray = new JSONArray();
            if (b) {
                n30.b a = n30Var.a();
                if (a != null && (t = a.a) != 0 && (fVar = (p20.f) t) != null && fVar.b() != null) {
                    for (p20.g gVar : fVar.b()) {
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
                n30Var.c();
            }
            return jSONArray;
        }
        return (JSONArray) invokeL.objValue;
    }

    @Override // com.baidu.tieba.s30
    public String c(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, context)) == null) {
            n30 n30Var = new n30();
            p20.f(context).m(n30Var);
            if (!n30Var.b(10000)) {
                n30Var.c();
                return null;
            }
            n30.b a = n30Var.a();
            if (a == null || TextUtils.isEmpty((CharSequence) a.a)) {
                return null;
            }
            return (String) a.a;
        }
        return (String) invokeL.objValue;
    }

    @Override // com.baidu.tieba.s30
    public String d(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, context)) == null) {
            n30 n30Var = new n30();
            p20.f(context).o(n30Var);
            if (!n30Var.b(10000)) {
                n30Var.c();
                return null;
            }
            n30.b a = n30Var.a();
            if (a == null || TextUtils.isEmpty((CharSequence) a.a)) {
                return null;
            }
            return (String) a.a;
        }
        return (String) invokeL.objValue;
    }

    @Override // com.baidu.tieba.s30
    public JSONArray e(Context context) {
        InterceptResult invokeL;
        T t;
        List<j50> list;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, context)) == null) {
            n30 n30Var = new n30();
            q20.b().e(context, n30Var);
            boolean b = n30Var.b(10000);
            JSONArray jSONArray = new JSONArray();
            if (b) {
                n30.b a = n30Var.a();
                if (a != null && (t = a.a) != 0 && (list = (List) t) != null && list.size() > 0) {
                    for (j50 j50Var : list) {
                        JSONObject jSONObject = new JSONObject();
                        try {
                            jSONObject.put("pkg", j50Var.a);
                            jSONObject.put("sigs", Arrays.toString(j50Var.b));
                            jSONObject.put("vc", j50Var.c);
                            jSONObject.put("va", j50Var.d);
                            jSONObject.put("installts", j50Var.e);
                            jSONObject.put("lstupdatets", j50Var.f);
                            jSONArray.put(jSONObject);
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                }
            } else {
                n30Var.c();
            }
            return jSONArray;
        }
        return (JSONArray) invokeL.objValue;
    }

    @Override // com.baidu.tieba.s30
    public JSONObject f(Context context) {
        InterceptResult invokeL;
        T t;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, context)) == null) {
            n30 n30Var = new n30();
            q20.b().c(context, n30Var);
            boolean b = n30Var.b(10000);
            JSONObject jSONObject = new JSONObject();
            if (b) {
                n30.b a = n30Var.a();
                if (a != null && (t = a.a) != 0) {
                    i50 i50Var = (i50) t;
                }
            } else {
                n30Var.c();
            }
            return jSONObject;
        }
        return (JSONObject) invokeL.objValue;
    }

    @Override // com.baidu.tieba.s30
    public String g(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, context)) == null) ? p20.f(context.getApplicationContext()).e() : (String) invokeL.objValue;
    }
}
