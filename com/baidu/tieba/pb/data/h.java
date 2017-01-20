package com.baidu.tieba.pb.data;

import com.baidu.adp.lib.util.StringUtils;
import tbclient.PbPage.ForumHeadlineImgInfo;
/* loaded from: classes.dex */
public class h {
    private long Qa = 0;
    private String Qb = "";
    private String imgUrl = "";
    private int efN = Integer.MAX_VALUE;
    private String efO = "";
    private String efP = "";

    public void a(ForumHeadlineImgInfo forumHeadlineImgInfo) {
        if (forumHeadlineImgInfo != null) {
            this.Qa = forumHeadlineImgInfo.img_user_id.longValue();
            this.Qb = forumHeadlineImgInfo.img_user_name;
            this.imgUrl = forumHeadlineImgInfo.img_url;
            this.efN = forumHeadlineImgInfo.rank_num.intValue();
            this.efO = forumHeadlineImgInfo.rank_up_info;
            this.efP = forumHeadlineImgInfo.rank_url;
        }
    }

    public boolean pI() {
        return StringUtils.isNull(this.Qb, true) || this.Qa <= 0;
    }

    public String aKs() {
        return this.efP;
    }

    public String pK() {
        return this.Qb;
    }

    public String pL() {
        return this.imgUrl;
    }

    public int aKt() {
        return this.efN;
    }

    public String aKu() {
        return this.efO;
    }
}
