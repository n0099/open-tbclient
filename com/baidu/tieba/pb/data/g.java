package com.baidu.tieba.pb.data;

import tbclient.PbPage.ForumHeadlineImgInfo;
/* loaded from: classes9.dex */
public class g {
    private long cOG = 0;
    private String cOH = "";
    private String imgUrl = "";
    private int iCE = Integer.MAX_VALUE;
    private String iCF = "";
    private String abI = "";

    public void a(ForumHeadlineImgInfo forumHeadlineImgInfo) {
        if (forumHeadlineImgInfo != null) {
            this.cOG = forumHeadlineImgInfo.img_user_id.longValue();
            this.cOH = forumHeadlineImgInfo.img_user_name;
            this.imgUrl = forumHeadlineImgInfo.img_url;
            this.iCE = forumHeadlineImgInfo.rank_num.intValue();
            this.iCF = forumHeadlineImgInfo.rank_up_info;
            this.abI = forumHeadlineImgInfo.rank_url;
        }
    }

    public String ckX() {
        return this.abI;
    }

    public String aAG() {
        return this.imgUrl;
    }
}
