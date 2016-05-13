package com.baidu.tieba.write.shareSDK;

import android.view.View;
import android.widget.TextView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class r implements View.OnClickListener {
    final /* synthetic */ o fav;

    /* JADX INFO: Access modifiers changed from: package-private */
    public r(o oVar) {
        this.fav = oVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        TextView textView;
        View view2;
        com.baidu.tieba.write.b bVar;
        WriteShareActivity writeShareActivity;
        WriteShareActivity writeShareActivity2;
        WriteShareActivity writeShareActivity3;
        WriteShareActivity writeShareActivity4;
        textView = this.fav.faj;
        textView.setVisibility(0);
        view2 = this.fav.fam;
        view2.setSelected(true);
        bVar = this.fav.fak;
        writeShareActivity = this.fav.fas;
        int dip2px = com.baidu.adp.lib.util.k.dip2px(writeShareActivity.getPageContext().getContext(), 15.0f);
        writeShareActivity2 = this.fav.fas;
        com.baidu.adp.lib.h.j.showPopupWindowAsDropDown(bVar, view, dip2px, com.baidu.adp.lib.util.k.dip2px(writeShareActivity2.getPageContext().getContext(), 1.0f));
        writeShareActivity3 = this.fav.fas;
        if (writeShareActivity3 != null) {
            writeShareActivity4 = this.fav.fas;
            writeShareActivity4.bcm();
        }
    }
}
