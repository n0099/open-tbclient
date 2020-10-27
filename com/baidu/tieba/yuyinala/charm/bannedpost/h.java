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
/* loaded from: classes4.dex */
public class h {
    private List<com.baidu.live.liveroom.d.d> aFm = new LinkedList();
    private AlaLiveRoomPanelTabHost aFp;
    private View contentView;
    private View mRootView;
    private YuyinBannedPostListActivity nMv;

    public h(YuyinBannedPostListActivity yuyinBannedPostListActivity) {
        this.nMv = yuyinBannedPostListActivity;
        initView();
        bOU();
    }

    private void initView() {
        this.mRootView = LayoutInflater.from(this.nMv).inflate(a.h.yuyin_ala_baned_post_activity_layout, (ViewGroup) null);
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
        Intent intent = this.nMv.getIntent();
        String stringExtra = intent.getStringExtra("room_id");
        String stringExtra2 = intent.getStringExtra("live_id");
        String stringExtra3 = intent.getStringExtra("group_id");
        final e eVar = new e(this.nMv, stringExtra2, stringExtra3, stringExtra, 1);
        eVar.createView();
        this.aFm.add(eVar);
        final e eVar2 = new e(this.nMv, stringExtra2, stringExtra3, stringExtra, 2);
        eVar2.createView();
        this.aFm.add(eVar2);
        this.aFp.setData(this.aFm);
        this.aFp.setPageSelectedListener(new AlaLiveRoomPanelTabHost.b() { // from class: com.baidu.tieba.yuyinala.charm.bannedpost.h.1
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
        for (com.baidu.live.liveroom.d.d dVar : this.aFm) {
            dVar.onDestroy();
        }
    }
}
