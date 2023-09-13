package com.baidu.tieba;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.bdtask.component.buoy.TaskBuoyViewData;
import com.baidu.bdtask.component.buoy.TaskBuoyViewModel;
import com.baidu.bdtask.model.info.TaskInfo;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
/* loaded from: classes7.dex */
public final class mp {
    public static /* synthetic */ Interceptable $ic;
    public static final a a;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1448311402, "Lcom/baidu/tieba/mp;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1448311402, "Lcom/baidu/tieba/mp;");
                return;
            }
        }
        a = new a(null);
    }

    @JvmStatic
    public static final tp a(ps<TaskBuoyViewData, TaskBuoyViewModel> psVar, up upVar, TaskInfo taskInfo) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLLL = interceptable.invokeLLL(65537, null, psVar, upVar, taskInfo)) == null) ? a.a(psVar, upVar, taskInfo) : (tp) invokeLLL.objValue;
    }

    @JvmStatic
    public static final wp b(ps<TaskBuoyViewData, TaskBuoyViewModel> psVar, TaskBuoyViewModel taskBuoyViewModel, TaskInfo taskInfo) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLLL = interceptable.invokeLLL(65538, null, psVar, taskBuoyViewModel, taskInfo)) == null) ? a.b(psVar, taskBuoyViewModel, taskInfo) : (wp) invokeLLL.objValue;
    }

    /* loaded from: classes7.dex */
    public static final class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public a() {
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

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @JvmStatic
        public final tp a(ps<TaskBuoyViewData, TaskBuoyViewModel> psVar, up upVar, TaskInfo taskInfo) {
            InterceptResult invokeLLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048576, this, psVar, upVar, taskInfo)) == null) {
                return new tp(psVar, upVar, taskInfo);
            }
            return (tp) invokeLLL.objValue;
        }

        @JvmStatic
        public final wp b(ps<TaskBuoyViewData, TaskBuoyViewModel> psVar, TaskBuoyViewModel taskBuoyViewModel, TaskInfo taskInfo) {
            InterceptResult invokeLLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLLL = interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, psVar, taskBuoyViewModel, taskInfo)) == null) {
                return new wp(psVar, taskBuoyViewModel, taskInfo);
            }
            return (wp) invokeLLL.objValue;
        }
    }
}
