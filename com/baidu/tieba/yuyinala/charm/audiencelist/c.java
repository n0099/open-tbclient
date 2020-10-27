package com.baidu.tieba.yuyinala.charm.audiencelist;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.live.adp.lib.util.BdUtilHelper;
import com.baidu.live.bottompanel.NobilityAlaLiveRoomPanelTabHost;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.core.atomdata.YuyinAlaCharmCardActivityConfig;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes4.dex */
public class c {
    private List<com.baidu.live.liveroom.d.d> aFm = new LinkedList();
    private boolean aJi;
    private View contentView;
    private View mRootView;
    private YuyinALaAudiencesActivity nLH;
    private NobilityAlaLiveRoomPanelTabHost nLI;
    private f nLJ;

    public c(YuyinALaAudiencesActivity yuyinALaAudiencesActivity) {
        this.nLH = yuyinALaAudiencesActivity;
        initView();
        bOU();
    }

    private void initView() {
        this.mRootView = LayoutInflater.from(this.nLH).inflate(a.h.yuyin_ala_charm_activity_layout, (ViewGroup) null);
        this.contentView = this.mRootView.findViewById(a.g.ala_charm_root_view);
        this.contentView.setBackgroundResource(a.f.yuyin_ala_audiencelist_white_corner);
        this.nLI = (NobilityAlaLiveRoomPanelTabHost) this.mRootView.findViewById(a.g.ala_charm_tab_host);
        this.nLI.setIndicatorWidthAuto(false);
        this.nLI.setmIndicatorHeight(BdUtilHelper.getDimens(TbadkCoreApplication.getInst(), a.e.sdk_ds8));
        this.nLI.setmIndicatorWidth(BdUtilHelper.getDimens(TbadkCoreApplication.getInst(), a.e.sdk_ds40));
    }

    public View getView() {
        return this.mRootView;
    }

    private void bOU() {
        Intent intent = this.nLH.getIntent();
        intent.getStringExtra("user_name");
        intent.getStringExtra("group_id");
        String stringExtra = intent.getStringExtra("live_id");
        this.aJi = intent.getBooleanExtra("live_owner_flag", false);
        String stringExtra2 = intent.getStringExtra("live_owner_uid");
        String stringExtra3 = intent.getStringExtra("login_user_id");
        boolean booleanExtra = intent.getBooleanExtra(YuyinAlaCharmCardActivityConfig.IS_SHOW_BUY_ENTRY, false);
        this.nLJ = new f(this.nLH);
        this.nLJ.UR(stringExtra).createView();
        this.aFm.add(this.nLJ);
        final g gVar = new g(this.nLH);
        gVar.yH(this.aJi).US(stringExtra).UT(stringExtra2).UU(stringExtra3).yG(booleanExtra).createView();
        this.aFm.add(gVar);
        this.nLI.setData(this.aFm);
        this.nLI.setPageSelectedListener(new NobilityAlaLiveRoomPanelTabHost.b() { // from class: com.baidu.tieba.yuyinala.charm.audiencelist.c.1
            @Override // com.baidu.live.bottompanel.NobilityAlaLiveRoomPanelTabHost.b
            public void onPageSelected(int i) {
                if (i == 0) {
                    c.this.nLJ.loadData();
                } else if (i == 1) {
                    gVar.loadData();
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
