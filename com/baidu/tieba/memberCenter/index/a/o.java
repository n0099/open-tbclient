package com.baidu.tieba.memberCenter.index.a;

import tbclient.GetVipInfo.VipSpecialItem;
/* loaded from: classes9.dex */
public class o {
    private String desc;
    private String imgUrl;
    private String linkUrl;
    private int ljS;
    private String ljf;
    private int ljg;
    private int taskId;
    private String title;
    private int updateType;

    public o(VipSpecialItem vipSpecialItem) {
        this.title = vipSpecialItem.title;
        this.desc = vipSpecialItem.desc;
        this.imgUrl = vipSpecialItem.img_url;
        this.linkUrl = vipSpecialItem.link;
        this.ljf = vipSpecialItem.update_time;
        this.ljg = vipSpecialItem.id.intValue();
        this.updateType = vipSpecialItem.type.intValue();
        this.taskId = vipSpecialItem.task_id.intValue();
        this.ljS = vipSpecialItem.is_finish.intValue();
    }
}
