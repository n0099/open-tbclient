package com.baidu.tieba.tbadkCore;

import android.content.Context;
import com.baidu.adp.lib.util.BdLog;
import tbclient.ForumRecommend.LikeForum;
/* loaded from: classes.dex */
public class ab {
    private String mId = null;
    private String mName = null;
    private int aIv = 0;
    private int bUM = 0;
    private int bUN = 0;
    private String atu = null;

    public String getId() {
        return this.mId;
    }

    public String getName() {
        return this.mName;
    }

    public void hK(int i) {
        this.bUM = i;
    }

    public int aeZ() {
        return this.bUM;
    }

    public void setLevel(int i) {
        this.aIv = i;
    }

    public int getLevel() {
        return this.aIv;
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
                this.bUM = likeForum.is_sign.intValue();
                this.aIv = likeForum.level_id.intValue();
                this.atu = likeForum.avatar;
            } catch (Exception e) {
                BdLog.detailException(e);
            }
        }
    }

    public int isLike() {
        return this.bUN;
    }
}
