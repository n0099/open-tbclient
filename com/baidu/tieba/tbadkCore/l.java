package com.baidu.tieba.tbadkCore;

import android.content.Context;
import android.view.View;
import com.baidu.tbadk.core.atomData.PersonInfoActivityConfig;
import com.baidu.tbadk.core.data.MetaData;
import com.baidu.tbadk.core.data.PraiseData;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class l implements View.OnClickListener {
    final /* synthetic */ FrsPraiseView fif;

    /* JADX INFO: Access modifiers changed from: package-private */
    public l(FrsPraiseView frsPraiseView) {
        this.fif = frsPraiseView;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        PraiseData praiseData;
        Context context;
        praiseData = this.fif.fic;
        MetaData metaData = praiseData.getUser().get(0);
        if (metaData != null) {
            context = this.fif.mContext;
            com.baidu.tbadk.util.k.a(CmdConfigCustom.START_PERSON_INFO, new PersonInfoActivityConfig(context, metaData.getUserId(), metaData.getName_show()));
        }
    }
}
