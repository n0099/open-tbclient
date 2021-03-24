package com.baidu.wallet.core.utils;

import android.content.Context;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import com.baidu.apollon.utils.ResUtils;
import com.baidu.wallet.core.BaseFragment;
/* loaded from: classes5.dex */
public final class FragmentUtils {
    public static void goBackToFirstFragment(FragmentManager fragmentManager) {
        if (fragmentManager != null) {
            BaseFragment.logFragmentStack(fragmentManager);
            int backStackEntryCount = fragmentManager.getBackStackEntryCount();
            if (backStackEntryCount > 0) {
                while (backStackEntryCount > 0) {
                    backStackEntryCount--;
                    fragmentManager.popBackStackImmediate();
                }
            }
        }
    }

    public static boolean popBackStackImmediate(FragmentManager fragmentManager) {
        if (fragmentManager == null || fragmentManager.getBackStackEntryCount() <= 0) {
            return false;
        }
        return fragmentManager.popBackStackImmediate();
    }

    public static void startFragment(Context context, FragmentManager fragmentManager, Fragment fragment, String str, boolean z) {
        if (fragment.isAdded()) {
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
