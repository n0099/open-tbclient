package com.baidu.tieba.recommendfrs.control;

import android.content.Context;
import android.view.View;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.aw;
import com.baidu.tbadk.core.util.bl;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class y implements View.OnClickListener {
    final /* synthetic */ q dZi;

    /* JADX INFO: Access modifiers changed from: package-private */
    public y(q qVar) {
        this.dZi = qVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Context context;
        Context context2;
        Context context3;
        context = this.dZi.mContext;
        if (context != null) {
            context2 = this.dZi.mContext;
            TiebaStatic.eventStat(context2, "notlogin_3", "click", 1, new Object[0]);
            TiebaStatic.log(new aw("c10517").ac("obj_source", "forum"));
            context3 = this.dZi.mContext;
            bl.aa(context3);
        }
    }
}
