package com.baidu.tieba.imMessageCenter.mention;

import android.view.View;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tieba.r;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ad implements com.baidu.tbadk.widget.layout.i {
    final /* synthetic */ z dtY;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ad(z zVar) {
        this.dtY = zVar;
    }

    @Override // com.baidu.tbadk.widget.layout.i
    public void a(View view, int i, int i2, int i3, int i4) {
        bf bfVar;
        bf bfVar2;
        if (i2 != i4) {
            int lightStatusBarHeight = UtilHelper.getLightStatusBarHeight();
            bfVar = this.dtY.dtC;
            bfVar2 = this.dtY.dtC;
            bfVar2.ms(lightStatusBarHeight + com.baidu.adp.lib.util.k.e(bfVar.getPageContext().getPageActivity(), r.e.ds98) + i2);
        }
    }
}
