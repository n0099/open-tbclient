package com.baidu.tieba.tbadkCore;

import android.content.Context;
import android.view.View;
import com.baidu.tbadk.core.atomData.PraiseListActivityConfig;
import com.baidu.tbadk.core.data.PraiseData;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class q implements View.OnClickListener {
    final /* synthetic */ FrsPraiseView bSE;

    /* JADX INFO: Access modifiers changed from: package-private */
    public q(FrsPraiseView frsPraiseView) {
        this.bSE = frsPraiseView;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        PraiseData praiseData;
        Context context;
        String str;
        String str2;
        boolean z;
        PraiseData praiseData2;
        String str3 = "";
        praiseData = this.bSE.bSC;
        if (praiseData != null) {
            praiseData2 = this.bSE.bSC;
            str3 = praiseData2.getTitle();
        }
        context = this.bSE.mContext;
        str = this.bSE.mThreadId;
        str2 = this.bSE.mPostId;
        z = this.bSE.bSD;
        com.baidu.tbadk.util.g.c(new PraiseListActivityConfig(context, str, str2, str3, z));
    }
}
