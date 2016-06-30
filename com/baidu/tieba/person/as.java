package com.baidu.tieba.person;

import android.view.View;
import com.baidu.tbadk.core.util.TiebaStatic;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class as implements View.OnClickListener {
    final /* synthetic */ PersonChangeActivity eeV;

    /* JADX INFO: Access modifiers changed from: package-private */
    public as(PersonChangeActivity personChangeActivity) {
        this.eeV = personChangeActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        boolean z;
        z = this.eeV.civ;
        if (!z) {
            this.eeV.finish();
        }
        if (this.eeV.eey.booleanValue()) {
            TiebaStatic.log("c10100");
        } else {
            TiebaStatic.log("c10101");
        }
        this.eeV.aKG();
    }
}
