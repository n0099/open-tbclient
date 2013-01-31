package com.baidu.tieba.more;

import android.view.View;
import android.widget.Button;
import com.baidu.tieba.R;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class g implements View.OnClickListener {
    final /* synthetic */ AccountActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(AccountActivity accountActivity) {
        this.a = accountActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        n nVar;
        n nVar2;
        Button button;
        n nVar3;
        n nVar4;
        Button button2;
        n nVar5;
        nVar = this.a.d;
        if (!nVar.a()) {
            nVar4 = this.a.d;
            nVar4.a(true);
            button2 = this.a.i;
            button2.setText(R.string.done);
            nVar5 = this.a.d;
            nVar5.notifyDataSetChanged();
            return;
        }
        nVar2 = this.a.d;
        nVar2.a(false);
        button = this.a.i;
        button.setText(R.string.edit);
        nVar3 = this.a.d;
        nVar3.notifyDataSetChanged();
    }
}
