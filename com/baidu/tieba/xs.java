package com.baidu.tieba;

import android.text.TextUtils;
import com.baidu.bdtask.framework.utils.DebugTrace;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.IOException;
/* loaded from: classes8.dex */
public abstract class xs {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean a;
    public int b;

    public abstract String a();

    public abstract void b(int i);

    public abstract void c(IOException iOException);

    public abstract void f(byte[] bArr);

    public xs() {
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
        this.a = false;
        this.b = 0;
    }

    public final void d(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, str) == null) {
            this.b = 0;
            vs.a().b(str, this);
        }
    }

    public void e(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048580, this, z) == null) {
            this.a = z;
        }
    }

    public final String g(byte[] bArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, bArr)) == null) {
            String str = new String(bArr);
            DebugTrace debugTrace = DebugTrace.a;
            debugTrace.a("processResponseData encodeResponseData=" + str);
            if (this.a) {
                qs b = zs.c().b(at.b().i(), bArr);
                DebugTrace debugTrace2 = DebugTrace.a;
                debugTrace2.a("processResponseData decodeResponseData=" + b);
                if (b != null) {
                    if (!TextUtils.isEmpty(b.a())) {
                        str = b.a();
                    }
                    this.b = b.d().intValue();
                } else {
                    this.b = -1;
                }
                at.b().i().b(this.b);
            }
            return str;
        }
        return (String) invokeL.objValue;
    }
}
