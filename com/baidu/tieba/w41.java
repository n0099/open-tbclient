package com.baidu.tieba;

import android.content.Context;
import android.content.Intent;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.nadcore.webview.AdWebActivity;
import com.baidu.nadcore.webview.AdWebActivityStandard;
import com.baidu.pyramid.annotation.Service;
import com.baidu.tieba.j51;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.HashMap;
import java.util.Map;
@Service
/* loaded from: classes6.dex */
public class w41 extends ji0 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes6.dex */
    public class a implements j51.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ Context a;
        public final /* synthetic */ HashMap b;
        public final /* synthetic */ ri0 c;
        public final /* synthetic */ ni0 d;
        public final /* synthetic */ w41 e;

        public a(w41 w41Var, Context context, HashMap hashMap, ri0 ri0Var, ni0 ni0Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {w41Var, context, hashMap, ri0Var, ni0Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.e = w41Var;
            this.a = context;
            this.b = hashMap;
            this.c = ri0Var;
            this.d = ni0Var;
        }

        @Override // com.baidu.tieba.j51.b
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                boolean g = w41.g(this.a, this.b);
                this.e.c(this.c, this.d, g ? 0 : 1001, g);
            }
        }
    }

    public w41() {
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
            if (ng0.a) {
                a21.a().showToast(context, "启动SDK Webview");
            }
            if (s41.a.b(hashMap, 0)) {
                Intent intent = new Intent(context, "1".equals(hashMap.remove("newbrowser")) ? AdWebActivityStandard.class : AdWebActivity.class);
                intent.putExtra("map", hashMap);
                return n21.d(context, intent);
            }
            return false;
        }
        return invokeLL.booleanValue;
    }

    @Override // com.baidu.tieba.ji0
    public String a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? "easybrowse" : (String) invokeV.objValue;
    }

    @Override // com.baidu.tieba.ji0
    public boolean b(@NonNull Context context, @NonNull ni0 ni0Var, @Nullable Map<String, Object> map, @Nullable ri0 ri0Var) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context, ni0Var, map, ri0Var)) == null) {
            super.b(context, ni0Var, map, ri0Var);
            HashMap<String, String> d = ni0Var.d();
            int b = x41.b(context.getApplicationContext(), new a(this, context, d, ri0Var, ni0Var));
            if (4 != b && b != 0) {
                if (2 != b && 1 != b) {
                    boolean g = g(context, d);
                    c(ri0Var, ni0Var, g ? 0 : 1001, g);
                }
                return true;
            }
            c(ri0Var, ni0Var, 1001, false);
            if (ng0.a) {
                throw new IllegalStateException("web app init failed, state=" + b);
            }
            return true;
        }
        return invokeLLLL.booleanValue;
    }
}
