package com.baidu.tieba.pb.data;

import tbclient.PbPage.ForumHeadlineImgInfo;
/* loaded from: classes2.dex */
public class f {
    private long aMf = 0;
    private String aMg = "";
    private String imgUrl = "";
    private int fHT = Integer.MAX_VALUE;
    private String fHU = "";
    private String fHV = "";

    public void a(ForumHeadlineImgInfo forumHeadlineImgInfo) {
        if (forumHeadlineImgInfo != null) {
            this.aMf = forumHeadlineImgInfo.img_user_id.longValue();
            this.aMg = forumHeadlineImgInfo.img_user_name;
            this.imgUrl = forumHeadlineImgInfo.img_url;
            this.fHT = forumHeadlineImgInfo.rank_num.intValue();
            this.fHU = forumHeadlineImgInfo.rank_up_info;
            this.fHV = forumHeadlineImgInfo.rank_url;
        }
    }

    public String baU() {
        return this.fHV;
    }

    public String ya() {
        return this.imgUrl;
    }
}
