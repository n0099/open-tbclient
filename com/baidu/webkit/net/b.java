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
/* loaded from: classes9.dex */
public class b {
    public static /* synthetic */ Interceptable $ic = null;

    /* renamed from: b  reason: collision with root package name */
    public static final String f63756b = "b";
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public BdNetTask f63757a;

    /* renamed from: c  reason: collision with root package name */
    public BdNet f63758c;

    /* renamed from: d  reason: collision with root package name */
    public BdNetEngine f63759d;

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
        this.f63758c = bdNet;
    }

    public final void a(BdNetEngine bdNetEngine) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, bdNetEngine) == null) {
            this.f63759d = bdNetEngine;
            bdNetEngine.setEventListener(this.f63758c);
        }
    }

    public final boolean a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f63757a != null : invokeV.booleanValue;
    }

    public final boolean a(BdNetTask bdNetTask) {
        InterceptResult invokeL;
        a a2;
        int ordinal;
        BdNetEngine bdNetEngine;
        BdNetTask bdNetTask2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, bdNetTask)) == null) {
            if (bdNetTask == null) {
                return false;
            }
            try {
                this.f63757a = bdNetTask;
                bdNetTask.setNet(this.f63758c);
                this.f63757a.setWorker(this);
                if (a.a().f63755c == null) {
                    a.a().f63755c = this.f63758c.getContext();
                }
                BdNetEngine e2 = a.a().e();
                this.f63759d = e2;
                if (e2 != null) {
                    e2.setEventListener(this.f63758c);
                    a.a();
                    if (!a.b()) {
                        bdNetEngine = this.f63759d;
                        bdNetTask2 = this.f63757a;
                    } else if (!this.f63757a.isHigherPriority()) {
                        return true;
                    } else {
                        bdNetEngine = this.f63759d;
                        bdNetTask2 = this.f63757a;
                    }
                    bdNetEngine.startDownload(bdNetTask2);
                    return true;
                }
                a.a();
                if (!a.b() || this.f63757a.isHigherPriority()) {
                    BdNetTask bdNetTask3 = this.f63757a;
                    if (bdNetTask3.getTaskPriority() == null) {
                        a2 = a.a();
                        ordinal = BdNetTask.b.f63745b.ordinal();
                    } else {
                        a2 = a.a();
                        ordinal = bdNetTask3.getTaskPriority().ordinal();
                    }
                    a2.a(bdNetTask3, ordinal);
                    return true;
                }
                return true;
            } catch (Exception unused) {
                BdNetEngine bdNetEngine2 = this.f63759d;
                if (bdNetEngine2 != null) {
                    bdNetEngine2.recycle();
                }
                BdNet bdNet = this.f63758c;
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
                if (this.f63757a != null) {
                    this.f63757a.setWorker(null);
                    this.f63757a.stop();
                    this.f63757a = null;
                }
            } catch (Exception e2) {
                Log.d(f63756b, "stop Exception", e2);
            }
        }
    }
}
