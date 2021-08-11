package com.baidu.wallet.base.widget;

import android.app.Dialog;
import android.content.Context;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import com.baidu.apollon.utils.DisplayUtils;
import com.baidu.apollon.utils.DxmApplicationContextImpl;
import com.baidu.apollon.utils.ResUtils;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.wallet.api.WalletLoginHelper;
import com.baidu.wallet.base.datamodel.AccountManager;
/* loaded from: classes8.dex */
public class LoginOutHelper {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes8.dex */
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
                public final /* synthetic */ Dialog f60140a;

                /* renamed from: b  reason: collision with root package name */
                public final /* synthetic */ Context f60141b;

                /* renamed from: c  reason: collision with root package name */
                public final /* synthetic */ IAfterDismissCallback f60142c;

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
                    this.f60140a = dialog;
                    this.f60141b = context;
                    this.f60142c = iAfterDismissCallback;
                }

                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, view) == null) {
                        this.f60140a.dismiss();
                        AccountManager.getInstance(DxmApplicationContextImpl.getApplicationContext(this.f60141b)).logout();
                        WalletLoginHelper.getInstance().logout();
                        IAfterDismissCallback iAfterDismissCallback2 = this.f60142c;
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
                public final /* synthetic */ Dialog f60143a;

                /* renamed from: b  reason: collision with root package name */
                public final /* synthetic */ IAfterDismissCallback f60144b;

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
                    this.f60143a = dialog;
                    this.f60144b = iAfterDismissCallback;
                }

                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, view) == null) {
                        this.f60143a.dismiss();
                        IAfterDismissCallback iAfterDismissCallback2 = this.f60144b;
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
