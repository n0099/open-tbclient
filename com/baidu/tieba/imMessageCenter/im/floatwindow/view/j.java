package com.baidu.tieba.imMessageCenter.im.floatwindow.view;

import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.tbadk.core.view.HeadImageView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class j implements View.OnLongClickListener {
    final /* synthetic */ h cvU;

    /* JADX INFO: Access modifiers changed from: package-private */
    public j(h hVar) {
        this.cvU = hVar;
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
        relativeLayout = this.cvU.cvM;
        relativeLayout.getLocationOnScreen(iArr);
        int i2 = iArr[0];
        relativeLayout2 = this.cvU.cvM;
        com.baidu.tieba.imMessageCenter.im.floatwindow.b ajy = com.baidu.tieba.imMessageCenter.im.floatwindow.b.ajy();
        headImageView = this.cvU.aLx;
        String url = headImageView.getUrl();
        i = this.cvU.cvQ;
        ajy.a(i2 + relativeLayout2.getMeasuredWidth(), iArr[1] - 25, url, i);
        this.cvU.cvR = true;
        headImageView2 = this.cvU.aLx;
        headImageView2.setVisibility(4);
        textView = this.cvU.cuN;
        textView.setVisibility(4);
        relativeLayout3 = this.cvU.cvM;
        relativeLayout3.clearFocus();
        return false;
    }
}
