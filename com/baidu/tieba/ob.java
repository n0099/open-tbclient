package com.baidu.tieba;

import com.baidu.adp.gif.NSGif;
import com.baidu.adp.widget.ImageView.BdImage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
public interface ob {
    BdImage a(byte[] bArr, int i, int i2);

    BdImage get(String str);

    /* loaded from: classes7.dex */
    public static class a implements ob {
        public static /* synthetic */ Interceptable $ic;
        public static ob c;
        public transient /* synthetic */ FieldHolder $fh;
        public int a;
        public final rb b;

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
            this.b = new rb();
            if (NSGif.f) {
                this.a = 0;
            } else {
                this.a = 1;
            }
        }

        public static synchronized ob b() {
            InterceptResult invokeV;
            ob obVar;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
                synchronized (a.class) {
                    if (c == null) {
                        c = new a();
                    }
                    obVar = c;
                }
                return obVar;
            }
            return (ob) invokeV.objValue;
        }

        @Override // com.baidu.tieba.ob
        public BdImage a(byte[] bArr, int i, int i2) {
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
            return (BdImage) invokeLII.objValue;
        }

        @Override // com.baidu.tieba.ob
        public BdImage get(String str) {
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
            return (BdImage) invokeL.objValue;
        }
    }
}
