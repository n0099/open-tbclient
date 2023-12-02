package com.baidu.tieba;

import android.app.Activity;
import androidx.core.view.InputDeviceCompat;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.sharedPref.SharedPrefHelper;
import com.baidu.tbadk.core.util.CommonStatisticKey;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.TimeHelper;
import com.baidu.tbadk.switchs.CheckIsQuestionThreadSwitch;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes6.dex */
public class jib {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void a(int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(65536, null, i, i2) == null) {
            StatisticItem statisticItem = new StatisticItem(CommonStatisticKey.KEY_CHECK_DIALOG_CLICK);
            statisticItem.addParam("uid", TbadkCoreApplication.getCurrentAccount());
            statisticItem.addParam("obj_locate", i);
            statisticItem.addParam("obj_type", i2);
            TiebaStatic.log(statisticItem);
        }
    }

    public static void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65537, null) == null) {
            StatisticItem statisticItem = new StatisticItem(CommonStatisticKey.KEY_CHECK_DIALOG_SHOW);
            statisticItem.addParam("uid", TbadkCoreApplication.getCurrentAccount());
            TiebaStatic.log(statisticItem);
        }
    }

    public static boolean d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
            if (CheckIsQuestionThreadSwitch.getSwitchType() != 3 && CheckIsQuestionThreadSwitch.getSwitchType() != 2) {
                return false;
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    public static boolean e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) {
            if (TimeHelper.getDayDifference(System.currentTimeMillis(), SharedPrefHelper.getInstance().getLong("key_check_is_question_thread_time", 0L)) > 7) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public static boolean f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65541, null)) == null) {
            if (CheckIsQuestionThreadSwitch.getSwitchType() == 2) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public static boolean g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65542, null)) == null) {
            if (CheckIsQuestionThreadSwitch.getSwitchType() == 3) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public static void c(Activity activity) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(65538, null, activity) != null) || activity == null) {
            return;
        }
        if (activity instanceof BaseFragmentActivity) {
            ((BaseFragmentActivity) activity).closeLoadingDialog();
        } else if (activity instanceof BaseActivity) {
            ((BaseActivity) activity).closeLoadingDialog();
        }
    }

    public static void h(Activity activity) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(65543, null, activity) != null) || activity == null) {
            return;
        }
        String string = activity.getString(R.string.obfuscated_res_0x7f0f043c);
        if (activity instanceof BaseFragmentActivity) {
            ((BaseFragmentActivity) activity).showLoadingDialog(string);
        } else if (activity instanceof BaseActivity) {
            ((BaseActivity) activity).showLoadingDialog(string);
        }
    }
}
