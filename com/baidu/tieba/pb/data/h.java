package com.baidu.tieba.pb.data;

import com.baidu.adp.lib.util.StringUtils;
import tbclient.PbPage.ForumHeadlineImgInfo;
/* loaded from: classes.dex */
public class h {
    private long WA = 0;
    private String WB = "";
    private String imgUrl = "";
    private int eGl = Integer.MAX_VALUE;
    private String eGm = "";
    private String eGn = "";

    public void a(ForumHeadlineImgInfo forumHeadlineImgInfo) {
        if (forumHeadlineImgInfo != null) {
            this.WA = forumHeadlineImgInfo.img_user_id.longValue();
            this.WB = forumHeadlineImgInfo.img_user_name;
            this.imgUrl = forumHeadlineImgInfo.img_url;
            this.eGl = forumHeadlineImgInfo.rank_num.intValue();
            this.eGm = forumHeadlineImgInfo.rank_up_info;
            this.eGn = forumHeadlineImgInfo.rank_url;
        }
    }

    public boolean aQo() {
        return StringUtils.isNull(this.WB, true) || this.WA <= 0;
    }

    public String aQp() {
        return this.eGn;
    }

    public String aQq() {
        return this.WB;
    }

    public String pV() {
        return this.imgUrl;
    }

    public int aQr() {
        return this.eGl;
    }

    public String aQs() {
        return this.eGm;
    }
}
