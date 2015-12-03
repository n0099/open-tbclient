package com.baidu.tieba.write.vote;

import android.view.View;
import android.widget.AdapterView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class d implements AdapterView.OnItemClickListener {
    final /* synthetic */ c dOx;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(c cVar) {
        this.dOx = cVar;
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        com.baidu.tbadk.core.dialog.e eVar;
        int i2;
        int i3;
        int i4;
        com.baidu.tbadk.core.dialog.e eVar2;
        eVar = this.dOx.dOq;
        eVar.bW(i);
        switch (i) {
            case 0:
                this.dOx.dOo = 1;
                this.dOx.dOp = false;
                c cVar = this.dOx;
                i4 = this.dOx.dOo;
                cVar.nB(i4);
                break;
            case 1:
                this.dOx.dOo = 7;
                this.dOx.dOp = false;
                c cVar2 = this.dOx;
                i3 = this.dOx.dOo;
                cVar2.nB(i3);
                break;
            case 2:
                this.dOx.dOo = 30;
                this.dOx.dOp = false;
                c cVar3 = this.dOx;
                i2 = this.dOx.dOo;
                cVar3.nB(i2);
                break;
            case 3:
                this.dOx.aIK();
                break;
        }
        eVar2 = this.dOx.dOq;
        eVar2.dismiss();
    }
}
