package com.baidu.tieba;

import android.content.Context;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.voice.tts.bdtts.BdTtsImpl;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import kotlin.jvm.internal.Intrinsics;
/* loaded from: classes8.dex */
public final class wya {
    public static /* synthetic */ Interceptable $ic;
    public static final wya a;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948288298, "Lcom/baidu/tieba/wya;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948288298, "Lcom/baidu/tieba/wya;");
                return;
            }
        }
        a = new wya();
    }

    public wya() {
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

    public final Context getContext() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            TbadkCoreApplication inst = TbadkCoreApplication.getInst();
            Intrinsics.checkNotNullExpressionValue(inst, "getInst()");
            return inst;
        }
        return (Context) invokeV.objValue;
    }

    public final tya a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            vya.a.a("TtsManager", "createTts");
            BdTtsImpl bdTtsImpl = new BdTtsImpl();
            bdTtsImpl.n(a.getContext());
            return bdTtsImpl;
        }
        return (tya) invokeV.objValue;
    }
}
