package com.baidu.tieba.person;

import android.view.View;
import android.widget.Button;
import com.baidu.tieba.R;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class aa implements View.OnClickListener {
    final /* synthetic */ EditMarkActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aa(EditMarkActivity editMarkActivity) {
        this.a = editMarkActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        com.baidu.tieba.home.ab abVar;
        com.baidu.tieba.home.ab abVar2;
        Button button;
        com.baidu.tieba.home.ab abVar3;
        com.baidu.tieba.home.ab abVar4;
        Button button2;
        com.baidu.tieba.home.ab abVar5;
        abVar = this.a.c;
        if (!abVar.d()) {
            abVar4 = this.a.c;
            abVar4.d(true);
            button2 = this.a.g;
            button2.setText(R.string.done);
            abVar5 = this.a.c;
            abVar5.notifyDataSetChanged();
            return;
        }
        abVar2 = this.a.c;
        abVar2.d(false);
        button = this.a.g;
        button.setText(R.string.edit);
        abVar3 = this.a.c;
        abVar3.notifyDataSetChanged();
    }
}
