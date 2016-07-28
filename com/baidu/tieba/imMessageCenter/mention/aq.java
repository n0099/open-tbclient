package com.baidu.tieba.imMessageCenter.mention;

import android.view.View;
import com.baidu.tbadk.mvc.core.ViewEventCenter;
/* loaded from: classes.dex */
class aq implements View.OnClickListener {
    final /* synthetic */ an dhk;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aq(an anVar) {
        this.dhk = anVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        com.baidu.tbadk.mvc.c.b bVar;
        ViewEventCenter kK;
        FeedData data = this.dhk.getData();
        if (data != null && FeedData.TYPE_GRAFFITI.equals(data.getPraiseItemType())) {
            bVar = new com.baidu.tbadk.mvc.c.b(9487, data, null, null);
        } else {
            bVar = new com.baidu.tbadk.mvc.c.b(9484, data, null, null);
        }
        kK = this.dhk.kK();
        kK.dispatchMvcEvent(bVar);
    }
}
