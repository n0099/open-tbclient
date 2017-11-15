package com.baidu.tieba.pb.data;

import com.baidu.adp.lib.util.StringUtils;
import tbclient.PbPage.ForumHeadlineImgInfo;
/* loaded from: classes.dex */
public class h {
    private long Wd = 0;
    private String We = "";
    private String imgUrl = "";
    private int eHe = Integer.MAX_VALUE;
    private String eHf = "";
    private String eHg = "";

    public void a(ForumHeadlineImgInfo forumHeadlineImgInfo) {
        if (forumHeadlineImgInfo != null) {
            this.Wd = forumHeadlineImgInfo.img_user_id.longValue();
            this.We = forumHeadlineImgInfo.img_user_name;
            this.imgUrl = forumHeadlineImgInfo.img_url;
            this.eHe = forumHeadlineImgInfo.rank_num.intValue();
            this.eHf = forumHeadlineImgInfo.rank_up_info;
            this.eHg = forumHeadlineImgInfo.rank_url;
        }
    }

    public boolean aQv() {
        return StringUtils.isNull(this.We, true) || this.Wd <= 0;
    }

    public String aQw() {
        return this.eHg;
    }

    public String aQx() {
        return this.We;
    }

    public String pQ() {
        return this.imgUrl;
    }

    public int aQy() {
        return this.eHe;
    }

    public String aQz() {
        return this.eHf;
    }
}
