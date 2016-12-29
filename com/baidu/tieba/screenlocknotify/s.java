package com.baidu.tieba.screenlocknotify;

import tbclient.GetMoreMsg.MsgContent;
/* loaded from: classes.dex */
public class s {
    public String content;
    public int customGroupType;
    public int eQV;
    public String eQW = "";
    public long eQX;
    public boolean euu;
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

    public s() {
    }

    public s(MsgContent msgContent) {
        this.title = msgContent.title;
        this.url = msgContent.url;
        this.pic = msgContent.src;
        this.content = msgContent.text;
        e(this);
    }

    private static void e(s sVar) {
        sVar.eQV = 0;
        sVar.msgType = 4;
        sVar.customGroupType = 4;
        sVar.lastTime = System.currentTimeMillis();
        sVar.isAcceptNotify = true;
    }
}
