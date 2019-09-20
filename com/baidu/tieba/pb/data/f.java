package com.baidu.tieba.pb.data;

import tbclient.PbPage.ForumHeadlineImgInfo;
/* loaded from: classes4.dex */
public class f {
    private long bHf = 0;
    private String bHg = "";
    private String imgUrl = "";
    private int dzX = Integer.MAX_VALUE;
    private String hKR = "";
    private String rankUrl = "";

    public void a(ForumHeadlineImgInfo forumHeadlineImgInfo) {
        if (forumHeadlineImgInfo != null) {
            this.bHf = forumHeadlineImgInfo.img_user_id.longValue();
            this.bHg = forumHeadlineImgInfo.img_user_name;
            this.imgUrl = forumHeadlineImgInfo.img_url;
            this.dzX = forumHeadlineImgInfo.rank_num.intValue();
            this.hKR = forumHeadlineImgInfo.rank_up_info;
            this.rankUrl = forumHeadlineImgInfo.rank_url;
        }
    }

    public String bTY() {
        return this.rankUrl;
    }

    public String acZ() {
        return this.imgUrl;
    }
}
