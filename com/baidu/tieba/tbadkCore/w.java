package com.baidu.tieba.tbadkCore;

import android.content.Context;
import com.baidu.adp.lib.util.BdLog;
import tbclient.ForumRecommend.LikeForum;
/* loaded from: classes.dex */
public class w implements com.baidu.tbadk.mvc.b.a {
    private String aPR;
    private int boa;
    private int dFx;
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

    public void mS(int i) {
        this.dFx = i;
    }

    public int aEx() {
        return this.dFx;
    }

    public void setLevel(int i) {
        this.boa = i;
    }

    public int getLevel() {
        return this.boa;
    }

    public String getAvatar() {
        return this.aPR;
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
                this.dFx = likeForum.is_sign.intValue();
                this.boa = likeForum.level_id.intValue();
                this.aPR = likeForum.avatar;
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
