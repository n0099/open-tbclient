package com.baidu.tieba;

import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.abtest.UbsABTestDataManager;
import com.baidu.tbadk.mutiprocess.sync.SyncDataEvent;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public class wa5 implements u95<SyncDataEvent> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public wa5() {
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

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.u95
    /* renamed from: a */
    public boolean onEvent(SyncDataEvent syncDataEvent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, syncDataEvent)) == null) {
            if (syncDataEvent == null) {
                return false;
            }
            TbSingleton.getInstance().setSampleId(syncDataEvent.sampleId);
            dg5.d().f(syncDataEvent.abtestExtraData);
            UbsABTestDataManager.getInstance().parseJSONArrayByStr(syncDataEvent.ubsABTest);
            TbSingleton.getInstance().setUserGrowthTaskListData(syncDataEvent.userGrowthTaskListData);
            return true;
        }
        return invokeL.booleanValue;
    }
}
