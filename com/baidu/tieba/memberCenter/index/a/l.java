package com.baidu.tieba.memberCenter.index.a;

import com.baidu.adp.BdUniqueId;
import tbclient.AutoPayInfo;
import tbclient.GetVipInfo.DataRes;
import tbclient.GetVipInfo.VipUpgrade;
import tbclient.GetVipInfo.VipUser;
/* loaded from: classes9.dex */
public class l implements com.baidu.adp.widget.ListView.n {
    public static final BdUniqueId ljq = BdUniqueId.gen();
    public String cardId;
    private int dayAddScore;
    private int getScore;
    private String hUI;
    private long id;
    public boolean liN = false;
    private String ljA;
    private String ljB;
    private AutoPayInfo ljC;
    private String ljr;
    private long ljs;
    private long ljt;
    private int lju;
    private int ljv;
    private int ljw;
    private int ljx;
    private int ljy;
    private String ljz;
    private String name;
    private int nextLevelScore;
    private long nowTime;
    private String portrait;
    private String vipIconUrl;
    private int vipLevel;
    private int vipStatus;

    public l(DataRes dataRes) {
        this.cardId = "";
        if (dataRes != null && dataRes.user != null && dataRes.upgrade != null) {
            VipUser vipUser = dataRes.user;
            VipUpgrade vipUpgrade = dataRes.upgrade;
            this.cardId = vipUser.card_id;
            this.ljz = vipUser.total_scores_link;
            this.ljA = vipUser.speed_link;
            this.ljB = vipUser.task_scores_link;
            this.ljy = vipUser.task_scores.intValue();
            this.name = vipUser.name;
            this.id = vipUser.id.longValue();
            this.portrait = vipUser.portrait;
            this.hUI = vipUser.name_show;
            this.vipIconUrl = vipUser.vip_link;
            if (vipUser.vipInfo != null) {
                this.ljr = vipUser.vipInfo.icon_url;
                this.ljs = vipUser.vipInfo.s_time.intValue();
                this.ljt = vipUser.vipInfo.e_time.intValue();
                this.nowTime = vipUser.now_time.intValue();
                this.vipStatus = vipUser.vipInfo.v_status.intValue();
                this.vipLevel = vipUser.vipInfo.v_level.intValue();
                this.getScore = vipUser.vipInfo.ext_score.intValue();
                this.dayAddScore = vipUser.vipInfo.a_score.intValue();
                this.nextLevelScore = vipUser.vipInfo.n_score.intValue();
            } else {
                this.vipStatus = 0;
            }
            this.lju = dataRes.today_get_score.intValue();
            this.ljv = dataRes.today_unget_score.intValue();
            this.ljw = vipUpgrade.normal.intValue();
            this.ljx = vipUpgrade.pay.intValue();
            this.ljC = dataRes.autopay_info;
        }
    }

    @Override // com.baidu.adp.widget.ListView.n
    public BdUniqueId getType() {
        return ljq;
    }
}
