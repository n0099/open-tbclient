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
    private List<com.baidu.live.liveroom.d.d> aGX = new LinkedList();
    private AlaLiveRoomPanelTabHost aHa;
    private View contentView;
    private View mRootView;
    private YuyinCharmRankTotalActivity oje;

    public f(YuyinCharmRankTotalActivity yuyinCharmRankTotalActivity) {
        this.oje = yuyinCharmRankTotalActivity;
        initView();
        bUx();
    }

    private void initView() {
        this.mRootView = LayoutInflater.from(this.oje).inflate(a.g.yuyin_ala_charm_rank_total_activity_layout, (ViewGroup) null);
        this.contentView = this.mRootView.findViewById(a.f.ala_charm_root_view);
        this.aHa = (AlaLiveRoomPanelTabHost) this.mRootView.findViewById(a.f.ala_charm_tab_host);
        this.aHa.setIndicatorWidthAuto(false);
        this.aHa.setmIndicatorHeight(BdUtilHelper.getDimens(TbadkCoreApplication.getInst(), a.d.sdk_ds8));
        this.aHa.setmIndicatorWidth(BdUtilHelper.getDimens(TbadkCoreApplication.getInst(), a.d.sdk_ds40));
        this.aHa.setmIsYuyinLive(true);
    }

    public View getView() {
        return this.mRootView;
    }

    private void bUx() {
        Intent intent = this.oje.getIntent();
        String stringExtra = intent.getStringExtra(YuyinAlaCharmRankActivityConfig.C_ROOM_ID);
        String stringExtra2 = intent.getStringExtra("live_id");
        int intExtra = intent.getIntExtra("user_type", 0);
        final d dVar = new d(this.oje, 0, stringExtra, stringExtra2, intExtra);
        dVar.createView();
        this.aGX.add(dVar);
        final d dVar2 = new d(this.oje, 1, stringExtra, stringExtra2, intExtra);
        dVar2.createView();
        this.aGX.add(dVar2);
        this.aHa.setData(this.aGX);
        this.aHa.setPageSelectedListener(new AlaLiveRoomPanelTabHost.b() { // from class: com.baidu.tieba.yuyinala.charm.charmrank.f.1
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
        for (com.baidu.live.liveroom.d.d dVar : this.aGX) {
            dVar.onDestroy();
        }
    }
}
