package com.baidu.tieba.person;

import android.view.View;
import com.baidu.tbadk.core.util.TiebaStatic;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class aq implements View.OnClickListener {
    final /* synthetic */ PersonChangeActivity dth;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aq(PersonChangeActivity personChangeActivity) {
        this.dth = personChangeActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.dth.dsK.booleanValue()) {
            TiebaStatic.log("c10100");
        } else {
            TiebaStatic.log("c10101");
        }
        this.dth.aBp();
    }
}
