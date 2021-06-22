package com.baidu.wallet.core.utils;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.view.ContextThemeWrapper;
import com.baidu.wallet.base.widget.LoadingDialog;
import com.baidu.wallet.core.BaseActivity;
@SuppressLint({"InlinedApi", "NewApi"})
/* loaded from: classes5.dex */
public final class WalletGlobalUtils {

    /* renamed from: a  reason: collision with root package name */
    public static Dialog f24114a = null;
    public static String showStr = "";

    public static void DismissLoadingDialog() {
        Dialog dialog = f24114a;
        if (dialog != null) {
            Context context = dialog.getContext();
            if (context instanceof ContextThemeWrapper) {
                context = ((ContextThemeWrapper) context).getBaseContext();
            }
            if ((context instanceof Activity) && ((Activity) context).isFinishing()) {
                return;
            }
            try {
                f24114a.dismiss();
            } catch (Throwable th) {
                LogUtil.e("globalUtils", "dialog Exception", th);
            }
            f24114a = null;
        }
    }

    public static void safeDismissDialog(BaseActivity baseActivity, int i2) {
        try {
            showStr = "";
            Activity activity = baseActivity.getActivity();
            if (activity == null || activity.isFinishing()) {
                return;
            }
            baseActivity.getActivity().removeDialog(i2);
        } catch (Throwable th) {
            LogUtil.e("globalUtils", "dialog Exception", th);
        }
    }

    public static void safeShowDialog(BaseActivity baseActivity, int i2, String str) {
        try {
            showStr = str;
            baseActivity.getActivity().showDialog(i2);
        } catch (Exception unused) {
        }
    }

    public static void showLoadingDialog(Context context) {
        if (f24114a == null) {
            f24114a = new LoadingDialog(context);
        }
        f24114a.show();
    }
}
