package com.baidu.tieba;

import android.util.Log;
import androidx.annotation.Nullable;
import androidx.core.app.NotificationCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import org.json.JSONArray;
/* loaded from: classes8.dex */
public class th2 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean b;
    public transient /* synthetic */ FieldHolder $fh;
    public final List<il2> a;

    /* loaded from: classes8.dex */
    public static class a extends il2 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public String d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(@Nullable Map<String, String> map) {
            super("TopPages", map);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {map};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    super((String) objArr2[0], (Map) objArr2[1]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
        }

        @Override // com.baidu.tieba.hl2
        public String c(fa2 fa2Var) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, fa2Var)) == null) {
                if (this.d == null) {
                    this.d = super.c(fa2Var);
                }
                return this.d;
            }
            return (String) invokeL.objValue;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948181131, "Lcom/baidu/tieba/th2;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948181131, "Lcom/baidu/tieba/th2;");
                return;
            }
        }
        b = rr1.a;
    }

    public th2() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.a = new ArrayList();
    }

    public th2 a(il2 il2Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, il2Var)) == null) {
            if (il2Var != null) {
                this.a.add(il2Var);
            }
            return this;
        }
        return (th2) invokeL.objValue;
    }

    public a b() {
        InterceptResult invokeV;
        long j;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            if (b) {
                j = System.currentTimeMillis();
            } else {
                j = 0;
            }
            TreeMap treeMap = new TreeMap();
            treeMap.put(NotificationCompat.WearableExtender.KEY_PAGES, c().toString());
            if (b) {
                long currentTimeMillis = System.currentTimeMillis();
                Log.d("TopPageEvent", "build slave preload msg cost - " + (currentTimeMillis - j) + "ms");
            }
            return new a(treeMap);
        }
        return (a) invokeV.objValue;
    }

    public final JSONArray c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            JSONArray jSONArray = new JSONArray();
            for (il2 il2Var : this.a) {
                jSONArray.put(il2Var.s());
            }
            return jSONArray;
        }
        return (JSONArray) invokeV.objValue;
    }
}
