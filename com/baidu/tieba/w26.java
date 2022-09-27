package com.baidu.tieba;

import com.baidu.adp.BdUniqueId;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.data.ThreadData;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public class w26 extends x26 {
    public static /* synthetic */ Interceptable $ic;
    public static final BdUniqueId N0;
    public static final BdUniqueId O0;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948218734, "Lcom/baidu/tieba/w26;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948218734, "Lcom/baidu/tieba/w26;");
                return;
            }
        }
        N0 = BdUniqueId.gen();
        O0 = BdUniqueId.gen();
    }

    public w26(ThreadData threadData) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {threadData};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.a = threadData;
    }

    public static boolean W(ThreadData threadData) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, threadData)) == null) {
            if (threadData == null) {
                return false;
            }
            if (threadData.getThreadType() == 49 || threadData.getThreadType() == 69) {
                return true;
            }
            return threadData.getThreadType() == 67 && threadData.getThreadAlaInfo() != null && threadData.getThreadAlaInfo().friendRoomStatus == 2;
        }
        return invokeL.booleanValue;
    }

    public StatisticItem Z(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) {
            StatisticItem f = f(str);
            f.delete("obj_type");
            f.delete("obj_type");
            f.param("obj_type", 3);
            return f;
        }
        return (StatisticItem) invokeL.objValue;
    }

    @Override // com.baidu.tieba.x26, com.baidu.tieba.p26, com.baidu.tieba.yq4
    public ThreadData getThreadData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.a : (ThreadData) invokeV.objValue;
    }

    @Override // com.baidu.tieba.x26, com.baidu.tieba.card.data.BaseCardInfo, com.baidu.tieba.Cdo
    public BdUniqueId getType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            ThreadData threadData = this.a;
            if (threadData != null && threadData.getThreadType() == 67) {
                return O0;
            }
            return N0;
        }
        return (BdUniqueId) invokeV.objValue;
    }
}
