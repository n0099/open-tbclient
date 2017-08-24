package com.baidu.tieba.pb.data;

import com.baidu.adp.lib.util.StringUtils;
import tbclient.PbPage.ForumHeadlineImgInfo;
/* loaded from: classes.dex */
public class h {
    private long WB = 0;
    private String WC = "";
    private String imgUrl = "";
    private int eGn = Integer.MAX_VALUE;
    private String eGo = "";
    private String eGp = "";

    public void a(ForumHeadlineImgInfo forumHeadlineImgInfo) {
        if (forumHeadlineImgInfo != null) {
            this.WB = forumHeadlineImgInfo.img_user_id.longValue();
            this.WC = forumHeadlineImgInfo.img_user_name;
            this.imgUrl = forumHeadlineImgInfo.img_url;
            this.eGn = forumHeadlineImgInfo.rank_num.intValue();
            this.eGo = forumHeadlineImgInfo.rank_up_info;
            this.eGp = forumHeadlineImgInfo.rank_url;
        }
    }

    public boolean aQj() {
        return StringUtils.isNull(this.WC, true) || this.WB <= 0;
    }

    public String aQk() {
        return this.eGp;
    }

    public String aQl() {
        return this.WC;
    }

    public String pW() {
        return this.imgUrl;
    }

    public int aQm() {
        return this.eGn;
    }

    public String aQn() {
        return this.eGo;
    }
}
