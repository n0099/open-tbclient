package com.bytedance.sdk.component.b.b;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Arrays;
import java.util.List;
/* loaded from: classes5.dex */
public interface o {

    /* renamed from: a  reason: collision with root package name */
    public static final o f28597a = new o() { // from class: com.bytedance.sdk.component.b.b.o.1
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // com.bytedance.sdk.component.b.b.o
        public List<InetAddress> a(String str) throws UnknownHostException {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) {
                if (str != null) {
                    try {
                        return Arrays.asList(InetAddress.getAllByName(str));
                    } catch (NullPointerException e2) {
                        UnknownHostException unknownHostException = new UnknownHostException("Broken system behaviour for dns lookup of " + str);
                        unknownHostException.initCause(e2);
                        throw unknownHostException;
                    }
                }
                throw new UnknownHostException("hostname == null");
            }
            return (List) invokeL.objValue;
        }
    };

    List<InetAddress> a(String str) throws UnknownHostException;
}
