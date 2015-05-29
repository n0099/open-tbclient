package com.baidu.tieba.setting.more;

import android.view.View;
import android.widget.AdapterView;
import com.baidu.tbadk.core.TbadkCoreApplication;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class p implements AdapterView.OnItemClickListener {
    final /* synthetic */ k cfp;

    /* JADX INFO: Access modifiers changed from: package-private */
    public p(k kVar) {
        this.cfp = kVar;
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        com.baidu.tbadk.core.dialog.i iVar;
        iVar = this.cfp.cff;
        iVar.bD(i);
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
        this.cfp.aiL();
    }
}
