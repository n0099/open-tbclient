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
    final /* synthetic */ FrsPraiseView dxj;

    /* JADX INFO: Access modifiers changed from: package-private */
    public l(FrsPraiseView frsPraiseView) {
        this.dxj = frsPraiseView;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        PraiseData praiseData;
        Context context;
        praiseData = this.dxj.dxi;
        MetaData metaData = praiseData.getUser().get(0);
        if (metaData != null) {
            context = this.dxj.mContext;
            com.baidu.tbadk.util.h.a(CmdConfigCustom.START_PERSON_INFO, new PersonInfoActivityConfig(context, metaData.getUserId(), metaData.getName_show()));
        }
    }
}
