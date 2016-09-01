package com.baidu.tieba.imMessageCenter.mention;

import android.view.View;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tieba.t;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ad implements com.baidu.tbadk.widget.layout.i {
    final /* synthetic */ z dsB;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ad(z zVar) {
        this.dsB = zVar;
    }

    @Override // com.baidu.tbadk.widget.layout.i
    public void a(View view, int i, int i2, int i3, int i4) {
        bf bfVar;
        bf bfVar2;
        if (i2 != i4) {
            int lightStatusBarHeight = UtilHelper.getLightStatusBarHeight();
            bfVar = this.dsB.dsf;
            bfVar2 = this.dsB.dsf;
            bfVar2.mk(lightStatusBarHeight + com.baidu.adp.lib.util.k.e(bfVar.getPageContext().getPageActivity(), t.e.ds98) + i2);
        }
    }
}
