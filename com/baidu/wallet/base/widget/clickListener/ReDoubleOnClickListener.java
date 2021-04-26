package com.baidu.wallet.base.widget.clickListener;

import android.view.View;
/* loaded from: classes5.dex */
public abstract class ReDoubleOnClickListener implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    public static boolean f24444a = true;

    /* renamed from: b  reason: collision with root package name */
    public static final Runnable f24445b = new Runnable() { // from class: com.baidu.wallet.base.widget.clickListener.ReDoubleOnClickListener.1
        @Override // java.lang.Runnable
        public void run() {
            boolean unused = ReDoubleOnClickListener.f24444a = true;
        }
    };

    public abstract void doClick(View view);

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        if (f24444a) {
            f24444a = false;
            view.post(f24445b);
            doClick(view);
        }
    }
}
