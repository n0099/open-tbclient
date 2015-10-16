package com.baidu.tieba.tbadkCore;

import android.content.Context;
import com.baidu.adp.lib.util.BdLog;
import tbclient.ForumRecommend.LikeForum;
/* loaded from: classes.dex */
public class v implements com.baidu.tbadk.mvc.b.a {
    private String aLy;
    private int bcY;
    private int cXT;
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

    public void kS(int i) {
        this.cXT = i;
    }

    public int awa() {
        return this.cXT;
    }

    public void setLevel(int i) {
        this.bcY = i;
    }

    public int getLevel() {
        return this.bcY;
    }

    public String getAvatar() {
        return this.aLy;
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
                this.cXT = likeForum.is_sign.intValue();
                this.bcY = likeForum.level_id.intValue();
                this.aLy = likeForum.avatar;
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
