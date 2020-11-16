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
/* loaded from: classes4.dex */
public class f {
    private List<com.baidu.live.liveroom.d.d> aEr = new LinkedList();
    private AlaLiveRoomPanelTabHost aEu;
    private View contentView;
    private View mRootView;
    private YuyinCharmRankTotalActivity nUg;

    public f(YuyinCharmRankTotalActivity yuyinCharmRankTotalActivity) {
        this.nUg = yuyinCharmRankTotalActivity;
        initView();
        bQN();
    }

    private void initView() {
        this.mRootView = LayoutInflater.from(this.nUg).inflate(a.g.yuyin_ala_charm_rank_total_activity_layout, (ViewGroup) null);
        this.contentView = this.mRootView.findViewById(a.f.ala_charm_root_view);
        this.aEu = (AlaLiveRoomPanelTabHost) this.mRootView.findViewById(a.f.ala_charm_tab_host);
        this.aEu.setIndicatorWidthAuto(false);
        this.aEu.setmIndicatorHeight(BdUtilHelper.getDimens(TbadkCoreApplication.getInst(), a.d.sdk_ds8));
        this.aEu.setmIndicatorWidth(BdUtilHelper.getDimens(TbadkCoreApplication.getInst(), a.d.sdk_ds40));
        this.aEu.setmIsYuyinLive(true);
    }

    public View getView() {
        return this.mRootView;
    }

    private void bQN() {
        Intent intent = this.nUg.getIntent();
        String stringExtra = intent.getStringExtra(YuyinAlaCharmRankActivityConfig.C_ROOM_ID);
        String stringExtra2 = intent.getStringExtra("live_id");
        int intExtra = intent.getIntExtra("user_type", 0);
        final d dVar = new d(this.nUg, 0, stringExtra, stringExtra2, intExtra);
        dVar.createView();
        this.aEr.add(dVar);
        final d dVar2 = new d(this.nUg, 1, stringExtra, stringExtra2, intExtra);
        dVar2.createView();
        this.aEr.add(dVar2);
        this.aEu.setData(this.aEr);
        this.aEu.setPageSelectedListener(new AlaLiveRoomPanelTabHost.b() { // from class: com.baidu.tieba.yuyinala.charm.charmrank.f.1
            @Override // com.baidu.live.bottompanel.AlaLiveRoomPanelTabHost.b
            public void onPageSelected(int i) {
                if (i == 0) {
                    dVar.loadData();
                } else if (i == 1) {
                    dVar2.loadData();
                }
            }
        });
    }

    public void onDestory() {
        for (com.baidu.live.liveroom.d.d dVar : this.aEr) {
            dVar.onDestroy();
        }
    }
}
