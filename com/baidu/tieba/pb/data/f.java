package com.baidu.tieba.pb.data;

import tbclient.PbPage.ForumHeadlineImgInfo;
/* loaded from: classes2.dex */
public class f {
    private long aMe = 0;
    private String aMf = "";
    private String imgUrl = "";
    private int fHD = Integer.MAX_VALUE;
    private String fHE = "";
    private String fHF = "";

    public void a(ForumHeadlineImgInfo forumHeadlineImgInfo) {
        if (forumHeadlineImgInfo != null) {
            this.aMe = forumHeadlineImgInfo.img_user_id.longValue();
            this.aMf = forumHeadlineImgInfo.img_user_name;
            this.imgUrl = forumHeadlineImgInfo.img_url;
            this.fHD = forumHeadlineImgInfo.rank_num.intValue();
            this.fHE = forumHeadlineImgInfo.rank_up_info;
            this.fHF = forumHeadlineImgInfo.rank_url;
        }
    }

    public String baT() {
        return this.fHF;
    }

    public String ya() {
        return this.imgUrl;
    }
}
