package com.baidu.tieba.imMessageCenter.im.floatwindow.view;

import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.tbadk.core.view.HeadImageView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class j implements View.OnLongClickListener {
    final /* synthetic */ h drm;

    /* JADX INFO: Access modifiers changed from: package-private */
    public j(h hVar) {
        this.drm = hVar;
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
        relativeLayout = this.drm.dre;
        relativeLayout.getLocationOnScreen(iArr);
        int i2 = iArr[0];
        relativeLayout2 = this.drm.dre;
        com.baidu.tieba.imMessageCenter.im.floatwindow.b axL = com.baidu.tieba.imMessageCenter.im.floatwindow.b.axL();
        headImageView = this.drm.aVS;
        String url = headImageView.getUrl();
        i = this.drm.dri;
        axL.a(i2 + relativeLayout2.getMeasuredWidth(), iArr[1] - 25, url, i);
        this.drm.drj = true;
        headImageView2 = this.drm.aVS;
        headImageView2.setVisibility(4);
        textView = this.drm.dqg;
        textView.setVisibility(4);
        relativeLayout3 = this.drm.dre;
        relativeLayout3.clearFocus();
        return false;
    }
}
