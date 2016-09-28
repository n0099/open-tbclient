package com.baidu.tieba.tbadkCore;

import android.content.Context;
import com.baidu.adp.lib.util.BdLog;
import tbclient.ForumRecommend.LikeForum;
/* loaded from: classes.dex */
public class w implements com.baidu.tbadk.mvc.b.a {
    private String ase;
    private int cgC;
    private int ftE;
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

    public void eo(int i) {
        this.ftE = i;
    }

    public int biT() {
        return this.ftE;
    }

    public void setLevel(int i) {
        this.cgC = i;
    }

    public int getLevel() {
        return this.cgC;
    }

    public String getAvatar() {
        return this.ase;
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
                this.ftE = likeForum.is_sign.intValue();
                this.cgC = likeForum.level_id.intValue();
                this.ase = likeForum.avatar;
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
