package com.baidu.tieba.tbadkCore;

import android.content.Context;
import com.baidu.adp.lib.util.BdLog;
import tbclient.ForumRecommend.LikeForum;
/* loaded from: classes.dex */
public class ab {
    private String mId = null;
    private String mName = null;
    private int aIy = 0;
    private int bUN = 0;
    private int bUO = 0;
    private String atx = null;

    public String getId() {
        return this.mId;
    }

    public String getName() {
        return this.mName;
    }

    public void hK(int i) {
        this.bUN = i;
    }

    public int afe() {
        return this.bUN;
    }

    public void setLevel(int i) {
        this.aIy = i;
    }

    public int getLevel() {
        return this.aIy;
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
                this.bUN = likeForum.is_sign.intValue();
                this.aIy = likeForum.level_id.intValue();
                this.atx = likeForum.avatar;
            } catch (Exception e) {
                BdLog.detailException(e);
            }
        }
    }

    public int isLike() {
        return this.bUO;
    }
}
