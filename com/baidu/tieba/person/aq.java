package com.baidu.tieba.person;

import android.view.View;
import com.baidu.tbadk.core.util.TiebaStatic;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class aq implements View.OnClickListener {
    final /* synthetic */ PersonChangeActivity cKS;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aq(PersonChangeActivity personChangeActivity) {
        this.cKS = personChangeActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.cKS.cKx.booleanValue()) {
            TiebaStatic.log("c10100");
        } else {
            TiebaStatic.log("c10101");
        }
        this.cKS.anG();
    }
}
