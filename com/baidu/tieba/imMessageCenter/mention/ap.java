package com.baidu.tieba.imMessageCenter.mention;

import android.view.View;
import com.baidu.tbadk.mvc.core.ViewEventCenter;
/* loaded from: classes2.dex */
class ap implements View.OnClickListener {
    final /* synthetic */ am dmP;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ap(am amVar) {
        this.dmP = amVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        com.baidu.tbadk.mvc.c.b bVar;
        ViewEventCenter ES;
        FeedData data = this.dmP.getData();
        if (data != null && FeedData.TYPE_GRAFFITI.equals(data.getPraiseItemType())) {
            bVar = new com.baidu.tbadk.mvc.c.b(9487, data, null, null);
        } else {
            bVar = new com.baidu.tbadk.mvc.c.b(9484, data, null, null);
        }
        ES = this.dmP.ES();
        ES.dispatchMvcEvent(bVar);
    }
}
