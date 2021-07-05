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
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.wallet.base.widget.dialog.PromptDialog;
import com.baidu.wallet.core.beans.NetworkBean;
import com.baidu.wallet.paysdk.SDKInitBeanCallBack;
import com.baidu.wallet.paysdk.beans.NewSdkInitBean;
import com.baidu.wallet.paysdk.beans.SdkInitBean;
import java.io.File;
/* loaded from: classes6.dex */
public class BdWalletUtils {
    public static /* synthetic */ Interceptable $ic = null;

    /* renamed from: a  reason: collision with root package name */
    public static final String f27221a = "__Baidu_Wallet_SDK_FP";

    /* renamed from: b  reason: collision with root package name */
    public static final String f27222b = "device_fp";

    /* renamed from: c  reason: collision with root package name */
    public static final String f27223c = "__Baidu_Wallet_SDK_KEFU";

    /* renamed from: d  reason: collision with root package name */
    public static final String f27224d = "kefu_phone_num";
    public transient /* synthetic */ FieldHolder $fh;

    public BdWalletUtils() {
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

    public static void addFlagsSecure(Activity activity) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65537, null, activity) == null) {
            activity.getWindow().addFlags(8192);
        }
    }

    public static void clearFlagsSecure(Activity activity) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65538, null, activity) == null) {
            activity.getWindow().clearFlags(8192);
        }
    }

    public static void dealCashDesk(BeanResponseBase.Session session) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65539, null, session) == null) || session == null) {
            return;
        }
        NetworkBean.SessionCache.getInstance().put(null, session);
    }

    public static String getDeviceFP(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65540, null, context)) == null) {
            String str = (String) SharedPreferencesUtils.getParam(context, f27221a, f27222b, "");
            return !TextUtils.isEmpty(str) ? SafePay.getInstance().localDecrypt1(str) : str;
        }
        return (String) invokeL.objValue;
    }

    public static String getFPFileLastModified(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(AdIconUtil.AD_TEXT_ID, null, context)) == null) {
            File file = new File(context.getFilesDir().getParent() + "/shared_prefs/" + f27221a + ActivityChooserModel.HISTORY_FILE_EXTENSION);
            if (file.exists()) {
                return "" + (file.lastModified() / 1000);
            }
            return "";
        }
        return (String) invokeL.objValue;
    }

    public static void getInitForPoll(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(AdIconUtil.BAIDU_LOGO_ID, null, context) == null) {
            SdkInitBean sdkInitBean = new SdkInitBean(context.getApplicationContext());
            sdkInitBean.setResponseCallback(new SDKInitBeanCallBack(context));
            sdkInitBean.execBean();
        }
    }

    public static String getKefuPhoneNum(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65543, null, context)) == null) {
            if (context == null) {
                return "";
            }
            String str = (String) SharedPreferencesUtils.getParam(context, f27223c, f27224d, "");
            return TextUtils.isEmpty(str) ? ResUtils.getString(context, "wallet_base_help_phone_no_dial") : str;
        }
        return (String) invokeL.objValue;
    }

    public static void loadDeviceFP(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65544, null, context) == null) {
            SdkInitBean sdkInitBean = new SdkInitBean(context.getApplicationContext());
            sdkInitBean.setResponseCallback(new SDKInitBeanCallBack(context));
            sdkInitBean.execBean();
            NewSdkInitBean newSdkInitBean = new NewSdkInitBean(context.getApplicationContext());
            newSdkInitBean.setResponseCallback(new SDKInitBeanCallBack(context));
            newSdkInitBean.execBean();
        }
    }

    public static void setDeviceFP(Context context, String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(65545, null, context, str) == null) || str == null) {
            return;
        }
        SharedPreferencesUtils.setParam(context, f27221a, f27222b, SafePay.getInstance().localEncrypt1(str));
    }

    public static void setKefuPhoneNumToSP(Context context, String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(65546, null, context, str) == null) || str == null || context == null) {
            return;
        }
        SharedPreferencesUtils.setParam(context, f27223c, f27224d, str);
    }

    public static void showThemeDialog(Context context, String str, String str2, String str3, View.OnClickListener onClickListener, View.OnClickListener onClickListener2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65547, null, new Object[]{context, str, str2, str3, onClickListener, onClickListener2}) == null) {
            PromptDialog promptDialog = new PromptDialog(context);
            promptDialog.setMessage(str);
            promptDialog.setNegativeBtn(str2, new View.OnClickListener(onClickListener, promptDialog) { // from class: com.baidu.wallet.utils.BdWalletUtils.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ View.OnClickListener f27225a;

                /* renamed from: b  reason: collision with root package name */
                public final /* synthetic */ PromptDialog f27226b;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {onClickListener, promptDialog};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.f27225a = onClickListener;
                    this.f27226b = promptDialog;
                }

                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, view) == null) {
                        View.OnClickListener onClickListener3 = this.f27225a;
                        if (onClickListener3 != null) {
                            onClickListener3.onClick(view);
                        }
                        this.f27226b.dismiss();
                    }
                }
            });
            promptDialog.setPositiveBtn(str3, new View.OnClickListener(onClickListener2, promptDialog) { // from class: com.baidu.wallet.utils.BdWalletUtils.2
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ View.OnClickListener f27227a;

                /* renamed from: b  reason: collision with root package name */
                public final /* synthetic */ PromptDialog f27228b;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {onClickListener2, promptDialog};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.f27227a = onClickListener2;
                    this.f27228b = promptDialog;
                }

                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, view) == null) {
                        View.OnClickListener onClickListener3 = this.f27227a;
                        if (onClickListener3 != null) {
                            onClickListener3.onClick(view);
                        }
                        this.f27228b.dismiss();
                    }
                }
            });
            promptDialog.show();
        }
    }
}
