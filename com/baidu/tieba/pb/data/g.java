package com.baidu.tieba.pb.data;

import android.support.v7.widget.ActivityChooserView;
import tbclient.PbPage.ForumHeadlineImgInfo;
/* loaded from: classes9.dex */
public class g {
    private long dnY = 0;
    private String dnZ = "";
    private String imgUrl = "";
    private int jol = ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED;
    private String jom = "";
    private String aup = "";

    public void a(ForumHeadlineImgInfo forumHeadlineImgInfo) {
        if (forumHeadlineImgInfo != null) {
            this.dnY = forumHeadlineImgInfo.img_user_id.longValue();
            this.dnZ = forumHeadlineImgInfo.img_user_name;
            this.imgUrl = forumHeadlineImgInfo.img_url;
            this.jol = forumHeadlineImgInfo.rank_num.intValue();
            this.jom = forumHeadlineImgInfo.rank_up_info;
            this.aup = forumHeadlineImgInfo.rank_url;
        }
    }

    public String cvX() {
        return this.aup;
    }

    public String aIW() {
        return this.imgUrl;
    }
}
