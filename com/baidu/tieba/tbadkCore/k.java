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
    final /* synthetic */ FrsPraiseView eVg;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(FrsPraiseView frsPraiseView) {
        this.eVg = frsPraiseView;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        PraiseData praiseData;
        Context context;
        praiseData = this.eVg.eVe;
        MetaData metaData = praiseData.getUser().get(1);
        if (metaData != null) {
            context = this.eVg.mContext;
            com.baidu.tbadk.util.k.a(CmdConfigCustom.START_PERSON_INFO, new PersonInfoActivityConfig(context, metaData.getUserId(), metaData.getName_show()));
        }
    }
}
