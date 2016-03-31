package com.baidu.tieba.person;

import android.view.View;
import android.widget.TextView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.t;
/* loaded from: classes.dex */
class y implements View.OnClickListener {
    final /* synthetic */ s dst;

    /* JADX INFO: Access modifiers changed from: package-private */
    public y(s sVar) {
        this.dst = sVar;
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
        adVar = this.dst.dsd;
        if (adVar != null) {
            adVar2 = this.dst.dsd;
            if (!adVar2.JH()) {
                adVar5 = this.dst.dsd;
                adVar5.setEditState(true);
                textView3 = this.dst.aLH;
                textView3.setText(t.j.done);
                if (TbadkCoreApplication.m411getInst().getSkinType() == 2) {
                    this.dst.dso = t.d.navi_op_text;
                } else {
                    this.dst.dso = t.d.cp_link_tip_a;
                }
                textView4 = this.dst.aLH;
                i = this.dst.dso;
                com.baidu.tbadk.core.util.at.b(textView4, i, 1);
                adVar6 = this.dst.dsd;
                adVar6.notifyDataSetChanged();
                return;
            }
            adVar3 = this.dst.dsd;
            adVar3.setEditState(false);
            textView = this.dst.aLH;
            textView.setText(t.j.edit);
            this.dst.dso = t.d.navi_op_text;
            textView2 = this.dst.aLH;
            com.baidu.tbadk.core.util.at.b(textView2, t.d.navi_op_text, 1);
            adVar4 = this.dst.dsd;
            adVar4.notifyDataSetChanged();
        }
    }
}
