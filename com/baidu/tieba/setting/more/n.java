package com.baidu.tieba.setting.more;

import android.view.View;
import android.widget.AdapterView;
import com.baidu.tbadk.core.util.TiebaStatic;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class n implements AdapterView.OnItemClickListener {
    final /* synthetic */ l ecT;

    /* JADX INFO: Access modifiers changed from: package-private */
    public n(l lVar) {
        this.ecT = lVar;
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        com.baidu.tbadk.core.dialog.f fVar;
        fVar = this.ecT.ecE;
        fVar.ck(i);
        switch (i) {
            case 0:
                com.baidu.tbadk.core.l.qE().ad(true);
                com.baidu.tbadk.core.l.qE().bA(0);
                break;
            case 1:
                com.baidu.tbadk.core.l.qE().ad(true);
                com.baidu.tbadk.core.l.qE().bA(1);
                TiebaStatic.log(new com.baidu.tbadk.core.util.aw("c10415").r("obj_type", 1));
                break;
            case 2:
                com.baidu.tbadk.core.l.qE().ad(true);
                com.baidu.tbadk.core.l.qE().bA(2);
                TiebaStatic.log(new com.baidu.tbadk.core.util.aw("c10415").r("obj_type", 3));
                break;
            case 3:
                com.baidu.tbadk.core.l.qE().ad(false);
                break;
        }
        this.ecT.aNO();
        this.ecT.aNN();
    }
}
