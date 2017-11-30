package com.baidu.tieba.pb.data;

import com.baidu.adp.lib.util.StringUtils;
import tbclient.PbPage.ForumHeadlineImgInfo;
/* loaded from: classes.dex */
public class h {
    private long WA = 0;
    private String WB = "";
    private String imgUrl = "";
    private int eOO = Integer.MAX_VALUE;
    private String eOP = "";
    private String eOQ = "";

    public void a(ForumHeadlineImgInfo forumHeadlineImgInfo) {
        if (forumHeadlineImgInfo != null) {
            this.WA = forumHeadlineImgInfo.img_user_id.longValue();
            this.WB = forumHeadlineImgInfo.img_user_name;
            this.imgUrl = forumHeadlineImgInfo.img_url;
            this.eOO = forumHeadlineImgInfo.rank_num.intValue();
            this.eOP = forumHeadlineImgInfo.rank_up_info;
            this.eOQ = forumHeadlineImgInfo.rank_url;
        }
    }

    public boolean aRH() {
        return StringUtils.isNull(this.WB, true) || this.WA <= 0;
    }

    public String aRI() {
        return this.eOQ;
    }

    public String aRJ() {
        return this.WB;
    }

    public String pT() {
        return this.imgUrl;
    }

    public int aRK() {
        return this.eOO;
    }

    public String aRL() {
        return this.eOP;
    }
}
