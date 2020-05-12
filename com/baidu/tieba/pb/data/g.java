package com.baidu.tieba.pb.data;

import android.support.v7.widget.ActivityChooserView;
import tbclient.PbPage.ForumHeadlineImgInfo;
/* loaded from: classes9.dex */
public class g {
    private long dod = 0;
    private String doe = "";
    private String imgUrl = "";
    private int jop = ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED;
    private String joq = "";
    private String auv = "";

    public void a(ForumHeadlineImgInfo forumHeadlineImgInfo) {
        if (forumHeadlineImgInfo != null) {
            this.dod = forumHeadlineImgInfo.img_user_id.longValue();
            this.doe = forumHeadlineImgInfo.img_user_name;
            this.imgUrl = forumHeadlineImgInfo.img_url;
            this.jop = forumHeadlineImgInfo.rank_num.intValue();
            this.joq = forumHeadlineImgInfo.rank_up_info;
            this.auv = forumHeadlineImgInfo.rank_url;
        }
    }

    public String cvV() {
        return this.auv;
    }

    public String aIU() {
        return this.imgUrl;
    }
}
