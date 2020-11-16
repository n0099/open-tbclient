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
    private List<com.baidu.live.liveroom.d.d> aEr = new LinkedList();
    private boolean aIu;
    private View contentView;
    private View mRootView;
    private YuyinALaAudiencesActivity nTe;
    private NobilityAlaLiveRoomPanelTabHost nTf;
    private f nTg;

    public c(YuyinALaAudiencesActivity yuyinALaAudiencesActivity) {
        this.nTe = yuyinALaAudiencesActivity;
        initView();
        bQN();
    }

    private void initView() {
        this.mRootView = LayoutInflater.from(this.nTe).inflate(a.g.yuyin_ala_charm_activity_layout, (ViewGroup) null);
        this.contentView = this.mRootView.findViewById(a.f.ala_charm_root_view);
        this.contentView.setBackgroundResource(a.e.yuyin_ala_audiencelist_white_corner);
        this.nTf = (NobilityAlaLiveRoomPanelTabHost) this.mRootView.findViewById(a.f.ala_charm_tab_host);
        this.nTf.setIndicatorWidthAuto(false);
        this.nTf.setmIndicatorHeight(BdUtilHelper.getDimens(TbadkCoreApplication.getInst(), a.d.sdk_ds8));
        this.nTf.setmIndicatorWidth(BdUtilHelper.getDimens(TbadkCoreApplication.getInst(), a.d.sdk_ds40));
    }

    public View getView() {
        return this.mRootView;
    }

    private void bQN() {
        Intent intent = this.nTe.getIntent();
        intent.getStringExtra("user_name");
        intent.getStringExtra("group_id");
        String stringExtra = intent.getStringExtra("live_id");
        this.aIu = intent.getBooleanExtra("live_owner_flag", false);
        String stringExtra2 = intent.getStringExtra("live_owner_uid");
        String stringExtra3 = intent.getStringExtra("login_user_id");
        boolean booleanExtra = intent.getBooleanExtra(YuyinAlaCharmCardActivityConfig.IS_SHOW_BUY_ENTRY, false);
        this.nTg = new f(this.nTe);
        this.nTg.UT(stringExtra).createView();
        this.aEr.add(this.nTg);
        final g gVar = new g(this.nTe);
        gVar.yX(this.aIu).UU(stringExtra).UV(stringExtra2).UW(stringExtra3).yW(booleanExtra).createView();
        this.aEr.add(gVar);
        this.nTf.setData(this.aEr);
        this.nTf.setPageSelectedListener(new NobilityAlaLiveRoomPanelTabHost.b() { // from class: com.baidu.tieba.yuyinala.charm.audiencelist.c.1
            @Override // com.baidu.live.bottompanel.NobilityAlaLiveRoomPanelTabHost.b
            public void onPageSelected(int i) {
                if (i == 0) {
                    c.this.nTg.loadData();
                } else if (i == 1) {
                    gVar.loadData();
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
