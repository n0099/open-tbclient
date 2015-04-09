package com.baidu.tieba.imMessageCenter.im.floatwindow.view;

import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.tbadk.core.view.HeadImageView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class k implements View.OnLongClickListener {
    final /* synthetic */ i brS;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(i iVar) {
        this.brS = iVar;
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
        relativeLayout = this.brS.brK;
        relativeLayout.getLocationOnScreen(iArr);
        int i2 = iArr[0];
        relativeLayout2 = this.brS.brK;
        com.baidu.tieba.imMessageCenter.im.floatwindow.b Uy = com.baidu.tieba.imMessageCenter.im.floatwindow.b.Uy();
        headImageView = this.brS.azz;
        String url = headImageView.getUrl();
        i = this.brS.brO;
        Uy.a(i2 + relativeLayout2.getMeasuredWidth(), iArr[1] - 25, url, i);
        this.brS.brP = true;
        headImageView2 = this.brS.azz;
        headImageView2.setVisibility(4);
        textView = this.brS.bqM;
        textView.setVisibility(4);
        relativeLayout3 = this.brS.brK;
        relativeLayout3.clearFocus();
        return false;
    }
}
