package com.baidu.tieba.person;

import android.view.View;
import android.widget.TextView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.t;
/* loaded from: classes.dex */
class y implements View.OnClickListener {
    final /* synthetic */ s cXR;

    /* JADX INFO: Access modifiers changed from: package-private */
    public y(s sVar) {
        this.cXR = sVar;
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
        int i;
        ad adVar6;
        adVar = this.cXR.cXB;
        if (adVar != null) {
            adVar2 = this.cXR.cXB;
            if (!adVar2.Il()) {
                adVar5 = this.cXR.cXB;
                adVar5.setEditState(true);
                textView3 = this.cXR.aIL;
                textView3.setText(t.j.done);
                if (TbadkCoreApplication.m411getInst().getSkinType() == 2) {
                    this.cXR.cXM = t.d.navi_op_text;
                } else {
                    this.cXR.cXM = t.d.cp_link_tip_a;
                }
                textView4 = this.cXR.aIL;
                i = this.cXR.cXM;
                com.baidu.tbadk.core.util.ar.b(textView4, i, 1);
                adVar6 = this.cXR.cXB;
                adVar6.notifyDataSetChanged();
                return;
            }
            adVar3 = this.cXR.cXB;
            adVar3.setEditState(false);
            textView = this.cXR.aIL;
            textView.setText(t.j.edit);
            this.cXR.cXM = t.d.navi_op_text;
            textView2 = this.cXR.aIL;
            com.baidu.tbadk.core.util.ar.b(textView2, t.d.navi_op_text, 1);
            adVar4 = this.cXR.cXB;
            adVar4.notifyDataSetChanged();
        }
    }
}
