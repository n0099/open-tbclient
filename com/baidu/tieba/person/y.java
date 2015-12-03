package com.baidu.tieba.person;

import android.view.View;
import android.widget.TextView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.n;
/* loaded from: classes.dex */
class y implements View.OnClickListener {
    final /* synthetic */ s cKg;

    /* JADX INFO: Access modifiers changed from: package-private */
    public y(s sVar) {
        this.cKg = sVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        ad adVar;
        ad adVar2;
        ad adVar3;
        TextView textView;
        TextView textView2;
        ad adVar4;
        ad adVar5;
        TextView textView3;
        TextView textView4;
        ad adVar6;
        TextView textView5;
        adVar = this.cKg.cJR;
        if (adVar != null) {
            adVar2 = this.cKg.cJR;
            if (!adVar2.GV()) {
                adVar5 = this.cKg.cJR;
                adVar5.setEditState(true);
                textView3 = this.cKg.aGj;
                textView3.setText(n.i.done);
                if (TbadkCoreApplication.m411getInst().getSkinType() == 2) {
                    textView5 = this.cKg.aGj;
                    com.baidu.tbadk.core.util.as.b(textView5, n.c.navi_op_text, 1);
                } else {
                    textView4 = this.cKg.aGj;
                    com.baidu.tbadk.core.util.as.b(textView4, n.c.cp_link_tip_a, 1);
                }
                adVar6 = this.cKg.cJR;
                adVar6.notifyDataSetChanged();
                return;
            }
            adVar3 = this.cKg.cJR;
            adVar3.setEditState(false);
            textView = this.cKg.aGj;
            textView.setText(n.i.edit);
            textView2 = this.cKg.aGj;
            com.baidu.tbadk.core.util.as.b(textView2, n.c.navi_op_text, 1);
            adVar4 = this.cKg.cJR;
            adVar4.notifyDataSetChanged();
        }
    }
}
