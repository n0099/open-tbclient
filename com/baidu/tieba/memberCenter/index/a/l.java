package com.baidu.tieba.memberCenter.index.a;

import com.baidu.adp.BdUniqueId;
import tbclient.AutoPayInfo;
import tbclient.GetVipInfo.DataRes;
import tbclient.GetVipInfo.VipUpgrade;
import tbclient.GetVipInfo.VipUser;
/* loaded from: classes9.dex */
public class l implements com.baidu.adp.widget.ListView.n {
    public static final BdUniqueId lmN = BdUniqueId.gen();
    public String cardId;
    private int dayAddScore;
    private int getScore;
    private long id;
    private String lmO;
    private long lmP;
    private long lmQ;
    private int lmR;
    private int lmS;
    private int lmT;
    private int lmU;
    private int lmV;
    private String lmW;
    private String lmX;
    private String lmY;
    private AutoPayInfo lmZ;
    public boolean lmk = false;
    private String name;
    private int nextLevelScore;
    private long nowTime;
    private String portrait;
    private String showName;
    private String vipIconUrl;
    private int vipLevel;
    private int vipStatus;

    public l(DataRes dataRes) {
        this.cardId = "";
        if (dataRes != null && dataRes.user != null && dataRes.upgrade != null) {
            VipUser vipUser = dataRes.user;
            VipUpgrade vipUpgrade = dataRes.upgrade;
            this.cardId = vipUser.card_id;
            this.lmW = vipUser.total_scores_link;
            this.lmX = vipUser.speed_link;
            this.lmY = vipUser.task_scores_link;
            this.lmV = vipUser.task_scores.intValue();
            this.name = vipUser.name;
            this.id = vipUser.id.longValue();
            this.portrait = vipUser.portrait;
            this.showName = vipUser.name_show;
            this.vipIconUrl = vipUser.vip_link;
            if (vipUser.vipInfo != null) {
                this.lmO = vipUser.vipInfo.icon_url;
                this.lmP = vipUser.vipInfo.s_time.intValue();
                this.lmQ = vipUser.vipInfo.e_time.intValue();
                this.nowTime = vipUser.now_time.intValue();
                this.vipStatus = vipUser.vipInfo.v_status.intValue();
                this.vipLevel = vipUser.vipInfo.v_level.intValue();
                this.getScore = vipUser.vipInfo.ext_score.intValue();
                this.dayAddScore = vipUser.vipInfo.a_score.intValue();
                this.nextLevelScore = vipUser.vipInfo.n_score.intValue();
            } else {
                this.vipStatus = 0;
            }
            this.lmR = dataRes.today_get_score.intValue();
            this.lmS = dataRes.today_unget_score.intValue();
            this.lmT = vipUpgrade.normal.intValue();
            this.lmU = vipUpgrade.pay.intValue();
            this.lmZ = dataRes.autopay_info;
        }
    }

    @Override // com.baidu.adp.widget.ListView.n
    public BdUniqueId getType() {
        return lmN;
    }
}
