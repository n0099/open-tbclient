package com.baidu.tieba;

import android.content.Context;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.pyramid.annotation.Autowired;
import com.baidu.pyramid.annotation.Inject;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.HashMap;
/* loaded from: classes6.dex */
public interface k81 {
    public static final k81 a = new a();

    boolean a(Context context, String str, String str2, @Nullable kj0 kj0Var);

    /* loaded from: classes6.dex */
    public class a implements k81 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public a() {
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

        @Override // com.baidu.tieba.k81
        public boolean a(Context context, String str, String str2, @Nullable kj0 kj0Var) {
            InterceptResult invokeLLLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048576, this, context, str, str2, kj0Var)) == null) {
                if (str != null) {
                    HashMap hashMap = new HashMap();
                    hashMap.put("refer", str2);
                    hashMap.put("from_web_view", Boolean.TRUE);
                    return bj0.e(str, context, hashMap, kj0Var);
                }
                return false;
            }
            return invokeLLLL.booleanValue;
        }
    }

    @Autowired
    /* loaded from: classes6.dex */
    public static final class b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        @NonNull
        @Inject(force = false)
        public static k81 a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
                return k81.a;
            }
            return (k81) invokeV.objValue;
        }
    }
}
