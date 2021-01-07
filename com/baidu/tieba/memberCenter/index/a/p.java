package com.baidu.tieba.memberCenter.index.a;

import com.baidu.adp.BdUniqueId;
import tbclient.GetVipInfo.VipRank;
import tbclient.GetVipInfo.VipUser;
/* loaded from: classes9.dex */
public class p implements com.baidu.adp.widget.ListView.n {
    public static final BdUniqueId ljT = BdUniqueId.gen();
    public String cardId;
    public boolean liN = false;
    public boolean liO = true;
    private d liT;
    private VipUser ljU;
    private String portrait;
    private int rankScore;

    public p(VipRank vipRank, VipUser vipUser) {
        this.cardId = "";
        if (vipRank != null) {
            this.cardId = vipRank.card_id;
            this.liT = new d();
            this.liT.setCategoryName(vipRank.class_name);
            this.liT.Os(vipRank.class_url_name);
            this.liT.Ot(vipRank.class_url);
            this.rankScore = vipRank.my_score_rank.intValue();
            this.portrait = vipUser.portrait;
            this.ljU = vipUser;
        }
    }

    @Override // com.baidu.adp.widget.ListView.n
    public BdUniqueId getType() {
        return ljT;
    }
}
