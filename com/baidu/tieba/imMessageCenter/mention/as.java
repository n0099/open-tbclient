package com.baidu.tieba.imMessageCenter.mention;

import android.view.View;
import com.baidu.tbadk.mvc.core.ViewEventCenter;
/* loaded from: classes.dex */
class as implements View.OnClickListener {
    final /* synthetic */ ap dcT;

    /* JADX INFO: Access modifiers changed from: package-private */
    public as(ap apVar) {
        this.dcT = apVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        com.baidu.tbadk.mvc.c.b bVar;
        ViewEventCenter lI;
        FeedData data = this.dcT.getData();
        if (data != null && FeedData.TYPE_GRAFFITI.equals(data.getPraiseItemType())) {
            bVar = new com.baidu.tbadk.mvc.c.b(9487, data, null, null);
        } else {
            bVar = new com.baidu.tbadk.mvc.c.b(9484, data, null, null);
        }
        lI = this.dcT.lI();
        lI.dispatchMvcEvent(bVar);
    }
}
