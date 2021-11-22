package com.baidu.wallet.base.widget.dialog.listener;

import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Build;
import android.view.View;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.wallet.core.utils.LogUtil;
/* loaded from: classes10.dex */
public class DelegateOnCancleListener implements DialogInterface.OnCancelListener {
    public static /* synthetic */ Interceptable $ic = null;

    /* renamed from: a  reason: collision with root package name */
    public static final String f58713a = "DelegateOnCancleListener";
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: b  reason: collision with root package name */
    public Dialog f58714b;
    public DialogInterface.OnCancelListener mOnCancleListener;

    public DelegateOnCancleListener(DialogInterface.OnCancelListener onCancelListener, Dialog dialog) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {onCancelListener, dialog};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.mOnCancleListener = onCancelListener;
        this.f58714b = dialog;
        if (Build.VERSION.SDK_INT >= 12) {
            dialog.getWindow().getDecorView().addOnAttachStateChangeListener(new View.OnAttachStateChangeListener(this) { // from class: com.baidu.wallet.base.widget.dialog.listener.DelegateOnCancleListener.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ DelegateOnCancleListener f58715a;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext2 = TitanRuntime.newInitContext();
                        newInitContext2.initArgs = r2;
                        Object[] objArr2 = {this};
                        interceptable2.invokeUnInit(65536, newInitContext2);
                        int i4 = newInitContext2.flag;
                        if ((i4 & 1) != 0) {
                            int i5 = i4 & 2;
                            newInitContext2.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext2);
                            return;
                        }
                    }
                    this.f58715a = this;
                }

                @Override // android.view.View.OnAttachStateChangeListener
                public void onViewAttachedToWindow(View view) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, view) == null) {
                        LogUtil.w(DelegateOnCancleListener.f58713a, "onWindowAttached, dialog=" + this);
                    }
                }

                @Override // android.view.View.OnAttachStateChangeListener
                public void onViewDetachedFromWindow(View view) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view) == null) {
                        LogUtil.d(DelegateOnCancleListener.f58713a, "Dialog.onWindowDetached");
                    }
                }
            });
        }
        this.f58714b.setOnDismissListener(new DialogInterface.OnDismissListener(this) { // from class: com.baidu.wallet.base.widget.dialog.listener.DelegateOnCancleListener.2
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ DelegateOnCancleListener f58716a;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext2 = TitanRuntime.newInitContext();
                    newInitContext2.initArgs = r2;
                    Object[] objArr2 = {this};
                    interceptable2.invokeUnInit(65536, newInitContext2);
                    int i4 = newInitContext2.flag;
                    if ((i4 & 1) != 0) {
                        int i5 = i4 & 2;
                        newInitContext2.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext2);
                        return;
                    }
                }
                this.f58716a = this;
            }

            @Override // android.content.DialogInterface.OnDismissListener
            public void onDismiss(DialogInterface dialogInterface) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeL(1048576, this, dialogInterface) == null) {
                    LogUtil.d(DelegateOnCancleListener.f58713a, "Dialog.onDismiss");
                    this.f58716a.f58714b = null;
                    this.f58716a.mOnCancleListener = null;
                }
            }
        });
    }

    @Override // android.content.DialogInterface.OnCancelListener
    public void onCancel(DialogInterface dialogInterface) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, dialogInterface) == null) {
            LogUtil.d(f58713a, "Dialog.onDismiss");
            DialogInterface.OnCancelListener onCancelListener = this.mOnCancleListener;
            if (onCancelListener != null) {
                onCancelListener.onCancel(dialogInterface);
            }
        }
    }
}
