package com.baidu.tieba.pb.data;

import com.baidu.adp.lib.util.StringUtils;
import tbclient.PbPage.ForumHeadlineImgInfo;
/* loaded from: classes.dex */
public class h {
    private long VF = 0;
    private String VG = "";
    private String imgUrl = "";
    private int egq = Integer.MAX_VALUE;
    private String egr = "";
    private String egs = "";

    public void a(ForumHeadlineImgInfo forumHeadlineImgInfo) {
        if (forumHeadlineImgInfo != null) {
            this.VF = forumHeadlineImgInfo.img_user_id.longValue();
            this.VG = forumHeadlineImgInfo.img_user_name;
            this.imgUrl = forumHeadlineImgInfo.img_url;
            this.egq = forumHeadlineImgInfo.rank_num.intValue();
            this.egr = forumHeadlineImgInfo.rank_up_info;
            this.egs = forumHeadlineImgInfo.rank_url;
        }
    }

    public boolean qy() {
        return StringUtils.isNull(this.VG, true) || this.VF <= 0;
    }

    public String aJR() {
        return this.egs;
    }

    public String qA() {
        return this.VG;
    }

    public String qB() {
        return this.imgUrl;
    }

    public int aJS() {
        return this.egq;
    }

    public String aJT() {
        return this.egr;
    }
}
