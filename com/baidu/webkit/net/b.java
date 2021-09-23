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
    public static final String f64247b = "b";
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public BdNetTask f64248a;

    /* renamed from: c  reason: collision with root package name */
    public BdNet f64249c;

    /* renamed from: d  reason: collision with root package name */
    public BdNetEngine f64250d;

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
        this.f64249c = bdNet;
    }

    public final void a(BdNetEngine bdNetEngine) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, bdNetEngine) == null) {
            this.f64250d = bdNetEngine;
            bdNetEngine.setEventListener(this.f64249c);
        }
    }

    public final boolean a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f64248a != null : invokeV.booleanValue;
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
                this.f64248a = bdNetTask;
                bdNetTask.setNet(this.f64249c);
                this.f64248a.setWorker(this);
                if (a.a().f64246c == null) {
                    a.a().f64246c = this.f64249c.getContext();
                }
                BdNetEngine e2 = a.a().e();
                this.f64250d = e2;
                if (e2 != null) {
                    e2.setEventListener(this.f64249c);
                    a.a();
                    if (!a.b()) {
                        bdNetEngine = this.f64250d;
                        bdNetTask2 = this.f64248a;
                    } else if (!this.f64248a.isHigherPriority()) {
                        return true;
                    } else {
                        bdNetEngine = this.f64250d;
                        bdNetTask2 = this.f64248a;
                    }
                    bdNetEngine.startDownload(bdNetTask2);
                    return true;
                }
                a.a();
                if (!a.b() || this.f64248a.isHigherPriority()) {
                    BdNetTask bdNetTask3 = this.f64248a;
                    if (bdNetTask3.getTaskPriority() == null) {
                        a2 = a.a();
                        ordinal = BdNetTask.b.f64236b.ordinal();
                    } else {
                        a2 = a.a();
                        ordinal = bdNetTask3.getTaskPriority().ordinal();
                    }
                    a2.a(bdNetTask3, ordinal);
                    return true;
                }
                return true;
            } catch (Exception unused) {
                BdNetEngine bdNetEngine2 = this.f64250d;
                if (bdNetEngine2 != null) {
                    bdNetEngine2.recycle();
                }
                BdNet bdNet = this.f64249c;
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
                if (this.f64248a != null) {
                    this.f64248a.setWorker(null);
                    this.f64248a.stop();
                    this.f64248a = null;
                }
            } catch (Exception e2) {
                Log.d(f64247b, "stop Exception", e2);
            }
        }
    }
}
