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
    private List<com.baidu.live.liveroom.d.d> aGc = new LinkedList();
    private AlaLiveRoomPanelTabHost aGf;
    private View contentView;
    private View mRootView;
    private YuyinCharmRankTotalActivity nSD;

    public f(YuyinCharmRankTotalActivity yuyinCharmRankTotalActivity) {
        this.nSD = yuyinCharmRankTotalActivity;
        initView();
        bRu();
    }

    private void initView() {
        this.mRootView = LayoutInflater.from(this.nSD).inflate(a.g.yuyin_ala_charm_rank_total_activity_layout, (ViewGroup) null);
        this.contentView = this.mRootView.findViewById(a.f.ala_charm_root_view);
        this.aGf = (AlaLiveRoomPanelTabHost) this.mRootView.findViewById(a.f.ala_charm_tab_host);
        this.aGf.setIndicatorWidthAuto(false);
        this.aGf.setmIndicatorHeight(BdUtilHelper.getDimens(TbadkCoreApplication.getInst(), a.d.sdk_ds8));
        this.aGf.setmIndicatorWidth(BdUtilHelper.getDimens(TbadkCoreApplication.getInst(), a.d.sdk_ds40));
        this.aGf.setmIsYuyinLive(true);
    }

    public View getView() {
        return this.mRootView;
    }

    private void bRu() {
        Intent intent = this.nSD.getIntent();
        String stringExtra = intent.getStringExtra(YuyinAlaCharmRankActivityConfig.C_ROOM_ID);
        String stringExtra2 = intent.getStringExtra("live_id");
        int intExtra = intent.getIntExtra("user_type", 0);
        final d dVar = new d(this.nSD, 0, stringExtra, stringExtra2, intExtra);
        dVar.createView();
        this.aGc.add(dVar);
        final d dVar2 = new d(this.nSD, 1, stringExtra, stringExtra2, intExtra);
        dVar2.createView();
        this.aGc.add(dVar2);
        this.aGf.setData(this.aGc);
        this.aGf.setPageSelectedListener(new AlaLiveRoomPanelTabHost.b() { // from class: com.baidu.tieba.yuyinala.charm.charmrank.f.1
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
        for (com.baidu.live.liveroom.d.d dVar : this.aGc) {
            dVar.onDestroy();
        }
    }
}
