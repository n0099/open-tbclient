package com.baidu.tieba.tbadkCore;

import android.content.Context;
import com.baidu.adp.lib.util.BdLog;
import tbclient.ForumRecommend.LikeForum;
/* loaded from: classes.dex */
public class ae implements com.baidu.tbadk.mvc.b.a {
    private String aEH;
    private int aQX;
    private int cpJ;
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
        this.cpJ = i;
    }

    public int amP() {
        return this.cpJ;
    }

    public void setLevel(int i) {
        this.aQX = i;
    }

    public int getLevel() {
        return this.aQX;
    }

    public String getAvatar() {
        return this.aEH;
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
                this.cpJ = likeForum.is_sign.intValue();
                this.aQX = likeForum.level_id.intValue();
                this.aEH = likeForum.avatar;
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
