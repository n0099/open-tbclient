package com.baidu.tieba.tbadkCore;

import android.content.Context;
import android.view.View;
import com.baidu.tbadk.core.atomData.PraiseListActivityConfig;
import com.baidu.tbadk.core.data.PraiseData;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class i implements View.OnClickListener {
    final /* synthetic */ FrsPraiseView fni;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(FrsPraiseView frsPraiseView) {
        this.fni = frsPraiseView;
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
        praiseData = this.fni.fng;
        if (praiseData != null) {
            praiseData2 = this.fni.fng;
            str3 = praiseData2.getTitle();
        }
        context = this.fni.mContext;
        str = this.fni.mThreadId;
        str2 = this.fni.mPostId;
        z = this.fni.esF;
        com.baidu.tbadk.util.j.a(new PraiseListActivityConfig(context, str, str2, str3, z));
    }
}
