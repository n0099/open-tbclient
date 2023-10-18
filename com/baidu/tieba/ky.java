package com.baidu.tieba;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.iy;
import com.baidu.tieba.kx;
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
public class ky implements ny {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public ky() {
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

    @Override // com.baidu.tieba.ny
    public String a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? lx.b().a() : (String) invokeV.objValue;
    }

    @Override // com.baidu.tieba.ny
    public String a(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context)) == null) ? kx.f(context.getApplicationContext()).c() : (String) invokeL.objValue;
    }

    @Override // com.baidu.tieba.ny
    public JSONArray b(Context context) {
        InterceptResult invokeL;
        T t;
        kx.f fVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, context)) == null) {
            iy iyVar = new iy();
            kx.f(context).q(iyVar);
            boolean b = iyVar.b(10000);
            JSONArray jSONArray = new JSONArray();
            if (b) {
                iy.b a = iyVar.a();
                if (a != null && (t = a.a) != 0 && (fVar = (kx.f) t) != null && fVar.b() != null) {
                    for (kx.g gVar : fVar.b()) {
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
                iyVar.c();
            }
            return jSONArray;
        }
        return (JSONArray) invokeL.objValue;
    }

    @Override // com.baidu.tieba.ny
    public String c(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, context)) == null) {
            iy iyVar = new iy();
            kx.f(context).o(iyVar);
            if (!iyVar.b(10000)) {
                iyVar.c();
                return null;
            }
            iy.b a = iyVar.a();
            if (a == null || TextUtils.isEmpty((CharSequence) a.a)) {
                return null;
            }
            return (String) a.a;
        }
        return (String) invokeL.objValue;
    }

    @Override // com.baidu.tieba.ny
    public String d(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, context)) == null) {
            iy iyVar = new iy();
            kx.f(context).m(iyVar);
            if (!iyVar.b(10000)) {
                iyVar.c();
                return null;
            }
            iy.b a = iyVar.a();
            if (a == null || TextUtils.isEmpty((CharSequence) a.a)) {
                return null;
            }
            return (String) a.a;
        }
        return (String) invokeL.objValue;
    }

    @Override // com.baidu.tieba.ny
    public String e(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, context)) == null) ? kx.f(context.getApplicationContext()).e() : (String) invokeL.objValue;
    }

    @Override // com.baidu.tieba.ny
    public JSONArray f(Context context) {
        InterceptResult invokeL;
        T t;
        List<d00> list;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, context)) == null) {
            iy iyVar = new iy();
            lx.b().e(context, iyVar);
            boolean b = iyVar.b(10000);
            JSONArray jSONArray = new JSONArray();
            if (b) {
                iy.b a = iyVar.a();
                if (a != null && (t = a.a) != 0 && (list = (List) t) != null && list.size() > 0) {
                    for (d00 d00Var : list) {
                        JSONObject jSONObject = new JSONObject();
                        try {
                            jSONObject.put("pkg", d00Var.a);
                            jSONObject.put("sigs", Arrays.toString(d00Var.b));
                            jSONObject.put("vc", d00Var.c);
                            jSONObject.put("va", d00Var.d);
                            jSONObject.put("installts", d00Var.e);
                            jSONObject.put("lstupdatets", d00Var.f);
                            jSONArray.put(jSONObject);
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                }
            } else {
                iyVar.c();
            }
            return jSONArray;
        }
        return (JSONArray) invokeL.objValue;
    }

    @Override // com.baidu.tieba.ny
    public JSONObject g(Context context) {
        InterceptResult invokeL;
        T t;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, context)) == null) {
            iy iyVar = new iy();
            lx.b().c(context, iyVar);
            boolean b = iyVar.b(10000);
            JSONObject jSONObject = new JSONObject();
            if (b) {
                iy.b a = iyVar.a();
                if (a != null && (t = a.a) != 0) {
                    c00 c00Var = (c00) t;
                }
            } else {
                iyVar.c();
            }
            return jSONObject;
        }
        return (JSONObject) invokeL.objValue;
    }
}
