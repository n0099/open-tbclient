package com.baidu.tieba.write.vote;

import android.view.View;
import android.widget.AdapterView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class d implements AdapterView.OnItemClickListener {
    final /* synthetic */ c dpu;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(c cVar) {
        this.dpu = cVar;
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        com.baidu.tbadk.core.dialog.e eVar;
        int i2;
        int i3;
        int i4;
        com.baidu.tbadk.core.dialog.e eVar2;
        eVar = this.dpu.dpn;
        eVar.bO(i);
        switch (i) {
            case 0:
                this.dpu.dpl = 1;
                this.dpu.dpm = false;
                c cVar = this.dpu;
                i4 = this.dpu.dpl;
                cVar.mp(i4);
                break;
            case 1:
                this.dpu.dpl = 7;
                this.dpu.dpm = false;
                c cVar2 = this.dpu;
                i3 = this.dpu.dpl;
                cVar2.mp(i3);
                break;
            case 2:
                this.dpu.dpl = 30;
                this.dpu.dpm = false;
                c cVar3 = this.dpu;
                i2 = this.dpu.dpl;
                cVar3.mp(i2);
                break;
            case 3:
                this.dpu.aDn();
                break;
        }
        eVar2 = this.dpu.dpn;
        eVar2.dismiss();
    }
}
