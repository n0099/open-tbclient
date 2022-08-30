package com.baidu.tieba;

import android.content.Context;
import android.os.Build;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public class ug1 implements vg1 {
    public static /* synthetic */ Interceptable $ic;
    public static ug1 c;
    public transient /* synthetic */ FieldHolder $fh;
    public vg1 a;
    public boolean b;

    public ug1() {
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
        this.a = null;
        this.b = false;
    }

    public static ug1 b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            if (c == null) {
                synchronized (ug1.class) {
                    if (c == null) {
                        c = new ug1();
                    }
                }
            }
            return c;
        }
        return (ug1) invokeV.objValue;
    }

    @Override // com.baidu.tieba.vg1
    public String a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            vg1 vg1Var = this.a;
            if (vg1Var == null) {
                return null;
            }
            try {
                return vg1Var.a();
            } catch (Throwable unused) {
                return null;
            }
        }
        return (String) invokeV.objValue;
    }

    /* JADX WARN: Removed duplicated region for block: B:25:0x0044 A[Catch: all -> 0x0049, TRY_LEAVE, TryCatch #0 {all -> 0x0049, blocks: (B:4:0x0004, B:7:0x0009, B:23:0x0040, B:25:0x0044, B:17:0x0024, B:18:0x0029, B:19:0x002c, B:20:0x0032, B:21:0x0038), top: B:31:0x0004 }] */
    /* JADX WARN: Removed duplicated region for block: B:33:? A[RETURN, SYNTHETIC] */
    @Override // com.baidu.tieba.vg1
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void a(Context context, wg1 wg1Var) {
        vg1 vg1Var;
        Interceptable interceptable = $ic;
        if (interceptable != null && interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context, wg1Var) != null) {
            return;
        }
        try {
            if (this.b) {
                return;
            }
            this.b = true;
            int ordinal = com.baidu.sso.s.a.a(Build.MANUFACTURER).ordinal();
            if (ordinal == 0) {
                vg1Var = null;
            } else if (ordinal == 1) {
                vg1Var = new yg1();
            } else if (ordinal == 2) {
                vg1Var = new gh1();
            } else if (ordinal == 3) {
                vg1Var = new eh1();
            } else if (ordinal != 4) {
                if (this.a == null) {
                    this.a.a(context, wg1Var);
                    return;
                }
                return;
            } else {
                vg1Var = new ah1();
            }
            this.a = vg1Var;
            if (this.a == null) {
            }
        } catch (Throwable unused) {
        }
    }
}
