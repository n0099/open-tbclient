package com.baidu.tieba.imMessageCenter.mention;

import android.view.View;
import com.baidu.tbadk.mvc.core.ViewEventCenter;
/* loaded from: classes.dex */
class ap implements View.OnClickListener {
    final /* synthetic */ am cxS;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ap(am amVar) {
        this.cxS = amVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        com.baidu.tbadk.mvc.c.b bVar;
        ViewEventCenter oy;
        FeedData data = this.cxS.getData();
        if (data != null && FeedData.TYPE_GRAFFITI.equals(data.getPraiseItemType())) {
            bVar = new com.baidu.tbadk.mvc.c.b(9487, data, null, null);
        } else {
            bVar = new com.baidu.tbadk.mvc.c.b(9484, data, null, null);
        }
        oy = this.cxS.oy();
        oy.dispatchMvcEvent(bVar);
    }
}
