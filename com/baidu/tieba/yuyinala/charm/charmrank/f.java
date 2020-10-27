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
    private List<com.baidu.live.liveroom.d.d> aFm = new LinkedList();
    private AlaLiveRoomPanelTabHost aFp;
    private View contentView;
    private View mRootView;
    private YuyinCharmRankTotalActivity nMJ;

    public f(YuyinCharmRankTotalActivity yuyinCharmRankTotalActivity) {
        this.nMJ = yuyinCharmRankTotalActivity;
        initView();
        bOU();
    }

    private void initView() {
        this.mRootView = LayoutInflater.from(this.nMJ).inflate(a.h.yuyin_ala_charm_rank_total_activity_layout, (ViewGroup) null);
        this.contentView = this.mRootView.findViewById(a.g.ala_charm_root_view);
        this.aFp = (AlaLiveRoomPanelTabHost) this.mRootView.findViewById(a.g.ala_charm_tab_host);
        this.aFp.setIndicatorWidthAuto(false);
        this.aFp.setmIndicatorHeight(BdUtilHelper.getDimens(TbadkCoreApplication.getInst(), a.e.sdk_ds8));
        this.aFp.setmIndicatorWidth(BdUtilHelper.getDimens(TbadkCoreApplication.getInst(), a.e.sdk_ds40));
        this.aFp.setmIsYuyinLive(true);
    }

    public View getView() {
        return this.mRootView;
    }

    private void bOU() {
        Intent intent = this.nMJ.getIntent();
        String stringExtra = intent.getStringExtra(YuyinAlaCharmRankActivityConfig.C_ROOM_ID);
        String stringExtra2 = intent.getStringExtra("live_id");
        int intExtra = intent.getIntExtra("user_type", 0);
        final d dVar = new d(this.nMJ, 0, stringExtra, stringExtra2, intExtra);
        dVar.createView();
        this.aFm.add(dVar);
        final d dVar2 = new d(this.nMJ, 1, stringExtra, stringExtra2, intExtra);
        dVar2.createView();
        this.aFm.add(dVar2);
        this.aFp.setData(this.aFm);
        this.aFp.setPageSelectedListener(new AlaLiveRoomPanelTabHost.b() { // from class: com.baidu.tieba.yuyinala.charm.charmrank.f.1
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
        for (com.baidu.live.liveroom.d.d dVar : this.aFm) {
            dVar.onDestroy();
        }
    }
}
