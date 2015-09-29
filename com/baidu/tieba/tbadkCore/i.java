package com.baidu.tieba.tbadkCore;

import android.content.Context;
import android.view.View;
import com.baidu.tbadk.core.atomData.PraiseListActivityConfig;
import com.baidu.tbadk.core.data.PraiseData;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class i implements View.OnClickListener {
    final /* synthetic */ FrsPraiseView cWL;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(FrsPraiseView frsPraiseView) {
        this.cWL = frsPraiseView;
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
        praiseData = this.cWL.cWK;
        if (praiseData != null) {
            praiseData2 = this.cWL.cWK;
            str3 = praiseData2.getTitle();
        }
        context = this.cWL.mContext;
        str = this.cWL.mThreadId;
        str2 = this.cWL.mPostId;
        z = this.cWL.cnf;
        com.baidu.tbadk.util.g.c(new PraiseListActivityConfig(context, str, str2, str3, z));
    }
}
