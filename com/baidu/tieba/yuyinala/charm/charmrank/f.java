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
/* loaded from: classes11.dex */
public class f {
    private List<com.baidu.live.liveroom.d.d> aEo = new LinkedList();
    private AlaLiveRoomPanelTabHost aEr;
    private View contentView;
    private View mRootView;
    private YuyinCharmRankTotalActivity oqE;

    public f(YuyinCharmRankTotalActivity yuyinCharmRankTotalActivity) {
        this.oqE = yuyinCharmRankTotalActivity;
        initView();
        bTV();
    }

    private void initView() {
        this.mRootView = LayoutInflater.from(this.oqE).inflate(a.g.yuyin_ala_charm_rank_total_activity_layout, (ViewGroup) null);
        this.contentView = this.mRootView.findViewById(a.f.ala_charm_root_view);
        this.aEr = (AlaLiveRoomPanelTabHost) this.mRootView.findViewById(a.f.ala_charm_tab_host);
        this.aEr.setIndicatorWidthAuto(false);
        this.aEr.setmIndicatorHeight(BdUtilHelper.getDimens(TbadkCoreApplication.getInst(), a.d.sdk_ds8));
        this.aEr.setmIndicatorWidth(BdUtilHelper.getDimens(TbadkCoreApplication.getInst(), a.d.sdk_ds36));
        this.aEr.setmIsYuyinLive(true);
    }

    public View getView() {
        return this.mRootView;
    }

    private void bTV() {
        Intent intent = this.oqE.getIntent();
        String stringExtra = intent.getStringExtra(YuyinAlaCharmRankActivityConfig.C_ROOM_ID);
        String stringExtra2 = intent.getStringExtra("live_id");
        int intExtra = intent.getIntExtra("user_type", 0);
        boolean booleanExtra = intent.getBooleanExtra(YuyinAlaCharmRankActivityConfig.SHOW_CHARM_LIST_VIEW, true);
        final d dVar = new d(this.oqE, 0, stringExtra, stringExtra2, intExtra);
        dVar.createView();
        this.aEo.add(dVar);
        if (booleanExtra) {
            final d dVar2 = new d(this.oqE, 1, stringExtra, stringExtra2, intExtra);
            dVar2.createView();
            this.aEo.add(dVar2);
            this.aEr.setIsIndicatorFollow(true);
            this.aEr.setPageSelectedListener(new AlaLiveRoomPanelTabHost.b() { // from class: com.baidu.tieba.yuyinala.charm.charmrank.f.1
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
        this.aEr.setData(this.aEo);
    }

    public void onDestory() {
        for (com.baidu.live.liveroom.d.d dVar : this.aEo) {
            dVar.onDestroy();
        }
    }
}
