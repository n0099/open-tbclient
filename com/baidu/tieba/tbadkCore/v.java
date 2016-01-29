package com.baidu.tieba.tbadkCore;

import android.content.Context;
import com.baidu.adp.lib.util.BdLog;
import tbclient.ForumRecommend.LikeForum;
/* loaded from: classes.dex */
public class v implements com.baidu.tbadk.mvc.b.a {
    private String aRU;
    private int bqU;
    private int dVs;
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

    public void od(int i) {
        this.dVs = i;
    }

    public int aLD() {
        return this.dVs;
    }

    public void setLevel(int i) {
        this.bqU = i;
    }

    public int getLevel() {
        return this.bqU;
    }

    public String getAvatar() {
        return this.aRU;
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
                this.dVs = likeForum.is_sign.intValue();
                this.bqU = likeForum.level_id.intValue();
                this.aRU = likeForum.avatar;
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
