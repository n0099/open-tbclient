package com.baidu.tieba.immessagecenter.msgtab.obs;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.r79;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\u000b\u001a\u00020\fH\u0016J\b\u0010\r\u001a\u00020\fH\u0016R!\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00010\u00048BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\u0005\u0010\u0006R\u000e\u0010\t\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u000e"}, d2 = {"Lcom/baidu/tieba/immessagecenter/msgtab/obs/ObserverRegistry;", "Lcom/baidu/tieba/immessagecenter/msgtab/obs/DataChangedMonitor;", "()V", "mMonitors", "", "getMMonitors", "()[Lcom/baidu/tieba/immessagecenter/msgtab/obs/DataChangedMonitor;", "mMonitors$delegate", "Lkotlin/Lazy;", "starting", "", "start", "", "stop", "imMessageCenter_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes6.dex */
public final class ObserverRegistry implements r79 {
    public static /* synthetic */ Interceptable $ic;
    public static final ObserverRegistry a;
    public static boolean b;
    public static final Lazy c;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1630635613, "Lcom/baidu/tieba/immessagecenter/msgtab/obs/ObserverRegistry;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1630635613, "Lcom/baidu/tieba/immessagecenter/msgtab/obs/ObserverRegistry;");
                return;
            }
        }
        a = new ObserverRegistry();
        c = LazyKt__LazyJVMKt.lazy(ObserverRegistry$mMonitors$2.INSTANCE);
    }

    public ObserverRegistry() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    public final r79[] a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return (r79[]) c.getValue();
        }
        return (r79[]) invokeV.objValue;
    }

    @Override // com.baidu.tieba.r79
    public void start() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) && !b) {
            b = true;
            for (r79 r79Var : a()) {
                r79Var.start();
            }
        }
    }
}
