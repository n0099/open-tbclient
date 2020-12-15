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
    private List<com.baidu.live.liveroom.d.d> aGX = new LinkedList();
    private boolean aLj;
    private View contentView;
    private View mRootView;
    private YuyinALaAudiencesActivity oie;
    private NobilityAlaLiveRoomPanelTabHost oif;
    private f oig;

    public c(YuyinALaAudiencesActivity yuyinALaAudiencesActivity) {
        this.oie = yuyinALaAudiencesActivity;
        initView();
        bUy();
    }

    private void initView() {
        this.mRootView = LayoutInflater.from(this.oie).inflate(a.g.yuyin_ala_charm_activity_layout, (ViewGroup) null);
        this.contentView = this.mRootView.findViewById(a.f.ala_charm_root_view);
        this.contentView.setBackgroundResource(a.e.yuyin_ala_audiencelist_white_corner);
        this.oif = (NobilityAlaLiveRoomPanelTabHost) this.mRootView.findViewById(a.f.ala_charm_tab_host);
        this.oif.setIndicatorWidthAuto(false);
        this.oif.setmIndicatorHeight(BdUtilHelper.getDimens(TbadkCoreApplication.getInst(), a.d.sdk_ds8));
        this.oif.setmIndicatorWidth(BdUtilHelper.getDimens(TbadkCoreApplication.getInst(), a.d.sdk_ds40));
    }

    public View getView() {
        return this.mRootView;
    }

    private void bUy() {
        Intent intent = this.oie.getIntent();
        intent.getStringExtra("user_name");
        intent.getStringExtra("group_id");
        String stringExtra = intent.getStringExtra("live_id");
        this.aLj = intent.getBooleanExtra("live_owner_flag", false);
        String stringExtra2 = intent.getStringExtra("live_owner_uid");
        String stringExtra3 = intent.getStringExtra("login_user_id");
        boolean booleanExtra = intent.getBooleanExtra(YuyinAlaCharmCardActivityConfig.IS_SHOW_BUY_ENTRY, false);
        this.oig = new f(this.oie);
        this.oig.Wi(stringExtra).createView();
        this.aGX.add(this.oig);
        final g gVar = new g(this.oie);
        gVar.zB(this.aLj).Wj(stringExtra).Wk(stringExtra2).Wl(stringExtra3).zA(booleanExtra).createView();
        this.aGX.add(gVar);
        this.oif.setData(this.aGX);
        this.oif.setPageSelectedListener(new NobilityAlaLiveRoomPanelTabHost.b() { // from class: com.baidu.tieba.yuyinala.charm.audiencelist.c.1
            @Override // com.baidu.live.bottompanel.NobilityAlaLiveRoomPanelTabHost.b
            public void onPageSelected(int i) {
                if (i == 0) {
                    c.this.oig.loadData();
                } else if (i == 1) {
                    gVar.loadData();
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
