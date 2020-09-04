package com.baidu.tieba.usermute;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.message.CustomMessage;
/* loaded from: classes.dex */
public class UserMuteAddAndDelCustomMessage extends CustomMessage {
    public static final int PB = 1;
    public static final int PERSON_INFO = 0;
    public static final int SETTING = 2;
    public int from;
    public boolean isMute;
    public BdUniqueId mId;
    public String msg;
    public String muteUserId;
    public String postId;
    public String threadId;
    public String userName;

    public UserMuteAddAndDelCustomMessage(int i) {
        super(i);
        this.from = -1;
    }

    public void setData(boolean z, String str, String str2, String str3, String str4, int i, String str5, BdUniqueId bdUniqueId) {
        this.isMute = z;
        this.muteUserId = str;
        this.userName = str2;
        this.threadId = str3;
        this.postId = str4;
        this.from = i;
        this.msg = str5;
        this.mId = bdUniqueId;
    }
}
