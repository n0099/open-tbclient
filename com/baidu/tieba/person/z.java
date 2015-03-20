package com.baidu.tieba.person;

import android.view.View;
import android.widget.TextView;
import com.baidu.tbadk.core.TbadkCoreApplication;
/* loaded from: classes.dex */
class z implements View.OnClickListener {
    final /* synthetic */ v bPF;

    /* JADX INFO: Access modifiers changed from: package-private */
    public z(v vVar) {
        this.bPF = vVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        af afVar;
        af afVar2;
        af afVar3;
        TextView textView;
        TextView textView2;
        af afVar4;
        af afVar5;
        TextView textView3;
        TextView textView4;
        af afVar6;
        afVar = this.bPF.bPt;
        if (afVar != null) {
            afVar2 = this.bPF.bPt;
            if (!afVar2.Ei()) {
                afVar5 = this.bPF.bPt;
                afVar5.setEditState(true);
                textView3 = this.bPF.auq;
                textView3.setText(com.baidu.tieba.y.done);
                textView4 = this.bPF.auq;
                com.baidu.tbadk.core.util.ba.g(textView4, TbadkCoreApplication.m411getInst().getSkinType());
                afVar6 = this.bPF.bPt;
                afVar6.notifyDataSetChanged();
                return;
            }
            afVar3 = this.bPF.bPt;
            afVar3.setEditState(false);
            textView = this.bPF.auq;
            textView.setText(com.baidu.tieba.y.edit);
            textView2 = this.bPF.auq;
            com.baidu.tbadk.core.util.ba.i(textView2, TbadkCoreApplication.m411getInst().getSkinType());
            afVar4 = this.bPF.bPt;
            afVar4.notifyDataSetChanged();
        }
    }
}
