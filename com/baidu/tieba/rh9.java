package com.baidu.tieba;

import android.app.Activity;
import android.text.TextUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.dialog.yun.YunDialogManager;
import com.baidu.tbadk.core.log.YunDialogLog;
import com.baidu.tbadk.core.sharedPref.SharedPrefHelper;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.data.DialogStrategiesData;
import com.baidu.tieba.pb.bot.BotEntranceManager;
import com.baidu.tieba.pb.pb.main.PbActivity;
import com.baidu.tieba.pb.pb.main.PbModel;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import tbclient.RobotEntrance;
import tbclient.RobotSkill;
import tbclient.RobotSkillInfo;
/* loaded from: classes7.dex */
public final class rh9 implements t65 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(1948121766, "Lcom/baidu/tieba/rh9;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(1948121766, "Lcom/baidu/tieba/rh9;");
        }
    }

    public rh9() {
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

    @Override // com.baidu.tieba.t65
    public Map<String, Object> a(DialogStrategiesData dialogData, Map<String, ? extends Object> strategyData, Map<String, ? extends Object> extraData) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048576, this, dialogData, strategyData, extraData)) == null) {
            Intrinsics.checkNotNullParameter(dialogData, "dialogData");
            Intrinsics.checkNotNullParameter(strategyData, "strategyData");
            Intrinsics.checkNotNullParameter(extraData, "extraData");
            HashMap hashMap = new HashMap(strategyData);
            hashMap.put("dialogName", "pbFriendBotBottomNewSkill");
            hashMap.putAll(strategyData);
            hashMap.putAll(extraData);
            return hashMap;
        }
        return (Map) invokeLLL.objValue;
    }

    @Override // com.baidu.tieba.t65
    public boolean b(Map<String, ? extends Object> map) {
        InterceptResult invokeL;
        List<RobotSkillInfo> list;
        List<RobotSkill> list2;
        aj9 r1;
        aj9 r12;
        RobotEntrance K;
        aj9 r13;
        RobotEntrance K2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, map)) == null) {
            Intrinsics.checkNotNullParameter(map, "map");
            Activity currentActivity = TbadkCoreApplication.getInst().getCurrentActivity();
            if (!(currentActivity instanceof PbActivity)) {
                YunDialogLog.getInstance().e(YunDialogManager.LOG_KEY, "pb好朋友bot底部新人设上线引导策略校验失败：当前Activity非PbActivity");
                return false;
            }
            PbActivity pbActivity = (PbActivity) currentActivity;
            PbModel J1 = pbActivity.J1();
            RobotEntrance robotEntrance = null;
            if (J1 != null && (r13 = J1.r1()) != null && (K2 = r13.K()) != null) {
                list = K2.robot_skill_info;
            } else {
                list = null;
            }
            PbModel J12 = pbActivity.J1();
            if (J12 != null && (r12 = J12.r1()) != null && (K = r12.K()) != null) {
                list2 = K.bottom_bar_robot_skill;
            } else {
                list2 = null;
            }
            if (!ListUtils.isEmpty(list) && !ListUtils.isEmpty(list2)) {
                PbModel J13 = pbActivity.J1();
                if (J13 != null && (r1 = J13.r1()) != null) {
                    robotEntrance = r1.K();
                }
                if (robotEntrance == null) {
                    return false;
                }
                String string = SharedPrefHelper.getInstance().getString("pb_friend_bot_bottom_new_skill_text", "default");
                String j = BotEntranceManager.c.c().j(robotEntrance.robot_skill_info);
                if (!TextUtils.equals("default", string) && !TextUtils.isEmpty(j)) {
                    return !TextUtils.equals(string, j);
                }
                if (!TextUtils.equals(j, string)) {
                    SharedPrefHelper.getInstance().putString("pb_friend_bot_bottom_new_skill_text", j);
                }
                return false;
            }
            YunDialogLog.getInstance().e(YunDialogManager.LOG_KEY, "pb好朋友bot底部新人设上线引导此时没有数据");
            return false;
        }
        return invokeL.booleanValue;
    }
}
