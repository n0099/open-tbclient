package com.baidu.tieba;

import android.text.TextUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
/* loaded from: classes6.dex */
public class vi2 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile vi2 b;
    public transient /* synthetic */ FieldHolder $fh;
    public Map<String, pk2> a;

    public vi2() {
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
        this.a = new HashMap();
    }

    public static vi2 a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            if (b == null) {
                synchronized (vi2.class) {
                    if (b == null) {
                        b = new vi2();
                    }
                }
            }
            return b;
        }
        return (vi2) invokeV.objValue;
    }

    public static void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65538, null) == null) {
            if (b != null) {
                b.b();
            }
            b = null;
        }
    }

    public final synchronized void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            synchronized (this) {
                e12.i("RtcRoomWidgetManager", "release");
                Iterator it = new ArrayList(this.a.values()).iterator();
                while (it.hasNext()) {
                    ((pk2) it.next()).onRelease();
                }
                this.a.clear();
            }
        }
    }

    public synchronized void c(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) {
            synchronized (this) {
                e12.i("RtcRoomWidgetManager", "onWebViewDetach slaveId=" + str);
                Iterator it = new ArrayList(this.a.values()).iterator();
                while (it.hasNext()) {
                    pk2 pk2Var = (pk2) it.next();
                    if (TextUtils.equals(pk2Var.b(), str)) {
                        pk2Var.onRelease();
                    }
                }
            }
        }
    }
}
