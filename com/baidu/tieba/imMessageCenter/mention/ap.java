package com.baidu.tieba.imMessageCenter.mention;

import android.view.View;
import com.baidu.tbadk.mvc.core.ViewEventCenter;
/* loaded from: classes2.dex */
class ap implements View.OnClickListener {
    final /* synthetic */ am dht;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ap(am amVar) {
        this.dht = amVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        com.baidu.tbadk.mvc.c.b bVar;
        ViewEventCenter EY;
        FeedData data = this.dht.getData();
        if (data != null && FeedData.TYPE_GRAFFITI.equals(data.getPraiseItemType())) {
            bVar = new com.baidu.tbadk.mvc.c.b(9487, data, null, null);
        } else {
            bVar = new com.baidu.tbadk.mvc.c.b(9484, data, null, null);
        }
        EY = this.dht.EY();
        EY.dispatchMvcEvent(bVar);
    }
}
