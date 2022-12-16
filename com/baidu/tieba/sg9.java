package com.baidu.tieba;

import android.util.Base64OutputStream;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.IOException;
import java.io.OutputStream;
/* loaded from: classes6.dex */
public class sg9 extends Base64OutputStream {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean a;
    public boolean b;
    public long c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public sg9(OutputStream outputStream, int i) {
        super(outputStream, i);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {outputStream, Integer.valueOf(i)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((OutputStream) objArr2[0], ((Integer) objArr2[1]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = false;
        this.b = false;
        this.c = 0L;
    }

    public long a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return this.c;
        }
        return invokeV.longValue;
    }

    @Override // android.util.Base64OutputStream, java.io.FilterOutputStream, java.io.OutputStream
    public void write(int i) throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i) == null) {
            if (!this.a) {
                super.write(117);
                this.a = true;
            } else if (!this.b) {
                super.write(123);
                this.b = true;
            } else {
                super.write(i);
            }
        }
    }

    @Override // android.util.Base64OutputStream, java.io.FilterOutputStream, java.io.OutputStream
    public void write(byte[] bArr, int i, int i2) throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLII(Constants.METHOD_SEND_USER_MSG, this, bArr, i, i2) == null) {
            if (this.a && !this.b && i2 > 0 && bArr.length - i > 0) {
                bArr[i] = 123;
                this.b = true;
            } else if (!this.a && i2 == 1 && bArr.length - i > 0) {
                bArr[i] = 117;
                this.a = true;
            } else if (!this.a && i2 > 1 && bArr.length - i > 1) {
                bArr[i] = 117;
                this.a = true;
                bArr[i + 1] = 123;
                this.b = true;
            }
            if (i2 > 0) {
                this.c += i2;
            }
            super.write(bArr, i, i2);
        }
    }
}
