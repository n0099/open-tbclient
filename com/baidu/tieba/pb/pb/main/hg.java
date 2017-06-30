package com.baidu.tieba.pb.pb.main;

import com.baidu.tieba.pb.a.a;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class hg implements a.InterfaceC0074a {
    final /* synthetic */ gg eEv;

    /* JADX INFO: Access modifiers changed from: package-private */
    public hg(gg ggVar) {
        this.eEv = ggVar;
    }

    @Override // com.baidu.tieba.pb.a.a.InterfaceC0074a
    public void aeP() {
        PbLandscapeListView pbLandscapeListView;
        com.baidu.tieba.pb.video.l lVar;
        PbLandscapeListView pbLandscapeListView2;
        com.baidu.tieba.pb.video.l lVar2;
        pbLandscapeListView = this.eEv.eBV;
        if (pbLandscapeListView != null) {
            lVar = this.eEv.eBM;
            if (lVar != null) {
                lVar2 = this.eEv.eBM;
                lVar2.aSX();
            }
            pbLandscapeListView2 = this.eEv.eBV;
            pbLandscapeListView2.smoothScrollToPosition(0);
        }
    }

    @Override // com.baidu.tieba.pb.a.a.InterfaceC0074a
    public void aeO() {
        PbActivity pbActivity;
        pbActivity = this.eEv.euf;
        pbActivity.aej();
    }
}
