package com.baidu.tieba.personPolymeric.b;

import android.view.View;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.bl;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class k implements View.OnClickListener {
    final /* synthetic */ i eUZ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(i iVar) {
        this.eUZ = iVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        TiebaStatic.eventStat(this.eUZ.aat.getPageActivity(), "notlogin_4", "click", 1, new Object[0]);
        bl.aM(this.eUZ.aat.getPageActivity());
    }
}
