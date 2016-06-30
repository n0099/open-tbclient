package com.baidu.tieba.imMessageCenter.im.floatwindow.view;

import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.tbadk.core.view.HeadImageView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class j implements View.OnLongClickListener {
    final /* synthetic */ h dbk;

    /* JADX INFO: Access modifiers changed from: package-private */
    public j(h hVar) {
        this.dbk = hVar;
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
        relativeLayout = this.dbk.dbc;
        relativeLayout.getLocationOnScreen(iArr);
        int i2 = iArr[0];
        relativeLayout2 = this.dbk.dbc;
        com.baidu.tieba.imMessageCenter.im.floatwindow.b arM = com.baidu.tieba.imMessageCenter.im.floatwindow.b.arM();
        headImageView = this.dbk.aOV;
        String url = headImageView.getUrl();
        i = this.dbk.dbg;
        arM.a(i2 + relativeLayout2.getMeasuredWidth(), iArr[1] - 25, url, i);
        this.dbk.dbh = true;
        headImageView2 = this.dbk.aOV;
        headImageView2.setVisibility(4);
        textView = this.dbk.dac;
        textView.setVisibility(4);
        relativeLayout3 = this.dbk.dbc;
        relativeLayout3.clearFocus();
        return false;
    }
}
