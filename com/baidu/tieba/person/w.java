package com.baidu.tieba.person;

import android.view.View;
import android.widget.Button;
import com.baidu.tieba.R;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class w implements View.OnClickListener {
    final /* synthetic */ EditMarkActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public w(EditMarkActivity editMarkActivity) {
        this.a = editMarkActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        com.baidu.tieba.home.y yVar;
        com.baidu.tieba.home.y yVar2;
        Button button;
        com.baidu.tieba.home.y yVar3;
        com.baidu.tieba.home.y yVar4;
        Button button2;
        com.baidu.tieba.home.y yVar5;
        yVar = this.a.b;
        if (yVar.c()) {
            yVar2 = this.a.b;
            yVar2.b(false);
            button = this.a.f;
            button.setText(R.string.edit);
            yVar3 = this.a.b;
            yVar3.notifyDataSetChanged();
            return;
        }
        yVar4 = this.a.b;
        yVar4.b(true);
        button2 = this.a.f;
        button2.setText(R.string.done);
        yVar5 = this.a.b;
        yVar5.notifyDataSetChanged();
    }
}
