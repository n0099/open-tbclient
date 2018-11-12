package com.baidu.tieba.pb.data;

import android.support.v7.widget.ActivityChooserView;
import tbclient.PbPage.ForumHeadlineImgInfo;
/* loaded from: classes6.dex */
public class f {
    private long anv = 0;
    private String anw = "";
    private String imgUrl = "";
    private int fJL = ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED;
    private String fJM = "";
    private String rankUrl = "";

    public void a(ForumHeadlineImgInfo forumHeadlineImgInfo) {
        if (forumHeadlineImgInfo != null) {
            this.anv = forumHeadlineImgInfo.img_user_id.longValue();
            this.anw = forumHeadlineImgInfo.img_user_name;
            this.imgUrl = forumHeadlineImgInfo.img_url;
            this.fJL = forumHeadlineImgInfo.rank_num.intValue();
            this.fJM = forumHeadlineImgInfo.rank_up_info;
            this.rankUrl = forumHeadlineImgInfo.rank_url;
        }
    }

    public String beW() {
        return this.rankUrl;
    }

    public String xn() {
        return this.imgUrl;
    }
}
