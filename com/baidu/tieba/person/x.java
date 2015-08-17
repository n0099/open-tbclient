package com.baidu.tieba.person;

import android.view.View;
import android.widget.TextView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.i;
/* loaded from: classes.dex */
class x implements View.OnClickListener {
    final /* synthetic */ r ciI;

    /* JADX INFO: Access modifiers changed from: package-private */
    public x(r rVar) {
        this.ciI = rVar;
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
        acVar = this.ciI.cis;
        if (acVar != null) {
            acVar2 = this.ciI.cis;
            if (!acVar2.FR()) {
                acVar5 = this.ciI.cis;
                acVar5.setEditState(true);
                textView3 = this.ciI.aDu;
                textView3.setText(i.C0057i.done);
                textView4 = this.ciI.aDu;
                com.baidu.tbadk.core.util.al.g(textView4, TbadkCoreApplication.m411getInst().getSkinType());
                acVar6 = this.ciI.cis;
                acVar6.notifyDataSetChanged();
                return;
            }
            acVar3 = this.ciI.cis;
            acVar3.setEditState(false);
            textView = this.ciI.aDu;
            textView.setText(i.C0057i.edit);
            textView2 = this.ciI.aDu;
            com.baidu.tbadk.core.util.al.i(textView2, TbadkCoreApplication.m411getInst().getSkinType());
            acVar4 = this.ciI.cis;
            acVar4.notifyDataSetChanged();
        }
    }
}
