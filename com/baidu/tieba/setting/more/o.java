package com.baidu.tieba.setting.more;

import android.view.View;
import android.widget.AdapterView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class o implements AdapterView.OnItemClickListener {
    final /* synthetic */ l cxv;

    /* JADX INFO: Access modifiers changed from: package-private */
    public o(l lVar) {
        this.cxv = lVar;
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        com.baidu.tbadk.core.dialog.e eVar;
        int i2;
        eVar = this.cxv.cxi;
        eVar.bL(i);
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
        com.baidu.tbadk.core.m.rd().bp(i2);
        this.cxv.jr(i2);
        this.cxv.ali();
        com.baidu.tbadk.core.util.ar.uE().uN();
    }
}
