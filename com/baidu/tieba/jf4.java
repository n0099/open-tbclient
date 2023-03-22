package com.baidu.tieba;

import androidx.annotation.Nullable;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.ch4;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.HashMap;
import java.util.Iterator;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class jf4 implements ch4.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final if4 a;

    @Override // com.baidu.tieba.ch4.a
    public void b(String str, String str2, JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048576, this, str, str2, jSONObject) == null) {
        }
    }

    @Override // com.baidu.tieba.ch4.a
    public void onStart() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
        }
    }

    public jf4(@Nullable if4 if4Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {if4Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = if4Var;
    }

    @Override // com.baidu.tieba.ch4.a
    public void onFail(Exception exc) {
        if4 if4Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, exc) == null) && (if4Var = this.a) != null) {
            if4Var.onFail(exc);
        }
    }

    @Override // com.baidu.tieba.ch4.a
    public void c(String str, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, i) == null) {
            try {
                HashMap hashMap = new HashMap();
                JSONObject optJSONObject = new JSONObject(str).optJSONObject("data");
                Iterator<String> keys = optJSONObject.keys();
                while (keys.hasNext()) {
                    JSONObject optJSONObject2 = optJSONObject.optJSONObject(keys.next());
                    if (optJSONObject2 != null) {
                        hashMap.put(optJSONObject2.optString("appkey"), optJSONObject2.optString("openbundleid"));
                    }
                }
                if (this.a != null) {
                    this.a.a(hashMap);
                }
            } catch (Exception e) {
                if4 if4Var = this.a;
                if (if4Var != null) {
                    if4Var.onFail(e);
                }
            }
        }
    }
}
