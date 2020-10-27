package com.baidu.yuyinala.privatemessage.implugin.entity;

import java.io.Serializable;
/* loaded from: classes4.dex */
public class ImBaseEntity implements Serializable {
    public String action;
    public int category;
    public String description;
    public String headUrl;
    public long id;
    public ImCreateGroupNotify mCreateGroupNotify;
    public ImPrivateInvite mPrivateInvite;
    public String mUK;
    public ImVideoEntity mVideoEntity;
    public String name;
    public int type;

    /* loaded from: classes4.dex */
    public static class ImCreateGroupNotify implements Serializable {
        public String messageContent;
    }

    /* loaded from: classes4.dex */
    public static class ImPrivateInvite implements Serializable {
        public String cover;
        public long groupId;
        public String inviteText;
    }

    /* loaded from: classes4.dex */
    public static class ImVideoEntity implements Serializable {
        public String cmd;
        public String describe;
        public int duration;
        public String h5Cmd;
        public String id;
        public boolean isShared;
        public String poster;
        public double posterWH;
        public String title;
    }
}
