package com.baidu.tieba.imMessageCenter.im.floatwindow.view;

import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.tbadk.core.view.HeadImageView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class j implements View.OnLongClickListener {
    final /* synthetic */ h dpP;

    /* JADX INFO: Access modifiers changed from: package-private */
    public j(h hVar) {
        this.dpP = hVar;
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
        relativeLayout = this.dpP.dpH;
        relativeLayout.getLocationOnScreen(iArr);
        int i2 = iArr[0];
        relativeLayout2 = this.dpP.dpH;
        com.baidu.tieba.imMessageCenter.im.floatwindow.b axm = com.baidu.tieba.imMessageCenter.im.floatwindow.b.axm();
        headImageView = this.dpP.aVj;
        String url = headImageView.getUrl();
        i = this.dpP.dpL;
        axm.a(i2 + relativeLayout2.getMeasuredWidth(), iArr[1] - 25, url, i);
        this.dpP.dpM = true;
        headImageView2 = this.dpP.aVj;
        headImageView2.setVisibility(4);
        textView = this.dpP.doI;
        textView.setVisibility(4);
        relativeLayout3 = this.dpP.dpH;
        relativeLayout3.clearFocus();
        return false;
    }
}
