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
import androidx.constraintlayout.motion.widget.Key;
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
import tv.athena.revenue.payui.model.PayFlowType;
import tv.athena.revenue.payui.model.PayViewInfo;
import tv.athena.revenue.payui.view.IViewEventListener;
import tv.athena.revenue.payui.view.dialog.CancelType;
import tv.athena.revenue.payui.view.dialog.PayDialogType;
/* loaded from: classes6.dex */
public final class x5a {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String a = "BottomDialogManager";
    public static final x5a b;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes6.dex */
    public static final class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PayDialogType a;
        public final /* synthetic */ z5a b;
        public final /* synthetic */ Dialog c;
        public final /* synthetic */ IViewEventListener d;

        public a(PayDialogType payDialogType, z5a z5aVar, Dialog dialog, IViewEventListener iViewEventListener) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {payDialogType, z5aVar, dialog, iViewEventListener};
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
            this.b = z5aVar;
            this.c = dialog;
            this.d = iViewEventListener;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                x5a x5aVar = x5a.b;
                String str = x5a.a;
                StringBuilder sb = new StringBuilder();
                sb.append("empty click payDialogType:");
                PayDialogType payDialogType = this.a;
                sb.append(payDialogType != null ? payDialogType.name() : null);
                RLog.info(str, sb.toString());
                z5a z5aVar = this.b;
                if (z5aVar != null) {
                    if (z5aVar == null) {
                        Intrinsics.throwNpe();
                    }
                    if (z5aVar.b(this.c)) {
                        x5a x5aVar2 = x5a.b;
                        String str2 = x5a.a;
                        StringBuilder sb2 = new StringBuilder();
                        sb2.append("empty click intercept ");
                        PayDialogType payDialogType2 = this.a;
                        sb2.append(payDialogType2 != null ? payDialogType2.name() : null);
                        RLog.info(str2, sb2.toString());
                        return;
                    }
                }
                PayViewInfo payViewInfo = new PayViewInfo();
                payViewInfo.clickArea = CancelType.EMPTY_AREA_CLICK;
                payViewInfo.payDialogType = this.a;
                payViewInfo.viewDialog = this.c;
                IViewEventListener iViewEventListener = this.d;
                if (iViewEventListener != null && iViewEventListener.onInterceptView(payViewInfo)) {
                    x5a x5aVar3 = x5a.b;
                    String str3 = x5a.a;
                    StringBuilder sb3 = new StringBuilder();
                    sb3.append("empty click onInterceptView ");
                    PayDialogType payDialogType3 = this.a;
                    sb3.append(payDialogType3 != null ? payDialogType3.name() : null);
                    RLog.info(str3, sb3.toString());
                    return;
                }
                z5a z5aVar2 = this.b;
                if (z5aVar2 != null) {
                    z5aVar2.a(CancelType.EMPTY_AREA_CLICK);
                }
                this.c.dismiss();
            }
        }
    }

    /* loaded from: classes6.dex */
    public static final class b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PayDialogType a;
        public final /* synthetic */ z5a b;
        public final /* synthetic */ Dialog c;
        public final /* synthetic */ IViewEventListener d;

        public b(PayDialogType payDialogType, z5a z5aVar, Dialog dialog, IViewEventListener iViewEventListener) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {payDialogType, z5aVar, dialog, iViewEventListener};
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
            this.b = z5aVar;
            this.c = dialog;
            this.d = iViewEventListener;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                x5a x5aVar = x5a.b;
                String str = x5a.a;
                StringBuilder sb = new StringBuilder();
                sb.append("btn close payDialogType:");
                PayDialogType payDialogType = this.a;
                sb.append(payDialogType != null ? payDialogType.name() : null);
                RLog.info(str, sb.toString());
                z5a z5aVar = this.b;
                if (z5aVar != null) {
                    if (z5aVar == null) {
                        Intrinsics.throwNpe();
                    }
                    if (z5aVar.b(this.c)) {
                        x5a x5aVar2 = x5a.b;
                        String str2 = x5a.a;
                        StringBuilder sb2 = new StringBuilder();
                        sb2.append("btn close intercept :");
                        PayDialogType payDialogType2 = this.a;
                        sb2.append(payDialogType2 != null ? payDialogType2.name() : null);
                        RLog.info(str2, sb2.toString());
                        return;
                    }
                }
                PayViewInfo payViewInfo = new PayViewInfo();
                payViewInfo.clickArea = CancelType.BUTTOM_AREA_CLICK;
                payViewInfo.payDialogType = this.a;
                payViewInfo.viewDialog = this.c;
                IViewEventListener iViewEventListener = this.d;
                if (iViewEventListener != null && iViewEventListener.onInterceptView(payViewInfo)) {
                    x5a x5aVar3 = x5a.b;
                    String str3 = x5a.a;
                    StringBuilder sb3 = new StringBuilder();
                    sb3.append("btn close onInterceptView :");
                    PayDialogType payDialogType3 = this.a;
                    sb3.append(payDialogType3 != null ? payDialogType3.name() : null);
                    RLog.info(str3, sb3.toString());
                    return;
                }
                z5a z5aVar2 = this.b;
                if (z5aVar2 != null) {
                    z5aVar2.a(CancelType.BUTTOM_AREA_CLICK);
                }
                this.c.dismiss();
            }
        }
    }

    /* loaded from: classes6.dex */
    public static final class c implements DialogInterface.OnDismissListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ z5a a;
        public final /* synthetic */ c6a b;

        public c(z5a z5aVar, c6a c6aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {z5aVar, c6aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = z5aVar;
            this.b = c6aVar;
        }

        @Override // android.content.DialogInterface.OnDismissListener
        public final void onDismiss(DialogInterface dialogInterface) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, dialogInterface) == null) {
                z5a z5aVar = this.a;
                if (z5aVar != null) {
                    z5aVar.a(CancelType.ON_DIALOG_DISMISS);
                }
                x5a.b.b(this.b);
            }
        }
    }

    /* loaded from: classes6.dex */
    public static final class d implements DialogInterface.OnCancelListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ z5a a;
        public final /* synthetic */ c6a b;

        public d(z5a z5aVar, c6a c6aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {z5aVar, c6aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = z5aVar;
            this.b = c6aVar;
        }

        @Override // android.content.DialogInterface.OnCancelListener
        public final void onCancel(DialogInterface dialogInterface) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, dialogInterface) == null) {
                z5a z5aVar = this.a;
                if (z5aVar != null) {
                    z5aVar.a(CancelType.ON_DIALOG_CANCEL);
                }
                x5a.b.b(this.b);
            }
        }
    }

    /* loaded from: classes6.dex */
    public static final class e implements DialogInterface.OnKeyListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PayDialogType a;
        public final /* synthetic */ z5a b;

        public e(PayDialogType payDialogType, z5a z5aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {payDialogType, z5aVar};
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
            this.b = z5aVar;
        }

        @Override // android.content.DialogInterface.OnKeyListener
        public boolean onKey(DialogInterface dialogInterface, int i, KeyEvent keyEvent) {
            InterceptResult invokeLIL;
            z5a z5aVar;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLIL = interceptable.invokeLIL(1048576, this, dialogInterface, i, keyEvent)) == null) {
                x5a x5aVar = x5a.b;
                String str = x5a.a;
                StringBuilder sb = new StringBuilder();
                sb.append("onKey keyCode:");
                sb.append(i);
                sb.append(" dialogType:");
                PayDialogType payDialogType = this.a;
                sb.append(payDialogType != null ? payDialogType.name() : null);
                RLog.info(str, sb.toString());
                if (keyEvent.getAction() == 0 && i == 4 && (z5aVar = this.b) != null) {
                    if (z5aVar == null) {
                        Intrinsics.throwNpe();
                    }
                    if (z5aVar.b(dialogInterface)) {
                        x5a x5aVar2 = x5a.b;
                        String str2 = x5a.a;
                        StringBuilder sb2 = new StringBuilder();
                        sb2.append("onKey intercept ");
                        PayDialogType payDialogType2 = this.a;
                        sb2.append(payDialogType2 != null ? payDialogType2.name() : null);
                        RLog.info(str2, sb2.toString());
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
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948252741, "Lcom/baidu/tieba/x5a;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948252741, "Lcom/baidu/tieba/x5a;");
                return;
            }
        }
        b = new x5a();
    }

    public x5a() {
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

    public final void b(Dialog dialog) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, dialog) == null) || dialog == null) {
            return;
        }
        Window window = dialog.getWindow();
        Intrinsics.checkExpressionValueIsNotNull(window, "dialog.getWindow()");
        ViewGroup viewGroup = (ViewGroup) window.findViewById(R.id.obfuscated_res_0x7f091c7c);
        ImageView imageView = (ImageView) window.findViewById(R.id.obfuscated_res_0x7f091015);
        if (viewGroup == null || imageView == null) {
            return;
        }
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

    public final void c(Context context, String str, View view2, z5a z5aVar, IViewEventListener iViewEventListener, PayDialogType payDialogType, Dialog dialog) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{context, str, view2, z5aVar, iViewEventListener, payDialogType, dialog}) == null) {
            Window window = dialog.getWindow();
            Intrinsics.checkExpressionValueIsNotNull(window, "bottomDialog.getWindow()");
            window.setGravity(80);
            WindowManager.LayoutParams attributes = window.getAttributes();
            Intrinsics.checkExpressionValueIsNotNull(attributes, "window.getAttributes()");
            attributes.width = -1;
            attributes.height = -2;
            window.setAttributes(attributes);
            window.setWindowAnimations(R.style.obfuscated_res_0x7f10014f);
            window.setContentView(R.layout.obfuscated_res_0x7f0d069f);
            View findViewById = window.findViewById(R.id.obfuscated_res_0x7f092419);
            Intrinsics.checkExpressionValueIsNotNull(findViewById, "window.findViewById<TextView>(R.id.tv_title)");
            ((TextView) findViewById).setText(str);
            window.findViewById(R.id.obfuscated_res_0x7f091c66).setOnClickListener(new a(payDialogType, z5aVar, dialog, iViewEventListener));
            ((Button) window.findViewById(R.id.obfuscated_res_0x7f09042f)).setOnClickListener(new b(payDialogType, z5aVar, dialog, iViewEventListener));
            ((ViewGroup) window.findViewById(R.id.obfuscated_res_0x7f0906d3)).addView(view2);
        }
    }

    public final Dialog d(Context context, String str, View view2, z5a z5aVar, IViewEventListener iViewEventListener, PayDialogType payDialogType, PayFlowType payFlowType) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{context, str, view2, z5aVar, iViewEventListener, payDialogType, payFlowType})) == null) ? e(context, str, view2, z5aVar, iViewEventListener, payDialogType, payFlowType, null) : (Dialog) invokeCommon.objValue;
    }

    public final Dialog e(Context context, String str, View view2, z5a z5aVar, IViewEventListener iViewEventListener, PayDialogType payDialogType, PayFlowType payFlowType, d6a d6aVar) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048579, this, new Object[]{context, str, view2, z5aVar, iViewEventListener, payDialogType, payFlowType, d6aVar})) == null) {
            if (!m5a.a.a(context)) {
                RLog.info(a, "showSimpleNumberInputDialog ActivityInvalid....");
                return null;
            }
            c6a c6aVar = new c6a(context, R.style.obfuscated_res_0x7f100153, payFlowType, d6aVar);
            c6aVar.setCancelable(true);
            c6aVar.setCanceledOnTouchOutside(true);
            c6aVar.show();
            c6aVar.setOnDismissListener(new c(z5aVar, c6aVar));
            c6aVar.setOnCancelListener(new d(z5aVar, c6aVar));
            c6aVar.setOnKeyListener(new e(payDialogType, z5aVar));
            c(context, str, view2, z5aVar, iViewEventListener, payDialogType, c6aVar);
            return c6aVar;
        }
        return (Dialog) invokeCommon.objValue;
    }

    public final void f(Dialog dialog) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048580, this, dialog) == null) || dialog == null) {
            return;
        }
        Window window = dialog.getWindow();
        Intrinsics.checkExpressionValueIsNotNull(window, "dialog.getWindow()");
        ViewGroup viewGroup = (ViewGroup) window.findViewById(R.id.obfuscated_res_0x7f091c7c);
        ImageView imageView = (ImageView) window.findViewById(R.id.obfuscated_res_0x7f091015);
        if (viewGroup == null || imageView == null) {
            return;
        }
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
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(imageView, Key.ROTATION, 0.0f, 360.0f);
        Intrinsics.checkExpressionValueIsNotNull(ofFloat, "ObjectAnimator.ofFloat(i…le, \"rotation\", 0f, 360f)");
        ofFloat.setDuration(1000L);
        ofFloat.setInterpolator(new LinearInterpolator());
        ofFloat.setRepeatCount(-1);
        ofFloat.start();
        imageView.setTag(ofFloat);
        RLog.debug(a, "showDialogLoading mRotateAnimator start()");
    }
}
