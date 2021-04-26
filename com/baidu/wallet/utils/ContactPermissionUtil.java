package com.baidu.wallet.utils;

import android.annotation.TargetApi;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.net.Uri;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import android.widget.AdapterView;
import com.baidu.apollon.permission.PermissionManager;
import com.baidu.apollon.utils.GlobalUtils;
import com.baidu.apollon.utils.PhoneUtils;
import com.baidu.apollon.utils.ResUtils;
import com.baidu.wallet.base.widget.dialog.PromptDialog;
import com.baidu.wallet.base.widget.dialog.SelectNumberDialog;
import com.baidu.wallet.core.BaseActivity;
import com.baidu.wallet.core.ContactManager;
import com.baidu.wallet.core.utils.BaiduWalletUtils;
import com.baidu.wallet.core.utils.LogUtil;
import com.baidu.wallet.core.utils.StringUtils;
import com.baidu.wallet.core.utils.WalletGlobalUtils;
import java.util.List;
/* loaded from: classes5.dex */
public class ContactPermissionUtil {
    public static final int DIALOG_NO_PERMISION_OR_NULL_OR_INCORRECT = 4642;
    public static final int DIALOG_NO_PERMISSION_CONTACTS = 137;

    /* renamed from: a  reason: collision with root package name */
    public static List<String> f27327a;

    /* renamed from: b  reason: collision with root package name */
    public static OnContactPermissionPhoneSelectListener f27328b;

    /* loaded from: classes5.dex */
    public interface OnContactPermissionPhoneSelectListener {
        void onContactPermissionPhoneSelect(String str);
    }

    public static void b(BaseActivity baseActivity, int i2) {
        String str = f27327a.get(i2);
        if (StringUtils.isPhoneNumber(str.replace(" ", ""))) {
            OnContactPermissionPhoneSelectListener onContactPermissionPhoneSelectListener = f27328b;
            if (onContactPermissionPhoneSelectListener != null) {
                onContactPermissionPhoneSelectListener.onContactPermissionPhoneSelect(str);
                f27328b = null;
                return;
            }
            return;
        }
        a(baseActivity, "wallet_fp_phone_not_correct");
    }

    public static void checkIsHasContactPermission(final BaseActivity baseActivity, final int i2, int i3, OnContactPermissionPhoneSelectListener onContactPermissionPhoneSelectListener) {
        f27328b = onContactPermissionPhoneSelectListener;
        if (!PermissionManager.checkCallingPermission(baseActivity, "android.permission.READ_CONTACTS")) {
            BaiduWalletUtils.requestPermissionsDialog(null, baseActivity.getActivity(), new String[]{"android.permission.READ_CONTACTS"}, new BaiduWalletUtils.IRequestPermissionCallBack() { // from class: com.baidu.wallet.utils.ContactPermissionUtil.1
                @Override // com.baidu.wallet.core.utils.BaiduWalletUtils.IRequestPermissionCallBack
                public void isAllAgree(Boolean bool) {
                    if (!bool.booleanValue() || PermissionManager.checkCallingOrSelfPermission(BaseActivity.this.getActivity(), new String[]{"android.permission.READ_CONTACTS"}, i2)) {
                        return;
                    }
                    WalletGlobalUtils.safeShowDialog(BaseActivity.this, ContactPermissionUtil.DIALOG_NO_PERMISSION_CONTACTS, "");
                }

                @Override // com.baidu.wallet.core.utils.BaiduWalletUtils.IRequestPermissionCallBack
                public void isShow(String str, Boolean bool) {
                }

                @Override // com.baidu.wallet.core.utils.BaiduWalletUtils.IRequestPermissionCallBack
                public void requestResult(String str, Boolean bool) {
                }
            });
        } else if (ContactManager.getIContactsImpl().pickContactsByContactsContentUri(baseActivity, i3)) {
        } else {
            GlobalUtils.toast(baseActivity, ResUtils.getString(baseActivity, "wallet_base_contacts_not_up"));
        }
    }

    public static SelectNumberDialog creatContactPromptDialog(BaseActivity baseActivity) {
        return new SelectNumberDialog(baseActivity);
    }

    public static List<String> getPhoneContactsForChargeFragment(Uri uri, Context context) {
        return ContactManager.getIContactsImpl().loadPhoneContactsForChargeFragment(uri, context);
    }

    public static void handleContactsSelectedActivityResult(BaseActivity baseActivity, Intent intent, int i2) {
        if (intent == null) {
            return;
        }
        List<String> phoneContactsForChargeFragment = getPhoneContactsForChargeFragment(intent.getData(), baseActivity);
        f27327a = phoneContactsForChargeFragment;
        if (phoneContactsForChargeFragment == null) {
            a(baseActivity, "wallet_fp_no_permision_or_null");
        } else if (phoneContactsForChargeFragment.size() <= 1) {
            a(baseActivity, "wallet_fp_phone_not_correct");
        } else if (f27327a.size() > 1) {
            if (f27327a.size() == 2) {
                b(baseActivity, 1);
            } else {
                WalletGlobalUtils.safeShowDialog(baseActivity, i2, "");
            }
        } else {
            GlobalUtils.toast(baseActivity, ResUtils.getString(baseActivity, "wallet_fp_select_wrong_number"));
        }
    }

    @TargetApi(23)
    public static void handleOnReadContactPermissionsResult(String[] strArr, int[] iArr, BaseActivity baseActivity, int i2, int i3) {
        if (strArr != null && strArr.length != 0 && iArr != null && iArr.length != 0) {
            for (int i4 = 0; i4 < strArr.length; i4++) {
                if ("android.permission.READ_CONTACTS".equalsIgnoreCase(strArr[i4]) && i4 < iArr.length) {
                    int i5 = iArr[i4];
                    if (i5 == 0) {
                        if (!ContactManager.getIContactsImpl().pickContactsByContactsContentUri(baseActivity, i2)) {
                            GlobalUtils.toast(baseActivity, ResUtils.getString(baseActivity, "wallet_base_contacts_not_up"));
                        }
                    } else if (i5 == -1 && !baseActivity.shouldShowRequestPermissionRationale("android.permission.READ_CONTACTS")) {
                        WalletGlobalUtils.safeShowDialog(baseActivity, i3, "");
                    }
                }
            }
        } else if (!baseActivity.shouldShowRequestPermissionRationale("android.permission.READ_CONTACTS")) {
            WalletGlobalUtils.safeShowDialog(baseActivity, i3, "");
        }
    }

    public static void prepareContactPromptDialog(final int i2, Dialog dialog, final BaseActivity baseActivity) {
        String str;
        PromptDialog promptDialog = (PromptDialog) dialog;
        promptDialog.setTitleText(ResUtils.getString(baseActivity, "wallet_fp_phone_no_contact_permission_title"));
        String string = ResUtils.getString(baseActivity, "wallet_fp_phone_no_contact_permission_content");
        try {
            str = PhoneUtils.getApplicationName(baseActivity.getActivity());
        } catch (Throwable unused) {
            str = "";
        }
        try {
            string = String.format(string, str);
        } catch (Throwable th) {
            LogUtil.d("showPhoneNumFormatErrorDialog", th.toString() + th.getMessage());
        }
        promptDialog.setMessage(string);
        promptDialog.setCanceledOnTouchOutside(false);
        String string2 = ResUtils.getString(baseActivity, "wallet_fp_phone_no_contact_permission_btn_ok");
        SpannableString spannableString = new SpannableString(string2);
        spannableString.setSpan(new ForegroundColorSpan(ResUtils.getColor(baseActivity, "wallet_fp_main_color")), 0, string2.length(), 18);
        promptDialog.hideNegativeButton();
        promptDialog.setPositiveBtn(spannableString, new View.OnClickListener() { // from class: com.baidu.wallet.utils.ContactPermissionUtil.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                WalletGlobalUtils.safeDismissDialog(BaseActivity.this, i2);
                try {
                    ApplicationInfo applicationInfo = PhoneUtils.getApplicationInfo(BaseActivity.this.getActivity());
                    PhoneUtils.showInstalledAppOrDetails(BaseActivity.this.getActivity(), applicationInfo != null ? applicationInfo.packageName : "");
                } catch (Throwable unused2) {
                }
            }
        });
    }

    public static void preparePhoneNotCorrectDialog(final int i2, Dialog dialog, final BaseActivity baseActivity) {
        PromptDialog promptDialog = (PromptDialog) dialog;
        promptDialog.setMessage(WalletGlobalUtils.showStr);
        promptDialog.setCanceledOnTouchOutside(false);
        promptDialog.setPositiveBtn(ResUtils.string(baseActivity, "ebpay_know"), new View.OnClickListener() { // from class: com.baidu.wallet.utils.ContactPermissionUtil.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                WalletGlobalUtils.safeDismissDialog(BaseActivity.this, i2);
            }
        });
        promptDialog.hideNegativeButton();
    }

    public static void prepareSelectNumberDialog(final BaseActivity baseActivity, int i2, Dialog dialog) {
        SelectNumberDialog selectNumberDialog = (SelectNumberDialog) dialog;
        selectNumberDialog.setData(f27327a);
        selectNumberDialog.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.baidu.wallet.utils.ContactPermissionUtil.2
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i3, long j) {
                if (i3 <= 0 || i3 >= ContactPermissionUtil.f27327a.size()) {
                    return;
                }
                ContactPermissionUtil.b(BaseActivity.this, i3);
            }
        });
    }

    public static void restListener() {
        if (f27328b != null) {
            f27328b = null;
        }
    }

    public static void a(BaseActivity baseActivity, String str) {
        WalletGlobalUtils.safeShowDialog(baseActivity, DIALOG_NO_PERMISION_OR_NULL_OR_INCORRECT, ResUtils.getString(baseActivity, str));
    }
}
