package com.baidu.tieba;

import android.text.TextUtils;
import com.baidu.adp.base.BdActivityStack;
import com.baidu.adp.lib.featureSwitch.SwitchManager;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.abtest.UbsABTestDataManager;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.mutiprocess.sync.SyncDataEvent;
import com.baidu.tbadk.switchs.PraiseSwitch;
import com.baidu.tbadk.switchs.WindowGreySwitch;
import com.baidu.tieba.person.ProfileVirtualImageInfo;
import com.baidu.tieba.tbadkCore.util.AICapacityApplyHelper;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.HashMap;
/* loaded from: classes7.dex */
public class pq5 implements lp5<SyncDataEvent> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public pq5() {
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
    @Override // com.baidu.tieba.lp5
    /* renamed from: a */
    public boolean onEvent(SyncDataEvent syncDataEvent) {
        InterceptResult invokeL;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, syncDataEvent)) == null) {
            boolean z2 = false;
            if (syncDataEvent == null) {
                return false;
            }
            HashMap<String, Integer> hashMap = syncDataEvent.switches;
            if (hashMap != null && hashMap.size() > 0) {
                SwitchManager.getInstance().refreshSwitchManager(syncDataEvent.switches);
            }
            TbSingleton.getInstance().setSampleId(syncDataEvent.sampleId);
            kv5.d().f(syncDataEvent.abtestExtraData);
            UbsABTestDataManager.getInstance().parseJSONArrayByStr(syncDataEvent.ubsABTest);
            TbSingleton.getInstance().setUserGrowthTaskListData(syncDataEvent.userGrowthTaskListData);
            ProfileVirtualImageInfo.getInstance().parseRemoteInfo(syncDataEvent.profileVirtualImageInfo);
            BdActivityStack inst = BdActivityStack.getInst();
            if (syncDataEvent.themeIsBlack == 1) {
                z = true;
            } else {
                z = false;
            }
            inst.setActivityIsGrey(z);
            WindowGreySwitch.setNewValue(syncDataEvent.themeIsBlack);
            SwitchManager.getInstance().turn(PraiseSwitch.KEY, syncDataEvent.praiseSwitch);
            AICapacityApplyHelper c = AICapacityApplyHelper.c();
            if (syncDataEvent.aiAvailableStatus == 1) {
                z2 = true;
            }
            c.g(z2);
            if (!TextUtils.isEmpty(syncDataEvent.aiWriteScheme)) {
                AICapacityApplyHelper.c().h(syncDataEvent.aiWriteScheme);
            }
            if (TbadkCoreApplication.getInst().isRemoteProcess()) {
                jt4.w().J();
            }
            return true;
        }
        return invokeL.booleanValue;
    }
}
