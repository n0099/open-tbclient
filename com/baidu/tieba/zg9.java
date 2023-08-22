package com.baidu.tieba;

import android.app.Activity;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.dialog.yun.YunDialogManager;
import com.baidu.tbadk.core.log.YunDialogLog;
import com.baidu.tbadk.core.sharedPref.SharedPrefHelper;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.TimeHelper;
import com.baidu.tbadk.data.DialogStrategiesData;
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
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import tbclient.RobotEntrance;
import tbclient.RobotSkill;
import tbclient.RobotSkillInfo;
/* loaded from: classes9.dex */
public final class zg9 implements l65 {
    public static /* synthetic */ Interceptable $ic;
    public static final a a;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948359133, "Lcom/baidu/tieba/zg9;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948359133, "Lcom/baidu/tieba/zg9;");
                return;
            }
        }
        a = new a(null);
    }

    @JvmStatic
    public static final void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65538, null) == null) {
            a.a();
        }
    }

    /* loaded from: classes9.dex */
    public static final class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

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

        @JvmStatic
        public final void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                SharedPrefHelper.getInstance().putLong("pb_friend_bot_bottom_no_use_time", System.currentTimeMillis());
            }
        }
    }

    public zg9() {
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

    @Override // com.baidu.tieba.l65
    public Map<String, Object> a(DialogStrategiesData dialogData, Map<String, ? extends Object> strategyData, Map<String, ? extends Object> extraData) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048576, this, dialogData, strategyData, extraData)) == null) {
            Intrinsics.checkNotNullParameter(dialogData, "dialogData");
            Intrinsics.checkNotNullParameter(strategyData, "strategyData");
            Intrinsics.checkNotNullParameter(extraData, "extraData");
            HashMap hashMap = new HashMap(strategyData);
            hashMap.put("dialogName", "pbFriendBotBottomNoUse");
            hashMap.putAll(strategyData);
            hashMap.putAll(extraData);
            return hashMap;
        }
        return (Map) invokeLLL.objValue;
    }

    @Override // com.baidu.tieba.l65
    public boolean b(Map<String, ? extends Object> map) {
        InterceptResult invokeL;
        List<RobotSkillInfo> list;
        yh9 s1;
        RobotEntrance K;
        yh9 s12;
        RobotEntrance K2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, map)) == null) {
            Intrinsics.checkNotNullParameter(map, "map");
            Activity currentActivity = TbadkCoreApplication.getInst().getCurrentActivity();
            if (!(currentActivity instanceof PbActivity)) {
                YunDialogLog.getInstance().e(YunDialogManager.LOG_KEY, "pb好朋友bot底部N天未点击引导策略校验失败：当前Activity非PbActivity");
                return false;
            }
            long j = SharedPrefHelper.getInstance().getLong("pb_friend_bot_bottom_no_use_time", -1L);
            if (j == -1) {
                a.a();
                return false;
            }
            PbActivity pbActivity = (PbActivity) currentActivity;
            PbModel I1 = pbActivity.I1();
            List<RobotSkill> list2 = null;
            if (I1 != null && (s12 = I1.s1()) != null && (K2 = s12.K()) != null) {
                list = K2.robot_skill_info;
            } else {
                list = null;
            }
            PbModel I12 = pbActivity.I1();
            if (I12 != null && (s1 = I12.s1()) != null && (K = s1.K()) != null) {
                list2 = K.bottom_bar_robot_skill;
            }
            if (!ListUtils.isEmpty(list) && !ListUtils.isEmpty(list2)) {
                if (TimeHelper.getDayDifference(System.currentTimeMillis(), j) < 7 || SharedPrefHelper.getInstance().getInt("pb_friend_bot_bottom_no_use_count", 0) >= 3) {
                    return false;
                }
                return true;
            }
            YunDialogLog.getInstance().e(YunDialogManager.LOG_KEY, "pb好朋友bot底部N天未点击引导此时没有数据");
            return false;
        }
        return invokeL.booleanValue;
    }
}
