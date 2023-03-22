package com.baidu.tieba;

import android.annotation.SuppressLint;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.retrieve.inter.constants.StatConstants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
/* loaded from: classes5.dex */
public final class o94 extends Thread {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public u94 a;
    public volatile boolean b;

    @SuppressLint({"MobilebdThread"})
    public o94() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    public final boolean a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return this.b;
        }
        return invokeV.booleanValue;
    }

    public final void b(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z) == null) {
            this.b = z;
        }
    }

    public final void c(u94 u94Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, u94Var) == null) {
            this.a = u94Var;
        }
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        DatagramSocket C;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            while (this.b) {
                try {
                    DatagramPacket datagramPacket = new DatagramPacket(new byte[4096], 4096);
                    u94 u94Var = this.a;
                    if (u94Var != null && (C = u94Var.C()) != null) {
                        C.receive(datagramPacket);
                    }
                    u94 u94Var2 = this.a;
                    if (u94Var2 != null) {
                        u94Var2.z(datagramPacket);
                    }
                } catch (InterruptedException unused) {
                    return;
                } catch (Throwable unused2) {
                    u94 u94Var3 = this.a;
                    if (u94Var3 != null) {
                        u94Var3.D(StatConstants.VALUE_TYPE_RECEIVE, "receive failed");
                    }
                }
            }
        }
    }
}
