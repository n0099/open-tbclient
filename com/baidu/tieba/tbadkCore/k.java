package com.baidu.tieba.tbadkCore;

import android.content.Context;
import android.view.View;
import com.baidu.tbadk.core.atomData.PersonInfoActivityConfig;
import com.baidu.tbadk.core.data.MetaData;
import com.baidu.tbadk.core.data.PraiseData;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class k implements View.OnClickListener {
    final /* synthetic */ FrsPraiseView dUG;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(FrsPraiseView frsPraiseView) {
        this.dUG = frsPraiseView;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        PraiseData praiseData;
        Context context;
        praiseData = this.dUG.dUE;
        MetaData metaData = praiseData.getUser().get(0);
        if (metaData != null) {
            context = this.dUG.mContext;
            com.baidu.tbadk.util.h.a(CmdConfigCustom.START_PERSON_INFO, new PersonInfoActivityConfig(context, metaData.getUserId(), metaData.getName_show()));
        }
    }
}
