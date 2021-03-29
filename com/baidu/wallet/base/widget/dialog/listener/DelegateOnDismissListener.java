package com.baidu.wallet.base.widget.dialog.listener;

import android.content.DialogInterface;
/* loaded from: classes5.dex */
public class DelegateOnDismissListener implements DialogInterface.OnDismissListener {

    /* renamed from: a  reason: collision with root package name */
    public DialogInterface.OnDismissListener f24060a;

    public DelegateOnDismissListener(DialogInterface.OnDismissListener onDismissListener) {
        this.f24060a = onDismissListener;
    }

    @Override // android.content.DialogInterface.OnDismissListener
    public void onDismiss(DialogInterface dialogInterface) {
        DialogInterface.OnDismissListener onDismissListener = this.f24060a;
        if (onDismissListener != null) {
            onDismissListener.onDismiss(dialogInterface);
            this.f24060a = null;
        }
    }
}
