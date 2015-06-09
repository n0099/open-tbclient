package com.baidu.tieba.setting.more;

import android.view.View;
import android.widget.AdapterView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class o implements AdapterView.OnItemClickListener {
    final /* synthetic */ k cfq;

    /* JADX INFO: Access modifiers changed from: package-private */
    public o(k kVar) {
        this.cfq = kVar;
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        com.baidu.tbadk.core.dialog.i iVar;
        iVar = this.cfq.cff;
        iVar.bD(i);
        switch (i) {
            case 0:
                com.baidu.tbadk.core.n.qc().bf(0);
                break;
            case 1:
                com.baidu.tbadk.core.n.qc().bf(1);
                break;
            case 2:
                com.baidu.tbadk.core.n.qc().bf(2);
                break;
        }
        this.cfq.aiL();
        this.cfq.aiI();
    }
}
