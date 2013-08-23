package com.baidu.tieba.more;

import android.view.View;
import android.widget.Button;
import com.slidingmenu.lib.R;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class g implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ AccountActivity f1448a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(AccountActivity accountActivity) {
        this.f1448a = accountActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        o oVar;
        o oVar2;
        Button button;
        o oVar3;
        o oVar4;
        Button button2;
        o oVar5;
        oVar = this.f1448a.b;
        if (!oVar.a()) {
            oVar4 = this.f1448a.b;
            oVar4.a(true);
            button2 = this.f1448a.g;
            button2.setText(R.string.done);
            oVar5 = this.f1448a.b;
            oVar5.notifyDataSetChanged();
            return;
        }
        oVar2 = this.f1448a.b;
        oVar2.a(false);
        button = this.f1448a.g;
        button.setText(R.string.edit);
        oVar3 = this.f1448a.b;
        oVar3.notifyDataSetChanged();
    }
}
