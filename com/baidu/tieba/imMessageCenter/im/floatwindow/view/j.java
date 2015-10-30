package com.baidu.tieba.imMessageCenter.im.floatwindow.view;

import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.tbadk.core.view.HeadImageView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class j implements View.OnLongClickListener {
    final /* synthetic */ h bMs;

    /* JADX INFO: Access modifiers changed from: package-private */
    public j(h hVar) {
        this.bMs = hVar;
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
        relativeLayout = this.bMs.bMk;
        relativeLayout.getLocationOnScreen(iArr);
        int i2 = iArr[0];
        relativeLayout2 = this.bMs.bMk;
        com.baidu.tieba.imMessageCenter.im.floatwindow.b Yd = com.baidu.tieba.imMessageCenter.im.floatwindow.b.Yd();
        headImageView = this.bMs.aHW;
        String url = headImageView.getUrl();
        i = this.bMs.bMo;
        Yd.a(i2 + relativeLayout2.getMeasuredWidth(), iArr[1] - 25, url, i);
        this.bMs.bMp = true;
        headImageView2 = this.bMs.aHW;
        headImageView2.setVisibility(4);
        textView = this.bMs.bLl;
        textView.setVisibility(4);
        relativeLayout3 = this.bMs.bMk;
        relativeLayout3.clearFocus();
        return false;
    }
}
