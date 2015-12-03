package com.baidu.tieba.imMessageCenter.im.floatwindow.view;

import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.tbadk.core.view.HeadImageView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class j implements View.OnLongClickListener {
    final /* synthetic */ h cbR;

    /* JADX INFO: Access modifiers changed from: package-private */
    public j(h hVar) {
        this.cbR = hVar;
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
        relativeLayout = this.cbR.cbJ;
        relativeLayout.getLocationOnScreen(iArr);
        int i2 = iArr[0];
        relativeLayout2 = this.cbR.cbJ;
        com.baidu.tieba.imMessageCenter.im.floatwindow.b abE = com.baidu.tieba.imMessageCenter.im.floatwindow.b.abE();
        headImageView = this.cbR.aJP;
        String url = headImageView.getUrl();
        i = this.cbR.cbN;
        abE.a(i2 + relativeLayout2.getMeasuredWidth(), iArr[1] - 25, url, i);
        this.cbR.cbO = true;
        headImageView2 = this.cbR.aJP;
        headImageView2.setVisibility(4);
        textView = this.cbR.caK;
        textView.setVisibility(4);
        relativeLayout3 = this.cbR.cbJ;
        relativeLayout3.clearFocus();
        return false;
    }
}
