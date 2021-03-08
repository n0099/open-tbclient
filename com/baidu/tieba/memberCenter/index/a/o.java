package com.baidu.tieba.memberCenter.index.a;

import tbclient.GetVipInfo.VipSpecialItem;
/* loaded from: classes8.dex */
public class o {
    private String desc;
    private String imgUrl;
    private String linkUrl;
    private String loX;
    private int loY;
    private int lpK;
    private int taskId;
    private String title;
    private int updateType;

    public o(VipSpecialItem vipSpecialItem) {
        this.title = vipSpecialItem.title;
        this.desc = vipSpecialItem.desc;
        this.imgUrl = vipSpecialItem.img_url;
        this.linkUrl = vipSpecialItem.link;
        this.loX = vipSpecialItem.update_time;
        this.loY = vipSpecialItem.id.intValue();
        this.updateType = vipSpecialItem.type.intValue();
        this.taskId = vipSpecialItem.task_id.intValue();
        this.lpK = vipSpecialItem.is_finish.intValue();
    }
}
