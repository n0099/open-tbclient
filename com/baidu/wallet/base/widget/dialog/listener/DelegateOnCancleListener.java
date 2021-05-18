package com.baidu.wallet.base.widget.dialog.listener;

import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Build;
import android.view.View;
import com.baidu.wallet.core.utils.LogUtil;
/* loaded from: classes5.dex */
public class DelegateOnCancleListener implements DialogInterface.OnCancelListener {

    /* renamed from: a  reason: collision with root package name */
    public static final String f23732a = "DelegateOnCancleListener";

    /* renamed from: b  reason: collision with root package name */
    public Dialog f23733b;
    public DialogInterface.OnCancelListener mOnCancleListener;

    public DelegateOnCancleListener(DialogInterface.OnCancelListener onCancelListener, Dialog dialog) {
        this.mOnCancleListener = onCancelListener;
        this.f23733b = dialog;
        if (Build.VERSION.SDK_INT >= 12) {
            dialog.getWindow().getDecorView().addOnAttachStateChangeListener(new View.OnAttachStateChangeListener() { // from class: com.baidu.wallet.base.widget.dialog.listener.DelegateOnCancleListener.1
                @Override // android.view.View.OnAttachStateChangeListener
                public void onViewAttachedToWindow(View view) {
                    LogUtil.w(DelegateOnCancleListener.f23732a, "onWindowAttached, dialog=" + this);
                }

                @Override // android.view.View.OnAttachStateChangeListener
                public void onViewDetachedFromWindow(View view) {
                    LogUtil.d(DelegateOnCancleListener.f23732a, "Dialog.onWindowDetached");
                }
            });
        }
        this.f23733b.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.baidu.wallet.base.widget.dialog.listener.DelegateOnCancleListener.2
            @Override // android.content.DialogInterface.OnDismissListener
            public void onDismiss(DialogInterface dialogInterface) {
                LogUtil.d(DelegateOnCancleListener.f23732a, "Dialog.onDismiss");
                DelegateOnCancleListener.this.f23733b = null;
                DelegateOnCancleListener.this.mOnCancleListener = null;
            }
        });
    }

    @Override // android.content.DialogInterface.OnCancelListener
    public void onCancel(DialogInterface dialogInterface) {
        LogUtil.d(f23732a, "Dialog.onDismiss");
        DialogInterface.OnCancelListener onCancelListener = this.mOnCancleListener;
        if (onCancelListener != null) {
            onCancelListener.onCancel(dialogInterface);
        }
    }
}
