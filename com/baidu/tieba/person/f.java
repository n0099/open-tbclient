package com.baidu.tieba.person;

import android.view.View;
import android.widget.Button;
import com.baidu.tieba.R;
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
        Button button;
        i iVar3;
        i iVar4;
        Button button2;
        i iVar5;
        iVar = this.a.g;
        if (!iVar.a()) {
            iVar4 = this.a.g;
            iVar4.a(true);
            button2 = this.a.f;
            button2.setText(R.string.done);
            iVar5 = this.a.g;
            iVar5.notifyDataSetChanged();
            return;
        }
        iVar2 = this.a.g;
        iVar2.a(false);
        button = this.a.f;
        button.setText(R.string.edit);
        iVar3 = this.a.g;
        iVar3.notifyDataSetChanged();
    }
}
