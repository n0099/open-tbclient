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
    private boolean aLL;
    private View contentView;
    private View mRootView;
    private YuyinALaAudiencesActivity ojM;
    private NobilityAlaLiveRoomPanelTabHost ojN;
    private f ojO;
    private g ojP;
    private List<com.baidu.live.liveroom.d.d> aHo = new LinkedList();
    private HttpMessageListener ojQ = new HttpMessageListener(1031031) { // from class: com.baidu.tieba.yuyinala.charm.audiencelist.c.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage != null && (httpResponsedMessage instanceof OnlineListHttpResponseMessage)) {
                long j = 0;
                if (httpResponsedMessage instanceof OnlineListHttpResponseMessage) {
                    j = ((OnlineListHttpResponseMessage) httpResponsedMessage).bWY();
                }
                c.this.ojN.C(String.format(c.this.ojM.getPageContext().getString(a.h.sdk_yuyin_onlineuser_tab_title), String.valueOf(j)), c.this.aHo.indexOf(c.this.ojO));
            }
        }
    };
    private HttpMessageListener bxJ = new HttpMessageListener(1031032) { // from class: com.baidu.tieba.yuyinala.charm.audiencelist.c.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            final com.baidu.live.noble.data.d QN;
            if (httpResponsedMessage != null && (httpResponsedMessage instanceof AlaNobleUserListResponseMessage) && (QN = ((AlaNobleUserListResponseMessage) httpResponsedMessage).QN()) != null) {
                c.this.ojN.setRightIconClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.yuyinala.charm.audiencelist.c.2.1
                    /* JADX DEBUG: Multi-variable search result rejected for r1v2, resolved type: com.baidu.tieba.yuyinala.charm.audiencelist.YuyinALaAudiencesActivity */
                    /* JADX WARN: Multi-variable type inference failed */
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (!UtilHelper.isFastDoubleClick() && !StringUtils.isNull(QN.bxr)) {
                            UrlManager.getInstance().dealOneLink(c.this.ojM.getPageContext(), new String[]{QN.bxr});
                        }
                    }
                });
                c.this.ojN.C(String.format(c.this.ojM.getPageContext().getString(a.h.sdk_yuyin_onlinenoble_tab_title), String.valueOf(QN.bxq)), c.this.aHo.indexOf(c.this.ojP));
            }
        }
    };

    public c(YuyinALaAudiencesActivity yuyinALaAudiencesActivity) {
        this.ojM = yuyinALaAudiencesActivity;
        MessageManager.getInstance().registerListener(this.bxJ);
        MessageManager.getInstance().registerListener(this.ojQ);
        initView();
        bXd();
    }

    private void initView() {
        this.mRootView = LayoutInflater.from(this.ojM).inflate(a.g.yuyin_ala_charm_activity_layout, (ViewGroup) null);
        this.contentView = this.mRootView.findViewById(a.f.ala_charm_root_view);
        this.contentView.setBackgroundResource(a.e.yuyin_ala_audiencelist_white_corner);
        this.ojN = (NobilityAlaLiveRoomPanelTabHost) this.mRootView.findViewById(a.f.ala_charm_tab_host);
        this.ojN.setIndicatorWidthAuto(false);
        this.ojN.setmIndicatorHeight(BdUtilHelper.getDimens(TbadkCoreApplication.getInst(), a.d.sdk_ds8));
        this.ojN.setmIndicatorWidth(BdUtilHelper.getDimens(TbadkCoreApplication.getInst(), a.d.sdk_ds40));
        this.ojN.setRightIconVisible(false);
    }

    public View getView() {
        return this.mRootView;
    }

    private void bXd() {
        Intent intent = this.ojM.getIntent();
        intent.getStringExtra("user_name");
        intent.getStringExtra("group_id");
        String stringExtra = intent.getStringExtra("live_id");
        this.aLL = intent.getBooleanExtra("live_owner_flag", false);
        String stringExtra2 = intent.getStringExtra("live_owner_uid");
        String stringExtra3 = intent.getStringExtra("login_user_id");
        boolean booleanExtra = intent.getBooleanExtra(YuyinAlaCharmCardActivityConfig.IS_SHOW_BUY_ENTRY, false);
        this.ojO = new f(this.ojM);
        this.ojO.VH(stringExtra).createView();
        this.aHo.add(this.ojO);
        this.ojP = new g(this.ojM);
        this.ojP.zz(this.aLL).VI(stringExtra).VJ(stringExtra2).VK(stringExtra3).zy(booleanExtra).createView();
        this.aHo.add(this.ojP);
        this.ojN.setData(this.aHo);
        this.ojN.setPageSelectedListener(new NobilityAlaLiveRoomPanelTabHost.b() { // from class: com.baidu.tieba.yuyinala.charm.audiencelist.c.3
            @Override // com.baidu.live.bottompanel.NobilityAlaLiveRoomPanelTabHost.b
            public void onPageSelected(int i) {
                if (i == 0) {
                    c.this.ojO.mH(false);
                    c.this.ojN.setRightIconVisible(false);
                } else if (i == 1) {
                    c.this.ojP.mH(false);
                    c.this.ojN.setRightIconVisible(true);
                }
            }
        });
    }

    public void onDestory() {
        for (com.baidu.live.liveroom.d.d dVar : this.aHo) {
            dVar.onDestroy();
        }
        MessageManager.getInstance().unRegisterListener(this.bxJ);
        MessageManager.getInstance().unRegisterListener(this.ojQ);
    }
}
