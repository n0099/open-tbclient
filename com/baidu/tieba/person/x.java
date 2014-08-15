package com.baidu.tieba.person;

import android.view.View;
import android.widget.TextView;
import com.baidu.tbadk.TbadkApplication;
/* loaded from: classes.dex */
class x implements View.OnClickListener {
    final /* synthetic */ t a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public x(t tVar) {
        this.a = tVar;
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
        acVar = this.a.c;
        if (acVar != null) {
            acVar2 = this.a.c;
            if (!acVar2.a()) {
                acVar5 = this.a.c;
                acVar5.a(true);
                textView3 = this.a.j;
                textView3.setText(com.baidu.tieba.x.done);
                textView4 = this.a.j;
                com.baidu.tbadk.core.util.ay.g(textView4, TbadkApplication.m252getInst().getSkinType());
                acVar6 = this.a.c;
                acVar6.notifyDataSetChanged();
                return;
            }
            acVar3 = this.a.c;
            acVar3.a(false);
            textView = this.a.j;
            textView.setText(com.baidu.tieba.x.edit);
            textView2 = this.a.j;
            com.baidu.tbadk.core.util.ay.i(textView2, TbadkApplication.m252getInst().getSkinType());
            acVar4 = this.a.c;
            acVar4.notifyDataSetChanged();
        }
    }
}
