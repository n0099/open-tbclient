package com.baidu.tieba;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes9.dex */
public class zcb implements gdb {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public mcb a;
    public int b;
    public int c;
    public boolean d;

    public zcb() {
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
        this.d = true;
    }

    @Override // com.baidu.tieba.gdb
    public int a(byte[] bArr, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048576, this, bArr, i)) == null) {
            mcb mcbVar = this.a;
            if (mcbVar == null || bArr == null) {
                return 0;
            }
            this.b += bArr.length;
            mcbVar.putBytes(bArr, i);
            return this.b;
        }
        return invokeLI.intValue;
    }

    @Override // com.baidu.tieba.gdb
    public boolean a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? b() && this.d && this.a.available() : invokeV.booleanValue;
    }

    @Override // com.baidu.tieba.gdb
    public boolean a(int i, int i2, int i3, int i4) {
        InterceptResult invokeIIII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIIII = interceptable.invokeIIII(Constants.METHOD_SEND_USER_MSG, this, i, i2, i3, i4)) == null) {
            if (this.a == null) {
                this.a = (mcb) ogb.a("com.baidu.ugc.audioedit.AudioChangeOperator");
            }
            mcb mcbVar = this.a;
            if (mcbVar != null) {
                mcbVar.initVoiceChanger(i, i2, i3, i4);
            }
            return this.a != null;
        }
        return invokeIIII.booleanValue;
    }

    @Override // com.baidu.tieba.gdb
    public byte[] a(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048579, this, i)) == null) {
            mcb mcbVar = this.a;
            if (mcbVar == null || mcbVar.availableBytes() <= 0) {
                return new byte[0];
            }
            byte[] bArr = new byte[4096];
            int bytes = this.a.getBytes(bArr, 4096);
            this.c += bytes;
            if (bytes == 0) {
                return null;
            }
            if (4096 == bytes) {
                return bArr;
            }
            byte[] bArr2 = new byte[bytes];
            System.arraycopy(bArr, 0, bArr2, 0, bytes);
            return bArr2;
        }
        return (byte[]) invokeI.objValue;
    }

    public void b(int[] iArr) {
        mcb mcbVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048580, this, iArr) == null) || (mcbVar = this.a) == null) {
            return;
        }
        mcbVar.setVoiceChangeType(iArr);
    }

    @Override // com.baidu.tieba.gdb
    public boolean b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.a != null : invokeV.booleanValue;
    }

    @Override // com.baidu.tieba.gdb
    public void c() {
        mcb mcbVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048582, this) == null) || (mcbVar = this.a) == null) {
            return;
        }
        mcbVar.flush();
    }

    public void c(int[] iArr, int[] iArr2, double[] dArr) {
        mcb mcbVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLL(1048583, this, iArr, iArr2, dArr) == null) || (mcbVar = this.a) == null) {
            return;
        }
        mcbVar.setVoiceChangeType(iArr, iArr2, dArr);
    }

    @Override // com.baidu.tieba.gdb
    public void d() {
        mcb mcbVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) || (mcbVar = this.a) == null) {
            return;
        }
        mcbVar.close();
        this.a = null;
    }

    @Override // com.baidu.tieba.gdb
    public void e() {
        mcb mcbVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048585, this) == null) || (mcbVar = this.a) == null) {
            return;
        }
        mcbVar.clearQueues();
    }
}
