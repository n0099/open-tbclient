package com.baidu.tieba.more;

import android.view.View;
import android.widget.Button;
import com.slidingmenu.lib.R;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class g implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ AccountActivity f1095a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(AccountActivity accountActivity) {
        this.f1095a = accountActivity;
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
        nVar = this.f1095a.b;
        if (!nVar.a()) {
            nVar4 = this.f1095a.b;
            nVar4.a(true);
            button2 = this.f1095a.g;
            button2.setText(R.string.done);
            nVar5 = this.f1095a.b;
            nVar5.notifyDataSetChanged();
            return;
        }
        nVar2 = this.f1095a.b;
        nVar2.a(false);
        button = this.f1095a.g;
        button.setText(R.string.edit);
        nVar3 = this.f1095a.b;
        nVar3.notifyDataSetChanged();
    }
}
