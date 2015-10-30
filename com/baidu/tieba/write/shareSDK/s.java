package com.baidu.tieba.write.shareSDK;

import android.view.View;
import android.widget.TextView;
import com.baidu.tieba.write.write.cd;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class s implements View.OnClickListener {
    final /* synthetic */ o dmR;

    /* JADX INFO: Access modifiers changed from: package-private */
    public s(o oVar) {
        this.dmR = oVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        TextView textView;
        cd cdVar;
        WriteShareActivity writeShareActivity;
        WriteShareActivity writeShareActivity2;
        WriteShareActivity writeShareActivity3;
        WriteShareActivity writeShareActivity4;
        textView = this.dmR.dmF;
        textView.setSelected(true);
        cdVar = this.dmR.dmG;
        writeShareActivity = this.dmR.dmO;
        int dip2px = com.baidu.adp.lib.util.k.dip2px(writeShareActivity.getPageContext().getContext(), 15.0f);
        writeShareActivity2 = this.dmR.dmO;
        com.baidu.adp.lib.g.j.showPopupWindowAsDropDown(cdVar, view, dip2px, com.baidu.adp.lib.util.k.dip2px(writeShareActivity2.getPageContext().getContext(), 1.0f));
        writeShareActivity3 = this.dmR.dmO;
        if (writeShareActivity3 != null) {
            writeShareActivity4 = this.dmR.dmO;
            writeShareActivity4.aCb();
        }
    }
}
