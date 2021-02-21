package com.baidu.tieba.memberCenter.index.a;

import com.baidu.adp.BdUniqueId;
import tbclient.AutoPayInfo;
import tbclient.GetVipInfo.DataRes;
import tbclient.GetVipInfo.VipUpgrade;
import tbclient.GetVipInfo.VipUser;
/* loaded from: classes9.dex */
public class l implements com.baidu.adp.widget.ListView.n {
    public static final BdUniqueId lnb = BdUniqueId.gen();
    public String cardId;
    private int dayAddScore;
    private int getScore;
    private long id;
    public boolean lmy = false;
    private String lnc;
    private long lnd;
    private long lne;
    private int lnf;
    private int lnh;
    private int lni;
    private int lnj;
    private int lnk;
    private String lnl;
    private String lnm;
    private String lnn;
    private AutoPayInfo lno;
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
            this.lnl = vipUser.total_scores_link;
            this.lnm = vipUser.speed_link;
            this.lnn = vipUser.task_scores_link;
            this.lnk = vipUser.task_scores.intValue();
            this.name = vipUser.name;
            this.id = vipUser.id.longValue();
            this.portrait = vipUser.portrait;
            this.showName = vipUser.name_show;
            this.vipIconUrl = vipUser.vip_link;
            if (vipUser.vipInfo != null) {
                this.lnc = vipUser.vipInfo.icon_url;
                this.lnd = vipUser.vipInfo.s_time.intValue();
                this.lne = vipUser.vipInfo.e_time.intValue();
                this.nowTime = vipUser.now_time.intValue();
                this.vipStatus = vipUser.vipInfo.v_status.intValue();
                this.vipLevel = vipUser.vipInfo.v_level.intValue();
                this.getScore = vipUser.vipInfo.ext_score.intValue();
                this.dayAddScore = vipUser.vipInfo.a_score.intValue();
                this.nextLevelScore = vipUser.vipInfo.n_score.intValue();
            } else {
                this.vipStatus = 0;
            }
            this.lnf = dataRes.today_get_score.intValue();
            this.lnh = dataRes.today_unget_score.intValue();
            this.lni = vipUpgrade.normal.intValue();
            this.lnj = vipUpgrade.pay.intValue();
            this.lno = dataRes.autopay_info;
        }
    }

    @Override // com.baidu.adp.widget.ListView.n
    public BdUniqueId getType() {
        return lnb;
    }
}
