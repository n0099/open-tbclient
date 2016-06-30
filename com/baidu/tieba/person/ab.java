package com.baidu.tieba.person;

import android.view.View;
import android.widget.TextView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.u;
/* loaded from: classes.dex */
class ab implements View.OnClickListener {
    final /* synthetic */ t eeh;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ab(t tVar) {
        this.eeh = tVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        af afVar;
        af afVar2;
        af afVar3;
        TextView textView;
        TextView textView2;
        int i;
        af afVar4;
        af afVar5;
        TextView textView3;
        TextView textView4;
        int i2;
        af afVar6;
        afVar = this.eeh.edR;
        if (afVar != null) {
            afVar2 = this.eeh.edR;
            if (!afVar2.IZ()) {
                afVar5 = this.eeh.edR;
                afVar5.setEditState(true);
                textView3 = this.eeh.aLo;
                textView3.setText(u.j.done);
                if (TbadkCoreApplication.m9getInst().getSkinType() == 2) {
                    this.eeh.eec = u.d.navi_op_text_skin;
                } else {
                    this.eeh.eec = u.d.cp_link_tip_a;
                }
                textView4 = this.eeh.aLo;
                i2 = this.eeh.eec;
                com.baidu.tbadk.core.util.av.c(textView4, i2, 1);
                afVar6 = this.eeh.edR;
                afVar6.notifyDataSetChanged();
                return;
            }
            afVar3 = this.eeh.edR;
            afVar3.setEditState(false);
            textView = this.eeh.aLo;
            textView.setText(u.j.edit);
            if (TbadkCoreApplication.m9getInst().getSkinType() == 2) {
                this.eeh.eec = u.d.navi_op_text_skin;
            } else {
                this.eeh.eec = u.d.cp_cont_f;
            }
            textView2 = this.eeh.aLo;
            i = this.eeh.eec;
            com.baidu.tbadk.core.util.av.c(textView2, i, 1);
            afVar4 = this.eeh.edR;
            afVar4.notifyDataSetChanged();
        }
    }
}
