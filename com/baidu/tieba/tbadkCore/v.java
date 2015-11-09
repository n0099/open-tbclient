package com.baidu.tieba.tbadkCore;

import android.content.Context;
import com.baidu.adp.lib.util.BdLog;
import tbclient.ForumRecommend.LikeForum;
/* loaded from: classes.dex */
public class v implements com.baidu.tbadk.mvc.b.a {
    private String aLG;
    private int bdD;
    private int cZq;
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

    public void lg(int i) {
        this.cZq = i;
    }

    public int awE() {
        return this.cZq;
    }

    public void setLevel(int i) {
        this.bdD = i;
    }

    public int getLevel() {
        return this.bdD;
    }

    public String getAvatar() {
        return this.aLG;
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
                this.cZq = likeForum.is_sign.intValue();
                this.bdD = likeForum.level_id.intValue();
                this.aLG = likeForum.avatar;
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
