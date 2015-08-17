package com.baidu.tieba.tbadkCore;

import android.content.Context;
import android.view.View;
import com.baidu.tbadk.core.atomData.PraiseListActivityConfig;
import com.baidu.tbadk.core.data.PraiseData;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class h implements View.OnClickListener {
    final /* synthetic */ FrsPraiseView cGX;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(FrsPraiseView frsPraiseView) {
        this.cGX = frsPraiseView;
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
        praiseData = this.cGX.cGW;
        if (praiseData != null) {
            praiseData2 = this.cGX.cGW;
            str3 = praiseData2.getTitle();
        }
        context = this.cGX.mContext;
        str = this.cGX.mThreadId;
        str2 = this.cGX.mPostId;
        z = this.cGX.cgM;
        com.baidu.tbadk.util.f.c(new PraiseListActivityConfig(context, str, str2, str3, z));
    }
}
