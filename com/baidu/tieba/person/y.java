package com.baidu.tieba.person;

import android.view.View;
import android.widget.TextView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.n;
/* loaded from: classes.dex */
class y implements View.OnClickListener {
    final /* synthetic */ s cOw;

    /* JADX INFO: Access modifiers changed from: package-private */
    public y(s sVar) {
        this.cOw = sVar;
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
        adVar = this.cOw.cOh;
        if (adVar != null) {
            adVar2 = this.cOw.cOh;
            if (!adVar2.GK()) {
                adVar5 = this.cOw.cOh;
                adVar5.setEditState(true);
                textView3 = this.cOw.aHJ;
                textView3.setText(n.j.done);
                if (TbadkCoreApplication.m411getInst().getSkinType() == 2) {
                    textView5 = this.cOw.aHJ;
                    com.baidu.tbadk.core.util.as.b(textView5, n.d.navi_op_text, 1);
                } else {
                    textView4 = this.cOw.aHJ;
                    com.baidu.tbadk.core.util.as.b(textView4, n.d.cp_link_tip_a, 1);
                }
                adVar6 = this.cOw.cOh;
                adVar6.notifyDataSetChanged();
                return;
            }
            adVar3 = this.cOw.cOh;
            adVar3.setEditState(false);
            textView = this.cOw.aHJ;
            textView.setText(n.j.edit);
            textView2 = this.cOw.aHJ;
            com.baidu.tbadk.core.util.as.b(textView2, n.d.navi_op_text, 1);
            adVar4 = this.cOw.cOh;
            adVar4.notifyDataSetChanged();
        }
    }
}
