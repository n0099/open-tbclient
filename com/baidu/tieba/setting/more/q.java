package com.baidu.tieba.setting.more;

import android.view.View;
import android.widget.AdapterView;
import com.baidu.tbadk.core.util.TiebaStatic;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class q implements AdapterView.OnItemClickListener {
    final /* synthetic */ l dKz;

    /* JADX INFO: Access modifiers changed from: package-private */
    public q(l lVar) {
        this.dKz = lVar;
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        com.baidu.tbadk.core.dialog.f fVar;
        fVar = this.dKz.dKm;
        fVar.ci(i);
        switch (i) {
            case 0:
                TiebaStatic.log(new com.baidu.tbadk.core.util.au("set_viewnophoto").r("obj_index", 2));
                com.baidu.tbadk.core.l.rn().bw(0);
                break;
            case 1:
                TiebaStatic.log(new com.baidu.tbadk.core.util.au("set_viewnophoto").r("obj_index", 1));
                com.baidu.tbadk.core.l.rn().bw(1);
                break;
            case 2:
                TiebaStatic.log(new com.baidu.tbadk.core.util.au("set_viewnophoto").r("obj_index", 3));
                com.baidu.tbadk.core.l.rn().bw(2);
                break;
        }
        this.dKz.aHh();
        this.dKz.aHd();
    }
}
