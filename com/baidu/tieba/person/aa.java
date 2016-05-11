package com.baidu.tieba.person;

import android.view.View;
import android.widget.TextView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.t;
/* loaded from: classes.dex */
class aa implements View.OnClickListener {
    final /* synthetic */ s dvP;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aa(s sVar) {
        this.dvP = sVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        ae aeVar;
        ae aeVar2;
        ae aeVar3;
        TextView textView;
        TextView textView2;
        int i;
        ae aeVar4;
        ae aeVar5;
        TextView textView3;
        TextView textView4;
        int i2;
        ae aeVar6;
        aeVar = this.dvP.dvz;
        if (aeVar != null) {
            aeVar2 = this.dvP.dvz;
            if (!aeVar2.HY()) {
                aeVar5 = this.dvP.dvz;
                aeVar5.setEditState(true);
                textView3 = this.dvP.aHS;
                textView3.setText(t.j.done);
                if (TbadkCoreApplication.m11getInst().getSkinType() == 2) {
                    this.dvP.dvK = t.d.navi_op_text_skin;
                } else {
                    this.dvP.dvK = t.d.cp_link_tip_a;
                }
                textView4 = this.dvP.aHS;
                i2 = this.dvP.dvK;
                com.baidu.tbadk.core.util.at.c(textView4, i2, 1);
                aeVar6 = this.dvP.dvz;
                aeVar6.notifyDataSetChanged();
                return;
            }
            aeVar3 = this.dvP.dvz;
            aeVar3.setEditState(false);
            textView = this.dvP.aHS;
            textView.setText(t.j.edit);
            if (TbadkCoreApplication.m11getInst().getSkinType() == 2) {
                this.dvP.dvK = t.d.navi_op_text_skin;
            } else {
                this.dvP.dvK = t.d.cp_cont_f;
            }
            textView2 = this.dvP.aHS;
            i = this.dvP.dvK;
            com.baidu.tbadk.core.util.at.c(textView2, i, 1);
            aeVar4 = this.dvP.dvz;
            aeVar4.notifyDataSetChanged();
        }
    }
}
