package com.baidu.wallet.base.widget;

import android.app.Dialog;
import android.content.Context;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import com.baidu.apollon.utils.DisplayUtils;
import com.baidu.apollon.utils.ResUtils;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.wallet.api.WalletLoginHelper;
import com.baidu.wallet.base.datamodel.AccountManager;
/* loaded from: classes6.dex */
public class LoginOutHelper {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes6.dex */
    public interface IAfterDismissCallback {
        void onCancel();

        void onLogout();
    }

    public LoginOutHelper() {
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

    public static void showLogoutDialog(Context context, IAfterDismissCallback iAfterDismissCallback) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65537, null, context, iAfterDismissCallback) == null) {
            Dialog dialog = new Dialog(context, ResUtils.style(context, "EbpayPromptDialog"));
            dialog.setContentView(ResUtils.layout(context, "wallet_base_dialog_logout"));
            dialog.findViewById(ResUtils.id(context, "ebpay_logout")).setOnClickListener(new View.OnClickListener(dialog, context, iAfterDismissCallback) { // from class: com.baidu.wallet.base.widget.LoginOutHelper.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ Dialog f24183a;

                /* renamed from: b  reason: collision with root package name */
                public final /* synthetic */ Context f24184b;

                /* renamed from: c  reason: collision with root package name */
                public final /* synthetic */ IAfterDismissCallback f24185c;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {dialog, context, iAfterDismissCallback};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.f24183a = dialog;
                    this.f24184b = context;
                    this.f24185c = iAfterDismissCallback;
                }

                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, view) == null) {
                        this.f24183a.dismiss();
                        AccountManager.getInstance(this.f24184b.getApplicationContext()).logout();
                        WalletLoginHelper.getInstance().logout();
                        IAfterDismissCallback iAfterDismissCallback2 = this.f24185c;
                        if (iAfterDismissCallback2 != null) {
                            iAfterDismissCallback2.onLogout();
                        }
                    }
                }
            });
            dialog.findViewById(ResUtils.id(context, "ebpay_cancel")).setOnClickListener(new View.OnClickListener(dialog, iAfterDismissCallback) { // from class: com.baidu.wallet.base.widget.LoginOutHelper.2
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ Dialog f24186a;

                /* renamed from: b  reason: collision with root package name */
                public final /* synthetic */ IAfterDismissCallback f24187b;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {dialog, iAfterDismissCallback};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.f24186a = dialog;
                    this.f24187b = iAfterDismissCallback;
                }

                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, view) == null) {
                        this.f24186a.dismiss();
                        IAfterDismissCallback iAfterDismissCallback2 = this.f24187b;
                        if (iAfterDismissCallback2 != null) {
                            iAfterDismissCallback2.onCancel();
                        }
                    }
                }
            });
            dialog.setCanceledOnTouchOutside(true);
            Window window = dialog.getWindow();
            WindowManager.LayoutParams attributes = window.getAttributes();
            attributes.width = DisplayUtils.getDisplayWidth(context);
            attributes.y = (DisplayUtils.getDisplayHeight(context) - attributes.height) / 2;
            window.setAttributes(attributes);
            window.setWindowAnimations(ResUtils.style(context, "DialogWindowAnim"));
            dialog.show();
        }
    }
}
