package com.baidu.tieba.setting.more;

import android.view.View;
import android.widget.AdapterView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class p implements AdapterView.OnItemClickListener {
    final /* synthetic */ l cxv;

    /* JADX INFO: Access modifiers changed from: package-private */
    public p(l lVar) {
        this.cxv = lVar;
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        com.baidu.tbadk.core.dialog.e eVar;
        eVar = this.cxv.cxk;
        eVar.bL(i);
        switch (i) {
            case 0:
                com.baidu.tbadk.core.m.rd().bo(0);
                break;
            case 1:
                com.baidu.tbadk.core.m.rd().bo(1);
                break;
            case 2:
                com.baidu.tbadk.core.m.rd().bo(2);
                break;
        }
        this.cxv.all();
        this.cxv.ali();
    }
}
