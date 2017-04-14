package com.baidu.tieba.tbadkCore;

import android.content.Context;
import android.view.View;
import com.baidu.tbadk.core.atomData.PraiseListActivityConfig;
import com.baidu.tbadk.core.data.PraiseData;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class i implements View.OnClickListener {
    final /* synthetic */ FrsPraiseView ftr;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(FrsPraiseView frsPraiseView) {
        this.ftr = frsPraiseView;
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
        praiseData = this.ftr.ftp;
        if (praiseData != null) {
            praiseData2 = this.ftr.ftp;
            str3 = praiseData2.getTitle();
        }
        context = this.ftr.mContext;
        str = this.ftr.mThreadId;
        str2 = this.ftr.mPostId;
        z = this.ftr.etY;
        com.baidu.tbadk.util.j.a(new PraiseListActivityConfig(context, str, str2, str3, z));
    }
}
