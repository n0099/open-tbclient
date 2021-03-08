package com.baidu.tieba.memberCenter.index.a;

import tbclient.GetVipInfo.VipSpecialItem;
/* loaded from: classes8.dex */
public class f {
    private String desc;
    private String imgUrl;
    private String linkUrl;
    private boolean loV;
    private boolean loW;
    private String loX;
    private int loY;
    private String title;
    private int updateType;

    public f(VipSpecialItem vipSpecialItem) {
        this.loV = false;
        this.loW = false;
        this.title = vipSpecialItem.title;
        this.desc = vipSpecialItem.desc;
        this.imgUrl = vipSpecialItem.img_url;
        this.linkUrl = vipSpecialItem.link;
        this.loX = vipSpecialItem.update_time;
        this.loY = vipSpecialItem.id.intValue();
        this.updateType = vipSpecialItem.type.intValue();
        this.loV = false;
    }

    public f(boolean z, boolean z2) {
        this.loV = false;
        this.loW = false;
        this.loV = z;
        this.loW = z2;
    }
}
