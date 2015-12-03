package com.baidu.tieba.write.shareSDK;

import android.view.View;
import android.widget.TextView;
import com.baidu.tieba.write.write.cf;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class s implements View.OnClickListener {
    final /* synthetic */ o dNF;

    /* JADX INFO: Access modifiers changed from: package-private */
    public s(o oVar) {
        this.dNF = oVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        TextView textView;
        cf cfVar;
        WriteShareActivity writeShareActivity;
        WriteShareActivity writeShareActivity2;
        WriteShareActivity writeShareActivity3;
        WriteShareActivity writeShareActivity4;
        textView = this.dNF.dNt;
        textView.setSelected(true);
        cfVar = this.dNF.dNu;
        writeShareActivity = this.dNF.dNC;
        int dip2px = com.baidu.adp.lib.util.k.dip2px(writeShareActivity.getPageContext().getContext(), 15.0f);
        writeShareActivity2 = this.dNF.dNC;
        com.baidu.adp.lib.h.j.showPopupWindowAsDropDown(cfVar, view, dip2px, com.baidu.adp.lib.util.k.dip2px(writeShareActivity2.getPageContext().getContext(), 1.0f));
        writeShareActivity3 = this.dNF.dNC;
        if (writeShareActivity3 != null) {
            writeShareActivity4 = this.dNF.dNC;
            writeShareActivity4.aIo();
        }
    }
}
