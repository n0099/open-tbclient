package com.baidu.tieba.tbadkCore;

import android.content.Context;
import android.view.View;
import com.baidu.tbadk.core.atomData.PraiseListActivityConfig;
import com.baidu.tbadk.core.data.PraiseData;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class q implements View.OnClickListener {
    final /* synthetic */ FrsPraiseView cpg;

    /* JADX INFO: Access modifiers changed from: package-private */
    public q(FrsPraiseView frsPraiseView) {
        this.cpg = frsPraiseView;
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
        praiseData = this.cpg.cpf;
        if (praiseData != null) {
            praiseData2 = this.cpg.cpf;
            str3 = praiseData2.getTitle();
        }
        context = this.cpg.mContext;
        str = this.cpg.mThreadId;
        str2 = this.cpg.mPostId;
        z = this.cpg.bQo;
        com.baidu.tbadk.util.i.c(new PraiseListActivityConfig(context, str, str2, str3, z));
    }
}
