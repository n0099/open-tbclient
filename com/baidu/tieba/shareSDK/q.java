package com.baidu.tieba.shareSDK;

import android.view.View;
import android.widget.TextView;
import com.baidu.tieba.write.ch;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class q implements View.OnClickListener {
    final /* synthetic */ o bJI;

    /* JADX INFO: Access modifiers changed from: package-private */
    public q(o oVar) {
        this.bJI = oVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        TextView textView;
        View view2;
        ch chVar;
        WriteShareActivity writeShareActivity;
        WriteShareActivity writeShareActivity2;
        WriteShareActivity writeShareActivity3;
        WriteShareActivity writeShareActivity4;
        textView = this.bJI.bJx;
        textView.setVisibility(0);
        view2 = this.bJI.bJA;
        view2.setSelected(true);
        chVar = this.bJI.bJy;
        writeShareActivity = this.bJI.bJG;
        int dip2px = com.baidu.adp.lib.util.m.dip2px(writeShareActivity, 15.0f);
        writeShareActivity2 = this.bJI.bJG;
        com.baidu.adp.lib.g.j.showPopupWindowAsDropDown(chVar, view, dip2px, com.baidu.adp.lib.util.m.dip2px(writeShareActivity2, 1.0f));
        writeShareActivity3 = this.bJI.bJG;
        if (writeShareActivity3 != null) {
            writeShareActivity4 = this.bJI.bJG;
            writeShareActivity4.ace();
        }
    }
}
