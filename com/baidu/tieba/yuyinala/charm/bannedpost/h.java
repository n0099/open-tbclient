package com.baidu.tieba.yuyinala.charm.bannedpost;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.live.adp.lib.util.BdUtilHelper;
import com.baidu.live.bottompanel.AlaLiveRoomPanelTabHost;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes10.dex */
public class h {
    private List<com.baidu.live.liveroom.d.d> aFO = new LinkedList();
    private AlaLiveRoomPanelTabHost aFR;
    private View contentView;
    private View mRootView;
    private YuyinBannedPostListActivity osw;

    public h(YuyinBannedPostListActivity yuyinBannedPostListActivity) {
        this.osw = yuyinBannedPostListActivity;
        initView();
        bUb();
    }

    private void initView() {
        this.mRootView = LayoutInflater.from(this.osw).inflate(a.g.yuyin_ala_baned_post_activity_layout, (ViewGroup) null);
        this.contentView = this.mRootView.findViewById(a.f.ala_charm_root_view);
        this.aFR = (AlaLiveRoomPanelTabHost) this.mRootView.findViewById(a.f.ala_charm_tab_host);
        this.aFR.setIndicatorWidthAuto(false);
        this.aFR.setmIndicatorHeight(BdUtilHelper.getDimens(TbadkCoreApplication.getInst(), a.d.sdk_ds8));
        this.aFR.setmIndicatorWidth(BdUtilHelper.getDimens(TbadkCoreApplication.getInst(), a.d.sdk_ds40));
        this.aFR.setmIsYuyinLive(true);
    }

    public View getView() {
        return this.mRootView;
    }

    private void bUb() {
        Intent intent = this.osw.getIntent();
        String stringExtra = intent.getStringExtra("room_id");
        String stringExtra2 = intent.getStringExtra("live_id");
        String stringExtra3 = intent.getStringExtra("group_id");
        final e eVar = new e(this.osw, stringExtra2, stringExtra3, stringExtra, 1);
        eVar.createView();
        this.aFO.add(eVar);
        final e eVar2 = new e(this.osw, stringExtra2, stringExtra3, stringExtra, 2);
        eVar2.createView();
        this.aFO.add(eVar2);
        this.aFR.setData(this.aFO);
        this.aFR.setPageSelectedListener(new AlaLiveRoomPanelTabHost.b() { // from class: com.baidu.tieba.yuyinala.charm.bannedpost.h.1
            @Override // com.baidu.live.bottompanel.AlaLiveRoomPanelTabHost.b
            public void onPageSelected(int i) {
                if (i == 0) {
                    eVar.loadData();
                } else if (i == 1) {
                    eVar2.loadData();
                }
            }
        });
    }

    public void onDestory() {
        for (com.baidu.live.liveroom.d.d dVar : this.aFO) {
            dVar.onDestroy();
        }
    }
}
