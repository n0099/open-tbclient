package com.baidu.tieba.more;

import android.view.View;
import android.widget.Button;
import com.slidingmenu.lib.R;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class h implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ AccountActivity f2009a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(AccountActivity accountActivity) {
        this.f2009a = accountActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        p pVar;
        p pVar2;
        Button button;
        p pVar3;
        p pVar4;
        Button button2;
        p pVar5;
        pVar = this.f2009a.b;
        if (!pVar.a()) {
            pVar4 = this.f2009a.b;
            pVar4.a(true);
            button2 = this.f2009a.e;
            button2.setText(R.string.done);
            pVar5 = this.f2009a.b;
            pVar5.notifyDataSetChanged();
            return;
        }
        pVar2 = this.f2009a.b;
        pVar2.a(false);
        button = this.f2009a.e;
        button.setText(R.string.edit);
        pVar3 = this.f2009a.b;
        pVar3.notifyDataSetChanged();
    }
}
