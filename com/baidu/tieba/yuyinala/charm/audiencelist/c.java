package com.baidu.tieba.yuyinala.charm.audiencelist;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.listener.HttpMessageListener;
import com.baidu.live.adp.framework.message.HttpResponsedMessage;
import com.baidu.live.adp.lib.util.BdUtilHelper;
import com.baidu.live.adp.lib.util.StringUtils;
import com.baidu.live.bottompanel.NobilityAlaLiveRoomPanelTabHost;
import com.baidu.live.message.AlaNobleUserListResponseMessage;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.core.atomdata.YuyinAlaCharmCardActivityConfig;
import com.baidu.live.tbadk.core.util.UrlManager;
import com.baidu.live.tbadk.core.util.UtilHelper;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes10.dex */
public class c {
    private boolean aGY;
    private View contentView;
    private View mRootView;
    private YuyinALaAudiencesActivity ofi;
    private NobilityAlaLiveRoomPanelTabHost ofj;
    private f ofk;
    private g ofl;
    private List<com.baidu.live.liveroom.d.d> aCB = new LinkedList();
    private HttpMessageListener ofm = new HttpMessageListener(1031031) { // from class: com.baidu.tieba.yuyinala.charm.audiencelist.c.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage != null && (httpResponsedMessage instanceof OnlineListHttpResponseMessage)) {
                long j = 0;
                if (httpResponsedMessage instanceof OnlineListHttpResponseMessage) {
                    j = ((OnlineListHttpResponseMessage) httpResponsedMessage).bTg();
                }
                c.this.ofj.C(String.format(c.this.ofi.getPageContext().getString(a.h.sdk_yuyin_onlineuser_tab_title), String.valueOf(j)), c.this.aCB.indexOf(c.this.ofk));
            }
        }
    };
    private HttpMessageListener bsV = new HttpMessageListener(1031032) { // from class: com.baidu.tieba.yuyinala.charm.audiencelist.c.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            final com.baidu.live.noble.data.d MS;
            if (httpResponsedMessage != null && (httpResponsedMessage instanceof AlaNobleUserListResponseMessage) && (MS = ((AlaNobleUserListResponseMessage) httpResponsedMessage).MS()) != null) {
                c.this.ofj.setRightIconClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.yuyinala.charm.audiencelist.c.2.1
                    /* JADX DEBUG: Multi-variable search result rejected for r1v2, resolved type: com.baidu.tieba.yuyinala.charm.audiencelist.YuyinALaAudiencesActivity */
                    /* JADX WARN: Multi-variable type inference failed */
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (!UtilHelper.isFastDoubleClick() && !StringUtils.isNull(MS.bsD)) {
                            UrlManager.getInstance().dealOneLink(c.this.ofi.getPageContext(), new String[]{MS.bsD});
                        }
                    }
                });
                c.this.ofj.C(String.format(c.this.ofi.getPageContext().getString(a.h.sdk_yuyin_onlinenoble_tab_title), String.valueOf(MS.bsC)), c.this.aCB.indexOf(c.this.ofl));
            }
        }
    };

    public c(YuyinALaAudiencesActivity yuyinALaAudiencesActivity) {
        this.ofi = yuyinALaAudiencesActivity;
        MessageManager.getInstance().registerListener(this.bsV);
        MessageManager.getInstance().registerListener(this.ofm);
        initView();
        bTl();
    }

    private void initView() {
        this.mRootView = LayoutInflater.from(this.ofi).inflate(a.g.yuyin_ala_charm_activity_layout, (ViewGroup) null);
        this.contentView = this.mRootView.findViewById(a.f.ala_charm_root_view);
        this.contentView.setBackgroundResource(a.e.yuyin_ala_audiencelist_white_corner);
        this.ofj = (NobilityAlaLiveRoomPanelTabHost) this.mRootView.findViewById(a.f.ala_charm_tab_host);
        this.ofj.setIndicatorWidthAuto(false);
        this.ofj.setmIndicatorHeight(BdUtilHelper.getDimens(TbadkCoreApplication.getInst(), a.d.sdk_ds8));
        this.ofj.setmIndicatorWidth(BdUtilHelper.getDimens(TbadkCoreApplication.getInst(), a.d.sdk_ds40));
        this.ofj.setRightIconVisible(false);
    }

    public View getView() {
        return this.mRootView;
    }

    private void bTl() {
        Intent intent = this.ofi.getIntent();
        intent.getStringExtra("user_name");
        intent.getStringExtra("group_id");
        String stringExtra = intent.getStringExtra("live_id");
        this.aGY = intent.getBooleanExtra("live_owner_flag", false);
        String stringExtra2 = intent.getStringExtra("live_owner_uid");
        String stringExtra3 = intent.getStringExtra("login_user_id");
        boolean booleanExtra = intent.getBooleanExtra(YuyinAlaCharmCardActivityConfig.IS_SHOW_BUY_ENTRY, false);
        this.ofk = new f(this.ofi);
        this.ofk.UA(stringExtra).createView();
        this.aCB.add(this.ofk);
        this.ofl = new g(this.ofi);
        this.ofl.zv(this.aGY).UB(stringExtra).UC(stringExtra2).UD(stringExtra3).zu(booleanExtra).createView();
        this.aCB.add(this.ofl);
        this.ofj.setData(this.aCB);
        this.ofj.setPageSelectedListener(new NobilityAlaLiveRoomPanelTabHost.b() { // from class: com.baidu.tieba.yuyinala.charm.audiencelist.c.3
            @Override // com.baidu.live.bottompanel.NobilityAlaLiveRoomPanelTabHost.b
            public void onPageSelected(int i) {
                if (i == 0) {
                    c.this.ofk.mD(false);
                    c.this.ofj.setRightIconVisible(false);
                } else if (i == 1) {
                    c.this.ofl.mD(false);
                    c.this.ofj.setRightIconVisible(true);
                }
            }
        });
    }

    public void onDestory() {
        for (com.baidu.live.liveroom.d.d dVar : this.aCB) {
            dVar.onDestroy();
        }
        MessageManager.getInstance().unRegisterListener(this.bsV);
        MessageManager.getInstance().unRegisterListener(this.ofm);
    }
}
