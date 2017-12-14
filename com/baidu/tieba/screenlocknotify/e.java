package com.baidu.tieba.screenlocknotify;

import tbclient.GetMoreMsg.MsgContent;
/* loaded from: classes2.dex */
public class e {
    public String content;
    public int customGroupType;
    public int followStatus;
    public boolean fyy;
    public int gep;
    public String geq = "";
    public long ger;
    public String groupId;
    public String groupName;
    public boolean isAcceptNotify;
    public long lastTime;
    public long msgId;
    public int msgType;
    public String pic;
    public String stat;
    public long taskId;
    public String title;
    public String url;
    public String userName;

    public e() {
    }

    public e(MsgContent msgContent) {
        this.title = msgContent.title;
        this.url = msgContent.url;
        this.pic = msgContent.src;
        this.content = msgContent.text;
        e(this);
    }

    private static void e(e eVar) {
        eVar.gep = 0;
        eVar.msgType = 4;
        eVar.customGroupType = 4;
        eVar.lastTime = System.currentTimeMillis();
        eVar.isAcceptNotify = true;
    }
}
