package com.baidu.tieba.person;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class e implements View.OnClickListener {
    final /* synthetic */ EditBarActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(EditBarActivity editBarActivity) {
        this.a = editBarActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int i;
        int i2;
        j jVar;
        j jVar2;
        int i3;
        i iVar;
        i iVar2;
        i iVar3;
        i iVar4;
        this.a.j = ((Integer) view.getTag()).intValue();
        i = this.a.j;
        if (i >= 0) {
            i2 = this.a.j;
            jVar = this.a.e;
            if (i2 < jVar.getCount()) {
                jVar2 = this.a.e;
                i3 = this.a.j;
                com.baidu.tieba.data.r rVar = (com.baidu.tieba.data.r) jVar2.getItem(i3);
                iVar = this.a.k;
                if (iVar != null) {
                    iVar4 = this.a.k;
                    iVar4.cancel();
                }
                this.a.k = new i(this.a, null);
                iVar2 = this.a.k;
                iVar2.setPriority(2);
                iVar3 = this.a.k;
                iVar3.execute(rVar);
            }
        }
    }
}
