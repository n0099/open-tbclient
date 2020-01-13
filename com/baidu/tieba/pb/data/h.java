package com.baidu.tieba.pb.data;

import tbclient.PbPage.ForumHeadlineImgInfo;
/* loaded from: classes7.dex */
public class h {
    private long cKB = 0;
    private String cKC = "";
    private String imgUrl = "";
    private int iAx = Integer.MAX_VALUE;
    private String iAy = "";
    private String ZN = "";

    public void a(ForumHeadlineImgInfo forumHeadlineImgInfo) {
        if (forumHeadlineImgInfo != null) {
            this.cKB = forumHeadlineImgInfo.img_user_id.longValue();
            this.cKC = forumHeadlineImgInfo.img_user_name;
            this.imgUrl = forumHeadlineImgInfo.img_url;
            this.iAx = forumHeadlineImgInfo.rank_num.intValue();
            this.iAy = forumHeadlineImgInfo.rank_up_info;
            this.ZN = forumHeadlineImgInfo.rank_url;
        }
    }

    public String cjw() {
        return this.ZN;
    }

    public String ayq() {
        return this.imgUrl;
    }
}
