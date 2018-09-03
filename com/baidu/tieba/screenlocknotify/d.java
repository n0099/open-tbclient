package com.baidu.tieba.screenlocknotify;

import tbclient.GetMoreMsg.MsgContent;
/* loaded from: classes3.dex */
public class d {
    public String content;
    public int customGroupType;
    public int followStatus;
    public boolean gat;
    public String groupId;
    public String groupName;
    public int gxc;
    public String gxd = "";
    public long gxe;
    public boolean isAcceptNotify;
    public long lastTime;
    public long msgId;
    public int msgType;
    public String nameShow;
    public String pic;
    public String stat;
    public long taskId;
    public String title;
    public String url;
    public String userName;

    public d() {
    }

    public d(MsgContent msgContent) {
        this.title = msgContent.title;
        this.url = msgContent.url;
        this.pic = msgContent.src;
        this.content = msgContent.text;
        e(this);
    }

    private static void e(d dVar) {
        dVar.gxc = 0;
        dVar.msgType = 4;
        dVar.customGroupType = 4;
        dVar.lastTime = System.currentTimeMillis();
        dVar.isAcceptNotify = true;
    }
}
