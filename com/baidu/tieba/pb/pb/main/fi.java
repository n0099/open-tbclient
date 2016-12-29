package com.baidu.tieba.pb.pb.main;

import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.tbadk.TbConfig;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class fi implements Runnable {
    final /* synthetic */ er egZ;
    private final /* synthetic */ int val$count;

    /* JADX INFO: Access modifiers changed from: package-private */
    public fi(er erVar, int i) {
        this.egZ = erVar;
        this.val$count = i;
    }

    @Override // java.lang.Runnable
    public void run() {
        BdTypeListView bdTypeListView;
        BdTypeListView bdTypeListView2;
        PbActivity pbActivity;
        PbActivity pbActivity2;
        bdTypeListView = this.egZ.aMc;
        if (bdTypeListView.getFirstVisiblePosition() <= 1) {
            bdTypeListView2 = this.egZ.aMc;
            bdTypeListView2.smoothScrollToPositionFromTop(1, 0, TbConfig.POST_IMAGE_SMALL);
            pbActivity = this.egZ.dYB;
            if (pbActivity.aJa() != null) {
                pbActivity2 = this.egZ.dYB;
                pbActivity2.aJa().Ur();
            }
            com.baidu.tbadk.core.sharedPref.b.tW().putInt(com.baidu.tbadk.core.sharedPref.b.cR("pb_video_immersive_guide_count_"), this.val$count + 1);
        }
    }
}
