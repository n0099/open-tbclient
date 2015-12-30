package com.baidu.tieba.setting.more;

import android.view.View;
import android.widget.AdapterView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class q implements AdapterView.OnItemClickListener {
    final /* synthetic */ l duv;

    /* JADX INFO: Access modifiers changed from: package-private */
    public q(l lVar) {
        this.duv = lVar;
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        com.baidu.tbadk.core.dialog.e eVar;
        eVar = this.duv.dui;
        eVar.bP(i);
        switch (i) {
            case 0:
                com.baidu.tbadk.core.m.qQ().bj(0);
                break;
            case 1:
                com.baidu.tbadk.core.m.qQ().bj(1);
                break;
            case 2:
                com.baidu.tbadk.core.m.qQ().bj(2);
                break;
        }
        this.duv.aAa();
        this.duv.azW();
    }
}
