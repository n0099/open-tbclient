package com.baidu.tieba.imMessageCenter.im.floatwindow.view;

import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.tbadk.core.view.HeadImageView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class j implements View.OnLongClickListener {
    final /* synthetic */ h cfR;

    /* JADX INFO: Access modifiers changed from: package-private */
    public j(h hVar) {
        this.cfR = hVar;
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
        relativeLayout = this.cfR.cfJ;
        relativeLayout.getLocationOnScreen(iArr);
        int i2 = iArr[0];
        relativeLayout2 = this.cfR.cfJ;
        com.baidu.tieba.imMessageCenter.im.floatwindow.b acN = com.baidu.tieba.imMessageCenter.im.floatwindow.b.acN();
        headImageView = this.cfR.aLn;
        String url = headImageView.getUrl();
        i = this.cfR.cfN;
        acN.a(i2 + relativeLayout2.getMeasuredWidth(), iArr[1] - 25, url, i);
        this.cfR.cfO = true;
        headImageView2 = this.cfR.aLn;
        headImageView2.setVisibility(4);
        textView = this.cfR.ceL;
        textView.setVisibility(4);
        relativeLayout3 = this.cfR.cfJ;
        relativeLayout3.clearFocus();
        return false;
    }
}
