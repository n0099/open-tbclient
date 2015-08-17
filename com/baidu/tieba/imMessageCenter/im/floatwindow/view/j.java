package com.baidu.tieba.imMessageCenter.im.floatwindow.view;

import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.tbadk.core.view.HeadImageView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class j implements View.OnLongClickListener {
    final /* synthetic */ h bIv;

    /* JADX INFO: Access modifiers changed from: package-private */
    public j(h hVar) {
        this.bIv = hVar;
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
        relativeLayout = this.bIv.bIn;
        relativeLayout.getLocationOnScreen(iArr);
        int i2 = iArr[0];
        relativeLayout2 = this.bIv.bIn;
        com.baidu.tieba.imMessageCenter.im.floatwindow.b Xx = com.baidu.tieba.imMessageCenter.im.floatwindow.b.Xx();
        headImageView = this.bIv.aIG;
        String url = headImageView.getUrl();
        i = this.bIv.bIr;
        Xx.a(i2 + relativeLayout2.getMeasuredWidth(), iArr[1] - 25, url, i);
        this.bIv.bIs = true;
        headImageView2 = this.bIv.aIG;
        headImageView2.setVisibility(4);
        textView = this.bIv.bHo;
        textView.setVisibility(4);
        relativeLayout3 = this.bIv.bIn;
        relativeLayout3.clearFocus();
        return false;
    }
}
