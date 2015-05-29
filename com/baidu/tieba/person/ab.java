package com.baidu.tieba.person;

import android.view.View;
import android.widget.TextView;
import com.baidu.tbadk.core.TbadkCoreApplication;
/* loaded from: classes.dex */
class ab implements View.OnClickListener {
    final /* synthetic */ v bSb;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ab(v vVar) {
        this.bSb = vVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        ag agVar;
        ag agVar2;
        ag agVar3;
        TextView textView;
        TextView textView2;
        ag agVar4;
        ag agVar5;
        TextView textView3;
        TextView textView4;
        ag agVar6;
        agVar = this.bSb.bRM;
        if (agVar != null) {
            agVar2 = this.bSb.bRM;
            if (!agVar2.Fb()) {
                agVar5 = this.bSb.bRM;
                agVar5.setEditState(true);
                textView3 = this.bSb.awb;
                textView3.setText(com.baidu.tieba.t.done);
                textView4 = this.bSb.awb;
                com.baidu.tbadk.core.util.ay.g(textView4, TbadkCoreApplication.m411getInst().getSkinType());
                agVar6 = this.bSb.bRM;
                agVar6.notifyDataSetChanged();
                return;
            }
            agVar3 = this.bSb.bRM;
            agVar3.setEditState(false);
            textView = this.bSb.awb;
            textView.setText(com.baidu.tieba.t.edit);
            textView2 = this.bSb.awb;
            com.baidu.tbadk.core.util.ay.i(textView2, TbadkCoreApplication.m411getInst().getSkinType());
            agVar4 = this.bSb.bRM;
            agVar4.notifyDataSetChanged();
        }
    }
}
