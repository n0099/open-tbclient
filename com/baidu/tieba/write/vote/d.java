package com.baidu.tieba.write.vote;

import android.view.View;
import android.widget.AdapterView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class d implements AdapterView.OnItemClickListener {
    final /* synthetic */ c dnF;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(c cVar) {
        this.dnF = cVar;
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        com.baidu.tbadk.core.dialog.e eVar;
        int i2;
        int i3;
        int i4;
        com.baidu.tbadk.core.dialog.e eVar2;
        eVar = this.dnF.dny;
        eVar.bO(i);
        switch (i) {
            case 0:
                this.dnF.dnw = 1;
                this.dnF.dnx = false;
                c cVar = this.dnF;
                i4 = this.dnF.dnw;
                cVar.mb(i4);
                break;
            case 1:
                this.dnF.dnw = 7;
                this.dnF.dnx = false;
                c cVar2 = this.dnF;
                i3 = this.dnF.dnw;
                cVar2.mb(i3);
                break;
            case 2:
                this.dnF.dnw = 30;
                this.dnF.dnx = false;
                c cVar3 = this.dnF;
                i2 = this.dnF.dnw;
                cVar3.mb(i2);
                break;
            case 3:
                this.dnF.aCz();
                break;
        }
        eVar2 = this.dnF.dny;
        eVar2.dismiss();
    }
}
