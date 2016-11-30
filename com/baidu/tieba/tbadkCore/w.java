package com.baidu.tieba.tbadkCore;

import android.content.Context;
import com.baidu.adp.lib.util.BdLog;
import tbclient.ForumRecommend.LikeForum;
/* loaded from: classes.dex */
public class w implements com.baidu.tbadk.mvc.b.a {
    private String asY;
    private int clH;
    private int fAR;
    private String mId;
    private String mName;
    private int mType;

    public w() {
    }

    public w(int i) {
        this.mType = i;
    }

    public String getId() {
        return this.mId;
    }

    public String getName() {
        return this.mName;
    }

    public void eq(int i) {
        this.fAR = i;
    }

    public int blt() {
        return this.fAR;
    }

    public void setLevel(int i) {
        this.clH = i;
    }

    public int getLevel() {
        return this.clH;
    }

    public String getAvatar() {
        return this.asY;
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
                this.fAR = likeForum.is_sign.intValue();
                this.clH = likeForum.level_id.intValue();
                this.asY = likeForum.avatar;
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
