package com.baidu.tts;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.tts.chainofresponsibility.logger.LoggerProxy;
/* loaded from: classes9.dex */
public class l implements d1<l, a> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public String a;

    /* loaded from: classes9.dex */
    public static class a implements c1 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public d a;

        @Override // com.baidu.tts.c1
        public boolean a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                return true;
            }
            return invokeV.booleanValue;
        }

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

        public void a(d dVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, dVar) == null) {
                LoggerProxy.d("OnlineAuth", "this=" + this + "--error=" + dVar.getDetailMessage());
                this.a = dVar;
            }
        }
    }

    public l() {
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

    @Override // java.util.concurrent.Callable
    public Object call() throws Exception {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            LoggerProxy.d("OnlineAuth", "enter online auth");
            a aVar = new a();
            LoggerProxy.d("OnlineAuth", "end online auth");
            return aVar;
        }
        return invokeV.objValue;
    }

    @Override // java.lang.Comparable
    public int compareTo(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, obj)) == null) {
            String str = ((l) obj).a;
            LoggerProxy.d("OnlineAuth", "mProductId=" + this.a + "--productId2=" + str);
            if (str == null) {
                return 1;
            }
            return this.a.compareTo(str);
        }
        return invokeL.intValue;
    }
}
