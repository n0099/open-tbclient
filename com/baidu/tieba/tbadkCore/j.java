package com.baidu.tieba.tbadkCore;

import android.content.Context;
import android.view.View;
import com.baidu.tbadk.core.atomData.PraiseListActivityConfig;
import com.baidu.tbadk.core.data.PraiseData;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class j implements View.OnClickListener {
    final /* synthetic */ FrsPraiseView eVg;

    /* JADX INFO: Access modifiers changed from: package-private */
    public j(FrsPraiseView frsPraiseView) {
        this.eVg = frsPraiseView;
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
        praiseData = this.eVg.eVe;
        if (praiseData != null) {
            praiseData2 = this.eVg.eVe;
            str3 = praiseData2.getTitle();
        }
        context = this.eVg.mContext;
        str = this.eVg.mThreadId;
        str2 = this.eVg.mPostId;
        z = this.eVg.dXR;
        com.baidu.tbadk.util.k.a(new PraiseListActivityConfig(context, str, str2, str3, z));
    }
}
