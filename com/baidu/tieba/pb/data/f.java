package com.baidu.tieba.pb.data;

import tbclient.PbPage.ForumHeadlineImgInfo;
/* loaded from: classes2.dex */
public class f {
    private long aMp = 0;
    private String aMq = "";
    private String imgUrl = "";
    private int fHO = Integer.MAX_VALUE;
    private String fHP = "";
    private String fHQ = "";

    public void a(ForumHeadlineImgInfo forumHeadlineImgInfo) {
        if (forumHeadlineImgInfo != null) {
            this.aMp = forumHeadlineImgInfo.img_user_id.longValue();
            this.aMq = forumHeadlineImgInfo.img_user_name;
            this.imgUrl = forumHeadlineImgInfo.img_url;
            this.fHO = forumHeadlineImgInfo.rank_num.intValue();
            this.fHP = forumHeadlineImgInfo.rank_up_info;
            this.fHQ = forumHeadlineImgInfo.rank_url;
        }
    }

    public String baU() {
        return this.fHQ;
    }

    public String ya() {
        return this.imgUrl;
    }
}
