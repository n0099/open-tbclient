package com.baidu.tieba.tbadkCore;

import android.content.Context;
import com.baidu.adp.lib.util.BdLog;
import tbclient.ForumRecommend.LikeForum;
/* loaded from: classes.dex */
public class x implements com.baidu.tbadk.mvc.b.a {
    private String apm;
    private int bVv;
    private int fje;
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
        this.fje = i;
    }

    public int beC() {
        return this.fje;
    }

    public void setLevel(int i) {
        this.bVv = i;
    }

    public int getLevel() {
        return this.bVv;
    }

    public String getAvatar() {
        return this.apm;
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
                this.fje = likeForum.is_sign.intValue();
                this.bVv = likeForum.level_id.intValue();
                this.apm = likeForum.avatar;
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
