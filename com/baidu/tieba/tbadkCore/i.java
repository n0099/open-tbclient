package com.baidu.tieba.tbadkCore;

import android.content.Context;
import android.view.View;
import com.baidu.tbadk.core.atomData.PraiseListActivityConfig;
import com.baidu.tbadk.core.data.PraiseData;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class i implements View.OnClickListener {
    final /* synthetic */ FrsPraiseView frG;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(FrsPraiseView frsPraiseView) {
        this.frG = frsPraiseView;
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
        praiseData = this.frG.frE;
        if (praiseData != null) {
            praiseData2 = this.frG.frE;
            str3 = praiseData2.getTitle();
        }
        context = this.frG.mContext;
        str = this.frG.mThreadId;
        str2 = this.frG.mPostId;
        z = this.frG.evT;
        com.baidu.tbadk.util.j.a(new PraiseListActivityConfig(context, str, str2, str3, z));
    }
}
