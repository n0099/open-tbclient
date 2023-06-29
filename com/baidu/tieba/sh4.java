package com.baidu.tieba;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.swan.map.location.model.SelectedLocationInfo;
import com.baidu.tieba.dh4;
import com.baidu.tieba.nh4;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class sh4 extends og4<my2> implements nh4.b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public ly2 a;
    public my2 b;

    /* loaded from: classes7.dex */
    public class a implements dh4.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ly2 a;
        public final /* synthetic */ String b;
        public final /* synthetic */ sh4 c;

        public a(sh4 sh4Var, ly2 ly2Var, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {sh4Var, ly2Var, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = sh4Var;
            this.a = ly2Var;
            this.b = str;
        }

        @Override // com.baidu.tieba.dh4.c
        public void onFail() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                c92.o("map", "location permission fail");
                this.a.b(this.b, 1003, "location permission fail");
            }
        }

        @Override // com.baidu.tieba.dh4.c
        public void onSuccess() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                c92.o("map", "location permission success");
                this.c.g();
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948151402, "Lcom/baidu/tieba/sh4;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948151402, "Lcom/baidu/tieba/sh4;");
                return;
            }
        }
        boolean z = ms1.a;
    }

    public sh4() {
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

    public static sh4 h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
            return new sh4();
        }
        return (sh4) invokeV.objValue;
    }

    public final void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            nh4 d3 = nh4.d3(null);
            d3.i3(this);
            d3.k3();
        }
    }

    @Override // com.baidu.tieba.nh4.b
    public void onCancel() {
        my2 my2Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            c92.i("map", "choose location cancel");
            ly2 ly2Var = this.a;
            if (ly2Var != null && (my2Var = this.b) != null) {
                ly2Var.b(my2Var.z, 1002, "choose location canceled");
            }
        }
    }

    @Override // com.baidu.tieba.nh4.b
    public void onError() {
        my2 my2Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            c92.i("map", "choose location fail");
            ly2 ly2Var = this.a;
            if (ly2Var != null && (my2Var = this.b) != null) {
                ly2Var.b(my2Var.z, 1007, "choose location failed");
            }
        }
    }

    @Override // com.baidu.tieba.nh4.b
    public void a(SelectedLocationInfo selectedLocationInfo) {
        ly2 ly2Var;
        my2 my2Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048576, this, selectedLocationInfo) == null) && (ly2Var = this.a) != null && (my2Var = this.b) != null) {
            ly2Var.c(my2Var.z, selectedLocationInfo.toJson());
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.og4
    /* renamed from: f */
    public boolean b(Context context, my2 my2Var, ly2 ly2Var, cc3 cc3Var, JSONObject jSONObject) {
        InterceptResult invokeLLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLLL = interceptable.invokeLLLLL(1048579, this, context, my2Var, ly2Var, cc3Var, jSONObject)) == null) {
            return e(context, my2Var, ly2Var, cc3Var);
        }
        return invokeLLLLL.booleanValue;
    }

    public final boolean e(Context context, my2 my2Var, ly2 ly2Var, cc3 cc3Var) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(Constants.METHOD_SEND_USER_MSG, this, context, my2Var, ly2Var, cc3Var)) == null) {
            c92.i("map", "ChooseLocationAction start");
            if (!my2Var.isValid()) {
                c92.c("map", "model is invalid");
                return false;
            }
            String str = my2Var.z;
            if (TextUtils.isEmpty(str)) {
                c92.c("map", "cb is empty");
                return false;
            }
            this.a = ly2Var;
            this.b = my2Var;
            dh4.b(context, new a(this, ly2Var, str));
            c92.i("map", "ChooseLocationAction end");
            return true;
        }
        return invokeLLLL.booleanValue;
    }
}
