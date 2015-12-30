package com.baidu.tieba.setting.more;

import android.view.View;
import android.widget.AdapterView;
import com.baidu.tbadk.core.util.TiebaStatic;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class n implements AdapterView.OnItemClickListener {
    final /* synthetic */ l duv;

    /* JADX INFO: Access modifiers changed from: package-private */
    public n(l lVar) {
        this.duv = lVar;
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        com.baidu.tbadk.core.dialog.e eVar;
        eVar = this.duv.dug;
        eVar.bP(i);
        switch (i) {
            case 0:
                com.baidu.tbadk.core.m.qQ().ad(true);
                com.baidu.tbadk.core.m.qQ().bm(0);
                break;
            case 1:
                com.baidu.tbadk.core.m.qQ().ad(true);
                com.baidu.tbadk.core.m.qQ().bm(1);
                TiebaStatic.log(new com.baidu.tbadk.core.util.av("c10415").r("obj_type", 1));
                break;
            case 2:
                com.baidu.tbadk.core.m.qQ().ad(true);
                com.baidu.tbadk.core.m.qQ().bm(2);
                TiebaStatic.log(new com.baidu.tbadk.core.util.av("c10415").r("obj_type", 3));
                break;
            case 3:
                com.baidu.tbadk.core.m.qQ().ad(false);
                break;
        }
        this.duv.azX();
        this.duv.azW();
    }
}
