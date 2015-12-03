package com.baidu.tieba.tbadkCore;

import android.content.Context;
import com.baidu.adp.lib.util.BdLog;
import tbclient.ForumRecommend.LikeForum;
/* loaded from: classes.dex */
public class w implements com.baidu.tbadk.mvc.b.a {
    private String aMN;
    private int bkj;
    private int dxW;
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

    public void mq(int i) {
        this.dxW = i;
    }

    public int aCp() {
        return this.dxW;
    }

    public void setLevel(int i) {
        this.bkj = i;
    }

    public int getLevel() {
        return this.bkj;
    }

    public String getAvatar() {
        return this.aMN;
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
                this.dxW = likeForum.is_sign.intValue();
                this.bkj = likeForum.level_id.intValue();
                this.aMN = likeForum.avatar;
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
