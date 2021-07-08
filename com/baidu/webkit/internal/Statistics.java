package com.baidu.webkit.internal;

import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public class Statistics implements INoProGuard {
    public static /* synthetic */ Interceptable $ic = null;
    public static int MONITOR_TYPE_ADD_JAVA_SCRIPT = 12320;
    public static final int kTypeWhiteScreen = 12302;
    public static final int kTypeWhiteScreenForAsyncSearch = 12304;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes5.dex */
    public interface Client extends INoProGuard {
        boolean onCommitRecord(Record record);
    }

    /* loaded from: classes5.dex */
    public interface Record extends INoProGuard {
        int getType();

        String getUrl();

        String toJSON();
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(1203622949, "Lcom/baidu/webkit/internal/Statistics;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(1203622949, "Lcom/baidu/webkit/internal/Statistics;");
        }
    }

    public Statistics() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }
}
