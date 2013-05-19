package com.baidu.tieba;

import android.widget.ImageView;
import android.widget.LinearLayout;
import com.slidingmenu.lib.R;
/* loaded from: classes.dex */
class l implements android.support.v4.view.aj {
    final /* synthetic */ GuideActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public l(GuideActivity guideActivity) {
        this.a = guideActivity;
    }

    @Override // android.support.v4.view.aj
    public void a(int i) {
        LinearLayout linearLayout;
        LinearLayout linearLayout2;
        linearLayout = this.a.j;
        int childCount = linearLayout.getChildCount();
        if (i < childCount) {
            for (int i2 = 0; i2 < childCount; i2++) {
                linearLayout2 = this.a.j;
                ImageView imageView = (ImageView) linearLayout2.getChildAt(i2);
                if (i2 != i) {
                    imageView.setBackgroundResource(R.drawable.tag_page_rb_click);
                } else {
                    imageView.setBackgroundResource(R.drawable.tag_page_rb_normal);
                }
            }
        }
    }

    @Override // android.support.v4.view.aj
    public void b(int i) {
    }

    @Override // android.support.v4.view.aj
    public void a(int i, float f, int i2) {
    }
}
