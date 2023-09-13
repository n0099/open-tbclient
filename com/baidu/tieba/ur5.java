package com.baidu.tieba;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes8.dex */
public abstract class ur5 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public List<sr5> eventDelegates;
    public boolean isDispatchMvcEventing;
    public BdUniqueId uniqueId;

    public void onBeforeDispatchMvcEvent(tr5 tr5Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, tr5Var) == null) {
        }
    }

    public ur5() {
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
        this.isDispatchMvcEventing = false;
    }

    public void addEventDelegate(sr5 sr5Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, sr5Var) == null) {
            if (this.eventDelegates == null) {
                this.eventDelegates = new ArrayList();
            }
            if (this.eventDelegates.contains(sr5Var)) {
                return;
            }
            if (this.isDispatchMvcEventing && TbadkCoreApplication.getInst().isDebugMode()) {
                throw new RuntimeException("can not add event delegate on dispatch mvcevent");
            }
            this.eventDelegates.add(sr5Var);
        }
    }

    public void removeEventDelegate(sr5 sr5Var) {
        List<sr5> list;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048579, this, sr5Var) != null) || (list = this.eventDelegates) == null || !list.contains(sr5Var)) {
            return;
        }
        if (this.isDispatchMvcEventing && TbadkCoreApplication.getInst().isDebugMode()) {
            throw new RuntimeException("can not add event delegate on dispatch mvcevent");
        }
        this.eventDelegates.remove(sr5Var);
    }

    public boolean dispatchMvcEvent(tr5 tr5Var) {
        InterceptResult invokeL;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, tr5Var)) == null) {
            if (tr5Var == null) {
                return false;
            }
            if (tr5Var.e() == null) {
                tr5Var.i(this.uniqueId);
            }
            if (this.eventDelegates == null) {
                return false;
            }
            try {
                this.isDispatchMvcEventing = true;
                onBeforeDispatchMvcEvent(tr5Var);
                int size = this.eventDelegates.size();
                z = false;
                for (int i = 0; i < size; i++) {
                    try {
                        sr5 sr5Var = this.eventDelegates.get(i);
                        if (sr5Var != null && ((!sr5Var.s1() || (sr5Var.s1() && tr5Var.e() == sr5Var.getUniqueId())) && (z = sr5Var.N0(tr5Var)) && tr5Var.f())) {
                            return true;
                        }
                    } catch (Throwable th) {
                        th = th;
                        try {
                            BdLog.e(th);
                            if (TbadkCoreApplication.getInst().isDebugMode()) {
                                throw new RuntimeException(th);
                            }
                            this.isDispatchMvcEventing = false;
                            return z;
                        } finally {
                            this.isDispatchMvcEventing = false;
                        }
                    }
                }
            } catch (Throwable th2) {
                th = th2;
                z = false;
            }
            this.isDispatchMvcEventing = false;
            return z;
        }
        return invokeL.booleanValue;
    }
}
