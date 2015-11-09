package com.baidu.tieba.setting.more;

import android.view.View;
import android.widget.AdapterView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class p implements AdapterView.OnItemClickListener {
    final /* synthetic */ l cOO;

    /* JADX INFO: Access modifiers changed from: package-private */
    public p(l lVar) {
        this.cOO = lVar;
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        com.baidu.tbadk.core.dialog.e eVar;
        eVar = this.cOO.cOD;
        eVar.bO(i);
        switch (i) {
            case 0:
                com.baidu.tbadk.core.m.qV().bo(0);
                break;
            case 1:
                com.baidu.tbadk.core.m.qV().bo(1);
                break;
            case 2:
                com.baidu.tbadk.core.m.qV().bo(2);
                break;
        }
        this.cOO.ass();
        this.cOO.asp();
    }
}
