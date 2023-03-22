package com.baidu.tieba;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public class n4a implements u4a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public a4a a;
    public int b;
    public int c;
    public boolean d;

    public n4a() {
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

    @Override // com.baidu.tieba.u4a
    public int a(byte[] bArr, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048576, this, bArr, i)) == null) {
            a4a a4aVar = this.a;
            if (a4aVar == null || bArr == null) {
                return 0;
            }
            this.b += bArr.length;
            a4aVar.putBytes(bArr, i);
            return this.b;
        }
        return invokeLI.intValue;
    }

    @Override // com.baidu.tieba.u4a
    public boolean a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? b() && this.d && this.a.available() : invokeV.booleanValue;
    }

    @Override // com.baidu.tieba.u4a
    public boolean a(int i, int i2, int i3, int i4) {
        InterceptResult invokeIIII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIIII = interceptable.invokeIIII(Constants.METHOD_SEND_USER_MSG, this, i, i2, i3, i4)) == null) {
            if (this.a == null) {
                this.a = (a4a) c8a.a("com.baidu.ugc.audioedit.AudioChangeOperator");
            }
            a4a a4aVar = this.a;
            if (a4aVar != null) {
                a4aVar.initVoiceChanger(i, i2, i3, i4);
            }
            return this.a != null;
        }
        return invokeIIII.booleanValue;
    }

    @Override // com.baidu.tieba.u4a
    public byte[] a(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048579, this, i)) == null) {
            a4a a4aVar = this.a;
            if (a4aVar == null || a4aVar.availableBytes() <= 0) {
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
        a4a a4aVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048580, this, iArr) == null) || (a4aVar = this.a) == null) {
            return;
        }
        a4aVar.setVoiceChangeType(iArr);
    }

    @Override // com.baidu.tieba.u4a
    public boolean b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.a != null : invokeV.booleanValue;
    }

    @Override // com.baidu.tieba.u4a
    public void c() {
        a4a a4aVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048582, this) == null) || (a4aVar = this.a) == null) {
            return;
        }
        a4aVar.flush();
    }

    public void c(int[] iArr, int[] iArr2, double[] dArr) {
        a4a a4aVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLL(1048583, this, iArr, iArr2, dArr) == null) || (a4aVar = this.a) == null) {
            return;
        }
        a4aVar.setVoiceChangeType(iArr, iArr2, dArr);
    }

    @Override // com.baidu.tieba.u4a
    public void d() {
        a4a a4aVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) || (a4aVar = this.a) == null) {
            return;
        }
        a4aVar.close();
        this.a = null;
    }

    @Override // com.baidu.tieba.u4a
    public void e() {
        a4a a4aVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048585, this) == null) || (a4aVar = this.a) == null) {
            return;
        }
        a4aVar.clearQueues();
    }
}
