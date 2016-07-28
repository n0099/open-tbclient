package com.baidu.tieba.imMessageCenter.mention;

import android.view.View;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tieba.u;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ad implements com.baidu.tbadk.widget.layout.i {
    final /* synthetic */ z dgV;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ad(z zVar) {
        this.dgV = zVar;
    }

    @Override // com.baidu.tbadk.widget.layout.i
    public void a(View view, int i, int i2, int i3, int i4) {
        bf bfVar;
        bf bfVar2;
        if (i2 != i4) {
            int lightStatusBarHeight = UtilHelper.getLightStatusBarHeight();
            bfVar = this.dgV.dgz;
            bfVar2 = this.dgV.dgz;
            bfVar2.lH(lightStatusBarHeight + com.baidu.adp.lib.util.k.c(bfVar.getPageContext().getPageActivity(), u.e.ds98) + i2);
        }
    }
}
