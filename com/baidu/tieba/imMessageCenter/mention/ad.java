package com.baidu.tieba.imMessageCenter.mention;

import android.view.View;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tieba.t;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ad implements com.baidu.tbadk.widget.layout.h {
    final /* synthetic */ z cyD;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ad(z zVar) {
        this.cyD = zVar;
    }

    @Override // com.baidu.tbadk.widget.layout.h
    public void a(View view, int i, int i2, int i3, int i4) {
        bf bfVar;
        bf bfVar2;
        if (i2 != i4) {
            int lightStatusBarHeight = UtilHelper.getLightStatusBarHeight();
            bfVar = this.cyD.cyh;
            bfVar2 = this.cyD.cyh;
            bfVar2.ka(lightStatusBarHeight + com.baidu.adp.lib.util.k.c(bfVar.getPageContext().getPageActivity(), t.e.ds98) + i2);
        }
    }
}
