package com.baidu.tieba.play;

import android.view.View;
/* loaded from: classes.dex */
public class a implements Runnable {
    public View mChildView;

    @Override // java.lang.Runnable
    public void run() {
        if (this.mChildView != null && (this.mChildView.getTag() instanceof e)) {
            ((e) this.mChildView.getTag()).startPlay();
        }
    }
}
