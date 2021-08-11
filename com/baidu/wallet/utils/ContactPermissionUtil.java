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
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.apollon.permission.PermissionManager;
import com.baidu.apollon.utils.GlobalUtils;
import com.baidu.apollon.utils.PhoneUtils;
import com.baidu.apollon.utils.ResUtils;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.wallet.base.widget.dialog.PromptDialog;
import com.baidu.wallet.base.widget.dialog.SelectNumberDialog;
import com.baidu.wallet.core.BaseActivity;
import com.baidu.wallet.core.ContactManager;
import com.baidu.wallet.core.utils.BaiduWalletUtils;
import com.baidu.wallet.core.utils.LogUtil;
import com.baidu.wallet.core.utils.StringUtils;
import com.baidu.wallet.core.utils.WalletGlobalUtils;
import java.util.List;
/* loaded from: classes8.dex */
public class ContactPermissionUtil {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int DIALOG_NO_PERMISION_OR_NULL_OR_INCORRECT = 4642;
    public static final int DIALOG_NO_PERMISSION_CONTACTS = 137;

    /* renamed from: a  reason: collision with root package name */
    public static List<String> f63327a;

    /* renamed from: b  reason: collision with root package name */
    public static OnContactPermissionPhoneSelectListener f63328b;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes8.dex */
    public interface OnContactPermissionPhoneSelectListener {
        void onContactPermissionPhoneSelect(String str);
    }

    public ContactPermissionUtil() {
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

    public static void b(BaseActivity baseActivity, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(InputDeviceCompat.SOURCE_TRACKBALL, null, baseActivity, i2) == null) {
            String str = f63327a.get(i2);
            if (StringUtils.isPhoneNumber(str.replace(" ", ""))) {
                OnContactPermissionPhoneSelectListener onContactPermissionPhoneSelectListener = f63328b;
                if (onContactPermissionPhoneSelectListener != null) {
                    onContactPermissionPhoneSelectListener.onContactPermissionPhoneSelect(str);
                    f63328b = null;
                    return;
                }
                return;
            }
            a(baseActivity, "wallet_fp_phone_not_correct");
        }
    }

    public static void checkIsHasContactPermission(BaseActivity baseActivity, int i2, int i3, OnContactPermissionPhoneSelectListener onContactPermissionPhoneSelectListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(AdIconUtil.AD_TEXT_ID, null, new Object[]{baseActivity, Integer.valueOf(i2), Integer.valueOf(i3), onContactPermissionPhoneSelectListener}) == null) {
            f63328b = onContactPermissionPhoneSelectListener;
            if (!PermissionManager.checkCallingPermission(baseActivity, "android.permission.READ_CONTACTS")) {
                BaiduWalletUtils.requestPermissionsDialog(null, baseActivity.getActivity(), new String[]{"android.permission.READ_CONTACTS"}, new BaiduWalletUtils.IRequestPermissionCallBack(baseActivity, i2) { // from class: com.baidu.wallet.utils.ContactPermissionUtil.1
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    /* renamed from: a  reason: collision with root package name */
                    public final /* synthetic */ BaseActivity f63329a;

                    /* renamed from: b  reason: collision with root package name */
                    public final /* synthetic */ int f63330b;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {baseActivity, Integer.valueOf(i2)};
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i4 = newInitContext.flag;
                            if ((i4 & 1) != 0) {
                                int i5 = i4 & 2;
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.f63329a = baseActivity;
                        this.f63330b = i2;
                    }

                    @Override // com.baidu.wallet.core.utils.BaiduWalletUtils.IRequestPermissionCallBack
                    public void isAllAgree(Boolean bool) {
                        Interceptable interceptable2 = $ic;
                        if ((interceptable2 == null || interceptable2.invokeL(1048576, this, bool) == null) && bool.booleanValue() && !PermissionManager.checkCallingOrSelfPermission(this.f63329a.getActivity(), new String[]{"android.permission.READ_CONTACTS"}, this.f63330b)) {
                            WalletGlobalUtils.safeShowDialog(this.f63329a, ContactPermissionUtil.DIALOG_NO_PERMISSION_CONTACTS, "");
                        }
                    }

                    @Override // com.baidu.wallet.core.utils.BaiduWalletUtils.IRequestPermissionCallBack
                    public void isShow(String str, Boolean bool) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, bool) == null) {
                        }
                    }

                    @Override // com.baidu.wallet.core.utils.BaiduWalletUtils.IRequestPermissionCallBack
                    public void requestResult(String str, Boolean bool) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeLL(Constants.METHOD_SEND_USER_MSG, this, str, bool) == null) {
                        }
                    }
                });
            } else if (ContactManager.getIContactsImpl().pickContactsByContactsContentUri(baseActivity.getActivity(), i3)) {
            } else {
                GlobalUtils.toast(baseActivity, ResUtils.getString(baseActivity, "wallet_base_contacts_not_up"));
            }
        }
    }

    public static SelectNumberDialog creatContactPromptDialog(BaseActivity baseActivity) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(AdIconUtil.BAIDU_LOGO_ID, null, baseActivity)) == null) ? new SelectNumberDialog(baseActivity) : (SelectNumberDialog) invokeL.objValue;
    }

    public static List<String> getPhoneContactsForChargeFragment(Uri uri, Context context) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(65543, null, uri, context)) == null) ? ContactManager.getIContactsImpl().loadPhoneContactsForChargeFragment(uri, context) : (List) invokeLL.objValue;
    }

    public static void handleContactsSelectedActivityResult(BaseActivity baseActivity, Intent intent, int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLI(65544, null, baseActivity, intent, i2) == null) || intent == null) {
            return;
        }
        List<String> phoneContactsForChargeFragment = getPhoneContactsForChargeFragment(intent.getData(), baseActivity);
        f63327a = phoneContactsForChargeFragment;
        if (phoneContactsForChargeFragment == null) {
            a(baseActivity, "wallet_fp_no_permision_or_null");
        } else if (phoneContactsForChargeFragment.size() <= 1) {
            a(baseActivity, "wallet_fp_phone_not_correct");
        } else if (f63327a.size() > 1) {
            if (f63327a.size() == 2) {
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
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65545, null, new Object[]{strArr, iArr, baseActivity, Integer.valueOf(i2), Integer.valueOf(i3)}) == null) {
            if (strArr != null && strArr.length != 0 && iArr != null && iArr.length != 0) {
                for (int i4 = 0; i4 < strArr.length; i4++) {
                    if ("android.permission.READ_CONTACTS".equalsIgnoreCase(strArr[i4]) && i4 < iArr.length) {
                        int i5 = iArr[i4];
                        if (i5 == 0) {
                            if (!ContactManager.getIContactsImpl().pickContactsByContactsContentUri(baseActivity.getActivity(), i2)) {
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
    }

    public static void prepareContactPromptDialog(int i2, Dialog dialog, BaseActivity baseActivity) {
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeILL(65546, null, i2, dialog, baseActivity) == null) {
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
            promptDialog.setPositiveBtn(spannableString, new View.OnClickListener(baseActivity, i2) { // from class: com.baidu.wallet.utils.ContactPermissionUtil.3
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ BaseActivity f63332a;

                /* renamed from: b  reason: collision with root package name */
                public final /* synthetic */ int f63333b;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {baseActivity, Integer.valueOf(i2)};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i3 = newInitContext.flag;
                        if ((i3 & 1) != 0) {
                            int i4 = i3 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.f63332a = baseActivity;
                    this.f63333b = i2;
                }

                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, view) == null) {
                        WalletGlobalUtils.safeDismissDialog(this.f63332a, this.f63333b);
                        try {
                            ApplicationInfo applicationInfo = PhoneUtils.getApplicationInfo(this.f63332a.getActivity());
                            PhoneUtils.showInstalledAppOrDetails(this.f63332a.getActivity(), applicationInfo != null ? applicationInfo.packageName : "");
                        } catch (Throwable unused2) {
                        }
                    }
                }
            });
        }
    }

    public static void preparePhoneNotCorrectDialog(int i2, Dialog dialog, BaseActivity baseActivity) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeILL(65547, null, i2, dialog, baseActivity) == null) {
            PromptDialog promptDialog = (PromptDialog) dialog;
            promptDialog.setMessage(WalletGlobalUtils.showStr);
            promptDialog.setCanceledOnTouchOutside(false);
            promptDialog.setPositiveBtn(ResUtils.string(baseActivity, "ebpay_know"), new View.OnClickListener(baseActivity, i2) { // from class: com.baidu.wallet.utils.ContactPermissionUtil.4
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ BaseActivity f63334a;

                /* renamed from: b  reason: collision with root package name */
                public final /* synthetic */ int f63335b;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {baseActivity, Integer.valueOf(i2)};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i3 = newInitContext.flag;
                        if ((i3 & 1) != 0) {
                            int i4 = i3 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.f63334a = baseActivity;
                    this.f63335b = i2;
                }

                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, view) == null) {
                        WalletGlobalUtils.safeDismissDialog(this.f63334a, this.f63335b);
                    }
                }
            });
            promptDialog.hideNegativeButton();
        }
    }

    public static void prepareSelectNumberDialog(BaseActivity baseActivity, int i2, Dialog dialog) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLIL(65548, null, baseActivity, i2, dialog) == null) {
            SelectNumberDialog selectNumberDialog = (SelectNumberDialog) dialog;
            selectNumberDialog.setData(f63327a);
            selectNumberDialog.setOnItemClickListener(new AdapterView.OnItemClickListener(baseActivity) { // from class: com.baidu.wallet.utils.ContactPermissionUtil.2
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ BaseActivity f63331a;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {baseActivity};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i3 = newInitContext.flag;
                        if ((i3 & 1) != 0) {
                            int i4 = i3 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.f63331a = baseActivity;
                }

                @Override // android.widget.AdapterView.OnItemClickListener
                public void onItemClick(AdapterView<?> adapterView, View view, int i3, long j2) {
                    Interceptable interceptable2 = $ic;
                    if (!(interceptable2 == null || interceptable2.invokeCommon(1048576, this, new Object[]{adapterView, view, Integer.valueOf(i3), Long.valueOf(j2)}) == null) || i3 <= 0 || i3 >= ContactPermissionUtil.f63327a.size()) {
                        return;
                    }
                    ContactPermissionUtil.b(this.f63331a, i3);
                }
            });
        }
    }

    public static void restListener() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65549, null) == null) || f63328b == null) {
            return;
        }
        f63328b = null;
    }

    public static void a(BaseActivity baseActivity, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65539, null, baseActivity, str) == null) {
            WalletGlobalUtils.safeShowDialog(baseActivity, DIALOG_NO_PERMISION_OR_NULL_OR_INCORRECT, ResUtils.getString(baseActivity, str));
        }
    }
}
