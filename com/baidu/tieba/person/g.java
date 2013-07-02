package com.baidu.tieba.person;

import android.view.View;
import android.widget.Button;
import com.slidingmenu.lib.R;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class g implements View.OnClickListener {
    final /* synthetic */ EditBarActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(EditBarActivity editBarActivity) {
        this.a = editBarActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        j jVar;
        j jVar2;
        Button button;
        j jVar3;
        j jVar4;
        Button button2;
        j jVar5;
        jVar = this.a.e;
        if (!jVar.a()) {
            jVar4 = this.a.e;
            jVar4.a(true);
            button2 = this.a.d;
            button2.setText(R.string.done);
            jVar5 = this.a.e;
            jVar5.notifyDataSetChanged();
            return;
        }
        jVar2 = this.a.e;
        jVar2.a(false);
        button = this.a.d;
        button.setText(R.string.edit);
        jVar3 = this.a.e;
        jVar3.notifyDataSetChanged();
    }
}
