package com.baidu.tieba.imMessageCenter.mention;

import android.view.View;
import com.baidu.tbadk.mvc.core.ViewEventCenter;
/* loaded from: classes.dex */
class aq implements View.OnClickListener {
    final /* synthetic */ an dsQ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aq(an anVar) {
        this.dsQ = anVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        com.baidu.tbadk.mvc.c.b bVar;
        ViewEventCenter lF;
        FeedData data = this.dsQ.getData();
        if (data != null && FeedData.TYPE_GRAFFITI.equals(data.getPraiseItemType())) {
            bVar = new com.baidu.tbadk.mvc.c.b(9487, data, null, null);
        } else {
            bVar = new com.baidu.tbadk.mvc.c.b(9484, data, null, null);
        }
        lF = this.dsQ.lF();
        lF.dispatchMvcEvent(bVar);
    }
}
