package com.baidu.tieba;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public class m4a implements u4a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public z3a a;
    public float b;
    public boolean c;

    public m4a() {
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

    @Override // com.baidu.tieba.u4a
    public int a(byte[] bArr, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048576, this, bArr, i)) == null) {
            z3a z3aVar = this.a;
            if (z3aVar == null || !z3aVar.putBytes(bArr, i)) {
                return 0;
            }
            return i;
        }
        return invokeLI.intValue;
    }

    @Override // com.baidu.tieba.u4a
    public boolean a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? b() && this.c && this.b != 1.0f : invokeV.booleanValue;
    }

    @Override // com.baidu.tieba.u4a
    public boolean a(int i, int i2, int i3, int i4) {
        InterceptResult invokeIIII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIIII = interceptable.invokeIIII(Constants.METHOD_SEND_USER_MSG, this, i, i2, i3, i4)) == null) {
            if (this.a == null) {
                this.a = (z3a) c8a.a("com.baidu.ugc.audioedit.AudioSpeedOperator");
            }
            z3a z3aVar = this.a;
            if (z3aVar != null) {
                z3aVar.init(i3, i2);
                this.a.setSpeed(1.0f);
                return false;
            }
            return false;
        }
        return invokeIIII.booleanValue;
    }

    @Override // com.baidu.tieba.u4a
    public byte[] a(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048579, this, i)) == null) {
            z3a z3aVar = this.a;
            return z3aVar != null ? z3aVar.getOutPutBytes() : new byte[0];
        }
        return (byte[]) invokeI.objValue;
    }

    public void b(float f) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(1048580, this, f) == null) {
            this.b = f;
            z3a z3aVar = this.a;
            if (z3aVar != null) {
                z3aVar.setSpeed(f);
            }
        }
    }

    @Override // com.baidu.tieba.u4a
    public boolean b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.a != null : invokeV.booleanValue;
    }

    @Override // com.baidu.tieba.u4a
    public void c() {
        z3a z3aVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048582, this) == null) || (z3aVar = this.a) == null) {
            return;
        }
        z3aVar.flush();
    }

    @Override // com.baidu.tieba.u4a
    public void d() {
        z3a z3aVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048583, this) == null) || (z3aVar = this.a) == null) {
            return;
        }
        z3aVar.close();
        this.a = null;
    }

    @Override // com.baidu.tieba.u4a
    public void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
        }
    }
}
