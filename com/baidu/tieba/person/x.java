package com.baidu.tieba.person;

import android.view.View;
import android.widget.TextView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.i;
/* loaded from: classes.dex */
class x implements View.OnClickListener {
    final /* synthetic */ r cqM;

    /* JADX INFO: Access modifiers changed from: package-private */
    public x(r rVar) {
        this.cqM = rVar;
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
        acVar = this.cqM.cqw;
        if (acVar != null) {
            acVar2 = this.cqM.cqw;
            if (!acVar2.FO()) {
                acVar5 = this.cqM.cqw;
                acVar5.setEditState(true);
                textView3 = this.cqM.aDm;
                textView3.setText(i.h.done);
                if (TbadkCoreApplication.m411getInst().getSkinType() == 2) {
                    textView5 = this.cqM.aDm;
                    com.baidu.tbadk.core.util.an.b(textView5, i.c.navi_op_text, 1);
                } else {
                    textView4 = this.cqM.aDm;
                    com.baidu.tbadk.core.util.an.b(textView4, i.c.cp_link_tip_a, 1);
                }
                acVar6 = this.cqM.cqw;
                acVar6.notifyDataSetChanged();
                return;
            }
            acVar3 = this.cqM.cqw;
            acVar3.setEditState(false);
            textView = this.cqM.aDm;
            textView.setText(i.h.edit);
            textView2 = this.cqM.aDm;
            com.baidu.tbadk.core.util.an.b(textView2, i.c.navi_op_text, 1);
            acVar4 = this.cqM.cqw;
            acVar4.notifyDataSetChanged();
        }
    }
}
