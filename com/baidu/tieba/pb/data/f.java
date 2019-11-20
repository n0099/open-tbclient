package com.baidu.tieba.pb.data;

import tbclient.PbPage.ForumHeadlineImgInfo;
/* loaded from: classes4.dex */
public class f {
    private long bXZ = 0;
    private String bYa = "";
    private String imgUrl = "";
    private int hIF = Integer.MAX_VALUE;
    private String hIG = "";
    private String SD = "";

    public void a(ForumHeadlineImgInfo forumHeadlineImgInfo) {
        if (forumHeadlineImgInfo != null) {
            this.bXZ = forumHeadlineImgInfo.img_user_id.longValue();
            this.bYa = forumHeadlineImgInfo.img_user_name;
            this.imgUrl = forumHeadlineImgInfo.img_url;
            this.hIF = forumHeadlineImgInfo.rank_num.intValue();
            this.hIG = forumHeadlineImgInfo.rank_up_info;
            this.SD = forumHeadlineImgInfo.rank_url;
        }
    }

    public String bQX() {
        return this.SD;
    }

    public String ahd() {
        return this.imgUrl;
    }
}
