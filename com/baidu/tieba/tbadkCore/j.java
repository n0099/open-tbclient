package com.baidu.tieba.tbadkCore;

import android.content.Context;
import android.view.View;
import com.baidu.tbadk.core.atomData.PraiseListActivityConfig;
import com.baidu.tbadk.core.data.PraiseData;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class j implements View.OnClickListener {
    final /* synthetic */ FrsPraiseView fzM;

    /* JADX INFO: Access modifiers changed from: package-private */
    public j(FrsPraiseView frsPraiseView) {
        this.fzM = frsPraiseView;
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
        praiseData = this.fzM.fzK;
        if (praiseData != null) {
            praiseData2 = this.fzM.fzK;
            str3 = praiseData2.getTitle();
        }
        context = this.fzM.mContext;
        str = this.fzM.mThreadId;
        str2 = this.fzM.mPostId;
        z = this.fzM.eFv;
        com.baidu.tbadk.util.j.a(new PraiseListActivityConfig(context, str, str2, str3, z));
    }
}
