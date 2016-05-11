package com.baidu.tieba.tbadkCore;

import android.content.Context;
import android.view.View;
import com.baidu.tbadk.core.atomData.PraiseListActivityConfig;
import com.baidu.tbadk.core.data.PraiseData;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class i implements View.OnClickListener {
    final /* synthetic */ FrsPraiseView eqw;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(FrsPraiseView frsPraiseView) {
        this.eqw = frsPraiseView;
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
        praiseData = this.eqw.equ;
        if (praiseData != null) {
            praiseData2 = this.eqw.equ;
            str3 = praiseData2.getTitle();
        }
        context = this.eqw.mContext;
        str = this.eqw.mThreadId;
        str2 = this.eqw.mPostId;
        z = this.eqw.drg;
        com.baidu.tbadk.util.k.a(new PraiseListActivityConfig(context, str, str2, str3, z));
    }
}
