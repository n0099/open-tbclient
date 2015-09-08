package com.baidu.tieba.write.shareSDK;

import android.view.View;
import android.widget.TextView;
import com.baidu.tieba.write.write.cb;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class s implements View.OnClickListener {
    final /* synthetic */ o dbp;

    /* JADX INFO: Access modifiers changed from: package-private */
    public s(o oVar) {
        this.dbp = oVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        TextView textView;
        cb cbVar;
        WriteShareActivity writeShareActivity;
        WriteShareActivity writeShareActivity2;
        WriteShareActivity writeShareActivity3;
        WriteShareActivity writeShareActivity4;
        textView = this.dbp.dbd;
        textView.setSelected(true);
        cbVar = this.dbp.dbe;
        writeShareActivity = this.dbp.dbm;
        int dip2px = com.baidu.adp.lib.util.k.dip2px(writeShareActivity.getPageContext().getContext(), 15.0f);
        writeShareActivity2 = this.dbp.dbm;
        com.baidu.adp.lib.g.j.showPopupWindowAsDropDown(cbVar, view, dip2px, com.baidu.adp.lib.util.k.dip2px(writeShareActivity2.getPageContext().getContext(), 1.0f));
        writeShareActivity3 = this.dbp.dbm;
        if (writeShareActivity3 != null) {
            writeShareActivity4 = this.dbp.dbm;
            writeShareActivity4.ayM();
        }
    }
}
