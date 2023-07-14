package com.baidu.tieba;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.k40;
import com.baidu.tieba.m30;
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
public class m40 implements p40 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public m40() {
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

    @Override // com.baidu.tieba.p40
    public String a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? n30.b().a() : (String) invokeV.objValue;
    }

    @Override // com.baidu.tieba.p40
    public String a(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context)) == null) ? m30.f(context.getApplicationContext()).c() : (String) invokeL.objValue;
    }

    @Override // com.baidu.tieba.p40
    public JSONArray b(Context context) {
        InterceptResult invokeL;
        T t;
        m30.f fVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, context)) == null) {
            k40 k40Var = new k40();
            m30.f(context).q(k40Var);
            boolean b = k40Var.b(10000);
            JSONArray jSONArray = new JSONArray();
            if (b) {
                k40.b a = k40Var.a();
                if (a != null && (t = a.a) != 0 && (fVar = (m30.f) t) != null && fVar.b() != null) {
                    for (m30.g gVar : fVar.b()) {
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
                k40Var.c();
            }
            return jSONArray;
        }
        return (JSONArray) invokeL.objValue;
    }

    @Override // com.baidu.tieba.p40
    public String c(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, context)) == null) {
            k40 k40Var = new k40();
            m30.f(context).o(k40Var);
            if (!k40Var.b(10000)) {
                k40Var.c();
                return null;
            }
            k40.b a = k40Var.a();
            if (a == null || TextUtils.isEmpty((CharSequence) a.a)) {
                return null;
            }
            return (String) a.a;
        }
        return (String) invokeL.objValue;
    }

    @Override // com.baidu.tieba.p40
    public String d(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, context)) == null) {
            k40 k40Var = new k40();
            m30.f(context).m(k40Var);
            if (!k40Var.b(10000)) {
                k40Var.c();
                return null;
            }
            k40.b a = k40Var.a();
            if (a == null || TextUtils.isEmpty((CharSequence) a.a)) {
                return null;
            }
            return (String) a.a;
        }
        return (String) invokeL.objValue;
    }

    @Override // com.baidu.tieba.p40
    public String e(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, context)) == null) ? m30.f(context.getApplicationContext()).e() : (String) invokeL.objValue;
    }

    @Override // com.baidu.tieba.p40
    public JSONArray f(Context context) {
        InterceptResult invokeL;
        T t;
        List<f60> list;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, context)) == null) {
            k40 k40Var = new k40();
            n30.b().e(context, k40Var);
            boolean b = k40Var.b(10000);
            JSONArray jSONArray = new JSONArray();
            if (b) {
                k40.b a = k40Var.a();
                if (a != null && (t = a.a) != 0 && (list = (List) t) != null && list.size() > 0) {
                    for (f60 f60Var : list) {
                        JSONObject jSONObject = new JSONObject();
                        try {
                            jSONObject.put("pkg", f60Var.a);
                            jSONObject.put("sigs", Arrays.toString(f60Var.b));
                            jSONObject.put("vc", f60Var.c);
                            jSONObject.put("va", f60Var.d);
                            jSONObject.put("installts", f60Var.e);
                            jSONObject.put("lstupdatets", f60Var.f);
                            jSONArray.put(jSONObject);
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                }
            } else {
                k40Var.c();
            }
            return jSONArray;
        }
        return (JSONArray) invokeL.objValue;
    }

    @Override // com.baidu.tieba.p40
    public JSONObject g(Context context) {
        InterceptResult invokeL;
        T t;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, context)) == null) {
            k40 k40Var = new k40();
            n30.b().c(context, k40Var);
            boolean b = k40Var.b(10000);
            JSONObject jSONObject = new JSONObject();
            if (b) {
                k40.b a = k40Var.a();
                if (a != null && (t = a.a) != 0) {
                    e60 e60Var = (e60) t;
                }
            } else {
                k40Var.c();
            }
            return jSONObject;
        }
        return (JSONObject) invokeL.objValue;
    }
}
