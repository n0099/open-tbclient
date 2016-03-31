package com.baidu.tieba.write.vote;

import android.view.View;
import android.widget.AdapterView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class d implements AdapterView.OnItemClickListener {
    final /* synthetic */ c eKJ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(c cVar) {
        this.eKJ = cVar;
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        com.baidu.tbadk.core.dialog.f fVar;
        int i2;
        int i3;
        int i4;
        com.baidu.tbadk.core.dialog.f fVar2;
        fVar = this.eKJ.eKD;
        fVar.ck(i);
        switch (i) {
            case 0:
                this.eKJ.eKB = 1;
                this.eKJ.eKC = false;
                c cVar = this.eKJ;
                i4 = this.eKJ.eKB;
                cVar.qH(i4);
                break;
            case 1:
                this.eKJ.eKB = 7;
                this.eKJ.eKC = false;
                c cVar2 = this.eKJ;
                i3 = this.eKJ.eKB;
                cVar2.qH(i3);
                break;
            case 2:
                this.eKJ.eKB = 30;
                this.eKJ.eKC = false;
                c cVar3 = this.eKJ;
                i2 = this.eKJ.eKB;
                cVar3.qH(i2);
                break;
            case 3:
                this.eKJ.baA();
                break;
        }
        fVar2 = this.eKJ.eKD;
        fVar2.dismiss();
    }
}
