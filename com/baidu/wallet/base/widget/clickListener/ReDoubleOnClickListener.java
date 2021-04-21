package com.baidu.wallet.base.widget.clickListener;

import android.view.View;
/* loaded from: classes5.dex */
public abstract class ReDoubleOnClickListener implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    public static boolean f23706a = true;

    /* renamed from: b  reason: collision with root package name */
    public static final Runnable f23707b = new Runnable() { // from class: com.baidu.wallet.base.widget.clickListener.ReDoubleOnClickListener.1
        @Override // java.lang.Runnable
        public void run() {
            boolean unused = ReDoubleOnClickListener.f23706a = true;
        }
    };

    public abstract void doClick(View view);

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        if (f23706a) {
            f23706a = false;
            view.post(f23707b);
            doClick(view);
        }
    }
}
