package com.baidu.tieba.write.vote;

import android.view.View;
import android.widget.AdapterView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class d implements AdapterView.OnItemClickListener {
    final /* synthetic */ c eqP;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(c cVar) {
        this.eqP = cVar;
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        com.baidu.tbadk.core.dialog.f fVar;
        int i2;
        int i3;
        int i4;
        com.baidu.tbadk.core.dialog.f fVar2;
        fVar = this.eqP.eqI;
        fVar.ci(i);
        switch (i) {
            case 0:
                this.eqP.eqG = 1;
                this.eqP.eqH = false;
                c cVar = this.eqP;
                i4 = this.eqP.eqG;
                cVar.pO(i4);
                break;
            case 1:
                this.eqP.eqG = 7;
                this.eqP.eqH = false;
                c cVar2 = this.eqP;
                i3 = this.eqP.eqG;
                cVar2.pO(i3);
                break;
            case 2:
                this.eqP.eqG = 30;
                this.eqP.eqH = false;
                c cVar3 = this.eqP;
                i2 = this.eqP.eqG;
                cVar3.pO(i2);
                break;
            case 3:
                this.eqP.aUa();
                break;
        }
        fVar2 = this.eqP.eqI;
        fVar2.dismiss();
    }
}
