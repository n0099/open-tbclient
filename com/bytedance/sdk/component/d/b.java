package com.bytedance.sdk.component.d;

import android.os.SystemClock;
import com.baidu.android.common.others.lang.StringUtil;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.bytedance.sdk.component.utils.k;
/* loaded from: classes9.dex */
public class b implements Comparable, Runnable {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public g f64869a;

    /* renamed from: b  reason: collision with root package name */
    public a f64870b;

    /* renamed from: c  reason: collision with root package name */
    public long f64871c;

    /* renamed from: d  reason: collision with root package name */
    public Thread f64872d;

    public b(g gVar, a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {gVar, aVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f64869a = null;
        this.f64870b = null;
        this.f64871c = 0L;
        this.f64872d = null;
        this.f64869a = gVar;
        this.f64870b = aVar;
        this.f64871c = SystemClock.uptimeMillis();
    }

    public g a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f64869a : (g) invokeV.objValue;
    }

    @Override // java.lang.Comparable
    public int compareTo(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, obj)) == null) {
            if (obj instanceof b) {
                return this.f64869a.compareTo(((b) obj).a());
            }
            return 0;
        }
        return invokeL.intValue;
    }

    public boolean equals(Object obj) {
        InterceptResult invokeL;
        g gVar;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, obj)) == null) ? (obj instanceof b) && (gVar = this.f64869a) != null && gVar.equals(((b) obj).a()) : invokeL.booleanValue;
    }

    public int hashCode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f64869a.hashCode() : invokeV.intValue;
    }

    @Override // java.lang.Runnable
    public void run() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            long uptimeMillis = SystemClock.uptimeMillis();
            long j2 = uptimeMillis - this.f64871c;
            this.f64872d = Thread.currentThread();
            g gVar = this.f64869a;
            if (gVar != null) {
                gVar.run();
            }
            long uptimeMillis2 = SystemClock.uptimeMillis() - uptimeMillis;
            a aVar = this.f64870b;
            if (aVar != null) {
                d.a(aVar, j2, uptimeMillis2);
            }
            Object[] objArr = new Object[8];
            objArr[0] = "run: pool  = ";
            a aVar2 = this.f64870b;
            String str = StringUtil.NULL_STRING;
            objArr[1] = aVar2 != null ? aVar2.a() : StringUtil.NULL_STRING;
            objArr[2] = " waitTime =";
            objArr[3] = Long.valueOf(j2);
            objArr[4] = " taskCost = ";
            objArr[5] = Long.valueOf(uptimeMillis2);
            objArr[6] = " name=";
            g gVar2 = this.f64869a;
            if (gVar2 != null) {
                str = gVar2.b();
            }
            objArr[7] = str;
            k.b("DelegateRunnable", objArr);
        }
    }
}
