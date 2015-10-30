package com.baidu.tieba.setting.more;

import android.view.View;
import android.widget.AdapterView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class n implements AdapterView.OnItemClickListener {
    final /* synthetic */ l cNs;

    /* JADX INFO: Access modifiers changed from: package-private */
    public n(l lVar) {
        this.cNs = lVar;
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        com.baidu.tbadk.core.dialog.e eVar;
        eVar = this.cNs.cNg;
        eVar.bO(i);
        switch (i) {
            case 0:
                com.baidu.tbadk.core.m.qU().ae(true);
                com.baidu.tbadk.core.m.qU().bq(0);
                break;
            case 1:
                com.baidu.tbadk.core.m.qU().ae(true);
                com.baidu.tbadk.core.m.qU().bq(1);
                break;
            case 2:
                com.baidu.tbadk.core.m.qU().ae(true);
                com.baidu.tbadk.core.m.qU().bq(2);
                break;
            case 3:
                com.baidu.tbadk.core.m.qU().ae(false);
                break;
        }
        this.cNs.arK();
        this.cNs.arJ();
    }
}
