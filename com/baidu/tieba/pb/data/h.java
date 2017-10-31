package com.baidu.tieba.pb.data;

import com.baidu.adp.lib.util.StringUtils;
import tbclient.PbPage.ForumHeadlineImgInfo;
/* loaded from: classes.dex */
public class h {
    private long Wd = 0;
    private String We = "";
    private String imgUrl = "";
    private int eGK = Integer.MAX_VALUE;
    private String eGL = "";
    private String eGM = "";

    public void a(ForumHeadlineImgInfo forumHeadlineImgInfo) {
        if (forumHeadlineImgInfo != null) {
            this.Wd = forumHeadlineImgInfo.img_user_id.longValue();
            this.We = forumHeadlineImgInfo.img_user_name;
            this.imgUrl = forumHeadlineImgInfo.img_url;
            this.eGK = forumHeadlineImgInfo.rank_num.intValue();
            this.eGL = forumHeadlineImgInfo.rank_up_info;
            this.eGM = forumHeadlineImgInfo.rank_url;
        }
    }

    public boolean aQn() {
        return StringUtils.isNull(this.We, true) || this.Wd <= 0;
    }

    public String aQo() {
        return this.eGM;
    }

    public String aQp() {
        return this.We;
    }

    public String pQ() {
        return this.imgUrl;
    }

    public int aQq() {
        return this.eGK;
    }

    public String aQr() {
        return this.eGL;
    }
}
