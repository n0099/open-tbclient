package com.baidu.tieba.setting.more;

import android.view.View;
import android.widget.AdapterView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class n implements AdapterView.OnItemClickListener {
    final /* synthetic */ l cxv;

    /* JADX INFO: Access modifiers changed from: package-private */
    public n(l lVar) {
        this.cxv = lVar;
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        com.baidu.tbadk.core.dialog.e eVar;
        eVar = this.cxv.cxj;
        eVar.bL(i);
        switch (i) {
            case 0:
                com.baidu.tbadk.core.m.rd().ae(true);
                com.baidu.tbadk.core.m.rd().bq(0);
                break;
            case 1:
                com.baidu.tbadk.core.m.rd().ae(true);
                com.baidu.tbadk.core.m.rd().bq(1);
                break;
            case 2:
                com.baidu.tbadk.core.m.rd().ae(true);
                com.baidu.tbadk.core.m.rd().bq(2);
                break;
            case 3:
                com.baidu.tbadk.core.m.rd().ae(false);
                break;
        }
        this.cxv.alj();
        this.cxv.ali();
    }
}
