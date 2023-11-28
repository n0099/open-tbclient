package com.baidu.tieba;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Triple;
import kotlin.jvm.internal.Intrinsics;
/* loaded from: classes8.dex */
public interface qv8<TbMsg, SdkMsg> {
    TbMsg a(rv8<SdkMsg> rv8Var, SdkMsg sdkmsg) throws Exception;

    SdkMsg b(rv8<SdkMsg> rv8Var, TbMsg tbmsg) throws Exception;

    /* loaded from: classes8.dex */
    public static abstract class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final Map<Class<?>, qv8<?, ?>> a;
        public final Map<Class<?>, qv8<?, ?>> b;

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
                    return;
                }
            }
            this.a = new LinkedHashMap();
            this.b = new LinkedHashMap();
        }

        public final qv8<?, ?> a(Class<?> sdkMsgClass) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, sdkMsgClass)) == null) {
                Intrinsics.checkNotNullParameter(sdkMsgClass, "sdkMsgClass");
                return this.b.get(sdkMsgClass);
            }
            return (qv8) invokeL.objValue;
        }

        public final void c(Triple<? extends Class<?>, ? extends Class<?>, ? extends qv8<?, ?>> triple) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, triple) == null) {
                Intrinsics.checkNotNullParameter(triple, "triple");
                this.a.put(triple.getFirst(), triple.getThird());
                this.b.put(triple.getSecond(), triple.getThird());
            }
        }

        public final qv8<?, ?> b(Class<?> tbMsgClass) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, tbMsgClass)) == null) {
                Intrinsics.checkNotNullParameter(tbMsgClass, "tbMsgClass");
                if (this.a.containsKey(tbMsgClass)) {
                    return this.a.get(tbMsgClass);
                }
                Class<? super Object> superclass = tbMsgClass.getSuperclass();
                if (superclass == null) {
                    return null;
                }
                return b(superclass);
            }
            return (qv8) invokeL.objValue;
        }
    }
}
