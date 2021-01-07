package com.baidu.tieba.memberCenter.index.a;

import tbclient.GetMemberTaskList.PointTaskInfo;
import tbclient.GetVipInfo.VipTaskItem;
/* loaded from: classes9.dex */
public class r {
    private String desc;
    private long id;
    private String imgUrl;
    private String linkUrl;
    private int ljW;
    private int status;
    private String title;
    private int type;

    public r() {
    }

    public r(VipTaskItem vipTaskItem) {
        this.id = vipTaskItem.task_id.intValue();
        this.title = vipTaskItem.title;
        this.desc = vipTaskItem.desc;
        this.imgUrl = vipTaskItem.img_url;
        this.linkUrl = vipTaskItem.link;
        this.status = vipTaskItem.is_finish.intValue();
    }

    public r(PointTaskInfo pointTaskInfo) {
        if (pointTaskInfo != null) {
            this.id = pointTaskInfo.task_id.longValue();
            this.title = pointTaskInfo.task_name;
            this.desc = pointTaskInfo.task_intro;
            this.status = pointTaskInfo.is_finish.intValue();
            this.ljW = pointTaskInfo.points_add.intValue();
            this.type = pointTaskInfo.type.intValue();
        }
    }

    public void FH(int i) {
        this.status = i;
    }

    public void setTaskId(long j) {
        this.id = j;
    }

    public int getStatus() {
        return this.status;
    }

    public long getId() {
        return this.id;
    }

    public String getTitle() {
        return this.title;
    }

    public String getDesc() {
        return this.desc;
    }

    public boolean getIsFinish() {
        return this.status == 1;
    }

    public int dgY() {
        return this.ljW;
    }

    public int getType() {
        return this.type;
    }
}
