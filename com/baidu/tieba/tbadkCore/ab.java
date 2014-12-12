package com.baidu.tieba.tbadkCore;

import android.content.Context;
import com.baidu.adp.lib.util.BdLog;
import tbclient.ForumRecommend.LikeForum;
/* loaded from: classes.dex */
public class ab {
    private String mId = null;
    private String mName = null;
    private int aHo = 0;
    private int bSU = 0;
    private int bSV = 0;
    private String asr = null;

    public String getId() {
        return this.mId;
    }

    public String getName() {
        return this.mName;
    }

    public void hB(int i) {
        this.bSU = i;
    }

    public int aeA() {
        return this.bSU;
    }

    public void setLevel(int i) {
        this.aHo = i;
    }

    public int getLevel() {
        return this.aHo;
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
                this.bSU = likeForum.is_sign.intValue();
                this.aHo = likeForum.level_id.intValue();
                this.asr = likeForum.avatar;
            } catch (Exception e) {
                BdLog.detailException(e);
            }
        }
    }

    public int isLike() {
        return this.bSV;
    }
}
