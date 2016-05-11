package com.baidu.tieba.tbadkCore;

import android.content.Context;
import com.baidu.adp.lib.util.BdLog;
import tbclient.ForumRecommend.LikeForum;
/* loaded from: classes.dex */
public class w implements com.baidu.tbadk.mvc.b.a {
    private String aWQ;
    private int bvK;
    private int ero;
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

    public void pi(int i) {
        this.ero = i;
    }

    public int aSV() {
        return this.ero;
    }

    public void setLevel(int i) {
        this.bvK = i;
    }

    public int getLevel() {
        return this.bvK;
    }

    public String getAvatar() {
        return this.aWQ;
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
                this.ero = likeForum.is_sign.intValue();
                this.bvK = likeForum.level_id.intValue();
                this.aWQ = likeForum.avatar;
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
