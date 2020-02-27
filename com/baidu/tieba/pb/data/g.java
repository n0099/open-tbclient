package com.baidu.tieba.pb.data;

import tbclient.PbPage.ForumHeadlineImgInfo;
/* loaded from: classes9.dex */
public class g {
    private long cOE = 0;
    private String cOF = "";
    private String imgUrl = "";
    private int iCq = Integer.MAX_VALUE;
    private String iCr = "";
    private String abI = "";

    public void a(ForumHeadlineImgInfo forumHeadlineImgInfo) {
        if (forumHeadlineImgInfo != null) {
            this.cOE = forumHeadlineImgInfo.img_user_id.longValue();
            this.cOF = forumHeadlineImgInfo.img_user_name;
            this.imgUrl = forumHeadlineImgInfo.img_url;
            this.iCq = forumHeadlineImgInfo.rank_num.intValue();
            this.iCr = forumHeadlineImgInfo.rank_up_info;
            this.abI = forumHeadlineImgInfo.rank_url;
        }
    }

    public String ckU() {
        return this.abI;
    }

    public String aAE() {
        return this.imgUrl;
    }
}
