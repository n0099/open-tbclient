package com.baidu.tieba.play;

import android.view.View;
import com.baidu.tbadk.core.view.at;
/* loaded from: classes.dex */
public class a implements Runnable {
    public View mChildView;

    public void bk(View view) {
        this.mChildView = view;
    }

    @Override // java.lang.Runnable
    public void run() {
        if (at.vG().vJ() <= 0 && this.mChildView != null && (this.mChildView.getTag() instanceof d)) {
            ((d) this.mChildView.getTag()).IA();
        }
    }
}
