package com.baidu.tieba.pb.data;

import tbclient.PbPage.ForumHeadlineImgInfo;
/* loaded from: classes2.dex */
public class j {
    private long eOT = 0;
    private String eOU = "";
    private String imgUrl = "";
    private int lNo = Integer.MAX_VALUE;
    private String lNp = "";
    private String aQo = "";

    public void a(ForumHeadlineImgInfo forumHeadlineImgInfo) {
        if (forumHeadlineImgInfo != null) {
            this.eOT = forumHeadlineImgInfo.img_user_id.longValue();
            this.eOU = forumHeadlineImgInfo.img_user_name;
            this.imgUrl = forumHeadlineImgInfo.img_url;
            this.lNo = forumHeadlineImgInfo.rank_num.intValue();
            this.lNp = forumHeadlineImgInfo.rank_up_info;
            this.aQo = forumHeadlineImgInfo.rank_url;
        }
    }

    public String dlZ() {
        return this.aQo;
    }

    public String getImgUrl() {
        return this.imgUrl;
    }
}
