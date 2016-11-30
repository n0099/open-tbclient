package com.baidu.tieba.imMessageCenter.im.floatwindow.view;

import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.tbadk.core.view.HeadImageView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class j implements View.OnLongClickListener {
    final /* synthetic */ h dwT;

    /* JADX INFO: Access modifiers changed from: package-private */
    public j(h hVar) {
        this.dwT = hVar;
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
        relativeLayout = this.dwT.dwL;
        relativeLayout.getLocationOnScreen(iArr);
        int i2 = iArr[0];
        relativeLayout2 = this.dwT.dwL;
        com.baidu.tieba.imMessageCenter.im.floatwindow.b azI = com.baidu.tieba.imMessageCenter.im.floatwindow.b.azI();
        headImageView = this.dwT.aYe;
        String url = headImageView.getUrl();
        i = this.dwT.dwP;
        azI.a(i2 + relativeLayout2.getMeasuredWidth(), iArr[1] - 25, url, i);
        this.dwT.dwQ = true;
        headImageView2 = this.dwT.aYe;
        headImageView2.setVisibility(4);
        textView = this.dwT.dvN;
        textView.setVisibility(4);
        relativeLayout3 = this.dwT.dwL;
        relativeLayout3.clearFocus();
        return false;
    }
}
