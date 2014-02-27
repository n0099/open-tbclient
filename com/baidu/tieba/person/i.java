package com.baidu.tieba.person;

import android.view.View;
import android.widget.TextView;
import com.baidu.tieba.TiebaApplication;
import com.slidingmenu.lib.R;
/* loaded from: classes.dex */
final class i implements View.OnClickListener {
    final /* synthetic */ EditBarActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(EditBarActivity editBarActivity) {
        this.a = editBarActivity;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        l lVar;
        l lVar2;
        TextView textView;
        TextView textView2;
        l lVar3;
        l lVar4;
        TextView textView3;
        TextView textView4;
        l lVar5;
        lVar = this.a.i;
        if (!lVar.a()) {
            lVar4 = this.a.i;
            lVar4.a(true);
            textView3 = this.a.g;
            textView3.setText(R.string.done);
            textView4 = this.a.g;
            com.baidu.tieba.util.bq.h(textView4, TiebaApplication.g().ae());
            lVar5 = this.a.i;
            lVar5.notifyDataSetChanged();
            return;
        }
        lVar2 = this.a.i;
        lVar2.a(false);
        textView = this.a.g;
        textView.setText(R.string.edit);
        textView2 = this.a.g;
        com.baidu.tieba.util.bq.i(textView2, TiebaApplication.g().ae());
        lVar3 = this.a.i;
        lVar3.notifyDataSetChanged();
    }
}
