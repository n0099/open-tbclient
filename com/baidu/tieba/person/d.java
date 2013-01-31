package com.baidu.tieba.person;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class d implements View.OnClickListener {
    final /* synthetic */ EditBarActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(EditBarActivity editBarActivity) {
        this.a = editBarActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int i;
        int i2;
        i iVar;
        i iVar2;
        int i3;
        h hVar;
        h hVar2;
        h hVar3;
        this.a.j = ((Integer) view.getTag()).intValue();
        i = this.a.j;
        if (i >= 0) {
            i2 = this.a.j;
            iVar = this.a.g;
            if (i2 < iVar.getCount()) {
                iVar2 = this.a.g;
                i3 = this.a.j;
                com.baidu.tieba.a.q qVar = (com.baidu.tieba.a.q) iVar2.getItem(i3);
                hVar = this.a.k;
                if (hVar != null) {
                    hVar3 = this.a.k;
                    hVar3.a();
                }
                this.a.k = new h(this.a, null);
                hVar2 = this.a.k;
                hVar2.execute(qVar);
            }
        }
    }
}
