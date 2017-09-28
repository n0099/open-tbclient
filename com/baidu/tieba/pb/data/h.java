package com.baidu.tieba.pb.data;

import com.baidu.adp.lib.util.StringUtils;
import tbclient.PbPage.ForumHeadlineImgInfo;
/* loaded from: classes.dex */
public class h {
    private long VX = 0;
    private String VY = "";
    private String imgUrl = "";
    private int eyX = Integer.MAX_VALUE;
    private String eyY = "";
    private String eyZ = "";

    public void a(ForumHeadlineImgInfo forumHeadlineImgInfo) {
        if (forumHeadlineImgInfo != null) {
            this.VX = forumHeadlineImgInfo.img_user_id.longValue();
            this.VY = forumHeadlineImgInfo.img_user_name;
            this.imgUrl = forumHeadlineImgInfo.img_url;
            this.eyX = forumHeadlineImgInfo.rank_num.intValue();
            this.eyY = forumHeadlineImgInfo.rank_up_info;
            this.eyZ = forumHeadlineImgInfo.rank_url;
        }
    }

    public boolean aNA() {
        return StringUtils.isNull(this.VY, true) || this.VX <= 0;
    }

    public String aNB() {
        return this.eyZ;
    }

    public String aNC() {
        return this.VY;
    }

    public String pS() {
        return this.imgUrl;
    }

    public int aND() {
        return this.eyX;
    }

    public String aNE() {
        return this.eyY;
    }
}
