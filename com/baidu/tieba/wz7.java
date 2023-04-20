package com.baidu.tieba;

import android.app.Activity;
import android.content.Context;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.dialog.TBAlertBuilder;
import com.baidu.tbadk.core.dialog.TBAlertConfig;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TbadkCoreStatisticKey;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import tbclient.Anti;
/* loaded from: classes6.dex */
public class wz7 {
    public static /* synthetic */ Interceptable $ic;
    public static boolean a;
    public transient /* synthetic */ FieldHolder $fh;

    public static boolean a(@Nullable Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, context)) == null) {
            if (c()) {
                if (!bq5.a()) {
                    d(context);
                    return true;
                }
                return true;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public static void b(boolean z, Anti anti) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZL(65537, null, z, anti) == null) && z && anti != null) {
            if (anti.user_chat_block.intValue() == 1) {
                e();
            } else {
                f();
            }
        }
    }

    public static boolean c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            return a;
        }
        return invokeV.booleanValue;
    }

    public static void e() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null) == null) && !c()) {
            a = true;
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921720, Boolean.TRUE));
        }
    }

    public static void f() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(65541, null) == null) && c()) {
            a = false;
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921720, Boolean.FALSE));
        }
    }

    public static void d(@Nullable Context context) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65539, null, context) == null) && (context instanceof Activity)) {
            TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_IM_MESSAGE_BLOCK_DIALOG_SHOW).addParam("uid", TbadkCoreApplication.getCurrentAccount()));
            TBAlertBuilder tBAlertBuilder = new TBAlertBuilder((Activity) context);
            tBAlertBuilder.w(R.string.chat_block_dialog_title);
            tBAlertBuilder.m(R.string.chat_block_dialog_desc);
            tBAlertBuilder.u(new TBAlertConfig.a((int) R.string.chat_block_dialog_btn, TBAlertConfig.OperateBtnStyle.MAIN));
            tBAlertBuilder.j(false);
            tBAlertBuilder.i();
            tBAlertBuilder.z();
        }
    }
}
