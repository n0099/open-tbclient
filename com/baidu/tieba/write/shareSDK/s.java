package com.baidu.tieba.write.shareSDK;

import android.view.View;
import android.widget.TextView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class s implements View.OnClickListener {
    final /* synthetic */ o fFy;

    /* JADX INFO: Access modifiers changed from: package-private */
    public s(o oVar) {
        this.fFy = oVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        TextView textView;
        com.baidu.tieba.write.b bVar;
        WriteShareActivity writeShareActivity;
        WriteShareActivity writeShareActivity2;
        WriteShareActivity writeShareActivity3;
        WriteShareActivity writeShareActivity4;
        textView = this.fFy.fFn;
        textView.setSelected(true);
        bVar = this.fFy.fFo;
        writeShareActivity = this.fFy.fFw;
        int dip2px = com.baidu.adp.lib.util.k.dip2px(writeShareActivity.getPageContext().getContext(), 15.0f);
        writeShareActivity2 = this.fFy.fFw;
        com.baidu.adp.lib.h.j.showPopupWindowAsDropDown(bVar, view, dip2px, com.baidu.adp.lib.util.k.dip2px(writeShareActivity2.getPageContext().getContext(), 1.0f));
        writeShareActivity3 = this.fFy.fFw;
        if (writeShareActivity3 != null) {
            writeShareActivity4 = this.fFy.fFw;
            writeShareActivity4.bkH();
        }
    }
}
