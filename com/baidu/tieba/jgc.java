package com.baidu.tieba;

import android.animation.ObjectAnimator;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.yy.mobile.framework.revenuesdk.baseapi.log.RLog;
import kotlin.jvm.internal.Intrinsics;
import tv.athena.revenue.api.pay.params.PayFlowType;
import tv.athena.revenue.payui.model.PayViewInfo;
import tv.athena.revenue.payui.view.IViewEventListener;
import tv.athena.revenue.payui.view.dialog.CancelType;
import tv.athena.revenue.payui.view.dialog.PayDialogType;
/* loaded from: classes6.dex */
public final class jgc {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String a = "CenterDialogManager";
    public static final jgc b;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes6.dex */
    public static final class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PayDialogType a;
        public final /* synthetic */ Dialog b;
        public final /* synthetic */ IViewEventListener c;
        public final /* synthetic */ kgc d;

        public a(PayDialogType payDialogType, Dialog dialog, IViewEventListener iViewEventListener, kgc kgcVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {payDialogType, dialog, iViewEventListener, kgcVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = payDialogType;
            this.b = dialog;
            this.c = iViewEventListener;
            this.d = kgcVar;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                String a = jgc.a(jgc.b);
                RLog.info(a, "empty click payDialogType:" + this.a.name());
                PayViewInfo payViewInfo = new PayViewInfo();
                payViewInfo.clickArea = CancelType.EMPTY_AREA_CLICK;
                payViewInfo.payDialogType = this.a;
                payViewInfo.viewDialog = this.b;
                IViewEventListener iViewEventListener = this.c;
                if (iViewEventListener != null && iViewEventListener.onInterceptView(payViewInfo)) {
                    return;
                }
                kgc kgcVar = this.d;
                if (kgcVar != null) {
                    kgcVar.a(CancelType.EMPTY_AREA_CLICK);
                }
                this.b.dismiss();
            }
        }
    }

    /* loaded from: classes6.dex */
    public static final class b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PayDialogType a;
        public final /* synthetic */ Dialog b;
        public final /* synthetic */ IViewEventListener c;
        public final /* synthetic */ kgc d;

        public b(PayDialogType payDialogType, Dialog dialog, IViewEventListener iViewEventListener, kgc kgcVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {payDialogType, dialog, iViewEventListener, kgcVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = payDialogType;
            this.b = dialog;
            this.c = iViewEventListener;
            this.d = kgcVar;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                String a = jgc.a(jgc.b);
                RLog.info(a, "btn close payDialogType:" + this.a.name());
                PayViewInfo payViewInfo = new PayViewInfo();
                payViewInfo.clickArea = CancelType.BUTTOM_AREA_CLICK;
                payViewInfo.payDialogType = this.a;
                payViewInfo.viewDialog = this.b;
                IViewEventListener iViewEventListener = this.c;
                if (iViewEventListener != null && iViewEventListener.onInterceptView(payViewInfo)) {
                    return;
                }
                kgc kgcVar = this.d;
                if (kgcVar != null) {
                    kgcVar.a(CancelType.BUTTOM_AREA_CLICK);
                }
                this.b.dismiss();
            }
        }
    }

    /* loaded from: classes6.dex */
    public static final class c implements DialogInterface.OnDismissListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ kgc a;
        public final /* synthetic */ ngc b;

        public c(kgc kgcVar, ngc ngcVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {kgcVar, ngcVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = kgcVar;
            this.b = ngcVar;
        }

        @Override // android.content.DialogInterface.OnDismissListener
        public final void onDismiss(DialogInterface dialogInterface) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, dialogInterface) == null) {
                kgc kgcVar = this.a;
                if (kgcVar != null) {
                    kgcVar.a(CancelType.ON_DIALOG_DISMISS);
                }
                jgc.b.c(this.b);
            }
        }
    }

    /* loaded from: classes6.dex */
    public static final class d implements DialogInterface.OnCancelListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ kgc a;
        public final /* synthetic */ ngc b;

        public d(kgc kgcVar, ngc ngcVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {kgcVar, ngcVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = kgcVar;
            this.b = ngcVar;
        }

        @Override // android.content.DialogInterface.OnCancelListener
        public final void onCancel(DialogInterface dialogInterface) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, dialogInterface) == null) {
                kgc kgcVar = this.a;
                if (kgcVar != null) {
                    kgcVar.a(CancelType.ON_DIALOG_CANCEL);
                }
                jgc.b.c(this.b);
            }
        }
    }

    /* loaded from: classes6.dex */
    public static final class e implements DialogInterface.OnKeyListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ kgc a;

        public e(kgc kgcVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {kgcVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = kgcVar;
        }

        @Override // android.content.DialogInterface.OnKeyListener
        public boolean onKey(DialogInterface dialogInterface, int i, KeyEvent keyEvent) {
            InterceptResult invokeLIL;
            kgc kgcVar;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLIL = interceptable.invokeLIL(1048576, this, dialogInterface, i, keyEvent)) == null) {
                String a = jgc.a(jgc.b);
                RLog.info(a, "onKey keyCode:" + i);
                if (keyEvent.getAction() == 0 && i == 4 && (kgcVar = this.a) != null) {
                    if (kgcVar == null) {
                        Intrinsics.throwNpe();
                    }
                    if (kgcVar.b(dialogInterface, CancelType.ON_DIALOG_CANCEL)) {
                        return true;
                    }
                }
                return false;
            }
            return invokeLIL.booleanValue;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947883779, "Lcom/baidu/tieba/jgc;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947883779, "Lcom/baidu/tieba/jgc;");
                return;
            }
        }
        b = new jgc();
    }

    public jgc() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    public static final /* synthetic */ String a(jgc jgcVar) {
        return a;
    }

    public final void c(Dialog dialog) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048576, this, dialog) != null) || dialog == null) {
            return;
        }
        Window window = dialog.getWindow();
        Intrinsics.checkExpressionValueIsNotNull(window, "dialog.getWindow()");
        ViewGroup viewGroup = (ViewGroup) window.findViewById(R.id.root_loading);
        ImageView imageView = (ImageView) window.findViewById(R.id.iv_loading_circle);
        if (viewGroup != null && imageView != null) {
            viewGroup.setVisibility(8);
            Object tag = imageView.getTag();
            if (!(tag instanceof ObjectAnimator)) {
                tag = null;
            }
            ObjectAnimator objectAnimator = (ObjectAnimator) tag;
            if (objectAnimator != null) {
                objectAnimator.cancel();
                imageView.setTag(null);
                RLog.debug(a, "hideDialogLoading->oldRotateAnimator.cancel()");
            }
        }
    }

    public final void d(Context context, String str, View view2, kgc kgcVar, IViewEventListener iViewEventListener, PayDialogType payDialogType, Dialog dialog) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{context, str, view2, kgcVar, iViewEventListener, payDialogType, dialog}) == null) {
            Window window = dialog.getWindow();
            Intrinsics.checkExpressionValueIsNotNull(window, "centerDialog.getWindow()");
            window.setGravity(17);
            WindowManager.LayoutParams attributes = window.getAttributes();
            Intrinsics.checkExpressionValueIsNotNull(attributes, "window.getAttributes()");
            attributes.width = -2;
            attributes.height = -2;
            window.setAttributes(attributes);
            window.setWindowAnimations(R.style.obfuscated_res_0x7f100164);
            window.setContentView(R.layout.pay_ui_center_dialog_pay_common);
            View findViewById = window.findViewById(R.id.tv_title);
            Intrinsics.checkExpressionValueIsNotNull(findViewById, "window.findViewById<TextView>(R.id.tv_title)");
            ((TextView) findViewById).setText(str);
            window.findViewById(R.id.obfuscated_res_0x7f091f8b).setOnClickListener(new a(payDialogType, dialog, iViewEventListener, kgcVar));
            ((Button) window.findViewById(R.id.obfuscated_res_0x7f0904be)).setOnClickListener(new b(payDialogType, dialog, iViewEventListener, kgcVar));
            ((ViewGroup) window.findViewById(R.id.obfuscated_res_0x7f0907bc)).addView(view2);
        }
    }

    public final Dialog e(Context context, String str, View view2, kgc kgcVar, IViewEventListener iViewEventListener, PayDialogType payDialogType, PayFlowType payFlowType) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{context, str, view2, kgcVar, iViewEventListener, payDialogType, payFlowType})) == null) {
            if (!rfc.a.a(context)) {
                RLog.info(a, "showDialog ActivityInvalid....");
                return null;
            }
            ngc ngcVar = new ngc(context, R.style.obfuscated_res_0x7f100167, payFlowType);
            ngcVar.setCancelable(true);
            ngcVar.setCanceledOnTouchOutside(false);
            ngcVar.show();
            ngcVar.setOnDismissListener(new c(kgcVar, ngcVar));
            ngcVar.setOnCancelListener(new d(kgcVar, ngcVar));
            ngcVar.setOnKeyListener(new e(kgcVar));
            d(context, str, view2, kgcVar, iViewEventListener, payDialogType, ngcVar);
            return ngcVar;
        }
        return (Dialog) invokeCommon.objValue;
    }
}
