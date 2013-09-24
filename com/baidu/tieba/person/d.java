package com.baidu.tieba.person;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class d implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ EditBarActivity f1690a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(EditBarActivity editBarActivity) {
        this.f1690a = editBarActivity;
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
        h hVar4;
        this.f1690a.k = ((Integer) view.getTag()).intValue();
        i = this.f1690a.k;
        if (i >= 0) {
            i2 = this.f1690a.k;
            iVar = this.f1690a.f;
            if (i2 < iVar.getCount()) {
                iVar2 = this.f1690a.f;
                i3 = this.f1690a.k;
                com.baidu.tieba.data.v vVar = (com.baidu.tieba.data.v) iVar2.getItem(i3);
                hVar = this.f1690a.m;
                if (hVar != null) {
                    hVar4 = this.f1690a.m;
                    hVar4.cancel();
                }
                this.f1690a.m = new h(this.f1690a, null);
                hVar2 = this.f1690a.m;
                hVar2.setPriority(2);
                hVar3 = this.f1690a.m;
                hVar3.execute(vVar);
            }
        }
    }
}
