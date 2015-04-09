package com.baidu.tieba.person;

import android.view.View;
import android.widget.TextView;
import com.baidu.tbadk.core.TbadkCoreApplication;
/* loaded from: classes.dex */
class z implements View.OnClickListener {
    final /* synthetic */ v bPV;

    /* JADX INFO: Access modifiers changed from: package-private */
    public z(v vVar) {
        this.bPV = vVar;
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
        afVar = this.bPV.bPJ;
        if (afVar != null) {
            afVar2 = this.bPV.bPJ;
            if (!afVar2.Eo()) {
                afVar5 = this.bPV.bPJ;
                afVar5.setEditState(true);
                textView3 = this.bPV.auy;
                textView3.setText(com.baidu.tieba.y.done);
                textView4 = this.bPV.auy;
                com.baidu.tbadk.core.util.ba.g(textView4, TbadkCoreApplication.m411getInst().getSkinType());
                afVar6 = this.bPV.bPJ;
                afVar6.notifyDataSetChanged();
                return;
            }
            afVar3 = this.bPV.bPJ;
            afVar3.setEditState(false);
            textView = this.bPV.auy;
            textView.setText(com.baidu.tieba.y.edit);
            textView2 = this.bPV.auy;
            com.baidu.tbadk.core.util.ba.i(textView2, TbadkCoreApplication.m411getInst().getSkinType());
            afVar4 = this.bPV.bPJ;
            afVar4.notifyDataSetChanged();
        }
    }
}
