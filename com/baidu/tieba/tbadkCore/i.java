package com.baidu.tieba.tbadkCore;

import android.content.Context;
import android.view.View;
import com.baidu.tbadk.core.atomData.PraiseListActivityConfig;
import com.baidu.tbadk.core.data.PraiseData;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class i implements View.OnClickListener {
    final /* synthetic */ FrsPraiseView frM;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(FrsPraiseView frsPraiseView) {
        this.frM = frsPraiseView;
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
        praiseData = this.frM.frK;
        if (praiseData != null) {
            praiseData2 = this.frM.frK;
            str3 = praiseData2.getTitle();
        }
        context = this.frM.mContext;
        str = this.frM.mThreadId;
        str2 = this.frM.mPostId;
        z = this.frM.erW;
        com.baidu.tbadk.util.k.a(new PraiseListActivityConfig(context, str, str2, str3, z));
    }
}
