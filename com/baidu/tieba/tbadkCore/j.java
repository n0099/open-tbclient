package com.baidu.tieba.tbadkCore;

import android.content.Context;
import android.view.View;
import com.baidu.tbadk.core.atomData.PersonInfoActivityConfig;
import com.baidu.tbadk.core.data.MetaData;
import com.baidu.tbadk.core.data.PraiseData;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class j implements View.OnClickListener {
    final /* synthetic */ FrsPraiseView eni;

    /* JADX INFO: Access modifiers changed from: package-private */
    public j(FrsPraiseView frsPraiseView) {
        this.eni = frsPraiseView;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        PraiseData praiseData;
        Context context;
        praiseData = this.eni.eng;
        MetaData metaData = praiseData.getUser().get(1);
        if (metaData != null) {
            context = this.eni.mContext;
            com.baidu.tbadk.util.k.a(CmdConfigCustom.START_PERSON_INFO, new PersonInfoActivityConfig(context, metaData.getUserId(), metaData.getName_show()));
        }
    }
}
