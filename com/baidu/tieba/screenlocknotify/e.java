package com.baidu.tieba.screenlocknotify;

import tbclient.GetMoreMsg.MsgContent;
/* loaded from: classes3.dex */
public class e {
    public String content;
    public int customGroupType;
    public long dyC;
    public boolean fWc;
    public int followStatus;
    public String groupId;
    public String groupName;
    public int gsa;
    public String gsb = "";
    public long gsc;
    public boolean isAcceptNotify;
    public long msgId;
    public int msgType;
    public String nameShow;
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
        eVar.gsa = 0;
        eVar.msgType = 4;
        eVar.customGroupType = 4;
        eVar.dyC = System.currentTimeMillis();
        eVar.isAcceptNotify = true;
    }
}
