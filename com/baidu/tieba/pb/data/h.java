package com.baidu.tieba.pb.data;

import com.baidu.adp.lib.util.StringUtils;
import tbclient.PbPage.ForumHeadlineImgInfo;
/* loaded from: classes.dex */
public class h {
    private long Wx = 0;
    private String Wy = "";
    private String imgUrl = "";
    private int ePW = Integer.MAX_VALUE;
    private String ePX = "";
    private String ePY = "";

    public void a(ForumHeadlineImgInfo forumHeadlineImgInfo) {
        if (forumHeadlineImgInfo != null) {
            this.Wx = forumHeadlineImgInfo.img_user_id.longValue();
            this.Wy = forumHeadlineImgInfo.img_user_name;
            this.imgUrl = forumHeadlineImgInfo.img_url;
            this.ePW = forumHeadlineImgInfo.rank_num.intValue();
            this.ePX = forumHeadlineImgInfo.rank_up_info;
            this.ePY = forumHeadlineImgInfo.rank_url;
        }
    }

    public boolean aRQ() {
        return StringUtils.isNull(this.Wy, true) || this.Wx <= 0;
    }

    public String aRR() {
        return this.ePY;
    }

    public String aRS() {
        return this.Wy;
    }

    public String pR() {
        return this.imgUrl;
    }

    public int aRT() {
        return this.ePW;
    }

    public String aRU() {
        return this.ePX;
    }
}
