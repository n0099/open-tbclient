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
import android.view.animation.LinearInterpolator;
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
import tv.athena.revenue.payui.model.PayUIKitConfig;
import tv.athena.revenue.payui.model.PayViewInfo;
import tv.athena.revenue.payui.view.IViewEventListener;
import tv.athena.revenue.payui.view.dialog.CancelType;
import tv.athena.revenue.payui.view.dialog.PayDialogType;
/* loaded from: classes8.dex */
public final class wac {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String a = "BottomDialogManager";
    public static final wac b;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes8.dex */
    public static final class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PayDialogType a;
        public final /* synthetic */ yac b;
        public final /* synthetic */ Dialog c;
        public final /* synthetic */ IViewEventListener d;

        public a(PayDialogType payDialogType, yac yacVar, Dialog dialog, IViewEventListener iViewEventListener) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {payDialogType, yacVar, dialog, iViewEventListener};
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
            this.b = yacVar;
            this.c = dialog;
            this.d = iViewEventListener;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view2) {
            String str;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                String a = wac.a(wac.b);
                StringBuilder sb = new StringBuilder();
                sb.append("empty click payDialogType:");
                PayDialogType payDialogType = this.a;
                String str2 = null;
                if (payDialogType != null) {
                    str = payDialogType.name();
                } else {
                    str = null;
                }
                sb.append(str);
                RLog.info(a, sb.toString());
                yac yacVar = this.b;
                if (yacVar != null) {
                    if (yacVar == null) {
                        Intrinsics.throwNpe();
                    }
                    if (yacVar.b(this.c, CancelType.EMPTY_AREA_CLICK)) {
                        String a2 = wac.a(wac.b);
                        StringBuilder sb2 = new StringBuilder();
                        sb2.append("empty click intercept ");
                        PayDialogType payDialogType2 = this.a;
                        if (payDialogType2 != null) {
                            str2 = payDialogType2.name();
                        }
                        sb2.append(str2);
                        RLog.info(a2, sb2.toString());
                        return;
                    }
                }
                PayViewInfo payViewInfo = new PayViewInfo();
                payViewInfo.clickArea = CancelType.EMPTY_AREA_CLICK;
                payViewInfo.payDialogType = this.a;
                payViewInfo.viewDialog = this.c;
                IViewEventListener iViewEventListener = this.d;
                if (iViewEventListener != null && iViewEventListener.onInterceptView(payViewInfo)) {
                    String a3 = wac.a(wac.b);
                    StringBuilder sb3 = new StringBuilder();
                    sb3.append("empty click onInterceptView ");
                    PayDialogType payDialogType3 = this.a;
                    if (payDialogType3 != null) {
                        str2 = payDialogType3.name();
                    }
                    sb3.append(str2);
                    RLog.info(a3, sb3.toString());
                    return;
                }
                yac yacVar2 = this.b;
                if (yacVar2 != null) {
                    yacVar2.a(CancelType.EMPTY_AREA_CLICK);
                }
                this.c.dismiss();
            }
        }
    }

    /* loaded from: classes8.dex */
    public static final class b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PayDialogType a;
        public final /* synthetic */ yac b;
        public final /* synthetic */ Dialog c;
        public final /* synthetic */ IViewEventListener d;

        public b(PayDialogType payDialogType, yac yacVar, Dialog dialog, IViewEventListener iViewEventListener) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {payDialogType, yacVar, dialog, iViewEventListener};
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
            this.b = yacVar;
            this.c = dialog;
            this.d = iViewEventListener;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view2) {
            String str;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                String a = wac.a(wac.b);
                StringBuilder sb = new StringBuilder();
                sb.append("btn close payDialogType:");
                PayDialogType payDialogType = this.a;
                String str2 = null;
                if (payDialogType != null) {
                    str = payDialogType.name();
                } else {
                    str = null;
                }
                sb.append(str);
                RLog.info(a, sb.toString());
                yac yacVar = this.b;
                if (yacVar != null) {
                    if (yacVar == null) {
                        Intrinsics.throwNpe();
                    }
                    if (yacVar.b(this.c, CancelType.BUTTOM_AREA_CLICK)) {
                        String a2 = wac.a(wac.b);
                        StringBuilder sb2 = new StringBuilder();
                        sb2.append("btn close intercept :");
                        PayDialogType payDialogType2 = this.a;
                        if (payDialogType2 != null) {
                            str2 = payDialogType2.name();
                        }
                        sb2.append(str2);
                        RLog.info(a2, sb2.toString());
                        return;
                    }
                }
                PayViewInfo payViewInfo = new PayViewInfo();
                payViewInfo.clickArea = CancelType.BUTTOM_AREA_CLICK;
                payViewInfo.payDialogType = this.a;
                payViewInfo.viewDialog = this.c;
                IViewEventListener iViewEventListener = this.d;
                if (iViewEventListener != null && iViewEventListener.onInterceptView(payViewInfo)) {
                    String a3 = wac.a(wac.b);
                    StringBuilder sb3 = new StringBuilder();
                    sb3.append("btn close onInterceptView :");
                    PayDialogType payDialogType3 = this.a;
                    if (payDialogType3 != null) {
                        str2 = payDialogType3.name();
                    }
                    sb3.append(str2);
                    RLog.info(a3, sb3.toString());
                    return;
                }
                yac yacVar2 = this.b;
                if (yacVar2 != null) {
                    yacVar2.a(CancelType.BUTTOM_AREA_CLICK);
                }
                this.c.dismiss();
            }
        }
    }

    /* loaded from: classes8.dex */
    public static final class c implements DialogInterface.OnDismissListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ yac a;
        public final /* synthetic */ bbc b;

        public c(yac yacVar, bbc bbcVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {yacVar, bbcVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = yacVar;
            this.b = bbcVar;
        }

        @Override // android.content.DialogInterface.OnDismissListener
        public final void onDismiss(DialogInterface dialogInterface) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, dialogInterface) == null) {
                yac yacVar = this.a;
                if (yacVar != null) {
                    yacVar.a(CancelType.ON_DIALOG_DISMISS);
                }
                wac.b.b(this.b);
            }
        }
    }

    /* loaded from: classes8.dex */
    public static final class d implements DialogInterface.OnCancelListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ yac a;
        public final /* synthetic */ bbc b;

        public d(yac yacVar, bbc bbcVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {yacVar, bbcVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = yacVar;
            this.b = bbcVar;
        }

        @Override // android.content.DialogInterface.OnCancelListener
        public final void onCancel(DialogInterface dialogInterface) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, dialogInterface) == null) {
                yac yacVar = this.a;
                if (yacVar != null) {
                    yacVar.a(CancelType.ON_DIALOG_CANCEL);
                }
                wac.b.b(this.b);
            }
        }
    }

    /* loaded from: classes8.dex */
    public static final class e implements DialogInterface.OnKeyListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PayDialogType a;
        public final /* synthetic */ yac b;

        public e(PayDialogType payDialogType, yac yacVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {payDialogType, yacVar};
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
            this.b = yacVar;
        }

        @Override // android.content.DialogInterface.OnKeyListener
        public boolean onKey(DialogInterface dialogInterface, int i, KeyEvent keyEvent) {
            InterceptResult invokeLIL;
            String str;
            yac yacVar;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLIL = interceptable.invokeLIL(1048576, this, dialogInterface, i, keyEvent)) == null) {
                String a = wac.a(wac.b);
                StringBuilder sb = new StringBuilder();
                sb.append("onKey keyCode:");
                sb.append(i);
                sb.append(" dialogType:");
                PayDialogType payDialogType = this.a;
                String str2 = null;
                if (payDialogType != null) {
                    str = payDialogType.name();
                } else {
                    str = null;
                }
                sb.append(str);
                RLog.info(a, sb.toString());
                if (keyEvent.getAction() == 0 && i == 4 && (yacVar = this.b) != null) {
                    if (yacVar == null) {
                        Intrinsics.throwNpe();
                    }
                    if (yacVar.b(dialogInterface, CancelType.ON_DIALOG_CANCEL)) {
                        String a2 = wac.a(wac.b);
                        StringBuilder sb2 = new StringBuilder();
                        sb2.append("onKey intercept ");
                        PayDialogType payDialogType2 = this.a;
                        if (payDialogType2 != null) {
                            str2 = payDialogType2.name();
                        }
                        sb2.append(str2);
                        RLog.info(a2, sb2.toString());
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
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948265296, "Lcom/baidu/tieba/wac;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948265296, "Lcom/baidu/tieba/wac;");
                return;
            }
        }
        b = new wac();
    }

    public wac() {
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

    public static final /* synthetic */ String a(wac wacVar) {
        return a;
    }

    public final void b(Dialog dialog) {
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
                RLog.debug(a, "hideDialogLoading oldRotateAnimator cancel()");
            }
        }
    }

    public final void c(Context context, PayUIKitConfig payUIKitConfig, String str, View view2, yac yacVar, IViewEventListener iViewEventListener, PayDialogType payDialogType, Dialog dialog, boolean z) {
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{context, payUIKitConfig, str, view2, yacVar, iViewEventListener, payDialogType, dialog, Boolean.valueOf(z)}) == null) {
            Window window = dialog.getWindow();
            Intrinsics.checkExpressionValueIsNotNull(window, "bottomDialog.getWindow()");
            window.setGravity(80);
            WindowManager.LayoutParams attributes = window.getAttributes();
            Intrinsics.checkExpressionValueIsNotNull(attributes, "window.getAttributes()");
            attributes.width = -1;
            attributes.height = -2;
            window.setAttributes(attributes);
            window.setWindowAnimations(R.style.obfuscated_res_0x7f100163);
            window.setContentView(R.layout.pay_ui_bottom_dialog_pay_common);
            View findViewById = window.findViewById(R.id.tv_title);
            Intrinsics.checkExpressionValueIsNotNull(findViewById, "window.findViewById<TextView>(R.id.tv_title)");
            ((TextView) findViewById).setText(str);
            ViewGroup viewGroup = (ViewGroup) window.findViewById(R.id.obfuscated_res_0x7f0907b1);
            Button button = (Button) window.findViewById(R.id.obfuscated_res_0x7f0904b8);
            View findViewById2 = window.findViewById(R.id.obfuscated_res_0x7f091f54);
            View findViewById3 = window.findViewById(R.id.ll_content);
            if (payUIKitConfig != null) {
                if (dac.a.b(payUIKitConfig)) {
                    i = R.drawable.pay_ui_bg_pay_common_bottom_dialog_red_bg;
                } else {
                    i = R.drawable.pay_ui_bg_pay_common_bottom_dialog_yellow_bg;
                }
                findViewById3.setBackgroundResource(i);
            }
            findViewById2.setOnClickListener(new a(payDialogType, yacVar, dialog, iViewEventListener));
            button.setOnClickListener(new b(payDialogType, yacVar, dialog, iViewEventListener));
            if (z && context != null) {
                viewGroup.setBackgroundColor(context.getResources().getColor(R.color.pay_ui_color_F6F7F8));
                viewGroup.setPadding(0, 0, 0, 0);
            }
            viewGroup.addView(view2);
        }
    }

    public final Dialog d(Context context, String str, View view2, yac yacVar, IViewEventListener iViewEventListener, PayDialogType payDialogType, PayFlowType payFlowType, PayUIKitConfig payUIKitConfig) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{context, str, view2, yacVar, iViewEventListener, payDialogType, payFlowType, payUIKitConfig})) == null) {
            return e(context, str, view2, yacVar, iViewEventListener, payDialogType, payFlowType, payUIKitConfig, false);
        }
        return (Dialog) invokeCommon.objValue;
    }

    public final Dialog e(Context context, String str, View view2, yac yacVar, IViewEventListener iViewEventListener, PayDialogType payDialogType, PayFlowType payFlowType, PayUIKitConfig payUIKitConfig, boolean z) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048579, this, new Object[]{context, str, view2, yacVar, iViewEventListener, payDialogType, payFlowType, payUIKitConfig, Boolean.valueOf(z)})) == null) {
            if (!fac.a.a(context)) {
                RLog.info(a, "showSimpleNumberInputDialog ActivityInvalid....");
                return null;
            }
            bbc bbcVar = new bbc(context, R.style.obfuscated_res_0x7f100167, payFlowType);
            bbcVar.setCancelable(true);
            bbcVar.setCanceledOnTouchOutside(true);
            bbcVar.show();
            bbcVar.setOnDismissListener(new c(yacVar, bbcVar));
            bbcVar.setOnCancelListener(new d(yacVar, bbcVar));
            bbcVar.setOnKeyListener(new e(payDialogType, yacVar));
            c(context, payUIKitConfig, str, view2, yacVar, iViewEventListener, payDialogType, bbcVar, z);
            return bbcVar;
        }
        return (Dialog) invokeCommon.objValue;
    }

    public final void f(Dialog dialog) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048580, this, dialog) != null) || dialog == null) {
            return;
        }
        Window window = dialog.getWindow();
        Intrinsics.checkExpressionValueIsNotNull(window, "dialog.getWindow()");
        ViewGroup viewGroup = (ViewGroup) window.findViewById(R.id.root_loading);
        ImageView imageView = (ImageView) window.findViewById(R.id.iv_loading_circle);
        if (viewGroup != null && imageView != null) {
            Object tag = imageView.getTag();
            if (!(tag instanceof ObjectAnimator)) {
                tag = null;
            }
            ObjectAnimator objectAnimator = (ObjectAnimator) tag;
            if (objectAnimator != null) {
                objectAnimator.cancel();
                imageView.setTag(null);
                RLog.debug(a, "showDialogLoading oldRotateAnimator cancel()");
            }
            viewGroup.setVisibility(0);
            ObjectAnimator ofFloat = ObjectAnimator.ofFloat(imageView, "rotation", 0.0f, 360.0f);
            Intrinsics.checkExpressionValueIsNotNull(ofFloat, "ObjectAnimator.ofFloat(i…le, \"rotation\", 0f, 360f)");
            ofFloat.setDuration(1000L);
            ofFloat.setInterpolator(new LinearInterpolator());
            ofFloat.setRepeatCount(-1);
            ofFloat.start();
            imageView.setTag(ofFloat);
            RLog.debug(a, "showDialogLoading mRotateAnimator start()");
        }
    }
}
