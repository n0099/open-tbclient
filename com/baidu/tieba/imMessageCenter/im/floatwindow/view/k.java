package com.baidu.tieba.imMessageCenter.im.floatwindow.view;

import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.tbadk.core.view.HeadImageView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class k implements View.OnLongClickListener {
    final /* synthetic */ i buE;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(i iVar) {
        this.buE = iVar;
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
        relativeLayout = this.buE.buw;
        relativeLayout.getLocationOnScreen(iArr);
        int i2 = iArr[0];
        relativeLayout2 = this.buE.buw;
        com.baidu.tieba.imMessageCenter.im.floatwindow.b VP = com.baidu.tieba.imMessageCenter.im.floatwindow.b.VP();
        headImageView = this.buE.aBk;
        String url = headImageView.getUrl();
        i = this.buE.buA;
        VP.a(i2 + relativeLayout2.getMeasuredWidth(), iArr[1] - 25, url, i);
        this.buE.buB = true;
        headImageView2 = this.buE.aBk;
        headImageView2.setVisibility(4);
        textView = this.buE.btw;
        textView.setVisibility(4);
        relativeLayout3 = this.buE.buw;
        relativeLayout3.clearFocus();
        return false;
    }
}
