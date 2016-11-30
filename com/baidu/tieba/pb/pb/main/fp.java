package com.baidu.tieba.pb.pb.main;

import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.tbadk.TbConfig;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class fp implements Runnable {
    final /* synthetic */ ey eCT;
    private final /* synthetic */ int val$count;

    /* JADX INFO: Access modifiers changed from: package-private */
    public fp(ey eyVar, int i) {
        this.eCT = eyVar;
        this.val$count = i;
    }

    @Override // java.lang.Runnable
    public void run() {
        BdTypeListView bdTypeListView;
        BdTypeListView bdTypeListView2;
        PbActivity pbActivity;
        PbActivity pbActivity2;
        bdTypeListView = this.eCT.aML;
        if (bdTypeListView.getFirstVisiblePosition() <= 1) {
            bdTypeListView2 = this.eCT.aML;
            bdTypeListView2.smoothScrollToPositionFromTop(1, 0, TbConfig.POST_IMAGE_SMALL);
            pbActivity = this.eCT.eug;
            if (pbActivity.aPb() != null) {
                pbActivity2 = this.eCT.eug;
                pbActivity2.aPb().aae();
            }
            com.baidu.tbadk.core.sharedPref.b.um().putInt(com.baidu.tbadk.core.sharedPref.b.cQ("pb_video_immersive_guide_count_"), this.val$count + 1);
        }
    }
}
