package com.baidu.tieba.person;

import android.view.View;
import android.widget.TextView;
import com.baidu.tbadk.TbadkApplication;
/* loaded from: classes.dex */
class s implements View.OnClickListener {
    final /* synthetic */ o bBP;

    /* JADX INFO: Access modifiers changed from: package-private */
    public s(o oVar) {
        this.bBP = oVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        x xVar;
        x xVar2;
        x xVar3;
        TextView textView;
        TextView textView2;
        x xVar4;
        x xVar5;
        TextView textView3;
        TextView textView4;
        x xVar6;
        xVar = this.bBP.bBH;
        if (xVar != null) {
            xVar2 = this.bBP.bBH;
            if (!xVar2.xf()) {
                xVar5 = this.bBP.bBH;
                xVar5.setEditState(true);
                textView3 = this.bBP.aes;
                textView3.setText(com.baidu.tieba.y.done);
                textView4 = this.bBP.aes;
                com.baidu.tbadk.core.util.aw.f(textView4, TbadkApplication.m251getInst().getSkinType());
                xVar6 = this.bBP.bBH;
                xVar6.notifyDataSetChanged();
                return;
            }
            xVar3 = this.bBP.bBH;
            xVar3.setEditState(false);
            textView = this.bBP.aes;
            textView.setText(com.baidu.tieba.y.edit);
            textView2 = this.bBP.aes;
            com.baidu.tbadk.core.util.aw.h(textView2, TbadkApplication.m251getInst().getSkinType());
            xVar4 = this.bBP.bBH;
            xVar4.notifyDataSetChanged();
        }
    }
}
