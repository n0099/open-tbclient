package com.baidu.tieba.write.shareSDK;

import android.view.View;
import android.widget.TextView;
import com.baidu.tieba.write.write.cd;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class r implements View.OnClickListener {
    final /* synthetic */ o dmr;

    /* JADX INFO: Access modifiers changed from: package-private */
    public r(o oVar) {
        this.dmr = oVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        TextView textView;
        View view2;
        cd cdVar;
        WriteShareActivity writeShareActivity;
        WriteShareActivity writeShareActivity2;
        WriteShareActivity writeShareActivity3;
        WriteShareActivity writeShareActivity4;
        textView = this.dmr.dmf;
        textView.setVisibility(0);
        view2 = this.dmr.dmi;
        view2.setSelected(true);
        cdVar = this.dmr.dmg;
        writeShareActivity = this.dmr.dmo;
        int dip2px = com.baidu.adp.lib.util.k.dip2px(writeShareActivity.getPageContext().getContext(), 15.0f);
        writeShareActivity2 = this.dmr.dmo;
        com.baidu.adp.lib.g.j.showPopupWindowAsDropDown(cdVar, view, dip2px, com.baidu.adp.lib.util.k.dip2px(writeShareActivity2.getPageContext().getContext(), 1.0f));
        writeShareActivity3 = this.dmr.dmo;
        if (writeShareActivity3 != null) {
            writeShareActivity4 = this.dmr.dmo;
            writeShareActivity4.aBV();
        }
    }
}
