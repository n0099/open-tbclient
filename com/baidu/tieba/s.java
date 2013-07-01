package com.baidu.tieba;

import android.support.v4.view.bq;
import android.view.animation.Animation;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.slidingmenu.lib.R;
/* loaded from: classes.dex */
class s implements bq {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ LabelActivity f1393a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public s(LabelActivity labelActivity) {
        this.f1393a = labelActivity;
    }

    @Override // android.support.v4.view.bq
    public void a_(int i) {
        LinearLayout linearLayout;
        Animation animation;
        Animation animation2;
        LinearLayout linearLayout2;
        linearLayout = this.f1393a.t;
        int childCount = linearLayout.getChildCount();
        if (i < childCount) {
            for (int i2 = 0; i2 < childCount; i2++) {
                linearLayout2 = this.f1393a.t;
                ImageView imageView = (ImageView) linearLayout2.getChildAt(i2);
                if (i2 != i) {
                    imageView.setBackgroundResource(R.drawable.tag_page_rb_click);
                } else {
                    imageView.setBackgroundResource(R.drawable.tag_page_rb_normal);
                }
            }
        }
        animation = this.f1393a.w;
        animation.reset();
        animation2 = this.f1393a.w;
        animation2.start();
    }

    @Override // android.support.v4.view.bq
    public void b(int i) {
    }

    @Override // android.support.v4.view.bq
    public void a(int i, float f, int i2) {
    }
}
