package com.baidu.tieba.imMessageCenter.im.floatwindow.view;

import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.tbadk.core.view.HeadImageView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class j implements View.OnLongClickListener {
    final /* synthetic */ h bMN;

    /* JADX INFO: Access modifiers changed from: package-private */
    public j(h hVar) {
        this.bMN = hVar;
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
        relativeLayout = this.bMN.bMF;
        relativeLayout.getLocationOnScreen(iArr);
        int i2 = iArr[0];
        relativeLayout2 = this.bMN.bMF;
        com.baidu.tieba.imMessageCenter.im.floatwindow.b Yy = com.baidu.tieba.imMessageCenter.im.floatwindow.b.Yy();
        headImageView = this.bMN.aGQ;
        String url = headImageView.getUrl();
        i = this.bMN.bMJ;
        Yy.a(i2 + relativeLayout2.getMeasuredWidth(), iArr[1] - 25, url, i);
        this.bMN.bMK = true;
        headImageView2 = this.bMN.aGQ;
        headImageView2.setVisibility(4);
        textView = this.bMN.bLG;
        textView.setVisibility(4);
        relativeLayout3 = this.bMN.bMF;
        relativeLayout3.clearFocus();
        return false;
    }
}
