package com.baidu.tieba;

import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.mutiprocess.mission.MissionEvent;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public class rj5 implements vi5<MissionEvent> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public rj5() {
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
    @Override // com.baidu.tieba.vi5
    /* renamed from: a */
    public boolean onEvent(MissionEvent missionEvent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, missionEvent)) == null) {
            if (!TbadkCoreApplication.getInst().isMainProcess(true)) {
                return false;
            }
            int i = missionEvent.pageId;
            int i2 = missionEvent.pageType;
            long j = missionEvent.tid;
            String str = missionEvent.actionType;
            if ("onResume".equals(str)) {
                aq4.w().L(i, j);
                aq4.w().Q(i2, j);
            } else if (MissionEvent.MESSAGE_PAUSE.equals(str)) {
                aq4.w().E();
            } else if (MissionEvent.MESSAGE_TOUCH.equals(str)) {
                aq4.w().F();
            } else if (MissionEvent.MESSAGE_ACTIVITY.equals(str)) {
                aq4.w().L(i, j);
            }
            return true;
        }
        return invokeL.booleanValue;
    }
}
