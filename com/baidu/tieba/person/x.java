package com.baidu.tieba.person;

import android.view.View;
import android.widget.TextView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.i;
/* loaded from: classes.dex */
class x implements View.OnClickListener {
    final /* synthetic */ r cjC;

    /* JADX INFO: Access modifiers changed from: package-private */
    public x(r rVar) {
        this.cjC = rVar;
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
        acVar = this.cjC.cjm;
        if (acVar != null) {
            acVar2 = this.cjC.cjm;
            if (!acVar2.Gb()) {
                acVar5 = this.cjC.cjm;
                acVar5.setEditState(true);
                textView3 = this.cjC.aFc;
                textView3.setText(i.h.done);
                textView4 = this.cjC.aFc;
                com.baidu.tbadk.core.util.al.g(textView4, TbadkCoreApplication.m411getInst().getSkinType());
                acVar6 = this.cjC.cjm;
                acVar6.notifyDataSetChanged();
                return;
            }
            acVar3 = this.cjC.cjm;
            acVar3.setEditState(false);
            textView = this.cjC.aFc;
            textView.setText(i.h.edit);
            textView2 = this.cjC.aFc;
            com.baidu.tbadk.core.util.al.i(textView2, TbadkCoreApplication.m411getInst().getSkinType());
            acVar4 = this.cjC.cjm;
            acVar4.notifyDataSetChanged();
        }
    }
}
