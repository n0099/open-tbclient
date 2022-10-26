package com.baidu.tieba;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.r30;
import com.baidu.tieba.t20;
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
public class t30 implements w30 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public t30() {
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

    @Override // com.baidu.tieba.w30
    public String a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? u20.b().a() : (String) invokeV.objValue;
    }

    @Override // com.baidu.tieba.w30
    public String a(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context)) == null) ? t20.f(context.getApplicationContext()).c() : (String) invokeL.objValue;
    }

    @Override // com.baidu.tieba.w30
    public JSONArray b(Context context) {
        InterceptResult invokeL;
        Object obj;
        t20.f fVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, context)) == null) {
            r30 r30Var = new r30();
            t20.f(context).q(r30Var);
            boolean b = r30Var.b(10000);
            JSONArray jSONArray = new JSONArray();
            if (b) {
                r30.b a = r30Var.a();
                if (a != null && (obj = a.a) != null && (fVar = (t20.f) obj) != null && fVar.b() != null) {
                    for (t20.g gVar : fVar.b()) {
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
                r30Var.c();
            }
            return jSONArray;
        }
        return (JSONArray) invokeL.objValue;
    }

    @Override // com.baidu.tieba.w30
    public String c(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, context)) == null) {
            r30 r30Var = new r30();
            t20.f(context).m(r30Var);
            if (!r30Var.b(10000)) {
                r30Var.c();
                return null;
            }
            r30.b a = r30Var.a();
            if (a == null || TextUtils.isEmpty((CharSequence) a.a)) {
                return null;
            }
            return (String) a.a;
        }
        return (String) invokeL.objValue;
    }

    @Override // com.baidu.tieba.w30
    public String d(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, context)) == null) {
            r30 r30Var = new r30();
            t20.f(context).o(r30Var);
            if (!r30Var.b(10000)) {
                r30Var.c();
                return null;
            }
            r30.b a = r30Var.a();
            if (a == null || TextUtils.isEmpty((CharSequence) a.a)) {
                return null;
            }
            return (String) a.a;
        }
        return (String) invokeL.objValue;
    }

    @Override // com.baidu.tieba.w30
    public JSONArray e(Context context) {
        InterceptResult invokeL;
        Object obj;
        List<n50> list;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, context)) == null) {
            r30 r30Var = new r30();
            u20.b().e(context, r30Var);
            boolean b = r30Var.b(10000);
            JSONArray jSONArray = new JSONArray();
            if (b) {
                r30.b a = r30Var.a();
                if (a != null && (obj = a.a) != null && (list = (List) obj) != null && list.size() > 0) {
                    for (n50 n50Var : list) {
                        JSONObject jSONObject = new JSONObject();
                        try {
                            jSONObject.put("pkg", n50Var.a);
                            jSONObject.put("sigs", Arrays.toString(n50Var.b));
                            jSONObject.put("vc", n50Var.c);
                            jSONObject.put("va", n50Var.d);
                            jSONObject.put("installts", n50Var.e);
                            jSONObject.put("lstupdatets", n50Var.f);
                            jSONArray.put(jSONObject);
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                }
            } else {
                r30Var.c();
            }
            return jSONArray;
        }
        return (JSONArray) invokeL.objValue;
    }

    @Override // com.baidu.tieba.w30
    public JSONObject f(Context context) {
        InterceptResult invokeL;
        Object obj;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, context)) == null) {
            r30 r30Var = new r30();
            u20.b().c(context, r30Var);
            boolean b = r30Var.b(10000);
            JSONObject jSONObject = new JSONObject();
            if (b) {
                r30.b a = r30Var.a();
                if (a != null && (obj = a.a) != null) {
                    m50 m50Var = (m50) obj;
                }
            } else {
                r30Var.c();
            }
            return jSONObject;
        }
        return (JSONObject) invokeL.objValue;
    }

    @Override // com.baidu.tieba.w30
    public String g(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, context)) == null) ? t20.f(context.getApplicationContext()).e() : (String) invokeL.objValue;
    }
}
