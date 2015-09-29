package com.baidu.tieba.tbadkCore;

import android.content.Context;
import com.baidu.adp.lib.util.BdLog;
import tbclient.ForumRecommend.LikeForum;
/* loaded from: classes.dex */
public class v implements com.baidu.tbadk.mvc.b.a {
    private String aLn;
    private int bcN;
    private int cXt;
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

    public void kQ(int i) {
        this.cXt = i;
    }

    public int avS() {
        return this.cXt;
    }

    public void setLevel(int i) {
        this.bcN = i;
    }

    public int getLevel() {
        return this.bcN;
    }

    public String getAvatar() {
        return this.aLn;
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
                this.cXt = likeForum.is_sign.intValue();
                this.bcN = likeForum.level_id.intValue();
                this.aLn = likeForum.avatar;
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
