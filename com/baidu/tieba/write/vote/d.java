package com.baidu.tieba.write.vote;

import android.view.View;
import android.widget.AdapterView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class d implements AdapterView.OnItemClickListener {
    final /* synthetic */ c dVW;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(c cVar) {
        this.dVW = cVar;
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        com.baidu.tbadk.core.dialog.e eVar;
        int i2;
        int i3;
        int i4;
        com.baidu.tbadk.core.dialog.e eVar2;
        eVar = this.dVW.dVP;
        eVar.bP(i);
        switch (i) {
            case 0:
                this.dVW.dVN = 1;
                this.dVW.dVO = false;
                c cVar = this.dVW;
                i4 = this.dVW.dVN;
                cVar.ot(i4);
                break;
            case 1:
                this.dVW.dVN = 7;
                this.dVW.dVO = false;
                c cVar2 = this.dVW;
                i3 = this.dVW.dVN;
                cVar2.ot(i3);
                break;
            case 2:
                this.dVW.dVN = 30;
                this.dVW.dVO = false;
                c cVar3 = this.dVW;
                i2 = this.dVW.dVN;
                cVar3.ot(i2);
                break;
            case 3:
                this.dVW.aLf();
                break;
        }
        eVar2 = this.dVW.dVP;
        eVar2.dismiss();
    }
}
