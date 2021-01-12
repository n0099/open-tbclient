package com.baidu.tieba.memberCenter.index.adapter;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.n;
import tbclient.GetVipInfo.DataRes;
/* loaded from: classes8.dex */
public class a implements n {
    public static final BdUniqueId leg = BdUniqueId.gen();
    private int dayCounts;
    private String descStr;
    private String expire;
    private String lej;
    private String linkUrl;
    private String nextLevelStr;
    private int vipDays;
    public boolean leh = false;
    public boolean lei = true;
    public String cardId = "";

    public void a(DataRes dataRes) {
        if (dataRes != null && dataRes.upgrade != null) {
            this.nextLevelStr = dataRes.upgrade.svip;
            this.linkUrl = dataRes.upgrade.link;
            this.lej = dataRes.upgrade.button;
            this.descStr = dataRes.upgrade.text;
            this.vipDays = dataRes.upgrade.pay.intValue();
            this.dayCounts = dataRes.upgrade.normal.intValue();
            this.cardId = dataRes.upgrade.card_id;
            this.expire = dataRes.upgrade.expire;
        }
    }

    @Override // com.baidu.adp.widget.ListView.n
    public BdUniqueId getType() {
        return leg;
    }
}
