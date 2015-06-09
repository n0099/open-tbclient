package com.baidu.tieba.setting.more;

import android.view.View;
import android.widget.AdapterView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class n implements AdapterView.OnItemClickListener {
    final /* synthetic */ k cfq;

    /* JADX INFO: Access modifiers changed from: package-private */
    public n(k kVar) {
        this.cfq = kVar;
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        com.baidu.tbadk.core.dialog.i iVar;
        int i2;
        iVar = this.cfq.cfd;
        iVar.bD(i);
        switch (i) {
            case 1:
                i2 = 1;
                break;
            case 2:
                i2 = 2;
                break;
            case 3:
                i2 = 3;
                break;
            default:
                i2 = 0;
                break;
        }
        com.baidu.tbadk.core.n.qc().bg(i2);
        this.cfq.iw(i2);
        this.cfq.aiI();
        com.baidu.tbadk.core.util.bc.tB().tK();
    }
}
