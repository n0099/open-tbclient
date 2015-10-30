package com.baidu.tieba.person;

import android.view.View;
import com.baidu.tbadk.core.util.TiebaStatic;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ap implements View.OnClickListener {
    final /* synthetic */ PersonChangeActivity cqc;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ap(PersonChangeActivity personChangeActivity) {
        this.cqc = personChangeActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.cqc.cpH.booleanValue()) {
            TiebaStatic.log("c10100");
        } else {
            TiebaStatic.log("c10101");
        }
        this.cqc.aix();
    }
}
