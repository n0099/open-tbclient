package com.baidu.tieba.person;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class b implements View.OnClickListener {
    final /* synthetic */ EditBarActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(EditBarActivity editBarActivity) {
        this.a = editBarActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int i;
        int i2;
        g gVar;
        g gVar2;
        int i3;
        f fVar;
        f fVar2;
        f fVar3;
        this.a.i = ((Integer) view.getTag()).intValue();
        i = this.a.i;
        if (i >= 0) {
            i2 = this.a.i;
            gVar = this.a.f;
            if (i2 < gVar.getCount()) {
                gVar2 = this.a.f;
                i3 = this.a.i;
                com.baidu.tieba.a.p pVar = (com.baidu.tieba.a.p) gVar2.getItem(i3);
                fVar = this.a.j;
                if (fVar != null) {
                    fVar3 = this.a.j;
                    fVar3.a();
                }
                this.a.j = new f(this.a, null);
                fVar2 = this.a.j;
                fVar2.execute(pVar);
            }
        }
    }
}
