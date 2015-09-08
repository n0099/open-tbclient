package com.baidu.tieba.imMessageCenter.im.floatwindow.view;

import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.tbadk.core.view.HeadImageView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class j implements View.OnLongClickListener {
    final /* synthetic */ h bJc;

    /* JADX INFO: Access modifiers changed from: package-private */
    public j(h hVar) {
        this.bJc = hVar;
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
        relativeLayout = this.bJc.bIU;
        relativeLayout.getLocationOnScreen(iArr);
        int i2 = iArr[0];
        relativeLayout2 = this.bJc.bIU;
        com.baidu.tieba.imMessageCenter.im.floatwindow.b Xz = com.baidu.tieba.imMessageCenter.im.floatwindow.b.Xz();
        headImageView = this.bJc.aIT;
        String url = headImageView.getUrl();
        i = this.bJc.bIY;
        Xz.a(i2 + relativeLayout2.getMeasuredWidth(), iArr[1] - 25, url, i);
        this.bJc.bIZ = true;
        headImageView2 = this.bJc.aIT;
        headImageView2.setVisibility(4);
        textView = this.bJc.bHV;
        textView.setVisibility(4);
        relativeLayout3 = this.bJc.bIU;
        relativeLayout3.clearFocus();
        return false;
    }
}
