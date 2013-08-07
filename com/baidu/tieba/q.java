package com.baidu.tieba;

import android.support.v4.view.bq;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.slidingmenu.lib.R;
/* loaded from: classes.dex */
class q implements bq {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ GuideActivity f1620a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public q(GuideActivity guideActivity) {
        this.f1620a = guideActivity;
    }

    @Override // android.support.v4.view.bq
    public void a_(int i) {
        LinearLayout linearLayout;
        LinearLayout linearLayout2;
        linearLayout = this.f1620a.i;
        int childCount = linearLayout.getChildCount();
        if (i < childCount) {
            for (int i2 = 0; i2 < childCount; i2++) {
                linearLayout2 = this.f1620a.i;
                ImageView imageView = (ImageView) linearLayout2.getChildAt(i2);
                if (i2 != i) {
                    imageView.setBackgroundResource(R.drawable.tag_page_rb_click);
                } else {
                    imageView.setBackgroundResource(R.drawable.tag_page_rb_normal);
                }
            }
        }
    }

    @Override // android.support.v4.view.bq
    public void b(int i) {
    }

    @Override // android.support.v4.view.bq
    public void a(int i, float f, int i2) {
    }
}
