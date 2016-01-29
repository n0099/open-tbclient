package com.baidu.tieba.setting.more;

import android.view.View;
import android.widget.AdapterView;
import com.baidu.tbadk.core.util.TiebaStatic;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class p implements AdapterView.OnItemClickListener {
    final /* synthetic */ l dKz;

    /* JADX INFO: Access modifiers changed from: package-private */
    public p(l lVar) {
        this.dKz = lVar;
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        com.baidu.tbadk.core.dialog.f fVar;
        int i2 = 1;
        fVar = this.dKz.dKl;
        fVar.ci(i);
        switch (i) {
            case 0:
                TiebaStatic.log(new com.baidu.tbadk.core.util.au("c10411").r("obj_type", 1));
                break;
            case 1:
                TiebaStatic.log(new com.baidu.tbadk.core.util.au("c10411").r("obj_type", 2));
                i2 = 2;
                break;
            case 2:
                TiebaStatic.log(new com.baidu.tbadk.core.util.au("c10411").r("obj_type", 3));
                i2 = 0;
                break;
            default:
                i2 = 0;
                break;
        }
        com.baidu.tbadk.core.l.rn().bA(i2);
        this.dKz.nN(i2);
    }
}
