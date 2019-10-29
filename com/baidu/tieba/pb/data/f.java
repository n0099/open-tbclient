package com.baidu.tieba.pb.data;

import tbclient.PbPage.ForumHeadlineImgInfo;
/* loaded from: classes4.dex */
public class f {
    private long bYQ = 0;
    private String bYR = "";
    private String imgUrl = "";
    private int hJw = Integer.MAX_VALUE;
    private String hJx = "";
    private String Ta = "";

    public void a(ForumHeadlineImgInfo forumHeadlineImgInfo) {
        if (forumHeadlineImgInfo != null) {
            this.bYQ = forumHeadlineImgInfo.img_user_id.longValue();
            this.bYR = forumHeadlineImgInfo.img_user_name;
            this.imgUrl = forumHeadlineImgInfo.img_url;
            this.hJw = forumHeadlineImgInfo.rank_num.intValue();
            this.hJx = forumHeadlineImgInfo.rank_up_info;
            this.Ta = forumHeadlineImgInfo.rank_url;
        }
    }

    public String bQZ() {
        return this.Ta;
    }

    public String ahf() {
        return this.imgUrl;
    }
}
