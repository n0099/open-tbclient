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
/* loaded from: classes8.dex */
public final class tbc {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String a = "CenterDialogManager";
    public static final tbc b;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes8.dex */
    public static final class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PayDialogType a;
        public final /* synthetic */ Dialog b;
        public final /* synthetic */ IViewEventListener c;
        public final /* synthetic */ ubc d;

        public a(PayDialogType payDialogType, Dialog dialog, IViewEventListener iViewEventListener, ubc ubcVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {payDialogType, dialog, iViewEventListener, ubcVar};
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
            this.d = ubcVar;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                String a = tbc.a(tbc.b);
                RLog.info(a, "empty click payDialogType:" + this.a.name());
                PayViewInfo payViewInfo = new PayViewInfo();
                payViewInfo.clickArea = CancelType.EMPTY_AREA_CLICK;
                payViewInfo.payDialogType = this.a;
                payViewInfo.viewDialog = this.b;
                IViewEventListener iViewEventListener = this.c;
                if (iViewEventListener != null && iViewEventListener.onInterceptView(payViewInfo)) {
                    return;
                }
                ubc ubcVar = this.d;
                if (ubcVar != null) {
                    ubcVar.a(CancelType.EMPTY_AREA_CLICK);
                }
                this.b.dismiss();
            }
        }
    }

    /* loaded from: classes8.dex */
    public static final class b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PayDialogType a;
        public final /* synthetic */ Dialog b;
        public final /* synthetic */ IViewEventListener c;
        public final /* synthetic */ ubc d;

        public b(PayDialogType payDialogType, Dialog dialog, IViewEventListener iViewEventListener, ubc ubcVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {payDialogType, dialog, iViewEventListener, ubcVar};
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
            this.d = ubcVar;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                String a = tbc.a(tbc.b);
                RLog.info(a, "btn close payDialogType:" + this.a.name());
                PayViewInfo payViewInfo = new PayViewInfo();
                payViewInfo.clickArea = CancelType.BUTTOM_AREA_CLICK;
                payViewInfo.payDialogType = this.a;
                payViewInfo.viewDialog = this.b;
                IViewEventListener iViewEventListener = this.c;
                if (iViewEventListener != null && iViewEventListener.onInterceptView(payViewInfo)) {
                    return;
                }
                ubc ubcVar = this.d;
                if (ubcVar != null) {
                    ubcVar.a(CancelType.BUTTOM_AREA_CLICK);
                }
                this.b.dismiss();
            }
        }
    }

    /* loaded from: classes8.dex */
    public static final class c implements DialogInterface.OnDismissListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ubc a;
        public final /* synthetic */ xbc b;

        public c(ubc ubcVar, xbc xbcVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ubcVar, xbcVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = ubcVar;
            this.b = xbcVar;
        }

        @Override // android.content.DialogInterface.OnDismissListener
        public final void onDismiss(DialogInterface dialogInterface) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, dialogInterface) == null) {
                ubc ubcVar = this.a;
                if (ubcVar != null) {
                    ubcVar.a(CancelType.ON_DIALOG_DISMISS);
                }
                tbc.b.c(this.b);
            }
        }
    }

    /* loaded from: classes8.dex */
    public static final class d implements DialogInterface.OnCancelListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ubc a;
        public final /* synthetic */ xbc b;

        public d(ubc ubcVar, xbc xbcVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ubcVar, xbcVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = ubcVar;
            this.b = xbcVar;
        }

        @Override // android.content.DialogInterface.OnCancelListener
        public final void onCancel(DialogInterface dialogInterface) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, dialogInterface) == null) {
                ubc ubcVar = this.a;
                if (ubcVar != null) {
                    ubcVar.a(CancelType.ON_DIALOG_CANCEL);
                }
                tbc.b.c(this.b);
            }
        }
    }

    /* loaded from: classes8.dex */
    public static final class e implements DialogInterface.OnKeyListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ubc a;

        public e(ubc ubcVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ubcVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = ubcVar;
        }

        @Override // android.content.DialogInterface.OnKeyListener
        public boolean onKey(DialogInterface dialogInterface, int i, KeyEvent keyEvent) {
            InterceptResult invokeLIL;
            ubc ubcVar;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLIL = interceptable.invokeLIL(1048576, this, dialogInterface, i, keyEvent)) == null) {
                String a = tbc.a(tbc.b);
                RLog.info(a, "onKey keyCode:" + i);
                if (keyEvent.getAction() == 0 && i == 4 && (ubcVar = this.a) != null) {
                    if (ubcVar == null) {
                        Intrinsics.throwNpe();
                    }
                    if (ubcVar.b(dialogInterface, CancelType.ON_DIALOG_CANCEL)) {
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
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948176884, "Lcom/baidu/tieba/tbc;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948176884, "Lcom/baidu/tieba/tbc;");
                return;
            }
        }
        b = new tbc();
    }

    public tbc() {
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

    public static final /* synthetic */ String a(tbc tbcVar) {
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

    public final void d(Context context, String str, View view2, ubc ubcVar, IViewEventListener iViewEventListener, PayDialogType payDialogType, Dialog dialog) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{context, str, view2, ubcVar, iViewEventListener, payDialogType, dialog}) == null) {
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
            window.findViewById(R.id.obfuscated_res_0x7f091f37).setOnClickListener(new a(payDialogType, dialog, iViewEventListener, ubcVar));
            ((Button) window.findViewById(R.id.obfuscated_res_0x7f0904ab)).setOnClickListener(new b(payDialogType, dialog, iViewEventListener, ubcVar));
            ((ViewGroup) window.findViewById(R.id.obfuscated_res_0x7f0907a2)).addView(view2);
        }
    }

    public final Dialog e(Context context, String str, View view2, ubc ubcVar, IViewEventListener iViewEventListener, PayDialogType payDialogType, PayFlowType payFlowType) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{context, str, view2, ubcVar, iViewEventListener, payDialogType, payFlowType})) == null) {
            if (!bbc.a.a(context)) {
                RLog.info(a, "showDialog ActivityInvalid....");
                return null;
            }
            xbc xbcVar = new xbc(context, R.style.obfuscated_res_0x7f100167, payFlowType);
            xbcVar.setCancelable(true);
            xbcVar.setCanceledOnTouchOutside(false);
            xbcVar.show();
            xbcVar.setOnDismissListener(new c(ubcVar, xbcVar));
            xbcVar.setOnCancelListener(new d(ubcVar, xbcVar));
            xbcVar.setOnKeyListener(new e(ubcVar));
            d(context, str, view2, ubcVar, iViewEventListener, payDialogType, xbcVar);
            return xbcVar;
        }
        return (Dialog) invokeCommon.objValue;
    }
}
