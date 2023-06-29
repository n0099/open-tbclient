package com.baidu.tieba;

import com.baidu.adp.lib.util.BdLog;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.xe;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes8.dex */
public class ze<T> extends ye<T> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ze(String str, we<T> weVar) {
        super(str, weVar);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, weVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((String) objArr2[0], (we) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    @Override // com.baidu.tieba.ye, com.baidu.tieba.xe
    public void e(String str, T t, long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{str, t, Long.valueOf(j)}) == null) {
            try {
                super.e(str, t, j);
            } catch (Throwable th) {
                if (BdLog.isDebugMode()) {
                    BdLog.e(th);
                }
            }
        }
    }

    @Override // com.baidu.tieba.ye, com.baidu.tieba.xe
    public T get(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
            try {
                return (T) super.get(str);
            } catch (Throwable th) {
                if (BdLog.isDebugMode()) {
                    BdLog.e(th);
                    return null;
                }
                return null;
            }
        }
        return (T) invokeL.objValue;
    }

    @Override // com.baidu.tieba.ye, com.baidu.tieba.xe
    public xe.b<T> h(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) {
            try {
                return super.h(str);
            } catch (Throwable th) {
                if (BdLog.isDebugMode()) {
                    BdLog.e(th);
                    return null;
                }
                return null;
            }
        }
        return (xe.b) invokeL.objValue;
    }

    @Override // com.baidu.tieba.ye, com.baidu.tieba.xe
    public void remove(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, str) == null) {
            try {
                super.remove(str);
            } catch (Throwable th) {
                if (BdLog.isDebugMode()) {
                    BdLog.e(th);
                }
            }
        }
    }
}
