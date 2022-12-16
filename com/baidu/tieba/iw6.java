package com.baidu.tieba;

import android.content.Intent;
import android.text.TextUtils;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.LogoActivityConfig;
import com.baidu.tbadk.coreExtra.service.DealIntentService;
import com.baidu.tieba.frs.FrsFragment;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes5.dex */
public class iw6 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static boolean a(FrsFragment frsFragment, String str, String str2, boolean z) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65536, null, new Object[]{frsFragment, str, str2, Boolean.valueOf(z)})) == null) {
            if (!z || frsFragment == null || TextUtils.isEmpty(str) || !frsFragment.isAdded() || !mw6.j(TbadkCoreApplication.getInst().getApplicationContext(), frsFragment.getActivity().getClass().getName())) {
                return true;
            }
            Intent intent = new Intent();
            intent.putExtra(DealIntentService.KEY_CLASS, 2);
            intent.putExtra("fname", str);
            intent.putExtra(str2, "short_cut");
            frsFragment.sendMessage(new CustomMessage(2002001, new LogoActivityConfig(frsFragment.getPageContext().getPageActivity(), intent)));
            return false;
        }
        return invokeCommon.booleanValue;
    }
}
