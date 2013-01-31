package com.baidu.tieba.person;

import android.view.View;
import android.widget.Button;
import com.baidu.tieba.R;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class y implements View.OnClickListener {
    final /* synthetic */ EditMarkActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public y(EditMarkActivity editMarkActivity) {
        this.a = editMarkActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        com.baidu.tieba.home.af afVar;
        com.baidu.tieba.home.af afVar2;
        Button button;
        com.baidu.tieba.home.af afVar3;
        com.baidu.tieba.home.af afVar4;
        Button button2;
        com.baidu.tieba.home.af afVar5;
        afVar = this.a.c;
        if (!afVar.c()) {
            afVar4 = this.a.c;
            afVar4.b(true);
            button2 = this.a.g;
            button2.setText(R.string.done);
            afVar5 = this.a.c;
            afVar5.notifyDataSetChanged();
            return;
        }
        afVar2 = this.a.c;
        afVar2.b(false);
        button = this.a.g;
        button.setText(R.string.edit);
        afVar3 = this.a.c;
        afVar3.notifyDataSetChanged();
    }
}
