package com.baidu.tieba.setting.more;

import android.view.View;
import android.widget.AdapterView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class n implements AdapterView.OnItemClickListener {
    final /* synthetic */ l cMT;

    /* JADX INFO: Access modifiers changed from: package-private */
    public n(l lVar) {
        this.cMT = lVar;
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        com.baidu.tbadk.core.dialog.e eVar;
        eVar = this.cMT.cMH;
        eVar.bO(i);
        switch (i) {
            case 0:
                com.baidu.tbadk.core.m.qX().ae(true);
                com.baidu.tbadk.core.m.qX().bq(0);
                break;
            case 1:
                com.baidu.tbadk.core.m.qX().ae(true);
                com.baidu.tbadk.core.m.qX().bq(1);
                break;
            case 2:
                com.baidu.tbadk.core.m.qX().ae(true);
                com.baidu.tbadk.core.m.qX().bq(2);
                break;
            case 3:
                com.baidu.tbadk.core.m.qX().ae(false);
                break;
        }
        this.cMT.arI();
        this.cMT.arH();
    }
}
