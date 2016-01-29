package com.baidu.tieba.imMessageCenter.im.floatwindow.view;

import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.tbadk.core.view.HeadImageView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class j implements View.OnLongClickListener {
    final /* synthetic */ h ckr;

    /* JADX INFO: Access modifiers changed from: package-private */
    public j(h hVar) {
        this.ckr = hVar;
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
        relativeLayout = this.ckr.ckj;
        relativeLayout.getLocationOnScreen(iArr);
        int i2 = iArr[0];
        relativeLayout2 = this.ckr.ckj;
        com.baidu.tieba.imMessageCenter.im.floatwindow.b afW = com.baidu.tieba.imMessageCenter.im.floatwindow.b.afW();
        headImageView = this.ckr.aMs;
        String url = headImageView.getUrl();
        i = this.ckr.ckn;
        afW.a(i2 + relativeLayout2.getMeasuredWidth(), iArr[1] - 25, url, i);
        this.ckr.cko = true;
        headImageView2 = this.ckr.aMs;
        headImageView2.setVisibility(4);
        textView = this.ckr.cjk;
        textView.setVisibility(4);
        relativeLayout3 = this.ckr.ckj;
        relativeLayout3.clearFocus();
        return false;
    }
}
