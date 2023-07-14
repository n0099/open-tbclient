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
/* loaded from: classes6.dex */
public abstract class js5 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public List<hs5> eventDelegates;
    public boolean isDispatchMvcEventing;
    public BdUniqueId uniqueId;

    public void onBeforeDispatchMvcEvent(is5 is5Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, is5Var) == null) {
        }
    }

    public js5() {
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

    public void addEventDelegate(hs5 hs5Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, hs5Var) == null) {
            if (this.eventDelegates == null) {
                this.eventDelegates = new ArrayList();
            }
            if (this.eventDelegates.contains(hs5Var)) {
                return;
            }
            if (this.isDispatchMvcEventing && TbadkCoreApplication.getInst().isDebugMode()) {
                throw new RuntimeException("can not add event delegate on dispatch mvcevent");
            }
            this.eventDelegates.add(hs5Var);
        }
    }

    public void removeEventDelegate(hs5 hs5Var) {
        List<hs5> list;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048579, this, hs5Var) != null) || (list = this.eventDelegates) == null || !list.contains(hs5Var)) {
            return;
        }
        if (this.isDispatchMvcEventing && TbadkCoreApplication.getInst().isDebugMode()) {
            throw new RuntimeException("can not add event delegate on dispatch mvcevent");
        }
        this.eventDelegates.remove(hs5Var);
    }

    public boolean dispatchMvcEvent(is5 is5Var) {
        InterceptResult invokeL;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, is5Var)) == null) {
            if (is5Var == null) {
                return false;
            }
            if (is5Var.e() == null) {
                is5Var.i(this.uniqueId);
            }
            if (this.eventDelegates == null) {
                return false;
            }
            try {
                this.isDispatchMvcEventing = true;
                onBeforeDispatchMvcEvent(is5Var);
                int size = this.eventDelegates.size();
                z = false;
                for (int i = 0; i < size; i++) {
                    try {
                        hs5 hs5Var = this.eventDelegates.get(i);
                        if (hs5Var != null && ((!hs5Var.g1() || (hs5Var.g1() && is5Var.e() == hs5Var.getUniqueId())) && (z = hs5Var.D0(is5Var)) && is5Var.f())) {
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
