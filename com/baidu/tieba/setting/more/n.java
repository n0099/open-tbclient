package com.baidu.tieba.setting.more;

import android.view.View;
import android.widget.AdapterView;
import com.baidu.tbadk.core.util.TiebaStatic;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class n implements AdapterView.OnItemClickListener {
    final /* synthetic */ l dKz;

    /* JADX INFO: Access modifiers changed from: package-private */
    public n(l lVar) {
        this.dKz = lVar;
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        com.baidu.tbadk.core.dialog.f fVar;
        fVar = this.dKz.dKk;
        fVar.ci(i);
        switch (i) {
            case 0:
                com.baidu.tbadk.core.l.rn().ae(true);
                com.baidu.tbadk.core.l.rn().bB(0);
                break;
            case 1:
                com.baidu.tbadk.core.l.rn().ae(true);
                com.baidu.tbadk.core.l.rn().bB(1);
                TiebaStatic.log(new com.baidu.tbadk.core.util.au("c10415").r("obj_type", 1));
                break;
            case 2:
                com.baidu.tbadk.core.l.rn().ae(true);
                com.baidu.tbadk.core.l.rn().bB(2);
                TiebaStatic.log(new com.baidu.tbadk.core.util.au("c10415").r("obj_type", 3));
                break;
            case 3:
                com.baidu.tbadk.core.l.rn().ae(false);
                break;
        }
        this.dKz.aHe();
        this.dKz.aHd();
    }
}
