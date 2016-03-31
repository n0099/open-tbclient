package com.baidu.tieba.person;

import com.baidu.adp.widget.ListView.BdListView;
/* loaded from: classes.dex */
class be implements BdListView.e {
    final /* synthetic */ ax dtv;

    /* JADX INFO: Access modifiers changed from: package-private */
    public be(ax axVar) {
        this.dtv = axVar;
    }

    @Override // com.baidu.adp.widget.ListView.BdListView.e
    public void nm() {
        boolean z;
        bg bgVar;
        z = this.dtv.dtr;
        if (!z) {
            this.dtv.dtq = false;
            ax axVar = this.dtv;
            bgVar = this.dtv.dtm;
            axVar.pageNum = bgVar.getData().getPage().so() + 1;
            this.dtv.dtr = true;
            this.dtv.aBw();
        }
    }
}
