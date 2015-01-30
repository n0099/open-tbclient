package com.baidu.tieba.shareSDK;

import android.view.View;
import android.widget.TextView;
import com.baidu.tieba.write.ch;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class s implements View.OnClickListener {
    final /* synthetic */ q bPX;

    /* JADX INFO: Access modifiers changed from: package-private */
    public s(q qVar) {
        this.bPX = qVar;
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
        textView = this.bPX.bPM;
        textView.setVisibility(0);
        view2 = this.bPX.bPP;
        view2.setSelected(true);
        chVar = this.bPX.bPN;
        writeShareActivity = this.bPX.bPV;
        int dip2px = com.baidu.adp.lib.util.l.dip2px(writeShareActivity.getPageContext().getContext(), 15.0f);
        writeShareActivity2 = this.bPX.bPV;
        com.baidu.adp.lib.g.k.showPopupWindowAsDropDown(chVar, view, dip2px, com.baidu.adp.lib.util.l.dip2px(writeShareActivity2.getPageContext().getContext(), 1.0f));
        writeShareActivity3 = this.bPX.bPV;
        if (writeShareActivity3 != null) {
            writeShareActivity4 = this.bPX.bPV;
            writeShareActivity4.adg();
        }
    }
}
