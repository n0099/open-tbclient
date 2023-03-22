package com.baidu.tieba;

import com.baidu.adp.lib.featureSwitch.SwitchManager;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.abtest.UbsABTestDataManager;
import com.baidu.tbadk.mutiprocess.sync.SyncDataEvent;
import com.baidu.tbadk.switchs.PraiseSwitch;
import com.baidu.tbadk.switchs.WindowGreySwitch;
import com.baidu.tieba.person.ProfileVirtualImageInfo;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public class ti5 implements ph5<SyncDataEvent> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public ti5() {
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
    @Override // com.baidu.tieba.ph5
    /* renamed from: a */
    public boolean onEvent(SyncDataEvent syncDataEvent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, syncDataEvent)) == null) {
            boolean z = false;
            if (syncDataEvent == null) {
                return false;
            }
            TbSingleton.getInstance().setSampleId(syncDataEvent.sampleId);
            do5.d().f(syncDataEvent.abtestExtraData);
            UbsABTestDataManager.getInstance().parseJSONArrayByStr(syncDataEvent.ubsABTest);
            TbSingleton.getInstance().setUserGrowthTaskListData(syncDataEvent.userGrowthTaskListData);
            ProfileVirtualImageInfo.getInstance().parseRemoteInfo(syncDataEvent.profileVirtualImageInfo);
            w8 f = w8.f();
            if (syncDataEvent.themeIsBlack == 1) {
                z = true;
            }
            f.q(z);
            WindowGreySwitch.setNewValue(syncDataEvent.themeIsBlack);
            SwitchManager.getInstance().turn(PraiseSwitch.KEY, syncDataEvent.praiseSwitch);
            return true;
        }
        return invokeL.booleanValue;
    }
}
