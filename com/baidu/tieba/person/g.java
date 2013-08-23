package com.baidu.tieba.person;

import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import com.baidu.tieba.TiebaApplication;
import com.slidingmenu.lib.R;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class g implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ EditBarActivity f1645a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(EditBarActivity editBarActivity) {
        this.f1645a = editBarActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        j jVar;
        j jVar2;
        Button button;
        Button button2;
        j jVar3;
        j jVar4;
        Button button3;
        Button button4;
        j jVar5;
        jVar = this.f1645a.e;
        if (!jVar.a()) {
            jVar4 = this.f1645a.e;
            jVar4.a(true);
            button3 = this.f1645a.d;
            button3.setText(R.string.done);
            button4 = this.f1645a.d;
            com.baidu.tieba.util.ao.h(button4, TiebaApplication.g().an());
            jVar5 = this.f1645a.e;
            jVar5.notifyDataSetChanged();
            return;
        }
        jVar2 = this.f1645a.e;
        jVar2.a(false);
        button = this.f1645a.d;
        button.setText(R.string.edit);
        button2 = this.f1645a.d;
        com.baidu.tieba.util.ao.g((TextView) button2, TiebaApplication.g().an());
        jVar3 = this.f1645a.e;
        jVar3.notifyDataSetChanged();
    }
}
