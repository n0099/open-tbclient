package com.baidu.tieba;

import android.text.TextUtils;
import android.util.Log;
import android.util.LruCache;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.process.ipc.util.ProcessUtils;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes9.dex */
public class yb2 implements vb2 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean b;
    public transient /* synthetic */ FieldHolder $fh;
    public final LruCache<String, Long> a;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948324320, "Lcom/baidu/tieba/yb2;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948324320, "Lcom/baidu/tieba/yb2;");
                return;
            }
        }
        b = vm1.a;
    }

    public yb2(int i) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Integer.valueOf(i)};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        i = i <= 0 ? 10 : i;
        this.a = new LruCache<>(i);
        if (b) {
            Log.d("SwanPrelinkLocalRecorder", "lru size - " + i);
        }
    }

    @Override // com.baidu.tieba.vb2
    public void a(String str, String str2, boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLLZ(1048576, this, str, str2, z) != null) || TextUtils.isEmpty(str2)) {
            return;
        }
        if (b) {
            Log.d("SwanPrelinkLocalRecorder", "record : appId-" + str + ", url-" + str2);
        }
        this.a.put(str2, Long.valueOf(System.currentTimeMillis()));
    }

    @Override // com.baidu.tieba.vb2
    public wb2 get(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, str2)) == null) {
            if (b) {
                Log.d("SwanPrelinkLocalRecorder", "prelink LRU size - " + this.a.size());
            }
            Long l = this.a.get(str2);
            if (l == null) {
                return null;
            }
            wb2 wb2Var = new wb2();
            wb2Var.a = ProcessUtils.getCurProcessName();
            wb2Var.b = l.longValue();
            return wb2Var;
        }
        return (wb2) invokeLL.objValue;
    }
}
