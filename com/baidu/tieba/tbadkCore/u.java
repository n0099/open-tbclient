package com.baidu.tieba.tbadkCore;

import android.content.Context;
import com.baidu.adp.lib.util.BdLog;
import tbclient.ForumRecommend.LikeForum;
/* loaded from: classes.dex */
public class u implements com.baidu.tbadk.mvc.b.a {
    private String axt;
    private int bgX;
    private int fwQ;
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
        this.fwQ = i;
    }

    public int bix() {
        return this.fwQ;
    }

    public void setLevel(int i) {
        this.bgX = i;
    }

    public int getLevel() {
        return this.bgX;
    }

    public String getAvatar() {
        return this.axt;
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
                this.fwQ = likeForum.is_sign.intValue();
                this.bgX = likeForum.level_id.intValue();
                this.axt = likeForum.avatar;
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
