package com.baidu.tieba.person;

import android.view.View;
import android.widget.TextView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.i;
/* loaded from: classes.dex */
class x implements View.OnClickListener {
    final /* synthetic */ r cpf;

    /* JADX INFO: Access modifiers changed from: package-private */
    public x(r rVar) {
        this.cpf = rVar;
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
        acVar = this.cpf.coP;
        if (acVar != null) {
            acVar2 = this.cpf.coP;
            if (!acVar2.FV()) {
                acVar5 = this.cpf.coP;
                acVar5.setEditState(true);
                textView3 = this.cpf.aEh;
                textView3.setText(i.h.done);
                if (TbadkCoreApplication.m411getInst().getSkinType() == 2) {
                    textView5 = this.cpf.aEh;
                    com.baidu.tbadk.core.util.am.b(textView5, i.c.navi_op_text, 1);
                } else {
                    textView4 = this.cpf.aEh;
                    com.baidu.tbadk.core.util.am.b(textView4, i.c.cp_link_tip_a, 1);
                }
                acVar6 = this.cpf.coP;
                acVar6.notifyDataSetChanged();
                return;
            }
            acVar3 = this.cpf.coP;
            acVar3.setEditState(false);
            textView = this.cpf.aEh;
            textView.setText(i.h.edit);
            textView2 = this.cpf.aEh;
            com.baidu.tbadk.core.util.am.b(textView2, i.c.navi_op_text, 1);
            acVar4 = this.cpf.coP;
            acVar4.notifyDataSetChanged();
        }
    }
}
