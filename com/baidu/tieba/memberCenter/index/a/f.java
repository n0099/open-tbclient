package com.baidu.tieba.memberCenter.index.a;

import tbclient.GetVipInfo.VipSpecialItem;
/* loaded from: classes9.dex */
public class f {
    private String desc;
    private String imgUrl;
    private String linkUrl;
    private boolean lmO;
    private boolean lmP;
    private String lmQ;
    private int lmR;
    private String title;
    private int updateType;

    public f(VipSpecialItem vipSpecialItem) {
        this.lmO = false;
        this.lmP = false;
        this.title = vipSpecialItem.title;
        this.desc = vipSpecialItem.desc;
        this.imgUrl = vipSpecialItem.img_url;
        this.linkUrl = vipSpecialItem.link;
        this.lmQ = vipSpecialItem.update_time;
        this.lmR = vipSpecialItem.id.intValue();
        this.updateType = vipSpecialItem.type.intValue();
        this.lmO = false;
    }

    public f(boolean z, boolean z2) {
        this.lmO = false;
        this.lmP = false;
        this.lmO = z;
        this.lmP = z2;
    }
}
