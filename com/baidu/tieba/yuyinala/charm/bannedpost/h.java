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
    private List<com.baidu.live.liveroom.d.d> aGc = new LinkedList();
    private AlaLiveRoomPanelTabHost aGf;
    private View contentView;
    private View mRootView;
    private YuyinBannedPostListActivity nSp;

    public h(YuyinBannedPostListActivity yuyinBannedPostListActivity) {
        this.nSp = yuyinBannedPostListActivity;
        initView();
        bRu();
    }

    private void initView() {
        this.mRootView = LayoutInflater.from(this.nSp).inflate(a.g.yuyin_ala_baned_post_activity_layout, (ViewGroup) null);
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
        Intent intent = this.nSp.getIntent();
        String stringExtra = intent.getStringExtra("room_id");
        String stringExtra2 = intent.getStringExtra("live_id");
        String stringExtra3 = intent.getStringExtra("group_id");
        final e eVar = new e(this.nSp, stringExtra2, stringExtra3, stringExtra, 1);
        eVar.createView();
        this.aGc.add(eVar);
        final e eVar2 = new e(this.nSp, stringExtra2, stringExtra3, stringExtra, 2);
        eVar2.createView();
        this.aGc.add(eVar2);
        this.aGf.setData(this.aGc);
        this.aGf.setPageSelectedListener(new AlaLiveRoomPanelTabHost.b() { // from class: com.baidu.tieba.yuyinala.charm.bannedpost.h.1
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
        for (com.baidu.live.liveroom.d.d dVar : this.aGc) {
            dVar.onDestroy();
        }
    }
}
