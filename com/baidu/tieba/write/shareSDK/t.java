package com.baidu.tieba.write.shareSDK;

import android.view.View;
import android.widget.TextView;
import com.baidu.tieba.write.write.cm;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class t implements View.OnClickListener {
    final /* synthetic */ q cwf;

    /* JADX INFO: Access modifiers changed from: package-private */
    public t(q qVar) {
        this.cwf = qVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        TextView textView;
        View view2;
        cm cmVar;
        WriteShareActivity writeShareActivity;
        WriteShareActivity writeShareActivity2;
        WriteShareActivity writeShareActivity3;
        WriteShareActivity writeShareActivity4;
        textView = this.cwf.cvU;
        textView.setVisibility(0);
        view2 = this.cwf.cvX;
        view2.setSelected(true);
        cmVar = this.cwf.cvV;
        writeShareActivity = this.cwf.cwd;
        int dip2px = com.baidu.adp.lib.util.n.dip2px(writeShareActivity.getPageContext().getContext(), 15.0f);
        writeShareActivity2 = this.cwf.cwd;
        com.baidu.adp.lib.g.k.showPopupWindowAsDropDown(cmVar, view, dip2px, com.baidu.adp.lib.util.n.dip2px(writeShareActivity2.getPageContext().getContext(), 1.0f));
        writeShareActivity3 = this.cwf.cwd;
        if (writeShareActivity3 != null) {
            writeShareActivity4 = this.cwf.cwd;
            writeShareActivity4.aqw();
        }
    }
}
