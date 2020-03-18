package com.baidu.tieba.pb.data;

import tbclient.PbPage.ForumHeadlineImgInfo;
/* loaded from: classes9.dex */
public class g {
    private long cOT = 0;
    private String cOU = "";
    private String imgUrl = "";
    private int iEf = Integer.MAX_VALUE;
    private String iEg = "";
    private String abS = "";

    public void a(ForumHeadlineImgInfo forumHeadlineImgInfo) {
        if (forumHeadlineImgInfo != null) {
            this.cOT = forumHeadlineImgInfo.img_user_id.longValue();
            this.cOU = forumHeadlineImgInfo.img_user_name;
            this.imgUrl = forumHeadlineImgInfo.img_url;
            this.iEf = forumHeadlineImgInfo.rank_num.intValue();
            this.iEg = forumHeadlineImgInfo.rank_up_info;
            this.abS = forumHeadlineImgInfo.rank_url;
        }
    }

    public String cls() {
        return this.abS;
    }

    public String aAJ() {
        return this.imgUrl;
    }
}
