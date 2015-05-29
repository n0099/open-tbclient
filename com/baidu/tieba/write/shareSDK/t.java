package com.baidu.tieba.write.shareSDK;

import android.view.View;
import android.widget.TextView;
import com.baidu.tieba.write.write.cn;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class t implements View.OnClickListener {
    final /* synthetic */ q cAL;

    /* JADX INFO: Access modifiers changed from: package-private */
    public t(q qVar) {
        this.cAL = qVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        TextView textView;
        View view2;
        cn cnVar;
        WriteShareActivity writeShareActivity;
        WriteShareActivity writeShareActivity2;
        WriteShareActivity writeShareActivity3;
        WriteShareActivity writeShareActivity4;
        textView = this.cAL.cAA;
        textView.setVisibility(0);
        view2 = this.cAL.cAD;
        view2.setSelected(true);
        cnVar = this.cAL.cAB;
        writeShareActivity = this.cAL.cAJ;
        int dip2px = com.baidu.adp.lib.util.n.dip2px(writeShareActivity.getPageContext().getContext(), 15.0f);
        writeShareActivity2 = this.cAL.cAJ;
        com.baidu.adp.lib.g.k.showPopupWindowAsDropDown(cnVar, view, dip2px, com.baidu.adp.lib.util.n.dip2px(writeShareActivity2.getPageContext().getContext(), 1.0f));
        writeShareActivity3 = this.cAL.cAJ;
        if (writeShareActivity3 != null) {
            writeShareActivity4 = this.cAL.cAJ;
            writeShareActivity4.asB();
        }
    }
}
