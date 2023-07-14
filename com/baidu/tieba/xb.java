package com.baidu.tieba;

import com.baidu.adp.gif.NSGif;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes8.dex */
public interface xb {
    jn a(byte[] bArr, int i, int i2);

    jn get(String str);

    /* loaded from: classes8.dex */
    public static class a implements xb {
        public static /* synthetic */ Interceptable $ic;
        public static xb c;
        public transient /* synthetic */ FieldHolder $fh;
        public int a;
        public final ac b;

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
            this.a = 0;
            this.b = new ac();
            if (NSGif.f) {
                this.a = 0;
            } else {
                this.a = 1;
            }
        }

        public static synchronized xb b() {
            InterceptResult invokeV;
            xb xbVar;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
                synchronized (a.class) {
                    if (c == null) {
                        c = new a();
                    }
                    xbVar = c;
                }
                return xbVar;
            }
            return (xb) invokeV.objValue;
        }

        @Override // com.baidu.tieba.xb
        public jn a(byte[] bArr, int i, int i2) {
            InterceptResult invokeLII;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLII = interceptable.invokeLII(1048576, this, bArr, i, i2)) == null) {
                if (this.a == 0) {
                    try {
                        return this.b.a(bArr, i, i2);
                    } catch (Exception unused) {
                    }
                }
                return null;
            }
            return (jn) invokeLII.objValue;
        }

        @Override // com.baidu.tieba.xb
        public jn get(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
                if (this.a == 0) {
                    try {
                        return this.b.get(str);
                    } catch (Exception unused) {
                    }
                }
                return null;
            }
            return (jn) invokeL.objValue;
        }
    }
}
