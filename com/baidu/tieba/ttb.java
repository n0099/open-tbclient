package com.baidu.tieba;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes8.dex */
public class ttb implements aub {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public gtb a;
    public int b;
    public int c;
    public boolean d;

    public ttb() {
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

    @Override // com.baidu.tieba.aub
    public int a(byte[] bArr, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048576, this, bArr, i)) == null) {
            gtb gtbVar = this.a;
            if (gtbVar == null || bArr == null) {
                return 0;
            }
            this.b += bArr.length;
            gtbVar.putBytes(bArr, i);
            return this.b;
        }
        return invokeLI.intValue;
    }

    @Override // com.baidu.tieba.aub
    public boolean a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? b() && this.d && this.a.available() : invokeV.booleanValue;
    }

    @Override // com.baidu.tieba.aub
    public boolean a(int i, int i2, int i3, int i4) {
        InterceptResult invokeIIII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIIII = interceptable.invokeIIII(Constants.METHOD_SEND_USER_MSG, this, i, i2, i3, i4)) == null) {
            if (this.a == null) {
                this.a = (gtb) ixb.a("com.baidu.ugc.audioedit.AudioChangeOperator");
            }
            gtb gtbVar = this.a;
            if (gtbVar != null) {
                gtbVar.initVoiceChanger(i, i2, i3, i4);
            }
            return this.a != null;
        }
        return invokeIIII.booleanValue;
    }

    @Override // com.baidu.tieba.aub
    public byte[] a(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048579, this, i)) == null) {
            gtb gtbVar = this.a;
            if (gtbVar == null || gtbVar.availableBytes() <= 0) {
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
        gtb gtbVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048580, this, iArr) == null) || (gtbVar = this.a) == null) {
            return;
        }
        gtbVar.setVoiceChangeType(iArr);
    }

    @Override // com.baidu.tieba.aub
    public boolean b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.a != null : invokeV.booleanValue;
    }

    @Override // com.baidu.tieba.aub
    public void c() {
        gtb gtbVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048582, this) == null) || (gtbVar = this.a) == null) {
            return;
        }
        gtbVar.flush();
    }

    public void c(int[] iArr, int[] iArr2, double[] dArr) {
        gtb gtbVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLL(1048583, this, iArr, iArr2, dArr) == null) || (gtbVar = this.a) == null) {
            return;
        }
        gtbVar.setVoiceChangeType(iArr, iArr2, dArr);
    }

    @Override // com.baidu.tieba.aub
    public void d() {
        gtb gtbVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) || (gtbVar = this.a) == null) {
            return;
        }
        gtbVar.close();
        this.a = null;
    }

    @Override // com.baidu.tieba.aub
    public void e() {
        gtb gtbVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048585, this) == null) || (gtbVar = this.a) == null) {
            return;
        }
        gtbVar.clearQueues();
    }
}
