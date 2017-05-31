package com.baidu.tieba.personPolymeric.d;

import android.view.View;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.bb;
import com.baidu.tieba.w;
/* loaded from: classes.dex */
class aa implements View.OnClickListener {
    final /* synthetic */ w eNY;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aa(w wVar) {
        this.eNY = wVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        TbPageContext<?> tbPageContext;
        TbPageContext tbPageContext2;
        if (!com.baidu.adp.lib.util.k.hB()) {
            tbPageContext2 = this.eNY.ajh;
            tbPageContext2.showToast(w.l.no_network_guide);
            return;
        }
        bb vy = bb.vy();
        tbPageContext = this.eNY.ajh;
        vy.c(tbPageContext, new String[]{TbConfig.BIG_V_APPLAY});
    }
}
