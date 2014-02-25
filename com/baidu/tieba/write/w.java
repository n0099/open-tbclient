package com.baidu.tieba.write;

import android.view.View;
import android.widget.LinearLayout;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class w implements Runnable {
    final /* synthetic */ v a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public w(v vVar) {
        this.a = vVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        View view;
        int i;
        View view2;
        view = this.a.h;
        if (view != null) {
            int childCount = ((LinearLayout) this.a.getChildAt(0)).getChildCount();
            int i2 = 0;
            while (true) {
                if (i2 >= childCount) {
                    i = 0;
                    break;
                }
                View childAt = ((LinearLayout) this.a.getChildAt(0)).getChildAt(i2);
                view2 = this.a.h;
                if (childAt != view2) {
                    i2++;
                } else {
                    i = childAt.getRight();
                    break;
                }
            }
            this.a.h = null;
            int width = i - this.a.getWidth();
            if (width > 0) {
                this.a.scrollBy(width, 0);
            }
        }
    }
}
