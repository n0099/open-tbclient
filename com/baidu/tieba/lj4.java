package com.baidu.tieba;

import androidx.annotation.Nullable;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.el4;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.HashMap;
import java.util.Iterator;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class lj4 implements el4.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final kj4 a;

    @Override // com.baidu.tieba.el4.a
    public void b(String str, String str2, JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048576, this, str, str2, jSONObject) == null) {
        }
    }

    @Override // com.baidu.tieba.el4.a
    public void onStart() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
        }
    }

    public lj4(@Nullable kj4 kj4Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {kj4Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = kj4Var;
    }

    @Override // com.baidu.tieba.el4.a
    public void onFail(Exception exc) {
        kj4 kj4Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, exc) == null) && (kj4Var = this.a) != null) {
            kj4Var.onFail(exc);
        }
    }

    @Override // com.baidu.tieba.el4.a
    public void onSuccess(String str, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048579, this, str, i) == null) {
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
                kj4 kj4Var = this.a;
                if (kj4Var != null) {
                    kj4Var.onFail(e);
                }
            }
        }
    }
}
