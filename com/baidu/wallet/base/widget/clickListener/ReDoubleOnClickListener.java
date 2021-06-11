package com.baidu.wallet.base.widget.clickListener;

import android.view.View;
/* loaded from: classes5.dex */
public abstract class ReDoubleOnClickListener implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    public static boolean f23721a = true;

    /* renamed from: b  reason: collision with root package name */
    public static final Runnable f23722b = new Runnable() { // from class: com.baidu.wallet.base.widget.clickListener.ReDoubleOnClickListener.1
        @Override // java.lang.Runnable
        public void run() {
            boolean unused = ReDoubleOnClickListener.f23721a = true;
        }
    };

    public abstract void doClick(View view);

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        if (f23721a) {
            f23721a = false;
            view.post(f23722b);
            doClick(view);
        }
    }
}
