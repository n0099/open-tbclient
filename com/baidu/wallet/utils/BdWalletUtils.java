package com.baidu.wallet.utils;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import androidx.appcompat.widget.ActivityChooserModel;
import com.baidu.apollon.armor.SafePay;
import com.baidu.apollon.beans.BeanResponseBase;
import com.baidu.apollon.utils.ResUtils;
import com.baidu.apollon.utils.SharedPreferencesUtils;
import com.baidu.wallet.base.widget.dialog.PromptDialog;
import com.baidu.wallet.core.beans.NetworkBean;
import com.baidu.wallet.paysdk.SDKInitBeanCallBack;
import com.baidu.wallet.paysdk.beans.NewSdkInitBean;
import com.baidu.wallet.paysdk.beans.SdkInitBean;
import java.io.File;
/* loaded from: classes5.dex */
public class BdWalletUtils {

    /* renamed from: a  reason: collision with root package name */
    public static final String f26819a = "__Baidu_Wallet_SDK_FP";

    /* renamed from: b  reason: collision with root package name */
    public static final String f26820b = "device_fp";

    /* renamed from: c  reason: collision with root package name */
    public static final String f26821c = "__Baidu_Wallet_SDK_KEFU";

    /* renamed from: d  reason: collision with root package name */
    public static final String f26822d = "kefu_phone_num";

    public static void addFlagsSecure(Activity activity) {
        activity.getWindow().addFlags(8192);
    }

    public static void clearFlagsSecure(Activity activity) {
        activity.getWindow().clearFlags(8192);
    }

    public static void dealCashDesk(BeanResponseBase.Session session) {
        if (session == null) {
            return;
        }
        NetworkBean.SessionCache.getInstance().put(null, session);
    }

    public static String getDeviceFP(Context context) {
        String str = (String) SharedPreferencesUtils.getParam(context, f26819a, f26820b, "");
        return !TextUtils.isEmpty(str) ? SafePay.getInstance().localDecrypt1(str) : str;
    }

    public static String getFPFileLastModified(Context context) {
        File file = new File(context.getFilesDir().getParent() + "/shared_prefs/" + f26819a + ActivityChooserModel.HISTORY_FILE_EXTENSION);
        if (file.exists()) {
            return "" + (file.lastModified() / 1000);
        }
        return "";
    }

    public static void getInitForPoll(Context context) {
        SdkInitBean sdkInitBean = new SdkInitBean(context.getApplicationContext());
        sdkInitBean.setResponseCallback(new SDKInitBeanCallBack(context));
        sdkInitBean.execBean();
    }

    public static String getKefuPhoneNum(Context context) {
        if (context == null) {
            return "";
        }
        String str = (String) SharedPreferencesUtils.getParam(context, f26821c, f26822d, "");
        return TextUtils.isEmpty(str) ? ResUtils.getString(context, "wallet_base_help_phone_no_dial") : str;
    }

    public static void loadDeviceFP(Context context) {
        SdkInitBean sdkInitBean = new SdkInitBean(context.getApplicationContext());
        sdkInitBean.setResponseCallback(new SDKInitBeanCallBack(context));
        sdkInitBean.execBean();
        NewSdkInitBean newSdkInitBean = new NewSdkInitBean(context.getApplicationContext());
        newSdkInitBean.setResponseCallback(new SDKInitBeanCallBack(context));
        newSdkInitBean.execBean();
    }

    public static void setDeviceFP(Context context, String str) {
        if (str != null) {
            SharedPreferencesUtils.setParam(context, f26819a, f26820b, SafePay.getInstance().localEncrypt1(str));
        }
    }

    public static void setKefuPhoneNumToSP(Context context, String str) {
        if (str == null || context == null) {
            return;
        }
        SharedPreferencesUtils.setParam(context, f26821c, f26822d, str);
    }

    public static void showThemeDialog(Context context, String str, String str2, String str3, final View.OnClickListener onClickListener, final View.OnClickListener onClickListener2) {
        final PromptDialog promptDialog = new PromptDialog(context);
        promptDialog.setMessage(str);
        promptDialog.setNegativeBtn(str2, new View.OnClickListener() { // from class: com.baidu.wallet.utils.BdWalletUtils.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                View.OnClickListener onClickListener3 = onClickListener;
                if (onClickListener3 != null) {
                    onClickListener3.onClick(view);
                }
                promptDialog.dismiss();
            }
        });
        promptDialog.setPositiveBtn(str3, new View.OnClickListener() { // from class: com.baidu.wallet.utils.BdWalletUtils.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                View.OnClickListener onClickListener3 = onClickListener2;
                if (onClickListener3 != null) {
                    onClickListener3.onClick(view);
                }
                promptDialog.dismiss();
            }
        });
        promptDialog.show();
    }
}
