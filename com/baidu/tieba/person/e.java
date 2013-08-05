package com.baidu.tieba.person;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class e implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ EditBarActivity f1601a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(EditBarActivity editBarActivity) {
        this.f1601a = editBarActivity;
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
        this.f1601a.j = ((Integer) view.getTag()).intValue();
        i = this.f1601a.j;
        if (i >= 0) {
            i2 = this.f1601a.j;
            jVar = this.f1601a.e;
            if (i2 < jVar.getCount()) {
                jVar2 = this.f1601a.e;
                i3 = this.f1601a.j;
                com.baidu.tieba.data.v vVar = (com.baidu.tieba.data.v) jVar2.getItem(i3);
                iVar = this.f1601a.k;
                if (iVar != null) {
                    iVar4 = this.f1601a.k;
                    iVar4.cancel();
                }
                this.f1601a.k = new i(this.f1601a, null);
                iVar2 = this.f1601a.k;
                iVar2.setPriority(2);
                iVar3 = this.f1601a.k;
                iVar3.execute(vVar);
            }
        }
    }
}
