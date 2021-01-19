package com.baidu.tieba.yuyinala.charm.charmrank;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.live.adp.lib.util.BdUtilHelper;
import com.baidu.live.bottompanel.AlaLiveRoomPanelTabHost;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.core.atomdata.YuyinAlaCharmRankActivityConfig;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes10.dex */
public class f {
    private List<com.baidu.live.liveroom.d.d> aCB = new LinkedList();
    private AlaLiveRoomPanelTabHost aCE;
    private View contentView;
    private View mRootView;
    private YuyinCharmRankTotalActivity ogl;

    public f(YuyinCharmRankTotalActivity yuyinCharmRankTotalActivity) {
        this.ogl = yuyinCharmRankTotalActivity;
        initView();
        bTl();
    }

    private void initView() {
        this.mRootView = LayoutInflater.from(this.ogl).inflate(a.g.yuyin_ala_charm_rank_total_activity_layout, (ViewGroup) null);
        this.contentView = this.mRootView.findViewById(a.f.ala_charm_root_view);
        this.aCE = (AlaLiveRoomPanelTabHost) this.mRootView.findViewById(a.f.ala_charm_tab_host);
        this.aCE.setIndicatorWidthAuto(false);
        this.aCE.setmIndicatorHeight(BdUtilHelper.getDimens(TbadkCoreApplication.getInst(), a.d.sdk_ds8));
        this.aCE.setmIndicatorWidth(BdUtilHelper.getDimens(TbadkCoreApplication.getInst(), a.d.sdk_ds36));
        this.aCE.setmIsYuyinLive(true);
    }

    public View getView() {
        return this.mRootView;
    }

    private void bTl() {
        Intent intent = this.ogl.getIntent();
        String stringExtra = intent.getStringExtra(YuyinAlaCharmRankActivityConfig.C_ROOM_ID);
        String stringExtra2 = intent.getStringExtra("live_id");
        int intExtra = intent.getIntExtra("user_type", 0);
        final d dVar = new d(this.ogl, 0, stringExtra, stringExtra2, intExtra);
        dVar.createView();
        this.aCB.add(dVar);
        final d dVar2 = new d(this.ogl, 1, stringExtra, stringExtra2, intExtra);
        dVar2.createView();
        this.aCB.add(dVar2);
        this.aCE.setData(this.aCB);
        this.aCE.setIsIndicatorFollow(true);
        this.aCE.setPageSelectedListener(new AlaLiveRoomPanelTabHost.b() { // from class: com.baidu.tieba.yuyinala.charm.charmrank.f.1
            @Override // com.baidu.live.bottompanel.AlaLiveRoomPanelTabHost.b
            public void onPageSelected(int i) {
                if (i == 0) {
                    dVar.mD(false);
                } else if (i == 1) {
                    dVar2.mD(false);
                }
            }
        });
    }

    public void onDestory() {
        for (com.baidu.live.liveroom.d.d dVar : this.aCB) {
            dVar.onDestroy();
        }
    }
}
