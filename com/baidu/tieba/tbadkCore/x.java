package com.baidu.tieba.tbadkCore;

import android.content.Context;
import com.baidu.adp.lib.util.BdLog;
import tbclient.ForumRecommend.LikeForum;
/* loaded from: classes.dex */
public class x implements com.baidu.tbadk.mvc.b.a {
    private String aox;
    private int bTv;
    private int eWc;
    private String mId;
    private String mName;
    private int mType;

    public x() {
    }

    public x(int i) {
        this.mType = i;
    }

    public String getId() {
        return this.mId;
    }

    public String getName() {
        return this.mName;
    }

    public void ea(int i) {
        this.eWc = i;
    }

    public int bbo() {
        return this.eWc;
    }

    public void setLevel(int i) {
        this.bTv = i;
    }

    public int getLevel() {
        return this.bTv;
    }

    public String getAvatar() {
        return this.aox;
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
                this.eWc = likeForum.is_sign.intValue();
                this.bTv = likeForum.level_id.intValue();
                this.aox = likeForum.avatar;
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
