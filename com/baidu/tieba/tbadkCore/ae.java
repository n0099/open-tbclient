package com.baidu.tieba.tbadkCore;

import android.content.Context;
import com.baidu.adp.lib.util.BdLog;
import tbclient.ForumRecommend.LikeForum;
/* loaded from: classes.dex */
public class ae implements com.baidu.tbadk.mvc.b.a {
    private String aCw;
    private int aOu;
    private int clt;
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

    public void il(int i) {
        this.clt = i;
    }

    public int akO() {
        return this.clt;
    }

    public void setLevel(int i) {
        this.aOu = i;
    }

    public int getLevel() {
        return this.aOu;
    }

    public String getAvatar() {
        return this.aCw;
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
                this.clt = likeForum.is_sign.intValue();
                this.aOu = likeForum.level_id.intValue();
                this.aCw = likeForum.avatar;
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
