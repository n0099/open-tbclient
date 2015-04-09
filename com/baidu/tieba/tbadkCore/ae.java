package com.baidu.tieba.tbadkCore;

import android.content.Context;
import com.baidu.adp.lib.util.BdLog;
import tbclient.ForumRecommend.LikeForum;
/* loaded from: classes.dex */
public class ae implements com.baidu.tbadk.mvc.b.a {
    private String aCE;
    private int aOL;
    private int clJ;
    private String mId;
    private String mName;
    private int mType;

    public ae() {
    }

    public ae(int i) {
        this.mType = i;
    }

    public String getId() {
        return this.mId;
    }

    public String getName() {
        return this.mName;
    }

    public void io(int i) {
        this.clJ = i;
    }

    public int ald() {
        return this.clJ;
    }

    public void setLevel(int i) {
        this.aOL = i;
    }

    public int getLevel() {
        return this.aOL;
    }

    public String getAvatar() {
        return this.aCE;
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
                this.clJ = likeForum.is_sign.intValue();
                this.aOL = likeForum.level_id.intValue();
                this.aCE = likeForum.avatar;
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
