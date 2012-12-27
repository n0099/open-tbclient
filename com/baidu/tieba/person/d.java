package com.baidu.tieba.person;

import android.view.View;
import android.widget.Button;
import com.baidu.tieba.R;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class d implements View.OnClickListener {
    final /* synthetic */ EditBarActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(EditBarActivity editBarActivity) {
        this.a = editBarActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        g gVar;
        g gVar2;
        Button button;
        g gVar3;
        g gVar4;
        Button button2;
        g gVar5;
        gVar = this.a.f;
        if (gVar.a()) {
            gVar2 = this.a.f;
            gVar2.a(false);
            button = this.a.e;
            button.setText(R.string.edit);
            gVar3 = this.a.f;
            gVar3.notifyDataSetChanged();
            return;
        }
        gVar4 = this.a.f;
        gVar4.a(true);
        button2 = this.a.e;
        button2.setText(R.string.done);
        gVar5 = this.a.f;
        gVar5.notifyDataSetChanged();
    }
}
