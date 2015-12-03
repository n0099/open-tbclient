package com.baidu.tieba.tbadkCore;

import android.content.Context;
import android.view.View;
import com.baidu.tbadk.core.atomData.PraiseListActivityConfig;
import com.baidu.tbadk.core.data.PraiseData;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class j implements View.OnClickListener {
    final /* synthetic */ FrsPraiseView dxj;

    /* JADX INFO: Access modifiers changed from: package-private */
    public j(FrsPraiseView frsPraiseView) {
        this.dxj = frsPraiseView;
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
        praiseData = this.dxj.dxi;
        if (praiseData != null) {
            praiseData2 = this.dxj.dxi;
            str3 = praiseData2.getTitle();
        }
        context = this.dxj.mContext;
        str = this.dxj.mThreadId;
        str2 = this.dxj.mPostId;
        z = this.dxj.cHT;
        com.baidu.tbadk.util.h.c(new PraiseListActivityConfig(context, str, str2, str3, z));
    }
}
