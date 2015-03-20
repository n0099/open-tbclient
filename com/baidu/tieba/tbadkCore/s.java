package com.baidu.tieba.tbadkCore;

import android.content.Context;
import android.view.View;
import com.baidu.tbadk.core.atomData.PersonInfoActivityConfig;
import com.baidu.tbadk.core.data.MetaData;
import com.baidu.tbadk.core.data.PraiseData;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class s implements View.OnClickListener {
    final /* synthetic */ FrsPraiseView ckQ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public s(FrsPraiseView frsPraiseView) {
        this.ckQ = frsPraiseView;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        PraiseData praiseData;
        Context context;
        praiseData = this.ckQ.ckO;
        MetaData metaData = praiseData.getUser().get(0);
        if (metaData != null) {
            context = this.ckQ.mContext;
            com.baidu.tbadk.util.i.a(2002003, new PersonInfoActivityConfig(context, metaData.getUserId(), metaData.getName_show()));
        }
    }
}
