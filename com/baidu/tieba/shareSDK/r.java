package com.baidu.tieba.shareSDK;

import android.view.View;
import android.widget.TextView;
import com.baidu.tieba.write.ch;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class r implements View.OnClickListener {
    final /* synthetic */ p bJX;

    /* JADX INFO: Access modifiers changed from: package-private */
    public r(p pVar) {
        this.bJX = pVar;
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
        textView = this.bJX.bJM;
        textView.setVisibility(0);
        view2 = this.bJX.bJP;
        view2.setSelected(true);
        chVar = this.bJX.bJN;
        writeShareActivity = this.bJX.bJV;
        int dip2px = com.baidu.adp.lib.util.m.dip2px(writeShareActivity, 15.0f);
        writeShareActivity2 = this.bJX.bJV;
        com.baidu.adp.lib.g.j.showPopupWindowAsDropDown(chVar, view, dip2px, com.baidu.adp.lib.util.m.dip2px(writeShareActivity2, 1.0f));
        writeShareActivity3 = this.bJX.bJV;
        if (writeShareActivity3 != null) {
            writeShareActivity4 = this.bJX.bJV;
            writeShareActivity4.ach();
        }
    }
}
