package com.baidu.tieba.pb.data;

import tbclient.PbPage.ForumHeadlineImgInfo;
/* loaded from: classes9.dex */
public class g {
    private long cOF = 0;
    private String cOG = "";
    private String imgUrl = "";
    private int iCs = Integer.MAX_VALUE;
    private String iCt = "";
    private String abI = "";

    public void a(ForumHeadlineImgInfo forumHeadlineImgInfo) {
        if (forumHeadlineImgInfo != null) {
            this.cOF = forumHeadlineImgInfo.img_user_id.longValue();
            this.cOG = forumHeadlineImgInfo.img_user_name;
            this.imgUrl = forumHeadlineImgInfo.img_url;
            this.iCs = forumHeadlineImgInfo.rank_num.intValue();
            this.iCt = forumHeadlineImgInfo.rank_up_info;
            this.abI = forumHeadlineImgInfo.rank_url;
        }
    }

    public String ckW() {
        return this.abI;
    }

    public String aAG() {
        return this.imgUrl;
    }
}
