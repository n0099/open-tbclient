package com.baidu.tieba.tbadkCore;

import android.content.Context;
import com.baidu.adp.lib.util.BdLog;
import tbclient.ForumRecommend.LikeForum;
/* loaded from: classes.dex */
public class v implements com.baidu.tbadk.mvc.b.a {
    private String aVB;
    private int bvX;
    private int enW;
    private String mId;
    private String mName;
    private int mType;

    public v() {
    }

    public v(int i) {
        this.mType = i;
    }

    public String getId() {
        return this.mId;
    }

    public String getName() {
        return this.mName;
    }

    public void pm(int i) {
        this.enW = i;
    }

    public int aSw() {
        return this.enW;
    }

    public void setLevel(int i) {
        this.bvX = i;
    }

    public int getLevel() {
        return this.bvX;
    }

    public String getAvatar() {
        return this.aVB;
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
                this.enW = likeForum.is_sign.intValue();
                this.bvX = likeForum.level_id.intValue();
                this.aVB = likeForum.avatar;
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
