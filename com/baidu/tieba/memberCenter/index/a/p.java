package com.baidu.tieba.memberCenter.index.a;

import com.baidu.adp.BdUniqueId;
import tbclient.GetVipInfo.VipRank;
import tbclient.GetVipInfo.VipUser;
/* loaded from: classes9.dex */
public class p implements com.baidu.adp.widget.ListView.n {
    public static final BdUniqueId lnF = BdUniqueId.gen();
    public String cardId;
    private d lmE;
    public boolean lmy = false;
    public boolean lmz = true;
    private VipUser lnG;
    private String portrait;
    private int rankScore;

    public p(VipRank vipRank, VipUser vipUser) {
        this.cardId = "";
        if (vipRank != null) {
            this.cardId = vipRank.card_id;
            this.lmE = new d();
            this.lmE.setCategoryName(vipRank.class_name);
            this.lmE.Oa(vipRank.class_url_name);
            this.lmE.Ob(vipRank.class_url);
            this.rankScore = vipRank.my_score_rank.intValue();
            this.portrait = vipUser.portrait;
            this.lnG = vipUser;
        }
    }

    @Override // com.baidu.adp.widget.ListView.n
    public BdUniqueId getType() {
        return lnF;
    }
}
