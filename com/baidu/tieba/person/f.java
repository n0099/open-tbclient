package com.baidu.tieba.person;

import android.view.View;
import android.widget.TextView;
import com.baidu.tieba.TiebaApplication;
import com.slidingmenu.lib.R;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class f implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ EditBarActivity f2352a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(EditBarActivity editBarActivity) {
        this.f2352a = editBarActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        i iVar;
        i iVar2;
        TextView textView;
        TextView textView2;
        i iVar3;
        i iVar4;
        TextView textView3;
        TextView textView4;
        i iVar5;
        iVar = this.f2352a.f;
        if (!iVar.a()) {
            iVar4 = this.f2352a.f;
            iVar4.a(true);
            textView3 = this.f2352a.d;
            textView3.setText(R.string.done);
            textView4 = this.f2352a.d;
            com.baidu.tieba.util.ba.h(textView4, TiebaApplication.h().an());
            iVar5 = this.f2352a.f;
            iVar5.notifyDataSetChanged();
            return;
        }
        iVar2 = this.f2352a.f;
        iVar2.a(false);
        textView = this.f2352a.d;
        textView.setText(R.string.edit);
        textView2 = this.f2352a.d;
        com.baidu.tieba.util.ba.j(textView2, TiebaApplication.h().an());
        iVar3 = this.f2352a.f;
        iVar3.notifyDataSetChanged();
    }
}
