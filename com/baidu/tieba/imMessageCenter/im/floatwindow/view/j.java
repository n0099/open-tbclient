package com.baidu.tieba.imMessageCenter.im.floatwindow.view;

import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.tbadk.core.view.HeadImageView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class j implements View.OnLongClickListener {
    final /* synthetic */ h deh;

    /* JADX INFO: Access modifiers changed from: package-private */
    public j(h hVar) {
        this.deh = hVar;
    }

    @Override // android.view.View.OnLongClickListener
    public boolean onLongClick(View view) {
        RelativeLayout relativeLayout;
        RelativeLayout relativeLayout2;
        HeadImageView headImageView;
        int i;
        HeadImageView headImageView2;
        TextView textView;
        RelativeLayout relativeLayout3;
        int[] iArr = new int[2];
        relativeLayout = this.deh.ddZ;
        relativeLayout.getLocationOnScreen(iArr);
        int i2 = iArr[0];
        relativeLayout2 = this.deh.ddZ;
        com.baidu.tieba.imMessageCenter.im.floatwindow.b asy = com.baidu.tieba.imMessageCenter.im.floatwindow.b.asy();
        headImageView = this.deh.aPP;
        String url = headImageView.getUrl();
        i = this.deh.ded;
        asy.a(i2 + relativeLayout2.getMeasuredWidth(), iArr[1] - 25, url, i);
        this.deh.dee = true;
        headImageView2 = this.deh.aPP;
        headImageView2.setVisibility(4);
        textView = this.deh.dda;
        textView.setVisibility(4);
        relativeLayout3 = this.deh.ddZ;
        relativeLayout3.clearFocus();
        return false;
    }
}
