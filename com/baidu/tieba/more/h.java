package com.baidu.tieba.more;

import android.view.View;
import android.widget.TextView;
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
        p pVar3;
        p pVar4;
        TextView textView2;
        p pVar5;
        pVar = this.a.b;
        if (!pVar.a()) {
            pVar4 = this.a.b;
            pVar4.a(true);
            textView2 = this.a.e;
            textView2.setText(R.string.done);
            pVar5 = this.a.b;
            pVar5.notifyDataSetChanged();
            return;
        }
        pVar2 = this.a.b;
        pVar2.a(false);
        textView = this.a.e;
        textView.setText(R.string.edit);
        pVar3 = this.a.b;
        pVar3.notifyDataSetChanged();
    }
}
