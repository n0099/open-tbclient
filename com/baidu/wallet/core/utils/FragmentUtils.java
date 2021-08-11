package com.baidu.wallet.core.utils;

import android.content.Context;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import com.baidu.apollon.utils.ResUtils;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.wallet.core.BaseFragment;
/* loaded from: classes8.dex */
public final class FragmentUtils {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public FragmentUtils() {
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

    public static void goBackToFirstFragment(FragmentManager fragmentManager) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65537, null, fragmentManager) == null) || fragmentManager == null) {
            return;
        }
        BaseFragment.logFragmentStack(fragmentManager);
        int backStackEntryCount = fragmentManager.getBackStackEntryCount();
        if (backStackEntryCount > 0) {
            while (backStackEntryCount > 0) {
                backStackEntryCount--;
                fragmentManager.popBackStackImmediate();
            }
        }
    }

    public static boolean popBackStackImmediate(FragmentManager fragmentManager) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, fragmentManager)) == null) {
            if (fragmentManager == null || fragmentManager.getBackStackEntryCount() <= 0) {
                return false;
            }
            return fragmentManager.popBackStackImmediate();
        }
        return invokeL.booleanValue;
    }

    public static void startFragment(Context context, FragmentManager fragmentManager, Fragment fragment, String str, boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(65539, null, new Object[]{context, fragmentManager, fragment, str, Boolean.valueOf(z)}) == null) || fragment.isAdded()) {
            return;
        }
        FragmentTransaction beginTransaction = fragmentManager.beginTransaction();
        if (z) {
            beginTransaction.setCustomAnimations(ResUtils.anim(context, "wallet_base_slide_from_right"), ResUtils.anim(context, "wallet_base_slide_to_left"), ResUtils.anim(context, "wallet_base_slide_from_left"), ResUtils.anim(context, "wallet_base_slide_to_right"));
        } else {
            beginTransaction.setCustomAnimations(0, 0, ResUtils.anim(context, "wallet_base_slide_from_left"), ResUtils.anim(context, "wallet_base_slide_to_right"));
        }
        beginTransaction.replace(16908300, fragment);
        beginTransaction.addToBackStack(str);
        beginTransaction.commitAllowingStateLoss();
    }
}
