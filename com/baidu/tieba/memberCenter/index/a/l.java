package com.baidu.tieba.memberCenter.index.a;

import com.baidu.adp.BdUniqueId;
import tbclient.AutoPayInfo;
import tbclient.GetVipInfo.DataRes;
import tbclient.GetVipInfo.VipUpgrade;
import tbclient.GetVipInfo.VipUser;
/* loaded from: classes8.dex */
public class l implements com.baidu.adp.widget.ListView.n {
    public static final BdUniqueId leL = BdUniqueId.gen();
    public String cardId;
    private int dayAddScore;
    private int getScore;
    private long id;
    private String leM;
    private long leN;
    private long leO;
    private int leP;
    private int leQ;
    private int leR;
    private int leS;
    private int leT;
    private String leU;
    private String leV;
    private String leW;
    private AutoPayInfo leX;
    public boolean leh = false;
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
            this.leU = vipUser.total_scores_link;
            this.leV = vipUser.speed_link;
            this.leW = vipUser.task_scores_link;
            this.leT = vipUser.task_scores.intValue();
            this.name = vipUser.name;
            this.id = vipUser.id.longValue();
            this.portrait = vipUser.portrait;
            this.showName = vipUser.name_show;
            this.vipIconUrl = vipUser.vip_link;
            if (vipUser.vipInfo != null) {
                this.leM = vipUser.vipInfo.icon_url;
                this.leN = vipUser.vipInfo.s_time.intValue();
                this.leO = vipUser.vipInfo.e_time.intValue();
                this.nowTime = vipUser.now_time.intValue();
                this.vipStatus = vipUser.vipInfo.v_status.intValue();
                this.vipLevel = vipUser.vipInfo.v_level.intValue();
                this.getScore = vipUser.vipInfo.ext_score.intValue();
                this.dayAddScore = vipUser.vipInfo.a_score.intValue();
                this.nextLevelScore = vipUser.vipInfo.n_score.intValue();
            } else {
                this.vipStatus = 0;
            }
            this.leP = dataRes.today_get_score.intValue();
            this.leQ = dataRes.today_unget_score.intValue();
            this.leR = vipUpgrade.normal.intValue();
            this.leS = vipUpgrade.pay.intValue();
            this.leX = dataRes.autopay_info;
        }
    }

    @Override // com.baidu.adp.widget.ListView.n
    public BdUniqueId getType() {
        return leL;
    }
}
