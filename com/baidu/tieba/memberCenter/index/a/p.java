package com.baidu.tieba.memberCenter.index.a;

import com.baidu.adp.BdUniqueId;
import tbclient.GetVipInfo.VipRank;
import tbclient.GetVipInfo.VipUser;
/* loaded from: classes8.dex */
public class p implements com.baidu.adp.widget.ListView.n {
    public static final BdUniqueId lfo = BdUniqueId.gen();
    public String cardId;
    public boolean leh = false;
    public boolean lei = true;
    private d leo;
    private VipUser lfp;
    private String portrait;
    private int rankScore;

    public p(VipRank vipRank, VipUser vipUser) {
        this.cardId = "";
        if (vipRank != null) {
            this.cardId = vipRank.card_id;
            this.leo = new d();
            this.leo.setCategoryName(vipRank.class_name);
            this.leo.Nl(vipRank.class_url_name);
            this.leo.Nm(vipRank.class_url);
            this.rankScore = vipRank.my_score_rank.intValue();
            this.portrait = vipUser.portrait;
            this.lfp = vipUser;
        }
    }

    @Override // com.baidu.adp.widget.ListView.n
    public BdUniqueId getType() {
        return lfo;
    }
}
