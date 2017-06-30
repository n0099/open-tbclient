package com.baidu.tieba.tbadkCore;

import android.content.Context;
import android.view.View;
import com.baidu.tbadk.core.atomData.PraiseListActivityConfig;
import com.baidu.tbadk.core.data.PraiseData;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class i implements View.OnClickListener {
    final /* synthetic */ FrsPraiseView fJG;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(FrsPraiseView frsPraiseView) {
        this.fJG = frsPraiseView;
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
        praiseData = this.fJG.fJE;
        if (praiseData != null) {
            praiseData2 = this.fJG.fJE;
            str3 = praiseData2.getTitle();
        }
        context = this.fJG.mContext;
        str = this.fJG.mThreadId;
        str2 = this.fJG.mPostId;
        z = this.fJG.eIE;
        com.baidu.tbadk.util.l.a(new PraiseListActivityConfig(context, str, str2, str3, z));
    }
}
