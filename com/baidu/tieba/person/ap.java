package com.baidu.tieba.person;

import android.view.View;
import com.baidu.tbadk.core.util.TiebaStatic;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ap implements View.OnClickListener {
    final /* synthetic */ PersonChangeActivity cry;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ap(PersonChangeActivity personChangeActivity) {
        this.cry = personChangeActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.cry.crd.booleanValue()) {
            TiebaStatic.log("c10100");
        } else {
            TiebaStatic.log("c10101");
        }
        this.cry.ajd();
    }
}
