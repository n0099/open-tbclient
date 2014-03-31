package com.baidu.tieba.person;

import android.view.View;
import android.widget.TextView;
import com.baidu.tbadk.TbadkApplication;
/* loaded from: classes.dex */
final class d implements View.OnClickListener {
    final /* synthetic */ EditBarActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(EditBarActivity editBarActivity) {
        this.a = editBarActivity;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        g gVar;
        g gVar2;
        TextView textView;
        TextView textView2;
        g gVar3;
        g gVar4;
        TextView textView3;
        TextView textView4;
        g gVar5;
        gVar = this.a.i;
        if (!gVar.a()) {
            gVar4 = this.a.i;
            gVar4.a(true);
            textView3 = this.a.g;
            textView3.setText(com.baidu.tieba.a.k.done);
            textView4 = this.a.g;
            com.baidu.tbadk.core.util.ba.g(textView4, TbadkApplication.j().l());
            gVar5 = this.a.i;
            gVar5.notifyDataSetChanged();
            return;
        }
        gVar2 = this.a.i;
        gVar2.a(false);
        textView = this.a.g;
        textView.setText(com.baidu.tieba.a.k.edit);
        textView2 = this.a.g;
        com.baidu.tbadk.core.util.ba.h(textView2, TbadkApplication.j().l());
        gVar3 = this.a.i;
        gVar3.notifyDataSetChanged();
    }
}
