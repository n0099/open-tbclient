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
    private List<com.baidu.live.liveroom.d.d> aFO = new LinkedList();
    private AlaLiveRoomPanelTabHost aFR;
    private View contentView;
    private View mRootView;
    private YuyinCharmRankTotalActivity osK;

    public f(YuyinCharmRankTotalActivity yuyinCharmRankTotalActivity) {
        this.osK = yuyinCharmRankTotalActivity;
        initView();
        bUb();
    }

    private void initView() {
        this.mRootView = LayoutInflater.from(this.osK).inflate(a.g.yuyin_ala_charm_rank_total_activity_layout, (ViewGroup) null);
        this.contentView = this.mRootView.findViewById(a.f.ala_charm_root_view);
        this.aFR = (AlaLiveRoomPanelTabHost) this.mRootView.findViewById(a.f.ala_charm_tab_host);
        this.aFR.setIndicatorWidthAuto(false);
        this.aFR.setmIndicatorHeight(BdUtilHelper.getDimens(TbadkCoreApplication.getInst(), a.d.sdk_ds8));
        this.aFR.setmIndicatorWidth(BdUtilHelper.getDimens(TbadkCoreApplication.getInst(), a.d.sdk_ds36));
        this.aFR.setmIsYuyinLive(true);
    }

    public View getView() {
        return this.mRootView;
    }

    private void bUb() {
        Intent intent = this.osK.getIntent();
        String stringExtra = intent.getStringExtra(YuyinAlaCharmRankActivityConfig.C_ROOM_ID);
        String stringExtra2 = intent.getStringExtra("live_id");
        int intExtra = intent.getIntExtra("user_type", 0);
        boolean booleanExtra = intent.getBooleanExtra(YuyinAlaCharmRankActivityConfig.SHOW_CHARM_LIST_VIEW, true);
        final d dVar = new d(this.osK, 0, stringExtra, stringExtra2, intExtra);
        dVar.createView();
        this.aFO.add(dVar);
        if (booleanExtra) {
            final d dVar2 = new d(this.osK, 1, stringExtra, stringExtra2, intExtra);
            dVar2.createView();
            this.aFO.add(dVar2);
            this.aFR.setIsIndicatorFollow(true);
            this.aFR.setPageSelectedListener(new AlaLiveRoomPanelTabHost.b() { // from class: com.baidu.tieba.yuyinala.charm.charmrank.f.1
                @Override // com.baidu.live.bottompanel.AlaLiveRoomPanelTabHost.b
                public void onPageSelected(int i) {
                    if (i == 0) {
                        dVar.mH(false);
                    } else if (i == 1) {
                        dVar2.mH(false);
                    }
                }
            });
        }
        this.aFR.setData(this.aFO);
    }

    public void onDestory() {
        for (com.baidu.live.liveroom.d.d dVar : this.aFO) {
            dVar.onDestroy();
        }
    }
}
