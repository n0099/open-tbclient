package com.baidu.tieba.person;

import android.view.View;
import android.widget.TextView;
import com.baidu.tbadk.TbadkApplication;
/* loaded from: classes.dex */
class y implements View.OnClickListener {
    final /* synthetic */ u a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public y(u uVar) {
        this.a = uVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        ad adVar;
        ad adVar2;
        ad adVar3;
        TextView textView;
        TextView textView2;
        ad adVar4;
        ad adVar5;
        TextView textView3;
        TextView textView4;
        ad adVar6;
        adVar = this.a.c;
        if (adVar != null) {
            adVar2 = this.a.c;
            if (!adVar2.a()) {
                adVar5 = this.a.c;
                adVar5.a(true);
                textView3 = this.a.j;
                textView3.setText(com.baidu.tieba.x.done);
                textView4 = this.a.j;
                com.baidu.tbadk.core.util.ay.g(textView4, TbadkApplication.m252getInst().getSkinType());
                adVar6 = this.a.c;
                adVar6.notifyDataSetChanged();
                return;
            }
            adVar3 = this.a.c;
            adVar3.a(false);
            textView = this.a.j;
            textView.setText(com.baidu.tieba.x.edit);
            textView2 = this.a.j;
            com.baidu.tbadk.core.util.ay.i(textView2, TbadkApplication.m252getInst().getSkinType());
            adVar4 = this.a.c;
            adVar4.notifyDataSetChanged();
        }
    }
}
