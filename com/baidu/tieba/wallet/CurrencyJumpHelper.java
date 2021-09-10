package com.baidu.tieba.wallet;

import android.content.Context;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import c.a.q0.p0.b;
import c.a.q0.p0.f;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.BuyTBeanActivityConfig;
import com.baidu.tbadk.core.util.MemberPayStatistic;
import com.baidu.tbadk.util.PageDialogHelper;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Map;
/* loaded from: classes7.dex */
public class CurrencyJumpHelper {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public CurrencyJumpHelper() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    public static void buyGiftGotoBuyTBeanPage(Context context, float f2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLF(65538, null, context, f2) == null) {
            if (CurrencySwitchUtil.isYyIsConvert()) {
                goYYPay(context);
            } else {
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new BuyTBeanActivityConfig(TbadkCoreApplication.getInst().getContext(), f2)));
            }
        }
    }

    public static void goYYPay(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65539, null, context) == null) {
            goYYPay(context, null);
        }
    }

    public static void gotoBuyTBeanPage(Context context, long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLJ(65543, null, context, j2) == null) {
            if (CurrencySwitchUtil.isYyIsConvert()) {
                goYYPay(context);
                return;
            }
            BuyTBeanActivityConfig buyTBeanActivityConfig = new BuyTBeanActivityConfig(TbadkCoreApplication.getInst().getContext(), 0.0f);
            buyTBeanActivityConfig.setFromDecreaseGiftStepStrategy(2);
            buyTBeanActivityConfig.setTBeanLeftToBuyGift(j2);
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, buyTBeanActivityConfig));
        }
    }

    public static void memberCenterBuyTBean(Context context, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65544, null, context, str) == null) {
            if (CurrencySwitchUtil.isYyIsConvert()) {
                goYYPay(context);
            } else {
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new BuyTBeanActivityConfig(TbadkCoreApplication.getInst().getContext(), 0.0f, 1, str, PageDialogHelper.PayForm.NOT_SET)));
            }
        }
    }

    public static void nativeGotoBuyBean(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65545, null, context) == null) {
            if (CurrencySwitchUtil.isYyIsConvert()) {
                goYYPay(context);
            } else {
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new BuyTBeanActivityConfig(context, 0.0f)));
            }
        }
    }

    public static void openNativeBuyTBean(Context context, Map<String, Object> map) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65546, null, context, map) == null) {
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
        if (interceptable == null || interceptable.invokeL(65547, null, context) == null) {
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
        if (interceptable == null || interceptable.invokeL(65548, null, context) == null) {
            if (CurrencySwitchUtil.isYyIsConvert()) {
                goYYPay(context);
            } else {
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new BuyTBeanActivityConfig(context, 0.0f)));
            }
        }
    }

    public static void goYYPay(Context context, @Nullable b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, null, context, bVar) == null) {
            MessageManager.getInstance().runTask(2921546, String.class, new f(context, 0, null, null, bVar));
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

    public static void gotoBuyTBeanPage(Context context, float f2, String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(AdIconUtil.AD_TEXT_ID, null, new Object[]{context, Float.valueOf(f2), str, str2}) == null) {
            gotoBuyTBeanPage(context, f2, str, str2, null);
        }
    }

    public static void gotoBuyTBeanPage(Context context, float f2, String str, String str2, @Nullable b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(AdIconUtil.BAIDU_LOGO_ID, null, new Object[]{context, Float.valueOf(f2), str, str2, bVar}) == null) {
            if (CurrencySwitchUtil.isYyIsConvert()) {
                goYYPay(context, bVar);
                return;
            }
            BuyTBeanActivityConfig buyTBeanActivityConfig = new BuyTBeanActivityConfig(TbadkCoreApplication.getInst().getContext(), f2);
            buyTBeanActivityConfig.setReferPageAndClickZone(str, str2);
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, buyTBeanActivityConfig));
        }
    }
}
