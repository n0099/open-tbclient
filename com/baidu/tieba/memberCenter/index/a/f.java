package com.baidu.tieba.memberCenter.index.a;

import tbclient.GetVipInfo.VipSpecialItem;
/* loaded from: classes9.dex */
public class f {
    private String desc;
    private String imgUrl;
    private String linkUrl;
    private boolean lmA;
    private boolean lmB;
    private String lmC;
    private int lmD;
    private String title;
    private int updateType;

    public f(VipSpecialItem vipSpecialItem) {
        this.lmA = false;
        this.lmB = false;
        this.title = vipSpecialItem.title;
        this.desc = vipSpecialItem.desc;
        this.imgUrl = vipSpecialItem.img_url;
        this.linkUrl = vipSpecialItem.link;
        this.lmC = vipSpecialItem.update_time;
        this.lmD = vipSpecialItem.id.intValue();
        this.updateType = vipSpecialItem.type.intValue();
        this.lmA = false;
    }

    public f(boolean z, boolean z2) {
        this.lmA = false;
        this.lmB = false;
        this.lmA = z;
        this.lmB = z2;
    }
}
