package com.baidu.yuyinala.privatemessage.model.group;

import java.io.Serializable;
/* loaded from: classes11.dex */
public class FansFriends implements Serializable {
    public String cmd;
    public String descirbe;
    public String ext;
    public boolean hasMore;
    public String icon;
    public int isInGroup;
    public String name;
    public String uk;
    public int type = 0;
    public int groupType = 0;

    public boolean isHasMore() {
        return this.hasMore;
    }

    public boolean isInsideGroup() {
        return this.isInGroup == 1;
    }
}
