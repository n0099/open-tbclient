package com.baidu.tieba;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.n20;
import com.baidu.tieba.q10;
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
public class p20 implements s20 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public p20() {
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

    @Override // com.baidu.tieba.s20
    public String a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? r10.b().a() : (String) invokeV.objValue;
    }

    @Override // com.baidu.tieba.s20
    public String a(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context)) == null) {
            n20 n20Var = new n20();
            q10.e(context).j(n20Var);
            if (n20Var.b(10000)) {
                n20.b c = n20Var.c();
                if (c != null && !TextUtils.isEmpty((CharSequence) c.a)) {
                    return (String) c.a;
                }
            } else {
                n20Var.a();
            }
            return null;
        }
        return (String) invokeL.objValue;
    }

    @Override // com.baidu.tieba.s20
    public String b(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, context)) == null) ? q10.e(context.getApplicationContext()).d() : (String) invokeL.objValue;
    }

    @Override // com.baidu.tieba.s20
    public String c(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, context)) == null) ? q10.e(context.getApplicationContext()).b() : (String) invokeL.objValue;
    }

    @Override // com.baidu.tieba.s20
    public JSONArray d(Context context) {
        InterceptResult invokeL;
        T t;
        q10.e eVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, context)) == null) {
            n20 n20Var = new n20();
            q10.e(context).n(n20Var);
            boolean b = n20Var.b(10000);
            JSONArray jSONArray = new JSONArray();
            if (b) {
                n20.b c = n20Var.c();
                if (c != null && (t = c.a) != 0 && (eVar = (q10.e) t) != null && eVar.b() != null) {
                    for (q10.f fVar : eVar.b()) {
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
                n20Var.a();
            }
            return jSONArray;
        }
        return (JSONArray) invokeL.objValue;
    }

    @Override // com.baidu.tieba.s20
    public String e(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, context)) == null) {
            n20 n20Var = new n20();
            q10.e(context).l(n20Var);
            if (n20Var.b(10000)) {
                n20.b c = n20Var.c();
                if (c != null && !TextUtils.isEmpty((CharSequence) c.a)) {
                    return (String) c.a;
                }
            } else {
                n20Var.a();
            }
            return null;
        }
        return (String) invokeL.objValue;
    }

    @Override // com.baidu.tieba.s20
    public JSONArray f(Context context) {
        InterceptResult invokeL;
        T t;
        List<i40> list;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, context)) == null) {
            n20 n20Var = new n20();
            r10.b().e(context, n20Var);
            boolean b = n20Var.b(10000);
            JSONArray jSONArray = new JSONArray();
            if (b) {
                n20.b c = n20Var.c();
                if (c != null && (t = c.a) != 0 && (list = (List) t) != null && list.size() > 0) {
                    for (i40 i40Var : list) {
                        JSONObject jSONObject = new JSONObject();
                        try {
                            jSONObject.put("pkg", i40Var.a);
                            jSONObject.put("sigs", Arrays.toString(i40Var.b));
                            jSONObject.put("vc", i40Var.c);
                            jSONObject.put("va", i40Var.d);
                            jSONObject.put("installts", i40Var.e);
                            jSONObject.put("lstupdatets", i40Var.f);
                            jSONArray.put(jSONObject);
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                }
            } else {
                n20Var.a();
            }
            return jSONArray;
        }
        return (JSONArray) invokeL.objValue;
    }

    @Override // com.baidu.tieba.s20
    public JSONObject g(Context context) {
        InterceptResult invokeL;
        T t;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, context)) == null) {
            n20 n20Var = new n20();
            r10.b().c(context, n20Var);
            boolean b = n20Var.b(10000);
            JSONObject jSONObject = new JSONObject();
            if (b) {
                n20.b c = n20Var.c();
                if (c != null && (t = c.a) != 0) {
                    h40 h40Var = (h40) t;
                }
            } else {
                n20Var.a();
            }
            return jSONObject;
        }
        return (JSONObject) invokeL.objValue;
    }
}
