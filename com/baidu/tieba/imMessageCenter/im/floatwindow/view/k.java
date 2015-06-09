package com.baidu.tieba.imMessageCenter.im.floatwindow.view;

import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.tbadk.core.view.HeadImageView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class k implements View.OnLongClickListener {
    final /* synthetic */ i buF;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(i iVar) {
        this.buF = iVar;
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
        relativeLayout = this.buF.bux;
        relativeLayout.getLocationOnScreen(iArr);
        int i2 = iArr[0];
        relativeLayout2 = this.buF.bux;
        com.baidu.tieba.imMessageCenter.im.floatwindow.b VQ = com.baidu.tieba.imMessageCenter.im.floatwindow.b.VQ();
        headImageView = this.buF.aBl;
        String url = headImageView.getUrl();
        i = this.buF.buB;
        VQ.a(i2 + relativeLayout2.getMeasuredWidth(), iArr[1] - 25, url, i);
        this.buF.buC = true;
        headImageView2 = this.buF.aBl;
        headImageView2.setVisibility(4);
        textView = this.buF.btx;
        textView.setVisibility(4);
        relativeLayout3 = this.buF.bux;
        relativeLayout3.clearFocus();
        return false;
    }
}
