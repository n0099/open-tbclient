package com.baidu.tieba;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public class j6b implements r6b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public w5b a;
    public float b;
    public boolean c;

    public j6b() {
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
        this.b = 1.0f;
        this.c = true;
    }

    @Override // com.baidu.tieba.r6b
    public int a(byte[] bArr, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048576, this, bArr, i)) == null) {
            w5b w5bVar = this.a;
            if (w5bVar == null || !w5bVar.putBytes(bArr, i)) {
                return 0;
            }
            return i;
        }
        return invokeLI.intValue;
    }

    @Override // com.baidu.tieba.r6b
    public boolean a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? b() && this.c && this.b != 1.0f : invokeV.booleanValue;
    }

    @Override // com.baidu.tieba.r6b
    public boolean a(int i, int i2, int i3, int i4) {
        InterceptResult invokeIIII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIIII = interceptable.invokeIIII(Constants.METHOD_SEND_USER_MSG, this, i, i2, i3, i4)) == null) {
            if (this.a == null) {
                this.a = (w5b) z9b.a("com.baidu.ugc.audioedit.AudioSpeedOperator");
            }
            w5b w5bVar = this.a;
            if (w5bVar != null) {
                w5bVar.init(i3, i2);
                this.a.setSpeed(1.0f);
                return false;
            }
            return false;
        }
        return invokeIIII.booleanValue;
    }

    @Override // com.baidu.tieba.r6b
    public byte[] a(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048579, this, i)) == null) {
            w5b w5bVar = this.a;
            return w5bVar != null ? w5bVar.getOutPutBytes() : new byte[0];
        }
        return (byte[]) invokeI.objValue;
    }

    public void b(float f) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(1048580, this, f) == null) {
            this.b = f;
            w5b w5bVar = this.a;
            if (w5bVar != null) {
                w5bVar.setSpeed(f);
            }
        }
    }

    @Override // com.baidu.tieba.r6b
    public boolean b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.a != null : invokeV.booleanValue;
    }

    @Override // com.baidu.tieba.r6b
    public void c() {
        w5b w5bVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048582, this) == null) || (w5bVar = this.a) == null) {
            return;
        }
        w5bVar.flush();
    }

    @Override // com.baidu.tieba.r6b
    public void d() {
        w5b w5bVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048583, this) == null) || (w5bVar = this.a) == null) {
            return;
        }
        w5bVar.close();
        this.a = null;
    }

    @Override // com.baidu.tieba.r6b
    public void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
        }
    }
}
