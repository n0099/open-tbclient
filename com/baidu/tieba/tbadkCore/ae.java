package com.baidu.tieba.tbadkCore;

import android.content.Context;
import com.baidu.adp.lib.util.BdLog;
import tbclient.ForumRecommend.LikeForum;
/* loaded from: classes.dex */
public class ae implements com.baidu.tbadk.mvc.b.a {
    private String aEG;
    private int aQW;
    private int cpI;
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

    public void iK(int i) {
        this.cpI = i;
    }

    public int amO() {
        return this.cpI;
    }

    public void setLevel(int i) {
        this.aQW = i;
    }

    public int getLevel() {
        return this.aQW;
    }

    public String getAvatar() {
        return this.aEG;
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
                this.cpI = likeForum.is_sign.intValue();
                this.aQW = likeForum.level_id.intValue();
                this.aEG = likeForum.avatar;
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
