package com.baidu.tieba;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.p30;
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
public class r30 implements u30 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public r30() {
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

    @Override // com.baidu.tieba.u30
    public String a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? t20.b().a() : (String) invokeV.objValue;
    }

    @Override // com.baidu.tieba.u30
    public String a(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context)) == null) {
            p30 p30Var = new p30();
            s20.e(context).j(p30Var);
            if (p30Var.b(10000)) {
                p30.b c = p30Var.c();
                if (c != null && !TextUtils.isEmpty((CharSequence) c.a)) {
                    return (String) c.a;
                }
            } else {
                p30Var.a();
            }
            return null;
        }
        return (String) invokeL.objValue;
    }

    @Override // com.baidu.tieba.u30
    public String b(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, context)) == null) ? s20.e(context.getApplicationContext()).d() : (String) invokeL.objValue;
    }

    @Override // com.baidu.tieba.u30
    public String c(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, context)) == null) ? s20.e(context.getApplicationContext()).b() : (String) invokeL.objValue;
    }

    @Override // com.baidu.tieba.u30
    public JSONArray d(Context context) {
        InterceptResult invokeL;
        T t;
        s20.e eVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, context)) == null) {
            p30 p30Var = new p30();
            s20.e(context).n(p30Var);
            boolean b = p30Var.b(10000);
            JSONArray jSONArray = new JSONArray();
            if (b) {
                p30.b c = p30Var.c();
                if (c != null && (t = c.a) != 0 && (eVar = (s20.e) t) != null && eVar.b() != null) {
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
                p30Var.a();
            }
            return jSONArray;
        }
        return (JSONArray) invokeL.objValue;
    }

    @Override // com.baidu.tieba.u30
    public String e(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, context)) == null) {
            p30 p30Var = new p30();
            s20.e(context).l(p30Var);
            if (p30Var.b(10000)) {
                p30.b c = p30Var.c();
                if (c != null && !TextUtils.isEmpty((CharSequence) c.a)) {
                    return (String) c.a;
                }
            } else {
                p30Var.a();
            }
            return null;
        }
        return (String) invokeL.objValue;
    }

    @Override // com.baidu.tieba.u30
    public JSONArray f(Context context) {
        InterceptResult invokeL;
        T t;
        List<k50> list;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, context)) == null) {
            p30 p30Var = new p30();
            t20.b().e(context, p30Var);
            boolean b = p30Var.b(10000);
            JSONArray jSONArray = new JSONArray();
            if (b) {
                p30.b c = p30Var.c();
                if (c != null && (t = c.a) != 0 && (list = (List) t) != null && list.size() > 0) {
                    for (k50 k50Var : list) {
                        JSONObject jSONObject = new JSONObject();
                        try {
                            jSONObject.put("pkg", k50Var.a);
                            jSONObject.put("sigs", Arrays.toString(k50Var.b));
                            jSONObject.put("vc", k50Var.c);
                            jSONObject.put("va", k50Var.d);
                            jSONObject.put("installts", k50Var.e);
                            jSONObject.put("lstupdatets", k50Var.f);
                            jSONArray.put(jSONObject);
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                }
            } else {
                p30Var.a();
            }
            return jSONArray;
        }
        return (JSONArray) invokeL.objValue;
    }

    @Override // com.baidu.tieba.u30
    public JSONObject g(Context context) {
        InterceptResult invokeL;
        T t;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, context)) == null) {
            p30 p30Var = new p30();
            t20.b().c(context, p30Var);
            boolean b = p30Var.b(10000);
            JSONObject jSONObject = new JSONObject();
            if (b) {
                p30.b c = p30Var.c();
                if (c != null && (t = c.a) != 0) {
                    j50 j50Var = (j50) t;
                }
            } else {
                p30Var.a();
            }
            return jSONObject;
        }
        return (JSONObject) invokeL.objValue;
    }
}
