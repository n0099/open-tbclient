package com.baidu.tieba.setting.more;

import android.view.View;
import android.widget.AdapterView;
import com.baidu.tbadk.core.util.TiebaStatic;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class n implements AdapterView.OnItemClickListener {
    final /* synthetic */ l dnj;

    /* JADX INFO: Access modifiers changed from: package-private */
    public n(l lVar) {
        this.dnj = lVar;
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        com.baidu.tbadk.core.dialog.e eVar;
        eVar = this.dnj.dmU;
        eVar.bW(i);
        switch (i) {
            case 0:
                com.baidu.tbadk.core.m.rh().ag(true);
                com.baidu.tbadk.core.m.rh().bt(0);
                break;
            case 1:
                com.baidu.tbadk.core.m.rh().ag(true);
                com.baidu.tbadk.core.m.rh().bt(1);
                TiebaStatic.log(new com.baidu.tbadk.core.util.av("c10415").r("obj_type", 1));
                break;
            case 2:
                com.baidu.tbadk.core.m.rh().ag(true);
                com.baidu.tbadk.core.m.rh().bt(2);
                TiebaStatic.log(new com.baidu.tbadk.core.util.av("c10415").r("obj_type", 3));
                break;
            case 3:
                com.baidu.tbadk.core.m.rh().ag(false);
                break;
        }
        this.dnj.axR();
        this.dnj.axQ();
    }
}
