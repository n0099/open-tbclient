package com.baidu.tieba.pb.data;

import tbclient.PbPage.ForumHeadlineImgInfo;
/* loaded from: classes2.dex */
public class j {
    private long eNs = 0;
    private String eNt = "";
    private String imgUrl = "";
    private int lLm = Integer.MAX_VALUE;
    private String lLn = "";
    private String aOO = "";

    public void a(ForumHeadlineImgInfo forumHeadlineImgInfo) {
        if (forumHeadlineImgInfo != null) {
            this.eNs = forumHeadlineImgInfo.img_user_id.longValue();
            this.eNt = forumHeadlineImgInfo.img_user_name;
            this.imgUrl = forumHeadlineImgInfo.img_url;
            this.lLm = forumHeadlineImgInfo.rank_num.intValue();
            this.lLn = forumHeadlineImgInfo.rank_up_info;
            this.aOO = forumHeadlineImgInfo.rank_url;
        }
    }

    public String dlQ() {
        return this.aOO;
    }

    public String getImgUrl() {
        return this.imgUrl;
    }
}
