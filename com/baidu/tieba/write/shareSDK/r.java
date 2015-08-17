package com.baidu.tieba.write.shareSDK;

import android.view.View;
import android.widget.TextView;
import com.baidu.tieba.write.write.bx;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class r implements View.OnClickListener {
    final /* synthetic */ o cSC;

    /* JADX INFO: Access modifiers changed from: package-private */
    public r(o oVar) {
        this.cSC = oVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        TextView textView;
        View view2;
        bx bxVar;
        WriteShareActivity writeShareActivity;
        WriteShareActivity writeShareActivity2;
        WriteShareActivity writeShareActivity3;
        WriteShareActivity writeShareActivity4;
        textView = this.cSC.cSq;
        textView.setVisibility(0);
        view2 = this.cSC.cSt;
        view2.setSelected(true);
        bxVar = this.cSC.cSr;
        writeShareActivity = this.cSC.cSz;
        int dip2px = com.baidu.adp.lib.util.k.dip2px(writeShareActivity.getPageContext().getContext(), 15.0f);
        writeShareActivity2 = this.cSC.cSz;
        com.baidu.adp.lib.g.j.showPopupWindowAsDropDown(bxVar, view, dip2px, com.baidu.adp.lib.util.k.dip2px(writeShareActivity2.getPageContext().getContext(), 1.0f));
        writeShareActivity3 = this.cSC.cSz;
        if (writeShareActivity3 != null) {
            writeShareActivity4 = this.cSC.cSz;
            writeShareActivity4.aus();
        }
    }
}
