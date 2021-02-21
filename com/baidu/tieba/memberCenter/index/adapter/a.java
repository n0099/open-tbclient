package com.baidu.tieba.memberCenter.index.adapter;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.n;
import tbclient.GetVipInfo.DataRes;
/* loaded from: classes9.dex */
public class a implements n {
    public static final BdUniqueId lmx = BdUniqueId.gen();
    private int dayCounts;
    private String descStr;
    private String expire;
    private String linkUrl;
    private String lmA;
    private String nextLevelStr;
    private int vipDays;
    public boolean lmy = false;
    public boolean lmz = true;
    public String cardId = "";

    public void a(DataRes dataRes) {
        if (dataRes != null && dataRes.upgrade != null) {
            this.nextLevelStr = dataRes.upgrade.svip;
            this.linkUrl = dataRes.upgrade.link;
            this.lmA = dataRes.upgrade.button;
            this.descStr = dataRes.upgrade.text;
            this.vipDays = dataRes.upgrade.pay.intValue();
            this.dayCounts = dataRes.upgrade.normal.intValue();
            this.cardId = dataRes.upgrade.card_id;
            this.expire = dataRes.upgrade.expire;
        }
    }

    @Override // com.baidu.adp.widget.ListView.n
    public BdUniqueId getType() {
        return lmx;
    }
}
