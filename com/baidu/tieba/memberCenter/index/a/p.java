package com.baidu.tieba.memberCenter.index.a;

import com.baidu.adp.BdUniqueId;
import tbclient.GetVipInfo.VipRank;
import tbclient.GetVipInfo.VipUser;
/* loaded from: classes9.dex */
public class p implements com.baidu.adp.widget.ListView.n {
    public static final BdUniqueId lnr = BdUniqueId.gen();
    public String cardId;
    public boolean lmk = false;
    public boolean lml = true;
    private d lmq;
    private VipUser lns;
    private String portrait;
    private int rankScore;

    public p(VipRank vipRank, VipUser vipUser) {
        this.cardId = "";
        if (vipRank != null) {
            this.cardId = vipRank.card_id;
            this.lmq = new d();
            this.lmq.setCategoryName(vipRank.class_name);
            this.lmq.NZ(vipRank.class_url_name);
            this.lmq.Oa(vipRank.class_url);
            this.rankScore = vipRank.my_score_rank.intValue();
            this.portrait = vipUser.portrait;
            this.lns = vipUser;
        }
    }

    @Override // com.baidu.adp.widget.ListView.n
    public BdUniqueId getType() {
        return lnr;
    }
}
