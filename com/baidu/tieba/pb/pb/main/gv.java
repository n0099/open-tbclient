package com.baidu.tieba.pb.pb.main;

import com.baidu.tieba.pb.a.a;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class gv implements a.InterfaceC0071a {
    final /* synthetic */ fx evi;

    /* JADX INFO: Access modifiers changed from: package-private */
    public gv(fx fxVar) {
        this.evi = fxVar;
    }

    @Override // com.baidu.tieba.pb.a.a.InterfaceC0071a
    public void aaY() {
        PbLandscapeListView pbLandscapeListView;
        com.baidu.tieba.pb.video.l lVar;
        PbLandscapeListView pbLandscapeListView2;
        com.baidu.tieba.pb.video.l lVar2;
        pbLandscapeListView = this.evi.esK;
        if (pbLandscapeListView != null) {
            lVar = this.evi.esB;
            if (lVar != null) {
                lVar2 = this.evi.esB;
                lVar2.aOY();
            }
            pbLandscapeListView2 = this.evi.esK;
            pbLandscapeListView2.smoothScrollToPosition(0);
        }
    }

    @Override // com.baidu.tieba.pb.a.a.InterfaceC0071a
    public void aaX() {
        PbActivity pbActivity;
        pbActivity = this.evi.elf;
        pbActivity.aat();
    }
}
