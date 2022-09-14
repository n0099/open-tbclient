package com.baidu.tieba;

import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.util.PriorityOrganizer;
import com.baidu.tieba.frs.FrsActivity;
import com.baidu.tieba.frs.FrsFragment;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import tbclient.FrsTabInfo;
/* loaded from: classes6.dex */
public class yp6 extends PriorityOrganizer.Task {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public FrsFragment m;
    public FrsActivity n;

    public yp6(FrsActivity frsActivity, FrsFragment frsFragment) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {frsActivity, frsFragment};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.n = frsActivity;
        this.m = frsFragment;
    }

    @Override // com.baidu.tbadk.util.PriorityOrganizer.Task
    public void A() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            u();
        }
    }

    @Override // com.baidu.tbadk.util.PriorityOrganizer.Task
    public boolean v() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            FrsFragment frsFragment = this.m;
            return (frsFragment == null || frsFragment.u3() || TbSingleton.getInstance().getFrsResponseData() == null) ? false : true;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tbadk.util.PriorityOrganizer.Task
    public boolean x() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            kl8 frsResponseData = TbSingleton.getInstance().getFrsResponseData();
            boolean z = true;
            if (frsResponseData != null && frsResponseData.getEntelechyTabInfo() != null && frsResponseData.getEntelechyTabInfo().a != null) {
                for (FrsTabInfo frsTabInfo : frsResponseData.getEntelechyTabInfo().a) {
                    if (frsTabInfo.tab_id.intValue() == 502 && bx4.k().h("first_into_tab_profession", true)) {
                        return false;
                    }
                }
            }
            z = (frsResponseData == null || frsResponseData.getBusinessPromot() == null || StringUtils.isNull(frsResponseData.getBusinessPromot().q()) || frsResponseData.getForum() == null) ? false : false;
            if (z) {
                boolean j = qs6.j(frsResponseData.getBusinessPromot(), frsResponseData.getForum().getId());
                this.m.v4(j);
                this.m.z4(j);
                return j;
            }
            return z;
        }
        return invokeV.booleanValue;
    }
}
