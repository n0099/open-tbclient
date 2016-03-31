package com.baidu.tieba.imMessageCenter.im.floatwindow.view;

import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.tbadk.core.view.HeadImageView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class j implements View.OnLongClickListener {
    final /* synthetic */ h cuX;

    /* JADX INFO: Access modifiers changed from: package-private */
    public j(h hVar) {
        this.cuX = hVar;
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
        relativeLayout = this.cuX.cuP;
        relativeLayout.getLocationOnScreen(iArr);
        int i2 = iArr[0];
        relativeLayout2 = this.cuX.cuP;
        com.baidu.tieba.imMessageCenter.im.floatwindow.b ajq = com.baidu.tieba.imMessageCenter.im.floatwindow.b.ajq();
        headImageView = this.cuX.aPn;
        String url = headImageView.getUrl();
        i = this.cuX.cuT;
        ajq.a(i2 + relativeLayout2.getMeasuredWidth(), iArr[1] - 25, url, i);
        this.cuX.cuU = true;
        headImageView2 = this.cuX.aPn;
        headImageView2.setVisibility(4);
        textView = this.cuX.ctP;
        textView.setVisibility(4);
        relativeLayout3 = this.cuX.cuP;
        relativeLayout3.clearFocus();
        return false;
    }
}
