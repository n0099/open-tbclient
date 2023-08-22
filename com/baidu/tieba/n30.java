package com.baidu.tieba;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.l30;
import com.baidu.tieba.n20;
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
/* loaded from: classes7.dex */
public class n30 implements q30 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public n30() {
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

    @Override // com.baidu.tieba.q30
    public String a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? o20.b().a() : (String) invokeV.objValue;
    }

    @Override // com.baidu.tieba.q30
    public String a(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context)) == null) ? n20.f(context.getApplicationContext()).c() : (String) invokeL.objValue;
    }

    @Override // com.baidu.tieba.q30
    public JSONArray b(Context context) {
        InterceptResult invokeL;
        T t;
        n20.f fVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, context)) == null) {
            l30 l30Var = new l30();
            n20.f(context).q(l30Var);
            boolean b = l30Var.b(10000);
            JSONArray jSONArray = new JSONArray();
            if (b) {
                l30.b a = l30Var.a();
                if (a != null && (t = a.a) != 0 && (fVar = (n20.f) t) != null && fVar.b() != null) {
                    for (n20.g gVar : fVar.b()) {
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
                l30Var.c();
            }
            return jSONArray;
        }
        return (JSONArray) invokeL.objValue;
    }

    @Override // com.baidu.tieba.q30
    public String c(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, context)) == null) {
            l30 l30Var = new l30();
            n20.f(context).o(l30Var);
            if (!l30Var.b(10000)) {
                l30Var.c();
                return null;
            }
            l30.b a = l30Var.a();
            if (a == null || TextUtils.isEmpty((CharSequence) a.a)) {
                return null;
            }
            return (String) a.a;
        }
        return (String) invokeL.objValue;
    }

    @Override // com.baidu.tieba.q30
    public String d(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, context)) == null) {
            l30 l30Var = new l30();
            n20.f(context).m(l30Var);
            if (!l30Var.b(10000)) {
                l30Var.c();
                return null;
            }
            l30.b a = l30Var.a();
            if (a == null || TextUtils.isEmpty((CharSequence) a.a)) {
                return null;
            }
            return (String) a.a;
        }
        return (String) invokeL.objValue;
    }

    @Override // com.baidu.tieba.q30
    public String e(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, context)) == null) ? n20.f(context.getApplicationContext()).e() : (String) invokeL.objValue;
    }

    @Override // com.baidu.tieba.q30
    public JSONArray f(Context context) {
        InterceptResult invokeL;
        T t;
        List<g50> list;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, context)) == null) {
            l30 l30Var = new l30();
            o20.b().e(context, l30Var);
            boolean b = l30Var.b(10000);
            JSONArray jSONArray = new JSONArray();
            if (b) {
                l30.b a = l30Var.a();
                if (a != null && (t = a.a) != 0 && (list = (List) t) != null && list.size() > 0) {
                    for (g50 g50Var : list) {
                        JSONObject jSONObject = new JSONObject();
                        try {
                            jSONObject.put("pkg", g50Var.a);
                            jSONObject.put("sigs", Arrays.toString(g50Var.b));
                            jSONObject.put("vc", g50Var.c);
                            jSONObject.put("va", g50Var.d);
                            jSONObject.put("installts", g50Var.e);
                            jSONObject.put("lstupdatets", g50Var.f);
                            jSONArray.put(jSONObject);
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                }
            } else {
                l30Var.c();
            }
            return jSONArray;
        }
        return (JSONArray) invokeL.objValue;
    }

    @Override // com.baidu.tieba.q30
    public JSONObject g(Context context) {
        InterceptResult invokeL;
        T t;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, context)) == null) {
            l30 l30Var = new l30();
            o20.b().c(context, l30Var);
            boolean b = l30Var.b(10000);
            JSONObject jSONObject = new JSONObject();
            if (b) {
                l30.b a = l30Var.a();
                if (a != null && (t = a.a) != 0) {
                    f50 f50Var = (f50) t;
                }
            } else {
                l30Var.c();
            }
            return jSONObject;
        }
        return (JSONObject) invokeL.objValue;
    }
}
