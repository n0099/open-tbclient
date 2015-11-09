package com.baidu.tieba.setting.more;

import android.view.View;
import android.widget.AdapterView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class o implements AdapterView.OnItemClickListener {
    final /* synthetic */ l cOO;

    /* JADX INFO: Access modifiers changed from: package-private */
    public o(l lVar) {
        this.cOO = lVar;
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        com.baidu.tbadk.core.dialog.e eVar;
        int i2;
        eVar = this.cOO.cOB;
        eVar.bO(i);
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
        com.baidu.tbadk.core.m.qV().bp(i2);
        this.cOO.kQ(i2);
        this.cOO.asp();
        com.baidu.tbadk.core.util.at.uK().uT();
    }
}
