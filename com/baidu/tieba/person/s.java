package com.baidu.tieba.person;

import android.view.View;
import android.widget.TextView;
import com.baidu.tbadk.TbadkApplication;
/* loaded from: classes.dex */
class s implements View.OnClickListener {
    final /* synthetic */ o bBB;

    /* JADX INFO: Access modifiers changed from: package-private */
    public s(o oVar) {
        this.bBB = oVar;
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
        xVar = this.bBB.bBt;
        if (xVar != null) {
            xVar2 = this.bBB.bBt;
            if (!xVar2.xd()) {
                xVar5 = this.bBB.bBt;
                xVar5.setEditState(true);
                textView3 = this.bBB.aek;
                textView3.setText(com.baidu.tieba.y.done);
                textView4 = this.bBB.aek;
                com.baidu.tbadk.core.util.aw.f(textView4, TbadkApplication.m251getInst().getSkinType());
                xVar6 = this.bBB.bBt;
                xVar6.notifyDataSetChanged();
                return;
            }
            xVar3 = this.bBB.bBt;
            xVar3.setEditState(false);
            textView = this.bBB.aek;
            textView.setText(com.baidu.tieba.y.edit);
            textView2 = this.bBB.aek;
            com.baidu.tbadk.core.util.aw.h(textView2, TbadkApplication.m251getInst().getSkinType());
            xVar4 = this.bBB.bBt;
            xVar4.notifyDataSetChanged();
        }
    }
}
