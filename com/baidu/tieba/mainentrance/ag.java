package com.baidu.tieba.mainentrance;

import android.app.Activity;
import android.view.View;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.core.atomData.CreateBarGuideActivityConfig;
import com.baidu.tbadk.core.util.bq;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ag implements View.OnClickListener {
    final /* synthetic */ SquareSearchActivity bCF;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ag(SquareSearchActivity squareSearchActivity) {
        this.bCF = squareSearchActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        String str;
        if (bq.ae(this.bCF.getPageContext().getPageActivity())) {
            SquareSearchActivity squareSearchActivity = this.bCF;
            Activity pageActivity = this.bCF.getPageContext().getPageActivity();
            str = this.bCF.bCg;
            squareSearchActivity.sendMessage(new CustomMessage(2002001, new CreateBarGuideActivityConfig(pageActivity, str)));
        }
    }
}
