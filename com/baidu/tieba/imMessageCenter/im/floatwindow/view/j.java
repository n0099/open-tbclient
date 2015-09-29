package com.baidu.tieba.imMessageCenter.im.floatwindow.view;

import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.tbadk.core.view.HeadImageView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class j implements View.OnLongClickListener {
    final /* synthetic */ h bMh;

    /* JADX INFO: Access modifiers changed from: package-private */
    public j(h hVar) {
        this.bMh = hVar;
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
        relativeLayout = this.bMh.bLZ;
        relativeLayout.getLocationOnScreen(iArr);
        int i2 = iArr[0];
        relativeLayout2 = this.bMh.bLZ;
        com.baidu.tieba.imMessageCenter.im.floatwindow.b Yh = com.baidu.tieba.imMessageCenter.im.floatwindow.b.Yh();
        headImageView = this.bMh.aHL;
        String url = headImageView.getUrl();
        i = this.bMh.bMd;
        Yh.a(i2 + relativeLayout2.getMeasuredWidth(), iArr[1] - 25, url, i);
        this.bMh.bMe = true;
        headImageView2 = this.bMh.aHL;
        headImageView2.setVisibility(4);
        textView = this.bMh.bLa;
        textView.setVisibility(4);
        relativeLayout3 = this.bMh.bLZ;
        relativeLayout3.clearFocus();
        return false;
    }
}
