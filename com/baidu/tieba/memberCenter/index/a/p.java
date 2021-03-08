package com.baidu.tieba.memberCenter.index.a;

import com.baidu.adp.BdUniqueId;
import tbclient.GetVipInfo.VipRank;
import tbclient.GetVipInfo.VipUser;
/* loaded from: classes8.dex */
public class p implements com.baidu.adp.widget.ListView.n {
    public static final BdUniqueId lpL = BdUniqueId.gen();
    public String cardId;
    public boolean loF = false;
    public boolean loG = true;
    private d loL;
    private VipUser lpM;
    private String portrait;
    private int rankScore;

    public p(VipRank vipRank, VipUser vipUser) {
        this.cardId = "";
        if (vipRank != null) {
            this.cardId = vipRank.card_id;
            this.loL = new d();
            this.loL.setCategoryName(vipRank.class_name);
            this.loL.Og(vipRank.class_url_name);
            this.loL.Oh(vipRank.class_url);
            this.rankScore = vipRank.my_score_rank.intValue();
            this.portrait = vipUser.portrait;
            this.lpM = vipUser;
        }
    }

    @Override // com.baidu.adp.widget.ListView.n
    public BdUniqueId getType() {
        return lpL;
    }
}
