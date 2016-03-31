package com.baidu.tieba.write.shareSDK;

import android.view.View;
import android.widget.TextView;
import com.baidu.tieba.write.write.cg;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class r implements View.OnClickListener {
    final /* synthetic */ o eJF;

    /* JADX INFO: Access modifiers changed from: package-private */
    public r(o oVar) {
        this.eJF = oVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        TextView textView;
        View view2;
        cg cgVar;
        WriteShareActivity writeShareActivity;
        WriteShareActivity writeShareActivity2;
        WriteShareActivity writeShareActivity3;
        WriteShareActivity writeShareActivity4;
        textView = this.eJF.eJt;
        textView.setVisibility(0);
        view2 = this.eJF.eJw;
        view2.setSelected(true);
        cgVar = this.eJF.eJu;
        writeShareActivity = this.eJF.eJC;
        int dip2px = com.baidu.adp.lib.util.k.dip2px(writeShareActivity.getPageContext().getContext(), 15.0f);
        writeShareActivity2 = this.eJF.eJC;
        com.baidu.adp.lib.h.j.showPopupWindowAsDropDown(cgVar, view, dip2px, com.baidu.adp.lib.util.k.dip2px(writeShareActivity2.getPageContext().getContext(), 1.0f));
        writeShareActivity3 = this.eJF.eJC;
        if (writeShareActivity3 != null) {
            writeShareActivity4 = this.eJF.eJC;
            writeShareActivity4.aZT();
        }
    }
}
