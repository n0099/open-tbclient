package com.baidu.tieba;

import androidx.annotation.NonNull;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.webkit.sdk.plugin.ZeusPlugin;
import java.util.ArrayList;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class or2 extends wp2<ns2> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @Override // com.baidu.tieba.wp2
    @NonNull
    public String b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? "getRemoteUserList" : (String) invokeV.objValue;
    }

    public or2() {
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

    @Override // com.baidu.tieba.wp2
    public void c(@NonNull ZeusPlugin.Command command) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, command) == null) {
            command.obj = new JSONObject();
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.wp2
    /* renamed from: e */
    public void a(@NonNull ZeusPlugin.Command command, @NonNull ns2 ns2Var) {
        JSONObject a;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048579, this, command, ns2Var) == null) {
            ArrayList<rs2> h = ns2Var.h();
            JSONObject jSONObject = new JSONObject();
            JSONArray jSONArray = new JSONArray();
            if (h != null) {
                Iterator<rs2> it = h.iterator();
                while (it.hasNext()) {
                    rs2 next = it.next();
                    if (next == null) {
                        a = null;
                    } else {
                        a = next.a();
                    }
                    if (a != null) {
                        jSONArray.put(a);
                    }
                }
            }
            try {
                jSONObject.put("userList", jSONArray);
            } catch (JSONException unused) {
            }
            command.obj = jSONObject;
            String str = command.what;
            d(ns2Var, str, "" + command.obj, true);
        }
    }
}
