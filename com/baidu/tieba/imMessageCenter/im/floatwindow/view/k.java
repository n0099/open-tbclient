package com.baidu.tieba.imMessageCenter.im.floatwindow.view;

import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.tbadk.core.view.HeadImageView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class k implements View.OnLongClickListener {
    final /* synthetic */ i brC;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(i iVar) {
        this.brC = iVar;
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
        relativeLayout = this.brC.bru;
        relativeLayout.getLocationOnScreen(iArr);
        int i2 = iArr[0];
        relativeLayout2 = this.brC.bru;
        com.baidu.tieba.imMessageCenter.im.floatwindow.b Ul = com.baidu.tieba.imMessageCenter.im.floatwindow.b.Ul();
        headImageView = this.brC.azr;
        String url = headImageView.getUrl();
        i = this.brC.bry;
        Ul.a(i2 + relativeLayout2.getMeasuredWidth(), iArr[1] - 25, url, i);
        this.brC.brz = true;
        headImageView2 = this.brC.azr;
        headImageView2.setVisibility(4);
        textView = this.brC.bqw;
        textView.setVisibility(4);
        relativeLayout3 = this.brC.bru;
        relativeLayout3.clearFocus();
        return false;
    }
}
