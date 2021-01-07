package com.baidu.tieba.memberCenter.index.a;

import tbclient.GetVipInfo.VipSpecialItem;
/* loaded from: classes9.dex */
public class f {
    private String desc;
    private String imgUrl;
    private String linkUrl;
    private boolean ljd;
    private boolean lje;
    private String ljf;
    private int ljg;
    private String title;
    private int updateType;

    public f(VipSpecialItem vipSpecialItem) {
        this.ljd = false;
        this.lje = false;
        this.title = vipSpecialItem.title;
        this.desc = vipSpecialItem.desc;
        this.imgUrl = vipSpecialItem.img_url;
        this.linkUrl = vipSpecialItem.link;
        this.ljf = vipSpecialItem.update_time;
        this.ljg = vipSpecialItem.id.intValue();
        this.updateType = vipSpecialItem.type.intValue();
        this.ljd = false;
    }

    public f(boolean z, boolean z2) {
        this.ljd = false;
        this.lje = false;
        this.ljd = z;
        this.lje = z2;
    }
}
