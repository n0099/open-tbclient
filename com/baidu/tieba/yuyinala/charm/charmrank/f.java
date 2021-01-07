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
    private List<com.baidu.live.liveroom.d.d> aHo = new LinkedList();
    private AlaLiveRoomPanelTabHost aHr;
    private View contentView;
    private View mRootView;
    private YuyinCharmRankTotalActivity okP;

    public f(YuyinCharmRankTotalActivity yuyinCharmRankTotalActivity) {
        this.okP = yuyinCharmRankTotalActivity;
        initView();
        bXd();
    }

    private void initView() {
        this.mRootView = LayoutInflater.from(this.okP).inflate(a.g.yuyin_ala_charm_rank_total_activity_layout, (ViewGroup) null);
        this.contentView = this.mRootView.findViewById(a.f.ala_charm_root_view);
        this.aHr = (AlaLiveRoomPanelTabHost) this.mRootView.findViewById(a.f.ala_charm_tab_host);
        this.aHr.setIndicatorWidthAuto(false);
        this.aHr.setmIndicatorHeight(BdUtilHelper.getDimens(TbadkCoreApplication.getInst(), a.d.sdk_ds8));
        this.aHr.setmIndicatorWidth(BdUtilHelper.getDimens(TbadkCoreApplication.getInst(), a.d.sdk_ds36));
        this.aHr.setmIsYuyinLive(true);
    }

    public View getView() {
        return this.mRootView;
    }

    private void bXd() {
        Intent intent = this.okP.getIntent();
        String stringExtra = intent.getStringExtra(YuyinAlaCharmRankActivityConfig.C_ROOM_ID);
        String stringExtra2 = intent.getStringExtra("live_id");
        int intExtra = intent.getIntExtra("user_type", 0);
        final d dVar = new d(this.okP, 0, stringExtra, stringExtra2, intExtra);
        dVar.createView();
        this.aHo.add(dVar);
        final d dVar2 = new d(this.okP, 1, stringExtra, stringExtra2, intExtra);
        dVar2.createView();
        this.aHo.add(dVar2);
        this.aHr.setData(this.aHo);
        this.aHr.setIsIndicatorFollow(true);
        this.aHr.setPageSelectedListener(new AlaLiveRoomPanelTabHost.b() { // from class: com.baidu.tieba.yuyinala.charm.charmrank.f.1
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

    public void onDestory() {
        for (com.baidu.live.liveroom.d.d dVar : this.aHo) {
            dVar.onDestroy();
        }
    }
}
