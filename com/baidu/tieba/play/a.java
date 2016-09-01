package com.baidu.tieba.play;

import android.view.View;
import com.baidu.tbadk.core.view.au;
/* loaded from: classes.dex */
public class a implements Runnable {
    public View mChildView;

    public void bh(View view) {
        this.mChildView = view;
    }

    @Override // java.lang.Runnable
    public void run() {
        if (au.wK().wN() <= 0 && this.mChildView != null && (this.mChildView.getTag() instanceof d)) {
            ((d) this.mChildView.getTag()).Kz();
        }
    }
}
