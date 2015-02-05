package com.baidu.tieba.person;

import android.view.View;
import android.widget.TextView;
import com.baidu.tbadk.core.TbadkCoreApplication;
/* loaded from: classes.dex */
class k implements View.OnClickListener {
    final /* synthetic */ g bHb;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(g gVar) {
        this.bHb = gVar;
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
        qVar = this.bHb.bGQ;
        if (qVar != null) {
            qVar2 = this.bHb.bGQ;
            if (!qVar2.AT()) {
                qVar5 = this.bHb.bGQ;
                qVar5.setEditState(true);
                textView3 = this.bHb.amB;
                textView3.setText(com.baidu.tieba.z.done);
                textView4 = this.bHb.amB;
                com.baidu.tbadk.core.util.bc.g(textView4, TbadkCoreApplication.m255getInst().getSkinType());
                qVar6 = this.bHb.bGQ;
                qVar6.notifyDataSetChanged();
                return;
            }
            qVar3 = this.bHb.bGQ;
            qVar3.setEditState(false);
            textView = this.bHb.amB;
            textView.setText(com.baidu.tieba.z.edit);
            textView2 = this.bHb.amB;
            com.baidu.tbadk.core.util.bc.i(textView2, TbadkCoreApplication.m255getInst().getSkinType());
            qVar4 = this.bHb.bGQ;
            qVar4.notifyDataSetChanged();
        }
    }
}
