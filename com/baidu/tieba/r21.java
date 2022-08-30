package com.baidu.tieba;

import android.content.Context;
import android.content.Intent;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.nadcore.webview.AdWebActivity;
import com.baidu.nadcore.webview.AdWebActivityStandard;
import com.baidu.pyramid.annotation.Service;
import com.baidu.tieba.e31;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.HashMap;
import java.util.Map;
@Service
/* loaded from: classes5.dex */
public class r21 extends og0 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes5.dex */
    public class a implements e31.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ Context a;
        public final /* synthetic */ HashMap b;
        public final /* synthetic */ wg0 c;
        public final /* synthetic */ sg0 d;
        public final /* synthetic */ r21 e;

        public a(r21 r21Var, Context context, HashMap hashMap, wg0 wg0Var, sg0 sg0Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {r21Var, context, hashMap, wg0Var, sg0Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.e = r21Var;
            this.a = context;
            this.b = hashMap;
            this.c = wg0Var;
            this.d = sg0Var;
        }

        @Override // com.baidu.tieba.e31.b
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                boolean g = r21.g(this.a, this.b);
                this.e.c(this.c, this.d, g ? 0 : 1001, g);
            }
        }
    }

    public r21() {
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

    public static boolean g(Context context, @NonNull HashMap<String, String> hashMap) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65539, null, context, hashMap)) == null) {
            if (ue0.a) {
                yz0.a().showToast(context, "启动SDK Webview");
            }
            if (n21.a.b(hashMap, 0)) {
                Intent intent = new Intent(context, "1".equals(hashMap.remove("newbrowser")) ? AdWebActivityStandard.class : AdWebActivity.class);
                intent.putExtra("map", hashMap);
                return k01.d(context, intent);
            }
            return false;
        }
        return invokeLL.booleanValue;
    }

    @Override // com.baidu.tieba.og0
    public String a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? "easybrowse" : (String) invokeV.objValue;
    }

    @Override // com.baidu.tieba.og0
    public boolean b(@NonNull Context context, @NonNull sg0 sg0Var, @Nullable Map<String, Object> map, @Nullable wg0 wg0Var) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context, sg0Var, map, wg0Var)) == null) {
            super.b(context, sg0Var, map, wg0Var);
            HashMap<String, String> d = sg0Var.d();
            int b = s21.b(context.getApplicationContext(), new a(this, context, d, wg0Var, sg0Var));
            if (4 != b && b != 0) {
                if (2 != b && 1 != b) {
                    boolean g = g(context, d);
                    c(wg0Var, sg0Var, g ? 0 : 1001, g);
                }
                return true;
            }
            c(wg0Var, sg0Var, 1001, false);
            if (ue0.a) {
                throw new IllegalStateException("web app init failed, state=" + b);
            }
            return true;
        }
        return invokeLLLL.booleanValue;
    }
}
