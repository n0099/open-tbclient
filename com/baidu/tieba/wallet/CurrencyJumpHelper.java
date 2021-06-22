package com.baidu.tieba.wallet;

import android.content.Context;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.BuyTBeanActivityConfig;
import com.baidu.tbadk.core.util.MemberPayStatistic;
import com.baidu.tbadk.util.PageDialogHelper;
import d.a.n0.l0.f;
import java.util.Map;
/* loaded from: classes5.dex */
public class CurrencyJumpHelper {
    public static void buyGiftGotoBuyTBeanPage(Context context, float f2) {
        if (CurrencySwitchUtil.isYyIsConvert()) {
            goYYPay(context);
        } else {
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new BuyTBeanActivityConfig(TbadkCoreApplication.getInst().getContext(), f2)));
        }
    }

    public static void goYYPay(Context context) {
        MessageManager.getInstance().runTask(2921546, String.class, new f(context, 0, null, null));
    }

    public static void gotoBuyTBeanPage(Context context, long j) {
        if (CurrencySwitchUtil.isYyIsConvert()) {
            goYYPay(context);
            return;
        }
        BuyTBeanActivityConfig buyTBeanActivityConfig = new BuyTBeanActivityConfig(TbadkCoreApplication.getInst().getContext(), 0.0f);
        buyTBeanActivityConfig.setFromDecreaseGiftStepStrategy(2);
        buyTBeanActivityConfig.setTBeanLeftToBuyGift(j);
        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, buyTBeanActivityConfig));
    }

    public static void memberCenterBuyTBean(Context context, String str) {
        if (CurrencySwitchUtil.isYyIsConvert()) {
            goYYPay(context);
        } else {
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new BuyTBeanActivityConfig(TbadkCoreApplication.getInst().getContext(), 0.0f, 1, str, PageDialogHelper.PayForm.NOT_SET)));
        }
    }

    public static void nativeGotoBuyBean(Context context) {
        if (CurrencySwitchUtil.isYyIsConvert()) {
            goYYPay(context);
        } else {
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new BuyTBeanActivityConfig(context, 0.0f)));
        }
    }

    public static void openNativeBuyTBean(Context context, Map<String, Object> map) {
        if (CurrencySwitchUtil.isYyIsConvert()) {
            goYYPay(context);
            return;
        }
        BuyTBeanActivityConfig buyTBeanActivityConfig = new BuyTBeanActivityConfig(TbadkCoreApplication.getInst().getContext(), 0.0f);
        buyTBeanActivityConfig.setReferPageAndClickZone(MemberPayStatistic.REFER_PAGE_PERSONAL_CENTER, MemberPayStatistic.CLICK_ZONE_T_RECHARGE);
        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, buyTBeanActivityConfig));
    }

    public static void personGotoBuyBean(Context context) {
        if (CurrencySwitchUtil.isYyIsConvert()) {
            goYYPay(context);
            return;
        }
        BuyTBeanActivityConfig buyTBeanActivityConfig = new BuyTBeanActivityConfig(TbadkCoreApplication.getInst().getContext(), 0.0f);
        buyTBeanActivityConfig.setReferPageAndClickZone(MemberPayStatistic.REFER_PAGE_PERSONAL_CENTER, MemberPayStatistic.CLICK_ZONE_T_RECHARGE);
        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, buyTBeanActivityConfig));
    }

    public static void schemaGotoBuyBean(Context context) {
        if (CurrencySwitchUtil.isYyIsConvert()) {
            goYYPay(context);
        } else {
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new BuyTBeanActivityConfig(context, 0.0f)));
        }
    }

    public static void buyGiftGotoBuyTBeanPage(Context context) {
        if (CurrencySwitchUtil.isYyIsConvert()) {
            goYYPay(context);
            return;
        }
        BuyTBeanActivityConfig buyTBeanActivityConfig = new BuyTBeanActivityConfig(TbadkCoreApplication.getInst().getContext(), 0.0f);
        buyTBeanActivityConfig.setReferPageAndClickZone(MemberPayStatistic.REFER_PAGE_MY_GIFT, MemberPayStatistic.CLICK_ZONE_OBTAIN_T);
        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, buyTBeanActivityConfig));
    }

    public static void gotoBuyTBeanPage(Context context, float f2, String str, String str2) {
        if (CurrencySwitchUtil.isYyIsConvert()) {
            goYYPay(context);
            return;
        }
        BuyTBeanActivityConfig buyTBeanActivityConfig = new BuyTBeanActivityConfig(TbadkCoreApplication.getInst().getContext(), f2);
        buyTBeanActivityConfig.setReferPageAndClickZone(str, str2);
        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, buyTBeanActivityConfig));
    }
}
