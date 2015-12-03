package com.baidu.tieba.setting.more;

import android.view.View;
import android.widget.AdapterView;
import com.baidu.tbadk.core.util.TiebaStatic;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class o implements AdapterView.OnItemClickListener {
    final /* synthetic */ l dnj;

    /* JADX INFO: Access modifiers changed from: package-private */
    public o(l lVar) {
        this.dnj = lVar;
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        com.baidu.tbadk.core.dialog.e eVar;
        int i2;
        eVar = this.dnj.dmT;
        eVar.bW(i);
        switch (i) {
            case 1:
                i2 = 1;
                break;
            case 2:
                i2 = 2;
                break;
            case 3:
                i2 = 3;
                break;
            default:
                i2 = 0;
                break;
        }
        TiebaStatic.log(new com.baidu.tbadk.core.util.av("c10413").r("obj_type", i2));
        com.baidu.tbadk.core.m.rh().br(i2);
        this.dnj.lY(i2);
        this.dnj.axQ();
        com.baidu.tbadk.core.util.ay.vq().vz();
    }
}
