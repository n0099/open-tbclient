package com.baidu.tieba.memberCenter.index.a;

import tbclient.GetVipInfo.VipSpecialItem;
/* loaded from: classes8.dex */
public class f {
    private String desc;
    private String imgUrl;
    private String leA;
    private int leB;
    private boolean ley;
    private boolean lez;
    private String linkUrl;
    private String title;
    private int updateType;

    public f(VipSpecialItem vipSpecialItem) {
        this.ley = false;
        this.lez = false;
        this.title = vipSpecialItem.title;
        this.desc = vipSpecialItem.desc;
        this.imgUrl = vipSpecialItem.img_url;
        this.linkUrl = vipSpecialItem.link;
        this.leA = vipSpecialItem.update_time;
        this.leB = vipSpecialItem.id.intValue();
        this.updateType = vipSpecialItem.type.intValue();
        this.ley = false;
    }

    public f(boolean z, boolean z2) {
        this.ley = false;
        this.lez = false;
        this.ley = z;
        this.lez = z2;
    }
}
