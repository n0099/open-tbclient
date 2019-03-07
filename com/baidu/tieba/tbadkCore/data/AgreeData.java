package com.baidu.tieba.tbadkCore.data;

import java.io.Serializable;
import tbclient.Agree;
/* loaded from: classes.dex */
public class AgreeData implements Serializable {
    public int agreeType;
    public long diffAgreeNum = 0;
    public long agreeNum = 0;
    public long disAgreeNum = 0;
    public boolean hasAgree = false;
    public String threadId = "";
    public String forumId = "";
    public String postId = "";
    public boolean isInThread = false;
    public int objType = 0;
    public boolean isInPost = false;
    public long indexOfPic = 0;

    public void parseProtobuf(Agree agree) {
        if (agree != null) {
            this.agreeNum = agree.agree_num == null ? 0L : agree.agree_num.longValue();
            this.disAgreeNum = agree.disagree_num.longValue();
            this.agreeType = agree.agree_type == null ? 0 : agree.agree_type.intValue();
            this.hasAgree = agree.has_agree.intValue() == 1;
            this.diffAgreeNum = agree.diff_agree_num != null ? agree.diff_agree_num.longValue() : 0L;
        }
    }
}
