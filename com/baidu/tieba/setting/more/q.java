package com.baidu.tieba.setting.more;

import android.view.View;
import android.widget.AdapterView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class q implements AdapterView.OnItemClickListener {
    final /* synthetic */ l dnj;

    /* JADX INFO: Access modifiers changed from: package-private */
    public q(l lVar) {
        this.dnj = lVar;
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        com.baidu.tbadk.core.dialog.e eVar;
        eVar = this.dnj.dmW;
        eVar.bW(i);
        switch (i) {
            case 0:
                com.baidu.tbadk.core.m.rh().bq(0);
                break;
            case 1:
                com.baidu.tbadk.core.m.rh().bq(1);
                break;
            case 2:
                com.baidu.tbadk.core.m.rh().bq(2);
                break;
        }
        this.dnj.axU();
        this.dnj.axQ();
    }
}
