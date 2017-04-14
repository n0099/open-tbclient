package com.baidu.tieba.tbadkCore;

import android.content.Context;
import com.baidu.adp.lib.util.BdLog;
import tbclient.ForumRecommend.LikeForum;
/* loaded from: classes.dex */
public class u implements com.baidu.tbadk.mvc.b.a {
    private String axr;
    private int bfk;
    private int fuA;
    private String mId;
    private String mName;
    private int mType;

    public u() {
    }

    public u(int i) {
        this.mType = i;
    }

    public String getId() {
        return this.mId;
    }

    public String getName() {
        return this.mName;
    }

    public void eq(int i) {
        this.fuA = i;
    }

    public int bhw() {
        return this.fuA;
    }

    public void setLevel(int i) {
        this.bfk = i;
    }

    public int getLevel() {
        return this.bfk;
    }

    public String getAvatar() {
        return this.axr;
    }

    public void a(LikeForum likeForum) {
        if (likeForum != null) {
            a(likeForum, null);
        }
    }

    public void a(LikeForum likeForum, Context context) {
        if (likeForum != null) {
            try {
                this.mId = String.valueOf(likeForum.forum_id);
                this.mName = likeForum.forum_name;
                this.fuA = likeForum.is_sign.intValue();
                this.bfk = likeForum.level_id.intValue();
                this.axr = likeForum.avatar;
            } catch (Exception e) {
                BdLog.detailException(e);
            }
        }
    }

    public int getType() {
        return this.mType;
    }

    public void setType(int i) {
        this.mType = i;
    }
}
