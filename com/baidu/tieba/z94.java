package com.baidu.tieba;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.swan.map.location.model.SelectedLocationInfo;
import com.baidu.tieba.k94;
import com.baidu.tieba.u94;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class z94 extends v84<tq2> implements u94.b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public sq2 a;
    public tq2 b;

    /* loaded from: classes7.dex */
    public class a implements k94.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ sq2 a;
        public final /* synthetic */ String b;
        public final /* synthetic */ z94 c;

        public a(z94 z94Var, sq2 sq2Var, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {z94Var, sq2Var, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = z94Var;
            this.a = sq2Var;
            this.b = str;
        }

        @Override // com.baidu.tieba.k94.c
        public void onFail() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                j12.o("map", "location permission fail");
                this.a.b(this.b, 1003, "location permission fail");
            }
        }

        @Override // com.baidu.tieba.k94.c
        public void onSuccess() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                j12.o("map", "location permission success");
                this.c.g();
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948314772, "Lcom/baidu/tieba/z94;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948314772, "Lcom/baidu/tieba/z94;");
                return;
            }
        }
        boolean z = tk1.a;
    }

    public z94() {
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

    public static z94 h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
            return new z94();
        }
        return (z94) invokeV.objValue;
    }

    public final void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            u94 b3 = u94.b3(null);
            b3.g3(this);
            b3.i3();
        }
    }

    @Override // com.baidu.tieba.u94.b
    public void onCancel() {
        tq2 tq2Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            j12.i("map", "choose location cancel");
            sq2 sq2Var = this.a;
            if (sq2Var != null && (tq2Var = this.b) != null) {
                sq2Var.b(tq2Var.z, 1002, "choose location canceled");
            }
        }
    }

    @Override // com.baidu.tieba.u94.b
    public void onError() {
        tq2 tq2Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            j12.i("map", "choose location fail");
            sq2 sq2Var = this.a;
            if (sq2Var != null && (tq2Var = this.b) != null) {
                sq2Var.b(tq2Var.z, 1007, "choose location failed");
            }
        }
    }

    @Override // com.baidu.tieba.u94.b
    public void a(SelectedLocationInfo selectedLocationInfo) {
        sq2 sq2Var;
        tq2 tq2Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048576, this, selectedLocationInfo) == null) && (sq2Var = this.a) != null && (tq2Var = this.b) != null) {
            sq2Var.c(tq2Var.z, selectedLocationInfo.toJson());
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.v84
    /* renamed from: f */
    public boolean b(Context context, tq2 tq2Var, sq2 sq2Var, j43 j43Var, JSONObject jSONObject) {
        InterceptResult invokeLLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLLL = interceptable.invokeLLLLL(1048579, this, context, tq2Var, sq2Var, j43Var, jSONObject)) == null) {
            return e(context, tq2Var, sq2Var, j43Var);
        }
        return invokeLLLLL.booleanValue;
    }

    public final boolean e(Context context, tq2 tq2Var, sq2 sq2Var, j43 j43Var) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(Constants.METHOD_SEND_USER_MSG, this, context, tq2Var, sq2Var, j43Var)) == null) {
            j12.i("map", "ChooseLocationAction start");
            if (!tq2Var.isValid()) {
                j12.c("map", "model is invalid");
                return false;
            }
            String str = tq2Var.z;
            if (TextUtils.isEmpty(str)) {
                j12.c("map", "cb is empty");
                return false;
            }
            this.a = sq2Var;
            this.b = tq2Var;
            k94.b(context, new a(this, sq2Var, str));
            j12.i("map", "ChooseLocationAction end");
            return true;
        }
        return invokeLLLL.booleanValue;
    }
}
