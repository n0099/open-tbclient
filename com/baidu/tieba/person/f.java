package com.baidu.tieba.person;

import android.view.View;
import android.widget.Button;
import com.baidu.tieba.TiebaApplication;
import com.slidingmenu.lib.R;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class f implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ EditBarActivity f2213a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(EditBarActivity editBarActivity) {
        this.f2213a = editBarActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        i iVar;
        i iVar2;
        Button button;
        Button button2;
        i iVar3;
        i iVar4;
        Button button3;
        Button button4;
        i iVar5;
        iVar = this.f2213a.f;
        if (!iVar.a()) {
            iVar4 = this.f2213a.f;
            iVar4.a(true);
            button3 = this.f2213a.d;
            button3.setText(R.string.done);
            button4 = this.f2213a.d;
            com.baidu.tieba.util.bb.h(button4, TiebaApplication.g().as());
            iVar5 = this.f2213a.f;
            iVar5.notifyDataSetChanged();
            return;
        }
        iVar2 = this.f2213a.f;
        iVar2.a(false);
        button = this.f2213a.d;
        button.setText(R.string.edit);
        button2 = this.f2213a.d;
        com.baidu.tieba.util.bb.g(button2, TiebaApplication.g().as());
        iVar3 = this.f2213a.f;
        iVar3.notifyDataSetChanged();
    }
}
