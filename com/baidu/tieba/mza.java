package com.baidu.tieba;

import com.baidu.tieba.write.webwrite.data.WrapListener;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public interface mza {

    /* loaded from: classes7.dex */
    public static final class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public static Function1<JSONObject, Unit> a(mza mzaVar) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, mzaVar)) == null) {
                return null;
            }
            return (Function1) invokeL.objValue;
        }
    }

    Function1<JSONObject, Unit> b();

    jza[] d();

    WrapListener[] e();

    kza[] f();
}
