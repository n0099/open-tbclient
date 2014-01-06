package com.baidu.tieba.person;

import android.view.View;
import android.widget.TextView;
import com.baidu.tieba.TiebaApplication;
import com.slidingmenu.lib.R;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class f implements View.OnClickListener {
    final /* synthetic */ EditBarActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(EditBarActivity editBarActivity) {
        this.a = editBarActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        i iVar;
        i iVar2;
        TextView textView;
        TextView textView2;
        i iVar3;
        i iVar4;
        TextView textView3;
        TextView textView4;
        i iVar5;
        iVar = this.a.f;
        if (!iVar.a()) {
            iVar4 = this.a.f;
            iVar4.a(true);
            textView3 = this.a.d;
            textView3.setText(R.string.done);
            textView4 = this.a.d;
            com.baidu.tieba.util.bl.h(textView4, TiebaApplication.g().an());
            iVar5 = this.a.f;
            iVar5.notifyDataSetChanged();
            return;
        }
        iVar2 = this.a.f;
        iVar2.a(false);
        textView = this.a.d;
        textView.setText(R.string.edit);
        textView2 = this.a.d;
        com.baidu.tieba.util.bl.j(textView2, TiebaApplication.g().an());
        iVar3 = this.a.f;
        iVar3.notifyDataSetChanged();
    }
}
