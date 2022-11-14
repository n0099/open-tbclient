package com.baidu.tieba;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.swan.map.location.model.SelectedLocationInfo;
import com.baidu.tieba.g94;
import com.baidu.tieba.q94;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class v94 extends r84<pq2> implements q94.b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public oq2 a;
    public pq2 b;

    /* loaded from: classes6.dex */
    public class a implements g94.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ oq2 a;
        public final /* synthetic */ String b;
        public final /* synthetic */ v94 c;

        public a(v94 v94Var, oq2 oq2Var, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {v94Var, oq2Var, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = v94Var;
            this.a = oq2Var;
            this.b = str;
        }

        @Override // com.baidu.tieba.g94.c
        public void onFail() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                f12.o("map", "location permission fail");
                this.a.b(this.b, 1003, "location permission fail");
            }
        }

        @Override // com.baidu.tieba.g94.c
        public void onSuccess() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                f12.o("map", "location permission success");
                this.c.g();
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948195608, "Lcom/baidu/tieba/v94;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948195608, "Lcom/baidu/tieba/v94;");
                return;
            }
        }
        boolean z = pk1.a;
    }

    public v94() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    public static v94 h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
            return new v94();
        }
        return (v94) invokeV.objValue;
    }

    public final void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            q94 b3 = q94.b3(null);
            b3.g3(this);
            b3.i3();
        }
    }

    @Override // com.baidu.tieba.q94.b
    public void onCancel() {
        pq2 pq2Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            f12.i("map", "choose location cancel");
            oq2 oq2Var = this.a;
            if (oq2Var != null && (pq2Var = this.b) != null) {
                oq2Var.b(pq2Var.z, 1002, "choose location canceled");
            }
        }
    }

    @Override // com.baidu.tieba.q94.b
    public void onError() {
        pq2 pq2Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            f12.i("map", "choose location fail");
            oq2 oq2Var = this.a;
            if (oq2Var != null && (pq2Var = this.b) != null) {
                oq2Var.b(pq2Var.z, 1007, "choose location failed");
            }
        }
    }

    @Override // com.baidu.tieba.q94.b
    public void a(SelectedLocationInfo selectedLocationInfo) {
        oq2 oq2Var;
        pq2 pq2Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048576, this, selectedLocationInfo) == null) && (oq2Var = this.a) != null && (pq2Var = this.b) != null) {
            oq2Var.c(pq2Var.z, selectedLocationInfo.toJson());
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.r84
    /* renamed from: f */
    public boolean b(Context context, pq2 pq2Var, oq2 oq2Var, f43 f43Var, JSONObject jSONObject) {
        InterceptResult invokeLLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLLL = interceptable.invokeLLLLL(1048579, this, context, pq2Var, oq2Var, f43Var, jSONObject)) == null) {
            return e(context, pq2Var, oq2Var, f43Var);
        }
        return invokeLLLLL.booleanValue;
    }

    public final boolean e(Context context, pq2 pq2Var, oq2 oq2Var, f43 f43Var) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(Constants.METHOD_SEND_USER_MSG, this, context, pq2Var, oq2Var, f43Var)) == null) {
            f12.i("map", "ChooseLocationAction start");
            if (!pq2Var.isValid()) {
                f12.c("map", "model is invalid");
                return false;
            }
            String str = pq2Var.z;
            if (TextUtils.isEmpty(str)) {
                f12.c("map", "cb is empty");
                return false;
            }
            this.a = oq2Var;
            this.b = pq2Var;
            g94.b(context, new a(this, oq2Var, str));
            f12.i("map", "ChooseLocationAction end");
            return true;
        }
        return invokeLLLL.booleanValue;
    }
}
