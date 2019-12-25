package com.baidu.tieba.pb.data;

import tbclient.PbPage.ForumHeadlineImgInfo;
/* loaded from: classes6.dex */
public class h {
    private long cKq = 0;
    private String cKr = "";
    private String imgUrl = "";
    private int iwT = Integer.MAX_VALUE;
    private String iwU = "";
    private String Zz = "";

    public void a(ForumHeadlineImgInfo forumHeadlineImgInfo) {
        if (forumHeadlineImgInfo != null) {
            this.cKq = forumHeadlineImgInfo.img_user_id.longValue();
            this.cKr = forumHeadlineImgInfo.img_user_name;
            this.imgUrl = forumHeadlineImgInfo.img_url;
            this.iwT = forumHeadlineImgInfo.rank_num.intValue();
            this.iwU = forumHeadlineImgInfo.rank_up_info;
            this.Zz = forumHeadlineImgInfo.rank_url;
        }
    }

    public String cio() {
        return this.Zz;
    }

    public String axX() {
        return this.imgUrl;
    }
}
