package com.baidu.tieba.person;

import android.view.View;
import android.widget.TextView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.i;
/* loaded from: classes.dex */
class x implements View.OnClickListener {
    final /* synthetic */ r cpq;

    /* JADX INFO: Access modifiers changed from: package-private */
    public x(r rVar) {
        this.cpq = rVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        ac acVar;
        ac acVar2;
        ac acVar3;
        TextView textView;
        TextView textView2;
        ac acVar4;
        ac acVar5;
        TextView textView3;
        TextView textView4;
        ac acVar6;
        TextView textView5;
        acVar = this.cpq.cpa;
        if (acVar != null) {
            acVar2 = this.cpq.cpa;
            if (!acVar2.FR()) {
                acVar5 = this.cpq.cpa;
                acVar5.setEditState(true);
                textView3 = this.cpq.aEs;
                textView3.setText(i.h.done);
                if (TbadkCoreApplication.m411getInst().getSkinType() == 2) {
                    textView5 = this.cpq.aEs;
                    com.baidu.tbadk.core.util.an.b(textView5, i.c.navi_op_text, 1);
                } else {
                    textView4 = this.cpq.aEs;
                    com.baidu.tbadk.core.util.an.b(textView4, i.c.cp_link_tip_a, 1);
                }
                acVar6 = this.cpq.cpa;
                acVar6.notifyDataSetChanged();
                return;
            }
            acVar3 = this.cpq.cpa;
            acVar3.setEditState(false);
            textView = this.cpq.aEs;
            textView.setText(i.h.edit);
            textView2 = this.cpq.aEs;
            com.baidu.tbadk.core.util.an.b(textView2, i.c.navi_op_text, 1);
            acVar4 = this.cpq.cpa;
            acVar4.notifyDataSetChanged();
        }
    }
}
