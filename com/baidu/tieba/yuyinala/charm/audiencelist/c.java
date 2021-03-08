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
    private boolean aLc;
    private View contentView;
    private View mRootView;
    private YuyinALaAudiencesActivity orH;
    private NobilityAlaLiveRoomPanelTabHost orI;
    private f orJ;
    private g orK;
    private List<com.baidu.live.liveroom.d.d> aFO = new LinkedList();
    private HttpMessageListener orL = new HttpMessageListener(1031031) { // from class: com.baidu.tieba.yuyinala.charm.audiencelist.c.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage != null && (httpResponsedMessage instanceof OnlineListHttpResponseMessage)) {
                long j = 0;
                if (httpResponsedMessage instanceof OnlineListHttpResponseMessage) {
                    j = ((OnlineListHttpResponseMessage) httpResponsedMessage).bTW();
                }
                c.this.orI.C(String.format(c.this.orH.getPageContext().getString(a.h.sdk_yuyin_onlineuser_tab_title), String.valueOf(j)), c.this.aFO.indexOf(c.this.orJ));
            }
        }
    };
    private HttpMessageListener bxZ = new HttpMessageListener(1031032) { // from class: com.baidu.tieba.yuyinala.charm.audiencelist.c.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            final com.baidu.live.noble.data.d Ot;
            if (httpResponsedMessage != null && (httpResponsedMessage instanceof AlaNobleUserListResponseMessage) && (Ot = ((AlaNobleUserListResponseMessage) httpResponsedMessage).Ot()) != null) {
                c.this.orI.setRightIconClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.yuyinala.charm.audiencelist.c.2.1
                    /* JADX DEBUG: Multi-variable search result rejected for r1v2, resolved type: com.baidu.tieba.yuyinala.charm.audiencelist.YuyinALaAudiencesActivity */
                    /* JADX WARN: Multi-variable type inference failed */
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (!UtilHelper.isFastDoubleClick() && !StringUtils.isNull(Ot.bxH)) {
                            UrlManager.getInstance().dealOneLink(c.this.orH.getPageContext(), new String[]{Ot.bxH});
                        }
                    }
                });
                c.this.orI.C(String.format(c.this.orH.getPageContext().getString(a.h.sdk_yuyin_onlinenoble_tab_title), String.valueOf(Ot.bxG)), c.this.aFO.indexOf(c.this.orK));
            }
        }
    };

    public c(YuyinALaAudiencesActivity yuyinALaAudiencesActivity) {
        this.orH = yuyinALaAudiencesActivity;
        MessageManager.getInstance().registerListener(this.bxZ);
        MessageManager.getInstance().registerListener(this.orL);
        initView();
        bUb();
    }

    private void initView() {
        this.mRootView = LayoutInflater.from(this.orH).inflate(a.g.yuyin_ala_charm_activity_layout, (ViewGroup) null);
        this.contentView = this.mRootView.findViewById(a.f.ala_charm_root_view);
        this.contentView.setBackgroundResource(a.e.yuyin_ala_audiencelist_white_corner);
        this.orI = (NobilityAlaLiveRoomPanelTabHost) this.mRootView.findViewById(a.f.ala_charm_tab_host);
        this.orI.setIndicatorWidthAuto(false);
        this.orI.setmIndicatorHeight(BdUtilHelper.getDimens(TbadkCoreApplication.getInst(), a.d.sdk_ds8));
        this.orI.setmIndicatorWidth(BdUtilHelper.getDimens(TbadkCoreApplication.getInst(), a.d.sdk_ds40));
        this.orI.setRightIconVisible(false);
    }

    public View getView() {
        return this.mRootView;
    }

    private void bUb() {
        Intent intent = this.orH.getIntent();
        intent.getStringExtra("user_name");
        intent.getStringExtra("group_id");
        String stringExtra = intent.getStringExtra("live_id");
        this.aLc = intent.getBooleanExtra("live_owner_flag", false);
        String stringExtra2 = intent.getStringExtra("live_owner_uid");
        String stringExtra3 = intent.getStringExtra("login_user_id");
        boolean booleanExtra = intent.getBooleanExtra(YuyinAlaCharmCardActivityConfig.IS_SHOW_BUY_ENTRY, false);
        this.orJ = new f(this.orH);
        this.orJ.VR(stringExtra).createView();
        this.aFO.add(this.orJ);
        this.orK = new g(this.orH);
        this.orK.zP(this.aLc).VS(stringExtra).VT(stringExtra2).VU(stringExtra3).zO(booleanExtra).createView();
        this.aFO.add(this.orK);
        this.orI.setData(this.aFO);
        this.orI.setPageSelectedListener(new NobilityAlaLiveRoomPanelTabHost.b() { // from class: com.baidu.tieba.yuyinala.charm.audiencelist.c.3
            @Override // com.baidu.live.bottompanel.NobilityAlaLiveRoomPanelTabHost.b
            public void onPageSelected(int i) {
                if (i == 0) {
                    c.this.orJ.mH(false);
                    c.this.orI.setRightIconVisible(false);
                } else if (i == 1) {
                    c.this.orK.mH(false);
                    c.this.orI.setRightIconVisible(true);
                }
            }
        });
    }

    public void onDestory() {
        for (com.baidu.live.liveroom.d.d dVar : this.aFO) {
            dVar.onDestroy();
        }
        MessageManager.getInstance().unRegisterListener(this.bxZ);
        MessageManager.getInstance().unRegisterListener(this.orL);
    }
}
