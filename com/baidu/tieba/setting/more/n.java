package com.baidu.tieba.setting.more;

import android.view.View;
import android.widget.AdapterView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class n implements AdapterView.OnItemClickListener {
    final /* synthetic */ l cOO;

    /* JADX INFO: Access modifiers changed from: package-private */
    public n(l lVar) {
        this.cOO = lVar;
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        com.baidu.tbadk.core.dialog.e eVar;
        eVar = this.cOO.cOC;
        eVar.bO(i);
        switch (i) {
            case 0:
                com.baidu.tbadk.core.m.qV().ae(true);
                com.baidu.tbadk.core.m.qV().bq(0);
                break;
            case 1:
                com.baidu.tbadk.core.m.qV().ae(true);
                com.baidu.tbadk.core.m.qV().bq(1);
                break;
            case 2:
                com.baidu.tbadk.core.m.qV().ae(true);
                com.baidu.tbadk.core.m.qV().bq(2);
                break;
            case 3:
                com.baidu.tbadk.core.m.qV().ae(false);
                break;
        }
        this.cOO.asq();
        this.cOO.asp();
    }
}
