package com.baidu.tieba.more;

import android.view.View;
import android.widget.TextView;
import com.slidingmenu.lib.R;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class h implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ AccountActivity f2092a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(AccountActivity accountActivity) {
        this.f2092a = accountActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        p pVar;
        p pVar2;
        TextView textView;
        p pVar3;
        p pVar4;
        TextView textView2;
        p pVar5;
        pVar = this.f2092a.b;
        if (!pVar.a()) {
            pVar4 = this.f2092a.b;
            pVar4.a(true);
            textView2 = this.f2092a.e;
            textView2.setText(R.string.done);
            pVar5 = this.f2092a.b;
            pVar5.notifyDataSetChanged();
            return;
        }
        pVar2 = this.f2092a.b;
        pVar2.a(false);
        textView = this.f2092a.e;
        textView.setText(R.string.edit);
        pVar3 = this.f2092a.b;
        pVar3.notifyDataSetChanged();
    }
}
