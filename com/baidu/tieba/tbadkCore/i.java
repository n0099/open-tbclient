package com.baidu.tieba.tbadkCore;

import android.content.Context;
import android.view.View;
import com.baidu.tbadk.core.atomData.PraiseListActivityConfig;
import com.baidu.tbadk.core.data.PraiseData;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class i implements View.OnClickListener {
    final /* synthetic */ FrsPraiseView cYG;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(FrsPraiseView frsPraiseView) {
        this.cYG = frsPraiseView;
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
        praiseData = this.cYG.cYF;
        if (praiseData != null) {
            praiseData2 = this.cYG.cYF;
            str3 = praiseData2.getTitle();
        }
        context = this.cYG.mContext;
        str = this.cYG.mThreadId;
        str2 = this.cYG.mPostId;
        z = this.cYG.coH;
        com.baidu.tbadk.util.g.c(new PraiseListActivityConfig(context, str, str2, str3, z));
    }
}
