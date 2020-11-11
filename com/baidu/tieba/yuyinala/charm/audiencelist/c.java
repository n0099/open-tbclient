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
    private List<com.baidu.live.liveroom.d.d> aGc = new LinkedList();
    private boolean aKf;
    private View contentView;
    private View mRootView;
    private YuyinALaAudiencesActivity nRB;
    private NobilityAlaLiveRoomPanelTabHost nRC;
    private f nRD;

    public c(YuyinALaAudiencesActivity yuyinALaAudiencesActivity) {
        this.nRB = yuyinALaAudiencesActivity;
        initView();
        bRu();
    }

    private void initView() {
        this.mRootView = LayoutInflater.from(this.nRB).inflate(a.g.yuyin_ala_charm_activity_layout, (ViewGroup) null);
        this.contentView = this.mRootView.findViewById(a.f.ala_charm_root_view);
        this.contentView.setBackgroundResource(a.e.yuyin_ala_audiencelist_white_corner);
        this.nRC = (NobilityAlaLiveRoomPanelTabHost) this.mRootView.findViewById(a.f.ala_charm_tab_host);
        this.nRC.setIndicatorWidthAuto(false);
        this.nRC.setmIndicatorHeight(BdUtilHelper.getDimens(TbadkCoreApplication.getInst(), a.d.sdk_ds8));
        this.nRC.setmIndicatorWidth(BdUtilHelper.getDimens(TbadkCoreApplication.getInst(), a.d.sdk_ds40));
    }

    public View getView() {
        return this.mRootView;
    }

    private void bRu() {
        Intent intent = this.nRB.getIntent();
        intent.getStringExtra("user_name");
        intent.getStringExtra("group_id");
        String stringExtra = intent.getStringExtra("live_id");
        this.aKf = intent.getBooleanExtra("live_owner_flag", false);
        String stringExtra2 = intent.getStringExtra("live_owner_uid");
        String stringExtra3 = intent.getStringExtra("login_user_id");
        boolean booleanExtra = intent.getBooleanExtra(YuyinAlaCharmCardActivityConfig.IS_SHOW_BUY_ENTRY, false);
        this.nRD = new f(this.nRB);
        this.nRD.Vi(stringExtra).createView();
        this.aGc.add(this.nRD);
        final g gVar = new g(this.nRB);
        gVar.yQ(this.aKf).Vj(stringExtra).Vk(stringExtra2).Vl(stringExtra3).yP(booleanExtra).createView();
        this.aGc.add(gVar);
        this.nRC.setData(this.aGc);
        this.nRC.setPageSelectedListener(new NobilityAlaLiveRoomPanelTabHost.b() { // from class: com.baidu.tieba.yuyinala.charm.audiencelist.c.1
            @Override // com.baidu.live.bottompanel.NobilityAlaLiveRoomPanelTabHost.b
            public void onPageSelected(int i) {
                if (i == 0) {
                    c.this.nRD.loadData();
                } else if (i == 1) {
                    gVar.loadData();
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
