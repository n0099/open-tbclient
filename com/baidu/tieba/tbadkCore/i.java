package com.baidu.tieba.tbadkCore;

import android.content.Context;
import android.view.View;
import com.baidu.tbadk.core.atomData.PraiseListActivityConfig;
import com.baidu.tbadk.core.data.PraiseData;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class i implements View.OnClickListener {
    final /* synthetic */ FrsPraiseView cPv;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(FrsPraiseView frsPraiseView) {
        this.cPv = frsPraiseView;
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
        praiseData = this.cPv.cPu;
        if (praiseData != null) {
            praiseData2 = this.cPv.cPu;
            str3 = praiseData2.getTitle();
        }
        context = this.cPv.mContext;
        str = this.cPv.mThreadId;
        str2 = this.cPv.mPostId;
        z = this.cPv.chJ;
        com.baidu.tbadk.util.f.c(new PraiseListActivityConfig(context, str, str2, str3, z));
    }
}
