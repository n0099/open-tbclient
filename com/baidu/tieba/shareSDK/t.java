package com.baidu.tieba.shareSDK;

import android.view.View;
import android.widget.TextView;
import com.baidu.tieba.write.ch;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class t implements View.OnClickListener {
    final /* synthetic */ q bPW;

    /* JADX INFO: Access modifiers changed from: package-private */
    public t(q qVar) {
        this.bPW = qVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        TextView textView;
        ch chVar;
        WriteShareActivity writeShareActivity;
        WriteShareActivity writeShareActivity2;
        WriteShareActivity writeShareActivity3;
        WriteShareActivity writeShareActivity4;
        textView = this.bPW.bPL;
        textView.setSelected(true);
        chVar = this.bPW.bPM;
        writeShareActivity = this.bPW.bPU;
        int dip2px = com.baidu.adp.lib.util.l.dip2px(writeShareActivity.getPageContext().getContext(), 15.0f);
        writeShareActivity2 = this.bPW.bPU;
        com.baidu.adp.lib.g.k.showPopupWindowAsDropDown(chVar, view, dip2px, com.baidu.adp.lib.util.l.dip2px(writeShareActivity2.getPageContext().getContext(), 1.0f));
        writeShareActivity3 = this.bPW.bPU;
        if (writeShareActivity3 != null) {
            writeShareActivity4 = this.bPW.bPU;
            writeShareActivity4.adb();
        }
    }
}
