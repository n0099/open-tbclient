package com.baidu.tieba.setting.more;

import android.view.View;
import android.widget.AdapterView;
import com.baidu.tbadk.core.TbadkCoreApplication;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class r implements AdapterView.OnItemClickListener {
    final /* synthetic */ l dnj;

    /* JADX INFO: Access modifiers changed from: package-private */
    public r(l lVar) {
        this.dnj = lVar;
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        com.baidu.tbadk.core.dialog.e eVar;
        eVar = this.dnj.dmX;
        eVar.bW(i);
        switch (i) {
            case 0:
                TbadkCoreApplication.m411getInst().setFontSize(1);
                break;
            case 1:
                TbadkCoreApplication.m411getInst().setFontSize(2);
                break;
            case 2:
                TbadkCoreApplication.m411getInst().setFontSize(3);
                break;
        }
        this.dnj.axV();
    }
}
