package com.baidu.tieba;

import android.graphics.drawable.Drawable;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.text.style.StrikethroughSpan;
import com.baidu.adp.lib.util.BdUtilHelper;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.widget.VCenterTextSpan;
import com.baidu.tieba.wallet.CurrencyHelper;
import com.baidu.tieba.wallet.CurrencySwitchUtil;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes8.dex */
public class sz7 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static SpannableString a(long j, int i, int i2) {
        InterceptResult invokeCommon;
        String formatOverBaiwanNum;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65536, null, new Object[]{Long.valueOf(j), Integer.valueOf(i), Integer.valueOf(i2)})) == null) {
            if (CurrencySwitchUtil.isYyIsConvert(i2)) {
                formatOverBaiwanNum = CurrencyHelper.getFormatOverBaiwanNum(i2, j);
            } else {
                formatOverBaiwanNum = StringHelper.formatOverBaiwanNum(j);
            }
            Drawable moneyIcon = CurrencySwitchUtil.getMoneyIcon(i2);
            String str = "[icon]" + formatOverBaiwanNum;
            SpannableString spannableString = new SpannableString(str);
            if (TbadkApplication.getInst().getSkinType() == 4) {
                z = true;
            } else {
                z = false;
            }
            if (z) {
                moneyIcon.setAlpha(179);
            } else {
                moneyIcon.setAlpha(255);
            }
            int dimens = BdUtilHelper.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.obfuscated_res_0x7f0701e8);
            moneyIcon.setBounds(0, 0, dimens, dimens);
            VCenterTextSpan vCenterTextSpan = new VCenterTextSpan(moneyIcon);
            vCenterTextSpan.setPaddingLeft(BdUtilHelper.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.obfuscated_res_0x7f07035d));
            vCenterTextSpan.setPaddingRight(BdUtilHelper.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.obfuscated_res_0x7f07035d));
            UtilHelper.setSpan(spannableString, str, "[icon]", vCenterTextSpan);
            UtilHelper.setSpan(spannableString, str, formatOverBaiwanNum, new ForegroundColorSpan(SkinManager.getColor(R.color.CAM_X0108)));
            return spannableString;
        }
        return (SpannableString) invokeCommon.objValue;
    }

    public static SpannableString b(long j, boolean z, int i) {
        InterceptResult invokeCommon;
        String formatOverBaiwanNum;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65537, null, new Object[]{Long.valueOf(j), Boolean.valueOf(z), Integer.valueOf(i)})) == null) {
            if (CurrencySwitchUtil.isYyIsConvert(i)) {
                formatOverBaiwanNum = CurrencyHelper.getFormatOverBaiwanNum(i, j);
            } else {
                formatOverBaiwanNum = StringHelper.formatOverBaiwanNum(j);
            }
            if (z) {
                str = "=[icon]" + formatOverBaiwanNum;
            } else {
                str = "[icon]" + formatOverBaiwanNum;
            }
            SpannableString spannableString = new SpannableString(str);
            Drawable moneyIcon = CurrencySwitchUtil.getMoneyIcon(i);
            int dimens = BdUtilHelper.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.obfuscated_res_0x7f0701e8);
            moneyIcon.setBounds(0, 0, dimens, dimens);
            VCenterTextSpan vCenterTextSpan = new VCenterTextSpan(moneyIcon);
            vCenterTextSpan.setPaddingLeft(BdUtilHelper.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.obfuscated_res_0x7f07035d));
            vCenterTextSpan.setPaddingRight(BdUtilHelper.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.obfuscated_res_0x7f07035d));
            UtilHelper.setSpan(spannableString, str, "[icon]", vCenterTextSpan);
            UtilHelper.setSpan(spannableString, str, formatOverBaiwanNum, new ForegroundColorSpan(SkinManager.getColor(R.color.CAM_X0305)));
            if (z) {
                UtilHelper.setSpan(spannableString, str, "=", new ForegroundColorSpan(SkinManager.getColor(R.color.CAM_X0108)));
            }
            return spannableString;
        }
        return (SpannableString) invokeCommon.objValue;
    }

    public static SpannableString c(String str, String str2, String str3) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65538, null, str, str2, str3)) == null) {
            if (StringUtils.isNull(str)) {
                return new SpannableString("");
            }
            SpannableString spannableString = new SpannableString(str);
            UtilHelper.setSpan(spannableString, str, str, new ForegroundColorSpan(SkinManager.getColor(R.color.CAM_X0109)));
            UtilHelper.setSpan(spannableString, str, str2, new ForegroundColorSpan(SkinManager.getColor(R.color.CAM_X0305)));
            if (!StringUtils.isNull(str3)) {
                UtilHelper.setSpan(spannableString, str, str3, new StrikethroughSpan());
            }
            return spannableString;
        }
        return (SpannableString) invokeLLL.objValue;
    }
}
