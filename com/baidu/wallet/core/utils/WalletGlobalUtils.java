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
    public static Dialog f24007a = null;
    public static String showStr = "";

    public static void DismissLoadingDialog() {
        Dialog dialog = f24007a;
        if (dialog != null) {
            Context context = dialog.getContext();
            if (context instanceof ContextThemeWrapper) {
                context = ((ContextThemeWrapper) context).getBaseContext();
            }
            if ((context instanceof Activity) && ((Activity) context).isFinishing()) {
                return;
            }
            try {
                f24007a.dismiss();
            } catch (Throwable th) {
                LogUtil.e("globalUtils", "dialog Exception", th);
            }
            f24007a = null;
        }
    }

    public static void safeDismissDialog(BaseActivity baseActivity, int i) {
        try {
            showStr = "";
            Activity activity = baseActivity.getActivity();
            if (activity == null || activity.isFinishing()) {
                return;
            }
            baseActivity.getActivity().removeDialog(i);
        } catch (Throwable th) {
            LogUtil.e("globalUtils", "dialog Exception", th);
        }
    }

    public static void safeShowDialog(BaseActivity baseActivity, int i, String str) {
        try {
            showStr = str;
            baseActivity.getActivity().showDialog(i);
        } catch (Exception unused) {
        }
    }

    public static void showLoadingDialog(Context context) {
        if (f24007a == null) {
            f24007a = new LoadingDialog(context);
        }
        f24007a.show();
    }
}
