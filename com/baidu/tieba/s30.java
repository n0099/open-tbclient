package com.baidu.tieba;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.q30;
import com.baidu.tieba.s20;
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
public class s30 implements v30 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public s30() {
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

    @Override // com.baidu.tieba.v30
    public String a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? t20.b().a() : (String) invokeV.objValue;
    }

    @Override // com.baidu.tieba.v30
    public String a(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context)) == null) ? s20.e(context.getApplicationContext()).b() : (String) invokeL.objValue;
    }

    @Override // com.baidu.tieba.v30
    public JSONArray b(Context context) {
        InterceptResult invokeL;
        T t;
        s20.e eVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, context)) == null) {
            q30 q30Var = new q30();
            s20.e(context).n(q30Var);
            boolean b = q30Var.b(10000);
            JSONArray jSONArray = new JSONArray();
            if (b) {
                q30.b a = q30Var.a();
                if (a != null && (t = a.a) != 0 && (eVar = (s20.e) t) != null && eVar.b() != null) {
                    for (s20.f fVar : eVar.b()) {
                        JSONObject jSONObject = new JSONObject();
                        try {
                            jSONObject.put("aid", fVar.b);
                            jSONObject.put("pkg", fVar.a);
                            jSONObject.put("priority", fVar.c);
                            jSONArray.put(jSONObject);
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                }
            } else {
                q30Var.c();
            }
            return jSONArray;
        }
        return (JSONArray) invokeL.objValue;
    }

    @Override // com.baidu.tieba.v30
    public String c(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, context)) == null) {
            q30 q30Var = new q30();
            s20.e(context).j(q30Var);
            if (!q30Var.b(10000)) {
                q30Var.c();
                return null;
            }
            q30.b a = q30Var.a();
            if (a == null || TextUtils.isEmpty((CharSequence) a.a)) {
                return null;
            }
            return (String) a.a;
        }
        return (String) invokeL.objValue;
    }

    @Override // com.baidu.tieba.v30
    public String d(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, context)) == null) {
            q30 q30Var = new q30();
            s20.e(context).l(q30Var);
            if (!q30Var.b(10000)) {
                q30Var.c();
                return null;
            }
            q30.b a = q30Var.a();
            if (a == null || TextUtils.isEmpty((CharSequence) a.a)) {
                return null;
            }
            return (String) a.a;
        }
        return (String) invokeL.objValue;
    }

    @Override // com.baidu.tieba.v30
    public JSONArray e(Context context) {
        InterceptResult invokeL;
        T t;
        List<m50> list;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, context)) == null) {
            q30 q30Var = new q30();
            t20.b().e(context, q30Var);
            boolean b = q30Var.b(10000);
            JSONArray jSONArray = new JSONArray();
            if (b) {
                q30.b a = q30Var.a();
                if (a != null && (t = a.a) != 0 && (list = (List) t) != null && list.size() > 0) {
                    for (m50 m50Var : list) {
                        JSONObject jSONObject = new JSONObject();
                        try {
                            jSONObject.put("pkg", m50Var.a);
                            jSONObject.put("sigs", Arrays.toString(m50Var.b));
                            jSONObject.put("vc", m50Var.c);
                            jSONObject.put("va", m50Var.d);
                            jSONObject.put("installts", m50Var.e);
                            jSONObject.put("lstupdatets", m50Var.f);
                            jSONArray.put(jSONObject);
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                }
            } else {
                q30Var.c();
            }
            return jSONArray;
        }
        return (JSONArray) invokeL.objValue;
    }

    @Override // com.baidu.tieba.v30
    public JSONObject f(Context context) {
        InterceptResult invokeL;
        T t;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, context)) == null) {
            q30 q30Var = new q30();
            t20.b().c(context, q30Var);
            boolean b = q30Var.b(10000);
            JSONObject jSONObject = new JSONObject();
            if (b) {
                q30.b a = q30Var.a();
                if (a != null && (t = a.a) != 0) {
                    l50 l50Var = (l50) t;
                }
            } else {
                q30Var.c();
            }
            return jSONObject;
        }
        return (JSONObject) invokeL.objValue;
    }

    @Override // com.baidu.tieba.v30
    public String g(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, context)) == null) ? s20.e(context.getApplicationContext()).d() : (String) invokeL.objValue;
    }
}
