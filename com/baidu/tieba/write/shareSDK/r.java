package com.baidu.tieba.write.shareSDK;

import android.view.View;
import android.widget.TextView;
import com.baidu.tieba.write.write.cc;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class r implements View.OnClickListener {
    final /* synthetic */ o epJ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public r(o oVar) {
        this.epJ = oVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        TextView textView;
        View view2;
        cc ccVar;
        WriteShareActivity writeShareActivity;
        WriteShareActivity writeShareActivity2;
        WriteShareActivity writeShareActivity3;
        WriteShareActivity writeShareActivity4;
        textView = this.epJ.epx;
        textView.setVisibility(0);
        view2 = this.epJ.epA;
        view2.setSelected(true);
        ccVar = this.epJ.epy;
        writeShareActivity = this.epJ.epG;
        int dip2px = com.baidu.adp.lib.util.k.dip2px(writeShareActivity.getPageContext().getContext(), 15.0f);
        writeShareActivity2 = this.epJ.epG;
        com.baidu.adp.lib.h.j.showPopupWindowAsDropDown(ccVar, view, dip2px, com.baidu.adp.lib.util.k.dip2px(writeShareActivity2.getPageContext().getContext(), 1.0f));
        writeShareActivity3 = this.epJ.epG;
        if (writeShareActivity3 != null) {
            writeShareActivity4 = this.epJ.epG;
            writeShareActivity4.aTt();
        }
    }
}
