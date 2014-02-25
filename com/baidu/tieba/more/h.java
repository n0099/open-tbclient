package com.baidu.tieba.more;

import android.view.View;
import android.widget.TextView;
import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.util.bq;
import com.slidingmenu.lib.R;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class h implements View.OnClickListener {
    final /* synthetic */ AccountActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(AccountActivity accountActivity) {
        this.a = accountActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        p pVar;
        p pVar2;
        TextView textView;
        TextView textView2;
        p pVar3;
        p pVar4;
        TextView textView3;
        TextView textView4;
        p pVar5;
        pVar = this.a.b;
        if (!pVar.a()) {
            pVar4 = this.a.b;
            pVar4.a(true);
            textView3 = this.a.f;
            textView3.setText(R.string.done);
            textView4 = this.a.f;
            bq.h(textView4, TiebaApplication.g().al());
            pVar5 = this.a.b;
            pVar5.notifyDataSetChanged();
            return;
        }
        pVar2 = this.a.b;
        pVar2.a(false);
        textView = this.a.f;
        textView.setText(R.string.edit);
        textView2 = this.a.f;
        bq.j(textView2, TiebaApplication.g().al());
        pVar3 = this.a.b;
        pVar3.notifyDataSetChanged();
    }
}
