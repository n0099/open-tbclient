package com.baidu.tieba.wallet;

import android.content.Context;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.BuyTBeanActivityConfig;
import com.baidu.tbadk.core.util.MemberPayStatistic;
import com.baidu.tbadk.util.PageDialogHelper$PayForm;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.c85;
import com.repackage.g85;
import java.util.Map;
/* loaded from: classes4.dex */
public class CurrencyJumpHelper {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public CurrencyJumpHelper() {
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

    public static void buyGiftGotoBuyTBeanPage(Context context, float f) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLF(65538, null, context, f) == null) {
            if (CurrencySwitchUtil.isYyIsConvert()) {
                goYYPay(context);
            } else {
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new BuyTBeanActivityConfig(TbadkCoreApplication.getInst().getContext(), f)));
            }
        }
    }

    public static void goYYPay(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, context) == null) {
            goYYPay(context, null);
        }
    }

    public static void gotoBuyTBeanPage(Context context, long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLJ(65545, null, context, j) == null) {
            if (CurrencySwitchUtil.isYyIsConvert()) {
                goYYPay(context);
                return;
            }
            BuyTBeanActivityConfig buyTBeanActivityConfig = new BuyTBeanActivityConfig(TbadkCoreApplication.getInst().getContext(), 0.0f);
            buyTBeanActivityConfig.setFromDecreaseGiftStepStrategy(2);
            buyTBeanActivityConfig.setTBeanLeftToBuyGift(j);
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, buyTBeanActivityConfig));
        }
    }

    public static void memberCenterBuyTBean(Context context, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65546, null, context, str) == null) {
            if (CurrencySwitchUtil.isYyIsConvert()) {
                goYYPay(context);
            } else {
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new BuyTBeanActivityConfig(TbadkCoreApplication.getInst().getContext(), 0.0f, 1, str, PageDialogHelper$PayForm.NOT_SET)));
            }
        }
    }

    public static void nativeGotoBuyBean(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65547, null, context) == null) {
            if (CurrencySwitchUtil.isYyIsConvert()) {
                goYYPay(context);
            } else {
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new BuyTBeanActivityConfig(context, 0.0f)));
            }
        }
    }

    public static void openNativeBuyTBean(Context context, Map<String, Object> map) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65548, null, context, map) == null) {
            if (CurrencySwitchUtil.isYyIsConvert()) {
                goYYPay(context);
                return;
            }
            BuyTBeanActivityConfig buyTBeanActivityConfig = new BuyTBeanActivityConfig(TbadkCoreApplication.getInst().getContext(), 0.0f);
            buyTBeanActivityConfig.setReferPageAndClickZone(MemberPayStatistic.REFER_PAGE_PERSONAL_CENTER, MemberPayStatistic.CLICK_ZONE_T_RECHARGE);
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, buyTBeanActivityConfig));
        }
    }

    public static void personGotoBuyBean(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65549, null, context) == null) {
            if (CurrencySwitchUtil.isYyIsConvert()) {
                goYYPay(context);
                return;
            }
            BuyTBeanActivityConfig buyTBeanActivityConfig = new BuyTBeanActivityConfig(TbadkCoreApplication.getInst().getContext(), 0.0f);
            buyTBeanActivityConfig.setReferPageAndClickZone(MemberPayStatistic.REFER_PAGE_PERSONAL_CENTER, MemberPayStatistic.CLICK_ZONE_T_RECHARGE);
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, buyTBeanActivityConfig));
        }
    }

    public static void schemaGotoBuyBean(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65550, null, context) == null) {
            if (CurrencySwitchUtil.isYyIsConvert()) {
                goYYPay(context);
            } else {
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new BuyTBeanActivityConfig(context, 0.0f)));
            }
        }
    }

    public static void goYYPay(Context context, @Nullable c85 c85Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65541, null, context, c85Var) == null) {
            MessageManager.getInstance().runTask(2921546, String.class, new g85(context, 0, null, null, c85Var));
        }
    }

    public static void goYYPay(Context context, @Nullable c85 c85Var, String str, Long l, boolean z, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65542, null, new Object[]{context, c85Var, str, l, Boolean.valueOf(z), Integer.valueOf(i)}) == null) {
            g85 g85Var = new g85(context, 0, str, l, c85Var);
            g85Var.g = z;
            g85Var.f = i;
            MessageManager.getInstance().runTask(2921546, String.class, g85Var);
        }
    }

    public static void buyGiftGotoBuyTBeanPage(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65537, null, context) == null) {
            if (CurrencySwitchUtil.isYyIsConvert()) {
                goYYPay(context);
                return;
            }
            BuyTBeanActivityConfig buyTBeanActivityConfig = new BuyTBeanActivityConfig(TbadkCoreApplication.getInst().getContext(), 0.0f);
            buyTBeanActivityConfig.setReferPageAndClickZone(MemberPayStatistic.REFER_PAGE_MY_GIFT, MemberPayStatistic.CLICK_ZONE_OBTAIN_T);
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, buyTBeanActivityConfig));
        }
    }

    public static void gotoBuyTBeanPage(Context context, float f, String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65543, null, new Object[]{context, Float.valueOf(f), str, str2}) == null) {
            gotoBuyTBeanPage(context, f, str, str2, null);
        }
    }

    public static void gotoBuyTBeanPage(Context context, float f, String str, String str2, @Nullable c85 c85Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65544, null, new Object[]{context, Float.valueOf(f), str, str2, c85Var}) == null) {
            if (CurrencySwitchUtil.isYyIsConvert()) {
                goYYPay(context, c85Var);
                return;
            }
            BuyTBeanActivityConfig buyTBeanActivityConfig = new BuyTBeanActivityConfig(TbadkCoreApplication.getInst().getContext(), f);
            buyTBeanActivityConfig.setReferPageAndClickZone(str, str2);
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, buyTBeanActivityConfig));
        }
    }

    public static void buyGiftGotoBuyTBeanPage(Context context, c85 c85Var, String str, Long l, boolean z, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65539, null, new Object[]{context, c85Var, str, l, Boolean.valueOf(z), Integer.valueOf(i)}) == null) {
            if (CurrencySwitchUtil.isYyIsConvert()) {
                goYYPay(context, c85Var, str, l, z, i);
                return;
            }
            BuyTBeanActivityConfig buyTBeanActivityConfig = new BuyTBeanActivityConfig(TbadkCoreApplication.getInst().getContext(), 0.0f);
            buyTBeanActivityConfig.setReferPageAndClickZone(MemberPayStatistic.REFER_PAGE_MY_GIFT, MemberPayStatistic.CLICK_ZONE_OBTAIN_T);
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, buyTBeanActivityConfig));
        }
    }
}
