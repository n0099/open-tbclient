package com.baidu.tieba;

import android.view.animation.Animation;
import android.widget.ImageView;
import android.widget.LinearLayout;
/* loaded from: classes.dex */
class o implements android.support.v4.view.aj {
    final /* synthetic */ LabelActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public o(LabelActivity labelActivity) {
        this.a = labelActivity;
    }

    @Override // android.support.v4.view.aj
    public void a(int i) {
        LinearLayout linearLayout;
        Animation animation;
        Animation animation2;
        LinearLayout linearLayout2;
        linearLayout = this.a.t;
        int childCount = linearLayout.getChildCount();
        if (i < childCount) {
            for (int i2 = 0; i2 < childCount; i2++) {
                linearLayout2 = this.a.t;
                ImageView imageView = (ImageView) linearLayout2.getChildAt(i2);
                if (i2 != i) {
                    imageView.setBackgroundResource(R.drawable.tag_page_rb_click);
                } else {
                    imageView.setBackgroundResource(R.drawable.tag_page_rb_normal);
                }
            }
        }
        animation = this.a.w;
        animation.reset();
        animation2 = this.a.w;
        animation2.start();
    }

    @Override // android.support.v4.view.aj
    public void b(int i) {
    }

    @Override // android.support.v4.view.aj
    public void a(int i, float f, int i2) {
    }
}
