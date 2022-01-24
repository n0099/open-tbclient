package com.baidu.webkit.net;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.webkit.net.BdNetTask;
import com.baidu.webkit.sdk.Log;
/* loaded from: classes2.dex */
public class b {
    public static /* synthetic */ Interceptable $ic = null;

    /* renamed from: b  reason: collision with root package name */
    public static final String f52915b = "b";
    public transient /* synthetic */ FieldHolder $fh;
    public BdNetTask a;

    /* renamed from: c  reason: collision with root package name */
    public BdNet f52916c;

    /* renamed from: d  reason: collision with root package name */
    public BdNetEngine f52917d;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(129199402, "Lcom/baidu/webkit/net/b;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(129199402, "Lcom/baidu/webkit/net/b;");
        }
    }

    public b(BdNet bdNet) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {bdNet};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f52916c = bdNet;
    }

    public final void a(BdNetEngine bdNetEngine) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, bdNetEngine) == null) {
            this.f52917d = bdNetEngine;
            bdNetEngine.setEventListener(this.f52916c);
        }
    }

    public final boolean a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.a != null : invokeV.booleanValue;
    }

    public final boolean a(BdNetTask bdNetTask) {
        InterceptResult invokeL;
        a a;
        int ordinal;
        BdNetEngine bdNetEngine;
        BdNetTask bdNetTask2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, bdNetTask)) == null) {
            if (bdNetTask == null) {
                return false;
            }
            try {
                this.a = bdNetTask;
                bdNetTask.setNet(this.f52916c);
                this.a.setWorker(this);
                if (a.a().f52914c == null) {
                    a.a().f52914c = this.f52916c.getContext();
                }
                BdNetEngine e2 = a.a().e();
                this.f52917d = e2;
                if (e2 != null) {
                    e2.setEventListener(this.f52916c);
                    a.a();
                    if (!a.b()) {
                        bdNetEngine = this.f52917d;
                        bdNetTask2 = this.a;
                    } else if (!this.a.isHigherPriority()) {
                        return true;
                    } else {
                        bdNetEngine = this.f52917d;
                        bdNetTask2 = this.a;
                    }
                    bdNetEngine.startDownload(bdNetTask2);
                    return true;
                }
                a.a();
                if (!a.b() || this.a.isHigherPriority()) {
                    BdNetTask bdNetTask3 = this.a;
                    if (bdNetTask3.getTaskPriority() == null) {
                        a = a.a();
                        ordinal = BdNetTask.b.f52905b.ordinal();
                    } else {
                        a = a.a();
                        ordinal = bdNetTask3.getTaskPriority().ordinal();
                    }
                    a.a(bdNetTask3, ordinal);
                    return true;
                }
                return true;
            } catch (Exception unused) {
                BdNetEngine bdNetEngine2 = this.f52917d;
                if (bdNetEngine2 != null) {
                    bdNetEngine2.recycle();
                }
                BdNet bdNet = this.f52916c;
                if (bdNet != null) {
                    bdNet.startError(bdNetTask);
                }
                return false;
            }
        }
        return invokeL.booleanValue;
    }

    public final void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            try {
                if (this.a != null) {
                    this.a.setWorker(null);
                    this.a.stop();
                    this.a = null;
                }
            } catch (Exception e2) {
                Log.d(f52915b, "stop Exception", e2);
            }
        }
    }
}
