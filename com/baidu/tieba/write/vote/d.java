package com.baidu.tieba.write.vote;

import android.view.View;
import android.widget.AdapterView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class d implements AdapterView.OnItemClickListener {
    final /* synthetic */ c dnf;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(c cVar) {
        this.dnf = cVar;
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        com.baidu.tbadk.core.dialog.e eVar;
        int i2;
        int i3;
        int i4;
        com.baidu.tbadk.core.dialog.e eVar2;
        eVar = this.dnf.dmY;
        eVar.bO(i);
        switch (i) {
            case 0:
                this.dnf.dmW = 1;
                this.dnf.dmX = false;
                c cVar = this.dnf;
                i4 = this.dnf.dmW;
                cVar.lZ(i4);
                break;
            case 1:
                this.dnf.dmW = 7;
                this.dnf.dmX = false;
                c cVar2 = this.dnf;
                i3 = this.dnf.dmW;
                cVar2.lZ(i3);
                break;
            case 2:
                this.dnf.dmW = 30;
                this.dnf.dmX = false;
                c cVar3 = this.dnf;
                i2 = this.dnf.dmW;
                cVar3.lZ(i2);
                break;
            case 3:
                this.dnf.aCp();
                break;
        }
        eVar2 = this.dnf.dmY;
        eVar2.dismiss();
    }
}
