package com.baidu.tieba.tbadkCore;

import android.content.Context;
import android.view.View;
import com.baidu.tbadk.core.atomData.PersonInfoActivityConfig;
import com.baidu.tbadk.core.data.MetaData;
import com.baidu.tbadk.core.data.PraiseData;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class r implements View.OnClickListener {
    final /* synthetic */ FrsPraiseView bSE;

    /* JADX INFO: Access modifiers changed from: package-private */
    public r(FrsPraiseView frsPraiseView) {
        this.bSE = frsPraiseView;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        PraiseData praiseData;
        Context context;
        praiseData = this.bSE.bSC;
        MetaData metaData = praiseData.getUser().get(1);
        if (metaData != null) {
            context = this.bSE.mContext;
            com.baidu.tbadk.util.g.a(2002003, new PersonInfoActivityConfig(context, metaData.getUserId(), metaData.getName_show()));
        }
    }
}
