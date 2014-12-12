package com.baidu.tieba.person;

import android.view.View;
import android.widget.TextView;
import com.baidu.tbadk.core.TbadkCoreApplication;
/* loaded from: classes.dex */
class k implements View.OnClickListener {
    final /* synthetic */ g bFr;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(g gVar) {
        this.bFr = gVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        q qVar;
        q qVar2;
        q qVar3;
        TextView textView;
        TextView textView2;
        q qVar4;
        q qVar5;
        TextView textView3;
        TextView textView4;
        q qVar6;
        qVar = this.bFr.bFg;
        if (qVar != null) {
            qVar2 = this.bFr.bFg;
            if (!qVar2.Ay()) {
                qVar5 = this.bFr.bFg;
                qVar5.setEditState(true);
                textView3 = this.bFr.alK;
                textView3.setText(com.baidu.tieba.z.done);
                textView4 = this.bFr.alK;
                com.baidu.tbadk.core.util.ax.g(textView4, TbadkCoreApplication.m255getInst().getSkinType());
                qVar6 = this.bFr.bFg;
                qVar6.notifyDataSetChanged();
                return;
            }
            qVar3 = this.bFr.bFg;
            qVar3.setEditState(false);
            textView = this.bFr.alK;
            textView.setText(com.baidu.tieba.z.edit);
            textView2 = this.bFr.alK;
            com.baidu.tbadk.core.util.ax.i(textView2, TbadkCoreApplication.m255getInst().getSkinType());
            qVar4 = this.bFr.bFg;
            qVar4.notifyDataSetChanged();
        }
    }
}
