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
/* loaded from: classes11.dex */
public class c {
    private boolean aJC;
    private View contentView;
    private View mRootView;
    private YuyinALaAudiencesActivity opB;
    private NobilityAlaLiveRoomPanelTabHost opC;
    private f opD;
    private g opE;
    private List<com.baidu.live.liveroom.d.d> aEo = new LinkedList();
    private HttpMessageListener opF = new HttpMessageListener(1031031) { // from class: com.baidu.tieba.yuyinala.charm.audiencelist.c.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage != null && (httpResponsedMessage instanceof OnlineListHttpResponseMessage)) {
                long j = 0;
                if (httpResponsedMessage instanceof OnlineListHttpResponseMessage) {
                    j = ((OnlineListHttpResponseMessage) httpResponsedMessage).bTQ();
                }
                c.this.opC.C(String.format(c.this.opB.getPageContext().getString(a.h.sdk_yuyin_onlineuser_tab_title), String.valueOf(j)), c.this.aEo.indexOf(c.this.opD));
            }
        }
    };
    private HttpMessageListener bwz = new HttpMessageListener(1031032) { // from class: com.baidu.tieba.yuyinala.charm.audiencelist.c.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            final com.baidu.live.noble.data.d Oq;
            if (httpResponsedMessage != null && (httpResponsedMessage instanceof AlaNobleUserListResponseMessage) && (Oq = ((AlaNobleUserListResponseMessage) httpResponsedMessage).Oq()) != null) {
                c.this.opC.setRightIconClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.yuyinala.charm.audiencelist.c.2.1
                    /* JADX DEBUG: Multi-variable search result rejected for r1v2, resolved type: com.baidu.tieba.yuyinala.charm.audiencelist.YuyinALaAudiencesActivity */
                    /* JADX WARN: Multi-variable type inference failed */
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (!UtilHelper.isFastDoubleClick() && !StringUtils.isNull(Oq.bwh)) {
                            UrlManager.getInstance().dealOneLink(c.this.opB.getPageContext(), new String[]{Oq.bwh});
                        }
                    }
                });
                c.this.opC.C(String.format(c.this.opB.getPageContext().getString(a.h.sdk_yuyin_onlinenoble_tab_title), String.valueOf(Oq.bwg)), c.this.aEo.indexOf(c.this.opE));
            }
        }
    };

    public c(YuyinALaAudiencesActivity yuyinALaAudiencesActivity) {
        this.opB = yuyinALaAudiencesActivity;
        MessageManager.getInstance().registerListener(this.bwz);
        MessageManager.getInstance().registerListener(this.opF);
        initView();
        bTV();
    }

    private void initView() {
        this.mRootView = LayoutInflater.from(this.opB).inflate(a.g.yuyin_ala_charm_activity_layout, (ViewGroup) null);
        this.contentView = this.mRootView.findViewById(a.f.ala_charm_root_view);
        this.contentView.setBackgroundResource(a.e.yuyin_ala_audiencelist_white_corner);
        this.opC = (NobilityAlaLiveRoomPanelTabHost) this.mRootView.findViewById(a.f.ala_charm_tab_host);
        this.opC.setIndicatorWidthAuto(false);
        this.opC.setmIndicatorHeight(BdUtilHelper.getDimens(TbadkCoreApplication.getInst(), a.d.sdk_ds8));
        this.opC.setmIndicatorWidth(BdUtilHelper.getDimens(TbadkCoreApplication.getInst(), a.d.sdk_ds40));
        this.opC.setRightIconVisible(false);
    }

    public View getView() {
        return this.mRootView;
    }

    private void bTV() {
        Intent intent = this.opB.getIntent();
        intent.getStringExtra("user_name");
        intent.getStringExtra("group_id");
        String stringExtra = intent.getStringExtra("live_id");
        this.aJC = intent.getBooleanExtra("live_owner_flag", false);
        String stringExtra2 = intent.getStringExtra("live_owner_uid");
        String stringExtra3 = intent.getStringExtra("login_user_id");
        boolean booleanExtra = intent.getBooleanExtra(YuyinAlaCharmCardActivityConfig.IS_SHOW_BUY_ENTRY, false);
        this.opD = new f(this.opB);
        this.opD.VK(stringExtra).createView();
        this.aEo.add(this.opD);
        this.opE = new g(this.opB);
        this.opE.zQ(this.aJC).VL(stringExtra).VM(stringExtra2).VN(stringExtra3).zP(booleanExtra).createView();
        this.aEo.add(this.opE);
        this.opC.setData(this.aEo);
        this.opC.setPageSelectedListener(new NobilityAlaLiveRoomPanelTabHost.b() { // from class: com.baidu.tieba.yuyinala.charm.audiencelist.c.3
            @Override // com.baidu.live.bottompanel.NobilityAlaLiveRoomPanelTabHost.b
            public void onPageSelected(int i) {
                if (i == 0) {
                    c.this.opD.mH(false);
                    c.this.opC.setRightIconVisible(false);
                } else if (i == 1) {
                    c.this.opE.mH(false);
                    c.this.opC.setRightIconVisible(true);
                }
            }
        });
    }

    public void onDestory() {
        for (com.baidu.live.liveroom.d.d dVar : this.aEo) {
            dVar.onDestroy();
        }
        MessageManager.getInstance().unRegisterListener(this.bwz);
        MessageManager.getInstance().unRegisterListener(this.opF);
    }
}
